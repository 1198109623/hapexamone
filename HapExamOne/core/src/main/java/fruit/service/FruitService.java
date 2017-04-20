package fruit.service;

import com.hand.hap.core.ProxySelf;
import com.hand.hap.system.service.impl.BaseServiceImpl;
import fruit.dto.Fruit;
import fruit.mapper.FruitMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.xml.ws.ServiceMode;
import java.util.List;

/**
 * Created by GuoMingLi on 2017/4/19.
 */
@Service
@Transactional(rollbackFor = RuntimeException.class)
public class FruitService extends BaseServiceImpl<Fruit> implements IFruitService,ProxySelf<Fruit> {
    @Autowired
    private FruitMapper fruitMapper;

    @Override
    public int updateList(List<Fruit> fruitList){
        fruitList.forEach(fruit -> checkOvn(fruitMapper.myUpdate(fruit),fruit));
        return  fruitList.size();
    }
}

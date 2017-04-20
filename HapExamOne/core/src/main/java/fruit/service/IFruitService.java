package fruit.service;

import com.hand.hap.system.service.IBaseService;
import fruit.dto.Fruit;

import java.util.List;

/**
 * Created by GuoMingLi on 2017/4/19.
 */
public interface IFruitService extends IBaseService<Fruit> {
     int updateList(List<Fruit> fruitList);
}

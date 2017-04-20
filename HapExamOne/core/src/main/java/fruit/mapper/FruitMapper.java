package fruit.mapper;

import com.hand.hap.mybatis.common.Mapper;
import fruit.dto.Fruit;

/**
 * Created by GuoMingLi on 2017/4/19.
 */
public interface FruitMapper extends Mapper<Fruit> {
    int myUpdate(Fruit fruit);
}

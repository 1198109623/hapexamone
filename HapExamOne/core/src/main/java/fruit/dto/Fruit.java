package fruit.dto;

import com.hand.hap.mybatis.annotation.Condition;
import com.hand.hap.mybatis.annotation.ExtensionAttribute;
import com.hand.hap.system.dto.BaseDTO;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Created by GuoMingLi on 2017/4/19.
 */
@Table(name = "fruit")
@ExtensionAttribute(disable = true)
public class Fruit extends BaseDTO
{
    @Id
    @GeneratedValue(
            generator = "IDENTITY"
    )
    @Column
    private Long id;
    @Column
    @Condition(operator = "LIKE")
    private String name;
    @Column
    private Integer price;
    @Column
    private String producingArea;

    public Long getId() {return id;}

    public void setId(Long id){this.id =id;}

    public String getName() {return name;}

    public void setName(String name) {this.name = name;}

    public Integer getPrice() {return price;}

    public void setPrice(Integer price) {this.price = price;}

    public String getProducingArea() {return producingArea;}

    public void setProducingArea(String producingArea) {this.producingArea = producingArea;}
}

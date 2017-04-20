package fruit.controllers;

import com.hand.hap.system.controllers.BaseController;
import com.hand.hap.system.dto.ResponseData;
import com.sun.net.httpserver.Authenticator;
import fruit.dto.Fruit;
import fruit.service.IFruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.yaml.snakeyaml.constructor.BaseConstructor;

import javax.servlet.http.HttpServletRequest;
import java.security.cert.TrustAnchor;
import java.util.List;

/**
 * Created by GuoMingLi on 2017/4/19.
 */
@RestController
@RequestMapping(path = {"/fruit","/api/public/fruit"})
public class FruitController extends BaseController {
    @Autowired
    private IFruitService fruitService;

    @RequestMapping(path = "/query")
    public ResponseData query(HttpServletRequest request,
                              Fruit fruit,
                              @RequestParam(required = false,defaultValue = "1") int page,
                              @RequestParam(required = false,defaultValue = "10") int pageSize){
        return new ResponseData(fruitService.select(createRequestContext(request),fruit,page,pageSize));

    }
    @RequestMapping(path = "/delete")
    public  ResponseData delete(HttpServletRequest request,
                                @RequestBody List<Fruit> fruits){
        fruitService.batchDelete(fruits);
        return  new ResponseData(true);
    }
    @RequestMapping(path = "/update")
    public  ResponseData udate(HttpServletRequest request,
                               @RequestBody Fruit fruit){
        fruitService.updateByPrimaryKey(createRequestContext(request),fruit);
        return new ResponseData(true);
    }
    @RequestMapping(path = "/insert")
    public  ResponseData insert(HttpServletRequest request,
                                @RequestBody Fruit fruit){
        fruitService.updateByPrimaryKey(createRequestContext(request),fruit);
        return new ResponseData(true);
    }
    @RequestMapping(path = "/submit")
    public  ResponseData batchUpdate(HttpServletRequest request,
                                     @RequestBody List<Fruit> fruits){
        fruitService.batchUpdate(createRequestContext(request),fruits);
        return new ResponseData(true);
    }
}

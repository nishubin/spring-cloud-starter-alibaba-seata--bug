package icu.funkye.service;



import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(name = "ddwl-goods"  ,path = "/goods")
public interface GoodsApi {

    /**
     * 获取商品详情
     * @param id
     * @return
     */
    @RequestMapping(value = "/item/get",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    String getItemInfo(@RequestParam("id") String id);

    /**
     * 获取类目详情
     * @param id
     * @return
     */
    @RequestMapping(value = "/category/detail",method = RequestMethod.GET)
    String getCategoryDetail(@RequestParam("id") String id);


    /**
     * 获取商品详情
     * @param id
     * @return
     */
    @GetMapping("/item/detail")
    String detail(@RequestParam("id") String id);

    /**
     * 移除用户购物车商品
     * @param skuCodes
     * @param userId
     * @return
     */
    @DeleteMapping("/shoppingCard/{userId}")
    String deleteShoppingCard(@RequestParam("skuCodes") List<String> skuCodes, @PathVariable("userId") String userId);


}

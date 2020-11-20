package com.ggy.lcnorder.controller;

import com.codingapi.txlcn.tc.annotation.TxcTransaction;
import com.ggy.lcnorder.dao.TblOrderDao;
import com.ggy.lcnorder.entity.TblOrder;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

/**
 * @ClassName OrderTxcController
 * @Decription TODO
 * @Author gaoguangyao
 * @Date 2020/10/28 10:53 上午
 */
@Controller
public class OrderTxcController {
    @Autowired
    private TblOrderDao tblOrderDao;

    @Autowired
    private RestTemplate restTemplate;

    @PostMapping("/add-order-txc")
    @Transactional(rollbackFor = Exception.class)
    @TxcTransaction
    public String add(@RequestBody TblOrder bean){

        JSONObject date = new JSONObject();
        date.put("payName",bean.getOrderName()+"pay");

        restTemplate.postForEntity("http://lcn-pay/add-pay-txc",date,String.class);

        tblOrderDao.insert(bean);
        Integer id = bean.getId();
        maps.put("a",id);

        int i = 1/0;
        return "新增订单成功";
    }

    public String confirmAdd(TblOrder bean){

        System.out.println("order confirm ");
        return "新增订单成功";
    }

    private static Map<String,Integer> maps = new HashMap<>();

    public String cancelAdd(TblOrder bean){
        Integer a = maps.get("a");
        System.out.println("a:"+a);
        tblOrderDao.deleteByPrimaryKey(a);
        System.out.println("order cancel ");
        return "新增订单成功";
    }
}


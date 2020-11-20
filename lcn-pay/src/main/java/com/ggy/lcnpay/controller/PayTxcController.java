package com.ggy.lcnpay.controller;

import com.codingapi.txlcn.tc.annotation.TxcTransaction;
import com.ggy.lcnpay.dao.TblPayDao;
import com.ggy.lcnpay.entity.TblPay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName PayTxcController
 * @Decription TODO
 * @Author gaoguangyao
 * @Date 2020/10/28 10:42 上午
 */
@RestController
public class PayTxcController {

    @Autowired
    private TblPayDao tblPayDao;

    @PostMapping("/add-pay-txc")
    @Transactional(rollbackFor = Exception.class)
    @TxcTransaction
    public String addPay(@RequestBody TblPay bean) {
        tblPayDao.insert(bean);
        Integer id = bean.getId();
        // int i = 1/0;
        System.out.println("新增支付成功");
        return "新增支付成功";

    }
}
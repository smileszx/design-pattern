package com.victor.pattern.proxy.service.impl;

import com.victor.pattern.proxy.service.PayService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @Description
 * 支付宝方式
 * @Author victor su
 * @Date 2019/10/5 10:08
 **/
public class AliPayServiceImpl implements PayService {
    private static final Logger LOGGER = LoggerFactory.getLogger(PayService.class);
    @Override
    public PayService pay() {
        LOGGER.info("支付方式: AliPay");
        return this;
    }
}

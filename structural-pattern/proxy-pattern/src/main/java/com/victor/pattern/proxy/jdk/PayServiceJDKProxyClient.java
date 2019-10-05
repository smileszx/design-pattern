package com.victor.pattern.proxy.jdk;

import com.victor.pattern.proxy.service.PayService;
import com.victor.pattern.proxy.service.impl.AliPayServiceImpl;

/**
 * @Description
 * 支付方式代理类客户端
 * @Author victor su
 * @Date 2019/10/5 10:27
 **/
public class PayServiceJDKProxyClient {

    public static void main(String[] args) {
        PayServiceJDKProxy<PayService> payServiceJDKProxy = new PayServiceJDKProxy<>();

        PayService proxy = payServiceJDKProxy.createProxy(PayService.class, AliPayServiceImpl.class);
        proxy.pay();
    }
}

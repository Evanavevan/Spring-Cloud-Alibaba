package com.evan.myshop.service.reg.service;

import com.evan.myshop.commons.domain.TbUser;
import com.evan.myshop.commons.utils.MapperUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

@Service
public class RegService {

    @Autowired
    private MessageChannel output;

    /**
     * 该方法将被异步调用
     * @param tbUser {@link TbUser}
     */
    @Async
    public void sendEmail(TbUser tbUser) {
        try {
            output.send(MessageBuilder.withPayload(MapperUtils.obj2json(tbUser)).build());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

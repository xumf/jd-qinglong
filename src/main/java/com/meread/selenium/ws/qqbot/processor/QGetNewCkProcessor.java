package com.meread.selenium.ws.qqbot.processor;

import com.meread.selenium.service.BotService;
import com.meread.selenium.util.CommonAttributes;
import com.meread.selenium.ws.qqbot.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.WebSocketSession;

/**
 * @author yangxg
 * @date 2021/10/17
 */
@Component
@Slf4j
public class QGetNewCkProcessor implements QCommandProcessor {

    @Autowired
    private BotService botService;

    @Override
    public ProcessStatus process(long senderQQ, String content, QQAiFlow qqAiFlow) {
        log.info("senderQQ = " + senderQQ + ", content = " + content);
        QA last = qqAiFlow.getLast();
        QCommand qCommand = last.getQCommand();
        log.info("qCommand = " + qCommand);
        if (qCommand == QCommand.GET_NEW_CK) {
            botService.sendMsgWithRetry(senderQQ,"请选择登陆方式：1.手机号\n2.qq扫码");
        } else if (qCommand == QCommand.GET_NEW_CK_LOGIN_TYPE) {
            int code = Integer.parseInt(content);
            if (code == 1) {

            } else if (code == 2) {

            } else {
                botService.sendMsgWithRetry(senderQQ,"输入有误，请输入1或2!");
            }
        }
        return ProcessStatus.FINISH;
    }

}

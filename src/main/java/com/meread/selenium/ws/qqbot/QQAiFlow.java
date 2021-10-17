package com.meread.selenium.ws.qqbot;

import lombok.Data;
import org.springframework.util.CollectionUtils;

import java.util.List;

/**
 * @author yangxg
 * @date 2021/10/17
 */
@Data
public class QQAiFlow {
    private long senderQQ;
    private List<QA> qas;

    public QA getLast() {
        if (CollectionUtils.isEmpty(qas)) {
            return null;
        }
        for (QA qa : qas) {
            if (qa.getStatus() != ProcessStatus.FINISH) {
                return qa;
            }
        }
        return null;
    }
}

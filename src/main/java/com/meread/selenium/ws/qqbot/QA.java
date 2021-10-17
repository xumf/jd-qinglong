package com.meread.selenium.ws.qqbot;

import lombok.Data;

import java.util.List;
import java.util.regex.Pattern;

/**
 * @author yangxg
 * @date 2021/10/17
 */
@Data
public class QA {
    private long requestTime;
    private String requestRaw;
    private QCommand qCommand;
    private List<String> response;
    private ProcessStatus status;

    public QCommand getTopCommand() {
        if (qCommand == null) {
            return null;
        }
        int parentCode =0;
        QCommand res = null;
        do {
            parentCode = qCommand.getParentCode();
            res = QCommand.parse(parentCode);
        } while (parentCode != 0);
        return res;
    }
}

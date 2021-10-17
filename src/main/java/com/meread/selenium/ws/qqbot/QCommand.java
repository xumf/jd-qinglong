package com.meread.selenium.ws.qqbot;

/**
 * @author yangxg
 * @date 2021/10/17
 */
public enum QCommand {

    GET_NEW_CK("获取CK", 1, 0),
    GET_NEW_CK_LOGIN_TYPE("获取CK-输入登陆方式", 2, 1),
    GET_NEW_CK_PHONE("获取CK-输入手机号", 3, 2),
    GET_NEW_CK_AUTHCODE_QQ("获取CK-输入QQ登陆验证码", 5, 2),
    GET_NEW_CK_AUTHCODE_PHONE("获取CK-输入手机登陆验证码", 4, 3),
    GET_NEW_CK_REMARK("获取CK-输入备注", 6, 4),
    GET_NEW_CK_QLID("获取CK-输入青龙配置id", 7, 5),

    EXIT("直接退出", 8, 0),
    HELP("帮助菜单", 9, 0);

    private String desc;
    private int code;
    private int parentCode;

    QCommand(String desc, int code, int parentCode) {
        this.parentCode = parentCode;
        this.desc = desc;
        this.code = code;
    }

    public static QCommand parse(int code) {
        for (QCommand qc : QCommand.values()) {
            if (qc.getCode() == code) {
                return qc;
            }
        }
        return null;
    }

    public String getDesc() {
        return desc;
    }

    public int getCode() {
        return code;
    }

    public int getParentCode() {
        return parentCode;
    }

}

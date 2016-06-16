package com.sxjr.message;

public class RedisConstant {

	/**
	 * 网关服务器流控规则
	 */
	//单一号码每日发送不超过40条
//	public static final String SINGLE_PHONE_DAY = "single_phone_day";
	public static final int SINGLE_PHONE_DAY_COUNT = 40;
	
	//单一号码每分钟不超过2条
//	public static final String SINGLE_PHONE_MINUTE = "single_phone_minute";
	public static final int SINGLE_PHONE_MINUTE_COUNT = 2;
	
	//每10分钟不超过4条
//	public static final String SINGLE_PHONE_TENMINUTE = "single_phone_tenminute";
	public static final int SINGLE_PHONE_TENMINUTE_COUNT = 4;
	
	//批量发送每次发送量不超过200个手机号
//	public static final String GROUP_PHONE_MSG = "group_phone_msg";
	public static final int GROUP_PHONE_MSG_COUNT = 200;
	
	/**
	 * 部分redis命名
	 */
	//所有通道集合
//	public static final String CONDUIT = "conduit";
    //通道过去时间段统计
//	public static final String SMS_SENDED_RATES = "sms.sended.statistics.rates";
	//通道固定时间段统计
//	public static final String CONDUIT_BYTIME_STATIS = "conduit.bytime.statis";
	//消息通知
//	public static final String MESSAGE_SEND = "message.send.";
	
	//沃动 流控
    /**
     * 单一号码每两条短信间隔不低于60s
     */
//	public static final String WODONG = "wodong";
//    public static final String WODONG_MOBILE_INTERVAL = "wodong_mobile_interval.";
    public static final int WODONG_MOBILE_INTERVAL_EXPIRE_TIME = 60;
    public static final int WODONG_MOBILE_INTERVA_COUNT =2;
    public static int WODONG_SMS_LENGTH = 350;
    // 单一号码一天内最多发送10条
    public static final int WODONG_MOBILE_DAY_SENT_COUNT = 10;
//    public static final String WODONG_MOBILE_DAY_SENT="wodong_mobile_day_send.";



    //互亿 流控
    /**
     * 单一号码每两条短信间隔不低于60s
     */
//    public static final String HUYI = "huyi";
//    public static final String HUYI_MOBILE_INTERVAL = "huyi_mobile_interval.";
    public static final int HUYI_MOBILE_INTERVAL_EXPIRE_TIME = 60;

    public static int HUYI_SMS_LENGTH = 350;
    // 单一号码一天内含“验证码”5条
//    public static final String HUYI_MOBILE_DAY_SENT="huyi_mobile_day_send.";
    public static final int HUYI_MOBILE_DAY_SENT_COUNT = 5;

    //亿美 流控
    /**
     * 单一号码每两条短信间隔不低于60s
     */
//    public static final String YIMEI = "yimei";
//    public static final String YIMEI_MOBILE_INTERVAL = "yimei_mobile_interval.";
    public static final int YIMEI_MOBILE_INTERVAL_EXPIRE_TIME = 120;
    public static final int YIMEI_MOBILE_INTERVA_COUNT =2;
//    public static final String YIMEI_MOBILE_DAY_SENT ="yimei_mobile_day_send.";
    public static int YIMEI_SMS_LENGTH = 350;
    // 单一号码一天内最多发送20条
    public static final int YIMEI_MOBILE_DAY_SENT_COUNT = 20;
    
//    public static final String CHANNEL_COFNIG = "conduit";
    
//    public static final String CHANNEL_DEFAULT_CONFIG = "sms.channel.default.config";
    
//    public static final String CHANNEL_SMS_TEMPLATE = "SmsTemplate";
	
}

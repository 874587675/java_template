package com.dfg.java_template.common.util.date;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 时间工具类
 * @author zgc
 */
public class DateUtils {

    /**
     * 时间戳转换成日期格式字符串
     * @param timestamp
     * @return
     */
    public static String formatTime(long timestamp) {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(timestamp));
    }
}

package com.dfg.java_template.framework.util.string;

import cn.hutool.core.util.ObjectUtil;

import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *  字符串工具类
 *
 * @author zgc
 */
public class StringUtils {

    private static final Pattern PLACEHOLDER_PATTERN = Pattern.compile("\\$\\{(.+?)\\}");   //匹配格式${...}
    private static final Pattern BRACE_PATTERN = Pattern.compile("\\{(.+?)}");    //匹配格式{...}

    /**
     * 替换字符串中的占位符 ${key} 为对应的值
     * @param template 模板字符串
     * @param params 参数键值对
     * @return 替换后的字符串
     */
    public static String replacePlaceholders(String template, Map<String, Object> params) {
        if (ObjectUtil.isEmpty(template) || params == null || params.isEmpty()) {
            return template;
        }

        StringBuffer result = new StringBuffer();
        Matcher matcher = PLACEHOLDER_PATTERN.matcher(template);

        while (matcher.find()) {
            String key = matcher.group(1);
            Object value = params.get(key);
            matcher.appendReplacement(result, value != null ? value.toString() : "");
        }
        matcher.appendTail(result);

        return result.toString();
    }

    /**
     * 替换字符串中的花括号 {key} 为对应的值
     * @param template 模板字符串
     * @param params 参数键值对
     * @return 替换后的字符串
     */
    public static String replaceBraces(String template, Map<String, Object> params) {
        if (ObjectUtil.isEmpty(template) || params == null || params.isEmpty()) {
            return template;
        }

        StringBuffer result = new StringBuffer();
        Matcher matcher = BRACE_PATTERN.matcher(template);

        while (matcher.find()) {
            String key = matcher.group(1);
            Object value = params.get(key);
            matcher.appendReplacement(result, value != null ? value.toString() : "");
        }
        matcher.appendTail(result);

        return result.toString();
    }

    /**
     * 替换字符串中的指定字符
     * @param source 源字符串
     * @param oldChar 要替换的字符
     * @param newChar 替换为的字符
     * @return 替换后的字符串
     */
    public static String replaceChar(String source, char oldChar, char newChar) {
        if (ObjectUtil.isEmpty(source)) {
            return source;
        }
        return source.replace(oldChar, newChar);
    }

    /**
     * 替换字符串中的指定子串
     * @param source 源字符串
     * @param oldStr 要替换的子串
     * @param newStr 替换为的子串
     * @return 替换后的字符串
     */
    public static String replaceString(String source, String oldStr, String newStr) {
        if (ObjectUtil.isEmpty(source) || ObjectUtil.isEmpty(oldStr)) {
            return source;
        }
        return source.replace(oldStr, newStr);
    }

    /**
     * 替换字符串中所有匹配正则表达式的部分
     * @param source 源字符串
     * @param regex 正则表达式
     * @param replacement 替换内容
     * @return 替换后的字符串
     */
    public static String replaceRegex(String source, String regex, String replacement) {
        if (ObjectUtil.isEmpty(source) || ObjectUtil.isEmpty(regex)) {
            return source;
        }
        return source.replaceAll(regex, replacement);
    }

    /**
     * 替换字符串中的HTML特殊字符为转义字符
     * @param source 源字符串
     * @return 转义后的字符串
     */
    public static String escapeHtml(String source) {
        if (ObjectUtil.isEmpty(source)) {
            return source;
        }
        return source.replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;")
                .replace("'", "&#39;");
    }

    /**
     * 替换字符串中的转义字符为HTML特殊字符
     * @param source 源字符串
     * @return 反转义后的字符串
     */
    public static String unescapeHtml(String source) {
        if (ObjectUtil.isEmpty(source)) {
            return source;
        }
        return source.replace("&amp;", "&")
                .replace("&lt;", "<")
                .replace("&gt;", ">")
                .replace("&quot;", "\"")
                .replace("&#39;", "'");
    }

    /**
     * 替换字符串中的敏感信息（如手机号、身份证号等）
     * @param source 源字符串
     * @param start 开始保留的位数
     * @param end 结束保留的位数
     * @param replacement 替换字符
     * @return 脱敏后的字符串
     */
    public static String maskSensitiveInfo(String source, int start, int end, char replacement) {
        if (ObjectUtil.isEmpty(source)) {
            return source;
        }

        int length = source.length();
        if (start >= length || end >= length || (start + end) >= length) {
            return source;
        }

        char[] chars = source.toCharArray();
        for (int i = start; i < length - end; i++) {
            chars[i] = replacement;
        }
        return new String(chars);
    }

    /**
     * 替换字符串中的变量（使用${var}格式）
     * @param template 模板字符串
     * @param varName 变量名
     * @param value 变量值
     * @return 替换后的字符串
     */
    public static String replaceVariable(String template, String varName, Object value) {
        if (ObjectUtil.isEmpty(template) || ObjectUtil.isEmpty(varName)) {
            return template;
        }
        return template.replace("${" + varName + "}", value != null ? value.toString() : "");
    }

    /**
     * 替换字符串中的多个变量（使用${var}格式）
     * @param template 模板字符串
     * @param vars 变量名数组
     * @param values 变量值数组
     * @return 替换后的字符串
     */
    public static String replaceVariables(String template, String[] vars, Object[] values) {
        if (ObjectUtil.isEmpty(template) || vars == null || values == null || vars.length != values.length) {
            return template;
        }

        String result = template;
        for (int i = 0; i < vars.length; i++) {
            result = replaceVariable(result, vars[i], values[i]);
        }
        return result;
    }

}

package com.huskar_t.jdsl;

import com.alibaba.fastjson.JSON;
import com.huskar_t.util.GoString;
import com.sun.jna.Library;
import com.sun.jna.Native;
import com.sun.jna.NativeLibrary;
import org.apache.commons.lang.StringEscapeUtils;

import java.nio.charset.Charset;
import java.util.Map;

/**
 * {@link JDSL}
 * 使用 jna 调用 jdsl 动态库
 */
public class JDSL {
    public static void main(String[] args) {
        var k = new JDSL("F:\\hivemq\\tdenginejsdl\\src\\main\\resources");
    }
    private LibJDSL INSTANCE;

    public JDSL(String libPath) {
        NativeLibrary.addSearchPath("jdsl",libPath);
        INSTANCE = Native.load("jdsl", LibJDSL.class);
    }

    /**
     * @param config {@link Config}
     * @return {@link CParseResult}
     * @throws Exception 用于初始化 json 模板
     *                   调用动态库的 ParseJson 方法
     *                   返回 {@link CParseResult} 其中 sql{@link CreatSql}为创建数据库和表的语句
     *                   当 error 字段不为空时抛出异常,内容为 error 字段内容
     */
    public CParseResult ParseJson(Config config) throws Exception {
        String c = JSON.toJSONString(config);
        String parseResult = INSTANCE.ParseJson(new GoString.ByValue(c));
        CParseResult result = JSON.parseObject(parseResult, CParseResult.class);
        if (!result.error.equals("")) {
            throw new Exception(result.error);
        } else {
            return result;
        }
    }

    /**
     * @param parseResult {@link ParseResult}
     * @param msg         {@link String}
     * @param extra       {@link Map}
     * @return {@link String[]}
     * @throws Exception 读取并解析 msg
     *                   parseResult 为 ParseJson 方法返回值的 result 字段
     *                   msg 为 json 字符串
     *                   extra 为补充定义的模板值(如: 模板值在消息队列的 topic 中则无法通过 msg 获取,可在此处将结果存为 Map 调用动态库)
     */
    public String[] Read(ParseResult parseResult, String msg, Map<String, String> extra) throws Exception {
        String res = JSON.toJSONString(parseResult);
        String extraMsg = "";
        if (extra != null) {
            extraMsg = JSON.toJSONString(extra);
        }
        String s = INSTANCE.Read(new GoString.ByValue(res), new GoString.ByValue(msg), new GoString.ByValue(extraMsg));
//        ReadResult readResult = JSON.parseObject(s,0,s.length, Charset.forName("GBK"),ReadResult.class);
        ReadResult readResult = JSON.parseObject(s, ReadResult.class);
        if (!readResult.error.equals("")) {
            throw new Exception(readResult.error);
        }
        return readResult.sqlList;
    }
}



package com.huskar_t.jdsl;

import com.alibaba.fastjson.annotation.JSONField;

public class CParseResult {
    @JSONField(name = "error")
    public String error;
    @JSONField(name = "result")
    public ParseResult result;
    @JSONField(name = "sql")
    public CreatSql sql;
}

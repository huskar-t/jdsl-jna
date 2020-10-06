package com.huskar_t.jdsl;

import com.alibaba.fastjson.annotation.JSONField;

public class ReadResult {
    @JSONField(name = "sqlList")
    public String[] sqlList;
    @JSONField(name = "error")
    public String error;
}

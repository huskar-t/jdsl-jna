package com.huskar_t.jdsl;

import com.alibaba.fastjson.annotation.JSONField;

public class Found {
    @JSONField(name = "path")
    public String[] path;
    @JSONField(name = "types")
    public Integer[] types;
    @JSONField(name = "type")
    public Integer Type;
    @JSONField(name = "name")
    public String name;
}

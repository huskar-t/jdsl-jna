package com.huskar_t.jdsl;

import com.alibaba.fastjson.annotation.JSONField;

public class CreatSql {
    @JSONField(name = "dbSql")
    public String dbSql;
    @JSONField(name = "tableFloatSql")
    public String tableFloatSql;
    @JSONField(name = "tableStringSql")
    public String tableStringSql;
}

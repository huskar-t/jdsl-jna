package com.huskar_t.jdsl;

import com.alibaba.fastjson.annotation.JSONField;

public class ParseResult {
    @JSONField(name = "value")
    public String value;
    @JSONField(name = "dbName")
    public String dbName;
    @JSONField(name = "tableName")
    public String tableName;
    @JSONField(name = "sTableName")
    public String sTableName;
    @JSONField(name = "tagsTemplateStr")
    public String[] tagsTemplateStr;
    @JSONField(name = "ns")
    public Found[] ns;
}

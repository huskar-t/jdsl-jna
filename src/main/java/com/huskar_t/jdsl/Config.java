package com.huskar_t.jdsl;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Map;

/**
 * dbName 数据库名
 * sTableName 超级表名
 * tableName 数据表名(可为模板值)
 * keep 数据库保留天数
 * payloadTemplate 定义json模板
 * value 要入库的模板名(必须为模板值)
 * tagsMap 自定义tag名和值 (key 为 tag 名(不可为模板), value 为 tag值(可定义为常量和模板))
 */
public class Config {
    @JSONField(name = "dbName")
    public String dbName;
    @JSONField(name = "sTableName")
    public String sTableName;
    @JSONField(name = "tableName")
    public String tableName;
    @JSONField(name = "keep")
    public Integer keep;
    @JSONField(name = "payloadTemplate")
    public String payloadTemplate;
    @JSONField(name = "value")
    public String value;
    @JSONField(name = "tagsMap")
    public Map<String, String> tagsMap;
}

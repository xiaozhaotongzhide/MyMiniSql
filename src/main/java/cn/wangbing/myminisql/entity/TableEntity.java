package cn.wangbing.myminisql.entity;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 维护了表中存储的对象
 */
public class TableEntity extends Structure implements Serializable {

    /**
     * 存放了属性map
     */
    Map<String,String> propertyMap = new HashMap<>();

    /**
     * 存放了表名
     */
    String tableName;

    public Map<String, String> getPropertyMap() {
        return propertyMap;
    }

    public void setPropertyMap(Map<String, String> propertyMap) {
        this.propertyMap = propertyMap;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }
}

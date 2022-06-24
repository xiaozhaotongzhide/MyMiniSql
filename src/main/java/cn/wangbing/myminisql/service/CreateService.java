package cn.wangbing.myminisql.service;

import cn.wangbing.myminisql.entity.TableAVLtree;

import java.util.ArrayList;
import java.util.List;

/**
 * create table students ( name varchar(30) , age varchar(30) );
 */
public class CreateService {
    public static void create(String[] s, TableAVLtree table) {
        System.out.println("---create---");
        String tableName = s[2];
        table.setTableName(tableName);
        // 5 6  8 9  11 12 13这样可以算出表中一共有多少个属性
        int propertyNum = (s.length - 4) / 3;
        //获取表维护的属性map
        List<String> propertyList = new ArrayList<String>();
        for (int i = 0; i < propertyNum; i++) {
            propertyList.add(s[4 + i * 3]);
        }
        table.setPropertyList(propertyList);
    }
}

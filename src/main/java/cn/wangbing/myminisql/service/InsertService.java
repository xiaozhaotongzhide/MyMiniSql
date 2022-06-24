package cn.wangbing.myminisql.service;

import cn.wangbing.myminisql.entity.Structure;
import cn.wangbing.myminisql.entity.TableAVLtree;

import java.util.List;
import java.util.Map;

/**
 * insert into students values ( wangbing , 22 );
 */
public class InsertService {
    public static void insert(String[] s, TableAVLtree table) {
        System.out.println("---insert---");
        Structure structure = new Structure(table.getId());
        table.setId(table.getId() + 1);
        List<String> propertyList = table.getPropertyList();
        for (int i = 0; i < propertyList.size(); i++) {
            Map<String, String> propertyMap = structure.getPropertyMap();
            propertyMap.put(propertyList.get(i), s[5 + i * 2]);
            structure.setPropertyMap(propertyMap);
        }
        table.add(structure);
    }
}

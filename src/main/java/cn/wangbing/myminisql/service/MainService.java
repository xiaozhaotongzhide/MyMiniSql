package cn.wangbing.myminisql.service;

import cn.wangbing.myminisql.entity.TableAVLtree;

/**
 * 数据库的主方法

 */
public class MainService {
    public static void Main(String line, TableAVLtree table) {
        String[] s = line.split(" ");
        switch (s[0]) {
            case "create":
                CreateService.create(s, table);
                break;
            case "select":
                SelectService.select(s, table);
                break;
            case "insert":
                InsertService.insert(s, table);
                break;
            case "delete":
                DeleteService.delete(s, table);
                break;
        }
    }
}

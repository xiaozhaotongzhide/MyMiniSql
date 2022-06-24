package cn.wangbing.myminisql.service;

import cn.wangbing.myminisql.entity.TableAVLtree;

/**
 * select * form students
 */
public class SelectService {
    public static void select(String[] s, TableAVLtree table) {
        System.out.println("---select---");
        for (String string : table.getPropertyList()) {
            System.out.print(string + " ");
        }
        System.out.println();
        table.infixOrder();
    }
}

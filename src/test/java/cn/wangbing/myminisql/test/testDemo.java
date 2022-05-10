package cn.wangbing.myminisql.test;

import cn.wangbing.myminisql.entity.TableEntity;

import java.util.Scanner;

public class testDemo {
    public static void main(String[] args) {
        TableEntity entity = new TableEntity(1);
        Scanner scanner = new Scanner(System.in);
        String a = scanner.nextLine();
        String b = scanner.nextLine();
        entity.getPropertyMap().put(a, b);
        System.out.println(entity.getPropertyMap().get(a));
    }
}

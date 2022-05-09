package cn.wangbing.myminisql.service;

/**
 * 数据库的主方法
 */
public class MainService {
    public static void Main(String line) {
        String[] s = line.split(" ");
        switch (s[0]) {
            case "create":
                CreateService.create(s);
                break;
            case "select":
                SelectService.select(s);
                break;
            case "update":
                UpdateService.update(s);
                break;
            case "delete":
                DeleteService.delete(s);
                break;
        }
    }
}

package cn.wangbing.myminisql;

import cn.wangbing.myminisql.service.MainService;

import java.util.Objects;
import java.util.Scanner;

/**
 * 启动类
 */
public class StartUpMain {

    public static Boolean status = true;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (status) {
            String line = scanner.nextLine();
            if (Objects.equals(line, "close")) {
                status = false;
                return;
            }
            MainService.Main(line);
        }
    }
}

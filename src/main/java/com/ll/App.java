package com.ll;

import java.util.Scanner;

public class App {

    private Scanner scanner;


    App() {
        scanner = new Scanner(System.in);

    }

    public void run() {
        System.out.println("== 명언 앱 ==");
        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine();
            if (cmd.equals("종료")) {
                break;

            }
        }
    }
}
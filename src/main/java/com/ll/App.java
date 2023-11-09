package com.ll;

import java.util.Scanner;

public class App {
    private Scanner scanner;


    App() {
        scanner = new Scanner(System.in);

    }

    public void run() {


        SayingControl sayingControl=new SayingControl(scanner);


        System.out.println("== 명언 앱 ==");
        //loadFile("sayings.txt");
        sayingControl.loadJson("data.json");

        while (true) {

            System.out.print("명령) ");
            String cmd = scanner.nextLine();
            Rq rq = new Rq(cmd);
            switch (rq.getAction()) {
                case "종료":
                    //makeFile(sayings, "sayings.txt");

                    return;

                case "등록":
                    sayingControl.addSaying();
                    break;
                case "목록":
                    sayingControl.sayingList();
                    break;
                case "삭제":
                    sayingControl.deleteSaying(rq);
                    break;
                case "수정":
                    sayingControl.modifySaying(rq);
                    break;
                case "빌드":
                    sayingControl.saveSayingToJson();
                    break;
                default:
                    System.out.println("다시 입력 해 주세요.");
            }
        }

    }





}

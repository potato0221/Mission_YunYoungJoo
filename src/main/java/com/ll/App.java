package com.ll;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class App {

    private Scanner scanner;
    private int idx;
    private List<Saying> sayings;

    App() {
        scanner = new Scanner(System.in);
        idx=0;
        sayings=new ArrayList<>();
    }

    public void run() {
        System.out.println("== 명언 앱 ==");
        while (true) {
            System.out.print("명령) ");
            String cmd = scanner.nextLine();
            if (cmd.equals("종료")) {
                break;

            }else if(cmd.equals("등록")){
                addSaying();

            }
        }
    }

    private void addSaying(){
        System.out.print("명언 : ");
        String content=scanner.nextLine();
        System.out.print("작가 : ");
        String author=scanner.nextLine();
        idx++;
        Saying saying=new Saying(idx,content,author);
        sayings.add(saying);
        System.out.printf("%d번 명언이 등록 되었습니다.\n",idx);
    }

}

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
            Rq rq=new Rq(cmd);
            if (rq.getAction().equals("종료")) {
                break;

            }else if(rq.getAction().equals("등록")){
                addSaying();

            }else if(rq.getAction().equals("목록")){
                sayingList();
            }else if(rq.getAction().equals("삭제")){
                deleteSaying(rq);

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
    private void sayingList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("-------------------");
        for(int i=sayings.size()-1;i>=0;i--){
            Saying saying = sayings.get(i);
            System.out.printf("%d / %s / %s\n",saying.idx,saying.author,saying.content);
        }

    }

    private void deleteSaying(Rq rq) {
        int id=rq.getParamAsInt("id",0);
        if(id==0){
            System.out.println("id를 정확히 입력 해주세요.");
            return;
        }
        int deleteIdx=getIdx(id);
        if(deleteIdx==-1){
            System.out.printf("%d번 명언은 존재하지 않습니다.\n",id);
            return;
        }
        sayings.remove(deleteIdx);
        System.out.printf("%d번 명언을 삭제 했습니다.\n",id);


    }

    private int getIdx(int id) {
        for(int i=0;i<sayings.size();i++){
            Saying saying=sayings.get(i);
            if(saying.idx==id){
                return i;
            }
        }


        return -1;
    }


}

package com.ll.domain.Saying;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.ll.base.Rq;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SayingControl {

    private Scanner scanner;
    private int idx;
    private List<Saying> sayings;


    public SayingControl(Scanner scanner){
        this.scanner=scanner;
        idx = 0;
        sayings = new ArrayList<>();

    }


    public void addSaying() {
        idx=lastIdx();
        System.out.print("명언 : ");
        String content = scanner.nextLine();
        System.out.print("작가 : ");
        String author = scanner.nextLine();
        idx++;
        Saying saying = new Saying(idx, content, author);
        sayings.add(saying);
        System.out.printf("%d번 명언이 등록 되었습니다.\n", idx);
    }

    public void sayingList() {
        System.out.println("번호 / 작가 / 명언");
        System.out.println("-------------------");
        for (int i = sayings.size() - 1; i >= 0; i--) {
            Saying saying = sayings.get(i);
            System.out.printf("%d / %s / %s\n", saying.getIdx(), saying.getAuthor(), saying.getContent());
        }

    }

    public void deleteSaying(Rq rq) {
        int id = rq.getParamAsInt("id", 0);
        if (id == 0) {
            System.out.println("id를 정확히 입력 해 주세요.");
            return;
        }
        int deleteIdx = getIdx(id);
        if (deleteIdx == -1) {
            System.out.printf("%d번 명언은 존재 하지 않습니다.\n", id);
            return;
        }
        sayings.remove(deleteIdx);

        System.out.printf("%d번 명언을 삭제 했습니다.\n", id);


    }

    public void modifySaying(Rq rq) {
        int id = rq.getParamAsInt("id", 0);
        if (id == 0) {
            System.out.println("id를 정확히 입력 해 주세요.");
            return;
        }
        int modifyIdx = getIdx(id);
        if (modifyIdx == -1) {
            System.out.printf("%d번 명언은 존재 하지 않습니다.\n", id);
            return;
        }
        Saying saying = sayings.get(modifyIdx);
        System.out.printf("명언(기존) : %s\n", saying.getContent());
        System.out.print("명언 : ");
        saying.setContent(scanner.nextLine());
        System.out.printf("작가(기존) : %s\n", saying.getAuthor());
        System.out.print("작가 : ");
        saying.setAuthor(scanner.nextLine());

    }

    private int getIdx(int id) {
        for (int i = 0; i < sayings.size(); i++) {
            Saying saying = sayings.get(i);
            if (saying.getIdx() == id) {
                return i;
            }
        }

        return -1;
    }

//    private void makeFile(List<Saying> sayings, String filename) {
//        List<Saying> exist = loadFile("sayings.txt");
//
//        try (PrintWriter writer = new PrintWriter(new FileWriter("sayings.txt"))) {
//            if (!exist.isEmpty()) {
//                for (int i = 0; i < exist.size(); i++) {
//                    writer.println(exist.get(i));
//                }
//            }
//            for (Saying saying : sayings) {
//                String txtSaying = saying.toString();
//                boolean trueFalse = false;
//                for (Saying saying1 : exist) {
//                    if (txtSaying.contains(saying1.toString())) {
//                        trueFalse = true;
//                        break;
//                    }
//                }
//                if (!trueFalse) {
//                    writer.println(txtSaying);
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//
//    }
//
//    private List<Saying> loadFile(String filename) {
//        List<Saying> file = new ArrayList<>();
//        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
//            String line;
//            while ((line = reader.readLine()) != null) {
//                String[] parts = line.split(",");
//                if (parts.length == 3) {
//                    int idx = Integer.parseInt(parts[0]);
//                    String author = parts[1];
//                    String content = parts[2];
//                    Saying saying = new Saying(idx, content, author);
//                    file.add(saying);
//                    sayings.add(saying);
//                }
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//        return file;
//
//    }

    public List<Saying> loadJson(String fileName) {
        ObjectMapper objectMapper = new ObjectMapper();

        try {
            File file = new File(fileName);

            if (file.exists()) {
                sayings = objectMapper.readValue(file, new TypeReference<List<Saying>>() {
                });
            }
        } catch (IOException e) {
            System.out.println("Json 파일에 저장된 데이터가 없습니다.");

        }

        return sayings;
    }

    public int lastIdx(){
        if (!sayings.isEmpty()) {
            idx = sayings.get(sayings.size() - 1).getIdx();

        }else idx=0;
        return idx;
    }

    public void saveSayingToJson() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        File file = new File("C:\\Users\\rkawk\\Desktop\\mission\\mission\\src\\main\\resources\\data.json");

        try {
            objectMapper.writeValue(file, sayings);
            System.out.println("변경된 내용이 JSON 파일에 저장되었습니다.");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }






}

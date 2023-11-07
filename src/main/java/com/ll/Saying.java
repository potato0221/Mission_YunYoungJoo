package com.ll;

public class Saying {
    public int idx;
    public String content;
    public String author;

    public Saying(){

    }

    public Saying(int idx,String content, String author){
        this.idx=idx;
        this.content=content;
        this.author=author;
    }

    public String toString(){
        return idx+","+author+","+content;
    }




}

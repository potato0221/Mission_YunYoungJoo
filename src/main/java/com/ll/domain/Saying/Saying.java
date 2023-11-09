package com.ll.domain.Saying;

import lombok.Getter;
import lombok.Setter;

public class Saying {
    @Getter
    private int idx;
    @Getter
    @Setter
    private String content;
    @Getter
    @Setter
    private String author;

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

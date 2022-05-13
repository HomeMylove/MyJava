package com.neta.mycollection.Homework;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class HomeWork01 {
    public static void main(String[] args) {
        News news1 = new News("新冠确诊病例超千万，数百万印度教徒赴横河“圣洁”引民众担忧");
        News news2 = new News("男子突然想起2个月前钓的鱼还在网兜里，捞起一看赶紧放生");

        ArrayList<News> news = new ArrayList<News>();

        news.add(news1);
        news.add(news2);


//        Collections.reverse(news);

        for(int i = news.size()-1; i >= 0; i--){
            String title = news.get(i).getTitle();
            if(title.length() > 15)
                title = title.substring(0,15)+"...";
            System.out.println(title);
        }

    }
}


class News{
    private String title;
    private String content;

    public News(String title) {
        this.title = title;
    }


    @Override
    public String toString() {
        return "News{" +
                "title='" + title + '\'' +
                '}';
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}

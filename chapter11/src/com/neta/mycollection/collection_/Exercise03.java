package com.neta.mycollection.collection_;

import java.util.LinkedList;

public class Exercise03 {
    public static void main(String[] args) {
        LinkedList list = new LinkedList<>();

        list.add(new Book("红楼梦",100,"曹雪芹"));
        list.add(new Book("西游记",10,"吴承恩"));
        list.add(new Book("水浒传",9,"施耐庵"));
        list.add(new Book("三国演义",80,"罗贯中"));
        list.add(new Book("西游记",10,"罗贯中"));

        for(int i = 0; i < list.size() - 1; i++){
            for( int j = 0; j < list.size() - 1 - i; j++){
                if(((Book)list.get(j)).getPrice() > ((Book)list.get(j + 1)).getPrice()){
                    Book temp =(Book) list.get(j);
                    list.set(j,list.get(j+1));
                    list.set(j+1,temp);
                }
            }
        }

        for (Object o : list) {
            System.out.println(o);
        }

    }
}



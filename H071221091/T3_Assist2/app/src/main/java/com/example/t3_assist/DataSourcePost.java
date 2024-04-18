package com.example.t3_assist;

import java.util.ArrayList;

public class DataSourcePost {
    public static ArrayList<Post> posts = generateDummyStory();

    public static ArrayList<Post> generateDummyStory() {
        ArrayList<Post> posts = new ArrayList<>();
        posts.add(new Post(R.drawable.satu, "Lorem ipsum dolor sit amet, consectetur adipiscing elit"
                ,R.drawable.s1, "Lorem ipsum","121","121"));
        posts.add(new Post(R.drawable.dua, "Lorem ipsum dolor sit amet, consectetur adipiscing elit"
                ,R.drawable.s2, "Lorem ipsum","122","122"));
        posts.add(new Post(R.drawable.tiga, "Lorem ipsum dolor sit amet, consectetur adipiscing elit"
                ,R.drawable.s3, "Lorem ipsum","123","123"));
        posts.add(new Post(R.drawable.empat, "Lorem ipsum dolor sit amet, consectetur adipiscing elit"
                ,R.drawable.s4, "Lorem ipsum","124","124"));
        posts.add(new Post(R.drawable.lima, "Lorem ipsum dolor sit amet, consectetur adipiscing elit"
                ,R.drawable.s5, "Lorem ipsum","125","125"));
        posts.add(new Post(R.drawable.enam, "Lorem ipsum dolor sit amet, consectetur adipiscing elit"
                ,R.drawable.s6, "Lorem ipsum","126","126"));
        posts.add(new Post(R.drawable.tujuh, "Lorem ipsum dolor sit amet, consectetur adipiscing elit"
                ,R.drawable.s7, "Lorem ipsum","127","127"));
        posts.add(new Post(R.drawable.delapan, "Lorem ipsum dolor sit amet, consectetur adipiscing elit"
                ,R.drawable.s8, "Lorem ipsum","128","128"));
        posts.add(new Post(R.drawable.sembilan, "Lorem ipsum dolor sit amet, consectetur adipiscing elit"
                ,R.drawable.s9, "Lorem ipsum","129","129"));
        posts.add(new Post(R.drawable.sepuluh, "Lorem ipsum dolor sit amet, consectetur adipiscing elit"
                ,R.drawable.s10,"Lorem ipsum","130","130"));
        return posts;
    }
}
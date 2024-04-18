package com.example.t3_assist;

import java.util.ArrayList;

public class DataSourceStory {
    public static ArrayList<Story> storys = generateDummyStory();

    public static ArrayList<Story> generateDummyStory() {
        ArrayList<Story> storys = new ArrayList<>();
        storys.add(new Story(R.drawable.q1,"1"));
        storys.add(new Story(R.drawable.q2,"2"));
        storys.add(new Story(R.drawable.q3,"3"));
        storys.add(new Story(R.drawable.q4,"4"));
        storys.add(new Story(R.drawable.q5,"5"));
        storys.add(new Story(R.drawable.q6,"6"));
        storys.add(new Story(R.drawable.q7,"7"));
        storys.add(new Story(R.drawable.q8,"8"));
        storys.add(new Story(R.drawable.q9,"9"));
        storys.add(new Story(R.drawable.q10,"10"));
        return storys;
    }
}
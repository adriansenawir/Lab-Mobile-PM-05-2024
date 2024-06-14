package com.example.t5_assist;

import java.util.ArrayList;

public class DataSource {

    public static ArrayList<Instagram> instagrams =generateDummyInstagram();

    private static ArrayList<Instagram> generateDummyInstagram() {
        ArrayList<Instagram> instagrams1 = new ArrayList<>();
        instagrams1.add(new Instagram("Rimuru Tempest", "Rimuru", "Anime Isekai Kerajaan Tempest"
                , R.drawable.rt, R.drawable.rt));

        instagrams1.add(new Instagram("Solo Leveling", "Song Jin Wo", "Lahir kembali menjadi monarch"
                , R.drawable.sl, R.drawable.sl));

        instagrams1.add(new Instagram("Classroom Of Elite", "Ayanokoji", "Tidak Ada yang lebih kuat dariku"
                , R.drawable.ce, R.drawable.ce));

        instagrams1.add(new Instagram("One Piece", "Monkey D Luffy", "Perjalanan Mnejadi bajak laut"
                , R.drawable.op, R.drawable.op));

        instagrams1.add(new Instagram("One Punch Man", "Saitama", "Pukulan sekali membuatmu KO"
                , R.drawable.opm, R.drawable.opm));

        return instagrams1;

    }

}

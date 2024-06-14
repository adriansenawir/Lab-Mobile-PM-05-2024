package com.example.t4_assist;

import java.util.ArrayList;

public class DataSource {

    public static ArrayList<Instagram> instagrams = generateDummyInstagrams();

    private static ArrayList<Instagram> generateDummyInstagrams() {
        ArrayList<Instagram> instagrams1 = new ArrayList<>();
        instagrams1.add(new Instagram("Dr.Stone","Senku"
                ,"Anime Batu"
                ,R.drawable.dr, R.drawable.dr));

        instagrams1.add(new Instagram("Classroom", "Ayanokoji"
                ,"Classsroom of the elite"
                ,R.drawable.ce,R.drawable.ce));

        instagrams1.add(new Instagram("Narutooo Shimpuden", "Naruto"
                ,"Naruto menjadu hokage jelek sekali karena diganti"
                ,R.drawable.naruto, R.drawable.naruto));

        instagrams1.add((new Instagram("Tensei Slime","Rimuru"
                ,"Bereikarnasi jadi raja iblis oktagram"
                ,R.drawable.rt,R.drawable.rt)));

        instagrams1.add(new Instagram("Solo Levelin", "Sung jin woo"
                ,"Terlahir kembali menjadi hunter"
                ,R.drawable.sl,R.drawable.sl));

        instagrams1.add(new Instagram("One Punch Man","Saitama"
                ,"Pukulan satu kali"
                ,R.drawable.opm, R.drawable.opm));

        instagrams1.add(new Instagram("One Piece","Luffy"
                , "Petualangan dI Lautan Bebas"
                ,R.drawable.op,R.drawable.op));

        instagrams1.add(new Instagram("Kurokoooo","Kisse"
                ,"Korokuuu No bASKET"
                ,R.drawable.kr, R.drawable.kr));

        instagrams1.add(new Instagram("Haikyyu", "Hinata"
                ,"Bermaain volli "
                ,R.drawable.haikyu, R.drawable.haikyu));

        instagrams1.add(new Instagram("Aya Level 99", "Aya"
                ,"Reikarnasi jadi level 99"
                ,R.drawable.ak, R.drawable.ak));
        return instagrams1;
    }
}

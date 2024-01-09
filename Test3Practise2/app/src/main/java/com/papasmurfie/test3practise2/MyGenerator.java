package com.papasmurfie.test3practise2;

import java.util.ArrayList;
import java.util.Random;

public class MyGenerator {

    public static ArrayList<AvtobusDataModel> generateAvtobusList(int q){

        ArrayList<AvtobusDataModel> vsichkiAvtobusi = new ArrayList<AvtobusDataModel>();
        String randomStatus;
        Random r = new Random();

        for(int i=1; i<=q; i++){
            if(r.nextInt()%2 == 0){
                randomStatus = "travelling";
            }else {randomStatus = "arrived";}

            vsichkiAvtobusi.add(new AvtobusDataModel("Name"+i, "Marka"+i,
                    "Napravlenie"+i, "Chas"+i, randomStatus));
        }
        return vsichkiAvtobusi;
    }
}

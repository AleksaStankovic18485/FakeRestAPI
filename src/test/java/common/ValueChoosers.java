package common;

import org.apache.commons.lang3.RandomUtils;

import java.util.ArrayList;

public class ValueChoosers {

    public static String getRandomTitle(){
        ArrayList<String> listOfTitles = new ArrayList<>();
        listOfTitles.add("Mokra krpa na dnu mora");
        listOfTitles.add("Krik mrtvog indijanca na krovu spaljene kuce");
        listOfTitles.add("Pustolovine Petrovic grupe");
        listOfTitles.add("Tadija, o zasto si Tadija");
        listOfTitles.add("Genesys takeover");
        listOfTitles.add("Floodgates!");

        return listOfTitles.get(RandomUtils.nextInt(0, listOfTitles.size()));
    }

}

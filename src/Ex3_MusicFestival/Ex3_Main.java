package Ex3_MusicFestival;

import java.util.ArrayList;

public class Ex3_Main {
    public static void run() {
        ArrayList<Event> allEvents = new ArrayList<>();
        allEvents.add(new MainStageEvent("Walk off the Earth", "Music"));
        allEvents.add(new MainStageEvent("The Black Pumas", "Music"));
        allEvents.add(new NonMusicEvent("Five Fries", "Food Truck", "Truck 9"));

        ((MainStageEvent)allEvents.get(0)).addTech("Pyrotechnics");
        ((MainStageEvent)allEvents.get(0)).addTech("Symphony Orchestra");

        for (int i = 0; i < allEvents.size(); i++) {
            System.out.println(allEvents.get(i).getEventName());
                if(allEvents.get(i) instanceof MainStageEvent){
                    ((MainStageEvent)allEvents.get(i)).printTech();
                }

        }
        allEvents.add(new SmallStage("Despacito", "Music", "11:11"));

        for (int i = 0; i < allEvents.size(); i++) {
            if(allEvents.get(i) instanceof  SmallStage){
                ((SmallStage)allEvents.get(i)).addLocation("the river");
                ((SmallStage)allEvents.get(i)).addLocation("the clouds");
                ((SmallStage) allEvents.get(i)).printLocation();
            }
        }









    }

}

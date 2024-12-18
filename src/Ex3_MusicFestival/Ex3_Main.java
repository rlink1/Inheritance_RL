package Ex3_MusicFestival;

import java.util.ArrayList;

public class Ex3_Main {
    public static void run() {
        ArrayList<Event> allEvents = new ArrayList<>();
        double availableSpace = 1000;

        System.out.println("Welcome to Folkfest!!");
        while (true) {
            System.out.println();
            System.out.println("What would you like to do?");
            System.out.println("1.  Make new event");
            System.out.println("2.  Search for event");
            System.out.println("3.  Filter by event type");
            System.out.println("4.  Exit");

            int choice = Library.input.nextInt();
            Library.input.nextLine();
            if (choice == 1) {
                System.out.println("Which type of event would you like to add? Your choices are of the following:\nMainStageEvent\nNonMusicEvent\nNonMusicSub\nSmallStage");
                String cho = Library.input.nextLine();
                if(cho.equalsIgnoreCase("MainStageEvent")){

                }else if(cho.equalsIgnoreCase("NonMusicEvent")){

                }else if(cho.equalsIgnoreCase("NonMusicSub")){

                }else if(cho.equalsIgnoreCase("SmallStage")){

                }

            } else if (choice == 2) {

            } else if (choice == 3) {



            } else if (choice == 4) {

            }  else {
                break;
            }
        } // while
        System.out.println("There is no folk folking like there is in folkfests folks  \nGood bye.");

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

        allEvents.add(new NonMusicSub("LaineyCultist", "cement ice cream bar", "Strathcona roof", 10000));

        for (int i = 0; i < allEvents.size(); i++) {
            if(allEvents.get(i) instanceof  NonMusicSub){
                if(((NonMusicSub)allEvents.get(i)).checkSpace(availableSpace)){
                    availableSpace = availableSpace - ((NonMusicSub)allEvents.get(i)).returnSpace();
                }
                else{
                    System.out.println("\nNo available space! GET OUT!");
                    allEvents.remove(i);
                }


            }
        }









    }

}

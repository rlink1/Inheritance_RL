package Ex3_MusicFestival;

import java.util.ArrayList;

class SmallStage extends Event{

    ArrayList<String> multLocations;
    private int numArtists;


    public SmallStage(String name, String type, String time){
        super(name, type);
        super.setTime(time);
        multLocations = new ArrayList<String>();

    }

    public void addLocation(String location){
        multLocations.add(location);
    }

    public void printLocation() {

        if(this.multLocations.size() > 1){

            System.out.println("The location for " + super.getEventName() + " is: " );

            for (String loc : multLocations) {
                System.out.print(loc);
            }
            System.out.println(" at " + super.getTime());
        }

    }







}

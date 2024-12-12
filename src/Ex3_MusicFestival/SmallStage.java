package Ex3_MusicFestival;

class SmallStage extends Event{

    private String location = "The river";
    private int numArtists;


    public SmallStage(String name, String type, String time){
        super(name, type);
        super.setTime(time);
        numArtists = -1;
    }

    public void setNumArtists(int a){
        this.numArtists = a;
    }
    public void setLocation(String location) {
        this.location = location;
    }




}

package Ex3_MusicFestival;

class NonMusicEvent extends Event {
    private double rent;


    public NonMusicEvent(String name, String type, String loc ){
        super(name, type);
        super.setLocation(loc);
        rent = -1; // arbitrary default integer

    }


    public void setRent(double r){
        this.rent = r;
    }

    public double getRent() {
        return rent;
    }

    public String getLoc(){
        return getLocation();
    }






}
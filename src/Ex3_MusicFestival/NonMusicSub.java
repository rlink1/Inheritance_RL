package Ex3_MusicFestival;

import java.util.ArrayList;

class NonMusicSub extends NonMusicEvent {

     ArrayList<Double> allSpace = new ArrayList<Double>();
     public int rent;
  private double space;

    public NonMusicSub(String name, String type, String loc, double space){
        super(name, type, loc);
        this.space = space;
        allSpace.add(space);
        super.setLocation(loc);
        this.rent = -1;


    }

     public void setRent(int r){
         this.rent = r;
     }

     public double returnSpace(){
        return this.space;
     }

     public boolean checkSpace(double availableSpace){
        double space = 0;
         for (int i = 0; i < allSpace.size(); i++) {
             space = allSpace.get(i) + space;
         }
         if(availableSpace -  space >= 0){
             return true;
         }
         else{
             return false;
         }
     }



}

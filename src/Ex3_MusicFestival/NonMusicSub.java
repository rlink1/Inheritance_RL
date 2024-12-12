package Ex3_MusicFestival;

 class NonMusicSub extends NonMusicEvent {


  private Boolean hasSell;

    public NonMusicSub(String name, String type, String loc){
       super(name, type, loc);
       super.setLocation(loc);
       this.rent = -1;
       hasSell = false;
    }

  public void setHasSell(Boolean s){
   this.hasSell = s;
  }

  public void setRent(int r){
   this.rent = r;
  }
}

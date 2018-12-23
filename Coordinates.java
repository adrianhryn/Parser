package parser;
//TODO Create class that represents coordinates
public class Coordinates {
    private String longtitude;
    private String latitude;

    public Coordinates(String longtitude, String latitude){ this.longtitude = longtitude; this.latitude = latitude; }
    public String getLongtitude(){ return this.longtitude; }
    public String getLatitude(){ return this.latitude; }
    @Override
    public String toString(){ return String.format("(%1$s; %2$s)", this.longtitude, this.latitude);}
}
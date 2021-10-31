public class Coordinates {
    double latitude;
    double longitude;

    public Coordinates(double latitude, double longitude) {
        this.latitude = latitude;
        this.longitude = longitude;
    }

    public double getDistance(Coordinates coordinates) {
        return (Math.sqrt(
                Math.pow(coordinates.latitude - this.latitude, 2)
                        + Math.pow(coordinates.longitude - this.longitude, 2)));
    }
}

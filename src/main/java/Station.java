import java.util.ArrayList;
import java.util.List;

public class Station {

    private final String objectId;
    private final String name;
    private final Coordinates coordinates;
    private final List<String> lines;

    private final List<Station> connections;

    public Station(String objectId, String name, Coordinates coordinates, List<String> lines){
        this.objectId = objectId;
        this.name = name;
        this.coordinates = coordinates;
        this.lines = lines;
        this.connections = new ArrayList<>();
    }

    public double distance(Station station){
        return coordinates.getDistance(station.coordinates);
    }

    public void connect(Station station){
        connections.add(station);
        station.connections.add(this);
    }

    public String getObjectId() {
        return objectId;
    }

    public Coordinates getCoordinates() {
        return coordinates;
    }

    public List<String> getLines() {
        return lines;
    }

    public List<Station> getConnections() {
        return connections;
    }

    public String getName(){
        return name;
    }
}

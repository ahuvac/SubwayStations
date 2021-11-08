import java.util.*;

public class SubwaySystem {

    List<Station> features;

    static class Station {
        Properties properties;
        Geometry geometry;
        List<Station> connections;

        public Station() {
            this.connections = new ArrayList<>();
        }

        public void connect(Station station) {
            this.connections.add(station);
            station.connections.add(this);
        }

        static class Properties {
            int objectid;
            String name;
            String line;

            public int getObjectid() {
                return objectid;
            }

            public String getName() {
                return name;
            }

            public String getLine() {
                return line;
            }
        }

        static class Geometry {
            List<Double> coordinates;
            Coordinates coords;

            public Coordinates getCoords(){
                this.coords = new Coordinates(coordinates.get(0), coordinates.get(1));
                return coords;
            }

            public List<Double> getCoordinates() {
                return coordinates;
            }

        }
    }

    public Station findClosestStation(Coordinates coordinates){
        return this.features.stream().
                min(Comparator.comparingDouble(station -> station.geometry.getCoords().getDistance(coordinates)))
                .get();
    }

    public Map<Integer, Station> getStationMap(){
        Map<Integer, SubwaySystem.Station> stationMap = new HashMap<>();
        for(SubwaySystem.Station station : this.features){
            stationMap.put(station.properties.objectid, station);
        }
        return stationMap;
    }

    public int getIDFromName(String name) {
        for (Station station : features) {
            if (station.properties.name.equals(name)) {
                return station.properties.objectid;
            }
        }
        return -1;
    }

    public void connectStations(SubwayLines lines, Map<Integer, Station> stations) {
        for (String line : lines.keySet()) {
            int[] stationsOfLine = lines.get(line);
            for (int i = 0; i < stationsOfLine.length - 1; i++) {
                stations.get(stationsOfLine[i]).connect(stations.get(stationsOfLine[i + 1]));
            }
        }
    }


    public List<Station> findShortestPath(SubwayLines lines, Station sourceStation, Station finalStation) {
        final int EDGEWEIGHT = 1;
        Map<Integer, Station> stations = this.getStationMap();
        List<Station> unvisitedStations = this.features;
        Map<Station, Integer> distances = new HashMap<>();

        setDistances(distances, stations, sourceStation);
        connectStations(lines, stations);

        while (!unvisitedStations.isEmpty()) {
            Station currentStation = getClosestStation(unvisitedStations, distances);
            unvisitedStations.remove(currentStation);
            for (Station adjacentStation : currentStation.connections) {
                if (unvisitedStations.contains(adjacentStation)) {
                    replaceDistances(currentStation, adjacentStation, distances, EDGEWEIGHT);
                }
            }
            if(currentStation.equals(finalStation)) break;
        }
        return backtrackPath(distances, sourceStation, finalStation);
    }

    private List<Station> backtrackPath(Map<Station, Integer> distances, Station sourceStation, Station finalStation) {
        List<Station> shortestPath = new ArrayList<>();
        Station current = finalStation;
        while(!current.equals(sourceStation)){
            Station shortestStation = getClosestStation(current.connections, distances);
            shortestPath.add(shortestStation);
            current = shortestStation;
        }
        Collections.reverse(shortestPath);
        shortestPath.add(finalStation);
        return shortestPath;
    }

    private Station getClosestStation(List<Station> unvisitedNodes, Map<Station, Integer> distances) {
            Station lowestDistanceNode = null;
            int lowestDistance = Integer.MAX_VALUE;
            for (Station station : unvisitedNodes) {
                int nodeDistance = distances.get(station);
                if (nodeDistance < lowestDistance) {
                    lowestDistance = nodeDistance;
                    lowestDistanceNode = station;
                }
            }
            return lowestDistanceNode;
        }

    private void setDistances(Map<Station, Integer> distances, Map<Integer, Station> stations, Station source) {
        for(Map.Entry<Integer, Station> station : stations.entrySet()){
            distances.put(station.getValue(), Integer.MAX_VALUE);
        }
        distances.put(source, 0);
    }

    private void replaceDistances(Station sourceNode, Station adjacentStation, Map<Station, Integer> distances, int edgeWeight)
    {
        int sourceDistance = distances.get(sourceNode);
        int newDistance = sourceDistance + edgeWeight;
        if (newDistance < distances.get(adjacentStation))
        {
            distances.put(adjacentStation, newDistance);
        }
    }

}






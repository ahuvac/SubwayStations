public class Trip {
    private Coordinates start;
    private Coordinates end;
    

    public Trip(Coordinates start, Coordinates end) {
        this.start = start;
        this.end = end;
    }

    public Coordinates getStart() {
        return start;
    }

    public Coordinates getEnd() {
        return end;
    }
}

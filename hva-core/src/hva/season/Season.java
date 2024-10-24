package hva.season;

/**
 * Be extra carefull if you are changing this.
 */
public enum Season {
    SPRING,  // ordinal = 0
    SUMMER,  // ordinal = 1
    FALL,  // ordinal = 2
    WINTER;     // ordinal = 3

    // Method to get the next season
    public Season next() {
        return values()[(this.ordinal() + 1) % values().length]; // Wraps around to SPRING after WINTER 
    }

    public int seasonCode() {
        return this.ordinal();
    }
}


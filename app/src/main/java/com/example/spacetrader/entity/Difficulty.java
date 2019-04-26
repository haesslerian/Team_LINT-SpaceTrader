package com.example.spacetrader.entity;

/**
 * @author lukemuehring
 * @version 1.0
 *
 * Enumeration of difficulties available for the user to select
 */
public enum Difficulty {
    BEGINNER ("Beginner"), EASY ("Easy"), NORMAL ("Normal"), HARD ("Hard"), IMPOSSIBLE ("Impossible");
    private final String diffNames;

    Difficulty(String diffNames){
        this.diffNames = diffNames;
    }

    public String toString() { return diffNames; }
}

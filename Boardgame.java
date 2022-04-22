package Module1;
// Parent superclass: Can't be initiated, needs to be inherited.
public abstract class BoardGame {
    // Constants
    private final String gameName;
    private final int players;
    private final int playTimeMin;
    private final int recAge;

    // Default Constructor
    public BoardGame() {
        this.gameName    = "Board Game";
        this.players     = 0;
        this.playTimeMin = 0;
        this.recAge      = 0;
    }

    // Parameter Constructor
    public BoardGame(String gameName, int players, int playTimeMin, int recAge) {
        this.gameName    = gameName;
        this.players     = players;
        this.playTimeMin = playTimeMin;
        this.recAge      = recAge;
    }

    // Interface must have inherited implementation
    public abstract GameType getType();

    public String getGameName() {return gameName;}

    public int getPlayers() {return players;}

    public int getPlayTimeMin() {return playTimeMin;}

    public int getRecAge() {return recAge;}

    // Inherited from 'Object' class
    @Override // Polymorphes
    public String toString() {
        return "Module1.BoardGame - " + this.getGameName() + ", " + this.getPlayers() + " Players Max" + ", Play Time: " + this.getPlayTimeMin() + " mins, " + "Ages " + this.getRecAge() + "+";
    }
}

// Nested Enumerator for the abstract method
enum GameType {
    STRATEGY("Module1.Strategy"), FAMILY("Module1.Family");
    private final String name;

    GameType(String name) {
        this.name = name;
    }

    // Inherited from 'Object' class
    @Override
    public String toString() {
        return name;
    }
}

// Child subclass inheriting the parent superclass
class Strategy extends BoardGame {
    private final GameType type;
    private final int rankBGG;

    // Default Constructor
    public Strategy() {
/*      super.getGameName(); -- Unnecessary
        super.getPlayers();
        super.getPlayTimeMin();
        super.getRecAge();*/
        this.type    = GameType.STRATEGY;
        this.rankBGG = 0;
    }

    // Parameter Constructor
    public Strategy(String gameName, int players, int playTimeMin, int recAge, int rankBGG) {
        super(gameName, players, playTimeMin, recAge);
        this.type    = GameType.STRATEGY;
        this.rankBGG = rankBGG;
    }

    // Parameter Constructor w/ type
    public Strategy(String gameName, int players, int playTimeMin, int recAge, GameType type, int rankBGG) {
        super(gameName, players, playTimeMin, recAge);
        this.type    = type;
        this.rankBGG = rankBGG;
    }

    // Must inherit abstract interface
    public GameType getType() {return this.type;}

    public int getBGGRank() {return this.rankBGG;}

    // Inherited from 'Object' class
    @Override
    public String toString() {
        return super.toString() + ", " + this.getType() + " Type" + ", Board Game Geeks Rank: " + this.getBGGRank();
    }
}

// Child subclass inheriting the parent superclass
class Family extends BoardGame {
    private final GameType type;
    private final int rankBGG;

    // Default Constructor
    public Family() {
/*      super(); -- Unnecessary
        super.getClass();*/
        this.type    = GameType.FAMILY;
        this.rankBGG = 0;
    }

    // Parameter Constructor
    public Family(String gameName, int players, int playTimeMin, int recAge, int rankBGG) {
        super(gameName, players, playTimeMin, recAge);
        this.type    = GameType.FAMILY;
        this.rankBGG = rankBGG;
    }

    // Parameter Constructor w/ type
    public Family(String gameName, int players, int playTimeMin, int recAge, GameType type, int rankBGG) {
        super(gameName, players, playTimeMin, recAge);
        this.type    = type;
        this.rankBGG = rankBGG;
    }

    // Must inherit abstract interface
    public GameType getType() {return this.type;}

    public int getBGGRank() {return this.rankBGG;}

    // Inherited from 'Object' class
    @Override
    public String toString() {
        return super.toString() + ", " + this.getType() + " Type" + ", Board Game Geeks Rank: " + this.getBGGRank();
    }
}

class Main {
    public static void main(String[] args) {
        BoardGame s = new Strategy();
        BoardGame f = new Family();
        BoardGame tfMars = new Strategy("Terraforming Mars", 4, 120, 12, s.getType(), 4);
        BoardGame azul = new Family("Azul", 4, 45, 8, 62);

        System.out.println(s);
        System.out.println(f);
        System.out.println(tfMars);
        System.out.println(azul);
    }
}

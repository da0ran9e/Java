package game;

public class Player {
    private final String[] chatSentences = new String[]{};
    private String name;
    private int score;

    public Player(String name) {
        this.name = name;
        this.score = 0;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public boolean isBot() {
        return false;
    }

    public String getChatSentence() {
        return null;
    }
}

package game;

import java.util.List;

class GameMaster {
    private List<Player> players;
    private int currentPlayerIndex;

    public GameMaster(List<Player> players) {
        this.players = players;
        this.currentPlayerIndex = 0;
    }

    public void nextTurn() {
        currentPlayerIndex = (currentPlayerIndex + 1) % players.size();
    }

    public Player getCurrentPlayer() {
        return players.get(currentPlayerIndex);
    }

    public void calculateScore(int points) {
        Player currentPlayer = getCurrentPlayer();
        int tempScore = currentPlayer.getScore() + points;

        if (tempScore <= 21) {
            currentPlayer.setScore(tempScore);
        }
    }

    public boolean isGameOver() {
        for (Player player : players) {
            if (player.getScore() >= 21) {
                return true;
            }
        }
        return false;
    }

    public Player getWinner() {
        Player winner = null;

        for (Player player : players) {
            if (player.getScore() == 21) {
                if (winner == null) {
                    winner = player;
                    break;
                }
            }
        }

        return winner;
    }
}

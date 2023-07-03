package game;

import java.util.*;

class Game {
    private List<Player> players;
    private GameMaster gameMaster;
    private Dice dice;
    private Scanner scanner;

    public Game() {
        this.players = new ArrayList<>();
        this.gameMaster = new GameMaster(players);
        this.dice = new Dice();
        this.scanner = new Scanner(System.in);
    }

    public void start() {
        System.out.println("=== Chào mừng đến với trò chơi ===");
        System.out.println("Vui lòng nhập tên người chơi: ");
        String name = scanner.nextLine();
        Player player = new Player(name);
        players.add(player);
        boolean isRunning = true;

        while (isRunning) {
            System.out.println("1. Bắt đầu chơi");
            System.out.println("2. Thêm người chơi");
            System.out.println("3. Xóa người chơi");
            System.out.println("4. Thêm bot");
            System.out.println("5. Thoát");
            System.out.print("Lựa chọn của bạn: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Đọc dòng trống sau khi đọc lựa chọn

            switch (choice) {
                case 1:
                    playGame();
                    break;
                case 2:
                    addPlayer();
                    break;
                case 3:
                    removePlayer();
                    break;
                case 4:
                    addBotPlayer();
                    break;
                case 5:
                    isRunning = false;
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }

            System.out.println();
        }

        System.out.println("\n\n\n\n\n\n\n=== Cảm ơn bạn đã chơi ===");
    }

    private void playGame() {
        if (players.size() < 4) {
            while(players.size() < 4){
                Player bot = Bot.addBot();
                players.add(bot);
                System.out.println("Người chơi " + bot.getName() + " đã tham gia!");
            }
        }

        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n=== Bắt đầu trò chơi ===\n\n\n\n");

        while (!gameMaster.isGameOver()) {
            Player currentPlayer = gameMaster.getCurrentPlayer();
            System.out.println("Lượt chơi của người chơi: " + currentPlayer.getName());
            if(!currentPlayer.isBot()){
                System.out.print("Nhấn Enter để lắc xúc xắc...");
                scanner.nextLine();
            }

            int diceRoll = dice.roll();
            System.out.println("Giá trị xúc xắc: " + diceRoll);

            gameMaster.calculateScore(diceRoll);

            System.out.println("Điểm của người chơi " + currentPlayer.getName() + ": " + currentPlayer.getScore());
            gameMaster.nextTurn();
            System.out.println();
        }

        Player winner = gameMaster.getWinner();
        System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n=== Kết thúc trò chơi ===");
        if (winner != null) {
            System.out.println("Người chiến thắng: " + winner.getName() + " với điểm " + winner.getScore()+"\n\n\n\n\n\n\n");
        } else {
            System.out.println("Không có người chiến thắng.\n\n\n\n\n\n\n");
        }
        for(Player player:players){
            if(player.isBot()&&player.getScore()<21){
                System.out.println(player.getName()+": "+player.getChatSentence());
            }
        }
    }

    private void addPlayer() {
        System.out.print("Nhập tên người chơi: ");
        String playerName = scanner.nextLine();

        Player player = new Player(playerName);
        players.add(player);

        System.out.println("Người chơi " + playerName + " đã được thêm vào trò chơi.");
    }

    private void removePlayer() {
        if (players.size() == 1) {
            System.out.println("Phải có ít nhất 1 người để bắt đầu trò chơi");
            return;
        }

        System.out.print("Chọn người chơi cần xóa: ");
        for(int i = 0; i < players.size(); i++) {
            System.out.println((i + 1) + ". " + players.get(i).getName());
        }
        int choice = scanner.nextInt();
        scanner.nextLine();
        String playerName = null;
        while(playerName==null){
            switch (choice) {
                case 1:
                    playerName = players.get(0).getName();
                    break;
                case 2:
                    playerName = players.get(1).getName();
                    break;
                case 3:
                    playerName = players.get(2).getName();
                    break;
                case 4:
                    playerName = players.get(3).getName();
                    break;
                default:
                    System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                    break;
            }
        }
        for (Player player : players) {
            if (player.getName().equals(playerName)) {
                players.remove(player);
                break;
            }
        }
        System.out.println("Người chơi " + playerName + " đã được xóa khỏi trò chơi.");
    }

    private void addBotPlayer() {
        System.out.print("Nhập tên người chơi [Máy]: ");
        String botName = scanner.nextLine();

        Bot bot = new Bot(botName);
        players.add(bot);

        System.out.println("Người chơi " + botName + " đã được thêm vào trò chơi.");
    }
}

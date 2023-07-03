package game;

import java.util.Random;

public class Bot extends Player{
    private final String[] chatSentences = new String[]{"ggs!", "🤣🤣", "hihi", "haha", "hihi", "hihi", "hihi", "hihi", "hihi", "hihi", "hihi", "hihi", "hihi", "hihi", "hihi"};


    public Bot(String name) {
        super("[MÁY]" + name);
    }

    public static String generateRandomName() {
        String ALLOWED_CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";
        Random random = new Random();
        int nameLength = random.nextInt(3) + 8; // Random từ 8 đến 10 kí tự

        StringBuilder nameBuilder = new StringBuilder();
        for (int i = 0; i < nameLength; i++) {
            int randomIndex = random.nextInt(ALLOWED_CHARACTERS.length());
            char randomChar = ALLOWED_CHARACTERS.charAt(randomIndex);
            nameBuilder.append(randomChar);
        }

        return nameBuilder.toString();
    }

    @Override
    public String getChatSentence() {
        return chatSentences[new Random().nextInt(chatSentences.length)];
    }

    public static Player addBot() {
        Player bot = new Bot(generateRandomName());
        return bot;
    }

    @Override
    public boolean isBot() {
        return true;
    }
}

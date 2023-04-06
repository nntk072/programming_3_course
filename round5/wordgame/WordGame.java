import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

public class WordGame {
    private boolean active;
    private final ArrayList<String> WordList = new ArrayList<>();
    private int mistakeLimit, mistakeCount, missingChars;
    private String word;
    private String guessingWord;

    public WordGame(String wordFilename) throws IOException {
        try (var cmdFile = new BufferedReader(new FileReader(wordFilename))) {
            String cmd;
            while ((cmd = cmdFile.readLine()) != null) {
                WordList.add(cmd);
            }
        }
    }

    public void initGame(int wordIndex, int mistakeLimit) {
        // Get word and mistake limit
        while (wordIndex > WordList.size() - 1) {
            wordIndex -= WordList.size();
        }
        this.word = WordList.get(wordIndex);
        this.mistakeLimit = mistakeLimit;

        // Get word as ____ and how many chars to guess
        char[] chars = new char[word.length()];
        Arrays.fill(chars, '_');
        guessingWord = new String(chars);
        missingChars = word.length();
        // Change the state of the game
        active = true;
        mistakeCount = 0;
    }

    public boolean isGameActive() {
        return active;
    }

    public static class WordGameState {
        private final String guessingWord;
        private final int mistakes;
        private final int mistakeLimit;
        private final int missingChars;

        private WordGameState(String word, int mistakes, int mistakeLimit, int missingChars) {
            this.guessingWord = word;
            this.mistakes = mistakes;
            this.mistakeLimit = mistakeLimit;
            this.missingChars = missingChars;
        }

        public String getWord() {
            return guessingWord;
        }

        public int getMistakes() {
            return mistakes;
        }

        public int getMistakeLimit() {
            return mistakeLimit;
        }

        public int getMissingChars() {
            return missingChars;
        }
    }

    public WordGameState getGameState() throws GameStateException {
        if (!active) {
            throw new GameStateException("There is currently no active word game!");
        }
        return new WordGameState(guessingWord, mistakeCount, mistakeLimit, missingChars);
    }

    public WordGameState guess(char c) throws GameStateException {
        if (!active || mistakeCount > mistakeLimit) {
            active = false;
            mistakeCount = 0;
            throw new GameStateException("There is currently no active word game!");
        }
        int count = 0;

        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) == Character.toLowerCase(c) && word.charAt(i) != guessingWord.charAt(i)) {
                count++;
                missingChars--;
                char[] strArray = guessingWord.toCharArray();
                strArray[i] = Character.toLowerCase(c);
                guessingWord = new String(strArray);
            }
        }
        if (count == 0)
            mistakeCount++;
        if (guessingWord.equals(word)) {
            active = false;
        }
        if (mistakeCount > mistakeLimit)
            guessingWord = word;
        return new WordGameState(guessingWord, mistakeCount, mistakeLimit, missingChars);
    }

    public WordGameState guess(String c) throws GameStateException {
        if (!active || mistakeCount > mistakeLimit) {
            active = false;
            mistakeCount = 0;
            throw new GameStateException("There is currently no active word game!");
        }
        if (c.equals(word)) {
            guessingWord = word;
            active = false;
        } else {
            mistakeCount++;
        }
        if (guessingWord.equals(word)) {
            missingChars = 0;
            active = false;
        }
        if (mistakeCount > mistakeLimit) {
            guessingWord = word;
            active = false;
        }
        return new WordGameState(guessingWord, mistakeCount, mistakeLimit, missingChars);
    }
}
import java.util.*;

public class App {
    public static void main(String[] args) {
        int attempts = 10;
        List<String> words = Arrays.asList(
                "apple", "banana", "car", "dog", "elephant", "flower", "guitar", "house",
                "island", "jacket", "kite", "lamp", "mountain", "notebook", "ocean", "piano",
                "quilt", "rocket", "sun", "tree", "umbrella", "violin", "whale", "xylophone",
                "yacht", "zebra", "airplane", "book", "cat", "drum", "egg", "fish",
                "grape", "hat", "ice", "jewel", "key", "leaf", "moon", "nest",
                "orange", "pearl", "quokka", "ring", "star", "turtle", "unicorn", "vase",
                "window", "x-ray", "yarn", "zucchini", "ant", "balloon", "candle", "dolphin",
                "envelope", "feather", "giraffe", "honey", "igloo", "jungle", "koala", "lighthouse",
                "mushroom", "noodle", "octopus", "puzzle", "quokka", "robot", "sailboat", "telescope",
                "universe", "volcano", "waterfall", "xenon", "yeti", "zodiac", "anchor", "bicycle",
                "cactus", "daisy", "eagle", "fountain", "goblet", "horizon", "ink", "jigsaw"
        );

        System.out.println("Welcome to Hangman!\nIn this game you have 10 attempts to guess the word.");

        String my_word = words.get(RandomNum(0, words.size() - 1));
        List<String> list = new ArrayList<>(Collections.nCopies(my_word.length(), "_"));
        Scanner input = new Scanner(System.in);
        char my_char;
        int remainingAttempts = attempts;
        Set<Character> incorrectGuesses = new HashSet<>();

        while (remainingAttempts > 0 && list.contains("_")) {
            clearConsole(); // Clear the console before each guess
            System.out.println("Attempts: " + remainingAttempts);
            System.out.println("Word: " + String.join(" ", list));
            System.out.println("Incorrect guesses: " + incorrectGuesses);

            System.out.println("\nPlease enter your guessed character: ");
            String my_input = input.nextLine();
            if (my_input.length() == 1 && Character.isLetter(my_input.charAt(0))) {
                my_char = my_input.charAt(0);
                boolean correctGuess = false;

                for (int i = 0; i < my_word.length(); i++) {
                    if (my_word.charAt(i) == my_char) {
                        list.set(i, Character.toString(my_char));
                        correctGuess = true;
                    }
                }

                if (!correctGuess) {
                    if (!incorrectGuesses.contains(my_char)) {
                        incorrectGuesses.add(my_char);
                        remainingAttempts--;
                        System.out.println("Wrong guess! Attempts remaining: " + remainingAttempts);
                    } else {
                        System.out.println("You already guessed that letter.");
                    }
                } else {
                    System.out.println("Good guess! Attempts remaining: " + remainingAttempts);
                }
            } else {
                System.out.println("Invalid input. Please enter exactly one letter.");
                // Do not decrement attempts for invalid input
            }
        }

        if (!list.contains("_")) {
            System.out.println("Congratulations! You've guessed the word: " + my_word);
        } else {
            System.out.println("Game over! The word was: " + my_word);
        }
    }

    public static void clearConsole() {
        // Print new lines to simulate clearing the console
        for (int i = 0; i < 50; i++) {
            System.out.println();
        }
    }

    public static int RandomNum(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min; // +1 to include max
    }
}

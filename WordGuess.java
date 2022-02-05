import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.Random;

public class WordGuess {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.print("Welcome to words: The Word Guessing Game!\n" +
        "Play as many agmes as you like. I'll remember your top score.\n" +
        "and also compute your average for all games played.\n" +
        "\n- - - - - - - - - - - - - - - - - - - - - -\n");
        String play = "y";
        Scanner kb = new Scanner(System.in);
        int games = 0;
        double bestScore = 0.0;
        double sumScore = 0.0;
        double score = 0.0;
        while(play.equals("y")) {
            games++;
            score = game();
            sumScore += score;
            if(score > bestScore) {
                bestScore = score;
            }
            System.out.printf("Your score: %.1f%%!\n", score);
            System.out.print("\nWant to play again? ");
            play = kb.next().toLowerCase();
            System.out.print("\n- - - - - - - - - - - - - - - - - - - - - -\n");
        }
        System.out.print("Thanks for playing...\n");
        System.out.printf("  Your best score was %.2f%%!\n", bestScore);
        System.out.printf("  Your average score was %.2f%%!\n", sumScore/games);
    }

    // Game: series of guesses.
    public static double game() throws FileNotFoundException {
        String[] wordArray = hideWord();
        String rightLetters = "";
        String wrongLetters = "";

        int tries = 0;
        boolean guessed = false;
        while(!guessed) {
            // Print out incorrectly guessed letters and then prompt the user for the next letter.
            System.out.print("Letters already guessed: " + wrongLetters + "\n");
            System.out.print("Guess a letter in this word: " + wordString(wordArray) + " ?? ");
            String guess = guess();

            // Series of guess checks.
            if(rightLetters.indexOf(guess) > -1) {
                // If guess is in rightLetters:
                System.out.print("==> " + guess + " was already guessed correctly.\n");
            } else if(wrongLetters.indexOf(guess) > -1) {
                // If guess is in wrongLetters:
                System.out.print("==> " + guess + " was already guessed.\n");
            } else {
                // If guess is in neither rightLetters nor wrongLetters
                if(checkIfContainsGuess(guess, wordArray)) {
                    // If the word contains the guess:
                    rightLetters = rightLetters + guess;
                    tries++;
                } else {
                    // If the word does NOT contain the guess:
                    wrongLetters = wrongLetters + guess;
                    tries++;
                }
            }

            // Check for completion.
            if(checkIfComplete(wordArray)) {
                guessed = true;
            }
        }
        System.out.print("\nYou guessed this word: " + wordString(wordArray) + " in " + tries + " guesses!\n");
        return 100 - tries / 26.0 * 100 + (wordArray.length-1) / 26.0 * 100;
    }

    // Creates the array that hides the word. The last value in the array is the word itself.
    public static String[] hideWord() throws FileNotFoundException {
        // Generate random number
        int NUMBER_OF_WORDS = 6;
        Random random = new Random();
        int num = random.nextInt(NUMBER_OF_WORDS) + 1;

        // Read the word
        // Requires a .txt file in the cwd named "words.txt"
        File words = new File("words.txt");
        Scanner readWord = new Scanner(words);
        String word = "";
        for(int i = 0; i < num; i++) {
            word = readWord.nextLine();
        }

        // Create the array that hides the word. Last array value is the word itself.
        String[] wordArray = new String[word.length() + 1];
        for(int i = 0; i < word.length(); i++) {
            if(isVowel(word.substring(i, i+1))) {
                wordArray[i] = "=";
            } else {
                wordArray[i] = "-";
            }
        }
        wordArray[word.length()] = word;

        readWord.close();

        return wordArray;
    }

    // User inputted guess. Recursive call if not a single letter. Makes capital letters lowercase.
    public static String guess() {
        Scanner kb = new Scanner(System.in);
        String guess = kb.next().toLowerCase();
        if(isLetter(guess)) {
            return guess;
        } else {
            System.out.print("Not a letter. Guess again: ");
            return guess();
        }
    }

    // Checks if the inputted guess is in the word.
    public static boolean checkIfContainsGuess(String guess, String[] wordArray) {
        boolean contains = false;
        String word = wordArray[wordArray.length - 1];
        for(int i = 0; i < word.length(); i++) {
            if(guess.equals(word.substring(i, i+1))) {
                contains = true;
                wordArray[i] = guess;
            }
        }
        return contains;
    }

    // Checks if there is any '-' or "=" left in the word. False if remaining, true otherwise.
    public static boolean checkIfComplete(String[] wordArray) {
        for(int i = 0; i < wordArray.length - 1; i++) {
            if(wordArray[i].equals("-") || wordArray[i].equals("=")) {
                return false;
            }
        }
        return true;
    }

    // Checks if letter in the word is a vowel.
    public static boolean isVowel(String a) {
        return "aeiou".indexOf(a) > -1;
    }

    // Checks if entered string is a letter.
    public static boolean isLetter(String a) {
        return "abcdefghijklmnopqrstuvwxyz".indexOf(a) > -1;
    }

    // Prints all values in the array except for the last one (the word).
    public static String wordString(String[] array) {
        String word = "";
        for(int i = 0; i < array.length - 1; i++) {
            word = word + array[i];
        }
        return word;
    }
}
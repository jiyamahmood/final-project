import java.util.Random;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 * Final Project
 * @author Jiya Mahmood
 * @since December 5th, 2025
 * This program generates random sentences using articles, nouns, verbs, and prepositions 
 */
public class RandomSentences {

    // main method: displays the menu and allows user to select between the given options
    public static void main(String[] args) { 
        Random random = new Random();
        
        // these are the list of words used for the random sentence generator 
        ArrayList<String> articles = new ArrayList<>(Arrays.asList("a", "the", "an", "some", "any"));
        ArrayList<String> nouns = new ArrayList<>(Arrays.asList("apple", "orange", "panda", "bird", "woman", "man"));
        ArrayList<String> verbs = new ArrayList<>(Arrays.asList("ran", "jumped", "skipped", "danced", "sang"));
        ArrayList<String> prepositions = new ArrayList<>(Arrays.asList("to", "from", "over", "under", "by", "for"));

            int choice = 0;
            Scanner scanner = new Scanner(System.in);

            // while loop: gives user the option to add/remove nouns/verbs, generate random sentences, or view the list of nouns/verbs
            while (choice !=8) { // 
                System.out.println("Hello, welcome to my Random Number Generator! Please select one of the following options.");
                System.out.println("1. Add a noun");
                System.out.println("2. Add a verb");
                System.out.println("3. Remove a noun");
                System.out.println("4. Remove a verb");
                System.out.println("5. Generate a random sentence");
                System.out.println("6. View list of nouns");
                System.out.println("7. View list of verbs");
                System.out.println("8. Exit Generator");

                choice = scanner.nextInt();
                scanner.nextLine();

                switch (choice) {

                    // case 1: add a noun
                    case 1: 
                    System.out.print("Please enter a noun to add: ");
                    String newNoun = scanner.nextLine();
                    nouns.add(newNoun);
                    System.out.println(newNoun + " added!");
                    break;

                    // case 2: add a verb
                    case 2:
                    System.out.print("Please enter a verb to add: ");
                    String newVerb = scanner.nextLine();
                    verbs.add(newVerb);
                    System.out.println(newVerb + " added!");
                    break;

                    // case 3: remove a noun from the list of nouns
                    case 3:
                    System.out.print("Please enter a noun to remove: ");
                    String removeNoun = scanner.nextLine();
                    if (nouns.remove(removeNoun)) {
                        System.out.println(removeNoun + " removed!");
                    } else {
                        System.out.println(removeNoun + " not found!");
                    }
                    break;

                    // case 4: remove a verb from the list of verbs 
                    case 4:
                    System.out.print("Please enter a verb to remove: ");
                    String removeVerb = scanner.nextLine();
                    if (verbs.remove(removeVerb)) {
                        System.out.println(removeVerb + " removed!");
                    } else {
                        System.out.println(removeVerb + " not found!");
                    }
                    break;

                    // case 5: generate a random sentence 
                    case 5:
                    String sentence = generateSentences(articles, nouns, verbs, prepositions, random);
                    System.out.println("Generated random sentence: " + sentence);
                    break;
                    
                    // case 6: displays the list of nouns
                    case 6: 
                    System.out.println("Nouns: " + nouns);
                    break;

                    // case 7: displays the list of verbs
                    case 7:
                    System.out.println("Verbs: " + verbs);
                    break;

                    // case 8: exit the program
                    case 8:
                    System.out.println("Goodbye!");
                    break;

                    default:
                    System.out.println("Invalid option, try again!");
                }
            }

            scanner.close();

        }

        /**
        * generateSentences: this method generates a random sentence using the given list of words
        * @param articles the list of articles for the random sentence generator
        * @param nouns the list of nouns for the random sentence generator
        * @param verbs the list of verbs for the random sentence generator
        * @param prepositions the list of prepositions for the random sentence generator 
        * @param random the random object applied to choose random words
        * @return the random sentence generated
        */ 
        public static String generateSentences(
            ArrayList<String> articles,
            ArrayList<String> nouns,
            ArrayList<String> verbs,
            ArrayList<String> prepositions,

            Random random) {

                // sentence format: article, noun, verb, preposition, article, noun
                String word1 = articles.get(random.nextInt(articles.size()));
                String word2 = nouns.get(random.nextInt(nouns.size()));
                String word3 = verbs.get(random.nextInt(verbs.size()));
                String word4 = prepositions.get(random.nextInt(prepositions.size()));
                String word5 = articles.get(random.nextInt(articles.size()));
                String word6 = nouns.get(random.nextInt(nouns.size()));

                    word1 = word1.substring(0, 1).toUpperCase() + word1.substring(1);

                StringBuilder sb = new StringBuilder();
                sb.append(word1).append(" ")
                  .append(word2).append(" ")
                  .append(word3).append(" ")
                  .append(word4).append(" ")
                  .append(word5).append(" ")
                  .append(word6).append(".");
                
                return sb.toString();

    }

}

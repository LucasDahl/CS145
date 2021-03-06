import java.util.*;

/**
 *This program will read an input file, and using grammar in Backus-Naur form
 * will randomly generate elements of the grammar.
 *
 * @author Lucas D. Dahl
 * @version 10/19/20
 */
public class GrammarSolver {

    // **************************** Fields ****************************
    private Map<String, List<String>> grammarMap = new TreeMap<>();

    // ************************** Constructors ************************

    /**
     *  This is the default constructor that takes in a list of from
     *  a file that has non-terminals and terminals.
     *
     * @param rules is the list of rules to use to construct a sentence.
     * @throws IllegalArgumentException throws an error if the list is null, empty, or the key already exists.
     */
    public GrammarSolver(List<String> rules) {

        // Make sure the list is not null or empty
        if(rules.isEmpty()) {
            throw new IllegalArgumentException("The rule list must contain at least one rule.");
        }

        // Split the list into non-terminals and terminals.
        for(String word: rules) {

            // Loop properties
            ArrayList<String> terminal = new ArrayList<>();
            Scanner lineScanner = new Scanner(word);

            // Set the Delimiter
            lineScanner.useDelimiter("::=");

            // Get the terminal and the non-terminal
            String nonTerminal = lineScanner.next().trim();
            String terminalLine = lineScanner.next();
            Scanner termScan = new Scanner(terminalLine);

            // Set the  new delimiter
            termScan.useDelimiter("\\|");

            // Separate for each terminal
            while(termScan.hasNext()) {
                String termWord = termScan.next().trim();
                terminal.add(termWord);
            }

            // Make sure there are two non-terminals that are the same.
            if(!contains(nonTerminal)) {
                grammarMap.put(nonTerminal, terminal);
            } else {
                throw new IllegalArgumentException("Contains more than one rule set for a non-terminal.");
            }
        }
    }

    // **************************** Methods ***************************

    /**
     *This method will return true if the map contains the current
     * symbol as a non-terminal, and false if it does not.
     *
     * @param symbol is the string symbol to check.
     * @return will return true or false if the map contains the key.
     * @throws IllegalArgumentException throws an error if the symbol is null or empty.
     */
    public Boolean contains(String symbol) {

        // Make sure the symbol is not empty or null.
        if(symbol.isEmpty()) {
            throw new IllegalArgumentException("The symbol does not exist.");
        }

        // Return true if the symbol is a key in the map.
        return grammarMap.containsKey(symbol);
    }

    /**
     * This method will return a set containing all the string
     * non-terminal strings from teh file.
     *
     * @return a set of Strings that are non-terminal symbols.
     */
    public Set<String> getSymbols() {

        // Properties
        Set<String> grammarSet = new TreeSet<>();

        // Get all the keys(non-terminals) from the map.
        for(String rule: grammarMap.keySet()) {
            grammarSet.add(rule);
        }

        // Return the non-terminal symbols from the file.
        return grammarSet;
    }

    /**
     *This method will take in a non-terminal symbol to start a recursive
     * generated string.
     *
     * @param symbol is the symbol to start the generation from,
     * @return the fine string to display to the user once the base case is met.
     * @throws IllegalArgumentException throws an error if the symbol is null or empty.
     */
    public String generate(String symbol) {

        // Properties
        String grammar = "";

        // Make sure the symbol is not empty or null.
        if(symbol.isEmpty()) {
            throw new IllegalArgumentException("The symbol does not exist.");
        }

        if(!contains(symbol)) {
            return symbol;
        } else {

            // Get the terminals into a set.
            Random rand = new Random();
            ArrayList<String> terminalSet = new ArrayList<>();
            int randNum = rand.nextInt(grammarMap.get(symbol).size());

            // Setup the scanner
            String line = grammarMap.get(symbol).get(randNum);
            Scanner termScan = new Scanner(line.trim());

            while(termScan.hasNext()) {
                String word = termScan.next().trim();
                terminalSet.add(word);
            }

            // Create the sentence recursively.
            for(String terminal: terminalSet) {
                grammar += generate(terminal) + " ";
            }
        }

        return grammar.trim();
    }
}
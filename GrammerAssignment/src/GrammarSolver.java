import java.util.*;

/**
 *
 * @author Lucas D. Dahl
 * @version 10/19/20
 */
public class GrammarSolver {

    // **************************** Fields ****************************
    private Map<String, ArrayList<String>> grammarMap = new TreeMap<>();

    // ************************** Constructors ************************

    /**
     *  This is the default constructor that takes in a list of from
     *  a file that has non-terminals and terminals.
     *
     * @param rules is the list of rules to use to construct a sentence.
     */
    public GrammarSolver(List<String> rules) {

        // Properties
        String nonTerminal = null, list = "";


        // Make sure the list is not null or empty
        if(rules.isEmpty()) {
            throw new IllegalArgumentException("The rule list must contain at least one rule.");
        }

        // Create the string to scan.
        for(String word: rules) {
            list += word + "::=";
        }

        // Setup the scanner.
        Scanner lineScanner = new Scanner(list);

        // Set the delimiter
        lineScanner.useDelimiter("::=");

        while(lineScanner.hasNext()) {

            ArrayList<String> terminal = new ArrayList<>();

            // Get the terminal and the non-terminal
            nonTerminal = lineScanner.next().trim();

            // Setup the terminals to scan through an breakup.
            String terminalLine = lineScanner.next();
            Scanner termScan = new Scanner(terminalLine);

            // Set the delimiter
            termScan.useDelimiter("\\|");

            while(termScan.hasNext()) {
                terminal.add(termScan.next());
            }

            // Add them to the map.
            grammarMap.put(nonTerminal, terminal);
        }

        for(String key: grammarMap.keySet()) {
            System.out.println("key: " + key + " -- " + grammarMap.get(key));
        }

    }

    // **************************** Methods ***************************

    // **************** Private ***************

    // **************** Public ****************
    /**
     *
     * @param symbol is the string symbol to check.
     * @return will return true or false if the map contains the key.
     */
    public Boolean contains(String symbol) {

        // Make sure the symbol is not empty or null.
        if(symbol.isEmpty()) {
            throw new IllegalArgumentException("The symbol does not exist.");
        }

        return grammarMap.containsKey(symbol);
    }

    /**
     *
     * @return
     */
    public Set<String> getSymbols() {

        // Properties
        Set<String> grammarSet = new TreeSet<>();

        for(String rule: grammarMap.keySet()) {
            grammarSet.add(rule);
        }

        return grammarSet;
    }

    /**
     *
     * @param symbol
     * @return
     */
    public String generate(String symbol) {

        // Properties
        String grammar = "";
        Random rand = new Random();
        ArrayList<String> terminalSet;

        if(!contains(symbol)) { // CHECK?
            return symbol;
        }

        terminalSet = grammarMap.get(symbol);
        int randNum = rand.nextInt(terminalSet.size());
        for(int i = 0; i < terminalSet.size(); i++) {
            grammar += generate(terminalSet.get(randNum)) + " ";
        }

        return grammar;
    }

}

/**
 * 
 */
import java.util.HashMap;
//import org.apache.common.cli;

/**
 * @author alex
 *
 */
public class BddTestHardCoded {
    static HashMap<String,Bdd> nodes;
    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Create a Hard BDD Tree and test our functions
        // create command line parser
        //CommandLineParser parser = new DefaultParser();
        
        // Create a Hashmap or ArrayList which we will add our Nodes to.
        nodes = new HashMap<String,Bdd>();
        
        // Create Ending Nodes 
        // zero
        nodes.put("zero",new Bdd("0", null, null));
        // one
        nodes.put("one",new Bdd("1", null, null));
        // Create Regular Nodes
        // Node F 
        nodes.put("f",new Bdd("f", nodes.get("one"), nodes.get("zero")));
        // Node E
        nodes.put("e",new Bdd("e", nodes.get("one"), nodes.get("zero")));
        // Node D
        nodes.put("d",new Bdd("d", nodes.get("zero"), nodes.get("one")));
        // Node C
        nodes.put("c",new Bdd("c", nodes.get("one"), nodes.get("f")));
        // Node B
        nodes.put("b",new Bdd("b", nodes.get("d"), nodes.get("e")));
        // Node A
        nodes.put("a",new Bdd("a", nodes.get("b"), nodes.get("c")));
        // Test some functions
        
        //Bdd root = nodes.get("a");
        // Print out the Tree.
       
        System.out.print(Bdd.graphvizStringFromCollection(nodes));
        
    }

}

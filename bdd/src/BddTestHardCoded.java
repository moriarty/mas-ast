/**
 * 
 */
import java.util.Collection;
import java.util.HashMap;
import java.util.Set;
import java.util.ConcurrentModificationException;
//import org.apache.common.cli;

/**
 * @author alex
 *
 */
public class BddTestHardCoded {
    /**
     * Class Variables
     * nodes is a HashMap of nodes which 
     */
    static HashMap<String,Bdd> nodes;

    public static void main(String[] args) {
        // TODO Create a Hard BDD Tree and test our functions
        // create command line parser
        //CommandLineParser parser = new DefaultParser();
        String root;
        
        // Test some functions
        root = hardCodeNodes();
        //System.out.println(root);
        
        //root = getRoot();
        //System.out.println(root + "END ");
        
        
        // Print out the Tree.       
        System.out.print(Bdd.graphvizStringFromCollection(nodes));
    }

    
    
    /**
     * Find the root node in a Bdd tree.
     * 
     * @param nodes
     * @return root node String key in nodes
     */
    public static String getRoot() {
        Collection<Bdd> values = nodes.values();
        
        for (Bdd node : nodes.values()){
            System.out.println("Keys "+values.toString());
            System.out.println("at "+node.getId());
            if (node.getId() == "1" || node.getId() == "0"){
                System.out.println("at sink: "+node.getId());
                
            } else {
                System.out.println("removing "+node.getHigh().getId());
            try{
                values.remove(node.getHigh().getId());
            } catch (ConcurrentModificationException e){
                System.out.println(node.getHigh().getId()+" was already removed");
            }

            System.out.println("removing "+node.getLow().getId());
            
            try{
                values.remove(node.getLow().getId());
            } catch (ConcurrentModificationException e){
                System.out.println(node.getLow().getId()+" was already removed");
            }
            
            }
        }
        if (values.size() == 1) {
            return values.toString();
        } else
            return values.toString();
    }
    
    /**
     * This function sets class variable nodes to a hard coded coded bdd tree.
     * 
     * @return String returned is key of root node in class variable nodes.
     */
    private static String hardCodeNodes() {
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
        
        return "a";
    }

}

/** An all in one class implementation of Binary Decision Diagram
 * 
 * This is a one stop Binary Decision Diagram (BDD) shop. In this
 * implementation there is only one Bdd class, no need for Tree 
 * and Node separation.  
 */

import java.util.ArrayList;
import java.util.Map;

/**
 * @author Alexander Moriarty
 *
 */
public class Bdd {

    private String id;
    private Bdd high;
    private Bdd low;
    private ArrayList<Bdd> parents;
    /**
     * A BDD Node Object
     * 
     * @param id
     * @param high
     * @param low
     */
    public Bdd(String id, Bdd high, Bdd low) {
       setId(id);
       setHigh(high);
       setLow(low);
       initParents();
        
        /**
        *  Text file (csv) [a | 1 | 0 ]
        *  or csv a,!a2,a3 (and columns or rows)
        *  
        *  Identify root node C1 \ C2 Union C3
        *  Value in C1 that is not in either C2 or C3
        */
        
    }
    private void initParents(){
        this.parents = new ArrayList<Bdd>(); 
    }
    
    public void addParent(Bdd parent){
        this.parents.add(parent);
    }
    public void removeParent(Bdd parent){
        this.parents.remove(parent);
    }
    
    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }
    public Bdd getHigh() {
        return high;
    }
    public void setHigh(Bdd high) {
        this.high = high;
    }
    public Bdd getLow() {
        return low;
    }
    public void setLow(Bdd low) {
        this.low = low;
    }
    public boolean isSink() {
        if (this.id.equals("-1") || this.id.equals("-2")) return true;
        else return false;
    }
    public boolean isTrue() {
        if (this.id.equals("-1")){ 
            return true;
        } else {
            return false;
        }
    }

    public static String one() {
        return "-1";
    }  
    public static String zero() {
        return "-2";
    }
    public static boolean bddIncludes(Bdd b, int[] v) {
        /* Tests whether a BDD includes a valuation */
        // Set n to the root of B.
        // array list 
        // Know Set A, v is Subset of A where values are true
        // if not in v then that is false
        boolean includes = false;
        Bdd n = b;
        while ( !n.isSink() ) {
            // Set a to the decision variable n.
            
            // Set n to the v(a) - successor of n.
        }
        //return true if n is labeled 1, falsue if it labeled 0.
        
        return includes;
    }
    public static String graphvizStringFromCollection(Map<String,Bdd> nodes){
        String str = "digraph G {\n";
        for (Bdd node : nodes.values()) {
            str += node.toGraphvizString();
        }
        str += "}\n";
        return str;
    }
    public String toGraphvizString(){
        StringBuilder sb = new StringBuilder(200);
        if (this.id.equals("1")){
            sb.append("1 [shape=box, style=filled, color=green];\n");
            return sb.toString();
        } else if (this.id.equals("0")) {
            sb.append("0 [shape=box, style=filled, color=red];\n");
            return sb.toString();            
        } else {
            sb.append(this.id);
            sb.append(" -> ");
            sb.append(this.high.getId());
            sb.append(" [color=green];\n");
            sb.append(this.id);
            sb.append(" -> ");
            sb.append(this.low.getId());
            sb.append(" [color=red];\n");
            return sb.toString();
        }
    }
}
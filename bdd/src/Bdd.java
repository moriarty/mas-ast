/** An all in one class implementation of Binary Decision Diagram
 * 
 * This is a one stop Binary Decision Diagram (BDD) shop. In this
 * implementation there is only one Bdd class, no need for Tree 
 * and Node separation.  
 */

import java.util.HashMap;

/**
 * @author Alexander Moriarty
 *
 */
public class Bdd {

    private int id;
    private Bdd high;
    private Bdd low;
    
    /**
     * 
     * 
     * @param id
     * @param high
     * @param low
     */
    public Bdd(string id, Bdd high, Bdd low) {
       /**
        *  Text file (csv) [a | 1 | 0 ]
        *  or csv a,!a2,a3 (and columns or rows)
        *  
        *  Identify root node C1 \ C2 Union C3
        *  Value in C1 that is not in either C2 or C3
        */
        
    }
    
    public int getId() {
        return id;
    }
    public void setId(int id) {
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
        if (this.id < 0) return true;
        else return false;
    }
    public boolean isTrue() {
        if (this.id == -1) return true;
    }

    public static int one() {
        return -1;
    }  
    public static int zero() {
        return -2;
    }
    public static boolean bdd-includes(Bdd b, int[] v) {
        /* Tests whether a BDD includes a valuation */
        // Set n to the root of B.
        // array list 
        // Know Set A, v is Subset of A where values are true
        // if not in v then that is false
        Bdd n = b;
        while ( !n.isSink() ) {
            // Set a to the decision variable n.
            
            // Set n to the v(a) - successor of n.
        }
        //return true if n is labeled 1, falsue if it labeled 0.
        
    }
    }
}

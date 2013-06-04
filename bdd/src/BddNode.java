/**
 * 
 */

/**
 * @author alex
 *
 */
public class BddNode {

    /**
     * @param args
     */
    private BddNode high; 
    private BddNode low; 
    int variable;
    
    // Set of incoming arcs
    
    /**
     * 
     * 
     * @param newData
     */
    BddNode(int newData) { 
      setHigh(null); 
      setLow(null); 
      variable = newData; 
    }

    public BddNode getHigh() {
        return high;
    }

    public void setHigh(BddNode high) {
        this.high = high;
    }

    public BddNode getLow() {
        return low;
    }

    public void setLow(BddNode low) {
        this.low = low;
    } 

}

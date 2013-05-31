/**
 * 
 */

/**
 * @author alex
 *
 */
public class BddTree {

    /**
     * @param args
     */
    private BddNode root;
    
    public BddTree(){
        setRoot(null);
    }

    public BddNode getRoot() {
        return root;
    }

    public void setRoot(BddNode root) {
        this.root = root;
    }

}

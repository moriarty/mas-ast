/**
 * 
 */

/**
 * @author Alexander Moriarty
 *
 */
public class BddTree {

    /**
     * root is the where the BddTree begins
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

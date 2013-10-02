/**
 * 
 */
//import java.awt.image.BufferedImage;
/**
 * @author alex
 *
 */
public class OccupancyMapTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        // TODO Auto-generated method stub
        
        OccupancyMap map = new OccupancyMap(10,10,10,10,1, 0.5);
        
        map.query(45.0);
        
        double[][] foo;
        foo = map.getMap();
        
        int[] data = { 3, 4, 5, 2, 7,8,7,7,7};
        
        map.update(data);
        
        foo[0][0] = 7.0;
        map.setMap(foo);
        System.out.print(map.printMap());
    }

}

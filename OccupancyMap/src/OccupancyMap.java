/**
 * 
 */

/**
 * @author alex
 *
 */
public class OccupancyMap {

    /* variables */
    private final double PROBABILITY_IS_FREE = 0.50;
    //private final double PROBABILITY_IS_OCCUPIED = 0.50;
    //private final double FREE = 0.40;
    private final double OCCUPIED = 0.60;
    private int front; // Forward max distance of the map
    private int back;  
    private int right;
    private int left;
    private int n;
    
    private double[][] map;
    
    /**
     * Create an Occupancy Map with given attributes.
     * 
     * @param front
     * @param back
     * @param right
     * @param left
     * @param n
     */
    public OccupancyMap( int front, int back, int right, int left, int n, double preset){
        this.setFront(front);
        this.setBack(back);
        this.setRight(right);
        this.setLeft(left);
        this.setN(n);
        this.setMap(initMap(preset));
        
    }
    
    /**
     * 
     */
    private double[][] initMap(double preset){
        int rows = this.left + this.right;
        int cols = this.back + this.front;
        map = new double[rows][cols];
        
        for(int i =0; i< rows*cols; i++){
            map[i/rows][i % cols] = preset;
        }
        return map;
    }
    
    /**
     * Update the Map with given laserData
     * 
     * @param laserData : An array of laser data.
     */
    public void update( int[] laserData) {
        double[][] scanMap;
        scanMap = this.initMap(-1.0);
        
        for (int i=1; i < laserData.length; i++){
            scanMap = this.setBeam(i, laserData[i],scanMap);
        }
        this.setMap(scanMap);
        
    }
    
    /**
     * Update the Map with given laserData
     * 
     * @param laserData : An array of laser data.
     */
    public void updateCell(int x, int y, boolean free) {
        double newValue;
        double oldValue = query(x, y);
        if (free){
            newValue = oldValue * (1.0 - OCCUPIED) / (PROBABILITY_IS_FREE);
        } else {
            newValue = oldValue * OCCUPIED /  (1.0 - PROBABILITY_IS_FREE) ;
        }
        System.out.println(newValue);
        set(x, y, newValue);
    }
    
    /**
     * 
     * @param angle
     * @return
     */
    private double traceBeam( double angle ) {
        double distance = 0.0;
        double slope = Math.tan(Math.toRadians(angle));
        double occupied = 0.0;
        // TODO: dx, dy required when this.n is implemented.
        // Would require lots of typecasting
        int dx = 0;
        int dy = 0;
        int i = 0;
        int x = this.left;
        int y = this.back;
        while( occupied <= 0.5){
            y = (int) (slope*(x-this.left)+this.back);
            x = x + i;
            i = i+1;
            try{ 
                occupied = map[x+dx][y+dy];
                //this.map[x][y] = 1;
            } catch (IndexOutOfBoundsException e) {
                break;
            }
        }
        distance = Math.sqrt(Math.pow((this.left-x),2) + Math.pow((this.right-y),2));
        return distance; 
    }
    /**
     * 
     * @param angle
     * @return
     */
    private double[][] setBeam( double angle, double scanDistance, double[][] scanMap ) {
        double distance = 0.0;
        double slope = Math.tan(Math.toRadians(angle));
        double mapValue = -1.0;
        int i = 0;
        int x = this.left;
        int y = this.back;
        while( distance <= scanDistance){
            y = (int) (this.back - slope*(x-this.left));
            x = x + i;
            i = i+1;
            distance = Math.sqrt(Math.pow((this.left-x),2) + Math.pow((this.right-y),2)); 
            try{ 
                mapValue = scanMap[x][y];
                if (mapValue == -1.0 ){
                    scanMap[x][y] = 0.0;
                }
            } catch (ArrayIndexOutOfBoundsException e) {
                /** TODO: Here is where map needs to grow */
                break;
            } 
        }
        scanMap[x-1][y-1] += 1.0;
        return scanMap;
        
    }
    
    
    
    /*
     * 
    function line(x0, y0, x1, y1)
     boolean steep := abs(y1 - y0) > abs(x1 - x0)
     if steep then
         swap(x0, y0)
         swap(x1, y1)
     int deltax := abs(x1 - x0)
     int deltay := abs(y1 - y0)
     int error := deltax / 2
     int ystep
     int y := y0
  
     int inc REM added
     if x0 < x1 then inc := 1 else inc := -1 REM added
 
     if y0 < y1 then ystep := 1 else ystep := -1
     for x from x0 to x1 with increment inc REM changed
         if steep then plot(y,x) else plot(x,y)
         REM increment here a variable to control the progress of the line drawing
         error := error - deltay
         if error < 0 then
             y := y + ystep
             error := error + deltax
     * 
     */
    
    /**
     * Query an X,Y coordinate in the map relative to self.
     * 
     * @param x
     * @param y
     */
    public double query(int x, int y) {
        return this.map[x+this.left][y+this.back];
    }
    /**
     * Query an X,Y coordinate in the map relative to self.
     * 
     * @param x
     * @param y
     */
    private void set(int x, int y, double value) {
        this.map[x+this.left][y+this.back] = value;
    }
    
    /**
     * Query how far is free in given angle.
     * 
     * @param angle
     */
    public double query(double angle) {
        double distance = 0.0;
        distance = this.traceBeam(angle);
        return distance;
    }

    public int getFront() {
        return front;
    }

    public void setFront(int front) {
        this.front = front;
    }

    public int getBack() {
        return back;
    }

    public void setBack(int back) {
        this.back = back;
    }

    public int getRight() {
        return right;
    }

    public void setRight(int right) {
        this.right = right;
    }

    public int getLeft() {
        return left;
    }

    public void setLeft(int left) {
        this.left = left;
    }

    public int getN() {
        return n;
    }

    public void setN(int n) {
        this.n = n;
    }

    public double[][] getMap() {
        return map;
    }

    public void setMap(double[][] map) {
        this.map = map;
    }
    public String printMap(){
        int rows = this.left + this.right;
        int cols = this.back + this.front;
        String cellString = "";
        StringBuilder strBuilder = new StringBuilder(rows*cols);
        for(int i =0; i< rows*cols; i++){
            /* if (this.map[i/rows][i % cols] <= 0.5 ) {
                cellString = "[ ]";
            } else {
                cellString = "[*]";
            } */
            strBuilder.append(this.map[i/rows][i % cols]);
            strBuilder.append(cellString);
            if ( (i+1) % cols == 0 )
                strBuilder.append("\n");   
        }
        return strBuilder.toString();
    }
}

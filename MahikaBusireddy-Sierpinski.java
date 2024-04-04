/*************************************************************************
 *  Compilation:  javac Sierpinski.java
 *  Execution:    java Sierpinski
 *
 *  @author: Mahika Busireddy mb2164@scarletmail.rutgers.edu mb2164
 *
 *************************************************************************/

public class Sierpinski {

    // Height of an equilateral triangle whose sides are of the specified length. 
    public static double height(double length) {
	    double height = (length/2) * Math.sqrt(3);
        return height;
    }

    // Draws a filled equilateral triangle whose bottom vertex is (x, y) 
    // of the specified side length. 
    public static void filledTriangle(double x, double y, double length) {
        double [] array1 = {x - (length/2) , x , x + (length/2)};
        double [] array2 = {y + height(length), y , y + height(length)};
        StdDraw.filledPolygon(array1, array2);
    }

    // Draws a Sierpinski triangle of order n, such that the largest filled 
    // triangle has bottom vertex (x, y) and sides of the specified length. 
    public static void sierpinski(int n, double x, double y, double length) {
        if (n == 0)
            return;
        else {
            filledTriangle(x, y, length);
            sierpinski(n - 1, x + (length/2), y, length/2);
            sierpinski(n - 1, x - (length/2), y, length/2);
            sierpinski(n - 1, x, y + height(length), length/2);
        }
    }

    // Takes an integer command-line argument n; 
    // draws the outline of an equilateral triangle (pointed upwards) of length 1; 
    // whose bottom-left vertex is (0, 0) and bottom-right vertex is (1, 0); and 
    // draws a Sierpinski triangle of order n that fits snugly inside the outline. 
    public static void main(String[] args) {

        int num = Integer.parseInt(args[0]);

        StdDraw.setPenColor(StdDraw.BLACK);

        StdDraw.line(0.0, 0.0, 1.0, 0.0);
        StdDraw.line(0.0 ,0.0 , 0.5 , 0.5 * Math.sqrt(3.0));
        StdDraw.line(0.5, 0.5 * Math.sqrt(3.0) , 1.0 , 0.0);

        double x = 0.5;
        double y = 0.0;
        double length = 1 - (x + y);

        sierpinski(num, x, y, length);
    }
}

package mx.tc.j2se.evaluation;

public class Circle {
    private int radius;

    /**
     * Default constructor
     */
    Circle(){
        radius=1;
    }

    /**
     * Constructor that check exception on the radius
     * @param radius Circle's radius
     */
    Circle(int radius){
        try {
            if (radius < 0)
            {
                throw new IllegalArgumentException();

            }
            this.radius=radius;
        }catch(IllegalArgumentException e){
            System.out.println("value must be non-negative");
        }
    }

    /**
     * Setter that obtain the radius
     * @param radius Circle's radius
     */
    public void setRadius(int radius){
        try{
            if (radius < 0)
            {
                throw new IllegalArgumentException();

            }
            this.radius=radius;
        }catch(IllegalArgumentException e){
            System.out.println("value must be non-negative");
        }

    }

    /**
     * Getter of the Radius
     * @return radius
     */
    public int getRadius(){
        return radius;
    }

    /**
     * Method to calculate the circle area
     * @return the area result
     */
    public double area(){
        double area;
        area=Math.PI*(radius*radius);
        return area;
    }
}

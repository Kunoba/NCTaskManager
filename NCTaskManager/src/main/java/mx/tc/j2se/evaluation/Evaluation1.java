package mx.tc.j2se.evaluation;

/**
 * @author Adrian Ramos Nieves
 */
public class Evaluation1 {
    /**
     * Method that return the index of the biggest circle
     * @param bigCircle an Array of the class Circle
     * @return index of the biggest circle
     */
    public int biggestCircle(Circle[] bigCircle){
        double area=0;
        int index = 0;
        for (int i=0;i<bigCircle.length; i++){
            if(bigCircle[i].area()>area){
                    area=bigCircle[i].area();
                    index=i;
            }
        }
        return index;
    }
    public static void main(String[] args){
        int index;
        Circle circleException=new Circle(-4);
        Circle[] circles=new Circle[5];
        circles[0]=new Circle(1);
        circles[1]=new Circle(16);
        circles[2]=new Circle(8);
        circles[3]=new Circle(2);
        circles[4]=new Circle(12);
        Evaluation1 eval=new Evaluation1();
        index=eval.biggestCircle(circles);
        System.out.println("The radius of the biggest Circle is:"+circles[index].getRadius());
    }
}

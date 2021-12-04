package mx.edu.j2se.aparicio.tasks.evaluation;

public class Evaluation1 {
    public static void main(String[] args) {
        try{
            Circle c1 = new Circle(-1);


        }catch (Exception e){
            //"The given value is not valid for a circle radius"
            System.out.println("The given value is not valid for a circle radius");
        }
        Circle[] cs ={new Circle(6), new Circle(8), new Circle(32), new Circle(9), new Circle(2)};

        Circle c2 = biggestCircle(cs);
        System.out.println(c2.getRadius());
    }
    public static Circle biggestCircle(Circle a[]){
        int in = 0, r = 0;
        Circle b;

        for (int i = 0; i < a.length; i++){
            if(a[i].getRadius() > r){
                r = a[i].getRadius();
                in = i;
            }
        }

        b = a[in];

        return b;
    }

}

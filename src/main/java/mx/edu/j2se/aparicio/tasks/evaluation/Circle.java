package mx.edu.j2se.aparicio.tasks.evaluation;

public class Circle {
    private int radius;

    Circle (){
        setRadius(1);
    }
    Circle (int rad) throws IllegalArgumentException{
        if (rad > 0){
            setRadius(rad);
        }else{
            throw new IllegalArgumentException(
                    "The given value is invalid"
            );
        }
    }

    public void setRadius(int r) throws IllegalArgumentException{
        if (r > 0){
            radius = r;
        }else{
            throw new IllegalArgumentException(
                    "The given value is invalid"
            );
        }
    }
    public int getRadius(){
        return radius;
    }
    public double getArea(){
        double a = radius * Math.PI;

        return a;
    }

}

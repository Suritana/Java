package geometry2d;

import exceptions.InvalidArgumentException;

public class Circle implements Figure{
    private double radius;

    public Circle(double radius)throws InvalidArgumentException {
        if(radius<=0){
            throw new InvalidArgumentException("Радиус должен быть больше нуля");
        }
        this.radius=radius;
    }

    @Override
    public double area(){
        return Math.PI*radius*radius;
    }

    @Override
    public double perimetr(){
        return Math.PI*2*radius;
    }

    @Override
    public String toString(){
        return "круг с радиусом - " + radius;
    }


}

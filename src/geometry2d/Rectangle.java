package geometry2d;

import exceptions.InvalidArgumentException;

public class Rectangle implements Figure{
    private double side;
    private double hight;

    public Rectangle(double side, double hight)throws InvalidArgumentException {
        if (side<=0){
            throw new InvalidArgumentException("Сторона должна быть больше нуля");
        }
        if (hight<=0) {
            throw new InvalidArgumentException("Высота должна быть больше нуля");
        }
        this.side=side;
        this.hight=hight;

    }

    @Override
    public double area(){
        return side*hight/2 ;
    }

    @Override
    public double perimetr(){
        return side*side*side;
    }

    @Override
    public String toString() {
        return "треугольник со стороной = " + side + " и высотой = " + hight;
    }

}

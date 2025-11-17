package geometry3d;

import exceptions.InvalidArgumentException;
import exceptions.ZeroVolumeException;
import geometry2d.Figure;


public class Cylinder {
    private Figure base;
    private double hight;

    public Cylinder(Figure base , double hight) throws InvalidArgumentException {

        if (hight<=0){
            throw new InvalidArgumentException("Высота должна быть больше нуля");
        }
        this.hight=hight;
        this.base=base;
    }


    public double volume() throws ZeroVolumeException {
        double volume = base.area() * hight;
        if (volume==0){
            throw new ZeroVolumeException("Volume должен быть не равен нулю");
        }
        return volume;
    }

    @Override
    public String toString(){
        return "цилиндр с высотой = " + hight + " и фигурой " + base;
    }
}


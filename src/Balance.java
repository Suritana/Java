import java.util.Scanner;

public class Balance {
    private int weightCountRight;
    private int weightCountLeft;

    public Balance() {
        weightCountLeft = 0;
        weightCountRight = 0;
    }

    void addRight(int weight){
        weightCountRight += weight;
        System.out.println("Итоговый вес правой чашы: " + weightCountRight);
    }

    void addleft(int weight){
        weightCountLeft += weight;
        System.out.println("Итоговый вес левой чашы: " + weightCountLeft);
    }


    void Result() {
        if (weightCountLeft == weightCountRight) {
            System.out.println("=");
        } else if (weightCountRight > weightCountLeft) {
            System.out.println("R");
        } else {
            System.out.println("L");
        }

    }


}

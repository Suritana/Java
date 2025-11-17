
import java.util.ArrayList;
import java.util.List;

public class OddEvenSeparator {
    private List<Integer> even = new ArrayList<>();
    private List<Integer> odd = new ArrayList<>();

    void showEven(){
        System.out.println("Четные числа:" + even);
    }
    void showOdd(){
        System.out.println("Нечетные числа:" + odd);
    }

    void addNumber(int number){
        if (number % 2 == 0){
            even.add(number);
        }
        else{
            odd.add(number);
        }
    }





}

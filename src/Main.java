import geometry2d.*;
import geometry3d.*;
import exceptions.ZeroVolumeException;
import exceptions.InvalidArgumentException;

public class Main {
    public static void main(String[] args) {
        Button button = new Button();
        button.click();
        button.click();
        button.click();

        Balance balance = new Balance();
        balance.addleft(10);
        balance.addRight(5);
        balance.Result();

        Bell bell = new Bell();
        bell.doBell();
        bell.doBell();
        bell.doBell();
        bell.doBell();

        OddEvenSeparator oddEvenSeparator = new OddEvenSeparator();
        oddEvenSeparator.addNumber(2);
        oddEvenSeparator.addNumber(3);
        oddEvenSeparator.addNumber(4);
        oddEvenSeparator.addNumber(5);
        oddEvenSeparator.showEven();
        oddEvenSeparator.showOdd();

        Table table = new Table(4,6);
        System.out.println(table.getValue(3,4));
        table.setValue(3,4,5);

        System.out.println(table.toString());
        System.out.println(table.average());
        System.out.println(table.rows());
        System.out.println(table.cols());

        try {
            Circle circle = new Circle(3);
            circle.area();
            System.out.println(circle);
            Rectangle rectangle = new Rectangle(4, 5);
            rectangle.area();
            System.out.println(rectangle);

            Cylinder cylinder = new Cylinder(circle, 5);
            System.out.println(cylinder.volume());
            System.out.println(cylinder);

        } catch (ZeroVolumeException | InvalidArgumentException message) {
            System.out.println(message.getMessage());
        }

        FileAnalyzer fileAnalyzer = new FileAnalyzer();
        fileAnalyzer.analyze("Java\\analyz");
        fileAnalyzer.printAnalysis("Java\\analyz");
    }
}
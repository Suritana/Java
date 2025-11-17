public class Button {
    private int clickCount;

    public Button() {
        clickCount = 0;
    }

    void click() {
        clickCount++;
        System.out.println("Количество нажатий: " + clickCount);
    }

}
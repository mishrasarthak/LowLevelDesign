package PrintMode;

public class PrintToConsole implements IPrint {
    @Override
    public void printData(String data) {
        System.out.println(data);
    }
}

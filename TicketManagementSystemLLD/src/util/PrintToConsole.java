package util;

public class PrintToConsole implements IPrintUtil {
    @Override
    public void print(String message) {
        System.out.println(message);
        System.out.println();
    }
}

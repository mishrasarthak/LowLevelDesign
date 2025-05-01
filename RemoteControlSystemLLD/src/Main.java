import Command.LightOfCommand;
import Command.LightOnCommand;
import Invoker.RemoteControl;
import Recievers.Light;

public class Main {
    public static void main(String[] args) {

        RemoteControl remote = new RemoteControl();
        Light light = new Light();

        LightOnCommand lightOn = new LightOnCommand(light);
        LightOfCommand lightOff = new LightOfCommand(light);

        remote.setCommand(lightOn);
        remote.pressButton(); // Light is ON

        remote.setCommand(lightOff);
        remote.pressButton(); // Light is OFF
        remote.pressBack(); // undo
    }
}
package Command;

import Recievers.Light;

public class LightOfCommand implements ICommand{
    Light light;

    public LightOfCommand(Light light){
        this.light = light;
    }

    @Override
    public void execute() {
        light.off();
    }

    @Override
    public void undo() {
        light.on();
    }
}

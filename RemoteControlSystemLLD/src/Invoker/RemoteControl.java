package Invoker;

import Command.ICommand;

public class RemoteControl {

    ICommand command;

    public RemoteControl() {
        this.command = null;
    }

    public void setCommand(ICommand command) {
        this.command = command;
    }

    public void pressButton() {
        if (command != null) {
            command.execute();
        } else {
            System.out.println("No command set.");
        }
    }

    public void pressBack() {
        if (command != null) {
            command.undo();
        } else {
            System.out.println("No command set.");
        }
    }
}

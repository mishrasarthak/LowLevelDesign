package Recievers;

public class Light {
    private boolean isOn;

    public Light(){
        this.isOn = false;
    }

    public void on(){
        isOn = true;
        System.out.println("Light is ON");
    }

    public void off(){
        isOn = false;
        System.out.println("Light is OFF");
    }
}

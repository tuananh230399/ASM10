package model;

public class Wheather {
    private String DateTime;
    private int WheatherIcon;
    private String IconPhrase;
    private Temperature Temperature;

    public String getDateTime() {
        return DateTime;
    }

    public void setDateTime(String dateTime) {
        DateTime = dateTime;
    }

    public int getWheatherIcon() {
        return WheatherIcon;
    }

    public void setWheatherIcon(int wheatherIcon) {
        WheatherIcon = wheatherIcon;
    }

    public String getIconPhrase() {
        return IconPhrase;
    }

    public void setIconPhrase(String iconPhrase) {
        IconPhrase = iconPhrase;
    }

    public model.Temperature getTemperature() {
        return Temperature;
    }

    public void setTemperature(model.Temperature temperature) {
        Temperature = temperature;
    }
}

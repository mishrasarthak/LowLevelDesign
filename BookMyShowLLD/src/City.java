import java.util.List;

public class City {
    int cityId;
    String cityName;
    String state;
    List<Integer> pinCodes;

    public int getCityId() {
        return cityId;
    }

    public void setCityId(int cityId) {
        this.cityId = cityId;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public List<Integer> getPinCodes() {
        return pinCodes;
    }

    public void setPinCodes(List<Integer> pinCodes) {
        this.pinCodes = pinCodes;
    }
}

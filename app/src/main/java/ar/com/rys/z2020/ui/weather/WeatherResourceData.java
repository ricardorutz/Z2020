package ar.com.rys.z2020.ui.weather;

public class WeatherResourceData {

    private int imagesResource;
    private String dateNameAndNumber;
    private int temperature;
    private int historicTemperature;


    public String getHistoricTemperature() {
        return String.valueOf(historicTemperature);
    }

    public void setHistoricTemperature(int historicTemperature) {
        this.historicTemperature = historicTemperature;
    }

    public String getTemperature() {
        return String.valueOf(temperature);
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public String getImagesResource() {
        return String.valueOf(imagesResource);
    }

    public void setImagesResource(int imagesResource) {
        this.imagesResource = imagesResource;
    }

    public String getDateNameAndNumber() {
        return String.valueOf(dateNameAndNumber);
    }

    public void setDateNameAndNumber(String dateNameAndNumber) {
        this.dateNameAndNumber = dateNameAndNumber;
    }

}

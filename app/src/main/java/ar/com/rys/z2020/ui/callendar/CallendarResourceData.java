package ar.com.rys.z2020.ui.callendar;

public class CallendarResourceData {

    private int imagesResource;
    private String dateNameAndNumber;
    private String temperature;
    private String historicTemperature;


    public String getHistoricTemperature() {
        return String.valueOf(historicTemperature);
    }

    public void setHistoricTemperature(String historicTemperature) {
        this.historicTemperature = historicTemperature;
    }

    public String getTemperature() {
        return String.valueOf(temperature);
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public int getImagesResource() {
        return this.imagesResource;
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

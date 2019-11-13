package ar.com.rys.z2020.ui.weather;

import android.content.Context;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import ar.com.rys.z2020.R;

public class WeatherStaticDataDeclaration {

    private Context context;

    public WeatherStaticDataDeclaration(Context c){
        context=c;
    }

    private LinkedHashMap<String, List<WeatherResourceData>> allData = new LinkedHashMap<>();
    private List<WeatherResourceData> smaResourcesData = new ArrayList<>();
    private List<WeatherResourceData> bsasResourcesData = new ArrayList<>();

    private  static Integer[] imagesStringSma = {
            R.drawable.ic_cloud_sun_solid,
            R.drawable.ic_cloud_showers_heavy_solid,
            R.drawable.ic_cloud_sun_solid,
            R.drawable.ic_cloud_sun_solid,
            R.drawable.ic_cloud_showers_heavy_solid,
            R.drawable.ic_cloud_sun_solid,
            R.drawable.ic_cloud_sun_solid,
            R.drawable.ic_cloud_sun_solid,
            R.drawable.ic_cloud_sun_rain_solid,
            R.drawable.ic_cloud_sun_solid,
    };

    private  static Integer[] imagesStringBsAs = {
            R.drawable.ic_cloud_sun_rain_solid,
            R.drawable.ic_cloud_sun_solid,
            R.drawable.ic_cloud_sun_solid,
            R.drawable.ic_cloud_sun_solid,
            R.drawable.ic_cloud_sun_solid,
            R.drawable.ic_cloud_sun_solid,
            R.drawable.ic_cloud_sun_solid,
            R.drawable.ic_cloud_sun_solid,
            R.drawable.ic_cloud_sun_solid,
            R.drawable.ic_cloud_sun_solid,
    };

    private  static int[] namesAndNumberOfDates = {
            R.string.date_1,
            R.string.date_2,
            R.string.date_3,
            R.string.date_4,
            R.string.date_5,
            R.string.date_6,
            R.string.date_7,
            R.string.date_8,
            R.string.date_9,
            R.string.date_10
    };

    private  static int[] historicTemperaturesSma = {
            R.string.h_temperature_sm__1,
            R.string.h_temperature_sm__2,
            R.string.h_temperature_sm__3,
            R.string.h_temperature_sm__4,
            R.string.h_temperature_sm__5,
            R.string.h_temperature_sm__6,
            R.string.h_temperature_sm__7,
            R.string.h_temperature_sm__8,
            R.string.h_temperature_sm__9,
            R.string.h_temperature_sm__10
    };

    private  static int[] historicTemperaturesBsAs = {
            R.string.h_temperature_bsas_1,
            R.string.h_temperature_bsas_2,
            R.string.h_temperature_bsas_3,
            R.string.h_temperature_bsas_4,
            R.string.h_temperature_bsas_5,
            R.string.h_temperature_bsas_6,
            R.string.h_temperature_bsas_7,
            R.string.h_temperature_bsas_8,
            R.string.h_temperature_bsas_9,
            R.string.h_temperature_bsas_10
    };

    private  static int[] temperaturesSma = {
            R.string.temperature_sm__1,
            R.string.temperature_sm__2,
            R.string.temperature_sm__3,
            R.string.temperature_sm__4,
            R.string.temperature_sm__5,
            R.string.temperature_sm__6,
            R.string.temperature_sm__7,
            R.string.temperature_sm__8,
            R.string.temperature_sm__9,
            R.string.temperature_sm__10
    };

    private  static int[] temperaturesBsAs = {
            R.string.temperature_bsas_1,
            R.string.temperature_bsas_2,
            R.string.temperature_bsas_3,
            R.string.temperature_bsas_4,
            R.string.temperature_bsas_5,
            R.string.temperature_bsas_6,
            R.string.temperature_bsas_7,
            R.string.temperature_bsas_8,
            R.string.temperature_bsas_9,
            R.string.temperature_bsas_10
    };


    private void loadData(){


        if(CollectionUtils.isEmpty(smaResourcesData)){
            for (int i = 0; i< imagesStringSma.length; i++){
                smaResourcesData.add(generateResourceData(i, imagesStringSma, temperaturesSma, historicTemperaturesSma));
            }
        }

        if(CollectionUtils.isEmpty(bsasResourcesData)){
            for (int i = 0; i< imagesStringBsAs.length; i++){
                bsasResourcesData.add(generateResourceData(i, imagesStringBsAs, temperaturesBsAs, historicTemperaturesBsAs));
            }
        }

        allData.put(context.getString(R.string.title_sma), smaResourcesData);
        allData.put(context.getString(R.string.title_bsas), bsasResourcesData);

    }

    private WeatherResourceData generateResourceData(int i, Integer[] imagesString, int[] temperatures, int[] historicTemperatures){

        WeatherResourceData weatherResourceData = new WeatherResourceData();
        weatherResourceData.setImagesResource(imagesString[i]);
        weatherResourceData.setDateNameAndNumber(context.getString(namesAndNumberOfDates[i]));
        weatherResourceData.setTemperature(context.getString(temperatures[i]));
        weatherResourceData.setHistoricTemperature(context.getString(historicTemperatures[i]));

        return weatherResourceData;

    }


    public LinkedHashMap<String, List<WeatherResourceData>> getMap(){

        if(allData.isEmpty()){
            loadData();
        }

        return  allData;
    }

}
package ar.com.rys.z2020.ui.callendar;

import android.content.Context;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import ar.com.rys.z2020.R;

public class CallendarStaticDataDeclaration {

    private Context context;

    public CallendarStaticDataDeclaration(Context c){
        context=c;
    }

    private LinkedHashMap<String, List<CallendarResourceData>> allData = new LinkedHashMap<>();
    private List<CallendarResourceData> dicemberRecourceData = new ArrayList<>();
    private List<CallendarResourceData> januaryResourcesData = new ArrayList<>();
    private int januaryStartsOn = 4;
    private int init = 1;
    private int end = 31;
    private int largeOfDateMatrix = 35;


    private  static Integer[] namesOfDates = {
            R.string.date_niedz,
            R.string.date_pon,
            R.string.date_wt,
            R.string.date_sr,
            R.string.date_csz,
            R.string.date_pt,
            R.string.date_sob,
    };


    private void loadData(){


        if(CollectionUtils.isEmpty(dicemberRecourceData)){
            for (int i = 0; i< namesOfDates.length; i++){
                dicemberRecourceData.add(generateResourceData(i, namesOfDates));
            }

            for (int i = init; i<= end; i++){
                dicemberRecourceData.add(generateResourceData(i));
            }

            if(dicemberRecourceData.size()<largeOfDateMatrix){
                dicemberRecourceData.add(generateEmptyResourceData());
            }
        }

        if(CollectionUtils.isEmpty(januaryResourcesData)){
            for (int i = 0; i< namesOfDates.length; i++){
                januaryResourcesData.add(generateResourceData(i, namesOfDates));
            }

            for (int i = init; i<= end; i++){
                januaryResourcesData.add(generateResourceData(i));
            }
        }

        allData.put(context.getString(R.string.title_diciembre), dicemberRecourceData);
        allData.put(context.getString(R.string.title_enero), januaryResourcesData);

    }

    private CallendarResourceData generateResourceData(int i, Integer[] imagesString){

        CallendarResourceData callendarResourceData = new CallendarResourceData();
        //callendarResourceData.setImagesResource(imagesString[i]);
        callendarResourceData.setDateNameAndNumber(context.getString(namesOfDates[i]));

        return callendarResourceData;

    }

    private CallendarResourceData generateResourceData(int numOfDay){

        CallendarResourceData callendarResourceData = new CallendarResourceData();
        callendarResourceData.setDateNameAndNumber(String.valueOf(numOfDay));

        return callendarResourceData;

    }

    private CallendarResourceData generateEmptyResourceData(){

        CallendarResourceData callendarResourceData = new CallendarResourceData();
        callendarResourceData.setDateNameAndNumber("");

        return callendarResourceData;

    }


    public LinkedHashMap<String, List<CallendarResourceData>> getMap(){

        if(allData.isEmpty()){
            loadData();
        }

        return  allData;
    }

}
package ar.com.rys.z2020.ui.callendar;

import android.content.Context;

import org.apache.commons.collections4.CollectionUtils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import ar.com.rys.z2020.R;

public class CallendarStaticDataDeclaration {

    private Context context;
    private LinkedHashMap<String, List<CallendarResourceData>> allData = new LinkedHashMap<>();
    private List<CallendarResourceData> decemberResourcesData = new ArrayList<>();
    private List<CallendarResourceData> januaryResourcesData = new ArrayList<>();
    private Set<Integer> greenNumberDecemberDates;
    private Set<Integer> greenNumberJanuaryDates;
    private Map<String, Set<Integer>> greenMap;

    private int januaryStartsOn = 3;
    private int init = 1;
    private int end = 31;
    private int largeOfDateMatrix = 42;

    public CallendarStaticDataDeclaration(Context c){

        context=c;
        this.greenNumberDecemberDates = new HashSet<>();
        Collections.addAll(greenNumberDecemberDates, 30, 31);
        this.greenNumberJanuaryDates = new HashSet<>();
        Collections.addAll(greenNumberJanuaryDates, 1, 2, 3, 4, 5, 6, 7, 8);
        greenMap = new HashMap<>();
        greenMap.put(context.getString(R.string.title_diciembre), greenNumberDecemberDates);
        greenMap.put(context.getString(R.string.title_enero), greenNumberJanuaryDates);

    }


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

        generateDecemberData();

        generateJanuaryData();


        allData.put(context.getString(R.string.title_diciembre), decemberResourcesData);
        allData.put(context.getString(R.string.title_enero), januaryResourcesData);

    }

    private CallendarResourceData generateResourceData(int i, Integer[] namesOfDates){

        CallendarResourceData callendarResourceData = new CallendarResourceData();
        callendarResourceData.setDateNameAndNumber(context.getString(namesOfDates[i]));
        callendarResourceData.setImagesResource(0xFF3F51B5);

        return callendarResourceData;

    }

    private CallendarResourceData generateResourceData(int numOfDay, String mes){

        CallendarResourceData callendarResourceData = new CallendarResourceData();
        callendarResourceData.setDateNameAndNumber(String.valueOf(numOfDay));



        if(greenMap.get(mes).contains(numOfDay)){
            callendarResourceData.setImagesResource(0XFF4CAF50);
        }

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


    private void generateDecemberData(){

        if(CollectionUtils.isEmpty(decemberResourcesData)){
            for (int i = 0; i< namesOfDates.length; i++){
                decemberResourcesData.add(generateResourceData(i, namesOfDates));
            }

            for (int i = init; i<= end; i++){
                decemberResourcesData.add(generateResourceData(i, context.getString(R.string.title_diciembre)));
            }

            while (decemberResourcesData.size()<largeOfDateMatrix){
                decemberResourcesData.add(generateEmptyResourceData());
            }

        }
    }

    private void generateJanuaryData(){

        if(CollectionUtils.isEmpty(januaryResourcesData)){


            for (int i = 0; i< namesOfDates.length; i++){
                januaryResourcesData.add(generateResourceData(i, namesOfDates));
            }

            for (int i = 0; i< januaryStartsOn; i++){
                januaryResourcesData.add(generateEmptyResourceData());
            }

            for (int i = init; i<= end; i++){
                januaryResourcesData.add(generateResourceData(i, context.getString(R.string.title_enero)));
            }

            while (januaryResourcesData.size()<largeOfDateMatrix){
                januaryResourcesData.add(generateEmptyResourceData());
            }
        }
    }
}
package com.y.md.dustmvp.parser;

import com.y.md.dustmvp.common.Constants;
import com.y.md.dustmvp.data.Dust;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by prompt32 on 2017-04-27.
 */

public class JSONParserHelper implements Constants {

    public List<Dust> parseDustList(JSONObject response) {
        List<Dust> dustList;
        try {
            JSONObject jsonRealTimeCityAir = response.getJSONObject(JSON_PARAM_REALTIMECITYAIR);
            int totalCount = jsonRealTimeCityAir.getInt(JSON_PARAM_LISTTOTALCOUNT);
            String resultCode = jsonRealTimeCityAir.getJSONObject(JSON_PARAM_RESULT).getString(JSON_PARAM_CODE);
            String resultMessage = jsonRealTimeCityAir.getJSONObject(JSON_PARAM_RESULT).getString(JSON_PARAM_MESSAGE);

            JSONArray jsonRows = jsonRealTimeCityAir.getJSONArray(JSON_PARAM_ROW);
            if(jsonRows != null && jsonRows.length() > 0) {
                dustList = new ArrayList<>();
                for (int i=0; i<jsonRows.length(); i++) {
                    Dust dust = new Dust();
                    JSONObject jsonRow = jsonRows.getJSONObject(i);
                    dust.setMeasureDate(jsonRow.getString(JSON_PARAM_MEASURE_DATE));
                    dust.setLocation(jsonRow.getString(JSON_PARAM_LOCATION));
                    dust.setMeasureLocation(jsonRow.getString(JSON_PARAM_MEASURELOCATION));
                    dust.setMicroDust(jsonRow.getInt(JSON_PARAM_MICRO_DUST));
                    dust.setUltraMicroDust(jsonRow.getInt(JSON_PARAM_ULTRAMICRODUST));
                    dust.setO3(jsonRow.getLong(JSON_PARAM_O3));
                    dust.setNO2(jsonRow.getLong(JSON_PARAM_NO2));
                    dust.setCO(jsonRow.getLong(JSON_PARAM_CO));
                    dust.setSO2(jsonRow.getLong(JSON_PARAM_SO2));
                    dust.setEnvRating(jsonRow.getString(JSON_PARAM_ENVRATING));
                    dust.setEnvIndex(jsonRow.getInt(JSON_PARAM_ENVINDEX));
                    dust.setMaterial(jsonRow.getString(JSON_PARAM_MATERIAL));

                    dustList.add(dust);
                }
                return dustList;
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}

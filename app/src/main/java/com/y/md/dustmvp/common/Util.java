package com.y.md.dustmvp.common;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by prompt32 on 2017-04-27.
 */

public class Util {

    public String changeDateFormat(String date) {
        SimpleDateFormat originalFormat = new SimpleDateFormat("yyyyMMddHHmm");
        SimpleDateFormat newFormat = new SimpleDateFormat("yyyy년 MM월 dd일 HH시 mm분");
        try {
            Date originalDate = originalFormat.parse(date);
            return newFormat.format(originalDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return "";
    }
}

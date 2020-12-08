package com.hr.api.config;

import org.springframework.core.convert.converter.Converter;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * 日期转换器
 * @author echo lovely
 * @date 2020/12/8 11:09
 */

public class DateInterceptor  implements Converter<String, Date> {

    @Override
    public Date convert(String s) {

        List<DateFormat> dateList = new ArrayList<>();
        dateList.add(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
        dateList.add(new SimpleDateFormat("yyyy-MM-dd"));
        dateList.add(new SimpleDateFormat("yyyy/MM/dd HH:mm:ss"));
        dateList.add(new SimpleDateFormat("yyyy/MM/dd"));

        Date date;
        for (DateFormat dateFormat : dateList) {
            try {
                // 支持 -- // ..日期格式的转换
                date = dateFormat.parse(s);
                System.out.println("============date===============" + date);
                return date;
            } catch (ParseException e) {
                // e.printStackTrace();
            }
        }

        return null;
    }


}

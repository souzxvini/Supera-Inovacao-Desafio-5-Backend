package br.com.banco.util;

import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@NoArgsConstructor
public class DateUtil {

    public static LocalDate toLocalDate(String value, String format){
        return LocalDate.parse(value, DateTimeFormatter.ofPattern(format));
    }


}

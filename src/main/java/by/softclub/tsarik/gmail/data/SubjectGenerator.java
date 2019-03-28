package by.softclub.tsarik.gmail.data;

import java.text.SimpleDateFormat;
import java.util.Date;

public class SubjectGenerator {

    public static String subjectGenerate() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return sdfDate.format(new Date());
    }
}
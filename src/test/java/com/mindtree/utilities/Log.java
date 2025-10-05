package com.mindtree.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.log4j.FileAppender;

public class Log extends FileAppender {

    @Override
    public void setFile(String file) {
        if (file.contains("%timestamp")) {
            SimpleDateFormat date = new SimpleDateFormat("yyyy_MM_dd_HH_mm_ss");
            file = file.replace("%timestamp", date.format(new Date()));
        }
        super.setFile(file);
    }
}

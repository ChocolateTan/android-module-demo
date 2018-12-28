package com.demo.sdk.common_base.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class CommonUtil {
  public static String getTime(long time, String format) {
    SimpleDateFormat simpleDateFormat = new SimpleDateFormat(format);
    return simpleDateFormat.format(new Date(time));
  }
}

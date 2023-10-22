package com.hunter.ricegrow.Activity.Setting;

import android.content.Context;
import android.content.res.Configuration;

import java.util.Locale;

public class GetCurrentLanguage {
    public static String getCurrentLanguage(Context context){
        Configuration configuration = context.getResources().getConfiguration();
        Locale currentLocale = configuration.getLocales().get(0);
        return currentLocale.getLanguage();
    }
}

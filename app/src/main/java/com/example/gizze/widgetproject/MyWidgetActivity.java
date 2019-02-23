package com.example.gizze.widgetproject;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

import java.util.Calendar;

public class MyWidgetActivity extends AppWidgetProvider {

    static void updateAppWidget(Context context, AppWidgetManager appWidgetManager,
                                int appWidgetId) {

        Calendar calendar = Calendar.getInstance();
        int today;
        CharSequence gununyemegi ="..";
        CharSequence tarih="..";
        today=calendar.get(Calendar.DAY_OF_MONTH);

        if(today==25){
            tarih="25.02.2019";
            gununyemegi=context.getString(R.string.yemek1);
        }
        if(today==26){
            tarih="26.02.2019";
            gununyemegi=context.getString(R.string.yemek2);
        }
        if(today==27){
            tarih="27.02.2019";
            gununyemegi=context.getString(R.string.yemek3);
        }
        if(today==28){
            tarih="28.02.2019";
            gununyemegi=context.getString(R.string.yemek4);
        }

        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.my_widget_activity);
        views.setTextViewText(R.id.textView4,tarih);
        views.setTextViewText(R.id.textView5,gununyemegi);


        Intent intentUpdate = new Intent(context, MyWidgetActivity.class);
        intentUpdate.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
        int[] idArray = new int[]{appWidgetId};
        intentUpdate.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, idArray);
        PendingIntent pendingUpdate = PendingIntent.getBroadcast(context,
                appWidgetId, intentUpdate, PendingIntent.FLAG_UPDATE_CURRENT);

        views.setOnClickPendingIntent(R.id.button, pendingUpdate);
        appWidgetManager.updateAppWidget(appWidgetId, views);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        for (int appWidgetId : appWidgetIds) {
            updateAppWidget(context, appWidgetManager, appWidgetId);
        }
    }
}


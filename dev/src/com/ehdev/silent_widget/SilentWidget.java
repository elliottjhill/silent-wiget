package com.ehdev.silent_widget;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

/**
 * This is an app widget provider that specifies the Widget to silence / unsilence the current phone
 * 
 * @author Elliott
 *
 */
public class SilentWidget extends AppWidgetProvider {

	@Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        final int N = appWidgetIds.length;
        
        // Perform this loop procedure for each App Widget that belongs to this provider
        for (int i=0; i<N; i++) {
            int appWidgetId = appWidgetIds[i];
                   
            // Create silent pending intent
            Intent intent = new Intent();
            intent.setAction(SilentReceiver.LOUD_ACTION);
            intent.setClassName(SilentReceiver.class.getPackage().getName(), SilentReceiver.class.getName());

            PendingIntent pendingIntent = PendingIntent.getBroadcast(context.getApplicationContext(), 0, intent, 
            		PendingIntent.FLAG_CANCEL_CURRENT);

            
            // Get the layout for the App Widget and attach an on-click listener
            // to the button
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_silence_phone);
            views.setOnClickPendingIntent(R.id.widget_loud, pendingIntent);
            
            intent = new Intent();
            intent.setAction(SilentReceiver.SILENT_ACTION);
            intent.setClassName(SilentReceiver.class.getPackage().getName(), SilentReceiver.class.getName());

            pendingIntent = PendingIntent.getBroadcast(context.getApplicationContext(), 0, intent,
            		PendingIntent.FLAG_CANCEL_CURRENT);

            views.setOnClickPendingIntent(R.id.widget_silence, pendingIntent);
            // Tell the AppWidgetManager to perform an update on the current app widget
            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }
}
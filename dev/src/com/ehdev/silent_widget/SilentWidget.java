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
            PendingIntent pendingIntent = PendingIntent.getBroadcast(context.getApplicationContext(), 0, intent, 
            		PendingIntent.FLAG_CANCEL_CURRENT);
            RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_silence_phone);
            intent.setAction(SyncReceiver.SYNC_ACTION);
            intent.setClassName(SyncReceiver.class.getPackage().getName(), SyncReceiver.class.getName());

           
            // Get the layout for the App Widget and attach an on-click listener
            // to the button
            views.setOnClickPendingIntent(R.id.widget_sync, pendingIntent);
            
            intent = new Intent();
            intent.setAction(SilentReceiver.SILENT_ACTION);
            intent.setClassName(SilentReceiver.class.getPackage().getName(), SilentReceiver.class.getName());

            pendingIntent = PendingIntent.getBroadcast(context.getApplicationContext(), 0, intent,
            		PendingIntent.FLAG_CANCEL_CURRENT);

            views.setOnClickPendingIntent(R.id.widget_volume, pendingIntent);
            // Tell the AppWidgetManager to perform an update on the current app widget
            appWidgetManager.updateAppWidget(appWidgetId, views);
        }
    }
}
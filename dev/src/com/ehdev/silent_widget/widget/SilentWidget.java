package com.ehdev.silent_widget.widget;

import com.ehdev.silent_widget.R;

import android.app.PendingIntent;
import android.appwidget.AppWidgetManager;
import android.appwidget.AppWidgetProvider;
import android.content.Context;
import android.content.Intent;
import android.widget.RemoteViews;

public class SilentWidget extends AppWidgetProvider {

	@Override
	public void onUpdate(Context context, AppWidgetManager appWidgetManager,
			int[] appWidgetIds) {
		 // Create an Intent to launch ExampleActivity
        Intent intent = new Intent(context, SilentWidget.class);
        PendingIntent pendingIntent = PendingIntent.getActivity(context, 0, intent, 0);

        // Get the layout for the App Widget and attach an on-click listener
        // to the button
        RemoteViews views = new RemoteViews(context.getPackageName(), R.layout.widget_silent_widget);
        views.setOnClickPendingIntent(R.id.silent_button, pendingIntent);
	}
}

package com.gransoft.geoapp.geofence;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.google.android.gms.location.Geofence;
import com.google.android.gms.location.GeofencingEvent;
import com.gransoft.geoapp.MainActivity;
import com.gransoft.geoapp.MyDatabaseHelper;

public class GeofenceBroadcastReceiver extends BroadcastReceiver {

    private static final String TAG = "GeofenceBroadcastReceiver";
    private static String msg = "";
    private static String messageBody = "";

    @Override
    public void onReceive(Context context, Intent intent) {
        GeofencingEvent geofencingEvent = GeofencingEvent.fromIntent(intent);
        int transition = geofencingEvent.getGeofenceTransition();
        if (transition == Geofence.GEOFENCE_TRANSITION_ENTER){
            msg = "Enter";
            messageBody = "You are entering into home zone";
        } else if (transition == Geofence.GEOFENCE_TRANSITION_EXIT){
            msg = "Exit";
            messageBody = "You are exiting from home zone";
        }

        Log.d(TAG, messageBody);
        NotificationHelper notificationHelper = new NotificationHelper(context);
        notificationHelper.sendHighPriorityNotification(msg, messageBody, MainActivity.class);

        MyDatabaseHelper db = new MyDatabaseHelper(context);
        db.addBook(msg, messageBody, 1);
    }
}
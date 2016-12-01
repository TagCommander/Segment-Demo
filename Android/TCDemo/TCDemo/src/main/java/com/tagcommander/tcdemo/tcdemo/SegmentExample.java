package com.tagcommander.tcdemo.tcdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;
import com.tagcommander.lib.core.TCDebug;
import com.tagcommander.lib.segment.TCSConstants;
import com.tagcommander.lib.segment.TCSegment;

public class SegmentExample extends BroadcastReceiver
{
    MainActivity main;

    /**
     * Here we initialize the Segment module. We need to context of the application for the module to
     * work, but here we instead pass the whole activity class. We use it to print the segment list
     * afterward.
     *
     * The parameters to initialize are *mandatory*, we need your siteID, the application context and the authentication token.
     *
     * In this example we use the simplest way to get back the segments which is registering to
     * the Segment Available notification. The module will send it when it will have received a
     * valid list of segment and parsed it.
     *
     * @param mainActivity a pointer to the class managing the fragments.
     */
    public void initializeSegmentation(MainActivity mainActivity)
    {
        main = mainActivity;
        TCDebug.setDebugLevel(Log.VERBOSE);
        TCDebug.setNotificationLog(true);
        TCSegment.getInstance().setSiteIDAppContextAndToken(3311, main.getApplicationContext(), "e2032376eca5533858b7d6616d40802be54d221db1b75e1b");

        LocalBroadcastManager broadcastManager = LocalBroadcastManager.getInstance(main.getApplicationContext());
        broadcastManager.registerReceiver(this, new IntentFilter(TCSConstants.kTCNotification_SegmentAvailable));
    }

    @Override
    public void onReceive(Context context, Intent intent)
    {
        String intentName = intent.getAction();

        if (intentName == null)
        {
            return;
        }

        if (intentName.equals(TCSConstants.kTCNotification_SegmentAvailable))
        {
            main.printSegment(TCSegment.getInstance().getSegmentList().toString());
        }
    }
}

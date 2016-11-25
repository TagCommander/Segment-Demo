package com.tagcommander.tcdemo.tcdemo;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v4.content.LocalBroadcastManager;
import android.util.Log;

import com.tagcommander.lib.core.TCCoreConstants;
import com.tagcommander.lib.core.TCDebug;
import com.tagcommander.lib.segment.TCSConstants;
import com.tagcommander.lib.segment.TCSegment;

public class SegmentExample extends BroadcastReceiver
{
    public void initializeSegmentation(Context appContext)
    {
        TCDebug.setDebugLevel(Log.VERBOSE);
        TCDebug.setNotificationLog(true);
        TCSegment.getInstance().setSiteIDAppContextAndToken(3107, appContext, "myToken");

        LocalBroadcastManager broadcastManager = LocalBroadcastManager.getInstance(appContext);
        broadcastManager.registerReceiver(this, new IntentFilter(TCCoreConstants.kTCNotification_SegmentResponse));
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

        }
    }
}

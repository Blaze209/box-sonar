package com.microsoft.identity.common.internal.util;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import com.microsoft.identity.common.java.flighting.CommonFlight;
import com.microsoft.identity.common.java.flighting.CommonFlightsManager;
import com.microsoft.identity.common.logging.Logger;
import com.microsoft.intune.mam.client.content.pm.MAMPackageManagement;
import java.util.function.Predicate;

/* JADX INFO: loaded from: classes14.dex */
public class WorkProfileUtil {
    private static final String TAG = "WorkProfileUtil";

    public static boolean checkIfIsInPersonalProfileButClouddpcWorkProfileAvailable(Context context) {
        if (context == null) {
            throw new NullPointerException("context is marked non-null but is null");
        }
        if (!CommonFlightsManager.INSTANCE.getFlightsProvider().isFlightEnabled(CommonFlight.ENABLE_AM_API_WORKPROFILE_EXTRA_QUERY_PARAMETERS)) {
            return false;
        }
        try {
            return MAMPackageManagement.queryIntentActivities(context.getPackageManager(), new Intent("com.google.android.apps.work.clouddpc.ACTION_DETECT_WORK_PROFILE"), 0).stream().anyMatch(new Predicate() { // from class: com.microsoft.identity.common.internal.util.WorkProfileUtil$$ExternalSyntheticLambda0
                @Override // java.util.function.Predicate
                public final boolean test(Object obj) {
                    return ((ResolveInfo) obj).isCrossProfileIntentForwarderActivity();
                }
            });
        } catch (Exception e) {
            Logger.warn(TAG, "Received an exception while trying to check if clouddpc work profile is available: " + e.getMessage());
            return false;
        }
    }
}

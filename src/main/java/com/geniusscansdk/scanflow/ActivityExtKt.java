package com.geniusscansdk.scanflow;

import android.app.Activity;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ActivityExt.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0001¨\u0006\u0003"}, d2 = {"lockOrientationToPortraitOnPhones", "", "Landroid/app/Activity;", "gssdk_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class ActivityExtKt {
    public static final void lockOrientationToPortraitOnPhones(Activity activity) {
        Intrinsics.checkNotNullParameter(activity, "<this>");
        if (activity.getResources().getConfiguration().smallestScreenWidthDp < 600) {
            activity.setRequestedOrientation(1);
        }
    }
}

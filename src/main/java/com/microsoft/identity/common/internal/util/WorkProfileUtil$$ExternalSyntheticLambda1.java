package com.microsoft.identity.common.internal.util;

import android.content.pm.ResolveInfo;
import java.util.function.Predicate;

/* JADX INFO: compiled from: D8$$SyntheticClass */
/* JADX INFO: loaded from: classes14.dex */
public final /* synthetic */ class WorkProfileUtil$$ExternalSyntheticLambda1 implements Predicate {
    @Override // java.util.function.Predicate
    public final boolean test(Object obj) {
        return ((ResolveInfo) obj).activityInfo.name.equals("com.android.internal.app.ForwardIntentToManagedProfile");
    }
}

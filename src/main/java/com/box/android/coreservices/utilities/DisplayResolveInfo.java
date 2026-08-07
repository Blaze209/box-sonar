package com.box.android.coreservices.utilities;

import android.content.pm.ResolveInfo;

/* JADX INFO: loaded from: classes9.dex */
public final class DisplayResolveInfo {
    public final CharSequence displayLabel;
    public final CharSequence extendedInfo;
    private final ResolveInfo ri;

    DisplayResolveInfo(ResolveInfo resolveInfo, CharSequence charSequence, CharSequence charSequence2) {
        this.ri = resolveInfo;
        this.displayLabel = charSequence;
        this.extendedInfo = charSequence2;
    }

    public String getPackageName() {
        return this.ri.activityInfo.packageName;
    }

    public ResolveInfo getResolveInfo() {
        return this.ri;
    }
}

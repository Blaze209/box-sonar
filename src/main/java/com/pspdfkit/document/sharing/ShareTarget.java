package com.pspdfkit.document.sharing;

import android.graphics.drawable.Drawable;
import com.box.android.domain.metrics.hubs.HubsObservability;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.pspdfkit.internal.uw;

/* JADX INFO: loaded from: classes3.dex */
public class ShareTarget {
    private final Drawable icon;
    private final String label;
    private final String packageName;
    private final ShareAction shareAction;

    public ShareTarget(String str, String str2, Drawable drawable, ShareAction shareAction) {
        uw.a(str, RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, null);
        uw.a(str2, "label", null);
        uw.a(drawable, HubsObservability.HUB_ASSET_ICON, null);
        uw.a(shareAction, "shareAction", null);
        this.packageName = str;
        this.label = str2;
        this.icon = drawable;
        this.shareAction = shareAction;
    }

    public Drawable getIcon() {
        return this.icon;
    }

    public String getLabel() {
        return this.label;
    }

    public String getPackageName() {
        return this.packageName;
    }

    public ShareAction getShareAction() {
        return this.shareAction;
    }

    public boolean isPrintTarget() {
        return this.packageName.equals("com.android.bips");
    }
}

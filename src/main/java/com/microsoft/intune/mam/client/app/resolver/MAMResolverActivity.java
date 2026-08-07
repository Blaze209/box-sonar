package com.microsoft.intune.mam.client.app.resolver;

import android.os.Bundle;
import com.microsoft.intune.mam.client.app.MAMActivity;
import com.microsoft.intune.mam.client.app.MAMComponents;

/* JADX INFO: loaded from: classes3.dex */
public final class MAMResolverActivity extends MAMActivity {
    private final MAMResolverUIBehavior mResolverUIBehavior = (MAMResolverUIBehavior) MAMComponents.get(MAMResolverUIBehavior.class);

    @Override // com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMCreate(Bundle bundle) {
        this.mResolverUIBehavior.onBeforeActivityCreate(this, bundle);
        super.onMAMCreate(bundle);
        this.mResolverUIBehavior.onAfterActivityCreate(this, bundle);
    }

    @Override // com.microsoft.intune.mam.client.app.MAMActivity, com.microsoft.intune.mam.client.app.HookedActivity
    public void onMAMResume() {
        this.mResolverUIBehavior.onBeforeActivityResume(this);
        super.onMAMResume();
        this.mResolverUIBehavior.onAfterActivityResume(this);
    }

    @Override // android.content.ContextWrapper, android.content.Context
    public ClassLoader getClassLoader() {
        return this.mResolverUIBehavior.getClassLoader();
    }
}

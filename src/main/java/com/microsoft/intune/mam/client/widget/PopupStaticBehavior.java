package com.microsoft.intune.mam.client.widget;

import android.content.Context;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public interface PopupStaticBehavior {
    Context getAndWrapContext(View view);

    Context wrapContext(Context context);
}

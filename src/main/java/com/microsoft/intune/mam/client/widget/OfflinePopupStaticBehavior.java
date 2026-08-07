package com.microsoft.intune.mam.client.widget;

import android.content.Context;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public class OfflinePopupStaticBehavior implements PopupStaticBehavior {
    @Override // com.microsoft.intune.mam.client.widget.PopupStaticBehavior
    public Context wrapContext(Context context) {
        return context;
    }

    @Override // com.microsoft.intune.mam.client.widget.PopupStaticBehavior
    public Context getAndWrapContext(View view) {
        if (view != null) {
            return view.getContext();
        }
        return null;
    }
}

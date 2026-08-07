package com.microsoft.intune.mam.client.widget;

import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public class OfflinePopupInstanceBehavior implements PopupInstanceBehavior {
    private View mContentView;

    @Override // com.microsoft.intune.mam.client.widget.PopupInstanceBehavior
    public View getContentView() {
        return this.mContentView;
    }

    @Override // com.microsoft.intune.mam.client.widget.PopupInstanceBehavior
    public View getMAMContentView() {
        return this.mContentView;
    }

    @Override // com.microsoft.intune.mam.client.widget.PopupInstanceBehavior
    public void setContentView(View view) {
        this.mContentView = view;
    }
}

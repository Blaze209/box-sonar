package com.microsoft.intune.mam.client.view;

import android.content.ClipData;
import android.view.View;

/* JADX INFO: loaded from: classes3.dex */
public class OfflineViewManagementBehavior implements ViewManagementBehavior {
    @Override // com.microsoft.intune.mam.client.view.ViewManagementBehavior
    public boolean startDragAndDrop(View view, ClipData clipData, View.DragShadowBuilder dragShadowBuilder, Object obj, int i) {
        return view.startDragAndDrop(clipData, dragShadowBuilder, obj, i);
    }
}

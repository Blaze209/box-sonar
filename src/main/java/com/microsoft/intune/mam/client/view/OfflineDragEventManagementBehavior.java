package com.microsoft.intune.mam.client.view;

import android.content.ClipData;
import android.view.DragEvent;

/* JADX INFO: loaded from: classes3.dex */
public class OfflineDragEventManagementBehavior implements DragEventManagementBehavior {
    @Override // com.microsoft.intune.mam.client.view.DragEventManagementBehavior
    public ClipData getClipData(DragEvent dragEvent) {
        return dragEvent.getClipData();
    }
}

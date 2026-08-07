package com.microsoft.intune.mam.client.view;

import android.content.ClipData;
import android.view.DragEvent;
import com.microsoft.intune.mam.client.CachedBehaviorProvider;

/* JADX INFO: loaded from: classes3.dex */
public final class MAMDragEventManagement {
    private static CachedBehaviorProvider<DragEventManagementBehavior> sCachedBehavior = new CachedBehaviorProvider<>(DragEventManagementBehavior.class);

    public static ClipData getClipData(DragEvent dragEvent) {
        return getBehavior().getClipData(dragEvent);
    }

    private static DragEventManagementBehavior getBehavior() {
        return sCachedBehavior.get();
    }

    private MAMDragEventManagement() {
    }
}

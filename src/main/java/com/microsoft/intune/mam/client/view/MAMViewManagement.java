package com.microsoft.intune.mam.client.view;

import android.content.ClipData;
import android.view.View;
import com.microsoft.intune.mam.client.CachedBehaviorProvider;

/* JADX INFO: loaded from: classes3.dex */
public final class MAMViewManagement {
    private static CachedBehaviorProvider<ViewManagementBehavior> sCachedBehavior = new CachedBehaviorProvider<>(ViewManagementBehavior.class);

    public static boolean startDragAndDrop(View view, ClipData clipData, View.DragShadowBuilder dragShadowBuilder, Object obj, int i) {
        return getBehavior().startDragAndDrop(view, clipData, dragShadowBuilder, obj, i);
    }

    private static ViewManagementBehavior getBehavior() {
        return sCachedBehavior.get();
    }

    private MAMViewManagement() {
    }
}

package com.microsoft.intune.mam.client.content;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import com.microsoft.intune.mam.client.CachedBehaviorProvider;

/* JADX INFO: loaded from: classes3.dex */
public final class MAMClipboard {
    private static CachedBehaviorProvider<ClipboardBehavior> sCachedBehavior = new CachedBehaviorProvider<>(ClipboardBehavior.class);

    public static ClipData getPrimaryClip(ClipboardManager clipboardManager) {
        return getBehavior().getPrimaryClip(clipboardManager);
    }

    public static ClipDescription getPrimaryClipDescription(ClipboardManager clipboardManager) {
        return getBehavior().getPrimaryClipDescription(clipboardManager);
    }

    @Deprecated
    public static CharSequence getText(ClipboardManager clipboardManager) {
        return getBehavior().getText(clipboardManager);
    }

    public static boolean hasPrimaryClip(ClipboardManager clipboardManager) {
        return getBehavior().hasPrimaryClip(clipboardManager);
    }

    @Deprecated
    public static boolean hasText(ClipboardManager clipboardManager) {
        return getBehavior().hasText(clipboardManager);
    }

    public static void setPrimaryClip(ClipboardManager clipboardManager, ClipData clipData) {
        getBehavior().setPrimaryClip(clipboardManager, clipData);
    }

    @Deprecated
    public static void setText(ClipboardManager clipboardManager, CharSequence charSequence) {
        getBehavior().setText(clipboardManager, charSequence);
    }

    private static ClipboardBehavior getBehavior() {
        return sCachedBehavior.get();
    }

    private MAMClipboard() {
    }
}

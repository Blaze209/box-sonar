package com.microsoft.intune.mam.client.content;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;

/* JADX INFO: loaded from: classes3.dex */
public interface ClipboardBehavior {
    ClipData getPrimaryClip(ClipboardManager clipboardManager);

    ClipDescription getPrimaryClipDescription(ClipboardManager clipboardManager);

    @Deprecated
    CharSequence getText(ClipboardManager clipboardManager);

    boolean hasPrimaryClip(ClipboardManager clipboardManager);

    @Deprecated
    boolean hasText(ClipboardManager clipboardManager);

    void setPrimaryClip(ClipboardManager clipboardManager, ClipData clipData);

    @Deprecated
    void setText(ClipboardManager clipboardManager, CharSequence charSequence);
}

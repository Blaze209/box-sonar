package com.microsoft.intune.mam.client.content.offline;

import android.content.ClipData;
import android.content.ClipDescription;
import android.content.ClipboardManager;
import com.microsoft.intune.mam.client.content.ClipboardBehavior;

/* JADX INFO: loaded from: classes3.dex */
public class OfflineClipboardBehavior implements ClipboardBehavior {
    @Override // com.microsoft.intune.mam.client.content.ClipboardBehavior
    public ClipData getPrimaryClip(ClipboardManager clipboardManager) {
        return clipboardManager.getPrimaryClip();
    }

    @Override // com.microsoft.intune.mam.client.content.ClipboardBehavior
    public ClipDescription getPrimaryClipDescription(ClipboardManager clipboardManager) {
        return clipboardManager.getPrimaryClipDescription();
    }

    @Override // com.microsoft.intune.mam.client.content.ClipboardBehavior
    public CharSequence getText(ClipboardManager clipboardManager) {
        return clipboardManager.getText();
    }

    @Override // com.microsoft.intune.mam.client.content.ClipboardBehavior
    public boolean hasPrimaryClip(ClipboardManager clipboardManager) {
        return clipboardManager.hasPrimaryClip();
    }

    @Override // com.microsoft.intune.mam.client.content.ClipboardBehavior
    public boolean hasText(ClipboardManager clipboardManager) {
        return clipboardManager.hasText();
    }

    @Override // com.microsoft.intune.mam.client.content.ClipboardBehavior
    public void setPrimaryClip(ClipboardManager clipboardManager, ClipData clipData) {
        clipboardManager.setPrimaryClip(clipData);
    }

    @Override // com.microsoft.intune.mam.client.content.ClipboardBehavior
    public void setText(ClipboardManager clipboardManager, CharSequence charSequence) {
        clipboardManager.setText(charSequence);
    }
}

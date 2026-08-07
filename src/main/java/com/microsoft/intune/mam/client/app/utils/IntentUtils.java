package com.microsoft.intune.mam.client.app.utils;

import android.content.Intent;

/* JADX INFO: loaded from: classes3.dex */
public final class IntentUtils {
    public static void stripStackManipulationFlags(Intent intent) {
        intent.setFlags((intent.getFlags() & (-336101377)) | 33619968);
    }

    private IntentUtils() {
    }
}

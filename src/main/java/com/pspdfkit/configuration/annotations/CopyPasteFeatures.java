package com.pspdfkit.configuration.annotations;

import java.util.EnumSet;

/* JADX INFO: loaded from: classes3.dex */
public enum CopyPasteFeatures {
    CROSS_DOCUMENT_COPY_PASTE;

    public static EnumSet<CopyPasteFeatures> allFeatures() {
        return EnumSet.allOf(CopyPasteFeatures.class);
    }
}

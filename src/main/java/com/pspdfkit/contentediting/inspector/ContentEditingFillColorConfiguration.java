package com.pspdfkit.contentediting.inspector;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface ContentEditingFillColorConfiguration {
    boolean customColorPickerEnabled();

    List<Integer> getAvailableFillColors();

    int getDefaultFillColor();
}

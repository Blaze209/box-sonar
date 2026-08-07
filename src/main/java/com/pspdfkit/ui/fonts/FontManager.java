package com.pspdfkit.ui.fonts;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface FontManager {
    List<Font> getAvailableFonts();

    Font getFontByName(String str);
}

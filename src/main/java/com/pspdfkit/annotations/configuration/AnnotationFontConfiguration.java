package com.pspdfkit.annotations.configuration;

import com.pspdfkit.ui.fonts.Font;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface AnnotationFontConfiguration extends AnnotationConfiguration {

    public interface Builder<T> extends AnnotationConfiguration.Builder<T> {
        T setAvailableFonts(List<Font> list);

        T setDefaultFont(Font font);
    }

    List<Font> getAvailableFonts();

    Font getDefaultFont();
}

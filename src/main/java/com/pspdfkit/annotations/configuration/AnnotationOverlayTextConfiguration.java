package com.pspdfkit.annotations.configuration;

/* JADX INFO: loaded from: classes3.dex */
public interface AnnotationOverlayTextConfiguration extends AnnotationConfiguration {

    public interface Builder<T> extends AnnotationConfiguration.Builder<T> {
        T setDefaultOverlayText(String str);

        T setDefaultRepeatOverlayTextSetting(boolean z);
    }

    String getDefaultOverlayText();

    boolean getDefaultRepeatOverlayTextSetting();
}

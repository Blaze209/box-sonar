package com.pspdfkit.annotations.configuration;

import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface AnnotationNoteIconConfiguration extends AnnotationConfiguration {

    public interface Builder<T> extends AnnotationConfiguration.Builder<T> {
        T setAvailableIconNames(List<String> list);

        T setDefaultIconName(String str);
    }

    List<String> getAvailableIconNames();

    String getDefaultIconName();
}

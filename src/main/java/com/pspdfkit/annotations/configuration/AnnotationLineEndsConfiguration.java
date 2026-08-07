package com.pspdfkit.annotations.configuration;

import androidx.core.util.Pair;
import com.pspdfkit.annotations.LineEndType;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface AnnotationLineEndsConfiguration extends AnnotationConfiguration {

    public interface Builder<T> extends AnnotationConfiguration.Builder<T> {
        T setAvailableLineEnds(List<LineEndType> list);

        T setDefaultLineEnds(Pair<LineEndType, LineEndType> pair);
    }

    List<LineEndType> getAvailableLineEnds();

    Pair<LineEndType, LineEndType> getDefaultLineEnds();
}

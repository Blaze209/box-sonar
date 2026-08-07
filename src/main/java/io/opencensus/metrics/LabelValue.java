package io.opencensus.metrics;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public abstract class LabelValue {
    @Nullable
    public abstract String getValue();

    LabelValue() {
    }

    public static LabelValue create(@Nullable String str) {
        return new AutoValue_LabelValue(str);
    }
}

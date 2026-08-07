package io.opentelemetry.sdk.metrics.internal.view;

import io.opentelemetry.sdk.metrics.InstrumentSelector;
import io.opentelemetry.sdk.metrics.View;
import io.opentelemetry.sdk.metrics.internal.debug.SourceInfo;

/* JADX INFO: loaded from: classes4.dex */
public abstract class RegisteredView {
    public abstract InstrumentSelector getInstrumentSelector();

    public abstract View getView();

    public abstract AttributesProcessor getViewAttributesProcessor();

    public abstract SourceInfo getViewSourceInfo();

    public static RegisteredView create(InstrumentSelector instrumentSelector, View view, AttributesProcessor attributesProcessor, SourceInfo sourceInfo) {
        return new AutoValue_RegisteredView(instrumentSelector, view, attributesProcessor, sourceInfo);
    }

    RegisteredView() {
    }

    public final String toString() {
        return "RegisteredView{instrumentSelector=" + getInstrumentSelector() + ", view=" + getView() + "}";
    }
}

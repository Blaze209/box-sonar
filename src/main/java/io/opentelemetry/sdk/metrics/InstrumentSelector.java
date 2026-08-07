package io.opentelemetry.sdk.metrics;

import java.util.StringJoiner;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
public abstract class InstrumentSelector {
    @Nullable
    public abstract String getInstrumentName();

    @Nullable
    public abstract InstrumentType getInstrumentType();

    @Nullable
    public abstract String getMeterName();

    @Nullable
    public abstract String getMeterSchemaUrl();

    @Nullable
    public abstract String getMeterVersion();

    public static InstrumentSelectorBuilder builder() {
        return new InstrumentSelectorBuilder();
    }

    static InstrumentSelector create(@Nullable InstrumentType instrumentType, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        return new AutoValue_InstrumentSelector(instrumentType, str, str2, str3, str4);
    }

    InstrumentSelector() {
    }

    public final String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ", "InstrumentSelector{", "}");
        if (getInstrumentType() != null) {
            stringJoiner.add("instrumentType=" + getInstrumentType());
        }
        if (getInstrumentName() != null) {
            stringJoiner.add("instrumentName=" + getInstrumentName());
        }
        if (getMeterName() != null) {
            stringJoiner.add("meterName=" + getMeterName());
        }
        if (getMeterVersion() != null) {
            stringJoiner.add("meterVersion=" + getMeterVersion());
        }
        if (getMeterSchemaUrl() != null) {
            stringJoiner.add("meterSchemaUrl=" + getMeterSchemaUrl());
        }
        return stringJoiner.toString();
    }
}

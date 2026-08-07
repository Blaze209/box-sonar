package io.opentelemetry.sdk.metrics;

import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_InstrumentSelector extends InstrumentSelector {
    private final String instrumentName;
    private final InstrumentType instrumentType;
    private final String meterName;
    private final String meterSchemaUrl;
    private final String meterVersion;

    AutoValue_InstrumentSelector(@Nullable InstrumentType instrumentType, @Nullable String str, @Nullable String str2, @Nullable String str3, @Nullable String str4) {
        this.instrumentType = instrumentType;
        this.instrumentName = str;
        this.meterName = str2;
        this.meterVersion = str3;
        this.meterSchemaUrl = str4;
    }

    @Override // io.opentelemetry.sdk.metrics.InstrumentSelector
    @Nullable
    public InstrumentType getInstrumentType() {
        return this.instrumentType;
    }

    @Override // io.opentelemetry.sdk.metrics.InstrumentSelector
    @Nullable
    public String getInstrumentName() {
        return this.instrumentName;
    }

    @Override // io.opentelemetry.sdk.metrics.InstrumentSelector
    @Nullable
    public String getMeterName() {
        return this.meterName;
    }

    @Override // io.opentelemetry.sdk.metrics.InstrumentSelector
    @Nullable
    public String getMeterVersion() {
        return this.meterVersion;
    }

    @Override // io.opentelemetry.sdk.metrics.InstrumentSelector
    @Nullable
    public String getMeterSchemaUrl() {
        return this.meterSchemaUrl;
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof InstrumentSelector) {
            InstrumentSelector instrumentSelector = (InstrumentSelector) obj;
            InstrumentType instrumentType = this.instrumentType;
            if (instrumentType != null ? instrumentType.equals(instrumentSelector.getInstrumentType()) : instrumentSelector.getInstrumentType() == null) {
                String str = this.instrumentName;
                if (str != null ? str.equals(instrumentSelector.getInstrumentName()) : instrumentSelector.getInstrumentName() == null) {
                    String str2 = this.meterName;
                    if (str2 != null ? str2.equals(instrumentSelector.getMeterName()) : instrumentSelector.getMeterName() == null) {
                        String str3 = this.meterVersion;
                        if (str3 != null ? str3.equals(instrumentSelector.getMeterVersion()) : instrumentSelector.getMeterVersion() == null) {
                            String str4 = this.meterSchemaUrl;
                            if (str4 != null ? str4.equals(instrumentSelector.getMeterSchemaUrl()) : instrumentSelector.getMeterSchemaUrl() == null) {
                                return true;
                            }
                        }
                    }
                }
            }
        }
        return false;
    }

    public int hashCode() {
        InstrumentType instrumentType = this.instrumentType;
        int iHashCode = ((instrumentType == null ? 0 : instrumentType.hashCode()) ^ 1000003) * 1000003;
        String str = this.instrumentName;
        int iHashCode2 = (iHashCode ^ (str == null ? 0 : str.hashCode())) * 1000003;
        String str2 = this.meterName;
        int iHashCode3 = (iHashCode2 ^ (str2 == null ? 0 : str2.hashCode())) * 1000003;
        String str3 = this.meterVersion;
        int iHashCode4 = (iHashCode3 ^ (str3 == null ? 0 : str3.hashCode())) * 1000003;
        String str4 = this.meterSchemaUrl;
        return iHashCode4 ^ (str4 != null ? str4.hashCode() : 0);
    }
}

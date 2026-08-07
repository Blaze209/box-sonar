package io.opentelemetry.sdk.logs;

/* JADX INFO: loaded from: classes4.dex */
final class AutoValue_LogLimits extends LogLimits {
    private final int maxAttributeValueLength;
    private final int maxNumberOfAttributes;

    AutoValue_LogLimits(int i, int i2) {
        this.maxNumberOfAttributes = i;
        this.maxAttributeValueLength = i2;
    }

    @Override // io.opentelemetry.sdk.logs.LogLimits
    public int getMaxNumberOfAttributes() {
        return this.maxNumberOfAttributes;
    }

    @Override // io.opentelemetry.sdk.logs.LogLimits
    public int getMaxAttributeValueLength() {
        return this.maxAttributeValueLength;
    }

    public String toString() {
        return "LogLimits{maxNumberOfAttributes=" + this.maxNumberOfAttributes + ", maxAttributeValueLength=" + this.maxAttributeValueLength + "}";
    }

    public boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof LogLimits) {
            LogLimits logLimits = (LogLimits) obj;
            if (this.maxNumberOfAttributes == logLimits.getMaxNumberOfAttributes() && this.maxAttributeValueLength == logLimits.getMaxAttributeValueLength()) {
                return true;
            }
        }
        return false;
    }

    public int hashCode() {
        return this.maxAttributeValueLength ^ ((this.maxNumberOfAttributes ^ 1000003) * 1000003);
    }
}

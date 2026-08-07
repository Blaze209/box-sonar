package io.opentelemetry.sdk.logs;

import io.opentelemetry.api.internal.Utils;

/* JADX INFO: loaded from: classes4.dex */
public final class LogLimitsBuilder {
    private static final int DEFAULT_LOG_MAX_ATTRIBUTE_LENGTH = Integer.MAX_VALUE;
    private static final int DEFAULT_LOG_MAX_NUM_ATTRIBUTES = 128;
    private int maxNumAttributes = 128;
    private int maxAttributeValueLength = Integer.MAX_VALUE;

    LogLimitsBuilder() {
    }

    public LogLimitsBuilder setMaxNumberOfAttributes(int i) {
        Utils.checkArgument(i > 0, "maxNumberOfAttributes must be greater than 0");
        this.maxNumAttributes = i;
        return this;
    }

    public LogLimitsBuilder setMaxAttributeValueLength(int i) {
        Utils.checkArgument(i > -1, "maxAttributeValueLength must be non-negative");
        this.maxAttributeValueLength = i;
        return this;
    }

    public LogLimits build() {
        return LogLimits.create(this.maxNumAttributes, this.maxAttributeValueLength);
    }
}

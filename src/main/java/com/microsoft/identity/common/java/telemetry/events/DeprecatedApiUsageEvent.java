package com.microsoft.identity.common.java.telemetry.events;

import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import javax.annotation.Nonnull;

/* JADX INFO: loaded from: classes14.dex */
@Deprecated
public class DeprecatedApiUsageEvent extends BaseEvent {
    public DeprecatedApiUsageEvent() {
        names(TelemetryEventStrings.Event.DEPRECATED_API_USAGE_EVENT).types(TelemetryEventStrings.EventType.LIBRARY_CONSUMER_EVENT);
    }

    public DeprecatedApiUsageEvent putDeprecatedClassUsage(@Nonnull Class<?> cls) {
        put(TelemetryEventStrings.Key.PACKAGE_NAME, cls.getPackage().toString());
        put(TelemetryEventStrings.Key.CLASS_NAME, cls.getSimpleName());
        return this;
    }

    public DeprecatedApiUsageEvent putDeprecatedMethodUsage(@Nonnull Class<?> cls, @Nonnull String str) {
        put(TelemetryEventStrings.Key.CLASS_METHOD, str);
        return putDeprecatedClassUsage(cls);
    }
}

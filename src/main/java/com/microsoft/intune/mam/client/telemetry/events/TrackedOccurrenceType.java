package com.microsoft.intune.mam.client.telemetry.events;

import java.util.concurrent.TimeUnit;

/* JADX INFO: loaded from: classes3.dex */
public interface TrackedOccurrenceType {
    public static final long DEFAULT_THROTTLE_MS = TimeUnit.HOURS.toMillis(1);

    String getName();

    long getThrottleMs();
}

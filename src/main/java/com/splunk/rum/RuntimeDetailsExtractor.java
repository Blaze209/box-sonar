package com.splunk.rum;

import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import com.google.firebase.analytics.FirebaseAnalytics;
import io.opentelemetry.api.common.AttributesBuilder;
import io.opentelemetry.context.Context;
import io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor;
import java.io.File;

/* JADX INFO: loaded from: classes3.dex */
final class RuntimeDetailsExtractor<RQ, RS> extends BroadcastReceiver implements AttributesExtractor<RQ, RS> {
    private volatile Double batteryPercent = null;
    private final File filesDir;

    @Override // io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor
    public void onEnd(AttributesBuilder attributesBuilder, Context context, RQ rq, RS rs, Throwable th) {
    }

    static <RQ, RS> RuntimeDetailsExtractor<RQ, RS> create(android.content.Context context) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.BATTERY_CHANGED");
        RuntimeDetailsExtractor<RQ, RS> runtimeDetailsExtractor = new RuntimeDetailsExtractor<>(context.getFilesDir());
        context.registerReceiver(runtimeDetailsExtractor, intentFilter);
        return runtimeDetailsExtractor;
    }

    private RuntimeDetailsExtractor(File file) {
        this.filesDir = file;
    }

    public void onMAMReceive(android.content.Context context, Intent intent) {
        this.batteryPercent = Double.valueOf((((double) intent.getIntExtra(FirebaseAnalytics.Param.LEVEL, -1)) * 100.0d) / ((double) intent.getIntExtra("scale", -1)));
    }

    @Override // io.opentelemetry.instrumentation.api.instrumenter.AttributesExtractor
    public void onStart(AttributesBuilder attributesBuilder, Context context, RQ rq) {
        attributesBuilder.put(SplunkRum.STORAGE_SPACE_FREE_KEY, Long.valueOf(getCurrentStorageFreeSpaceInBytes()));
        attributesBuilder.put(SplunkRum.HEAP_FREE_KEY, Long.valueOf(getCurrentFreeHeapInBytes()));
        Double currentBatteryPercent = getCurrentBatteryPercent();
        if (currentBatteryPercent != null) {
            attributesBuilder.put(SplunkRum.BATTERY_PERCENT_KEY, currentBatteryPercent);
        }
    }

    private long getCurrentStorageFreeSpaceInBytes() {
        return this.filesDir.getFreeSpace();
    }

    private long getCurrentFreeHeapInBytes() {
        return Runtime.getRuntime().freeMemory();
    }

    private Double getCurrentBatteryPercent() {
        return this.batteryPercent;
    }
}

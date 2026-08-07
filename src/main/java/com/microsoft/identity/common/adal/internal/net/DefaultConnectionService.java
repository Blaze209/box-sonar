package com.microsoft.identity.common.adal.internal.net;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkCapabilities;
import android.net.NetworkInfo;
import com.microsoft.identity.common.adal.internal.PowerManagerWrapper;
import com.microsoft.identity.common.internal.telemetry.Telemetry;
import com.microsoft.identity.common.java.flighting.CommonFlight;
import com.microsoft.identity.common.java.flighting.CommonFlightsManager;
import com.microsoft.identity.common.java.opentelemetry.OTelUtility;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.microsoft.identity.common.java.telemetry.events.BaseEvent;
import io.opentelemetry.api.metrics.LongCounter;

/* JADX INFO: loaded from: classes14.dex */
public class DefaultConnectionService implements IConnectionService {
    private static final LongCounter sNetworkCheckFailureCount = OTelUtility.createLongCounter("network_check_failure_count", "Number of times network was not available");
    private static final LongCounter sNetworkCheckSuccessCount = OTelUtility.createLongCounter("network_check_success_count", "Number of times network was available");
    private final Context mConnectionContext;

    public DefaultConnectionService(Context context) {
        this.mConnectionContext = context;
    }

    @Override // com.microsoft.identity.common.adal.internal.net.IConnectionService
    public boolean isConnectionAvailable() {
        ConnectivityManager connectivityManager = (ConnectivityManager) this.mConnectionContext.getSystemService("connectivity");
        boolean z = true;
        if (CommonFlightsManager.INSTANCE.getFlightsProvider().isFlightEnabled(CommonFlight.USE_NETWORK_CAPABILITY_FOR_NETWORK_CHECK)) {
            NetworkCapabilities networkCapabilities = connectivityManager.getNetworkCapabilities(connectivityManager.getActiveNetwork());
            z = networkCapabilities != null && networkCapabilities.hasCapability(12) && networkCapabilities.hasCapability(16);
            if (z) {
                sNetworkCheckSuccessCount.add(1L);
            } else {
                sNetworkCheckFailureCount.add(1L);
            }
        } else {
            NetworkInfo activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            if (activeNetworkInfo == null || !activeNetworkInfo.isConnectedOrConnecting()) {
                z = false;
            }
        }
        Telemetry.emit((BaseEvent) new BaseEvent().put(TelemetryEventStrings.Key.NETWORK_CONNECTION, String.valueOf(z)));
        return z;
    }

    public boolean isNetworkDisabledFromOptimizations() {
        PowerManagerWrapper powerManagerWrapper = PowerManagerWrapper.getInstance();
        if (powerManagerWrapper.isDeviceIdleMode(this.mConnectionContext) && !powerManagerWrapper.isIgnoringBatteryOptimizations(this.mConnectionContext)) {
            Telemetry.emit((BaseEvent) new BaseEvent().put(TelemetryEventStrings.Key.POWER_OPTIMIZATION, String.valueOf(true)));
            return true;
        }
        Telemetry.emit((BaseEvent) new BaseEvent().put(TelemetryEventStrings.Key.POWER_OPTIMIZATION, String.valueOf(false)));
        return false;
    }
}

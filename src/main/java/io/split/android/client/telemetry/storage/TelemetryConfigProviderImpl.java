package io.split.android.client.telemetry.storage;

import android.os.Build;
import io.split.android.client.ServiceEndpoints;
import io.split.android.client.SplitClientConfig;
import io.split.android.client.service.impressions.ImpressionsMode;
import io.split.android.client.telemetry.model.Config;
import io.split.android.client.telemetry.model.RefreshRates;
import io.split.android.client.telemetry.model.UrlOverrides;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;

/* JADX INFO: loaded from: classes4.dex */
public class TelemetryConfigProviderImpl implements TelemetryConfigProvider {
    private final int mInvalidFlagSetCount;
    private final SplitClientConfig mSplitClientConfig;
    private final TelemetryStorageConsumer mTelemetryConsumer;
    private final int mValidFlagSetCount;

    public TelemetryConfigProviderImpl(TelemetryStorageConsumer telemetryConsumer, SplitClientConfig splitClientConfig, int validFlagSetCount, int invalidFlagSetCount) {
        this.mTelemetryConsumer = (TelemetryStorageConsumer) Utils.checkNotNull(telemetryConsumer);
        this.mSplitClientConfig = (SplitClientConfig) Utils.checkNotNull(splitClientConfig);
        this.mValidFlagSetCount = validFlagSetCount;
        this.mInvalidFlagSetCount = invalidFlagSetCount;
    }

    @Override // io.split.android.client.telemetry.storage.TelemetryConfigProvider
    public Config getConfigTelemetry() {
        Config config = new Config();
        addDefaultTags(this.mSplitClientConfig);
        config.setStreamingEnabled(this.mSplitClientConfig.streamingEnabled());
        config.setRefreshRates(buildRefreshRates(this.mSplitClientConfig));
        config.setTags(this.mTelemetryConsumer.popTags());
        config.setImpressionsListenerEnabled(this.mSplitClientConfig.impressionListener() != null);
        config.setTimeUntilSDKReady(this.mTelemetryConsumer.getTimeUntilReady());
        config.setTimeUntilSDKReadyFromCache(this.mTelemetryConsumer.getTimeUntilReadyFromCache());
        config.setRedundantActiveFactories(this.mTelemetryConsumer.getRedundantFactories());
        config.setActiveFactories(this.mTelemetryConsumer.getActiveFactories());
        config.setHttpProxyDetected(this.mSplitClientConfig.proxy() != null);
        config.setSDKNotReadyUsage(this.mTelemetryConsumer.getNonReadyUsage());
        config.setUrlOverrides(buildUrlOverrides(this.mSplitClientConfig));
        config.setImpressionsQueueSize(this.mSplitClientConfig.impressionsQueueSize());
        config.setEventsQueueSize(this.mSplitClientConfig.eventsQueueSize());
        config.setUserConsent(this.mSplitClientConfig.userConsent().intValue());
        config.setFlagSetsTotal(this.mValidFlagSetCount + this.mInvalidFlagSetCount);
        config.setFlagSetsInvalid(this.mInvalidFlagSetCount);
        if (this.mSplitClientConfig.impressionsMode() == ImpressionsMode.DEBUG) {
            config.setImpressionsMode(io.split.android.client.telemetry.model.ImpressionsMode.DEBUG.intValue());
            return config;
        }
        if (this.mSplitClientConfig.impressionsMode() == ImpressionsMode.OPTIMIZED) {
            config.setImpressionsMode(io.split.android.client.telemetry.model.ImpressionsMode.OPTIMIZED.intValue());
            return config;
        }
        config.setImpressionsMode(io.split.android.client.telemetry.model.ImpressionsMode.NONE.intValue());
        return config;
    }

    private RefreshRates buildRefreshRates(SplitClientConfig splitClientConfig) {
        RefreshRates refreshRates = new RefreshRates();
        refreshRates.setTelemetry(splitClientConfig.telemetryRefreshRate());
        refreshRates.setSplits(splitClientConfig.featuresRefreshRate());
        refreshRates.setMySegments(splitClientConfig.segmentsRefreshRate());
        refreshRates.setImpressions(splitClientConfig.impressionsRefreshRate());
        refreshRates.setEvents(splitClientConfig.eventFlushInterval());
        return refreshRates;
    }

    private UrlOverrides buildUrlOverrides(SplitClientConfig splitClientConfig) {
        UrlOverrides urlOverrides = new UrlOverrides();
        urlOverrides.setAuth(ServiceEndpoints.EndpointValidator.authEndpointIsOverridden(splitClientConfig.authServiceUrl()));
        urlOverrides.setSdkUrl(ServiceEndpoints.EndpointValidator.sdkEndpointIsOverridden(splitClientConfig.endpoint()));
        urlOverrides.setStream(ServiceEndpoints.EndpointValidator.streamingEndpointIsOverridden(splitClientConfig.streamingServiceUrl()));
        urlOverrides.setEvents(ServiceEndpoints.EndpointValidator.eventsEndpointIsOverridden(splitClientConfig.eventsEndpoint()));
        urlOverrides.setTelemetry(ServiceEndpoints.EndpointValidator.telemetryEndpointIsOverridden(splitClientConfig.telemetryEndpoint()));
        return urlOverrides;
    }

    private void addDefaultTags(SplitClientConfig mSplitClientConfig) {
        try {
            TelemetryRuntimeProducer telemetryRuntimeProducer = (TelemetryRuntimeProducer) this.mTelemetryConsumer;
            telemetryRuntimeProducer.addTag("av:" + Build.VERSION.SDK_INT);
            if (mSplitClientConfig.synchronizeInBackground()) {
                telemetryRuntimeProducer.addTag("bgr:" + mSplitClientConfig.backgroundSyncPeriod());
            }
        } catch (ClassCastException unused) {
            Logger.d("Telemetry storage is not a producer");
        }
    }
}

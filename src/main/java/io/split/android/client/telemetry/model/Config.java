package io.split.android.client.telemetry.model;

import androidx.media3.exoplayer.upstream.CmcdConfiguration;
import com.google.gson.annotations.SerializedName;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class Config {

    @SerializedName("nR")
    private long SDKNotReadyUsage;

    @SerializedName("aF")
    private long activeFactories;

    @SerializedName("eQ")
    private long eventsQueueSize;

    @SerializedName("fsI")
    private int flagSetsInvalid;

    @SerializedName("fsT")
    private int flagSetsTotal;

    @SerializedName("hP")
    private boolean httpProxyDetected;

    @SerializedName("iL")
    private boolean impressionsListenerEnabled;

    @SerializedName("iM")
    private int impressionsMode;

    @SerializedName("iQ")
    private long impressionsQueueSize;

    @SerializedName("i")
    private List<String> integrations;

    @SerializedName("lsE")
    private boolean largeSegmentsEnabled;

    @SerializedName("rF")
    private long redundantActiveFactories;

    @SerializedName("rR")
    private RefreshRates refreshRates;

    @SerializedName("sE")
    private boolean streamingEnabled;

    @SerializedName("t")
    private List<String> tags;

    @SerializedName("tR")
    private long timeUntilSDKReady;

    @SerializedName("tC")
    private long timeUntilSDKReadyFromCache;

    @SerializedName("uO")
    private UrlOverrides urlOverrides;

    @SerializedName("uC")
    private long userConsent;

    @SerializedName("wls")
    private boolean waitForLargeSegments;

    @SerializedName("oM")
    private final int operationMode = OperationMode.STANDALONE.getNumericValue();

    @SerializedName(CmcdConfiguration.KEY_STREAM_TYPE)
    private final String storage = "memory";

    public int getOperationMode() {
        return this.operationMode;
    }

    public String getStorage() {
        return "memory";
    }

    public boolean isStreamingEnabled() {
        return this.streamingEnabled;
    }

    public void setStreamingEnabled(boolean streamingEnabled) {
        this.streamingEnabled = streamingEnabled;
    }

    public RefreshRates getRefreshRates() {
        return this.refreshRates;
    }

    public void setRefreshRates(RefreshRates refreshRates) {
        this.refreshRates = refreshRates;
    }

    public UrlOverrides getUrlOverrides() {
        return this.urlOverrides;
    }

    public void setUrlOverrides(UrlOverrides urlOverrides) {
        this.urlOverrides = urlOverrides;
    }

    public long getImpressionsQueueSize() {
        return this.impressionsQueueSize;
    }

    public void setImpressionsQueueSize(long impressionsQueueSize) {
        this.impressionsQueueSize = impressionsQueueSize;
    }

    public long getEventsQueueSize() {
        return this.eventsQueueSize;
    }

    public void setEventsQueueSize(long eventsQueueSize) {
        this.eventsQueueSize = eventsQueueSize;
    }

    public int getImpressionsMode() {
        return this.impressionsMode;
    }

    public void setImpressionsMode(int impressionsMode) {
        this.impressionsMode = impressionsMode;
    }

    public boolean isImpressionsListenerEnabled() {
        return this.impressionsListenerEnabled;
    }

    public void setImpressionsListenerEnabled(boolean impressionsListenerEnabled) {
        this.impressionsListenerEnabled = impressionsListenerEnabled;
    }

    public boolean isHttpProxyDetected() {
        return this.httpProxyDetected;
    }

    public void setHttpProxyDetected(boolean httpProxyDetected) {
        this.httpProxyDetected = httpProxyDetected;
    }

    public long getActiveFactories() {
        return this.activeFactories;
    }

    public void setActiveFactories(long activeFactories) {
        this.activeFactories = activeFactories;
    }

    public long getRedundantActiveFactories() {
        return this.redundantActiveFactories;
    }

    public void setRedundantActiveFactories(long redundantActiveFactories) {
        this.redundantActiveFactories = redundantActiveFactories;
    }

    public long getTimeUntilSDKReady() {
        return this.timeUntilSDKReady;
    }

    public void setTimeUntilSDKReady(long timeUntilSDKReady) {
        this.timeUntilSDKReady = timeUntilSDKReady;
    }

    public long getTimeUntilSDKReadyFromCache() {
        return this.timeUntilSDKReadyFromCache;
    }

    public void setTimeUntilSDKReadyFromCache(long timeUntilSDKReadyFromCache) {
        this.timeUntilSDKReadyFromCache = timeUntilSDKReadyFromCache;
    }

    public long getSDKNotReadyUsage() {
        return this.SDKNotReadyUsage;
    }

    public long getUserConsent() {
        return this.userConsent;
    }

    public void setUserConsent(long userConsent) {
        this.userConsent = userConsent;
    }

    public void setSDKNotReadyUsage(long SDKNotReadyUsage) {
        this.SDKNotReadyUsage = SDKNotReadyUsage;
    }

    public List<String> getTags() {
        return this.tags;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public List<String> getIntegrations() {
        return this.integrations;
    }

    public void setIntegrations(List<String> integrations) {
        this.integrations = integrations;
    }

    public int getFlagSetsTotal() {
        return this.flagSetsTotal;
    }

    public void setFlagSetsTotal(int flagSetsTotal) {
        this.flagSetsTotal = flagSetsTotal;
    }

    public int getFlagSetsInvalid() {
        return this.flagSetsInvalid;
    }

    public void setFlagSetsInvalid(int flagSetsInvalid) {
        this.flagSetsInvalid = flagSetsInvalid;
    }

    public boolean largeSegmentsEnabled() {
        return this.largeSegmentsEnabled;
    }

    public void setLargeSegmentsEnabled(boolean largeSegmentsEnabled) {
        this.largeSegmentsEnabled = largeSegmentsEnabled;
    }

    public boolean getWaitForLargeSegments() {
        return this.waitForLargeSegments;
    }

    public void setWaitForLargeSegments(boolean waitForLargeSegments) {
        this.waitForLargeSegments = waitForLargeSegments;
    }
}

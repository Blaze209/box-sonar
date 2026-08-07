package io.split.android.client.telemetry.model;

import com.google.gson.annotations.SerializedName;
import io.split.android.client.telemetry.model.streaming.StreamingEvent;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class Stats {

    @SerializedName("aR")
    private long authRejections;

    @SerializedName("eD")
    private long eventsDropped;

    @SerializedName("eQ")
    private long eventsQueued;

    @SerializedName("hE")
    private HttpErrors httpErrors;

    @SerializedName("hL")
    private HttpLatencies httpLatencies;

    @SerializedName("iDe")
    private long impressionsDeduped;

    @SerializedName("iDr")
    private long impressionsDropped;

    @SerializedName("iQ")
    private long impressionsQueued;

    @SerializedName("lsC")
    private long largeSegmentCount;

    @SerializedName("lS")
    private LastSync lastSynchronizations;

    @SerializedName("mE")
    private MethodExceptions methodExceptions;

    @SerializedName("mL")
    private MethodLatencies methodLatencies;

    @SerializedName("seC")
    private long segmentCount;

    @SerializedName("skC")
    private final long segmentKeyCount = 1;

    @SerializedName("sL")
    private long sessionLengthMs;

    @SerializedName("spC")
    private long splitCount;

    @SerializedName("sE")
    private List<StreamingEvent> streamingEvents;

    @SerializedName("t")
    private List<String> tags;

    @SerializedName("tR")
    private long tokenRefreshes;

    @SerializedName("ufs")
    private UpdatesFromSSE updatesFromSSE;

    public void setLastSynchronizations(LastSync lastSynchronizations) {
        this.lastSynchronizations = lastSynchronizations;
    }

    public void setMethodLatencies(MethodLatencies methodLatencies) {
        this.methodLatencies = methodLatencies;
    }

    public void setMethodExceptions(MethodExceptions methodExceptions) {
        this.methodExceptions = methodExceptions;
    }

    public void setHttpErrors(HttpErrors httpErrors) {
        this.httpErrors = httpErrors;
    }

    public void setHttpLatencies(HttpLatencies httpLatencies) {
        this.httpLatencies = httpLatencies;
    }

    public void setTokenRefreshes(long tokenRefreshes) {
        this.tokenRefreshes = tokenRefreshes;
    }

    public void setAuthRejections(long authRejections) {
        this.authRejections = authRejections;
    }

    public void setImpressionsQueued(long impressionsQueued) {
        this.impressionsQueued = impressionsQueued;
    }

    public void setImpressionsDeduped(long impressionsDeduped) {
        this.impressionsDeduped = impressionsDeduped;
    }

    public void setImpressionsDropped(long impressionsDropped) {
        this.impressionsDropped = impressionsDropped;
    }

    public void setSplitCount(long splitCount) {
        this.splitCount = splitCount;
    }

    public void setSegmentCount(long segmentCount) {
        this.segmentCount = segmentCount;
    }

    public void setLargeSegmentCount(long largeSegmentCount) {
        this.largeSegmentCount = largeSegmentCount;
    }

    public void setSessionLengthMs(long sessionLengthMs) {
        this.sessionLengthMs = sessionLengthMs;
    }

    public void setEventsQueued(long eventsQueued) {
        this.eventsQueued = eventsQueued;
    }

    public void setEventsDropped(long eventsDropped) {
        this.eventsDropped = eventsDropped;
    }

    public void setStreamingEvents(List<StreamingEvent> streamingEvents) {
        this.streamingEvents = streamingEvents;
    }

    public void setTags(List<String> tags) {
        this.tags = tags;
    }

    public void setUpdatesFromSSE(UpdatesFromSSE updatesFromSSE) {
        this.updatesFromSSE = updatesFromSSE;
    }

    public List<String> getTags() {
        return this.tags;
    }

    public UpdatesFromSSE getUpdatesFromSSE() {
        return this.updatesFromSSE;
    }

    public LastSync getLastSynchronizations() {
        return this.lastSynchronizations;
    }

    public MethodLatencies getMethodLatencies() {
        return this.methodLatencies;
    }

    public MethodExceptions getMethodExceptions() {
        return this.methodExceptions;
    }

    public HttpErrors getHttpErrors() {
        return this.httpErrors;
    }

    public HttpLatencies getHttpLatencies() {
        return this.httpLatencies;
    }

    public long getTokenRefreshes() {
        return this.tokenRefreshes;
    }

    public long getAuthRejections() {
        return this.authRejections;
    }

    public long getImpressionsQueued() {
        return this.impressionsQueued;
    }

    public long getImpressionsDeduped() {
        return this.impressionsDeduped;
    }

    public long getImpressionsDropped() {
        return this.impressionsDropped;
    }

    public long getSplitCount() {
        return this.splitCount;
    }

    public long getSegmentCount() {
        return this.segmentCount;
    }

    public long getLargeSegmentCount() {
        return this.largeSegmentCount;
    }

    public long getSessionLengthMs() {
        return this.sessionLengthMs;
    }

    public long getEventsQueued() {
        return this.eventsQueued;
    }

    public long getEventsDropped() {
        return this.eventsDropped;
    }

    public List<StreamingEvent> getStreamingEvents() {
        return this.streamingEvents;
    }
}

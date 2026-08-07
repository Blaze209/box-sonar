package io.split.android.client.service;

import io.split.android.client.dtos.AllSegmentsChange;
import io.split.android.client.dtos.Event;
import io.split.android.client.dtos.KeyImpression;
import io.split.android.client.dtos.TargetingRulesChange;
import io.split.android.client.service.http.HttpFetcher;
import io.split.android.client.service.http.HttpRecorder;
import io.split.android.client.service.http.mysegments.MySegmentsFetcherFactory;
import io.split.android.client.service.impressions.ImpressionsCount;
import io.split.android.client.service.impressions.unique.MTK;
import io.split.android.client.service.sseclient.SseAuthenticationResponse;
import io.split.android.client.telemetry.model.Config;
import io.split.android.client.telemetry.model.Stats;
import io.split.android.client.utils.Utils;
import java.util.List;

/* JADX INFO: loaded from: classes4.dex */
public class SplitApiFacade {
    private final HttpRecorder<List<Event>> mEventsRecorder;
    private final HttpRecorder<ImpressionsCount> mImpressionsCountRecorder;
    private final HttpRecorder<List<KeyImpression>> mImpressionsRecorder;
    private final MySegmentsFetcherFactory mMySegmentsFetcherFactory;
    private final HttpFetcher<TargetingRulesChange> mSplitFetcher;
    private final HttpFetcher<SseAuthenticationResponse> mSseAuthenticationFetcher;
    private final HttpRecorder<Config> mTelemetryConfigRecorder;
    private final HttpRecorder<Stats> mTelemetryStatsRecorder;
    private final HttpRecorder<MTK> mUniqueKeysRecorder;

    public SplitApiFacade(HttpFetcher<TargetingRulesChange> splitFetcher, MySegmentsFetcherFactory mySegmentsFetcherFactory, HttpFetcher<SseAuthenticationResponse> sseAuthenticationFetcher, HttpRecorder<List<Event>> eventsRecorder, HttpRecorder<List<KeyImpression>> impressionsRecorder, HttpRecorder<ImpressionsCount> impressionsCountRecorder, HttpRecorder<MTK> uniqueKeysRecorder, HttpRecorder<Config> telemetryConfigRecorder, HttpRecorder<Stats> telemetryStatsRecorder) {
        this.mSplitFetcher = (HttpFetcher) Utils.checkNotNull(splitFetcher);
        this.mMySegmentsFetcherFactory = (MySegmentsFetcherFactory) Utils.checkNotNull(mySegmentsFetcherFactory);
        this.mSseAuthenticationFetcher = (HttpFetcher) Utils.checkNotNull(sseAuthenticationFetcher);
        this.mEventsRecorder = (HttpRecorder) Utils.checkNotNull(eventsRecorder);
        this.mImpressionsRecorder = (HttpRecorder) Utils.checkNotNull(impressionsRecorder);
        this.mImpressionsCountRecorder = (HttpRecorder) Utils.checkNotNull(impressionsCountRecorder);
        this.mUniqueKeysRecorder = (HttpRecorder) Utils.checkNotNull(uniqueKeysRecorder);
        this.mTelemetryConfigRecorder = (HttpRecorder) Utils.checkNotNull(telemetryConfigRecorder);
        this.mTelemetryStatsRecorder = (HttpRecorder) Utils.checkNotNull(telemetryStatsRecorder);
    }

    public HttpFetcher<TargetingRulesChange> getSplitFetcher() {
        return this.mSplitFetcher;
    }

    public HttpFetcher<AllSegmentsChange> getMySegmentsFetcher(String matchingKey) {
        return this.mMySegmentsFetcherFactory.getFetcher(matchingKey);
    }

    public HttpFetcher<SseAuthenticationResponse> getSseAuthenticationFetcher() {
        return this.mSseAuthenticationFetcher;
    }

    public HttpRecorder<List<Event>> getEventsRecorder() {
        return this.mEventsRecorder;
    }

    public HttpRecorder<List<KeyImpression>> getImpressionsRecorder() {
        return this.mImpressionsRecorder;
    }

    public HttpRecorder<ImpressionsCount> getImpressionsCountRecorder() {
        return this.mImpressionsCountRecorder;
    }

    public HttpRecorder<MTK> getUniqueKeysRecorder() {
        return this.mUniqueKeysRecorder;
    }

    public HttpRecorder<Config> getTelemetryConfigRecorder() {
        return this.mTelemetryConfigRecorder;
    }

    public HttpRecorder<Stats> getTelemetryStatsRecorder() {
        return this.mTelemetryStatsRecorder;
    }
}

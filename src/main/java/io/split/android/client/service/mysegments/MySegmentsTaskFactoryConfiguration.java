package io.split.android.client.service.mysegments;

import io.split.android.client.dtos.AllSegmentsChange;
import io.split.android.client.events.SplitEventsManager;
import io.split.android.client.service.http.HttpFetcher;
import io.split.android.client.storage.mysegments.MySegmentsStorage;
import io.split.android.client.utils.Utils;

/* JADX INFO: loaded from: classes4.dex */
public class MySegmentsTaskFactoryConfiguration {
    private final SplitEventsManager mEventsManager;
    private final HttpFetcher<AllSegmentsChange> mHttpFetcher;
    private final LoadMySegmentsTaskConfig mLoadMySegmentsTaskConfig;
    private final MySegmentsStorage mMyLargeSegmentsStorage;
    private final MySegmentsUpdateTaskConfig mMyLargeSegmentsUpdateTaskConfig;
    private final MySegmentsStorage mMySegmentsStorage;
    private final MySegmentsSyncTaskConfig mMySegmentsSyncTaskConfig;
    private final MySegmentsUpdateTaskConfig mMySegmentsUpdateTaskConfig;

    private MySegmentsTaskFactoryConfiguration(HttpFetcher<AllSegmentsChange> httpFetcher, MySegmentsStorage storage, MySegmentsStorage myLargeSegmentsStorage, SplitEventsManager eventsManager, MySegmentsSyncTaskConfig mySegmentsSyncTaskConfig, MySegmentsUpdateTaskConfig mySegmentsUpdateTaskConfig, MySegmentsUpdateTaskConfig myLargeSegmentsUpdateTaskConfig, LoadMySegmentsTaskConfig loadMySegmentsTaskConfig) {
        this.mHttpFetcher = (HttpFetcher) Utils.checkNotNull(httpFetcher);
        this.mMySegmentsStorage = (MySegmentsStorage) Utils.checkNotNull(storage);
        this.mMyLargeSegmentsStorage = (MySegmentsStorage) Utils.checkNotNull(myLargeSegmentsStorage);
        this.mEventsManager = (SplitEventsManager) Utils.checkNotNull(eventsManager);
        this.mMySegmentsSyncTaskConfig = (MySegmentsSyncTaskConfig) Utils.checkNotNull(mySegmentsSyncTaskConfig);
        this.mMySegmentsUpdateTaskConfig = (MySegmentsUpdateTaskConfig) Utils.checkNotNull(mySegmentsUpdateTaskConfig);
        this.mMyLargeSegmentsUpdateTaskConfig = (MySegmentsUpdateTaskConfig) Utils.checkNotNull(myLargeSegmentsUpdateTaskConfig);
        this.mLoadMySegmentsTaskConfig = (LoadMySegmentsTaskConfig) Utils.checkNotNull(loadMySegmentsTaskConfig);
    }

    public HttpFetcher<AllSegmentsChange> getHttpFetcher() {
        return this.mHttpFetcher;
    }

    public MySegmentsStorage getMySegmentsStorage() {
        return this.mMySegmentsStorage;
    }

    public MySegmentsStorage getMyLargeSegmentsStorage() {
        return this.mMyLargeSegmentsStorage;
    }

    public SplitEventsManager getEventsManager() {
        return this.mEventsManager;
    }

    public MySegmentsSyncTaskConfig getMySegmentsSyncTaskConfig() {
        return this.mMySegmentsSyncTaskConfig;
    }

    public MySegmentsUpdateTaskConfig getMySegmentsUpdateTaskConfig() {
        return this.mMySegmentsUpdateTaskConfig;
    }

    public MySegmentsUpdateTaskConfig getMyLargeSegmentsUpdateTaskConfig() {
        return this.mMyLargeSegmentsUpdateTaskConfig;
    }

    public LoadMySegmentsTaskConfig getLoadMySegmentsTaskConfig() {
        return this.mLoadMySegmentsTaskConfig;
    }

    public static MySegmentsTaskFactoryConfiguration get(HttpFetcher<AllSegmentsChange> httpFetcher, MySegmentsStorage mySegmentsStorage, MySegmentsStorage myLargeSegmentsStorage, SplitEventsManager eventsManager) {
        return new MySegmentsTaskFactoryConfiguration(httpFetcher, mySegmentsStorage, myLargeSegmentsStorage, eventsManager, MySegmentsSyncTaskConfig.get(), MySegmentsUpdateTaskConfig.getForMySegments(), MySegmentsUpdateTaskConfig.getForMyLargeSegments(), LoadMySegmentsTaskConfig.get());
    }
}

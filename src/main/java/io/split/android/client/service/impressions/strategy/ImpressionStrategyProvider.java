package io.split.android.client.service.impressions.strategy;

import androidx.core.util.Pair;
import io.split.android.client.service.executor.SplitTaskExecutor;
import io.split.android.client.service.executor.SplitTaskType;
import io.split.android.client.service.impressions.ImpressionManagerRetryTimerProviderImpl;
import io.split.android.client.service.impressions.ImpressionsCounter;
import io.split.android.client.service.impressions.ImpressionsMode;
import io.split.android.client.service.impressions.ImpressionsTaskFactory;
import io.split.android.client.service.impressions.observer.ImpressionsObserverImpl;
import io.split.android.client.service.impressions.unique.UniqueKeysTrackerImpl;
import io.split.android.client.service.synchronizer.RecorderSyncHelperImpl;
import io.split.android.client.storage.common.SplitStorageContainer;
import io.split.android.client.telemetry.storage.TelemetryRuntimeProducer;

/* JADX INFO: loaded from: classes4.dex */
public class ImpressionStrategyProvider {
    private final ImpressionManagerRetryTimerProviderImpl mImpressionManagerRetryTimerProvider;
    private final ImpressionStrategyConfig mImpressionStrategyConfig;
    private final ImpressionsCounter mImpressionsCounter;
    private final NoneStrategy mNoneStrategy;
    private final NoneTracker mNoneTracker;
    private final SplitTaskExecutor mSplitTaskExecutor;
    private final ImpressionsTaskFactory mSplitTaskFactory;
    private final SplitStorageContainer mStorageContainer;
    private final TelemetryRuntimeProducer mTelemetryStorage;

    public ImpressionStrategyProvider(SplitTaskExecutor splitTaskExecutor, SplitStorageContainer storageContainer, ImpressionsTaskFactory splitTaskFactory, TelemetryRuntimeProducer telemetryStorage, ImpressionStrategyConfig config) {
        this.mSplitTaskExecutor = splitTaskExecutor;
        this.mStorageContainer = storageContainer;
        this.mSplitTaskFactory = splitTaskFactory;
        this.mTelemetryStorage = telemetryStorage;
        this.mImpressionStrategyConfig = config;
        ImpressionsCounter impressionsCounter = new ImpressionsCounter(config.getDedupeTimeIntervalInMs());
        this.mImpressionsCounter = impressionsCounter;
        ImpressionManagerRetryTimerProviderImpl impressionManagerRetryTimerProviderImpl = new ImpressionManagerRetryTimerProviderImpl(splitTaskExecutor);
        this.mImpressionManagerRetryTimerProvider = impressionManagerRetryTimerProviderImpl;
        UniqueKeysTrackerImpl uniqueKeysTrackerImpl = new UniqueKeysTrackerImpl();
        this.mNoneStrategy = new NoneStrategy(splitTaskExecutor, splitTaskFactory, impressionsCounter, uniqueKeysTrackerImpl, config.isUserConsentGranted());
        this.mNoneTracker = new NoneTracker(splitTaskExecutor, splitTaskFactory, impressionsCounter, uniqueKeysTrackerImpl, impressionManagerRetryTimerProviderImpl.getImpressionsCountTimer(), impressionManagerRetryTimerProviderImpl.getUniqueKeysTimer(), config.getImpressionsCounterRefreshRate(), config.getUniqueKeysRefreshRate(), config.isUserConsentGranted());
    }

    public Pair<ProcessStrategy, PeriodicTracker> getStrategy(ImpressionsMode mode) {
        ImpressionsObserverImpl impressionsObserverImpl = new ImpressionsObserverImpl(this.mStorageContainer.getImpressionsObserverCachePersistentStorage(), 2000);
        RecorderSyncHelperImpl recorderSyncHelperImpl = new RecorderSyncHelperImpl(SplitTaskType.IMPRESSIONS_RECORDER, this.mStorageContainer.getImpressionsStorage(), this.mImpressionStrategyConfig.getImpressionsQueueSize(), this.mImpressionStrategyConfig.getImpressionsChunkSize(), this.mSplitTaskExecutor);
        int i = AnonymousClass1.$SwitchMap$io$split$android$client$service$impressions$ImpressionsMode[mode.ordinal()];
        if (i == 1) {
            return new Pair<>(new DebugStrategy(impressionsObserverImpl, recorderSyncHelperImpl, this.mSplitTaskExecutor, this.mSplitTaskFactory, this.mTelemetryStorage), new DebugTracker(impressionsObserverImpl, recorderSyncHelperImpl, this.mSplitTaskExecutor, this.mSplitTaskFactory, this.mImpressionManagerRetryTimerProvider.getImpressionsTimer(), this.mImpressionStrategyConfig.getImpressionsRefreshRate()));
        }
        if (i == 2) {
            return getNoneComponents();
        }
        return new Pair<>(new OptimizedStrategy(impressionsObserverImpl, this.mImpressionsCounter, recorderSyncHelperImpl, this.mSplitTaskExecutor, this.mSplitTaskFactory, this.mTelemetryStorage, this.mImpressionStrategyConfig.getDedupeTimeIntervalInMs()), new OptimizedTracker(impressionsObserverImpl, recorderSyncHelperImpl, this.mSplitTaskExecutor, this.mSplitTaskFactory, this.mImpressionManagerRetryTimerProvider.getImpressionsTimer(), this.mImpressionStrategyConfig.getImpressionsRefreshRate(), this.mImpressionStrategyConfig.isUserConsentGranted()));
    }

    /* JADX INFO: renamed from: io.split.android.client.service.impressions.strategy.ImpressionStrategyProvider$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$io$split$android$client$service$impressions$ImpressionsMode;

        static {
            int[] iArr = new int[ImpressionsMode.values().length];
            $SwitchMap$io$split$android$client$service$impressions$ImpressionsMode = iArr;
            try {
                iArr[ImpressionsMode.DEBUG.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$io$split$android$client$service$impressions$ImpressionsMode[ImpressionsMode.NONE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public Pair<ProcessStrategy, PeriodicTracker> getNoneComponents() {
        return new Pair<>(this.mNoneStrategy, this.mNoneTracker);
    }
}

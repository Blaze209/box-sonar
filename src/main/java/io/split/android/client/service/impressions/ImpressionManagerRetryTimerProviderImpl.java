package io.split.android.client.service.impressions;

import androidx.core.util.Supplier;
import io.split.android.client.RetryBackoffCounterTimerFactory;
import io.split.android.client.service.executor.SplitTaskExecutor;
import io.split.android.client.service.sseclient.sseclient.RetryBackoffCounterTimer;
import io.split.android.client.utils.Utils;

/* JADX INFO: loaded from: classes4.dex */
public class ImpressionManagerRetryTimerProviderImpl implements ImpressionManagerRetryTimerProvider {
    private final Supplier<RetryBackoffCounterTimer> mImpressionsCountRetrySupplier;
    private final Supplier<RetryBackoffCounterTimer> mImpressionsRetrySupplier;
    private final RetryBackoffCounterTimerFactory mRetryBackoffCounterTimerFactory;
    private final SplitTaskExecutor mTaskExecutor;
    private final Supplier<RetryBackoffCounterTimer> mUniqueKeysRetrySupplier;

    public ImpressionManagerRetryTimerProviderImpl(SplitTaskExecutor taskExecutor) {
        this(taskExecutor, new RetryBackoffCounterTimerFactory());
    }

    ImpressionManagerRetryTimerProviderImpl(SplitTaskExecutor taskExecutor, RetryBackoffCounterTimerFactory retryBackoffCounterTimerFactory) {
        this.mUniqueKeysRetrySupplier = new MemoizedSupplier(buildBackoffTimerDelegate());
        this.mImpressionsRetrySupplier = new MemoizedSupplier(buildBackoffTimerDelegate());
        this.mImpressionsCountRetrySupplier = new MemoizedSupplier(buildBackoffTimerDelegate());
        this.mRetryBackoffCounterTimerFactory = (RetryBackoffCounterTimerFactory) Utils.checkNotNull(retryBackoffCounterTimerFactory);
        this.mTaskExecutor = (SplitTaskExecutor) Utils.checkNotNull(taskExecutor);
    }

    @Override // io.split.android.client.service.impressions.ImpressionManagerRetryTimerProvider
    public RetryBackoffCounterTimer getUniqueKeysTimer() {
        return this.mUniqueKeysRetrySupplier.get();
    }

    @Override // io.split.android.client.service.impressions.ImpressionManagerRetryTimerProvider
    public RetryBackoffCounterTimer getImpressionsTimer() {
        return this.mImpressionsRetrySupplier.get();
    }

    @Override // io.split.android.client.service.impressions.ImpressionManagerRetryTimerProvider
    public RetryBackoffCounterTimer getImpressionsCountTimer() {
        return this.mImpressionsCountRetrySupplier.get();
    }

    private Supplier<RetryBackoffCounterTimer> buildBackoffTimerDelegate() {
        return new Supplier<RetryBackoffCounterTimer>() { // from class: io.split.android.client.service.impressions.ImpressionManagerRetryTimerProviderImpl.1
            /* JADX WARN: Can't rename method to resolve collision */
            @Override // androidx.core.util.Supplier
            public RetryBackoffCounterTimer get() {
                return ImpressionManagerRetryTimerProviderImpl.this.mRetryBackoffCounterTimerFactory.createWithFixedInterval(ImpressionManagerRetryTimerProviderImpl.this.mTaskExecutor, 1, 3);
            }
        };
    }
}

package io.split.android.client.localhost;

import io.split.android.client.SplitClientConfig;
import io.split.android.client.lifecycle.SplitLifecycleAware;
import io.split.android.client.service.executor.SplitTaskExecutor;
import io.split.android.client.service.splits.LoadSplitsTask;
import io.split.android.client.storage.splits.SplitsStorage;
import io.split.android.client.utils.Utils;
import javax.security.auth.Destroyable;

/* JADX INFO: loaded from: classes4.dex */
public class LocalhostSynchronizer implements SplitLifecycleAware, Destroyable {
    private final int mRefreshRate;
    private final String mSplitsFilterQueryStringFromConfig;
    private final SplitsStorage mSplitsStorage;
    private final SplitTaskExecutor mTaskExecutor;

    public LocalhostSynchronizer(SplitTaskExecutor taskExecutor, SplitClientConfig splitClientConfig, SplitsStorage splitsStorage, String splitsFilterQueryStringFromConfig) {
        this.mTaskExecutor = (SplitTaskExecutor) Utils.checkNotNull(taskExecutor);
        this.mRefreshRate = ((SplitClientConfig) Utils.checkNotNull(splitClientConfig)).offlineRefreshRate();
        this.mSplitsStorage = (SplitsStorage) Utils.checkNotNull(splitsStorage);
        this.mSplitsFilterQueryStringFromConfig = splitsFilterQueryStringFromConfig;
    }

    public void start() {
        LoadSplitsTask loadSplitsTask = new LoadSplitsTask(this.mSplitsStorage, this.mSplitsFilterQueryStringFromConfig, null);
        int i = this.mRefreshRate;
        if (i > 0) {
            this.mTaskExecutor.schedule(loadSplitsTask, 0L, i, null);
        } else {
            this.mTaskExecutor.submit(loadSplitsTask, null);
        }
    }

    @Override // io.split.android.client.lifecycle.SplitLifecycleAware
    public void pause() {
        this.mTaskExecutor.pause();
    }

    @Override // io.split.android.client.lifecycle.SplitLifecycleAware
    public void resume() {
        this.mTaskExecutor.resume();
    }

    public void stop() {
        this.mTaskExecutor.stop();
    }
}

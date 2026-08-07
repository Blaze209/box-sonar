package io.split.android.client.events.executors;

import io.split.android.client.SplitClient;
import io.split.android.client.utils.Utils;

/* JADX INFO: loaded from: classes4.dex */
public class SplitEventExecutorResourcesImpl implements SplitEventExecutorResources {
    private SplitClient mClient;

    @Override // io.split.android.client.events.executors.SplitEventExecutorResources
    public void setSplitClient(SplitClient client) {
        this.mClient = (SplitClient) Utils.checkNotNull(client);
    }

    @Override // io.split.android.client.events.executors.SplitEventExecutorResources
    public SplitClient getSplitClient() {
        return this.mClient;
    }
}

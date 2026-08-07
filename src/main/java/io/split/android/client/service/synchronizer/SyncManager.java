package io.split.android.client.service.synchronizer;

import io.split.android.client.dtos.Event;
import io.split.android.client.impressions.DecoratedImpression;
import io.split.android.client.lifecycle.SplitLifecycleAware;
import io.split.android.client.shared.UserConsent;

/* JADX INFO: loaded from: classes4.dex */
public interface SyncManager extends SplitLifecycleAware {
    void flush();

    void pushEvent(Event event);

    void pushImpression(DecoratedImpression impression);

    void setupUserConsent(UserConsent status);

    void start();

    void stop();
}

package io.split.android.client.service.synchronizer.mysegments;

import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public interface MySegmentsWorkManagerWrapper {
    void removeWork();

    void scheduleMySegmentsWork(Set<String> keys);
}

package io.split.android.client.storage.mysegments;

import io.split.android.client.storage.RolloutDefinitionsCache;

/* JADX INFO: loaded from: classes4.dex */
public interface MySegmentsStorageContainer extends RolloutDefinitionsCache {
    MySegmentsStorage getStorageForKey(String matchingKey);

    long getUniqueAmount();
}

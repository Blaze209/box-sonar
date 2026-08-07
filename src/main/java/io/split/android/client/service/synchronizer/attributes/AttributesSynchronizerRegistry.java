package io.split.android.client.service.synchronizer.attributes;

/* JADX INFO: loaded from: classes4.dex */
public interface AttributesSynchronizerRegistry {
    void registerAttributesSynchronizer(String userKey, AttributesSynchronizer attributesSynchronizer);

    void unregisterAttributesSynchronizer(String userKey);
}

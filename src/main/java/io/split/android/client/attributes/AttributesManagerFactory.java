package io.split.android.client.attributes;

import io.split.android.client.storage.attributes.AttributesStorage;

/* JADX INFO: loaded from: classes4.dex */
public interface AttributesManagerFactory {
    AttributesManager getManager(String matchingKey, AttributesStorage attributesStorage);
}

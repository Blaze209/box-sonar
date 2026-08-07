package io.split.android.client.validators;

import io.split.android.client.api.Key;
import io.split.android.client.attributes.AttributesManager;
import io.split.android.client.events.ListenableEventsManager;

/* JADX INFO: loaded from: classes4.dex */
public interface TreatmentManagerFactory {
    TreatmentManager getTreatmentManager(Key key, ListenableEventsManager eventsManager, AttributesManager attributesManager);
}

package io.split.android.client.service.synchronizer.attributes;

import io.split.android.client.events.SplitEventsManager;
import io.split.android.client.service.attributes.AttributeTaskFactory;

/* JADX INFO: loaded from: classes4.dex */
public interface AttributesSynchronizerFactory {
    AttributesSynchronizer getSynchronizer(AttributeTaskFactory attributeTaskFactory, SplitEventsManager splitEventsManager);
}

package io.split.android.client.service.synchronizer.attributes;

import io.split.android.client.events.SplitEventsManager;
import io.split.android.client.service.attributes.AttributeTaskFactory;
import io.split.android.client.service.executor.SplitTaskExecutor;
import io.split.android.client.storage.attributes.PersistentAttributesStorage;
import io.split.android.client.utils.Utils;

/* JADX INFO: loaded from: classes4.dex */
public class AttributesSynchronizerFactoryImpl implements AttributesSynchronizerFactory {
    private final PersistentAttributesStorage mPersistentAttributeStorage;
    private final SplitTaskExecutor mTaskExecutor;

    public AttributesSynchronizerFactoryImpl(SplitTaskExecutor taskExecutor, PersistentAttributesStorage persistentAttributesStorage) {
        this.mTaskExecutor = (SplitTaskExecutor) Utils.checkNotNull(taskExecutor);
        this.mPersistentAttributeStorage = persistentAttributesStorage;
    }

    @Override // io.split.android.client.service.synchronizer.attributes.AttributesSynchronizerFactory
    public AttributesSynchronizer getSynchronizer(AttributeTaskFactory attributeTaskFactory, SplitEventsManager splitEventsManager) {
        return new AttributesSynchronizerImpl(this.mTaskExecutor, splitEventsManager, attributeTaskFactory, this.mPersistentAttributeStorage);
    }
}

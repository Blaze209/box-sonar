package io.split.android.client.attributes;

import io.split.android.client.service.attributes.AttributeTaskFactoryImpl;
import io.split.android.client.service.executor.SplitTaskExecutor;
import io.split.android.client.storage.attributes.AttributesStorage;
import io.split.android.client.storage.attributes.PersistentAttributesStorage;
import io.split.android.client.utils.Utils;
import io.split.android.client.validators.AttributesValidator;
import io.split.android.client.validators.ValidationMessageLogger;

/* JADX INFO: loaded from: classes4.dex */
public class AttributesManagerFactoryImpl implements AttributesManagerFactory {
    private final AttributesValidator mAttributesValidator;
    private final PersistentAttributesStorage mPersistentAttributesStorage;
    private final SplitTaskExecutor mSplitTaskExecutor;
    private final ValidationMessageLogger mValidationMessageLogger;

    public AttributesManagerFactoryImpl(AttributesValidator attributesValidator, ValidationMessageLogger validationMessageLogger) {
        this(attributesValidator, validationMessageLogger, null, null);
    }

    public AttributesManagerFactoryImpl(AttributesValidator attributesValidator, ValidationMessageLogger validationMessageLogger, PersistentAttributesStorage persistentAttributesStorage, SplitTaskExecutor splitTaskExecutor) {
        this.mAttributesValidator = (AttributesValidator) Utils.checkNotNull(attributesValidator);
        this.mValidationMessageLogger = (ValidationMessageLogger) Utils.checkNotNull(validationMessageLogger);
        this.mPersistentAttributesStorage = persistentAttributesStorage;
        this.mSplitTaskExecutor = splitTaskExecutor;
    }

    @Override // io.split.android.client.attributes.AttributesManagerFactory
    public AttributesManager getManager(String matchingKey, AttributesStorage attributesStorage) {
        return new AttributesManagerImpl(attributesStorage, this.mAttributesValidator, this.mValidationMessageLogger, this.mPersistentAttributesStorage, new AttributeTaskFactoryImpl(matchingKey, attributesStorage), this.mSplitTaskExecutor);
    }
}

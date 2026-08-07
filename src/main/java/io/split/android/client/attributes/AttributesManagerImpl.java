package io.split.android.client.attributes;

import io.split.android.client.service.attributes.AttributeTaskFactory;
import io.split.android.client.service.executor.SplitTaskExecutor;
import io.split.android.client.storage.attributes.AttributesStorage;
import io.split.android.client.storage.attributes.PersistentAttributesStorage;
import io.split.android.client.utils.Utils;
import io.split.android.client.validators.AttributesValidator;
import io.split.android.client.validators.ValidationMessageLogger;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class AttributesManagerImpl implements AttributesManager {
    private final AttributeTaskFactory mAttributeTaskFactory;
    private final AttributesStorage mAttributesStorage;
    private final AttributesValidator mAttributesValidator;
    private final PersistentAttributesStorage mPersistentAttributesStorage;
    private final SplitTaskExecutor mSplitTaskExecutor;
    private final ValidationMessageLogger mValidationMessageLogger;

    AttributesManagerImpl(AttributesStorage attributesStorage, AttributesValidator attributesValidator, ValidationMessageLogger validationMessageLogger) {
        this.mAttributesStorage = (AttributesStorage) Utils.checkNotNull(attributesStorage);
        this.mAttributesValidator = (AttributesValidator) Utils.checkNotNull(attributesValidator);
        this.mValidationMessageLogger = (ValidationMessageLogger) Utils.checkNotNull(validationMessageLogger);
        this.mPersistentAttributesStorage = null;
        this.mAttributeTaskFactory = null;
        this.mSplitTaskExecutor = null;
    }

    AttributesManagerImpl(AttributesStorage attributesStorage, AttributesValidator attributesValidator, ValidationMessageLogger validationMessageLogger, PersistentAttributesStorage persistentAttributesStorage, AttributeTaskFactory attributeTaskFactory, SplitTaskExecutor splitTaskExecutor) {
        this.mAttributesStorage = (AttributesStorage) Utils.checkNotNull(attributesStorage);
        this.mAttributesValidator = (AttributesValidator) Utils.checkNotNull(attributesValidator);
        this.mValidationMessageLogger = (ValidationMessageLogger) Utils.checkNotNull(validationMessageLogger);
        this.mPersistentAttributesStorage = persistentAttributesStorage;
        this.mAttributeTaskFactory = attributeTaskFactory;
        this.mSplitTaskExecutor = splitTaskExecutor;
    }

    @Override // io.split.android.client.attributes.AttributesManager
    public boolean setAttribute(String attributeName, Object value) {
        if (!this.mAttributesValidator.isValid(value)) {
            logValidationWarning(attributeName);
            return false;
        }
        this.mAttributesStorage.set(attributeName, value);
        submitUpdateTask(this.mPersistentAttributesStorage, this.mAttributesStorage.getAll());
        return true;
    }

    @Override // io.split.android.client.attributes.AttributesManager
    public Object getAttribute(String attributeName) {
        return this.mAttributesStorage.get(attributeName);
    }

    @Override // io.split.android.client.attributes.AttributesManager
    public boolean setAttributes(Map<String, Object> attributes) {
        for (Map.Entry<String, Object> entry : attributes.entrySet()) {
            if (!this.mAttributesValidator.isValid(entry.getValue())) {
                logValidationWarning(entry.getKey());
                return false;
            }
        }
        this.mAttributesStorage.set(attributes);
        submitUpdateTask(this.mPersistentAttributesStorage, this.mAttributesStorage.getAll());
        return true;
    }

    private void logValidationWarning(String key) {
        this.mValidationMessageLogger.w("You passed an invalid attribute value for " + key + ", acceptable types are String, double, float, long, int, boolean or Collections", "split attributes");
    }

    @Override // io.split.android.client.attributes.AttributesManager
    public Map<String, Object> getAllAttributes() {
        return this.mAttributesStorage.getAll();
    }

    @Override // io.split.android.client.attributes.AttributesManager
    public boolean removeAttribute(String attributeName) {
        this.mAttributesStorage.remove(attributeName);
        submitUpdateTask(this.mPersistentAttributesStorage, this.mAttributesStorage.getAll());
        return true;
    }

    @Override // io.split.android.client.attributes.AttributesManager
    public boolean clearAttributes() {
        this.mAttributesStorage.clear();
        submitClearTask(this.mPersistentAttributesStorage);
        return true;
    }

    private void submitUpdateTask(PersistentAttributesStorage persistentStorage, Map<String, Object> mInMemoryAttributes) {
        SplitTaskExecutor splitTaskExecutor;
        AttributeTaskFactory attributeTaskFactory;
        if (persistentStorage == null || (splitTaskExecutor = this.mSplitTaskExecutor) == null || (attributeTaskFactory = this.mAttributeTaskFactory) == null) {
            return;
        }
        splitTaskExecutor.schedule(attributeTaskFactory.createAttributeUpdateTask(persistentStorage, mInMemoryAttributes), 5L, null);
    }

    private void submitClearTask(PersistentAttributesStorage persistentStorage) {
        SplitTaskExecutor splitTaskExecutor;
        AttributeTaskFactory attributeTaskFactory;
        if (persistentStorage == null || (splitTaskExecutor = this.mSplitTaskExecutor) == null || (attributeTaskFactory = this.mAttributeTaskFactory) == null) {
            return;
        }
        splitTaskExecutor.schedule(attributeTaskFactory.createAttributeClearTask(persistentStorage), 5L, null);
    }
}

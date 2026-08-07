package io.split.android.client.validators;

import io.split.android.client.Evaluator;
import io.split.android.client.EvaluatorImpl;
import io.split.android.client.FlagSetsFilter;
import io.split.android.client.PropertyValidatorImpl;
import io.split.android.client.api.Key;
import io.split.android.client.attributes.AttributesManager;
import io.split.android.client.attributes.AttributesMerger;
import io.split.android.client.events.ListenableEventsManager;
import io.split.android.client.impressions.ImpressionListener;
import io.split.android.client.storage.splits.SplitsStorage;
import io.split.android.client.telemetry.storage.TelemetryStorageProducer;
import io.split.android.client.utils.Utils;
import io.split.android.engine.experiments.SplitParser;

/* JADX INFO: loaded from: classes4.dex */
public class TreatmentManagerFactoryImpl implements TreatmentManagerFactory {
    private final AttributesMerger mAttributesMerger;
    private final ImpressionListener.FederatedImpressionListener mCustomerImpressionListener;
    private final Evaluator mEvaluator;
    private final FlagSetsFilter mFlagSetsFilter;
    private final KeyValidator mKeyValidator;
    private final boolean mLabelsEnabled;
    private final SplitValidator mSplitValidator;
    private final SplitsStorage mSplitsStorage;
    private final TelemetryStorageProducer mTelemetryStorageProducer;
    private final ValidationMessageLogger mValidationMessageLogger = new ValidationMessageLoggerImpl();
    private final SplitFilterValidator mFlagSetsValidator = new FlagSetsValidatorImpl();
    private final PropertyValidator mPropertyValidator = new PropertyValidatorImpl();

    public TreatmentManagerFactoryImpl(KeyValidator keyValidator, SplitValidator splitValidator, ImpressionListener.FederatedImpressionListener customerImpressionListener, boolean labelsEnabled, AttributesMerger attributesMerger, TelemetryStorageProducer telemetryStorageProducer, SplitParser splitParser, FlagSetsFilter flagSetsFilter, SplitsStorage splitsStorage) {
        this.mKeyValidator = (KeyValidator) Utils.checkNotNull(keyValidator);
        this.mSplitValidator = (SplitValidator) Utils.checkNotNull(splitValidator);
        this.mCustomerImpressionListener = (ImpressionListener.FederatedImpressionListener) Utils.checkNotNull(customerImpressionListener);
        this.mLabelsEnabled = labelsEnabled;
        this.mAttributesMerger = (AttributesMerger) Utils.checkNotNull(attributesMerger);
        this.mTelemetryStorageProducer = (TelemetryStorageProducer) Utils.checkNotNull(telemetryStorageProducer);
        this.mEvaluator = new EvaluatorImpl(splitsStorage, splitParser);
        this.mFlagSetsFilter = flagSetsFilter;
        this.mSplitsStorage = (SplitsStorage) Utils.checkNotNull(splitsStorage);
    }

    @Override // io.split.android.client.validators.TreatmentManagerFactory
    public TreatmentManager getTreatmentManager(Key key, ListenableEventsManager eventsManager, AttributesManager attributesManager) {
        return new TreatmentManagerImpl(key.matchingKey(), key.bucketingKey(), this.mEvaluator, this.mKeyValidator, this.mSplitValidator, this.mCustomerImpressionListener, this.mLabelsEnabled, eventsManager, attributesManager, this.mAttributesMerger, this.mTelemetryStorageProducer, this.mFlagSetsFilter, this.mSplitsStorage, this.mValidationMessageLogger, this.mFlagSetsValidator, this.mPropertyValidator);
    }
}

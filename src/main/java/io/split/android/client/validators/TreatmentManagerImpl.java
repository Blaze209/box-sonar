package io.split.android.client.validators;

import com.microsoft.identity.common.java.providers.microsoft.MicrosoftAuthorizationErrorResponse;
import io.split.android.client.EvaluationOptions;
import io.split.android.client.EvaluationResult;
import io.split.android.client.Evaluator;
import io.split.android.client.FlagSetsFilter;
import io.split.android.client.SplitResult;
import io.split.android.client.TreatmentLabels;
import io.split.android.client.attributes.AttributesManager;
import io.split.android.client.attributes.AttributesMerger;
import io.split.android.client.events.ListenableEventsManager;
import io.split.android.client.events.SplitEvent;
import io.split.android.client.impressions.DecoratedImpression;
import io.split.android.client.impressions.Impression;
import io.split.android.client.impressions.ImpressionListener;
import io.split.android.client.storage.splits.SplitsStorage;
import io.split.android.client.telemetry.model.Method;
import io.split.android.client.telemetry.storage.TelemetryStorageProducer;
import io.split.android.client.utils.Json;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;
import io.split.android.grammar.Treatments;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes4.dex */
public class TreatmentManagerImpl implements TreatmentManager {
    private final AttributesManager mAttributesManager;
    private final AttributesMerger mAttributesMerger;
    private final String mBucketingKey;
    private final Evaluator mEvaluator;
    private final ListenableEventsManager mEventsManager;
    private final FlagSetsFilter mFlagSetsFilter;
    private final SplitFilterValidator mFlagSetsValidator;
    private final ImpressionListener.FederatedImpressionListener mImpressionListener;
    private final KeyValidator mKeyValidator;
    private final boolean mLabelsEnabled;
    private final String mMatchingKey;
    private final PropertyValidator mPropertyValidator;
    private final SplitValidator mSplitValidator;
    private final SplitsStorage mSplitsStorage;
    private final TelemetryStorageProducer mTelemetryStorageProducer;
    private final ValidationMessageLogger mValidationLogger;

    interface ResultTransformer<T> {
        static SplitResult identity(SplitResult splitResult) {
            return splitResult;
        }

        T transform(SplitResult splitResult);
    }

    public TreatmentManagerImpl(String matchingKey, String bucketingKey, Evaluator evaluator, KeyValidator keyValidator, SplitValidator splitValidator, ImpressionListener.FederatedImpressionListener impressionListener, boolean labelsEnabled, ListenableEventsManager eventsManager, AttributesManager attributesManager, AttributesMerger attributesMerger, TelemetryStorageProducer telemetryStorageProducer, FlagSetsFilter flagSetsFilter, SplitsStorage splitsStorage, ValidationMessageLogger validationLogger, SplitFilterValidator flagSetsValidator, PropertyValidator propertyValidator) {
        this.mEvaluator = evaluator;
        this.mKeyValidator = keyValidator;
        this.mSplitValidator = splitValidator;
        this.mMatchingKey = matchingKey;
        this.mBucketingKey = bucketingKey;
        this.mImpressionListener = impressionListener;
        this.mLabelsEnabled = labelsEnabled;
        this.mEventsManager = eventsManager;
        this.mValidationLogger = (ValidationMessageLogger) Utils.checkNotNull(validationLogger);
        this.mAttributesManager = (AttributesManager) Utils.checkNotNull(attributesManager);
        this.mAttributesMerger = (AttributesMerger) Utils.checkNotNull(attributesMerger);
        this.mTelemetryStorageProducer = (TelemetryStorageProducer) Utils.checkNotNull(telemetryStorageProducer);
        this.mFlagSetsFilter = flagSetsFilter;
        this.mSplitsStorage = (SplitsStorage) Utils.checkNotNull(splitsStorage);
        this.mFlagSetsValidator = (SplitFilterValidator) Utils.checkNotNull(flagSetsValidator);
        this.mPropertyValidator = (PropertyValidator) Utils.checkNotNull(propertyValidator);
    }

    @Override // io.split.android.client.validators.TreatmentManager
    public String getTreatment(String split, Map<String, Object> attributes, EvaluationOptions evaluationOptions, boolean isClientDestroyed) {
        TreatmentManagerImpl treatmentManagerImpl;
        try {
            treatmentManagerImpl = this;
            try {
                String str = (String) treatmentManagerImpl.getTreatmentsWithConfigGeneric(Collections.singletonList(split), null, attributes, evaluationOptions, isClientDestroyed, new TreatmentManagerImpl$$ExternalSyntheticLambda1(), Method.TREATMENT).get(split);
                return str == null ? Treatments.CONTROL : str;
            } catch (Exception e) {
                e = e;
                Logger.e("Client " + Method.TREATMENT.getMethod() + " exception", e);
                treatmentManagerImpl.mTelemetryStorageProducer.recordException(Method.TREATMENT);
                return Treatments.CONTROL;
            }
        } catch (Exception e2) {
            e = e2;
            treatmentManagerImpl = this;
        }
    }

    @Override // io.split.android.client.validators.TreatmentManager
    public SplitResult getTreatmentWithConfig(String split, Map<String, Object> attributes, EvaluationOptions evaluationOptions, boolean isClientDestroyed) {
        TreatmentManagerImpl treatmentManagerImpl;
        try {
            treatmentManagerImpl = this;
            try {
                SplitResult splitResult = (SplitResult) treatmentManagerImpl.getTreatmentsWithConfigGeneric(Collections.singletonList(split), null, attributes, evaluationOptions, isClientDestroyed, new TreatmentManagerImpl$$ExternalSyntheticLambda0(), Method.TREATMENT_WITH_CONFIG).get(split);
                return splitResult == null ? new SplitResult(Treatments.CONTROL) : splitResult;
            } catch (Exception e) {
                e = e;
                Logger.e("Client " + Method.TREATMENT_WITH_CONFIG.getMethod() + " exception", e);
                treatmentManagerImpl.mTelemetryStorageProducer.recordException(Method.TREATMENT_WITH_CONFIG);
                return new SplitResult(Treatments.CONTROL);
            }
        } catch (Exception e2) {
            e = e2;
            treatmentManagerImpl = this;
        }
    }

    @Override // io.split.android.client.validators.TreatmentManager
    public Map<String, String> getTreatments(List<String> splits, Map<String, Object> attributes, EvaluationOptions evaluationOptions, boolean isClientDestroyed) {
        return getTreatmentsWithConfigGeneric(splits, null, attributes, evaluationOptions, isClientDestroyed, new TreatmentManagerImpl$$ExternalSyntheticLambda1(), Method.TREATMENTS);
    }

    @Override // io.split.android.client.validators.TreatmentManager
    public Map<String, SplitResult> getTreatmentsWithConfig(List<String> splits, Map<String, Object> attributes, EvaluationOptions evaluationOptions, boolean isClientDestroyed) {
        return getTreatmentsWithConfigGeneric(splits, null, attributes, evaluationOptions, isClientDestroyed, new TreatmentManagerImpl$$ExternalSyntheticLambda0(), Method.TREATMENTS_WITH_CONFIG);
    }

    @Override // io.split.android.client.validators.TreatmentManager
    public Map<String, String> getTreatmentsByFlagSet(String flagSet, Map<String, Object> attributes, EvaluationOptions evaluationOptions, boolean isClientDestroyed) {
        return getTreatmentsWithConfigGeneric(null, Collections.singletonList(flagSet), attributes, evaluationOptions, isClientDestroyed, new TreatmentManagerImpl$$ExternalSyntheticLambda1(), Method.TREATMENTS_BY_FLAG_SET);
    }

    @Override // io.split.android.client.validators.TreatmentManager
    public Map<String, String> getTreatmentsByFlagSets(List<String> flagSets, Map<String, Object> attributes, EvaluationOptions evaluationOptions, boolean isClientDestroyed) {
        return getTreatmentsWithConfigGeneric(null, flagSets, attributes, evaluationOptions, isClientDestroyed, new TreatmentManagerImpl$$ExternalSyntheticLambda1(), Method.TREATMENTS_BY_FLAG_SETS);
    }

    @Override // io.split.android.client.validators.TreatmentManager
    public Map<String, SplitResult> getTreatmentsWithConfigByFlagSet(String flagSet, Map<String, Object> attributes, EvaluationOptions evaluationOptions, boolean isClientDestroyed) {
        return getTreatmentsWithConfigGeneric(null, Collections.singletonList(flagSet), attributes, evaluationOptions, isClientDestroyed, new TreatmentManagerImpl$$ExternalSyntheticLambda0(), Method.TREATMENTS_WITH_CONFIG_BY_FLAG_SET);
    }

    @Override // io.split.android.client.validators.TreatmentManager
    public Map<String, SplitResult> getTreatmentsWithConfigByFlagSets(List<String> flagSets, Map<String, Object> attributes, EvaluationOptions evaluationOptions, boolean isClientDestroyed) {
        return getTreatmentsWithConfigGeneric(null, flagSets, attributes, evaluationOptions, isClientDestroyed, new TreatmentManagerImpl$$ExternalSyntheticLambda0(), Method.TREATMENTS_WITH_CONFIG_BY_FLAG_SETS);
    }

    private <T> Map<String, T> getTreatmentsWithConfigGeneric(List<String> names, List<String> flagSets, Map<String, Object> attributes, EvaluationOptions evaluationOptions, boolean isClientDestroyed, ResultTransformer<T> resultTransformer, Method telemetryMethodName) {
        String method = telemetryMethodName.getMethod();
        try {
            if (isClientDestroyed) {
                this.mValidationLogger.e("Client has already been destroyed - no calls possible", method);
                return getControlTreatmentsForSplitsWithConfig(names, method, resultTransformer);
            }
            ValidationErrorInfo validationErrorInfoValidate = this.mKeyValidator.validate(this.mMatchingKey, this.mBucketingKey);
            if (validationErrorInfoValidate != null) {
                this.mValidationLogger.e(validationErrorInfoValidate, method);
                return getControlTreatmentsForSplitsWithConfig(names, method, resultTransformer);
            }
            if (names == null) {
                if (flagSets != null) {
                    names = getNamesFromSet(method, flagSets);
                } else {
                    names = new ArrayList();
                }
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            boolean z = false;
            try {
                Map<String, Object> mapMerge = this.mAttributesMerger.merge(this.mAttributesManager.getAllAttributes(), attributes);
                HashMap map = new HashMap();
                for (String str : names) {
                    TreatmentResult treatmentWithConfigWithoutMetrics = getTreatmentWithConfigWithoutMetrics(str, mapMerge, method, evaluationOptions);
                    map.put(str, resultTransformer.transform(treatmentWithConfigWithoutMetrics.getSplitResult()));
                    if (treatmentWithConfigWithoutMetrics.isException()) {
                        z = true;
                    }
                }
                recordLatency(telemetryMethodName, jCurrentTimeMillis);
                if (z) {
                    this.mTelemetryStorageProducer.recordException(telemetryMethodName);
                }
                return map;
            } catch (Throwable th) {
                recordLatency(telemetryMethodName, jCurrentTimeMillis);
                if (z) {
                    this.mTelemetryStorageProducer.recordException(telemetryMethodName);
                }
                throw th;
            }
        } catch (Exception e) {
            Logger.e("Client " + method + " exception", e);
            this.mTelemetryStorageProducer.recordException(telemetryMethodName);
            return getControlTreatmentsForSplitsWithConfig(names, method, resultTransformer);
        }
    }

    /* JADX WARN: Code duplicated, block: B:28:0x0097  */
    /* JADX WARN: Code duplicated, block: B:30:0x009d  */
    /* JADX WARN: Code duplicated, block: B:31:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:36:0x00ae  */
    private TreatmentResult getTreatmentWithConfigWithoutMetrics(String split, Map<String, Object> mergedAttributes, String validationTag, EvaluationOptions evaluationOptions) {
        String str;
        EvaluationResult evaluationResultEvaluateIfReady;
        Long changeNumber;
        boolean z;
        String strTrim;
        try {
            str = split;
            try {
                ValidationErrorInfo validationErrorInfoValidateName = this.mSplitValidator.validateName(str);
                if (validationErrorInfoValidateName == null) {
                    strTrim = str;
                } else {
                    if (validationErrorInfoValidateName.isError()) {
                        this.mValidationLogger.e(validationErrorInfoValidateName, validationTag);
                        return new TreatmentResult(new SplitResult(Treatments.CONTROL), false);
                    }
                    this.mValidationLogger.w(validationErrorInfoValidateName, validationTag);
                    strTrim = str.trim();
                }
                evaluationResultEvaluateIfReady = evaluateIfReady(strTrim, mergedAttributes, validationTag);
                try {
                    SplitResult splitResult = new SplitResult(evaluationResultEvaluateIfReady.getTreatment(), evaluationResultEvaluateIfReady.getConfigurations());
                    if (evaluationResultEvaluateIfReady.getLabel().equals(TreatmentLabels.DEFINITION_NOT_FOUND)) {
                        this.mValidationLogger.w(this.mSplitValidator.splitNotFoundMessage(strTrim), validationTag);
                        return new TreatmentResult(splitResult, false);
                    }
                    logImpression(this.mMatchingKey, this.mBucketingKey, strTrim, evaluationResultEvaluateIfReady.getTreatment(), this.mLabelsEnabled ? evaluationResultEvaluateIfReady.getLabel() : null, evaluationResultEvaluateIfReady.getChangeNumber(), mergedAttributes, evaluationResultEvaluateIfReady.isImpressionsDisabled(), evaluationOptions, validationTag);
                    return new TreatmentResult(splitResult, false);
                } catch (Exception unused) {
                    if (this.mLabelsEnabled) {
                        String str2 = this.mMatchingKey;
                        String str3 = this.mBucketingKey;
                        if (evaluationResultEvaluateIfReady != null) {
                            changeNumber = evaluationResultEvaluateIfReady.getChangeNumber();
                        } else {
                            changeNumber = null;
                        }
                        if (evaluationResultEvaluateIfReady == null && evaluationResultEvaluateIfReady.isImpressionsDisabled()) {
                            z = true;
                        } else {
                            z = false;
                        }
                        logImpression(str2, str3, str, Treatments.CONTROL, "exception", changeNumber, mergedAttributes, z, evaluationOptions, validationTag);
                    }
                    return new TreatmentResult(new SplitResult(Treatments.CONTROL), true);
                }
            } catch (Exception unused2) {
                evaluationResultEvaluateIfReady = null;
                if (this.mLabelsEnabled) {
                    String str4 = this.mMatchingKey;
                    String str5 = this.mBucketingKey;
                    if (evaluationResultEvaluateIfReady != null) {
                        changeNumber = evaluationResultEvaluateIfReady.getChangeNumber();
                    } else {
                        changeNumber = null;
                    }
                    if (evaluationResultEvaluateIfReady == null) {
                        z = false;
                    } else {
                        z = false;
                    }
                    logImpression(str4, str5, str, Treatments.CONTROL, "exception", changeNumber, mergedAttributes, z, evaluationOptions, validationTag);
                }
                return new TreatmentResult(new SplitResult(Treatments.CONTROL), true);
            }
        } catch (Exception unused3) {
            str = split;
        }
    }

    private void logImpression(String matchingKey, String bucketingKey, String splitName, String result, String label, Long changeNumber, Map<String, Object> attributes, boolean impressionsDisabled, EvaluationOptions evaluationOptions, String validationTag) {
        try {
            Impression impression = new Impression(matchingKey, bucketingKey, splitName, result, System.currentTimeMillis(), label, changeNumber, attributes, serializeProperties(evaluationOptions, validationTag));
            this.mImpressionListener.log(new DecoratedImpression(impression, impressionsDisabled));
            this.mImpressionListener.log(impression);
        } catch (Throwable th) {
            Logger.e("An error occurred logging impression: " + th.getLocalizedMessage());
        }
    }

    private String serializeProperties(EvaluationOptions evaluationOptions, String validationTag) {
        if (evaluationOptions != null && evaluationOptions.getProperties() != null && !evaluationOptions.getProperties().isEmpty()) {
            PropertyValidator.Result resultValidate = this.mPropertyValidator.validate(evaluationOptions.getProperties(), validationTag);
            if (!resultValidate.isValid()) {
                this.mValidationLogger.e("Properties validation failed: " + (resultValidate.getErrorMessage() != null ? resultValidate.getErrorMessage() : MicrosoftAuthorizationErrorResponse.UNKNOWN_ERROR), validationTag);
                return null;
            }
            if (resultValidate.getProperties() != null && !resultValidate.getProperties().isEmpty()) {
                try {
                    return Json.toJson(resultValidate.getProperties());
                } catch (Exception e) {
                    this.mValidationLogger.e("Failed to serialize properties to JSON: " + e.getLocalizedMessage(), validationTag);
                }
            }
        }
        return null;
    }

    private <T> Map<String, T> getControlTreatmentsForSplitsWithConfig(List<String> names, String validationTag, ResultTransformer<T> resultTransformer) {
        SplitValidator splitValidator = this.mSplitValidator;
        ValidationMessageLogger validationMessageLogger = this.mValidationLogger;
        if (names == null) {
            names = new ArrayList<>();
        }
        return TreatmentManagerHelper.controlTreatmentsForSplitsWithConfig(splitValidator, validationMessageLogger, names, validationTag, resultTransformer);
    }

    private EvaluationResult evaluateIfReady(String featureFlagName, Map<String, Object> attributes, String validationTag) {
        if (!this.mEventsManager.eventAlreadyTriggered(SplitEvent.SDK_READY) && !this.mEventsManager.eventAlreadyTriggered(SplitEvent.SDK_READY_FROM_CACHE)) {
            this.mValidationLogger.w("the SDK is not ready, results may be incorrect for feature flag " + featureFlagName + ". Make sure to wait for SDK readiness before using this method", validationTag);
            this.mTelemetryStorageProducer.recordNonReadyUsage();
            return new EvaluationResult(Treatments.CONTROL, TreatmentLabels.NOT_READY, null, null, false);
        }
        return this.mEvaluator.getTreatment(this.mMatchingKey, this.mBucketingKey, featureFlagName, attributes);
    }

    private void recordLatency(Method treatment, long startTime) {
        this.mTelemetryStorageProducer.recordLatency(treatment, System.currentTimeMillis() - startTime);
    }

    private List<String> getNamesFromSet(String method, List<String> flagSets) {
        Set<String> setItems = this.mFlagSetsValidator.items(method, flagSets, this.mFlagSetsFilter);
        if (setItems.isEmpty()) {
            return new ArrayList();
        }
        return new ArrayList(this.mSplitsStorage.getNamesByFlagSets(setItems));
    }

    private static class TreatmentResult {
        private final boolean mException;
        private final SplitResult mSplitResult;

        TreatmentResult(SplitResult splitResult, boolean exception) {
            this.mSplitResult = splitResult;
            this.mException = exception;
        }

        SplitResult getSplitResult() {
            return this.mSplitResult;
        }

        boolean isException() {
            return this.mException;
        }
    }
}

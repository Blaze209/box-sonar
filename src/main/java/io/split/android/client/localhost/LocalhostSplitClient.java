package io.split.android.client.localhost;

import io.split.android.client.EvaluationOptions;
import io.split.android.client.EvaluatorImpl;
import io.split.android.client.FlagSetsFilter;
import io.split.android.client.PropertyValidatorImpl;
import io.split.android.client.SplitClient;
import io.split.android.client.SplitClientConfig;
import io.split.android.client.SplitResult;
import io.split.android.client.api.Key;
import io.split.android.client.attributes.AttributesManager;
import io.split.android.client.attributes.AttributesMerger;
import io.split.android.client.events.SplitEvent;
import io.split.android.client.events.SplitEventTask;
import io.split.android.client.events.SplitEventsManager;
import io.split.android.client.impressions.ImpressionListener;
import io.split.android.client.shared.SplitClientContainer;
import io.split.android.client.storage.splits.SplitsStorage;
import io.split.android.client.telemetry.storage.TelemetryStorageProducer;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;
import io.split.android.client.validators.FlagSetsValidatorImpl;
import io.split.android.client.validators.KeyValidatorImpl;
import io.split.android.client.validators.SplitValidatorImpl;
import io.split.android.client.validators.TreatmentManager;
import io.split.android.client.validators.TreatmentManagerImpl;
import io.split.android.client.validators.ValidationMessageLoggerImpl;
import io.split.android.engine.experiments.SplitParser;
import io.split.android.grammar.Treatments;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class LocalhostSplitClient implements SplitClient {
    private final WeakReference<SplitClientContainer> mClientContainer;
    private final SplitEventsManager mEventsManager;
    private final WeakReference<LocalhostSplitFactory> mFactoryRef;
    private boolean mIsClientDestroyed = false;
    private final Key mKey;
    private final SplitsStorage mSplitsStorage;
    private final TreatmentManager mTreatmentManager;

    @Override // io.split.android.client.attributes.AttributesManager
    public boolean clearAttributes() {
        return true;
    }

    @Override // io.split.android.client.SplitClient
    public void flush() {
    }

    @Override // io.split.android.client.attributes.AttributesManager
    public Object getAttribute(String attributeName) {
        return null;
    }

    @Override // io.split.android.client.attributes.AttributesManager
    public boolean removeAttribute(String attributeName) {
        return true;
    }

    @Override // io.split.android.client.attributes.AttributesManager
    public boolean setAttribute(String attributeName, Object value) {
        return true;
    }

    @Override // io.split.android.client.attributes.AttributesManager
    public boolean setAttributes(Map<String, Object> attributes) {
        return true;
    }

    @Override // io.split.android.client.SplitClient
    public boolean track(String eventType) {
        return false;
    }

    @Override // io.split.android.client.SplitClient
    public boolean track(String eventType, double value) {
        return false;
    }

    @Override // io.split.android.client.SplitClient
    public boolean track(String eventType, double value, Map<String, Object> properties) {
        return false;
    }

    @Override // io.split.android.client.SplitClient
    public boolean track(String trafficType, String eventType) {
        return false;
    }

    @Override // io.split.android.client.SplitClient
    public boolean track(String trafficType, String eventType, double value) {
        return false;
    }

    @Override // io.split.android.client.SplitClient
    public boolean track(String trafficType, String eventType, double value, Map<String, Object> properties) {
        return false;
    }

    @Override // io.split.android.client.SplitClient
    public boolean track(String trafficType, String eventType, Map<String, Object> properties) {
        return false;
    }

    @Override // io.split.android.client.SplitClient
    public boolean track(String eventType, Map<String, Object> properties) {
        return false;
    }

    public LocalhostSplitClient(LocalhostSplitFactory container, SplitClientContainer clientContainer, SplitClientConfig splitClientConfig, Key key, SplitsStorage splitsStorage, SplitEventsManager eventsManager, SplitParser splitParser, AttributesManager attributesManager, AttributesMerger attributesMerger, TelemetryStorageProducer telemetryStorageProducer, FlagSetsFilter flagSetsFilter) {
        this.mFactoryRef = new WeakReference<>((LocalhostSplitFactory) Utils.checkNotNull(container));
        this.mClientContainer = new WeakReference<>((SplitClientContainer) Utils.checkNotNull(clientContainer));
        Key key2 = (Key) Utils.checkNotNull(key);
        this.mKey = key2;
        this.mEventsManager = (SplitEventsManager) Utils.checkNotNull(eventsManager);
        this.mSplitsStorage = splitsStorage;
        this.mTreatmentManager = new TreatmentManagerImpl(key2.matchingKey(), key2.bucketingKey(), new EvaluatorImpl(splitsStorage, splitParser), new KeyValidatorImpl(), new SplitValidatorImpl(), getImpressionsListener(splitClientConfig), splitClientConfig.labelsEnabled(), eventsManager, attributesManager, attributesMerger, telemetryStorageProducer, flagSetsFilter, splitsStorage, new ValidationMessageLoggerImpl(), new FlagSetsValidatorImpl(), new PropertyValidatorImpl());
    }

    @Override // io.split.android.client.SplitClient
    public String getTreatment(String featureFlagName) {
        return getTreatment(featureFlagName, Collections.emptyMap(), null);
    }

    @Override // io.split.android.client.SplitClient
    public String getTreatment(String featureFlagName, Map<String, Object> attributes) {
        return getTreatment(featureFlagName, attributes, null);
    }

    @Override // io.split.android.client.SplitClient
    public String getTreatment(String featureFlagName, Map<String, Object> attributes, EvaluationOptions evaluationOptions) {
        try {
            return this.mTreatmentManager.getTreatment(featureFlagName, attributes, evaluationOptions, this.mIsClientDestroyed);
        } catch (Exception e) {
            Logger.e(e);
            return Treatments.CONTROL;
        }
    }

    @Override // io.split.android.client.SplitClient
    public SplitResult getTreatmentWithConfig(String featureFlagName, Map<String, Object> attributes) {
        return getTreatmentWithConfig(featureFlagName, attributes, null);
    }

    @Override // io.split.android.client.SplitClient
    public SplitResult getTreatmentWithConfig(String featureFlagName, Map<String, Object> attributes, EvaluationOptions evaluationOptions) {
        try {
            return this.mTreatmentManager.getTreatmentWithConfig(featureFlagName, attributes, evaluationOptions, this.mIsClientDestroyed);
        } catch (Exception e) {
            Logger.e(e);
            return new SplitResult(Treatments.CONTROL);
        }
    }

    @Override // io.split.android.client.SplitClient
    public Map<String, String> getTreatments(List<String> featureFlagNames, Map<String, Object> attributes) {
        return getTreatments(featureFlagNames, attributes, null);
    }

    @Override // io.split.android.client.SplitClient
    public Map<String, String> getTreatments(List<String> featureFlagNames, Map<String, Object> attributes, EvaluationOptions evaluationOptions) {
        try {
            return this.mTreatmentManager.getTreatments(featureFlagNames, attributes, evaluationOptions, this.mIsClientDestroyed);
        } catch (Exception e) {
            Logger.e(e);
            HashMap map = new HashMap();
            Iterator<String> it = featureFlagNames.iterator();
            while (it.hasNext()) {
                map.put(it.next(), Treatments.CONTROL);
            }
            return map;
        }
    }

    @Override // io.split.android.client.SplitClient
    public Map<String, SplitResult> getTreatmentsWithConfig(List<String> featureFlagNames, Map<String, Object> attributes) {
        return getTreatmentsWithConfig(featureFlagNames, attributes, null);
    }

    @Override // io.split.android.client.SplitClient
    public Map<String, SplitResult> getTreatmentsWithConfig(List<String> featureFlagNames, Map<String, Object> attributes, EvaluationOptions evaluationOptions) {
        try {
            return this.mTreatmentManager.getTreatmentsWithConfig(featureFlagNames, attributes, evaluationOptions, this.mIsClientDestroyed);
        } catch (Exception e) {
            Logger.e(e);
            HashMap map = new HashMap();
            Iterator<String> it = featureFlagNames.iterator();
            while (it.hasNext()) {
                map.put(it.next(), new SplitResult(Treatments.CONTROL));
            }
            return map;
        }
    }

    @Override // io.split.android.client.SplitClient
    public Map<String, String> getTreatmentsByFlagSet(String flagSet, Map<String, Object> attributes) {
        return getTreatmentsByFlagSet(flagSet, attributes, null);
    }

    @Override // io.split.android.client.SplitClient
    public Map<String, String> getTreatmentsByFlagSet(String flagSet, Map<String, Object> attributes, EvaluationOptions evaluationOptions) {
        try {
            return this.mTreatmentManager.getTreatmentsByFlagSet(flagSet, attributes, evaluationOptions, this.mIsClientDestroyed);
        } catch (Exception e) {
            Logger.e(e);
            return buildExceptionResult(Collections.singletonList(flagSet));
        }
    }

    @Override // io.split.android.client.SplitClient
    public Map<String, String> getTreatmentsByFlagSets(List<String> flagSets, Map<String, Object> attributes) {
        return getTreatmentsByFlagSets(flagSets, attributes, null);
    }

    @Override // io.split.android.client.SplitClient
    public Map<String, String> getTreatmentsByFlagSets(List<String> flagSets, Map<String, Object> attributes, EvaluationOptions evaluationOptions) {
        try {
            return this.mTreatmentManager.getTreatmentsByFlagSets(flagSets, attributes, evaluationOptions, this.mIsClientDestroyed);
        } catch (Exception e) {
            Logger.e(e);
            return buildExceptionResult(flagSets);
        }
    }

    @Override // io.split.android.client.SplitClient
    public Map<String, SplitResult> getTreatmentsWithConfigByFlagSet(String flagSet, Map<String, Object> attributes) {
        return getTreatmentsWithConfigByFlagSet(flagSet, attributes, null);
    }

    @Override // io.split.android.client.SplitClient
    public Map<String, SplitResult> getTreatmentsWithConfigByFlagSet(String flagSet, Map<String, Object> attributes, EvaluationOptions evaluationOptions) {
        try {
            return this.mTreatmentManager.getTreatmentsWithConfigByFlagSet(flagSet, attributes, evaluationOptions, this.mIsClientDestroyed);
        } catch (Exception e) {
            Logger.e(e);
            return buildExceptionResultWithConfig(Collections.singletonList(flagSet));
        }
    }

    @Override // io.split.android.client.SplitClient
    public Map<String, SplitResult> getTreatmentsWithConfigByFlagSets(List<String> flagSets, Map<String, Object> attributes) {
        return getTreatmentsWithConfigByFlagSets(flagSets, attributes, null);
    }

    @Override // io.split.android.client.SplitClient
    public Map<String, SplitResult> getTreatmentsWithConfigByFlagSets(List<String> flagSets, Map<String, Object> attributes, EvaluationOptions evaluationOptions) {
        try {
            return this.mTreatmentManager.getTreatmentsWithConfigByFlagSets(flagSets, attributes, evaluationOptions, this.mIsClientDestroyed);
        } catch (Exception e) {
            Logger.e(e);
            return buildExceptionResultWithConfig(flagSets);
        }
    }

    @Override // io.split.android.client.SplitClient
    public void destroy() {
        this.mIsClientDestroyed = true;
        SplitClientContainer splitClientContainer = this.mClientContainer.get();
        if (splitClientContainer != null) {
            splitClientContainer.remove(this.mKey);
        }
        LocalhostSplitFactory localhostSplitFactory = this.mFactoryRef.get();
        if (localhostSplitFactory != null) {
            localhostSplitFactory.destroy();
        }
    }

    @Override // io.split.android.client.SplitClient
    public boolean isReady() {
        return this.mEventsManager.eventAlreadyTriggered(SplitEvent.SDK_READY);
    }

    @Override // io.split.android.client.SplitClient
    public void on(SplitEvent event, SplitEventTask task) {
        Utils.checkNotNull(event);
        Utils.checkNotNull(task);
        if (!event.equals(SplitEvent.SDK_READY_FROM_CACHE) && this.mEventsManager.eventAlreadyTriggered(event)) {
            Logger.w(String.format("A listener was added for %s on the SDK, which has already fired and won’t be emitted again. The callback won’t be executed.", event));
        } else {
            this.mEventsManager.register(event, task);
        }
    }

    private ImpressionListener.FederatedImpressionListener getImpressionsListener(SplitClientConfig config) {
        if (config.impressionListener() != null) {
            return new ImpressionListener.FederatedImpressionListener(new ImpressionListener.NoopImpressionListener(), Collections.singletonList(config.impressionListener()));
        }
        return new ImpressionListener.FederatedImpressionListener(new ImpressionListener.NoopImpressionListener(), Collections.emptyList());
    }

    @Override // io.split.android.client.attributes.AttributesManager
    public Map<String, Object> getAllAttributes() {
        return new HashMap();
    }

    private Map<String, String> buildExceptionResult(List<String> flagSets) {
        HashMap map = new HashMap();
        Iterator<String> it = this.mSplitsStorage.getNamesByFlagSets(flagSets).iterator();
        while (it.hasNext()) {
            map.put(it.next(), Treatments.CONTROL);
        }
        return map;
    }

    private Map<String, SplitResult> buildExceptionResultWithConfig(List<String> flagSets) {
        HashMap map = new HashMap();
        Iterator<String> it = this.mSplitsStorage.getNamesByFlagSets(flagSets).iterator();
        while (it.hasNext()) {
            map.put(it.next(), new SplitResult(Treatments.CONTROL));
        }
        return map;
    }
}

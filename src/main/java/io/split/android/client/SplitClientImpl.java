package io.split.android.client;

import io.split.android.client.api.Key;
import io.split.android.client.attributes.AttributesManager;
import io.split.android.client.events.SplitEvent;
import io.split.android.client.events.SplitEventTask;
import io.split.android.client.events.SplitEventsManager;
import io.split.android.client.impressions.ImpressionListener;
import io.split.android.client.shared.SplitClientContainer;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;
import io.split.android.client.validators.SplitValidator;
import io.split.android.client.validators.TreatmentManager;
import io.split.android.client.validators.ValidationMessageLogger;
import io.split.android.client.validators.ValidationMessageLoggerImpl;
import io.split.android.engine.experiments.SplitParser;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public final class SplitClientImpl implements SplitClient {
    private static final double TRACK_DEFAULT_VALUE = 0.0d;
    private final AttributesManager mAttributesManager;
    private final WeakReference<SplitClientContainer> mClientContainer;
    private final SplitClientConfig mConfig;
    private final SplitEventsManager mEventsManager;
    private final EventsTracker mEventsTracker;
    private boolean mIsClientDestroyed = false;
    private final Key mKey;
    private final WeakReference<SplitFactory> mSplitFactory;
    private final TreatmentManager mTreatmentManager;
    private final ValidationMessageLogger mValidationLogger;

    public SplitClientImpl(SplitFactory container, SplitClientContainer clientContainer, Key key, SplitParser splitParser, ImpressionListener impressionListener, SplitClientConfig config, SplitEventsManager eventsManager, EventsTracker eventsTracker, AttributesManager attributesManager, SplitValidator splitValidator, TreatmentManager treatmentManager) {
        Utils.checkNotNull(splitParser);
        Utils.checkNotNull(impressionListener);
        this.mSplitFactory = new WeakReference<>((SplitFactory) Utils.checkNotNull(container));
        this.mClientContainer = new WeakReference<>((SplitClientContainer) Utils.checkNotNull(clientContainer));
        this.mKey = (Key) Utils.checkNotNull(key);
        this.mConfig = (SplitClientConfig) Utils.checkNotNull(config);
        this.mEventsManager = (SplitEventsManager) Utils.checkNotNull(eventsManager);
        this.mEventsTracker = (EventsTracker) Utils.checkNotNull(eventsTracker);
        this.mValidationLogger = new ValidationMessageLoggerImpl();
        this.mTreatmentManager = treatmentManager;
        this.mAttributesManager = (AttributesManager) Utils.checkNotNull(attributesManager);
    }

    @Override // io.split.android.client.SplitClient
    public void destroy() {
        SplitFactory splitFactory;
        this.mIsClientDestroyed = true;
        SplitClientContainer splitClientContainer = this.mClientContainer.get();
        if (splitClientContainer != null) {
            splitClientContainer.remove(this.mKey);
            if (!splitClientContainer.getAll().isEmpty() || (splitFactory = this.mSplitFactory.get()) == null) {
                return;
            }
            if (splitFactory instanceof SplitFactoryImpl) {
                try {
                    ((SplitFactoryImpl) splitFactory).checkClients();
                } catch (ClassCastException unused) {
                }
            }
            splitFactory.destroy();
        }
    }

    @Override // io.split.android.client.SplitClient
    public void flush() {
        SplitFactory splitFactory = this.mSplitFactory.get();
        if (splitFactory != null) {
            splitFactory.flush();
        }
    }

    @Override // io.split.android.client.SplitClient
    public boolean isReady() {
        return this.mEventsManager.eventAlreadyTriggered(SplitEvent.SDK_READY);
    }

    @Override // io.split.android.client.SplitClient
    public String getTreatment(String featureFlagName) {
        return getTreatment(featureFlagName, Collections.emptyMap());
    }

    @Override // io.split.android.client.SplitClient
    public String getTreatment(String featureFlagName, Map<String, Object> attributes) {
        return getTreatment(featureFlagName, attributes, null);
    }

    @Override // io.split.android.client.SplitClient
    public String getTreatment(String featureFlagName, Map<String, Object> attributes, EvaluationOptions evaluationOptions) {
        return this.mTreatmentManager.getTreatment(featureFlagName, attributes, evaluationOptions, this.mIsClientDestroyed);
    }

    @Override // io.split.android.client.SplitClient
    public SplitResult getTreatmentWithConfig(String featureFlagName, Map<String, Object> attributes) {
        return getTreatmentWithConfig(featureFlagName, attributes, null);
    }

    @Override // io.split.android.client.SplitClient
    public SplitResult getTreatmentWithConfig(String featureFlagName, Map<String, Object> attributes, EvaluationOptions evaluationOptions) {
        return this.mTreatmentManager.getTreatmentWithConfig(featureFlagName, attributes, evaluationOptions, this.mIsClientDestroyed);
    }

    @Override // io.split.android.client.SplitClient
    public Map<String, String> getTreatments(List<String> featureFlagNames, Map<String, Object> attributes) {
        return getTreatments(featureFlagNames, attributes, null);
    }

    @Override // io.split.android.client.SplitClient
    public Map<String, String> getTreatments(List<String> featureFlagNames, Map<String, Object> attributes, EvaluationOptions evaluationOptions) {
        return this.mTreatmentManager.getTreatments(featureFlagNames, attributes, evaluationOptions, this.mIsClientDestroyed);
    }

    @Override // io.split.android.client.SplitClient
    public Map<String, SplitResult> getTreatmentsWithConfig(List<String> featureFlagNames, Map<String, Object> attributes) {
        return getTreatmentsWithConfig(featureFlagNames, attributes, null);
    }

    @Override // io.split.android.client.SplitClient
    public Map<String, SplitResult> getTreatmentsWithConfig(List<String> featureFlagNames, Map<String, Object> attributes, EvaluationOptions evaluationOptions) {
        return this.mTreatmentManager.getTreatmentsWithConfig(featureFlagNames, attributes, evaluationOptions, this.mIsClientDestroyed);
    }

    @Override // io.split.android.client.SplitClient
    public Map<String, String> getTreatmentsByFlagSet(String flagSet, Map<String, Object> attributes) {
        return getTreatmentsByFlagSet(flagSet, attributes, null);
    }

    @Override // io.split.android.client.SplitClient
    public Map<String, String> getTreatmentsByFlagSet(String flagSet, Map<String, Object> attributes, EvaluationOptions evaluationOptions) {
        return this.mTreatmentManager.getTreatmentsByFlagSet(flagSet, attributes, evaluationOptions, this.mIsClientDestroyed);
    }

    @Override // io.split.android.client.SplitClient
    public Map<String, String> getTreatmentsByFlagSets(List<String> flagSets, Map<String, Object> attributes) {
        return getTreatmentsByFlagSets(flagSets, attributes, null);
    }

    @Override // io.split.android.client.SplitClient
    public Map<String, String> getTreatmentsByFlagSets(List<String> flagSets, Map<String, Object> attributes, EvaluationOptions evaluationOptions) {
        return this.mTreatmentManager.getTreatmentsByFlagSets(flagSets, attributes, evaluationOptions, this.mIsClientDestroyed);
    }

    @Override // io.split.android.client.SplitClient
    public Map<String, SplitResult> getTreatmentsWithConfigByFlagSet(String flagSet, Map<String, Object> attributes) {
        return getTreatmentsWithConfigByFlagSet(flagSet, attributes, null);
    }

    @Override // io.split.android.client.SplitClient
    public Map<String, SplitResult> getTreatmentsWithConfigByFlagSet(String flagSet, Map<String, Object> attributes, EvaluationOptions evaluationOptions) {
        return this.mTreatmentManager.getTreatmentsWithConfigByFlagSet(flagSet, attributes, evaluationOptions, this.mIsClientDestroyed);
    }

    @Override // io.split.android.client.SplitClient
    public Map<String, SplitResult> getTreatmentsWithConfigByFlagSets(List<String> flagSets, Map<String, Object> attributes) {
        return getTreatmentsWithConfigByFlagSets(flagSets, attributes, null);
    }

    @Override // io.split.android.client.SplitClient
    public Map<String, SplitResult> getTreatmentsWithConfigByFlagSets(List<String> flagSets, Map<String, Object> attributes, EvaluationOptions evaluationOptions) {
        return this.mTreatmentManager.getTreatmentsWithConfigByFlagSets(flagSets, attributes, evaluationOptions, this.mIsClientDestroyed);
    }

    @Override // io.split.android.client.SplitClient
    public void on(SplitEvent event, SplitEventTask task) {
        Utils.checkNotNull(event);
        Utils.checkNotNull(task);
        if (!event.equals(SplitEvent.SDK_READY_FROM_CACHE) && this.mEventsManager.eventAlreadyTriggered(event)) {
            Logger.w(String.format("A listener was added for %s on the SDK, which has already fired and won’t be emitted again. The callback won’t be executed.", event.toString()));
        } else {
            this.mEventsManager.register(event, task);
        }
    }

    @Override // io.split.android.client.SplitClient
    public boolean track(String trafficType, String eventType) {
        return track(this.mKey.matchingKey(), trafficType, eventType, 0.0d, null);
    }

    @Override // io.split.android.client.SplitClient
    public boolean track(String trafficType, String eventType, double value) {
        return track(this.mKey.matchingKey(), trafficType, eventType, value, null);
    }

    @Override // io.split.android.client.SplitClient
    public boolean track(String eventType) {
        return track(this.mKey.matchingKey(), this.mConfig.trafficType(), eventType, 0.0d, null);
    }

    @Override // io.split.android.client.SplitClient
    public boolean track(String eventType, double value) {
        return track(this.mKey.matchingKey(), this.mConfig.trafficType(), eventType, value, null);
    }

    @Override // io.split.android.client.SplitClient
    public boolean track(String trafficType, String eventType, Map<String, Object> properties) {
        return track(this.mKey.matchingKey(), trafficType, eventType, 0.0d, properties);
    }

    @Override // io.split.android.client.SplitClient
    public boolean track(String trafficType, String eventType, double value, Map<String, Object> properties) {
        return track(this.mKey.matchingKey(), trafficType, eventType, value, properties);
    }

    @Override // io.split.android.client.SplitClient
    public boolean track(String eventType, Map<String, Object> properties) {
        return track(this.mKey.matchingKey(), this.mConfig.trafficType(), eventType, 0.0d, properties);
    }

    @Override // io.split.android.client.SplitClient
    public boolean track(String eventType, double value, Map<String, Object> properties) {
        return track(this.mKey.matchingKey(), this.mConfig.trafficType(), eventType, value, properties);
    }

    private boolean track(String key, String trafficType, String eventType, double value, Map<String, Object> properties) {
        if (this.mIsClientDestroyed) {
            this.mValidationLogger.e("Client has already been destroyed - no calls possible", "track");
            return false;
        }
        return this.mEventsTracker.track(key, trafficType, eventType, value, properties, this.mEventsManager.eventAlreadyTriggered(SplitEvent.SDK_READY));
    }

    @Override // io.split.android.client.attributes.AttributesManager
    public boolean setAttribute(String attributeName, Object value) {
        try {
            return this.mAttributesManager.setAttribute(attributeName, value);
        } catch (Exception e) {
            Logger.e("Error setting attribute: " + e.getLocalizedMessage());
            return false;
        }
    }

    @Override // io.split.android.client.attributes.AttributesManager
    public Object getAttribute(String attributeName) {
        try {
            return this.mAttributesManager.getAttribute(attributeName);
        } catch (Exception e) {
            Logger.e("Error getting attribute: " + e.getLocalizedMessage());
            return null;
        }
    }

    @Override // io.split.android.client.attributes.AttributesManager
    public boolean setAttributes(Map<String, Object> attributes) {
        try {
            return this.mAttributesManager.setAttributes(attributes);
        } catch (Exception e) {
            Logger.e("Error setting attributes: " + e.getLocalizedMessage());
            return false;
        }
    }

    @Override // io.split.android.client.attributes.AttributesManager
    public Map<String, Object> getAllAttributes() {
        try {
            return this.mAttributesManager.getAllAttributes();
        } catch (Exception e) {
            Logger.e("Error getting attributes: " + e.getLocalizedMessage());
            return Collections.emptyMap();
        }
    }

    @Override // io.split.android.client.attributes.AttributesManager
    public boolean removeAttribute(String attributeName) {
        try {
            return this.mAttributesManager.removeAttribute(attributeName);
        } catch (Exception e) {
            Logger.e("Error removing attribute: " + e.getLocalizedMessage());
            return false;
        }
    }

    @Override // io.split.android.client.attributes.AttributesManager
    public boolean clearAttributes() {
        try {
            return this.mAttributesManager.clearAttributes();
        } catch (Exception e) {
            Logger.e("Error clearing attributes: " + e.getLocalizedMessage());
            return false;
        }
    }
}

package io.split.android.client;

import io.split.android.client.dtos.Event;
import io.split.android.client.service.synchronizer.SyncManager;
import io.split.android.client.telemetry.model.Method;
import io.split.android.client.telemetry.storage.TelemetryStorageProducer;
import io.split.android.client.utils.Utils;
import io.split.android.client.utils.logger.Logger;
import io.split.android.client.validators.EventValidator;
import io.split.android.client.validators.PropertyValidator;
import io.split.android.client.validators.ValidationErrorInfo;
import io.split.android.client.validators.ValidationMessageLogger;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes4.dex */
public class EventsTrackerImpl implements EventsTracker {
    private static final int ESTIMATED_EVENT_SIZE_WITHOUT_PROPS = 1024;
    private final AtomicBoolean isTrackingEnabled = new AtomicBoolean(true);
    private final EventValidator mEventValidator;
    private final PropertyValidator mPropertyValidator;
    private final SyncManager mSyncManager;
    private final TelemetryStorageProducer mTelemetryStorageProducer;
    private final ValidationMessageLogger mValidationLogger;

    public EventsTrackerImpl(EventValidator eventValidator, ValidationMessageLogger validationLogger, TelemetryStorageProducer telemetryStorageProducer, PropertyValidator eventPropertiesProcessor, SyncManager syncManager) {
        this.mEventValidator = (EventValidator) Utils.checkNotNull(eventValidator);
        this.mValidationLogger = (ValidationMessageLogger) Utils.checkNotNull(validationLogger);
        this.mTelemetryStorageProducer = (TelemetryStorageProducer) Utils.checkNotNull(telemetryStorageProducer);
        this.mPropertyValidator = (PropertyValidator) Utils.checkNotNull(eventPropertiesProcessor);
        this.mSyncManager = (SyncManager) Utils.checkNotNull(syncManager);
    }

    @Override // io.split.android.client.EventsTracker
    public void enableTracking(boolean enable) {
        this.isTrackingEnabled.set(enable);
    }

    @Override // io.split.android.client.EventsTracker
    public boolean track(String key, String trafficType, String eventType, double value, Map<String, Object> properties, boolean isSdkReady) {
        if (!this.isTrackingEnabled.get()) {
            Logger.v("Event not tracked because tracking is disabled");
            return false;
        }
        try {
            Event event = new Event();
            event.eventTypeId = eventType;
            event.trafficTypeName = trafficType;
            event.key = key;
            event.value = value;
            event.timestamp = System.currentTimeMillis();
            event.properties = properties;
            ValidationErrorInfo validationErrorInfoValidate = this.mEventValidator.validate(event, isSdkReady);
            if (validationErrorInfoValidate != null) {
                if (validationErrorInfoValidate.isError()) {
                    this.mValidationLogger.e(validationErrorInfoValidate, "track");
                    return false;
                }
                this.mValidationLogger.w(validationErrorInfoValidate, "track");
                event.trafficTypeName = event.trafficTypeName.toLowerCase();
            }
            PropertyValidator.Result resultValidate = this.mPropertyValidator.validate(event.properties, "track");
            if (!resultValidate.isValid()) {
                return false;
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            event.properties = resultValidate.getProperties();
            event.setSizeInBytes(resultValidate.getSizeInBytes() + 1024);
            this.mSyncManager.pushEvent(event);
            this.mTelemetryStorageProducer.recordLatency(Method.TRACK, System.currentTimeMillis() - jCurrentTimeMillis);
            return true;
        } catch (Exception unused) {
            this.mTelemetryStorageProducer.recordException(Method.TRACK);
            return false;
        }
    }
}

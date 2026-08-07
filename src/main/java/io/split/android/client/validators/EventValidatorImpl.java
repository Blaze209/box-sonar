package io.split.android.client.validators;

import io.split.android.client.dtos.Event;
import io.split.android.client.storage.splits.SplitsStorage;
import io.split.android.client.utils.Utils;

/* JADX INFO: loaded from: classes4.dex */
public class EventValidatorImpl implements EventValidator {
    private final String TYPE_REGEX = ValidationConfig.getInstance().getTrackEventNamePattern();
    private KeyValidator mKeyValidator;
    private final SplitsStorage mSplitsStorage;

    public EventValidatorImpl(KeyValidator keyValidator, SplitsStorage splitsStorage) {
        this.mKeyValidator = keyValidator;
        this.mSplitsStorage = splitsStorage;
    }

    @Override // io.split.android.client.validators.EventValidator
    public ValidationErrorInfo validate(Event event, boolean validateTrafficType) {
        if (event == null) {
            return new ValidationErrorInfo(200, "Event could not be null");
        }
        ValidationErrorInfo validationErrorInfoValidate = this.mKeyValidator.validate(event.key, null);
        if (validationErrorInfoValidate != null) {
            return validationErrorInfoValidate;
        }
        if (event.trafficTypeName == null) {
            return new ValidationErrorInfo(200, "you passed a null or undefined traffic_type_name, traffic_type_name must be a non-empty string");
        }
        if (Utils.isNullOrEmpty(event.trafficTypeName.trim())) {
            return new ValidationErrorInfo(200, "you passed an empty traffic_type_name, traffic_type_name must be a non-empty string");
        }
        if (event.eventTypeId == null) {
            return new ValidationErrorInfo(200, "you passed a null or undefined event_type, event_type must be a non-empty String");
        }
        if (Utils.isNullOrEmpty(event.eventTypeId.trim())) {
            return new ValidationErrorInfo(200, "you passed an empty event_type, event_type must be a non-empty String");
        }
        if (!event.eventTypeId.matches(this.TYPE_REGEX)) {
            return new ValidationErrorInfo(200, "you passed " + event.eventTypeId + ", event name must adhere to the regular expression " + this.TYPE_REGEX + ". This means an event name must be alphanumeric, cannot be more than 80 characters long, and can only include a dash,  underscore, period, or colon as separators of alphanumeric characters.");
        }
        if (!event.trafficTypeName.toLowerCase().equals(event.trafficTypeName)) {
            validationErrorInfoValidate = new ValidationErrorInfo(101, "traffic_type_name should be all lowercase - converting string to lowercase", true);
        }
        if (validateTrafficType && !this.mSplitsStorage.isValidTrafficType(event.trafficTypeName)) {
            String str = "Traffic Type " + event.trafficTypeName + " does not have any corresponding feature flags in this environment, make sure you’re tracking your events to a valid traffic type defined in the Split user interface";
            if (validationErrorInfoValidate == null) {
                return new ValidationErrorInfo(102, str, true);
            }
            validationErrorInfoValidate.addWarning(102, str);
        }
        return validationErrorInfoValidate;
    }
}

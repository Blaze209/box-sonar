package io.split.android.client;

import io.split.android.client.utils.logger.Logger;
import io.split.android.client.validators.PropertyValidator;
import io.split.android.client.validators.ValidationConfig;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes4.dex */
public class PropertyValidatorImpl implements PropertyValidator {
    private static final int MAXIMUM_EVENT_PROPERTY_BYTES = ValidationConfig.getInstance().getMaximumEventPropertyBytes();
    private static final int MAX_PROPS_COUNT = 300;

    @Override // io.split.android.client.validators.PropertyValidator
    public PropertyValidator.Result validate(Map<String, Object> properties, String validationTag) {
        int iCalculateEventSizeInBytes = 0;
        if (properties == null) {
            return PropertyValidator.Result.valid(null, 0);
        }
        if (properties.size() > 300) {
            Logger.w(validationTag + "Event has more than 300 properties. Some of them will be trimmed when processed");
        }
        HashMap map = new HashMap(properties);
        for (Map.Entry<String, Object> entry : properties.entrySet()) {
            Object value = entry.getValue();
            String key = entry.getKey();
            if (value != null && isInvalidValueType(value)) {
                map.put(key, null);
            }
            iCalculateEventSizeInBytes += calculateEventSizeInBytes(key, value);
            if (iCalculateEventSizeInBytes > MAXIMUM_EVENT_PROPERTY_BYTES) {
                Logger.w(validationTag + "The maximum size allowed for the  properties is 32kb. Current is " + key + ". Event not queued");
                return PropertyValidator.Result.invalid("Event properties size is too large", iCalculateEventSizeInBytes);
            }
        }
        return PropertyValidator.Result.valid(map, iCalculateEventSizeInBytes);
    }

    private static boolean isInvalidValueType(Object value) {
        return ((value instanceof Number) || (value instanceof Boolean) || (value instanceof String)) ? false : true;
    }

    private static int calculateEventSizeInBytes(String key, Object value) {
        return ((value == null || value.getClass() != String.class) ? 0 : value.toString().getBytes().length) + key.getBytes().length;
    }
}

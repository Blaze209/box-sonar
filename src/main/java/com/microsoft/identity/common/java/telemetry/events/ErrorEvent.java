package com.microsoft.identity.common.java.telemetry.events;

import androidx.collection.SieveCacheKt;
import com.microsoft.identity.common.java.exception.BaseException;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;

/* JADX INFO: loaded from: classes14.dex */
@Deprecated
public class ErrorEvent extends BaseEvent {
    public static final String ERROR_TAG_PREFIX = "tag_";

    public ErrorEvent() {
        types(TelemetryEventStrings.EventType.ERROR_EVENT);
    }

    private String generateErrorTag(Exception exc, StackTraceElement stackTraceElement) {
        String str = exc.getClass().getSimpleName() + exc.getMessage() + stackTraceElement.getClassName() + stackTraceElement.getMethodName();
        if (exc instanceof BaseException) {
            str = str + ((BaseException) exc).getErrorCode();
        }
        return ERROR_TAG_PREFIX + (((long) str.hashCode()) + SieveCacheKt.NodeLinkMask);
    }

    public ErrorEvent putException(Exception exc) {
        if (exc != null) {
            StackTraceElement[] stackTrace = exc.getStackTrace();
            if (stackTrace != null && stackTrace.length > 0) {
                StackTraceElement stackTraceElement = stackTrace[0];
                put(TelemetryEventStrings.Key.ERROR_TAG, generateErrorTag(exc, stackTraceElement));
                put(TelemetryEventStrings.Key.ERROR_LOCATION_CLASS_NAME, stackTraceElement.getClassName());
                put(TelemetryEventStrings.Key.ERROR_LOCATION_LINE_NUMBER, String.valueOf(stackTraceElement.getLineNumber()));
                put(TelemetryEventStrings.Key.ERROR_LOCATION_METHOD_NAME, stackTraceElement.getMethodName());
            }
            put(TelemetryEventStrings.Key.ERROR_CLASS_NAME, exc.getClass().getSimpleName());
            put(TelemetryEventStrings.Key.ERROR_DESCRIPTION, exc.getMessage());
            if (exc instanceof BaseException) {
                BaseException baseException = (BaseException) exc;
                if (baseException.getCause() != null) {
                    put(TelemetryEventStrings.Key.ERROR_CLASS_NAME, baseException.getCause().getClass().getSimpleName());
                }
                put("Microsoft.MSAL.error_code", baseException.getErrorCode());
                put(TelemetryEventStrings.Key.SERVER_ERROR_CODE, baseException.getCliTelemErrorCode());
                put(TelemetryEventStrings.Key.SERVER_SUBERROR_CODE, baseException.getCliTelemSubErrorCode());
            }
        }
        return this;
    }
}

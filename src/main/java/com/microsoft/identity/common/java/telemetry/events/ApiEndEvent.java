package com.microsoft.identity.common.java.telemetry.events;

import com.microsoft.identity.common.java.controllers.ExceptionAdapter;
import com.microsoft.identity.common.java.exception.BaseException;
import com.microsoft.identity.common.java.exception.UserCancelException;
import com.microsoft.identity.common.java.result.AcquireTokenResult;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes14.dex */
@Deprecated
public class ApiEndEvent extends BaseEvent {
    public ApiEndEvent() {
        names(TelemetryEventStrings.Event.API_END_EVENT);
        types(TelemetryEventStrings.EventType.API_EVENT);
    }

    public ApiEndEvent(String str) {
        if (str == null) {
            throw new NullPointerException("apiId is marked non-null but is null");
        }
        names(TelemetryEventStrings.Event.API_END_EVENT);
        types(TelemetryEventStrings.EventType.API_EVENT);
        putApiId(str);
    }

    public ApiEndEvent putResult(@Nullable AcquireTokenResult acquireTokenResult) {
        if (acquireTokenResult != null) {
            put(TelemetryEventStrings.Key.IS_SUCCESSFUL, acquireTokenResult.getSucceeded().booleanValue() ? TelemetryEventStrings.Value.TRUE : "false");
            if (acquireTokenResult.getLocalAuthenticationResult() != null) {
                put(TelemetryEventStrings.Key.USER_ID, acquireTokenResult.getLocalAuthenticationResult().getUniqueId());
                put(TelemetryEventStrings.Key.TENANT_ID, acquireTokenResult.getLocalAuthenticationResult().getTenantId());
                put(TelemetryEventStrings.Key.SPE_RING, acquireTokenResult.getLocalAuthenticationResult().getSpeRing());
                put(TelemetryEventStrings.Key.RT_AGE, acquireTokenResult.getLocalAuthenticationResult().getRefreshTokenAge());
                correlationId(acquireTokenResult.getLocalAuthenticationResult().getCorrelationId());
            }
        }
        return this;
    }

    public ApiEndEvent putException(@Nullable Exception exc) {
        if (exc == null) {
            return this;
        }
        BaseException baseExceptionBaseExceptionFromException = ExceptionAdapter.baseExceptionFromException(exc);
        if (baseExceptionBaseExceptionFromException instanceof UserCancelException) {
            put(TelemetryEventStrings.Key.USER_CANCEL, TelemetryEventStrings.Value.TRUE);
        }
        put(TelemetryEventStrings.Key.SERVER_ERROR_CODE, baseExceptionBaseExceptionFromException.getCliTelemErrorCode());
        put(TelemetryEventStrings.Key.SERVER_SUBERROR_CODE, baseExceptionBaseExceptionFromException.getCliTelemSubErrorCode());
        put("Microsoft.MSAL.error_code", baseExceptionBaseExceptionFromException.getErrorCode());
        put(TelemetryEventStrings.Key.SPE_RING, baseExceptionBaseExceptionFromException.getSpeRing());
        put(TelemetryEventStrings.Key.ERROR_DESCRIPTION, baseExceptionBaseExceptionFromException.getMessage());
        put(TelemetryEventStrings.Key.RT_AGE, baseExceptionBaseExceptionFromException.getRefreshTokenAge());
        put(TelemetryEventStrings.Key.IS_SUCCESSFUL, "false");
        return this;
    }

    public ApiEndEvent putApiId(String str) {
        if (str == null) {
            throw new NullPointerException("apiId is marked non-null but is null");
        }
        put("Microsoft.MSAL.api_id", str);
        return this;
    }

    @Override // com.microsoft.identity.common.java.telemetry.events.BaseEvent, com.microsoft.identity.common.java.telemetry.Properties
    public ApiEndEvent put(String str, String str2) {
        if (str == null) {
            throw new NullPointerException("propertyName is marked non-null but is null");
        }
        super.put(str, str2);
        return this;
    }

    public ApiEndEvent isApiCallSuccessful(Boolean bool) {
        put(TelemetryEventStrings.Key.IS_SUCCESSFUL, bool.booleanValue() ? TelemetryEventStrings.Value.TRUE : "false");
        return this;
    }

    public ApiEndEvent putApiErrorCode(String str) {
        if (str == null) {
            throw new NullPointerException("errorCode is marked non-null but is null");
        }
        put("Microsoft.MSAL.error_code", str);
        return this;
    }
}

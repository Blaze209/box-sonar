package com.microsoft.intune.mam.client.telemetry.events;

import android.content.pm.PackageInfo;
import android.os.Parcelable;
import android.util.Log;
import com.microsoft.intune.mam.client.telemetry.AriaTelemetryEvent;
import com.microsoft.intune.mam.client.telemetry.TelemetryEvent;
import com.microsoft.intune.mam.client.telemetry.scrubbing.CustomerContentProperty;
import com.microsoft.intune.mam.client.telemetry.scrubbing.CustomerContentType;
import com.microsoft.intune.mam.log.MAMErrorId;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.logging.Level;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class MAMErrorEvent extends AriaTelemetryEvent {
    public static final String CAUSE_PREFIX = " Cause: ";
    public static final Parcelable.Creator<MAMErrorEvent> CREATOR;
    private static final List<CustomerContentProperty> CUSTOMER_CONTENT_PROPERTIES;
    private static final String EVENT_NAME = "MAMError";
    private static final int MAX_STACK_TRACE_SIZE = 6144;

    static {
        ArrayList arrayList = new ArrayList();
        for (KEYS keys : KEYS.values()) {
            if (!keys.getCustomerContentTypes().isEmpty()) {
                arrayList.add(keys);
            }
        }
        CUSTOMER_CONTENT_PROPERTIES = Collections.unmodifiableList(arrayList);
        CREATOR = new TelemetryEvent.ParcelableCreator(MAMErrorEvent.class);
    }

    public enum KEYS implements CustomerContentProperty {
        STACK_TRACE(CustomerContentType.LOB_APP_STACK_TRACE),
        MAM_SDK_VERSION(new CustomerContentType[0]),
        ERROR_NAME(new CustomerContentType[0]),
        ERROR_ID(new CustomerContentType[0]),
        ERROR_MESSAGE(CustomerContentType.LOB_APP_ERROR_MESSAGE),
        ERROR_CLASS(CustomerContentType.LOB_APP_CLASS_NAME),
        LINE_NUMBER(new CustomerContentType[0]),
        FILE_NAME(CustomerContentType.LOB_APP_GENERIC_ERROR_INFO),
        ERROR_METHOD(CustomerContentType.LOB_APP_GENERIC_ERROR_INFO),
        PROCESS_NAME(CustomerContentType.LOB_APP_GENERIC_ERROR_INFO),
        SEVERITY(new CustomerContentType[0]);

        private List<CustomerContentType> mCustomerContentTypes;

        @Override // com.microsoft.intune.mam.client.telemetry.scrubbing.CustomerContentProperty
        public Enum getKey() {
            return this;
        }

        KEYS(CustomerContentType... customerContentTypeArr) {
            this.mCustomerContentTypes = Arrays.asList(customerContentTypeArr);
        }

        @Override // com.microsoft.intune.mam.client.telemetry.scrubbing.CustomerContentProperty
        public List<CustomerContentType> getCustomerContentTypes() {
            return this.mCustomerContentTypes;
        }
    }

    public MAMErrorEvent(JSONObject jSONObject) throws JSONException {
        super(jSONObject, EVENT_NAME, KEYS.values());
    }

    public MAMErrorEvent(PackageInfo packageInfo, String str, String str2, Throwable th, String str3, String str4) {
        String message;
        this(packageInfo, str, str2, str3);
        if (th != null) {
            setProperty(KEYS.ERROR_CLASS, th.getClass().getName());
            message = th.getMessage();
            StackTraceElement stackTraceElement = th.getStackTrace()[0];
            if (stackTraceElement != null) {
                setProperty(KEYS.FILE_NAME, stackTraceElement.getFileName());
                setProperty((Enum) KEYS.LINE_NUMBER, stackTraceElement.getLineNumber());
                setProperty(KEYS.ERROR_METHOD, stackTraceElement.getMethodName());
            }
            setStackTrace(Log.getStackTraceString(th));
        } else {
            message = null;
        }
        if (str4 != null && message != null) {
            setErrorMessage(str4 + CAUSE_PREFIX + message);
        } else if (str4 != null) {
            setErrorMessage(str4);
        } else if (message != null) {
            setErrorMessage(message);
        }
    }

    public MAMErrorEvent(PackageInfo packageInfo, String str, String str2, String str3, String str4, String str5) {
        this(packageInfo, str, str2, str4);
        setStackTrace(str3);
        setErrorMessage(str5);
    }

    private MAMErrorEvent(PackageInfo packageInfo, String str, String str2, String str3) {
        super(EVENT_NAME, KEYS.values(), packageInfo);
        setProperty(KEYS.ERROR_NAME, str2);
        setProperty(KEYS.MAM_SDK_VERSION, str3);
        setProperty(KEYS.PROCESS_NAME, str);
    }

    public void setSeverity(Level level) {
        setProperty(KEYS.SEVERITY, level.toString());
    }

    public void setStackTrace(String str) {
        if (str.length() > MAX_STACK_TRACE_SIZE) {
            str = str.substring(0, MAX_STACK_TRACE_SIZE);
        }
        setProperty(KEYS.STACK_TRACE, str);
    }

    public String getStackTrace() {
        return getProperty(KEYS.STACK_TRACE);
    }

    public String getErrorMessage() {
        return getProperty(KEYS.ERROR_MESSAGE);
    }

    public void setErrorMessage(String str) {
        setProperty(KEYS.ERROR_MESSAGE, str);
    }

    @Override // com.microsoft.intune.mam.client.telemetry.AriaTelemetryEvent, com.microsoft.intune.mam.client.telemetry.TelemetryEvent
    public List<CustomerContentProperty> getCustomerContentProperties() {
        List<CustomerContentProperty> customerContentProperties = super.getCustomerContentProperties();
        customerContentProperties.addAll(CUSTOMER_CONTENT_PROPERTIES);
        return customerContentProperties;
    }

    public void setErrorId(MAMErrorId mAMErrorId) {
        if (mAMErrorId == null) {
            setProperty(KEYS.ERROR_ID, (String) null);
        } else {
            setProperty(KEYS.ERROR_ID, mAMErrorId.getId());
        }
    }
}

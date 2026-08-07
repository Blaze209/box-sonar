package com.microsoft.intune.mam.client.telemetry.events;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Parcelable;
import android.os.SystemClock;
import com.microsoft.intune.mam.client.telemetry.AriaTelemetryEvent;
import com.microsoft.intune.mam.client.telemetry.TelemetryEvent;
import com.microsoft.intune.mam.log.MAMLogger;
import com.microsoft.intune.mam.log.MAMLoggerProvider;
import java.io.IOException;
import java.net.HttpURLConnection;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ServiceRequestEvent extends AriaTelemetryEvent {
    private static final String EVENT_NAME = "ServiceRequest";
    private long mStartTimestampMs;
    private static final MAMLogger LOGGER = MAMLoggerProvider.getLogger(ServiceRequestEvent.class);
    public static final Parcelable.Creator<ServiceRequestEvent> CREATOR = new TelemetryEvent.ParcelableCreator(ServiceRequestEvent.class);

    public enum AuthType {
        Undefined,
        APIV2,
        Broker,
        RefreshToken
    }

    public enum KEYS {
        OPERATION_NAME,
        TARGET_URI,
        DURATION,
        SUCCEEDED,
        REQUEST_METHOD,
        RESPONSE_CONTENT_TYPE,
        PROTOCOL_STATUS_CODE,
        SERVICE_NAME,
        RESPONSE_SIZE_BYTES,
        REQUEST_ID,
        SESSION_ID,
        NETWORK_TYPE,
        NETWORK_SPEED,
        AUTH_TYPE,
        DNS_LOOKUP_TIME,
        START_TIME
    }

    public ServiceRequestEvent(JSONObject jSONObject) throws JSONException {
        super(jSONObject, EVENT_NAME, KEYS.values());
        this.mStartTimestampMs = -1L;
    }

    public ServiceRequestEvent(PackageInfo packageInfo, String str, String str2, String str3) {
        super(EVENT_NAME, KEYS.values(), packageInfo);
        this.mStartTimestampMs = -1L;
        setProperty(KEYS.OPERATION_NAME, str);
        setProperty(KEYS.SERVICE_NAME, str2);
        setProperty(KEYS.SESSION_ID, str3);
        setAuthType(AuthType.Undefined);
    }

    public void startTimer() {
        this.mStartTimestampMs = SystemClock.elapsedRealtime();
        setProperty((Enum) KEYS.START_TIME, this.mStartTimestampMs);
    }

    public void stopTimer() {
        if (this.mStartTimestampMs > 0) {
            setProperty((Enum) KEYS.DURATION, SystemClock.elapsedRealtime() - this.mStartTimestampMs);
        } else {
            LOGGER.warning("stopTimer called without preceding startStartTimestampMs. No duration logged.", new Object[0]);
        }
    }

    public void setSucceeded(boolean z) {
        setProperty(KEYS.SUCCEEDED, z);
    }

    public void setAuthType(AuthType authType) {
        setProperty(KEYS.AUTH_TYPE, authType.toString());
    }

    public void setTargetUri(String str) {
        setProperty(KEYS.TARGET_URI, str);
    }

    public void setProtocolStatusCode(String str) {
        setProperty(KEYS.PROTOCOL_STATUS_CODE, str);
    }

    public void setDNSLookupTimeMS(long j) {
        setProperty((Enum) KEYS.DNS_LOOKUP_TIME, j);
    }

    public void setRequestMethod(String str) {
        setProperty(KEYS.REQUEST_METHOD, str);
    }

    public void setResponseSizeBytes(int i) {
        setProperty((Enum) KEYS.RESPONSE_SIZE_BYTES, i);
    }

    public void setResponseContentType(String str) {
        setProperty(KEYS.RESPONSE_CONTENT_TYPE, str);
    }

    public void setRequestId(String str) {
        setProperty(KEYS.REQUEST_ID, str);
    }

    public void setConnectionData(Context context, HttpURLConnection httpURLConnection, String str) {
        if (httpURLConnection == null) {
            return;
        }
        httpURLConnection.disconnect();
        setTargetUri(String.valueOf(httpURLConnection.getURL()));
        setProperty(KEYS.REQUEST_METHOD, httpURLConnection.getRequestMethod());
        try {
            setProtocolStatusCode(String.valueOf(httpURLConnection.getResponseCode()));
        } catch (IOException unused) {
            setProtocolStatusCode("-1");
        }
        setProperty((Enum) KEYS.RESPONSE_SIZE_BYTES, httpURLConnection.getContentLength());
        setProperty(KEYS.RESPONSE_CONTENT_TYPE, httpURLConnection.getContentType());
        setProperty(KEYS.REQUEST_ID, str);
        setNetworkInfo(context);
    }

    public void setNetworkInfo(Context context) {
        NetworkInfo activeNetworkInfo;
        Object systemService = context.getSystemService("connectivity");
        if (systemService == null || (activeNetworkInfo = ((ConnectivityManager) systemService).getActiveNetworkInfo()) == null) {
            return;
        }
        if (!activeNetworkInfo.isConnected()) {
            setProperty(KEYS.NETWORK_TYPE, "Disconnected");
        } else {
            setProperty(KEYS.NETWORK_TYPE, activeNetworkInfo.getTypeName());
            setProperty(KEYS.NETWORK_SPEED, activeNetworkInfo.getSubtypeName());
        }
    }
}

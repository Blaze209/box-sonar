package com.microsoft.intune.mam.client.telemetry.events;

import android.content.pm.PackageInfo;
import android.os.Parcelable;
import android.os.SystemClock;
import com.microsoft.intune.mam.client.telemetry.AriaTelemetryEvent;
import com.microsoft.intune.mam.client.telemetry.TelemetryEvent;
import com.microsoft.intune.mam.policy.MAMWEError;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class ScenarioEvent extends AriaTelemetryEvent {
    public static final Parcelable.Creator<ScenarioEvent> CREATOR = new TelemetryEvent.ParcelableCreator(ScenarioEvent.class);
    private static final String EVENT_NAME = "Scenario";

    public enum KEYS {
        SCENARIO,
        RESULT,
        ERROR,
        SESSION_ID,
        DURATION,
        STOP_TIME,
        IS_FOREGROUND,
        SUB_OP
    }

    public enum ResultCode {
        SUCCESS,
        FAILURE,
        NOT_LICENSED,
        AUTH_NEEDED,
        WRONG_USER,
        CLIENT_EXCEPTION,
        COMPANY_PORTAL_REQUIRED,
        NETWORK_ERROR,
        NO_POLICY,
        THROTTLED_NO_OP,
        UNDEFINED,
        CANCELLED,
        WIPE_ON_ENROLLMENT
    }

    public enum Scenario {
        UNDEFINED,
        ENROLLMENT,
        UNENROLLMENT,
        ENROLLMENT_TASK,
        UNENROLLMENT_TASK,
        CHECKIN_TASK,
        LICENSE_CHECK_TASK,
        OFFLINE_ENROLLMENT,
        GET_ENCRYPTION_KEYS_TASK,
        FOREGROUND_ACQUIRE_TOKEN,
        GET_MAM_SERVICE_DEVICE_ID_TASK,
        AUTO_ENROLLMENT,
        ENROLLMENT_NO_OP,
        SAFETYNET_TASK,
        CLOUD_MANAGEMENT_VALIDATION,
        USER_LOOKUP,
        EARLY_MAM_INIT(0.01d),
        USER_CLOCK_STATUS_TASK,
        ONLINE_APP_STARTUP(0.001d),
        ONLINE_FIRST_HOOKED_ACTIVITY_STARTUP(0.001d),
        POLICYCHECKER_GET_ALL_CL_ACTIONS(1.0E-5d),
        POLICYCHECKER_MUST_CHECK_POLICIES(1.0E-5d),
        MAMCOMPONENTS_INIT(0.001d),
        APPPOLICY_CONTENTPROVIDER_STARTUP(0.001d),
        GET_IS_SHARED_DEVICE(0.001d),
        GET_SDM_INFO(0.001d),
        ORIGIN_CHECKS(1.0E-5d),
        ORIGIN_CHECK_BLOCKING_SPINNER(0.001d),
        KNOX_ATTESTATION_BLOCKING_SPINNER(0.001d),
        LOG_UPLOAD_TASK;

        private static final double DEFAULT_SAMPLING_RATIO = 1.0d;
        private final double mSamplingRatio;

        Scenario() {
            this(1.0d);
        }

        Scenario(double d) {
            this.mSamplingRatio = d;
        }

        public double getSamplingRatio() {
            return this.mSamplingRatio;
        }
    }

    public ScenarioEvent(JSONObject jSONObject) throws JSONException {
        super(jSONObject, EVENT_NAME, KEYS.values());
    }

    public ScenarioEvent(Scenario scenario, ResultCode resultCode, MAMWEError mAMWEError, String str, PackageInfo packageInfo, String str2, Long l, String str3, Boolean bool) {
        super(EVENT_NAME, KEYS.values(), str, packageInfo);
        setProperty(KEYS.SCENARIO, scenario.toString());
        setProperty(KEYS.RESULT, resultCode.toString());
        setProperty(KEYS.ERROR, mAMWEError.toString());
        setProperty(KEYS.SESSION_ID, str2);
        if (bool != null) {
            setProperty(KEYS.IS_FOREGROUND, bool.booleanValue());
        }
        if (l != null) {
            setProperty((Enum) KEYS.DURATION, l.longValue());
        }
        setProperty((Enum) KEYS.STOP_TIME, SystemClock.elapsedRealtime());
        if (str3 != null) {
            setProperty(KEYS.SUB_OP, str3);
        }
    }
}

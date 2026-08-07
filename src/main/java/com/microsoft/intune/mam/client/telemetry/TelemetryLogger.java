package com.microsoft.intune.mam.client.telemetry;

import android.content.Context;
import android.content.pm.PackageInfo;
import com.microsoft.intune.mam.client.app.AppUtils;
import com.microsoft.intune.mam.client.telemetry.events.MAMErrorEvent;
import com.microsoft.intune.mam.client.telemetry.events.ScenarioEvent;
import com.microsoft.intune.mam.client.telemetry.events.ServiceRequestEvent;
import com.microsoft.intune.mam.client.telemetry.events.TrackedOccurrence;
import com.microsoft.intune.mam.client.telemetry.events.TrackedOccurrenceEvent;
import com.microsoft.intune.mam.client.telemetry.events.TrackedOccurrenceType;
import com.microsoft.intune.mam.log.MAMErrorId;
import com.microsoft.intune.mam.log.MAMLogger;
import com.microsoft.intune.mam.log.MAMLoggerProvider;
import com.microsoft.intune.mam.log.PIIADAL;
import com.microsoft.intune.mam.log.SubOpTrace;
import com.microsoft.intune.mam.policy.MAMEnrollmentManager;
import com.microsoft.intune.mam.policy.MAMWEError;
import com.microsoft.intune.mam.policy.notification.MAMEnrollmentNotification;
import com.microsoft.intune.mam.util.NamedThreadFactory;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public abstract class TelemetryLogger {
    public static final String ANR = "ANR";
    private static final String MAM_SEVERE_ERROR_NAME_BASE = "Severe_";
    private static final String MAM_TRACKED_OCCURRENCE_NAME_BASE = "MAMTrackedOccurrence_";
    private static final int MAX_QUEUED_ASYNC_EVENTS = 50;
    private static final int MAX_THREADS = 1;
    private static final int NUM_CORE_THREADS = 1;
    public static final String SEVERE_LOG_MESSAGE = "SevereLogMessage";
    private static final int THREAD_KEEP_ALIVE_TIME_SEC = 10;
    protected final Context mContext;
    protected final SessionDurationStore mSessionDurationStore;
    private final TelemetryCache mTelemetryCache;
    private final ThreadPoolExecutor mThreadPool;
    protected static final long MAM_APP_DAILY_USE_THROTTLE = TimeUnit.HOURS.toMillis(4);
    private static final long MAM_ERROR_THROTTLE = TimeUnit.HOURS.toMillis(1);
    private static final MAMLogger LOGGER = MAMLoggerProvider.getLogger(TelemetryLogger.class);

    public abstract String getSDKVersion();

    @Deprecated
    public void logAgentIpcFailed(Throwable th) {
    }

    public abstract void logEvent(TelemetryEvent telemetryEvent);

    @Deprecated
    public void logMAMClipboardExProxyingError(Exception exc) {
    }

    @Deprecated
    public void logNativeLibrariesCorrupt(Throwable th) {
    }

    public TelemetryLogger(Context context, SessionDurationStore sessionDurationStore) {
        this(context, sessionDurationStore, new InMemoryTelemetryCache());
    }

    public TelemetryLogger(Context context, SessionDurationStore sessionDurationStore, TelemetryCache telemetryCache) {
        this.mThreadPool = new ThreadPoolExecutor(1, 1, 10L, TimeUnit.SECONDS, new ArrayBlockingQueue(50), new NamedThreadFactory("Intune MAM telemetry"));
        this.mContext = context;
        this.mSessionDurationStore = sessionDurationStore;
        this.mTelemetryCache = telemetryCache;
    }

    protected PackageInfo getPackageInfo(String str) {
        return AppUtils.getPackageInfo(this.mContext, str);
    }

    protected PackageInfo getPackageInfo(String str, long j) {
        return AppUtils.getPackageInfo(this.mContext, str, j);
    }

    protected void logIfNotThrottled(TelemetryEvent telemetryEvent, String str, long j) {
        if (this.mTelemetryCache.shouldLogEvent(str, j)) {
            logEvent(telemetryEvent);
        }
    }

    protected void logWithClientSampling(TelemetryEvent telemetryEvent, double d) {
        if (shouldLog(d)) {
            logEvent(telemetryEvent);
        }
    }

    private void logBatchWithClientSampling(Collection<TelemetryEvent> collection, double d) {
        if (shouldLog(d)) {
            Iterator<TelemetryEvent> it = collection.iterator();
            while (it.hasNext()) {
                logEvent(it.next());
            }
        }
    }

    private boolean shouldLog(double d) {
        return Math.random() < d;
    }

    public void logMAMEnrollmentResult(String str, MAMEnrollmentNotification mAMEnrollmentNotification, String str2, boolean z) {
        ScenarioEvent.Scenario scenario = mAMEnrollmentNotification.getScenario();
        MAMEnrollmentManager.Result enrollmentResult = mAMEnrollmentNotification.getEnrollmentResult();
        if (z && scenario == ScenarioEvent.Scenario.ENROLLMENT) {
            scenario = ScenarioEvent.Scenario.OFFLINE_ENROLLMENT;
        }
        ScenarioEvent.Scenario scenario2 = scenario;
        if (enrollmentResult == MAMEnrollmentManager.Result.WRONG_USER) {
            logTrackedOccurrence(str, str2, TrackedOccurrence.ENROLL_FAILED_WITH_WRONG_USER, (String) null);
        }
        logMAMScenarioStop(scenario2, getScenarioResultCode(enrollmentResult), mAMEnrollmentNotification.getError(), str, mAMEnrollmentNotification.getSessionId(), str2);
    }

    /* JADX INFO: renamed from: com.microsoft.intune.mam.client.telemetry.TelemetryLogger$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$microsoft$intune$mam$policy$MAMEnrollmentManager$Result;

        static {
            int[] iArr = new int[MAMEnrollmentManager.Result.values().length];
            $SwitchMap$com$microsoft$intune$mam$policy$MAMEnrollmentManager$Result = iArr;
            try {
                iArr[MAMEnrollmentManager.Result.COMPANY_PORTAL_REQUIRED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$microsoft$intune$mam$policy$MAMEnrollmentManager$Result[MAMEnrollmentManager.Result.ENROLLMENT_SUCCEEDED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$microsoft$intune$mam$policy$MAMEnrollmentManager$Result[MAMEnrollmentManager.Result.UNENROLLMENT_SUCCEEDED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$microsoft$intune$mam$policy$MAMEnrollmentManager$Result[MAMEnrollmentManager.Result.ENROLLMENT_FAILED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$microsoft$intune$mam$policy$MAMEnrollmentManager$Result[MAMEnrollmentManager.Result.UNENROLLMENT_FAILED.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$microsoft$intune$mam$policy$MAMEnrollmentManager$Result[MAMEnrollmentManager.Result.NOT_LICENSED.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$microsoft$intune$mam$policy$MAMEnrollmentManager$Result[MAMEnrollmentManager.Result.WRONG_USER.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$microsoft$intune$mam$policy$MAMEnrollmentManager$Result[MAMEnrollmentManager.Result.AUTHORIZATION_NEEDED.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
        }
    }

    private ScenarioEvent.ResultCode getScenarioResultCode(MAMEnrollmentManager.Result result) {
        switch (AnonymousClass1.$SwitchMap$com$microsoft$intune$mam$policy$MAMEnrollmentManager$Result[result.ordinal()]) {
            case 1:
                return ScenarioEvent.ResultCode.COMPANY_PORTAL_REQUIRED;
            case 2:
            case 3:
                return ScenarioEvent.ResultCode.SUCCESS;
            case 4:
            case 5:
                return ScenarioEvent.ResultCode.FAILURE;
            case 6:
                return ScenarioEvent.ResultCode.NOT_LICENSED;
            case 7:
                return ScenarioEvent.ResultCode.WRONG_USER;
            case 8:
                return ScenarioEvent.ResultCode.AUTH_NEEDED;
            default:
                return ScenarioEvent.ResultCode.UNDEFINED;
        }
    }

    public void logMAMScenarioStart(ScenarioEvent.Scenario scenario, String str, String str2) {
        this.mSessionDurationStore.setSessionStart(str2);
    }

    public void logMAMScenarioStop(ScenarioEvent.Scenario scenario, ScenarioEvent.ResultCode resultCode, MAMWEError mAMWEError, String str, String str2, String str3) {
        logWithClientSampling(createStopEvent(scenario, resultCode, mAMWEError, str, str2, str3, this.mSessionDurationStore.getSessionDuration(str2), null, null), scenario.getSamplingRatio());
    }

    public void logMAMScenarioStopAsync(final ScenarioEvent.Scenario scenario, final ScenarioEvent.ResultCode resultCode, final MAMWEError mAMWEError, final String str, final Long l, final Map<SubOpTrace, Long> map, final Boolean bool) {
        this.mThreadPool.execute(new Runnable() { // from class: com.microsoft.intune.mam.client.telemetry.TelemetryLogger$$ExternalSyntheticLambda0
            @Override // java.lang.Runnable
            public final void run() {
                this.f$0.m13874x92771d6c(scenario, resultCode, mAMWEError, str, l, bool, map);
            }
        });
    }

    /* JADX INFO: renamed from: lambda$logMAMScenarioStopAsync$0$com-microsoft-intune-mam-client-telemetry-TelemetryLogger, reason: not valid java name */
    /* synthetic */ void m13874x92771d6c(ScenarioEvent.Scenario scenario, ScenarioEvent.ResultCode resultCode, MAMWEError mAMWEError, String str, Long l, Boolean bool, Map map) {
        ArrayList arrayList = new ArrayList();
        arrayList.add(createStopEvent(scenario, resultCode, mAMWEError, str, null, null, l, null, bool));
        if (map != null) {
            for (Map.Entry entry : map.entrySet()) {
                arrayList.add(createStopEvent(scenario, resultCode, mAMWEError, str, null, null, (Long) entry.getValue(), ((SubOpTrace) entry.getKey()).toString(), bool));
            }
        }
        logBatchWithClientSampling(arrayList, scenario.getSamplingRatio());
    }

    private AriaTelemetryEvent createStopEvent(ScenarioEvent.Scenario scenario, ScenarioEvent.ResultCode resultCode, MAMWEError mAMWEError, String str, String str2, String str3, Long l, String str4, Boolean bool) {
        ScenarioEvent scenarioEvent = new ScenarioEvent(scenario, resultCode, mAMWEError, str, getPackageInfo(str), str2, l, str4, bool);
        scenarioEvent.setAADTenantID(str3);
        return scenarioEvent;
    }

    public void logTrackedOccurrenceForCurrentApp(TrackedOccurrenceType trackedOccurrenceType, String str) {
        logTrackedOccurrenceForCurrentApp(trackedOccurrenceType, str, null);
    }

    public void logTrackedOccurrenceForCurrentApp(TrackedOccurrenceType trackedOccurrenceType, String str, Map<String, String> map) {
        logTrackedOccurrence(this.mContext.getPackageName(), null, trackedOccurrenceType, str, map);
    }

    public void logTrackedOccurrence(String str, TrackedOccurrenceType trackedOccurrenceType, String str2) {
        logTrackedOccurrence(str, trackedOccurrenceType, str2, (Map<String, String>) null);
    }

    public void logTrackedOccurrence(String str, TrackedOccurrenceType trackedOccurrenceType, String str2, Map<String, String> map) {
        logTrackedOccurrence(str, null, trackedOccurrenceType, str2, map);
    }

    public void logTrackedOccurrence(String str, String str2, TrackedOccurrenceType trackedOccurrenceType, String str3) {
        logTrackedOccurrence(str, str2, trackedOccurrenceType, str3, null);
    }

    public void logTrackedOccurrence(String str, String str2, TrackedOccurrenceType trackedOccurrenceType, String str3, Map<String, String> map) {
        String name = trackedOccurrenceType.getName();
        long throttleMs = trackedOccurrenceType.getThrottleMs();
        LOGGER.info("tracked occurrence " + name + " : " + str3 + " " + (map != null ? new JSONObject(map).toString() : ""), new Object[0]);
        TrackedOccurrenceEvent trackedOccurrenceEvent = new TrackedOccurrenceEvent(getPackageInfo(str), getSDKVersion(), trackedOccurrenceType, str3, map);
        trackedOccurrenceEvent.setAADTenantID(str2);
        logIfNotThrottled(trackedOccurrenceEvent, MAM_TRACKED_OCCURRENCE_NAME_BASE + name, throttleMs);
    }

    public void logSevereLogMessage(Throwable th, String str, Level level, MAMErrorId mAMErrorId) {
        logSevereLogMessage(this.mContext.getPackageName(), null, th, str, level, mAMErrorId);
    }

    public void logSevereLogMessage(String str, String str2, Throwable th, String str3, Level level, MAMErrorId mAMErrorId) {
        if (str3 == null || !str3.equals(PIIADAL.HIDDEN_ADAL_LOG)) {
            if (th == null) {
                th = new Exception(str3);
            }
            logError(str, str2, SEVERE_LOG_MESSAGE, th, str3, level, mAMErrorId);
        }
    }

    public void logError(String str, String str2, Throwable th, String str3) {
        logError(str, null, str2, th, str3);
    }

    public void logError(String str, String str2, String str3, Throwable th, String str4) {
        MAMErrorEvent mAMErrorEvent = new MAMErrorEvent(getPackageInfo(str), AppUtils.getCurrentProcessName(this.mContext), str3, th, getSDKVersion(), str4);
        mAMErrorEvent.setAADTenantID(str2);
        logIfNotThrottled(mAMErrorEvent, getSevereLogMessageName(th, str4), MAM_ERROR_THROTTLE);
    }

    private void logError(String str, String str2, String str3, Throwable th, String str4, Level level, MAMErrorId mAMErrorId) {
        MAMErrorEvent mAMErrorEvent = new MAMErrorEvent(getPackageInfo(str), AppUtils.getCurrentProcessName(this.mContext), str3, th, getSDKVersion(), str4);
        mAMErrorEvent.setAADTenantID(str2);
        mAMErrorEvent.setSeverity(level);
        mAMErrorEvent.setErrorId(mAMErrorId);
        logIfNotThrottled(mAMErrorEvent, getSevereLogMessageName(th, str4), MAM_ERROR_THROTTLE);
    }

    public void logAnr(String str, String str2, String str3, String str4) {
        logEvent(new MAMErrorEvent(getPackageInfo(str), str4, ANR, str3, getSDKVersion(), str2));
    }

    private String getSevereLogMessageName(Throwable th, String str) {
        return MAM_SEVERE_ERROR_NAME_BASE + String.valueOf((th == null ? 0 : Arrays.hashCode(th.getStackTrace()) * 31) + (str != null ? str.hashCode() : 0));
    }

    public void logServiceRequest(ServiceRequestEvent serviceRequestEvent) {
        logEvent(serviceRequestEvent);
    }
}

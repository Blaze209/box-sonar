package com.microsoft.intune.mam.log;

import android.os.SystemClock;
import android.os.Trace;
import com.microsoft.intune.mam.client.telemetry.TelemetryLogger;
import com.microsoft.intune.mam.client.telemetry.events.ScenarioEvent;
import com.microsoft.intune.mam.policy.MAMWEError;
import java.io.Closeable;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.logging.Logger;

/* JADX INFO: loaded from: classes3.dex */
public final class MAMTrace {
    private static final int DEFAULT_COOKIE = 0;
    private static final Logger LOGGER = Logger.getLogger("MAMTrace");
    private static final Map<ScenarioEvent.Scenario, ScenarioTiming> ACTIVE_SCENARIOS = new ConcurrentHashMap();
    private static long sCurrentTimeMsOverride = -1;

    public interface SubOp extends Closeable {
        @Override // java.io.Closeable, java.lang.AutoCloseable
        void close();
    }

    private static boolean systemTracingSupported() {
        return true;
    }

    private static class Timing {
        long mEndTimeMs;
        long mStartTimeMs;

        private Timing() {
            this.mStartTimeMs = -1L;
            this.mEndTimeMs = -1L;
        }

        long getDuration() {
            if (this.mStartTimeMs == -1) {
                return 0L;
            }
            if (!isComplete()) {
                this.mEndTimeMs = MAMTrace.getCurrentTimeMs();
            }
            return this.mEndTimeMs - this.mStartTimeMs;
        }

        boolean isComplete() {
            return this.mEndTimeMs != -1;
        }
    }

    private static final class ScenarioTiming extends Timing {
        Map<SubOpTrace, Timing> mSubOps;

        private ScenarioTiming() {
            super();
            this.mSubOps = new ConcurrentHashMap();
        }
    }

    public static void overrideCurrentTimeMs(long j) {
        sCurrentTimeMsOverride = j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static long getCurrentTimeMs() {
        long j = sCurrentTimeMsOverride;
        return j != -1 ? j : SystemClock.elapsedRealtime();
    }

    public static void start(ScenarioEvent.Scenario scenario) {
        Map<ScenarioEvent.Scenario, ScenarioTiming> map = ACTIVE_SCENARIOS;
        if (map.containsKey(scenario)) {
            LOGGER.severe("Already tracing scenario " + scenario.name());
            return;
        }
        ScenarioTiming scenarioTiming = new ScenarioTiming();
        scenarioTiming.mStartTimeMs = getCurrentTimeMs();
        map.put(scenario, scenarioTiming);
        if (systemTracingSupported()) {
            Trace.beginAsyncSection(scenario.name(), 0);
        }
    }

    public static void endAndLog(ScenarioEvent.Scenario scenario, TelemetryLogger telemetryLogger, String str) {
        endAndLog(scenario, telemetryLogger, str, null);
    }

    public static void endAndLog(ScenarioEvent.Scenario scenario, TelemetryLogger telemetryLogger, String str, Boolean bool) {
        HashMap map;
        ScenarioTiming scenarioTimingEndInner = endInner(scenario);
        if (scenarioTimingEndInner == null) {
            return;
        }
        if (scenarioTimingEndInner.mSubOps.size() > 0) {
            map = new HashMap();
            for (Map.Entry<SubOpTrace, Timing> entry : scenarioTimingEndInner.mSubOps.entrySet()) {
                map.put(entry.getKey(), Long.valueOf(entry.getValue().getDuration()));
            }
        } else {
            map = null;
        }
        telemetryLogger.logMAMScenarioStopAsync(scenario, ScenarioEvent.ResultCode.SUCCESS, MAMWEError.NONE_KNOWN, str, Long.valueOf(scenarioTimingEndInner.getDuration()), map, bool);
    }

    private static ScenarioTiming endInner(ScenarioEvent.Scenario scenario) {
        ScenarioTiming scenarioTiming = ACTIVE_SCENARIOS.get(scenario);
        if (scenarioTiming == null) {
            LOGGER.severe("Tried to end tracing for scenario " + scenario.name() + " that was not being traced.");
            return null;
        }
        for (Map.Entry<SubOpTrace, Timing> entry : scenarioTiming.mSubOps.entrySet()) {
            if (!entry.getValue().isComplete()) {
                endSubOperation(scenario, entry.getKey());
            }
        }
        ACTIVE_SCENARIOS.remove(scenario);
        scenarioTiming.mEndTimeMs = getCurrentTimeMs();
        if (systemTracingSupported()) {
            Trace.endAsyncSection(scenario.name(), 0);
        }
        return scenarioTiming;
    }

    public static void endAndLogIfNeeded(ScenarioEvent.Scenario scenario, TelemetryLogger telemetryLogger, String str) {
        if (ACTIVE_SCENARIOS.containsKey(scenario)) {
            endAndLog(scenario, telemetryLogger, str);
        }
    }

    public static void end(ScenarioEvent.Scenario scenario) {
        endInner(scenario);
    }

    public static SubOp subOperation(final ScenarioEvent.Scenario scenario, final SubOpTrace subOpTrace) {
        startSubOperation(scenario, subOpTrace);
        return new SubOp() { // from class: com.microsoft.intune.mam.log.MAMTrace$$ExternalSyntheticLambda0
            @Override // com.microsoft.intune.mam.log.MAMTrace.SubOp, java.io.Closeable, java.lang.AutoCloseable
            public final void close() {
                MAMTrace.endSubOperation(scenario, subOpTrace);
            }
        };
    }

    public static void startSubOperation(ScenarioEvent.Scenario scenario, SubOpTrace subOpTrace) {
        ScenarioTiming scenarioTiming = ACTIVE_SCENARIOS.get(scenario);
        if (scenarioTiming == null) {
            return;
        }
        if (scenarioTiming.mSubOps.containsKey(subOpTrace)) {
            LOGGER.severe("Tried to start tracing for sub-operation " + subOpTrace + " for scenario " + scenario.name() + " that is already being traced.");
            return;
        }
        Timing timing = new Timing();
        timing.mStartTimeMs = getCurrentTimeMs();
        scenarioTiming.mSubOps.put(subOpTrace, timing);
        if (systemTracingSupported()) {
            Trace.beginAsyncSection(getSubOperationTraceName(scenario, subOpTrace.toString()), 0);
        }
    }

    public static void endSubOperation(ScenarioEvent.Scenario scenario, SubOpTrace subOpTrace) {
        ScenarioTiming scenarioTiming = ACTIVE_SCENARIOS.get(scenario);
        if (scenarioTiming == null) {
            return;
        }
        Timing timing = scenarioTiming.mSubOps.get(subOpTrace);
        if (timing == null) {
            LOGGER.severe("Tried to end tracing for sub-operation " + subOpTrace + " for scenario " + scenario.name() + " that was not being traced.");
            return;
        }
        timing.mEndTimeMs = getCurrentTimeMs();
        if (systemTracingSupported()) {
            Trace.endAsyncSection(getSubOperationTraceName(scenario, subOpTrace.toString()), 0);
        }
    }

    private static String getSubOperationTraceName(ScenarioEvent.Scenario scenario, String str) {
        return scenario.name() + ": " + str;
    }

    private MAMTrace() {
    }
}

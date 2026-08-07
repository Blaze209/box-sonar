package com.microsoft.identity.common.java.telemetry;

import com.microsoft.identity.common.java.logging.DiagnosticContext;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.telemetry.adapter.BrokerTelemetryAdapter;
import com.microsoft.identity.common.java.telemetry.adapter.TelemetryAggregationAdapter;
import com.microsoft.identity.common.java.telemetry.adapter.TelemetryDefaultAdapter;
import com.microsoft.identity.common.java.telemetry.events.BaseEvent;
import com.microsoft.identity.common.java.telemetry.observers.IBrokerTelemetryObserver;
import com.microsoft.identity.common.java.telemetry.observers.ITelemetryAggregatedObserver;
import com.microsoft.identity.common.java.telemetry.observers.ITelemetryDefaultObserver;
import com.microsoft.identity.common.java.telemetry.observers.ITelemetryObserver;
import com.microsoft.identity.common.java.telemetry.rules.TelemetryPiiOiiRules;
import com.microsoft.identity.common.java.util.StringUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes14.dex */
@Deprecated
public class Telemetry {
    private static final String TAG = "Telemetry";
    private static Queue<ITelemetryObserver> mObservers;
    private static volatile Telemetry sTelemetryInstance;
    private TelemetryConfiguration mDefaultConfiguration;
    private boolean mIsDebugging;
    private final boolean mIsTelemetryEnabled;
    private AbstractTelemetryContext mTelemetryContext;
    private Queue<Map<String, String>> mTelemetryRawDataMap;

    protected Telemetry() {
        this.mIsTelemetryEnabled = false;
    }

    private Telemetry(Builder builder) {
        if (builder == null || builder.mTelemetryContext == null || builder.mDefaultConfiguration == null) {
            Logger.warn(TAG, "Telemetry is disabled because the Telemetry context or configuration is null");
            this.mIsTelemetryEnabled = false;
            return;
        }
        this.mIsTelemetryEnabled = true;
        this.mDefaultConfiguration = builder.mDefaultConfiguration;
        this.mTelemetryContext = builder.mTelemetryContext;
        this.mIsDebugging = builder.mIsDebugging.booleanValue();
        this.mTelemetryRawDataMap = new ConcurrentLinkedQueue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static synchronized Telemetry prepareInstance(Builder builder) {
        if (sTelemetryInstance == null || !sTelemetryInstance.mIsTelemetryEnabled) {
            sTelemetryInstance = new Telemetry(builder);
        }
        return sTelemetryInstance;
    }

    public static synchronized Telemetry getInstance() {
        if (sTelemetryInstance == null) {
            new Builder().build();
        }
        return sTelemetryInstance;
    }

    private synchronized Queue<Map<String, String>> getRequestMap() {
        return this.mTelemetryRawDataMap;
    }

    public synchronized void addObserver(ITelemetryObserver iTelemetryObserver) {
        try {
            if (iTelemetryObserver == null) {
                throw new IllegalArgumentException("Telemetry Observer instance cannot be null");
            }
            if (mObservers == null) {
                mObservers = new ConcurrentLinkedQueue();
            }
            if (!mObservers.contains(iTelemetryObserver)) {
                mObservers.add(iTelemetryObserver);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void removeObserver(Class<?> cls) {
        if (cls != null) {
            Queue<ITelemetryObserver> queue = mObservers;
            if (queue != null && !queue.isEmpty()) {
                Iterator<ITelemetryObserver> it = mObservers.iterator();
                while (it.hasNext()) {
                    if (it.next().getClass() == cls) {
                        Logger.verbose(TAG, "The [" + cls.getSimpleName() + "] observer is removed.");
                        it.remove();
                    }
                }
                return;
            }
        }
        Logger.warn(TAG + ":removeObserver", "Unable to remove the observe. Either the observer is null or the observer list is empty.");
    }

    public synchronized void removeObserver(ITelemetryObserver iTelemetryObserver) {
        if (iTelemetryObserver != null) {
            Queue<ITelemetryObserver> queue = mObservers;
            if (queue != null && !queue.isEmpty()) {
                mObservers.remove(iTelemetryObserver);
                return;
            }
        }
        Logger.warn(TAG + ":removeObserver", "Unable to remove the observer. Either the observer is null or the observer list is empty.");
    }

    public synchronized void removeAllObservers() {
        Queue<ITelemetryObserver> queue = mObservers;
        if (queue == null) {
            return;
        }
        queue.clear();
    }

    public synchronized List<ITelemetryObserver> getObservers() {
        CopyOnWriteArrayList copyOnWriteArrayList;
        if (mObservers != null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList(mObservers);
        } else {
            copyOnWriteArrayList = new CopyOnWriteArrayList();
        }
        return Collections.unmodifiableList(copyOnWriteArrayList);
    }

    public static void emit(BaseEvent baseEvent) {
        Telemetry telemetry = getInstance();
        if (telemetry.mIsTelemetryEnabled) {
            telemetry.getRequestMap().add(baseEvent.getProperties());
        }
    }

    public void flush() {
        if (getInstance().mIsTelemetryEnabled) {
            flush(DiagnosticContext.INSTANCE.getRequestContext().get("correlation_id"));
        }
    }

    public void flush(String str) {
        if (str == null) {
            throw new NullPointerException("correlationId is marked non-null but is null");
        }
        if (this.mIsTelemetryEnabled) {
            if (StringUtil.isNullOrEmpty(str)) {
                Logger.warn(TAG, "No correlation id set.");
                return;
            }
            if (this.mDefaultConfiguration.isDebugEnabled() || !this.mIsDebugging) {
                CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
                Iterator<Map<String, String>> it = this.mTelemetryRawDataMap.iterator();
                while (it.hasNext()) {
                    Map<String, String> next = it.next();
                    if (str.equalsIgnoreCase(next.get("Microsoft.MSAL.correlation_id"))) {
                        copyOnWriteArrayList.add(applyPiiOiiRule(next));
                        it.remove();
                    }
                }
                processRawMap(copyOnWriteArrayList);
            }
        }
    }

    private void processRawMap(List<Map<String, String>> list) {
        list.add(applyPiiOiiRule(this.mTelemetryContext.getProperties()));
        Queue<ITelemetryObserver> queue = mObservers;
        if (queue == null) {
            Logger.warn(TAG, "No telemetry observer set.");
            return;
        }
        for (ITelemetryObserver iTelemetryObserver : queue) {
            if (iTelemetryObserver instanceof IBrokerTelemetryObserver) {
                new BrokerTelemetryAdapter((IBrokerTelemetryObserver) iTelemetryObserver).process(list);
            } else if (iTelemetryObserver instanceof ITelemetryAggregatedObserver) {
                new TelemetryAggregationAdapter((ITelemetryAggregatedObserver) iTelemetryObserver).process(list);
            } else if (iTelemetryObserver instanceof ITelemetryDefaultObserver) {
                new TelemetryDefaultAdapter((ITelemetryDefaultObserver) iTelemetryObserver).process(list);
            } else {
                Logger.warn(TAG, "Unknown observer type: " + iTelemetryObserver.getClass());
            }
        }
    }

    public List<Map<String, String>> getMap() {
        if (getInstance().mIsTelemetryEnabled) {
            return getMap(DiagnosticContext.INSTANCE.getRequestContext().get("correlation_id"));
        }
        return Collections.emptyList();
    }

    public List<Map<String, String>> getMap(String str) {
        if (str == null) {
            throw new NullPointerException("correlationId is marked non-null but is null");
        }
        if (!this.mIsTelemetryEnabled) {
            return Collections.emptyList();
        }
        if (StringUtil.isNullOrEmpty(str)) {
            Logger.warn(TAG, "No correlation id set.");
            return Collections.emptyList();
        }
        if (!this.mDefaultConfiguration.isDebugEnabled() && this.mIsDebugging) {
            return Collections.emptyList();
        }
        ArrayList arrayList = new ArrayList();
        for (Map<String, String> map : this.mTelemetryRawDataMap) {
            if (str.equalsIgnoreCase(map.get("Microsoft.MSAL.correlation_id"))) {
                arrayList.add(applyPiiOiiRule(map));
            }
        }
        return arrayList;
    }

    private Map<String, String> applyPiiOiiRule(Map<String, String> map) {
        if (this.mDefaultConfiguration.isPiiEnabled()) {
            Logger.warn(TAG, "Telemetry PII/OII is enabled by the developer.");
            return map;
        }
        HashMap map2 = new HashMap();
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (!TelemetryPiiOiiRules.getInstance().isPiiOrOii(entry.getKey())) {
                map2.put(entry.getKey(), entry.getValue());
            }
        }
        return map2;
    }

    public static class Builder {
        private TelemetryConfiguration mDefaultConfiguration;
        private Boolean mIsDebugging;
        private AbstractTelemetryContext mTelemetryContext;

        public Builder withTelemetryContext(AbstractTelemetryContext abstractTelemetryContext) {
            this.mTelemetryContext = abstractTelemetryContext;
            return this;
        }

        public Builder isDebugging(boolean z) {
            this.mIsDebugging = Boolean.valueOf(z);
            return this;
        }

        public Builder defaultConfiguration(TelemetryConfiguration telemetryConfiguration) {
            this.mDefaultConfiguration = telemetryConfiguration;
            return this;
        }

        public Telemetry build() throws IllegalArgumentException {
            return Telemetry.prepareInstance(this);
        }
    }
}

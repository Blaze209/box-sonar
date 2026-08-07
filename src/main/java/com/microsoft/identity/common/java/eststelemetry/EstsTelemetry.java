package com.microsoft.identity.common.java.eststelemetry;

import com.microsoft.identity.common.java.commands.ICommand;
import com.microsoft.identity.common.java.commands.ICommandResult;
import com.microsoft.identity.common.java.exception.BaseException;
import com.microsoft.identity.common.java.exception.ServiceException;
import com.microsoft.identity.common.java.flighting.CommonFlight;
import com.microsoft.identity.common.java.flighting.CommonFlightsManager;
import com.microsoft.identity.common.java.interfaces.INameValueStorage;
import com.microsoft.identity.common.java.interfaces.IPlatformComponents;
import com.microsoft.identity.common.java.logging.DiagnosticContext;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.opentelemetry.AttributeName;
import com.microsoft.identity.common.java.opentelemetry.SpanExtension;
import com.microsoft.identity.common.java.result.ILocalAuthenticationResult;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import com.microsoft.identity.common.java.util.StringUtil;
import com.microsoft.identity.common.java.util.ported.InMemoryStorage;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes14.dex */
public class EstsTelemetry {
    private static final String LAST_REQUEST_TELEMETRY_STORAGE_FILE = "com.microsoft.identity.client.last_request_telemetry";
    private static final String SUPPLEMENTAL_TELEMETRY_DATA_CACHE_FILE_NAME = "com.microsoft.identity.client.supplemental_telemetry_data_cache";
    private static final String TAG = "EstsTelemetry";
    private static volatile EstsTelemetry sEstsTelemetryInstance;
    private LastRequestTelemetryCache mLastRequestTelemetryCache;
    private final INameValueStorage<Set<FailedRequest>> mSentFailedRequests;
    private INameValueStorage<String> mSupplementalTelemetryDataCache;
    private final INameValueStorage<CurrentRequestTelemetry> mTelemetryMap;

    private static class NoopEstsTelemetry extends EstsTelemetry {
        @Override // com.microsoft.identity.common.java.eststelemetry.EstsTelemetry
        public void emit(String str, int i) {
        }

        @Override // com.microsoft.identity.common.java.eststelemetry.EstsTelemetry
        public void emit(String str, long j) {
        }

        @Override // com.microsoft.identity.common.java.eststelemetry.EstsTelemetry
        public void emit(String str, String str2) {
        }

        @Override // com.microsoft.identity.common.java.eststelemetry.EstsTelemetry
        public void emit(String str, boolean z) {
        }

        @Override // com.microsoft.identity.common.java.eststelemetry.EstsTelemetry
        public void emit(Map<String, String> map) {
        }

        @Override // com.microsoft.identity.common.java.eststelemetry.EstsTelemetry
        public void emitApiId(String str) {
        }

        @Override // com.microsoft.identity.common.java.eststelemetry.EstsTelemetry
        public void emitForceRefresh(boolean z) {
        }

        NoopEstsTelemetry() {
            super(new InMemoryStorage(), new InMemoryStorage());
        }

        @Override // com.microsoft.identity.common.java.eststelemetry.EstsTelemetry
        public synchronized void setUp(LastRequestTelemetryCache lastRequestTelemetryCache) {
            if (lastRequestTelemetryCache == null) {
                throw new NullPointerException("lastRequestTelemetryCache is marked non-null but is null");
            }
        }

        @Override // com.microsoft.identity.common.java.eststelemetry.EstsTelemetry
        public synchronized void setUp(IPlatformComponents iPlatformComponents) {
            if (iPlatformComponents == null) {
                throw new NullPointerException("platformComponents is marked non-null but is null");
            }
        }

        @Override // com.microsoft.identity.common.java.eststelemetry.EstsTelemetry
        public void initTelemetryForCommand(ICommand<?> iCommand) {
            if (iCommand == null) {
                throw new NullPointerException("command is marked non-null but is null");
            }
        }

        @Override // com.microsoft.identity.common.java.eststelemetry.EstsTelemetry
        public synchronized void flush(ICommand<?> iCommand, ICommandResult iCommandResult) {
            try {
                if (iCommand == null) {
                    throw new NullPointerException("command is marked non-null but is null");
                }
                if (iCommandResult == null) {
                    throw new NullPointerException("commandResult is marked non-null but is null");
                }
            } catch (Throwable th) {
                throw th;
            }
        }

        @Override // com.microsoft.identity.common.java.eststelemetry.EstsTelemetry
        public Map<String, String> getTelemetryHeaders() {
            return Collections.emptyMap();
        }

        @Override // com.microsoft.identity.common.java.eststelemetry.EstsTelemetry
        public synchronized void clear() {
        }
    }

    EstsTelemetry() {
        this(new InMemoryStorage(), new InMemoryStorage());
    }

    EstsTelemetry(INameValueStorage<CurrentRequestTelemetry> iNameValueStorage, INameValueStorage<Set<FailedRequest>> iNameValueStorage2) {
        if (iNameValueStorage == null) {
            throw new NullPointerException("telemetryMap is marked non-null but is null");
        }
        if (iNameValueStorage2 == null) {
            throw new NullPointerException("sentFailedRequestsMap is marked non-null but is null");
        }
        this.mTelemetryMap = iNameValueStorage;
        this.mSentFailedRequests = iNameValueStorage2;
    }

    public static synchronized EstsTelemetry getInstance() {
        if (sEstsTelemetryInstance == null) {
            if (CommonFlightsManager.INSTANCE.getFlightsProvider().isFlightEnabled(CommonFlight.SKIP_ESTS_TELEMETRY)) {
                Logger.verbose(TAG, "SKIP_ESTS_TELEMETRY feature flag enabled, using NoopEstsTelemetry");
                SpanExtension.current().setAttribute(AttributeName.skipped_ests_telemetry.name(), true);
                sEstsTelemetryInstance = new NoopEstsTelemetry();
            } else {
                Logger.verbose(TAG, "SKIP_ESTS_TELEMETRY feature flag disabled, using standard EstsTelemetry");
                SpanExtension.current().setAttribute(AttributeName.skipped_ests_telemetry.name(), false);
                sEstsTelemetryInstance = new EstsTelemetry();
            }
        }
        return sEstsTelemetryInstance;
    }

    public synchronized void clear() {
        this.mTelemetryMap.clear();
        this.mSentFailedRequests.clear();
        LastRequestTelemetryCache lastRequestTelemetryCache = this.mLastRequestTelemetryCache;
        if (lastRequestTelemetryCache != null) {
            lastRequestTelemetryCache.clear();
        }
    }

    public synchronized void setUp(LastRequestTelemetryCache lastRequestTelemetryCache) {
        try {
            if (lastRequestTelemetryCache == null) {
                throw new NullPointerException("lastRequestTelemetryCache is marked non-null but is null");
            }
            if (this.mLastRequestTelemetryCache == null) {
                this.mLastRequestTelemetryCache = lastRequestTelemetryCache;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void setUp(IPlatformComponents iPlatformComponents) {
        try {
            if (iPlatformComponents == null) {
                throw new NullPointerException("platformComponents is marked non-null but is null");
            }
            if (this.mLastRequestTelemetryCache == null) {
                this.mLastRequestTelemetryCache = new LastRequestTelemetryCache(iPlatformComponents.getStorageSupplier().getUnencryptedNameValueStore(LAST_REQUEST_TELEMETRY_STORAGE_FILE, String.class));
            }
            if (this.mSupplementalTelemetryDataCache == null) {
                this.mSupplementalTelemetryDataCache = iPlatformComponents.getStorageSupplier().getUnencryptedNameValueStore(SUPPLEMENTAL_TELEMETRY_DATA_CACHE_FILE_NAME, String.class);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void initTelemetryForCommand(ICommand<?> iCommand) {
        if (iCommand == null) {
            throw new NullPointerException("command is marked non-null but is null");
        }
        if (iCommand.isEligibleForEstsTelemetry()) {
            this.mTelemetryMap.put(iCommand.getCorrelationId(), new CurrentRequestTelemetry());
            this.mSentFailedRequests.put(iCommand.getCorrelationId(), new HashSet());
        }
    }

    public void emit(Map<String, String> map) {
        if (map == null) {
            return;
        }
        for (Map.Entry<String, String> entry : map.entrySet()) {
            emit(entry.getKey(), entry.getValue());
        }
    }

    public void emit(String str, String str2) {
        if (StringUtil.isNullOrEmpty(str)) {
            return;
        }
        String str3 = DiagnosticContext.INSTANCE.getRequestContext().get("correlation_id");
        String schemaCompliantString = TelemetryUtils.getSchemaCompliantString(str2);
        CurrentRequestTelemetry currentTelemetryInstance = getCurrentTelemetryInstance(str3);
        if (currentTelemetryInstance != null) {
            currentTelemetryInstance.put(str, schemaCompliantString);
        } else {
            emitToSupplementalTelemetryCache(str, schemaCompliantString);
        }
    }

    private synchronized void emitToSupplementalTelemetryCache(String str, String str2) {
        try {
            if (str == null) {
                throw new NullPointerException("key is marked non-null but is null");
            }
            if (this.mSupplementalTelemetryDataCache != null && SchemaConstants.isOfflineEmitAllowedForThisField(str)) {
                this.mSupplementalTelemetryDataCache.put(str, str2);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void emit(String str, int i) {
        emit(str, String.valueOf(i));
    }

    public void emit(String str, long j) {
        emit(str, String.valueOf(j));
    }

    public void emit(String str, boolean z) {
        emit(str, TelemetryUtils.getSchemaCompliantStringFromBoolean(z));
    }

    public void emitApiId(String str) {
        emit("Microsoft.MSAL.api_id", str);
    }

    public void emitForceRefresh(boolean z) {
        emit("Microsoft.MSAL.force_refresh", TelemetryUtils.getSchemaCompliantStringFromBoolean(z));
    }

    public synchronized void flush(ICommand<?> iCommand, ICommandResult iCommandResult) {
        try {
            if (iCommand == null) {
                throw new NullPointerException("command is marked non-null but is null");
            }
            if (iCommandResult == null) {
                throw new NullPointerException("commandResult is marked non-null but is null");
            }
            String correlationId = iCommand.getCorrelationId();
            if (correlationId == null) {
                Logger.info(TAG + ":flush", "correlation ID is null. Nothing to flush.");
                return;
            }
            CurrentRequestTelemetry currentRequestTelemetry = this.mTelemetryMap.get(correlationId);
            if (currentRequestTelemetry == null) {
                Logger.info(TAG + ":flush", "currentTelemetry is null. Nothing to flush.");
                return;
            }
            LastRequestTelemetry lastRequestTelemetryLoadLastRequestTelemetryFromCache = loadLastRequestTelemetryFromCache();
            if (lastRequestTelemetryLoadLastRequestTelemetryFromCache == null) {
                lastRequestTelemetryLoadLastRequestTelemetryFromCache = (LastRequestTelemetry) new LastRequestTelemetry(currentRequestTelemetry.getSchemaVersion()).copySharedValues(currentRequestTelemetry);
            }
            if (isTelemetryLoggedByServer(iCommand, iCommandResult)) {
                lastRequestTelemetryLoadLastRequestTelemetryFromCache.resetSilentSuccessCount();
                lastRequestTelemetryLoadLastRequestTelemetryFromCache.wipeFailedRequestAndErrorForSubList(this.mSentFailedRequests.get(correlationId));
                INameValueStorage<String> iNameValueStorage = this.mSupplementalTelemetryDataCache;
                if (iNameValueStorage != null) {
                    iNameValueStorage.clear();
                }
            }
            String errorCodeFromCommandResult = getErrorCodeFromCommandResult(iCommandResult);
            if (errorCodeFromCommandResult != null) {
                lastRequestTelemetryLoadLastRequestTelemetryFromCache.appendFailedRequest(currentRequestTelemetry.getApiId(), correlationId, errorCodeFromCommandResult);
            } else if (iCommandResult.getResult() != null && (iCommandResult.getResult() instanceof ILocalAuthenticationResult) && ((ILocalAuthenticationResult) iCommandResult.getResult()).isServicedFromCache()) {
                lastRequestTelemetryLoadLastRequestTelemetryFromCache.incrementSilentSuccessCount();
            }
            this.mTelemetryMap.remove(correlationId);
            this.mSentFailedRequests.remove(correlationId);
            LastRequestTelemetryCache lastRequestTelemetryCache = this.mLastRequestTelemetryCache;
            if (lastRequestTelemetryCache != null) {
                lastRequestTelemetryCache.saveRequestTelemetryToCache(lastRequestTelemetryLoadLastRequestTelemetryFromCache);
            } else {
                Logger.warn(TAG + ":flush", "Last Request Telemetry Cache object was null. Unable to save request telemetry to cache.");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private LastRequestTelemetry loadLastRequestTelemetryFromCache() {
        LastRequestTelemetryCache lastRequestTelemetryCache = this.mLastRequestTelemetryCache;
        if (lastRequestTelemetryCache == null) {
            Logger.verbose(TAG + ":loadLastRequestTelemetry", "Last Request Telemetry Cache has not been initialized. Cannot load Last Request Telemetry data from cache.");
            return null;
        }
        return lastRequestTelemetryCache.getRequestTelemetryFromCache();
    }

    private String getErrorCodeFromCommandResult(ICommandResult iCommandResult) {
        if (iCommandResult == null) {
            throw new NullPointerException("commandResult is marked non-null but is null");
        }
        if (iCommandResult.getStatus() == ICommandResult.ResultStatus.ERROR) {
            return ((BaseException) iCommandResult.getResult()).getErrorCode();
        }
        if (iCommandResult.getStatus() == ICommandResult.ResultStatus.CANCEL) {
            return "user_cancel";
        }
        return null;
    }

    private boolean isTelemetryLoggedByServer(ICommand<?> iCommand, ICommandResult iCommandResult) {
        int httpStatusCode;
        if (iCommand == null) {
            throw new NullPointerException("command is marked non-null but is null");
        }
        if (iCommandResult == null) {
            throw new NullPointerException("commandResult is marked non-null but is null");
        }
        if (!iCommand.willReachTokenEndpoint()) {
            return false;
        }
        if (iCommandResult.getStatus() == ICommandResult.ResultStatus.ERROR) {
            BaseException baseException = (BaseException) iCommandResult.getResult();
            return (baseException instanceof ServiceException) && (httpStatusCode = ((ServiceException) baseException).getHttpStatusCode()) != 0 && httpStatusCode != 429 && httpStatusCode < 500;
        }
        if (iCommandResult.getStatus() == ICommandResult.ResultStatus.CANCEL) {
            return false;
        }
        return iCommandResult.getStatus() != ICommandResult.ResultStatus.COMPLETED || ((iCommandResult.getResult() instanceof ILocalAuthenticationResult) && !((ILocalAuthenticationResult) iCommandResult.getResult()).isServicedFromCache());
    }

    private String getCurrentTelemetryHeaderString() {
        String str = DiagnosticContext.INSTANCE.getRequestContext().get("correlation_id");
        if (str == null) {
            Logger.warn(TAG + ":getCurrentTelemetryHeaderString", "correlation ID is null.");
            return null;
        }
        CurrentRequestTelemetry currentRequestTelemetry = this.mTelemetryMap.get(str);
        if (currentRequestTelemetry == null) {
            Logger.warn(TAG + ":getCurrentTelemetryHeaderString", "currentTelemetry for correlation ID:" + str + " is null.");
            return null;
        }
        addFromSupplementalTelemetryToCurrentTelemetry();
        return currentRequestTelemetry.getCompleteHeaderString();
    }

    private synchronized void addFromSupplementalTelemetryToCurrentTelemetry() {
        if (this.mSupplementalTelemetryDataCache != null) {
            getInstance().emit(this.mSupplementalTelemetryDataCache.getAll());
        }
    }

    private synchronized String getLastTelemetryHeaderString() {
        if (this.mLastRequestTelemetryCache == null) {
            Logger.warn(TAG + ":getLastTelemetryHeaderString", "mLastRequestTelemetryCache is null.");
            return null;
        }
        String str = DiagnosticContext.INSTANCE.getRequestContext().get("correlation_id");
        if (str == null) {
            Logger.warn(TAG + ":getLastTelemetryHeaderString", "correlation ID is null.");
            return null;
        }
        LastRequestTelemetry requestTelemetryFromCache = this.mLastRequestTelemetryCache.getRequestTelemetryFromCache();
        if (requestTelemetryFromCache == null) {
            CurrentRequestTelemetry currentRequestTelemetry = this.mTelemetryMap.get(str);
            if (currentRequestTelemetry == null) {
                Logger.warn(TAG + ":getLastTelemetryHeaderString", "currentTelemetry for correlation ID:" + str + " is null.");
                return null;
            }
            LastRequestTelemetry lastRequestTelemetry = new LastRequestTelemetry(currentRequestTelemetry.getSchemaVersion());
            lastRequestTelemetry.copySharedValues(currentRequestTelemetry);
            lastRequestTelemetry.putInPlatformTelemetry(SchemaConstants.Key.ALL_TELEMETRY_DATA_SENT, "1");
            return lastRequestTelemetry.getCompleteHeaderString();
        }
        LastRequestTelemetry lastRequestTelemetry2 = new LastRequestTelemetry(requestTelemetryFromCache.getSchemaVersion());
        lastRequestTelemetry2.copySharedValues(requestTelemetryFromCache);
        List<FailedRequest> failedRequests = requestTelemetryFromCache.getFailedRequests();
        Set<FailedRequest> set = this.mSentFailedRequests.get(str);
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= failedRequests.size()) {
                z = true;
                break;
            }
            if (lastRequestTelemetry2.getCompleteHeaderString().length() >= 3800) {
                break;
            }
            FailedRequest failedRequest = failedRequests.get(i);
            lastRequestTelemetry2.appendFailedRequest(failedRequest);
            if (set != null) {
                set.add(failedRequest);
            }
            i++;
        }
        lastRequestTelemetry2.putInPlatformTelemetry(SchemaConstants.Key.ALL_TELEMETRY_DATA_SENT, TelemetryUtils.getSchemaCompliantStringFromBoolean(z));
        return lastRequestTelemetry2.getCompleteHeaderString();
    }

    public Map<String, String> getTelemetryHeaders() {
        HashMap map = new HashMap();
        if (!isCurrentTelemetryAvailable()) {
            return map;
        }
        String currentTelemetryHeaderString = getCurrentTelemetryHeaderString();
        String lastTelemetryHeaderString = getLastTelemetryHeaderString();
        if (currentTelemetryHeaderString == null) {
            Logger.verbose(TAG + ":getTelemetryHeaders", "Current Request Telemetry Header is null");
        } else {
            map.put(SchemaConstants.CURRENT_REQUEST_HEADER_NAME, currentTelemetryHeaderString);
        }
        if (lastTelemetryHeaderString == null) {
            Logger.verbose(TAG + ":getTelemetryHeaders", "Last Request Telemetry Header is null");
        } else {
            map.put(SchemaConstants.LAST_REQUEST_HEADER_NAME, lastTelemetryHeaderString);
        }
        return Collections.unmodifiableMap(map);
    }

    private boolean isCurrentTelemetryAvailable() {
        return getCurrentTelemetryInstance(DiagnosticContext.INSTANCE.getRequestContext().get("correlation_id")) != null;
    }

    private CurrentRequestTelemetry getCurrentTelemetryInstance(String str) {
        if (this.mTelemetryMap == null || str == null || str.equals(TelemetryEventStrings.Value.UNSET)) {
            return null;
        }
        return this.mTelemetryMap.get(str);
    }
}

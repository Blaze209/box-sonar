package com.microsoft.identity.common.internal.controllers;

import android.os.Bundle;
import com.microsoft.identity.common.exception.BrokerCommunicationException;
import com.microsoft.identity.common.internal.broker.ipc.BrokerOperationBundle;
import com.microsoft.identity.common.internal.broker.ipc.IIpcStrategy;
import com.microsoft.identity.common.internal.cache.ActiveBrokerCacheUpdater;
import com.microsoft.identity.common.internal.telemetry.Telemetry;
import com.microsoft.identity.common.internal.telemetry.events.ApiEndEvent;
import com.microsoft.identity.common.internal.telemetry.events.ApiStartEvent;
import com.microsoft.identity.common.java.commands.parameters.CommandParameters;
import com.microsoft.identity.common.java.exception.BaseException;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.marker.CodeMarkerManager;
import com.microsoft.identity.common.java.marker.PerfConstants;
import com.microsoft.identity.common.java.opentelemetry.AttributeName;
import com.microsoft.identity.common.java.opentelemetry.OTelUtility;
import com.microsoft.identity.common.java.opentelemetry.SpanExtension;
import com.microsoft.identity.common.java.opentelemetry.SpanName;
import com.microsoft.identity.common.java.util.StringUtil;
import com.microsoft.identity.common.logging.Logger;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.StatusCode;
import io.opentelemetry.context.Scope;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes14.dex */
public class BrokerOperationExecutor {
    private static final String TAG = "BrokerOperationExecutor";
    private final ActiveBrokerCacheUpdater mCacheUpdaterManager;
    private final List<IIpcStrategy> mStrategies;

    public interface BrokerOperation<T> {
        T extractResultBundle(Bundle bundle) throws BaseException;

        BrokerOperationBundle getBundle() throws ClientException;

        String getMethodName();

        String getTelemetryApiId();

        void performPrerequisites(IIpcStrategy iIpcStrategy) throws BaseException;

        void putValueInSuccessEvent(ApiEndEvent apiEndEvent, T t);
    }

    public BrokerOperationExecutor(List<IIpcStrategy> list, ActiveBrokerCacheUpdater activeBrokerCacheUpdater) {
        if (list == null) {
            throw new NullPointerException("strategies is marked non-null but is null");
        }
        if (activeBrokerCacheUpdater == null) {
            throw new NullPointerException("cacheUpdaterManager is marked non-null but is null");
        }
        this.mStrategies = list;
        this.mCacheUpdaterManager = activeBrokerCacheUpdater;
    }

    public <T extends CommandParameters, U> U execute(T t, BrokerOperation<U> brokerOperation) throws BaseException {
        if (brokerOperation == null) {
            throw new NullPointerException("operation is marked non-null but is null");
        }
        CodeMarkerManager codeMarkerManager = CodeMarkerManager.getInstance();
        codeMarkerManager.markCode(PerfConstants.CodeMarkerConstants.BROKER_OPERATION_EXECUTION_START);
        String str = TAG + ":execute";
        emitOperationStartEvent(t, brokerOperation);
        if (this.mStrategies.size() == 0) {
            ClientException clientException = new ClientException("Failed to bind the service in broker app", "No strategies can be used to connect to the broker.");
            emitOperationFailureEvent(brokerOperation, clientException);
            throw clientException;
        }
        ArrayList<BrokerCommunicationException> arrayList = new ArrayList();
        for (IIpcStrategy iIpcStrategy : this.mStrategies) {
            try {
                codeMarkerManager.markCode(PerfConstants.CodeMarkerConstants.BROKER_PROCESS_START);
                U u = (U) performStrategy(iIpcStrategy, brokerOperation);
                codeMarkerManager.markCode(PerfConstants.CodeMarkerConstants.BROKER_PROCESS_END);
                emitOperationSuccessEvent(brokerOperation, u);
                return u;
            } catch (BrokerCommunicationException e) {
                arrayList.add(e);
            } catch (BaseException e2) {
                emitOperationFailureEvent(brokerOperation, e2);
                throw e2;
            }
        }
        ClientException clientException2 = new ClientException("Failed to bind the service in broker app", "Unable to connect to the broker. Please refer to MSAL/Broker logs or suppressed exception (API 19+) for more details.");
        for (BrokerCommunicationException brokerCommunicationException : arrayList) {
            Logger.error(str, brokerCommunicationException.getMessage(), brokerCommunicationException);
            clientException2.addSuppressedException(brokerCommunicationException);
        }
        emitOperationFailureEvent(brokerOperation, clientException2);
        throw clientException2;
    }

    private <T extends CommandParameters, U> void emitOperationStartEvent(T t, BrokerOperation<U> brokerOperation) {
        if (brokerOperation == null) {
            throw new NullPointerException("operation is marked non-null but is null");
        }
        String telemetryApiId = brokerOperation.getTelemetryApiId();
        if (StringUtil.isNullOrEmpty(telemetryApiId)) {
            return;
        }
        Telemetry.emit(new ApiStartEvent().putProperties(t).putApiId(telemetryApiId));
    }

    private <U> void emitOperationSuccessEvent(BrokerOperation<U> brokerOperation, U u) {
        if (brokerOperation == null) {
            throw new NullPointerException("operation is marked non-null but is null");
        }
        String telemetryApiId = brokerOperation.getTelemetryApiId();
        if (telemetryApiId != null) {
            ApiEndEvent apiEndEvent = (ApiEndEvent) new ApiEndEvent().putApiId(telemetryApiId).isApiCallSuccessful(Boolean.TRUE);
            brokerOperation.putValueInSuccessEvent(apiEndEvent, u);
            Telemetry.emit(apiEndEvent);
        }
    }

    private <U> void emitOperationFailureEvent(BrokerOperation<U> brokerOperation, BaseException baseException) {
        if (brokerOperation == null) {
            throw new NullPointerException("operation is marked non-null but is null");
        }
        String telemetryApiId = brokerOperation.getTelemetryApiId();
        if (StringUtil.isNullOrEmpty(telemetryApiId)) {
            return;
        }
        Telemetry.emit(new ApiEndEvent().putException(baseException).putApiId(telemetryApiId));
    }

    private <T> T performStrategy(IIpcStrategy iIpcStrategy, BrokerOperation<T> brokerOperation) throws BaseException {
        if (iIpcStrategy == null) {
            throw new NullPointerException("strategy is marked non-null but is null");
        }
        if (brokerOperation == null) {
            throw new NullPointerException("operation is marked non-null but is null");
        }
        com.microsoft.identity.common.internal.logging.Logger.info(TAG + brokerOperation.getMethodName(), "Executing with IIpcStrategy: " + iIpcStrategy.getClass().getSimpleName());
        Span spanCreateSpan = OTelUtility.createSpan(SpanName.MSAL_PerformIpcStrategy.name());
        try {
            Scope scopeMakeCurrentSpan = SpanExtension.makeCurrentSpan(spanCreateSpan);
            try {
                spanCreateSpan.setAttribute(AttributeName.ipc_strategy.name(), iIpcStrategy.getType().name());
                spanCreateSpan.setAttribute(AttributeName.broker_operation_name.name(), brokerOperation.getMethodName());
                brokerOperation.performPrerequisites(iIpcStrategy);
                Bundle bundleCommunicateToBroker = iIpcStrategy.communicateToBroker(brokerOperation.getBundle());
                this.mCacheUpdaterManager.updateCachedActiveBrokerFromResultBundle(bundleCommunicateToBroker);
                spanCreateSpan.setStatus(StatusCode.OK);
                T tExtractResultBundle = brokerOperation.extractResultBundle(bundleCommunicateToBroker);
                if (scopeMakeCurrentSpan != null) {
                    scopeMakeCurrentSpan.close();
                }
                spanCreateSpan.end();
                return tExtractResultBundle;
            } catch (Throwable th) {
                if (scopeMakeCurrentSpan != null) {
                    try {
                        scopeMakeCurrentSpan.close();
                    } catch (Throwable th2) {
                        th.addSuppressed(th2);
                    }
                }
                throw th;
            }
        } catch (Throwable th3) {
            try {
                spanCreateSpan.setStatus(StatusCode.ERROR);
                spanCreateSpan.recordException(th3);
                throw th3;
            } catch (Throwable th4) {
                spanCreateSpan.end();
                throw th4;
            }
        }
    }
}

package com.microsoft.identity.common.java.commands.parameters;

import com.microsoft.identity.common.java.broker.IBrokerAccount;
import com.microsoft.identity.common.java.request.BrokerRequestType;

/* JADX INFO: loaded from: classes14.dex */
public interface IBrokerTokenCommandParameters {
    IBrokerAccount getBrokerAccount();

    String getBrokerVersion();

    String getCallerAppVersion();

    String getCallerPackageName();

    int getCallerUid();

    String getHomeAccountId();

    String getHomeTenantId();

    String getLocalAccountId();

    String getNegotiatedBrokerProtocolVersion();

    BrokerRequestType getRequestType();

    default boolean isRequestFromBroker() {
        return getRequestType() == BrokerRequestType.BROKER_RT_REQUEST || getRequestType() == BrokerRequestType.RESOLVE_INTERRUPT;
    }
}

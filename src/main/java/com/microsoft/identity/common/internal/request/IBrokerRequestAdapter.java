package com.microsoft.identity.common.internal.request;

import com.microsoft.identity.common.internal.broker.BrokerRequest;
import com.microsoft.identity.common.java.commands.parameters.DeviceCodeFlowCommandParameters;
import com.microsoft.identity.common.java.commands.parameters.InteractiveTokenCommandParameters;
import com.microsoft.identity.common.java.commands.parameters.SilentTokenCommandParameters;

/* JADX INFO: loaded from: classes14.dex */
public interface IBrokerRequestAdapter {
    BrokerRequest brokerRequestFromAcquireTokenParameters(InteractiveTokenCommandParameters interactiveTokenCommandParameters);

    BrokerRequest brokerRequestFromDeviceCodeFlowCommandParameters(DeviceCodeFlowCommandParameters deviceCodeFlowCommandParameters);

    BrokerRequest brokerRequestFromSilentOperationParameters(SilentTokenCommandParameters silentTokenCommandParameters);
}

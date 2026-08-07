package com.microsoft.identity.common.internal.result;

import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.request.SdkType;

/* JADX INFO: loaded from: classes14.dex */
public class BrokerResultAdapterFactory {
    public static IBrokerResultAdapter getBrokerResultAdapter(SdkType sdkType) {
        if (sdkType == SdkType.ADAL) {
            Logger.verbose("BrokerResultAdapterFactory", "Using AdalBrokerResultAdapter");
            return new AdalBrokerResultAdapter();
        }
        Logger.verbose("BrokerResultAdapterFactory", "Using MsalBrokerResultAdapter");
        return new MsalBrokerResultAdapter();
    }
}

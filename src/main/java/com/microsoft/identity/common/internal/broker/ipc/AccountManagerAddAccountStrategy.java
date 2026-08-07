package com.microsoft.identity.common.internal.broker.ipc;

import android.accounts.AccountManager;
import android.accounts.AccountManagerFuture;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.content.Context;
import android.os.Bundle;
import com.microsoft.identity.common.exception.BrokerCommunicationException;
import com.microsoft.identity.common.internal.activebrokerdiscovery.AccountManagerBrokerDiscoveryUtil;
import com.microsoft.identity.common.internal.broker.BrokerData;
import com.microsoft.identity.common.internal.util.AccountManagerUtil;
import com.microsoft.identity.common.internal.util.ProcessUtil;
import com.microsoft.identity.common.java.AuthenticationConstants;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.logging.Logger;
import java.io.IOException;
import java.util.HashSet;

/* JADX INFO: loaded from: classes14.dex */
public class AccountManagerAddAccountStrategy implements IIpcStrategy {
    private static final String TAG = "AccountManagerAddAccountStrategy";
    private final Context mContext;

    public AccountManagerAddAccountStrategy(Context context) {
        this.mContext = context;
    }

    @Override // com.microsoft.identity.common.internal.broker.ipc.IIpcStrategy
    public Bundle communicateToBroker(BrokerOperationBundle brokerOperationBundle) throws BrokerCommunicationException {
        String str = TAG + ":communicateToBroker";
        Logger.info(str, "Broker operation: " + brokerOperationBundle.getOperation().name() + " brokerPackage: " + brokerOperationBundle.getTargetBrokerAppPackageName());
        try {
            AccountManagerFuture<Bundle> accountManagerFutureAddAccount = AccountManager.get(this.mContext).addAccount(AuthenticationConstants.Broker.BROKER_ACCOUNT_TYPE, com.microsoft.identity.common.adal.internal.AuthenticationConstants.Broker.AUTHTOKEN_TYPE, null, brokerOperationBundle.getAccountManagerBundle(), null, null, ProcessUtil.getPreferredHandler());
            Logger.verbose(str, "Received result from broker");
            return accountManagerFutureAddAccount.getResult();
        } catch (AuthenticatorException | OperationCanceledException | IOException e) {
            Logger.error(str, e.getMessage(), e);
            throw new BrokerCommunicationException(BrokerCommunicationException.Category.CONNECTION_ERROR, getType(), "Failed to connect to AccountManager", e);
        }
    }

    @Override // com.microsoft.identity.common.internal.broker.ipc.IIpcStrategy
    public IIpcStrategy.Type getType() {
        return IIpcStrategy.Type.ACCOUNT_MANAGER_ADD_ACCOUNT;
    }

    @Override // com.microsoft.identity.common.internal.broker.ipc.IIpcStrategy
    public boolean isSupportedByTargetedBroker(String str) throws ClientException {
        BrokerData activeBrokerFromAccountManager = new AccountManagerBrokerDiscoveryUtil(this.mContext).getActiveBrokerFromAccountManager();
        if (activeBrokerFromAccountManager == null || !activeBrokerFromAccountManager.getPackageName().equalsIgnoreCase(str)) {
            return false;
        }
        HashSet hashSet = new HashSet();
        hashSet.add(AuthenticationConstants.Broker.BROKER_ACCOUNT_TYPE);
        return AccountManagerUtil.canUseAccountManagerOperation(this.mContext, hashSet);
    }
}

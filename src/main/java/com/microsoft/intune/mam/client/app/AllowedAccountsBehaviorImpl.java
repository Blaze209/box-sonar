package com.microsoft.intune.mam.client.app;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.RestrictionsManager;
import android.os.Bundle;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.microsoft.intune.mam.log.MAMLogPIIFactory;
import com.microsoft.intune.mam.log.MAMLogger;
import com.microsoft.intune.mam.log.MAMLoggerProvider;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
public class AllowedAccountsBehaviorImpl implements AllowedAccountsBehavior {
    protected static final String KEY_ALLOWED_ACCOUNTS = "com.microsoft.intune.mam.AllowedAccountUPNs";
    private static final MAMLogger LOGGER = MAMLoggerProvider.getLogger(AllowedAccountsBehaviorImpl.class);
    private final Context mContext;
    private final Map<AllowedAccountsListener, BroadcastReceiver> mListeners = new HashMap();
    private final MAMLogPIIFactory mPIIFactory;

    public AllowedAccountsBehaviorImpl(Context context, MAMLogPIIFactory mAMLogPIIFactory) {
        this.mContext = context;
        this.mPIIFactory = mAMLogPIIFactory;
    }

    @Override // com.microsoft.intune.mam.client.app.AllowedAccountsBehavior
    public List<AllowedAccountInfo> getAllowedAccounts() {
        return getAllowedAccounts(getAllowedUsersRawValue());
    }

    @Override // com.microsoft.intune.mam.client.app.AllowedAccountsBehavior
    public boolean isAccountAllowed(String str) {
        return isAccountAllowed(getAllowedAccounts(), str);
    }

    protected boolean isAccountAllowed(List<AllowedAccountInfo> list, String str) {
        if (list == null) {
            return true;
        }
        if (str == null) {
            return false;
        }
        for (AllowedAccountInfo allowedAccountInfo : list) {
            if (allowedAccountInfo.getUPN().equalsIgnoreCase(str)) {
                return true;
            }
            String aADUserId = allowedAccountInfo.getAADUserId();
            if (aADUserId != null && aADUserId.equalsIgnoreCase(str)) {
                return true;
            }
        }
        LOGGER.info("Informing app that user {0} is not allowed.", this.mPIIFactory.getPIIUPN(str));
        return false;
    }

    @Override // com.microsoft.intune.mam.client.app.AllowedAccountsBehavior
    public synchronized void listenForChanges(final AllowedAccountsListener allowedAccountsListener) {
        if (this.mListeners.containsKey(allowedAccountsListener)) {
            LOGGER.info("ignoring already registered listener", new Object[0]);
            return;
        }
        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("android.intent.action.APPLICATION_RESTRICTIONS_CHANGED");
        BroadcastReceiver broadcastReceiver = new BroadcastReceiver() { // from class: com.microsoft.intune.mam.client.app.AllowedAccountsBehaviorImpl.1
            @Override // android.content.BroadcastReceiver
            public void onReceive(Context context, Intent intent) {
                allowedAccountsListener.onAllowedAccountsChanged();
            }
        };
        this.mContext.registerReceiver(broadcastReceiver, intentFilter);
        this.mListeners.put(allowedAccountsListener, broadcastReceiver);
    }

    @Override // com.microsoft.intune.mam.client.app.AllowedAccountsBehavior
    public synchronized void unregisterListener(AllowedAccountsListener allowedAccountsListener) {
        if (this.mListeners.containsKey(allowedAccountsListener)) {
            this.mContext.unregisterReceiver(this.mListeners.get(allowedAccountsListener));
            this.mListeners.remove(allowedAccountsListener);
        }
    }

    protected List<AllowedAccountInfo> getAllowedAccounts(String str) {
        if (str == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        for (String str2 : str.split(AuthenticationConstants.Broker.CHALLENGE_REQUEST_CERT_AUTH_DELIMETER)) {
            String[] strArrSplit = str2.split(":");
            if (strArrSplit.length == 0 || strArrSplit[0].isEmpty()) {
                LOGGER.warning("Unexpected empty account info", new Object[0]);
            } else {
                final String str3 = strArrSplit[0];
                final String str4 = (strArrSplit.length <= 1 || strArrSplit[1].isEmpty()) ? null : strArrSplit[1];
                arrayList.add(new AllowedAccountInfo() { // from class: com.microsoft.intune.mam.client.app.AllowedAccountsBehaviorImpl.2
                    @Override // com.microsoft.intune.mam.client.app.AllowedAccountInfo
                    public String getUPN() {
                        return str3;
                    }

                    @Override // com.microsoft.intune.mam.client.app.AllowedAccountInfo
                    public String getAADUserId() {
                        return str4;
                    }
                });
            }
        }
        if (!arrayList.isEmpty()) {
            return arrayList;
        }
        LOGGER.warning("AllowedAccounts setting was non-null but could not be parsed", new Object[0]);
        return null;
    }

    private String getAllowedUsersRawValue() {
        Bundle applicationRestrictions = ((RestrictionsManager) this.mContext.getSystemService("restrictions")).getApplicationRestrictions();
        if (applicationRestrictions == null) {
            return null;
        }
        return canonicalizeRawUsers(applicationRestrictions.getString(KEY_ALLOWED_ACCOUNTS));
    }

    protected static String canonicalizeRawUsers(String str) {
        if (str == null) {
            return null;
        }
        String strTrim = str.trim();
        if (strTrim.isEmpty()) {
            return null;
        }
        return strTrim;
    }
}

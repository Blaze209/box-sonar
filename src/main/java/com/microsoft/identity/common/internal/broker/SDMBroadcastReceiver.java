package com.microsoft.identity.common.internal.broker;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Build;
import com.microsoft.identity.common.components.AndroidPlatformComponentsFactory;
import com.microsoft.identity.common.internal.activebrokerdiscovery.BrokerDiscoveryClientFactory;
import com.microsoft.identity.common.internal.controllers.BrokerMsalController;
import com.microsoft.identity.common.java.cache.CacheKeyValueDelegate;
import com.microsoft.identity.common.java.cache.SharedPreferencesAccountCredentialCache;
import com.microsoft.identity.common.java.commands.parameters.CommandParameters;
import com.microsoft.identity.common.java.constants.SharedDeviceModeConstants;
import com.microsoft.identity.common.java.exception.BaseException;
import com.microsoft.identity.common.java.interfaces.IPlatformComponents;
import com.microsoft.identity.common.logging.Logger;
import com.microsoft.intune.mam.client.content.MAMBroadcastReceiver;
import java.util.UUID;

/* JADX INFO: loaded from: classes14.dex */
public class SDMBroadcastReceiver {
    private static final String TAG = "SDMBroadcastReceiver";
    private static BroadcastReceiver sSDMBroadcastReceiver;

    public interface SharedDeviceModeCallback {
        void onGlobalSignOut();

        void onSharedDeviceModeRegistered();

        void onSharedDeviceModeRegistrationStarted();
    }

    public static synchronized void initialize(Context context, final SharedDeviceModeCallback sharedDeviceModeCallback) {
        if (sSDMBroadcastReceiver == null) {
            sSDMBroadcastReceiver = new MAMBroadcastReceiver() { // from class: com.microsoft.identity.common.internal.broker.SDMBroadcastReceiver.1
                @Override // com.microsoft.intune.mam.client.content.HookedBroadcastReceiver
                public void onMAMReceive(Context context2, Intent intent) {
                    SDMBroadcastReceiver.handleSharedDeviceModeBroadCast(context2, intent, sharedDeviceModeCallback);
                }
            };
            IntentFilter intentFilter = new IntentFilter(SharedDeviceModeConstants.CURRENT_ACCOUNT_CHANGED_BROADCAST_IDENTIFIER);
            if (Build.VERSION.SDK_INT >= 33) {
                context.registerReceiver(sSDMBroadcastReceiver, intentFilter, 2);
            } else {
                context.registerReceiver(sSDMBroadcastReceiver, intentFilter);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:23:0x006f  */
    public static void handleSharedDeviceModeBroadCast(Context context, Intent intent, SharedDeviceModeCallback sharedDeviceModeCallback) {
        byte b;
        String str = TAG + ":handleSharedDeviceModeBroadCast";
        String stringExtra = intent.getStringExtra(SharedDeviceModeConstants.BROADCAST_TYPE_KEY);
        Logger.info(str, "Received SDM broadcast with type: " + stringExtra);
        try {
            IPlatformComponents iPlatformComponentsCreateFromContext = AndroidPlatformComponentsFactory.createFromContext(context);
            if (stringExtra == null) {
                Logger.warn(str, "ignoring null broadcast type ");
                return;
            }
            int iHashCode = stringExtra.hashCode();
            if (iHashCode != -730319227) {
                if (iHashCode != -580826561) {
                    if (iHashCode == 712651464 && stringExtra.equals(SharedDeviceModeConstants.BROADCAST_TYPE_GLOBAL_SIGN_OUT)) {
                        b = 2;
                    } else {
                        b = -1;
                    }
                } else if (stringExtra.equals(SharedDeviceModeConstants.BROADCAST_TYPE_SDM_REGISTRATION_START)) {
                    b = 0;
                } else {
                    b = -1;
                }
            } else if (stringExtra.equals(SharedDeviceModeConstants.BROADCAST_TYPE_SDM_REGISTERED)) {
                b = 1;
            } else {
                b = -1;
            }
            if (b == 0) {
                sharedDeviceModeCallback.onSharedDeviceModeRegistrationStarted();
                return;
            }
            if (b != 1) {
                if (b == 2) {
                    sharedDeviceModeCallback.onGlobalSignOut();
                    return;
                } else {
                    Logger.warn(str, "ignoring unknown broadcast type " + stringExtra);
                    return;
                }
            }
            if (isDeviceInSharedMode(context, iPlatformComponentsCreateFromContext)) {
                Logger.info(str, "Device is registered in SDM, clearing default account cache.");
                new SharedPreferencesAccountCredentialCache(new CacheKeyValueDelegate(), iPlatformComponentsCreateFromContext.getStorageSupplier().getEncryptedNameValueStore(SharedPreferencesAccountCredentialCache.DEFAULT_ACCOUNT_CREDENTIAL_SHARED_PREFERENCES, String.class)).clearAll();
                sharedDeviceModeCallback.onSharedDeviceModeRegistered();
                return;
            }
            Logger.warn(str, "Device not in shared device mode, ignore broadcast.");
        } catch (BaseException e) {
            Logger.error(str, "Failed to handle SDM broadcast", e);
        }
    }

    private static boolean isDeviceInSharedMode(Context context, IPlatformComponents iPlatformComponents) throws BaseException {
        BrokerData activeBroker = BrokerDiscoveryClientFactory.getInstanceForBrokerSdk(context, iPlatformComponents).getActiveBroker(false);
        if (activeBroker == null) {
            return false;
        }
        return new BrokerMsalController(context, iPlatformComponents, activeBroker.getPackageName()).getDeviceMode(CommandParameters.builder().platformComponents(iPlatformComponents).correlationId(UUID.randomUUID().toString()).build());
    }
}

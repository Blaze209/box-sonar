package com.microsoft.identity.common.internal.broker;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.text.TextUtils;
import com.microsoft.identity.client.IMicrosoftAuthService;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.microsoft.identity.common.exception.BrokerCommunicationException;
import com.microsoft.identity.common.internal.broker.ipc.BrokerOperationBundle;
import com.microsoft.identity.common.internal.broker.ipc.IIpcStrategy;

/* JADX INFO: loaded from: classes14.dex */
public class MicrosoftAuthClient extends BoundServiceClient<IMicrosoftAuthService> {
    private static final String MICROSOFT_AUTH_SERVICE_CLASS_NAME = "com.microsoft.identity.client.MicrosoftAuthService";
    private static final String MICROSOFT_AUTH_SERVICE_INTENT_FILTER = "com.microsoft.identity.client.MicrosoftAuth";

    public MicrosoftAuthClient(Context context) {
        super(context, MICROSOFT_AUTH_SERVICE_CLASS_NAME, MICROSOFT_AUTH_SERVICE_INTENT_FILTER);
    }

    public MicrosoftAuthClient(Context context, int i) {
        super(context, MICROSOFT_AUTH_SERVICE_INTENT_FILTER, MICROSOFT_AUTH_SERVICE_CLASS_NAME, i);
    }

    /* JADX INFO: renamed from: com.microsoft.identity.common.internal.broker.MicrosoftAuthClient$1, reason: invalid class name */
    static /* synthetic */ class AnonymousClass1 {
        static final /* synthetic */ int[] $SwitchMap$com$microsoft$identity$common$internal$broker$ipc$BrokerOperationBundle$Operation;

        static {
            int[] iArr = new int[BrokerOperationBundle.Operation.values().length];
            $SwitchMap$com$microsoft$identity$common$internal$broker$ipc$BrokerOperationBundle$Operation = iArr;
            try {
                iArr[BrokerOperationBundle.Operation.MSAL_HELLO.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$microsoft$identity$common$internal$broker$ipc$BrokerOperationBundle$Operation[BrokerOperationBundle.Operation.MSAL_GET_INTENT_FOR_INTERACTIVE_REQUEST.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                $SwitchMap$com$microsoft$identity$common$internal$broker$ipc$BrokerOperationBundle$Operation[BrokerOperationBundle.Operation.MSAL_ACQUIRE_TOKEN_SILENT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                $SwitchMap$com$microsoft$identity$common$internal$broker$ipc$BrokerOperationBundle$Operation[BrokerOperationBundle.Operation.MSAL_GET_ACCOUNTS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                $SwitchMap$com$microsoft$identity$common$internal$broker$ipc$BrokerOperationBundle$Operation[BrokerOperationBundle.Operation.MSAL_REMOVE_ACCOUNT.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                $SwitchMap$com$microsoft$identity$common$internal$broker$ipc$BrokerOperationBundle$Operation[BrokerOperationBundle.Operation.MSAL_GET_DEVICE_MODE.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                $SwitchMap$com$microsoft$identity$common$internal$broker$ipc$BrokerOperationBundle$Operation[BrokerOperationBundle.Operation.MSAL_GET_CURRENT_ACCOUNT_IN_SHARED_DEVICE.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                $SwitchMap$com$microsoft$identity$common$internal$broker$ipc$BrokerOperationBundle$Operation[BrokerOperationBundle.Operation.MSAL_SIGN_OUT_FROM_SHARED_DEVICE.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                $SwitchMap$com$microsoft$identity$common$internal$broker$ipc$BrokerOperationBundle$Operation[BrokerOperationBundle.Operation.MSAL_GENERATE_SHR.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.microsoft.identity.common.internal.broker.BoundServiceClient
    public Bundle performOperationInternal(BrokerOperationBundle brokerOperationBundle, IMicrosoftAuthService iMicrosoftAuthService) throws BrokerCommunicationException, RemoteException {
        Bundle bundle = brokerOperationBundle.getBundle();
        switch (AnonymousClass1.$SwitchMap$com$microsoft$identity$common$internal$broker$ipc$BrokerOperationBundle$Operation[brokerOperationBundle.getOperation().ordinal()]) {
            case 1:
                return iMicrosoftAuthService.hello(bundle);
            case 2:
                Intent intentForInteractiveRequest = iMicrosoftAuthService.getIntentForInteractiveRequest();
                Bundle extras = intentForInteractiveRequest.getExtras();
                if (intentForInteractiveRequest.getComponent() != null && !TextUtils.isEmpty(intentForInteractiveRequest.getPackage()) && !TextUtils.isEmpty(intentForInteractiveRequest.getComponent().getClassName())) {
                    extras.putString(AuthenticationConstants.Broker.BROKER_PACKAGE_NAME, intentForInteractiveRequest.getPackage());
                    extras.putString(AuthenticationConstants.Broker.BROKER_ACTIVITY_NAME, intentForInteractiveRequest.getComponent().getClassName());
                }
                return extras;
            case 3:
                return iMicrosoftAuthService.acquireTokenSilently(bundle);
            case 4:
                return iMicrosoftAuthService.getAccounts(bundle);
            case 5:
                return iMicrosoftAuthService.removeAccount(bundle);
            case 6:
                return iMicrosoftAuthService.getDeviceMode();
            case 7:
                return iMicrosoftAuthService.getCurrentAccount(bundle);
            case 8:
                return iMicrosoftAuthService.removeAccountFromSharedDevice(bundle);
            case 9:
                return iMicrosoftAuthService.generateSignedHttpRequest(bundle);
            default:
                throw new BrokerCommunicationException(BrokerCommunicationException.Category.OPERATION_NOT_SUPPORTED_ON_CLIENT_SIDE, IIpcStrategy.Type.BOUND_SERVICE, "Operation " + brokerOperationBundle.getOperation().name() + " is not supported by MicrosoftAuthClient.", null);
        }
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    @Override // com.microsoft.identity.common.internal.broker.BoundServiceClient
    public IMicrosoftAuthService getInterfaceFromIBinder(IBinder iBinder) {
        IMicrosoftAuthService iMicrosoftAuthServiceAsInterface = IMicrosoftAuthService.Stub.asInterface(iBinder);
        if (iMicrosoftAuthServiceAsInterface != null) {
            return iMicrosoftAuthServiceAsInterface;
        }
        throw new IllegalStateException("Failed to extract IMicrosoftAuthService from IBinder.", null);
    }
}

package com.microsoft.identity.common.internal.broker.ipc;

import android.accounts.AccountManager;
import android.accounts.AuthenticatorDescription;
import android.accounts.AuthenticatorException;
import android.accounts.OperationCanceledException;
import android.content.Context;
import android.os.Bundle;
import com.microsoft.identity.common.exception.BrokerCommunicationException;
import com.microsoft.identity.common.internal.broker.BrokerData;
import com.microsoft.identity.common.internal.broker.BrokerValidator;
import com.microsoft.identity.common.internal.broker.IBrokerValidator;
import com.microsoft.identity.common.internal.util.AccountManagerUtil;
import com.microsoft.identity.common.internal.util.ProcessUtil;
import com.microsoft.identity.common.logging.Logger;
import java.io.IOException;
import java.util.Iterator;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: AccountManagerBackupIpcStrategyTargetingSpecificBrokerApp.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dBo\b\u0000\u0012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003\u00126\u0010\u0005\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\n0\u0006\u0012\u0012\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\r\u0012\u0006\u0010\u0010\u001a\u00020\u0011¢\u0006\u0002\u0010\u0012J\u0012\u0010\u0013\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u0004H\u0016J\u0018\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u0004H\u0002R\u001a\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000f0\u000e0\rX\u0082\u0004¢\u0006\u0002\n\u0000R>\u0010\u0005\u001a2\u0012\u0013\u0012\u00110\u0004¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\t\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u0007\u0012\b\b\b\u0012\u0004\b\b(\u000b\u0012\u0004\u0012\u00020\n0\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001e"}, d2 = {"Lcom/microsoft/identity/common/internal/broker/ipc/AccountManagerBackupIpcStrategyTargetingSpecificBrokerApp;", "Lcom/microsoft/identity/common/internal/broker/ipc/IIpcStrategy;", "accountTypeForEachPackage", "", "", "sendRequestViaAccountManager", "Lkotlin/Function2;", "Lkotlin/ParameterName;", "name", "accountType", "Landroid/os/Bundle;", "bundle", "getAccountManagerApps", "Lkotlin/Function0;", "", "Landroid/accounts/AuthenticatorDescription;", "brokerValidator", "Lcom/microsoft/identity/common/internal/broker/IBrokerValidator;", "(Ljava/util/Map;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function0;Lcom/microsoft/identity/common/internal/broker/IBrokerValidator;)V", "communicateToBroker", "Lcom/microsoft/identity/common/internal/broker/ipc/BrokerOperationBundle;", "getType", "Lcom/microsoft/identity/common/internal/broker/ipc/IIpcStrategy$Type;", "isSupportedByTargetedBroker", "", "targetedBrokerPackageName", "validateTargetApp", "", "targetPackageName", "Companion", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AccountManagerBackupIpcStrategyTargetingSpecificBrokerApp implements IIpcStrategy {
    public static final String AUTHAPP_BACKUP_IPC_ACCOUNT_MANAGER_ACCOUNT_TYPE = "com.microsoft.authapppassthroughbackup";
    public static final String CONTENT_PROVIDER_PATH_KEY = "CONTENT_PROVIDER_PATH";
    public static final String CP_BACKUP_IPC_ACCOUNT_MANAGER_ACCOUNT_TYPE = "com.microsoft.cppassthroughbackup";
    public static final String LTW_BACKUP_IPC_ACCOUNT_MANAGER_ACCOUNT_TYPE = "com.microsoft.ltwpassthroughbackup";
    public static final String REQUEST_BUNDLE_KEY = "REQUEST_BUNDLE";
    private final Map<String, String> accountTypeForEachPackage;
    private final IBrokerValidator brokerValidator;
    private final Function0<AuthenticatorDescription[]> getAccountManagerApps;
    private final Function2<String, Bundle, Bundle> sendRequestViaAccountManager;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = Reflection.getOrCreateKotlinClass(AccountManagerBackupIpcStrategyTargetingSpecificBrokerApp.class).getSimpleName();

    /* JADX WARN: Multi-variable type inference failed */
    public AccountManagerBackupIpcStrategyTargetingSpecificBrokerApp(Map<String, String> accountTypeForEachPackage, Function2<? super String, ? super Bundle, Bundle> sendRequestViaAccountManager, Function0<AuthenticatorDescription[]> getAccountManagerApps, IBrokerValidator brokerValidator) {
        Intrinsics.checkNotNullParameter(accountTypeForEachPackage, "accountTypeForEachPackage");
        Intrinsics.checkNotNullParameter(sendRequestViaAccountManager, "sendRequestViaAccountManager");
        Intrinsics.checkNotNullParameter(getAccountManagerApps, "getAccountManagerApps");
        Intrinsics.checkNotNullParameter(brokerValidator, "brokerValidator");
        this.accountTypeForEachPackage = accountTypeForEachPackage;
        this.sendRequestViaAccountManager = sendRequestViaAccountManager;
        this.getAccountManagerApps = getAccountManagerApps;
        this.brokerValidator = brokerValidator;
    }

    /* JADX INFO: compiled from: AccountManagerBackupIpcStrategyTargetingSpecificBrokerApp.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0019\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\rH\u0000¢\u0006\u0002\b\u000eJ\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u0012R\u000e\u0010\u0003\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0080T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b¨\u0006\u0013"}, d2 = {"Lcom/microsoft/identity/common/internal/broker/ipc/AccountManagerBackupIpcStrategyTargetingSpecificBrokerApp$Companion;", "", "()V", "AUTHAPP_BACKUP_IPC_ACCOUNT_MANAGER_ACCOUNT_TYPE", "", "CONTENT_PROVIDER_PATH_KEY", "CP_BACKUP_IPC_ACCOUNT_MANAGER_ACCOUNT_TYPE", "LTW_BACKUP_IPC_ACCOUNT_MANAGER_ACCOUNT_TYPE", "REQUEST_BUNDLE_KEY", "TAG", "getTAG", "()Ljava/lang/String;", "getAccountTypeForEachPackage", "", "getAccountTypeForEachPackage$common_distRelease", "tryCreateInstance", "Lcom/microsoft/identity/common/internal/broker/ipc/AccountManagerBackupIpcStrategyTargetingSpecificBrokerApp;", "context", "Landroid/content/Context;", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getTAG() {
            return AccountManagerBackupIpcStrategyTargetingSpecificBrokerApp.TAG;
        }

        public final Map<String, String> getAccountTypeForEachPackage$common_distRelease() {
            Map<String, String> mapMapOf = MapsKt.mapOf(TuplesKt.to(BrokerData.INSTANCE.getDebugMockLtw().getPackageName(), AccountManagerBackupIpcStrategyTargetingSpecificBrokerApp.LTW_BACKUP_IPC_ACCOUNT_MANAGER_ACCOUNT_TYPE), TuplesKt.to(BrokerData.INSTANCE.getProdLTW().getPackageName(), AccountManagerBackupIpcStrategyTargetingSpecificBrokerApp.LTW_BACKUP_IPC_ACCOUNT_MANAGER_ACCOUNT_TYPE), TuplesKt.to(BrokerData.INSTANCE.getDebugMockCp().getPackageName(), AccountManagerBackupIpcStrategyTargetingSpecificBrokerApp.CP_BACKUP_IPC_ACCOUNT_MANAGER_ACCOUNT_TYPE), TuplesKt.to(BrokerData.INSTANCE.getProdCompanyPortal().getPackageName(), AccountManagerBackupIpcStrategyTargetingSpecificBrokerApp.CP_BACKUP_IPC_ACCOUNT_MANAGER_ACCOUNT_TYPE), TuplesKt.to(BrokerData.INSTANCE.getDebugMockAuthApp().getPackageName(), AccountManagerBackupIpcStrategyTargetingSpecificBrokerApp.AUTHAPP_BACKUP_IPC_ACCOUNT_MANAGER_ACCOUNT_TYPE), TuplesKt.to(BrokerData.INSTANCE.getProdMicrosoftAuthenticator().getPackageName(), AccountManagerBackupIpcStrategyTargetingSpecificBrokerApp.AUTHAPP_BACKUP_IPC_ACCOUNT_MANAGER_ACCOUNT_TYPE));
            Iterator<T> it = BrokerData.INSTANCE.getProdBrokers().iterator();
            while (it.hasNext()) {
                mapMapOf.containsKey(((BrokerData) it.next()).getPackageName());
            }
            return mapMapOf;
        }

        public final AccountManagerBackupIpcStrategyTargetingSpecificBrokerApp tryCreateInstance(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            if (!AccountManagerUtil.canUseAccountManagerOperation(context, SetsKt.setOf((Object[]) new String[]{AccountManagerBackupIpcStrategyTargetingSpecificBrokerApp.LTW_BACKUP_IPC_ACCOUNT_MANAGER_ACCOUNT_TYPE, AccountManagerBackupIpcStrategyTargetingSpecificBrokerApp.CP_BACKUP_IPC_ACCOUNT_MANAGER_ACCOUNT_TYPE, AccountManagerBackupIpcStrategyTargetingSpecificBrokerApp.AUTHAPP_BACKUP_IPC_ACCOUNT_MANAGER_ACCOUNT_TYPE}))) {
                return null;
            }
            final AccountManager accountManager = AccountManager.get(context);
            return new AccountManagerBackupIpcStrategyTargetingSpecificBrokerApp(getAccountTypeForEachPackage$common_distRelease(), new Function2<String, Bundle, Bundle>() { // from class: com.microsoft.identity.common.internal.broker.ipc.AccountManagerBackupIpcStrategyTargetingSpecificBrokerApp$Companion$tryCreateInstance$1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public final Bundle invoke(String accountType, Bundle requestBundle) throws OperationCanceledException, IOException, AuthenticatorException {
                    Intrinsics.checkNotNullParameter(accountType, "accountType");
                    Intrinsics.checkNotNullParameter(requestBundle, "requestBundle");
                    Bundle result = accountManager.addAccount(accountType, null, null, requestBundle, null, null, ProcessUtil.getPreferredHandler()).getResult(2L, TimeUnit.SECONDS);
                    Intrinsics.checkNotNullExpressionValue(result, "accountManager.addAccoun…sult(2, TimeUnit.SECONDS)");
                    return result;
                }
            }, new Function0<AuthenticatorDescription[]>() { // from class: com.microsoft.identity.common.internal.broker.ipc.AccountManagerBackupIpcStrategyTargetingSpecificBrokerApp$Companion$tryCreateInstance$2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(0);
                }

                @Override // kotlin.jvm.functions.Function0
                public final AuthenticatorDescription[] invoke() {
                    AuthenticatorDescription[] authenticatorTypes = accountManager.getAuthenticatorTypes();
                    Intrinsics.checkNotNullExpressionValue(authenticatorTypes, "accountManager.authenticatorTypes");
                    return authenticatorTypes;
                }
            }, new BrokerValidator(context));
        }
    }

    @Override // com.microsoft.identity.common.internal.broker.ipc.IIpcStrategy
    public Bundle communicateToBroker(BrokerOperationBundle bundle) throws BrokerCommunicationException {
        String message;
        Intrinsics.checkNotNullParameter(bundle, "bundle");
        String str = TAG + ":communicateToBroker";
        String str2 = bundle.targetBrokerAppPackageName;
        Intrinsics.checkNotNullExpressionValue(str2, "bundle.targetBrokerAppPackageName");
        Logger.info(str, "Operation " + bundle.operation.name() + " is requested to " + str2);
        String str3 = this.accountTypeForEachPackage.get(str2);
        if (str3 == null) {
            throw new BrokerCommunicationException(BrokerCommunicationException.Category.OPERATION_NOT_SUPPORTED_ON_CLIENT_SIDE, getType(), "AccountManagerBackupIpcStrategy doesn't recognize " + str2 + " as a broker", null);
        }
        String str4 = str3;
        validateTargetApp(str2, str4);
        Bundle bundle2 = new Bundle();
        bundle2.putParcelable(REQUEST_BUNDLE_KEY, bundle.bundle);
        bundle2.putString(CONTENT_PROVIDER_PATH_KEY, bundle.operation.getContentApi().getPath());
        try {
            return this.sendRequestViaAccountManager.invoke(str4, bundle2);
        } catch (Throwable th) {
            String message2 = th.getMessage();
            if (message2 == null || message2.length() == 0) {
                message = th.getClass().getSimpleName() + " is thrown";
            } else {
                message = th.getMessage();
            }
            Logger.error(str, message, th);
            throw new BrokerCommunicationException(BrokerCommunicationException.Category.CONNECTION_ERROR, getType(), "AccountManager failed to respond - " + message, th);
        }
    }

    @Override // com.microsoft.identity.common.internal.broker.ipc.IIpcStrategy
    public boolean isSupportedByTargetedBroker(String targetedBrokerPackageName) {
        Intrinsics.checkNotNullParameter(targetedBrokerPackageName, "targetedBrokerPackageName");
        String str = TAG + ":isSupportedByTargetedBroker";
        try {
            String str2 = this.accountTypeForEachPackage.get(targetedBrokerPackageName);
            if (str2 == null) {
                Logger.info(str, "AccountManagerBackupIpcStrategy doesn't recognize " + targetedBrokerPackageName + " as a broker");
                return false;
            }
            validateTargetApp(targetedBrokerPackageName, str2);
            return true;
        } catch (Throwable th) {
            Logger.error(str, th.getMessage(), th);
            return false;
        }
    }

    private final void validateTargetApp(String targetPackageName, String accountType) throws BrokerCommunicationException {
        try {
            for (AuthenticatorDescription authenticatorDescription : this.getAccountManagerApps.invoke()) {
                AuthenticatorDescription authenticatorDescription2 = authenticatorDescription;
                if (Intrinsics.areEqual(authenticatorDescription2.packageName, targetPackageName) && Intrinsics.areEqual(authenticatorDescription2.type, accountType)) {
                    AuthenticatorDescription authenticatorDescription3 = authenticatorDescription;
                    IBrokerValidator iBrokerValidator = this.brokerValidator;
                    String str = authenticatorDescription3.packageName;
                    Intrinsics.checkNotNullExpressionValue(str, "targetAppInfo.packageName");
                    if (!iBrokerValidator.isValidBrokerPackage(str)) {
                        throw new BrokerCommunicationException(BrokerCommunicationException.Category.VALIDATION_ERROR, getType(), authenticatorDescription3.packageName + " is not a valid broker app.", null);
                    }
                    return;
                }
            }
            throw new NoSuchElementException("Array contains no element matching the predicate.");
        } catch (Throwable unused) {
            throw new BrokerCommunicationException(BrokerCommunicationException.Category.VALIDATION_ERROR, getType(), targetPackageName + " doesn't support account manager backup ipc.", null);
        }
    }

    @Override // com.microsoft.identity.common.internal.broker.ipc.IIpcStrategy
    public IIpcStrategy.Type getType() {
        return IIpcStrategy.Type.ACCOUNT_MANAGER_ADD_ACCOUNT;
    }
}

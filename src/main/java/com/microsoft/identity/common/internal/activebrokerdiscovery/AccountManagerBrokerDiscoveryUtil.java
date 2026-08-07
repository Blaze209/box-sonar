package com.microsoft.identity.common.internal.activebrokerdiscovery;

import android.accounts.AccountManager;
import android.accounts.AuthenticatorDescription;
import android.content.Context;
import com.microsoft.identity.common.internal.broker.BrokerData;
import com.microsoft.identity.common.internal.broker.BrokerValidator;
import com.microsoft.identity.common.java.AuthenticationConstants;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.logging.Logger;
import java.util.ArrayList;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: AccountManagerBrokerDiscoveryUtil.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B;\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\t\u0012\u0012\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\f¢\u0006\u0002\u0010\u000fJ\b\u0010\u0010\u001a\u0004\u0018\u00010\u0007R\u001a\u0010\u000b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\n0\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/microsoft/identity/common/internal/activebrokerdiscovery/AccountManagerBrokerDiscoveryUtil;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "knownBrokerApps", "", "Lcom/microsoft/identity/common/internal/broker/BrokerData;", "isSignedByKnownKeys", "Lkotlin/Function1;", "", "getAccountManagerApps", "Lkotlin/Function0;", "", "Landroid/accounts/AuthenticatorDescription;", "(Ljava/util/Set;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;)V", "getActiveBrokerFromAccountManager", "Companion", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AccountManagerBrokerDiscoveryUtil {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = Reflection.getOrCreateKotlinClass(AccountManagerBrokerDiscoveryUtil.class).getSimpleName();
    private final Function0<AuthenticatorDescription[]> getAccountManagerApps;
    private final Function1<BrokerData, Boolean> isSignedByKnownKeys;
    private final Set<BrokerData> knownBrokerApps;

    /* JADX WARN: Multi-variable type inference failed */
    public AccountManagerBrokerDiscoveryUtil(Set<BrokerData> knownBrokerApps, Function1<? super BrokerData, Boolean> isSignedByKnownKeys, Function0<AuthenticatorDescription[]> getAccountManagerApps) {
        Intrinsics.checkNotNullParameter(knownBrokerApps, "knownBrokerApps");
        Intrinsics.checkNotNullParameter(isSignedByKnownKeys, "isSignedByKnownKeys");
        Intrinsics.checkNotNullParameter(getAccountManagerApps, "getAccountManagerApps");
        this.knownBrokerApps = knownBrokerApps;
        this.isSignedByKnownKeys = isSignedByKnownKeys;
        this.getAccountManagerApps = getAccountManagerApps;
    }

    /* JADX INFO: compiled from: AccountManagerBrokerDiscoveryUtil.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0013\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, d2 = {"Lcom/microsoft/identity/common/internal/activebrokerdiscovery/AccountManagerBrokerDiscoveryUtil$Companion;", "", "()V", "TAG", "", "getTAG", "()Ljava/lang/String;", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getTAG() {
            return AccountManagerBrokerDiscoveryUtil.TAG;
        }
    }

    public AccountManagerBrokerDiscoveryUtil(final Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        Set<BrokerData> knownBrokerApps = BrokerData.INSTANCE.getKnownBrokerApps();
        ArrayList arrayList = new ArrayList();
        for (Object obj : knownBrokerApps) {
            if (BrokerData.INSTANCE.isAccountManagerSupported(((BrokerData) obj).getPackageName())) {
                arrayList.add(obj);
            }
        }
        this(CollectionsKt.toSet(arrayList), new Function1<BrokerData, Boolean>() { // from class: com.microsoft.identity.common.internal.activebrokerdiscovery.AccountManagerBrokerDiscoveryUtil.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(BrokerData brokerData) {
                Intrinsics.checkNotNullParameter(brokerData, "brokerData");
                return Boolean.valueOf(new BrokerValidator(context).isSignedByKnownKeys(brokerData));
            }
        }, new Function0<AuthenticatorDescription[]>() { // from class: com.microsoft.identity.common.internal.activebrokerdiscovery.AccountManagerBrokerDiscoveryUtil.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            @Override // kotlin.jvm.functions.Function0
            public final AuthenticatorDescription[] invoke() {
                AuthenticatorDescription[] authenticatorTypes = AccountManager.get(context).getAuthenticatorTypes();
                Intrinsics.checkNotNullExpressionValue(authenticatorTypes, "get(context).authenticatorTypes");
                return authenticatorTypes;
            }
        });
    }

    public final BrokerData getActiveBrokerFromAccountManager() throws ClientException {
        String str = TAG + ":getActiveBrokerFromAccountManager";
        try {
            AuthenticatorDescription[] authenticatorDescriptionArrInvoke = this.getAccountManagerApps.invoke();
            int length = authenticatorDescriptionArrInvoke.length;
            int i = 0;
            while (true) {
                Object obj = null;
                if (i < length) {
                    AuthenticatorDescription authenticatorDescription = authenticatorDescriptionArrInvoke[i];
                    if (authenticatorDescription.packageName != null && authenticatorDescription.type != null) {
                        String str2 = authenticatorDescription.packageName;
                        Intrinsics.checkNotNullExpressionValue(str2, "authenticator.packageName");
                        String string = StringsKt.trim((CharSequence) str2).toString();
                        String str3 = authenticatorDescription.type;
                        Intrinsics.checkNotNullExpressionValue(str3, "authenticator.type");
                        if (StringsKt.equals(AuthenticationConstants.Broker.BROKER_ACCOUNT_TYPE, StringsKt.trim((CharSequence) str3).toString(), true)) {
                            Set<BrokerData> set = this.knownBrokerApps;
                            ArrayList arrayList = new ArrayList();
                            for (Object obj2 : set) {
                                if (StringsKt.equals(((BrokerData) obj2).getPackageName(), string, true)) {
                                    arrayList.add(obj2);
                                }
                            }
                            Function1<BrokerData, Boolean> function1 = this.isSignedByKnownKeys;
                            for (Object obj3 : arrayList) {
                                if (function1.invoke((BrokerData) obj3).booleanValue()) {
                                    obj = obj3;
                                    break;
                                }
                            }
                            BrokerData brokerData = (BrokerData) obj;
                            if (brokerData != null) {
                                Logger.info(str, brokerData + " is the active AccountManager broker.");
                                return brokerData;
                            }
                        } else {
                            continue;
                        }
                    }
                    i++;
                } else {
                    Logger.info(str, "No valid AccountManager broker is found");
                    return null;
                }
            }
        } catch (Throwable th) {
            throw new ClientException(ClientException.ACCOUNT_MANAGER_FAILED, th.getMessage());
        }
    }
}

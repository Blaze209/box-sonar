package com.microsoft.identity.common.internal.cache;

import android.content.Context;
import android.os.Bundle;
import com.microsoft.identity.common.internal.broker.BrokerData;
import com.microsoft.identity.common.internal.broker.BrokerValidator;
import com.microsoft.identity.common.logging.Logger;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: ActiveBrokerCacheUpdater.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00102\u00020\u0001:\u0001\u0010B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006B!\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\b\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u000bJ\u0010\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/microsoft/identity/common/internal/cache/ActiveBrokerCacheUpdater;", "", "context", "Landroid/content/Context;", SemanticAttributes.DbSystemValues.CACHE, "Lcom/microsoft/identity/common/internal/cache/IClientActiveBrokerCache;", "(Landroid/content/Context;Lcom/microsoft/identity/common/internal/cache/IClientActiveBrokerCache;)V", "isValidBroker", "Lkotlin/Function1;", "Lcom/microsoft/identity/common/internal/broker/BrokerData;", "", "(Lkotlin/jvm/functions/Function1;Lcom/microsoft/identity/common/internal/cache/IClientActiveBrokerCache;)V", "updateCachedActiveBrokerFromResultBundle", "", "bundle", "Landroid/os/Bundle;", "Companion", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ActiveBrokerCacheUpdater {
    public static final String ACTIVE_BROKER_PACKAGE_NAME_KEY = "active.broker.package.name";
    public static final String ACTIVE_BROKER_SIGNING_CERTIFICATE_THUMBPRINT_KEY = "active.broker.signing.certificate.thumbprint";
    public static final String BROKER_DISCOVERY_DISABLED_KEY = "broker.discovery.disabled";
    public static final String KEY_REQUEST_ACTIVE_BROKER_DATA = "com.microsoft.identity.request.broker.data";
    private final IClientActiveBrokerCache cache;
    private final Function1<BrokerData, Boolean> isValidBroker;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = Reflection.getOrCreateKotlinClass(ActiveBrokerCacheUpdater.class).getSimpleName();

    @JvmStatic
    public static final void appendActiveBrokerToResultBundle(Bundle bundle, BrokerData brokerData) {
        INSTANCE.appendActiveBrokerToResultBundle(bundle, brokerData);
    }

    @JvmStatic
    public static final void appendBrokerDiscoveryDisabledToResultBundle(Bundle bundle) {
        INSTANCE.appendBrokerDiscoveryDisabledToResultBundle(bundle);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ActiveBrokerCacheUpdater(Function1<? super BrokerData, Boolean> isValidBroker, IClientActiveBrokerCache cache) {
        Intrinsics.checkNotNullParameter(isValidBroker, "isValidBroker");
        Intrinsics.checkNotNullParameter(cache, "cache");
        this.isValidBroker = isValidBroker;
        this.cache = cache;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ActiveBrokerCacheUpdater(final Context context, IClientActiveBrokerCache cache) {
        this(new Function1<BrokerData, Boolean>() { // from class: com.microsoft.identity.common.internal.cache.ActiveBrokerCacheUpdater.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(BrokerData brokerData) {
                Intrinsics.checkNotNullParameter(brokerData, "brokerData");
                return Boolean.valueOf(new BrokerValidator(context).isSignedByKnownKeys(brokerData));
            }
        }, cache);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(cache, "cache");
    }

    /* JADX INFO: compiled from: ActiveBrokerCacheUpdater.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0007J\u0010\u0010\u000f\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, d2 = {"Lcom/microsoft/identity/common/internal/cache/ActiveBrokerCacheUpdater$Companion;", "", "()V", "ACTIVE_BROKER_PACKAGE_NAME_KEY", "", "ACTIVE_BROKER_SIGNING_CERTIFICATE_THUMBPRINT_KEY", "BROKER_DISCOVERY_DISABLED_KEY", "KEY_REQUEST_ACTIVE_BROKER_DATA", "TAG", "appendActiveBrokerToResultBundle", "", "bundle", "Landroid/os/Bundle;", "activeBroker", "Lcom/microsoft/identity/common/internal/broker/BrokerData;", "appendBrokerDiscoveryDisabledToResultBundle", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final void appendActiveBrokerToResultBundle(Bundle bundle, BrokerData activeBroker) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            Intrinsics.checkNotNullParameter(activeBroker, "activeBroker");
            bundle.putString(ActiveBrokerCacheUpdater.ACTIVE_BROKER_PACKAGE_NAME_KEY, activeBroker.getPackageName());
            bundle.putString(ActiveBrokerCacheUpdater.ACTIVE_BROKER_SIGNING_CERTIFICATE_THUMBPRINT_KEY, activeBroker.getSigningCertificateThumbprint());
        }

        @JvmStatic
        public final void appendBrokerDiscoveryDisabledToResultBundle(Bundle bundle) {
            Intrinsics.checkNotNullParameter(bundle, "bundle");
            bundle.putBoolean(ActiveBrokerCacheUpdater.BROKER_DISCOVERY_DISABLED_KEY, true);
        }
    }

    public final void updateCachedActiveBrokerFromResultBundle(Bundle bundle) {
        String str;
        String str2 = TAG + ":updateCachedActiveBrokerFromResultBundle";
        if (bundle == null) {
            return;
        }
        if (bundle.getBoolean(BROKER_DISCOVERY_DISABLED_KEY, false)) {
            Logger.info(str2, "Got a response indicating that the broker discovery is disabled.Will also wipe the local active broker cache,and skip broker discovery via IPC (only fall back to AccountManager) for the next 60 minutes.");
            this.cache.clearCachedActiveBroker();
            this.cache.setShouldUseAccountManagerForTheNextMilliseconds(TimeUnit.MINUTES.toMillis(60L));
            return;
        }
        String string = bundle.getString(ACTIVE_BROKER_PACKAGE_NAME_KEY);
        String string2 = bundle.getString(ACTIVE_BROKER_SIGNING_CERTIFICATE_THUMBPRINT_KEY);
        String str3 = string;
        if (str3 == null || str3.length() == 0 || (str = string2) == null || str.length() == 0) {
            Logger.info(str2, "A response was received without active broker information.");
            return;
        }
        BrokerData brokerData = new BrokerData(string, string2);
        if (!this.isValidBroker.invoke(brokerData).booleanValue()) {
            Logger.warn(str2, "Cannot find an installed " + string + " with a matching signing certificate thumbprint.");
        } else {
            this.cache.setCachedActiveBroker(brokerData);
        }
    }
}

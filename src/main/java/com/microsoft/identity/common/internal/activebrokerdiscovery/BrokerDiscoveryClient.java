package com.microsoft.identity.common.internal.activebrokerdiscovery;

import android.content.Context;
import android.os.Bundle;
import com.microsoft.identity.common.exception.BrokerCommunicationException;
import com.microsoft.identity.common.internal.broker.BrokerData;
import com.microsoft.identity.common.internal.broker.BrokerValidator;
import com.microsoft.identity.common.internal.broker.PackageHelper;
import com.microsoft.identity.common.internal.broker.ipc.BrokerOperationBundle;
import com.microsoft.identity.common.internal.broker.ipc.ContentProviderStrategy;
import com.microsoft.identity.common.internal.broker.ipc.IIpcStrategy;
import com.microsoft.identity.common.internal.cache.IClientActiveBrokerCache;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.interfaces.IPlatformComponents;
import com.microsoft.identity.common.java.logging.Logger;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import java.io.Serializable;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: compiled from: BrokerDiscoveryClient.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bB[\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n\u0012\u000e\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\r\u0012\u0006\u0010\u000e\u001a\u00020\u000f\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0012\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00120\u0011¢\u0006\u0002\u0010\u0014J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u000bH\u0016J\u0012\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0018\u001a\u00020\u0012H\u0016J\u001a\u0010\u0017\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0018\u001a\u00020\u00122\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J%\u0010\u001b\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0018\u001a\u00020\u00122\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0082@ø\u0001\u0000¢\u0006\u0002\u0010\u001cR\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\f\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000b0\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0013\u001a\u000e\u0012\u0004\u0012\u00020\u000b\u0012\u0004\u0012\u00020\u00120\u0011X\u0082\u0004¢\u0006\u0002\n\u0000\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006\u001e"}, d2 = {"Lcom/microsoft/identity/common/internal/activebrokerdiscovery/BrokerDiscoveryClient;", "Lcom/microsoft/identity/common/internal/activebrokerdiscovery/IBrokerDiscoveryClient;", "context", "Landroid/content/Context;", "components", "Lcom/microsoft/identity/common/java/interfaces/IPlatformComponents;", SemanticAttributes.DbSystemValues.CACHE, "Lcom/microsoft/identity/common/internal/cache/IClientActiveBrokerCache;", "(Landroid/content/Context;Lcom/microsoft/identity/common/java/interfaces/IPlatformComponents;Lcom/microsoft/identity/common/internal/cache/IClientActiveBrokerCache;)V", "brokerCandidates", "", "Lcom/microsoft/identity/common/internal/broker/BrokerData;", "getActiveBrokerFromAccountManager", "Lkotlin/Function0;", "ipcStrategy", "Lcom/microsoft/identity/common/internal/broker/ipc/IIpcStrategy;", "isPackageInstalled", "Lkotlin/Function1;", "", "isValidBroker", "(Ljava/util/Set;Lkotlin/jvm/functions/Function0;Lcom/microsoft/identity/common/internal/broker/ipc/IIpcStrategy;Lcom/microsoft/identity/common/internal/cache/IClientActiveBrokerCache;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;)V", "forceBrokerRediscovery", "brokerCandidate", "getActiveBroker", "shouldSkipCache", "telemetryCallback", "Lcom/microsoft/identity/common/internal/activebrokerdiscovery/IBrokerDiscoveryClientTelemetryCallback;", "getActiveBrokerAsync", "(ZLcom/microsoft/identity/common/internal/activebrokerdiscovery/IBrokerDiscoveryClientTelemetryCallback;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class BrokerDiscoveryClient implements IBrokerDiscoveryClient {
    public static final String ACTIVE_BROKER_PACKAGE_NAME_BUNDLE_KEY = "ACTIVE_BROKER_PACKAGE_NAME_BUNDLE_KEY";
    public static final String ACTIVE_BROKER_SIGNING_CERTIFICATE_THUMBPRINT_BUNDLE_KEY = "ACTIVE_BROKER_SIGNING_CERTIFICATE_THUMBPRINT_BUNDLE_KEY";
    public static final String ERROR_BUNDLE_KEY = "ERROR_BUNDLE_KEY";
    public static final String FORCE_TRIGGER_BROKER_DISCOVERY_BUNDLE_KEY = "FORCE_TRIGGER_BROKER_DISCOVERY_BUNDLE_KEY";
    public static final String FORCE_TRIGGER_BROKER_DISCOVERY_NOT_VALID_BROKER = "NOT_VALID_BROKER";
    public static final String FORCE_TRIGGER_BROKER_DISCOVERY_PACKAGE_NOT_INSTALLED = "PACKAGE_NOT_INSTALLED";
    public static final String FORCE_TRIGGER_BROKER_DISCOVERY_RESULT_EXECUTED_BUNDLE_KEY = "FORCE_TRIGGER_BROKER_DISCOVERY_RESULT_EXECUTED_BUNDLE_KEY";
    public static final String FORCE_TRIGGER_BROKER_DISCOVERY_RESULT_OPERATION_DISABLED = "OPERATION_DISABLED";
    public static final String FORCE_TRIGGER_BROKER_DISCOVERY_RESULT_OPERATION_NOT_SUPPORTED = "OPERATION_NOT_SUPPORTED";
    public static final String FORCE_TRIGGER_BROKER_DISCOVERY_RESULT_UNEXPECTED_ERROR = "UNEXPECTED_ERROR";
    private final Set<BrokerData> brokerCandidates;
    private final IClientActiveBrokerCache cache;
    private final Function0<BrokerData> getActiveBrokerFromAccountManager;
    private final IIpcStrategy ipcStrategy;
    private final Function1<BrokerData, Boolean> isPackageInstalled;
    private final Function1<BrokerData, Boolean> isValidBroker;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = Reflection.getOrCreateKotlinClass(BrokerDiscoveryClient.class).getSimpleName();
    private static final CoroutineDispatcher dispatcher = Dispatchers.getIO().limitedParallelism(10);
    private static final Mutex classLevelLock = MutexKt.Mutex$default(false, 1, null);

    /* JADX INFO: renamed from: com.microsoft.identity.common.internal.activebrokerdiscovery.BrokerDiscoveryClient$getActiveBrokerAsync$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrokerDiscoveryClient.kt */
    @Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.microsoft.identity.common.internal.activebrokerdiscovery.BrokerDiscoveryClient", f = "BrokerDiscoveryClient.kt", i = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {391, 350}, m = "getActiveBrokerAsync", n = {"this", "telemetryCallback", "methodTag", "$this$withLock_u24default$iv", "shouldSkipCache", "timeStartAcquiringLock", "this", "telemetryCallback", "methodTag", "$this$withLock_u24default$iv", "timeStartQueryFromBroker"}, s = {"L$0", "L$1", "L$2", "L$3", "Z$0", "J$0", "L$0", "L$1", "L$2", "L$3", "J$0"})
    static final class C18091 extends ContinuationImpl {
        long J$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;

        C18091(Continuation<? super C18091> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return BrokerDiscoveryClient.this.getActiveBrokerAsync(false, null, this);
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public BrokerDiscoveryClient(Set<BrokerData> brokerCandidates, Function0<BrokerData> getActiveBrokerFromAccountManager, IIpcStrategy ipcStrategy, IClientActiveBrokerCache cache, Function1<? super BrokerData, Boolean> isPackageInstalled, Function1<? super BrokerData, Boolean> isValidBroker) {
        Intrinsics.checkNotNullParameter(brokerCandidates, "brokerCandidates");
        Intrinsics.checkNotNullParameter(getActiveBrokerFromAccountManager, "getActiveBrokerFromAccountManager");
        Intrinsics.checkNotNullParameter(ipcStrategy, "ipcStrategy");
        Intrinsics.checkNotNullParameter(cache, "cache");
        Intrinsics.checkNotNullParameter(isPackageInstalled, "isPackageInstalled");
        Intrinsics.checkNotNullParameter(isValidBroker, "isValidBroker");
        this.brokerCandidates = brokerCandidates;
        this.getActiveBrokerFromAccountManager = getActiveBrokerFromAccountManager;
        this.ipcStrategy = ipcStrategy;
        this.cache = cache;
        this.isPackageInstalled = isPackageInstalled;
        this.isValidBroker = isValidBroker;
    }

    /* JADX INFO: compiled from: BrokerDiscoveryClient.kt */
    @Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001c\u0010\u0018\u001a\u0004\u0018\u00010\u00192\b\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u001a\u0010\u001e\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001f\u001a\u00020\u00192\u0006\u0010 \u001a\u00020!H\u0002JS\u0010\"\u001a\u0004\u0018\u00010\u00192\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00190$2\u0006\u0010 \u001a\u00020!2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001d0&2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001d0&H\u0080@ø\u0001\u0000¢\u0006\u0004\b(\u0010)R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0013\u001a\u00020\u0014¢\u0006\u000e\n\u0000\u0012\u0004\b\u0015\u0010\u0002\u001a\u0004\b\u0016\u0010\u0017\u0082\u0002\u0004\n\u0002\b\u0019¨\u0006*"}, d2 = {"Lcom/microsoft/identity/common/internal/activebrokerdiscovery/BrokerDiscoveryClient$Companion;", "", "()V", BrokerDiscoveryClient.ACTIVE_BROKER_PACKAGE_NAME_BUNDLE_KEY, "", BrokerDiscoveryClient.ACTIVE_BROKER_SIGNING_CERTIFICATE_THUMBPRINT_BUNDLE_KEY, BrokerDiscoveryClient.ERROR_BUNDLE_KEY, BrokerDiscoveryClient.FORCE_TRIGGER_BROKER_DISCOVERY_BUNDLE_KEY, "FORCE_TRIGGER_BROKER_DISCOVERY_NOT_VALID_BROKER", "FORCE_TRIGGER_BROKER_DISCOVERY_PACKAGE_NOT_INSTALLED", BrokerDiscoveryClient.FORCE_TRIGGER_BROKER_DISCOVERY_RESULT_EXECUTED_BUNDLE_KEY, "FORCE_TRIGGER_BROKER_DISCOVERY_RESULT_OPERATION_DISABLED", "FORCE_TRIGGER_BROKER_DISCOVERY_RESULT_OPERATION_NOT_SUPPORTED", "FORCE_TRIGGER_BROKER_DISCOVERY_RESULT_UNEXPECTED_ERROR", "TAG", "getTAG", "()Ljava/lang/String;", "classLevelLock", "Lkotlinx/coroutines/sync/Mutex;", "dispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "getDispatcher$annotations", "getDispatcher", "()Lkotlinx/coroutines/CoroutineDispatcher;", "extractResult", "Lcom/microsoft/identity/common/internal/broker/BrokerData;", "bundle", "Landroid/os/Bundle;", "forceTriggerDiscoveryFlow", "", "makeRequest", "candidate", "ipcStrategy", "Lcom/microsoft/identity/common/internal/broker/ipc/IIpcStrategy;", "queryFromBroker", "brokerCandidates", "", "isPackageInstalled", "Lkotlin/Function1;", "isValidBroker", "queryFromBroker$common_distRelease", "(Ljava/util/Set;Lcom/microsoft/identity/common/internal/broker/ipc/IIpcStrategy;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public static /* synthetic */ void getDispatcher$annotations() {
        }

        private Companion() {
        }

        public final String getTAG() {
            return BrokerDiscoveryClient.TAG;
        }

        public final CoroutineDispatcher getDispatcher() {
            return BrokerDiscoveryClient.dispatcher;
        }

        public final Object queryFromBroker$common_distRelease(Set<BrokerData> set, IIpcStrategy iIpcStrategy, Function1<? super BrokerData, Boolean> function1, Function1<? super BrokerData, Boolean> function2, Continuation<? super BrokerData> continuation) {
            return CoroutineScopeKt.coroutineScope(new BrokerDiscoveryClient$Companion$queryFromBroker$2(set, function1, function2, iIpcStrategy, null), continuation);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final BrokerData makeRequest(BrokerData candidate, IIpcStrategy ipcStrategy) {
            String str = getTAG() + ":makeRequest";
            try {
                return extractResult(ipcStrategy.communicateToBroker(new BrokerOperationBundle(BrokerOperationBundle.Operation.BROKER_DISCOVERY_FROM_SDK, candidate.getPackageName(), new Bundle())), false);
            } catch (Throwable th) {
                if ((th instanceof BrokerCommunicationException) && BrokerCommunicationException.Category.OPERATION_NOT_SUPPORTED_ON_SERVER_SIDE == ((BrokerCommunicationException) th).getCategory()) {
                    Logger.info(str, "Tried broker discovery on " + candidate + ". It doesn't support the IPC mechanism.");
                    return null;
                }
                if ((th instanceof ClientException) && Intrinsics.areEqual(ClientException.ONLY_SUPPORTS_ACCOUNT_MANAGER_ERROR_CODE, ((ClientException) th).getErrorCode())) {
                    Logger.info(str, "Tried broker discovery on " + candidate + ". The Broker side indicates that only AccountManager is supported.");
                    return null;
                }
                Logger.error(str, "Tried broker discovery on " + candidate + ", get an error", th);
                return null;
            }
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final BrokerData extractResult(Bundle bundle, boolean forceTriggerDiscoveryFlow) throws Throwable {
            if (bundle == null) {
                return null;
            }
            Serializable serializable = bundle.getSerializable(BrokerDiscoveryClient.ERROR_BUNDLE_KEY);
            if (serializable != null) {
                throw ((Throwable) serializable);
            }
            if (forceTriggerDiscoveryFlow && !bundle.containsKey(BrokerDiscoveryClient.FORCE_TRIGGER_BROKER_DISCOVERY_RESULT_EXECUTED_BUNDLE_KEY)) {
                throw new ClientException(BrokerDiscoveryClient.FORCE_TRIGGER_BROKER_DISCOVERY_RESULT_OPERATION_NOT_SUPPORTED, "Force Broker Discovery is not supported by the broker side. Please update the app.");
            }
            String string = bundle.getString(BrokerDiscoveryClient.ACTIVE_BROKER_PACKAGE_NAME_BUNDLE_KEY);
            if (string == null) {
                throw new NoSuchElementException("ACTIVE_BROKER_PACKAGE_NAME_BUNDLE_KEY must not be null");
            }
            String string2 = bundle.getString(BrokerDiscoveryClient.ACTIVE_BROKER_SIGNING_CERTIFICATE_THUMBPRINT_BUNDLE_KEY);
            if (string2 == null) {
                throw new NoSuchElementException("ACTIVE_BROKER_SIGNING_CERTIFICATE_THUMBPRINT_BUNDLE_KEY must not be null");
            }
            return new BrokerData(string, string2);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public BrokerDiscoveryClient(final Context context, IPlatformComponents components, IClientActiveBrokerCache cache) {
        this(BrokerData.INSTANCE.getKnownBrokerApps(), new Function0<BrokerData>() { // from class: com.microsoft.identity.common.internal.activebrokerdiscovery.BrokerDiscoveryClient.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final BrokerData invoke() {
                return new AccountManagerBrokerDiscoveryUtil(context).getActiveBrokerFromAccountManager();
            }
        }, new ContentProviderStrategy(context, components), cache, new Function1<BrokerData, Boolean>() { // from class: com.microsoft.identity.common.internal.activebrokerdiscovery.BrokerDiscoveryClient.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(BrokerData brokerData) {
                Intrinsics.checkNotNullParameter(brokerData, "brokerData");
                return Boolean.valueOf(new PackageHelper(context).isPackageInstalledAndEnabled(brokerData.getPackageName()));
            }
        }, new Function1<BrokerData, Boolean>() { // from class: com.microsoft.identity.common.internal.activebrokerdiscovery.BrokerDiscoveryClient.3
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(BrokerData brokerData) {
                Intrinsics.checkNotNullParameter(brokerData, "brokerData");
                return Boolean.valueOf(new BrokerValidator(context).isSignedByKnownKeys(brokerData));
            }
        });
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(components, "components");
        Intrinsics.checkNotNullParameter(cache, "cache");
    }

    /* JADX INFO: renamed from: com.microsoft.identity.common.internal.activebrokerdiscovery.BrokerDiscoveryClient$forceBrokerRediscovery$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrokerDiscoveryClient.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/microsoft/identity/common/internal/broker/BrokerData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.microsoft.identity.common.internal.activebrokerdiscovery.BrokerDiscoveryClient$forceBrokerRediscovery$1", f = "BrokerDiscoveryClient.kt", i = {0}, l = {391}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv"}, s = {"L$0"})
    static final class C18061 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BrokerData>, Object> {
        final /* synthetic */ BrokerData $brokerCandidate;
        final /* synthetic */ String $methodTag;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C18061(BrokerData brokerData, String str, Continuation<? super C18061> continuation) {
            super(2, continuation);
            this.$brokerCandidate = brokerData;
            this.$methodTag = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BrokerDiscoveryClient.this.new C18061(this.$brokerCandidate, this.$methodTag, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super BrokerData> continuation) {
            return ((C18061) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            BrokerDiscoveryClient brokerDiscoveryClient;
            BrokerData brokerData;
            Mutex mutex;
            String str;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                Mutex mutex2 = BrokerDiscoveryClient.classLevelLock;
                brokerDiscoveryClient = BrokerDiscoveryClient.this;
                brokerData = this.$brokerCandidate;
                String str2 = this.$methodTag;
                this.L$0 = mutex2;
                this.L$1 = brokerDiscoveryClient;
                this.L$2 = brokerData;
                this.L$3 = str2;
                this.label = 1;
                if (mutex2.lock(null, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
                mutex = mutex2;
                str = str2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                str = (String) this.L$3;
                brokerData = (BrokerData) this.L$2;
                brokerDiscoveryClient = (BrokerDiscoveryClient) this.L$1;
                mutex = (Mutex) this.L$0;
                ResultKt.throwOnFailure(obj);
            }
            try {
                try {
                    if (((Boolean) brokerDiscoveryClient.isPackageInstalled.invoke(brokerData)).booleanValue()) {
                        if (!((Boolean) brokerDiscoveryClient.isValidBroker.invoke(brokerData)).booleanValue()) {
                            throw new ClientException(BrokerDiscoveryClient.FORCE_TRIGGER_BROKER_DISCOVERY_NOT_VALID_BROKER, brokerData.getPackageName() + " is not signed with valid key.");
                        }
                        BrokerOperationBundle.Operation operation = BrokerOperationBundle.Operation.BROKER_DISCOVERY_FROM_SDK;
                        String packageName = brokerData.getPackageName();
                        Bundle bundle = new Bundle();
                        bundle.putBoolean(BrokerDiscoveryClient.FORCE_TRIGGER_BROKER_DISCOVERY_BUNDLE_KEY, true);
                        Unit unit = Unit.INSTANCE;
                        BrokerData brokerDataExtractResult = BrokerDiscoveryClient.INSTANCE.extractResult(brokerDiscoveryClient.ipcStrategy.communicateToBroker(new BrokerOperationBundle(operation, packageName, bundle)), true);
                        if (brokerDataExtractResult != null) {
                            brokerDiscoveryClient.cache.setCachedActiveBroker(brokerDataExtractResult);
                            mutex.unlock(null);
                            return brokerDataExtractResult;
                        }
                        throw new ClientException(BrokerDiscoveryClient.FORCE_TRIGGER_BROKER_DISCOVERY_RESULT_UNEXPECTED_ERROR, "Result bundle should not be null.");
                    }
                    throw new ClientException(BrokerDiscoveryClient.FORCE_TRIGGER_BROKER_DISCOVERY_PACKAGE_NOT_INSTALLED, brokerData.getPackageName() + " is not installed.");
                } catch (Throwable th) {
                    mutex.unlock(null);
                    throw th;
                }
            } catch (ClientException e) {
                Logger.error(str, "forceBrokerRediscovery Failed.", e);
                throw e;
            } catch (Throwable th2) {
                Logger.error(str, "forceBrokerRediscovery Failed with unknown error.", th2);
                throw new ClientException(BrokerDiscoveryClient.FORCE_TRIGGER_BROKER_DISCOVERY_RESULT_UNEXPECTED_ERROR, "Unexpected result: " + th2.getMessage(), th2);
            }
        }
    }

    @Override // com.microsoft.identity.common.internal.activebrokerdiscovery.IBrokerDiscoveryClient
    public BrokerData forceBrokerRediscovery(BrokerData brokerCandidate) throws ClientException {
        Intrinsics.checkNotNullParameter(brokerCandidate, "brokerCandidate");
        return (BrokerData) BuildersKt__BuildersKt.runBlocking$default(null, new C18061(brokerCandidate, TAG + ":forceBrokerRediscovery", null), 1, null);
    }

    /* JADX INFO: renamed from: com.microsoft.identity.common.internal.activebrokerdiscovery.BrokerDiscoveryClient$getActiveBroker$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrokerDiscoveryClient.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/microsoft/identity/common/internal/broker/BrokerData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.microsoft.identity.common.internal.activebrokerdiscovery.BrokerDiscoveryClient$getActiveBroker$1", f = "BrokerDiscoveryClient.kt", i = {}, l = {278}, m = "invokeSuspend", n = {}, s = {})
    static final class C18071 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BrokerData>, Object> {
        final /* synthetic */ boolean $shouldSkipCache;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C18071(boolean z, Continuation<? super C18071> continuation) {
            super(2, continuation);
            this.$shouldSkipCache = z;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BrokerDiscoveryClient.this.new C18071(this.$shouldSkipCache, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super BrokerData> continuation) {
            return ((C18071) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object activeBrokerAsync = BrokerDiscoveryClient.this.getActiveBrokerAsync(this.$shouldSkipCache, null, this);
            return activeBrokerAsync == coroutine_suspended ? coroutine_suspended : activeBrokerAsync;
        }
    }

    @Override // com.microsoft.identity.common.internal.activebrokerdiscovery.IBrokerDiscoveryClient
    public BrokerData getActiveBroker(boolean shouldSkipCache) {
        return (BrokerData) BuildersKt__BuildersKt.runBlocking$default(null, new C18071(shouldSkipCache, null), 1, null);
    }

    /* JADX INFO: renamed from: com.microsoft.identity.common.internal.activebrokerdiscovery.BrokerDiscoveryClient$getActiveBroker$2, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: BrokerDiscoveryClient.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0004\u0018\u00010\u0001*\u00020\u0002H\u008a@"}, d2 = {"<anonymous>", "Lcom/microsoft/identity/common/internal/broker/BrokerData;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {1, 8, 0}, xi = 48)
    @DebugMetadata(c = "com.microsoft.identity.common.internal.activebrokerdiscovery.BrokerDiscoveryClient$getActiveBroker$2", f = "BrokerDiscoveryClient.kt", i = {}, l = {287}, m = "invokeSuspend", n = {}, s = {})
    static final class C18082 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super BrokerData>, Object> {
        final /* synthetic */ boolean $shouldSkipCache;
        final /* synthetic */ IBrokerDiscoveryClientTelemetryCallback $telemetryCallback;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        C18082(boolean z, IBrokerDiscoveryClientTelemetryCallback iBrokerDiscoveryClientTelemetryCallback, Continuation<? super C18082> continuation) {
            super(2, continuation);
            this.$shouldSkipCache = z;
            this.$telemetryCallback = iBrokerDiscoveryClientTelemetryCallback;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return BrokerDiscoveryClient.this.new C18082(this.$shouldSkipCache, this.$telemetryCallback, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super BrokerData> continuation) {
            return ((C18082) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) throws Throwable {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i != 0) {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            Object activeBrokerAsync = BrokerDiscoveryClient.this.getActiveBrokerAsync(this.$shouldSkipCache, this.$telemetryCallback, this);
            return activeBrokerAsync == coroutine_suspended ? coroutine_suspended : activeBrokerAsync;
        }
    }

    @Override // com.microsoft.identity.common.internal.activebrokerdiscovery.IBrokerDiscoveryClient
    public BrokerData getActiveBroker(boolean shouldSkipCache, IBrokerDiscoveryClientTelemetryCallback telemetryCallback) {
        Intrinsics.checkNotNullParameter(telemetryCallback, "telemetryCallback");
        return (BrokerData) BuildersKt__BuildersKt.runBlocking$default(null, new C18082(shouldSkipCache, telemetryCallback, null), 1, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:65:0x01b5 A[Catch: all -> 0x004d, TryCatch #1 {all -> 0x004d, blocks: (B:13:0x0048, B:63:0x01b1, B:65:0x01b5, B:67:0x01bf, B:70:0x01c8, B:72:0x01e1, B:73:0x01e4, B:75:0x01f3, B:77:0x01f9), top: B:83:0x0048 }] */
    /* JADX WARN: Code duplicated, block: B:67:0x01bf A[Catch: all -> 0x004d, TRY_LEAVE, TryCatch #1 {all -> 0x004d, blocks: (B:13:0x0048, B:63:0x01b1, B:65:0x01b5, B:67:0x01bf, B:70:0x01c8, B:72:0x01e1, B:73:0x01e4, B:75:0x01f3, B:77:0x01f9), top: B:83:0x0048 }] */
    /* JADX WARN: Code duplicated, block: B:70:0x01c8 A[Catch: all -> 0x004d, TRY_ENTER, TryCatch #1 {all -> 0x004d, blocks: (B:13:0x0048, B:63:0x01b1, B:65:0x01b5, B:67:0x01bf, B:70:0x01c8, B:72:0x01e1, B:73:0x01e4, B:75:0x01f3, B:77:0x01f9), top: B:83:0x0048 }] */
    /* JADX WARN: Code duplicated, block: B:72:0x01e1 A[Catch: all -> 0x004d, TryCatch #1 {all -> 0x004d, blocks: (B:13:0x0048, B:63:0x01b1, B:65:0x01b5, B:67:0x01bf, B:70:0x01c8, B:72:0x01e1, B:73:0x01e4, B:75:0x01f3, B:77:0x01f9), top: B:83:0x0048 }] */
    /* JADX WARN: Code duplicated, block: B:75:0x01f3 A[Catch: all -> 0x004d, TryCatch #1 {all -> 0x004d, blocks: (B:13:0x0048, B:63:0x01b1, B:65:0x01b5, B:67:0x01bf, B:70:0x01c8, B:72:0x01e1, B:73:0x01e4, B:75:0x01f3, B:77:0x01f9), top: B:83:0x0048 }] */
    /* JADX WARN: Code duplicated, block: B:76:0x01f8  */
    /* JADX WARN: Code duplicated, block: B:7:0x001e  */
    public final Object getActiveBrokerAsync(boolean z, IBrokerDiscoveryClientTelemetryCallback iBrokerDiscoveryClientTelemetryCallback, Continuation<? super BrokerData> continuation) throws Throwable {
        C18091 c18091;
        String str;
        Mutex mutex;
        IBrokerDiscoveryClientTelemetryCallback iBrokerDiscoveryClientTelemetryCallback2;
        BrokerDiscoveryClient brokerDiscoveryClient;
        boolean z2;
        long j;
        Mutex mutex2;
        long jNanoTime;
        String str2;
        IBrokerDiscoveryClientTelemetryCallback iBrokerDiscoveryClientTelemetryCallback3;
        BrokerDiscoveryClient brokerDiscoveryClient2;
        BrokerData brokerData;
        BrokerData brokerDataInvoke;
        String packageName;
        if (continuation instanceof C18091) {
            c18091 = (C18091) continuation;
            if ((c18091.label & Integer.MIN_VALUE) != 0) {
                c18091.label -= Integer.MIN_VALUE;
            } else {
                c18091 = new C18091(continuation);
            }
        } else {
            c18091 = new C18091(continuation);
        }
        C18091 c18092 = c18091;
        Object obj = c18092.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c18092.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            str = TAG + ":getActiveBrokerAsync";
            long jNanoTime2 = System.nanoTime();
            mutex = classLevelLock;
            c18092.L$0 = this;
            iBrokerDiscoveryClientTelemetryCallback2 = iBrokerDiscoveryClientTelemetryCallback;
            c18092.L$1 = iBrokerDiscoveryClientTelemetryCallback2;
            c18092.L$2 = str;
            c18092.L$3 = mutex;
            c18092.Z$0 = z;
            c18092.J$0 = jNanoTime2;
            c18092.label = 1;
            if (mutex.lock(null, c18092) != coroutine_suspended) {
                brokerDiscoveryClient = this;
                z2 = z;
                j = jNanoTime2;
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            jNanoTime = c18092.J$0;
            mutex2 = (Mutex) c18092.L$3;
            str2 = (String) c18092.L$2;
            iBrokerDiscoveryClientTelemetryCallback3 = (IBrokerDiscoveryClientTelemetryCallback) c18092.L$1;
            brokerDiscoveryClient2 = (BrokerDiscoveryClient) c18092.L$0;
            try {
                ResultKt.throwOnFailure(obj);
                brokerData = (BrokerData) obj;
                if (iBrokerDiscoveryClientTelemetryCallback3 != null) {
                    iBrokerDiscoveryClientTelemetryCallback3.onFinishQueryingResultFromBroker(System.nanoTime() - jNanoTime);
                }
                if (brokerData != null) {
                    brokerDiscoveryClient2.cache.setCachedActiveBroker(brokerData);
                    mutex2.unlock(null);
                    return brokerData;
                }
                Logger.info(str2, "Will skip broker discovery via IPC and fall back to AccountManager for the next 60 minutes.");
                brokerDiscoveryClient2.cache.clearCachedActiveBroker();
                brokerDiscoveryClient2.cache.setShouldUseAccountManagerForTheNextMilliseconds(TimeUnit.MINUTES.toMillis(60L));
                if (iBrokerDiscoveryClientTelemetryCallback3 != null) {
                    iBrokerDiscoveryClientTelemetryCallback3.onUseAccountManager();
                }
                brokerDataInvoke = brokerDiscoveryClient2.getActiveBrokerFromAccountManager.invoke();
                StringBuilder sb = new StringBuilder("Tried getting active broker from account manager, get ");
                if (brokerDataInvoke != null) {
                    packageName = brokerDataInvoke.getPackageName();
                } else {
                    packageName = null;
                }
                Logger.info(str2, sb.append(packageName).append('.').toString());
                mutex2.unlock(null);
                return brokerDataInvoke;
            } catch (Throwable th) {
                th = th;
                mutex2.unlock(null);
                throw th;
            }
        }
        j = c18092.J$0;
        z2 = c18092.Z$0;
        mutex = (Mutex) c18092.L$3;
        String str3 = (String) c18092.L$2;
        iBrokerDiscoveryClientTelemetryCallback2 = (IBrokerDiscoveryClientTelemetryCallback) c18092.L$1;
        brokerDiscoveryClient = (BrokerDiscoveryClient) c18092.L$0;
        ResultKt.throwOnFailure(obj);
        str = str3;
        Mutex mutex3 = mutex;
        if (iBrokerDiscoveryClientTelemetryCallback2 != null) {
            try {
                iBrokerDiscoveryClientTelemetryCallback2.onLockAcquired(System.nanoTime() - j);
            } catch (Throwable th2) {
                th = th2;
                mutex2 = mutex3;
                mutex2.unlock(null);
                throw th;
            }
        }
        if (!z2) {
            if (brokerDiscoveryClient.cache.shouldUseAccountManager()) {
                if (iBrokerDiscoveryClientTelemetryCallback2 != null) {
                    iBrokerDiscoveryClientTelemetryCallback2.onUseAccountManager();
                }
                BrokerData brokerDataInvoke2 = brokerDiscoveryClient.getActiveBrokerFromAccountManager.invoke();
                mutex3.unlock(null);
                return brokerDataInvoke2;
            }
            long jNanoTime3 = System.nanoTime();
            BrokerData cachedActiveBroker = brokerDiscoveryClient.cache.getCachedActiveBroker();
            if (cachedActiveBroker != null) {
                if (iBrokerDiscoveryClientTelemetryCallback2 != null) {
                    iBrokerDiscoveryClientTelemetryCallback2.onReadFromCache(System.nanoTime() - jNanoTime3);
                }
                long jNanoTime4 = System.nanoTime();
                boolean zBooleanValue = brokerDiscoveryClient.isPackageInstalled.invoke(cachedActiveBroker).booleanValue();
                if (iBrokerDiscoveryClientTelemetryCallback2 != null) {
                    iBrokerDiscoveryClientTelemetryCallback2.onFinishCheckingIfPackageIsInstalled(System.nanoTime() - jNanoTime4);
                }
                if (zBooleanValue) {
                    long jNanoTime5 = System.nanoTime();
                    boolean zBooleanValue2 = brokerDiscoveryClient.isValidBroker.invoke(cachedActiveBroker).booleanValue();
                    if (iBrokerDiscoveryClientTelemetryCallback2 != null) {
                        iBrokerDiscoveryClientTelemetryCallback2.onFinishCheckingIfValidBroker(System.nanoTime() - jNanoTime5);
                    }
                    if (zBooleanValue2) {
                        long jNanoTime6 = System.nanoTime();
                        boolean zIsSupportedByTargetedBroker = brokerDiscoveryClient.ipcStrategy.isSupportedByTargetedBroker(cachedActiveBroker.getPackageName());
                        if (iBrokerDiscoveryClientTelemetryCallback2 != null) {
                            iBrokerDiscoveryClientTelemetryCallback2.onFinishCheckingIfSupportedByTargetedBroker(System.nanoTime() - jNanoTime6);
                        }
                        if (zIsSupportedByTargetedBroker) {
                            Logger.info(str, "Returning cached broker: " + cachedActiveBroker);
                            mutex3.unlock(null);
                            return cachedActiveBroker;
                        }
                        Logger.info(str, "Clearing cache as the installed app does not provide any IPC mechanism to communicate to. (e.g. the broker code isn't shipped with this apk)");
                        brokerDiscoveryClient.cache.clearCachedActiveBroker();
                    } else {
                        Logger.info(str, "Clearing cache as the installed app does not have a matching signature hash.");
                        brokerDiscoveryClient.cache.clearCachedActiveBroker();
                    }
                } else {
                    Logger.info(str, "There is a cached broker: " + cachedActiveBroker + ", but the app is no longer installed.");
                    brokerDiscoveryClient.cache.clearCachedActiveBroker();
                }
            }
        }
        jNanoTime = System.nanoTime();
        Companion companion = INSTANCE;
        Set<BrokerData> set = brokerDiscoveryClient.brokerCandidates;
        IIpcStrategy iIpcStrategy = brokerDiscoveryClient.ipcStrategy;
        Function1<BrokerData, Boolean> function1 = brokerDiscoveryClient.isPackageInstalled;
        Function1<BrokerData, Boolean> function2 = brokerDiscoveryClient.isValidBroker;
        c18092.L$0 = brokerDiscoveryClient;
        c18092.L$1 = iBrokerDiscoveryClientTelemetryCallback2;
        c18092.L$2 = str;
        c18092.L$3 = mutex3;
        c18092.J$0 = jNanoTime;
        c18092.label = 2;
        Object objQueryFromBroker$common_distRelease = companion.queryFromBroker$common_distRelease(set, iIpcStrategy, function1, function2, c18092);
        if (objQueryFromBroker$common_distRelease != coroutine_suspended) {
            String str4 = str;
            obj = objQueryFromBroker$common_distRelease;
            str2 = str4;
            iBrokerDiscoveryClientTelemetryCallback3 = iBrokerDiscoveryClientTelemetryCallback2;
            brokerDiscoveryClient2 = brokerDiscoveryClient;
            mutex2 = mutex3;
            brokerData = (BrokerData) obj;
            if (iBrokerDiscoveryClientTelemetryCallback3 != null) {
                iBrokerDiscoveryClientTelemetryCallback3.onFinishQueryingResultFromBroker(System.nanoTime() - jNanoTime);
            }
            if (brokerData != null) {
                brokerDiscoveryClient2.cache.setCachedActiveBroker(brokerData);
                mutex2.unlock(null);
                return brokerData;
            }
            Logger.info(str2, "Will skip broker discovery via IPC and fall back to AccountManager for the next 60 minutes.");
            brokerDiscoveryClient2.cache.clearCachedActiveBroker();
            brokerDiscoveryClient2.cache.setShouldUseAccountManagerForTheNextMilliseconds(TimeUnit.MINUTES.toMillis(60L));
            if (iBrokerDiscoveryClientTelemetryCallback3 != null) {
                iBrokerDiscoveryClientTelemetryCallback3.onUseAccountManager();
            }
            brokerDataInvoke = brokerDiscoveryClient2.getActiveBrokerFromAccountManager.invoke();
            StringBuilder sb2 = new StringBuilder("Tried getting active broker from account manager, get ");
            if (brokerDataInvoke != null) {
                packageName = brokerDataInvoke.getPackageName();
            } else {
                packageName = null;
            }
            Logger.info(str2, sb2.append(packageName).append('.').toString());
            mutex2.unlock(null);
            return brokerDataInvoke;
        }
        return coroutine_suspended;
    }
}

package com.box.android.domain.configuration;

import android.content.SharedPreferences;
import android.os.Build;
import com.box.android.common.BuildConfig;
import com.box.android.common.utilities.ApplicationProvider;
import com.box.android.common.utilities.BuildConfigProvider;
import com.box.android.domain.services.IBVEManager;
import com.box.androidsdk.content.models.BoxEnterprise;
import com.box.androidsdk.content.models.BoxUser;
import com.facebook.imageutils.TiffUtil;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthConstants;
import external.sdk.pendo.io.mozilla.javascript.Token;
import io.split.android.client.ServiceEndpoints;
import io.split.android.client.SplitClient;
import io.split.android.client.SplitClientConfig;
import io.split.android.client.SplitFactory;
import io.split.android.client.SplitFactoryBuilder;
import io.split.android.client.SplitManager;
import io.split.android.client.api.Key;
import io.split.android.client.events.SplitEvent;
import io.split.android.client.events.SplitEventTask;
import io.split.android.client.exceptions.SplitInstantiationException;
import java.util.Map;
import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CompletableDeferred;
import kotlinx.coroutines.CompletableDeferredKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.sync.Mutex;
import kotlinx.coroutines.sync.MutexKt;

/* JADX INFO: compiled from: SplitConfiguration.kt */
/* JADX INFO: loaded from: classes11.dex */
@Singleton
@Metadata(d1 = {"\u0000p\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u0000 >2\u00020\u0001:\u0001>B#\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0010\u0010\u001b\u001a\u00020\u001c2\u0006\u0010\u001d\u001a\u00020\u001eH\u0016J0\u0010\u001f\u001a\u00020\u001c2\b\u0010 \u001a\u0004\u0018\u00010\u000b2\b\u0010!\u001a\u0004\u0018\u00010\r2\b\u0010\"\u001a\u0004\u0018\u00010\u000b2\b\u0010#\u001a\u0004\u0018\u00010\rH\u0007J*\u0010$\u001a\u00020\u00172\u0006\u0010%\u001a\u00020&2\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011H\u0096@¢\u0006\u0002\u0010(J\u0014\u0010)\u001a\u00020\u0017*\u00020&2\u0006\u0010*\u001a\u00020\u0012H\u0002J*\u0010+\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\u00122\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u0011H\u0086@¢\u0006\u0002\u0010-J4\u0010.\u001a\u00020\u00122\u0006\u0010,\u001a\u00020\u00122\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00112\b\u0010/\u001a\u0004\u0018\u00010\u0012H\u0086@¢\u0006\u0002\u00100J\u0010\u00101\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\u0012H\u0002J\b\u00102\u001a\u00020\u0012H\u0002J\u0010\u00103\u001a\u00020\u00172\u0006\u0010,\u001a\u00020\u0012H\u0002J>\u00104\u001a\u00020\u0012*\u00020\u000b2\u0006\u0010,\u001a\u00020\u00122\u0012\u0010'\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00112\u000e\b\u0002\u00105\u001a\b\u0012\u0004\u0012\u00020\u001c06H\u0082@¢\u0006\u0002\u00107J\u0012\u00108\u001a\u00020\u0017*\u00020\u000bH\u0082@¢\u0006\u0002\u00109J\"\u0010:\u001a\u00020\u001c*\u00020\u000b2\u0006\u0010;\u001a\u00020<2\f\u0010=\u001a\b\u0012\u0004\u0012\u00020\u001c06H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000bX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00118F¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006?"}, d2 = {"Lcom/box/android/domain/configuration/SplitConfiguration;", "Lcom/box/android/domain/configuration/ISplitConfiguration;", "sharedPreferences", "Landroid/content/SharedPreferences;", "boxAccountSettings", "Lcom/box/android/domain/configuration/IBoxAccountSettings;", "bveManager", "Lcom/box/android/domain/services/IBVEManager;", "<init>", "(Landroid/content/SharedPreferences;Lcom/box/android/domain/configuration/IBoxAccountSettings;Lcom/box/android/domain/services/IBVEManager;)V", "enterpriseIdTrafficClient", "Lio/split/android/client/SplitClient;", "enterpriseIdManager", "Lio/split/android/client/SplitManager;", "userIdTrafficClient", "userIdManager", "mandatoryAttributes", "", "", "", "getMandatoryAttributes", "()Ljava/util/Map;", "enterpriseTimedOut", "", "userTimedOut", "splitMutex", "Lkotlinx/coroutines/sync/Mutex;", "init", "", "boxUser", "Lcom/box/androidsdk/content/models/BoxUser;", "initForTesting", "enterpriseClient", "enterpriseManager", "userClient", "userManager", "getTreatment", "split", "Lcom/box/android/domain/configuration/Split;", NativeAuthConstants.GrantType.ATTRIBUTES, "(Lcom/box/android/domain/configuration/Split;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isEnabled", "treatment", "getEnterpriseSplit", "featureName", "(Ljava/lang/String;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getUserSplit", "enterpriseSplit", "(Ljava/lang/String;Ljava/util/Map;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "enterpriseSplitExists", "getSplitApiKey", "userSplitExists", "getTreatmentSync", "onTimedOut", "Lkotlin/Function0;", "(Lio/split/android/client/SplitClient;Ljava/lang/String;Ljava/util/Map;Lkotlin/jvm/functions/Function0;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "awaitReady", "(Lio/split/android/client/SplitClient;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "on", "event", "Lio/split/android/client/events/SplitEvent;", ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, "Companion", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class SplitConfiguration implements ISplitConfiguration {
    public static final String SPLIT_ATTRIBUTE_APP_VERSION_KEY = "app_version";
    public static final String SPLIT_ATTRIBUTE_ENTERPRISE_TREATMENT = "enterprise_treatment";
    public static final String SPLIT_ATTRIBUTE_MANAGED_ACCOUNT_KEY = "managed_account";
    public static final String SPLIT_ATTRIBUTE_MANAGED_DEVICE_KEY = "managed_device";
    public static final String SPLIT_ATTRIBUTE_OS_KEY = "os";
    public static final String SPLIT_ATTRIBUTE_OS_VERSION_KEY = "os_version";
    public static final String SPLIT_CLIENT_NOT_READY = "client_not_ready";
    public static final String SPLIT_NOT_FOUND = "not_found";
    public static final String TREATMENT_OFF = "off";
    public static final String TREATMENT_ON = "on";
    private final IBoxAccountSettings boxAccountSettings;
    private final IBVEManager bveManager;
    private SplitManager enterpriseIdManager;
    private SplitClient enterpriseIdTrafficClient;
    private boolean enterpriseTimedOut;
    private SharedPreferences sharedPreferences;
    private final Mutex splitMutex;
    private SplitManager userIdManager;
    private SplitClient userIdTrafficClient;
    private boolean userTimedOut;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String SPLIT_ENV_OVERRIDE_KEY = "split_env_override_key";

    /* JADX INFO: renamed from: com.box.android.domain.configuration.SplitConfiguration$awaitReady$1, reason: invalid class name */
    /* JADX INFO: compiled from: SplitConfiguration.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.configuration.SplitConfiguration", f = "SplitConfiguration.kt", i = {0, 0, 0, 0, 1, 1}, l = {336, 303}, m = "awaitReady", n = {"$this$awaitReady", "deferred", "$this$withLock_u24default$iv", "$i$f$withLock", "$this$awaitReady", "deferred"}, s = {"L$0", "L$1", "L$2", "I$0", "L$0", "L$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SplitConfiguration.this.awaitReady(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.domain.configuration.SplitConfiguration$getEnterpriseSplit$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SplitConfiguration.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.configuration.SplitConfiguration", f = "SplitConfiguration.kt", i = {0, 0, 0, 0}, l = {218}, m = "getEnterpriseSplit", n = {"featureName", NativeAuthConstants.GrantType.ATTRIBUTES, "enterpriseClient", "$i$a$-let-SplitConfiguration$getEnterpriseSplit$2"}, s = {"L$0", "L$1", "L$2", "I$0"}, v = 1)
    static final class C15751 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        /* synthetic */ Object result;

        C15751(Continuation<? super C15751> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SplitConfiguration.this.getEnterpriseSplit(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.domain.configuration.SplitConfiguration$getTreatment$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SplitConfiguration.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.configuration.SplitConfiguration", f = "SplitConfiguration.kt", i = {0, 0, 0, 1, 1, 1, 1}, l = {195, 196}, m = "getTreatment", n = {"split", NativeAuthConstants.GrantType.ATTRIBUTES, "combinedAttributes", "split", NativeAuthConstants.GrantType.ATTRIBUTES, "combinedAttributes", "enterpriseTreatment"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3"}, v = 1)
    static final class C15761 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C15761(Continuation<? super C15761> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SplitConfiguration.this.getTreatment(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.domain.configuration.SplitConfiguration$getTreatmentSync$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SplitConfiguration.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.configuration.SplitConfiguration", f = "SplitConfiguration.kt", i = {0, 0, 0, 0}, l = {TiffUtil.TIFF_TAG_ORIENTATION}, m = "getTreatmentSync", n = {"$this$getTreatmentSync", "featureName", NativeAuthConstants.GrantType.ATTRIBUTES, "onTimedOut"}, s = {"L$0", "L$1", "L$2", "L$3"}, v = 1)
    static final class C15771 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        C15771(Continuation<? super C15771> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SplitConfiguration.this.getTreatmentSync(null, null, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.domain.configuration.SplitConfiguration$getUserSplit$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SplitConfiguration.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.configuration.SplitConfiguration", f = "SplitConfiguration.kt", i = {0, 0, 0, 0, 0, 0}, l = {239}, m = "getUserSplit", n = {"featureName", NativeAuthConstants.GrantType.ATTRIBUTES, "enterpriseSplit", "userClient", "newAttributes", "$i$a$-let-SplitConfiguration$getUserSplit$2"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "I$0"}, v = 1)
    static final class C15781 extends ContinuationImpl {
        int I$0;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        C15781(Continuation<? super C15781> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return SplitConfiguration.this.getUserSplit(null, null, null, this);
        }
    }

    public static final String getSPLIT_ENV_OVERRIDE_KEY() {
        return INSTANCE.getSPLIT_ENV_OVERRIDE_KEY();
    }

    @Inject
    public SplitConfiguration(@Named("global-shared-preference") SharedPreferences sharedPreferences, IBoxAccountSettings boxAccountSettings, IBVEManager bveManager) {
        Intrinsics.checkNotNullParameter(sharedPreferences, "sharedPreferences");
        Intrinsics.checkNotNullParameter(boxAccountSettings, "boxAccountSettings");
        Intrinsics.checkNotNullParameter(bveManager, "bveManager");
        this.sharedPreferences = sharedPreferences;
        this.boxAccountSettings = boxAccountSettings;
        this.bveManager = bveManager;
        this.splitMutex = MutexKt.Mutex$default(false, 1, null);
    }

    public final Map<String, Object> getMandatoryAttributes() {
        return MapsKt.mapOf(TuplesKt.to("os", "Android"), TuplesKt.to("os_version", Integer.valueOf(Build.VERSION.SDK_INT)), TuplesKt.to(SPLIT_ATTRIBUTE_APP_VERSION_KEY, 7020645), TuplesKt.to(SPLIT_ATTRIBUTE_MANAGED_ACCOUNT_KEY, Boolean.valueOf(this.boxAccountSettings.isIntuneManaged())), TuplesKt.to(SPLIT_ATTRIBUTE_MANAGED_DEVICE_KEY, Boolean.valueOf(this.boxAccountSettings.isEMMMode())));
    }

    @Override // com.box.android.domain.configuration.ISplitConfiguration
    public void init(BoxUser boxUser) throws SplitInstantiationException {
        String id;
        Intrinsics.checkNotNullParameter(boxUser, "boxUser");
        String str = this.bveManager.getBaseUri() + "app-api/split-proxy/api";
        SplitClientConfig splitClientConfigBuild = SplitClientConfig.builder().streamingEnabled(false).serviceEndpoints(ServiceEndpoints.builder().apiEndpoint(str).sseAuthServiceEndpoint(str).eventsEndpoint(str).build()).featuresRefreshRate(1800).segmentsRefreshRate(1800).logLevel(4).build();
        BoxEnterprise enterprise = boxUser.getEnterprise();
        if (enterprise == null || (id = enterprise.getUserId()) == null) {
            id = "-1";
        }
        SplitFactory splitFactoryBuild = SplitFactoryBuilder.build(getSplitApiKey(), new Key(id), splitClientConfigBuild, ApplicationProvider.getApplication());
        Intrinsics.checkNotNullExpressionValue(splitFactoryBuild, "build(...)");
        this.enterpriseIdTrafficClient = splitFactoryBuild.client();
        this.enterpriseIdManager = splitFactoryBuild.manager();
        SplitFactory splitFactoryBuild2 = SplitFactoryBuilder.build(getSplitApiKey(), new Key(boxUser.getUserId()), splitClientConfigBuild, ApplicationProvider.getApplication());
        Intrinsics.checkNotNullExpressionValue(splitFactoryBuild2, "build(...)");
        this.userIdTrafficClient = splitFactoryBuild2.client();
        this.userIdManager = splitFactoryBuild2.manager();
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C15791(null), 3, null);
    }

    /* JADX INFO: renamed from: com.box.android.domain.configuration.SplitConfiguration$init$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: SplitConfiguration.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.configuration.SplitConfiguration$init$1", f = "SplitConfiguration.kt", i = {0, 0, 1, 1}, l = {Token.SET, Token.SETCONSTVAR}, m = "invokeSuspend", n = {"it", "$i$a$-let-SplitConfiguration$init$1$1", "it", "$i$a$-let-SplitConfiguration$init$1$2"}, s = {"L$0", "I$0", "L$0", "I$0"}, v = 1)
    static final class C15791 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        Object L$0;
        int label;

        C15791(Continuation<? super C15791> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return SplitConfiguration.this.new C15791(continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((C15791) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:19:0x005f  */
        /* JADX WARN: Code restructure failed: missing block: B:13:0x0050, code lost:
        
            if (r12 == r0) goto L21;
         */
        /* JADX WARN: Code restructure failed: missing block: B:20:0x007a, code lost:
        
            if (r4.getTreatmentSync(r5, "init_feature", r7, r8, r9) == r0) goto L21;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r12) {
            /*
                r11 = this;
                java.lang.Object r0 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
                int r1 = r11.label
                r2 = 0
                r3 = 2
                r4 = 1
                if (r1 == 0) goto L28
                if (r1 == r4) goto L1f
                if (r1 != r3) goto L17
                java.lang.Object r11 = r11.L$0
                io.split.android.client.SplitClient r11 = (io.split.android.client.SplitClient) r11
                kotlin.ResultKt.throwOnFailure(r12)
                goto L7d
            L17:
                java.lang.IllegalStateException r11 = new java.lang.IllegalStateException
                java.lang.String r12 = "call to 'resume' before 'invoke' with coroutine"
                r11.<init>(r12)
                throw r11
            L1f:
                java.lang.Object r1 = r11.L$0
                io.split.android.client.SplitClient r1 = (io.split.android.client.SplitClient) r1
                kotlin.ResultKt.throwOnFailure(r12)
                r9 = r11
                goto L53
            L28:
                kotlin.ResultKt.throwOnFailure(r12)
                com.box.android.domain.configuration.SplitConfiguration r12 = com.box.android.domain.configuration.SplitConfiguration.this
                io.split.android.client.SplitClient r6 = com.box.android.domain.configuration.SplitConfiguration.access$getEnterpriseIdTrafficClient$p(r12)
                if (r6 == 0) goto L56
                com.box.android.domain.configuration.SplitConfiguration r5 = com.box.android.domain.configuration.SplitConfiguration.this
                java.util.Map r8 = kotlin.collections.MapsKt.emptyMap()
                com.box.android.domain.configuration.SplitConfiguration$init$1$$ExternalSyntheticLambda0 r9 = new com.box.android.domain.configuration.SplitConfiguration$init$1$$ExternalSyntheticLambda0
                r9.<init>()
                java.lang.Object r12 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r6)
                r11.L$0 = r12
                r11.I$0 = r2
                r11.label = r4
                java.lang.String r7 = "init_feature"
                r10 = r11
                java.lang.Object r12 = com.box.android.domain.configuration.SplitConfiguration.access$getTreatmentSync(r5, r6, r7, r8, r9, r10)
                r9 = r10
                if (r12 != r0) goto L53
                goto L7c
            L53:
                java.lang.String r12 = (java.lang.String) r12
                goto L57
            L56:
                r9 = r11
            L57:
                com.box.android.domain.configuration.SplitConfiguration r11 = com.box.android.domain.configuration.SplitConfiguration.this
                io.split.android.client.SplitClient r5 = com.box.android.domain.configuration.SplitConfiguration.access$getUserIdTrafficClient$p(r11)
                if (r5 == 0) goto L7d
                com.box.android.domain.configuration.SplitConfiguration r4 = com.box.android.domain.configuration.SplitConfiguration.this
                java.util.Map r7 = kotlin.collections.MapsKt.emptyMap()
                com.box.android.domain.configuration.SplitConfiguration$init$1$$ExternalSyntheticLambda1 r8 = new com.box.android.domain.configuration.SplitConfiguration$init$1$$ExternalSyntheticLambda1
                r8.<init>()
                java.lang.Object r11 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r5)
                r9.L$0 = r11
                r9.I$0 = r2
                r9.label = r3
                java.lang.String r6 = "init_feature"
                java.lang.Object r11 = com.box.android.domain.configuration.SplitConfiguration.access$getTreatmentSync(r4, r5, r6, r7, r8, r9)
                if (r11 != r0) goto L7d
            L7c:
                return r0
            L7d:
                kotlin.Unit r11 = kotlin.Unit.INSTANCE
                return r11
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.domain.configuration.SplitConfiguration.C15791.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$0$0(SplitConfiguration splitConfiguration) {
            splitConfiguration.enterpriseTimedOut = true;
            return Unit.INSTANCE;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit invokeSuspend$lambda$1$0(SplitConfiguration splitConfiguration) {
            splitConfiguration.userTimedOut = true;
            return Unit.INSTANCE;
        }
    }

    public final void initForTesting(SplitClient enterpriseClient, SplitManager enterpriseManager, SplitClient userClient, SplitManager userManager) {
        this.enterpriseIdTrafficClient = enterpriseClient;
        this.enterpriseIdManager = enterpriseManager;
        this.userIdTrafficClient = userClient;
        this.userIdManager = userManager;
    }

    /* JADX WARN: Code duplicated, block: B:28:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:30:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:34:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.domain.configuration.ISplitConfiguration
    public Object getTreatment(Split split, Map<String, ? extends Object> map, Continuation<? super Boolean> continuation) {
        C15761 c15761;
        Map<String, ? extends Object> mapPlus;
        Object enterpriseSplit;
        Split split2;
        String str;
        String str2;
        boolean zIsEnabled;
        if (continuation instanceof C15761) {
            c15761 = (C15761) continuation;
            if ((c15761.label & Integer.MIN_VALUE) != 0) {
                c15761.label -= Integer.MIN_VALUE;
            } else {
                c15761 = new C15761(continuation);
            }
        } else {
            c15761 = new C15761(continuation);
        }
        Object userSplit = c15761.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c15761.label;
        if (i != 0) {
            if (i == 1) {
                Map<String, ? extends Object> map2 = (Map) c15761.L$2;
                map = (Map) c15761.L$1;
                Split split3 = (Split) c15761.L$0;
                ResultKt.throwOnFailure(userSplit);
                mapPlus = map2;
                split = split3;
                enterpriseSplit = userSplit;
            } else {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                str = (String) c15761.L$3;
                split2 = (Split) c15761.L$0;
                ResultKt.throwOnFailure(userSplit);
            }
            str2 = (String) userSplit;
            if (!Intrinsics.areEqual(str2, SPLIT_CLIENT_NOT_READY) && Intrinsics.areEqual(str, SPLIT_CLIENT_NOT_READY)) {
                zIsEnabled = split2.getDefaultValue();
            } else if (!Intrinsics.areEqual(str2, SPLIT_CLIENT_NOT_READY) || Intrinsics.areEqual(str2, "not_found")) {
                zIsEnabled = isEnabled(split2, str);
            } else {
                zIsEnabled = isEnabled(split2, str2);
            }
            return Boxing.boxBoolean(zIsEnabled);
        }
        ResultKt.throwOnFailure(userSplit);
        mapPlus = MapsKt.plus(getMandatoryAttributes(), map);
        String featureName = split.getFeatureName();
        c15761.L$0 = split;
        c15761.L$1 = SpillingKt.nullOutSpilledVariable(map);
        c15761.L$2 = mapPlus;
        c15761.label = 1;
        enterpriseSplit = getEnterpriseSplit(featureName, mapPlus, c15761);
        if (enterpriseSplit != coroutine_suspended) {
        }
        return coroutine_suspended;
        String str3 = (String) enterpriseSplit;
        String featureName2 = split.getFeatureName();
        c15761.L$0 = split;
        c15761.L$1 = SpillingKt.nullOutSpilledVariable(map);
        c15761.L$2 = SpillingKt.nullOutSpilledVariable(mapPlus);
        c15761.L$3 = str3;
        c15761.label = 2;
        userSplit = getUserSplit(featureName2, mapPlus, str3, c15761);
        if (userSplit != coroutine_suspended) {
            split2 = split;
            str = str3;
            str2 = (String) userSplit;
            if (!Intrinsics.areEqual(str2, SPLIT_CLIENT_NOT_READY)) {
                if (!Intrinsics.areEqual(str2, SPLIT_CLIENT_NOT_READY)) {
                    zIsEnabled = isEnabled(split2, str);
                } else {
                    zIsEnabled = isEnabled(split2, str);
                }
            } else if (!Intrinsics.areEqual(str2, SPLIT_CLIENT_NOT_READY)) {
                zIsEnabled = isEnabled(split2, str);
            } else {
                zIsEnabled = isEnabled(split2, str);
            }
            return Boxing.boxBoolean(zIsEnabled);
        }
        return coroutine_suspended;
    }

    private final boolean isEnabled(Split split, String str) {
        if (Intrinsics.areEqual(str, "not_found")) {
            return split.getDefaultValue();
        }
        return Intrinsics.areEqual(str, "on");
    }

    /* JADX WARN: Code duplicated, block: B:29:0x0094 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getEnterpriseSplit(String str, Map<String, ? extends Object> map, Continuation<? super String> continuation) {
        C15751 c15751;
        String str2;
        if (continuation instanceof C15751) {
            c15751 = (C15751) continuation;
            if ((c15751.label & Integer.MIN_VALUE) != 0) {
                c15751.label -= Integer.MIN_VALUE;
            } else {
                c15751 = new C15751(continuation);
            }
        } else {
            c15751 = new C15751(continuation);
        }
        C15751 c15752 = c15751;
        Object treatmentSync$default = c15752.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c15752.label;
        if (i == 0) {
            ResultKt.throwOnFailure(treatmentSync$default);
            if (enterpriseSplitExists(str)) {
                SplitClient splitClient = this.enterpriseIdTrafficClient;
                if (splitClient != null) {
                    if (splitClient.isReady() || !this.enterpriseTimedOut) {
                        c15752.L$0 = SpillingKt.nullOutSpilledVariable(str);
                        c15752.L$1 = SpillingKt.nullOutSpilledVariable(map);
                        c15752.L$2 = SpillingKt.nullOutSpilledVariable(splitClient);
                        c15752.I$0 = 0;
                        c15752.label = 1;
                        treatmentSync$default = getTreatmentSync$default(this, splitClient, "enterprise_" + str, map, null, c15752, 4, null);
                        if (treatmentSync$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        str2 = SPLIT_CLIENT_NOT_READY;
                    }
                    if (str2 != null) {
                        return str2;
                    }
                }
                return SPLIT_CLIENT_NOT_READY;
            }
            return "not_found";
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        int i2 = c15752.I$0;
        ResultKt.throwOnFailure(treatmentSync$default);
        str2 = (String) treatmentSync$default;
        if (str2 != null) {
            return SPLIT_CLIENT_NOT_READY;
        }
        return str2;
    }

    /* JADX WARN: Code duplicated, block: B:32:0x00b2 A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getUserSplit(String str, Map<String, ? extends Object> map, String str2, Continuation<? super String> continuation) {
        C15781 c15781;
        String str3;
        if (continuation instanceof C15781) {
            c15781 = (C15781) continuation;
            if ((c15781.label & Integer.MIN_VALUE) != 0) {
                c15781.label -= Integer.MIN_VALUE;
            } else {
                c15781 = new C15781(continuation);
            }
        } else {
            c15781 = new C15781(continuation);
        }
        C15781 c15782 = c15781;
        Object treatmentSync$default = c15782.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c15782.label;
        if (i == 0) {
            ResultKt.throwOnFailure(treatmentSync$default);
            if (userSplitExists(str)) {
                SplitClient splitClient = this.userIdTrafficClient;
                if (splitClient != null) {
                    if (splitClient.isReady() || !this.userTimedOut) {
                        Map mutableMap = MapsKt.toMutableMap(map);
                        if (str2 != null) {
                            mutableMap.put(SPLIT_ATTRIBUTE_ENTERPRISE_TREATMENT, str2);
                        }
                        c15782.L$0 = SpillingKt.nullOutSpilledVariable(str);
                        c15782.L$1 = SpillingKt.nullOutSpilledVariable(map);
                        c15782.L$2 = SpillingKt.nullOutSpilledVariable(str2);
                        c15782.L$3 = SpillingKt.nullOutSpilledVariable(splitClient);
                        c15782.L$4 = SpillingKt.nullOutSpilledVariable(mutableMap);
                        c15782.I$0 = 0;
                        c15782.label = 1;
                        treatmentSync$default = getTreatmentSync$default(this, splitClient, "user_" + str, mutableMap, null, c15782, 4, null);
                        if (treatmentSync$default == coroutine_suspended) {
                            return coroutine_suspended;
                        }
                    } else {
                        str3 = SPLIT_CLIENT_NOT_READY;
                    }
                    if (str3 != null) {
                        return str3;
                    }
                }
                return SPLIT_CLIENT_NOT_READY;
            }
            return "not_found";
        }
        if (i != 1) {
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
        int i2 = c15782.I$0;
        ResultKt.throwOnFailure(treatmentSync$default);
        str3 = (String) treatmentSync$default;
        if (str3 != null) {
            return SPLIT_CLIENT_NOT_READY;
        }
        return str3;
    }

    private final boolean enterpriseSplitExists(String featureName) {
        SplitManager splitManager = this.enterpriseIdManager;
        return (splitManager != null ? splitManager.split(new StringBuilder("enterprise_").append(featureName).toString()) : null) != null;
    }

    private final String getSplitApiKey() {
        String string;
        return (!BuildConfigProvider.INSTANCE.isDebugBuild() || (string = this.sharedPreferences.getString(SPLIT_ENV_OVERRIDE_KEY, BuildConfig.CONFIG_SPLIT_API_KEY)) == null) ? BuildConfig.CONFIG_SPLIT_API_KEY : string;
    }

    private final boolean userSplitExists(String featureName) {
        SplitManager splitManager = this.userIdManager;
        return (splitManager != null ? splitManager.split(new StringBuilder("user_").append(featureName).toString()) : null) != null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getTreatmentSync(SplitClient splitClient, String str, Map<String, ? extends Object> map, Function0<Unit> function0, Continuation<? super String> continuation) {
        C15771 c15771;
        if (continuation instanceof C15771) {
            c15771 = (C15771) continuation;
            if ((c15771.label & Integer.MIN_VALUE) != 0) {
                c15771.label -= Integer.MIN_VALUE;
            } else {
                c15771 = new C15771(continuation);
            }
        } else {
            c15771 = new C15771(continuation);
        }
        Object objAwaitReady = c15771.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = c15771.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objAwaitReady);
            c15771.L$0 = splitClient;
            c15771.L$1 = str;
            c15771.L$2 = map;
            c15771.L$3 = function0;
            c15771.label = 1;
            objAwaitReady = awaitReady(splitClient, c15771);
            if (objAwaitReady == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            function0 = (Function0) c15771.L$3;
            map = (Map) c15771.L$2;
            str = (String) c15771.L$1;
            splitClient = (SplitClient) c15771.L$0;
            ResultKt.throwOnFailure(objAwaitReady);
        }
        if (((Boolean) objAwaitReady).booleanValue()) {
            return Intrinsics.areEqual(splitClient.getTreatment(str, map), "on") ? "on" : "off";
        }
        function0.invoke();
        return "off";
    }

    /* JADX WARN: Multi-variable type inference failed */
    static /* synthetic */ Object getTreatmentSync$default(SplitConfiguration splitConfiguration, SplitClient splitClient, String str, Map map, Function0 function0, Continuation continuation, int i, Object obj) {
        if ((i & 4) != 0) {
            function0 = new Function0() { // from class: com.box.android.domain.configuration.SplitConfiguration$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Unit.INSTANCE;
                }
            };
        }
        return splitConfiguration.getTreatmentSync(splitClient, str, map, function0, continuation);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object awaitReady(SplitClient splitClient, Continuation<? super Boolean> continuation) {
        AnonymousClass1 anonymousClass1;
        final CompletableDeferred completableDeferredCompletableDeferred$default;
        Mutex mutex;
        if (continuation instanceof AnonymousClass1) {
            anonymousClass1 = (AnonymousClass1) continuation;
            if ((anonymousClass1.label & Integer.MIN_VALUE) != 0) {
                anonymousClass1.label -= Integer.MIN_VALUE;
            } else {
                anonymousClass1 = new AnonymousClass1(continuation);
            }
        } else {
            anonymousClass1 = new AnonymousClass1(continuation);
        }
        Object obj = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                if (splitClient.isReady()) {
                    return Boxing.boxBoolean(true);
                }
                completableDeferredCompletableDeferred$default = CompletableDeferredKt.CompletableDeferred$default(null, 1, null);
                mutex = this.splitMutex;
                anonymousClass1.L$0 = splitClient;
                anonymousClass1.L$1 = completableDeferredCompletableDeferred$default;
                anonymousClass1.L$2 = mutex;
                anonymousClass1.I$0 = 0;
                anonymousClass1.label = 1;
                if (mutex.lock(null, anonymousClass1) != coroutine_suspended) {
                }
            }
            if (i != 1) {
                if (i != 2) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
                return obj;
            }
            int i2 = anonymousClass1.I$0;
            Mutex mutex2 = (Mutex) anonymousClass1.L$2;
            completableDeferredCompletableDeferred$default = (CompletableDeferred) anonymousClass1.L$1;
            SplitClient splitClient2 = (SplitClient) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
            mutex = mutex2;
            splitClient = splitClient2;
            on(splitClient, SplitEvent.SDK_READY, new Function0() { // from class: com.box.android.domain.configuration.SplitConfiguration$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SplitConfiguration.awaitReady$lambda$0$0(completableDeferredCompletableDeferred$default);
                }
            });
            on(splitClient, SplitEvent.SDK_READY_FROM_CACHE, new Function0() { // from class: com.box.android.domain.configuration.SplitConfiguration$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SplitConfiguration.awaitReady$lambda$0$1(completableDeferredCompletableDeferred$default);
                }
            });
            on(splitClient, SplitEvent.SDK_READY_TIMED_OUT, new Function0() { // from class: com.box.android.domain.configuration.SplitConfiguration$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return SplitConfiguration.awaitReady$lambda$0$2(completableDeferredCompletableDeferred$default);
                }
            });
            Unit unit = Unit.INSTANCE;
            mutex.unlock(null);
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(splitClient);
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(completableDeferredCompletableDeferred$default);
            anonymousClass1.L$2 = null;
            anonymousClass1.label = 2;
            Object objAwait = completableDeferredCompletableDeferred$default.await(anonymousClass1);
            return objAwait == coroutine_suspended ? coroutine_suspended : objAwait;
        } catch (Throwable th) {
            mutex.unlock(null);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit awaitReady$lambda$0$0(CompletableDeferred completableDeferred) {
        completableDeferred.complete(true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit awaitReady$lambda$0$1(CompletableDeferred completableDeferred) {
        completableDeferred.complete(true);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit awaitReady$lambda$0$2(CompletableDeferred completableDeferred) {
        completableDeferred.complete(false);
        return Unit.INSTANCE;
    }

    private final void on(SplitClient splitClient, SplitEvent splitEvent, final Function0<Unit> function0) {
        splitClient.on(splitEvent, new SplitEventTask() { // from class: com.box.android.domain.configuration.SplitConfiguration.on.1
            @Override // io.split.android.client.events.SplitEventTask
            public void onPostExecution(SplitClient client) {
                function0.invoke();
            }
        });
    }

    /* JADX INFO: compiled from: SplitConfiguration.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000e\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u001c\u0010\u000f\u001a\u00020\u00058\u0006X\u0087D¢\u0006\u000e\n\u0000\u0012\u0004\b\u0010\u0010\u0003\u001a\u0004\b\u0011\u0010\u0012¨\u0006\u0013"}, d2 = {"Lcom/box/android/domain/configuration/SplitConfiguration$Companion;", "", "<init>", "()V", "TREATMENT_OFF", "", "TREATMENT_ON", "SPLIT_NOT_FOUND", "SPLIT_CLIENT_NOT_READY", "SPLIT_ATTRIBUTE_OS_KEY", "SPLIT_ATTRIBUTE_OS_VERSION_KEY", "SPLIT_ATTRIBUTE_APP_VERSION_KEY", "SPLIT_ATTRIBUTE_MANAGED_DEVICE_KEY", "SPLIT_ATTRIBUTE_MANAGED_ACCOUNT_KEY", "SPLIT_ATTRIBUTE_ENTERPRISE_TREATMENT", "SPLIT_ENV_OVERRIDE_KEY", "getSPLIT_ENV_OVERRIDE_KEY$annotations", "getSPLIT_ENV_OVERRIDE_KEY", "()Ljava/lang/String;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getSPLIT_ENV_OVERRIDE_KEY$annotations() {
        }

        private Companion() {
        }

        public final String getSPLIT_ENV_OVERRIDE_KEY() {
            return SplitConfiguration.SPLIT_ENV_OVERRIDE_KEY;
        }
    }
}

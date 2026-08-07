package com.box.android.domain.initialisation;

import com.box.android.domain.configuration.FeatureFlips;
import com.box.android.domain.models.ClientSettingsModel;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.services.IClientSettingsService;
import com.box.android.domain.services.IGeniusScanLicenseService;
import com.box.android.domain.services.RumService;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.utils.BoxLogUtils;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: ClientSettingsInitialisation.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0002\u0018\u00002\u00020\u0001B)\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0004\b\n\u0010\u000bJ\u0012\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007J\u0012\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0002J!\u0010\u0013\u001a\u00020\r2\b\u0010\u0014\u001a\u0004\u0018\u00010\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0002¢\u0006\u0002\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/box/android/domain/initialisation/ClientSettingsInitialisation;", "", "clientSettingsService", "Lcom/box/android/domain/services/IClientSettingsService;", "geniusScanLicenseService", "Lcom/box/android/domain/services/IGeniusScanLicenseService;", "rumService", "Lcom/box/android/domain/services/RumService;", "featureFlips", "Lcom/box/android/domain/configuration/FeatureFlips;", "<init>", "(Lcom/box/android/domain/services/IClientSettingsService;Lcom/box/android/domain/services/IGeniusScanLicenseService;Lcom/box/android/domain/services/RumService;Lcom/box/android/domain/configuration/FeatureFlips;)V", "init", "", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "initLicence", "geniusScanLicense", "", "initialiseRUM", "rumProxyUrl", "rumSamplingRatio", "", "(Ljava/lang/String;Ljava/lang/Double;)V", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class ClientSettingsInitialisation {
    private final IClientSettingsService clientSettingsService;
    private final FeatureFlips featureFlips;
    private final IGeniusScanLicenseService geniusScanLicenseService;
    private final RumService rumService;

    public final void init() {
        init$default(this, null, 1, null);
    }

    @Inject
    public ClientSettingsInitialisation(IClientSettingsService clientSettingsService, IGeniusScanLicenseService geniusScanLicenseService, RumService rumService, FeatureFlips featureFlips) {
        Intrinsics.checkNotNullParameter(clientSettingsService, "clientSettingsService");
        Intrinsics.checkNotNullParameter(geniusScanLicenseService, "geniusScanLicenseService");
        Intrinsics.checkNotNullParameter(rumService, "rumService");
        Intrinsics.checkNotNullParameter(featureFlips, "featureFlips");
        this.clientSettingsService = clientSettingsService;
        this.geniusScanLicenseService = geniusScanLicenseService;
        this.rumService = rumService;
        this.featureFlips = featureFlips;
    }

    /* JADX INFO: renamed from: com.box.android.domain.initialisation.ClientSettingsInitialisation$init$1, reason: invalid class name */
    /* JADX INFO: compiled from: ClientSettingsInitialisation.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.initialisation.ClientSettingsInitialisation$init$1", f = "ClientSettingsInitialisation.kt", i = {0}, l = {27}, m = "invokeSuspend", n = {"$this$launch"}, s = {"L$0"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = ClientSettingsInitialisation.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            CoroutineScope coroutineScope = (CoroutineScope) this.L$0;
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.L$0 = coroutineScope;
                this.label = 1;
                obj = ClientSettingsInitialisation.this.clientSettingsService.getClientSettingsRemote(this);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Result result = (Result) obj;
            ClientSettingsInitialisation clientSettingsInitialisation = ClientSettingsInitialisation.this;
            boolean z = result instanceof Result.Success;
            if (z) {
                ClientSettingsModel clientSettingsModel = (ClientSettingsModel) ((Result.Success) result).getValue();
                clientSettingsInitialisation.initLicence(clientSettingsModel.getGeniusScanLicense());
                clientSettingsInitialisation.initialiseRUM(clientSettingsModel.getRumProxyUrl(), clientSettingsModel.getRumSamplingRatio());
            } else if (!(result instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            if (!z) {
                if (!(result instanceof Result.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                BoxLogUtils.w(ExtensionsKt.getTAG(coroutineScope), "Client settings fetch error " + ((DomainError) ((Result.Error) result).getValue()).getMessage() + ". RUM not initialised");
            }
            return Unit.INSTANCE;
        }
    }

    public static /* synthetic */ void init$default(ClientSettingsInitialisation clientSettingsInitialisation, CoroutineDispatcher coroutineDispatcher, int i, Object obj) {
        if ((i & 1) != 0) {
            coroutineDispatcher = Dispatchers.getIO();
        }
        clientSettingsInitialisation.init(coroutineDispatcher);
    }

    public final void init(CoroutineDispatcher ioDispatcher) {
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        BuildersKt__Builders_commonKt.launch$default(CoroutineScopeKt.CoroutineScope(ioDispatcher), null, null, new AnonymousClass1(null), 3, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initLicence(String geniusScanLicense) {
        if (geniusScanLicense != null) {
            this.geniusScanLicenseService.writeLicenseKeyToCache(geniusScanLicense);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void initialiseRUM(String rumProxyUrl, Double rumSamplingRatio) {
        if (this.featureFlips.getSplunkRUM().getEnabled()) {
            if (rumProxyUrl != null && rumSamplingRatio != null) {
                this.rumService.init(rumProxyUrl, rumSamplingRatio.doubleValue());
            } else {
                BoxLogUtils.w(ExtensionsKt.getTAG(this), "RUM proxy url or RUM sampling ratio are null. RUM not initialised");
            }
        }
    }
}

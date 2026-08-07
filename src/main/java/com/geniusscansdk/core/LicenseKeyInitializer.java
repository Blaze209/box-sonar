package com.geniusscansdk.core;

import android.content.Context;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.GlobalScope;

/* JADX INFO: compiled from: LicenseKeyInitializer.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0000\u0018\u00002\u00020\u0001BA\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\b\b\u0002\u0010\f\u001a\u00020\r¢\u0006\u0004\b\u000e\u0010\u000fJ\u0016\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0015J\u000e\u0010\u0016\u001a\u00020\u0011H\u0086@¢\u0006\u0002\u0010\u0017J\u001e\u0010\u0018\u001a\u00020\u00112\u0006\u0010\u0019\u001a\u00020\u00132\u0006\u0010\u001a\u001a\u00020\u001bH\u0082@¢\u0006\u0002\u0010\u001cR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/geniusscansdk/core/LicenseKeyInitializer;", "", "context", "Landroid/content/Context;", "licenseKeySetter", "Lcom/geniusscansdk/core/LicenseKeySetter;", "logger", "Lcom/geniusscansdk/core/Logger;", "licenseKeyRefresher", "Lcom/geniusscansdk/core/LicenseKeyRefresher;", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "licenseKeyHolder", "Lcom/geniusscansdk/core/SessionLicenseKeyHolder;", "<init>", "(Landroid/content/Context;Lcom/geniusscansdk/core/LicenseKeySetter;Lcom/geniusscansdk/core/Logger;Lcom/geniusscansdk/core/LicenseKeyRefresher;Lkotlinx/coroutines/CoroutineScope;Lcom/geniusscansdk/core/SessionLicenseKeyHolder;)V", "setLicenseKey", "", "licenseKey", "", "autoRefresh", "", "refreshAndInitializeInScanFlow", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "refreshAndInitializeWithRefreshedKey", "baseLicenseKey", BoxNoteConstants.BOX_NOTE_BRIDGE_KEY_REASON, "Lcom/geniusscansdk/core/LicenseKeyRefresher$LicenseKeyRefreshReason;", "(Ljava/lang/String;Lcom/geniusscansdk/core/LicenseKeyRefresher$LicenseKeyRefreshReason;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "gssdk_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LicenseKeyInitializer {
    private final Context context;
    private final CoroutineScope coroutineScope;
    private final SessionLicenseKeyHolder licenseKeyHolder;
    private final LicenseKeyRefresher licenseKeyRefresher;
    private final LicenseKeySetter licenseKeySetter;
    private final Logger logger;

    /* JADX INFO: renamed from: com.geniusscansdk.core.LicenseKeyInitializer$refreshAndInitializeWithRefreshedKey$1, reason: invalid class name */
    /* JADX INFO: compiled from: LicenseKeyInitializer.kt */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.geniusscansdk.core.LicenseKeyInitializer", f = "LicenseKeyInitializer.kt", i = {0}, l = {60}, m = "refreshAndInitializeWithRefreshedKey", n = {"this"}, s = {"L$0"})
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return LicenseKeyInitializer.this.refreshAndInitializeWithRefreshedKey(null, null, this);
        }
    }

    public LicenseKeyInitializer(Context context, LicenseKeySetter licenseKeySetter, Logger logger, LicenseKeyRefresher licenseKeyRefresher, CoroutineScope coroutineScope, SessionLicenseKeyHolder licenseKeyHolder) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(licenseKeySetter, "licenseKeySetter");
        Intrinsics.checkNotNullParameter(logger, "logger");
        Intrinsics.checkNotNullParameter(licenseKeyRefresher, "licenseKeyRefresher");
        Intrinsics.checkNotNullParameter(coroutineScope, "coroutineScope");
        Intrinsics.checkNotNullParameter(licenseKeyHolder, "licenseKeyHolder");
        this.context = context;
        this.licenseKeySetter = licenseKeySetter;
        this.logger = logger;
        this.licenseKeyRefresher = licenseKeyRefresher;
        this.coroutineScope = coroutineScope;
        this.licenseKeyHolder = licenseKeyHolder;
    }

    public /* synthetic */ LicenseKeyInitializer(Context context, GeniusScanSDK.DefaultLicenseKeySetter defaultLicenseKeySetter, Logger logger, LicenseKeyRefresher licenseKeyRefresher, GlobalScope globalScope, SessionLicenseKeyHolder sessionLicenseKeyHolder, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i & 2) != 0 ? new GeniusScanSDK.DefaultLicenseKeySetter() : defaultLicenseKeySetter, (i & 4) != 0 ? GeniusScanSDK.getLogger() : logger, (i & 8) != 0 ? new LicenseKeyRefresher(context) : licenseKeyRefresher, (i & 16) != 0 ? GlobalScope.INSTANCE : globalScope, (i & 32) != 0 ? SessionLicenseKeyHolder.INSTANCE.getShared() : sessionLicenseKeyHolder);
    }

    public final void setLicenseKey(String licenseKey, boolean autoRefresh) {
        String cachedLicenseKey;
        Intrinsics.checkNotNullParameter(licenseKey, "licenseKey");
        try {
            this.licenseKeySetter.setLicenseKey(this.context, licenseKey);
        } catch (LicenseException e) {
            this.logger.warn("Error when initializing the Genius Scan SDK with the license key " + licenseKey + ": " + e);
            if (e.errorCode != LicenseException.ErrorCode.ExpiredKey) {
                this.logger.error("License key is invalid, SDK has not been initialized, no automatic refresh will be attempted.");
                this.licenseKeyHolder.forgetLicenseKey();
                return;
            } else if (autoRefresh && (cachedLicenseKey = this.licenseKeyRefresher.getCachedLicenseKey()) != null) {
                try {
                    this.licenseKeySetter.setLicenseKey(this.context, cachedLicenseKey);
                } catch (LicenseException e2) {
                    this.logger.error("Error when initializing the Genius Scan SDK with the cached license key " + licenseKey + ": " + e2);
                }
            }
        }
        if (autoRefresh) {
            this.licenseKeyHolder.rememberLicenseKey(licenseKey);
            BuildersKt__Builders_commonKt.launch$default(this.coroutineScope, null, null, new AnonymousClass2(licenseKey, null), 3, null);
        } else {
            this.licenseKeyHolder.forgetLicenseKey();
        }
    }

    /* JADX INFO: renamed from: com.geniusscansdk.core.LicenseKeyInitializer$setLicenseKey$2, reason: invalid class name */
    /* JADX INFO: compiled from: LicenseKeyInitializer.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.geniusscansdk.core.LicenseKeyInitializer$setLicenseKey$2", f = "LicenseKeyInitializer.kt", i = {}, l = {47}, m = "invokeSuspend", n = {}, s = {})
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ String $licenseKey;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(String str, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$licenseKey = str;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return LicenseKeyInitializer.this.new AnonymousClass2(this.$licenseKey, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                this.label = 1;
                if (LicenseKeyInitializer.this.refreshAndInitializeWithRefreshedKey(this.$licenseKey, LicenseKeyRefresher.LicenseKeyRefreshReason.INITIALIZATION, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public final Object refreshAndInitializeInScanFlow(Continuation<? super Unit> continuation) {
        Object objRefreshAndInitializeWithRefreshedKey;
        String storedLicenseKey = this.licenseKeyHolder.getStoredLicenseKey();
        return (storedLicenseKey != null && (objRefreshAndInitializeWithRefreshedKey = refreshAndInitializeWithRefreshedKey(storedLicenseKey, LicenseKeyRefresher.LicenseKeyRefreshReason.SCAN_FLOW, continuation)) == IntrinsicsKt.getCOROUTINE_SUSPENDED()) ? objRefreshAndInitializeWithRefreshedKey : Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object refreshAndInitializeWithRefreshedKey(String str, LicenseKeyRefresher.LicenseKeyRefreshReason licenseKeyRefreshReason, Continuation<? super Unit> continuation) {
        AnonymousClass1 anonymousClass1;
        Object objM13558refresh0E7RQCE;
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
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            LicenseKeyRefresher licenseKeyRefresher = this.licenseKeyRefresher;
            anonymousClass1.L$0 = this;
            anonymousClass1.label = 1;
            objM13558refresh0E7RQCE = licenseKeyRefresher.m13558refresh0E7RQCE(str, licenseKeyRefreshReason, anonymousClass1);
            if (objM13558refresh0E7RQCE == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            this = (LicenseKeyInitializer) anonymousClass1.L$0;
            ResultKt.throwOnFailure(obj);
            objM13558refresh0E7RQCE = ((Result) obj).getValue();
        }
        if (Result.m14787isSuccessimpl(objM13558refresh0E7RQCE)) {
            String str2 = (String) objM13558refresh0E7RQCE;
            try {
                this.licenseKeySetter.setLicenseKey(this.context, str2);
                this.logger.info("Successfully refreshed and cached the Genius Scan SDK license key.");
            } catch (LicenseException e) {
                this.logger.error("Error when initializing the Genius Scan SDK with the refreshed license key " + str2 + ": " + e);
            }
        }
        Throwable thM14783exceptionOrNullimpl = Result.m14783exceptionOrNullimpl(objM13558refresh0E7RQCE);
        if (thM14783exceptionOrNullimpl != null) {
            this.logger.warn("Error while refreshing the Genius Scan SDK license key: " + thM14783exceptionOrNullimpl);
        }
        return Unit.INSTANCE;
    }
}

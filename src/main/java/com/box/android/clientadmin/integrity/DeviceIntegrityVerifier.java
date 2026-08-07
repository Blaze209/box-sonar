package com.box.android.clientadmin.integrity;

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
import kotlinx.coroutines.BuildersKt__BuildersKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: DeviceIntegrityVerifier.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, d2 = {"Lcom/box/android/clientadmin/integrity/DeviceIntegrityVerifier;", "", "integrityAPICaller", "Lcom/box/android/clientadmin/integrity/IntegrityAPICaller;", "<init>", "(Lcom/box/android/clientadmin/integrity/IntegrityAPICaller;)V", "verifyIntegrity", "Lcom/box/android/clientadmin/integrity/DeviceIntegrityResult;", "playIntegrityAPIUniqueValue", "", "Companion", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeviceIntegrityVerifier {
    public static final int $stable = 0;
    private static final String TAG = "DeviceIntegrityVerifier";
    private static final long TIMEOUT_MS = 60000;
    private final IntegrityAPICaller integrityAPICaller;

    @Inject
    public DeviceIntegrityVerifier(IntegrityAPICaller integrityAPICaller) {
        Intrinsics.checkNotNullParameter(integrityAPICaller, "integrityAPICaller");
        this.integrityAPICaller = integrityAPICaller;
    }

    /* JADX INFO: renamed from: com.box.android.clientadmin.integrity.DeviceIntegrityVerifier$verifyIntegrity$1, reason: invalid class name */
    /* JADX INFO: compiled from: DeviceIntegrityVerifier.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "Lcom/box/android/clientadmin/integrity/DeviceIntegrityResult;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.clientadmin.integrity.DeviceIntegrityVerifier$verifyIntegrity$1", f = "DeviceIntegrityVerifier.kt", i = {}, l = {25}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super DeviceIntegrityResult>, Object> {
        final /* synthetic */ String $playIntegrityAPIUniqueValue;
        int label;
        final /* synthetic */ DeviceIntegrityVerifier this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass1(String str, DeviceIntegrityVerifier deviceIntegrityVerifier, Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
            this.$playIntegrityAPIUniqueValue = str;
            this.this$0 = deviceIntegrityVerifier;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass1(this.$playIntegrityAPIUniqueValue, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super DeviceIntegrityResult> continuation) {
            return ((AnonymousClass1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.label;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                String str = this.$playIntegrityAPIUniqueValue;
                if (str == null || str.length() == 0) {
                    String str2 = DeviceIntegrityVerifier.TAG;
                    Intrinsics.checkNotNullExpressionValue(str2, "access$getTAG$cp(...)");
                    BoxLogUtils.i(str2, "Unique value not provided. Device integrity check failed.");
                    return new DeviceIntegrityResult.IntegrityTokenError("Unique value not provided.");
                }
                String str3 = DeviceIntegrityVerifier.TAG;
                Intrinsics.checkNotNullExpressionValue(str3, "access$getTAG$cp(...)");
                BoxLogUtils.i(str3, "Unique value provided. Checking device integrity with Play Integrity API.");
                this.label = 1;
                obj = IntegrityAPICaller.getIntegrityApiToken$default(this.this$0.integrityAPICaller, this.$playIntegrityAPIUniqueValue, 60000L, null, this, 4, null);
                if (obj == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            Result.Error error = (Result) obj;
            if (error instanceof Result.Success) {
                String str4 = (String) ((Result.Success) error).getValue();
                String str5 = DeviceIntegrityVerifier.TAG;
                Intrinsics.checkNotNullExpressionValue(str5, "access$getTAG$cp(...)");
                BoxLogUtils.i(str5, "Integrity token received successfully.");
                error = new Result.Success(new DeviceIntegrityResult.IntegrityToken(str4));
            } else if (!(error instanceof Result.Error)) {
                throw new NoWhenBranchMatchedException();
            }
            if (!(error instanceof Result.Success)) {
                if (error instanceof Result.Error) {
                    String str6 = (String) ((Result.Error) error).getValue();
                    String str7 = DeviceIntegrityVerifier.TAG;
                    Intrinsics.checkNotNullExpressionValue(str7, "access$getTAG$cp(...)");
                    BoxLogUtils.i(str7, "Error when calling Integrity API: " + str6);
                    error = new Result.Error(new DeviceIntegrityResult.IntegrityTokenError(str6));
                } else {
                    throw new NoWhenBranchMatchedException();
                }
            }
            Object obj2 = com.box.android.domain.utils.result.ResultKt.get(error);
            Intrinsics.checkNotNull(obj2, "null cannot be cast to non-null type com.box.android.clientadmin.integrity.DeviceIntegrityResult");
            return (DeviceIntegrityResult) obj2;
        }
    }

    public final DeviceIntegrityResult verifyIntegrity(String playIntegrityAPIUniqueValue) {
        return (DeviceIntegrityResult) BuildersKt__BuildersKt.runBlocking$default(null, new AnonymousClass1(playIntegrityAPIUniqueValue, this, null), 1, null);
    }
}

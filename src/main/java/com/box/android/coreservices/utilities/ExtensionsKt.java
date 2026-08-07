package com.box.android.coreservices.utilities;

import androidx.exifinterface.media.ExifInterface;
import com.box.android.coreservices.modelcontroller.BoxAppFutureTask;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.models.BoxObject;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: compiled from: Extensions.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a.\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00030\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0004*\b\u0012\u0004\u0012\u0002H\u00020\u0005H\u0086@¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, d2 = {ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "Lcom/box/android/domain/utils/result/Result;", ExifInterface.GPS_DIRECTION_TRUE, "Lcom/box/android/domain/models/DomainError;", "Lcom/box/androidsdk/content/models/BoxObject;", "Lcom/box/android/coreservices/modelcontroller/BoxAppFutureTask;", "(Lcom/box/android/coreservices/modelcontroller/BoxAppFutureTask;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "coreservices_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ExtensionsKt {

    /* JADX INFO: renamed from: com.box.android.coreservices.utilities.ExtensionsKt$result$1, reason: invalid class name */
    /* JADX INFO: compiled from: Extensions.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.coreservices.utilities.ExtensionsKt", f = "Extensions.kt", i = {0}, l = {18}, m = ReactNativeFeatureActivity.RESULT_EXTRA_KEY, n = {"$this$result"}, s = {"L$0"}, v = 1)
    static final class AnonymousClass1<T extends BoxObject> extends ContinuationImpl {
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
            return ExtensionsKt.result(null, this);
        }
    }

    /* JADX INFO: Add missing generic type declarations: [T] */
    /* JADX INFO: renamed from: com.box.android.coreservices.utilities.ExtensionsKt$result$2, reason: invalid class name */
    /* JADX INFO: compiled from: Extensions.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u0016\u0012\f\u0012\n \u0003*\u0004\u0018\u0001H\u0002H\u0002\u0012\u0004\u0012\u00020\u00040\u0001\"\b\b\u0000\u0010\u0002*\u00020\u0005*\u00020\u0006H\n"}, d2 = {"<anonymous>", "Lcom/box/android/domain/utils/result/Result;", ExifInterface.GPS_DIRECTION_TRUE, "kotlin.jvm.PlatformType", "Lcom/box/android/domain/models/DomainError$UnknownError;", "Lcom/box/androidsdk/content/models/BoxObject;", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.coreservices.utilities.ExtensionsKt$result$2", f = "Extensions.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {}, v = 1)
    static final class AnonymousClass2<T> extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Result<? extends T, ? extends DomainError.UnknownError>>, Object> {
        final /* synthetic */ BoxAppFutureTask<T> $this_result;
        int label;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(BoxAppFutureTask<T> boxAppFutureTask, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$this_result = boxAppFutureTask;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$this_result, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Result<? extends T, DomainError.UnknownError>> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            ResultKt.throwOnFailure(obj);
            BoxResponse boxResponse = this.$this_result.get(30L, TimeUnit.SECONDS);
            if (boxResponse.isSuccess()) {
                return new Result.Success(boxResponse.getResult());
            }
            String message = boxResponse.getException().getMessage();
            if (message == null) {
                message = boxResponse.getException().toString();
            }
            return new Result.Error(new DomainError.UnknownError(message));
        }
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public static final <T extends BoxObject> Object result(BoxAppFutureTask<T> boxAppFutureTask, Continuation<? super Result<? extends T, ? extends DomainError>> continuation) {
        AnonymousClass1 anonymousClass1;
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
        Object objWithContext = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        try {
            if (i == 0) {
                ResultKt.throwOnFailure(objWithContext);
                CoroutineDispatcher io2 = Dispatchers.getIO();
                AnonymousClass2 anonymousClass2 = new AnonymousClass2(boxAppFutureTask, null);
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(boxAppFutureTask);
                anonymousClass1.label = 1;
                objWithContext = BuildersKt.withContext(io2, anonymousClass2, anonymousClass1);
                if (objWithContext == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(objWithContext);
            }
            return (Result) objWithContext;
        } catch (Exception e) {
            String message = e.getMessage();
            if (message == null) {
                message = e.toString();
            }
            return new Result.Error(new DomainError.UnknownError(message));
        }
    }
}

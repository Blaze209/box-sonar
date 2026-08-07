package com.box.android.preview.annotations.cpl;

import androidx.media3.extractor.ts.TsExtractor;
import com.box.android.domain.utils.result.Result;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function1;

/* JADX INFO: compiled from: CreateAnnotationReducer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0006\n\u0000\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, d2 = {"<anonymous>", "Lcom/box/android/preview/annotations/cpl/CreateAnnotationReducer$Action;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.preview.annotations.cpl.CreateAnnotationReducer$build$1$1", f = "CreateAnnotationReducer.kt", i = {}, l = {TsExtractor.TS_PACKET_SIZE}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class CreateAnnotationReducer$build$1$1 extends SuspendLambda implements Function1<Continuation<? super CreateAnnotationReducer.Action>, Object> {
    final /* synthetic */ CreateAnnotationReducer.State $state;
    int label;
    final /* synthetic */ CreateAnnotationReducer this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CreateAnnotationReducer$build$1$1(CreateAnnotationReducer createAnnotationReducer, CreateAnnotationReducer.State state, Continuation<? super CreateAnnotationReducer$build$1$1> continuation) {
        super(1, continuation);
        this.this$0 = createAnnotationReducer;
        this.$state = state;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Continuation<?> continuation) {
        return new CreateAnnotationReducer$build$1$1(this.this$0, this.$state, continuation);
    }

    @Override // kotlin.jvm.functions.Function1
    public final Object invoke(Continuation<? super CreateAnnotationReducer.Action> continuation) {
        return ((CreateAnnotationReducer$build$1$1) create(continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = this.label;
        if (i == 0) {
            ResultKt.throwOnFailure(obj);
            this.label = 1;
            obj = this.this$0.createAnnotation(this.$state, this);
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
        if (result instanceof Result.Error) {
            return CreateAnnotationReducer.Action.AnnotationSaveFailed.INSTANCE;
        }
        if (result instanceof Result.Success) {
            return CreateAnnotationReducer.Action.AnnotationSaveSuccess.INSTANCE;
        }
        throw new NoWhenBranchMatchedException();
    }
}

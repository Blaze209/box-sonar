package com.box.android.preview.annotations.managers;

import com.box.android.common.utilities.BoxCommonConstants;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: CreateAnnotationsManager.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u000b\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
@DebugMetadata(c = "com.box.android.preview.annotations.managers.CreateAnnotationsManager$onAnnotationChanged$1$isNotAboveLimit$1", f = "CreateAnnotationsManager.kt", i = {}, l = {BoxCommonConstants.REQUEST_CHOOSE_REMOTE_UPLOAD_DIR}, m = "invokeSuspend", n = {}, s = {}, v = 1)
final class CreateAnnotationsManager$onAnnotationChanged$1$isNotAboveLimit$1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Boolean>, Object> {
    int label;
    final /* synthetic */ CreateAnnotationsManager this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    CreateAnnotationsManager$onAnnotationChanged$1$isNotAboveLimit$1(CreateAnnotationsManager createAnnotationsManager, Continuation<? super CreateAnnotationsManager$onAnnotationChanged$1$isNotAboveLimit$1> continuation) {
        super(2, continuation);
        this.this$0 = createAnnotationsManager;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
        return new CreateAnnotationsManager$onAnnotationChanged$1$isNotAboveLimit$1(this.this$0, continuation);
    }

    @Override // kotlin.jvm.functions.Function2
    public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Boolean> continuation) {
        return ((CreateAnnotationsManager$onAnnotationChanged$1$isNotAboveLimit$1) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
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
        Object objIsPendingAnnotationPayloadSizeNotAboveLimit = this.this$0.isPendingAnnotationPayloadSizeNotAboveLimit(this);
        return objIsPendingAnnotationPayloadSizeNotAboveLimit == coroutine_suspended ? coroutine_suspended : objIsPendingAnnotationPayloadSizeNotAboveLimit;
    }
}

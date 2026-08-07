package com.box.android.domain.usecases.fileactivities.annotation;

import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.services.IAnnotationsService;
import com.box.android.domain.services.IRemoteItemService;
import com.box.android.domain.utils.result.Result;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: DeleteAnnotationInteractor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J.\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0086@¢\u0006\u0002\u0010\u0010R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/box/android/domain/usecases/fileactivities/annotation/DeleteAnnotationInteractor;", "", "annotationsService", "Lcom/box/android/domain/services/IAnnotationsService;", "itemService", "Lcom/box/android/domain/services/IRemoteItemService;", "<init>", "(Lcom/box/android/domain/services/IAnnotationsService;Lcom/box/android/domain/services/IRemoteItemService;)V", "deleteAnnotation", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/DomainError;", "annotationId", "", "itemId", "Lcom/box/android/domain/models/ItemId;", "(Ljava/lang/String;Lcom/box/android/domain/models/ItemId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeleteAnnotationInteractor {
    private final IAnnotationsService annotationsService;
    private final IRemoteItemService itemService;

    /* JADX INFO: renamed from: com.box.android.domain.usecases.fileactivities.annotation.DeleteAnnotationInteractor$deleteAnnotation$1, reason: invalid class name */
    /* JADX INFO: compiled from: DeleteAnnotationInteractor.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.usecases.fileactivities.annotation.DeleteAnnotationInteractor", f = "DeleteAnnotationInteractor.kt", i = {0, 0, 1, 1, 1, 1, 1, 1}, l = {15, 17}, m = "deleteAnnotation", n = {"annotationId", "itemId", "annotationId", "itemId", "$this$onSuccess$iv", "it", "$i$f$onSuccess", "$i$a$-onSuccess-DeleteAnnotationInteractor$deleteAnnotation$2"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DeleteAnnotationInteractor.this.deleteAnnotation(null, null, this);
        }
    }

    @Inject
    public DeleteAnnotationInteractor(IAnnotationsService annotationsService, IRemoteItemService itemService) {
        Intrinsics.checkNotNullParameter(annotationsService, "annotationsService");
        Intrinsics.checkNotNullParameter(itemService, "itemService");
        this.annotationsService = annotationsService;
        this.itemService = itemService;
    }

    public static /* synthetic */ Object deleteAnnotation$default(DeleteAnnotationInteractor deleteAnnotationInteractor, String str, ItemId itemId, Continuation continuation, int i, Object obj) {
        if ((i & 2) != 0) {
            itemId = null;
        }
        return deleteAnnotationInteractor.deleteAnnotation(str, itemId, continuation);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object deleteAnnotation(String str, ItemId itemId, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
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
        Object objDeleteAnnotation = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objDeleteAnnotation);
            IAnnotationsService iAnnotationsService = this.annotationsService;
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str);
            anonymousClass1.L$1 = itemId;
            anonymousClass1.label = 1;
            objDeleteAnnotation = iAnnotationsService.deleteAnnotation(str, anonymousClass1);
            if (objDeleteAnnotation != coroutine_suspended) {
            }
            return coroutine_suspended;
        }
        if (i != 1) {
            if (i != 2) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            int i2 = anonymousClass1.I$1;
            int i3 = anonymousClass1.I$0;
            Result result = (Result) anonymousClass1.L$2;
            ResultKt.throwOnFailure(objDeleteAnnotation);
            return result;
        }
        itemId = (ItemId) anonymousClass1.L$1;
        str = (String) anonymousClass1.L$0;
        ResultKt.throwOnFailure(objDeleteAnnotation);
        Result result2 = (Result) objDeleteAnnotation;
        if (result2 instanceof Result.Success) {
            Unit unit = (Unit) ((Result.Success) result2).getValue();
            if (itemId != null) {
                IRemoteItemService iRemoteItemService = this.itemService;
                anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(str);
                anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(itemId);
                anonymousClass1.L$2 = result2;
                anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(unit);
                anonymousClass1.I$0 = 0;
                anonymousClass1.I$1 = 0;
                anonymousClass1.label = 2;
                if (iRemoteItemService.updateCacheItemFromRemote(itemId, anonymousClass1) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            }
        } else if (!(result2 instanceof Result.Error)) {
            throw new NoWhenBranchMatchedException();
        }
        return result2;
    }
}

package com.box.android.domain.usecases.fileactivities.annotation;

import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.annotations.FileActivityModel;
import com.box.android.domain.models.annotations.FileVersionIdModel;
import com.box.android.domain.services.IAnnotationsService;
import com.box.android.domain.services.IdMappingService;
import com.box.android.domain.utils.result.Result;
import java.util.List;
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
import kotlinx.coroutines.flow.Flow;

/* JADX INFO: compiled from: GetAnnotationForFileVersionInteractor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\"\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\f\u001a\u00020\rH\u0086@¢\u0006\u0002\u0010\u000eJ&\u0010\u000f\u001a\u001a\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0010\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\f\u001a\u00020\rJ*\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0086@¢\u0006\u0002\u0010\u0017J6\u0010\u000f\u001a\u001a\u0012\u0010\u0012\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u00110\u0010\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0086@¢\u0006\u0002\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/box/android/domain/usecases/fileactivities/annotation/GetAnnotationForFileVersionInteractor;", "", "annotationsService", "Lcom/box/android/domain/services/IAnnotationsService;", "idMappingService", "Lcom/box/android/domain/services/IdMappingService;", "<init>", "(Lcom/box/android/domain/services/IAnnotationsService;Lcom/box/android/domain/services/IdMappingService;)V", "refreshAnnotations", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/DomainError;", "fileVersionIdModel", "Lcom/box/android/domain/models/annotations/FileVersionIdModel;", "(Lcom/box/android/domain/models/annotations/FileVersionIdModel;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAnnotationsFlow", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/box/android/domain/models/annotations/FileActivityModel$AnnotationModel;", "itemId", "Lcom/box/android/domain/models/ItemId;", "fileVersionId", "", "(Lcom/box/android/domain/models/ItemId;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class GetAnnotationForFileVersionInteractor {
    private final IAnnotationsService annotationsService;
    private final IdMappingService idMappingService;

    /* JADX INFO: renamed from: com.box.android.domain.usecases.fileactivities.annotation.GetAnnotationForFileVersionInteractor$getAnnotationsFlow$1, reason: invalid class name */
    /* JADX INFO: compiled from: GetAnnotationForFileVersionInteractor.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.usecases.fileactivities.annotation.GetAnnotationForFileVersionInteractor", f = "GetAnnotationForFileVersionInteractor.kt", i = {0, 0}, l = {34}, m = "getAnnotationsFlow", n = {"itemId", "fileVersionId"}, s = {"L$0", "L$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        Object L$0;
        Object L$1;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GetAnnotationForFileVersionInteractor.this.getAnnotationsFlow(null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.domain.usecases.fileactivities.annotation.GetAnnotationForFileVersionInteractor$refreshAnnotations$2, reason: invalid class name */
    /* JADX INFO: compiled from: GetAnnotationForFileVersionInteractor.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.usecases.fileactivities.annotation.GetAnnotationForFileVersionInteractor", f = "GetAnnotationForFileVersionInteractor.kt", i = {0, 0, 1, 1, 1, 1, 1, 1, 1}, l = {25, 27}, m = "refreshAnnotations", n = {"itemId", "fileVersionId", "itemId", "fileVersionId", "$this$flatMap$iv", "it", "fileVersionIdModel", "$i$f$flatMap", "$i$a$-flatMap-GetAnnotationForFileVersionInteractor$refreshAnnotations$3"}, s = {"L$0", "L$1", "L$0", "L$1", "L$2", "L$3", "L$4", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass2 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        /* synthetic */ Object result;

        AnonymousClass2(Continuation<? super AnonymousClass2> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return GetAnnotationForFileVersionInteractor.this.refreshAnnotations(null, null, this);
        }
    }

    @Inject
    public GetAnnotationForFileVersionInteractor(IAnnotationsService annotationsService, IdMappingService idMappingService) {
        Intrinsics.checkNotNullParameter(annotationsService, "annotationsService");
        Intrinsics.checkNotNullParameter(idMappingService, "idMappingService");
        this.annotationsService = annotationsService;
        this.idMappingService = idMappingService;
    }

    public final Object refreshAnnotations(FileVersionIdModel fileVersionIdModel, Continuation<? super Result<Unit, ? extends DomainError>> continuation) {
        return this.annotationsService.fetchAnnotationsFromRemote(fileVersionIdModel, continuation);
    }

    public final Result<Flow<List<FileActivityModel.AnnotationModel>>, DomainError> getAnnotationsFlow(FileVersionIdModel fileVersionIdModel) {
        Intrinsics.checkNotNullParameter(fileVersionIdModel, "fileVersionIdModel");
        return this.annotationsService.annotations(fileVersionIdModel);
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00b1, code lost:
    
        if (r9 == r1) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object refreshAnnotations(com.box.android.domain.models.ItemId r7, java.lang.String r8, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<kotlin.Unit, ? extends com.box.android.domain.models.DomainError>> r9) {
        /*
            r6 = this;
            boolean r0 = r9 instanceof com.box.android.domain.usecases.fileactivities.annotation.GetAnnotationForFileVersionInteractor.AnonymousClass2
            if (r0 == 0) goto L14
            r0 = r9
            com.box.android.domain.usecases.fileactivities.annotation.GetAnnotationForFileVersionInteractor$refreshAnnotations$2 r0 = (com.box.android.domain.usecases.fileactivities.annotation.GetAnnotationForFileVersionInteractor.AnonymousClass2) r0
            int r1 = r0.label
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r1 = r1 & r2
            if (r1 == 0) goto L14
            int r9 = r0.label
            int r9 = r9 - r2
            r0.label = r9
            goto L19
        L14:
            com.box.android.domain.usecases.fileactivities.annotation.GetAnnotationForFileVersionInteractor$refreshAnnotations$2 r0 = new com.box.android.domain.usecases.fileactivities.annotation.GetAnnotationForFileVersionInteractor$refreshAnnotations$2
            r0.<init>(r9)
        L19:
            java.lang.Object r9 = r0.result
            java.lang.Object r1 = kotlin.coroutines.intrinsics.IntrinsicsKt.getCOROUTINE_SUSPENDED()
            int r2 = r0.label
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L5a
            if (r2 == r4) goto L4d
            if (r2 != r3) goto L45
            int r6 = r0.I$1
            int r6 = r0.I$0
            java.lang.Object r6 = r0.L$4
            com.box.android.domain.models.annotations.FileVersionIdModel r6 = (com.box.android.domain.models.annotations.FileVersionIdModel) r6
            java.lang.Object r6 = r0.L$3
            com.box.android.domain.models.ItemId$Remote r6 = (com.box.android.domain.models.ItemId.Remote) r6
            java.lang.Object r6 = r0.L$2
            com.box.android.domain.utils.result.Result r6 = (com.box.android.domain.utils.result.Result) r6
            java.lang.Object r6 = r0.L$1
            java.lang.String r6 = (java.lang.String) r6
            java.lang.Object r6 = r0.L$0
            com.box.android.domain.models.ItemId r6 = (com.box.android.domain.models.ItemId) r6
            kotlin.ResultKt.throwOnFailure(r9)
            goto Lb4
        L45:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L4d:
            java.lang.Object r7 = r0.L$1
            r8 = r7
            java.lang.String r8 = (java.lang.String) r8
            java.lang.Object r7 = r0.L$0
            com.box.android.domain.models.ItemId r7 = (com.box.android.domain.models.ItemId) r7
            kotlin.ResultKt.throwOnFailure(r9)
            goto L70
        L5a:
            kotlin.ResultKt.throwOnFailure(r9)
            com.box.android.domain.services.IdMappingService r9 = r6.idMappingService
            java.lang.Object r2 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r0.L$0 = r2
            r0.L$1 = r8
            r0.label = r4
            java.lang.Object r9 = r9.getRemoteIdOrError(r7, r0)
            if (r9 != r1) goto L70
            goto Lb3
        L70:
            com.box.android.domain.utils.result.Result r9 = (com.box.android.domain.utils.result.Result) r9
            boolean r2 = r9 instanceof com.box.android.domain.utils.result.Result.Success
            if (r2 == 0) goto Lb7
            r2 = r9
            com.box.android.domain.utils.result.Result$Success r2 = (com.box.android.domain.utils.result.Result.Success) r2
            java.lang.Object r2 = r2.getValue()
            com.box.android.domain.models.ItemId$Remote r2 = (com.box.android.domain.models.ItemId.Remote) r2
            com.box.android.domain.models.annotations.FileVersionIdModel r4 = new com.box.android.domain.models.annotations.FileVersionIdModel
            java.lang.String r5 = r2.getBoxId()
            r4.<init>(r8, r5)
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r7)
            r0.L$0 = r7
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r8)
            r0.L$1 = r7
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r9)
            r0.L$2 = r7
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r2)
            r0.L$3 = r7
            java.lang.Object r7 = kotlin.coroutines.jvm.internal.SpillingKt.nullOutSpilledVariable(r4)
            r0.L$4 = r7
            r7 = 0
            r0.I$0 = r7
            r0.I$1 = r7
            r0.label = r3
            java.lang.Object r9 = r6.refreshAnnotations(r4, r0)
            if (r9 != r1) goto Lb4
        Lb3:
            return r1
        Lb4:
            com.box.android.domain.utils.result.Result r9 = (com.box.android.domain.utils.result.Result) r9
            return r9
        Lb7:
            boolean r6 = r9 instanceof com.box.android.domain.utils.result.Result.Error
            if (r6 == 0) goto Lbc
            return r9
        Lbc:
            kotlin.NoWhenBranchMatchedException r6 = new kotlin.NoWhenBranchMatchedException
            r6.<init>()
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.domain.usecases.fileactivities.annotation.GetAnnotationForFileVersionInteractor.refreshAnnotations(com.box.android.domain.models.ItemId, java.lang.String, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object getAnnotationsFlow(ItemId itemId, String str, Continuation<? super Result<? extends Flow<? extends List<FileActivityModel.AnnotationModel>>, ? extends DomainError>> continuation) {
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
        Object remoteIdOrError = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(remoteIdOrError);
            IdMappingService idMappingService = this.idMappingService;
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(itemId);
            anonymousClass1.L$1 = str;
            anonymousClass1.label = 1;
            remoteIdOrError = idMappingService.getRemoteIdOrError(itemId, anonymousClass1);
            if (remoteIdOrError == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            str = (String) anonymousClass1.L$1;
            ResultKt.throwOnFailure(remoteIdOrError);
        }
        Result result = (Result) remoteIdOrError;
        if (result instanceof Result.Success) {
            return getAnnotationsFlow(new FileVersionIdModel(str, ((ItemId.Remote) ((Result.Success) result).getValue()).getBoxId()));
        }
        if (result instanceof Result.Error) {
            return result;
        }
        throw new NoWhenBranchMatchedException();
    }
}

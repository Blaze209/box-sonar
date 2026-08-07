package com.box.android.domain.usecases.fileactivities.annotation;

import com.box.android.domain.services.IAnnotationsService;
import com.box.android.domain.services.IdMappingService;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UpdateAnnotationInteractor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J>\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b0\t2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0086@¢\u0006\u0002\u0010\u0013R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/box/android/domain/usecases/fileactivities/annotation/UpdateAnnotationInteractor;", "", "annotationsService", "Lcom/box/android/domain/services/IAnnotationsService;", "idMappingService", "Lcom/box/android/domain/services/IdMappingService;", "<init>", "(Lcom/box/android/domain/services/IAnnotationsService;Lcom/box/android/domain/services/IdMappingService;)V", "update", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/annotations/FileActivityModel$AnnotationModel;", "Lcom/box/android/domain/models/DomainError;", "itemId", "Lcom/box/android/domain/models/ItemId;", "annotationId", "", "message", "status", "Lcom/box/android/domain/models/annotations/FileActivityModel$Status;", "(Lcom/box/android/domain/models/ItemId;Ljava/lang/String;Ljava/lang/String;Lcom/box/android/domain/models/annotations/FileActivityModel$Status;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class UpdateAnnotationInteractor {
    private final IAnnotationsService annotationsService;
    private final IdMappingService idMappingService;

    /* JADX INFO: renamed from: com.box.android.domain.usecases.fileactivities.annotation.UpdateAnnotationInteractor$update$1, reason: invalid class name */
    /* JADX INFO: compiled from: UpdateAnnotationInteractor.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.usecases.fileactivities.annotation.UpdateAnnotationInteractor", f = "UpdateAnnotationInteractor.kt", i = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1}, l = {21, 22}, m = "update", n = {"itemId", "annotationId", "message", "status", "itemId", "annotationId", "message", "status", "$this$flatMap$iv", "it", "$i$f$flatMap", "$i$a$-flatMap-UpdateAnnotationInteractor$update$2"}, s = {"L$0", "L$1", "L$2", "L$3", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return UpdateAnnotationInteractor.this.update(null, null, null, null, this);
        }
    }

    @Inject
    public UpdateAnnotationInteractor(IAnnotationsService annotationsService, IdMappingService idMappingService) {
        Intrinsics.checkNotNullParameter(annotationsService, "annotationsService");
        Intrinsics.checkNotNullParameter(idMappingService, "idMappingService");
        this.annotationsService = annotationsService;
        this.idMappingService = idMappingService;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x00cc, code lost:
    
        if (r0 == r1) goto L23;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final java.lang.Object update(com.box.android.domain.models.ItemId r6, java.lang.String r7, java.lang.String r8, com.box.android.domain.models.annotations.FileActivityModel.Status r9, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<com.box.android.domain.models.annotations.FileActivityModel.AnnotationModel, ? extends com.box.android.domain.models.DomainError>> r10) {
        /*
            Method dump skipped, instruction units count: 221
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.domain.usecases.fileactivities.annotation.UpdateAnnotationInteractor.update(com.box.android.domain.models.ItemId, java.lang.String, java.lang.String, com.box.android.domain.models.annotations.FileActivityModel$Status, kotlin.coroutines.Continuation):java.lang.Object");
    }
}

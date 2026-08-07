package com.box.android.domain.usecases.capture;

import com.box.android.domain.services.ICaptureHistoryFilesService;
import com.box.android.domain.services.IJobService;
import com.box.android.domain.services.ILocalItemService;
import com.box.android.domain.services.IdMappingService;
import java.util.Set;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;

/* JADX INFO: compiled from: DeleteCaptureHistoryInteractor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\"\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B3\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\b\u0001\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ(\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u00130\u00112\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0096@¢\u0006\u0002\u0010\u0017J4\u0010\u0018\u001a\u001a\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u0015\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u00150\u00192\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00160\u0015H\u0087@¢\u0006\u0002\u0010\u0017R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u001b"}, d2 = {"Lcom/box/android/domain/usecases/capture/DeleteCaptureHistoryInteractor;", "Lcom/box/android/domain/usecases/capture/DeleteCaptureHistoryUseCase;", "jobService", "Lcom/box/android/domain/services/IJobService;", "localItemService", "Lcom/box/android/domain/services/ILocalItemService;", "captureHistoryFilesService", "Lcom/box/android/domain/services/ICaptureHistoryFilesService;", "idMappingService", "Lcom/box/android/domain/services/IdMappingService;", "ioDispatcher", "Lkotlinx/coroutines/CoroutineDispatcher;", "<init>", "(Lcom/box/android/domain/services/IJobService;Lcom/box/android/domain/services/ILocalItemService;Lcom/box/android/domain/services/ICaptureHistoryFilesService;Lcom/box/android/domain/services/IdMappingService;Lkotlinx/coroutines/CoroutineDispatcher;)V", "coroutineScope", "Lkotlinx/coroutines/CoroutineScope;", "deleteCaptureHistoryItems", "Lcom/box/android/domain/utils/result/Result;", "", "Lcom/box/android/domain/models/DomainError;", "captureHistoryModels", "", "Lcom/box/android/domain/models/CaptureHistoryModel;", "(Ljava/util/Set;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "partitionUploadedFileIdsAndPendingModels", "Lkotlin/Pair;", "", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeleteCaptureHistoryInteractor implements DeleteCaptureHistoryUseCase {
    private final ICaptureHistoryFilesService captureHistoryFilesService;
    private CoroutineScope coroutineScope;
    private final IdMappingService idMappingService;
    private final CoroutineDispatcher ioDispatcher;
    private final IJobService jobService;
    private final ILocalItemService localItemService;

    /* JADX INFO: renamed from: com.box.android.domain.usecases.capture.DeleteCaptureHistoryInteractor$deleteCaptureHistoryItems$1, reason: invalid class name */
    /* JADX INFO: compiled from: DeleteCaptureHistoryInteractor.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.usecases.capture.DeleteCaptureHistoryInteractor", f = "DeleteCaptureHistoryInteractor.kt", i = {0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2}, l = {37, 50, 52}, m = "deleteCaptureHistoryItems", n = {"captureHistoryModels", "failedDeletions", "historyModelsCopy", "captureHistoryModels", "failedDeletions", "historyModelsCopy", "uploadedIds", "pendingModels", "$this$forEach$iv", "element$iv", "captureHistoryModel", "$i$f$forEach", "$i$a$-forEach-DeleteCaptureHistoryInteractor$deleteCaptureHistoryItems$3", "captureHistoryModels", "failedDeletions", "historyModelsCopy", "uploadedIds", "pendingModels", "$this$forEach$iv", "element$iv", "captureHistoryModel", "$this$onSuccess$iv", "it", "$i$f$forEach", "$i$a$-forEach-DeleteCaptureHistoryInteractor$deleteCaptureHistoryItems$3", "$i$f$onSuccess", "$i$a$-onSuccess-DeleteCaptureHistoryInteractor$deleteCaptureHistoryItems$3$1"}, s = {"L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "L$8", "I$0", "I$1", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$7", "L$8", "L$9", "L$10", "I$0", "I$1", "I$2", "I$3"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
        int I$0;
        int I$1;
        int I$2;
        int I$3;
        Object L$0;
        Object L$1;
        Object L$10;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        Object L$8;
        Object L$9;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DeleteCaptureHistoryInteractor.this.deleteCaptureHistoryItems(null, this);
        }
    }

    /* JADX INFO: renamed from: com.box.android.domain.usecases.capture.DeleteCaptureHistoryInteractor$partitionUploadedFileIdsAndPendingModels$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: compiled from: DeleteCaptureHistoryInteractor.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.usecases.capture.DeleteCaptureHistoryInteractor", f = "DeleteCaptureHistoryInteractor.kt", i = {0, 0, 0, 0, 0, 0, 0, 0, 0}, l = {85}, m = "partitionUploadedFileIdsAndPendingModels", n = {"captureHistoryModels", "uploadedFileIds", "pendingModels", "$this$forEach$iv", "element$iv", "captureHistoryModel", "itemId", "$i$f$forEach", "$i$a$-forEach-DeleteCaptureHistoryInteractor$partitionUploadedFileIdsAndPendingModels$2"}, s = {"L$0", "L$1", "L$2", "L$3", "L$5", "L$6", "L$7", "I$0", "I$1"}, v = 1)
    static final class C16291 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        Object L$6;
        Object L$7;
        int label;
        /* synthetic */ Object result;

        C16291(Continuation<? super C16291> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return DeleteCaptureHistoryInteractor.this.partitionUploadedFileIdsAndPendingModels(null, this);
        }
    }

    @Inject
    public DeleteCaptureHistoryInteractor(IJobService jobService, ILocalItemService localItemService, ICaptureHistoryFilesService captureHistoryFilesService, IdMappingService idMappingService, CoroutineDispatcher ioDispatcher) {
        Intrinsics.checkNotNullParameter(jobService, "jobService");
        Intrinsics.checkNotNullParameter(localItemService, "localItemService");
        Intrinsics.checkNotNullParameter(captureHistoryFilesService, "captureHistoryFilesService");
        Intrinsics.checkNotNullParameter(idMappingService, "idMappingService");
        Intrinsics.checkNotNullParameter(ioDispatcher, "ioDispatcher");
        this.jobService = jobService;
        this.localItemService = localItemService;
        this.captureHistoryFilesService = captureHistoryFilesService;
        this.idMappingService = idMappingService;
        this.ioDispatcher = ioDispatcher;
        this.coroutineScope = CoroutineScopeKt.CoroutineScope(ioDispatcher);
    }

    /* JADX WARN: Code duplicated, block: B:24:0x0126  */
    /* JADX WARN: Code duplicated, block: B:27:0x0180  */
    /* JADX WARN: Code duplicated, block: B:30:0x0194  */
    /* JADX WARN: Code duplicated, block: B:34:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:39:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:41:0x0203  */
    /* JADX WARN: Code duplicated, block: B:42:0x020f  */
    /* JADX WARN: Code duplicated, block: B:45:0x021f  */
    /* JADX WARN: Code duplicated, block: B:7:0x001a  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:31:0x01e7 -> B:33:0x01ea). Please report as a decompilation issue!!! */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:35:0x01f8 -> B:33:0x01ea). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    @Override // com.box.android.domain.usecases.capture.DeleteCaptureHistoryUseCase
    public java.lang.Object deleteCaptureHistoryItems(java.util.Set<com.box.android.domain.models.CaptureHistoryModel> r22, kotlin.coroutines.Continuation<? super com.box.android.domain.utils.result.Result<kotlin.Unit, ? extends com.box.android.domain.models.DomainError>> r23) {
        /*
            Method dump skipped, instruction units count: 615
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.domain.usecases.capture.DeleteCaptureHistoryInteractor.deleteCaptureHistoryItems(java.util.Set, kotlin.coroutines.Continuation):java.lang.Object");
    }

    /* JADX INFO: renamed from: com.box.android.domain.usecases.capture.DeleteCaptureHistoryInteractor$deleteCaptureHistoryItems$2, reason: invalid class name */
    /* JADX INFO: compiled from: DeleteCaptureHistoryInteractor.kt */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.usecases.capture.DeleteCaptureHistoryInteractor$deleteCaptureHistoryItems$2", f = "DeleteCaptureHistoryInteractor.kt", i = {0, 0, 0, 0, 0, 1, 1, 1, 1, 1}, l = {43, 45}, m = "invokeSuspend", n = {"$this$forEach$iv", "element$iv", "it", "$i$f$forEach", "$i$a$-forEach-DeleteCaptureHistoryInteractor$deleteCaptureHistoryItems$2$1", "$this$forEach$iv", "element$iv", "it", "$i$f$forEach", "$i$a$-forEach-DeleteCaptureHistoryInteractor$deleteCaptureHistoryItems$2$1"}, s = {"L$0", "L$3", "L$4", "I$0", "I$1", "L$0", "L$3", "L$4", "I$0", "I$1"}, v = 1)
    static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ Set<String> $uploadedIds;
        int I$0;
        int I$1;
        Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        int label;
        final /* synthetic */ DeleteCaptureHistoryInteractor this$0;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        AnonymousClass2(Set<String> set, DeleteCaptureHistoryInteractor deleteCaptureHistoryInteractor, Continuation<? super AnonymousClass2> continuation) {
            super(2, continuation);
            this.$uploadedIds = set;
            this.this$0 = deleteCaptureHistoryInteractor;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new AnonymousClass2(this.$uploadedIds, this.this$0, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((AnonymousClass2) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:14:0x0066  */
        /* JADX WARN: Code duplicated, block: B:17:0x0099  */
        /* JADX WARN: Code duplicated, block: B:21:0x00c6  */
        /* JADX WARN: Code restructure failed: missing block: B:19:0x00c3, code lost:
        
            if (r10.updateLastUpdatedDate(r8, r12) == r0) goto L20;
         */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:19:0x00c3 -> B:7:0x0024). Please report as a decompilation issue!!! */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                Method dump skipped, instruction units count: 201
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.domain.usecases.capture.DeleteCaptureHistoryInteractor.AnonymousClass2.invokeSuspend(java.lang.Object):java.lang.Object");
        }
    }

    /* JADX WARN: Code duplicated, block: B:17:0x007f  */
    /* JADX WARN: Code duplicated, block: B:19:0x00bc A[RETURN] */
    /* JADX WARN: Code duplicated, block: B:20:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:23:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:24:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:7:0x0018  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:20:0x00bd -> B:21:0x00c3). Please report as a decompilation issue!!! */
    /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
        jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
        	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
        	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
        	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
        */
    public final java.lang.Object partitionUploadedFileIdsAndPendingModels(java.util.Set<com.box.android.domain.models.CaptureHistoryModel> r18, kotlin.coroutines.Continuation<? super kotlin.Pair<? extends java.util.Set<java.lang.String>, ? extends java.util.Set<com.box.android.domain.models.CaptureHistoryModel>>> r19) {
        /*
            Method dump skipped, instruction units count: 235
            To view this dump add '--comments-level debug' option
        */
        throw new UnsupportedOperationException("Method not decompiled: com.box.android.domain.usecases.capture.DeleteCaptureHistoryInteractor.partitionUploadedFileIdsAndPendingModels(java.util.Set, kotlin.coroutines.Continuation):java.lang.Object");
    }
}

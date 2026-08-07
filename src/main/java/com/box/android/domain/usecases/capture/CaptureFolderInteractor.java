package com.box.android.domain.usecases.capture;

import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.services.ICapturePreferencesService;
import com.box.android.domain.services.IJobService;
import com.box.android.domain.services.IdMappingService;
import com.box.android.domain.utils.result.Result;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFolder;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.FlowKt;

/* JADX INFO: compiled from: CaptureFolderInteractor.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001b2\u00020\u0001:\u0001\u001bB1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u001a\u0010\u0016\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0019\u0012\u0004\u0012\u00020\u001a0\u00180\u0017H\u0016R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0005¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015¨\u0006\u001c"}, d2 = {"Lcom/box/android/domain/usecases/capture/CaptureFolderInteractor;", "Lcom/box/android/domain/usecases/capture/CaptureFolderUseCase;", "jobService", "Lcom/box/android/domain/services/IJobService;", "capturePreferencesService", "Lcom/box/android/domain/services/ICapturePreferencesService;", "captureLocalItemsUseCase", "Lcom/box/android/domain/usecases/capture/CaptureLocalItemsUseCase;", "boxExtendedApiFolder", "Lcom/box/boxandroidlibv2private/resourcemanagers/BoxExtendedApiFolder;", "idMappingService", "Lcom/box/android/domain/services/IdMappingService;", "<init>", "(Lcom/box/android/domain/services/IJobService;Lcom/box/android/domain/services/ICapturePreferencesService;Lcom/box/android/domain/usecases/capture/CaptureLocalItemsUseCase;Lcom/box/boxandroidlibv2private/resourcemanagers/BoxExtendedApiFolder;Lcom/box/android/domain/services/IdMappingService;)V", "getJobService", "()Lcom/box/android/domain/services/IJobService;", "getCapturePreferencesService", "()Lcom/box/android/domain/services/ICapturePreferencesService;", "getBoxExtendedApiFolder", "()Lcom/box/boxandroidlibv2private/resourcemanagers/BoxExtendedApiFolder;", "getIdMappingService", "()Lcom/box/android/domain/services/IdMappingService;", "getCaptureFolder", "Lkotlinx/coroutines/flow/Flow;", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/item/FolderModel;", "Lcom/box/android/domain/models/DomainError;", "Companion", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CaptureFolderInteractor implements CaptureFolderUseCase {
    public static final String DEFAULT_CAPTURE_FOLDER_NAME = "Capture Uploads";
    private final BoxExtendedApiFolder boxExtendedApiFolder;
    private final CaptureLocalItemsUseCase captureLocalItemsUseCase;
    private final ICapturePreferencesService capturePreferencesService;
    private final IdMappingService idMappingService;
    private final IJobService jobService;

    @Inject
    public CaptureFolderInteractor(IJobService jobService, ICapturePreferencesService capturePreferencesService, CaptureLocalItemsUseCase captureLocalItemsUseCase, BoxExtendedApiFolder boxExtendedApiFolder, IdMappingService idMappingService) {
        Intrinsics.checkNotNullParameter(jobService, "jobService");
        Intrinsics.checkNotNullParameter(capturePreferencesService, "capturePreferencesService");
        Intrinsics.checkNotNullParameter(captureLocalItemsUseCase, "captureLocalItemsUseCase");
        Intrinsics.checkNotNullParameter(boxExtendedApiFolder, "boxExtendedApiFolder");
        Intrinsics.checkNotNullParameter(idMappingService, "idMappingService");
        this.jobService = jobService;
        this.capturePreferencesService = capturePreferencesService;
        this.captureLocalItemsUseCase = captureLocalItemsUseCase;
        this.boxExtendedApiFolder = boxExtendedApiFolder;
        this.idMappingService = idMappingService;
    }

    public final IJobService getJobService() {
        return this.jobService;
    }

    public final ICapturePreferencesService getCapturePreferencesService() {
        return this.capturePreferencesService;
    }

    public final BoxExtendedApiFolder getBoxExtendedApiFolder() {
        return this.boxExtendedApiFolder;
    }

    public final IdMappingService getIdMappingService() {
        return this.idMappingService;
    }

    /* JADX INFO: renamed from: com.box.android.domain.usecases.capture.CaptureFolderInteractor$getCaptureFolder$1, reason: invalid class name */
    /* JADX INFO: compiled from: CaptureFolderInteractor.kt */
    @Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/item/FolderModel;", "Lcom/box/android/domain/models/DomainError;"}, k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.domain.usecases.capture.CaptureFolderInteractor$getCaptureFolder$1", f = "CaptureFolderInteractor.kt", i = {0, 0, 1, 1, 2, 2, 2, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 5, 5, 5, 5, 5, 5, 6, 6, 6, 6, 6, 6}, l = {55, 59, 68, 85, 89, 95, 99}, m = "invokeSuspend", n = {"$this$flow", "defaultFolderId", "$this$flow", "defaultFolderId", "$this$flow", "defaultFolderId", "defaultFolder", "$this$flow", "defaultFolderId", "defaultFolder", "rootFolderItems", "cachedFolder", "$this$flow", "defaultFolderId", "defaultFolder", "rootFolderItems", "cachedFolder", "$this$flow", "defaultFolderId", "defaultFolder", "rootFolderItems", "cachedFolder", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "$this$flow", "defaultFolderId", "defaultFolder", "rootFolderItems", "cachedFolder", ReactNativeFeatureActivity.RESULT_EXTRA_KEY}, s = {"L$0", "L$1", "L$0", "L$1", "L$0", "L$1", "L$2", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$0", "L$1", "L$2", "L$3", "L$4", "L$5"}, v = 1)
    static final class AnonymousClass1 extends SuspendLambda implements Function2<FlowCollector<? super Result<? extends FolderModel, ? extends DomainError>>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        Object L$3;
        Object L$4;
        Object L$5;
        int label;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(2, continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            AnonymousClass1 anonymousClass1 = CaptureFolderInteractor.this.new AnonymousClass1(continuation);
            anonymousClass1.L$0 = obj;
            return anonymousClass1;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Result<? extends FolderModel, ? extends DomainError>> flowCollector, Continuation<? super Unit> continuation) {
            return invoke2((FlowCollector<? super Result<FolderModel, ? extends DomainError>>) flowCollector, continuation);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Result<FolderModel, ? extends DomainError>> flowCollector, Continuation<? super Unit> continuation) {
            return ((AnonymousClass1) create(flowCollector, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Code duplicated, block: B:35:0x00eb  */
        /* JADX WARN: Code duplicated, block: B:38:0x010d  */
        /* JADX WARN: Code duplicated, block: B:44:0x012a  */
        /* JADX WARN: Code duplicated, block: B:47:0x0137  */
        /* JADX WARN: Code duplicated, block: B:54:0x0151  */
        /* JADX WARN: Code duplicated, block: B:57:0x0156  */
        /* JADX WARN: Code duplicated, block: B:58:0x0159  */
        /* JADX WARN: Code duplicated, block: B:60:0x015c  */
        /* JADX WARN: Code duplicated, block: B:61:0x0164  */
        /* JADX WARN: Code duplicated, block: B:63:0x0167  */
        /* JADX WARN: Code duplicated, block: B:66:0x0198  */
        /* JADX WARN: Code duplicated, block: B:69:0x01c6  */
        /* JADX WARN: Code duplicated, block: B:72:0x01d2  */
        /* JADX WARN: Code duplicated, block: B:75:0x020e  */
        /* JADX WARN: Code duplicated, block: B:77:0x0212  */
        /* JADX WARN: Code duplicated, block: B:82:0x0246  */
        /* JADX WARN: Code duplicated, block: B:89:0x014d A[SYNTHETIC] */
        /* JADX WARN: Code restructure failed: missing block: B:15:0x0080, code lost:
        
            if (r13 == r1) goto L79;
         */
        /* JADX WARN: Code restructure failed: missing block: B:26:0x00c4, code lost:
        
            if (r13 == r1) goto L79;
         */
        /* JADX WARN: Code restructure failed: missing block: B:36:0x0109, code lost:
        
            if (invokeSuspend$observeUploadFolderCreationJob(r0, r12.this$0, r13, r12) == r1) goto L79;
         */
        /* JADX WARN: Code restructure failed: missing block: B:64:0x0194, code lost:
        
            if (r0.emit(new com.box.android.domain.utils.result.Result.Success(r3), r12) == r1) goto L79;
         */
        /* JADX WARN: Code restructure failed: missing block: B:73:0x020b, code lost:
        
            if (invokeSuspend$observeUploadFolderCreationJob(r0, r12.this$0, (com.box.android.domain.models.item.FolderModel) ((com.box.android.domain.utils.result.Result.Success) r13).getValue(), r12) == r1) goto L79;
         */
        /* JADX WARN: Code restructure failed: missing block: B:78:0x0240, code lost:
        
            if (r0.emit(r13, r12) == r1) goto L79;
         */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct add '--show-bad-code' argument
        */
        public final java.lang.Object invokeSuspend(java.lang.Object r13) {
            /*
                Method dump skipped, instruction units count: 614
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.domain.usecases.capture.CaptureFolderInteractor.AnonymousClass1.invokeSuspend(java.lang.Object):java.lang.Object");
        }

        /* JADX INFO: Access modifiers changed from: private */
        /* JADX WARN: Code duplicated, block: B:44:0x01cf  */
        /* JADX WARN: Code duplicated, block: B:47:0x0238  */
        /* JADX WARN: Code duplicated, block: B:7:0x001a  */
        /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:47:0x0238 -> B:19:0x00c1). Please report as a decompilation issue!!! */
        /*  JADX ERROR: JadxOverflowException in pass: RegionMakerVisitor
            jadx.core.utils.exceptions.JadxOverflowException: Regions stack size limit reached
            	at jadx.core.utils.ErrorsCounter.addError(ErrorsCounter.java:59)
            	at jadx.core.utils.ErrorsCounter.error(ErrorsCounter.java:31)
            	at jadx.core.dex.attributes.nodes.NotificationAttrNode.addError(NotificationAttrNode.java:19)
            */
        public static final java.lang.Object invokeSuspend$observeUploadFolderCreationJob(kotlinx.coroutines.flow.FlowCollector<? super com.box.android.domain.utils.result.Result<com.box.android.domain.models.item.FolderModel, ? extends com.box.android.domain.models.DomainError>> r20, com.box.android.domain.usecases.capture.CaptureFolderInteractor r21, com.box.android.domain.models.item.FolderModel r22, kotlin.coroutines.Continuation<? super kotlin.Unit> r23) {
            /*
                Method dump skipped, instruction units count: 735
                To view this dump add '--comments-level debug' option
            */
            throw new UnsupportedOperationException("Method not decompiled: com.box.android.domain.usecases.capture.CaptureFolderInteractor.AnonymousClass1.invokeSuspend$observeUploadFolderCreationJob(kotlinx.coroutines.flow.FlowCollector, com.box.android.domain.usecases.capture.CaptureFolderInteractor, com.box.android.domain.models.item.FolderModel, kotlin.coroutines.Continuation):java.lang.Object");
        }
    }

    @Override // com.box.android.domain.usecases.capture.CaptureFolderUseCase
    public Flow<Result<FolderModel, DomainError>> getCaptureFolder() {
        return FlowKt.flow(new AnonymousClass1(null));
    }
}

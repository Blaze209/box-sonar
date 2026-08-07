package com.box.android.data.service.impl.preview;

import com.box.android.common.extensions.FileExtensionsKt;
import com.box.android.coreservices.models.PreviewFile;
import com.box.android.coreservices.models.PreviewFileAttributes;
import com.box.android.coreservices.utilities.PreviewStorageExtension;
import com.box.android.data.service.impl.OfflineService;
import com.box.android.domain.controller.IPreviewController;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.WatermarkModel;
import com.box.android.domain.preview.PreviewContentType;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.androidsdk.content.utils.BoxLogUtils;
import java.io.File;
import java.net.URI;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SpillingKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviewLocalDataSource.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J \u0010\b\u001a\u0004\u0018\u00010\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0096@¢\u0006\u0002\u0010\u000eJ\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\n\u001a\u00020\u000bH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0011"}, d2 = {"Lcom/box/android/data/service/impl/preview/PreviewLocalDataSource;", "Lcom/box/android/data/service/impl/preview/PreviewDataSource;", "legacyPreviewController", "Lcom/box/android/domain/controller/IPreviewController;", "offlineService", "Lcom/box/android/data/service/impl/OfflineService;", "<init>", "(Lcom/box/android/domain/controller/IPreviewController;Lcom/box/android/data/service/impl/OfflineService;)V", "getPreviewFile", "Lcom/box/android/coreservices/models/PreviewFile;", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "previewFileAttributes", "Lcom/box/android/coreservices/models/PreviewFileAttributes;", "(Lcom/box/android/domain/models/item/FileModel;Lcom/box/android/coreservices/models/PreviewFileAttributes;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAllPreviewFiles", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PreviewLocalDataSource implements PreviewDataSource {
    private final IPreviewController legacyPreviewController;
    private final OfflineService offlineService;

    /* JADX INFO: renamed from: com.box.android.data.service.impl.preview.PreviewLocalDataSource$getPreviewFile$1, reason: invalid class name */
    /* JADX INFO: compiled from: PreviewLocalDataSource.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.preview.PreviewLocalDataSource", f = "PreviewLocalDataSource.kt", i = {0, 0, 0, 0, 0, 0, 0, 0}, l = {47}, m = "getPreviewFile", n = {"fileModel", "previewFileAttributes", "cachedBoxFile", "cachedFile", "cachedFileUri", "cachedPreviewAttrs", "previewContentType", "isWatermarked"}, s = {"L$0", "L$1", "L$2", "L$3", "L$4", "L$5", "L$6", "I$0"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
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
        Object L$8;
        int label;
        /* synthetic */ Object result;

        AnonymousClass1(Continuation<? super AnonymousClass1> continuation) {
            super(continuation);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            this.result = obj;
            this.label |= Integer.MIN_VALUE;
            return PreviewLocalDataSource.this.getPreviewFile(null, null, this);
        }
    }

    @Inject
    public PreviewLocalDataSource(IPreviewController legacyPreviewController, OfflineService offlineService) {
        Intrinsics.checkNotNullParameter(legacyPreviewController, "legacyPreviewController");
        Intrinsics.checkNotNullParameter(offlineService, "offlineService");
        this.legacyPreviewController = legacyPreviewController;
        this.offlineService = offlineService;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    @Override // com.box.android.data.service.impl.preview.PreviewDataSource
    public Object getPreviewFile(FileModel fileModel, PreviewFileAttributes previewFileAttributes, Continuation<? super PreviewFile> continuation) {
        AnonymousClass1 anonymousClass1;
        PreviewContentType previewFileOrigin;
        WatermarkModel watermark;
        PreviewFileAttributes previewFileAttributes2;
        URI uri;
        int i;
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
        Object objIsFileOfflined = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i2 = anonymousClass1.label;
        if (i2 == 0) {
            ResultKt.throwOnFailure(objIsFileOfflined);
            ItemModel metadata = this.legacyPreviewController.getStorage().getMetadata(fileModel, "doc", previewFileAttributes.getPreviewFileOrigin());
            FileModel fileModel2 = (FileModel) metadata;
            if (!Intrinsics.areEqual(fileModel2 != null ? fileModel2.getSha1() : null, fileModel.getSha1())) {
                metadata = null;
            }
            FileModel fileModel3 = (FileModel) metadata;
            if (fileModel3 == null) {
                return null;
            }
            File cachedPreviewFile = this.legacyPreviewController.getStorage().getCachedPreviewFile(fileModel, (String) null, previewFileAttributes.getPreviewFileOrigin());
            Intrinsics.checkNotNull(cachedPreviewFile);
            URI uriIfExist = FileExtensionsKt.getUriIfExist(cachedPreviewFile);
            if (uriIfExist == null) {
                return null;
            }
            PreviewFileAttributes previewFileAttributesExtractPreviewFileAttributes = PreviewStorageExtension.INSTANCE.extractPreviewFileAttributes(cachedPreviewFile);
            if (previewFileAttributesExtractPreviewFileAttributes == null || (previewFileOrigin = previewFileAttributesExtractPreviewFileAttributes.getPreviewFileOrigin()) == null) {
                previewFileOrigin = previewFileAttributes.getPreviewFileOrigin();
                BoxLogUtils.e(ExtensionsKt.getTAG(this), "Preview content type is not available for file " + fileModel.getItemId());
            }
            int i3 = (Intrinsics.areEqual(previewFileOrigin, PreviewContentType.Original.INSTANCE) || (watermark = fileModel3.getWatermark()) == null || !watermark.isWatermarked()) ? 0 : 1;
            OfflineService offlineService = this.offlineService;
            anonymousClass1.L$0 = SpillingKt.nullOutSpilledVariable(fileModel);
            anonymousClass1.L$1 = SpillingKt.nullOutSpilledVariable(previewFileAttributes);
            anonymousClass1.L$2 = SpillingKt.nullOutSpilledVariable(fileModel3);
            anonymousClass1.L$3 = SpillingKt.nullOutSpilledVariable(cachedPreviewFile);
            anonymousClass1.L$4 = SpillingKt.nullOutSpilledVariable(uriIfExist);
            anonymousClass1.L$5 = SpillingKt.nullOutSpilledVariable(previewFileAttributesExtractPreviewFileAttributes);
            anonymousClass1.L$6 = SpillingKt.nullOutSpilledVariable(previewFileOrigin);
            anonymousClass1.L$7 = uriIfExist;
            anonymousClass1.L$8 = previewFileAttributesExtractPreviewFileAttributes;
            anonymousClass1.I$0 = i3;
            anonymousClass1.I$1 = i3;
            anonymousClass1.label = 1;
            objIsFileOfflined = offlineService.isFileOfflined(fileModel, anonymousClass1);
            if (objIsFileOfflined == coroutine_suspended) {
                return coroutine_suspended;
            }
            previewFileAttributes2 = previewFileAttributesExtractPreviewFileAttributes;
            uri = uriIfExist;
            i = i3;
        } else {
            if (i2 != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            i = anonymousClass1.I$1;
            int i4 = anonymousClass1.I$0;
            previewFileAttributes2 = (PreviewFileAttributes) anonymousClass1.L$8;
            uri = (URI) anonymousClass1.L$7;
            ResultKt.throwOnFailure(objIsFileOfflined);
        }
        return new PreviewFile(uri, previewFileAttributes2, i != 0, ((Boolean) objIsFileOfflined).booleanValue());
    }

    @Override // com.box.android.data.service.impl.preview.PreviewDataSource
    public void deleteAllPreviewFiles(FileModel fileModel) {
        Intrinsics.checkNotNullParameter(fileModel, "fileModel");
        try {
            this.legacyPreviewController.getStorage().clearPreviewCacheForFile(fileModel);
        } catch (SecurityException e) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Preview file " + fileModel.getItemId() + " deletion failed " + e);
        }
    }
}

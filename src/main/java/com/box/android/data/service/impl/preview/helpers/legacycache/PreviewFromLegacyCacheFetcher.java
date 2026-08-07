package com.box.android.data.service.impl.preview.helpers.legacycache;

import com.box.android.common.extensions.FileExtensionsKt;
import com.box.android.data.service.impl.LocalItemService;
import com.box.android.domain.configuration.DataPolicy;
import com.box.android.domain.controller.IPreviewController;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.FilePreviewDomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.preview.PreviewData;
import com.box.android.domain.utils.result.Result;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import java.io.File;
import java.io.UnsupportedEncodingException;
import java.net.URI;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviewFromLegacyCacheFetcher.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\"\u0010\n\u001a\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\r0\u000b2\u0006\u0010\u000e\u001a\u00020\u000fH\u0086@¢\u0006\u0002\u0010\u0010J \u0010\u0011\u001a\u0012\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00122\u0006\u0010\u0015\u001a\u00020\u0013H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/box/android/data/service/impl/preview/helpers/legacycache/PreviewFromLegacyCacheFetcher;", "", "itemService", "Lcom/box/android/data/service/impl/LocalItemService;", "previewerTypeLegacyCacheMapper", "Lcom/box/android/data/service/impl/preview/helpers/legacycache/PreviewerTypeLegacyCacheMapper;", "legacyPreviewController", "Lcom/box/android/domain/controller/IPreviewController;", "<init>", "(Lcom/box/android/data/service/impl/LocalItemService;Lcom/box/android/data/service/impl/preview/helpers/legacycache/PreviewerTypeLegacyCacheMapper;Lcom/box/android/domain/controller/IPreviewController;)V", RemoteConfigComponent.FETCH_FILE_NAME, "Lcom/box/android/domain/utils/result/Result;", "Lcom/box/android/domain/models/preview/PreviewData;", "Lcom/box/android/domain/models/DomainError;", "itemId", "Lcom/box/android/domain/models/ItemId;", "(Lcom/box/android/domain/models/ItemId;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getCachedFile", "Lkotlin/Pair;", "Lcom/box/android/domain/models/item/FileModel;", "Ljava/net/URI;", "fileModel", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PreviewFromLegacyCacheFetcher {
    private final LocalItemService itemService;
    private final IPreviewController legacyPreviewController;
    private final PreviewerTypeLegacyCacheMapper previewerTypeLegacyCacheMapper;

    /* JADX INFO: renamed from: com.box.android.data.service.impl.preview.helpers.legacycache.PreviewFromLegacyCacheFetcher$fetch$1, reason: invalid class name */
    /* JADX INFO: compiled from: PreviewFromLegacyCacheFetcher.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    @DebugMetadata(c = "com.box.android.data.service.impl.preview.helpers.legacycache.PreviewFromLegacyCacheFetcher", f = "PreviewFromLegacyCacheFetcher.kt", i = {0}, l = {45}, m = RemoteConfigComponent.FETCH_FILE_NAME, n = {"itemId"}, s = {"L$0"}, v = 1)
    static final class AnonymousClass1 extends ContinuationImpl {
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
            return PreviewFromLegacyCacheFetcher.this.fetch(null, this);
        }
    }

    @Inject
    public PreviewFromLegacyCacheFetcher(LocalItemService itemService, PreviewerTypeLegacyCacheMapper previewerTypeLegacyCacheMapper, IPreviewController legacyPreviewController) {
        Intrinsics.checkNotNullParameter(itemService, "itemService");
        Intrinsics.checkNotNullParameter(previewerTypeLegacyCacheMapper, "previewerTypeLegacyCacheMapper");
        Intrinsics.checkNotNullParameter(legacyPreviewController, "legacyPreviewController");
        this.itemService = itemService;
        this.previewerTypeLegacyCacheMapper = previewerTypeLegacyCacheMapper;
        this.legacyPreviewController = legacyPreviewController;
    }

    /* JADX WARN: Code duplicated, block: B:7:0x0014  */
    public final Object fetch(ItemId itemId, Continuation<? super Result<PreviewData, ? extends DomainError>> continuation) throws UnsupportedEncodingException {
        AnonymousClass1 anonymousClass1;
        FileModel first;
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
        Object objItem = anonymousClass1.result;
        Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int i = anonymousClass1.label;
        if (i == 0) {
            ResultKt.throwOnFailure(objItem);
            LocalItemService localItemService = this.itemService;
            DataPolicy dataPolicy = DataPolicy.CACHE;
            anonymousClass1.L$0 = itemId;
            anonymousClass1.label = 1;
            objItem = localItemService.item(itemId, dataPolicy, anonymousClass1);
            if (objItem == coroutine_suspended) {
                return coroutine_suspended;
            }
        } else {
            if (i != 1) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            itemId = (ItemId) anonymousClass1.L$0;
            ResultKt.throwOnFailure(objItem);
        }
        Object orNull = com.box.android.domain.utils.result.ResultKt.getOrNull((Result) objItem);
        FileModel fileModel = orNull instanceof FileModel ? (FileModel) orNull : null;
        if (fileModel == null) {
            return new Result.Error(new DomainError.NoResultFoundError("No file found for itemId = " + itemId));
        }
        Pair<FileModel, URI> cachedFile = getCachedFile(fileModel);
        if (cachedFile == null) {
            return new Result.Error(new DomainError.NoResultFoundError("No cached file found for itemId = " + itemId));
        }
        if (FileModel.INSTANCE.isWatermarked(fileModel) && ((first = cachedFile.getFirst()) == null || !FileModel.INSTANCE.isWatermarked(first))) {
            return new Result.Error(new FilePreviewDomainError.WatermarkSettingChanged(null, 1, null));
        }
        return new Result.Success(new PreviewData(cachedFile.getSecond(), this.previewerTypeLegacyCacheMapper.getPreviewerType(fileModel), true));
    }

    private final Pair<FileModel, URI> getCachedFile(FileModel fileModel) {
        FileModel fileModel2 = (FileModel) this.legacyPreviewController.getStorage().getMetadata(fileModel, "doc");
        File cachedPreviewFile = this.legacyPreviewController.getStorage().getCachedPreviewFile(fileModel, (String) null);
        URI uriIfExist = cachedPreviewFile != null ? FileExtensionsKt.getUriIfExist(cachedPreviewFile) : null;
        Pair<FileModel, URI> pair = uriIfExist != null ? TuplesKt.to(fileModel2, uriIfExist) : null;
        if (fileModel2 == null || Intrinsics.areEqual(fileModel2.getSha1(), fileModel.getSha1())) {
            return pair;
        }
        return null;
    }
}

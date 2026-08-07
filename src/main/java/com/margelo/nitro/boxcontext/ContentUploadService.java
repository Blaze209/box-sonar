package com.margelo.nitro.boxcontext;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ContentInfoService.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003JI\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2!\u0010\f\u001a\u001d\u0012\u0013\u0012\u00110\u000e¢\u0006\f\b\u000f\u0012\b\b\u0010\u0012\u0004\b\b(\u0011\u0012\u0004\u0012\u00020\u00060\rH\u0016¨\u0006\u0012"}, d2 = {"Lcom/margelo/nitro/boxcontext/ContentUploadService;", "Lcom/margelo/nitro/boxcontext/HybridContentUploadServiceSpec;", "<init>", "()V", "startUpload", "Lkotlin/Function0;", "", "itemId", "Lcom/margelo/nitro/boxcontext/ItemIdentifier;", "itemName", "", "uploadFolderId", "onUpdate", "Lkotlin/Function1;", "Lcom/margelo/nitro/boxcontext/PendingItemUpdate;", "Lkotlin/ParameterName;", "name", "update", "cirrus_box-context_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ContentUploadService extends HybridContentUploadServiceSpec {
    /* JADX INFO: Access modifiers changed from: private */
    public static final com.margelo.nitro.boxcontext.providers.ContentUploadService startUpload$lambda$0(BoxContext.Dependencies require) {
        Intrinsics.checkNotNullParameter(require, "$this$require");
        return require.getContentUploadService();
    }

    @Override // com.margelo.nitro.boxcontext.HybridContentUploadServiceSpec
    public Function0<Unit> startUpload(ItemIdentifier itemId, String itemName, String uploadFolderId, Function1<? super PendingItemUpdate, Unit> onUpdate) {
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(itemName, "itemName");
        Intrinsics.checkNotNullParameter(uploadFolderId, "uploadFolderId");
        Intrinsics.checkNotNullParameter(onUpdate, "onUpdate");
        return ((com.margelo.nitro.boxcontext.providers.ContentUploadService) BoxContext.INSTANCE.require(new Function1() { // from class: com.margelo.nitro.boxcontext.ContentUploadService$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return ContentUploadService.startUpload$lambda$0((BoxContext.Dependencies) obj);
            }
        })).startUpload(itemId, itemName, uploadFolderId, onUpdate);
    }
}

package com.box.android.preview.previousversion;

import com.box.android.domain.models.ItemId;
import com.box.android.preview.annotations.managers.BoxPdfAnnotationManager;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviousVersionPreviewScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
final /* synthetic */ class PreviousVersionPreviewScreenKt$PreviousVersionItemPreview$1$9$1 extends FunctionReferenceImpl implements Function1<ItemId, BoxPdfAnnotationManager> {
    PreviousVersionPreviewScreenKt$PreviousVersionItemPreview$1$9$1(Object obj) {
        super(1, obj, PreviousVersionUIDependencyProvider.class, "getPdfAnnotationManager", "getPdfAnnotationManager(Lcom/box/android/domain/models/ItemId;)Lcom/box/android/preview/annotations/managers/BoxPdfAnnotationManager;", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public final BoxPdfAnnotationManager invoke(ItemId p0) {
        Intrinsics.checkNotNullParameter(p0, "p0");
        return ((PreviousVersionUIDependencyProvider) this.receiver).getPdfAnnotationManager(p0);
    }
}

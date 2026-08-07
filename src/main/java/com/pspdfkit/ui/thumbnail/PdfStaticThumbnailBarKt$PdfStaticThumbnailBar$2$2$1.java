package com.pspdfkit.ui.thumbnail;

import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final /* synthetic */ class PdfStaticThumbnailBarKt$PdfStaticThumbnailBar$2$2$1 extends FunctionReferenceImpl implements Function1<ThumbnailBarEvent, Unit> {
    public PdfStaticThumbnailBarKt$PdfStaticThumbnailBar$2$2$1(Object obj) {
        super(1, obj, ThumbnailBarStateManager.class, "onEvent", "onEvent(Lcom/pspdfkit/ui/thumbnail/ThumbnailBarEvent;)V", 0);
    }

    @Override // kotlin.jvm.functions.Function1
    public /* bridge */ /* synthetic */ Unit invoke(ThumbnailBarEvent thumbnailBarEvent) {
        invoke2(thumbnailBarEvent);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
    public final void invoke2(ThumbnailBarEvent thumbnailBarEvent) {
        thumbnailBarEvent.getClass();
        ((ThumbnailBarStateManager) this.receiver).onEvent(thumbnailBarEvent);
    }
}

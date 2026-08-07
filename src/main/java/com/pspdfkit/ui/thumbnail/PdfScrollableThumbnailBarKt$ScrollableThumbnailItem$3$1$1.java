package com.pspdfkit.ui.thumbnail;

import com.pspdfkit.internal.x7;
import kotlin.Metadata;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.FunctionReferenceImpl;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(k = 3, mv = {2, 3, 0}, xi = 48)
public final /* synthetic */ class PdfScrollableThumbnailBarKt$ScrollableThumbnailItem$3$1$1 extends FunctionReferenceImpl implements Function0<x7> {
    public PdfScrollableThumbnailBarKt$ScrollableThumbnailItem$3$1$1(Object obj) {
        super(0, obj, ThumbnailBitmap.class, "acquireLeaseOrNull", "acquireLeaseOrNull()Lcom/pspdfkit/internal/utilities/bitmap/BitmapLease;", 0);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // kotlin.jvm.functions.Function0
    public final x7 invoke() {
        return ((ThumbnailBitmap) this.receiver).acquireLeaseOrNull();
    }
}

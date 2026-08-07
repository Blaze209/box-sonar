package com.pspdfkit.ui.thumbnail;

import android.graphics.Bitmap;
import com.pspdfkit.internal.v7;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0003\u001a\u00020\u0002¢\u0006\u0004\b\u0004\u0010\u0005R\u0013\u0010\b\u001a\u0004\u0018\u00010\u00028F¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007¨\u0006\t"}, d2 = {"Lcom/pspdfkit/ui/thumbnail/ThumbnailBitmap;", "Lcom/pspdfkit/internal/v7;", "Landroid/graphics/Bitmap;", "bitmap", "<init>", "(Landroid/graphics/Bitmap;)V", "getBitmapOrNull", "()Landroid/graphics/Bitmap;", "bitmapOrNull", "sdk-nutrient"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final class ThumbnailBitmap extends v7 {
    public static final int $stable = 8;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public ThumbnailBitmap(Bitmap bitmap) {
        super(bitmap);
        bitmap.getClass();
    }

    public final Bitmap getBitmapOrNull() {
        return getPeekBitmapOrNull();
    }
}

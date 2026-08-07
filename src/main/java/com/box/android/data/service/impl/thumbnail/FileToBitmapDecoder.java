package com.box.android.data.service.impl.thumbnail;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileToBitmapDecoder.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\u0018\u00002\u00020\u0001B\t\b\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0006\u001a\u00020\u0007¨\u0006\b"}, d2 = {"Lcom/box/android/data/service/impl/thumbnail/FileToBitmapDecoder;", "", "<init>", "()V", "toBitmap", "Landroid/graphics/Bitmap;", "path", "", "data_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class FileToBitmapDecoder {
    @Inject
    public FileToBitmapDecoder() {
    }

    public final Bitmap toBitmap(String path) {
        Intrinsics.checkNotNullParameter(path, "path");
        return BitmapFactory.decodeFile(path);
    }
}

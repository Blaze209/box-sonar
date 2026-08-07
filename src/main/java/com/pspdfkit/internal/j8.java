package com.pspdfkit.internal;

import android.graphics.Bitmap;
import com.pspdfkit.bookmarks.Bookmark;
import com.pspdfkit.utils.Size;
import io.reactivex.rxjava3.core.Maybe;

/* JADX INFO: loaded from: classes3.dex */
public interface j8 {
    Maybe<String> a(Bookmark bookmark);

    Maybe<Bitmap> a(Bookmark bookmark, Size size);

    String b(Bookmark bookmark);

    String c(Bookmark bookmark);
}

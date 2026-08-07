package com.pspdfkit.bookmarks;

import com.pspdfkit.internal.cm;
import com.pspdfkit.internal.lm;

/* JADX INFO: loaded from: classes3.dex */
public class BookmarkProviderFactory {
    public static cm fromInternalDocument(lm lmVar) {
        return new BookmarkProviderImpl(lmVar);
    }
}

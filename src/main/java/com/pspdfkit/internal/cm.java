package com.pspdfkit.internal;

import com.pspdfkit.bookmarks.BookmarkProvider;

/* JADX INFO: loaded from: classes3.dex */
public interface cm extends BookmarkProvider {
    void markBookmarksAsSavedToDisk();

    void prepareToSave();
}

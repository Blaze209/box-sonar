package com.pspdfkit.bookmarks;

import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface BookmarkProvider {

    public interface BookmarkListener {
        default void onBookmarkAdded(Bookmark bookmark) {
        }

        void onBookmarksChanged(List<Bookmark> list);
    }

    boolean addBookmark(Bookmark bookmark);

    Completable addBookmarkAsync(Bookmark bookmark);

    void addBookmarkListener(BookmarkListener bookmarkListener);

    List<Bookmark> getBookmarks();

    Observable<List<Bookmark>> getBookmarksAsync();

    boolean hasUnsavedChanges();

    boolean removeBookmark(Bookmark bookmark);

    Completable removeBookmarkAsync(Bookmark bookmark);

    void removeBookmarkListener(BookmarkListener bookmarkListener);
}

package com.pspdfkit.ui.outline;

import com.pspdfkit.bookmarks.Bookmark;
import com.pspdfkit.bookmarks.BookmarkProvider;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public interface BookmarkViewAdapter {
    void addBookmarkListener(BookmarkProvider.BookmarkListener bookmarkListener);

    default boolean canRemoveBookmark(Bookmark bookmark) {
        return true;
    }

    List<Bookmark> getBookmarks();

    boolean isBookmarkAddButtonEnabled();

    void onBookmarkAdd();

    void onBookmarkClicked(Bookmark bookmark);

    void onBookmarkNameSet(Bookmark bookmark, String str);

    void onBookmarkPositionSet(Bookmark bookmark, int i);

    boolean onBookmarkRemove(Bookmark bookmark);

    void removeBookmarkListener(BookmarkProvider.BookmarkListener bookmarkListener);
}

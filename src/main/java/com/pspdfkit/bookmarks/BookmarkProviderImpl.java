package com.pspdfkit.bookmarks;

import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.pspdfkit.internal.cm;
import com.pspdfkit.internal.go;
import com.pspdfkit.internal.h60;
import com.pspdfkit.internal.jni.NativeBookmark;
import com.pspdfkit.internal.jni.NativeBookmarkManager;
import com.pspdfkit.internal.jni.NativeResult;
import com.pspdfkit.internal.lm;
import com.pspdfkit.internal.uw;
import com.pspdfkit.utils.PdfLog;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.core.ObservableSource;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Supplier;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes3.dex */
final class BookmarkProviderImpl implements cm, Bookmark.OnBookmarkUpdatedListener {
    private BookmarkCache cache;
    private final lm document;
    private final String LOG_TAG = "Nutri.BookmarkProvImpl";
    private final go<BookmarkProvider.BookmarkListener> bookmarkListeners = new go<>();
    private boolean dirty = false;

    public static class BookmarkCache {
        private final List<Bookmark> bookmarks;
        private final Map<String, NativeBookmark> nativeBookmarks;

        private BookmarkCache(List<Bookmark> list, Map<String, NativeBookmark> map, Bookmark.OnBookmarkUpdatedListener onBookmarkUpdatedListener) {
            this.bookmarks = list;
            Iterator<Bookmark> it = list.iterator();
            while (it.hasNext()) {
                it.next().setOnBookmarkUpdatedListener(onBookmarkUpdatedListener);
            }
            this.nativeBookmarks = map;
        }

        public static BookmarkCache createFromNative(NativeBookmarkManager nativeBookmarkManager, Bookmark.OnBookmarkUpdatedListener onBookmarkUpdatedListener) {
            ArrayList<NativeBookmark> bookmarks = nativeBookmarkManager.getBookmarks();
            ArrayList arrayList = new ArrayList(bookmarks.size());
            HashMap map = new HashMap();
            int size = bookmarks.size();
            int i = 0;
            while (i < size) {
                NativeBookmark nativeBookmark = bookmarks.get(i);
                i++;
                NativeBookmark nativeBookmark2 = nativeBookmark;
                arrayList.add(new Bookmark(nativeBookmark2.getId(), nativeBookmark2.getName(), nativeBookmark2.getPageIndex(), nativeBookmark2.getSortKey()));
                map.put(nativeBookmark2.getId(), nativeBookmark2);
            }
            return new BookmarkCache(arrayList, map, onBookmarkUpdatedListener);
        }

        public boolean exists(Bookmark bookmark) {
            return this.nativeBookmarks.containsKey(bookmark.getUuid());
        }
    }

    public BookmarkProviderImpl(lm lmVar) {
        this.document = lmVar;
    }

    private BookmarkCache getBookmarkCache() {
        BookmarkCache bookmarkCache;
        synchronized (this) {
            if (this.cache == null) {
                this.cache = BookmarkCache.createFromNative(this.document.y.getBookmarkManager(), this);
            }
            bookmarkCache = this.cache;
        }
        return bookmarkCache;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ ObservableSource lambda$getBookmarksAsync$0() throws Throwable {
        return Observable.just(getBookmarks());
    }

    private void notifyBookmarksChanged() {
        final ArrayList arrayList = new ArrayList(getBookmarkCache().bookmarks);
        Collections.sort(arrayList);
        for (final BookmarkProvider.BookmarkListener bookmarkListener : this.bookmarkListeners) {
            h60.a(new Runnable() { // from class: com.pspdfkit.bookmarks.BookmarkProviderImpl$$ExternalSyntheticLambda1
                @Override // java.lang.Runnable
                public final void run() {
                    bookmarkListener.onBookmarksChanged(arrayList);
                }
            });
        }
    }

    @Override // com.pspdfkit.bookmarks.BookmarkProvider
    /* JADX INFO: renamed from: addBookmark, reason: merged with bridge method [inline-methods] */
    public boolean lambda$addBookmarkAsync$1(Bookmark bookmark) {
        uw.a(bookmark, "bookmark", null);
        if (bookmark.getPageIndex() == null) {
            throw new IllegalArgumentException("Page must be set on new bookmarks!");
        }
        synchronized (this) {
            BookmarkCache bookmarkCache = getBookmarkCache();
            if (bookmarkCache.exists(bookmark)) {
                PdfLog.w("Nutri.BookmarkProvImpl", "Attempted to add already added bookmark (id %s already exists), skipping...", bookmark.getUuid());
                return false;
            }
            this.dirty = true;
            NativeBookmark nativeBookmarkCreateBookmark = NativeBookmark.createBookmark(bookmark.getUuid(), bookmark.getPageIndex().intValue(), bookmark.getName(), bookmark.getSortKey());
            NativeResult nativeResultAddBookmark = this.document.y.getBookmarkManager().addBookmark(nativeBookmarkCreateBookmark);
            if (nativeResultAddBookmark.getHasError()) {
                PdfLog.e("Nutri.BookmarkProvImpl", "Failed to add bookmark %s to document!", bookmark.getUuid());
                throw new IllegalStateException(nativeResultAddBookmark.getErrorString());
            }
            bookmarkCache.nativeBookmarks.put(bookmark.getUuid(), nativeBookmarkCreateBookmark);
            bookmarkCache.bookmarks.add(bookmark);
            bookmark.setOnBookmarkUpdatedListener(this);
            notifyBookmarksChanged();
            return true;
        }
    }

    @Override // com.pspdfkit.bookmarks.BookmarkProvider
    public Completable addBookmarkAsync(final Bookmark bookmark) {
        uw.a(bookmark, "bookmark", null);
        return Completable.fromAction(new Action() { // from class: com.pspdfkit.bookmarks.BookmarkProviderImpl$$ExternalSyntheticLambda0
            @Override // io.reactivex.rxjava3.functions.Action
            public final void run() throws Throwable {
                this.f$0.lambda$addBookmarkAsync$1(bookmark);
            }
        }).subscribeOn(this.document.b(5));
    }

    @Override // com.pspdfkit.bookmarks.BookmarkProvider
    public void addBookmarkListener(BookmarkProvider.BookmarkListener bookmarkListener) {
        uw.a(bookmarkListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
        this.bookmarkListeners.a(bookmarkListener);
    }

    @Override // com.pspdfkit.bookmarks.BookmarkProvider
    public List<Bookmark> getBookmarks() {
        ArrayList arrayList;
        synchronized (this) {
            arrayList = new ArrayList(getBookmarkCache().bookmarks);
        }
        return arrayList;
    }

    @Override // com.pspdfkit.bookmarks.BookmarkProvider
    public Observable<List<Bookmark>> getBookmarksAsync() {
        return Observable.defer(new Supplier() { // from class: com.pspdfkit.bookmarks.BookmarkProviderImpl$$ExternalSyntheticLambda3
            @Override // io.reactivex.rxjava3.functions.Supplier
            public final Object get() {
                return this.f$0.lambda$getBookmarksAsync$0();
            }
        }).subscribeOn(this.document.b(5));
    }

    @Override // com.pspdfkit.bookmarks.BookmarkProvider
    public boolean hasUnsavedChanges() {
        synchronized (this) {
            if (this.dirty) {
                return true;
            }
            BookmarkCache bookmarkCache = this.cache;
            if (bookmarkCache == null) {
                return false;
            }
            Iterator it = bookmarkCache.bookmarks.iterator();
            while (it.hasNext()) {
                if (((Bookmark) it.next()).isDirty()) {
                    return true;
                }
            }
            return false;
        }
    }

    @Override // com.pspdfkit.internal.cm
    public void markBookmarksAsSavedToDisk() {
        synchronized (this) {
            this.dirty = false;
        }
    }

    @Override // com.pspdfkit.bookmarks.Bookmark.OnBookmarkUpdatedListener
    public void onBookmarkUpdated(Bookmark bookmark) {
        notifyBookmarksChanged();
    }

    @Override // com.pspdfkit.internal.cm
    public void prepareToSave() {
        synchronized (this) {
            BookmarkCache bookmarkCache = this.cache;
            if (bookmarkCache == null) {
                return;
            }
            for (Bookmark bookmark : bookmarkCache.bookmarks) {
                if (bookmark.isDirty()) {
                    NativeBookmark nativeBookmark = (NativeBookmark) this.cache.nativeBookmarks.get(bookmark.getUuid());
                    nativeBookmark.setName(bookmark.getName());
                    nativeBookmark.setSortKey(bookmark.getSortKey());
                    bookmark.clearDirty();
                }
            }
        }
    }

    @Override // com.pspdfkit.bookmarks.BookmarkProvider
    /* JADX INFO: renamed from: removeBookmark, reason: merged with bridge method [inline-methods] */
    public boolean lambda$removeBookmarkAsync$2(Bookmark bookmark) {
        uw.a(bookmark, "bookmark", null);
        synchronized (this) {
            BookmarkCache bookmarkCache = getBookmarkCache();
            if (!bookmarkCache.exists(bookmark)) {
                PdfLog.w("Nutri.BookmarkProvImpl", "Attempted to remove non-existing bookmark (id %s), skipping...", bookmark.getUuid());
                return false;
            }
            NativeResult nativeResultRemoveBookmark = this.document.y.getBookmarkManager().removeBookmark((NativeBookmark) bookmarkCache.nativeBookmarks.get(bookmark.getUuid()));
            if (nativeResultRemoveBookmark.getHasError()) {
                PdfLog.e("Nutri.BookmarkProvImpl", "Failed to remove bookmark %s from document!", bookmark.getUuid());
                throw new IllegalStateException(nativeResultRemoveBookmark.getErrorString());
            }
            this.dirty = true;
            bookmarkCache.bookmarks.remove(bookmark);
            bookmarkCache.nativeBookmarks.remove(bookmark.getUuid());
            bookmark.setOnBookmarkUpdatedListener(null);
            notifyBookmarksChanged();
            return true;
        }
    }

    @Override // com.pspdfkit.bookmarks.BookmarkProvider
    public Completable removeBookmarkAsync(final Bookmark bookmark) {
        uw.a(bookmark, "bookmark", null);
        return Completable.fromAction(new Action() { // from class: com.pspdfkit.bookmarks.BookmarkProviderImpl$$ExternalSyntheticLambda2
            @Override // io.reactivex.rxjava3.functions.Action
            public final void run() throws Throwable {
                this.f$0.lambda$removeBookmarkAsync$2(bookmark);
            }
        }).subscribeOn(this.document.b(5));
    }

    @Override // com.pspdfkit.bookmarks.BookmarkProvider
    public void removeBookmarkListener(BookmarkProvider.BookmarkListener bookmarkListener) {
        uw.a(bookmarkListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
        this.bookmarkListeners.b(bookmarkListener);
    }
}

package com.pspdfkit.ui.outline;

import android.os.Bundle;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import com.google.android.gms.common.internal.ServiceSpecificExtraArgs;
import com.pspdfkit.analytics.Analytics;
import com.pspdfkit.bookmarks.Bookmark;
import com.pspdfkit.bookmarks.BookmarkProvider;
import com.pspdfkit.document.PdfDocument;
import com.pspdfkit.internal.ar;
import com.pspdfkit.internal.i0;
import com.pspdfkit.internal.uw;
import com.pspdfkit.internal.z50;
import com.pspdfkit.listeners.InternalDocumentListener;
import com.pspdfkit.ui.PdfFragment;
import com.pspdfkit.utils.PdfLog;
import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.functions.Action;
import io.reactivex.rxjava3.functions.Consumer;
import java.util.Collections;
import java.util.List;

/* JADX INFO: loaded from: classes3.dex */
public class DefaultBookmarkAdapter implements BookmarkViewAdapter, InternalDocumentListener, BookmarkProvider.BookmarkListener, DefaultLifecycleObserver {
    private BookmarkProvider.BookmarkListener bookmarkViewListener;
    private final PdfFragment fragment;

    public DefaultBookmarkAdapter(PdfFragment pdfFragment) {
        this.fragment = pdfFragment;
        pdfFragment.getLifecycle().addObserver(this);
        addListeners();
    }

    private void addListeners() {
        this.fragment.addDocumentListener(this);
        if (this.fragment.getDocument() != null) {
            this.fragment.getDocument().getBookmarkProvider().addBookmarkListener(this);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void lambda$onBookmarkAdd$0(Bookmark bookmark) throws Throwable {
        i0 i0VarA = ar.a();
        Bundle bundleA = z50.a(i0VarA);
        bundleA.putInt(Analytics.Data.PAGE_INDEX, bookmark.getPageIndex() != null ? bookmark.getPageIndex().intValue() : -1);
        if (bookmark.getSortKey() != null) {
            bundleA.putString("sort", bookmark.getSortKey().toString());
        }
        i0VarA.a(Analytics.Event.ADD_BOOKMARK, bundleA);
        onBookmarkAdded(bookmark);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$onBookmarkAdd$1(Throwable th) throws Throwable {
        PdfLog.e("DefaultBookmarkAdapter", th, "Failed to add bookmark.", new Object[0]);
        onBookmarksChanged(getBookmarks());
    }

    private void removeListeners() {
        this.fragment.removeDocumentListener(this);
        if (this.fragment.getDocument() != null) {
            this.fragment.getDocument().getBookmarkProvider().removeBookmarkListener(this);
        }
    }

    @Override // com.pspdfkit.ui.outline.BookmarkViewAdapter
    public void addBookmarkListener(BookmarkProvider.BookmarkListener bookmarkListener) {
        uw.a(bookmarkListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
        this.bookmarkViewListener = bookmarkListener;
        if (this.fragment.getDocument() != null) {
            this.fragment.getDocument().getBookmarkProvider().addBookmarkListener(this);
        }
        this.fragment.addDocumentListener(this);
    }

    @Override // com.pspdfkit.ui.outline.BookmarkViewAdapter
    public List<Bookmark> getBookmarks() {
        return this.fragment.getDocument() == null ? Collections.EMPTY_LIST : this.fragment.getDocument().getBookmarkProvider().getBookmarks();
    }

    @Override // com.pspdfkit.ui.outline.BookmarkViewAdapter
    public boolean isBookmarkAddButtonEnabled() {
        PdfDocument document = this.fragment.getDocument();
        int pageIndex = this.fragment.getPageIndex();
        if (document == null || pageIndex < 0) {
            return false;
        }
        if (this.fragment.getConfiguration().getAllowMultipleBookmarksPerPage()) {
            return true;
        }
        for (Bookmark bookmark : getBookmarks()) {
            if (bookmark.getPageIndex() != null && bookmark.getPageIndex().intValue() == pageIndex) {
                return false;
            }
        }
        return true;
    }

    @Override // com.pspdfkit.ui.outline.BookmarkViewAdapter
    public void onBookmarkAdd() {
        int pageIndex = this.fragment.getPageIndex();
        if (this.fragment.getDocument() == null || pageIndex < 0) {
            return;
        }
        final Bookmark bookmark = new Bookmark(pageIndex);
        this.fragment.getDocument().getBookmarkProvider().addBookmarkAsync(bookmark).observeOn(AndroidSchedulers.mainThread()).subscribe(new Action() { // from class: com.pspdfkit.ui.outline.DefaultBookmarkAdapter$$ExternalSyntheticLambda0
            @Override // io.reactivex.rxjava3.functions.Action
            public final void run() throws Throwable {
                this.f$0.lambda$onBookmarkAdd$0(bookmark);
            }
        }, new Consumer() { // from class: com.pspdfkit.ui.outline.DefaultBookmarkAdapter$$ExternalSyntheticLambda1
            @Override // io.reactivex.rxjava3.functions.Consumer
            public final void accept(Object obj) throws Throwable {
                this.f$0.lambda$onBookmarkAdd$1((Throwable) obj);
            }
        });
    }

    @Override // com.pspdfkit.bookmarks.BookmarkProvider.BookmarkListener
    public void onBookmarkAdded(Bookmark bookmark) {
        BookmarkProvider.BookmarkListener bookmarkListener = this.bookmarkViewListener;
        if (bookmarkListener != null) {
            bookmarkListener.onBookmarkAdded(bookmark);
        }
    }

    @Override // com.pspdfkit.ui.outline.BookmarkViewAdapter
    public void onBookmarkClicked(Bookmark bookmark) {
        Integer pageIndex = bookmark.getPageIndex();
        if (pageIndex == null) {
            return;
        }
        i0 i0VarA = ar.a();
        Bundle bundleA = z50.a(i0VarA);
        bundleA.putInt(Analytics.Data.PAGE_INDEX, bookmark.getPageIndex() != null ? bookmark.getPageIndex().intValue() : -1);
        if (bookmark.getSortKey() != null) {
            bundleA.putString("sort", bookmark.getSortKey().toString());
        }
        i0VarA.a(Analytics.Event.TAP_BOOKMARK_IN_BOOKMARK_LIST, bundleA);
        this.fragment.beginNavigation();
        this.fragment.setPageIndex(pageIndex.intValue(), true);
        this.fragment.endNavigation();
    }

    @Override // com.pspdfkit.ui.outline.BookmarkViewAdapter
    public void onBookmarkNameSet(Bookmark bookmark, String str) {
        bookmark.setName(str);
        i0 i0VarA = ar.a();
        i0VarA.getClass();
        Bundle bundle = new Bundle();
        bundle.putInt(Analytics.Data.PAGE_INDEX, bookmark.getPageIndex() != null ? bookmark.getPageIndex().intValue() : -1);
        if (bookmark.getSortKey() != null) {
            bundle.putString("sort", bookmark.getSortKey().toString());
        }
        i0VarA.a(Analytics.Event.RENAME_BOOKMARK, bundle);
    }

    @Override // com.pspdfkit.ui.outline.BookmarkViewAdapter
    public void onBookmarkPositionSet(Bookmark bookmark, int i) {
        bookmark.setSortKey(i);
        i0 i0VarA = ar.a();
        i0VarA.getClass();
        Bundle bundle = new Bundle();
        bundle.putInt(Analytics.Data.PAGE_INDEX, bookmark.getPageIndex() != null ? bookmark.getPageIndex().intValue() : -1);
        if (bookmark.getSortKey() != null) {
            bundle.putString("sort", bookmark.getSortKey().toString());
        }
        i0VarA.a(Analytics.Event.SORT_BOOKMARK, bundle);
    }

    @Override // com.pspdfkit.ui.outline.BookmarkViewAdapter
    public boolean onBookmarkRemove(Bookmark bookmark) {
        boolean z = this.fragment.getDocument() != null && this.fragment.getDocument().getBookmarkProvider().lambda$removeBookmarkAsync$2(bookmark);
        if (z) {
            i0 i0VarA = ar.a();
            Bundle bundleA = z50.a(i0VarA);
            bundleA.putInt(Analytics.Data.PAGE_INDEX, bookmark.getPageIndex() != null ? bookmark.getPageIndex().intValue() : -1);
            if (bookmark.getSortKey() != null) {
                bundleA.putString("sort", bookmark.getSortKey().toString());
            }
            i0VarA.a(Analytics.Event.REMOVE_BOOKMARK, bundleA);
        }
        return z;
    }

    @Override // com.pspdfkit.bookmarks.BookmarkProvider.BookmarkListener
    public void onBookmarksChanged(List<Bookmark> list) {
        BookmarkProvider.BookmarkListener bookmarkListener = this.bookmarkViewListener;
        if (bookmarkListener != null) {
            bookmarkListener.onBookmarksChanged(list);
        }
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onDestroy(LifecycleOwner lifecycleOwner) {
        this.fragment.getLifecycle().removeObserver(this);
    }

    @Override // com.pspdfkit.listeners.DocumentListener
    public void onDocumentLoaded(PdfDocument pdfDocument) {
        if (this.fragment.getDocument() != null) {
            pdfDocument.getBookmarkProvider().removeBookmarkListener(this);
        }
        pdfDocument.getBookmarkProvider().addBookmarkListener(this);
        onBookmarksChanged(getBookmarks());
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStart(LifecycleOwner lifecycleOwner) {
        addListeners();
    }

    @Override // androidx.lifecycle.DefaultLifecycleObserver
    public void onStop(LifecycleOwner lifecycleOwner) {
        removeListeners();
    }

    @Override // com.pspdfkit.ui.outline.BookmarkViewAdapter
    public void removeBookmarkListener(BookmarkProvider.BookmarkListener bookmarkListener) {
        uw.a(bookmarkListener, ServiceSpecificExtraArgs.CastExtraArgs.LISTENER, null);
        this.bookmarkViewListener = null;
        if (this.fragment.getDocument() != null) {
            this.fragment.getDocument().getBookmarkProvider().removeBookmarkListener(this);
        }
        this.fragment.removeDocumentListener(this);
    }
}

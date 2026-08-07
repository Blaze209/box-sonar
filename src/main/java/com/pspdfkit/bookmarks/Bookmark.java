package com.pspdfkit.bookmarks;

import android.text.TextUtils;
import com.pspdfkit.internal.q70;
import com.pspdfkit.internal.uw;
import java.util.UUID;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: loaded from: classes3.dex */
public class Bookmark implements Comparable<Bookmark> {
    private boolean isDirty;
    private String name;
    private OnBookmarkUpdatedListener onBookmarkUpdatedListener;
    private final Integer pageIndex;
    private Integer sortKey;
    private final String uuid;

    public interface OnBookmarkUpdatedListener {
        void onBookmarkUpdated(Bookmark bookmark);
    }

    public Bookmark(int i) {
        this.isDirty = false;
        this.name = null;
        this.pageIndex = Integer.valueOf(i);
        q70.a();
        String string = UUID.randomUUID().toString();
        string.getClass();
        this.uuid = string;
    }

    private void notifyBookmarkUpdated() {
        OnBookmarkUpdatedListener onBookmarkUpdatedListener = this.onBookmarkUpdatedListener;
        if (onBookmarkUpdatedListener != null) {
            onBookmarkUpdatedListener.onBookmarkUpdated(this);
        }
    }

    public synchronized void clearDirty() {
        this.isDirty = false;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof Bookmark) {
            return this.uuid.equals(((Bookmark) obj).uuid);
        }
        return false;
    }

    public synchronized String getName() {
        return this.name;
    }

    public Integer getPageIndex() {
        return this.pageIndex;
    }

    public synchronized Integer getSortKey() {
        return this.sortKey;
    }

    public String getUuid() {
        return this.uuid;
    }

    public int hashCode() {
        return this.uuid.hashCode();
    }

    public synchronized boolean isDirty() {
        return this.isDirty;
    }

    public synchronized void setName(String str) {
        if (TextUtils.equals(this.name, str)) {
            return;
        }
        this.name = str;
        this.isDirty = true;
        notifyBookmarkUpdated();
    }

    public synchronized void setOnBookmarkUpdatedListener(OnBookmarkUpdatedListener onBookmarkUpdatedListener) {
        this.onBookmarkUpdatedListener = onBookmarkUpdatedListener;
    }

    public synchronized void setSortKey(int i) {
        Integer num = this.sortKey;
        if (num == null || num.intValue() != i) {
            this.sortKey = Integer.valueOf(i);
            this.isDirty = true;
            notifyBookmarkUpdated();
        }
    }

    public synchronized String toString() {
        return "Bookmark{uuid='" + this.uuid + "', page=" + this.pageIndex + ", name='" + this.name + "', sortKey=" + this.sortKey + AbstractJsonLexerKt.END_OBJ;
    }

    @Override // java.lang.Comparable
    public synchronized int compareTo(Bookmark bookmark) {
        if (bookmark == null) {
            return 0;
        }
        if (this.sortKey != null && bookmark.getSortKey() != null) {
            return this.sortKey.compareTo(bookmark.getSortKey());
        }
        if (this.pageIndex == null || bookmark.getPageIndex() == null) {
            return 0;
        }
        return this.pageIndex.compareTo(bookmark.getPageIndex());
    }

    public Bookmark(String str, int i) {
        this.isDirty = false;
        this.name = str;
        this.pageIndex = Integer.valueOf(i);
        q70.a();
        String string = UUID.randomUUID().toString();
        string.getClass();
        this.uuid = string;
    }

    public Bookmark(String str, String str2, int i) {
        this.isDirty = false;
        uw.a(str, "uuid", null);
        this.uuid = str;
        this.name = str2;
        this.pageIndex = Integer.valueOf(i);
    }

    public Bookmark(String str, String str2, Integer num, Integer num2) {
        this.isDirty = false;
        uw.a(str, "uuid", null);
        this.uuid = str;
        this.name = str2;
        this.pageIndex = num;
        this.sortKey = num2;
    }
}

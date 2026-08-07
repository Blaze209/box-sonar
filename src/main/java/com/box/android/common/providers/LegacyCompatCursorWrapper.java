package com.box.android.common.providers;

import android.database.Cursor;
import android.database.CursorWrapper;
import android.net.Uri;
import android.text.TextUtils;
import java.util.Arrays;

/* JADX INFO: loaded from: classes10.dex */
public class LegacyCompatCursorWrapper extends CursorWrapper {
    private final int fakeDataColumn;
    private final int fakeMimeTypeColumn;
    private String mOriginalFilePath;
    private final String mimeType;
    private final Uri uriForDataColumn;

    public LegacyCompatCursorWrapper(Cursor cursor) {
        this(cursor, null);
    }

    public LegacyCompatCursorWrapper(Cursor cursor, String str) {
        this(cursor, str, null);
    }

    public LegacyCompatCursorWrapper(Cursor cursor, String str, Uri uri) {
        super(cursor);
        this.uriForDataColumn = uri;
        if (cursor.getColumnIndex("_data") >= 0) {
            this.fakeDataColumn = -1;
        } else {
            this.fakeDataColumn = cursor.getColumnCount();
        }
        if (cursor.getColumnIndex("mime_type") >= 0) {
            this.fakeMimeTypeColumn = -1;
        } else {
            int i = this.fakeDataColumn;
            if (i == -1) {
                this.fakeMimeTypeColumn = cursor.getColumnCount();
            } else {
                this.fakeMimeTypeColumn = i + 1;
            }
        }
        this.mimeType = str;
    }

    public void setOriginalFilePath(String str) {
        this.mOriginalFilePath = str;
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public int getColumnCount() {
        int columnCount = super.getColumnCount();
        if (!cursorHasDataColumn()) {
            columnCount++;
        }
        return !cursorHasMimeTypeColumn() ? columnCount + 1 : columnCount;
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public int getColumnIndex(String str) {
        if (!cursorHasDataColumn() && "_data".equalsIgnoreCase(str)) {
            return this.fakeDataColumn;
        }
        if (!cursorHasMimeTypeColumn() && "mime_type".equalsIgnoreCase(str)) {
            return this.fakeMimeTypeColumn;
        }
        return super.getColumnIndex(str);
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public String getColumnName(int i) {
        if (i == this.fakeDataColumn) {
            return "_data";
        }
        if (i == this.fakeMimeTypeColumn) {
            return "mime_type";
        }
        return super.getColumnName(i);
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public String[] getColumnNames() {
        if (cursorHasDataColumn() && cursorHasMimeTypeColumn()) {
            return super.getColumnNames();
        }
        String[] strArr = (String[]) Arrays.copyOf(super.getColumnNames(), getColumnCount());
        if (!cursorHasDataColumn()) {
            strArr[this.fakeDataColumn] = "_data";
        }
        if (!cursorHasMimeTypeColumn()) {
            strArr[this.fakeMimeTypeColumn] = "mime_type";
        }
        return strArr;
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public String getString(int i) {
        boolean zEquals = getColumnName(i).equals("_data");
        if (!cursorHasDataColumn() && i == this.fakeDataColumn) {
            Uri uri = this.uriForDataColumn;
            if (uri != null) {
                return uri.toString();
            }
            if (!zEquals || TextUtils.isEmpty(this.mOriginalFilePath)) {
                return null;
            }
            return this.mOriginalFilePath;
        }
        if (!cursorHasMimeTypeColumn() && i == this.fakeMimeTypeColumn) {
            return this.mimeType;
        }
        if (zEquals && !TextUtils.isEmpty(this.mOriginalFilePath)) {
            return this.mOriginalFilePath;
        }
        return super.getString(i);
    }

    @Override // android.database.CursorWrapper, android.database.Cursor
    public int getType(int i) {
        if (!cursorHasDataColumn() && i == this.fakeDataColumn) {
            return 3;
        }
        if (cursorHasMimeTypeColumn() || i != this.fakeMimeTypeColumn) {
            return super.getType(i);
        }
        return 3;
    }

    private boolean cursorHasDataColumn() {
        return this.fakeDataColumn == -1;
    }

    private boolean cursorHasMimeTypeColumn() {
        return this.fakeMimeTypeColumn == -1;
    }
}

package com.box.android.dao;

/* JADX INFO: loaded from: classes9.dex */
public class FileInfo {
    private String _absolutePath;
    private String _filename;
    private String _icon;
    private boolean _isFolder;
    private String _lastUpdated;
    private String _size;
    private int mId;

    public String getIcon() {
        return this._icon;
    }

    public void setIcon(String str) {
        this._icon = str;
    }

    public String getFilename() {
        return this._filename;
    }

    public void setFilename(String str) {
        this._filename = str;
    }

    public String getAbsolutePath() {
        return this._absolutePath;
    }

    public void setAbsolutePath(String str) {
        this._absolutePath = str;
        this.mId = str.hashCode();
    }

    public String getLastUpdated() {
        return this._lastUpdated;
    }

    public void setLastUpdated(String str) {
        this._lastUpdated = str;
    }

    public boolean isFolder() {
        return this._isFolder;
    }

    public void setIsFolder(boolean z) {
        this._isFolder = z;
    }

    public String getSize() {
        return this._size;
    }

    public void setSize(String str) {
        this._size = str;
    }

    public int getAbsolutePathHash() {
        return this.mId;
    }
}

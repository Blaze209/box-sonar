package com.box.android.coreservices.modelcontroller;

import com.box.android.domain.localrepo.IKeyValueStore;
import java.util.List;

/* JADX INFO: loaded from: classes9.dex */
public class BoxFolderItemsCursor<T> extends BoxTypedObjectsCursor<T> {
    private final int mNumFiles;
    private final int mNumFolders;
    private final int mNumWebLinks;

    public BoxFolderItemsCursor(List<String> list, Class<T> cls, IKeyValueStore iKeyValueStore, int i, int i2, int i3) {
        super(list, cls, iKeyValueStore);
        this.mNumFolders = i;
        this.mNumFiles = i2;
        this.mNumWebLinks = i3;
    }

    public int getNumFolders() {
        return this.mNumFolders;
    }

    public int getNumFiles() {
        return this.mNumFiles;
    }

    public int getNumWebLinks() {
        return this.mNumWebLinks;
    }
}

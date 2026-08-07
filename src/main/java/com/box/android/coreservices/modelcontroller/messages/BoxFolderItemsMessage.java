package com.box.android.coreservices.modelcontroller.messages;

import com.box.android.coreservices.modelcontroller.BoxFolderItemsCursor;
import com.box.android.coreservices.modelcontroller.BoxTypedObjectsCursor;
import com.box.android.domain.localrepo.IKeyValueStore;
import com.box.androidsdk.content.models.BoxItem;

/* JADX INFO: loaded from: classes9.dex */
public class BoxFolderItemsMessage extends BoxItemsMessage {
    private static final String EXTRA_NUM_FILES = "numfiles";
    private static final String EXTRA_NUM_FOLDERS = "numfolders";
    private static final String EXTRA_NUM_WEBLINKS = "numweblinks";

    public BoxFolderItemsMessage(IKeyValueStore iKeyValueStore, String str) {
        super(iKeyValueStore);
        setFolderId(str);
    }

    private void setFolderId(String str) {
        putExtra("folder_id", str);
    }

    public String getFolderId() {
        return getStringExtra("folder_id");
    }

    public void setNumFolders(int i) {
        putExtra(EXTRA_NUM_FOLDERS, i);
    }

    public int getNumFolders() {
        return getIntExtra(EXTRA_NUM_FOLDERS, 0);
    }

    public void setNumFiles(int i) {
        putExtra(EXTRA_NUM_FILES, i);
    }

    public int getNumFiles() {
        return getIntExtra(EXTRA_NUM_FILES, 0);
    }

    public void setNumWebLinks(int i) {
        putExtra(EXTRA_NUM_WEBLINKS, i);
    }

    public int getNumWebLinks() {
        return getIntExtra(EXTRA_NUM_WEBLINKS, 0);
    }

    @Override // com.box.android.coreservices.modelcontroller.messages.BoxTypedObjectsMessage
    protected BoxTypedObjectsCursor<BoxItem> createTypedObjectsCursor() {
        return new BoxFolderItemsCursor(getTypedIds(), getCursoredClass(), this.mKVStore, getNumFolders(), getNumFiles(), getNumWebLinks());
    }
}

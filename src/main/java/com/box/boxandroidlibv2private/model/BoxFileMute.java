package com.box.boxandroidlibv2private.model;

import com.box.androidsdk.content.models.BoxCollection;
import com.box.androidsdk.content.models.BoxFile;
import com.eclipsesource.json.JsonObject;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public class BoxFileMute extends BoxFile {
    private List<BoxCollection> mMuteCollections;

    public BoxFileMute(JsonObject jsonObject) {
        super(jsonObject);
        this.mMuteCollections = new ArrayList();
    }

    @Override // com.box.androidsdk.content.models.BoxItem
    public List<BoxCollection> getCollections() {
        return this.mMuteCollections;
    }

    public void addMuteCollection(BoxCollection boxCollection) {
        this.mMuteCollections.add(boxCollection);
    }
}

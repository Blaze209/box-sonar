package com.box.androidsdk.content.requests;

import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.models.BoxVoid;
import com.box.androidsdk.content.requests.BoxRequest;

/* JADX INFO: loaded from: classes13.dex */
public abstract class BoxRequestItemDelete<R extends BoxRequest<BoxVoid, R>> extends BoxRequest<BoxVoid, R> {
    protected BoxItem item;
    protected String mId;

    protected BoxRequestItemDelete(String str, String str2, BoxSession boxSession) {
        super(BoxVoid.class, str2, boxSession);
        this.mId = str;
        this.mRequestMethod = BoxRequest.Methods.DELETE;
    }

    protected BoxRequestItemDelete(BoxItem boxItem, String str, BoxSession boxSession) {
        super(BoxVoid.class, str, boxSession);
        this.item = boxItem;
        this.mId = boxItem.getUserId();
        this.mRequestMethod = BoxRequest.Methods.DELETE;
    }

    public String getId() {
        return this.mId;
    }

    public BoxItem getItem() {
        return this.item;
    }

    @Override // com.box.androidsdk.content.requests.BoxRequest
    public R setIfMatchEtag(String str) {
        return (R) super.setIfMatchEtag(str);
    }

    @Override // com.box.androidsdk.content.requests.BoxRequest
    public String getIfMatchEtag() {
        return super.getIfMatchEtag();
    }
}

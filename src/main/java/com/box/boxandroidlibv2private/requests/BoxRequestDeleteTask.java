package com.box.boxandroidlibv2private.requests;

import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.requests.BoxRequest;
import com.box.androidsdk.content.requests.BoxRequestItemDelete;

/* JADX INFO: loaded from: classes13.dex */
public class BoxRequestDeleteTask extends BoxRequestItemDelete<BoxRequestDeleteTask> {
    public static final String URI = "undoc/tasks/%s";

    public BoxRequestDeleteTask(String str, String str2, BoxSession boxSession) {
        super(str2, str, boxSession);
        this.mRequestMethod = BoxRequest.Methods.DELETE;
    }

    public static String getUri(String str) {
        return String.format("undoc/tasks/%s", str);
    }

    @Override // com.box.androidsdk.content.requests.BoxRequest
    protected void createHeaderMap() {
        super.createHeaderMap();
        this.mHeaderMap.put("Accept", "application/json;version=1");
    }
}

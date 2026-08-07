package com.box.boxandroidlibv2private.requests;

import com.box.androidsdk.content.models.BoxSession;

/* JADX INFO: loaded from: classes13.dex */
public class BoxRequestUpdateTaskCollaboratorAndGetTask extends BoxRequestUpdateAndGetTask {
    public BoxRequestUpdateTaskCollaboratorAndGetTask(String str, String str2, BoxSession boxSession, BoxRequestUpdateTaskCollaborator boxRequestUpdateTaskCollaborator) {
        super(str, str2, boxSession, boxRequestUpdateTaskCollaborator);
    }

    @Override // com.box.boxandroidlibv2private.requests.BoxRequestUpdateAndGetTask
    public BoxRequestUpdateTaskCollaborator getRequest() {
        return (BoxRequestUpdateTaskCollaborator) super.getRequest();
    }
}

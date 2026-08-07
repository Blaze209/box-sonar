package com.box.android.domain.controller;

import com.box.androidsdk.content.requests.BoxResponse;
import com.box.boxandroidlibv2private.model.BoxFileMute;

/* JADX INFO: loaded from: classes11.dex */
public interface ILegacyCommentsController extends ICommentsController {

    public interface CommentStatusListener {
        void onCompleted(BoxResponse<BoxFileMute> boxResponse);
    }

    void fetchCommentsMuteStatus(String str, CommentStatusListener commentStatusListener);

    void removeMuteStatus(String str);
}

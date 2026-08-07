package com.box.boxandroidlibv2private.requests;

import com.box.androidsdk.content.BoxCache;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.models.BoxCollaboration;
import com.box.androidsdk.content.models.BoxCollaborationItem;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.models.BoxVoid;
import com.box.androidsdk.content.requests.BoxRequestsShare;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.androidsdk.content.utils.BoxLogUtils;
import java.sql.SQLException;

/* JADX INFO: loaded from: classes13.dex */
public class BoxRequestDeleteCollaboration extends BoxRequestsShare.DeleteCollaboration {
    private BoxCache mCache;
    private BoxCollaboration mCollaboration;

    public BoxRequestDeleteCollaboration(BoxCache boxCache, BoxCollaboration boxCollaboration, String str, BoxSession boxSession) {
        super(boxCollaboration.getUserId(), str, boxSession);
        this.mCache = boxCache;
        this.mCollaboration = boxCollaboration;
    }

    @Override // com.box.androidsdk.content.requests.BoxRequestsShare.DeleteCollaboration, com.box.androidsdk.content.requests.BoxRequest
    protected void onSendCompleted(BoxResponse<BoxVoid> boxResponse) throws BoxException {
        super.onSendCompleted(boxResponse);
        if (boxResponse.isSuccess() && this.mCollaboration.getAccessibleBy() != null && this.mSession.getUserId().equals(this.mCollaboration.getAccessibleBy().getUserId())) {
            try {
                BoxCollaborationItem item = this.mCollaboration.getItem();
                String id = item.getUserId();
                if ("folder".equals(item.getType())) {
                    this.mCache.deleteFolder(id);
                } else if ("file".equals(item.getType())) {
                    this.mCache.deleteFile(id);
                }
            } catch (SQLException e) {
                BoxLogUtils.e("BoxRequestsShare.DeleteCollab", "Failed to delete folder", e);
            }
        }
    }

    public BoxCollaboration getCollaboration() {
        return this.mCollaboration;
    }
}

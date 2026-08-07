package com.bumptech.glide.manager;

import com.bumptech.glide.RequestManager;
import com.microsoft.intune.mam.client.app.MAMFragment;
import java.util.Collections;
import java.util.Set;

/* JADX INFO: loaded from: classes13.dex */
@Deprecated
public class RequestManagerFragment extends MAMFragment {
    @Deprecated
    public RequestManager getRequestManager() {
        return null;
    }

    @Deprecated
    public void setRequestManager(RequestManager requestManager) {
    }

    @Deprecated
    public RequestManagerTreeNode getRequestManagerTreeNode() {
        return new RequestManagerTreeNode() { // from class: com.bumptech.glide.manager.RequestManagerFragment.1
            @Override // com.bumptech.glide.manager.RequestManagerTreeNode
            public Set<RequestManager> getDescendants() {
                return Collections.emptySet();
            }
        };
    }
}

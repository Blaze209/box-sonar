package com.box.android.coreservices.api;

import android.content.Context;
import com.box.android.coreservices.models.BoxFeatures;
import com.box.android.coreservices.models.BoxIteratorInvitees;
import com.box.androidsdk.content.BoxFutureTask;
import com.box.androidsdk.content.models.BoxCollaboration;
import com.box.androidsdk.content.models.BoxCollaborationItem;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxIteratorCollaborations;
import com.box.androidsdk.content.models.BoxObject;
import com.box.androidsdk.content.models.BoxVoid;
import com.box.androidsdk.content.requests.BoxRequest;
import com.box.androidsdk.content.requests.BoxRequestUpdateSharedItem;
import com.box.androidsdk.content.requests.BoxResponseBatch;
import com.box.androidsdk.content.views.BoxAvatarView;
import java.io.Serializable;

/* JADX INFO: loaded from: classes9.dex */
public interface ShareController {
    BoxFutureTask<BoxResponseBatch> addCollaborations(BoxCollaborationItem boxCollaborationItem, BoxCollaboration.Role role, String[] strArr);

    BoxFutureTask<BoxItem> createDefaultSharedLink(BoxItem boxItem);

    BoxFutureTask<BoxVoid> deleteCollaboration(BoxCollaboration boxCollaboration);

    BoxFutureTask<BoxItem> disableShareLink(BoxItem boxItem);

    <E extends BoxObject> BoxFutureTask<E> executeRequest(Class<E> cls, BoxRequest boxRequest);

    BoxFutureTask<BoxIteratorCollaborations> fetchCollaborations(BoxCollaborationItem boxCollaborationItem);

    BoxFutureTask<BoxItem> fetchItemInfo(BoxItem boxItem);

    BoxFutureTask<BoxCollaborationItem> fetchRoles(BoxCollaborationItem boxCollaborationItem);

    <E extends BoxAvatarView.AvatarController & Serializable> E getAvatarController();

    BoxRequestUpdateSharedItem getCreatedSharedLinkRequest(BoxItem boxItem);

    String getCurrentUserId();

    BoxFutureTask<BoxIteratorInvitees> getInvitees(BoxCollaborationItem boxCollaborationItem, String str);

    BoxFutureTask<BoxFeatures> getSupportedFeatures();

    void showToast(Context context, int i);

    void showToast(Context context, CharSequence charSequence);

    BoxFutureTask<BoxCollaboration> updateCollaboration(BoxCollaboration boxCollaboration, BoxCollaboration.Role role);

    BoxFutureTask<BoxVoid> updateOwner(BoxCollaboration boxCollaboration);
}

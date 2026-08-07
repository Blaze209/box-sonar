package com.box.android.coreservices.modelcontroller.messages;

import android.os.Parcelable;
import com.box.android.coreservices.models.BoxLocalMetadata;
import com.box.android.domain.localrepo.IKeyValueStore;
import com.box.androidsdk.content.models.BoxUser;

/* JADX INFO: loaded from: classes9.dex */
public class BoxUserMessage extends BoxMessage<BoxUser> {
    public static final String ACTION_FETCH_USER_INFORMATION = "com.box.android.BoxUserMessage.fetch.user.information";
    private static final String USER_LOCAL_METADATA = "user_local_metadata";

    public BoxUserMessage() {
        setAction(ACTION_FETCH_USER_INFORMATION);
    }

    @Override // com.box.android.coreservices.modelcontroller.messages.BoxMessage
    public void setPayload(BoxUser boxUser) {
        putExtra("box_message_payload", boxUser);
    }

    /* JADX WARN: Can't rename method to resolve collision */
    @Override // com.box.android.coreservices.modelcontroller.messages.BoxMessage
    public BoxUser getPayload() {
        return (BoxUser) getSerializableExtra("box_message_payload");
    }

    public BoxLocalMetadata getLocalMetadata() {
        return (BoxLocalMetadata) getParcelableExtra(USER_LOCAL_METADATA);
    }

    public void setLocalMetadata(String str, String str2, IKeyValueStore iKeyValueStore) {
        putExtra(USER_LOCAL_METADATA, (Parcelable) ((BoxLocalMetadata) iKeyValueStore.getLocalMetadataForObject(str, str2)));
    }

    public String getUserAccount() {
        return getPayload().getLogin();
    }

    public long getSpaceUsed() {
        return getPayload().getSpaceUsed().longValue();
    }

    public long getSpaceAmount() {
        return getPayload().getSpaceAmount().longValue();
    }

    public long getUploadLimit() {
        return getPayload().getMaxUploadSize().longValue();
    }
}

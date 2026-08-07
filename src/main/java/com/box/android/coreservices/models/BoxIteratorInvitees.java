package com.box.android.coreservices.models;

import com.box.androidsdk.content.models.BoxEntity;
import com.box.androidsdk.content.models.BoxIterator;
import com.box.androidsdk.content.models.BoxJsonObject;

/* JADX INFO: loaded from: classes9.dex */
public class BoxIteratorInvitees extends BoxIterator<BoxInvitee> {
    private static final long serialVersionUID = 1900245905334373228L;
    private transient BoxJsonObject.BoxJsonObjectCreator<BoxInvitee> representationCreator;

    @Override // com.box.androidsdk.content.models.BoxIterator
    protected BoxJsonObject.BoxJsonObjectCreator<BoxInvitee> getObjectCreator() {
        BoxJsonObject.BoxJsonObjectCreator<BoxInvitee> boxJsonObjectCreator = this.representationCreator;
        if (boxJsonObjectCreator != null) {
            return boxJsonObjectCreator;
        }
        BoxJsonObject.BoxJsonObjectCreator<BoxInvitee> boxJsonObjectCreator2 = BoxEntity.getBoxJsonObjectCreator(BoxInvitee.class);
        this.representationCreator = boxJsonObjectCreator2;
        return boxJsonObjectCreator2;
    }
}

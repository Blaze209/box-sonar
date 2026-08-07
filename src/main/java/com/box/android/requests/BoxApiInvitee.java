package com.box.android.requests;

import com.box.androidsdk.content.BoxApi;
import com.box.androidsdk.content.models.BoxSession;

/* JADX INFO: loaded from: classes12.dex */
public class BoxApiInvitee extends BoxApi {
    public static final int LIMIT = 1000;

    public BoxApiInvitee(BoxSession boxSession) {
        super(boxSession);
    }

    public BoxRequestsInvitee.GetInvitees getInviteesRequest(String str) {
        BoxRequestsInvitee.GetInvitees getInvitees = new BoxRequestsInvitee.GetInvitees(str, BoxInternalApi.getInvitesUri(getBaseUri(), str), this.mSession);
        getInvitees.setLimit(1000);
        return getInvitees;
    }
}

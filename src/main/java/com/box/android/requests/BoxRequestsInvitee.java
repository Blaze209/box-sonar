package com.box.android.requests;

import com.box.android.coreservices.models.BoxIteratorInvitees;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.BoxFutureTask;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.requests.BoxCacheableRequest;
import com.box.androidsdk.content.requests.BoxRequestList;

/* JADX INFO: loaded from: classes12.dex */
public class BoxRequestsInvitee {

    public static class GetInvitees extends BoxRequestList<BoxIteratorInvitees, GetInvitees> implements BoxCacheableRequest<BoxIteratorInvitees> {
        private static final String FIELD_FILTER_TERM = "filter_term";
        private static final long serialVersionUID = 972965042279973942L;

        public GetInvitees(String str, String str2, BoxSession boxSession) {
            super(BoxIteratorInvitees.class, str, str2, boxSession);
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
        public BoxIteratorInvitees sendForCachedResult() throws BoxException {
            return (BoxIteratorInvitees) handleSendForCachedResult();
        }

        @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
        public BoxFutureTask<BoxIteratorInvitees> toTaskForCachedResult() throws BoxException {
            return handleToTaskForCachedResult();
        }

        public GetInvitees setFilterTerm(String str) {
            this.mQueryMap.put(FIELD_FILTER_TERM, str);
            return this;
        }
    }
}

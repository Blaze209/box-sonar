package com.box.boxandroidlibv2private.requests;

import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.BoxFutureTask;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.requests.BoxCacheableRequest;
import com.box.androidsdk.content.requests.BoxRequest;
import com.box.androidsdk.content.requests.BoxRequestItem;
import com.box.androidsdk.content.utils.SdkUtils;
import com.box.boxandroidlibv2private.model.BoxIteratorTaskCollaborators;
import com.box.boxandroidlibv2private.model.BoxTaskCollaborator;
import com.eclipsesource.json.JsonObject;
import java.util.Iterator;

/* JADX INFO: loaded from: classes13.dex */
public class BoxRequestGetTaskCollaborators extends BoxRequestItem<BoxIteratorTaskCollaborators, BoxRequestGetTaskCollaborators> implements BoxCacheableRequest<BoxIteratorTaskCollaborators> {
    public static final String FIELD_MARKER = "marker";
    private static final String FIELD_ROLE = "role";
    public static final String URI = "undoc/tasks/%s/task_collaborators";
    private boolean mFetchAll;

    public BoxRequestGetTaskCollaborators(String str, String str2, BoxSession boxSession) {
        super(BoxIteratorTaskCollaborators.class, str2, str, boxSession);
        this.mRequestMethod = BoxRequest.Methods.GET;
    }

    private BoxRequestGetTaskCollaborators(BoxRequestGetTaskCollaborators boxRequestGetTaskCollaborators) {
        super(boxRequestGetTaskCollaborators);
        this.mId = boxRequestGetTaskCollaborators.getId();
        this.mHintHeader = new StringBuffer(boxRequestGetTaskCollaborators.mHintHeader.toString());
    }

    public static String getUri(String str) {
        return String.format(URI, str);
    }

    private BoxRequestGetTaskCollaborators createInnerRequest() {
        return new BoxRequestGetTaskCollaborators(this);
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.box.androidsdk.content.requests.BoxRequest
    public BoxIteratorTaskCollaborators onSend() throws BoxException {
        BoxIteratorTaskCollaborators boxIteratorTaskCollaborators = (BoxIteratorTaskCollaborators) super.onSend();
        String nextMarker = boxIteratorTaskCollaborators.getNextMarker();
        if (!isFetchAll() || SdkUtils.isBlank(nextMarker)) {
            return boxIteratorTaskCollaborators;
        }
        JsonObject jsonObject = boxIteratorTaskCollaborators.toJsonObject();
        do {
            BoxIteratorTaskCollaborators boxIteratorTaskCollaborators2 = (BoxIteratorTaskCollaborators) createInnerRequest().setMarker(nextMarker).send();
            nextMarker = boxIteratorTaskCollaborators2.getNextMarker();
            Iterator<BoxTaskCollaborator> it = boxIteratorTaskCollaborators2.iterator();
            while (it.hasNext()) {
                jsonObject.get("entries").asArray().add(it.next().toJsonObject());
            }
        } while (!SdkUtils.isBlank(nextMarker));
        return new BoxIteratorTaskCollaborators(jsonObject);
    }

    public BoxRequestGetTaskCollaborators limitTaskCollaboratorsRole(String str) {
        this.mQueryMap.put("role", str);
        return this;
    }

    @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
    public BoxIteratorTaskCollaborators sendForCachedResult() throws BoxException {
        return (BoxIteratorTaskCollaborators) super.handleSendForCachedResult();
    }

    @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
    public BoxFutureTask<BoxIteratorTaskCollaborators> toTaskForCachedResult() throws BoxException {
        return super.handleToTaskForCachedResult();
    }

    public BoxRequestGetTaskCollaborators setMarker(String str) {
        this.mQueryMap.put("marker", String.valueOf(str));
        return this;
    }

    public String getMarker() {
        return this.mQueryMap.get("marker");
    }

    public boolean isFetchAll() {
        return this.mFetchAll;
    }

    public BoxRequestGetTaskCollaborators setFetchAll(boolean z) {
        this.mFetchAll = z;
        return this;
    }
}

package com.box.boxandroidlibv2private.requests;

import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.BoxFutureTask;
import com.box.androidsdk.content.models.BoxIterator;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.requests.BoxCacheableRequest;
import com.box.androidsdk.content.requests.BoxRequest;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.boxandroidlibv2private.model.BoxIteratorTasks;

/* JADX INFO: loaded from: classes13.dex */
public class BoxRequestGetInbox extends BoxRequest<BoxIteratorTasks, BoxRequestGetInbox> implements BoxCacheableRequest<BoxIteratorTasks> {
    public static final String FIELD_MARKER = "marker";
    protected static final String FIELD_TASK_COLLABORATOR_ROLE = "task_collaborator_role";
    protected static final String FIELD_TASK_COLLABORATOR_STATUS = "task_collaborator_status";
    protected static final String FIELD_TASK_LINK_TARGET_ID = "task_link_target_id";
    protected static final String FIELD_TASK_LINK_TARGET_TYPE = "task_link_target_type";
    protected static final String FIELD_TASK_STATUS = "task_status";
    public static final String STATUS_COMPLETED = "completed";
    public static final String STATUS_NOT_STARTED = "not_started";
    public static final String URI = "undoc/inbox";

    public BoxRequestGetInbox(String str, BoxSession boxSession) {
        super(BoxIteratorTasks.class, str, boxSession);
        this.mRequestMethod = BoxRequest.Methods.GET;
    }

    protected BoxRequestGetInbox(BoxRequestGetInbox boxRequestGetInbox) {
        super(boxRequestGetInbox);
    }

    public static String getUri() {
        return URI;
    }

    /* JADX INFO: Access modifiers changed from: protected */
    @Override // com.box.androidsdk.content.requests.BoxRequest
    public BoxIteratorTasks onSend() throws BoxException {
        return (BoxIteratorTasks) super.onSend();
    }

    public BoxRequestGetInbox limitTaskCollaboratorStatus(String str) {
        this.mQueryMap.put("task_collaborator_status", str);
        return this;
    }

    public BoxRequestGetInbox limitTaskStatus(String str) {
        this.mQueryMap.put(FIELD_TASK_STATUS, str);
        return this;
    }

    public BoxRequestGetInbox limitTaskCollaboratorRole(String str) {
        this.mQueryMap.put(FIELD_TASK_COLLABORATOR_ROLE, str);
        return this;
    }

    public BoxRequestGetInbox limitTaskLinkTargetType(String str) {
        this.mQueryMap.put(FIELD_TASK_LINK_TARGET_TYPE, str);
        return this;
    }

    public BoxRequestGetInbox limitTaskLinkTargetId(String str) {
        this.mQueryMap.put(FIELD_TASK_LINK_TARGET_ID, str);
        return this;
    }

    public String getTaskCollaboratorStatusLimit() {
        return this.mQueryMap.get("task_collaborator_status");
    }

    public String getTaskStatusLimit() {
        return this.mQueryMap.get(FIELD_TASK_STATUS);
    }

    public String getTaskCollaboratorRoleLimit() {
        return this.mQueryMap.get(FIELD_TASK_COLLABORATOR_ROLE);
    }

    public String getTaskLinkTargetTypeLimit() {
        return this.mQueryMap.get(FIELD_TASK_LINK_TARGET_TYPE);
    }

    public String getTaskLinkTargetIdLimit() {
        return this.mQueryMap.get(FIELD_TASK_LINK_TARGET_ID);
    }

    public BoxRequestGetInbox setLimit(int i) {
        this.mQueryMap.put(BoxIterator.FIELD_LIMIT, String.valueOf(i));
        return this;
    }

    public Integer getLimit() {
        String str = this.mQueryMap.get(BoxIterator.FIELD_LIMIT);
        if (str != null) {
            try {
                return Integer.valueOf(Integer.parseInt(str));
            } catch (NumberFormatException unused) {
            }
        }
        return null;
    }

    public BoxRequestGetInbox setMarker(String str) {
        this.mQueryMap.put("marker", str);
        return this;
    }

    public String getMarker() {
        return this.mQueryMap.get("marker");
    }

    @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
    public BoxIteratorTasks sendForCachedResult() throws BoxException {
        return (BoxIteratorTasks) super.handleSendForCachedResult();
    }

    @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
    public BoxFutureTask<BoxIteratorTasks> toTaskForCachedResult() throws BoxException {
        return super.handleToTaskForCachedResult();
    }

    @Override // com.box.androidsdk.content.requests.BoxRequest
    protected void onSendCompleted(BoxResponse<BoxIteratorTasks> boxResponse) throws BoxException {
        super.onSendCompleted(boxResponse);
        super.handleUpdateCache(boxResponse);
    }
}

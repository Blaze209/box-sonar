package com.box.boxandroidlibv2private.requests;

import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.BoxFutureTask;
import com.box.androidsdk.content.models.BoxSession;
import com.box.androidsdk.content.requests.BoxCacheableRequest;
import com.box.androidsdk.content.requests.BoxRequest;
import com.box.androidsdk.content.requests.BoxRequestItem;
import com.box.androidsdk.content.utils.SdkUtils;
import com.box.boxandroidlibv2private.model.BoxIteratorTaskCollaborators;
import com.box.boxandroidlibv2private.model.BoxTask;
import com.box.boxandroidlibv2private.model.BoxTaskCollaborator;
import com.box.boxandroidlibv2private.resourcemanagers.BoxApiPrivate;

/* JADX INFO: loaded from: classes13.dex */
public class BoxRequestUpdateTaskCollaborator extends BoxRequestItem<BoxTaskCollaborator, BoxRequestUpdateTaskCollaborator> implements BoxCacheableRequest<BoxTaskCollaborator> {
    protected static final String FIELD_STATUS = "status";
    public static final String URI = "undoc/task_collaborators/%s";
    private BoxApiPrivate mApiPrivate;
    private boolean mNeedsToFetchTaskCollabs;
    private String mTaskId;

    public BoxRequestUpdateTaskCollaborator(String str, String str2, String str3, BoxSession boxSession) {
        super(BoxTaskCollaborator.class, str2, str, boxSession);
        this.mNeedsToFetchTaskCollabs = false;
        this.mBodyMap.put("status", str3);
        this.mRequestMethod = BoxRequest.Methods.PUT;
    }

    public BoxRequestUpdateTaskCollaborator(BoxTask boxTask, String str, BoxSession boxSession, BoxApiPrivate boxApiPrivate) {
        super(BoxTaskCollaborator.class, getUserTaskCollaboratorId(boxTask, boxSession.getUserId()), null, boxSession);
        this.mNeedsToFetchTaskCollabs = false;
        this.mBodyMap.put("status", str);
        this.mRequestMethod = BoxRequest.Methods.PUT;
        this.mTaskId = boxTask.getUserId();
        this.mApiPrivate = boxApiPrivate;
        boolean zIsBlank = SdkUtils.isBlank(getId());
        this.mNeedsToFetchTaskCollabs = zIsBlank;
        if (zIsBlank) {
            return;
        }
        String userTaskCollaboratorId = getUserTaskCollaboratorId(boxTask, boxSession.getUserId());
        this.mRequestUrlString = this.mApiPrivate.getApiUrl(getUri(userTaskCollaboratorId));
        this.mId = userTaskCollaboratorId;
    }

    static String getUserTaskCollaboratorId(BoxTask boxTask, String str) {
        return getTaskCollaboratorId(boxTask.getAssignmentCollaborators(), str);
    }

    static String getTaskCollaboratorId(BoxIteratorTaskCollaborators boxIteratorTaskCollaborators, String str) {
        if (boxIteratorTaskCollaborators == null) {
            return null;
        }
        for (BoxTaskCollaborator boxTaskCollaborator : boxIteratorTaskCollaborators) {
            if (boxTaskCollaborator.getTarget().getUserId().equals(str)) {
                return boxTaskCollaborator.getUserId();
            }
        }
        return null;
    }

    public static String getUri(String str) {
        return String.format(URI, str);
    }

    public String getStatus() {
        return (String) this.mBodyMap.get("status");
    }

    /* JADX INFO: Access modifiers changed from: protected */
    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.box.androidsdk.content.requests.BoxRequest
    public BoxTaskCollaborator onSend() throws BoxException {
        if (this.mNeedsToFetchTaskCollabs) {
            String taskCollaboratorId = getTaskCollaboratorId((BoxIteratorTaskCollaborators) this.mApiPrivate.getTaskCollaborators(this.mTaskId).setFetchAll(true).send(), getSession().getUserId());
            if (SdkUtils.isBlank(taskCollaboratorId)) {
                throw new BoxException("Collaborator not found as part of this task!");
            }
            this.mId = taskCollaboratorId;
            this.mRequestUrlString = this.mApiPrivate.getApiUrl(getUri(taskCollaboratorId));
        }
        return (BoxTaskCollaborator) super.onSend();
    }

    @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
    public BoxTaskCollaborator sendForCachedResult() throws BoxException {
        return (BoxTaskCollaborator) super.handleSendForCachedResult();
    }

    @Override // com.box.androidsdk.content.requests.BoxCacheableRequest
    public BoxFutureTask<BoxTaskCollaborator> toTaskForCachedResult() throws BoxException {
        return super.handleToTaskForCachedResult();
    }
}

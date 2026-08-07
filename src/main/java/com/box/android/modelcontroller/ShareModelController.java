package com.box.android.modelcontroller;

import android.content.Context;
import android.widget.Toast;
import com.box.android.coreservices.api.ShareController;
import com.box.android.coreservices.models.BoxFeatures;
import com.box.android.coreservices.models.BoxIteratorInvitees;
import com.box.android.data.controller.impl.BaseModelController;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.requests.BoxApiFeatures;
import com.box.android.requests.BoxApiInvitee;
import com.box.androidsdk.content.BoxApiBookmark;
import com.box.androidsdk.content.BoxFutureTask;
import com.box.androidsdk.content.models.BoxBookmark;
import com.box.androidsdk.content.models.BoxCollaboration;
import com.box.androidsdk.content.models.BoxCollaborationItem;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxIteratorCollaborations;
import com.box.androidsdk.content.models.BoxObject;
import com.box.androidsdk.content.models.BoxVoid;
import com.box.androidsdk.content.requests.BoxRequest;
import com.box.androidsdk.content.requests.BoxRequestBatch;
import com.box.androidsdk.content.requests.BoxRequestUpdateSharedItem;
import com.box.androidsdk.content.requests.BoxResponseBatch;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.androidsdk.content.utils.SdkUtils;
import com.box.androidsdk.content.views.BoxAvatarView;
import com.box.boxandroidlibv2private.resourcemanagers.BoxApiPrivate;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiCollaboration;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFile;
import com.box.boxandroidlibv2private.resourcemanagers.BoxExtendedApiFolder;
import java.io.Serializable;
import java.util.Arrays;
import java.util.concurrent.ThreadPoolExecutor;
import javax.inject.Inject;
import javax.inject.Singleton;

/* JADX INFO: loaded from: classes12.dex */
@Singleton
public class ShareModelController extends BaseModelController implements ShareController {
    BoxApiBookmark mBookmarkApi;
    private String[] mBookmarkShareFields;
    BoxExtendedApiCollaboration mCollabApi;
    BoxApiFeatures mFeaturesApi;
    BoxExtendedApiFile mFileApi;
    private String[] mFileShareFields;
    BoxExtendedApiFolder mFolderApi;
    private String[] mFolderShareFields;
    BoxApiInvitee mInviteeApi;

    @Inject
    public ShareModelController(IUserContextManager iUserContextManager, Context context, BoxExtendedApiFolder boxExtendedApiFolder, BoxExtendedApiFile boxExtendedApiFile, BoxApiBookmark boxApiBookmark, BoxApiInvitee boxApiInvitee, BoxExtendedApiCollaboration boxExtendedApiCollaboration, BoxApiFeatures boxApiFeatures) {
        super(iUserContextManager, context);
        this.mFolderShareFields = initializeShareFieldsArray(BoxApiPrivate.FOLDER_FIELDS);
        this.mFileShareFields = initializeShareFieldsArray(BoxFile.ALL_FIELDS);
        this.mBookmarkShareFields = initializeShareFieldsArray(BoxBookmark.ALL_FIELDS);
        this.mFolderApi = boxExtendedApiFolder;
        this.mFileApi = boxExtendedApiFile;
        this.mBookmarkApi = boxApiBookmark;
        this.mInviteeApi = boxApiInvitee;
        this.mCollabApi = boxExtendedApiCollaboration;
        this.mFeaturesApi = boxApiFeatures;
    }

    private String[] initializeShareFieldsArray(String[] strArr) {
        String[] strArr2 = (String[]) Arrays.copyOf(strArr, strArr.length + 3);
        strArr2[strArr.length] = BoxItem.FIELD_ALLOWED_SHARED_LINK_ACCESS_LEVELS;
        strArr2[strArr.length + 1] = BoxCollaborationItem.FIELD_DEFAULT_INVITEE_ROLE;
        strArr2[strArr.length + 2] = BoxCollaborationItem.FIELD_ALLOWED_INVITEE_ROLES;
        return strArr2;
    }

    @Override // com.box.android.coreservices.api.ShareController
    public BoxFutureTask<BoxItem> fetchItemInfo(BoxItem boxItem) {
        BoxRequest fields;
        if (boxItem instanceof BoxFile) {
            fields = this.mFileApi.getInfoRequest(boxItem.getUserId()).setFields(this.mFileShareFields);
        } else if (boxItem instanceof BoxFolder) {
            fields = this.mFolderApi.getInfoRequest(boxItem.getUserId()).setFields(this.mFolderShareFields);
        } else {
            fields = boxItem instanceof BoxBookmark ? this.mBookmarkApi.getInfoRequest(boxItem.getUserId()).setFields(this.mBookmarkShareFields) : null;
        }
        BoxFutureTask<BoxItem> boxFutureTask = new BoxFutureTask<>(BoxItem.class, fields);
        getApiExecutor().submit(boxFutureTask);
        return boxFutureTask;
    }

    /* JADX WARN: Multi-variable type inference failed */
    @Override // com.box.android.coreservices.api.ShareController
    public BoxRequestUpdateSharedItem getCreatedSharedLinkRequest(BoxItem boxItem) {
        if (boxItem instanceof BoxFile) {
            return (BoxRequestUpdateSharedItem) this.mFileApi.getCreateSharedLinkRequest(boxItem.getUserId()).setFields(this.mFileShareFields);
        }
        if (boxItem instanceof BoxFolder) {
            return (BoxRequestUpdateSharedItem) this.mFolderApi.getCreateSharedLinkRequest(boxItem.getUserId()).setFields(this.mFolderShareFields);
        }
        if (boxItem instanceof BoxBookmark) {
            return (BoxRequestUpdateSharedItem) this.mBookmarkApi.getCreateSharedLinkRequest(boxItem.getUserId()).setFields(this.mBookmarkShareFields);
        }
        return null;
    }

    @Override // com.box.android.coreservices.api.ShareController
    public BoxFutureTask<BoxItem> createDefaultSharedLink(BoxItem boxItem) {
        return executeRequest(BoxItem.class, getCreatedSharedLinkRequest(boxItem));
    }

    @Override // com.box.android.coreservices.api.ShareController
    public BoxFutureTask<BoxItem> disableShareLink(BoxItem boxItem) {
        BoxRequest fields;
        if (boxItem instanceof BoxFile) {
            fields = this.mFileApi.getDisableSharedLinkRequest(boxItem.getUserId()).setFields(BoxFile.ALL_FIELDS);
        } else if (boxItem instanceof BoxFolder) {
            fields = this.mFolderApi.getDisableSharedLinkRequest(boxItem.getUserId()).setFields(BoxApiPrivate.FOLDER_FIELDS);
        } else {
            fields = boxItem instanceof BoxBookmark ? this.mBookmarkApi.getDisableSharedLinkRequest(boxItem.getUserId()).setFields(BoxBookmark.ALL_FIELDS) : null;
        }
        return executeRequest(BoxItem.class, fields);
    }

    @Override // com.box.android.coreservices.api.ShareController
    public BoxFutureTask<BoxIteratorCollaborations> fetchCollaborations(BoxCollaborationItem boxCollaborationItem) {
        BoxFutureTask<BoxIteratorCollaborations> task;
        if (boxCollaborationItem instanceof BoxFolder) {
            task = this.mFolderApi.getCollaborationsRequest(boxCollaborationItem.getUserId()).setFields("").toTask();
        } else {
            task = boxCollaborationItem instanceof BoxFile ? this.mFileApi.getCollaborationsRequest(boxCollaborationItem.getUserId()).toTask() : null;
        }
        if (task == null) {
            BoxLogUtils.logException("BoxShareConteroller", "unhandled type " + boxCollaborationItem, new RuntimeException("bad argument"));
            return null;
        }
        getApiExecutor().submit(task);
        return task;
    }

    @Override // com.box.android.coreservices.api.ShareController
    public BoxFutureTask<BoxCollaborationItem> fetchRoles(BoxCollaborationItem boxCollaborationItem) {
        BoxRequest fields = boxCollaborationItem instanceof BoxFile ? this.mFileApi.getInfoRequest(boxCollaborationItem.getUserId()).setFields(BoxApiPrivate.COLLAB_ROLE_FIELDS) : null;
        if (boxCollaborationItem instanceof BoxFolder) {
            fields = this.mFolderApi.getInfoRequest(boxCollaborationItem.getUserId()).setFields(BoxApiPrivate.COLLAB_ROLE_FIELDS);
        }
        if (fields == null) {
            BoxLogUtils.logException("BoxShareConteroller", "unhandled type " + boxCollaborationItem, new RuntimeException("bad argument"));
            return null;
        }
        BoxFutureTask<BoxCollaborationItem> boxFutureTask = new BoxFutureTask<>(BoxCollaborationItem.class, fields);
        getApiExecutor().submit(boxFutureTask);
        return boxFutureTask;
    }

    @Override // com.box.android.coreservices.api.ShareController
    public BoxFutureTask<BoxCollaboration> updateCollaboration(BoxCollaboration boxCollaboration, BoxCollaboration.Role role) {
        BoxFutureTask<BoxCollaboration> task = this.mCollabApi.getUpdateRequest(boxCollaboration.getUserId()).setNewRole(role).toTask();
        getApiExecutor().submit(task);
        return task;
    }

    @Override // com.box.android.coreservices.api.ShareController
    public BoxFutureTask<BoxVoid> updateOwner(BoxCollaboration boxCollaboration) {
        BoxFutureTask<BoxVoid> task = this.mCollabApi.getUpdateOwnerRequest(boxCollaboration.getUserId()).toTask();
        getApiExecutor().submit(task);
        return task;
    }

    @Override // com.box.android.coreservices.api.ShareController
    public BoxFutureTask<BoxVoid> deleteCollaboration(BoxCollaboration boxCollaboration) {
        BoxFutureTask<BoxVoid> task = this.mCollabApi.getDeleteRequest(boxCollaboration).toTask();
        getApiExecutor().submit(task);
        return task;
    }

    @Override // com.box.android.coreservices.api.ShareController
    public <E extends BoxAvatarView.AvatarController & Serializable> E getAvatarController() {
        return this.mUserContextManager.getPreviewStorage().getAvatarController();
    }

    @Override // com.box.android.coreservices.api.ShareController
    public BoxFutureTask<BoxResponseBatch> addCollaborations(BoxCollaborationItem boxCollaborationItem, BoxCollaboration.Role role, String[] strArr) {
        BoxRequestBatch boxRequestBatch = new BoxRequestBatch();
        for (String str : strArr) {
            String strTrim = str.trim();
            if (!SdkUtils.isBlank(strTrim)) {
                boxRequestBatch.addRequest(this.mCollabApi.getAddRequest(boxCollaborationItem, role, strTrim));
            }
        }
        BoxFutureTask<BoxResponseBatch> task = boxRequestBatch.toTask();
        getApiExecutor().submit(task);
        return task;
    }

    @Override // com.box.android.coreservices.api.ShareController
    public BoxFutureTask<BoxIteratorInvitees> getInvitees(BoxCollaborationItem boxCollaborationItem, String str) {
        BoxFutureTask task = this.mInviteeApi.getInviteesRequest(boxCollaborationItem.getUserId()).setFilterTerm(str).toTask();
        getApiExecutor().submit(task);
        return task;
    }

    @Override // com.box.android.coreservices.api.ShareController
    public <E extends BoxObject> BoxFutureTask<E> executeRequest(Class<E> cls, BoxRequest boxRequest) {
        BoxFutureTask<E> boxFutureTask = new BoxFutureTask<>(cls, boxRequest);
        getApiExecutor().submit(boxFutureTask);
        return boxFutureTask;
    }

    @Override // com.box.android.coreservices.api.ShareController
    public void showToast(Context context, CharSequence charSequence) {
        Toast.makeText(context, charSequence, 1).show();
    }

    @Override // com.box.android.coreservices.api.ShareController
    public void showToast(Context context, int i) {
        showToast(context, context.getResources().getText(i));
    }

    @Override // com.box.android.coreservices.api.ShareController
    public BoxFutureTask<BoxFeatures> getSupportedFeatures() {
        BoxFutureTask<BoxFeatures> task = this.mFeaturesApi.getSupportedFeatures().toTask();
        getApiExecutor().submit(task);
        return task;
    }

    @Override // com.box.android.coreservices.api.ShareController
    public String getCurrentUserId() {
        return this.mUserContextManager.getUserInfo().getUserId();
    }

    ThreadPoolExecutor getApiExecutor() {
        return getExecutorPool().getLocalModelExecutor();
    }
}

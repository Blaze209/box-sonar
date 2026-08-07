package com.box.android.repo;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import com.box.android.coreservices.api.ShareController;
import com.box.android.coreservices.models.BoxFeatures;
import com.box.android.coreservices.models.BoxIteratorInvitees;
import com.box.android.data.api.utils.UpdateSharedLinkPasswordErrorConverter;
import com.box.android.data.datasource.CacheError;
import com.box.android.data.datasource.LegacyCacheDataSource;
import com.box.android.data.datasource.errors.RemoteError;
import com.box.android.domain.utils.result.Result;
import com.box.androidsdk.content.BoxException;
import com.box.androidsdk.content.BoxFutureTask;
import com.box.androidsdk.content.models.BoxCollaboration;
import com.box.androidsdk.content.models.BoxCollaborationItem;
import com.box.androidsdk.content.models.BoxFile;
import com.box.androidsdk.content.models.BoxFolder;
import com.box.androidsdk.content.models.BoxItem;
import com.box.androidsdk.content.models.BoxIteratorCollaborations;
import com.box.androidsdk.content.models.BoxSharedLink;
import com.box.androidsdk.content.models.BoxVoid;
import com.box.androidsdk.content.requests.BoxRequestsFile;
import com.box.androidsdk.content.requests.BoxRequestsFolder;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.androidsdk.content.requests.BoxResponseBatch;
import com.box.androidsdk.content.views.BoxAvatarView;
import java.io.Serializable;
import java.text.ParseException;
import java.util.Date;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;

/* JADX INFO: loaded from: classes12.dex */
public class ShareRepo {
    private final ShareController mController;
    private final LegacyCacheDataSource mLegacyCacheDataSource;
    private final UpdateSharedLinkPasswordErrorConverter updateSharedLinkPasswordErrorConverter;
    private final MutableLiveData<BoxResponse<BoxIteratorInvitees>> mInvitees = new MutableLiveData<>();
    private final MutableLiveData<BoxResponse<BoxCollaborationItem>> mRoleItem = new MutableLiveData<>();
    private final MutableLiveData<BoxResponse<BoxResponseBatch>> mInviteCollabsBatchResponse = new MutableLiveData<>();
    private final MutableLiveData<BoxResponse<BoxItem>> mItemInfo = new MutableLiveData<>();
    private final MutableLiveData<BoxResponse<BoxItem>> mSharedLinkedItem = new MutableLiveData<>();
    private final MutableLiveData<BoxResponse<BoxIteratorCollaborations>> mCollaborations = new MutableLiveData<>();
    private final MutableLiveData<BoxResponse<BoxFeatures>> mSupportedFeatures = new MutableLiveData<>();
    private final MutableLiveData<BoxResponse<BoxVoid>> mDeleteCollaboration = new MutableLiveData<>();
    private final MutableLiveData<BoxResponse<BoxVoid>> mUpdateOwner = new MutableLiveData<>();
    private final MutableLiveData<BoxResponse<BoxCollaboration>> mUpdateCollaboration = new MutableLiveData<>();
    public final MutableLiveData<Result<BoxItem, RemoteError>> updateSharedLinkPasswordResult = new MutableLiveData<>();

    public ShareRepo(ShareController shareController, UpdateSharedLinkPasswordErrorConverter updateSharedLinkPasswordErrorConverter, LegacyCacheDataSource legacyCacheDataSource) {
        this.mLegacyCacheDataSource = legacyCacheDataSource;
        this.mController = shareController;
        this.updateSharedLinkPasswordErrorConverter = updateSharedLinkPasswordErrorConverter;
    }

    public void fetchInviteesFromRemote(BoxCollaborationItem boxCollaborationItem, String str) {
        handleTaskAndPostValue(this.mController.getInvitees(boxCollaborationItem, str), this.mInvitees);
    }

    private void handleTaskAndPostValue(BoxFutureTask boxFutureTask, final MutableLiveData mutableLiveData) {
        boxFutureTask.addOnCompletedListener(new BoxFutureTask.OnCompletedListener() { // from class: com.box.android.repo.ShareRepo$$ExternalSyntheticLambda0
            @Override // com.box.androidsdk.content.BoxFutureTask.OnCompletedListener
            public final void onCompleted(BoxResponse boxResponse) {
                this.f$0.lambda$handleTaskAndPostValue$0(mutableLiveData, boxResponse);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$handleTaskAndPostValue$0(MutableLiveData mutableLiveData, BoxResponse boxResponse) {
        mutableLiveData.postValue(boxResponse);
        if (boxResponse.getResult() instanceof BoxItem) {
            saveBoxItemToCache((BoxItem) boxResponse.getResult());
        }
    }

    private void saveBoxItemToCache(BoxItem boxItem) {
        this.mLegacyCacheDataSource.saveItem(boxItem, true, (Continuation<? super Result<Unit, CacheError.SaveError>>) new Continuation<Result<? extends Unit, ? extends CacheError.SaveError>>() { // from class: com.box.android.repo.ShareRepo.1
            @Override // kotlin.coroutines.Continuation
            public void resumeWith(Object obj) {
            }

            @Override // kotlin.coroutines.Continuation
            public CoroutineContext getContext() {
                return EmptyCoroutineContext.INSTANCE;
            }
        });
    }

    public void fetchRolesFromRemote(BoxCollaborationItem boxCollaborationItem) {
        handleTaskAndPostValue(this.mController.fetchRoles(boxCollaborationItem), this.mRoleItem);
    }

    public void fetchItemInfo(BoxItem boxItem) {
        handleTaskAndPostValue(this.mController.fetchItemInfo(boxItem), this.mItemInfo);
    }

    public void inviteCollabs(BoxCollaborationItem boxCollaborationItem, BoxCollaboration.Role role, String[] strArr) {
        handleTaskAndPostValue(this.mController.addCollaborations(boxCollaborationItem, role, strArr), this.mInviteCollabsBatchResponse);
    }

    public LiveData<BoxResponse<BoxIteratorInvitees>> getInvitees() {
        return this.mInvitees;
    }

    public LiveData<BoxResponse<BoxCollaborationItem>> getRoleItem() {
        return this.mRoleItem;
    }

    public LiveData<BoxResponse<BoxResponseBatch>> getInviteCollabsBatchResponse() {
        return this.mInviteCollabsBatchResponse;
    }

    public LiveData<BoxResponse<BoxItem>> getItemInfo() {
        return this.mItemInfo;
    }

    public void createDefaultSharedLink(BoxCollaborationItem boxCollaborationItem) {
        handleTaskAndPostValue(this.mController.createDefaultSharedLink(boxCollaborationItem), this.mSharedLinkedItem);
    }

    public void disableSharedLink(BoxCollaborationItem boxCollaborationItem) {
        handleTaskAndPostValue(this.mController.disableShareLink(boxCollaborationItem), this.mSharedLinkedItem);
    }

    public void changeItemPermission(BoxCollaborationItem boxCollaborationItem, BoxSharedLink.Permission permission) throws IllegalArgumentException {
        if (boxCollaborationItem instanceof BoxFile) {
            ShareController shareController = this.mController;
            handleTaskAndPostValue(shareController.executeRequest(BoxItem.class, ((BoxRequestsFile.UpdatedSharedFile) shareController.getCreatedSharedLinkRequest(boxCollaborationItem)).setPermission(permission)), this.mSharedLinkedItem);
        } else {
            if (boxCollaborationItem instanceof BoxFolder) {
                ShareController shareController2 = this.mController;
                handleTaskAndPostValue(shareController2.executeRequest(BoxItem.class, ((BoxRequestsFolder.UpdateSharedFolder) shareController2.getCreatedSharedLinkRequest(boxCollaborationItem)).setPermission(permission)), this.mSharedLinkedItem);
                return;
            }
            throw new IllegalArgumentException();
        }
    }

    public void setExpiryDate(BoxCollaborationItem boxCollaborationItem, Date date) throws ParseException {
        ShareController shareController = this.mController;
        handleTaskAndPostValue(shareController.executeRequest(BoxItem.class, shareController.getCreatedSharedLinkRequest(boxCollaborationItem).setUnsharedAt(date)), this.mSharedLinkedItem);
    }

    public void removeExpiryDate(BoxCollaborationItem boxCollaborationItem) throws ParseException {
        ShareController shareController = this.mController;
        handleTaskAndPostValue(shareController.executeRequest(BoxItem.class, shareController.getCreatedSharedLinkRequest(boxCollaborationItem).setRemoveUnsharedAtDate()), this.mSharedLinkedItem);
    }

    public void changeAccessLevel(BoxCollaborationItem boxCollaborationItem, BoxSharedLink.Access access) {
        ShareController shareController = this.mController;
        handleTaskAndPostValue(shareController.executeRequest(BoxItem.class, shareController.getCreatedSharedLinkRequest(boxCollaborationItem).setAccess(access)), this.mSharedLinkedItem);
    }

    public void changePassword(BoxCollaborationItem boxCollaborationItem, String str) {
        ShareController shareController = this.mController;
        shareController.executeRequest(BoxItem.class, shareController.getCreatedSharedLinkRequest(boxCollaborationItem).setPassword(str)).addOnCompletedListener(new BoxFutureTask.OnCompletedListener() { // from class: com.box.android.repo.ShareRepo$$ExternalSyntheticLambda1
            @Override // com.box.androidsdk.content.BoxFutureTask.OnCompletedListener
            public final void onCompleted(BoxResponse boxResponse) {
                this.f$0.lambda$changePassword$1(boxResponse);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public /* synthetic */ void lambda$changePassword$1(BoxResponse boxResponse) {
        if (boxResponse.isSuccess()) {
            this.updateSharedLinkPasswordResult.postValue(new Result.Success((BoxItem) boxResponse.getResult()));
        } else {
            this.updateSharedLinkPasswordResult.postValue(new Result.Error(this.updateSharedLinkPasswordErrorConverter.convert(((BoxException) boxResponse.getException()).getResponse())));
        }
    }

    public void fetchCollaborations(BoxCollaborationItem boxCollaborationItem) {
        handleTaskAndPostValue(this.mController.fetchCollaborations(boxCollaborationItem), this.mCollaborations);
    }

    public void fetchSupportedFeatures() {
        handleTaskAndPostValue(this.mController.getSupportedFeatures(), this.mSupportedFeatures);
    }

    public LiveData<BoxResponse<BoxFeatures>> getSupportFeatures() {
        return this.mSupportedFeatures;
    }

    public LiveData<BoxResponse<BoxItem>> getShareLinkedItem() {
        return this.mSharedLinkedItem;
    }

    public LiveData<BoxResponse<BoxIteratorCollaborations>> getCollaborations() {
        return this.mCollaborations;
    }

    public <E extends BoxAvatarView.AvatarController & Serializable> E getAvatarController() {
        return (E) this.mController.getAvatarController();
    }

    public LiveData<BoxResponse<BoxVoid>> getDeleteCollaboration() {
        return this.mDeleteCollaboration;
    }

    public LiveData<BoxResponse<BoxCollaboration>> getUpdateCollaboration() {
        return this.mUpdateCollaboration;
    }

    public LiveData<BoxResponse<BoxVoid>> getUpdateOwner() {
        return this.mUpdateOwner;
    }

    public void deleteCollaboration(BoxCollaboration boxCollaboration) {
        handleTaskAndPostValue(this.mController.deleteCollaboration(boxCollaboration), this.mDeleteCollaboration);
    }

    public void updateCollaboration(BoxCollaboration boxCollaboration, BoxCollaboration.Role role) {
        handleTaskAndPostValue(this.mController.updateCollaboration(boxCollaboration, role), this.mUpdateCollaboration);
    }

    public void updateOwner(BoxCollaboration boxCollaboration) {
        handleTaskAndPostValue(this.mController.updateOwner(boxCollaboration), this.mUpdateOwner);
    }

    public String getUserId() {
        return this.mController.getCurrentUserId();
    }
}

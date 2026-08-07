package com.box.android.vm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import com.box.android.repo.ShareRepo;
import com.box.android.utilities.ShareSDKTransformer;
import com.box.androidsdk.content.models.BoxCollaboration;
import com.box.androidsdk.content.models.BoxCollaborationItem;
import com.box.androidsdk.content.models.BoxIteratorCollaborations;
import com.box.androidsdk.content.models.BoxVoid;
import com.box.androidsdk.content.requests.BoxRequest;
import com.box.androidsdk.content.requests.BoxResponse;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes13.dex */
public class CollaborationsShareVM extends BaseShareVM {
    private List<BoxCollaboration> mCachedCollaborations;
    private final LiveData<PresenterData<BoxIteratorCollaborations>> mCollaborations;
    private final LiveData<PresenterData<BoxRequest>> mDeleteCollaboration;
    private boolean mOwnerUpdated;
    private final LiveData<PresenterData<BoxCollaborationItem>> mRoleItem;
    private final LiveData<PresenterData<BoxCollaboration>> mUpdateCollaboration;
    private final LiveData<PresenterData<BoxVoid>> mUpdateOwner;

    public CollaborationsShareVM(ShareRepo shareRepo, BoxCollaborationItem boxCollaborationItem) {
        super(shareRepo, boxCollaborationItem);
        final ShareSDKTransformer shareSDKTransformer = new ShareSDKTransformer();
        LiveData<BoxResponse<BoxIteratorCollaborations>> collaborations = shareRepo.getCollaborations();
        Objects.requireNonNull(shareSDKTransformer);
        this.mCollaborations = Transformations.map(collaborations, new Function1() { // from class: com.box.android.vm.CollaborationsShareVM$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return shareSDKTransformer.getCollaborationsPresenterData((BoxResponse) obj);
            }
        });
        LiveData<BoxResponse<BoxVoid>> deleteCollaboration = shareRepo.getDeleteCollaboration();
        Objects.requireNonNull(shareSDKTransformer);
        this.mDeleteCollaboration = Transformations.map(deleteCollaboration, new Function1() { // from class: com.box.android.vm.CollaborationsShareVM$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return shareSDKTransformer.getDeleteCollaborationPresenterData((BoxResponse) obj);
            }
        });
        LiveData<BoxResponse<BoxVoid>> updateOwner = shareRepo.getUpdateOwner();
        Objects.requireNonNull(shareSDKTransformer);
        this.mUpdateOwner = Transformations.map(updateOwner, new Function1() { // from class: com.box.android.vm.CollaborationsShareVM$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return shareSDKTransformer.getUpdateOwnerPresenterData((BoxResponse) obj);
            }
        });
        LiveData<BoxResponse<BoxCollaboration>> updateCollaboration = shareRepo.getUpdateCollaboration();
        Objects.requireNonNull(shareSDKTransformer);
        this.mUpdateCollaboration = Transformations.map(updateCollaboration, new Function1() { // from class: com.box.android.vm.CollaborationsShareVM$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return shareSDKTransformer.getUpdateCollaborationPresenterData((BoxResponse) obj);
            }
        });
        LiveData<BoxResponse<BoxCollaborationItem>> roleItem = shareRepo.getRoleItem();
        Objects.requireNonNull(shareSDKTransformer);
        this.mRoleItem = Transformations.map(roleItem, new CollaborationsShareVM$$ExternalSyntheticLambda4(shareSDKTransformer));
        this.mOwnerUpdated = false;
    }

    CollaborationsShareVM(ShareRepo shareRepo, BoxCollaborationItem boxCollaborationItem, final ShareSDKTransformer shareSDKTransformer) {
        super(shareRepo, boxCollaborationItem);
        LiveData<BoxResponse<BoxIteratorCollaborations>> collaborations = shareRepo.getCollaborations();
        Objects.requireNonNull(shareSDKTransformer);
        this.mCollaborations = Transformations.map(collaborations, new Function1() { // from class: com.box.android.vm.CollaborationsShareVM$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return shareSDKTransformer.getCollaborationsPresenterData((BoxResponse) obj);
            }
        });
        LiveData<BoxResponse<BoxVoid>> deleteCollaboration = shareRepo.getDeleteCollaboration();
        Objects.requireNonNull(shareSDKTransformer);
        this.mDeleteCollaboration = Transformations.map(deleteCollaboration, new Function1() { // from class: com.box.android.vm.CollaborationsShareVM$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return shareSDKTransformer.getDeleteCollaborationPresenterData((BoxResponse) obj);
            }
        });
        LiveData<BoxResponse<BoxVoid>> updateOwner = shareRepo.getUpdateOwner();
        Objects.requireNonNull(shareSDKTransformer);
        this.mUpdateOwner = Transformations.map(updateOwner, new Function1() { // from class: com.box.android.vm.CollaborationsShareVM$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return shareSDKTransformer.getUpdateOwnerPresenterData((BoxResponse) obj);
            }
        });
        LiveData<BoxResponse<BoxCollaboration>> updateCollaboration = shareRepo.getUpdateCollaboration();
        Objects.requireNonNull(shareSDKTransformer);
        this.mUpdateCollaboration = Transformations.map(updateCollaboration, new Function1() { // from class: com.box.android.vm.CollaborationsShareVM$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return shareSDKTransformer.getUpdateCollaborationPresenterData((BoxResponse) obj);
            }
        });
        LiveData<BoxResponse<BoxCollaborationItem>> roleItem = shareRepo.getRoleItem();
        Objects.requireNonNull(shareSDKTransformer);
        this.mRoleItem = Transformations.map(roleItem, new CollaborationsShareVM$$ExternalSyntheticLambda4(shareSDKTransformer));
        this.mOwnerUpdated = false;
    }

    public void deleteCollaboration(BoxCollaboration boxCollaboration) {
        this.mShareRepo.deleteCollaboration(boxCollaboration);
    }

    public void updateCollaboration(BoxCollaboration boxCollaboration, BoxCollaboration.Role role) {
        this.mShareRepo.updateCollaboration(boxCollaboration, role);
    }

    public void updateOwner(BoxCollaboration boxCollaboration) {
        this.mShareRepo.updateOwner(boxCollaboration);
    }

    public void fetchCollaborations(BoxCollaborationItem boxCollaborationItem) {
        this.mShareRepo.fetchCollaborations(boxCollaborationItem);
    }

    public LiveData<PresenterData<BoxRequest>> getDeleteCollaboration() {
        return this.mDeleteCollaboration;
    }

    public LiveData<PresenterData<BoxVoid>> getUpdateOwner() {
        return this.mUpdateOwner;
    }

    public LiveData<PresenterData<BoxCollaboration>> getUpdateCollaboration() {
        return this.mUpdateCollaboration;
    }

    public LiveData<PresenterData<BoxIteratorCollaborations>> getCollaborations() {
        return this.mCollaborations;
    }

    public boolean isOwnerUpdated() {
        return this.mOwnerUpdated;
    }

    public void setOwnerUpdated(boolean z) {
        this.mOwnerUpdated = z;
    }

    public void fetchRoles(BoxCollaborationItem boxCollaborationItem) {
        this.mShareRepo.fetchRolesFromRemote(boxCollaborationItem);
    }

    public LiveData<PresenterData<BoxCollaborationItem>> getRoleItem() {
        return this.mRoleItem;
    }

    public List<BoxCollaboration> getCachedCollaborations() {
        return this.mCachedCollaborations;
    }

    public void setCachedCollaborations(List<BoxCollaboration> list) {
        this.mCachedCollaborations = list;
    }
}

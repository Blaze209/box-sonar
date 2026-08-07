package com.box.android.vm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.Transformations;
import com.box.android.coreservices.models.BoxInvitee;
import com.box.android.coreservices.models.BoxIteratorInvitees;
import com.box.android.repo.ShareRepo;
import com.box.android.utilities.ShareSDKTransformer;
import com.box.androidsdk.content.models.BoxCollaboration;
import com.box.androidsdk.content.models.BoxCollaborationItem;
import com.box.androidsdk.content.requests.BoxResponse;
import com.box.androidsdk.content.requests.BoxResponseBatch;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes13.dex */
public class InviteCollaboratorsShareVM extends BaseShareVM {
    private boolean mContactsPermissionRequested;
    private boolean mInvitationSuccess;
    private LiveData<InviteCollaboratorsPresenterData> mInviteCollabs;
    private LiveData<PresenterData<BoxIteratorInvitees>> mInvitees;
    List<BoxInvitee> mInviteesList;
    private LiveData<PresenterData<BoxCollaborationItem>> mRoleItem;
    private String pendingInviteText;

    public InviteCollaboratorsShareVM(ShareRepo shareRepo, BoxCollaborationItem boxCollaborationItem) {
        super(shareRepo, boxCollaborationItem);
        this.pendingInviteText = "";
        this.mInvitationSuccess = true;
        this.mContactsPermissionRequested = false;
        final ShareSDKTransformer shareSDKTransformer = new ShareSDKTransformer();
        LiveData<BoxResponse<BoxCollaborationItem>> roleItem = shareRepo.getRoleItem();
        Objects.requireNonNull(shareSDKTransformer);
        this.mRoleItem = Transformations.map(roleItem, new CollaborationsShareVM$$ExternalSyntheticLambda4(shareSDKTransformer));
        LiveData<BoxResponse<BoxResponseBatch>> inviteCollabsBatchResponse = shareRepo.getInviteCollabsBatchResponse();
        Objects.requireNonNull(shareSDKTransformer);
        this.mInviteCollabs = Transformations.map(inviteCollabsBatchResponse, new Function1() { // from class: com.box.android.vm.InviteCollaboratorsShareVM$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return shareSDKTransformer.getInviteCollabsPresenterDataFromBoxResponse((BoxResponse) obj);
            }
        });
        LiveData<BoxResponse<BoxIteratorInvitees>> invitees = shareRepo.getInvitees();
        Objects.requireNonNull(shareSDKTransformer);
        this.mInvitees = Transformations.map(invitees, new Function1() { // from class: com.box.android.vm.InviteCollaboratorsShareVM$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return shareSDKTransformer.getInviteesPresenterData((BoxResponse) obj);
            }
        });
        this.mInviteesList = new ArrayList();
    }

    InviteCollaboratorsShareVM(ShareRepo shareRepo, BoxCollaborationItem boxCollaborationItem, final ShareSDKTransformer shareSDKTransformer) {
        super(shareRepo, boxCollaborationItem);
        this.pendingInviteText = "";
        this.mInvitationSuccess = true;
        this.mContactsPermissionRequested = false;
        LiveData<BoxResponse<BoxCollaborationItem>> roleItem = shareRepo.getRoleItem();
        Objects.requireNonNull(shareSDKTransformer);
        this.mRoleItem = Transformations.map(roleItem, new CollaborationsShareVM$$ExternalSyntheticLambda4(shareSDKTransformer));
        LiveData<BoxResponse<BoxResponseBatch>> inviteCollabsBatchResponse = shareRepo.getInviteCollabsBatchResponse();
        Objects.requireNonNull(shareSDKTransformer);
        this.mInviteCollabs = Transformations.map(inviteCollabsBatchResponse, new Function1() { // from class: com.box.android.vm.InviteCollaboratorsShareVM$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return shareSDKTransformer.getInviteCollabsPresenterDataFromBoxResponse((BoxResponse) obj);
            }
        });
        LiveData<BoxResponse<BoxIteratorInvitees>> invitees = shareRepo.getInvitees();
        Objects.requireNonNull(shareSDKTransformer);
        this.mInvitees = Transformations.map(invitees, new Function1() { // from class: com.box.android.vm.InviteCollaboratorsShareVM$$ExternalSyntheticLambda1
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return shareSDKTransformer.getInviteesPresenterData((BoxResponse) obj);
            }
        });
    }

    public void fetchRoles(BoxCollaborationItem boxCollaborationItem) {
        this.mShareRepo.fetchRolesFromRemote(boxCollaborationItem);
    }

    public void inviteCollabs(BoxCollaborationItem boxCollaborationItem, BoxCollaboration.Role role, String[] strArr) {
        this.mShareRepo.inviteCollabs(boxCollaborationItem, role, strArr);
    }

    public void fetchInvitees(BoxCollaborationItem boxCollaborationItem, String str) {
        this.mShareRepo.fetchInviteesFromRemote(boxCollaborationItem, str);
    }

    public LiveData<PresenterData<BoxCollaborationItem>> getRoleItem() {
        return this.mRoleItem;
    }

    public LiveData<InviteCollaboratorsPresenterData> getInviteCollabs() {
        return this.mInviteCollabs;
    }

    public LiveData<PresenterData<BoxIteratorInvitees>> getInvitees() {
        return this.mInvitees;
    }

    public List<BoxInvitee> getInviteesList() {
        return this.mInviteesList;
    }

    public void setInviteesList(List<BoxInvitee> list) {
        this.mInviteesList = list;
    }

    public void setInvitationSucceded(boolean z) {
        this.mInvitationSuccess = z;
    }

    public boolean isInvitationSucceded() {
        return this.mInvitationSuccess;
    }

    public String getPendingInviteText() {
        return this.pendingInviteText;
    }

    public void setPendingInviteText(String str) {
        this.pendingInviteText = str;
    }

    public boolean isContactsPermissionRequested() {
        return this.mContactsPermissionRequested;
    }

    public void setContactsPermissionRequested(boolean z) {
        this.mContactsPermissionRequested = z;
    }
}

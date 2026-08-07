package com.box.android.vm;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import com.box.androidsdk.content.models.BoxCollaboration;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes13.dex */
public class SelectRoleShareVM extends ViewModel {
    private BoxCollaboration mCollaboration;
    private List<BoxCollaboration.Role> mRoles = new ArrayList();
    private boolean mAllowOwnerRole = false;
    private MutableLiveData<BoxCollaboration.Role> mSelectedRole = new MutableLiveData<>();
    private boolean mAllowRemove = false;
    private boolean mRemoveSelected = false;
    private MutableLiveData<Boolean> mSendInvitationEnabled = new MutableLiveData<>();
    private MutableLiveData<Boolean> mShowSend = new MutableLiveData<>();
    private String mName = "";

    public SelectRoleShareVM() {
        this.mSendInvitationEnabled.postValue(false);
        this.mShowSend.postValue(true);
    }

    public List<BoxCollaboration.Role> getRoles() {
        return this.mRoles;
    }

    public boolean isOwnerRoleAllowed() {
        return this.mAllowOwnerRole;
    }

    public LiveData<BoxCollaboration.Role> getSelectedRole() {
        return this.mSelectedRole;
    }

    public boolean isRemoveAllowed() {
        return this.mAllowRemove;
    }

    public BoxCollaboration getCollaboration() {
        return this.mCollaboration;
    }

    public void setSelectedRole(BoxCollaboration.Role role) {
        this.mSelectedRole.postValue(role);
    }

    public void setRoles(List<BoxCollaboration.Role> list) {
        this.mRoles = list;
    }

    public void setAllowOwnerRole(boolean z) {
        this.mAllowOwnerRole = z;
    }

    public void setAllowRemove(boolean z) {
        this.mAllowRemove = z;
    }

    public void setCollaboration(BoxCollaboration boxCollaboration) {
        this.mCollaboration = boxCollaboration;
    }

    public LiveData<Boolean> isSendInvitationEnabled() {
        return this.mSendInvitationEnabled;
    }

    public void setSendInvitationEnabled(boolean z) {
        this.mSendInvitationEnabled.postValue(Boolean.valueOf(z));
    }

    public LiveData<Boolean> isShowSend() {
        return this.mShowSend;
    }

    public void setShowSend(boolean z) {
        this.mShowSend.postValue(Boolean.valueOf(z));
    }

    public boolean isRemoveSelected() {
        return this.mRemoveSelected;
    }

    public void setRemoveSelected(boolean z) {
        this.mRemoveSelected = z;
    }

    public String getName() {
        return this.mName;
    }

    public void setName(String str) {
        this.mName = str;
    }
}

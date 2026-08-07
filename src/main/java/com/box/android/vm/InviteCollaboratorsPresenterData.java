package com.box.android.vm;

import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes13.dex */
public class InviteCollaboratorsPresenterData extends PresenterData<String> {
    private int mAlreadyAddedCount;
    private boolean mInvitationFailed;
    private Map<Integer, List<String>> mKVPData;
    private MessageUIType mMessageUIType;

    public enum MessageUIType {
        TOAST,
        SNACKBAR,
        ALERT_DIALOG
    }

    public InviteCollaboratorsPresenterData(String str, int i) {
        super(str, i);
        this.mInvitationFailed = false;
        this.mAlreadyAddedCount = 0;
        this.mMessageUIType = MessageUIType.TOAST;
    }

    public InviteCollaboratorsPresenterData(MessageUIType messageUIType, String str, int i, boolean z) {
        super(str, i);
        this.mMessageUIType = messageUIType;
        this.mInvitationFailed = z;
    }

    public InviteCollaboratorsPresenterData(MessageUIType messageUIType, boolean z, Map<Integer, List<String>> map) {
        super(null, -1);
        this.mMessageUIType = messageUIType;
        this.mInvitationFailed = z;
        this.mKVPData = map;
    }

    public int getAlreadyAdddedCount() {
        return this.mAlreadyAddedCount;
    }

    @Override // com.box.android.vm.PresenterData
    public boolean isSuccess() {
        return !this.mInvitationFailed;
    }

    public boolean isNonNullData() {
        return this.mData != 0;
    }

    public boolean isStrCodeSet() {
        return this.mStrRes != -1;
    }

    public boolean isDataMapSet() {
        return this.mKVPData != null;
    }

    public MessageUIType getUIType() {
        return this.mMessageUIType;
    }

    public Map<Integer, List<String>> getDataMap() {
        this.mIsHandled = true;
        return this.mKVPData;
    }
}

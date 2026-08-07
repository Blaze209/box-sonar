package com.box.android.coreservices.modelcontroller.messages;

import com.box.android.coreservices.jobmanager.JobItem;

/* JADX INFO: loaded from: classes9.dex */
public class BoxJobMessage<E> extends BoxMessage<E> {
    private int[] mCancelIds = new int[0];
    private int mCollectionId;
    private JobItem.JobItemState mState;

    public BoxJobMessage(String str) {
        setAction(str);
    }

    private static int convertIdString(String str) {
        if (str == null) {
            return 0;
        }
        return str.hashCode();
    }

    public int getCollectionId() {
        return this.mCollectionId;
    }

    public void setCollectionId(String str) {
        this.mCollectionId = convertIdString(str);
    }

    public int[] getCancelIds() {
        return this.mCancelIds;
    }

    public void setCancelIds(String... strArr) {
        this.mCancelIds = new int[strArr.length];
        for (int i = 0; i < strArr.length; i++) {
            this.mCancelIds[i] = convertIdString(strArr[i]);
        }
    }

    public JobItem.JobItemState getState() {
        return this.mState;
    }

    public void setState(JobItem.JobItemState jobItemState) {
        this.mState = jobItemState;
    }
}

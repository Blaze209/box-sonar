package com.pspdfkit.internal.jni;

import java.util.Date;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeAnnotationStateChange {
    final String mAuthor;
    final Date mCreationDate;
    final NativeAuthorState mState;

    public NativeAnnotationStateChange(String str, NativeAuthorState nativeAuthorState, Date date) {
        this.mAuthor = str;
        this.mState = nativeAuthorState;
        this.mCreationDate = date;
    }

    public String getAuthor() {
        return this.mAuthor;
    }

    public Date getCreationDate() {
        return this.mCreationDate;
    }

    public NativeAuthorState getState() {
        return this.mState;
    }

    public String toString() {
        return "NativeAnnotationStateChange{mAuthor=" + this.mAuthor + ",mState=" + this.mState + ",mCreationDate=" + this.mCreationDate + "}";
    }
}

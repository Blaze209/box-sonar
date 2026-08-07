package com.pspdfkit.internal.jni;

import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: loaded from: classes3.dex */
public final class NativeAnnotationReviewSummary {
    final NativeAuthorState mCurrentUserState;
    final HashMap<NativeAuthorState, ArrayList<String>> mReviewNames;

    public NativeAnnotationReviewSummary(HashMap<NativeAuthorState, ArrayList<String>> map, NativeAuthorState nativeAuthorState) {
        this.mReviewNames = map;
        this.mCurrentUserState = nativeAuthorState;
    }

    public NativeAuthorState getCurrentUserState() {
        return this.mCurrentUserState;
    }

    public HashMap<NativeAuthorState, ArrayList<String>> getReviewNames() {
        return this.mReviewNames;
    }

    public String toString() {
        return "NativeAnnotationReviewSummary{mReviewNames=" + this.mReviewNames + ",mCurrentUserState=" + this.mCurrentUserState + "}";
    }
}

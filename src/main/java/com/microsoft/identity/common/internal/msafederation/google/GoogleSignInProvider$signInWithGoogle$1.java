package com.microsoft.identity.common.internal.msafederation.google;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;

/* JADX INFO: compiled from: GoogleSignInProvider.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(k = 3, mv = {1, 8, 0}, xi = 48)
@DebugMetadata(c = "com.microsoft.identity.common.internal.msafederation.google.GoogleSignInProvider", f = "GoogleSignInProvider.kt", i = {}, l = {111}, m = "signInWithGoogle-IoAF18A", n = {}, s = {})
final class GoogleSignInProvider$signInWithGoogle$1 extends ContinuationImpl {
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GoogleSignInProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GoogleSignInProvider$signInWithGoogle$1(GoogleSignInProvider googleSignInProvider, Continuation<? super GoogleSignInProvider$signInWithGoogle$1> continuation) {
        super(continuation);
        this.this$0 = googleSignInProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM13849signInWithGoogleIoAF18A = this.this$0.m13849signInWithGoogleIoAF18A(this);
        return objM13849signInWithGoogleIoAF18A == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM13849signInWithGoogleIoAF18A : Result.m14779boximpl(objM13849signInWithGoogleIoAF18A);
    }
}

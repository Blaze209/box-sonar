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
@DebugMetadata(c = "com.microsoft.identity.common.internal.msafederation.google.GoogleSignInProvider", f = "GoogleSignInProvider.kt", i = {0, 0, 0}, l = {135, 199}, m = "getCredential-gIAlu-s", n = {"this", "option", "methodTag"}, s = {"L$0", "L$1", "L$2"})
final class GoogleSignInProvider$getCredential$1 extends ContinuationImpl {
    Object L$0;
    Object L$1;
    Object L$2;
    int label;
    /* synthetic */ Object result;
    final /* synthetic */ GoogleSignInProvider this$0;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    GoogleSignInProvider$getCredential$1(GoogleSignInProvider googleSignInProvider, Continuation<? super GoogleSignInProvider$getCredential$1> continuation) {
        super(continuation);
        this.this$0 = googleSignInProvider;
    }

    @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
    public final Object invokeSuspend(Object obj) {
        this.result = obj;
        this.label |= Integer.MIN_VALUE;
        Object objM13848getCredentialgIAlus = this.this$0.m13848getCredentialgIAlus(null, this);
        return objM13848getCredentialgIAlus == IntrinsicsKt.getCOROUTINE_SUSPENDED() ? objM13848getCredentialgIAlus : Result.m14779boximpl(objM13848getCredentialgIAlus);
    }
}

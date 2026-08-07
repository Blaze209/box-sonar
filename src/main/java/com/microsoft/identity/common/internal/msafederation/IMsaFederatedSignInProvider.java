package com.microsoft.identity.common.internal.msafederation;

import kotlin.Metadata;
import kotlin.Result;
import kotlin.Unit;
import kotlin.coroutines.Continuation;

/* JADX INFO: compiled from: IMsaFederatedSignInProvider.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\b`\u0018\u00002\u00020\u0001J\"\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H¦@ø\u0001\u0000ø\u0001\u0001ø\u0001\u0002ø\u0001\u0002¢\u0006\u0004\b\u0005\u0010\u0006J\u0011\u0010\u0007\u001a\u00020\bH¦@ø\u0001\u0002¢\u0006\u0002\u0010\u0006\u0082\u0002\u000f\n\u0002\b!\n\u0005\b¡\u001e0\u0001\n\u0002\b\u0019¨\u0006\t"}, d2 = {"Lcom/microsoft/identity/common/internal/msafederation/IMsaFederatedSignInProvider;", "", "signIn", "Lkotlin/Result;", "Lcom/microsoft/identity/common/internal/msafederation/MsaFederatedCredential;", "signIn-IoAF18A", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "signOut", "", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public interface IMsaFederatedSignInProvider {
    /* JADX INFO: renamed from: signIn-IoAF18A, reason: not valid java name */
    Object mo13844signInIoAF18A(Continuation<? super Result<? extends MsaFederatedCredential>> continuation);

    Object signOut(Continuation<? super Unit> continuation);
}

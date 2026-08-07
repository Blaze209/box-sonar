package com.microsoft.identity.nativeauth;

import com.microsoft.identity.common.java.nativeauth.providers.responses.signin.AuthenticationMethodApiResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AuthMethod.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004*\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"toAuthMethod", "Lcom/microsoft/identity/nativeauth/AuthMethod;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/AuthenticationMethodApiResult;", "toListOfAuthMethods", "", "msal_distRelease"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AuthMethodKt {
    public static final List<AuthMethod> toListOfAuthMethods(List<AuthenticationMethodApiResult> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        List<AuthenticationMethodApiResult> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toAuthMethod((AuthenticationMethodApiResult) it.next()));
        }
        return arrayList;
    }

    public static final AuthMethod toAuthMethod(AuthenticationMethodApiResult authenticationMethodApiResult) {
        Intrinsics.checkNotNullParameter(authenticationMethodApiResult, "<this>");
        return new AuthMethod(authenticationMethodApiResult.getId(), authenticationMethodApiResult.getChallengeType(), authenticationMethodApiResult.getLoginHint(), authenticationMethodApiResult.getChallengeChannel());
    }
}

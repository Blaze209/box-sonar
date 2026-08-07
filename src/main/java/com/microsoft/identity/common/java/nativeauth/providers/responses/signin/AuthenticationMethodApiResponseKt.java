package com.microsoft.identity.common.java.nativeauth.providers.responses.signin;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AuthenticationMethodApiResponse.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0000\u001a\f\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\u0000\u001a\u0018\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00010\u0004*\b\u0012\u0004\u0012\u00020\u00020\u0004H\u0000¨\u0006\u0005"}, d2 = {"toAuthenticationMethodApiResult", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/AuthenticationMethodApiResult;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/signin/AuthenticationMethodApiResponse;", "toListOfAuthenticationMethodApiResult", "", "common4j"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class AuthenticationMethodApiResponseKt {
    public static final List<AuthenticationMethodApiResult> toListOfAuthenticationMethodApiResult(List<AuthenticationMethodApiResponse> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        List<AuthenticationMethodApiResponse> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toAuthenticationMethodApiResult((AuthenticationMethodApiResponse) it.next()));
        }
        return arrayList;
    }

    public static final AuthenticationMethodApiResult toAuthenticationMethodApiResult(AuthenticationMethodApiResponse authenticationMethodApiResponse) throws IllegalStateException {
        Intrinsics.checkNotNullParameter(authenticationMethodApiResponse, "<this>");
        String id = authenticationMethodApiResponse.getId();
        if (id == null) {
            throw new IllegalStateException("Required field id is empty");
        }
        String challengeType = authenticationMethodApiResponse.getChallengeType();
        if (challengeType == null) {
            throw new IllegalStateException("Required field challengeType is empty");
        }
        String loginHint = authenticationMethodApiResponse.getLoginHint();
        String challengeChannel = authenticationMethodApiResponse.getChallengeChannel();
        if (challengeChannel != null) {
            return new AuthenticationMethodApiResult(id, challengeType, loginHint, challengeChannel);
        }
        throw new IllegalStateException("Required challengeChannel id is empty");
    }
}

package com.microsoft.identity.nativeauth;

import com.microsoft.identity.common.java.nativeauth.providers.responses.UserAttributeOptionsApiResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RequiredUserAttributeOptions.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0000\u001a\n\u0010\u0000\u001a\u00020\u0001*\u00020\u0002\u001a\u0018\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00010\u0003*\b\u0012\u0004\u0012\u00020\u00020\u0003H\u0000¨\u0006\u0004"}, d2 = {"toListOfRequiredUserAttributeOptions", "Lcom/microsoft/identity/nativeauth/RequiredUserAttributeOptions;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/UserAttributeOptionsApiResult;", "", "msal_distRelease"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RequiredUserAttributeOptionsKt {
    public static final List<RequiredUserAttributeOptions> toListOfRequiredUserAttributeOptions(List<UserAttributeOptionsApiResult> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        List<UserAttributeOptionsApiResult> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toListOfRequiredUserAttributeOptions((UserAttributeOptionsApiResult) it.next()));
        }
        return arrayList;
    }

    public static final RequiredUserAttributeOptions toListOfRequiredUserAttributeOptions(UserAttributeOptionsApiResult userAttributeOptionsApiResult) {
        Intrinsics.checkNotNullParameter(userAttributeOptionsApiResult, "<this>");
        return new RequiredUserAttributeOptions(userAttributeOptionsApiResult.getRegex());
    }
}

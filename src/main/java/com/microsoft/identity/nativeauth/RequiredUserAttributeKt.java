package com.microsoft.identity.nativeauth;

import com.microsoft.identity.common.java.nativeauth.providers.responses.UserAttributeApiResult;
import com.microsoft.identity.common.java.nativeauth.providers.responses.UserAttributeOptionsApiResult;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: RequiredUserAttribute.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0018\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0001H\u0000\u001a\f\u0010\u0004\u001a\u00020\u0002*\u00020\u0003H\u0000¨\u0006\u0005"}, d2 = {"toListOfRequiredUserAttribute", "", "Lcom/microsoft/identity/nativeauth/RequiredUserAttribute;", "Lcom/microsoft/identity/common/java/nativeauth/providers/responses/UserAttributeApiResult;", "toRequiredUserAttribute", "msal_distRelease"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class RequiredUserAttributeKt {
    public static final List<RequiredUserAttribute> toListOfRequiredUserAttribute(List<UserAttributeApiResult> list) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        List<UserAttributeApiResult> list2 = list;
        ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
        Iterator<T> it = list2.iterator();
        while (it.hasNext()) {
            arrayList.add(toRequiredUserAttribute((UserAttributeApiResult) it.next()));
        }
        return arrayList;
    }

    public static final RequiredUserAttribute toRequiredUserAttribute(UserAttributeApiResult userAttributeApiResult) {
        Intrinsics.checkNotNullParameter(userAttributeApiResult, "<this>");
        String name = userAttributeApiResult.getName();
        String type = userAttributeApiResult.getType();
        Boolean required = userAttributeApiResult.getRequired();
        UserAttributeOptionsApiResult options = userAttributeApiResult.getOptions();
        return new RequiredUserAttribute(name, type, required, options != null ? RequiredUserAttributeOptionsKt.toListOfRequiredUserAttributeOptions(options) : null);
    }
}

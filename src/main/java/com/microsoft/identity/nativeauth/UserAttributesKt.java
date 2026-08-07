package com.microsoft.identity.nativeauth;

import com.microsoft.identity.common.java.util.ObjectMapper;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: UserAttributes.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\u001a\u0018\u0010\u0000\u001a\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u0003H\u0000¨\u0006\u0004"}, d2 = {"toMap", "", "", "Lcom/microsoft/identity/nativeauth/UserAttributes;", "msal_distRelease"}, k = 2, mv = {1, 8, 0}, xi = 48)
public final class UserAttributesKt {
    public static final Map<String, String> toMap(UserAttributes userAttributes) {
        Intrinsics.checkNotNullParameter(userAttributes, "<this>");
        Map<String, String> mapConstructMapFromObject = ObjectMapper.constructMapFromObject(userAttributes.getUserAttributes$msal_distRelease());
        Intrinsics.checkNotNullExpressionValue(mapConstructMapFromObject, "constructMapFromObject(userAttributes)");
        return mapConstructMapFromObject;
    }
}

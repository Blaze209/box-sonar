package com.box.androidsdk.content.utils;

import java.util.UUID;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OAuthUtils.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0005H\u0007J\u0012\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\u0005H\u0007R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000¨\u0006\n"}, d2 = {"Lcom/box/androidsdk/content/utils/OAuthUtils;", "", "<init>", "()V", "stateToken", "", "generateStateToken", "isValidStateString", "", "state", "content_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class OAuthUtils {
    public static final OAuthUtils INSTANCE = new OAuthUtils();
    private static String stateToken;

    private OAuthUtils() {
    }

    @JvmStatic
    public static final String generateStateToken() {
        String str = stateToken;
        if (str != null) {
            if (str != null) {
                return str;
            }
            Intrinsics.throwUninitializedPropertyAccessException("stateToken");
            return null;
        }
        String string = UUID.randomUUID().toString();
        Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
        stateToken = string;
        if (string != null) {
            return string;
        }
        Intrinsics.throwUninitializedPropertyAccessException("stateToken");
        return null;
    }

    @JvmStatic
    public static final boolean isValidStateString(String state) {
        String str = stateToken;
        if (str == null || state == null) {
            return false;
        }
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("stateToken");
            str = null;
        }
        return Intrinsics.areEqual(state, str);
    }
}

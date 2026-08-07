package com.box.android.auth;

import android.net.Uri;
import com.box.android.domain.configuration.BoxConfigConstants;
import com.box.android.domain.identity.IUserContextManager;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import com.box.androidsdk.content.auth.BoxAuthentication;
import java.util.Map;
import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: DeepLinkAuthResolver.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\bÁ\u0002\u0018\u00002\u00020\u0001:\u0001\u001cB\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\t\u001a\u0004\u0018\u00010\u00052\b\u0010\n\u001a\u0004\u0018\u00010\u000bJ\u0016\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rJ$\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0011\u001a\u00020\u00122\u0014\u0010\u0013\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u0015\u0018\u00010\u0014J \u0010\u0016\u001a\u00020\u00172\b\u0010\u0018\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u000e\u001a\u00020\r2\u0006\u0010\u000f\u001a\u00020\rJ\u001a\u0010\u0019\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u001a\u001a\u00020\r2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0005R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u001d"}, d2 = {"Lcom/box/android/auth/DeepLinkAuthResolver;", "", "<init>", "()V", "DEEP_LINK_SCHEME", "", "DEEP_LINK_HOST", "AUTH_CODE_PARAM", "CODE_PARAM", "extractAuthCode", "uri", "Landroid/net/Uri;", "shouldIgnore", "", "hasActiveUsers", "isEmmMode", "computeHasActiveUsers", "userContextManager", "Lcom/box/android/domain/identity/IUserContextManager;", "storedAuthInfo", "", "Lcom/box/androidsdk/content/auth/BoxAuthentication$BoxAuthenticationInfo;", "resolveDecision", "Lcom/box/android/auth/DeepLinkAuthResolver$Decision;", BoxNoteConstants.NOTES_BUILDER_AUTH_CODE, "resolveDevpodAuthority", "isDebugBuild", "authority", "Decision", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class DeepLinkAuthResolver {
    public static final int $stable = 0;
    private static final String AUTH_CODE_PARAM = "auth_code";
    private static final String CODE_PARAM = "code";
    private static final String DEEP_LINK_HOST = "m.box.com";
    private static final String DEEP_LINK_SCHEME = "box-login";
    public static final DeepLinkAuthResolver INSTANCE = new DeepLinkAuthResolver();

    /* JADX INFO: compiled from: DeepLinkAuthResolver.kt */
    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/box/android/auth/DeepLinkAuthResolver$Decision;", "", "<init>", "(Ljava/lang/String;I)V", "FALLBACK_AUTHENTICATE", "IGNORE", "EXCHANGE_AUTH_CODE", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public enum Decision {
        FALLBACK_AUTHENTICATE,
        IGNORE,
        EXCHANGE_AUTH_CODE;

        private static final /* synthetic */ EnumEntries $ENTRIES = EnumEntriesKt.enumEntries(values());

        public static EnumEntries<Decision> getEntries() {
            return $ENTRIES;
        }
    }

    public final boolean shouldIgnore(boolean hasActiveUsers, boolean isEmmMode) {
        return hasActiveUsers || isEmmMode;
    }

    private DeepLinkAuthResolver() {
    }

    public final String extractAuthCode(final Uri uri) {
        if (uri != null && Intrinsics.areEqual(uri.getScheme(), DEEP_LINK_SCHEME) && Intrinsics.areEqual(uri.getHost(), DEEP_LINK_HOST)) {
            return (String) SequencesKt.firstOrNull(SequencesKt.mapNotNull(SequencesKt.sequenceOf((Object[]) new String[]{"auth_code", "code"}), new Function1() { // from class: com.box.android.auth.DeepLinkAuthResolver$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return DeepLinkAuthResolver.extractAuthCode$lambda$0(uri, (String) obj);
                }
            }));
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String extractAuthCode$lambda$0(Uri uri, String param) {
        Intrinsics.checkNotNullParameter(param, "param");
        String queryParameter = uri.getQueryParameter(param);
        if (queryParameter == null || StringsKt.isBlank(queryParameter)) {
            return null;
        }
        return queryParameter;
    }

    public final boolean computeHasActiveUsers(IUserContextManager userContextManager, Map<String, ? extends BoxAuthentication.BoxAuthenticationInfo> storedAuthInfo) {
        Intrinsics.checkNotNullParameter(userContextManager, "userContextManager");
        if (userContextManager.isValidUserAvailable()) {
            return true;
        }
        return (storedAuthInfo == null || storedAuthInfo.isEmpty()) ? false : true;
    }

    public final Decision resolveDecision(String authCode, boolean hasActiveUsers, boolean isEmmMode) {
        String str = authCode;
        if (str == null || StringsKt.isBlank(str)) {
            return Decision.FALLBACK_AUTHENTICATE;
        }
        return shouldIgnore(hasActiveUsers, isEmmMode) ? Decision.IGNORE : Decision.EXCHANGE_AUTH_CODE;
    }

    public final String resolveDevpodAuthority(boolean isDebugBuild, String authority) {
        String str;
        if (!isDebugBuild || (str = authority) == null || StringsKt.isBlank(str) || !StringsKt.contains$default((CharSequence) str, (CharSequence) BoxConfigConstants.DEVPOD_HOST_NAME_SUBSTRING, false, 2, (Object) null)) {
            return null;
        }
        return authority;
    }
}

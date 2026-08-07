package com.microsoft.identity.nativeauth;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import com.microsoft.identity.client.PublicClientApplicationConfiguration;
import com.microsoft.identity.client.configuration.AccountMode;
import com.microsoft.identity.client.exception.MsalClientException;
import com.microsoft.identity.common.java.authorities.CIAMAuthority;
import com.microsoft.identity.common.java.logging.Logger;
import com.microsoft.identity.common.java.nativeauth.authorities.NativeAuthCIAMAuthority;
import com.microsoft.identity.common.java.nativeauth.providers.NativeAuthConstants;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NativeAuthPublicClientApplicationConfiguration.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0002\b\f\u0018\u0000 \u001f2\u00020\u00012\u00020\u0002:\u0002\u001f B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010\u0014\u001a\u00020\u0015H\u0016J\u000e\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005J\u000e\u0010\u0017\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005J\u000e\u0010\u0018\u001a\u00020\u00152\u0006\u0010\u0019\u001a\u00020\u0000J\u0016\u0010\u001a\u001a\u00020\u00152\u000e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005J\u0016\u0010\u001b\u001a\u00020\u00152\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005J\b\u0010\u001c\u001a\u00020\u0015H\u0002J\b\u0010\u001d\u001a\u00020\u0015H\u0002J\b\u0010\u001e\u001a\u00020\u0015H\u0016R\u001a\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0002@\u0002X\u0083\u000e¢\u0006\u0002\n\u0000R \u0010\b\u001a\u0004\u0018\u00010\u00068\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\"\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0013\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012¨\u0006!"}, d2 = {"Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplicationConfiguration;", "Lcom/microsoft/identity/client/PublicClientApplicationConfiguration;", "Ljava/io/Serializable;", "()V", NativeAuthSerializedNames.CAPABILITIES, "", "", "challengeTypes", "dc", "getDc", "()Ljava/lang/String;", "setDc", "(Ljava/lang/String;)V", "useMockAuthority", "", "getUseMockAuthority", "()Ljava/lang/Boolean;", "setUseMockAuthority", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "checkIntentFilterAddedToAppManifestForBrokerFlow", "", "getCapabilities", "getChallengeTypes", "mergeConfiguration", "config", "setCapabilities", "setChallengeTypes", "validateCapabilities", "validateChallengeTypes", "validateConfiguration", "Companion", "NativeAuthSerializedNames", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class NativeAuthPublicClientApplicationConfiguration extends PublicClientApplicationConfiguration implements Serializable {

    @SerializedName(NativeAuthSerializedNames.CAPABILITIES)
    private List<String> capabilities;

    @SerializedName(NativeAuthSerializedNames.CHALLENGE_TYPES)
    private List<String> challengeTypes;

    @SerializedName("dc")
    private String dc;

    @SerializedName(NativeAuthSerializedNames.USE_MOCK_API)
    private Boolean useMockAuthority;
    private static final String TAG = "NativeAuthPublicClientApplicationConfiguration";
    private static final List<String> VALID_CHALLENGE_TYPES = CollectionsKt.listOf((Object[]) new String[]{"password", "oob", "redirect"});
    private static final List<String> VALID_CAPABILITIES = CollectionsKt.listOf((Object[]) new String[]{NativeAuthConstants.Capabilities.MFA_REQUIRED, NativeAuthConstants.Capabilities.REGISTRATION_REQUIRED});

    /* JADX INFO: compiled from: NativeAuthPublicClientApplicationConfiguration.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\bÂ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\b"}, d2 = {"Lcom/microsoft/identity/nativeauth/NativeAuthPublicClientApplicationConfiguration$NativeAuthSerializedNames;", "", "()V", "CAPABILITIES", "", "CHALLENGE_TYPES", "DC", "USE_MOCK_API", "msal_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    private static final class NativeAuthSerializedNames {
        public static final String CAPABILITIES = "capabilities";
        public static final String CHALLENGE_TYPES = "challenge_types";
        public static final String DC = "dc";
        public static final NativeAuthSerializedNames INSTANCE = new NativeAuthSerializedNames();
        public static final String USE_MOCK_API = "use_mock_api_for_native_auth";

        private NativeAuthSerializedNames() {
        }
    }

    public final Boolean getUseMockAuthority() {
        return this.useMockAuthority;
    }

    public final void setUseMockAuthority(Boolean bool) {
        this.useMockAuthority = bool;
    }

    public final String getDc() {
        return this.dc;
    }

    public final void setDc(String str) {
        this.dc = str;
    }

    public final List<String> getChallengeTypes() {
        return this.challengeTypes;
    }

    public final void setChallengeTypes(List<String> challengeTypes) {
        this.challengeTypes = challengeTypes;
    }

    public final List<String> getCapabilities() {
        return this.capabilities;
    }

    public final void setCapabilities(List<String> capabilities) {
        this.capabilities = capabilities;
    }

    public final void mergeConfiguration(NativeAuthPublicClientApplicationConfiguration config) {
        Intrinsics.checkNotNullParameter(config, "config");
        super.mergeConfiguration((PublicClientApplicationConfiguration) config);
        setAccountMode(config.getAccountMode() != null ? config.getAccountMode() : getAccountMode());
        List<String> list = config.challengeTypes;
        if (list == null) {
            list = this.challengeTypes;
        }
        this.challengeTypes = list;
        List<String> list2 = config.capabilities;
        if (list2 == null) {
            list2 = this.capabilities;
        }
        this.capabilities = list2;
        Boolean bool = config.useMockAuthority;
        if (bool == null) {
            bool = this.useMockAuthority;
        }
        this.useMockAuthority = bool;
        String str = config.dc;
        if (str == null) {
            str = this.dc;
        }
        this.dc = str;
    }

    @Override // com.microsoft.identity.client.PublicClientApplicationConfiguration
    public void validateConfiguration() {
        if (TextUtils.isEmpty(getClientId())) {
            throw new MsalClientException(MsalClientException.NATIVE_AUTH_USE_WITHOUT_CLIENT_ID_ERROR_CODE, MsalClientException.NATIVE_AUTH_USE_WITHOUT_CLIENT_ID_ERROR_MESSAGE);
        }
        if (getRedirectUri() != null) {
            super.validateConfiguration();
        } else {
            Logger.warn(TAG, "No redirect URI was passed.");
        }
        if (getAccountMode() != AccountMode.SINGLE) {
            throw new MsalClientException(MsalClientException.NATIVE_AUTH_INVALID_ACCOUNT_MODE_CONFIG_ERROR_CODE, MsalClientException.NATIVE_AUTH_INVALID_ACCOUNT_MODE_CONFIG_ERROR_MESSAGE);
        }
        if (getAuthorities() == null || getAuthorities().size() == 0) {
            throw new MsalClientException(MsalClientException.NATIVE_AUTH_USE_WITH_NO_AUTHORITY_ERROR_CODE, MsalClientException.NATIVE_AUTH_USE_WITH_NO_AUTHORITY_ERROR_MESSAGE);
        }
        if (getAuthorities().size() > 1) {
            throw new MsalClientException(MsalClientException.NATIVE_AUTH_USE_WITH_MULTI_AUTHORITY_ERROR_CODE, MsalClientException.NATIVE_AUTH_USE_WITH_MULTI_AUTHORITY_ERROR_MESSAGE);
        }
        if (!(getDefaultAuthority() instanceof NativeAuthCIAMAuthority)) {
            if (getDefaultAuthority() instanceof CIAMAuthority) {
                String string = getDefaultAuthority().getAuthorityUri().toString();
                Intrinsics.checkNotNullExpressionValue(string, "defaultAuthority.authorityUri.toString()");
                String clientId = getClientId();
                Intrinsics.checkNotNullExpressionValue(clientId, "clientId");
                NativeAuthCIAMAuthority nativeAuthCIAMAuthority = new NativeAuthCIAMAuthority(string, clientId);
                getAuthorities().clear();
                getAuthorities().add(nativeAuthCIAMAuthority);
            } else {
                throw new MsalClientException("native_auth_invalid_ciam_authority", MsalClientException.NATIVE_AUTH_INVALID_CIAM_AUTHORITY_ERROR_MESSAGE);
            }
        }
        if (getIsSharedDevice()) {
            throw new MsalClientException(MsalClientException.NATIVE_AUTH_SHARED_DEVICE_MODE_ERROR_CODE, MsalClientException.NATIVE_AUTH_SHARED_DEVICE_MODE_ERROR_MESSAGE);
        }
        validateChallengeTypes();
        validateCapabilities();
    }

    private final void validateChallengeTypes() throws MsalClientException {
        ArrayList arrayList;
        List<String> list = this.challengeTypes;
        if (list != null) {
            List<String> list2 = list;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                String lowerCase = ((String) it.next()).toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                arrayList2.add(lowerCase);
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        this.challengeTypes = arrayList;
        List<String> listDistinct = arrayList != null ? CollectionsKt.distinct(arrayList) : null;
        this.challengeTypes = listDistinct;
        if (listDistinct != null) {
            for (String str : listDistinct) {
                if (!VALID_CHALLENGE_TYPES.contains(str)) {
                    throw new MsalClientException(MsalClientException.NATIVE_AUTH_INVALID_CHALLENGE_TYPE_ERROR_CODE, "NativeAuthPublicClientApplication detected invalid challenge type. \"" + str + '\"');
                }
            }
        }
    }

    private final void validateCapabilities() throws MsalClientException {
        ArrayList arrayList;
        List<String> list = this.capabilities;
        if (list != null) {
            List<String> list2 = list;
            ArrayList arrayList2 = new ArrayList(CollectionsKt.collectionSizeOrDefault(list2, 10));
            Iterator<T> it = list2.iterator();
            while (it.hasNext()) {
                String lowerCase = ((String) it.next()).toLowerCase(Locale.ROOT);
                Intrinsics.checkNotNullExpressionValue(lowerCase, "this as java.lang.String).toLowerCase(Locale.ROOT)");
                arrayList2.add(lowerCase);
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        this.capabilities = arrayList;
        List<String> listDistinct = arrayList != null ? CollectionsKt.distinct(arrayList) : null;
        this.capabilities = listDistinct;
        if (listDistinct != null) {
            for (String str : listDistinct) {
                if (!VALID_CAPABILITIES.contains(str)) {
                    throw new MsalClientException(MsalClientException.NATIVE_AUTH_INVALID_CAPABILITY_ERROR_CODE, "NativeAuthPublicClientApplication detected invalid capability. \"" + str + '\"');
                }
            }
        }
    }

    @Override // com.microsoft.identity.client.PublicClientApplicationConfiguration
    public void checkIntentFilterAddedToAppManifestForBrokerFlow() throws MsalClientException {
        if (getRedirectUri() != null) {
            super.checkIntentFilterAddedToAppManifestForBrokerFlow();
        }
    }
}

package com.microsoft.identity.common.java.constants;

import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: compiled from: FidoConstants.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/microsoft/identity/common/java/constants/FidoConstants;", "", "()V", "Companion", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class FidoConstants {
    public static final String PASSKEY_CONTEXT_DELIMITER = " ";
    public static final String PASSKEY_PROTOCOL_ERROR_PREFIX_STRING = "ERROR: ";
    public static final String PASSKEY_PROTOCOL_HEADER_AUTH_AND_REG = "1.1/passkey";
    public static final String PASSKEY_PROTOCOL_HEADER_AUTH_ONLY = "1.0/passkey";
    public static final String PASSKEY_PROTOCOL_HEADER_NAME = "x-ms-PassKeyAuth";
    public static final String PASSKEY_PROTOCOL_KEY_TYPES_DELIMITER = ",";
    public static final String PASSKEY_PROTOCOL_KEY_TYPES_NGC_OPTION = "ngc";
    public static final String PASSKEY_PROTOCOL_KEY_TYPES_PASSKEY_OPTION = "passkey";
    public static final String PASSKEY_PROTOCOL_KEY_TYPES_SECURITYKEY_OPTION = "securitykey";
    public static final String PASSKEY_PROTOCOL_KEY_TYPES_SUPPORTED = "passkey";
    public static final String PASSKEY_PROTOCOL_REDIRECT = "urn:http-auth:PassKey";
    public static final String PASSKEY_PROTOCOL_VERSION_1_0 = "1.0";
    public static final String PASSKEY_PROTOCOL_VERSION_1_1 = "1.1";
    public static final String PASSKEY_RESPONSE_ASSERTION_HEADER = "Assertion";
    public static final String PASSKEY_RESPONSE_CONTEXT_HEADER = "x-ms-ctx";
    public static final String PASSKEY_RESPONSE_FLOWTOKEN_HEADER = "x-ms-flowToken";
    public static final String WEBAUTHN_AUTHENTICATION_ASSERTION_RESPONSE_JSON_KEY = "response";
    public static final String WEBAUTHN_QUERY_PARAMETER_FIELD = "webauthn";
    public static final String WEBAUTHN_QUERY_PARAMETER_VALUE = "1";
    public static final String WEBAUTHN_RESPONSE_AUTHENTICATOR_DATA_JSON_KEY = "authenticatorData";
    public static final String WEBAUTHN_RESPONSE_CLIENT_DATA_JSON_KEY = "clientDataJSON";
    public static final String WEBAUTHN_RESPONSE_ID_JSON_KEY = "id";
    public static final String WEBAUTHN_RESPONSE_SIGNATURE_JSON_KEY = "signature";
    public static final String WEBAUTHN_RESPONSE_USER_HANDLE_JSON_KEY = "userHandle";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Set<String> supportedPasskeyProtocolVersions = SetsKt.setOf((Object[]) new String[]{"1.0", "1.1"});

    /* JADX INFO: compiled from: FidoConstants.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0018\n\u0002\u0010\"\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000R\u0017\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00040\u001d¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001f¨\u0006 "}, d2 = {"Lcom/microsoft/identity/common/java/constants/FidoConstants$Companion;", "", "()V", "PASSKEY_CONTEXT_DELIMITER", "", "PASSKEY_PROTOCOL_ERROR_PREFIX_STRING", "PASSKEY_PROTOCOL_HEADER_AUTH_AND_REG", "PASSKEY_PROTOCOL_HEADER_AUTH_ONLY", "PASSKEY_PROTOCOL_HEADER_NAME", "PASSKEY_PROTOCOL_KEY_TYPES_DELIMITER", "PASSKEY_PROTOCOL_KEY_TYPES_NGC_OPTION", "PASSKEY_PROTOCOL_KEY_TYPES_PASSKEY_OPTION", "PASSKEY_PROTOCOL_KEY_TYPES_SECURITYKEY_OPTION", "PASSKEY_PROTOCOL_KEY_TYPES_SUPPORTED", "PASSKEY_PROTOCOL_REDIRECT", "PASSKEY_PROTOCOL_VERSION_1_0", "PASSKEY_PROTOCOL_VERSION_1_1", "PASSKEY_RESPONSE_ASSERTION_HEADER", "PASSKEY_RESPONSE_CONTEXT_HEADER", "PASSKEY_RESPONSE_FLOWTOKEN_HEADER", "WEBAUTHN_AUTHENTICATION_ASSERTION_RESPONSE_JSON_KEY", "WEBAUTHN_QUERY_PARAMETER_FIELD", "WEBAUTHN_QUERY_PARAMETER_VALUE", "WEBAUTHN_RESPONSE_AUTHENTICATOR_DATA_JSON_KEY", "WEBAUTHN_RESPONSE_CLIENT_DATA_JSON_KEY", "WEBAUTHN_RESPONSE_ID_JSON_KEY", "WEBAUTHN_RESPONSE_SIGNATURE_JSON_KEY", "WEBAUTHN_RESPONSE_USER_HANDLE_JSON_KEY", "supportedPasskeyProtocolVersions", "", "getSupportedPasskeyProtocolVersions", "()Ljava/util/Set;", "common4j"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Set<String> getSupportedPasskeyProtocolVersions() {
            return FidoConstants.supportedPasskeyProtocolVersions;
        }
    }
}

package com.microsoft.identity.common.internal.fido;

import android.util.Base64;
import com.google.android.gms.fido.u2f.api.common.ClientData;
import com.microsoft.identity.common.internal.util.CommonMoshiJsonAdapter;
import com.microsoft.identity.common.java.constants.FidoConstants;
import com.microsoft.identity.common.logging.Logger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.Charsets;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: WebAuthnJsonUtil.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, d2 = {"Lcom/microsoft/identity/common/internal/fido/WebAuthnJsonUtil;", "", "()V", "Companion", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class WebAuthnJsonUtil {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = String.valueOf(Reflection.getOrCreateKotlinClass(WebAuthnJsonUtil.class).getSimpleName());

    @JvmStatic
    public static final String createAssertionString(String str, String str2, String str3, String str4, String str5) {
        return INSTANCE.createAssertionString(str, str2, str3, str4, str5);
    }

    /* JADX INFO: compiled from: WebAuthnJsonUtil.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010 \n\u0002\b\u0005\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J0\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0006\u001a\u00020\u00042\u0006\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\u00042\u0006\u0010\t\u001a\u00020\u00042\u0006\u0010\n\u001a\u00020\u0004H\u0007J.\u0010\u000b\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u00042\u0006\u0010\r\u001a\u00020\u00042\u000e\u0010\u000e\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u000f2\u0006\u0010\u0010\u001a\u00020\u0004J\u000e\u0010\u0011\u001a\u00020\u00042\u0006\u0010\u0012\u001a\u00020\u0004J\n\u0010\u0013\u001a\u00020\u0004*\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/microsoft/identity/common/internal/fido/WebAuthnJsonUtil$Companion;", "", "()V", "TAG", "", "createAssertionString", "clientDataJson", FidoConstants.WEBAUTHN_RESPONSE_AUTHENTICATOR_DATA_JSON_KEY, FidoConstants.WEBAUTHN_RESPONSE_SIGNATURE_JSON_KEY, FidoConstants.WEBAUTHN_RESPONSE_USER_HANDLE_JSON_KEY, "id", "createJsonAuthRequest", ClientData.KEY_CHALLENGE, "relyingPartyIdentifier", "allowedCredentials", "", "userVerificationPolicy", "extractAuthenticatorAssertionResponseJson", "fullResponseJson", "base64UrlEncoded", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String createJsonAuthRequest(String challenge, String relyingPartyIdentifier, List<String> allowedCredentials, String userVerificationPolicy) {
            Intrinsics.checkNotNullParameter(challenge, "challenge");
            Intrinsics.checkNotNullParameter(relyingPartyIdentifier, "relyingPartyIdentifier");
            Intrinsics.checkNotNullParameter(userVerificationPolicy, "userVerificationPolicy");
            ArrayList arrayList = new ArrayList();
            if (allowedCredentials != null) {
                Iterator<String> it = allowedCredentials.iterator();
                while (it.hasNext()) {
                    arrayList.add(new PublicKeyCredentialDescriptor("public-key", it.next()));
                }
            }
            String json = new CommonMoshiJsonAdapter().toJson(new PublicKeyCredentialRequestOptions(base64UrlEncoded(challenge), relyingPartyIdentifier, arrayList, userVerificationPolicy));
            Intrinsics.checkNotNullExpressionValue(json, "CommonMoshiJsonAdapter().toJson(options)");
            return json;
        }

        public final String extractAuthenticatorAssertionResponseJson(String fullResponseJson) throws JSONException {
            Intrinsics.checkNotNullParameter(fullResponseJson, "fullResponseJson");
            String str = WebAuthnJsonUtil.TAG + ":extractAuthenticatorAssertionResponseJson";
            JSONObject jSONObject = new JSONObject(fullResponseJson);
            JSONObject jSONObject2 = jSONObject.getJSONObject("response");
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("id", jSONObject.get("id"));
            jSONObject3.put(FidoConstants.WEBAUTHN_RESPONSE_AUTHENTICATOR_DATA_JSON_KEY, jSONObject2.get(FidoConstants.WEBAUTHN_RESPONSE_AUTHENTICATOR_DATA_JSON_KEY));
            jSONObject3.put(FidoConstants.WEBAUTHN_RESPONSE_CLIENT_DATA_JSON_KEY, jSONObject2.get(FidoConstants.WEBAUTHN_RESPONSE_CLIENT_DATA_JSON_KEY));
            jSONObject3.put(FidoConstants.WEBAUTHN_RESPONSE_SIGNATURE_JSON_KEY, jSONObject2.get(FidoConstants.WEBAUTHN_RESPONSE_SIGNATURE_JSON_KEY));
            if (jSONObject2.isNull(FidoConstants.WEBAUTHN_RESPONSE_USER_HANDLE_JSON_KEY)) {
                Logger.info(str, "UserHandle not found in assertion response.");
            } else {
                Logger.info(str, "UserHandle was included in assertion response.");
                jSONObject3.put(FidoConstants.WEBAUTHN_RESPONSE_USER_HANDLE_JSON_KEY, jSONObject2.get(FidoConstants.WEBAUTHN_RESPONSE_USER_HANDLE_JSON_KEY));
            }
            String string = jSONObject3.toString();
            Intrinsics.checkNotNullExpressionValue(string, "assertionResult.toString()");
            return string;
        }

        @JvmStatic
        public final String createAssertionString(String clientDataJson, String authenticatorData, String signature, String userHandle, String id) throws JSONException {
            Intrinsics.checkNotNullParameter(clientDataJson, "clientDataJson");
            Intrinsics.checkNotNullParameter(authenticatorData, "authenticatorData");
            Intrinsics.checkNotNullParameter(signature, "signature");
            Intrinsics.checkNotNullParameter(userHandle, "userHandle");
            Intrinsics.checkNotNullParameter(id, "id");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("id", id);
            jSONObject.put(FidoConstants.WEBAUTHN_RESPONSE_AUTHENTICATOR_DATA_JSON_KEY, authenticatorData);
            jSONObject.put(FidoConstants.WEBAUTHN_RESPONSE_CLIENT_DATA_JSON_KEY, clientDataJson);
            jSONObject.put(FidoConstants.WEBAUTHN_RESPONSE_SIGNATURE_JSON_KEY, signature);
            jSONObject.put(FidoConstants.WEBAUTHN_RESPONSE_USER_HANDLE_JSON_KEY, userHandle);
            String string = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(string, "assertionResult.toString()");
            return string;
        }

        public final String base64UrlEncoded(String str) {
            Intrinsics.checkNotNullParameter(str, "<this>");
            byte[] bytes = str.getBytes(Charsets.UTF_8);
            Intrinsics.checkNotNullExpressionValue(bytes, "this as java.lang.String).getBytes(charset)");
            String strEncodeToString = Base64.encodeToString(bytes, 11);
            Intrinsics.checkNotNullExpressionValue(strEncodeToString, "encodeToString(data, (Ba…AP or Base64.NO_PADDING))");
            return strEncodeToString;
        }
    }
}

package com.microsoft.identity.common.internal.broker;

import android.webkit.JavascriptInterface;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonParseException;
import com.google.gson.JsonSyntaxException;
import com.google.gson.stream.MalformedJsonException;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.microsoft.identity.common.internal.numberMatch.NumberMatchHelper;
import com.microsoft.identity.common.java.opentelemetry.AttributeName;
import com.microsoft.identity.common.java.opentelemetry.SpanExtension;
import com.microsoft.identity.common.logging.Logger;
import io.opentelemetry.api.trace.Span;
import java.net.URI;
import java.net.URISyntaxException;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: AuthUxJavaScriptInterface.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \n2\u00020\u0001:\u0002\n\u000bB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0002J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0006H\u0007¨\u0006\f"}, d2 = {"Lcom/microsoft/identity/common/internal/broker/AuthUxJavaScriptInterface;", "", "()V", "parseJsonToAuthUxJsonPayloadObject", "Lcom/microsoft/identity/common/internal/broker/AuthUxJsonPayload;", "jsonString", "", "receiveAuthUxMessage", "", "jsonPayload", "Companion", "OperationNames", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class AuthUxJavaScriptInterface {
    private static final String JAVASCRIPT_INTERFACE_NAME = "broker";

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "AuthUxJavaScriptInterface";

    /* JADX INFO: compiled from: AuthUxJavaScriptInterface.kt */
    @Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\u0004J\u0010\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0019\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00040\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\r"}, d2 = {"Lcom/microsoft/identity/common/internal/broker/AuthUxJavaScriptInterface$Companion;", "", "()V", "JAVASCRIPT_INTERFACE_NAME", "", "TAG", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "getInterfaceName", "isValidUriForInterface", "", "uriString", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final String getTAG() {
            return AuthUxJavaScriptInterface.TAG;
        }

        public final String getInterfaceName() {
            return AuthUxJavaScriptInterface.JAVASCRIPT_INTERFACE_NAME;
        }

        public final boolean isValidUriForInterface(String uriString) {
            String str = uriString;
            if (str != null && str.length() != 0) {
                try {
                    String host = new URI(uriString).getHost();
                    Intrinsics.checkNotNullExpressionValue(host, "host");
                    return StringsKt.endsWith$default(host, AuthenticationConstants.Broker.AAD_GLOBAL_URL_HOST_SUFFIX, false, 2, (Object) null) || StringsKt.endsWith$default(host, AuthenticationConstants.Broker.AAD_INTUNE_MDM_URL_HOST_SUFFIX, false, 2, (Object) null) || StringsKt.endsWith$default(host, AuthenticationConstants.Broker.AAD_US_URL_HOST_SUFFIX, false, 2, (Object) null) || StringsKt.endsWith$default(host, AuthenticationConstants.Broker.AAD_CHINA_URL_HOST_SUFFIX, false, 2, (Object) null);
                } catch (URISyntaxException e) {
                    Logger.warn(getTAG(), "URISyntaxException received. uri: " + uriString + ", Message: " + e.getMessage());
                }
            }
            return false;
        }
    }

    @JavascriptInterface
    public final void receiveAuthUxMessage(String jsonPayload) {
        Intrinsics.checkNotNullParameter(jsonPayload, "jsonPayload");
        String str = TAG + ":receiveAuthUxMessage";
        Logger.info(str, "Received a payload from AuthUX through JavaScript API.");
        try {
            AuthUxJsonPayload jsonToAuthUxJsonPayloadObject = parseJsonToAuthUxJsonPayloadObject(jsonPayload);
            Logger.info(str, "Correlation ID during JavaScript Call: [" + jsonToAuthUxJsonPayloadObject.getCorrelationId() + AbstractJsonLexerKt.END_LIST);
            Span spanCurrent = SpanExtension.current();
            spanCurrent.setAttribute(AttributeName.authux_js_action_name.name(), jsonToAuthUxJsonPayloadObject.getActionName());
            spanCurrent.setAttribute(AttributeName.authux_js_action_component.name(), jsonToAuthUxJsonPayloadObject.getActionComponent());
            AuthUxParams params = jsonToAuthUxJsonPayloadObject.getParams();
            if (params == null) {
                Logger.warn(str, "Payload from AuthUX contained no \"params\" field.");
                return;
            }
            String operation = params.getOperation();
            if (operation != null) {
                spanCurrent.setAttribute(AttributeName.authux_js_operation.name(), operation);
            }
            Logger.info(str, "Function name: [" + operation + AbstractJsonLexerKt.END_LIST);
            if (Intrinsics.areEqual(operation, OperationNames.NUMBER_MATCHING)) {
                NumberMatchHelper.INSTANCE.storeNumberMatch(params.getSessionId(), params.getCodeMatch());
            } else {
                Logger.warn(str, "Payload from AuthUX contained an unknown function name.");
            }
        } catch (Exception e) {
            if (e instanceof NullPointerException) {
                Logger.error(str, "Payload with missing mandatory fields sent through JavaScriptInterface", e);
                return;
            }
            if (e instanceof MalformedJsonException ? true : e instanceof JsonSyntaxException ? true : e instanceof JsonParseException) {
                Logger.error(str, "Error Parsing JSON payload sent through JavaScriptInterface", e);
            } else {
                Logger.error(str, "Unknown error occurred while processing the payload.", e);
            }
        }
    }

    private final AuthUxJsonPayload parseJsonToAuthUxJsonPayloadObject(String jsonString) {
        Object objFromJson = new GsonBuilder().registerTypeAdapter(AuthUxJsonPayload.class, new AuthUxJsonPayloadKTDeserializer()).create().fromJson(jsonString, (Class<Object>) AuthUxJsonPayload.class);
        Intrinsics.checkNotNullExpressionValue(objFromJson, "gson.fromJson(jsonString…xJsonPayload::class.java)");
        return (AuthUxJsonPayload) objFromJson;
    }

    /* JADX INFO: compiled from: AuthUxJavaScriptInterface.kt */
    @Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0005"}, d2 = {"Lcom/microsoft/identity/common/internal/broker/AuthUxJavaScriptInterface$OperationNames;", "", "()V", "NUMBER_MATCHING", "", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class OperationNames {
        public static final OperationNames INSTANCE = new OperationNames();
        public static final String NUMBER_MATCHING = "number_matching";

        private OperationNames() {
        }
    }
}

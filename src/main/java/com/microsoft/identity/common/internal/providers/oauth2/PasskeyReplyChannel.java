package com.microsoft.identity.common.internal.providers.oauth2;

import androidx.credentials.exceptions.CreateCredentialCancellationException;
import androidx.credentials.exceptions.CreateCredentialInterruptedException;
import androidx.credentials.exceptions.CreateCredentialProviderConfigurationException;
import androidx.credentials.exceptions.CreateCredentialUnknownException;
import androidx.credentials.exceptions.GetCredentialCancellationException;
import androidx.credentials.exceptions.GetCredentialInterruptedException;
import androidx.credentials.exceptions.GetCredentialProviderConfigurationException;
import androidx.credentials.exceptions.GetCredentialUnknownException;
import androidx.credentials.exceptions.NoCredentialException;
import androidx.webkit.JavaScriptReplyProxy;
import com.microsoft.identity.common.java.opentelemetry.AttributeName;
import com.microsoft.identity.common.java.opentelemetry.OTelUtility;
import com.microsoft.identity.common.java.opentelemetry.SpanExtension;
import com.microsoft.identity.common.java.opentelemetry.SpanName;
import com.microsoft.identity.common.logging.Logger;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.api.trace.StatusCode;
import io.opentelemetry.context.Scope;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: compiled from: PasskeyReplyChannel.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u0003\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0002\u0011\u0012B#\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0007J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u0005H\u0007J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u000b\u001a\u00020\fH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0013"}, d2 = {"Lcom/microsoft/identity/common/internal/providers/oauth2/PasskeyReplyChannel;", "", "replyProxy", "Landroidx/webkit/JavaScriptReplyProxy;", "requestType", "", "spanContext", "Lio/opentelemetry/api/trace/SpanContext;", "(Landroidx/webkit/JavaScriptReplyProxy;Ljava/lang/String;Lio/opentelemetry/api/trace/SpanContext;)V", "postError", "", "throwable", "", "postSuccess", "json", "throwableToErrorMessage", "Lcom/microsoft/identity/common/internal/providers/oauth2/PasskeyReplyChannel$ReplyMessage$Error;", "Companion", "ReplyMessage", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class PasskeyReplyChannel {
    public static final String DATA_KEY = "data";
    public static final String DOM_EXCEPTION_ABORT_ERROR = "AbortError";
    public static final String DOM_EXCEPTION_MESSAGE_KEY = "domExceptionMessage";
    public static final String DOM_EXCEPTION_NAME_KEY = "domExceptionName";
    public static final String DOM_EXCEPTION_NOT_ALLOWED_ERROR = "NotAllowedError";
    public static final String DOM_EXCEPTION_NOT_SUPPORTED_ERROR = "NotSupportedError";
    public static final String DOM_EXCEPTION_UNKNOWN_ERROR = "UnknownError";
    public static final String ERROR_STATUS = "error";
    public static final String STATUS_KEY = "status";
    public static final String SUCCESS_STATUS = "success";
    public static final String TAG = "PasskeyReplyChannel";
    public static final String TYPE_KEY = "type";
    private final JavaScriptReplyProxy replyProxy;
    private final String requestType;
    private final SpanContext spanContext;

    public PasskeyReplyChannel(JavaScriptReplyProxy replyProxy, String requestType, SpanContext spanContext) {
        Intrinsics.checkNotNullParameter(replyProxy, "replyProxy");
        Intrinsics.checkNotNullParameter(requestType, "requestType");
        this.replyProxy = replyProxy;
        this.requestType = requestType;
        this.spanContext = spanContext;
    }

    public /* synthetic */ PasskeyReplyChannel(JavaScriptReplyProxy javaScriptReplyProxy, String str, SpanContext spanContext, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(javaScriptReplyProxy, (i & 2) != 0 ? "unknown" : str, (i & 4) != 0 ? null : spanContext);
    }

    /* JADX INFO: compiled from: PasskeyReplyChannel.kt */
    @Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b6\u0018\u00002\u00020\u0001:\u0002\u000e\u000fB\u0007\b\u0004¢\u0006\u0002\u0010\u0002J\b\u0010\r\u001a\u00020\bH\u0016R\u0012\u0010\u0003\u001a\u00020\u0004X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0012\u0010\u000b\u001a\u00020\bX¦\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\n\u0082\u0001\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"Lcom/microsoft/identity/common/internal/providers/oauth2/PasskeyReplyChannel$ReplyMessage;", "", "()V", "data", "Lorg/json/JSONObject;", "getData", "()Lorg/json/JSONObject;", "status", "", "getStatus", "()Ljava/lang/String;", "type", "getType", "toString", "Error", "Success", "Lcom/microsoft/identity/common/internal/providers/oauth2/PasskeyReplyChannel$ReplyMessage$Error;", "Lcom/microsoft/identity/common/internal/providers/oauth2/PasskeyReplyChannel$ReplyMessage$Success;", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static abstract class ReplyMessage {
        public /* synthetic */ ReplyMessage(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public abstract JSONObject getData();

        public abstract String getStatus();

        public abstract String getType();

        private ReplyMessage() {
        }

        /* JADX INFO: compiled from: PasskeyReplyChannel.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003¢\u0006\u0002\u0010\u0005R\u0014\u0010\u0006\u001a\u00020\u0007X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0014\u0010\u0004\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000b¨\u0006\u000f"}, d2 = {"Lcom/microsoft/identity/common/internal/providers/oauth2/PasskeyReplyChannel$ReplyMessage$Success;", "Lcom/microsoft/identity/common/internal/providers/oauth2/PasskeyReplyChannel$ReplyMessage;", "json", "", "type", "(Ljava/lang/String;Ljava/lang/String;)V", "data", "Lorg/json/JSONObject;", "getData", "()Lorg/json/JSONObject;", "getJson", "()Ljava/lang/String;", "status", "getStatus", "getType", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Success extends ReplyMessage {
            private final JSONObject data;
            private final String json;
            private final String status;
            private final String type;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Success(String json, String type) {
                Object objM14780constructorimpl;
                super(null);
                Intrinsics.checkNotNullParameter(json, "json");
                Intrinsics.checkNotNullParameter(type, "type");
                this.json = json;
                this.type = type;
                this.status = "success";
                try {
                    Result.Companion companion = Result.INSTANCE;
                    Success success = this;
                    objM14780constructorimpl = Result.m14780constructorimpl(new JSONObject(this.json));
                } catch (Throwable th) {
                    Result.Companion companion2 = Result.INSTANCE;
                    objM14780constructorimpl = Result.m14780constructorimpl(ResultKt.createFailure(th));
                }
                this.data = (JSONObject) (Result.m14783exceptionOrNullimpl(objM14780constructorimpl) != null ? new JSONObject() : objM14780constructorimpl);
            }

            public final String getJson() {
                return this.json;
            }

            @Override // com.microsoft.identity.common.internal.providers.oauth2.PasskeyReplyChannel.ReplyMessage
            public String getType() {
                return this.type;
            }

            @Override // com.microsoft.identity.common.internal.providers.oauth2.PasskeyReplyChannel.ReplyMessage
            public String getStatus() {
                return this.status;
            }

            @Override // com.microsoft.identity.common.internal.providers.oauth2.PasskeyReplyChannel.ReplyMessage
            public JSONObject getData() {
                return this.data;
            }
        }

        /* JADX INFO: compiled from: PasskeyReplyChannel.kt */
        @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003¢\u0006\u0002\u0010\u0006R\u0014\u0010\u0007\u001a\u00020\b8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\fR\u0014\u0010\u000e\u001a\u00020\u0003X\u0096D¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\fR\u0014\u0010\u0005\u001a\u00020\u0003X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\f¨\u0006\u0011"}, d2 = {"Lcom/microsoft/identity/common/internal/providers/oauth2/PasskeyReplyChannel$ReplyMessage$Error;", "Lcom/microsoft/identity/common/internal/providers/oauth2/PasskeyReplyChannel$ReplyMessage;", PasskeyReplyChannel.DOM_EXCEPTION_MESSAGE_KEY, "", PasskeyReplyChannel.DOM_EXCEPTION_NAME_KEY, "type", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "data", "Lorg/json/JSONObject;", "getData", "()Lorg/json/JSONObject;", "getDomExceptionMessage", "()Ljava/lang/String;", "getDomExceptionName", "status", "getStatus", "getType", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
        public static final class Error extends ReplyMessage {
            private final String domExceptionMessage;
            private final String domExceptionName;
            private final String status;
            private final String type;

            public final String getDomExceptionMessage() {
                return this.domExceptionMessage;
            }

            public /* synthetic */ Error(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
                this(str, (i & 2) != 0 ? PasskeyReplyChannel.DOM_EXCEPTION_NOT_ALLOWED_ERROR : str2, str3);
            }

            public final String getDomExceptionName() {
                return this.domExceptionName;
            }

            @Override // com.microsoft.identity.common.internal.providers.oauth2.PasskeyReplyChannel.ReplyMessage
            public String getType() {
                return this.type;
            }

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public Error(String domExceptionMessage, String domExceptionName, String type) {
                super(null);
                Intrinsics.checkNotNullParameter(domExceptionMessage, "domExceptionMessage");
                Intrinsics.checkNotNullParameter(domExceptionName, "domExceptionName");
                Intrinsics.checkNotNullParameter(type, "type");
                this.domExceptionMessage = domExceptionMessage;
                this.domExceptionName = domExceptionName;
                this.type = type;
                this.status = "error";
            }

            @Override // com.microsoft.identity.common.internal.providers.oauth2.PasskeyReplyChannel.ReplyMessage
            public String getStatus() {
                return this.status;
            }

            @Override // com.microsoft.identity.common.internal.providers.oauth2.PasskeyReplyChannel.ReplyMessage
            public JSONObject getData() throws JSONException {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put(PasskeyReplyChannel.DOM_EXCEPTION_MESSAGE_KEY, this.domExceptionMessage);
                jSONObject.put(PasskeyReplyChannel.DOM_EXCEPTION_NAME_KEY, this.domExceptionName);
                return jSONObject;
            }
        }

        public String toString() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("status", getStatus());
            jSONObject.put("data", getData());
            jSONObject.put("type", getType());
            String string = jSONObject.toString();
            Intrinsics.checkNotNullExpressionValue(string, "JSONObject().apply {\n   …\n            }.toString()");
            return string;
        }
    }

    public final void postSuccess(String json) {
        Intrinsics.checkNotNullParameter(json, "json");
        Span spanCreateSpanFromParent = OTelUtility.createSpanFromParent(SpanName.PasskeyWebListener.name(), this.spanContext);
        try {
            Scope scopeMakeCurrentSpan = SpanExtension.makeCurrentSpan(spanCreateSpanFromParent);
            try {
                Scope scope = scopeMakeCurrentSpan;
                this.replyProxy.postMessage(new ReplyMessage.Success(json, this.requestType).toString());
                Logger.info("PasskeyReplyChannel:postSuccess", "RequestType: " + this.requestType + " was successful.");
                spanCreateSpanFromParent.setAttribute(AttributeName.passkey_operation_type.name(), this.requestType);
                spanCreateSpanFromParent.setStatus(StatusCode.OK);
                AutoCloseableKt.closeFinally(scopeMakeCurrentSpan, null);
                spanCreateSpanFromParent.end();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    AutoCloseableKt.closeFinally(scopeMakeCurrentSpan, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            try {
                spanCreateSpanFromParent.setStatus(StatusCode.ERROR);
                spanCreateSpanFromParent.setAttribute(AttributeName.passkey_operation_type.name(), this.requestType);
                spanCreateSpanFromParent.recordException(th3);
                Logger.error("PasskeyReplyChannel:postSuccess", "Reply message failed", th3);
                throw th3;
            } catch (Throwable th4) {
                spanCreateSpanFromParent.end();
                throw th4;
            }
        }
    }

    public final void postError(Throwable throwable) {
        Intrinsics.checkNotNullParameter(throwable, "throwable");
        Span spanCreateSpanFromParent = OTelUtility.createSpanFromParent(SpanName.PasskeyWebListener.name(), this.spanContext);
        try {
            Scope scopeMakeCurrentSpan = SpanExtension.makeCurrentSpan(spanCreateSpanFromParent);
            try {
                Scope scope = scopeMakeCurrentSpan;
                ReplyMessage.Error errorThrowableToErrorMessage = throwableToErrorMessage(throwable);
                this.replyProxy.postMessage(errorThrowableToErrorMessage.toString());
                spanCreateSpanFromParent.setAttribute(AttributeName.passkey_operation_type.name(), this.requestType);
                spanCreateSpanFromParent.setAttribute(AttributeName.passkey_dom_exception_name.name(), errorThrowableToErrorMessage.getDomExceptionName());
                spanCreateSpanFromParent.setStatus(StatusCode.ERROR);
                spanCreateSpanFromParent.recordException(throwable);
                Logger.error("PasskeyReplyChannel:postError", "RequestType: " + this.requestType + " failed with error: " + errorThrowableToErrorMessage, null);
                Unit unit = Unit.INSTANCE;
                AutoCloseableKt.closeFinally(scopeMakeCurrentSpan, null);
                spanCreateSpanFromParent.end();
            } catch (Throwable th) {
                try {
                    throw th;
                } catch (Throwable th2) {
                    AutoCloseableKt.closeFinally(scopeMakeCurrentSpan, th);
                    throw th2;
                }
            }
        } catch (Throwable th3) {
            try {
                spanCreateSpanFromParent.setStatus(StatusCode.ERROR);
                spanCreateSpanFromParent.recordException(th3);
                spanCreateSpanFromParent.setAttribute(AttributeName.passkey_operation_type.name(), this.requestType);
                Logger.error("PasskeyReplyChannel:postError", "Reply message failed", th3);
                throw th3;
            } catch (Throwable th4) {
                spanCreateSpanFromParent.end();
                throw th4;
            }
        }
    }

    private final ReplyMessage.Error throwableToErrorMessage(Throwable throwable) {
        String message = throwable.getMessage();
        if (message == null) {
            message = "Unknown error (empty message)";
        }
        boolean z = throwable instanceof CreateCredentialCancellationException ? true : throwable instanceof GetCredentialCancellationException ? true : throwable instanceof NoCredentialException;
        String str = DOM_EXCEPTION_NOT_ALLOWED_ERROR;
        if (!z) {
            if (throwable instanceof CreateCredentialInterruptedException ? true : throwable instanceof GetCredentialInterruptedException) {
                str = DOM_EXCEPTION_ABORT_ERROR;
            } else {
                if (throwable instanceof CreateCredentialProviderConfigurationException ? true : throwable instanceof GetCredentialProviderConfigurationException) {
                    str = DOM_EXCEPTION_NOT_SUPPORTED_ERROR;
                } else {
                    if (throwable instanceof CreateCredentialUnknownException ? true : throwable instanceof GetCredentialUnknownException) {
                        str = DOM_EXCEPTION_UNKNOWN_ERROR;
                    }
                }
            }
        }
        return new ReplyMessage.Error(message, str, this.requestType);
    }
}

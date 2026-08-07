package com.microsoft.identity.common.internal.ui.webview.switchbrowser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import com.microsoft.identity.common.adal.internal.AuthenticationConstants;
import com.microsoft.identity.common.internal.providers.oauth2.SwitchBrowserActivity;
import com.microsoft.identity.common.internal.ui.webview.challengehandlers.SwitchBrowserRequestHandler;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.opentelemetry.AttributeName;
import com.microsoft.identity.common.java.opentelemetry.OTelUtility;
import com.microsoft.identity.common.java.opentelemetry.SpanExtension;
import com.microsoft.identity.common.java.opentelemetry.SpanName;
import com.microsoft.identity.common.logging.Logger;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.api.trace.StatusCode;
import io.opentelemetry.context.Scope;
import java.util.HashMap;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: SwitchBrowserProtocolCoordinator.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u001f2\u00020\u0001:\u0001\u001fB\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u0006B\u0019\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\tJ\u0006\u0010\u0012\u001a\u00020\u0013JL\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u001924\u0010\u001a\u001a0\u0012\u0004\u0012\u00020\u001c\u0012 \u0012\u001e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00170\u001dj\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0017`\u001e\u0012\u0004\u0012\u00020\u00150\u001bR\u001b\u0010\n\u001a\u00020\u000b8FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u000e\u0010\u000f\u001a\u0004\b\f\u0010\rR\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0007\u001a\u00020\b¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006 "}, d2 = {"Lcom/microsoft/identity/common/internal/ui/webview/switchbrowser/SwitchBrowserProtocolCoordinator;", "", "activity", "Landroid/app/Activity;", "spanContext", "Lio/opentelemetry/api/trace/SpanContext;", "(Landroid/app/Activity;Lio/opentelemetry/api/trace/SpanContext;)V", "switchBrowserRequestHandler", "Lcom/microsoft/identity/common/internal/ui/webview/challengehandlers/SwitchBrowserRequestHandler;", "(Lcom/microsoft/identity/common/internal/ui/webview/challengehandlers/SwitchBrowserRequestHandler;Lio/opentelemetry/api/trace/SpanContext;)V", "span", "Lio/opentelemetry/api/trace/Span;", "getSpan", "()Lio/opentelemetry/api/trace/Span;", "span$delegate", "Lkotlin/Lazy;", "getSwitchBrowserRequestHandler", "()Lcom/microsoft/identity/common/internal/ui/webview/challengehandlers/SwitchBrowserRequestHandler;", "isExpectingSwitchBrowserResume", "", "processSwitchBrowserResume", "", "authorizationRequest", "", "extras", "Landroid/os/Bundle;", "onSuccessAction", "Lkotlin/Function2;", "Landroid/net/Uri;", "Ljava/util/HashMap;", "Lkotlin/collections/HashMap;", "Companion", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SwitchBrowserProtocolCoordinator {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "SwitchBrowserProtocolCoordinator";

    /* JADX INFO: renamed from: span$delegate, reason: from kotlin metadata */
    private final Lazy span;
    private final SpanContext spanContext;
    private final SwitchBrowserRequestHandler switchBrowserRequestHandler;

    public SwitchBrowserProtocolCoordinator(SwitchBrowserRequestHandler switchBrowserRequestHandler, SpanContext spanContext) {
        Intrinsics.checkNotNullParameter(switchBrowserRequestHandler, "switchBrowserRequestHandler");
        this.switchBrowserRequestHandler = switchBrowserRequestHandler;
        this.spanContext = spanContext;
        this.span = LazyKt.lazy(new Function0<Span>() { // from class: com.microsoft.identity.common.internal.ui.webview.switchbrowser.SwitchBrowserProtocolCoordinator$span$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Span invoke() {
                return OTelUtility.createSpanFromParent(SpanName.SwitchBrowserResume.name(), this.this$0.spanContext);
            }
        });
    }

    public /* synthetic */ SwitchBrowserProtocolCoordinator(SwitchBrowserRequestHandler switchBrowserRequestHandler, SpanContext spanContext, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(switchBrowserRequestHandler, (i & 2) != 0 ? null : spanContext);
    }

    public final SwitchBrowserRequestHandler getSwitchBrowserRequestHandler() {
        return this.switchBrowserRequestHandler;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SwitchBrowserProtocolCoordinator(Activity activity, SpanContext spanContext) {
        this(new SwitchBrowserRequestHandler(activity, spanContext), spanContext);
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    public final Span getSpan() {
        return (Span) this.span.getValue();
    }

    /* JADX INFO: compiled from: SwitchBrowserProtocolCoordinator.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0004J\u0018\u0010\n\u001a\u00020\u000b2\b\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/microsoft/identity/common/internal/ui/webview/switchbrowser/SwitchBrowserProtocolCoordinator$Companion;", "", "()V", "TAG", "", "getIntentToResumeWebViewAuth", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "intentDataString", "isSwitchBrowserResume", "", "url", "redirectUrl", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean isSwitchBrowserResume(String url, String redirectUrl) {
            Intrinsics.checkNotNullParameter(redirectUrl, "redirectUrl");
            return SwitchBrowserUriHelper.INSTANCE.isSwitchBrowserRedirectUrl(url, redirectUrl, AuthenticationConstants.SWITCH_BROWSER.RESUME_PATH);
        }

        public final Intent getIntentToResumeWebViewAuth(Context context, String intentDataString) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intentDataString, "intentDataString");
            Uri uri = Uri.parse(intentDataString);
            Intrinsics.checkExpressionValueIsNotNull(uri, "Uri.parse(this)");
            Intent intent = new Intent(context, (Class<?>) SwitchBrowserActivity.class);
            intent.putExtra(AuthenticationConstants.SWITCH_BROWSER.ACTION_URI, uri.getQueryParameter(AuthenticationConstants.SWITCH_BROWSER.ACTION_URI));
            intent.putExtra("code", uri.getQueryParameter("code"));
            intent.putExtra("state", uri.getQueryParameter("state"));
            intent.putExtra(SwitchBrowserActivity.RESUME_REQUEST, true);
            return intent;
        }
    }

    public final void processSwitchBrowserResume(String authorizationRequest, Bundle extras, Function2<? super Uri, ? super HashMap<String, String>, Unit> onSuccessAction) throws ClientException {
        String str;
        Intrinsics.checkNotNullParameter(authorizationRequest, "authorizationRequest");
        Intrinsics.checkNotNullParameter(extras, "extras");
        Intrinsics.checkNotNullParameter(onSuccessAction, "onSuccessAction");
        Scope scopeMakeCurrentSpan = SpanExtension.makeCurrentSpan(getSpan());
        try {
            Scope scope = scopeMakeCurrentSpan;
            String string = extras.getString(AuthenticationConstants.SWITCH_BROWSER.ACTION_URI);
            String string2 = extras.getString("code");
            String string3 = extras.getString("state");
            String str2 = string;
            if (str2 != null && str2.length() != 0 && (str = string2) != null && str.length() != 0) {
                SwitchBrowserUriHelper.INSTANCE.statesMatch(authorizationRequest, string3);
                onSuccessAction.invoke(SwitchBrowserUriHelper.INSTANCE.buildResumeUri(string, string3), MapsKt.hashMapOf(TuplesKt.to("Authorization", "Bearer " + string2)));
                this.switchBrowserRequestHandler.resetChallengeState();
                Logger.info("SwitchBrowserProtocolCoordinator:processSwitchBrowserResume", "Switch browser resume action processed successfully.");
                getSpan().setAttribute(AttributeName.is_switch_browser_resume_handled.name(), true);
                getSpan().setStatus(StatusCode.OK);
                getSpan().end();
                Unit unit = Unit.INSTANCE;
                AutoCloseableKt.closeFinally(scopeMakeCurrentSpan, null);
                return;
            }
            String str3 = string;
            String str4 = string2;
            ClientException clientException = new ClientException(ClientException.MISSING_PARAMETER, "Action URI is null/empty: " + (str3 == null || str3.length() == 0) + ", code is null/empty: " + (str4 == null || str4.length() == 0) + '.');
            getSpan().setStatus(StatusCode.ERROR);
            getSpan().recordException(clientException);
            getSpan().end();
            throw clientException;
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                AutoCloseableKt.closeFinally(scopeMakeCurrentSpan, th);
                throw th2;
            }
        }
    }

    public final boolean isExpectingSwitchBrowserResume() {
        Logger.verbose("SwitchBrowserProtocolCoordinator:isExpectingSwitchBrowserResume", "ExpectingRequest: " + this.switchBrowserRequestHandler.getIsSwitchBrowserChallengeActive());
        return this.switchBrowserRequestHandler.getIsSwitchBrowserChallengeActive();
    }
}

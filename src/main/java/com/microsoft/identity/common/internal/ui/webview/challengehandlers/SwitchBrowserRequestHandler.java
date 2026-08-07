package com.microsoft.identity.common.internal.ui.webview.challengehandlers;

import android.app.Activity;
import android.content.Intent;
import com.microsoft.identity.common.internal.providers.oauth2.SwitchBrowserActivity;
import com.microsoft.identity.common.internal.ui.browser.AndroidBrowserSelector;
import com.microsoft.identity.common.internal.ui.webview.switchbrowser.SwitchBrowserUriHelper;
import com.microsoft.identity.common.java.browser.Browser;
import com.microsoft.identity.common.java.browser.IBrowserSelector;
import com.microsoft.identity.common.java.exception.ClientException;
import com.microsoft.identity.common.java.opentelemetry.AttributeName;
import com.microsoft.identity.common.java.opentelemetry.OTelUtility;
import com.microsoft.identity.common.java.opentelemetry.SpanExtension;
import com.microsoft.identity.common.java.opentelemetry.SpanName;
import com.microsoft.identity.common.java.ui.BrowserDescriptor;
import com.microsoft.identity.common.logging.Logger;
import io.opentelemetry.api.trace.Span;
import io.opentelemetry.api.trace.SpanContext;
import io.opentelemetry.api.trace.StatusCode;
import io.opentelemetry.context.Scope;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jdk7.AutoCloseableKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: compiled from: SwitchBrowserRequestHandler.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\u0006\u0018\u0000 \u001e2\u000e\u0012\u0004\u0012\u00020\u0002\u0012\u0004\u0012\u00020\u00030\u0001:\u0001\u001eB\u0019\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\bB\u001f\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007¢\u0006\u0002\u0010\u000bJ\u0018\u0010\u0017\u001a\u00020\r2\b\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u001a\u001a\u00020\u0019J\u0010\u0010\u001b\u001a\u00020\u00032\u0006\u0010\u001c\u001a\u00020\u0002H\u0016J\u0006\u0010\u001d\u001a\u00020\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\f\u001a\u00020\rX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u001b\u0010\u0011\u001a\u00020\u00128FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u0015\u0010\u0016\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001f"}, d2 = {"Lcom/microsoft/identity/common/internal/ui/webview/challengehandlers/SwitchBrowserRequestHandler;", "Lcom/microsoft/identity/common/internal/ui/webview/challengehandlers/IChallengeHandler;", "Lcom/microsoft/identity/common/internal/ui/webview/challengehandlers/SwitchBrowserChallenge;", "", "activity", "Landroid/app/Activity;", "spanContext", "Lio/opentelemetry/api/trace/SpanContext;", "(Landroid/app/Activity;Lio/opentelemetry/api/trace/SpanContext;)V", "browserSelector", "Lcom/microsoft/identity/common/java/browser/IBrowserSelector;", "(Landroid/app/Activity;Lcom/microsoft/identity/common/java/browser/IBrowserSelector;Lio/opentelemetry/api/trace/SpanContext;)V", "isSwitchBrowserChallengeActive", "", "()Z", "setSwitchBrowserChallengeActive", "(Z)V", "span", "Lio/opentelemetry/api/trace/Span;", "getSpan", "()Lio/opentelemetry/api/trace/Span;", "span$delegate", "Lkotlin/Lazy;", "isSwitchBrowserRequest", "url", "", "redirectUrl", "processChallenge", "switchBrowserChallenge", "resetChallengeState", "Companion", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class SwitchBrowserRequestHandler implements IChallengeHandler<SwitchBrowserChallenge, Unit> {
    private static final String TAG = Reflection.getOrCreateKotlinClass(SwitchBrowserRequestHandler.class).getSimpleName();
    private final Activity activity;
    private final IBrowserSelector browserSelector;
    private boolean isSwitchBrowserChallengeActive;

    /* JADX INFO: renamed from: span$delegate, reason: from kotlin metadata */
    private final Lazy span;
    private final SpanContext spanContext;

    public SwitchBrowserRequestHandler(Activity activity, IBrowserSelector browserSelector, SpanContext spanContext) {
        Intrinsics.checkNotNullParameter(activity, "activity");
        Intrinsics.checkNotNullParameter(browserSelector, "browserSelector");
        this.activity = activity;
        this.browserSelector = browserSelector;
        this.spanContext = spanContext;
        this.span = LazyKt.lazy(new Function0<Span>() { // from class: com.microsoft.identity.common.internal.ui.webview.challengehandlers.SwitchBrowserRequestHandler$span$2
            {
                super(0);
            }

            /* JADX WARN: Can't rename method to resolve collision */
            @Override // kotlin.jvm.functions.Function0
            public final Span invoke() {
                return OTelUtility.createSpanFromParent(SpanName.SwitchBrowserProcess.name(), this.this$0.spanContext);
            }
        });
    }

    @Override // com.microsoft.identity.common.internal.ui.webview.challengehandlers.IChallengeHandler
    public /* bridge */ /* synthetic */ Unit processChallenge(SwitchBrowserChallenge switchBrowserChallenge) throws Exception {
        processChallenge2(switchBrowserChallenge);
        return Unit.INSTANCE;
    }

    public final Span getSpan() {
        return (Span) this.span.getValue();
    }

    /* JADX INFO: renamed from: isSwitchBrowserChallengeActive, reason: from getter */
    public final boolean getIsSwitchBrowserChallengeActive() {
        return this.isSwitchBrowserChallengeActive;
    }

    public final void setSwitchBrowserChallengeActive(boolean z) {
        this.isSwitchBrowserChallengeActive = z;
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public SwitchBrowserRequestHandler(Activity activity, SpanContext spanContext) {
        this(activity, new AndroidBrowserSelector(activity.getApplicationContext()), spanContext);
        Intrinsics.checkNotNullParameter(activity, "activity");
    }

    /* JADX INFO: renamed from: processChallenge, reason: avoid collision after fix types in other method */
    public void processChallenge2(SwitchBrowserChallenge switchBrowserChallenge) throws Exception {
        Intrinsics.checkNotNullParameter(switchBrowserChallenge, "switchBrowserChallenge");
        Scope scopeMakeCurrentSpan = SpanExtension.makeCurrentSpan(getSpan());
        try {
            Scope scope = scopeMakeCurrentSpan;
            String str = TAG + ":processChallenge";
            SwitchBrowserUriHelper.INSTANCE.statesMatch(switchBrowserChallenge.getAuthorizationUrl(), switchBrowserChallenge.getProcessUri().getQueryParameter("state"));
            Browser browserSelectBrowser = this.browserSelector.selectBrowser(BrowserDescriptor.getBrowserSafeListForSwitchBrowser(), null);
            if (browserSelectBrowser == null) {
                ClientException clientException = new ClientException(ClientException.NO_BROWSERS_AVAILABLE, "No browser found for SwitchBrowserChallenge.");
                Logger.error(str, "No browser found for SwitchBrowserChallenge.", clientException);
                getSpan().setStatus(StatusCode.ERROR);
                getSpan().recordException(clientException);
                getSpan().end();
                throw clientException;
            }
            getSpan().setAttribute(AttributeName.browser_package_name.name(), browserSelectBrowser.getPackageName());
            getSpan().setAttribute(AttributeName.is_custom_tabs_supported.name(), browserSelectBrowser.isCustomTabsServiceSupported());
            Intent intent = new Intent(this.activity, (Class<?>) SwitchBrowserActivity.class);
            intent.putExtra(SwitchBrowserActivity.BROWSER_PACKAGE_NAME, browserSelectBrowser.getPackageName());
            intent.putExtra(SwitchBrowserActivity.BROWSER_SUPPORTS_CUSTOM_TABS, browserSelectBrowser.isCustomTabsServiceSupported());
            intent.putExtra(SwitchBrowserActivity.PROCESS_URI, switchBrowserChallenge.getProcessUri().toString());
            intent.setFlags(268435456);
            this.activity.startActivity(intent);
            getSpan().setStatus(StatusCode.OK);
            this.isSwitchBrowserChallengeActive = true;
            getSpan().end();
            Unit unit = Unit.INSTANCE;
            AutoCloseableKt.closeFinally(scopeMakeCurrentSpan, null);
        } catch (Throwable th) {
            try {
                throw th;
            } catch (Throwable th2) {
                AutoCloseableKt.closeFinally(scopeMakeCurrentSpan, th);
                throw th2;
            }
        }
    }

    public final boolean isSwitchBrowserRequest(String url, String redirectUrl) {
        Intrinsics.checkNotNullParameter(redirectUrl, "redirectUrl");
        return SwitchBrowserUriHelper.INSTANCE.isSwitchBrowserRedirectUrl(url, redirectUrl, "switch_browser");
    }

    public final void resetChallengeState() {
        this.isSwitchBrowserChallengeActive = false;
    }
}

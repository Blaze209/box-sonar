package com.microsoft.identity.common.internal.ui.webview;

import android.net.Uri;
import java.util.Collection;
import java.util.Set;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import sdk.pendo.io.utilities.script.JavascriptRunner;

/* JADX INFO: compiled from: JsScriptRecord.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 \u000e2\u00020\u0001:\u0001\u000eB%\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u000e\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0003R\u0016\u0010\u0005\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\t¨\u0006\u000f"}, d2 = {"Lcom/microsoft/identity/common/internal/ui/webview/JsScriptRecord;", "", "id", "", JavascriptRunner.SCRIPT_NAME, "allowedUrls", "", "(Ljava/lang/String;Ljava/lang/String;Ljava/util/Set;)V", "getId", "()Ljava/lang/String;", "getScript", "isAllowedForUrl", "", "url", "Companion", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class JsScriptRecord {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final Set<String> SOVEREIGN_CLOUD_URL_WITH_EXTRA_VALIDATION = SetsKt.setOf((Object[]) new String[]{"https://login.microsoftonline.us", "https://login.microsoftonline.microsoft.scloud", "https://login.microsoftonline.eaglex.ic.gov"});
    private final Set<String> allowedUrls;
    private final String id;
    private final String script;

    public JsScriptRecord(String id, String script, Set<String> set) {
        Intrinsics.checkNotNullParameter(id, "id");
        Intrinsics.checkNotNullParameter(script, "script");
        this.id = id;
        this.script = script;
        this.allowedUrls = set;
    }

    public final String getId() {
        return this.id;
    }

    public final String getScript() {
        return this.script;
    }

    /* JADX INFO: compiled from: JsScriptRecord.kt */
    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\"\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\b"}, d2 = {"Lcom/microsoft/identity/common/internal/ui/webview/JsScriptRecord$Companion;", "", "()V", "SOVEREIGN_CLOUD_URL_WITH_EXTRA_VALIDATION", "", "", "getSOVEREIGN_CLOUD_URL_WITH_EXTRA_VALIDATION", "()Ljava/util/Set;", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Set<String> getSOVEREIGN_CLOUD_URL_WITH_EXTRA_VALIDATION() {
            return JsScriptRecord.SOVEREIGN_CLOUD_URL_WITH_EXTRA_VALIDATION;
        }
    }

    public final boolean isAllowedForUrl(String url) {
        Intrinsics.checkNotNullParameter(url, "url");
        if (this.allowedUrls == null) {
            return true;
        }
        Uri uri = Uri.parse(url);
        Intrinsics.checkExpressionValueIsNotNull(uri, "Uri.parse(this)");
        Set<String> set = this.allowedUrls;
        if ((set instanceof Collection) && set.isEmpty()) {
            return false;
        }
        for (String str : set) {
            Uri uri2 = Uri.parse(str);
            Intrinsics.checkExpressionValueIsNotNull(uri2, "Uri.parse(this)");
            boolean zAreEqual = Intrinsics.areEqual(uri.getScheme(), uri2.getScheme());
            boolean zAreEqual2 = Intrinsics.areEqual(uri.getHost(), uri2.getHost());
            if (zAreEqual && zAreEqual2) {
                if (SOVEREIGN_CLOUD_URL_WITH_EXTRA_VALIDATION.contains(str)) {
                    String path = uri.getPath();
                    if (path != null) {
                        Intrinsics.checkNotNullExpressionValue(path, "path");
                        if (StringsKt.contains((CharSequence) path, (CharSequence) "fido", true)) {
                        }
                    } else {
                        continue;
                    }
                }
                return true;
            }
        }
        return false;
    }
}

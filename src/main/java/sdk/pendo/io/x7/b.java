package sdk.pendo.io.x7;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextPaint;
import android.text.style.URLSpan;
import android.view.View;
import androidx.media3.exoplayer.upstream.CmcdData;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import sdk.pendo.io.logging.PendoLogger;

/* JADX INFO: loaded from: classes6.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u000e\u001a\u00020\r¢\u0006\u0004\b\u000f\u0010\u0010J\u0010\u0010\u0005\u001a\u00020\u00042\u0006\u0010\u0003\u001a\u00020\u0002H\u0002J\u0010\u0010\t\u001a\u00020\b2\u0006\u0010\u0007\u001a\u00020\u0006H\u0016J\u0010\u0010\f\u001a\u00020\b2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u0011"}, d2 = {"Lsdk/pendo/io/x7/b;", "Landroid/text/style/URLSpan;", "Landroid/net/Uri;", "uri", "Landroid/content/Intent;", CmcdData.OBJECT_TYPE_AUDIO_ONLY, "Landroid/text/TextPaint;", "drawState", "", "updateDrawState", "Landroid/view/View;", "widget", ViewProps.ON_CLICK, "", "url", "<init>", "(Ljava/lang/String;)V", "pendoIO_release"}, k = 1, mv = {1, 9, 0})
public final class b extends URLSpan {
    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public b(String url) {
        super(url);
        Intrinsics.checkNotNullParameter(url, "url");
    }

    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    /* JADX WARN: Code restructure failed: missing block: B:11:0x0025, code lost:
    
        if (r1.equals("smsto") == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:14:0x002e, code lost:
    
        if (r1.equals("mmsto") != false) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0038, code lost:
    
        if (r1.equals("tel") == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0042, code lost:
    
        if (r1.equals(com.microsoft.identity.common.java.nativeauth.providers.NativeAuthConstants.ChallengeChannel.SMS) == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:23:0x004c, code lost:
    
        if (r1.equals("sip") == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0056, code lost:
    
        return new android.content.Intent("android.intent.action.DIAL", r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x005d, code lost:
    
        if (r1.equals("mms") == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x0066, code lost:
    
        if (r1.equals("mailto") == false) goto L35;
     */
    /* JADX WARN: Code restructure failed: missing block: B:34:0x0070, code lost:
    
        return new android.content.Intent("android.intent.action.SENDTO", r2);
     */
    /* JADX WARN: Failed to restore switch over string. Please report as a decompilation issue */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    private final android.content.Intent a(android.net.Uri r2) {
        /*
            r1 = this;
            java.lang.String r1 = r2.getScheme()
            if (r1 == 0) goto L13
            java.util.Locale r0 = java.util.Locale.ROOT
            java.lang.String r1 = r1.toLowerCase(r0)
            java.lang.String r0 = "this as java.lang.String).toLowerCase(Locale.ROOT)"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r1, r0)
            goto L14
        L13:
            r1 = 0
        L14:
            if (r1 == 0) goto L71
            int r0 = r1.hashCode()
            switch(r0) {
                case -1081572750: goto L60;
                case 108243: goto L57;
                case 113882: goto L45;
                case 114009: goto L3b;
                case 114715: goto L31;
                case 104025230: goto L28;
                case 109566356: goto L1e;
                default: goto L1d;
            }
        L1d:
            goto L71
        L1e:
            java.lang.String r0 = "smsto"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L69
            goto L71
        L28:
            java.lang.String r0 = "mmsto"
            boolean r1 = r1.equals(r0)
            if (r1 == 0) goto L71
            goto L69
        L31:
            java.lang.String r0 = "tel"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L4f
            goto L71
        L3b:
            java.lang.String r0 = "sms"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L69
            goto L71
        L45:
            java.lang.String r0 = "sip"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L4f
            goto L71
        L4f:
            android.content.Intent r1 = new android.content.Intent
            java.lang.String r0 = "android.intent.action.DIAL"
            r1.<init>(r0, r2)
            return r1
        L57:
            java.lang.String r0 = "mms"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L69
            goto L71
        L60:
            java.lang.String r0 = "mailto"
            boolean r1 = r1.equals(r0)
            if (r1 != 0) goto L69
            goto L71
        L69:
            android.content.Intent r1 = new android.content.Intent
            java.lang.String r0 = "android.intent.action.SENDTO"
            r1.<init>(r0, r2)
            return r1
        L71:
            android.content.Intent r1 = new android.content.Intent
            java.lang.String r0 = "android.intent.action.VIEW"
            r1.<init>(r0, r2)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: sdk.pendo.io.x7.b.a(android.net.Uri):android.content.Intent");
    }

    @Override // android.text.style.URLSpan, android.text.style.ClickableSpan
    public void onClick(View widget) {
        Intrinsics.checkNotNullParameter(widget, "widget");
        Context context = widget.getContext();
        String url = getURL();
        Intrinsics.checkNotNullExpressionValue(url, "getURL(...)");
        Uri uri = Uri.parse(url);
        Intrinsics.checkNotNullExpressionValue(uri, "parse(this)");
        Intent intentA = a(uri);
        if (!(context instanceof Activity)) {
            intentA.addFlags(268435456);
        }
        try {
            context.startActivity(intentA);
        } catch (Exception e) {
            PendoLogger.i("PNDURLSpan", String.valueOf(e.getMessage()));
        }
    }

    @Override // android.text.style.ClickableSpan, android.text.style.CharacterStyle
    public void updateDrawState(TextPaint drawState) {
        Intrinsics.checkNotNullParameter(drawState, "drawState");
        drawState.setUnderlineText(true);
    }
}

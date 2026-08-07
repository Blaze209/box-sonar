package com.box.android.preview.boxcanvas;

import android.net.Uri;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import com.box.androidsdk.content.utils.BoxLogUtils;
import java.io.IOException;
import javax.inject.Inject;
import javax.inject.Named;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

/* JADX INFO: compiled from: CanvasAuthorizer.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0013\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0018\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\nJ\u0018\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0007H\u0007R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/box/android/preview/boxcanvas/CanvasAuthorizer;", "", "client", "Lokhttp3/OkHttpClient;", "<init>", "(Lokhttp3/OkHttpClient;)V", BoxNoteConstants.NOTES_BUILDER_AUTH_CODE, "", "accessToken", "authorizationURL", "Landroid/net/Uri;", "authorizeCall", "Lokhttp3/Call;", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CanvasAuthorizer {
    public static final int $stable = 8;
    private final OkHttpClient client;

    @Inject
    public CanvasAuthorizer(@Named("canvas-authorizer-http-client") OkHttpClient client) {
        Intrinsics.checkNotNullParameter(client, "client");
        this.client = client;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v5, types: [java.lang.String] */
    public final String authCode(String accessToken, Uri authorizationURL) {
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        Intrinsics.checkNotNullParameter(authorizationURL, "authorizationURL");
        try {
            String string = authorizationURL.toString();
            Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
            Response responseExecute = authorizeCall(accessToken, string).execute();
            while (responseExecute.isRedirect()) {
                Uri uri = Uri.parse(Response.header$default(responseExecute, "Location", null, 2, null));
                if (uri.getQueryParameter("code") != null) {
                    this = uri.getQueryParameter("code");
                    return this;
                }
                if (uri != null) {
                    String string2 = uri.toString();
                    Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
                    responseExecute = authorizeCall(accessToken, string2).execute();
                }
            }
        } catch (IOException e) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Authorization request failed: " + e.getMessage());
        } catch (NullPointerException e2) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Location header was not found: " + e2.getMessage());
        }
        return null;
    }

    public final Call authorizeCall(String accessToken, String authorizationURL) {
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        Intrinsics.checkNotNullParameter(authorizationURL, "authorizationURL");
        return this.client.newCall(new Request.Builder().url(authorizationURL).get().addHeader("Authorization", "Bearer " + accessToken).build());
    }
}

package com.box.android.preview.boxcanvas;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import com.box.android.domain.configuration.BoxConfigConstants;
import com.box.android.domain.configuration.ConfigManager;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import com.google.androidbrowserhelper.trusted.LauncherActivity;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxCanvasIntentBuilder.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0019\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J*\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u00152\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0015J&\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0014\u001a\u00020\u00152\b\u0010\u001a\u001a\u0004\u0018\u00010\u00152\n\b\u0002\u0010\u0017\u001a\u0004\u0018\u00010\u0015H\u0007J\b\u0010\u001b\u001a\u00020\u0019H\u0007R\u001a\u0010\u0002\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\u0004\u001a\u00020\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u001d"}, d2 = {"Lcom/box/android/preview/boxcanvas/BoxCanvasIntentBuilder;", "", "configManager", "Lcom/box/android/domain/configuration/ConfigManager;", "canvasAuthorizer", "Lcom/box/android/preview/boxcanvas/CanvasAuthorizer;", "<init>", "(Lcom/box/android/domain/configuration/ConfigManager;Lcom/box/android/preview/boxcanvas/CanvasAuthorizer;)V", "getConfigManager", "()Lcom/box/android/domain/configuration/ConfigManager;", "setConfigManager", "(Lcom/box/android/domain/configuration/ConfigManager;)V", "getCanvasAuthorizer", "()Lcom/box/android/preview/boxcanvas/CanvasAuthorizer;", "setCanvasAuthorizer", "(Lcom/box/android/preview/boxcanvas/CanvasAuthorizer;)V", "getBoxCanvasLaunchIntent", "Landroid/content/Intent;", "context", "Landroid/content/Context;", "fileId", "", "accessToken", "sharedLinkParameter", "launchingURL", "Landroid/net/Uri;", BoxNoteConstants.NOTES_BUILDER_AUTH_CODE, "authorizationURL", "Companion", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxCanvasIntentBuilder {
    private static final String CANVAS_BUILDER_CLIENT_ID = "client_id";
    private static final String CANVAS_BUILDER_CODE = "code";
    private static final String CANVAS_BUILDER_REDIRECT_URI = "redirect_uri";
    private static final String CANVAS_BUILDER_RESPONSE_TYPE = "response_type";
    private static final String CANVAS_BUILDER_SHARED_LINK = "s";
    private CanvasAuthorizer canvasAuthorizer;
    private ConfigManager configManager;
    public static final int $stable = 8;

    @Inject
    public BoxCanvasIntentBuilder(ConfigManager configManager, CanvasAuthorizer canvasAuthorizer) {
        Intrinsics.checkNotNullParameter(configManager, "configManager");
        Intrinsics.checkNotNullParameter(canvasAuthorizer, "canvasAuthorizer");
        this.configManager = configManager;
        this.canvasAuthorizer = canvasAuthorizer;
    }

    public final CanvasAuthorizer getCanvasAuthorizer() {
        return this.canvasAuthorizer;
    }

    public final ConfigManager getConfigManager() {
        return this.configManager;
    }

    public final void setCanvasAuthorizer(CanvasAuthorizer canvasAuthorizer) {
        Intrinsics.checkNotNullParameter(canvasAuthorizer, "<set-?>");
        this.canvasAuthorizer = canvasAuthorizer;
    }

    public final void setConfigManager(ConfigManager configManager) {
        Intrinsics.checkNotNullParameter(configManager, "<set-?>");
        this.configManager = configManager;
    }

    public static /* synthetic */ Intent getBoxCanvasLaunchIntent$default(BoxCanvasIntentBuilder boxCanvasIntentBuilder, Context context, String str, String str2, String str3, int i, Object obj) {
        if ((i & 8) != 0) {
            str3 = null;
        }
        return boxCanvasIntentBuilder.getBoxCanvasLaunchIntent(context, str, str2, str3);
    }

    public final Intent getBoxCanvasLaunchIntent(Context context, String fileId, String accessToken, String sharedLinkParameter) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        Intrinsics.checkNotNullParameter(accessToken, "accessToken");
        Intent intent = new Intent(context, (Class<?>) LauncherActivity.class);
        intent.setData(launchingURL(fileId, this.canvasAuthorizer.authCode(accessToken, authorizationURL()), sharedLinkParameter));
        return intent;
    }

    public static /* synthetic */ Uri launchingURL$default(BoxCanvasIntentBuilder boxCanvasIntentBuilder, String str, String str2, String str3, int i, Object obj) {
        if ((i & 4) != 0) {
            str3 = null;
        }
        return boxCanvasIntentBuilder.launchingURL(str, str2, str3);
    }

    public final Uri launchingURL(String fileId, String authCode, String sharedLinkParameter) {
        Intrinsics.checkNotNullParameter(fileId, "fileId");
        Uri.Builder builder = new Uri.Builder();
        String string = this.configManager.getString(BoxConfigConstants.CONFIG_KEY_V2_API_URL_HOSTNAME);
        builder.scheme(this.configManager.getString(BoxConfigConstants.CONFIG_KEY_V2_API_URL_SCHEME));
        if (this.configManager.isDevpodEnvironment()) {
            builder.authority("app." + string);
        } else {
            builder.authority(string);
        }
        builder.path(this.configManager.getString(BoxConfigConstants.CONFIG_KEY_BOX_CANVAS_URL_PATH) + "/" + fileId);
        if (sharedLinkParameter != null) {
            builder.appendQueryParameter("s", sharedLinkParameter);
        }
        if (authCode != null) {
            builder.appendQueryParameter("code", authCode);
        }
        Uri uriBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(uriBuild, "build(...)");
        return uriBuild;
    }

    public final Uri authorizationURL() {
        Uri.Builder builder = new Uri.Builder();
        String string = this.configManager.getString(BoxConfigConstants.CONFIG_KEY_V2_API_URL_HOSTNAME);
        builder.scheme(this.configManager.getString(BoxConfigConstants.CONFIG_KEY_V2_API_URL_SCHEME));
        if (this.configManager.isDevpodEnvironment()) {
            builder.authority("app." + string);
        } else {
            builder.authority(string);
        }
        builder.path(this.configManager.getString(BoxConfigConstants.CONFIG_KEY_BOX_CANVAS_OAUTH_PATH));
        builder.appendQueryParameter("client_id", this.configManager.getString(BoxConfigConstants.CONFIG_KEY_BOX_CANVAS_SERVICE_CLIENT_ID));
        builder.appendQueryParameter("response_type", "code");
        builder.appendQueryParameter("redirect_uri", this.configManager.getString(BoxConfigConstants.CONFIG_KEY_BOX_CANVAS_REDIRECT_URL));
        Uri uriBuild = builder.build();
        Intrinsics.checkNotNullExpressionValue(uriBuild, "build(...)");
        return uriBuild;
    }
}

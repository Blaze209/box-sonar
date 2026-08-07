package com.box.android.inbox.mfasetup;

import android.net.Uri;
import com.box.android.domain.configuration.BoxConfigConstants;
import com.box.android.domain.configuration.ConfigManager;
import com.microsoft.identity.common.java.telemetry.TelemetryEventStrings;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MfaSetupUrlBuilder.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\b\u0007\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0017\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010\nR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, d2 = {"Lcom/box/android/inbox/mfasetup/MfaSetupUrlBuilder;", "", "configManager", "Lcom/box/android/domain/configuration/ConfigManager;", "<init>", "(Lcom/box/android/domain/configuration/ConfigManager;)V", "generateMfaSetupUrl", "", "mobileSessionId", "", "(Ljava/lang/Long;)Ljava/lang/String;", "Companion", "box_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class MfaSetupUrlBuilder {
    private static final String ACCOUNT_PATH = "account";
    private static final String AUTO_ENABLE_2FA_POPUP = "auto_enable_2fa_popup";
    private static final String MOBILE_APP_REDIRECT = "mobile_app_redirect";
    private static final String MOBILE_SESSION_ID = "mobile_session_id";
    private final ConfigManager configManager;
    public static final int $stable = 8;

    @Inject
    public MfaSetupUrlBuilder(ConfigManager configManager) {
        Intrinsics.checkNotNullParameter(configManager, "configManager");
        this.configManager = configManager;
    }

    public static /* synthetic */ String generateMfaSetupUrl$default(MfaSetupUrlBuilder mfaSetupUrlBuilder, Long l, int i, Object obj) {
        if ((i & 1) != 0) {
            l = null;
        }
        return mfaSetupUrlBuilder.generateMfaSetupUrl(l);
    }

    public final String generateMfaSetupUrl(Long mobileSessionId) {
        String string = this.configManager.getString(BoxConfigConstants.CONFIG_KEY_V2_API_URL_SCHEME);
        Uri.Builder builderAppendQueryParameter = new Uri.Builder().scheme(string).authority(this.configManager.getString(BoxConfigConstants.CONFIG_KEY_V2_API_URL_HOSTNAME)).path("account").appendQueryParameter(AUTO_ENABLE_2FA_POPUP, TelemetryEventStrings.Value.TRUE).appendQueryParameter(MOBILE_APP_REDIRECT, TelemetryEventStrings.Value.TRUE);
        if (mobileSessionId != null) {
            builderAppendQueryParameter.appendQueryParameter(MOBILE_SESSION_ID, String.valueOf(mobileSessionId.longValue()));
        }
        String string2 = builderAppendQueryParameter.build().toString();
        Intrinsics.checkNotNullExpressionValue(string2, "toString(...)");
        return string2;
    }
}

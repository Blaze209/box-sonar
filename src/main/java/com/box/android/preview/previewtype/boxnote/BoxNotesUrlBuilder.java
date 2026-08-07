package com.box.android.preview.previewtype.boxnote;

import android.net.Uri;
import android.text.TextUtils;
import android.webkit.CookieManager;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.data.api.interceptors.auth.SharedLinkAuthInterceptor;
import com.box.android.domain.analytics.BoxAmplitudeAnalytics;
import com.box.android.domain.configuration.BoxConfigConstants;
import com.box.android.domain.configuration.ConfigManager;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.SharedLinkModel;
import com.box.androidsdk.content.utils.SdkUtils;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;

/* JADX INFO: compiled from: BoxNotesUrlBuilder.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0019B\u0011\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u001a\u0010\u000e\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u000f2\u0006\u0010\f\u001a\u00020\rJ(\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\u0016\u001a\u00020\u00102\u0006\u0010\b\u001a\u00020\tH\u0002J \u0010\u0017\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\tH\u0002J\u0010\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0015\u001a\u00020\u0014H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u001a"}, d2 = {"Lcom/box/android/preview/previewtype/boxnote/BoxNotesUrlBuilder;", "", "configManager", "Lcom/box/android/domain/configuration/ConfigManager;", "<init>", "(Lcom/box/android/domain/configuration/ConfigManager;)V", "createOpenBoxNoteUri", "Landroid/net/Uri;", "fileModel", "Lcom/box/android/domain/models/item/FileModel;", "attemptQuickLoad", "", "sessionData", "Lcom/box/android/preview/previewtype/boxnote/BoxNotesUrlBuilder$SessionData;", "buildHeaders", "", "", "buildDevEnvironmentUri", "", "boxNoteUriBuilder", "Landroid/net/Uri$Builder;", "boxNoteRedirectUriBuilder", "authority", "buildProdEnvironmentUri", "hasValidSessionCookie", "SessionData", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxNotesUrlBuilder {
    public static final int $stable = 8;
    private final ConfigManager configManager;

    @Inject
    public BoxNotesUrlBuilder(ConfigManager configManager) {
        Intrinsics.checkNotNullParameter(configManager, "configManager");
        this.configManager = configManager;
    }

    /* JADX INFO: compiled from: BoxNotesUrlBuilder.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0006\u0010\u0007J\t\u0010\f\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J+\u0010\u000f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0010\u001a\u00020\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u0001HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0003HÖ\u0001R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\tR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\t¨\u0006\u0016"}, d2 = {"Lcom/box/android/preview/previewtype/boxnote/BoxNotesUrlBuilder$SessionData;", "", "accessToken", "", BoxNoteConstants.NOTES_BUILDER_SHARED_LINK, "password", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getAccessToken", "()Ljava/lang/String;", "getSharedLink", "getPassword", "component1", "component2", "component3", BoxAmplitudeAnalytics.JobEventPropertyBuilder.JOB_TYPE_COPY_JOB, "equals", "", "other", "hashCode", "", "toString", "preview_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    public static final /* data */ class SessionData {
        public static final int $stable = 0;
        private final String accessToken;
        private final String password;
        private final String sharedLink;

        public static /* synthetic */ SessionData copy$default(SessionData sessionData, String str, String str2, String str3, int i, Object obj) {
            if ((i & 1) != 0) {
                str = sessionData.accessToken;
            }
            if ((i & 2) != 0) {
                str2 = sessionData.sharedLink;
            }
            if ((i & 4) != 0) {
                str3 = sessionData.password;
            }
            return sessionData.copy(str, str2, str3);
        }

        /* JADX INFO: renamed from: component1, reason: from getter */
        public final String getAccessToken() {
            return this.accessToken;
        }

        /* JADX INFO: renamed from: component2, reason: from getter */
        public final String getSharedLink() {
            return this.sharedLink;
        }

        /* JADX INFO: renamed from: component3, reason: from getter */
        public final String getPassword() {
            return this.password;
        }

        public final SessionData copy(String accessToken, String sharedLink, String password) {
            Intrinsics.checkNotNullParameter(accessToken, "accessToken");
            return new SessionData(accessToken, sharedLink, password);
        }

        public boolean equals(Object other) {
            if (this == other) {
                return true;
            }
            if (!(other instanceof SessionData)) {
                return false;
            }
            SessionData sessionData = (SessionData) other;
            return Intrinsics.areEqual(this.accessToken, sessionData.accessToken) && Intrinsics.areEqual(this.sharedLink, sessionData.sharedLink) && Intrinsics.areEqual(this.password, sessionData.password);
        }

        public int hashCode() {
            int iHashCode = this.accessToken.hashCode() * 31;
            String str = this.sharedLink;
            int iHashCode2 = (iHashCode + (str == null ? 0 : str.hashCode())) * 31;
            String str2 = this.password;
            return iHashCode2 + (str2 != null ? str2.hashCode() : 0);
        }

        public String toString() {
            return "SessionData(accessToken=" + this.accessToken + ", sharedLink=" + this.sharedLink + ", password=" + this.password + ")";
        }

        public SessionData(String accessToken, String str, String str2) {
            Intrinsics.checkNotNullParameter(accessToken, "accessToken");
            this.accessToken = accessToken;
            this.sharedLink = str;
            this.password = str2;
        }

        public /* synthetic */ SessionData(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
        }

        public final String getAccessToken() {
            return this.accessToken;
        }

        public final String getPassword() {
            return this.password;
        }

        public final String getSharedLink() {
            return this.sharedLink;
        }
    }

    public final Uri createOpenBoxNoteUri(FileModel fileModel, boolean attemptQuickLoad, SessionData sessionData) {
        String sharedLink;
        Intrinsics.checkNotNullParameter(fileModel, "fileModel");
        Intrinsics.checkNotNullParameter(sessionData, "sessionData");
        Uri.Builder builder = new Uri.Builder();
        String string = this.configManager.getString(BoxConfigConstants.CONFIG_KEY_V2_API_URL_HOSTNAME);
        Uri.Builder builder2 = new Uri.Builder();
        if (this.configManager.isDevpodEnvironment()) {
            Intrinsics.checkNotNull(string);
            buildDevEnvironmentUri(builder, builder2, string, fileModel);
        } else {
            buildProdEnvironmentUri(builder, builder2, fileModel);
        }
        SharedLinkModel sharedLink2 = fileModel.getSharedLink();
        if (sharedLink2 == null || (sharedLink = sharedLink2.getUrl()) == null) {
            sharedLink = sessionData.getSharedLink();
        }
        if (!SdkUtils.isBlank(sharedLink)) {
            builder2.appendQueryParameter(BoxNoteConstants.NOTES_BUILDER_SHARED_LINK, sharedLink);
        }
        if (attemptQuickLoad && hasValidSessionCookie(builder2)) {
            builder2.appendQueryParameter(BoxNoteConstants.NOTES_BUILDER_AUTH_CODE, "nonsense");
            Uri uriBuild = builder2.build();
            Intrinsics.checkNotNullExpressionValue(uriBuild, "build(...)");
            return uriBuild;
        }
        builder.appendQueryParameter("redirect_uri", builder2.build().toString());
        Uri uriBuild2 = builder.build();
        Intrinsics.checkNotNullExpressionValue(uriBuild2, "build(...)");
        return uriBuild2;
    }

    public final Map<String, String> buildHeaders(SessionData sessionData) {
        Intrinsics.checkNotNullParameter(sessionData, "sessionData");
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        linkedHashMap.put("Authorization", "Bearer " + sessionData.getAccessToken());
        if (!TextUtils.isEmpty(sessionData.getSharedLink())) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String str = String.format(Locale.ENGLISH, "shared_link=%s", Arrays.copyOf(new Object[]{sessionData.getSharedLink()}, 1));
            Intrinsics.checkNotNullExpressionValue(str, "format(...)");
            if (!TextUtils.isEmpty(sessionData.getPassword())) {
                StringCompanionObject stringCompanionObject2 = StringCompanionObject.INSTANCE;
                String str2 = String.format(Locale.ENGLISH, "&shared_link_password=%s", Arrays.copyOf(new Object[]{sessionData.getPassword()}, 1));
                Intrinsics.checkNotNullExpressionValue(str2, "format(...)");
                str = str + str2;
            }
            linkedHashMap.put(SharedLinkAuthInterceptor.HEADER_AUTH_SHARED_LINK, str);
        }
        return linkedHashMap;
    }

    private final void buildDevEnvironmentUri(Uri.Builder boxNoteUriBuilder, Uri.Builder boxNoteRedirectUriBuilder, String authority, FileModel fileModel) {
        boxNoteUriBuilder.scheme(this.configManager.getString(BoxConfigConstants.CONFIG_KEY_V2_API_URL_SCHEME));
        boxNoteUriBuilder.authority(authority);
        boxNoteUriBuilder.path(BoxConfigConstants.CONFIG_BOX_CANVAS_OAUTH_PATH);
        boxNoteUriBuilder.appendQueryParameter("client_id", this.configManager.getString(BoxConfigConstants.CONFIG_KEY_BOX_NOTES_SERVICE_CLIENT_ID));
        boxNoteUriBuilder.appendQueryParameter("response_type", "code");
        boxNoteRedirectUriBuilder.scheme(this.configManager.getString(BoxConfigConstants.CONFIG_KEY_BOX_NOTES_URL_SCHEME));
        boxNoteRedirectUriBuilder.authority("app." + this.configManager.getString(BoxConfigConstants.CONFIG_KEY_BOX_NOTES_URL_HOSTNAME));
        boxNoteRedirectUriBuilder.path(this.configManager.getString(BoxConfigConstants.CONFIG_KEY_BOX_NOTES_URL_PATH));
        boxNoteRedirectUriBuilder.appendQueryParameter("fileId", fileModel.boxIdOrNull());
    }

    private final void buildProdEnvironmentUri(Uri.Builder boxNoteUriBuilder, Uri.Builder boxNoteRedirectUriBuilder, FileModel fileModel) {
        boxNoteUriBuilder.scheme(this.configManager.getString(BoxConfigConstants.CONFIG_KEY_V2_API_URL_SCHEME));
        boxNoteUriBuilder.authority(this.configManager.getString(BoxConfigConstants.CONFIG_KEY_V2_API_URL_HOSTNAME));
        boxNoteUriBuilder.path(this.configManager.getString(BoxConfigConstants.CONFIG_KEY_BOX_NOTES_OAUTH_PATH));
        boxNoteUriBuilder.appendQueryParameter("client_id", this.configManager.getString(BoxConfigConstants.CONFIG_KEY_BOX_NOTES_SERVICE_CLIENT_ID));
        boxNoteUriBuilder.appendQueryParameter("response_type", "code");
        boxNoteRedirectUriBuilder.scheme(this.configManager.getString(BoxConfigConstants.CONFIG_KEY_BOX_NOTES_URL_SCHEME));
        boxNoteRedirectUriBuilder.authority(this.configManager.getString(BoxConfigConstants.CONFIG_KEY_BOX_NOTES_URL_HOSTNAME));
        boxNoteRedirectUriBuilder.path(this.configManager.getString(BoxConfigConstants.CONFIG_KEY_BOX_NOTES_URL_PATH));
        boxNoteRedirectUriBuilder.appendQueryParameter("fileId", fileModel.boxIdOrNull());
    }

    private final boolean hasValidSessionCookie(Uri.Builder boxNoteRedirectUriBuilder) {
        return !TextUtils.isEmpty(CommonBoxUtil.parseCookies(CookieManager.getInstance().getCookie(boxNoteRedirectUriBuilder.build().toString())).get(BoxNoteConstants.NOTES_SESSION_ID_COOKIE_KEY));
    }
}

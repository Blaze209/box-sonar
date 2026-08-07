package com.box.android.coreservices.models;

import android.net.Uri;
import android.os.Bundle;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.boxandroidlibv2private.model.BoxPushNotification;
import com.eclipsesource.json.Json;
import com.eclipsesource.json.JsonObject;
import com.eclipsesource.json.JsonValue;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: BoxPushNotificationV1.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\t\b\u0016¢\u0006\u0004\b\u0002\u0010\u0003B\u0011\b\u0016\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0002\u0010\u0006B\u0011\b\u0016\u0012\u0006\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\u0002\u0010\tJ\u0010\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\b\u0010\u000e\u001a\u00020\u000bH\u0002J\b\u0010\u000f\u001a\u00020\rH\u0016J\b\u0010\u0010\u001a\u00020\rH\u0016J\u0006\u0010\u0011\u001a\u00020\rJ\u0006\u0010\u0012\u001a\u00020\r¨\u0006\u0014"}, d2 = {"Lcom/box/android/coreservices/models/BoxPushNotificationV1;", "Lcom/box/boxandroidlibv2private/model/BoxPushNotification;", "<init>", "()V", "jsonObject", "Lcom/eclipsesource/json/JsonObject;", "(Lcom/eclipsesource/json/JsonObject;)V", "intentExtras", "Landroid/os/Bundle;", "(Landroid/os/Bundle;)V", "extractTargetFromRedirectUrl", "", "redirectUrl", "", "flattenApsNode", "getCommentMessage", "getMessage", "getTitle", "getRedirectUrl", "Companion", "coreservices_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxPushNotificationV1 extends BoxPushNotification {
    private static final Companion Companion = new Companion(null);

    @Deprecated
    public static final String FIELD_ALERT = "alert";

    @Deprecated
    public static final String FIELD_ALERT_BODY = "aps.alert.body";

    @Deprecated
    public static final String FIELD_ALERT_TITLE = "aps.alert.title";

    @Deprecated
    public static final String FIELD_APS = "aps";

    @Deprecated
    public static final String FIELD_BODY = "body";

    @Deprecated
    public static final String FIELD_NOTIFICATION_VERSION = "notification_version";

    @Deprecated
    public static final String FIELD_RECIPIENT_ID = "recipient_id";

    @Deprecated
    public static final String FIELD_REDIRECT_URL = "redirect_url";

    @Deprecated
    public static final String FIELD_THREAD_ID = "aps.thread-id";

    @Deprecated
    public static final String FIELD_TITLE = "title";

    @Deprecated
    public static final String LEGACY_SCHEME = "boxopendirect";

    @Deprecated
    public static final String NOTIF_VERSION = "1";

    @Deprecated
    public static final String URL_AUTHORITY = "box.com";

    @Deprecated
    public static final String URL_QUERY_PARAM_ID = "id";

    @Deprecated
    public static final String URL_SCHEME_HTTPS = "https";

    public BoxPushNotificationV1() {
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BoxPushNotificationV1(JsonObject jsonObject) {
        super(jsonObject);
        Intrinsics.checkNotNullParameter(jsonObject, "jsonObject");
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public BoxPushNotificationV1(Bundle intentExtras) {
        super(intentExtras);
        Intrinsics.checkNotNullParameter(intentExtras, "intentExtras");
        flattenApsNode();
        String string = intentExtras.getString(FIELD_REDIRECT_URL);
        if (string != null) {
            extractTargetFromRedirectUrl(string);
        }
        set("target_user_id", intentExtras.getString(FIELD_RECIPIENT_ID));
    }

    private final void extractTargetFromRedirectUrl(String redirectUrl) {
        Uri uri = Uri.parse(redirectUrl);
        if (StringsKt.equals$default(uri.getScheme(), "boxopendirect", false, 2, null)) {
            String host = uri.getHost();
            set("target_resource_id", uri.getQueryParameter("id"));
            set("target_resource_type", host);
        } else if (StringsKt.equals$default(uri.getScheme(), "https", false, 2, null) && StringsKt.equals$default(uri.getHost(), URL_AUTHORITY, false, 2, null)) {
            set("target_resource_id", uri.getPathSegments().get(1));
            set("target_resource_type", "file");
        }
    }

    private final void flattenApsNode() {
        JsonValue propertyValue = getPropertyValue(FIELD_APS);
        if (propertyValue != null) {
            JsonValue jsonValue = JsonObject.readFrom(propertyValue.asString()).get(FIELD_ALERT);
            if (jsonValue != null && jsonValue.isObject()) {
                JsonObject jsonObjectAsObject = jsonValue.asObject();
                String strAsString = jsonObjectAsObject.get("title").asString();
                String strAsString2 = jsonObjectAsObject.get("body").asString();
                set(FIELD_ALERT_TITLE, strAsString);
                set(FIELD_ALERT_BODY, strAsString2);
            }
            try {
                set("comment_id", Json.parse(propertyValue.asString()).asObject().get("comment_id").asString());
            } catch (Exception unused) {
                BoxLogUtils.e(ExtensionsKt.getTAG(this), "unable to parse object for commentId " + propertyValue.asString());
            }
        }
        remove(FIELD_APS);
    }

    /* JADX INFO: compiled from: BoxPushNotificationV1.kt */
    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u000f\b\u0082\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0005X\u0086T¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/box/android/coreservices/models/BoxPushNotificationV1$Companion;", "", "<init>", "()V", "FIELD_NOTIFICATION_VERSION", "", "FIELD_RECIPIENT_ID", "FIELD_REDIRECT_URL", "FIELD_ALERT_TITLE", "FIELD_ALERT_BODY", "FIELD_THREAD_ID", "FIELD_APS", "FIELD_ALERT", "FIELD_TITLE", "FIELD_BODY", "LEGACY_SCHEME", "URL_QUERY_PARAM_ID", "URL_SCHEME_HTTPS", "URL_AUTHORITY", "NOTIF_VERSION", "coreservices_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
    private static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    @Override // com.box.boxandroidlibv2private.model.BoxPushNotification
    public String getCommentMessage() {
        String propertyAsString = getPropertyAsString(FIELD_ALERT_BODY);
        Intrinsics.checkNotNullExpressionValue(propertyAsString, "getPropertyAsString(...)");
        return propertyAsString;
    }

    @Override // com.box.boxandroidlibv2private.model.BoxPushNotification
    public String getMessage() {
        String propertyAsString = getPropertyAsString(FIELD_ALERT_BODY);
        Intrinsics.checkNotNullExpressionValue(propertyAsString, "getPropertyAsString(...)");
        return propertyAsString;
    }

    public final String getTitle() {
        String propertyAsString = getPropertyAsString(FIELD_ALERT_TITLE);
        Intrinsics.checkNotNullExpressionValue(propertyAsString, "getPropertyAsString(...)");
        return propertyAsString;
    }

    public final String getRedirectUrl() {
        String propertyAsString = getPropertyAsString(FIELD_REDIRECT_URL);
        Intrinsics.checkNotNullExpressionValue(propertyAsString, "getPropertyAsString(...)");
        return propertyAsString;
    }
}

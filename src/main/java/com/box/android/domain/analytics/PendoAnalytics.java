package com.box.android.domain.analytics;

import android.app.Application;
import com.box.android.common.utilities.BuildConfigProvider;
import com.box.android.common.utilities.CommonBoxUtil;
import com.box.android.domain.mappers.UserModelMapper;
import com.box.android.domain.models.item.EnterpriseModel;
import com.box.android.domain.models.item.UserModel;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.androidsdk.content.models.BoxUser;
import com.box.androidsdk.content.utils.BoxLogUtils;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Locale;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.json.JSONException;
import org.json.JSONObject;
import sdk.pendo.io.Pendo;

/* JADX INFO: compiled from: PendoAnalytics.kt */
/* JADX INFO: loaded from: classes11.dex */
@Metadata(d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u000e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fJ\u0010\u0010\u0010\u001a\u00020\r2\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012J\u000e\u0010\u0010\u001a\u00020\r2\u0006\u0010\u0013\u001a\u00020\u0014J\u0016\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u0017\u001a\u00020\u0018J\u0018\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\u00010\u001a*\u00020\u0018H\u0002J\u0010\u0010\u001b\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u0005H\u0002J$\u0010\u0015\u001a\u00020\r2\u0006\u0010\u0016\u001a\u00020\u00052\u0014\u0010\u0017\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u001aJ\u0006\u0010\u001d\u001a\u00020\rR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u0011\u0010\b\u001a\u00020\t8F¢\u0006\u0006\u001a\u0004\b\n\u0010\u000b¨\u0006\u001e"}, d2 = {"Lcom/box/android/domain/analytics/PendoAnalytics;", "", "<init>", "()V", "LANGUAGE", "", "PENDO_PROPERTIES_JSON_SIZE_LIMIT", "", "skipLoggingMetrics", "", "getSkipLoggingMetrics", "()Z", "initialize", "", "context", "Landroid/app/Application;", "startSession", "boxUser", "Lcom/box/androidsdk/content/models/BoxUser;", "user", "Lcom/box/android/domain/models/item/UserModel;", "trackEvent", "eventName", "properties", "Lorg/json/JSONObject;", "toMap", "", "formatStringValue", "input", "endSession", "domain_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class PendoAnalytics {
    public static final PendoAnalytics INSTANCE = new PendoAnalytics();
    private static final String LANGUAGE = "boxLanguage";
    private static final int PENDO_PROPERTIES_JSON_SIZE_LIMIT = 512;

    private PendoAnalytics() {
    }

    public final boolean getSkipLoggingMetrics() {
        return CommonBoxUtil.isRunningAutomatedTest();
    }

    public final void initialize(Application context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (getSkipLoggingMetrics()) {
            return;
        }
        Pendo.setup(context, "eyJhbGciOiJSUzI1NiIsImtpZCI6IiIsInR5cCI6IkpXVCJ9.eyJkYXRhY2VudGVyIjoidXMiLCJrZXkiOiJhZGEwOTMzYjNiNzQxNTczNTNhNTRhNWEyYWZjYzlkOWY3OWUxMGI1MDA4OTBjOTYzYjkyMGFkZmZlYmExZjExYjFmNDE3NGViMmQzMjY1ZWVmNWYyOWM2MmYzYzgyOTgzZmQyYzJhNDBlNzEwMTIzODJmODU3ZDliZmIyZTJlNTQ1NzIwZWZhN2NhODcyMThkY2YzNzMzYTVkYWRjZTdlZjFlOTgxMmE5MTI4Yzg0NzY2M2VjM2IwODM5MmYyMzhlM2RkNjI0YjNkMjQxNzQ5MGNjOWZjNmUzNzE1ZTgyOC44NWRlNzI4MTM2ZGJiOWYyYzI2NDhhMjU2YjZlYTBlMC5lNTNkNzYxZjQ0ZDFhOWNkOWNhODk2YzA1OWQyNDRmNTAzNDFkZGEzNGRiNjg1MzdhYmNlYTFjMTNmNjBjN2Q1In0.BOFIXEyeiA8EZZs9sLOlLVY_rP-k6Vfke6LlM5XH7q7pq5DbMokPCfPfJBH5vvVWXjJfLUh1_CWvLpvVC5zH2L7S5SOZdzCqrMTHaG09XAbEwcWM8JEEXDF1Yap-CiXLlGWLMP35ONoXiPFr2XCuwRSa79DESvw6d5xfGiXFC40", new Pendo.PendoOptions.Builder().build(), null);
        if (BuildConfigProvider.INSTANCE.isDebugBuild()) {
            Pendo.setDebugMode(true);
        }
        startSession((BoxUser) null);
    }

    public final void startSession(BoxUser boxUser) {
        if (getSkipLoggingMetrics()) {
            return;
        }
        if (boxUser == null) {
            Pendo.startSession("", "", null, null);
        } else {
            startSession(UserModelMapper.INSTANCE.toUserModel(boxUser));
        }
    }

    public final void startSession(UserModel user) {
        String id;
        Intrinsics.checkNotNullParameter(user, "user");
        if (getSkipLoggingMetrics()) {
            return;
        }
        if (BuildConfigProvider.INSTANCE.isDebugBuild()) {
            id = "mobile-" + user.getId();
        } else {
            id = user.getId();
        }
        EnterpriseModel enterprise = user.getEnterprise();
        Pendo.startSession(id, enterprise != null ? enterprise.getId() : null, MapsKt.mapOf(TuplesKt.to(LANGUAGE, Locale.getDefault().toLanguageTag())), MapsKt.emptyMap());
    }

    public final void trackEvent(String eventName, JSONObject properties) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(properties, "properties");
        if (getSkipLoggingMetrics()) {
            return;
        }
        if (BuildConfigProvider.INSTANCE.isDebugBuild() && properties.toString().length() + 14 > 512) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), "Pendo event properties too long for  " + eventName);
        }
        trackEvent(eventName, (Map<String, ? extends Object>) toMap(properties));
    }

    private final Map<String, Object> toMap(JSONObject jSONObject) {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Iterator<String> itKeys = jSONObject.keys();
        Intrinsics.checkNotNullExpressionValue(itKeys, "keys(...)");
        while (itKeys.hasNext()) {
            String next = itKeys.next();
            try {
                Object map = jSONObject.get(next);
                Intrinsics.checkNotNullExpressionValue(map, "get(...)");
                if (map instanceof JSONObject) {
                    map = toMap((JSONObject) map);
                }
                linkedHashMap.put(formatStringValue(next), map);
            } catch (JSONException e) {
                BoxLogUtils.e("Error transforming JSONObject to Map: " + e);
            }
        }
        return linkedHashMap;
    }

    private final String formatStringValue(String input) {
        String lowerCase = StringsKt.replace$default(StringsKt.trim((CharSequence) input).toString(), " ", "_", false, 4, (Object) null).toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        return lowerCase;
    }

    public final void trackEvent(String eventName, Map<String, ? extends Object> properties) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        Intrinsics.checkNotNullParameter(properties, "properties");
        if (getSkipLoggingMetrics()) {
            return;
        }
        Pendo.track(eventName, properties);
    }

    public final void endSession() {
        if (getSkipLoggingMetrics()) {
            return;
        }
        Pendo.endSession();
    }
}

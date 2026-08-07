package com.box.androidsdk.content;

import android.content.Context;
import io.opentelemetry.semconv.trace.attributes.SemanticAttributes;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxConfig.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0005\bÆ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0005H\u0007J\n\u0010\u0015\u001a\u0004\u0018\u00010\u0005H\u0007R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\u0006\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\b\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\f\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0012\u0010\r\u001a\u00020\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0010\u001a\u0004\u0018\u00010\u00118\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\nX\u0086T¢\u0006\u0002\n\u0000R\u0012\u0010\u0017\u001a\u00020\u00078\u0006@\u0006X\u0087\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/box/androidsdk/content/BoxConfig;", "", "<init>", "()V", "mCache", "Lcom/box/androidsdk/content/BoxCache;", "IS_LOG_ENABLED", "", "IS_DEBUG", "CLIENT_ID", "", "CLIENT_SECRET", "ENABLE_BOX_APP_AUTHENTICATION", "REDIRECT_URL", "DEVICE_NAME", "DEVICE_ID", "APPLICATION_CONTEXT", "Landroid/content/Context;", "setCache", "", SemanticAttributes.DbSystemValues.CACHE, "getCache", "SDK_VERSION", "IS_FLAG_SECURE", "content_prodRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class BoxConfig {
    public static Context APPLICATION_CONTEXT = null;
    public static String CLIENT_ID = null;
    public static String CLIENT_SECRET = null;
    public static String DEVICE_ID = null;
    public static String DEVICE_NAME = null;
    public static boolean ENABLE_BOX_APP_AUTHENTICATION = false;
    public static boolean IS_DEBUG = false;
    public static boolean IS_FLAG_SECURE = false;
    public static boolean IS_LOG_ENABLED = false;
    public static final String SDK_VERSION = "5.0.0";
    private static BoxCache mCache;
    public static final BoxConfig INSTANCE = new BoxConfig();
    public static String REDIRECT_URL = "https://account.box.com/static/sync_redirect.html";

    private BoxConfig() {
    }

    @JvmStatic
    public static final void setCache(BoxCache cache) {
        Intrinsics.checkNotNullParameter(cache, "cache");
        mCache = cache;
    }

    @JvmStatic
    public static final BoxCache getCache() {
        return mCache;
    }
}

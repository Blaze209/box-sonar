package com.microsoft.identity.common.internal.cache;

import android.content.Context;
import android.content.pm.PackageManager;
import com.box.brownfieldApi.featuresNavigator.activities.ReactNativeFeatureActivity;
import com.microsoft.identity.common.java.interfaces.INameValueStorage;
import com.microsoft.identity.common.java.interfaces.IPlatformComponents;
import com.microsoft.identity.common.logging.Logger;
import com.microsoft.intune.mam.client.content.pm.MAMPackageManagement;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: HelloCache.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000b\b\u0016\u0018\u0000 \u001e2\u00020\u0001:\u0001\u001eB/\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\b\b\u0002\u0010\t\u001a\u00020\n¢\u0006\u0002\u0010\u000bJ\b\u0010\u0011\u001a\u00020\u0012H\u0007J\u001a\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0016\u001a\u00020\u0005J\u001a\u0010\u0017\u001a\u00020\u00052\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0016\u001a\u00020\u0005H\u0002J\u0018\u0010\u0018\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0016\u001a\u00020\u0005J \u0010\u0019\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u001a\u001a\u00020\u0005J*\u0010\u001b\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u00052\u0006\u0010\u0016\u001a\u00020\u00052\u0006\u0010\u001c\u001a\u00020\u00142\u0006\u0010\u001d\u001a\u00020\u0005H\u0002R\u000e\u0010\t\u001a\u00020\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00050\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000e\u001a\u00020\u00058WX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010¨\u0006\u001f"}, d2 = {"Lcom/microsoft/identity/common/internal/cache/HelloCache;", "", "context", "Landroid/content/Context;", "protocolName", "", "targetAppPackageName", "components", "Lcom/microsoft/identity/common/java/interfaces/IPlatformComponents;", "cacheExpiryTimeInMs", "", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Lcom/microsoft/identity/common/java/interfaces/IPlatformComponents;J)V", "fileManager", "Lcom/microsoft/identity/common/java/interfaces/INameValueStorage;", "versionCode", "getVersionCode", "()Ljava/lang/String;", "clearCache", "", "getHelloCacheResult", "Lcom/microsoft/identity/common/internal/cache/HelloCacheResult;", "clientMinimumProtocolVersion", "clientMaximumProtocolVersion", "getNegotiatedProtocolVersionCacheKey", "saveHandshakeError", "saveNegotiatedProtocolVersion", "negotiatedProtocolVersion", "saveNegotiatedValue", ReactNativeFeatureActivity.RESULT_EXTRA_KEY, "callerMethodTag", "Companion", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public class HelloCache {
    private static final String SHARED_PREFERENCE_NAME = "com.microsoft.common.ipc.hello.cache";
    private final long cacheExpiryTimeInMs;
    private final Context context;
    private final INameValueStorage<String> fileManager;
    private final String protocolName;
    private final String targetAppPackageName;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "HelloCache";
    private static boolean sIsEnabled = true;
    private static final long DEFAULT_CACHE_EXPIRY_MILLIS = TimeUnit.HOURS.toMillis(4);

    public HelloCache(Context context, String protocolName, String targetAppPackageName, IPlatformComponents components, long j) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(protocolName, "protocolName");
        Intrinsics.checkNotNullParameter(targetAppPackageName, "targetAppPackageName");
        Intrinsics.checkNotNullParameter(components, "components");
        this.context = context;
        this.protocolName = protocolName;
        this.targetAppPackageName = targetAppPackageName;
        this.cacheExpiryTimeInMs = j;
        this.fileManager = components.getStorageSupplier().getUnencryptedNameValueStore(SHARED_PREFERENCE_NAME, String.class);
    }

    public /* synthetic */ HelloCache(Context context, String str, String str2, IPlatformComponents iPlatformComponents, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, str, str2, iPlatformComponents, (i & 16) != 0 ? DEFAULT_CACHE_EXPIRY_MILLIS : j);
    }

    /* JADX INFO: compiled from: HelloCache.kt */
    @Metadata(d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\nR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n \b*\u0004\u0018\u00010\u00060\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/microsoft/identity/common/internal/cache/HelloCache$Companion;", "", "()V", "DEFAULT_CACHE_EXPIRY_MILLIS", "", "SHARED_PREFERENCE_NAME", "", "TAG", "kotlin.jvm.PlatformType", "sIsEnabled", "", "setIsEnabled", "", "value", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void setIsEnabled(boolean value) {
            synchronized (HelloCache.class) {
                Companion companion = HelloCache.INSTANCE;
                HelloCache.sIsEnabled = value;
                Unit unit = Unit.INSTANCE;
            }
        }
    }

    public final HelloCacheResult getHelloCacheResult(String clientMinimumProtocolVersion, String clientMaximumProtocolVersion) {
        Intrinsics.checkNotNullParameter(clientMaximumProtocolVersion, "clientMaximumProtocolVersion");
        String str = TAG + ":tryGetNegotiatedProtocolVersion";
        if (!sIsEnabled) {
            Logger.infoPII(str, "hello cache is not enabled.");
            return null;
        }
        try {
            String negotiatedProtocolVersionCacheKey = getNegotiatedProtocolVersionCacheKey(clientMinimumProtocolVersion, clientMaximumProtocolVersion);
            String str2 = this.fileManager.get(negotiatedProtocolVersionCacheKey);
            String str3 = str2;
            if (str3 == null || str3.length() == 0) {
                return null;
            }
            HelloCacheResult helloCacheResultDeserialize$common_distRelease = HelloCacheResult.INSTANCE.deserialize$common_distRelease(str2);
            if (helloCacheResultDeserialize$common_distRelease == null) {
                Logger.info(str, "Legacy or invalid cache value.");
                this.fileManager.remove(negotiatedProtocolVersionCacheKey);
                return null;
            }
            if (System.currentTimeMillis() - helloCacheResultDeserialize$common_distRelease.getTimeStamp() <= this.cacheExpiryTimeInMs) {
                return helloCacheResultDeserialize$common_distRelease;
            }
            Logger.info(str, "Cache entry is expired.");
            this.fileManager.remove(negotiatedProtocolVersionCacheKey);
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            Logger.error(str, "Failed to retrieve key", e);
            return null;
        }
    }

    public final void saveNegotiatedProtocolVersion(String clientMinimumProtocolVersion, String clientMaximumProtocolVersion, String negotiatedProtocolVersion) {
        Intrinsics.checkNotNullParameter(clientMaximumProtocolVersion, "clientMaximumProtocolVersion");
        Intrinsics.checkNotNullParameter(negotiatedProtocolVersion, "negotiatedProtocolVersion");
        saveNegotiatedValue(clientMinimumProtocolVersion, clientMaximumProtocolVersion, HelloCacheResult.INSTANCE.createFromNegotiatedProtocolVersion$common_distRelease(negotiatedProtocolVersion), TAG + ":saveNegotiatedProtocolVersion");
    }

    public final void saveHandshakeError(String clientMinimumProtocolVersion, String clientMaximumProtocolVersion) {
        Intrinsics.checkNotNullParameter(clientMaximumProtocolVersion, "clientMaximumProtocolVersion");
        saveNegotiatedValue(clientMinimumProtocolVersion, clientMaximumProtocolVersion, HelloCacheResult.INSTANCE.createHandshakeError$common_distRelease(), TAG + ":saveHandShakeError");
    }

    private final void saveNegotiatedValue(String clientMinimumProtocolVersion, String clientMaximumProtocolVersion, HelloCacheResult result, String callerMethodTag) {
        String str = TAG + callerMethodTag + ":saveNegotiatedProtocolVersion";
        if (!sIsEnabled) {
            Logger.infoPII(str, "hello cache is not enabled.");
            return;
        }
        try {
            this.fileManager.put(getNegotiatedProtocolVersionCacheKey(clientMinimumProtocolVersion, clientMaximumProtocolVersion), result.serialize$common_distRelease());
        } catch (PackageManager.NameNotFoundException e) {
            Logger.error(str, "Failed to retrieve key", e);
        }
    }

    private final String getNegotiatedProtocolVersionCacheKey(String clientMinimumProtocolVersion, String clientMaximumProtocolVersion) throws PackageManager.NameNotFoundException {
        return this.protocolName + AbstractJsonLexerKt.BEGIN_LIST + clientMinimumProtocolVersion + AbstractJsonLexerKt.COMMA + clientMaximumProtocolVersion + "]:" + this.targetAppPackageName + AbstractJsonLexerKt.BEGIN_LIST + getVersionCode() + AbstractJsonLexerKt.END_LIST;
    }

    public final void clearCache() {
        this.fileManager.clear();
    }

    public String getVersionCode() throws PackageManager.NameNotFoundException {
        return String.valueOf(MAMPackageManagement.getPackageInfo(this.context.getPackageManager(), this.targetAppPackageName, 0).getLongVersionCode());
    }
}

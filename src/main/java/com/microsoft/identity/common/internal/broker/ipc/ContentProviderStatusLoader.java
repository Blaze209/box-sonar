package com.microsoft.identity.common.internal.broker.ipc;

import android.content.Context;
import android.content.pm.PackageManager;
import android.content.pm.ProviderInfo;
import android.os.DeadObjectException;
import com.google.firebase.remoteconfig.RemoteConfigConstants;
import com.microsoft.identity.common.java.interfaces.INameValueStorage;
import com.microsoft.identity.common.java.interfaces.IPlatformComponents;
import com.microsoft.identity.common.logging.Logger;
import com.microsoft.intune.mam.client.content.pm.MAMPackageManagement;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.serialization.json.internal.AbstractJsonLexerKt;

/* JADX INFO: compiled from: ContentProviderStatusLoader.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0002\u0010\u0006BY\u0012!\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\t0\b\u0012!\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u000e0\b\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u0010¢\u0006\u0002\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u000e2\u0006\u0010\u0013\u001a\u00020\tH\u0016R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\t0\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\u0007\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004¢\u0006\u0002\n\u0000R)\u0010\r\u001a\u001d\u0012\u0013\u0012\u00110\t¢\u0006\f\b\n\u0012\b\b\u000b\u0012\u0004\b\b(\f\u0012\u0004\u0012\u00020\u000e0\bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0015"}, d2 = {"Lcom/microsoft/identity/common/internal/broker/ipc/ContentProviderStatusLoader;", "Lcom/microsoft/identity/common/internal/broker/ipc/IContentProviderStatusLoader;", "context", "Landroid/content/Context;", "components", "Lcom/microsoft/identity/common/java/interfaces/IPlatformComponents;", "(Landroid/content/Context;Lcom/microsoft/identity/common/java/interfaces/IPlatformComponents;)V", "getVersionCode", "Lkotlin/Function1;", "", "Lkotlin/ParameterName;", "name", "appPackageName", "supportedByContentProvider", "", "fileManager", "Lcom/microsoft/identity/common/java/interfaces/INameValueStorage;", "(Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Lcom/microsoft/identity/common/java/interfaces/INameValueStorage;)V", "supportsContentProvider", RemoteConfigConstants.RequestFieldKey.PACKAGE_NAME, "Companion", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
public final class ContentProviderStatusLoader implements IContentProviderStatusLoader {
    private static final String SHARED_PREFERENCE_NAME = "com.microsoft.common.ipc.content.provider.query.cache";
    private final INameValueStorage<String> fileManager;
    private final Function1<String, String> getVersionCode;
    private final Function1<String, Boolean> supportedByContentProvider;

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final String TAG = "ContentProviderStatusLoader";

    /* JADX WARN: Multi-variable type inference failed */
    public ContentProviderStatusLoader(Function1<? super String, String> getVersionCode, Function1<? super String, Boolean> supportedByContentProvider, INameValueStorage<String> fileManager) {
        Intrinsics.checkNotNullParameter(getVersionCode, "getVersionCode");
        Intrinsics.checkNotNullParameter(supportedByContentProvider, "supportedByContentProvider");
        Intrinsics.checkNotNullParameter(fileManager, "fileManager");
        this.getVersionCode = getVersionCode;
        this.supportedByContentProvider = supportedByContentProvider;
        this.fileManager = fileManager;
    }

    /* JADX INFO: compiled from: ContentProviderStatusLoader.kt */
    @Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004H\u0002J\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T¢\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\n \u0006*\u0004\u0018\u00010\u00040\u0004X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\r"}, d2 = {"Lcom/microsoft/identity/common/internal/broker/ipc/ContentProviderStatusLoader$Companion;", "", "()V", "SHARED_PREFERENCE_NAME", "", "TAG", "kotlin.jvm.PlatformType", "getVersionCode", "context", "Landroid/content/Context;", "appPackageName", "supportedByContentProvider", "", "common_distRelease"}, k = 1, mv = {1, 8, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        /* JADX INFO: Access modifiers changed from: private */
        public final String getVersionCode(Context context, String appPackageName) throws PackageManager.NameNotFoundException {
            return String.valueOf(MAMPackageManagement.getPackageInfo(context.getPackageManager(), appPackageName, 0).getLongVersionCode());
        }

        public final boolean supportedByContentProvider(Context context, String appPackageName) throws DeadObjectException {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(appPackageName, "appPackageName");
            String contentProviderAuthority = ContentProviderStrategy.getContentProviderAuthority(appPackageName);
            Intrinsics.checkNotNullExpressionValue(contentProviderAuthority, "getContentProviderAuthority(appPackageName)");
            List<ProviderInfo> listQueryContentProviders = MAMPackageManagement.queryContentProviders(context.getPackageManager(), (String) null, 0, 0);
            Intrinsics.checkNotNullExpressionValue(listQueryContentProviders, "context.packageManager\n …tentProviders(null, 0, 0)");
            for (ProviderInfo providerInfo : listQueryContentProviders) {
                if (providerInfo.authority != null && Intrinsics.areEqual(providerInfo.authority, contentProviderAuthority)) {
                    return true;
                }
            }
            return false;
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public ContentProviderStatusLoader(final Context context, IPlatformComponents components) {
        this(new Function1<String, String>() { // from class: com.microsoft.identity.common.internal.broker.ipc.ContentProviderStatusLoader.1
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final String invoke(String pkgName) {
                Intrinsics.checkNotNullParameter(pkgName, "pkgName");
                return ContentProviderStatusLoader.INSTANCE.getVersionCode(context, pkgName);
            }
        }, new Function1<String, Boolean>() { // from class: com.microsoft.identity.common.internal.broker.ipc.ContentProviderStatusLoader.2
            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public final Boolean invoke(String pkgName) {
                Intrinsics.checkNotNullParameter(pkgName, "pkgName");
                return Boolean.valueOf(ContentProviderStatusLoader.INSTANCE.supportedByContentProvider(context, pkgName));
            }
        }, components.getStorageSupplier().getUnencryptedNameValueStore(SHARED_PREFERENCE_NAME, String.class));
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(components, "components");
    }

    @Override // com.microsoft.identity.common.internal.broker.ipc.IContentProviderStatusLoader
    public boolean supportsContentProvider(String packageName) {
        Intrinsics.checkNotNullParameter(packageName, "packageName");
        String str = TAG + ":getResult";
        try {
            String str2 = packageName + AbstractJsonLexerKt.COLON + this.getVersionCode.invoke(packageName);
            String str3 = this.fileManager.get(str2);
            if (str3 != null) {
                return Boolean.parseBoolean(str3);
            }
            boolean zBooleanValue = this.supportedByContentProvider.invoke(packageName).booleanValue();
            this.fileManager.put(str2, String.valueOf(zBooleanValue));
            return zBooleanValue;
        } catch (Throwable th) {
            Logger.error(str, th.getMessage(), th);
            return false;
        }
    }
}

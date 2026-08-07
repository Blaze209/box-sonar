package com.box.cirrus;

import android.app.Application;
import com.box.android.common.utilities.MetroDevSettings;
import com.box.android.domain.utils.ExtensionsKt;
import com.box.androidsdk.content.utils.BoxLogUtils;
import com.box.brownfieldApi.ReactNativeHostManager;
import com.box.cirrus.providers.BoxAccountSettingsProvider;
import com.box.cirrus.providers.BoxAnalyticsProvider;
import com.box.cirrus.providers.BoxAuthProvider;
import com.box.cirrus.providers.BoxConfigProvider;
import com.box.cirrus.providers.BoxContentUploadService;
import com.box.cirrus.providers.BoxLoggingProvider;
import com.facebook.react.PackageList;
import com.facebook.react.ReactPackage;
import com.margelo.nitro.boxcontext.BoxContext;
import com.margelo.nitro.boxcontext.providers.HelloWorldProvider;
import com.margelo.nitro.boxcontext.providers.UuidProvider;
import java.util.ArrayList;
import java.util.UUID;
import javax.inject.Inject;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: CirrusLoader.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B1\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0012"}, d2 = {"Lcom/box/cirrus/CirrusLoader;", "", "authProvider", "Lcom/box/cirrus/providers/BoxAuthProvider;", "configProvider", "Lcom/box/cirrus/providers/BoxConfigProvider;", "analyticsProvider", "Lcom/box/cirrus/providers/BoxAnalyticsProvider;", "boxContentUploadService", "Lcom/box/cirrus/providers/BoxContentUploadService;", "accountSettingsProvider", "Lcom/box/cirrus/providers/BoxAccountSettingsProvider;", "<init>", "(Lcom/box/cirrus/providers/BoxAuthProvider;Lcom/box/cirrus/providers/BoxConfigProvider;Lcom/box/cirrus/providers/BoxAnalyticsProvider;Lcom/box/cirrus/providers/BoxContentUploadService;Lcom/box/cirrus/providers/BoxAccountSettingsProvider;)V", "init", "", "reactApplication", "Landroid/app/Application;", "cirrus_generalProdRelease"}, k = 1, mv = {2, 2, 0}, xi = 48)
public final class CirrusLoader {
    private final BoxAccountSettingsProvider accountSettingsProvider;
    private final BoxAnalyticsProvider analyticsProvider;
    private final BoxAuthProvider authProvider;
    private final BoxContentUploadService boxContentUploadService;
    private final BoxConfigProvider configProvider;

    @Inject
    public CirrusLoader(BoxAuthProvider authProvider, BoxConfigProvider configProvider, BoxAnalyticsProvider analyticsProvider, BoxContentUploadService boxContentUploadService, BoxAccountSettingsProvider accountSettingsProvider) {
        Intrinsics.checkNotNullParameter(authProvider, "authProvider");
        Intrinsics.checkNotNullParameter(configProvider, "configProvider");
        Intrinsics.checkNotNullParameter(analyticsProvider, "analyticsProvider");
        Intrinsics.checkNotNullParameter(boxContentUploadService, "boxContentUploadService");
        Intrinsics.checkNotNullParameter(accountSettingsProvider, "accountSettingsProvider");
        this.authProvider = authProvider;
        this.configProvider = configProvider;
        this.analyticsProvider = analyticsProvider;
        this.boxContentUploadService = boxContentUploadService;
        this.accountSettingsProvider = accountSettingsProvider;
    }

    public final void init(Application reactApplication) {
        Intrinsics.checkNotNullParameter(reactApplication, "reactApplication");
        try {
            ReactNativeHostManager reactNativeHostManager = ReactNativeHostManager.INSTANCE;
            ArrayList<ReactPackage> packages = new PackageList(reactApplication).getPackages();
            Intrinsics.checkNotNullExpressionValue(packages, "getPackages(...)");
            reactNativeHostManager.initialize(reactApplication, packages, MetroDevSettings.INSTANCE.getUseMetroServer(), MetroDevSettings.INSTANCE.getMetroUrl());
            BoxContext.ServiceRegistry serviceRegistry = BoxContext.ServiceRegistry.INSTANCE;
            HelloWorldProvider helloWorldProvider = new HelloWorldProvider() { // from class: com.box.cirrus.CirrusLoader.init.1
                @Override // com.margelo.nitro.boxcontext.providers.HelloWorldProvider
                public String sayHello() {
                    return "Hello from Box Core App!";
                }
            };
            BoxLoggingProvider boxLoggingProvider = new BoxLoggingProvider();
            BoxAuthProvider boxAuthProvider = this.authProvider;
            BoxConfigProvider boxConfigProvider = this.configProvider;
            UuidProvider uuidProvider = new UuidProvider() { // from class: com.box.cirrus.CirrusLoader.init.2
                @Override // com.margelo.nitro.boxcontext.providers.UuidProvider
                public String generateUuid() {
                    String string = UUID.randomUUID().toString();
                    Intrinsics.checkNotNullExpressionValue(string, "toString(...)");
                    return string;
                }
            };
            serviceRegistry.register(new BoxContext.Dependencies(reactApplication, this.analyticsProvider, helloWorldProvider, boxLoggingProvider, boxAuthProvider, boxConfigProvider, uuidProvider, this.boxContentUploadService, this.accountSettingsProvider));
        } catch (Throwable th) {
            BoxLogUtils.e(ExtensionsKt.getTAG(this), th);
        }
    }
}

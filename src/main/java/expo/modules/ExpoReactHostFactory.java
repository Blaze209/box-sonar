package expo.modules;

import android.content.Context;
import com.facebook.react.ReactHost;
import com.facebook.react.ReactInstanceEventListener;
import com.facebook.react.ReactPackage;
import com.facebook.react.ReactPackageTurboModuleManagerDelegate;
import com.facebook.react.bridge.JSBundleLoader;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.annotations.UnstableReactNativeAPI;
import com.facebook.react.defaults.DefaultComponentsRegistry;
import com.facebook.react.defaults.DefaultTurboModuleManagerDelegate;
import com.facebook.react.fabric.ComponentFactory;
import com.facebook.react.runtime.BindingsInstaller;
import com.facebook.react.runtime.JSRuntimeFactory;
import com.facebook.react.runtime.ReactHostDelegate;
import com.facebook.react.runtime.ReactHostImpl;
import com.facebook.react.runtime.hermes.HermesInstance;
import expo.modules.core.interfaces.Package;
import expo.modules.core.interfaces.ReactNativeHostHandler;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.sequences.SequencesKt;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: ExpoReactHostFactory.kt */
/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001:\u0001\u0016B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J`\u0010\u0006\u001a\u00020\u00052\u0006\u0010\u0007\u001a\u00020\b2\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\b\b\u0002\u0010\f\u001a\u00020\r2\b\b\u0002\u0010\u000e\u001a\u00020\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\r2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\n\b\u0002\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0007R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0017"}, d2 = {"Lexpo/modules/ExpoReactHostFactory;", "", "<init>", "()V", "reactHost", "Lcom/facebook/react/ReactHost;", "getDefaultReactHost", "context", "Landroid/content/Context;", "packageList", "", "Lcom/facebook/react/ReactPackage;", "jsMainModulePath", "", "jsBundleAssetPath", "jsBundleFilePath", "jsRuntimeFactory", "Lcom/facebook/react/runtime/JSRuntimeFactory;", "useDevSupport", "", "bindingsInstaller", "Lcom/facebook/react/runtime/BindingsInstaller;", "ExpoReactHostDelegate", "expo_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExpoReactHostFactory {
    public static final ExpoReactHostFactory INSTANCE = new ExpoReactHostFactory();
    private static ReactHost reactHost;

    private ExpoReactHostFactory() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX INFO: compiled from: ExpoReactHostFactory.kt */
    @Metadata(d1 = {"\u0000`\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001Bm\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006\u0012\u0006\u0010\b\u001a\u00020\t\u0012\b\u0010\n\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\t\u0012\u0006\u0010\f\u001a\u00020\r\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0011\u0012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0006¢\u0006\u0004\b\u0014\u0010\u0015J\u0014\u0010/\u001a\u0002002\n\u00101\u001a\u000602j\u0002`3H\u0016R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\u00020\tX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0010\u0010\n\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\tX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u0010\u001a\u00020\u0011X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0013\u0010\u001c\u001a\u0004\u0018\u00010\t8F¢\u0006\u0006\u001a\u0004\b\u001d\u0010\u0017R\u0013\u0010\u001e\u001a\u0004\u0018\u00010\t8F¢\u0006\u0006\u001a\u0004\b\u001f\u0010\u0017R\u0011\u0010 \u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b!\u0010\"R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010%\u001a\u00020$8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b&\u0010'R\u0014\u0010(\u001a\u00020)8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b*\u0010+R\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00070\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b-\u0010.¨\u00064"}, d2 = {"Lexpo/modules/ExpoReactHostFactory$ExpoReactHostDelegate;", "Lcom/facebook/react/runtime/ReactHostDelegate;", "weakContext", "Ljava/lang/ref/WeakReference;", "Landroid/content/Context;", "packageList", "", "Lcom/facebook/react/ReactPackage;", "jsMainModulePath", "", "jsBundleAssetPath", "jsBundleFilePath", "useDevSupport", "", "bindingsInstaller", "Lcom/facebook/react/runtime/BindingsInstaller;", "turboModuleManagerDelegateBuilder", "Lcom/facebook/react/ReactPackageTurboModuleManagerDelegate$Builder;", "hostHandlers", "Lexpo/modules/core/interfaces/ReactNativeHostHandler;", "<init>", "(Ljava/lang/ref/WeakReference;Ljava/util/List;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLcom/facebook/react/runtime/BindingsInstaller;Lcom/facebook/react/ReactPackageTurboModuleManagerDelegate$Builder;Ljava/util/List;)V", "getJsMainModulePath", "()Ljava/lang/String;", "getBindingsInstaller", "()Lcom/facebook/react/runtime/BindingsInstaller;", "getTurboModuleManagerDelegateBuilder", "()Lcom/facebook/react/ReactPackageTurboModuleManagerDelegate$Builder;", "hostDelegateJsBundleFilePath", "getHostDelegateJsBundleFilePath", "hostDelegateJSBundleAssetPath", "getHostDelegateJSBundleAssetPath", "hostDelegateUseDeveloperSupport", "getHostDelegateUseDeveloperSupport", "()Z", "_jsBundleLoader", "Lcom/facebook/react/bridge/JSBundleLoader;", "jsBundleLoader", "getJsBundleLoader", "()Lcom/facebook/react/bridge/JSBundleLoader;", "jsRuntimeFactory", "Lcom/facebook/react/runtime/JSRuntimeFactory;", "getJsRuntimeFactory", "()Lcom/facebook/react/runtime/JSRuntimeFactory;", "reactPackages", "getReactPackages", "()Ljava/util/List;", "handleInstanceException", "", "error", "Ljava/lang/Exception;", "Lkotlin/Exception;", "expo_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    @UnstableReactNativeAPI
    static final class ExpoReactHostDelegate implements ReactHostDelegate {
        private JSBundleLoader _jsBundleLoader;
        private final BindingsInstaller bindingsInstaller;
        private final List<ReactNativeHostHandler> hostHandlers;
        private final String jsBundleAssetPath;
        private final String jsBundleFilePath;
        private final String jsMainModulePath;
        private final List<ReactPackage> packageList;
        private final ReactPackageTurboModuleManagerDelegate.Builder turboModuleManagerDelegateBuilder;
        private final boolean useDevSupport;
        private final WeakReference<Context> weakContext;

        /* JADX WARN: Multi-variable type inference failed */
        public ExpoReactHostDelegate(WeakReference<Context> weakContext, List<? extends ReactPackage> packageList, String jsMainModulePath, String str, String str2, boolean z, BindingsInstaller bindingsInstaller, ReactPackageTurboModuleManagerDelegate.Builder turboModuleManagerDelegateBuilder, List<? extends ReactNativeHostHandler> hostHandlers) {
            Intrinsics.checkNotNullParameter(weakContext, "weakContext");
            Intrinsics.checkNotNullParameter(packageList, "packageList");
            Intrinsics.checkNotNullParameter(jsMainModulePath, "jsMainModulePath");
            Intrinsics.checkNotNullParameter(turboModuleManagerDelegateBuilder, "turboModuleManagerDelegateBuilder");
            Intrinsics.checkNotNullParameter(hostHandlers, "hostHandlers");
            this.weakContext = weakContext;
            this.packageList = packageList;
            this.jsMainModulePath = jsMainModulePath;
            this.jsBundleAssetPath = str;
            this.jsBundleFilePath = str2;
            this.useDevSupport = z;
            this.bindingsInstaller = bindingsInstaller;
            this.turboModuleManagerDelegateBuilder = turboModuleManagerDelegateBuilder;
            this.hostHandlers = hostHandlers;
        }

        @Override // com.facebook.react.runtime.ReactHostDelegate
        public String getJsMainModulePath() {
            return this.jsMainModulePath;
        }

        @Override // com.facebook.react.runtime.ReactHostDelegate
        public BindingsInstaller getBindingsInstaller() {
            return this.bindingsInstaller;
        }

        @Override // com.facebook.react.runtime.ReactHostDelegate
        public ReactPackageTurboModuleManagerDelegate.Builder getTurboModuleManagerDelegateBuilder() {
            return this.turboModuleManagerDelegateBuilder;
        }

        public /* synthetic */ ExpoReactHostDelegate(WeakReference weakReference, List list, String str, String str2, String str3, boolean z, BindingsInstaller bindingsInstaller, DefaultTurboModuleManagerDelegate.Builder builder, List list2, int i, DefaultConstructorMarker defaultConstructorMarker) {
            this(weakReference, list, str, str2, (i & 16) != 0 ? null : str3, z, (i & 64) != 0 ? null : bindingsInstaller, (i & 128) != 0 ? new DefaultTurboModuleManagerDelegate.Builder() : builder, list2);
        }

        public final String getHostDelegateJsBundleFilePath() {
            String str = (String) SequencesKt.firstOrNull(SequencesKt.mapNotNull(CollectionsKt.asSequence(this.hostHandlers), new Function1() { // from class: expo.modules.ExpoReactHostFactory$ExpoReactHostDelegate$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ExpoReactHostFactory.ExpoReactHostDelegate._get_hostDelegateJsBundleFilePath_$lambda$0(this.f$0, (ReactNativeHostHandler) obj);
                }
            }));
            return str == null ? this.jsBundleFilePath : str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String _get_hostDelegateJsBundleFilePath_$lambda$0(ExpoReactHostDelegate expoReactHostDelegate, ReactNativeHostHandler it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return it.getJSBundleFile(expoReactHostDelegate.useDevSupport);
        }

        public final String getHostDelegateJSBundleAssetPath() {
            String str = (String) SequencesKt.firstOrNull(SequencesKt.mapNotNull(CollectionsKt.asSequence(this.hostHandlers), new Function1() { // from class: expo.modules.ExpoReactHostFactory$ExpoReactHostDelegate$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ExpoReactHostFactory.ExpoReactHostDelegate._get_hostDelegateJSBundleAssetPath_$lambda$1(this.f$0, (ReactNativeHostHandler) obj);
                }
            }));
            return str == null ? this.jsBundleAssetPath : str;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final String _get_hostDelegateJSBundleAssetPath_$lambda$1(ExpoReactHostDelegate expoReactHostDelegate, ReactNativeHostHandler it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return it.getBundleAssetName(expoReactHostDelegate.useDevSupport);
        }

        public final boolean getHostDelegateUseDeveloperSupport() {
            Boolean bool = (Boolean) SequencesKt.firstOrNull(SequencesKt.mapNotNull(CollectionsKt.asSequence(this.hostHandlers), new Function1() { // from class: expo.modules.ExpoReactHostFactory$ExpoReactHostDelegate$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ExpoReactHostFactory.ExpoReactHostDelegate._get_hostDelegateUseDeveloperSupport_$lambda$2((ReactNativeHostHandler) obj);
                }
            }));
            if (bool != null) {
                return bool.booleanValue();
            }
            return this.useDevSupport;
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Boolean _get_hostDelegateUseDeveloperSupport_$lambda$2(ReactNativeHostHandler it) {
            Intrinsics.checkNotNullParameter(it, "it");
            return it.getUseDeveloperSupport();
        }

        @Override // com.facebook.react.runtime.ReactHostDelegate
        public JSBundleLoader getJsBundleLoader() {
            JSBundleLoader jSBundleLoader = this._jsBundleLoader;
            if (jSBundleLoader != null) {
                return jSBundleLoader;
            }
            Context context = this.weakContext.get();
            if (context == null) {
                throw new IllegalStateException("Unable to get concrete Context");
            }
            String hostDelegateJsBundleFilePath = getHostDelegateJsBundleFilePath();
            if (hostDelegateJsBundleFilePath != null) {
                if (StringsKt.startsWith$default(hostDelegateJsBundleFilePath, "assets://", false, 2, (Object) null)) {
                    return JSBundleLoader.INSTANCE.createAssetLoader(context, hostDelegateJsBundleFilePath, true);
                }
                return JSBundleLoader.INSTANCE.createFileLoader(hostDelegateJsBundleFilePath);
            }
            return JSBundleLoader.INSTANCE.createAssetLoader(context, "assets://" + getHostDelegateJSBundleAssetPath(), true);
        }

        @Override // com.facebook.react.runtime.ReactHostDelegate
        public JSRuntimeFactory getJsRuntimeFactory() {
            return new HermesInstance();
        }

        @Override // com.facebook.react.runtime.ReactHostDelegate
        public List<ReactPackage> getReactPackages() {
            return this.packageList;
        }

        @Override // com.facebook.react.runtime.ReactHostDelegate
        public void handleInstanceException(Exception error) throws Exception {
            Intrinsics.checkNotNullParameter(error, "error");
            if (this.hostHandlers.isEmpty()) {
                throw error;
            }
            Iterator<T> it = this.hostHandlers.iterator();
            while (it.hasNext()) {
                ((ReactNativeHostHandler) it.next()).onReactInstanceException(getHostDelegateUseDeveloperSupport(), error);
            }
        }
    }

    @JvmStatic
    public static final ReactHost getDefaultReactHost(Context context, List<? extends ReactPackage> packageList, String jsMainModulePath, String jsBundleAssetPath, String jsBundleFilePath, JSRuntimeFactory jsRuntimeFactory, final boolean useDevSupport, BindingsInstaller bindingsInstaller) {
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(packageList, "packageList");
        Intrinsics.checkNotNullParameter(jsMainModulePath, "jsMainModulePath");
        Intrinsics.checkNotNullParameter(jsBundleAssetPath, "jsBundleAssetPath");
        if (reactHost == null) {
            List<Package> packageList2 = ExpoModulesPackage.INSTANCE.getPackageList();
            ArrayList arrayList = new ArrayList();
            Iterator<T> it = packageList2.iterator();
            while (it.hasNext()) {
                List<? extends ReactNativeHostHandler> listCreateReactNativeHostHandlers = ((Package) it.next()).createReactNativeHostHandlers(context);
                Intrinsics.checkNotNullExpressionValue(listCreateReactNativeHostHandlers, "createReactNativeHostHandlers(...)");
                CollectionsKt.addAll(arrayList, listCreateReactNativeHostHandlers);
            }
            final ArrayList arrayList2 = arrayList;
            ExpoReactHostDelegate expoReactHostDelegate = new ExpoReactHostDelegate(new WeakReference(context), packageList, jsMainModulePath, jsBundleAssetPath, jsBundleFilePath, useDevSupport, bindingsInstaller, null, arrayList2, 128, null);
            ComponentFactory componentFactory = new ComponentFactory();
            DefaultComponentsRegistry.register(componentFactory);
            ArrayList<ReactNativeHostHandler> arrayList3 = arrayList2;
            Iterator it2 = arrayList3.iterator();
            while (it2.hasNext()) {
                ((ReactNativeHostHandler) it2.next()).onWillCreateReactInstance(useDevSupport);
            }
            ReactHostImpl reactHostImpl = new ReactHostImpl(context, expoReactHostDelegate, componentFactory, true, useDevSupport);
            for (ReactNativeHostHandler reactNativeHostHandler : arrayList3) {
                reactNativeHostHandler.onDidCreateReactHost(context, reactHostImpl);
                reactNativeHostHandler.onDidCreateDevSupportManager(reactHostImpl.getDevSupportManager());
            }
            reactHostImpl.addReactInstanceEventListener(new ReactInstanceEventListener() { // from class: expo.modules.ExpoReactHostFactory.getDefaultReactHost.3
                @Override // com.facebook.react.ReactInstanceEventListener
                public void onReactContextInitialized(ReactContext context2) {
                    Intrinsics.checkNotNullParameter(context2, "context");
                    List<ReactNativeHostHandler> list = arrayList2;
                    boolean z = useDevSupport;
                    Iterator<T> it3 = list.iterator();
                    while (it3.hasNext()) {
                        ((ReactNativeHostHandler) it3.next()).onDidCreateReactInstance(z, context2);
                    }
                }
            });
            reactHost = reactHostImpl;
        }
        ReactHost reactHost2 = reactHost;
        Intrinsics.checkNotNull(reactHost2, "null cannot be cast to non-null type com.facebook.react.ReactHost");
        return reactHost2;
    }
}

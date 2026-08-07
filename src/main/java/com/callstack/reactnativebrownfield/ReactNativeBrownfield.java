package com.callstack.reactnativebrownfield;

import android.app.Application;
import android.os.Bundle;
import android.widget.FrameLayout;
import androidx.activity.OnBackPressedCallback;
import androidx.activity.OnBackPressedDispatcher;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.DefaultLifecycleObserver;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.media3.common.MimeTypes;
import com.callstack.reactnativebrownfield.utils.VersionUtils;
import com.facebook.react.ReactHost;
import com.facebook.react.ReactInstanceEventListener;
import com.facebook.react.ReactPackage;
import com.facebook.react.ReactRootView;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.common.build.ReactBuildConfig;
import com.facebook.react.defaults.DefaultNewArchitectureEntryPoint;
import com.facebook.react.defaults.DefaultReactHost;
import com.facebook.react.soloader.OpenSourceMergedSoMapping;
import com.facebook.soloader.SoLoader;
import com.google.firebase.analytics.FirebaseAnalytics;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ReactNativeBrownfield.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J0\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0015"}, d2 = {"Lcom/callstack/reactnativebrownfield/ReactNativeBrownfield;", "", "reactHost", "Lcom/facebook/react/ReactHost;", "<init>", "(Lcom/facebook/react/ReactHost;)V", "getReactHost", "()Lcom/facebook/react/ReactHost;", "createView", "Landroid/widget/FrameLayout;", "activity", "Landroidx/fragment/app/FragmentActivity;", "moduleName", "", "reactDelegate", "Lcom/callstack/reactnativebrownfield/ReactDelegateWrapper;", "launchOptions", "Landroid/os/Bundle;", "getLifeCycleObserver", "Landroidx/lifecycle/DefaultLifecycleObserver;", "Companion", "callstack_react-native-brownfield_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ReactNativeBrownfield {

    /* JADX INFO: renamed from: Companion, reason: from kotlin metadata */
    public static final Companion INSTANCE = new Companion(null);
    private static final AtomicBoolean initialized = new AtomicBoolean();
    private static ReactNativeBrownfield instance;
    private final ReactHost reactHost;

    public /* synthetic */ ReactNativeBrownfield(ReactHost reactHost, DefaultConstructorMarker defaultConstructorMarker) {
        this(reactHost);
    }

    public static final ReactNativeBrownfield getShared() {
        return INSTANCE.getShared();
    }

    @JvmStatic
    public static final void initialize(Application application, ReactHost reactHost) throws IOException {
        INSTANCE.initialize(application, reactHost);
    }

    @JvmStatic
    public static final void initialize(Application application, ReactHost reactHost, OnJSBundleLoaded onJSBundleLoaded) throws IOException {
        INSTANCE.initialize(application, reactHost, onJSBundleLoaded);
    }

    @JvmStatic
    public static final void initialize(Application application, HashMap<String, Object> map) throws IOException {
        INSTANCE.initialize(application, map);
    }

    @JvmStatic
    public static final void initialize(Application application, HashMap<String, Object> map, OnJSBundleLoaded onJSBundleLoaded) throws IOException {
        INSTANCE.initialize(application, map, onJSBundleLoaded);
    }

    @JvmStatic
    public static final void initialize(Application application, List<? extends ReactPackage> list) throws IOException {
        INSTANCE.initialize(application, list);
    }

    @JvmStatic
    public static final void initialize(Application application, List<? extends ReactPackage> list, OnJSBundleLoaded onJSBundleLoaded) throws IOException {
        INSTANCE.initialize(application, list, onJSBundleLoaded);
    }

    /* JADX INFO: compiled from: ReactNativeBrownfield.kt */
    @Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002J$\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0007J@\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\"\u0010\u0015\u001a\u001e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u00010\u0016j\u000e\u0012\u0004\u0012\u00020\u0017\u0012\u0004\u0012\u00020\u0001`\u00182\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0007J*\u0010\u0010\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001a2\n\b\u0002\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0007J\u001c\u0010\u001c\u001a\u00020\r2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u001f\u0012\u0004\u0012\u00020\r0\u001eH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\b\u001a\u00020\u00058FX\u0087\u0004¢\u0006\f\u0012\u0004\b\t\u0010\u0003\u001a\u0004\b\n\u0010\u000b¨\u0006 ²\u0006\n\u0010\u0011\u001a\u00020\u0012X\u008a\u0084\u0002"}, d2 = {"Lcom/callstack/reactnativebrownfield/ReactNativeBrownfield$Companion;", "", "<init>", "()V", "instance", "Lcom/callstack/reactnativebrownfield/ReactNativeBrownfield;", "initialized", "Ljava/util/concurrent/atomic/AtomicBoolean;", "shared", "getShared$annotations", "getShared", "()Lcom/callstack/reactnativebrownfield/ReactNativeBrownfield;", "loadNativeLibs", "", MimeTypes.BASE_TYPE_APPLICATION, "Landroid/app/Application;", "initialize", "reactHost", "Lcom/facebook/react/ReactHost;", "onJSBundleLoaded", "Lcom/callstack/reactnativebrownfield/OnJSBundleLoaded;", "options", "Ljava/util/HashMap;", "", "Lkotlin/collections/HashMap;", "packages", "", "Lcom/facebook/react/ReactPackage;", "preloadReactNative", "callback", "Lkotlin/Function1;", "", "callstack_react-native-brownfield_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public static /* synthetic */ void getShared$annotations() {
        }

        @JvmStatic
        public final void initialize(Application application, ReactHost reactHost) throws IOException {
            Intrinsics.checkNotNullParameter(application, "application");
            Intrinsics.checkNotNullParameter(reactHost, "reactHost");
            initialize$default(this, application, reactHost, (OnJSBundleLoaded) null, 4, (Object) null);
        }

        @JvmStatic
        public final void initialize(Application application, HashMap<String, Object> options) throws IOException {
            Intrinsics.checkNotNullParameter(application, "application");
            Intrinsics.checkNotNullParameter(options, "options");
            initialize$default(this, application, options, (OnJSBundleLoaded) null, 4, (Object) null);
        }

        @JvmStatic
        public final void initialize(Application application, List<? extends ReactPackage> packages) throws IOException {
            Intrinsics.checkNotNullParameter(application, "application");
            Intrinsics.checkNotNullParameter(packages, "packages");
            initialize$default(this, application, packages, (OnJSBundleLoaded) null, 4, (Object) null);
        }

        private Companion() {
        }

        public final ReactNativeBrownfield getShared() {
            ReactNativeBrownfield reactNativeBrownfield = ReactNativeBrownfield.instance;
            if (reactNativeBrownfield != null) {
                return reactNativeBrownfield;
            }
            Intrinsics.throwUninitializedPropertyAccessException("instance");
            return null;
        }

        private final void loadNativeLibs(Application application) throws IOException {
            if (VersionUtils.INSTANCE.isVersionLessThan(BuildConfig.RN_VERSION, "0.80.0")) {
                SoLoader.init(application.getApplicationContext(), OpenSourceMergedSoMapping.INSTANCE);
                DefaultNewArchitectureEntryPoint.load();
            }
        }

        public static /* synthetic */ void initialize$default(Companion companion, Application application, ReactHost reactHost, OnJSBundleLoaded onJSBundleLoaded, int i, Object obj) throws IOException {
            if ((i & 4) != 0) {
                onJSBundleLoaded = null;
            }
            companion.initialize(application, reactHost, onJSBundleLoaded);
        }

        @JvmStatic
        public final void initialize(Application application, ReactHost reactHost, final OnJSBundleLoaded onJSBundleLoaded) throws IOException {
            Intrinsics.checkNotNullParameter(application, "application");
            Intrinsics.checkNotNullParameter(reactHost, "reactHost");
            if (ReactNativeBrownfield.initialized.getAndSet(true)) {
                return;
            }
            loadNativeLibs(application);
            ReactNativeBrownfield.instance = new ReactNativeBrownfield(reactHost, null);
            preloadReactNative(new Function1() { // from class: com.callstack.reactnativebrownfield.ReactNativeBrownfield$Companion$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return ReactNativeBrownfield.Companion.initialize$lambda$0(onJSBundleLoaded, ((Boolean) obj).booleanValue());
                }
            });
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final Unit initialize$lambda$0(OnJSBundleLoaded onJSBundleLoaded, boolean z) {
            if (onJSBundleLoaded != null) {
                onJSBundleLoaded.invoke(true);
            }
            return Unit.INSTANCE;
        }

        public static /* synthetic */ void initialize$default(Companion companion, Application application, HashMap map, OnJSBundleLoaded onJSBundleLoaded, int i, Object obj) throws IOException {
            if ((i & 4) != 0) {
                onJSBundleLoaded = null;
            }
            companion.initialize(application, (HashMap<String, Object>) map, onJSBundleLoaded);
        }

        private static final ReactHost initialize$lambda$2(Lazy<? extends ReactHost> lazy) {
            return lazy.getValue();
        }

        @JvmStatic
        public final void initialize(final Application application, final HashMap<String, Object> options, OnJSBundleLoaded onJSBundleLoaded) throws IOException {
            Intrinsics.checkNotNullParameter(application, "application");
            Intrinsics.checkNotNullParameter(options, "options");
            initialize(application, initialize$lambda$2(LazyKt.lazy(new Function0() { // from class: com.callstack.reactnativebrownfield.ReactNativeBrownfield$Companion$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ReactNativeBrownfield.Companion.initialize$lambda$1(options, application);
                }
            })), onJSBundleLoaded);
        }

        /* JADX INFO: Access modifiers changed from: private */
        public static final ReactHost initialize$lambda$1(HashMap map, Application application) {
            DefaultReactHost defaultReactHost = DefaultReactHost.INSTANCE;
            Object obj = map.get("packages");
            List listEmptyList = obj instanceof List ? (List) obj : null;
            if (listEmptyList == null) {
                listEmptyList = CollectionsKt.emptyList();
            }
            ArrayList arrayList = new ArrayList();
            for (Object obj2 : listEmptyList) {
                if (obj2 instanceof ReactPackage) {
                    arrayList.add(obj2);
                }
            }
            ArrayList arrayList2 = arrayList;
            Object obj3 = map.get("mainModuleName");
            String str = obj3 instanceof String ? (String) obj3 : null;
            if (str == null) {
                str = FirebaseAnalytics.Param.INDEX;
            }
            String str2 = str;
            Object obj4 = map.get("bundleAssetPath");
            String str3 = obj4 instanceof String ? (String) obj4 : null;
            if (str3 == null) {
                str3 = "index.android.bundle";
            }
            String str4 = str3;
            Object obj5 = map.get("bundleFilePath");
            String str5 = obj5 instanceof String ? (String) obj5 : null;
            Object obj6 = map.get("useDeveloperSupport");
            Boolean bool = obj6 instanceof Boolean ? (Boolean) obj6 : null;
            return DefaultReactHost.getDefaultReactHost(application, arrayList2, (896 & 4) != 0 ? FirebaseAnalytics.Param.INDEX : str2, (896 & 8) != 0 ? "index.android.bundle" : str4, (896 & 16) != 0 ? null : str5, (896 & 32) != 0 ? null : null, (896 & 64) != 0 ? ReactBuildConfig.DEBUG : bool != null ? bool.booleanValue() : ReactBuildConfig.DEBUG, (896 & 128) != 0 ? CollectionsKt.emptyList() : null, (896 & 256) != 0 ? 
            /*  JADX ERROR: Method code generation error
                jadx.core.utils.exceptions.CodegenException: Error generate insn: 0x0098: RETURN 
                  (wrap com.facebook.react.ReactHost:0x0094: INVOKE 
                  (r19v0 'application' android.app.Application)
                  (r7v1 'arrayList2' java.util.ArrayList)
                  (wrap java.lang.String:?: TERNARY null = ((wrap int:0x0002: ARITH (896 int) & (4 int) A[WRAPPED]) != (0 int)) ? (wrap ??:0x0006: SGET  A[WRAPPED] (LINE:65) com.google.firebase.analytics.FirebaseAnalytics.Param.INDEX java.lang.String) : (r8v0 'str2' java.lang.String))
                  (wrap java.lang.String:?: TERNARY null = ((wrap int:0x000a: ARITH (896 int) & (8 int) A[WRAPPED]) != (0 int)) ? ("index.android.bundle") : (r9v0 'str4' java.lang.String))
                  (wrap java.lang.String:?: TERNARY null = ((wrap int:0x0012: ARITH (896 int) & (16 int) A[WRAPPED]) != (0 int)) ? (null java.lang.String) : (r10v1 'str5' java.lang.String))
                  (wrap com.facebook.react.runtime.JSRuntimeFactory:?: TERNARY null = ((wrap int:0x001a: ARITH (896 int) & (32 int) A[WRAPPED]) != (0 int)) ? (null com.facebook.react.runtime.JSRuntimeFactory) : (null com.facebook.react.runtime.JSRuntimeFactory))
                  (wrap boolean:?: TERNARY null = ((wrap int:0x0021: ARITH (896 int) & (64 int) A[WRAPPED]) != (0 int)) ? (wrap ??:0x0025: SGET  A[WRAPPED] (LINE:69) com.facebook.react.common.build.ReactBuildConfig.DEBUG boolean) : (wrap boolean:?: TERNARY null = ((r3v1 'bool' java.lang.Boolean) != (null java.lang.Boolean)) ? (wrap ??:0x0080: INVOKE (r3v1 'bool' java.lang.Boolean) VIRTUAL call: java.lang.Boolean.booleanValue():boolean A[MD:():boolean (c), WRAPPED]) : (wrap ??:0x0085: SGET  A[WRAPPED] (LINE:83) com.facebook.react.common.build.ReactBuildConfig.DEBUG boolean)))
                  (wrap java.util.List:?: TERNARY null = ((wrap int:0x0029: ARITH (896 int) & (128 int) A[WRAPPED]) != (0 int)) ? (wrap ??:0x002d: INVOKE  STATIC call: kotlin.collections.CollectionsKt.emptyList():java.util.List A[MD:<T>:():java.util.List<T> (m), WRAPPED] (LINE:70)) : (null java.util.List))
                  (wrap kotlin.jvm.functions.Function1:?: TERNARY null = ((wrap int:0x0034: ARITH (896 int) & (256 int) A[WRAPPED]) != (0 int)) ? (wrap ??:0x003a: CONSTRUCTOR  A[MD:():void (m), WRAPPED] (LINE:71) call: com.facebook.react.defaults.DefaultReactHost$$ExternalSyntheticLambda0.<init>():void type: CONSTRUCTOR) : (null kotlin.jvm.functions.Function1))
                  (wrap com.facebook.react.runtime.BindingsInstaller:?: TERNARY null = ((wrap int:0x0040: ARITH (896 int) & (512 int) A[WRAPPED]) != (0 int)) ? (null com.facebook.react.runtime.BindingsInstaller) : (null com.facebook.react.runtime.BindingsInstaller))
                 STATIC call: com.facebook.react.defaults.DefaultReactHost.getDefaultReactHost(android.content.Context, java.util.List, java.lang.String, java.lang.String, java.lang.String, com.facebook.react.runtime.JSRuntimeFactory, boolean, java.util.List, kotlin.jvm.functions.Function1, com.facebook.react.runtime.BindingsInstaller):com.facebook.react.ReactHost A[MD:(android.content.Context, java.util.List<? extends com.facebook.react.ReactPackage>, java.lang.String, java.lang.String, java.lang.String, com.facebook.react.runtime.JSRuntimeFactory, boolean, java.util.List<? extends kotlin.jvm.functions.Function1<? super com.facebook.react.bridge.ReactContext, ? extends com.facebook.react.runtime.cxxreactpackage.CxxReactPackage>>, kotlin.jvm.functions.Function1<? super java.lang.Exception, kotlin.Unit>, com.facebook.react.runtime.BindingsInstaller):com.facebook.react.ReactHost (m), WRAPPED] (LINE:60))
                 (LINE:60) in method: com.callstack.reactnativebrownfield.ReactNativeBrownfield.Companion.initialize$lambda$1(java.util.HashMap, android.app.Application):com.facebook.react.ReactHost, file: classes13.dex
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:310)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:273)
                	at jadx.core.codegen.RegionGen.makeSimpleBlock(RegionGen.java:94)
                	at jadx.core.dex.nodes.IBlock.generate(IBlock.java:15)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                	at jadx.core.dex.regions.Region.generate(Region.java:35)
                	at jadx.core.codegen.RegionGen.makeRegion(RegionGen.java:66)
                	at jadx.core.codegen.MethodGen.addRegionInsns(MethodGen.java:291)
                	at jadx.core.codegen.MethodGen.addInstructions(MethodGen.java:270)
                	at jadx.core.codegen.ClassGen.addMethodCode(ClassGen.java:420)
                	at jadx.core.codegen.ClassGen.addMethod(ClassGen.java:345)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:299)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                	at jadx.core.codegen.ClassGen.addInnerClass(ClassGen.java:320)
                	at jadx.core.codegen.ClassGen.lambda$addInnerClsAndMethods$3(ClassGen.java:297)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.accept(ForEachOps.java:186)
                	at java.base/java.util.ArrayList.forEach(ArrayList.java:1612)
                	at java.base/java.util.stream.SortedOps$RefSortingSink.end(SortedOps.java:395)
                	at java.base/java.util.stream.Sink$ChainedReference.end(Sink.java:261)
                	at java.base/java.util.stream.ReferencePipeline$7$1FlatMap.end(ReferencePipeline.java:284)
                	at java.base/java.util.stream.AbstractPipeline.copyInto(AbstractPipeline.java:571)
                	at java.base/java.util.stream.AbstractPipeline.wrapAndCopyInto(AbstractPipeline.java:560)
                	at java.base/java.util.stream.ForEachOps$ForEachOp.evaluateSequential(ForEachOps.java:153)
                	at java.base/java.util.stream.ForEachOps$ForEachOp$OfRef.evaluateSequential(ForEachOps.java:176)
                	at java.base/java.util.stream.AbstractPipeline.evaluate(AbstractPipeline.java:265)
                	at java.base/java.util.stream.ReferencePipeline.forEach(ReferencePipeline.java:632)
                	at jadx.core.codegen.ClassGen.addInnerClsAndMethods(ClassGen.java:295)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:284)
                	at jadx.core.codegen.ClassGen.addClassBody(ClassGen.java:268)
                	at jadx.core.codegen.ClassGen.addClassCode(ClassGen.java:160)
                	at jadx.core.codegen.ClassGen.makeClass(ClassGen.java:104)
                	at jadx.core.codegen.CodeGen.wrapCodeGen(CodeGen.java:45)
                	at jadx.core.codegen.CodeGen.generateJavaCode(CodeGen.java:34)
                	at jadx.core.codegen.CodeGen.generate(CodeGen.java:22)
                	at jadx.core.ProcessClass.process(ProcessClass.java:89)
                	at jadx.core.ProcessClass.generateCode(ProcessClass.java:127)
                	at jadx.core.dex.nodes.ClassNode.generateClassCode(ClassNode.java:405)
                	at jadx.core.dex.nodes.ClassNode.decompile(ClassNode.java:393)
                	at jadx.core.dex.nodes.ClassNode.getCode(ClassNode.java:343)
                Caused by: jadx.core.utils.exceptions.JadxRuntimeException: Expected class to be processed at this point, class: com.facebook.react.defaults.DefaultReactHost$$ExternalSyntheticLambda0, state: NOT_LOADED
                	at jadx.core.dex.nodes.ClassNode.ensureProcessed(ClassNode.java:306)
                	at jadx.core.codegen.InsnGen.inlineAnonymousConstructor(InsnGen.java:807)
                	at jadx.core.codegen.InsnGen.makeConstructor(InsnGen.java:730)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:418)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                	at jadx.core.codegen.InsnGen.makeTernary(InsnGen.java:1187)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:536)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                	at jadx.core.codegen.InsnGen.generateMethodArguments(InsnGen.java:1143)
                	at jadx.core.codegen.InsnGen.makeInvoke(InsnGen.java:910)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:422)
                	at jadx.core.codegen.InsnGen.addWrappedArg(InsnGen.java:145)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:121)
                	at jadx.core.codegen.InsnGen.addArg(InsnGen.java:108)
                	at jadx.core.codegen.InsnGen.makeInsnBody(InsnGen.java:368)
                	at jadx.core.codegen.InsnGen.makeInsn(InsnGen.java:303)
                	... 52 more
                */
            /*
                r0 = r18
                com.facebook.react.defaults.DefaultReactHost r1 = com.facebook.react.defaults.DefaultReactHost.INSTANCE
                java.lang.String r1 = "packages"
                java.lang.Object r1 = r0.get(r1)
                boolean r2 = r1 instanceof java.util.List
                r3 = 0
                if (r2 == 0) goto L12
                java.util.List r1 = (java.util.List) r1
                goto L13
            L12:
                r1 = r3
            L13:
                if (r1 != 0) goto L19
                java.util.List r1 = kotlin.collections.CollectionsKt.emptyList()
            L19:
                java.lang.Iterable r1 = (java.lang.Iterable) r1
                java.util.ArrayList r2 = new java.util.ArrayList
                r2.<init>()
                java.util.Collection r2 = (java.util.Collection) r2
                java.util.Iterator r1 = r1.iterator()
            L26:
                boolean r4 = r1.hasNext()
                if (r4 == 0) goto L38
                java.lang.Object r4 = r1.next()
                boolean r5 = r4 instanceof com.facebook.react.ReactPackage
                if (r5 == 0) goto L26
                r2.add(r4)
                goto L26
            L38:
                r7 = r2
                java.util.List r7 = (java.util.List) r7
                java.lang.String r1 = "mainModuleName"
                java.lang.Object r1 = r0.get(r1)
                boolean r2 = r1 instanceof java.lang.String
                if (r2 == 0) goto L48
                java.lang.String r1 = (java.lang.String) r1
                goto L49
            L48:
                r1 = r3
            L49:
                if (r1 != 0) goto L4d
                java.lang.String r1 = "index"
            L4d:
                r8 = r1
                java.lang.String r1 = "bundleAssetPath"
                java.lang.Object r1 = r0.get(r1)
                boolean r2 = r1 instanceof java.lang.String
                if (r2 == 0) goto L5b
                java.lang.String r1 = (java.lang.String) r1
                goto L5c
            L5b:
                r1 = r3
            L5c:
                if (r1 != 0) goto L60
                java.lang.String r1 = "index.android.bundle"
            L60:
                r9 = r1
                java.lang.String r1 = "bundleFilePath"
                java.lang.Object r1 = r0.get(r1)
                boolean r2 = r1 instanceof java.lang.String
                if (r2 == 0) goto L6f
                java.lang.String r1 = (java.lang.String) r1
                r10 = r1
                goto L70
            L6f:
                r10 = r3
            L70:
                java.lang.String r1 = "useDeveloperSupport"
                java.lang.Object r0 = r0.get(r1)
                boolean r1 = r0 instanceof java.lang.Boolean
                if (r1 == 0) goto L7e
                r3 = r0
                java.lang.Boolean r3 = (java.lang.Boolean) r3
            L7e:
                if (r3 == 0) goto L85
                boolean r0 = r3.booleanValue()
                goto L87
            L85:
                boolean r0 = com.facebook.react.common.build.ReactBuildConfig.DEBUG
            L87:
                r12 = r0
                r6 = r19
                android.content.Context r6 = (android.content.Context) r6
                r16 = 896(0x380, float:1.256E-42)
                r17 = 0
                r11 = 0
                r13 = 0
                r14 = 0
                r15 = 0
                com.facebook.react.ReactHost r0 = com.facebook.react.defaults.DefaultReactHost.getDefaultReactHost$default(r6, r7, r8, r9, r10, r11, r12, r13, r14, r15, r16, r17)
                return r0
            */
            throw new UnsupportedOperationException("Method not decompiled: com.callstack.reactnativebrownfield.ReactNativeBrownfield.Companion.initialize$lambda$1(java.util.HashMap, android.app.Application):com.facebook.react.ReactHost");
        }

        public static /* synthetic */ void initialize$default(Companion companion, Application application, List list, OnJSBundleLoaded onJSBundleLoaded, int i, Object obj) throws IOException {
            if ((i & 4) != 0) {
                onJSBundleLoaded = null;
            }
            companion.initialize(application, (List<? extends ReactPackage>) list, onJSBundleLoaded);
        }

        @JvmStatic
        public final void initialize(Application application, List<? extends ReactPackage> packages, OnJSBundleLoaded onJSBundleLoaded) throws IOException {
            Intrinsics.checkNotNullParameter(application, "application");
            Intrinsics.checkNotNullParameter(packages, "packages");
            initialize(application, MapsKt.hashMapOf(TuplesKt.to("packages", packages), TuplesKt.to("mainModuleName", FirebaseAnalytics.Param.INDEX)), onJSBundleLoaded);
        }

        private final void preloadReactNative(final Function1<? super Boolean, Unit> callback) {
            getShared().getReactHost().addReactInstanceEventListener(new ReactInstanceEventListener() { // from class: com.callstack.reactnativebrownfield.ReactNativeBrownfield$Companion$preloadReactNative$1
                @Override // com.facebook.react.ReactInstanceEventListener
                public void onReactContextInitialized(ReactContext context) {
                    Intrinsics.checkNotNullParameter(context, "context");
                    callback.invoke(true);
                    ReactNativeBrownfield.INSTANCE.getShared().getReactHost().removeReactInstanceEventListener(this);
                }
            });
            getShared().getReactHost().start();
        }
    }

    private ReactNativeBrownfield(ReactHost reactHost) {
        this.reactHost = reactHost;
    }

    public final ReactHost getReactHost() {
        return this.reactHost;
    }

    public static /* synthetic */ FrameLayout createView$default(ReactNativeBrownfield reactNativeBrownfield, FragmentActivity fragmentActivity, String str, ReactDelegateWrapper reactDelegateWrapper, Bundle bundle, int i, Object obj) {
        if ((i & 4) != 0) {
            reactDelegateWrapper = null;
        }
        if ((i & 8) != 0) {
            bundle = null;
        }
        return reactNativeBrownfield.createView(fragmentActivity, str, reactDelegateWrapper, bundle);
    }

    public final FrameLayout createView(final FragmentActivity activity, String moduleName, ReactDelegateWrapper reactDelegate, Bundle launchOptions) {
        Lifecycle lifecycle;
        OnBackPressedDispatcher onBackPressedDispatcher;
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        final ReactDelegateWrapper reactDelegateWrapper = reactDelegate == null ? new ReactDelegateWrapper(activity, INSTANCE.getShared().reactHost, moduleName, launchOptions) : reactDelegate;
        final OnBackPressedCallback onBackPressedCallback = new OnBackPressedCallback() { // from class: com.callstack.reactnativebrownfield.ReactNativeBrownfield$createView$mBackPressedCallback$1
            {
                super(true);
            }

            @Override // androidx.activity.OnBackPressedCallback
            public void handleOnBackPressed() {
                reactDelegateWrapper.onBackPressed();
            }
        };
        if (activity != null && (onBackPressedDispatcher = activity.getOnBackPressedDispatcher()) != null) {
            onBackPressedDispatcher.addCallback(onBackPressedCallback);
        }
        reactDelegateWrapper.setHardwareBackHandler(new Function0() { // from class: com.callstack.reactnativebrownfield.ReactNativeBrownfield$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ReactNativeBrownfield.createView$lambda$0(onBackPressedCallback, activity);
            }
        });
        if (reactDelegate == null && activity != null && (lifecycle = activity.getLifecycleRegistry()) != null) {
            lifecycle.addObserver(getLifeCycleObserver(reactDelegateWrapper));
        }
        reactDelegateWrapper.loadApp();
        ReactRootView reactRootView = reactDelegateWrapper.getReactRootView();
        Intrinsics.checkNotNull(reactRootView);
        return reactRootView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit createView$lambda$0(OnBackPressedCallback onBackPressedCallback, FragmentActivity fragmentActivity) {
        OnBackPressedDispatcher onBackPressedDispatcher;
        onBackPressedCallback.setEnabled(false);
        if (fragmentActivity != null && (onBackPressedDispatcher = fragmentActivity.getOnBackPressedDispatcher()) != null) {
            onBackPressedDispatcher.onBackPressed();
        }
        return Unit.INSTANCE;
    }

    private final DefaultLifecycleObserver getLifeCycleObserver(final ReactDelegateWrapper reactDelegate) {
        return new DefaultLifecycleObserver() { // from class: com.callstack.reactnativebrownfield.ReactNativeBrownfield.getLifeCycleObserver.1
            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public void onResume(LifecycleOwner owner) {
                Intrinsics.checkNotNullParameter(owner, "owner");
                reactDelegate.onReactHostResume();
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public void onPause(LifecycleOwner owner) {
                Intrinsics.checkNotNullParameter(owner, "owner");
                reactDelegate.onHostPause();
            }

            @Override // androidx.lifecycle.DefaultLifecycleObserver
            public void onDestroy(LifecycleOwner owner) {
                Intrinsics.checkNotNullParameter(owner, "owner");
                reactDelegate.onHostDestroy();
                owner.getLifecycleRegistry().removeObserver(this);
            }
        };
    }
}

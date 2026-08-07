package expo.modules.kotlin.runtime;

import androidx.tracing.Trace;
import com.facebook.react.bridge.JavaScriptContextHolder;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.RuntimeExecutor;
import expo.modules.core.logging.Logger;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.CoreLoggerKt;
import expo.modules.kotlin.ModuleHolder;
import expo.modules.kotlin.UtilsKt;
import expo.modules.kotlin.defaultmodules.CoreModule;
import expo.modules.kotlin.jni.JNIDeallocator;
import expo.modules.kotlin.jni.JSIContext;
import expo.modules.kotlin.jni.JavaScriptValue;
import expo.modules.kotlin.jni.MainRuntimeInstaller;
import expo.modules.kotlin.sharedobjects.ClassRegistry;
import expo.modules.kotlin.sharedobjects.SharedObjectRegistry;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MainRuntime.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\u001a2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0016\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\u001e0 H\u0016J\r\u00102\u001a\u00020\u001eH\u0000¢\u0006\u0002\b3J\r\u00104\u001a\u00020\u001eH\u0010¢\u0006\u0002\b5R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\f\u0010\rR\u0016\u0010\u000e\u001a\u0004\u0018\u00010\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000f\u0010\u0010R\u001a\u0010\u0011\u001a\u00020\u0012X\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0014\"\u0004\b\u0015\u0010\u0016R\u001a\u0010!\u001a\b\u0012\u0004\u0012\u00020#0\"X\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0014\u0010&\u001a\u00020'X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b(\u0010)R\u0014\u0010*\u001a\u00020+X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b,\u0010-R\u0014\u0010.\u001a\u00020/X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b0\u00101¨\u00066"}, d2 = {"Lexpo/modules/kotlin/runtime/MainRuntime;", "Lexpo/modules/kotlin/runtime/Runtime;", "appContext", "Lexpo/modules/kotlin/AppContext;", "reactContextHolder", "Ljava/lang/ref/WeakReference;", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lexpo/modules/kotlin/AppContext;Ljava/lang/ref/WeakReference;)V", "getReactContextHolder", "()Ljava/lang/ref/WeakReference;", "appContextHolder", "getAppContext", "()Lexpo/modules/kotlin/AppContext;", "reactContext", "getReactContext", "()Lcom/facebook/react/bridge/ReactApplicationContext;", "jsiContext", "Lexpo/modules/kotlin/jni/JSIContext;", "getJsiContext", "()Lexpo/modules/kotlin/jni/JSIContext;", "setJsiContext", "(Lexpo/modules/kotlin/jni/JSIContext;)V", "isJSIContextInitialized", "", "eval", "Lexpo/modules/kotlin/jni/JavaScriptValue;", "source", "", "schedule", "", "block", "Lkotlin/Function0;", "coreModule", "Lexpo/modules/kotlin/ModuleHolder;", "Lexpo/modules/kotlin/defaultmodules/CoreModule;", "getCoreModule$expo_modules_core_release", "()Lexpo/modules/kotlin/ModuleHolder;", "deallocator", "Lexpo/modules/kotlin/jni/JNIDeallocator;", "getDeallocator$expo_modules_core_release", "()Lexpo/modules/kotlin/jni/JNIDeallocator;", "sharedObjectRegistry", "Lexpo/modules/kotlin/sharedobjects/SharedObjectRegistry;", "getSharedObjectRegistry$expo_modules_core_release", "()Lexpo/modules/kotlin/sharedobjects/SharedObjectRegistry;", "classRegistry", "Lexpo/modules/kotlin/sharedobjects/ClassRegistry;", "getClassRegistry$expo_modules_core_release", "()Lexpo/modules/kotlin/sharedobjects/ClassRegistry;", "install", "install$expo_modules_core_release", "deallocate", "deallocate$expo_modules_core_release", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MainRuntime extends Runtime {
    public static final int $stable = 8;
    private final WeakReference<AppContext> appContextHolder;
    private final ClassRegistry classRegistry;
    private final ModuleHolder<CoreModule> coreModule;
    private final JNIDeallocator deallocator;
    public JSIContext jsiContext;
    private final WeakReference<ReactApplicationContext> reactContextHolder;
    private final SharedObjectRegistry sharedObjectRegistry;

    public final WeakReference<ReactApplicationContext> getReactContextHolder() {
        return this.reactContextHolder;
    }

    public MainRuntime(AppContext appContext, WeakReference<ReactApplicationContext> reactContextHolder) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(reactContextHolder, "reactContextHolder");
        this.reactContextHolder = reactContextHolder;
        this.appContextHolder = UtilsKt.weak(appContext);
        CoreModule coreModule = new CoreModule();
        coreModule.set_appContextHolder$expo_modules_core_release(this.appContextHolder);
        this.coreModule = new ModuleHolder<>(coreModule, null);
        this.deallocator = new JNIDeallocator(false, 1, null);
        this.sharedObjectRegistry = new SharedObjectRegistry(this);
        this.classRegistry = new ClassRegistry();
    }

    @Override // expo.modules.kotlin.runtime.Runtime
    public AppContext getAppContext() {
        return this.appContextHolder.get();
    }

    @Override // expo.modules.kotlin.runtime.Runtime
    public ReactApplicationContext getReactContext() {
        return this.reactContextHolder.get();
    }

    @Override // expo.modules.kotlin.runtime.Runtime
    public JSIContext getJsiContext() {
        JSIContext jSIContext = this.jsiContext;
        if (jSIContext != null) {
            return jSIContext;
        }
        Intrinsics.throwUninitializedPropertyAccessException("jsiContext");
        return null;
    }

    public void setJsiContext(JSIContext jSIContext) {
        Intrinsics.checkNotNullParameter(jSIContext, "<set-?>");
        this.jsiContext = jSIContext;
    }

    private final boolean isJSIContextInitialized() {
        return this.jsiContext != null;
    }

    @Override // expo.modules.kotlin.runtime.Runtime
    public JavaScriptValue eval(String source) {
        Intrinsics.checkNotNullParameter(source, "source");
        return getJsiContext().evaluateScript(source);
    }

    @Override // expo.modules.kotlin.runtime.Runtime
    public void schedule(final Function0<Unit> block) {
        Intrinsics.checkNotNullParameter(block, "block");
        ReactApplicationContext reactContext = getReactContext();
        if (reactContext != null) {
            reactContext.runOnJSQueueThread(new Runnable() { // from class: expo.modules.kotlin.runtime.MainRuntime$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    block.invoke();
                }
            });
        }
    }

    public final ModuleHolder<CoreModule> getCoreModule$expo_modules_core_release() {
        return this.coreModule;
    }

    @Override // expo.modules.kotlin.runtime.Runtime
    /* JADX INFO: renamed from: getDeallocator$expo_modules_core_release, reason: from getter */
    public JNIDeallocator getDeallocator() {
        return this.deallocator;
    }

    @Override // expo.modules.kotlin.runtime.Runtime
    /* JADX INFO: renamed from: getSharedObjectRegistry$expo_modules_core_release, reason: from getter */
    public SharedObjectRegistry getSharedObjectRegistry() {
        return this.sharedObjectRegistry;
    }

    @Override // expo.modules.kotlin.runtime.Runtime
    /* JADX INFO: renamed from: getClassRegistry$expo_modules_core_release, reason: from getter */
    public ClassRegistry getClassRegistry() {
        return this.classRegistry;
    }

    public final void install$expo_modules_core_release() {
        JavaScriptContextHolder javaScriptContextHolder;
        synchronized (this) {
            if (isJSIContextInitialized()) {
                Logger.warn$default(CoreLoggerKt.getLogger(), "⚠️ JSI interop was already installed", null, 2, null);
                return;
            }
            Trace.beginSection("[ExpoModulesCore] " + (this + ".install"));
            try {
                try {
                    ReactApplicationContext reactApplicationContext = getReactContextHolder().get();
                    if (reactApplicationContext != null && (javaScriptContextHolder = reactApplicationContext.getJavaScriptContextHolder()) != null) {
                        Long lValueOf = Long.valueOf(javaScriptContextHolder.getContext());
                        if (lValueOf.longValue() == 0) {
                            lValueOf = null;
                        }
                        if (lValueOf != null) {
                            long jLongValue = lValueOf.longValue();
                            MainRuntimeInstaller mainRuntimeInstaller = new MainRuntimeInstaller(this);
                            RuntimeExecutor runtimeExecutor = reactApplicationContext.getCatalystInstance().getRuntimeExecutor();
                            Intrinsics.checkNotNull(runtimeExecutor);
                            setJsiContext(mainRuntimeInstaller.install(jLongValue, runtimeExecutor));
                            CoreLoggerKt.getLogger().info("✅ JSI interop was installed");
                        } else {
                            Logger.error$default(CoreLoggerKt.getLogger(), "❌ Cannot install JSI interop - JS runtime pointer is null", null, 2, null);
                        }
                    }
                } catch (Throwable th) {
                    CoreLoggerKt.getLogger().error("❌ Cannot install JSI interop: " + th, th);
                }
                Unit unit = Unit.INSTANCE;
                Trace.endSection();
                Unit unit2 = Unit.INSTANCE;
            } catch (Throwable th2) {
                Trace.endSection();
                throw th2;
            }
        }
    }

    @Override // expo.modules.kotlin.runtime.Runtime
    public void deallocate$expo_modules_core_release() {
        getDeallocator().deallocate$expo_modules_core_release();
    }
}

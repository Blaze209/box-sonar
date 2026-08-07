package expo.modules.kotlin.runtime;

import androidx.tracing.Trace;
import com.facebook.react.bridge.ReactApplicationContext;
import expo.modules.core.logging.Logger;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.CoreLoggerKt;
import expo.modules.kotlin.UtilsKt;
import expo.modules.kotlin.jni.JNIDeallocator;
import expo.modules.kotlin.jni.JSIContext;
import expo.modules.kotlin.jni.JavaScriptValue;
import expo.modules.kotlin.jni.WorkletRuntimeInstaller;
import expo.modules.kotlin.jni.worklets.WorkletNativeRuntime;
import expo.modules.kotlin.sharedobjects.ClassRegistry;
import expo.modules.kotlin.sharedobjects.SharedObjectRegistry;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: WorkletRuntime.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005¢\u0006\u0004\b\u0007\u0010\bJ\b\u0010\u001e\u001a\u00020\u001fH\u0002J\u0010\u0010)\u001a\u00020*2\u0006\u0010+\u001a\u00020,H\u0016J\u0016\u0010-\u001a\u00020.2\f\u0010/\u001a\b\u0012\u0004\u0012\u00020.00H\u0016J\u0015\u00101\u001a\u00020.2\u0006\u00102\u001a\u000203H\u0000¢\u0006\u0002\b4J\r\u00105\u001a\u00020.H\u0010¢\u0006\u0002\b6R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\t\u001a\u00020\nX\u0096.¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0080\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0016\u001a\u00020\u0017X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0014\u0010\u001a\u001a\u00020\u001bX\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00038VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b \u0010!R\u0016\u0010\"\u001a\u0004\u0018\u00010\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b#\u0010$R\u0014\u0010%\u001a\u00020&X\u0090\u0004¢\u0006\b\n\u0000\u001a\u0004\b'\u0010(¨\u00067"}, d2 = {"Lexpo/modules/kotlin/runtime/WorkletRuntime;", "Lexpo/modules/kotlin/runtime/Runtime;", "appContext", "Lexpo/modules/kotlin/AppContext;", "reactContextHolder", "Ljava/lang/ref/WeakReference;", "Lcom/facebook/react/bridge/ReactApplicationContext;", "<init>", "(Lexpo/modules/kotlin/AppContext;Ljava/lang/ref/WeakReference;)V", "jsiContext", "Lexpo/modules/kotlin/jni/JSIContext;", "getJsiContext", "()Lexpo/modules/kotlin/jni/JSIContext;", "setJsiContext", "(Lexpo/modules/kotlin/jni/JSIContext;)V", "mWorkletNativeRuntime", "Lexpo/modules/kotlin/jni/worklets/WorkletNativeRuntime;", "getMWorkletNativeRuntime$expo_modules_core_release", "()Lexpo/modules/kotlin/jni/worklets/WorkletNativeRuntime;", "setMWorkletNativeRuntime$expo_modules_core_release", "(Lexpo/modules/kotlin/jni/worklets/WorkletNativeRuntime;)V", "appContextHolder", "sharedObjectRegistry", "Lexpo/modules/kotlin/sharedobjects/SharedObjectRegistry;", "getSharedObjectRegistry$expo_modules_core_release", "()Lexpo/modules/kotlin/sharedobjects/SharedObjectRegistry;", "classRegistry", "Lexpo/modules/kotlin/sharedobjects/ClassRegistry;", "getClassRegistry$expo_modules_core_release", "()Lexpo/modules/kotlin/sharedobjects/ClassRegistry;", "isJSIContextInitialized", "", "getAppContext", "()Lexpo/modules/kotlin/AppContext;", "reactContext", "getReactContext", "()Lcom/facebook/react/bridge/ReactApplicationContext;", "deallocator", "Lexpo/modules/kotlin/jni/JNIDeallocator;", "getDeallocator$expo_modules_core_release", "()Lexpo/modules/kotlin/jni/JNIDeallocator;", "eval", "Lexpo/modules/kotlin/jni/JavaScriptValue;", "source", "", "schedule", "", "block", "Lkotlin/Function0;", "install", "runtimePointer", "", "install$expo_modules_core_release", "deallocate", "deallocate$expo_modules_core_release", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class WorkletRuntime extends Runtime {
    public static final int $stable = 8;
    private final WeakReference<AppContext> appContextHolder;
    private final ClassRegistry classRegistry;
    private final JNIDeallocator deallocator;
    public JSIContext jsiContext;
    private WorkletNativeRuntime mWorkletNativeRuntime;
    private final WeakReference<ReactApplicationContext> reactContextHolder;
    private final SharedObjectRegistry sharedObjectRegistry;

    public WorkletRuntime(AppContext appContext, WeakReference<ReactApplicationContext> reactContextHolder) {
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(reactContextHolder, "reactContextHolder");
        this.reactContextHolder = reactContextHolder;
        this.appContextHolder = UtilsKt.weak(appContext);
        this.sharedObjectRegistry = new SharedObjectRegistry(this);
        this.classRegistry = new ClassRegistry();
        this.deallocator = new JNIDeallocator(false, 1, null);
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

    /* JADX INFO: renamed from: getMWorkletNativeRuntime$expo_modules_core_release, reason: from getter */
    public final WorkletNativeRuntime getMWorkletNativeRuntime() {
        return this.mWorkletNativeRuntime;
    }

    public final void setMWorkletNativeRuntime$expo_modules_core_release(WorkletNativeRuntime workletNativeRuntime) {
        this.mWorkletNativeRuntime = workletNativeRuntime;
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

    private final boolean isJSIContextInitialized() {
        return this.jsiContext != null;
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
    /* JADX INFO: renamed from: getDeallocator$expo_modules_core_release, reason: from getter */
    public JNIDeallocator getDeallocator() {
        return this.deallocator;
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
            reactContext.runOnJSQueueThread(new Runnable() { // from class: expo.modules.kotlin.runtime.WorkletRuntime$$ExternalSyntheticLambda0
                @Override // java.lang.Runnable
                public final void run() {
                    block.invoke();
                }
            });
        }
    }

    public final void install$expo_modules_core_release(long runtimePointer) {
        synchronized (this) {
            if (isJSIContextInitialized()) {
                Logger.warn$default(CoreLoggerKt.getLogger(), "⚠️ JSI interop was already installed", null, 2, null);
                return;
            }
            Trace.beginSection("[ExpoModulesCore] " + (this + ".install on runtime " + runtimePointer));
            try {
                setMWorkletNativeRuntime$expo_modules_core_release(new WorkletNativeRuntime(runtimePointer));
                setJsiContext(new WorkletRuntimeInstaller(this).install(runtimePointer));
                CoreLoggerKt.getLogger().info("✅ JSI interop was installed");
                Unit unit = Unit.INSTANCE;
                Trace.endSection();
                Unit unit2 = Unit.INSTANCE;
            } catch (Throwable th) {
                Trace.endSection();
                throw th;
            }
        }
    }

    @Override // expo.modules.kotlin.runtime.Runtime
    public void deallocate$expo_modules_core_release() {
        getDeallocator().deallocate$expo_modules_core_release();
    }
}

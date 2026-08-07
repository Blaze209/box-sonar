package expo.modules.kotlin.jni;

import com.facebook.react.bridge.RuntimeExecutor;
import com.facebook.react.turbomodule.core.CallInvokerHolderImpl;
import com.facebook.soloader.SoLoader;
import expo.modules.kotlin.UtilsKt;
import expo.modules.kotlin.runtime.MainRuntime;
import java.lang.ref.WeakReference;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: MainRuntimeInstaller.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u00162\u00020\u0001:\u0001\u0016B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rJ\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u0010\u0010\u001a\u00020\u0011H\u0007J/\u0010\b\u001a\u00020\t2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u00132\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\f\u001a\u00020\rH\u0082 J/\u0010\b\u001a\u00020\t2\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u00132\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u000e\u001a\u00020\u000fH\u0082 R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0017"}, d2 = {"Lexpo/modules/kotlin/jni/MainRuntimeInstaller;", "", "runtimeContext", "Lexpo/modules/kotlin/runtime/MainRuntime;", "<init>", "(Lexpo/modules/kotlin/runtime/MainRuntime;)V", "getRuntimeContext", "()Lexpo/modules/kotlin/runtime/MainRuntime;", "install", "Lexpo/modules/kotlin/jni/JSIContext;", "jsRuntimePointer", "", "jsInvokerHolder", "Lcom/facebook/react/turbomodule/core/CallInvokerHolderImpl;", "runtimeExecutor", "Lcom/facebook/react/bridge/RuntimeExecutor;", "getCoreModuleObject", "Lexpo/modules/kotlin/jni/JavaScriptModuleObject;", "runtimeContextHolder", "Ljava/lang/ref/WeakReference;", "jniDeallocator", "Lexpo/modules/kotlin/jni/JNIDeallocator;", "Companion", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MainRuntimeInstaller {
    private final MainRuntime runtimeContext;
    public static final int $stable = 8;

    private final native JSIContext install(WeakReference<Object> runtimeContextHolder, long jsRuntimePointer, JNIDeallocator jniDeallocator, RuntimeExecutor runtimeExecutor);

    private final native JSIContext install(WeakReference<Object> runtimeContextHolder, long jsRuntimePointer, JNIDeallocator jniDeallocator, CallInvokerHolderImpl jsInvokerHolder);

    public MainRuntimeInstaller(MainRuntime runtimeContext) {
        Intrinsics.checkNotNullParameter(runtimeContext, "runtimeContext");
        this.runtimeContext = runtimeContext;
    }

    public final MainRuntime getRuntimeContext() {
        return this.runtimeContext;
    }

    public final JSIContext install(long jsRuntimePointer, CallInvokerHolderImpl jsInvokerHolder) {
        Intrinsics.checkNotNullParameter(jsInvokerHolder, "jsInvokerHolder");
        return install(UtilsKt.weak(this.runtimeContext), jsRuntimePointer, this.runtimeContext.getDeallocator(), jsInvokerHolder);
    }

    public final JSIContext install(long jsRuntimePointer, RuntimeExecutor runtimeExecutor) {
        Intrinsics.checkNotNullParameter(runtimeExecutor, "runtimeExecutor");
        return install(UtilsKt.weak(this.runtimeContext), jsRuntimePointer, this.runtimeContext.getDeallocator(), runtimeExecutor);
    }

    public final JavaScriptModuleObject getCoreModuleObject() {
        return this.runtimeContext.getCoreModule$expo_modules_core_release().getJsObject();
    }

    static {
        SoLoader.loadLibrary("expo-modules-core");
    }
}

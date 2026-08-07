package expo.modules.kotlin.runtime;

import com.facebook.react.bridge.ReactApplicationContext;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.jni.JNIDeallocator;
import expo.modules.kotlin.jni.JSIContext;
import expo.modules.kotlin.jni.JavaScriptValue;
import expo.modules.kotlin.sharedobjects.ClassRegistry;
import expo.modules.kotlin.sharedobjects.SharedObjectRegistry;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: compiled from: Runtime.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020 H&J\u0016\u0010!\u001a\u00020\"2\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\"0$H&J\r\u0010%\u001a\u00020\"H ¢\u0006\u0002\b&R\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u0005X¦\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u0004\u0018\u00010\tX¦\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0012\u0010\f\u001a\u00020\rX¦\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u00118 X¡\u0004¢\u0006\f\u0012\u0004\b\u0012\u0010\u0003\u001a\u0004\b\u0013\u0010\u0014R\u0012\u0010\u0015\u001a\u00020\u0016X \u0004¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u0012\u0010\u0019\u001a\u00020\u001aX \u0004¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u001c¨\u0006'"}, d2 = {"Lexpo/modules/kotlin/runtime/Runtime;", "", "<init>", "()V", "appContext", "Lexpo/modules/kotlin/AppContext;", "getAppContext", "()Lexpo/modules/kotlin/AppContext;", "reactContext", "Lcom/facebook/react/bridge/ReactApplicationContext;", "getReactContext", "()Lcom/facebook/react/bridge/ReactApplicationContext;", "jsiContext", "Lexpo/modules/kotlin/jni/JSIContext;", "getJsiContext", "()Lexpo/modules/kotlin/jni/JSIContext;", "deallocator", "Lexpo/modules/kotlin/jni/JNIDeallocator;", "getDeallocator$annotations", "getDeallocator", "()Lexpo/modules/kotlin/jni/JNIDeallocator;", "sharedObjectRegistry", "Lexpo/modules/kotlin/sharedobjects/SharedObjectRegistry;", "getSharedObjectRegistry$expo_modules_core_release", "()Lexpo/modules/kotlin/sharedobjects/SharedObjectRegistry;", "classRegistry", "Lexpo/modules/kotlin/sharedobjects/ClassRegistry;", "getClassRegistry$expo_modules_core_release", "()Lexpo/modules/kotlin/sharedobjects/ClassRegistry;", "eval", "Lexpo/modules/kotlin/jni/JavaScriptValue;", "source", "", "schedule", "", "block", "Lkotlin/Function0;", "deallocate", "deallocate$expo_modules_core_release", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class Runtime {
    public static final int $stable = 0;

    public static /* synthetic */ void getDeallocator$annotations() {
    }

    public abstract void deallocate$expo_modules_core_release();

    public abstract JavaScriptValue eval(String source);

    public abstract AppContext getAppContext();

    /* JADX INFO: renamed from: getClassRegistry$expo_modules_core_release */
    public abstract ClassRegistry getClassRegistry();

    public abstract JNIDeallocator getDeallocator();

    public abstract JSIContext getJsiContext();

    public abstract ReactApplicationContext getReactContext();

    /* JADX INFO: renamed from: getSharedObjectRegistry$expo_modules_core_release */
    public abstract SharedObjectRegistry getSharedObjectRegistry();

    public abstract void schedule(Function0<Unit> block);
}

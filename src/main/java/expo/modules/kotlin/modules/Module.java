package expo.modules.kotlin.modules;

import android.os.Bundle;
import androidx.exifinterface.media.ExifInterface;
import com.box.androidsdk.content.models.BoxClassification;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.EnumExtensionsKt;
import expo.modules.kotlin.ModuleRegistry;
import expo.modules.kotlin.events.EventEmitter;
import expo.modules.kotlin.providers.AppContextProvider;
import expo.modules.kotlin.runtime.MainRuntime;
import expo.modules.kotlin.runtime.Runtime;
import expo.modules.kotlin.types.TypeConverterProvider;
import java.lang.ref.WeakReference;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: Module.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b'\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u001a\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\n\b\u0002\u0010,\u001a\u0004\u0018\u00010-J$\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020+2\u0014\u0010,\u001a\u0010\u0012\u0004\u0012\u00020+\u0012\u0006\u0012\u0004\u0018\u00010/0.J3\u0010(\u001a\u00020)\"\u0012\b\u0000\u00100*\u000201*\b\u0012\u0004\u0012\u0002H0022\u0006\u00103\u001a\u0002H02\n\b\u0002\u0010,\u001a\u0004\u0018\u00010-¢\u0006\u0002\u00104JA\u0010(\u001a\u00020)\"\u0012\b\u0000\u00100*\u000201*\b\u0012\u0004\u0012\u0002H0022\u0006\u00103\u001a\u0002H02\u0018\b\u0002\u0010,\u001a\u0012\u0012\u0004\u0012\u00020+\u0012\u0006\u0012\u0004\u0018\u00010/\u0018\u00010.¢\u0006\u0002\u00105J\n\u00106\u001a\u0004\u0018\u000107H\u0016J\b\u00108\u001a\u000209H&R&\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0080\u000e¢\u0006\u0014\n\u0000\u0012\u0004\b\u0007\u0010\u0003\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\r8F¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\r8FX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0011\u0010\u0003\u001a\u0004\b\u0012\u0010\u000fR\u0014\u0010\u0013\u001a\u00020\u00068VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0015R\u001d\u0010\u0016\u001a\u0004\u0018\u00010\u00178BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001a\u0010\u001b\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u001c\u001a\u00020\u001d8F¢\u0006\u0006\u001a\u0004\b\u001e\u0010\u001fR*\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!8\u0000@\u0000X\u0081.¢\u0006\u0014\n\u0000\u0012\u0004\b#\u0010\u0003\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'¨\u0006:"}, d2 = {"Lexpo/modules/kotlin/modules/Module;", "Lexpo/modules/kotlin/providers/AppContextProvider;", "<init>", "()V", "_appContextHolder", "Ljava/lang/ref/WeakReference;", "Lexpo/modules/kotlin/AppContext;", "get_appContextHolder$expo_modules_core_release$annotations", "get_appContextHolder$expo_modules_core_release", "()Ljava/lang/ref/WeakReference;", "set_appContextHolder$expo_modules_core_release", "(Ljava/lang/ref/WeakReference;)V", "runtime", "Lexpo/modules/kotlin/runtime/Runtime;", "getRuntime", "()Lexpo/modules/kotlin/runtime/Runtime;", "runtimeContext", "getRuntimeContext$annotations", "getRuntimeContext", "appContext", "getAppContext", "()Lexpo/modules/kotlin/AppContext;", "moduleEventEmitter", "Lexpo/modules/kotlin/events/EventEmitter;", "getModuleEventEmitter", "()Lexpo/modules/kotlin/events/EventEmitter;", "moduleEventEmitter$delegate", "Lkotlin/Lazy;", "registry", "Lexpo/modules/kotlin/ModuleRegistry;", "getRegistry", "()Lexpo/modules/kotlin/ModuleRegistry;", "coroutineScopeDelegate", "Lkotlin/Lazy;", "Lkotlinx/coroutines/CoroutineScope;", "getCoroutineScopeDelegate$annotations", "getCoroutineScopeDelegate", "()Lkotlin/Lazy;", "setCoroutineScopeDelegate", "(Lkotlin/Lazy;)V", "sendEvent", "", "name", "", "body", "Landroid/os/Bundle;", "", "", ExifInterface.GPS_DIRECTION_TRUE, "Lexpo/modules/kotlin/types/Enumerable;", "", "enum", "(Ljava/lang/Enum;Landroid/os/Bundle;)V", "(Ljava/lang/Enum;Ljava/util/Map;)V", "converters", "Lexpo/modules/kotlin/types/TypeConverterProvider;", BoxClassification.FIELD_DEFINITION, "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public abstract class Module implements AppContextProvider {
    public static final int $stable = 8;
    public Lazy<? extends CoroutineScope> coroutineScopeDelegate;
    private WeakReference<AppContext> _appContextHolder = new WeakReference<>(null);

    /* JADX INFO: renamed from: moduleEventEmitter$delegate, reason: from kotlin metadata */
    private final Lazy moduleEventEmitter = LazyKt.lazy(new Function0() { // from class: expo.modules.kotlin.modules.Module$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return Module.moduleEventEmitter_delegate$lambda$2(this.f$0);
        }
    });

    public static /* synthetic */ void getCoroutineScopeDelegate$annotations() {
    }

    @Deprecated(message = "Use 'runtime' property instead.", replaceWith = @ReplaceWith(expression = "runtime", imports = {}))
    public static /* synthetic */ void getRuntimeContext$annotations() {
    }

    public static /* synthetic */ void get_appContextHolder$expo_modules_core_release$annotations() {
    }

    public TypeConverterProvider converters() {
        return null;
    }

    public abstract ModuleDefinitionData definition();

    public final WeakReference<AppContext> get_appContextHolder$expo_modules_core_release() {
        return this._appContextHolder;
    }

    public final void set_appContextHolder$expo_modules_core_release(WeakReference<AppContext> weakReference) {
        Intrinsics.checkNotNullParameter(weakReference, "<set-?>");
        this._appContextHolder = weakReference;
    }

    public final Runtime getRuntime() {
        AppContext appContext = this._appContextHolder.get();
        MainRuntime runtime = appContext != null ? appContext.getRuntime() : null;
        if (runtime != null) {
            return runtime;
        }
        throw new IllegalArgumentException("The module wasn't created! You can't access the hosting runtime.".toString());
    }

    public final Runtime getRuntimeContext() {
        return getRuntime();
    }

    @Override // expo.modules.kotlin.providers.AppContextProvider
    public AppContext getAppContext() {
        AppContext appContext = this._appContextHolder.get();
        if (appContext != null) {
            return appContext;
        }
        throw new IllegalArgumentException("You attempted to access the app context before the module was created. Defer accessing the context until after the module initializes.".toString());
    }

    private final EventEmitter getModuleEventEmitter() {
        return (EventEmitter) this.moduleEventEmitter.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final EventEmitter moduleEventEmitter_delegate$lambda$2(Module module) {
        return module.getAppContext().eventEmitter(module);
    }

    public final ModuleRegistry getRegistry() {
        return getAppContext().getRegistry();
    }

    public final Lazy<CoroutineScope> getCoroutineScopeDelegate() {
        Lazy lazy = this.coroutineScopeDelegate;
        if (lazy != null) {
            return lazy;
        }
        Intrinsics.throwUninitializedPropertyAccessException("coroutineScopeDelegate");
        return null;
    }

    public final void setCoroutineScopeDelegate(Lazy<? extends CoroutineScope> lazy) {
        Intrinsics.checkNotNullParameter(lazy, "<set-?>");
        this.coroutineScopeDelegate = lazy;
    }

    public static /* synthetic */ void sendEvent$default(Module module, String str, Bundle bundle, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendEvent");
        }
        if ((i & 2) != 0) {
            bundle = Bundle.EMPTY;
        }
        module.sendEvent(str, bundle);
    }

    public final void sendEvent(String name, Bundle body) {
        Intrinsics.checkNotNullParameter(name, "name");
        EventEmitter moduleEventEmitter = getModuleEventEmitter();
        if (moduleEventEmitter != null) {
            moduleEventEmitter.emit(name, body);
        }
    }

    public final void sendEvent(String name, Map<String, ? extends Object> body) {
        Intrinsics.checkNotNullParameter(name, "name");
        Intrinsics.checkNotNullParameter(body, "body");
        EventEmitter moduleEventEmitter = getModuleEventEmitter();
        if (moduleEventEmitter != null) {
            moduleEventEmitter.emit(name, body);
        }
    }

    public static /* synthetic */ void sendEvent$default(Module module, Enum r1, Bundle bundle, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendEvent");
        }
        if ((i & 2) != 0) {
            bundle = Bundle.EMPTY;
        }
        module.sendEvent(r1, bundle);
    }

    /* JADX WARN: Incorrect types in method signature: <T:Ljava/lang/Enum<TT;>;:Lexpo/modules/kotlin/types/Enumerable;>(TT;Landroid/os/Bundle;)V */
    public final void sendEvent(Enum r2, Bundle body) {
        Intrinsics.checkNotNullParameter(r2, "enum");
        EventEmitter moduleEventEmitter = getModuleEventEmitter();
        if (moduleEventEmitter != null) {
            moduleEventEmitter.emit(EnumExtensionsKt.convertToString(r2), body);
        }
    }

    public static /* synthetic */ void sendEvent$default(Module module, Enum r1, Map map, int i, Object obj) {
        if (obj != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: sendEvent");
        }
        if ((i & 2) != 0) {
            map = null;
        }
        module.sendEvent(r1, map);
    }

    /* JADX WARN: Incorrect types in method signature: <T:Ljava/lang/Enum<TT;>;:Lexpo/modules/kotlin/types/Enumerable;>(TT;Ljava/util/Map<Ljava/lang/String;+Ljava/lang/Object;>;)V */
    public final void sendEvent(Enum r2, Map body) {
        Intrinsics.checkNotNullParameter(r2, "enum");
        EventEmitter moduleEventEmitter = getModuleEventEmitter();
        if (moduleEventEmitter != null) {
            moduleEventEmitter.emit(EnumExtensionsKt.convertToString(r2), (Map<?, ?>) body);
        }
    }
}

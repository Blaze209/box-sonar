package expo.modules.kotlin;

import androidx.core.app.NotificationCompat;
import androidx.exifinterface.media.ExifInterface;
import androidx.tracing.Trace;
import com.box.androidsdk.content.models.BoxClassification;
import com.facebook.react.bridge.BaseJavaModule;
import expo.modules.kotlin.activityresult.AppContextActivityResultCaller;
import expo.modules.kotlin.events.BasicEventListener;
import expo.modules.kotlin.events.EventListener;
import expo.modules.kotlin.events.EventListenerWithPayload;
import expo.modules.kotlin.events.EventListenerWithSenderAndPayload;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.exception.CodedException;
import expo.modules.kotlin.exception.FunctionCallException;
import expo.modules.kotlin.exception.MethodNotFoundException;
import expo.modules.kotlin.exception.UnexpectedException;
import expo.modules.kotlin.functions.AsyncFunctionComponent;
import expo.modules.kotlin.functions.BaseAsyncFunctionComponent;
import expo.modules.kotlin.functions.SyncFunctionComponent;
import expo.modules.kotlin.jni.JNIDeallocator;
import expo.modules.kotlin.jni.JavaScriptModuleObject;
import expo.modules.kotlin.jni.decorators.JSDecoratorsBridgingObject;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.objects.ObjectDefinitionData;
import expo.modules.kotlin.runtime.Runtime;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;

/* JADX INFO: compiled from: ModuleHolder.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0011\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000*\b\b\u0000\u0010\u0001*\u00020\u00022\u00020\u0003B\u0019\u0012\u0006\u0010\u0004\u001a\u00028\u0000\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u001c\u0010\u001d\u001a\u00020\u001e*\u00020\u001f2\u0006\u0010 \u001a\u00020!2\u0006\u0010\"\u001a\u00020#H\u0002J+\u0010$\u001a\u00020\u001e2\u0006\u0010%\u001a\u00020\u00062\u000e\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030'2\u0006\u0010(\u001a\u00020)¢\u0006\u0002\u0010*J%\u0010+\u001a\u0004\u0018\u00010\u00032\u0006\u0010%\u001a\u00020\u00062\u000e\u0010&\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00030'¢\u0006\u0002\u0010,J\u000e\u0010-\u001a\u00020\u001e2\u0006\u0010.\u001a\u00020/J!\u0010-\u001a\u00020\u001e\"\u0004\b\u0001\u001002\u0006\u0010.\u001a\u00020/2\u0006\u00101\u001a\u0002H0¢\u0006\u0002\u00102J/\u0010-\u001a\u00020\u001e\"\u0004\b\u0001\u00103\"\u0004\b\u0002\u001002\u0006\u0010.\u001a\u00020/2\u0006\u00104\u001a\u0002H32\u0006\u00101\u001a\u0002H0¢\u0006\u0002\u00105J\u0006\u00106\u001a\u00020\u001eR\u0013\u0010\u0004\u001a\u00028\u0000¢\u0006\n\n\u0002\u0010\u000b\u001a\u0004\b\t\u0010\nR\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u0082\u0004¢\u0006\u0002\n\u0000R\u0011\u0010\f\u001a\u00020\r¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0010\u001a\u00020\u00068F¢\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0013\u001a\u00020\u0014X\u0082\u000e¢\u0006\u0002\n\u0000R\u0013\u0010\u0015\u001a\u0004\u0018\u00010\u00168F¢\u0006\u0006\u001a\u0004\b\u0017\u0010\u0018R\u001b\u0010\u0019\u001a\u00020\u00168FX\u0086\u0084\u0002¢\u0006\f\n\u0004\b\u001b\u0010\u001c\u001a\u0004\b\u001a\u0010\u0018¨\u00067"}, d2 = {"Lexpo/modules/kotlin/ModuleHolder;", ExifInterface.GPS_DIRECTION_TRUE, "Lexpo/modules/kotlin/modules/Module;", "", "module", "_name", "", "<init>", "(Lexpo/modules/kotlin/modules/Module;Ljava/lang/String;)V", "getModule", "()Lexpo/modules/kotlin/modules/Module;", "Lexpo/modules/kotlin/modules/Module;", BoxClassification.FIELD_DEFINITION, "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "getDefinition", "()Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "name", "getName", "()Ljava/lang/String;", "wasInitialized", "", "safeJSObject", "Lexpo/modules/kotlin/jni/JavaScriptModuleObject;", "getSafeJSObject", "()Lexpo/modules/kotlin/jni/JavaScriptModuleObject;", "jsObject", "getJsObject", "jsObject$delegate", "Lkotlin/Lazy;", "export", "", "Lexpo/modules/kotlin/jni/decorators/JSDecoratorsBridgingObject;", "appContext", "Lexpo/modules/kotlin/AppContext;", "runtime", "Lexpo/modules/kotlin/runtime/Runtime;", NotificationCompat.CATEGORY_CALL, "methodName", "args", "", BaseJavaModule.METHOD_TYPE_PROMISE, "Lexpo/modules/kotlin/Promise;", "(Ljava/lang/String;[Ljava/lang/Object;Lexpo/modules/kotlin/Promise;)V", "callSync", "(Ljava/lang/String;[Ljava/lang/Object;)Ljava/lang/Object;", "post", "eventName", "Lexpo/modules/kotlin/events/EventName;", "Payload", "payload", "(Lexpo/modules/kotlin/events/EventName;Ljava/lang/Object;)V", "Sender", "sender", "(Lexpo/modules/kotlin/events/EventName;Ljava/lang/Object;Ljava/lang/Object;)V", "registerContracts", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ModuleHolder<T extends Module> {
    public static final int $stable = 8;
    private final String _name;
    private final ModuleDefinitionData definition;

    /* JADX INFO: renamed from: jsObject$delegate, reason: from kotlin metadata */
    private final Lazy jsObject;
    private final T module;
    private boolean wasInitialized;

    public ModuleHolder(T module, String str) {
        Intrinsics.checkNotNullParameter(module, "module");
        this.module = module;
        this._name = str;
        this.definition = module.definition();
        this.jsObject = LazyKt.lazy(new Function0() { // from class: expo.modules.kotlin.ModuleHolder$$ExternalSyntheticLambda0
            @Override // kotlin.jvm.functions.Function0
            public final Object invoke() {
                return ModuleHolder.jsObject_delegate$lambda$3(this.f$0);
            }
        });
    }

    public final T getModule() {
        return this.module;
    }

    public final ModuleDefinitionData getDefinition() {
        return this.definition;
    }

    public final String getName() {
        String str = this._name;
        return str == null ? this.definition.getName() : str;
    }

    public final JavaScriptModuleObject getSafeJSObject() {
        if (this.wasInitialized) {
            return getJsObject();
        }
        return null;
    }

    public final JavaScriptModuleObject getJsObject() {
        return (JavaScriptModuleObject) this.jsObject.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final JavaScriptModuleObject jsObject_delegate$lambda$3(ModuleHolder moduleHolder) {
        moduleHolder.wasInitialized = true;
        Trace.beginSection("[ExpoModulesCore] " + (moduleHolder.getName() + ".jsObject"));
        try {
            AppContext appContext = moduleHolder.getModule().getAppContext();
            Runtime runtime = moduleHolder.getModule().getRuntime();
            JNIDeallocator deallocator = runtime.getDeallocator();
            JSDecoratorsBridgingObject jSDecoratorsBridgingObject = new JSDecoratorsBridgingObject(deallocator);
            moduleHolder.export(jSDecoratorsBridgingObject, appContext, runtime);
            JavaScriptModuleObject javaScriptModuleObject = new JavaScriptModuleObject(deallocator, moduleHolder.getName());
            javaScriptModuleObject.decorate(jSDecoratorsBridgingObject);
            return javaScriptModuleObject;
        } finally {
            Trace.endSection();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void export(JSDecoratorsBridgingObject jSDecoratorsBridgingObject, AppContext appContext, Runtime runtime) {
        jSDecoratorsBridgingObject.registerModuleName(getName());
        ModuleDefinitionData moduleDefinitionData = this.definition;
        ObjectDefinitionData objectDefinition = moduleDefinitionData.getObjectDefinition();
        jSDecoratorsBridgingObject.exportConstants(objectDefinition);
        jSDecoratorsBridgingObject.exportFunctions(objectDefinition, moduleDefinitionData.getName(), appContext);
        jSDecoratorsBridgingObject.exportProperties(objectDefinition, appContext);
        jSDecoratorsBridgingObject.exportViewPrototypes(moduleDefinitionData.getViewManagerDefinitions(), moduleDefinitionData.getName(), appContext, runtime);
        jSDecoratorsBridgingObject.exportClasses(moduleDefinitionData.getClassData(), appContext, runtime);
    }

    public final void call(String methodName, Object[] args, Promise promise) throws FunctionCallException {
        UnexpectedException unexpectedException;
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(args, "args");
        Intrinsics.checkNotNullParameter(promise, "promise");
        try {
            BaseAsyncFunctionComponent baseAsyncFunctionComponent = getDefinition().getAsyncFunctions().get(methodName);
            if (baseAsyncFunctionComponent == null) {
                throw new MethodNotFoundException();
            }
            if (!(baseAsyncFunctionComponent instanceof AsyncFunctionComponent)) {
                throw new IllegalStateException("Cannot call a " + baseAsyncFunctionComponent + " method in test context");
            }
            ((AsyncFunctionComponent) baseAsyncFunctionComponent).callUserImplementation$expo_modules_core_release(args, promise, getModule().getAppContext());
            Unit unit = Unit.INSTANCE;
        } catch (Throwable th) {
            if (th instanceof CodedException) {
                unexpectedException = (CodedException) th;
            } else if (th instanceof expo.modules.core.errors.CodedException) {
                expo.modules.core.errors.CodedException codedException = (expo.modules.core.errors.CodedException) th;
                String code = codedException.getCode();
                Intrinsics.checkNotNullExpressionValue(code, "getCode(...)");
                unexpectedException = new CodedException(code, codedException.getMessage(), codedException.getCause());
            } else {
                unexpectedException = new UnexpectedException(th);
            }
            throw new FunctionCallException(methodName, getName(), unexpectedException);
        }
    }

    public final Object callSync(String methodName, Object[] args) throws MethodNotFoundException {
        Intrinsics.checkNotNullParameter(methodName, "methodName");
        Intrinsics.checkNotNullParameter(args, "args");
        SyncFunctionComponent syncFunctionComponent = this.definition.getSyncFunctions().get(methodName);
        if (syncFunctionComponent == null) {
            throw new MethodNotFoundException();
        }
        return SyncFunctionComponent.callUserImplementation$default(syncFunctionComponent, args, null, 2, null);
    }

    public final void post(EventName eventName) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        EventListener eventListener = this.definition.getEventListeners().get(eventName);
        if (eventListener == null) {
            return;
        }
        BasicEventListener basicEventListener = eventListener instanceof BasicEventListener ? (BasicEventListener) eventListener : null;
        if (basicEventListener != null) {
            basicEventListener.call();
        }
    }

    public final <Payload> void post(EventName eventName, Payload payload) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        EventListener eventListener = this.definition.getEventListeners().get(eventName);
        if (eventListener == null) {
            return;
        }
        EventListenerWithPayload eventListenerWithPayload = eventListener instanceof EventListenerWithPayload ? (EventListenerWithPayload) eventListener : null;
        if (eventListenerWithPayload != null) {
            eventListenerWithPayload.call(payload);
        }
    }

    public final <Sender, Payload> void post(EventName eventName, Sender sender, Payload payload) {
        Intrinsics.checkNotNullParameter(eventName, "eventName");
        EventListener eventListener = this.definition.getEventListeners().get(eventName);
        if (eventListener == null) {
            return;
        }
        EventListenerWithSenderAndPayload eventListenerWithSenderAndPayload = eventListener instanceof EventListenerWithSenderAndPayload ? (EventListenerWithSenderAndPayload) eventListener : null;
        if (eventListenerWithSenderAndPayload != null) {
            eventListenerWithSenderAndPayload.call(sender, payload);
        }
    }

    public final void registerContracts() {
        Function2<AppContextActivityResultCaller, Continuation<? super Unit>, Object> registerContracts = this.definition.getRegisterContracts();
        if (registerContracts != null) {
            BuildersKt__Builders_commonKt.launch$default(this.module.getAppContext().getMainQueue(), null, null, new ModuleHolder$registerContracts$1$1(registerContracts, this, null), 3, null);
        }
    }
}

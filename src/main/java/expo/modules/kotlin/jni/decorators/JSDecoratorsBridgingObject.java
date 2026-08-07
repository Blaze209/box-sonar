package expo.modules.kotlin.jni.decorators;

import androidx.tracing.Trace;
import com.facebook.jni.HybridData;
import com.facebook.react.bridge.Arguments;
import com.facebook.react.bridge.NativeMap;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.ConcatIterator;
import expo.modules.kotlin.classcomponent.ClassDefinitionData;
import expo.modules.kotlin.functions.AnyFunction;
import expo.modules.kotlin.functions.BaseAsyncFunctionComponent;
import expo.modules.kotlin.functions.SyncFunctionComponent;
import expo.modules.kotlin.jni.Destructible;
import expo.modules.kotlin.jni.ExpectedType;
import expo.modules.kotlin.jni.JNIAsyncFunctionBody;
import expo.modules.kotlin.jni.JNIDeallocator;
import expo.modules.kotlin.jni.JNIFunctionBody;
import expo.modules.kotlin.jni.JNINoArgsFunctionBody;
import expo.modules.kotlin.modules.ModuleDefinitionBuilderKt;
import expo.modules.kotlin.objects.ConstantComponent;
import expo.modules.kotlin.objects.ObjectDefinitionData;
import expo.modules.kotlin.objects.PropertyComponent;
import expo.modules.kotlin.runtime.Runtime;
import expo.modules.kotlin.views.ViewManagerDefinition;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmClassMappingKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.reflect.KClass;
import kotlin.reflect.KClassifier;
import kotlin.reflect.KType;

/* JADX INFO: compiled from: JSDecoratorsBridgingObject.kt */
/* JADX INFO: loaded from: classes14.dex */
@Metadata(d1 = {"\u0000\u0094\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010$\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0007\u0018\u00002\u00020\u0001B\u000f\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\t\u0010\b\u001a\u00020\u0007H\u0082 J\u0011\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fH\u0086 JD\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u0019H\u0086 ¢\u0006\u0002\u0010\u001aJ<\u0010\u001b\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0018\u001a\u00020\u001cH\u0086 ¢\u0006\u0002\u0010\u001dJV\u0010\u001e\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u001f\u001a\u00020\u00112\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\b\u0010!\u001a\u0004\u0018\u00010\u00192\u0006\u0010\"\u001a\u00020\u00112\f\u0010#\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\b\u0010$\u001a\u0004\u0018\u00010\u0019H\u0086 ¢\u0006\u0002\u0010%J\u001b\u0010&\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\b\u0010!\u001a\u0004\u0018\u00010'H\u0086 J\u0019\u0010(\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010)\u001a\u00020\u0000H\u0086 JZ\u0010*\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010+\u001a\u00020\u00002\u0006\u0010,\u001a\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\f\u0010-\u001a\b\u0012\u0002\b\u0003\u0018\u00010.2\u0006\u0010/\u001a\u00020\u00112\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0018\u001a\u00020\u0019H\u0086 ¢\u0006\u0002\u00100J\u000e\u00101\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fJ\b\u00102\u001a\u00020\nH\u0004J\b\u00103\u001a\u00020\u0007H\u0016J\n\u00104\u001a\u00020\n*\u000205J\u001a\u00106\u001a\u00020\n*\u0002052\u0006\u00107\u001a\u00020\u000f2\u0006\u00108\u001a\u000209J\u0012\u0010:\u001a\u00020\n*\u0002052\u0006\u00108\u001a\u000209J \u0010;\u001a\u00020\n*\b\u0012\u0004\u0012\u00020=0<2\u0006\u00108\u001a\u0002092\u0006\u0010>\u001a\u00020?J\u001a\u0010@\u001a\u00020\n*\u00020=2\u0006\u00108\u001a\u0002092\u0006\u0010>\u001a\u00020?J\u001a\u0010A\u001a\u00020\n*\u00020=2\u0006\u00107\u001a\u00020\u000f2\u0006\u00108\u001a\u000209J.\u0010B\u001a\u00020\n*\u000e\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020D0C2\u0006\u0010E\u001a\u00020\u000f2\u0006\u00108\u001a\u0002092\u0006\u0010>\u001a\u00020?J*\u0010F\u001a\u00020\n*\u00020D2\u0006\u0010G\u001a\u00020\u000f2\u0006\u0010H\u001a\u00020\u000f2\u0006\u00108\u001a\u0002092\u0006\u0010>\u001a\u00020?R\u0010\u0010\u0006\u001a\u00020\u00078\u0002X\u0083\u0004¢\u0006\u0002\n\u0000¨\u0006I"}, d2 = {"Lexpo/modules/kotlin/jni/decorators/JSDecoratorsBridgingObject;", "Lexpo/modules/kotlin/jni/Destructible;", "jniDeallocator", "Lexpo/modules/kotlin/jni/JNIDeallocator;", "<init>", "(Lexpo/modules/kotlin/jni/JNIDeallocator;)V", "mHybridData", "Lcom/facebook/jni/HybridData;", "initHybrid", "registerConstants", "", "constants", "Lcom/facebook/react/bridge/NativeMap;", "registerSyncFunction", "name", "", "takesOwner", "", "enumerable", "desiredTypes", "", "Lexpo/modules/kotlin/jni/ExpectedType;", "cppReturnType", "", "body", "Lexpo/modules/kotlin/jni/JNIFunctionBody;", "(Ljava/lang/String;ZZ[Lexpo/modules/kotlin/jni/ExpectedType;ILexpo/modules/kotlin/jni/JNIFunctionBody;)V", "registerAsyncFunction", "Lexpo/modules/kotlin/jni/JNIAsyncFunctionBody;", "(Ljava/lang/String;ZZ[Lexpo/modules/kotlin/jni/ExpectedType;Lexpo/modules/kotlin/jni/JNIAsyncFunctionBody;)V", "registerProperty", "getterTakesOwner", "getterExpectedType", "getter", "setterTakesOwner", "setterExpectedType", "setter", "(Ljava/lang/String;Z[Lexpo/modules/kotlin/jni/ExpectedType;Lexpo/modules/kotlin/jni/JNIFunctionBody;Z[Lexpo/modules/kotlin/jni/ExpectedType;Lexpo/modules/kotlin/jni/JNIFunctionBody;)V", "registerConstant", "Lexpo/modules/kotlin/jni/JNINoArgsFunctionBody;", "registerObject", "jsDecoratorsBridgingObject", "registerClass", "prototypeDecorator", "constructorDecorator", "ownerClass", "Ljava/lang/Class;", "isSharedRef", "(Ljava/lang/String;Lexpo/modules/kotlin/jni/decorators/JSDecoratorsBridgingObject;Lexpo/modules/kotlin/jni/decorators/JSDecoratorsBridgingObject;ZLjava/lang/Class;Z[Lexpo/modules/kotlin/jni/ExpectedType;Lexpo/modules/kotlin/jni/JNIFunctionBody;)V", "registerModuleName", "finalize", "getHybridDataForJNIDeallocator", "exportConstants", "Lexpo/modules/kotlin/objects/ObjectDefinitionData;", "exportFunctions", "objectName", "appContext", "Lexpo/modules/kotlin/AppContext;", "exportProperties", "exportClasses", "", "Lexpo/modules/kotlin/classcomponent/ClassDefinitionData;", "runtime", "Lexpo/modules/kotlin/runtime/Runtime;", "exportClass", "exportStaticFunctions", "exportViewPrototypes", "", "Lexpo/modules/kotlin/views/ViewManagerDefinition;", "modulesName", "exportViewPrototype", "moduleName", "viewKey", "expo-modules-core_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class JSDecoratorsBridgingObject implements Destructible {
    public static final int $stable = 8;
    private final HybridData mHybridData;

    private final native HybridData initHybrid();

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object registerModuleName$lambda$0(String str, Object[] it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return str;
    }

    public final native void registerAsyncFunction(String name, boolean takesOwner, boolean enumerable, ExpectedType[] desiredTypes, JNIAsyncFunctionBody body);

    public final native void registerClass(String name, JSDecoratorsBridgingObject prototypeDecorator, JSDecoratorsBridgingObject constructorDecorator, boolean takesOwner, Class<?> ownerClass, boolean isSharedRef, ExpectedType[] desiredTypes, JNIFunctionBody body);

    public final native void registerConstant(String name, JNINoArgsFunctionBody getter);

    public final native void registerConstants(NativeMap constants);

    public final native void registerObject(String name, JSDecoratorsBridgingObject jsDecoratorsBridgingObject);

    public final native void registerProperty(String name, boolean getterTakesOwner, ExpectedType[] getterExpectedType, JNIFunctionBody getter, boolean setterTakesOwner, ExpectedType[] setterExpectedType, JNIFunctionBody setter);

    public final native void registerSyncFunction(String name, boolean takesOwner, boolean enumerable, ExpectedType[] desiredTypes, int cppReturnType, JNIFunctionBody body);

    public JSDecoratorsBridgingObject(JNIDeallocator jniDeallocator) {
        Intrinsics.checkNotNullParameter(jniDeallocator, "jniDeallocator");
        this.mHybridData = initHybrid();
        jniDeallocator.addReference(this);
    }

    public final void registerModuleName(final String name) {
        Intrinsics.checkNotNullParameter(name, "name");
        registerProperty("__expo_module_name__", false, new ExpectedType[0], new JNIFunctionBody() { // from class: expo.modules.kotlin.jni.decorators.JSDecoratorsBridgingObject$$ExternalSyntheticLambda0
            @Override // expo.modules.kotlin.jni.JNIFunctionBody
            public final Object invoke(Object[] objArr) {
                return JSDecoratorsBridgingObject.registerModuleName$lambda$0(name, objArr);
            }
        }, false, new ExpectedType[0], null);
    }

    protected final void finalize() throws Throwable {
        this.mHybridData.resetNative();
    }

    @Override // expo.modules.kotlin.jni.Destructible
    /* JADX INFO: renamed from: getHybridDataForJNIDeallocator, reason: from getter */
    public HybridData getMHybridData() {
        return this.mHybridData;
    }

    public final void exportConstants(ObjectDefinitionData objectDefinitionData) {
        Intrinsics.checkNotNullParameter(objectDefinitionData, "<this>");
        Map<String, Object> mapInvoke = objectDefinitionData.getLegacyConstantsProvider().invoke();
        if (objectDefinitionData.getConstants().isEmpty() && mapInvoke.isEmpty()) {
            return;
        }
        Trace.beginSection("[ExpoModulesCore] Exporting constants");
        try {
            if (!mapInvoke.isEmpty()) {
                registerConstants(Arguments.makeNativeMap((Map<String, ? extends Object>) mapInvoke));
            }
            Iterator<Map.Entry<String, ConstantComponent>> it = objectDefinitionData.getConstants().entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().attachToJSObject(this);
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.endSection();
        }
    }

    public final void exportFunctions(ObjectDefinitionData objectDefinitionData, String objectName, AppContext appContext) {
        Intrinsics.checkNotNullParameter(objectDefinitionData, "<this>");
        Intrinsics.checkNotNullParameter(objectName, "objectName");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        ConcatIterator<AnyFunction> functions = objectDefinitionData.getFunctions();
        if (functions.hasNext()) {
            Trace.beginSection("[ExpoModulesCore] Attaching functions");
            try {
                ConcatIterator<AnyFunction> concatIterator = functions;
                while (concatIterator.hasNext()) {
                    concatIterator.next().attachToJSObject(appContext, this, objectName);
                }
                Unit unit = Unit.INSTANCE;
            } finally {
                Trace.endSection();
            }
        }
    }

    public final void exportProperties(ObjectDefinitionData objectDefinitionData, AppContext appContext) {
        Intrinsics.checkNotNullParameter(objectDefinitionData, "<this>");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        if (objectDefinitionData.getProperties().isEmpty()) {
            return;
        }
        Trace.beginSection("[ExpoModulesCore] Attaching properties");
        try {
            Iterator<Map.Entry<String, PropertyComponent>> it = objectDefinitionData.getProperties().entrySet().iterator();
            while (it.hasNext()) {
                it.next().getValue().attachToJSObject(appContext, this);
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.endSection();
        }
    }

    public final void exportClasses(List<ClassDefinitionData> list, AppContext appContext, Runtime runtime) {
        Intrinsics.checkNotNullParameter(list, "<this>");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        if (list.isEmpty()) {
            return;
        }
        Trace.beginSection("[ExpoModulesCore] Attaching classes");
        try {
            Iterator<T> it = list.iterator();
            while (it.hasNext()) {
                exportClass((ClassDefinitionData) it.next(), appContext, runtime);
            }
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.endSection();
        }
    }

    public final void exportClass(ClassDefinitionData classDefinitionData, AppContext appContext, Runtime runtime) {
        Intrinsics.checkNotNullParameter(classDefinitionData, "<this>");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        Trace.beginSection("[ExpoModulesCore] " + ("Attaching class " + classDefinitionData.getName()));
        try {
            JSDecoratorsBridgingObject jSDecoratorsBridgingObject = new JSDecoratorsBridgingObject(runtime.getDeallocator());
            JSDecoratorsBridgingObject jSDecoratorsBridgingObject2 = new JSDecoratorsBridgingObject(runtime.getDeallocator());
            jSDecoratorsBridgingObject.exportConstants(classDefinitionData.getObjectDefinition());
            jSDecoratorsBridgingObject.exportFunctions(classDefinitionData.getObjectDefinition(), classDefinitionData.getName(), appContext);
            jSDecoratorsBridgingObject.exportProperties(classDefinitionData.getObjectDefinition(), appContext);
            jSDecoratorsBridgingObject2.exportStaticFunctions(classDefinitionData, classDefinitionData.getName(), appContext);
            SyncFunctionComponent constructor = classDefinitionData.getConstructor();
            KType ownerType = constructor.getOwnerType();
            KClassifier classifier = ownerType != null ? ownerType.getClassifier() : null;
            KClass kClass = classifier instanceof KClass ? (KClass) classifier : null;
            registerClass(classDefinitionData.getName(), jSDecoratorsBridgingObject, jSDecoratorsBridgingObject2, constructor.getTakesOwner$expo_modules_core_release(), kClass != null ? JvmClassMappingKt.getJavaClass(kClass) : null, classDefinitionData.getIsSharedRef(), (ExpectedType[]) constructor.getCppRequiredTypes$expo_modules_core_release().toArray(new ExpectedType[0]), constructor.getJNIFunctionBody$expo_modules_core_release(classDefinitionData.getName(), appContext));
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.endSection();
        }
    }

    public final void exportStaticFunctions(ClassDefinitionData classDefinitionData, String objectName, AppContext appContext) {
        Intrinsics.checkNotNullParameter(classDefinitionData, "<this>");
        Intrinsics.checkNotNullParameter(objectName, "objectName");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        ConcatIterator<AnyFunction> staticFunctions = classDefinitionData.getStaticFunctions();
        if (staticFunctions.hasNext()) {
            Trace.beginSection("[ExpoModulesCore] Attaching static functions");
            try {
                ConcatIterator<AnyFunction> concatIterator = staticFunctions;
                while (concatIterator.hasNext()) {
                    concatIterator.next().attachToJSObject(appContext, this, objectName);
                }
                Unit unit = Unit.INSTANCE;
            } finally {
                Trace.endSection();
            }
        }
    }

    public final void exportViewPrototypes(Map<String, ViewManagerDefinition> map, String modulesName, AppContext appContext, Runtime runtime) {
        Intrinsics.checkNotNullParameter(map, "<this>");
        Intrinsics.checkNotNullParameter(modulesName, "modulesName");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        if (map.isEmpty()) {
            return;
        }
        Trace.beginSection("[ExpoModulesCore] Attaching view prototypes");
        try {
            JSDecoratorsBridgingObject jSDecoratorsBridgingObject = new JSDecoratorsBridgingObject(runtime.getDeallocator());
            for (Map.Entry<String, ViewManagerDefinition> entry : map.entrySet()) {
                String str = modulesName;
                AppContext appContext2 = appContext;
                Runtime runtime2 = runtime;
                jSDecoratorsBridgingObject.exportViewPrototype(entry.getValue(), str, entry.getKey(), appContext2, runtime2);
                modulesName = str;
                appContext = appContext2;
                runtime = runtime2;
            }
            registerObject("ViewPrototypes", jSDecoratorsBridgingObject);
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.endSection();
        }
    }

    public final void exportViewPrototype(ViewManagerDefinition viewManagerDefinition, String moduleName, String viewKey, AppContext appContext, Runtime runtime) {
        Intrinsics.checkNotNullParameter(viewManagerDefinition, "<this>");
        Intrinsics.checkNotNullParameter(moduleName, "moduleName");
        Intrinsics.checkNotNullParameter(viewKey, "viewKey");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        Intrinsics.checkNotNullParameter(runtime, "runtime");
        List<BaseAsyncFunctionComponent> asyncFunctions = viewManagerDefinition.getAsyncFunctions();
        if (asyncFunctions.isEmpty()) {
            return;
        }
        Trace.beginSection("[ExpoModulesCore] " + ("Attaching view prototype for " + viewManagerDefinition.getName()));
        try {
            JSDecoratorsBridgingObject jSDecoratorsBridgingObject = new JSDecoratorsBridgingObject(runtime.getDeallocator());
            Iterator<T> it = asyncFunctions.iterator();
            while (it.hasNext()) {
                ((BaseAsyncFunctionComponent) it.next()).attachToJSObject(appContext, jSDecoratorsBridgingObject, viewManagerDefinition.getName());
            }
            if (!Intrinsics.areEqual(viewKey, ModuleDefinitionBuilderKt.DEFAULT_MODULE_VIEW)) {
                moduleName = moduleName + "_" + viewManagerDefinition.getName();
            }
            registerObject(moduleName, jSDecoratorsBridgingObject);
            Unit unit = Unit.INSTANCE;
        } finally {
            Trace.endSection();
        }
    }
}

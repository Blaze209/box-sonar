package expo.modules.keepawake;

import androidx.tracing.Trace;
import com.box.androidsdk.content.models.BoxClassification;
import com.google.firebase.remoteconfig.RemoteConfigComponent;
import expo.modules.kotlin.Promise;
import expo.modules.kotlin.exception.Exceptions;
import expo.modules.kotlin.functions.AsyncFunctionWithPromiseComponent;
import expo.modules.kotlin.functions.BoolAsyncFunctionComponent;
import expo.modules.kotlin.functions.DoubleAsyncFunctionComponent;
import expo.modules.kotlin.functions.FloatAsyncFunctionComponent;
import expo.modules.kotlin.functions.IntAsyncFunctionComponent;
import expo.modules.kotlin.functions.StringAsyncFunctionComponent;
import expo.modules.kotlin.functions.UntypedAsyncFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeProvider;
import expo.modules.kotlin.types.LazyKType;
import expo.modules.kotlin.types.TypeConverterProvider;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;

/* JADX INFO: compiled from: KeepAwakeModule.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\n\u001a\u00020\u000bH\u0016R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007¨\u0006\f"}, d2 = {"Lexpo/modules/keepawake/KeepAwakeModule;", "Lexpo/modules/kotlin/modules/Module;", "<init>", "()V", "keepAwakeManager", "Lexpo/modules/keepawake/ExpoKeepAwakeManager;", "getKeepAwakeManager", "()Lexpo/modules/keepawake/ExpoKeepAwakeManager;", "keepAwakeManager$delegate", "Lkotlin/Lazy;", BoxClassification.FIELD_DEFINITION, "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "expo-keep-awake_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class KeepAwakeModule extends Module {

    /* JADX INFO: renamed from: keepAwakeManager$delegate, reason: from kotlin metadata */
    private final Lazy keepAwakeManager = LazyKt.lazy(new Function0() { // from class: expo.modules.keepawake.KeepAwakeModule$$ExternalSyntheticLambda0
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return KeepAwakeModule.keepAwakeManager_delegate$lambda$0(this.f$0);
        }
    });

    /* JADX INFO: Access modifiers changed from: private */
    public final ExpoKeepAwakeManager getKeepAwakeManager() {
        return (ExpoKeepAwakeManager) this.keepAwakeManager.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ExpoKeepAwakeManager keepAwakeManager_delegate$lambda$0(KeepAwakeModule keepAwakeModule) {
        return new ExpoKeepAwakeManager(keepAwakeModule.getAppContext());
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent2;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent2;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent3;
        KeepAwakeModule keepAwakeModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (keepAwakeModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(keepAwakeModule);
            moduleDefinitionBuilder.Name("ExpoKeepAwake");
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(String.class, Promise.class)) {
                asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent(RemoteConfigComponent.ACTIVATE_FILE_NAME, new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.keepawake.KeepAwakeModule$definition$lambda$4$$inlined$AsyncFunction$1
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) throws Exceptions.AppContextLost {
                        Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        this.this$0.getKeepAwakeManager().activate((String) promise);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws Exceptions.AppContextLost {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                TypeConverterProvider converters = moduleDefinitionBuilder2.getConverters();
                AnyType[] anyTypeArr = new AnyType[1];
                AnyType anyType = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
                if (anyType == null) {
                    anyType = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.keepawake.KeepAwakeModule$definition$lambda$4$$inlined$AsyncFunction$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
                        }
                    }), converters);
                }
                anyTypeArr[0] = anyType;
                Function1<Object[], Unit> function1 = new Function1<Object[], Unit>() { // from class: expo.modules.keepawake.KeepAwakeModule$definition$lambda$4$$inlined$AsyncFunction$3
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) throws Exceptions.AppContextLost {
                        Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                        this.this$0.getKeepAwakeManager().activate((String) objArr[0]);
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    untypedAsyncFunctionComponent = new StringAsyncFunctionComponent(RemoteConfigComponent.ACTIVATE_FILE_NAME, anyTypeArr, function1);
                                } else {
                                    untypedAsyncFunctionComponent = new UntypedAsyncFunctionComponent(RemoteConfigComponent.ACTIVATE_FILE_NAME, anyTypeArr, function1);
                                }
                            } else {
                                untypedAsyncFunctionComponent = new FloatAsyncFunctionComponent(RemoteConfigComponent.ACTIVATE_FILE_NAME, anyTypeArr, function1);
                            }
                        } else {
                            untypedAsyncFunctionComponent = new DoubleAsyncFunctionComponent(RemoteConfigComponent.ACTIVATE_FILE_NAME, anyTypeArr, function1);
                        }
                    } else {
                        untypedAsyncFunctionComponent = new BoolAsyncFunctionComponent(RemoteConfigComponent.ACTIVATE_FILE_NAME, anyTypeArr, function1);
                    }
                } else {
                    untypedAsyncFunctionComponent = new IntAsyncFunctionComponent(RemoteConfigComponent.ACTIVATE_FILE_NAME, anyTypeArr, function1);
                }
                asyncFunctionWithPromiseComponent = untypedAsyncFunctionComponent;
            }
            moduleDefinitionBuilder2.getAsyncFunctions().put(RemoteConfigComponent.ACTIVATE_FILE_NAME, asyncFunctionWithPromiseComponent);
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            if (Intrinsics.areEqual(String.class, Promise.class)) {
                asyncFunctionWithPromiseComponent2 = new AsyncFunctionWithPromiseComponent("deactivate", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.keepawake.KeepAwakeModule$definition$lambda$4$$inlined$AsyncFunction$4
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) throws Exceptions.AppContextLost {
                        Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        this.this$0.getKeepAwakeManager().deactivate((String) promise);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) throws Exceptions.AppContextLost {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                TypeConverterProvider converters2 = moduleDefinitionBuilder3.getConverters();
                AnyType[] anyTypeArr2 = new AnyType[1];
                AnyType anyType2 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
                if (anyType2 == null) {
                    anyType2 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.keepawake.KeepAwakeModule$definition$lambda$4$$inlined$AsyncFunction$5
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(String.class);
                        }
                    }), converters2);
                }
                anyTypeArr2[0] = anyType2;
                Function1<Object[], Unit> function2 = new Function1<Object[], Unit>() { // from class: expo.modules.keepawake.KeepAwakeModule$definition$lambda$4$$inlined$AsyncFunction$6
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) throws Exceptions.AppContextLost {
                        Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                        this.this$0.getKeepAwakeManager().deactivate((String) objArr[0]);
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    untypedAsyncFunctionComponent2 = new StringAsyncFunctionComponent("deactivate", anyTypeArr2, function2);
                                } else {
                                    untypedAsyncFunctionComponent2 = new UntypedAsyncFunctionComponent("deactivate", anyTypeArr2, function2);
                                }
                            } else {
                                untypedAsyncFunctionComponent2 = new FloatAsyncFunctionComponent("deactivate", anyTypeArr2, function2);
                            }
                        } else {
                            untypedAsyncFunctionComponent2 = new DoubleAsyncFunctionComponent("deactivate", anyTypeArr2, function2);
                        }
                    } else {
                        untypedAsyncFunctionComponent2 = new BoolAsyncFunctionComponent("deactivate", anyTypeArr2, function2);
                    }
                } else {
                    untypedAsyncFunctionComponent2 = new IntAsyncFunctionComponent("deactivate", anyTypeArr2, function2);
                }
                asyncFunctionWithPromiseComponent2 = untypedAsyncFunctionComponent2;
            }
            moduleDefinitionBuilder3.getAsyncFunctions().put("deactivate", asyncFunctionWithPromiseComponent2);
            ModuleDefinitionBuilder moduleDefinitionBuilder4 = moduleDefinitionBuilder;
            AnyType[] anyTypeArr3 = new AnyType[0];
            Function1<Object[], Boolean> function3 = new Function1<Object[], Boolean>() { // from class: expo.modules.keepawake.KeepAwakeModule$definition$lambda$4$$inlined$AsyncFunction$7
                @Override // kotlin.jvm.functions.Function1
                public final Boolean invoke(Object[] it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    return Boolean.valueOf(this.this$0.getKeepAwakeManager().isActivated());
                }
            };
            if (!Intrinsics.areEqual(Boolean.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Boolean.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Boolean.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Boolean.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Boolean.class, String.class)) {
                                untypedAsyncFunctionComponent3 = new StringAsyncFunctionComponent("isActivated", anyTypeArr3, function3);
                            } else {
                                untypedAsyncFunctionComponent3 = new UntypedAsyncFunctionComponent("isActivated", anyTypeArr3, function3);
                            }
                        } else {
                            untypedAsyncFunctionComponent3 = new FloatAsyncFunctionComponent("isActivated", anyTypeArr3, function3);
                        }
                    } else {
                        untypedAsyncFunctionComponent3 = new DoubleAsyncFunctionComponent("isActivated", anyTypeArr3, function3);
                    }
                } else {
                    untypedAsyncFunctionComponent3 = new BoolAsyncFunctionComponent("isActivated", anyTypeArr3, function3);
                }
            } else {
                untypedAsyncFunctionComponent3 = new IntAsyncFunctionComponent("isActivated", anyTypeArr3, function3);
            }
            moduleDefinitionBuilder4.getAsyncFunctions().put("isActivated", untypedAsyncFunctionComponent3);
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }
}

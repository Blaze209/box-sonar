package expo.modules.ui;

import android.view.View;
import androidx.compose.material3.SwitchDefaults;
import androidx.compose.material3.ToggleButtonDefaults;
import androidx.tracing.Trace;
import com.box.androidsdk.content.models.BoxClassification;
import com.swmansion.rnscreens.gamma.stack.screen.event.StackScreenDismissEvent;
import expo.modules.kotlin.events.BasicEventListener;
import expo.modules.kotlin.events.EventName;
import expo.modules.kotlin.functions.BoolAsyncFunctionComponent;
import expo.modules.kotlin.functions.DoubleAsyncFunctionComponent;
import expo.modules.kotlin.functions.FloatAsyncFunctionComponent;
import expo.modules.kotlin.functions.IntAsyncFunctionComponent;
import expo.modules.kotlin.functions.StringAsyncFunctionComponent;
import expo.modules.kotlin.functions.UntypedAsyncFunctionComponent;
import expo.modules.kotlin.modules.Module;
import expo.modules.kotlin.modules.ModuleDefinitionBuilder;
import expo.modules.kotlin.modules.ModuleDefinitionData;
import expo.modules.kotlin.objects.ConstantComponentBuilder;
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeProvider;
import expo.modules.kotlin.types.LazyKType;
import expo.modules.kotlin.types.TypeConverterProvider;
import expo.modules.kotlin.views.AnyViewProp;
import expo.modules.kotlin.views.ComposeViewFunctionDefinitionBuilder;
import expo.modules.kotlin.views.ComposeViewProp;
import expo.modules.kotlin.views.ConcreteViewPropWithDefault;
import expo.modules.kotlin.views.ViewDefinitionBuilder;
import expo.modules.kotlin.views.decorators.CSSPropsKt;
import expo.modules.ui.button.ButtonProps;
import expo.modules.ui.button.IconButtonProps;
import expo.modules.ui.icon.IconProps;
import expo.modules.ui.icon.IconView;
import expo.modules.ui.menu.ContextMenuProps;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KProperty1;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.reflect.full.KClasses;
import okhttp3.Cache;
import okhttp3.ConnectionPool;
import okhttp3.Dispatcher;
import okhttp3.OkHttpClient;

/* JADX INFO: compiled from: ExpoUIModule.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\t\u001a\u00020\nH\u0016R\"\u0010\u0006\u001a\u0004\u0018\u00010\u00052\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005@BX\u0086\u000e¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b¨\u0006\u000b"}, d2 = {"Lexpo/modules/ui/ExpoUIModule;", "Lexpo/modules/kotlin/modules/Module;", "<init>", "()V", "value", "Lokhttp3/OkHttpClient;", "okHttpClient", "getOkHttpClient", "()Lokhttp3/OkHttpClient;", BoxClassification.FIELD_DEFINITION, "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ExpoUIModule extends Module {
    public static final int $stable = 8;
    private OkHttpClient okHttpClient;

    public final OkHttpClient getOkHttpClient() {
        return this.okHttpClient;
    }

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent;
        String str = "onPress";
        ExpoUIModule expoUIModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (expoUIModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(expoUIModule);
            moduleDefinitionBuilder.Name("ExpoUI");
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_CREATE, new BasicEventListener(EventName.MODULE_CREATE, new Function0<Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$28$$inlined$OnCreate$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    this.this$0.okHttpClient = new OkHttpClient.Builder().build();
                }
            }));
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_DESTROY, new BasicEventListener(EventName.MODULE_DESTROY, new Function0<Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$28$$inlined$OnDestroy$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() throws IOException {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() throws IOException {
                    Cache cache;
                    ConnectionPool connectionPool;
                    Dispatcher dispatcher;
                    ExecutorService executorService;
                    OkHttpClient okHttpClient = this.this$0.getOkHttpClient();
                    if (okHttpClient != null && (dispatcher = okHttpClient.dispatcher()) != null && (executorService = dispatcher.executorService()) != null) {
                        executorService.shutdown();
                    }
                    OkHttpClient okHttpClient2 = this.this$0.getOkHttpClient();
                    if (okHttpClient2 != null && (connectionPool = okHttpClient2.connectionPool()) != null) {
                        connectionPool.evictAll();
                    }
                    OkHttpClient okHttpClient3 = this.this$0.getOkHttpClient();
                    if (okHttpClient3 != null && (cache = okHttpClient3.cache()) != null) {
                        cache.close();
                    }
                    this.this$0.okHttpClient = null;
                }
            }));
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            ViewDefinitionBuilder viewDefinitionBuilder = new ViewDefinitionBuilder(Reflection.getOrCreateKotlinClass(HostView.class), new LazyKType(Reflection.getOrCreateKotlinClass(HostView.class), false, new Function0<KType>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$28$$inlined$ComposeView$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(HostView.class);
                }
            }, 2, null), null, 4, null);
            for (KProperty1 kProperty1 : KClasses.getMemberProperties(Reflection.getOrCreateKotlinClass(HostProps.class))) {
                KType type = ((KTypeProjection) CollectionsKt.first((List) kProperty1.getReturnType().getArguments())).getType();
                if (type != null && viewDefinitionBuilder.getProps().get(kProperty1.getName()) == null) {
                    viewDefinitionBuilder.getProps().put(kProperty1.getName(), new ComposeViewProp(kProperty1.getName(), new AnyType(type, null, 2, null), kProperty1));
                }
                str = str;
            }
            String str2 = str;
            CSSPropsKt.UseCSSProps(viewDefinitionBuilder);
            boolean z = false;
            viewDefinitionBuilder.Events("onLayoutContent");
            viewDefinitionBuilder.setOnViewDidUpdateProps(new Function1<View, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$28$lambda$3$$inlined$OnViewDidUpdateProps$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    ((HostView) it).onViewDidUpdateProps$expo_ui_release();
                }
            });
            moduleDefinitionBuilder2.registerViewDefinition(viewDefinitionBuilder.build());
            ConstantComponentBuilder constantComponentBuilder = new ConstantComponentBuilder("SwitchDefaultIconSize");
            constantComponentBuilder.setGetter(new Function0<Float>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$28$$inlined$Constant$1
                @Override // kotlin.jvm.functions.Function0
                public final Float invoke() {
                    return Float.valueOf(SwitchDefaults.INSTANCE.m4357getIconSizeD9Ej5fM());
                }
            });
            moduleDefinitionBuilder.getConstants().put("SwitchDefaultIconSize", constantComponentBuilder);
            ConstantComponentBuilder constantComponentBuilder2 = new ConstantComponentBuilder("ToggleButtonIconSpacing");
            constantComponentBuilder2.setGetter(new Function0<Float>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$28$$inlined$Constant$2
                @Override // kotlin.jvm.functions.Function0
                public final Float invoke() {
                    return Float.valueOf(ToggleButtonDefaults.INSTANCE.m4605getIconSpacingD9Ej5fM());
                }
            });
            moduleDefinitionBuilder.getConstants().put("ToggleButtonIconSpacing", constantComponentBuilder2);
            ConstantComponentBuilder constantComponentBuilder3 = new ConstantComponentBuilder("ToggleButtonIconSize");
            constantComponentBuilder3.setGetter(new Function0<Float>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$28$$inlined$Constant$3
                @Override // kotlin.jvm.functions.Function0
                public final Float invoke() {
                    return Float.valueOf(ToggleButtonDefaults.INSTANCE.m4604getIconSizeD9Ej5fM());
                }
            });
            moduleDefinitionBuilder.getConstants().put("ToggleButtonIconSize", constantComponentBuilder3);
            ViewDefinitionBuilder viewDefinitionBuilder2 = new ViewDefinitionBuilder(Reflection.getOrCreateKotlinClass(RNHostView.class), new LazyKType(Reflection.getOrCreateKotlinClass(RNHostView.class), false, new Function0<KType>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$28$$inlined$ComposeView$default$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(RNHostView.class);
                }
            }, 2, null), null, 4, null);
            for (KProperty1 kProperty2 : KClasses.getMemberProperties(Reflection.getOrCreateKotlinClass(RNHostProps.class))) {
                KType type2 = ((KTypeProjection) CollectionsKt.first((List) kProperty2.getReturnType().getArguments())).getType();
                if (type2 != null && viewDefinitionBuilder2.getProps().get(kProperty2.getName()) == null) {
                    viewDefinitionBuilder2.getProps().put(kProperty2.getName(), new ComposeViewProp(kProperty2.getName(), new AnyType(type2, null, 2, null), kProperty2));
                }
            }
            CSSPropsKt.UseCSSProps(viewDefinitionBuilder2);
            Unit unit = Unit.INSTANCE;
            moduleDefinitionBuilder.registerViewDefinition(viewDefinitionBuilder2.build());
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            ViewDefinitionBuilder viewDefinitionBuilder3 = new ViewDefinitionBuilder(Reflection.getOrCreateKotlinClass(TextInputView.class), new LazyKType(Reflection.getOrCreateKotlinClass(TextInputView.class), false, new Function0<KType>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$28$$inlined$ComposeView$2
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(TextInputView.class);
                }
            }, 2, null), null, 4, null);
            for (KProperty1 kProperty3 : KClasses.getMemberProperties(Reflection.getOrCreateKotlinClass(TextInputProps.class))) {
                KType type3 = ((KTypeProjection) CollectionsKt.first((List) kProperty3.getReturnType().getArguments())).getType();
                if (type3 != null && viewDefinitionBuilder3.getProps().get(kProperty3.getName()) == null) {
                    viewDefinitionBuilder3.getProps().put(kProperty3.getName(), new ComposeViewProp(kProperty3.getName(), new AnyType(type3, null, 2, null), kProperty3));
                }
                z = z;
            }
            boolean z2 = z;
            CSSPropsKt.UseCSSProps(viewDefinitionBuilder3);
            String[] strArr = new String[1];
            strArr[z2 ? 1 : 0] = "onValueChanged";
            viewDefinitionBuilder3.Events(strArr);
            ExpoUIModule$definition$1$7$1 expoUIModule$definition$1$7$1 = new Function2<TextInputView, String, Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$1$7$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(TextInputView textInputView, String str3) {
                    invoke2(textInputView, str3);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(TextInputView view, String text) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(text, "text");
                    if (view.getText() == null) {
                        view.setText(text);
                    }
                }
            };
            Map<String, AnyViewProp> props = viewDefinitionBuilder3.getProps();
            AnyType anyType = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), Boolean.valueOf(z2)));
            if (anyType == null) {
                anyType = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), z2, new Function0<KType>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$28$lambda$8$$inlined$PropGeneric$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }), null);
            }
            props.put("defaultValue", new ConcreteViewPropWithDefault("defaultValue", anyType, expoUIModule$definition$1$7$1, ""));
            TypeConverterProvider converters = viewDefinitionBuilder3.getConverters();
            AnyType[] anyTypeArr = new AnyType[2];
            AnyType anyType2 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(TextInputView.class), false));
            if (anyType2 == null) {
                anyType2 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(TextInputView.class), false, new Function0<KType>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$28$lambda$8$$inlined$AsyncFunction$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(TextInputView.class);
                    }
                }), converters);
            }
            anyTypeArr[0] = anyType2;
            AnyType anyType3 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType3 == null) {
                anyType3 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$28$lambda$8$$inlined$AsyncFunction$2
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }), converters);
            }
            anyTypeArr[1] = anyType3;
            Function1<Object[], Unit> function1 = new Function1<Object[], Unit>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$28$lambda$8$$inlined$AsyncFunction$3
                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    ((TextInputView) objArr[0]).setText((String) objArr[1]);
                    return Unit.INSTANCE;
                }
            };
            if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Unit.class, String.class)) {
                                untypedAsyncFunctionComponent = new StringAsyncFunctionComponent("setText", anyTypeArr, function1);
                            } else {
                                untypedAsyncFunctionComponent = new UntypedAsyncFunctionComponent("setText", anyTypeArr, function1);
                            }
                        } else {
                            untypedAsyncFunctionComponent = new FloatAsyncFunctionComponent("setText", anyTypeArr, function1);
                        }
                    } else {
                        untypedAsyncFunctionComponent = new DoubleAsyncFunctionComponent("setText", anyTypeArr, function1);
                    }
                } else {
                    untypedAsyncFunctionComponent = new BoolAsyncFunctionComponent("setText", anyTypeArr, function1);
                }
            } else {
                untypedAsyncFunctionComponent = new IntAsyncFunctionComponent("setText", anyTypeArr, function1);
            }
            viewDefinitionBuilder3.getAsyncFunctions().put("setText", untypedAsyncFunctionComponent);
            moduleDefinitionBuilder3.registerViewDefinition(viewDefinitionBuilder3.build());
            ModuleDefinitionBuilder moduleDefinitionBuilder4 = moduleDefinitionBuilder;
            ViewDefinitionBuilder viewDefinitionBuilder4 = new ViewDefinitionBuilder(Reflection.getOrCreateKotlinClass(SlotView.class), new LazyKType(Reflection.getOrCreateKotlinClass(SlotView.class), false, new Function0<KType>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$28$$inlined$ComposeView$3
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(SlotView.class);
                }
            }, 2, null), null, 4, null);
            for (KProperty1 kProperty4 : KClasses.getMemberProperties(Reflection.getOrCreateKotlinClass(SlotProps.class))) {
                KType type4 = ((KTypeProjection) CollectionsKt.first((List) kProperty4.getReturnType().getArguments())).getType();
                if (type4 != null && viewDefinitionBuilder4.getProps().get(kProperty4.getName()) == null) {
                    viewDefinitionBuilder4.getProps().put(kProperty4.getName(), new ComposeViewProp(kProperty4.getName(), new AnyType(type4, null, 2, null), kProperty4));
                }
            }
            CSSPropsKt.UseCSSProps(viewDefinitionBuilder4);
            viewDefinitionBuilder4.Events("onSlotEvent");
            moduleDefinitionBuilder4.registerViewDefinition(viewDefinitionBuilder4.build());
            ViewDefinitionBuilder viewDefinitionBuilder5 = new ViewDefinitionBuilder(Reflection.getOrCreateKotlinClass(IconView.class), new LazyKType(Reflection.getOrCreateKotlinClass(IconView.class), false, new Function0<KType>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$28$$inlined$ComposeView$default$2
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(IconView.class);
                }
            }, 2, null), null, 4, null);
            for (KProperty1 kProperty5 : KClasses.getMemberProperties(Reflection.getOrCreateKotlinClass(IconProps.class))) {
                KType type5 = ((KTypeProjection) CollectionsKt.first((List) kProperty5.getReturnType().getArguments())).getType();
                if (type5 != null && viewDefinitionBuilder5.getProps().get(kProperty5.getName()) == null) {
                    viewDefinitionBuilder5.getProps().put(kProperty5.getName(), new ComposeViewProp(kProperty5.getName(), new AnyType(type5, null, 2, null), kProperty5));
                }
            }
            CSSPropsKt.UseCSSProps(viewDefinitionBuilder5);
            Unit unit2 = Unit.INSTANCE;
            moduleDefinitionBuilder.registerViewDefinition(viewDefinitionBuilder5.build());
            ViewDefinitionBuilder viewDefinitionBuilder6 = new ViewDefinitionBuilder(Reflection.getOrCreateKotlinClass(LazyColumnView.class), new LazyKType(Reflection.getOrCreateKotlinClass(LazyColumnView.class), false, new Function0<KType>() { // from class: expo.modules.ui.ExpoUIModule$definition$lambda$28$$inlined$ComposeView$default$3
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(LazyColumnView.class);
                }
            }, 2, null), null, 4, null);
            for (KProperty1 kProperty6 : KClasses.getMemberProperties(Reflection.getOrCreateKotlinClass(LazyColumnProps.class))) {
                KType type6 = ((KTypeProjection) CollectionsKt.first((List) kProperty6.getReturnType().getArguments())).getType();
                if (type6 != null && viewDefinitionBuilder6.getProps().get(kProperty6.getName()) == null) {
                    viewDefinitionBuilder6.getProps().put(kProperty6.getName(), new ComposeViewProp(kProperty6.getName(), new AnyType(type6, null, 2, null), kProperty6));
                }
            }
            CSSPropsKt.UseCSSProps(viewDefinitionBuilder6);
            Unit unit3 = Unit.INSTANCE;
            moduleDefinitionBuilder.registerViewDefinition(viewDefinitionBuilder6.build());
            ComposeViewFunctionDefinitionBuilder composeViewFunctionDefinitionBuilder = new ComposeViewFunctionDefinitionBuilder("ModalBottomSheetView", Reflection.getOrCreateKotlinClass(ModalBottomSheetProps.class), ComposableSingletons$ExpoUIModuleKt.INSTANCE.getLambda$1665482278$expo_ui_release());
            composeViewFunctionDefinitionBuilder.Events("onDismissRequest");
            moduleDefinitionBuilder.registerViewDefinition(composeViewFunctionDefinitionBuilder.build());
            ComposeViewFunctionDefinitionBuilder composeViewFunctionDefinitionBuilder2 = new ComposeViewFunctionDefinitionBuilder("PickerView", Reflection.getOrCreateKotlinClass(PickerProps.class), ComposableSingletons$ExpoUIModuleKt.INSTANCE.getLambda$1368449064$expo_ui_release());
            composeViewFunctionDefinitionBuilder2.Events("onOptionSelected");
            moduleDefinitionBuilder.registerViewDefinition(composeViewFunctionDefinitionBuilder2.build());
            ComposeViewFunctionDefinitionBuilder composeViewFunctionDefinitionBuilder3 = new ComposeViewFunctionDefinitionBuilder("SwitchView", Reflection.getOrCreateKotlinClass(SwitchProps.class), ComposableSingletons$ExpoUIModuleKt.INSTANCE.getLambda$661371041$expo_ui_release());
            composeViewFunctionDefinitionBuilder3.Events("onValueChange");
            moduleDefinitionBuilder.registerViewDefinition(composeViewFunctionDefinitionBuilder3.build());
            ComposeViewFunctionDefinitionBuilder composeViewFunctionDefinitionBuilder4 = new ComposeViewFunctionDefinitionBuilder("Button", Reflection.getOrCreateKotlinClass(ButtonProps.class), ComposableSingletons$ExpoUIModuleKt.INSTANCE.m14634getLambda$282984766$expo_ui_release());
            composeViewFunctionDefinitionBuilder4.Events("onButtonPressed");
            moduleDefinitionBuilder.registerViewDefinition(composeViewFunctionDefinitionBuilder4.build());
            ComposeViewFunctionDefinitionBuilder composeViewFunctionDefinitionBuilder5 = new ComposeViewFunctionDefinitionBuilder("IconButton", Reflection.getOrCreateKotlinClass(IconButtonProps.class), ComposableSingletons$ExpoUIModuleKt.INSTANCE.getLambda$1832413544$expo_ui_release());
            composeViewFunctionDefinitionBuilder5.Events("onButtonPressed");
            moduleDefinitionBuilder.registerViewDefinition(composeViewFunctionDefinitionBuilder5.build());
            ComposeViewFunctionDefinitionBuilder composeViewFunctionDefinitionBuilder6 = new ComposeViewFunctionDefinitionBuilder("SliderView", Reflection.getOrCreateKotlinClass(SliderProps.class), ComposableSingletons$ExpoUIModuleKt.INSTANCE.m14639getLambda$873399247$expo_ui_release());
            composeViewFunctionDefinitionBuilder6.Events("onValueChanged");
            moduleDefinitionBuilder.registerViewDefinition(composeViewFunctionDefinitionBuilder6.build());
            ComposeViewFunctionDefinitionBuilder composeViewFunctionDefinitionBuilder7 = new ComposeViewFunctionDefinitionBuilder("ShapeView", Reflection.getOrCreateKotlinClass(ShapeProps.class), ComposableSingletons$ExpoUIModuleKt.INSTANCE.m14629getLambda$1515444166$expo_ui_release());
            Unit unit4 = Unit.INSTANCE;
            moduleDefinitionBuilder.registerViewDefinition(composeViewFunctionDefinitionBuilder7.build());
            ComposeViewFunctionDefinitionBuilder composeViewFunctionDefinitionBuilder8 = new ComposeViewFunctionDefinitionBuilder("DividerView", Reflection.getOrCreateKotlinClass(DividerProps.class), ComposableSingletons$ExpoUIModuleKt.INSTANCE.getLambda$1530221537$expo_ui_release());
            Unit unit5 = Unit.INSTANCE;
            moduleDefinitionBuilder.registerViewDefinition(composeViewFunctionDefinitionBuilder8.build());
            ComposeViewFunctionDefinitionBuilder composeViewFunctionDefinitionBuilder9 = new ComposeViewFunctionDefinitionBuilder("DateTimePickerView", Reflection.getOrCreateKotlinClass(DateTimePickerProps.class), ComposableSingletons$ExpoUIModuleKt.INSTANCE.m14631getLambda$1927449818$expo_ui_release());
            composeViewFunctionDefinitionBuilder9.Events("onDateSelected");
            moduleDefinitionBuilder.registerViewDefinition(composeViewFunctionDefinitionBuilder9.build());
            ComposeViewFunctionDefinitionBuilder composeViewFunctionDefinitionBuilder10 = new ComposeViewFunctionDefinitionBuilder("ContextMenuView", Reflection.getOrCreateKotlinClass(ContextMenuProps.class), ComposableSingletons$ExpoUIModuleKt.INSTANCE.getLambda$1585574314$expo_ui_release());
            composeViewFunctionDefinitionBuilder10.Events("onContextMenuButtonPressed", "onContextMenuSwitchValueChanged", "onExpandedChanged");
            moduleDefinitionBuilder.registerViewDefinition(composeViewFunctionDefinitionBuilder10.build());
            ComposeViewFunctionDefinitionBuilder composeViewFunctionDefinitionBuilder11 = new ComposeViewFunctionDefinitionBuilder("ProgressView", Reflection.getOrCreateKotlinClass(ProgressProps.class), ComposableSingletons$ExpoUIModuleKt.INSTANCE.getLambda$68758547$expo_ui_release());
            Unit unit6 = Unit.INSTANCE;
            moduleDefinitionBuilder.registerViewDefinition(composeViewFunctionDefinitionBuilder11.build());
            ComposeViewFunctionDefinitionBuilder composeViewFunctionDefinitionBuilder12 = new ComposeViewFunctionDefinitionBuilder("BoxView", Reflection.getOrCreateKotlinClass(LayoutProps.class), ComposableSingletons$ExpoUIModuleKt.INSTANCE.m14633getLambda$248019729$expo_ui_release());
            Unit unit7 = Unit.INSTANCE;
            moduleDefinitionBuilder.registerViewDefinition(composeViewFunctionDefinitionBuilder12.build());
            ComposeViewFunctionDefinitionBuilder composeViewFunctionDefinitionBuilder13 = new ComposeViewFunctionDefinitionBuilder("RowView", Reflection.getOrCreateKotlinClass(LayoutProps.class), ComposableSingletons$ExpoUIModuleKt.INSTANCE.m14640getLambda$932250034$expo_ui_release());
            Unit unit8 = Unit.INSTANCE;
            moduleDefinitionBuilder.registerViewDefinition(composeViewFunctionDefinitionBuilder13.build());
            ComposeViewFunctionDefinitionBuilder composeViewFunctionDefinitionBuilder14 = new ComposeViewFunctionDefinitionBuilder("FlowRowView", Reflection.getOrCreateKotlinClass(LayoutProps.class), ComposableSingletons$ExpoUIModuleKt.INSTANCE.m14630getLambda$1616480339$expo_ui_release());
            Unit unit9 = Unit.INSTANCE;
            moduleDefinitionBuilder.registerViewDefinition(composeViewFunctionDefinitionBuilder14.build());
            ComposeViewFunctionDefinitionBuilder composeViewFunctionDefinitionBuilder15 = new ComposeViewFunctionDefinitionBuilder("ColumnView", Reflection.getOrCreateKotlinClass(LayoutProps.class), ComposableSingletons$ExpoUIModuleKt.INSTANCE.getLambda$1994256652$expo_ui_release());
            Unit unit10 = Unit.INSTANCE;
            moduleDefinitionBuilder.registerViewDefinition(composeViewFunctionDefinitionBuilder15.build());
            ComposeViewFunctionDefinitionBuilder composeViewFunctionDefinitionBuilder16 = new ComposeViewFunctionDefinitionBuilder("TextView", Reflection.getOrCreateKotlinClass(TextProps.class), ComposableSingletons$ExpoUIModuleKt.INSTANCE.getLambda$804575342$expo_ui_release());
            Unit unit11 = Unit.INSTANCE;
            moduleDefinitionBuilder.registerViewDefinition(composeViewFunctionDefinitionBuilder16.build());
            ComposeViewFunctionDefinitionBuilder composeViewFunctionDefinitionBuilder17 = new ComposeViewFunctionDefinitionBuilder("SearchBarView", Reflection.getOrCreateKotlinClass(SearchBarProps.class), ComposableSingletons$ExpoUIModuleKt.INSTANCE.getLambda$230995585$expo_ui_release());
            composeViewFunctionDefinitionBuilder17.Events("onSearch");
            moduleDefinitionBuilder.registerViewDefinition(composeViewFunctionDefinitionBuilder17.build());
            ComposeViewFunctionDefinitionBuilder composeViewFunctionDefinitionBuilder18 = new ComposeViewFunctionDefinitionBuilder("DockedSearchBarView", Reflection.getOrCreateKotlinClass(DockedSearchBarProps.class), ComposableSingletons$ExpoUIModuleKt.INSTANCE.m14635getLambda$42052306$expo_ui_release());
            composeViewFunctionDefinitionBuilder18.Events("onQueryChange");
            moduleDefinitionBuilder.registerViewDefinition(composeViewFunctionDefinitionBuilder18.build());
            ComposeViewFunctionDefinitionBuilder composeViewFunctionDefinitionBuilder19 = new ComposeViewFunctionDefinitionBuilder("HorizontalFloatingToolbarView", Reflection.getOrCreateKotlinClass(HorizontalFloatingToolbarProps.class), ComposableSingletons$ExpoUIModuleKt.INSTANCE.m14632getLambda$2070623419$expo_ui_release());
            Unit unit12 = Unit.INSTANCE;
            moduleDefinitionBuilder.registerViewDefinition(composeViewFunctionDefinitionBuilder19.build());
            ComposeViewFunctionDefinitionBuilder composeViewFunctionDefinitionBuilder20 = new ComposeViewFunctionDefinitionBuilder("PullToRefreshBoxView", Reflection.getOrCreateKotlinClass(PullToRefreshBoxProps.class), ComposableSingletons$ExpoUIModuleKt.INSTANCE.getLambda$596787373$expo_ui_release());
            composeViewFunctionDefinitionBuilder20.Events("onRefresh");
            moduleDefinitionBuilder.registerViewDefinition(composeViewFunctionDefinitionBuilder20.build());
            ComposeViewFunctionDefinitionBuilder composeViewFunctionDefinitionBuilder21 = new ComposeViewFunctionDefinitionBuilder("CarouselView", Reflection.getOrCreateKotlinClass(CarouselProps.class), ComposableSingletons$ExpoUIModuleKt.INSTANCE.getLambda$994123911$expo_ui_release());
            Unit unit13 = Unit.INSTANCE;
            moduleDefinitionBuilder.registerViewDefinition(composeViewFunctionDefinitionBuilder21.build());
            ComposeViewFunctionDefinitionBuilder composeViewFunctionDefinitionBuilder22 = new ComposeViewFunctionDefinitionBuilder("AlertDialogView", Reflection.getOrCreateKotlinClass(AlertDialogProps.class), ComposableSingletons$ExpoUIModuleKt.INSTANCE.getLambda$77819936$expo_ui_release());
            composeViewFunctionDefinitionBuilder22.Events("onDismissPressed", "onConfirmPressed");
            moduleDefinitionBuilder.registerViewDefinition(composeViewFunctionDefinitionBuilder22.build());
            ComposeViewFunctionDefinitionBuilder composeViewFunctionDefinitionBuilder23 = new ComposeViewFunctionDefinitionBuilder("ChipView", Reflection.getOrCreateKotlinClass(ChipProps.class), ComposableSingletons$ExpoUIModuleKt.INSTANCE.getLambda$1003922353$expo_ui_release());
            composeViewFunctionDefinitionBuilder23.Events(str2, StackScreenDismissEvent.EVENT_REGISTRATION_NAME);
            moduleDefinitionBuilder.registerViewDefinition(composeViewFunctionDefinitionBuilder23.build());
            ComposeViewFunctionDefinitionBuilder composeViewFunctionDefinitionBuilder24 = new ComposeViewFunctionDefinitionBuilder("FilterChipView", Reflection.getOrCreateKotlinClass(FilterChipProps.class), ComposableSingletons$ExpoUIModuleKt.INSTANCE.getLambda$256499432$expo_ui_release());
            composeViewFunctionDefinitionBuilder24.Events(str2);
            moduleDefinitionBuilder.registerViewDefinition(composeViewFunctionDefinitionBuilder24.build());
            ComposeViewFunctionDefinitionBuilder composeViewFunctionDefinitionBuilder25 = new ComposeViewFunctionDefinitionBuilder("TextButtonView", Reflection.getOrCreateKotlinClass(TextButtonProps.class), ComposableSingletons$ExpoUIModuleKt.INSTANCE.m14637getLambda$55812126$expo_ui_release());
            composeViewFunctionDefinitionBuilder25.Events("onButtonPressed");
            moduleDefinitionBuilder.registerViewDefinition(composeViewFunctionDefinitionBuilder25.build());
            ComposeViewFunctionDefinitionBuilder composeViewFunctionDefinitionBuilder26 = new ComposeViewFunctionDefinitionBuilder("ToggleButtonView", Reflection.getOrCreateKotlinClass(ToggleButtonProps.class), ComposableSingletons$ExpoUIModuleKt.INSTANCE.getLambda$2043498664$expo_ui_release());
            composeViewFunctionDefinitionBuilder26.Events("onCheckedChange");
            moduleDefinitionBuilder.registerViewDefinition(composeViewFunctionDefinitionBuilder26.build());
            ComposeViewFunctionDefinitionBuilder composeViewFunctionDefinitionBuilder27 = new ComposeViewFunctionDefinitionBuilder("CardView", Reflection.getOrCreateKotlinClass(CardProps.class), ComposableSingletons$ExpoUIModuleKt.INSTANCE.m14627getLambda$1035540239$expo_ui_release());
            Unit unit14 = Unit.INSTANCE;
            moduleDefinitionBuilder.registerViewDefinition(composeViewFunctionDefinitionBuilder27.build());
            ComposeViewFunctionDefinitionBuilder composeViewFunctionDefinitionBuilder28 = new ComposeViewFunctionDefinitionBuilder("ListItemView", Reflection.getOrCreateKotlinClass(ListItemProps.class), ComposableSingletons$ExpoUIModuleKt.INSTANCE.m14626getLambda$1030307887$expo_ui_release());
            Unit unit15 = Unit.INSTANCE;
            moduleDefinitionBuilder.registerViewDefinition(composeViewFunctionDefinitionBuilder28.build());
            ComposeViewFunctionDefinitionBuilder composeViewFunctionDefinitionBuilder29 = new ComposeViewFunctionDefinitionBuilder("SpacerView", Reflection.getOrCreateKotlinClass(SpacerProps.class), ComposableSingletons$ExpoUIModuleKt.INSTANCE.m14638getLambda$767778165$expo_ui_release());
            Unit unit16 = Unit.INSTANCE;
            moduleDefinitionBuilder.registerViewDefinition(composeViewFunctionDefinitionBuilder29.build());
            ComposeViewFunctionDefinitionBuilder composeViewFunctionDefinitionBuilder30 = new ComposeViewFunctionDefinitionBuilder("BasicAlertDialogView", Reflection.getOrCreateKotlinClass(BasicAlertDialogProps.class), ComposableSingletons$ExpoUIModuleKt.INSTANCE.getLambda$2122913972$expo_ui_release());
            composeViewFunctionDefinitionBuilder30.Events("onDismissRequest");
            moduleDefinitionBuilder.registerViewDefinition(composeViewFunctionDefinitionBuilder30.build());
            ComposeViewFunctionDefinitionBuilder composeViewFunctionDefinitionBuilder31 = new ComposeViewFunctionDefinitionBuilder("SurfaceView", Reflection.getOrCreateKotlinClass(SurfaceProps.class), ComposableSingletons$ExpoUIModuleKt.INSTANCE.m14628getLambda$1252238869$expo_ui_release());
            Unit unit17 = Unit.INSTANCE;
            moduleDefinitionBuilder.registerViewDefinition(composeViewFunctionDefinitionBuilder31.build());
            ComposeViewFunctionDefinitionBuilder composeViewFunctionDefinitionBuilder32 = new ComposeViewFunctionDefinitionBuilder("RadioButtonView", Reflection.getOrCreateKotlinClass(RadioButtonProps.class), ComposableSingletons$ExpoUIModuleKt.INSTANCE.m14636getLambda$504997846$expo_ui_release());
            composeViewFunctionDefinitionBuilder32.Events("onNativeClick");
            moduleDefinitionBuilder.registerViewDefinition(composeViewFunctionDefinitionBuilder32.build());
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }
}

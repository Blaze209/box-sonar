package expo.modules.webview;

import android.view.View;
import androidx.tracing.Trace;
import com.box.androidsdk.content.models.BoxClassification;
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
import expo.modules.kotlin.types.AnyType;
import expo.modules.kotlin.types.AnyTypeProvider;
import expo.modules.kotlin.types.LazyKType;
import expo.modules.kotlin.types.TypeConverterProvider;
import expo.modules.kotlin.views.AnyViewProp;
import expo.modules.kotlin.views.ConcreteViewProp;
import expo.modules.kotlin.views.ViewDefinitionBuilder;
import expo.modules.kotlin.views.decorators.CSSPropsKt;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;

/* JADX INFO: compiled from: DomWebViewModule.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lexpo/modules/webview/DomWebViewModule;", "Lexpo/modules/kotlin/modules/Module;", "<init>", "()V", BoxClassification.FIELD_DEFINITION, "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "expo-dom-webview_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class DomWebViewModule extends Module {
    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent2;
        DomWebViewModule domWebViewModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (domWebViewModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(domWebViewModule);
            moduleDefinitionBuilder.Name("ExpoDomWebViewModule");
            moduleDefinitionBuilder.getEventListeners().put(EventName.MODULE_DESTROY, new BasicEventListener(EventName.MODULE_DESTROY, new Function0<Unit>() { // from class: expo.modules.webview.DomWebViewModule$definition$lambda$6$$inlined$OnDestroy$1
                @Override // kotlin.jvm.functions.Function0
                public /* bridge */ /* synthetic */ Unit invoke() {
                    invoke2();
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2() {
                    DomWebViewRegistry.INSTANCE.reset();
                }
            }));
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            TypeConverterProvider converters = moduleDefinitionBuilder2.getConverters();
            AnyType[] anyTypeArr = new AnyType[2];
            AnyType anyType = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Integer.class), false));
            if (anyType == null) {
                anyType = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.webview.DomWebViewModule$definition$lambda$6$$inlined$AsyncFunction$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Integer.TYPE);
                    }
                }), converters);
            }
            anyTypeArr[0] = anyType;
            AnyType anyType2 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType2 == null) {
                anyType2 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.webview.DomWebViewModule$definition$lambda$6$$inlined$AsyncFunction$2
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }), converters);
            }
            anyTypeArr[1] = anyType2;
            moduleDefinitionBuilder2.getAsyncFunctions().put("evalJsForWebViewAsync", new UntypedAsyncFunctionComponent("evalJsForWebViewAsync", anyTypeArr, new Function1<Object[], Unit>() { // from class: expo.modules.webview.DomWebViewModule$definition$lambda$6$$inlined$AsyncFunction$3
                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Object obj = objArr[0];
                    String str = (String) objArr[1];
                    DomWebView domWebView = DomWebViewRegistry.INSTANCE.get(((Number) obj).intValue());
                    if (domWebView == null) {
                        return null;
                    }
                    domWebView.injectJavaScript(str);
                    return Unit.INSTANCE;
                }
            }));
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            ViewDefinitionBuilder viewDefinitionBuilder = new ViewDefinitionBuilder(Reflection.getOrCreateKotlinClass(DomWebView.class), new LazyKType(Reflection.getOrCreateKotlinClass(DomWebView.class), false, new Function0<KType>() { // from class: expo.modules.webview.DomWebViewModule$definition$lambda$6$$inlined$View$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(DomWebView.class);
                }
            }, 2, null), moduleDefinitionBuilder3.getConverters());
            CSSPropsKt.UseCSSProps(viewDefinitionBuilder);
            viewDefinitionBuilder.Events("onMessage");
            DomWebViewModule$definition$1$3$1 domWebViewModule$definition$1$3$1 = new Function2<DomWebView, DomWebViewSource, Unit>() { // from class: expo.modules.webview.DomWebViewModule$definition$1$3$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(DomWebView domWebView, DomWebViewSource domWebViewSource) {
                    invoke2(domWebView, domWebViewSource);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(DomWebView view, DomWebViewSource source) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(source, "source");
                    view.setSource(source);
                }
            };
            Map<String, AnyViewProp> props = viewDefinitionBuilder.getProps();
            AnyType anyType3 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(DomWebViewSource.class), false));
            if (anyType3 == null) {
                anyType3 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(DomWebViewSource.class), false, new Function0<KType>() { // from class: expo.modules.webview.DomWebViewModule$definition$lambda$6$lambda$5$$inlined$Prop$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(DomWebViewSource.class);
                    }
                }), null);
            }
            props.put("source", new ConcreteViewProp("source", anyType3, domWebViewModule$definition$1$3$1));
            DomWebViewModule$definition$1$3$2 domWebViewModule$definition$1$3$2 = new Function2<DomWebView, String, Unit>() { // from class: expo.modules.webview.DomWebViewModule$definition$1$3$2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(DomWebView domWebView, String str) {
                    invoke2(domWebView, str);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(DomWebView view, String script) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(script, "script");
                    view.setInjectedJSBeforeContentLoaded(script);
                }
            };
            Map<String, AnyViewProp> props2 = viewDefinitionBuilder.getProps();
            AnyType anyType4 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType4 == null) {
                anyType4 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.webview.DomWebViewModule$definition$lambda$6$lambda$5$$inlined$Prop$2
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }), null);
            }
            props2.put("injectedJavaScriptBeforeContentLoaded", new ConcreteViewProp("injectedJavaScriptBeforeContentLoaded", anyType4, domWebViewModule$definition$1$3$2));
            DomWebViewModule$definition$1$3$3 domWebViewModule$definition$1$3$3 = new Function2<DomWebView, Boolean, Unit>() { // from class: expo.modules.webview.DomWebViewModule$definition$1$3$3
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(DomWebView domWebView, Boolean bool) {
                    invoke(domWebView, bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(DomWebView view, boolean z) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    view.setWebviewDebuggingEnabled(z);
                }
            };
            Map<String, AnyViewProp> props3 = viewDefinitionBuilder.getProps();
            AnyType anyType5 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Boolean.class), false));
            if (anyType5 == null) {
                anyType5 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Boolean.class), false, new Function0<KType>() { // from class: expo.modules.webview.DomWebViewModule$definition$lambda$6$lambda$5$$inlined$Prop$3
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Boolean.TYPE);
                    }
                }), null);
            }
            props3.put("webviewDebuggingEnabled", new ConcreteViewProp("webviewDebuggingEnabled", anyType5, domWebViewModule$definition$1$3$3));
            DomWebViewModule$definition$1$3$4 domWebViewModule$definition$1$3$4 = new Function2<DomWebView, Boolean, Unit>() { // from class: expo.modules.webview.DomWebViewModule$definition$1$3$4
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(DomWebView domWebView, Boolean bool) {
                    invoke(domWebView, bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(final DomWebView view, final boolean z) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    view.getWebView().post(new Runnable() { // from class: expo.modules.webview.DomWebViewModule$definition$1$3$4.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            view.getWebView().setHorizontalScrollBarEnabled(z);
                        }
                    });
                }
            };
            Map<String, AnyViewProp> props4 = viewDefinitionBuilder.getProps();
            AnyType anyType6 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Boolean.class), false));
            if (anyType6 == null) {
                anyType6 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Boolean.class), false, new Function0<KType>() { // from class: expo.modules.webview.DomWebViewModule$definition$lambda$6$lambda$5$$inlined$Prop$4
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Boolean.TYPE);
                    }
                }), null);
            }
            props4.put("showsHorizontalScrollIndicator", new ConcreteViewProp("showsHorizontalScrollIndicator", anyType6, domWebViewModule$definition$1$3$4));
            DomWebViewModule$definition$1$3$5 domWebViewModule$definition$1$3$5 = new Function2<DomWebView, Boolean, Unit>() { // from class: expo.modules.webview.DomWebViewModule$definition$1$3$5
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(DomWebView domWebView, Boolean bool) {
                    invoke(domWebView, bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(final DomWebView view, final boolean z) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    view.getWebView().post(new Runnable() { // from class: expo.modules.webview.DomWebViewModule$definition$1$3$5.1
                        @Override // java.lang.Runnable
                        public final void run() {
                            view.getWebView().setVerticalScrollBarEnabled(z);
                        }
                    });
                }
            };
            Map<String, AnyViewProp> props5 = viewDefinitionBuilder.getProps();
            AnyType anyType7 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Boolean.class), false));
            if (anyType7 == null) {
                anyType7 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Boolean.class), false, new Function0<KType>() { // from class: expo.modules.webview.DomWebViewModule$definition$lambda$6$lambda$5$$inlined$Prop$5
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Boolean.TYPE);
                    }
                }), null);
            }
            props5.put("showsVerticalScrollIndicator", new ConcreteViewProp("showsVerticalScrollIndicator", anyType7, domWebViewModule$definition$1$3$5));
            DomWebViewModule$definition$1$3$6 domWebViewModule$definition$1$3$6 = new Function2<DomWebView, Boolean, Unit>() { // from class: expo.modules.webview.DomWebViewModule$definition$1$3$6
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(DomWebView domWebView, Boolean bool) {
                    invoke(domWebView, bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(DomWebView view, boolean z) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    view.setNestedScrollEnabled(z);
                }
            };
            Map<String, AnyViewProp> props6 = viewDefinitionBuilder.getProps();
            AnyType anyType8 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Boolean.class), false));
            if (anyType8 == null) {
                anyType8 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Boolean.class), false, new Function0<KType>() { // from class: expo.modules.webview.DomWebViewModule$definition$lambda$6$lambda$5$$inlined$Prop$6
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Boolean.TYPE);
                    }
                }), null);
            }
            props6.put("nestedScrollEnabled", new ConcreteViewProp("nestedScrollEnabled", anyType8, domWebViewModule$definition$1$3$6));
            TypeConverterProvider converters2 = viewDefinitionBuilder.getConverters();
            AnyType[] anyTypeArr2 = new AnyType[2];
            AnyType anyType9 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(DomWebView.class), false));
            if (anyType9 == null) {
                anyType9 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(DomWebView.class), false, new Function0<KType>() { // from class: expo.modules.webview.DomWebViewModule$definition$lambda$6$lambda$5$$inlined$AsyncFunction$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(DomWebView.class);
                    }
                }), converters2);
            }
            anyTypeArr2[0] = anyType9;
            AnyType anyType10 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(ScrollToParam.class), false));
            if (anyType10 == null) {
                anyType10 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(ScrollToParam.class), false, new Function0<KType>() { // from class: expo.modules.webview.DomWebViewModule$definition$lambda$6$lambda$5$$inlined$AsyncFunction$2
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(ScrollToParam.class);
                    }
                }), converters2);
            }
            anyTypeArr2[1] = anyType10;
            Function1<Object[], Unit> function1 = new Function1<Object[], Unit>() { // from class: expo.modules.webview.DomWebViewModule$definition$lambda$6$lambda$5$$inlined$AsyncFunction$3
                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    ((DomWebView) objArr[0]).scrollTo((ScrollToParam) objArr[1]);
                    return Unit.INSTANCE;
                }
            };
            if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Unit.class, String.class)) {
                                untypedAsyncFunctionComponent = new StringAsyncFunctionComponent("scrollTo", anyTypeArr2, function1);
                            } else {
                                untypedAsyncFunctionComponent = new UntypedAsyncFunctionComponent("scrollTo", anyTypeArr2, function1);
                            }
                        } else {
                            untypedAsyncFunctionComponent = new FloatAsyncFunctionComponent("scrollTo", anyTypeArr2, function1);
                        }
                    } else {
                        untypedAsyncFunctionComponent = new DoubleAsyncFunctionComponent("scrollTo", anyTypeArr2, function1);
                    }
                } else {
                    untypedAsyncFunctionComponent = new BoolAsyncFunctionComponent("scrollTo", anyTypeArr2, function1);
                }
            } else {
                untypedAsyncFunctionComponent = new IntAsyncFunctionComponent("scrollTo", anyTypeArr2, function1);
            }
            viewDefinitionBuilder.getAsyncFunctions().put("scrollTo", untypedAsyncFunctionComponent);
            TypeConverterProvider converters3 = viewDefinitionBuilder.getConverters();
            AnyType[] anyTypeArr3 = new AnyType[2];
            AnyType anyType11 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(DomWebView.class), false));
            if (anyType11 == null) {
                anyType11 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(DomWebView.class), false, new Function0<KType>() { // from class: expo.modules.webview.DomWebViewModule$definition$lambda$6$lambda$5$$inlined$AsyncFunction$4
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(DomWebView.class);
                    }
                }), converters3);
            }
            anyTypeArr3[0] = anyType11;
            AnyType anyType12 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType12 == null) {
                anyType12 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.webview.DomWebViewModule$definition$lambda$6$lambda$5$$inlined$AsyncFunction$5
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }), converters3);
            }
            anyTypeArr3[1] = anyType12;
            Function1<Object[], Unit> function2 = new Function1<Object[], Unit>() { // from class: expo.modules.webview.DomWebViewModule$definition$lambda$6$lambda$5$$inlined$AsyncFunction$6
                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    ((DomWebView) objArr[0]).injectJavaScript((String) objArr[1]);
                    return Unit.INSTANCE;
                }
            };
            if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Unit.class, String.class)) {
                                untypedAsyncFunctionComponent2 = new StringAsyncFunctionComponent("injectJavaScript", anyTypeArr3, function2);
                            } else {
                                untypedAsyncFunctionComponent2 = new UntypedAsyncFunctionComponent("injectJavaScript", anyTypeArr3, function2);
                            }
                        } else {
                            untypedAsyncFunctionComponent2 = new FloatAsyncFunctionComponent("injectJavaScript", anyTypeArr3, function2);
                        }
                    } else {
                        untypedAsyncFunctionComponent2 = new DoubleAsyncFunctionComponent("injectJavaScript", anyTypeArr3, function2);
                    }
                } else {
                    untypedAsyncFunctionComponent2 = new BoolAsyncFunctionComponent("injectJavaScript", anyTypeArr3, function2);
                }
            } else {
                untypedAsyncFunctionComponent2 = new IntAsyncFunctionComponent("injectJavaScript", anyTypeArr3, function2);
            }
            viewDefinitionBuilder.getAsyncFunctions().put("injectJavaScript", untypedAsyncFunctionComponent2);
            viewDefinitionBuilder.setOnViewDidUpdateProps(new Function1<View, Unit>() { // from class: expo.modules.webview.DomWebViewModule$definition$lambda$6$lambda$5$$inlined$OnViewDidUpdateProps$1
                @Override // kotlin.jvm.functions.Function1
                public /* bridge */ /* synthetic */ Unit invoke(View view) {
                    invoke2(view);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(View it) {
                    Intrinsics.checkNotNullParameter(it, "it");
                    ((DomWebView) it).reload();
                }
            });
            moduleDefinitionBuilder3.registerViewDefinition(viewDefinitionBuilder.build());
            return moduleDefinitionBuilder.buildModule();
        } finally {
            Trace.endSection();
        }
    }
}

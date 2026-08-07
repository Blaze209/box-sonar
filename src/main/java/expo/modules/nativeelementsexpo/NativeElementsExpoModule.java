package expo.modules.nativeelementsexpo;

import android.view.View;
import android.view.ViewGroup;
import androidx.tracing.Trace;
import com.box.android.base.presentation.components.commentbar.CommentBarInputBoxKt;
import com.box.android.domain.metrics.hubs.HubsObservability;
import com.box.android.observability.DiagnosisParams;
import com.box.androidsdk.content.models.BoxClassification;
import com.facebook.react.uimanager.ViewProps;
import com.facebook.react.views.textinput.ReactTextInputShadowNode;
import expo.modules.kotlin.Promise;
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
import expo.modules.kotlin.views.AnyViewProp;
import expo.modules.kotlin.views.ConcreteViewProp;
import expo.modules.kotlin.views.ViewDefinitionBuilder;
import expo.modules.kotlin.views.ViewGroupDefinitionBuilder;
import expo.modules.kotlin.views.decorators.CSSPropsKt;
import expo.modules.nativeelementsexpo.keyboardavoidingview.NativeKeyboardAvoidingView;
import expo.modules.nativeelementsexpo.promptinput.PromptInputView;
import expo.modules.nativeelementsexpo.promptinput.TriggerConfig;
import expo.modules.nativeelementsexpo.promptinput.tag.TagType;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.reflect.KType;
import kotlin.reflect.KTypeProjection;
import kotlin.text.StringsKt;

/* JADX INFO: compiled from: NativeElementsExpoModule.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, d2 = {"Lexpo/modules/nativeelementsexpo/NativeElementsExpoModule;", "Lexpo/modules/kotlin/modules/Module;", "<init>", "()V", BoxClassification.FIELD_DEFINITION, "Lexpo/modules/kotlin/modules/ModuleDefinitionData;", "cirrus-native-elements-expo_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class NativeElementsExpoModule extends Module {
    public static final int $stable = Module.$stable;

    @Override // expo.modules.kotlin.modules.Module
    public ModuleDefinitionData definition() {
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent2;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent2;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent3;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent3;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent4;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent5;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent6;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent7;
        AsyncFunctionWithPromiseComponent asyncFunctionWithPromiseComponent4;
        UntypedAsyncFunctionComponent untypedAsyncFunctionComponent8;
        NativeElementsExpoModule nativeElementsExpoModule = this;
        Trace.beginSection("[ExpoModulesCore] " + (nativeElementsExpoModule.getClass() + ".ModuleDefinition"));
        try {
            ModuleDefinitionBuilder moduleDefinitionBuilder = new ModuleDefinitionBuilder(nativeElementsExpoModule);
            moduleDefinitionBuilder.Name("NativeElementsExpo");
            ModuleDefinitionBuilder moduleDefinitionBuilder2 = moduleDefinitionBuilder;
            ViewDefinitionBuilder viewDefinitionBuilder = new ViewDefinitionBuilder(Reflection.getOrCreateKotlinClass(MenuNativeView.class), new LazyKType(Reflection.getOrCreateKotlinClass(MenuNativeView.class), false, new Function0<KType>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$$inlined$View$1
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(MenuNativeView.class);
                }
            }, 2, null), moduleDefinitionBuilder2.getConverters());
            CSSPropsKt.UseCSSProps(viewDefinitionBuilder);
            viewDefinitionBuilder.Events("onMenuOpen", "onMenuDismiss");
            Intrinsics.areEqual(viewDefinitionBuilder.getViewClass(), Reflection.getOrCreateKotlinClass(MenuNativeView.class));
            if (viewDefinitionBuilder.getViewGroupDefinition() != null) {
                throw new IllegalArgumentException("The viewManager definition may have exported only one groupView definition.".toString());
            }
            ViewGroupDefinitionBuilder viewGroupDefinitionBuilder = new ViewGroupDefinitionBuilder();
            viewGroupDefinitionBuilder.setAddViewAction(new Function3<ViewGroup, View, Integer, Unit>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$lambda$5$lambda$4$$inlined$AddChildView$1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(ViewGroup viewGroup, View view, Integer num) {
                    invoke(viewGroup, view, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ViewGroup parent, View child, int i) {
                    Intrinsics.checkNotNullParameter(parent, "parent");
                    Intrinsics.checkNotNullParameter(child, "child");
                    ((MenuNativeView) parent).addChild(child, i);
                }
            });
            viewGroupDefinitionBuilder.setGetChildCountAction(new Function1<ViewGroup, Integer>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$lambda$5$lambda$4$$inlined$GetChildCount$1
                @Override // kotlin.jvm.functions.Function1
                public final Integer invoke(ViewGroup view) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    return Integer.valueOf(((MenuNativeView) view).getChildCount());
                }
            });
            viewGroupDefinitionBuilder.setGetChildAtAction(new Function2<ViewGroup, Integer, View>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$lambda$5$lambda$4$$inlined$GetChildViewAt$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ View invoke(ViewGroup viewGroup, Integer num) {
                    return invoke(viewGroup, num.intValue());
                }

                public final View invoke(ViewGroup view, int i) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    return ((MenuNativeView) view).getChildAt(i);
                }
            });
            final NativeElementsExpoModule$definition$1$1$1$4 nativeElementsExpoModule$definition$1$1$1$4 = new Function2<MenuNativeView, View, Unit>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$1$1$1$4
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(MenuNativeView menuNativeView, View view) {
                    invoke2(menuNativeView, view);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(MenuNativeView parent, View child) {
                    Intrinsics.checkNotNullParameter(parent, "parent");
                    Intrinsics.checkNotNullParameter(child, "child");
                    parent.removeChild(child);
                }
            };
            viewGroupDefinitionBuilder.setRemoveViewAction(new Function2<ViewGroup, View, Unit>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$lambda$5$lambda$4$$inlined$RemoveChildView$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ViewGroup viewGroup, View view) {
                    invoke2(viewGroup, view);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ViewGroup view, View child) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(child, "child");
                    nativeElementsExpoModule$definition$1$1$1$4.invoke(view, child);
                }
            });
            viewGroupDefinitionBuilder.setRemoveViewAtAction(new Function2<ViewGroup, Integer, Unit>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$lambda$5$lambda$4$$inlined$RemoveChildViewAt$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ViewGroup viewGroup, Integer num) {
                    invoke(viewGroup, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ViewGroup view, int i) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    ((MenuNativeView) view).removeChildAt(i);
                }
            });
            viewDefinitionBuilder.setViewGroupDefinition(viewGroupDefinitionBuilder.build());
            moduleDefinitionBuilder2.registerViewDefinition(viewDefinitionBuilder.build());
            ModuleDefinitionBuilder moduleDefinitionBuilder3 = moduleDefinitionBuilder;
            ViewDefinitionBuilder viewDefinitionBuilder2 = new ViewDefinitionBuilder(Reflection.getOrCreateKotlinClass(ContextMenuView.class), new LazyKType(Reflection.getOrCreateKotlinClass(ContextMenuView.class), false, new Function0<KType>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$$inlined$View$2
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(ContextMenuView.class);
                }
            }, 2, null), moduleDefinitionBuilder3.getConverters());
            CSSPropsKt.UseCSSProps(viewDefinitionBuilder2);
            Intrinsics.areEqual(viewDefinitionBuilder2.getViewClass(), Reflection.getOrCreateKotlinClass(ContextMenuView.class));
            if (viewDefinitionBuilder2.getViewGroupDefinition() != null) {
                throw new IllegalArgumentException("The viewManager definition may have exported only one groupView definition.".toString());
            }
            ViewGroupDefinitionBuilder viewGroupDefinitionBuilder2 = new ViewGroupDefinitionBuilder();
            viewGroupDefinitionBuilder2.setAddViewAction(new Function3<ViewGroup, View, Integer, Unit>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$lambda$11$lambda$10$$inlined$AddChildView$1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(ViewGroup viewGroup, View view, Integer num) {
                    invoke(viewGroup, view, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ViewGroup parent, View child, int i) {
                    Intrinsics.checkNotNullParameter(parent, "parent");
                    Intrinsics.checkNotNullParameter(child, "child");
                    ((ContextMenuView) parent).addChild(child, i);
                }
            });
            viewGroupDefinitionBuilder2.setGetChildCountAction(new Function1<ViewGroup, Integer>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$lambda$11$lambda$10$$inlined$GetChildCount$1
                @Override // kotlin.jvm.functions.Function1
                public final Integer invoke(ViewGroup view) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    return Integer.valueOf(((ContextMenuView) view).getChildCount());
                }
            });
            viewGroupDefinitionBuilder2.setGetChildAtAction(new Function2<ViewGroup, Integer, View>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$lambda$11$lambda$10$$inlined$GetChildViewAt$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ View invoke(ViewGroup viewGroup, Integer num) {
                    return invoke(viewGroup, num.intValue());
                }

                public final View invoke(ViewGroup view, int i) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    return ((ContextMenuView) view).getChildAt(i);
                }
            });
            final NativeElementsExpoModule$definition$1$2$1$4 nativeElementsExpoModule$definition$1$2$1$4 = new Function2<ContextMenuView, View, Unit>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$1$2$1$4
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ContextMenuView contextMenuView, View view) {
                    invoke2(contextMenuView, view);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ContextMenuView parent, View child) {
                    Intrinsics.checkNotNullParameter(parent, "parent");
                    Intrinsics.checkNotNullParameter(child, "child");
                    parent.removeChild(child);
                }
            };
            viewGroupDefinitionBuilder2.setRemoveViewAction(new Function2<ViewGroup, View, Unit>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$lambda$11$lambda$10$$inlined$RemoveChildView$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ViewGroup viewGroup, View view) {
                    invoke2(viewGroup, view);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ViewGroup view, View child) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(child, "child");
                    nativeElementsExpoModule$definition$1$2$1$4.invoke(view, child);
                }
            });
            viewGroupDefinitionBuilder2.setRemoveViewAtAction(new Function2<ViewGroup, Integer, Unit>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$lambda$11$lambda$10$$inlined$RemoveChildViewAt$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ViewGroup viewGroup, Integer num) {
                    invoke(viewGroup, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ViewGroup view, int i) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    ((ContextMenuView) view).removeChildAt(i);
                }
            });
            viewDefinitionBuilder2.setViewGroupDefinition(viewGroupDefinitionBuilder2.build());
            moduleDefinitionBuilder3.registerViewDefinition(viewDefinitionBuilder2.build());
            ModuleDefinitionBuilder moduleDefinitionBuilder4 = moduleDefinitionBuilder;
            ViewDefinitionBuilder viewDefinitionBuilder3 = new ViewDefinitionBuilder(Reflection.getOrCreateKotlinClass(ContextMenuPreviewView.class), new LazyKType(Reflection.getOrCreateKotlinClass(ContextMenuPreviewView.class), false, new Function0<KType>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$$inlined$View$3
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(ContextMenuPreviewView.class);
                }
            }, 2, null), moduleDefinitionBuilder4.getConverters());
            CSSPropsKt.UseCSSProps(viewDefinitionBuilder3);
            moduleDefinitionBuilder4.registerViewDefinition(viewDefinitionBuilder3.build());
            ModuleDefinitionBuilder moduleDefinitionBuilder5 = moduleDefinitionBuilder;
            ViewDefinitionBuilder viewDefinitionBuilder4 = new ViewDefinitionBuilder(Reflection.getOrCreateKotlinClass(SubmenuNativeView.class), new LazyKType(Reflection.getOrCreateKotlinClass(SubmenuNativeView.class), false, new Function0<KType>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$$inlined$View$4
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(SubmenuNativeView.class);
                }
            }, 2, null), moduleDefinitionBuilder5.getConverters());
            CSSPropsKt.UseCSSProps(viewDefinitionBuilder4);
            NativeElementsExpoModule$definition$1$4$1 nativeElementsExpoModule$definition$1$4$1 = new Function2<SubmenuNativeView, String, Unit>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$1$4$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(SubmenuNativeView submenuNativeView, String str) {
                    invoke2(submenuNativeView, str);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SubmenuNativeView view, String title) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(title, "title");
                    view.setTitle(title);
                }
            };
            Map<String, AnyViewProp> props = viewDefinitionBuilder4.getProps();
            AnyType anyType = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType == null) {
                anyType = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$lambda$18$$inlined$Prop$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }), null);
            }
            props.put("title", new ConcreteViewProp("title", anyType, nativeElementsExpoModule$definition$1$4$1));
            NativeElementsExpoModule$definition$1$4$2 nativeElementsExpoModule$definition$1$4$2 = new Function2<SubmenuNativeView, String, Unit>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$1$4$2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(SubmenuNativeView submenuNativeView, String str) {
                    invoke2(submenuNativeView, str);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SubmenuNativeView view, String mode) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(mode, "mode");
                    view.setMode(mode);
                }
            };
            Map<String, AnyViewProp> props2 = viewDefinitionBuilder4.getProps();
            AnyType anyType2 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType2 == null) {
                anyType2 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$lambda$18$$inlined$Prop$2
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }), null);
            }
            props2.put(DiagnosisParams.DIAGNOSIS_MODE, new ConcreteViewProp(DiagnosisParams.DIAGNOSIS_MODE, anyType2, nativeElementsExpoModule$definition$1$4$2));
            NativeElementsExpoModule$definition$1$4$3 nativeElementsExpoModule$definition$1$4$3 = new Function2<SubmenuNativeView, Boolean, Unit>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$1$4$3
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(SubmenuNativeView submenuNativeView, Boolean bool) {
                    invoke(submenuNativeView, bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(SubmenuNativeView view, boolean z) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    view.setDisabled(z);
                }
            };
            Map<String, AnyViewProp> props3 = viewDefinitionBuilder4.getProps();
            AnyType anyType3 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Boolean.class), false));
            if (anyType3 == null) {
                anyType3 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Boolean.class), false, new Function0<KType>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$lambda$18$$inlined$Prop$3
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Boolean.TYPE);
                    }
                }), null);
            }
            props3.put("disabled", new ConcreteViewProp("disabled", anyType3, nativeElementsExpoModule$definition$1$4$3));
            NativeElementsExpoModule$definition$1$4$4 nativeElementsExpoModule$definition$1$4$4 = new Function2<SubmenuNativeView, Integer, Unit>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$1$4$4
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(SubmenuNativeView submenuNativeView, Integer num) {
                    invoke(submenuNativeView, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(SubmenuNativeView view, int i) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    view.setSectionTitleColor(Integer.valueOf(i));
                }
            };
            Map<String, AnyViewProp> props4 = viewDefinitionBuilder4.getProps();
            AnyType anyType4 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Integer.class), false));
            if (anyType4 == null) {
                anyType4 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$lambda$18$$inlined$Prop$4
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Integer.TYPE);
                    }
                }), null);
            }
            props4.put("sectionTitleColor", new ConcreteViewProp("sectionTitleColor", anyType4, nativeElementsExpoModule$definition$1$4$4));
            Intrinsics.areEqual(viewDefinitionBuilder4.getViewClass(), Reflection.getOrCreateKotlinClass(SubmenuNativeView.class));
            if (viewDefinitionBuilder4.getViewGroupDefinition() != null) {
                throw new IllegalArgumentException("The viewManager definition may have exported only one groupView definition.".toString());
            }
            ViewGroupDefinitionBuilder viewGroupDefinitionBuilder3 = new ViewGroupDefinitionBuilder();
            viewGroupDefinitionBuilder3.setAddViewAction(new Function3<ViewGroup, View, Integer, Unit>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$lambda$18$lambda$17$$inlined$AddChildView$1
                @Override // kotlin.jvm.functions.Function3
                public /* bridge */ /* synthetic */ Unit invoke(ViewGroup viewGroup, View view, Integer num) {
                    invoke(viewGroup, view, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ViewGroup parent, View child, int i) {
                    Intrinsics.checkNotNullParameter(parent, "parent");
                    Intrinsics.checkNotNullParameter(child, "child");
                    ((SubmenuNativeView) parent).addChild(child, i);
                }
            });
            viewGroupDefinitionBuilder3.setGetChildCountAction(new Function1<ViewGroup, Integer>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$lambda$18$lambda$17$$inlined$GetChildCount$1
                @Override // kotlin.jvm.functions.Function1
                public final Integer invoke(ViewGroup view) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    return Integer.valueOf(((SubmenuNativeView) view).getChildCount());
                }
            });
            viewGroupDefinitionBuilder3.setGetChildAtAction(new Function2<ViewGroup, Integer, View>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$lambda$18$lambda$17$$inlined$GetChildViewAt$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ View invoke(ViewGroup viewGroup, Integer num) {
                    return invoke(viewGroup, num.intValue());
                }

                public final View invoke(ViewGroup view, int i) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    return ((SubmenuNativeView) view).getChildAt(i);
                }
            });
            final NativeElementsExpoModule$definition$1$4$5$4 nativeElementsExpoModule$definition$1$4$5$4 = new Function2<SubmenuNativeView, View, Unit>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$1$4$5$4
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(SubmenuNativeView submenuNativeView, View view) {
                    invoke2(submenuNativeView, view);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(SubmenuNativeView parent, View child) {
                    Intrinsics.checkNotNullParameter(parent, "parent");
                    Intrinsics.checkNotNullParameter(child, "child");
                    parent.removeChild(child);
                }
            };
            viewGroupDefinitionBuilder3.setRemoveViewAction(new Function2<ViewGroup, View, Unit>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$lambda$18$lambda$17$$inlined$RemoveChildView$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ViewGroup viewGroup, View view) {
                    invoke2(viewGroup, view);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(ViewGroup view, View child) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(child, "child");
                    nativeElementsExpoModule$definition$1$4$5$4.invoke(view, child);
                }
            });
            viewGroupDefinitionBuilder3.setRemoveViewAtAction(new Function2<ViewGroup, Integer, Unit>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$lambda$18$lambda$17$$inlined$RemoveChildViewAt$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(ViewGroup viewGroup, Integer num) {
                    invoke(viewGroup, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(ViewGroup view, int i) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    ((SubmenuNativeView) view).removeChildAt(i);
                }
            });
            viewDefinitionBuilder4.setViewGroupDefinition(viewGroupDefinitionBuilder3.build());
            moduleDefinitionBuilder5.registerViewDefinition(viewDefinitionBuilder4.build());
            ModuleDefinitionBuilder moduleDefinitionBuilder6 = moduleDefinitionBuilder;
            ViewDefinitionBuilder viewDefinitionBuilder5 = new ViewDefinitionBuilder(Reflection.getOrCreateKotlinClass(MenuActionNativeView.class), new LazyKType(Reflection.getOrCreateKotlinClass(MenuActionNativeView.class), false, new Function0<KType>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$$inlined$View$5
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(MenuActionNativeView.class);
                }
            }, 2, null), moduleDefinitionBuilder6.getConverters());
            CSSPropsKt.UseCSSProps(viewDefinitionBuilder5);
            viewDefinitionBuilder5.Events("onSelected");
            NativeElementsExpoModule$definition$1$5$1 nativeElementsExpoModule$definition$1$5$1 = new Function2<MenuActionNativeView, String, Unit>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$1$5$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(MenuActionNativeView menuActionNativeView, String str) {
                    invoke2(menuActionNativeView, str);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(MenuActionNativeView view, String title) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(title, "title");
                    view.setTitle(title);
                }
            };
            Map<String, AnyViewProp> props5 = viewDefinitionBuilder5.getProps();
            AnyType anyType5 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType5 == null) {
                anyType5 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$lambda$19$$inlined$Prop$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }), null);
            }
            props5.put("title", new ConcreteViewProp("title", anyType5, nativeElementsExpoModule$definition$1$5$1));
            NativeElementsExpoModule$definition$1$5$2 nativeElementsExpoModule$definition$1$5$2 = new Function2<MenuActionNativeView, Boolean, Unit>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$1$5$2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(MenuActionNativeView menuActionNativeView, Boolean bool) {
                    invoke(menuActionNativeView, bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(MenuActionNativeView view, boolean z) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    view.setDisabled(z);
                }
            };
            Map<String, AnyViewProp> props6 = viewDefinitionBuilder5.getProps();
            AnyType anyType6 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Boolean.class), false));
            if (anyType6 == null) {
                anyType6 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Boolean.class), false, new Function0<KType>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$lambda$19$$inlined$Prop$2
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Boolean.TYPE);
                    }
                }), null);
            }
            props6.put("disabled", new ConcreteViewProp("disabled", anyType6, nativeElementsExpoModule$definition$1$5$2));
            NativeElementsExpoModule$definition$1$5$3 nativeElementsExpoModule$definition$1$5$3 = new Function2<MenuActionNativeView, Boolean, Unit>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$1$5$3
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(MenuActionNativeView menuActionNativeView, Boolean bool) {
                    invoke(menuActionNativeView, bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(MenuActionNativeView view, boolean z) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    view.setDestructive(z);
                }
            };
            Map<String, AnyViewProp> props7 = viewDefinitionBuilder5.getProps();
            AnyType anyType7 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Boolean.class), false));
            if (anyType7 == null) {
                anyType7 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Boolean.class), false, new Function0<KType>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$lambda$19$$inlined$Prop$3
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Boolean.TYPE);
                    }
                }), null);
            }
            props7.put("destructive", new ConcreteViewProp("destructive", anyType7, nativeElementsExpoModule$definition$1$5$3));
            NativeElementsExpoModule$definition$1$5$4 nativeElementsExpoModule$definition$1$5$4 = new Function2<MenuActionNativeView, Boolean, Unit>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$1$5$4
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(MenuActionNativeView menuActionNativeView, Boolean bool) {
                    invoke2(menuActionNativeView, bool);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(MenuActionNativeView view, Boolean bool) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    view.setChecked(bool);
                }
            };
            Map<String, AnyViewProp> props8 = viewDefinitionBuilder5.getProps();
            AnyType anyType8 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Boolean.class), true));
            if (anyType8 == null) {
                anyType8 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Boolean.class), true, new Function0<KType>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$lambda$19$$inlined$Prop$4
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.nullableTypeOf(Boolean.class);
                    }
                }), null);
            }
            props8.put("checked", new ConcreteViewProp("checked", anyType8, nativeElementsExpoModule$definition$1$5$4));
            NativeElementsExpoModule$definition$1$5$5 nativeElementsExpoModule$definition$1$5$5 = new Function2<MenuActionNativeView, Integer, Unit>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$1$5$5
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(MenuActionNativeView menuActionNativeView, Integer num) {
                    invoke(menuActionNativeView, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(MenuActionNativeView view, int i) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    view.setDestructiveColor(Integer.valueOf(i));
                }
            };
            Map<String, AnyViewProp> props9 = viewDefinitionBuilder5.getProps();
            AnyType anyType9 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Integer.class), false));
            if (anyType9 == null) {
                anyType9 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$lambda$19$$inlined$Prop$5
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Integer.TYPE);
                    }
                }), null);
            }
            props9.put("destructiveColor", new ConcreteViewProp("destructiveColor", anyType9, nativeElementsExpoModule$definition$1$5$5));
            NativeElementsExpoModule$definition$1$5$6 nativeElementsExpoModule$definition$1$5$6 = new Function2<MenuActionNativeView, String, Unit>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$1$5$6
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(MenuActionNativeView menuActionNativeView, String str) {
                    invoke2(menuActionNativeView, str);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(MenuActionNativeView view, String str) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    view.setIcon(str);
                }
            };
            Map<String, AnyViewProp> props10 = viewDefinitionBuilder5.getProps();
            AnyType anyType10 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), true));
            if (anyType10 == null) {
                anyType10 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), true, new Function0<KType>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$lambda$19$$inlined$Prop$6
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.nullableTypeOf(String.class);
                    }
                }), null);
            }
            props10.put(HubsObservability.HUB_ASSET_ICON, new ConcreteViewProp(HubsObservability.HUB_ASSET_ICON, anyType10, nativeElementsExpoModule$definition$1$5$6));
            NativeElementsExpoModule$definition$1$5$7 nativeElementsExpoModule$definition$1$5$7 = new Function2<MenuActionNativeView, Integer, Unit>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$1$5$7
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(MenuActionNativeView menuActionNativeView, Integer num) {
                    invoke(menuActionNativeView, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(MenuActionNativeView view, int i) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    view.setTextColor(Integer.valueOf(i));
                }
            };
            Map<String, AnyViewProp> props11 = viewDefinitionBuilder5.getProps();
            AnyType anyType11 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Integer.class), false));
            if (anyType11 == null) {
                anyType11 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$lambda$19$$inlined$Prop$7
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Integer.TYPE);
                    }
                }), null);
            }
            props11.put("textColor", new ConcreteViewProp("textColor", anyType11, nativeElementsExpoModule$definition$1$5$7));
            NativeElementsExpoModule$definition$1$5$8 nativeElementsExpoModule$definition$1$5$8 = new Function2<MenuActionNativeView, Integer, Unit>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$1$5$8
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(MenuActionNativeView menuActionNativeView, Integer num) {
                    invoke(menuActionNativeView, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(MenuActionNativeView view, int i) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    view.setDisabledTextColor(Integer.valueOf(i));
                }
            };
            Map<String, AnyViewProp> props12 = viewDefinitionBuilder5.getProps();
            AnyType anyType12 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Integer.class), false));
            if (anyType12 == null) {
                anyType12 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$lambda$19$$inlined$Prop$8
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Integer.TYPE);
                    }
                }), null);
            }
            props12.put("disabledTextColor", new ConcreteViewProp("disabledTextColor", anyType12, nativeElementsExpoModule$definition$1$5$8));
            moduleDefinitionBuilder6.registerViewDefinition(viewDefinitionBuilder5.build());
            ModuleDefinitionBuilder moduleDefinitionBuilder7 = moduleDefinitionBuilder;
            ViewDefinitionBuilder viewDefinitionBuilder6 = new ViewDefinitionBuilder(Reflection.getOrCreateKotlinClass(NativeKeyboardAvoidingView.class), new LazyKType(Reflection.getOrCreateKotlinClass(NativeKeyboardAvoidingView.class), false, new Function0<KType>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$$inlined$View$6
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(NativeKeyboardAvoidingView.class);
                }
            }, 2, null), moduleDefinitionBuilder7.getConverters());
            CSSPropsKt.UseCSSProps(viewDefinitionBuilder6);
            viewDefinitionBuilder6.Events("onKeyboardHeightChange");
            moduleDefinitionBuilder7.registerViewDefinition(viewDefinitionBuilder6.build());
            ModuleDefinitionBuilder moduleDefinitionBuilder8 = moduleDefinitionBuilder;
            ViewDefinitionBuilder viewDefinitionBuilder7 = new ViewDefinitionBuilder(Reflection.getOrCreateKotlinClass(PromptInputView.class), new LazyKType(Reflection.getOrCreateKotlinClass(PromptInputView.class), false, new Function0<KType>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$$inlined$View$7
                @Override // kotlin.jvm.functions.Function0
                public final KType invoke() {
                    return Reflection.typeOf(PromptInputView.class);
                }
            }, 2, null), moduleDefinitionBuilder8.getConverters());
            CSSPropsKt.UseCSSProps(viewDefinitionBuilder7);
            NativeElementsExpoModule$definition$1$7$1 nativeElementsExpoModule$definition$1$7$1 = new Function2<PromptInputView, String, Unit>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$1$7$1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(PromptInputView promptInputView, String str) {
                    invoke2(promptInputView, str);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(PromptInputView view, String placeholder) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(placeholder, "placeholder");
                    view.setPlaceholder(placeholder);
                }
            };
            Map<String, AnyViewProp> props13 = viewDefinitionBuilder7.getProps();
            AnyType anyType13 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType13 == null) {
                anyType13 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$lambda$29$$inlined$Prop$1
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }), null);
            }
            props13.put(ReactTextInputShadowNode.PROP_PLACEHOLDER, new ConcreteViewProp(ReactTextInputShadowNode.PROP_PLACEHOLDER, anyType13, nativeElementsExpoModule$definition$1$7$1));
            NativeElementsExpoModule$definition$1$7$2 nativeElementsExpoModule$definition$1$7$2 = new Function2<PromptInputView, Boolean, Unit>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$1$7$2
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(PromptInputView promptInputView, Boolean bool) {
                    invoke(promptInputView, bool.booleanValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(PromptInputView view, boolean z) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    view.setDisabled(z);
                }
            };
            Map<String, AnyViewProp> props14 = viewDefinitionBuilder7.getProps();
            AnyType anyType14 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Boolean.class), false));
            if (anyType14 == null) {
                anyType14 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Boolean.class), false, new Function0<KType>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$lambda$29$$inlined$Prop$2
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Boolean.TYPE);
                    }
                }), null);
            }
            props14.put("disabled", new ConcreteViewProp("disabled", anyType14, nativeElementsExpoModule$definition$1$7$2));
            NativeElementsExpoModule$definition$1$7$3 nativeElementsExpoModule$definition$1$7$3 = new Function2<PromptInputView, Integer, Unit>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$1$7$3
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(PromptInputView promptInputView, Integer num) {
                    invoke(promptInputView, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(PromptInputView view, int i) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    view.setMaxHeight(i);
                }
            };
            Map<String, AnyViewProp> props15 = viewDefinitionBuilder7.getProps();
            AnyType anyType15 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Integer.class), false));
            if (anyType15 == null) {
                anyType15 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$lambda$29$$inlined$Prop$3
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Integer.TYPE);
                    }
                }), null);
            }
            props15.put(ViewProps.MAX_HEIGHT, new ConcreteViewProp(ViewProps.MAX_HEIGHT, anyType15, nativeElementsExpoModule$definition$1$7$3));
            NativeElementsExpoModule$definition$1$7$4 nativeElementsExpoModule$definition$1$7$4 = new Function2<PromptInputView, Integer, Unit>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$1$7$4
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(PromptInputView promptInputView, Integer num) {
                    invoke(promptInputView, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(PromptInputView view, int i) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    view.setTextColor(i);
                }
            };
            Map<String, AnyViewProp> props16 = viewDefinitionBuilder7.getProps();
            AnyType anyType16 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Integer.class), false));
            if (anyType16 == null) {
                anyType16 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$lambda$29$$inlined$Prop$4
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Integer.TYPE);
                    }
                }), null);
            }
            props16.put("textColor", new ConcreteViewProp("textColor", anyType16, nativeElementsExpoModule$definition$1$7$4));
            NativeElementsExpoModule$definition$1$7$5 nativeElementsExpoModule$definition$1$7$5 = new Function2<PromptInputView, Integer, Unit>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$1$7$5
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(PromptInputView promptInputView, Integer num) {
                    invoke(promptInputView, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(PromptInputView view, int i) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    view.setTokenBackgroundColor(i);
                }
            };
            Map<String, AnyViewProp> props17 = viewDefinitionBuilder7.getProps();
            AnyType anyType17 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Integer.class), false));
            if (anyType17 == null) {
                anyType17 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$lambda$29$$inlined$Prop$5
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Integer.TYPE);
                    }
                }), null);
            }
            props17.put("tokenBackgroundColor", new ConcreteViewProp("tokenBackgroundColor", anyType17, nativeElementsExpoModule$definition$1$7$5));
            NativeElementsExpoModule$definition$1$7$6 nativeElementsExpoModule$definition$1$7$6 = new Function2<PromptInputView, Integer, Unit>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$1$7$6
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(PromptInputView promptInputView, Integer num) {
                    invoke(promptInputView, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(PromptInputView view, int i) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    view.setPendingTokenBackgroundColor(i);
                }
            };
            Map<String, AnyViewProp> props18 = viewDefinitionBuilder7.getProps();
            AnyType anyType18 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Integer.class), false));
            if (anyType18 == null) {
                anyType18 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$lambda$29$$inlined$Prop$6
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Integer.TYPE);
                    }
                }), null);
            }
            props18.put("pendingTokenBackgroundColor", new ConcreteViewProp("pendingTokenBackgroundColor", anyType18, nativeElementsExpoModule$definition$1$7$6));
            NativeElementsExpoModule$definition$1$7$7 nativeElementsExpoModule$definition$1$7$7 = new Function2<PromptInputView, Integer, Unit>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$1$7$7
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(PromptInputView promptInputView, Integer num) {
                    invoke(promptInputView, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(PromptInputView view, int i) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    view.setTokenTextColor(i);
                }
            };
            Map<String, AnyViewProp> props19 = viewDefinitionBuilder7.getProps();
            AnyType anyType19 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Integer.class), false));
            if (anyType19 == null) {
                anyType19 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$lambda$29$$inlined$Prop$7
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Integer.TYPE);
                    }
                }), null);
            }
            props19.put("tokenTextColor", new ConcreteViewProp("tokenTextColor", anyType19, nativeElementsExpoModule$definition$1$7$7));
            NativeElementsExpoModule$definition$1$7$8 nativeElementsExpoModule$definition$1$7$8 = new Function2<PromptInputView, Integer, Unit>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$1$7$8
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(PromptInputView promptInputView, Integer num) {
                    invoke(promptInputView, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(PromptInputView view, int i) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    view.setPendingTokenTextColor(i);
                }
            };
            Map<String, AnyViewProp> props20 = viewDefinitionBuilder7.getProps();
            AnyType anyType20 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Integer.class), false));
            if (anyType20 == null) {
                anyType20 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$lambda$29$$inlined$Prop$8
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Integer.TYPE);
                    }
                }), null);
            }
            props20.put("pendingTokenTextColor", new ConcreteViewProp("pendingTokenTextColor", anyType20, nativeElementsExpoModule$definition$1$7$8));
            NativeElementsExpoModule$definition$1$7$9 nativeElementsExpoModule$definition$1$7$9 = new Function2<PromptInputView, Integer, Unit>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$1$7$9
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(PromptInputView promptInputView, Integer num) {
                    invoke(promptInputView, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(PromptInputView view, int i) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    view.setPlaceholderColor(i);
                }
            };
            Map<String, AnyViewProp> props21 = viewDefinitionBuilder7.getProps();
            AnyType anyType21 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(Integer.class), false));
            if (anyType21 == null) {
                anyType21 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(Integer.class), false, new Function0<KType>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$lambda$29$$inlined$Prop$9
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(Integer.TYPE);
                    }
                }), null);
            }
            props21.put("placeholderColor", new ConcreteViewProp("placeholderColor", anyType21, nativeElementsExpoModule$definition$1$7$9));
            NativeElementsExpoModule$definition$1$7$10 nativeElementsExpoModule$definition$1$7$10 = new Function2<PromptInputView, List<? extends TriggerCharacterRecord>, Unit>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$1$7$10
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(PromptInputView promptInputView, List<? extends TriggerCharacterRecord> list) {
                    invoke2(promptInputView, (List<TriggerCharacterRecord>) list);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(PromptInputView view, List<TriggerCharacterRecord> configs) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(configs, "configs");
                    List arrayList = new ArrayList();
                    for (TriggerCharacterRecord triggerCharacterRecord : configs) {
                        Character chFirstOrNull = StringsKt.firstOrNull(triggerCharacterRecord.getCharacter());
                        TriggerConfig triggerConfig = chFirstOrNull != null ? new TriggerConfig(chFirstOrNull.charValue(), triggerCharacterRecord.getMaxRange()) : null;
                        if (triggerConfig != null) {
                            arrayList.add(triggerConfig);
                        }
                    }
                    List listListOf = arrayList;
                    if (listListOf.isEmpty()) {
                        listListOf = CollectionsKt.listOf(new TriggerConfig(CommentBarInputBoxKt.MENTION_SYMBOL, 100));
                    }
                    view.setTriggerConfigs(listListOf);
                }
            };
            Map<String, AnyViewProp> props22 = viewDefinitionBuilder7.getProps();
            AnyType anyType22 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(List.class), false));
            if (anyType22 == null) {
                anyType22 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(List.class), false, new Function0<KType>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$lambda$29$$inlined$Prop$10
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(TriggerCharacterRecord.class)));
                    }
                }), null);
            }
            props22.put("triggerCharacters", new ConcreteViewProp("triggerCharacters", anyType22, nativeElementsExpoModule$definition$1$7$10));
            NativeElementsExpoModule$definition$1$7$11 nativeElementsExpoModule$definition$1$7$11 = new Function2<PromptInputView, List<? extends String>, Unit>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$1$7$11
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(PromptInputView promptInputView, List<? extends String> list) {
                    invoke2(promptInputView, (List<String>) list);
                    return Unit.INSTANCE;
                }

                /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                public final void invoke2(PromptInputView view, List<String> patterns) {
                    Intrinsics.checkNotNullParameter(view, "view");
                    Intrinsics.checkNotNullParameter(patterns, "patterns");
                    view.setTrackedItems(patterns);
                }
            };
            Map<String, AnyViewProp> props23 = viewDefinitionBuilder7.getProps();
            AnyType anyType23 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(List.class), false));
            if (anyType23 == null) {
                anyType23 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(List.class), false, new Function0<KType>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$lambda$29$$inlined$Prop$11
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(List.class, KTypeProjection.INSTANCE.invariant(Reflection.typeOf(String.class)));
                    }
                }), null);
            }
            props23.put("trackedItems", new ConcreteViewProp("trackedItems", anyType23, nativeElementsExpoModule$definition$1$7$11));
            viewDefinitionBuilder7.Events("onSubmit", "onHeightChange", "onDirtyChange", "onFocusChange", "onMentionShow", "onMentionHide", "onMentionFilter", "onItemTracked");
            if (PromptInputView.class == Promise.class) {
                asyncFunctionWithPromiseComponent = new AsyncFunctionWithPromiseComponent("getValue", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$lambda$29$$inlined$AsyncFunction$1
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        ((PromptInputView) promise).getValue();
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                AnyType[] anyTypeArr = new AnyType[1];
                AnyType anyType24 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(PromptInputView.class), false));
                if (anyType24 == null) {
                    anyType24 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(PromptInputView.class), false, new Function0<KType>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$lambda$29$$inlined$AsyncFunction$2
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(PromptInputView.class);
                        }
                    }), null);
                }
                anyTypeArr[0] = anyType24;
                Function1<Object[], String> function1 = new Function1<Object[], String>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$lambda$29$$inlined$AsyncFunction$3
                    @Override // kotlin.jvm.functions.Function1
                    public final String invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                        return ((PromptInputView) objArr[0]).getValue();
                    }
                };
                if (!Intrinsics.areEqual(String.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(String.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(String.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(String.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(String.class, String.class)) {
                                    untypedAsyncFunctionComponent = new StringAsyncFunctionComponent("getValue", anyTypeArr, function1);
                                } else {
                                    untypedAsyncFunctionComponent = new UntypedAsyncFunctionComponent("getValue", anyTypeArr, function1);
                                }
                            } else {
                                untypedAsyncFunctionComponent = new FloatAsyncFunctionComponent("getValue", anyTypeArr, function1);
                            }
                        } else {
                            untypedAsyncFunctionComponent = new DoubleAsyncFunctionComponent("getValue", anyTypeArr, function1);
                        }
                    } else {
                        untypedAsyncFunctionComponent = new BoolAsyncFunctionComponent("getValue", anyTypeArr, function1);
                    }
                } else {
                    untypedAsyncFunctionComponent = new IntAsyncFunctionComponent("getValue", anyTypeArr, function1);
                }
                asyncFunctionWithPromiseComponent = untypedAsyncFunctionComponent;
            }
            viewDefinitionBuilder7.getAsyncFunctions().put("getValue", asyncFunctionWithPromiseComponent);
            if (PromptInputView.class == Promise.class) {
                asyncFunctionWithPromiseComponent2 = new AsyncFunctionWithPromiseComponent("getPlainText", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$lambda$29$$inlined$AsyncFunction$4
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        ((PromptInputView) promise).getPlainText();
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                AnyType[] anyTypeArr2 = new AnyType[1];
                AnyType anyType25 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(PromptInputView.class), false));
                if (anyType25 == null) {
                    anyType25 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(PromptInputView.class), false, new Function0<KType>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$lambda$29$$inlined$AsyncFunction$5
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(PromptInputView.class);
                        }
                    }), null);
                }
                anyTypeArr2[0] = anyType25;
                Function1<Object[], String> function2 = new Function1<Object[], String>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$lambda$29$$inlined$AsyncFunction$6
                    @Override // kotlin.jvm.functions.Function1
                    public final String invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                        return ((PromptInputView) objArr[0]).getPlainText();
                    }
                };
                if (!Intrinsics.areEqual(String.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(String.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(String.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(String.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(String.class, String.class)) {
                                    untypedAsyncFunctionComponent2 = new StringAsyncFunctionComponent("getPlainText", anyTypeArr2, function2);
                                } else {
                                    untypedAsyncFunctionComponent2 = new UntypedAsyncFunctionComponent("getPlainText", anyTypeArr2, function2);
                                }
                            } else {
                                untypedAsyncFunctionComponent2 = new FloatAsyncFunctionComponent("getPlainText", anyTypeArr2, function2);
                            }
                        } else {
                            untypedAsyncFunctionComponent2 = new DoubleAsyncFunctionComponent("getPlainText", anyTypeArr2, function2);
                        }
                    } else {
                        untypedAsyncFunctionComponent2 = new BoolAsyncFunctionComponent("getPlainText", anyTypeArr2, function2);
                    }
                } else {
                    untypedAsyncFunctionComponent2 = new IntAsyncFunctionComponent("getPlainText", anyTypeArr2, function2);
                }
                asyncFunctionWithPromiseComponent2 = untypedAsyncFunctionComponent2;
            }
            viewDefinitionBuilder7.getAsyncFunctions().put("getPlainText", asyncFunctionWithPromiseComponent2);
            if (PromptInputView.class == Promise.class) {
                asyncFunctionWithPromiseComponent3 = new AsyncFunctionWithPromiseComponent(DiagnosisParams.CLEAR_ON_LOGOUT, new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$lambda$29$$inlined$AsyncFunction$7
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        ((PromptInputView) promise).clear();
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                AnyType[] anyTypeArr3 = new AnyType[1];
                AnyType anyType26 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(PromptInputView.class), false));
                if (anyType26 == null) {
                    anyType26 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(PromptInputView.class), false, new Function0<KType>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$lambda$29$$inlined$AsyncFunction$8
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(PromptInputView.class);
                        }
                    }), null);
                }
                anyTypeArr3[0] = anyType26;
                Function1<Object[], Unit> function3 = new Function1<Object[], Unit>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$lambda$29$$inlined$AsyncFunction$9
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                        ((PromptInputView) objArr[0]).clear();
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    untypedAsyncFunctionComponent3 = new StringAsyncFunctionComponent(DiagnosisParams.CLEAR_ON_LOGOUT, anyTypeArr3, function3);
                                } else {
                                    untypedAsyncFunctionComponent3 = new UntypedAsyncFunctionComponent(DiagnosisParams.CLEAR_ON_LOGOUT, anyTypeArr3, function3);
                                }
                            } else {
                                untypedAsyncFunctionComponent3 = new FloatAsyncFunctionComponent(DiagnosisParams.CLEAR_ON_LOGOUT, anyTypeArr3, function3);
                            }
                        } else {
                            untypedAsyncFunctionComponent3 = new DoubleAsyncFunctionComponent(DiagnosisParams.CLEAR_ON_LOGOUT, anyTypeArr3, function3);
                        }
                    } else {
                        untypedAsyncFunctionComponent3 = new BoolAsyncFunctionComponent(DiagnosisParams.CLEAR_ON_LOGOUT, anyTypeArr3, function3);
                    }
                } else {
                    untypedAsyncFunctionComponent3 = new IntAsyncFunctionComponent(DiagnosisParams.CLEAR_ON_LOGOUT, anyTypeArr3, function3);
                }
                asyncFunctionWithPromiseComponent3 = untypedAsyncFunctionComponent3;
            }
            viewDefinitionBuilder7.getAsyncFunctions().put(DiagnosisParams.CLEAR_ON_LOGOUT, asyncFunctionWithPromiseComponent3);
            TypeConverterProvider converters = viewDefinitionBuilder7.getConverters();
            AnyType[] anyTypeArr4 = new AnyType[4];
            AnyType anyType27 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(PromptInputView.class), false));
            if (anyType27 == null) {
                anyType27 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(PromptInputView.class), false, new Function0<KType>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$lambda$29$$inlined$AsyncFunction$10
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(PromptInputView.class);
                    }
                }), converters);
            }
            anyTypeArr4[0] = anyType27;
            AnyType anyType28 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType28 == null) {
                anyType28 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$lambda$29$$inlined$AsyncFunction$11
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }), converters);
            }
            anyTypeArr4[1] = anyType28;
            AnyType anyType29 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType29 == null) {
                anyType29 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$lambda$29$$inlined$AsyncFunction$12
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }), converters);
            }
            anyTypeArr4[2] = anyType29;
            AnyType anyType30 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType30 == null) {
                anyType30 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$lambda$29$$inlined$AsyncFunction$13
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }), converters);
            }
            anyTypeArr4[3] = anyType30;
            Function1<Object[], Unit> function4 = new Function1<Object[], Unit>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$lambda$29$$inlined$AsyncFunction$14
                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Object obj = objArr[0];
                    Object obj2 = objArr[1];
                    String str = (String) obj2;
                    PromptInputView promptInputView = (PromptInputView) obj;
                    promptInputView.insertMention(str, (String) objArr[2], TagType.INSTANCE.fromString((String) objArr[3]));
                    return Unit.INSTANCE;
                }
            };
            if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Unit.class, String.class)) {
                                untypedAsyncFunctionComponent4 = new StringAsyncFunctionComponent("insertMention", anyTypeArr4, function4);
                            } else {
                                untypedAsyncFunctionComponent4 = new UntypedAsyncFunctionComponent("insertMention", anyTypeArr4, function4);
                            }
                        } else {
                            untypedAsyncFunctionComponent4 = new FloatAsyncFunctionComponent("insertMention", anyTypeArr4, function4);
                        }
                    } else {
                        untypedAsyncFunctionComponent4 = new DoubleAsyncFunctionComponent("insertMention", anyTypeArr4, function4);
                    }
                } else {
                    untypedAsyncFunctionComponent4 = new BoolAsyncFunctionComponent("insertMention", anyTypeArr4, function4);
                }
            } else {
                untypedAsyncFunctionComponent4 = new IntAsyncFunctionComponent("insertMention", anyTypeArr4, function4);
            }
            viewDefinitionBuilder7.getAsyncFunctions().put("insertMention", untypedAsyncFunctionComponent4);
            TypeConverterProvider converters2 = viewDefinitionBuilder7.getConverters();
            AnyType[] anyTypeArr5 = new AnyType[5];
            AnyType anyType31 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(PromptInputView.class), false));
            if (anyType31 == null) {
                anyType31 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(PromptInputView.class), false, new Function0<KType>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$lambda$29$$inlined$AsyncFunction$15
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(PromptInputView.class);
                    }
                }), converters2);
            }
            anyTypeArr5[0] = anyType31;
            AnyType anyType32 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType32 == null) {
                anyType32 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$lambda$29$$inlined$AsyncFunction$16
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }), converters2);
            }
            anyTypeArr5[1] = anyType32;
            AnyType anyType33 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType33 == null) {
                anyType33 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$lambda$29$$inlined$AsyncFunction$17
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }), converters2);
            }
            anyTypeArr5[2] = anyType33;
            AnyType anyType34 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType34 == null) {
                anyType34 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$lambda$29$$inlined$AsyncFunction$18
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }), converters2);
            }
            anyTypeArr5[3] = anyType34;
            AnyType anyType35 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType35 == null) {
                anyType35 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$lambda$29$$inlined$AsyncFunction$19
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }), converters2);
            }
            anyTypeArr5[4] = anyType35;
            Function1<Object[], Unit> function5 = new Function1<Object[], Unit>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$lambda$29$$inlined$AsyncFunction$20
                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    Object obj = objArr[0];
                    Object obj2 = objArr[1];
                    Object obj3 = objArr[2];
                    String str = (String) obj3;
                    String str2 = (String) obj2;
                    PromptInputView promptInputView = (PromptInputView) obj;
                    promptInputView.insertItem(str2, str, (String) objArr[3], (String) objArr[4]);
                    return Unit.INSTANCE;
                }
            };
            if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Unit.class, String.class)) {
                                untypedAsyncFunctionComponent5 = new StringAsyncFunctionComponent("insertItem", anyTypeArr5, function5);
                            } else {
                                untypedAsyncFunctionComponent5 = new UntypedAsyncFunctionComponent("insertItem", anyTypeArr5, function5);
                            }
                        } else {
                            untypedAsyncFunctionComponent5 = new FloatAsyncFunctionComponent("insertItem", anyTypeArr5, function5);
                        }
                    } else {
                        untypedAsyncFunctionComponent5 = new DoubleAsyncFunctionComponent("insertItem", anyTypeArr5, function5);
                    }
                } else {
                    untypedAsyncFunctionComponent5 = new BoolAsyncFunctionComponent("insertItem", anyTypeArr5, function5);
                }
            } else {
                untypedAsyncFunctionComponent5 = new IntAsyncFunctionComponent("insertItem", anyTypeArr5, function5);
            }
            viewDefinitionBuilder7.getAsyncFunctions().put("insertItem", untypedAsyncFunctionComponent5);
            TypeConverterProvider converters3 = viewDefinitionBuilder7.getConverters();
            AnyType[] anyTypeArr6 = new AnyType[2];
            AnyType anyType36 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(PromptInputView.class), false));
            if (anyType36 == null) {
                anyType36 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(PromptInputView.class), false, new Function0<KType>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$lambda$29$$inlined$AsyncFunction$21
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(PromptInputView.class);
                    }
                }), converters3);
            }
            anyTypeArr6[0] = anyType36;
            AnyType anyType37 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType37 == null) {
                anyType37 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$lambda$29$$inlined$AsyncFunction$22
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }), converters3);
            }
            anyTypeArr6[1] = anyType37;
            Function1<Object[], Unit> function6 = new Function1<Object[], Unit>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$lambda$29$$inlined$AsyncFunction$23
                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    ((PromptInputView) objArr[0]).cancelTrackedItem((String) objArr[1]);
                    return Unit.INSTANCE;
                }
            };
            if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Unit.class, String.class)) {
                                untypedAsyncFunctionComponent6 = new StringAsyncFunctionComponent("cancelTrackedItem", anyTypeArr6, function6);
                            } else {
                                untypedAsyncFunctionComponent6 = new UntypedAsyncFunctionComponent("cancelTrackedItem", anyTypeArr6, function6);
                            }
                        } else {
                            untypedAsyncFunctionComponent6 = new FloatAsyncFunctionComponent("cancelTrackedItem", anyTypeArr6, function6);
                        }
                    } else {
                        untypedAsyncFunctionComponent6 = new DoubleAsyncFunctionComponent("cancelTrackedItem", anyTypeArr6, function6);
                    }
                } else {
                    untypedAsyncFunctionComponent6 = new BoolAsyncFunctionComponent("cancelTrackedItem", anyTypeArr6, function6);
                }
            } else {
                untypedAsyncFunctionComponent6 = new IntAsyncFunctionComponent("cancelTrackedItem", anyTypeArr6, function6);
            }
            viewDefinitionBuilder7.getAsyncFunctions().put("cancelTrackedItem", untypedAsyncFunctionComponent6);
            if (PromptInputView.class == Promise.class) {
                asyncFunctionWithPromiseComponent4 = new AsyncFunctionWithPromiseComponent("blur", new AnyType[0], new Function2<Object[], Promise, Unit>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$lambda$29$$inlined$AsyncFunction$24
                    /* JADX WARN: Multi-variable type inference failed */
                    /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                    public final void invoke2(Object[] objArr, Promise promise) {
                        Intrinsics.checkNotNullParameter(objArr, "<unused var>");
                        Intrinsics.checkNotNullParameter(promise, "promise");
                        ((PromptInputView) promise).blur();
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Object[] objArr, Promise promise) {
                        invoke2(objArr, promise);
                        return Unit.INSTANCE;
                    }
                });
            } else {
                AnyType[] anyTypeArr7 = new AnyType[1];
                AnyType anyType38 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(PromptInputView.class), false));
                if (anyType38 == null) {
                    anyType38 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(PromptInputView.class), false, new Function0<KType>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$lambda$29$$inlined$AsyncFunction$25
                        @Override // kotlin.jvm.functions.Function0
                        public final KType invoke() {
                            return Reflection.typeOf(PromptInputView.class);
                        }
                    }), null);
                }
                anyTypeArr7[0] = anyType38;
                Function1<Object[], Unit> function7 = new Function1<Object[], Unit>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$lambda$29$$inlined$AsyncFunction$26
                    @Override // kotlin.jvm.functions.Function1
                    public final Unit invoke(Object[] objArr) {
                        Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                        ((PromptInputView) objArr[0]).blur();
                        return Unit.INSTANCE;
                    }
                };
                if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                            if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                                if (Intrinsics.areEqual(Unit.class, String.class)) {
                                    untypedAsyncFunctionComponent7 = new StringAsyncFunctionComponent("blur", anyTypeArr7, function7);
                                } else {
                                    untypedAsyncFunctionComponent7 = new UntypedAsyncFunctionComponent("blur", anyTypeArr7, function7);
                                }
                            } else {
                                untypedAsyncFunctionComponent7 = new FloatAsyncFunctionComponent("blur", anyTypeArr7, function7);
                            }
                        } else {
                            untypedAsyncFunctionComponent7 = new DoubleAsyncFunctionComponent("blur", anyTypeArr7, function7);
                        }
                    } else {
                        untypedAsyncFunctionComponent7 = new BoolAsyncFunctionComponent("blur", anyTypeArr7, function7);
                    }
                } else {
                    untypedAsyncFunctionComponent7 = new IntAsyncFunctionComponent("blur", anyTypeArr7, function7);
                }
                asyncFunctionWithPromiseComponent4 = untypedAsyncFunctionComponent7;
            }
            viewDefinitionBuilder7.getAsyncFunctions().put("blur", asyncFunctionWithPromiseComponent4);
            TypeConverterProvider converters4 = viewDefinitionBuilder7.getConverters();
            AnyType[] anyTypeArr8 = new AnyType[2];
            AnyType anyType39 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(PromptInputView.class), false));
            if (anyType39 == null) {
                anyType39 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(PromptInputView.class), false, new Function0<KType>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$lambda$29$$inlined$AsyncFunction$27
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(PromptInputView.class);
                    }
                }), converters4);
            }
            anyTypeArr8[0] = anyType39;
            AnyType anyType40 = AnyTypeProvider.INSTANCE.getTypesMap().get(new Pair(Reflection.getOrCreateKotlinClass(String.class), false));
            if (anyType40 == null) {
                anyType40 = new AnyType(new LazyKType(Reflection.getOrCreateKotlinClass(String.class), false, new Function0<KType>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$lambda$29$$inlined$AsyncFunction$28
                    @Override // kotlin.jvm.functions.Function0
                    public final KType invoke() {
                        return Reflection.typeOf(String.class);
                    }
                }), converters4);
            }
            anyTypeArr8[1] = anyType40;
            Function1<Object[], Unit> function8 = new Function1<Object[], Unit>() { // from class: expo.modules.nativeelementsexpo.NativeElementsExpoModule$definition$lambda$30$lambda$29$$inlined$AsyncFunction$29
                @Override // kotlin.jvm.functions.Function1
                public final Unit invoke(Object[] objArr) {
                    Intrinsics.checkNotNullParameter(objArr, "<destruct>");
                    ((PromptInputView) objArr[0]).setText((String) objArr[1]);
                    return Unit.INSTANCE;
                }
            };
            if (!Intrinsics.areEqual(Unit.class, Integer.TYPE)) {
                if (!Intrinsics.areEqual(Unit.class, Boolean.TYPE)) {
                    if (!Intrinsics.areEqual(Unit.class, Double.TYPE)) {
                        if (!Intrinsics.areEqual(Unit.class, Float.TYPE)) {
                            if (Intrinsics.areEqual(Unit.class, String.class)) {
                                untypedAsyncFunctionComponent8 = new StringAsyncFunctionComponent("setText", anyTypeArr8, function8);
                            } else {
                                untypedAsyncFunctionComponent8 = new UntypedAsyncFunctionComponent("setText", anyTypeArr8, function8);
                            }
                        } else {
                            untypedAsyncFunctionComponent8 = new FloatAsyncFunctionComponent("setText", anyTypeArr8, function8);
                        }
                    } else {
                        untypedAsyncFunctionComponent8 = new DoubleAsyncFunctionComponent("setText", anyTypeArr8, function8);
                    }
                } else {
                    untypedAsyncFunctionComponent8 = new BoolAsyncFunctionComponent("setText", anyTypeArr8, function8);
                }
            } else {
                untypedAsyncFunctionComponent8 = new IntAsyncFunctionComponent("setText", anyTypeArr8, function8);
            }
            viewDefinitionBuilder7.getAsyncFunctions().put("setText", untypedAsyncFunctionComponent8);
            moduleDefinitionBuilder8.registerViewDefinition(viewDefinitionBuilder7.build());
            ModuleDefinitionData moduleDefinitionDataBuildModule = moduleDefinitionBuilder.buildModule();
            Trace.endSection();
            return moduleDefinitionDataBuildModule;
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }
}

package expo.modules.ui;

import android.content.Context;
import android.content.res.Configuration;
import android.view.View;
import android.widget.LinearLayout;
import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.material3.ColorScheme;
import androidx.compose.material3.MaterialThemeKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.ComposeView;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.viewevent.ViewEventCallback;
import expo.modules.kotlin.viewevent.ViewEventDelegate;
import expo.modules.kotlin.views.ComposableScope;
import expo.modules.kotlin.views.ExpoComposeView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.jvm.internal.Reflection;
import kotlin.ranges.RangesKt;
import kotlin.reflect.KProperty;

/* JADX INFO: compiled from: HostView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\b\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0017\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0004\b\u0007\u0010\bJ\u0011\u0010\u0015\u001a\u00020\u0016*\u00020\u0017H\u0017¢\u0006\u0002\u0010\u0018J \u0010\u0019\u001a\u00020\u00162\u0011\u0010\u001a\u001a\r\u0012\u0004\u0012\u00020\u00160\u001b¢\u0006\u0002\b\u001cH\u0003¢\u0006\u0002\u0010\u001dJ\u001f\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u001f\u001a\u00020\u00142\u0006\u0010 \u001a\u00020!H\u0002¢\u0006\u0004\b\"\u0010#J\u0018\u0010$\u001a\u00020\u00162\u0006\u0010%\u001a\u00020&2\u0006\u0010'\u001a\u00020&H\u0014J\r\u0010(\u001a\u00020\u0016H\u0000¢\u0006\u0002\b)J\b\u0010*\u001a\u00020+H\u0002R\u0014\u0010\t\u001a\u00020\u0002X\u0096\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR!\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u000f\u0010\u0010R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006,"}, d2 = {"Lexpo/modules/ui/HostView;", "Lexpo/modules/kotlin/views/ExpoComposeView;", "Lexpo/modules/ui/HostProps;", "context", "Landroid/content/Context;", "appContext", "Lexpo/modules/kotlin/AppContext;", "<init>", "(Landroid/content/Context;Lexpo/modules/kotlin/AppContext;)V", "props", "getProps", "()Lexpo/modules/ui/HostProps;", "onLayoutContent", "Lexpo/modules/kotlin/viewevent/ViewEventCallback;", "Lexpo/modules/ui/LayoutContentEvent;", "getOnLayoutContent", "()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", "onLayoutContent$delegate", "Lexpo/modules/kotlin/viewevent/ViewEventDelegate;", "lastDispatchedContentSize", "Landroidx/compose/ui/unit/IntSize;", "Content", "", "Lexpo/modules/kotlin/views/ComposableScope;", "(Lexpo/modules/kotlin/views/ComposableScope;Landroidx/compose/runtime/Composer;I)V", "MaybeMatchContentsLayout", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "dispatchOnLayoutContent", "size", "density", "Landroidx/compose/ui/unit/Density;", "dispatchOnLayoutContent-viCIZxY", "(JLandroidx/compose/ui/unit/Density;)V", "onMeasure", "widthMeasureSpec", "", "heightMeasureSpec", "onViewDidUpdateProps", "onViewDidUpdateProps$expo_ui_release", "findComposeView", "Landroidx/compose/ui/platform/ComposeView;", "expo-ui_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HostView extends ExpoComposeView<HostProps> {
    static final /* synthetic */ KProperty<Object>[] $$delegatedProperties = {Reflection.property1(new PropertyReference1Impl(HostView.class, "onLayoutContent", "getOnLayoutContent()Lexpo/modules/kotlin/viewevent/ViewEventCallback;", 0))};
    public static final int $stable = 8;
    private IntSize lastDispatchedContentSize;

    /* JADX INFO: renamed from: onLayoutContent$delegate, reason: from kotlin metadata */
    private final ViewEventDelegate onLayoutContent;
    private final HostProps props;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Content$lambda$0(HostView hostView, ComposableScope composableScope, int i, Composer composer, int i2) {
        hostView.Content(composableScope, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MaybeMatchContentsLayout$lambda$6(HostView hostView, Function2 function2, int i, Composer composer, int i2) {
        hostView.MaybeMatchContentsLayout(function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HostView(Context context, AppContext appContext) {
        super(context, appContext, true);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(appContext, "appContext");
        this.props = new HostProps(null, null, null, null, null, null, 63, null);
        this.onLayoutContent = new ViewEventDelegate(this, null);
    }

    @Override // expo.modules.kotlin.views.ExpoComposeView
    public HostProps getProps() {
        return this.props;
    }

    private final ViewEventCallback<LayoutContentEvent> getOnLayoutContent() {
        return this.onLayoutContent.getValue(this, $$delegatedProperties[0]);
    }

    @Override // expo.modules.kotlin.views.ExpoComposeView
    public void Content(final ComposableScope composableScope, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(composableScope, "<this>");
        Composer composerStartRestartGroup = composer.startRestartGroup(-968938567);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Content)99@4209L7,104@4514L142,104@4442L214:HostView.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(composableScope) : composerStartRestartGroup.changedInstance(composableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(this) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-968938567, i2, -1, "expo.modules.ui.HostView.Content (HostView.kt:98)");
            }
            ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localContext);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Context context = (Context) objConsume;
            ExpoColorScheme value = getProps().getColorScheme().getValue();
            final ColorScheme colorScheme = value != null ? value.toColorScheme(context) : null;
            composerStartRestartGroup.startReplaceGroup(857944180);
            ComposerKt.sourceInformation(composerStartRestartGroup, "101@4340L21");
            if (colorScheme == null) {
                colorScheme = ExpoColorScheme.INSTANCE.defaultColorScheme(context, DarkThemeKt.isSystemInDarkTheme(composerStartRestartGroup, 0));
            }
            composerStartRestartGroup.endReplaceGroup();
            CompositionLocalKt.CompositionLocalProvider(CompositionLocalsKt.getLocalLayoutDirection().provides(getProps().getLayoutDirection().getValue().toLayoutDirection()), ComposableLambdaKt.rememberComposableLambda(-1708425095, true, new Function2<Composer, Integer, Unit>() { // from class: expo.modules.ui.HostView.Content.1
                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i3) {
                    ComposerKt.sourceInformation(composer2, "C105@4563L87,105@4522L128:HostView.kt#v15e7d");
                    if ((i3 & 3) == 2 && composer2.getSkipping()) {
                        composer2.skipToGroupEnd();
                        return;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1708425095, i3, -1, "expo.modules.ui.HostView.Content.<anonymous> (HostView.kt:105)");
                    }
                    ColorScheme colorScheme2 = colorScheme;
                    final HostView hostView = this;
                    final ComposableScope composableScope2 = composableScope;
                    MaterialThemeKt.MaterialTheme(colorScheme2, null, null, ComposableLambdaKt.rememberComposableLambda(-1438482867, true, new Function2<Composer, Integer, Unit>() { // from class: expo.modules.ui.HostView.Content.1.1
                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer3, Integer num) {
                            invoke(composer3, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer3, int i4) {
                            ComposerKt.sourceInformation(composer3, "C106@4598L44,106@4573L69:HostView.kt#v15e7d");
                            if ((i4 & 3) == 2 && composer3.getSkipping()) {
                                composer3.skipToGroupEnd();
                                return;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1438482867, i4, -1, "expo.modules.ui.HostView.Content.<anonymous>.<anonymous> (HostView.kt:106)");
                            }
                            HostView hostView2 = hostView;
                            final HostView hostView3 = hostView;
                            final ComposableScope composableScope3 = composableScope2;
                            hostView2.MaybeMatchContentsLayout(ComposableLambdaKt.rememberComposableLambda(1238855295, true, new Function2<Composer, Integer, Unit>() { // from class: expo.modules.ui.HostView.Content.1.1.1
                                @Override // kotlin.jvm.functions.Function2
                                public /* bridge */ /* synthetic */ Unit invoke(Composer composer4, Integer num) {
                                    invoke(composer4, num.intValue());
                                    return Unit.INSTANCE;
                                }

                                public final void invoke(Composer composer4, int i5) {
                                    ComposerKt.sourceInformation(composer4, "C107@4610L22:HostView.kt#v15e7d");
                                    if ((i5 & 3) == 2 && composer4.getSkipping()) {
                                        composer4.skipToGroupEnd();
                                        return;
                                    }
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventStart(1238855295, i5, -1, "expo.modules.ui.HostView.Content.<anonymous>.<anonymous>.<anonymous> (HostView.kt:107)");
                                    }
                                    hostView3.Children(composableScope3, composer4, ComposableScope.$stable);
                                    if (ComposerKt.isTraceInProgress()) {
                                        ComposerKt.traceEventEnd();
                                    }
                                }
                            }, composer3, 54), composer3, 6);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                        }
                    }, composer2, 54), composer2, 3072, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.HostView$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HostView.Content$lambda$0(this.f$0, composableScope, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public final void MaybeMatchContentsLayout(final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-148440405);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(MaybeMatchContentsLayout)115@4781L7,116@4832L7,117@4887L7,122@5103L10,122@5133L13,138@5862L50,140@5944L1793,134@5594L2143:HostView.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function2) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(this) ? 32 : 16;
        }
        if ((i2 & 19) != 18 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-148440405, i2, -1, "expo.modules.ui.HostView.MaybeMatchContentsLayout (HostView.kt:114)");
            }
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final Density density = (Density) objConsume;
            ProvidableCompositionLocal<Configuration> localConfiguration = AndroidCompositionLocals_androidKt.getLocalConfiguration();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localConfiguration);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Configuration configuration = (Configuration) objConsume2;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume3 = composerStartRestartGroup.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            LayoutDirection layoutDirection = (LayoutDirection) objConsume3;
            int iMo748roundToPx0680j_4 = density.mo748roundToPx0680j_4(Dp.m9687constructorimpl(configuration.screenWidthDp));
            int iMo748roundToPx0680j_5 = density.mo748roundToPx0680j_4(Dp.m9687constructorimpl(configuration.screenHeightDp));
            WindowInsets windowInsetsUnion = WindowInsetsKt.union(WindowInsets_androidKt.getSystemBars(WindowInsets.INSTANCE, composerStartRestartGroup, 6), WindowInsets_androidKt.getDisplayCutout(WindowInsets.INSTANCE, composerStartRestartGroup, 6));
            composerStartRestartGroup.startReplaceGroup(-917292025);
            ComposerKt.sourceInformation(composerStartRestartGroup, "126@5287L3");
            WindowInsets windowInsetsUnion2 = getProps().getIgnoreSafeAreaKeyboardInsets().getValue().booleanValue() ? windowInsetsUnion : WindowInsetsKt.union(windowInsetsUnion, WindowInsets_androidKt.getIme(WindowInsets.INSTANCE, composerStartRestartGroup, 6));
            composerStartRestartGroup.endReplaceGroup();
            int iCoerceAtLeast = RangesKt.coerceAtLeast((iMo748roundToPx0680j_4 - windowInsetsUnion.getLeft(density, layoutDirection)) - windowInsetsUnion.getRight(density, layoutDirection), 0);
            int iCoerceAtLeast2 = RangesKt.coerceAtLeast((iMo748roundToPx0680j_5 - windowInsetsUnion2.getTop(density)) - windowInsetsUnion2.getBottom(density), 0);
            Modifier modifierThen = Modifier.INSTANCE.then(Intrinsics.areEqual((Object) getProps().getMatchContentsHorizontal().getValue(), (Object) true) ? SizeKt.wrapContentWidth$default(Modifier.INSTANCE, null, false, 3, null) : Modifier.INSTANCE).then(Intrinsics.areEqual((Object) getProps().getMatchContentsVertical().getValue(), (Object) true) ? SizeKt.wrapContentHeight$default(Modifier.INSTANCE, null, false, 3, null) : Modifier.INSTANCE);
            composerStartRestartGroup.startReplaceGroup(-1633490746);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):HostView.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(this) | composerStartRestartGroup.changed(density);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: expo.modules.ui.HostView$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return HostView.MaybeMatchContentsLayout$lambda$4$lambda$3(this.f$0, density, (IntSize) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            composerStartRestartGroup.endReplaceGroup();
            Modifier modifierOnSizeChanged = OnRemeasuredModifierKt.onSizeChanged(modifierThen, (Function1) objRememberedValue);
            composerStartRestartGroup.startReplaceGroup(-1224400529);
            ComposerKt.sourceInformation(composerStartRestartGroup, "CC(remember):HostView.kt#9igjgp");
            boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(this) | composerStartRestartGroup.changed(iCoerceAtLeast) | composerStartRestartGroup.changed(iCoerceAtLeast2) | composerStartRestartGroup.changed(density);
            HostView$MaybeMatchContentsLayout$2$1 hostView$MaybeMatchContentsLayout$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance2 || hostView$MaybeMatchContentsLayout$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                hostView$MaybeMatchContentsLayout$2$1RememberedValue = new HostView$MaybeMatchContentsLayout$2$1(this, iCoerceAtLeast, iCoerceAtLeast2, density);
                composerStartRestartGroup.updateRememberedValue(hostView$MaybeMatchContentsLayout$2$1RememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) hostView$MaybeMatchContentsLayout$2$1RememberedValue;
            composerStartRestartGroup.endReplaceGroup();
            int i3 = i2 & 14;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierOnSizeChanged);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int i4 = ((i3 << 6) & 896) | 6;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            function2.invoke(composerStartRestartGroup, Integer.valueOf((i4 >> 6) & 14));
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.HostView$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return HostView.MaybeMatchContentsLayout$lambda$6(this.f$0, function2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MaybeMatchContentsLayout$lambda$4$lambda$3(HostView hostView, Density density, IntSize intSize) {
        hostView.m14653dispatchOnLayoutContentviCIZxY(intSize.m9862unboximpl(), density);
        return Unit.INSTANCE;
    }

    /* JADX INFO: renamed from: dispatchOnLayoutContent-viCIZxY, reason: not valid java name */
    private final void m14653dispatchOnLayoutContentviCIZxY(long size, Density density) {
        IntSize intSize = this.lastDispatchedContentSize;
        if (intSize == null ? false : IntSize.m9856equalsimpl0(intSize.m9862unboximpl(), size)) {
            return;
        }
        this.lastDispatchedContentSize = IntSize.m9850boximpl(size);
        Boolean value = getProps().getMatchContentsHorizontal().getValue();
        Boolean value2 = getProps().getMatchContentsVertical().getValue();
        float fMo751toDpu2uoSUM = density.mo751toDpu2uoSUM((int) (size >> 32));
        float fMo751toDpu2uoSUM2 = density.mo751toDpu2uoSUM((int) (size & 4294967295L));
        if (Intrinsics.areEqual((Object) value, (Object) true) || Intrinsics.areEqual((Object) value2, (Object) true)) {
            Float fValueOf = (!Intrinsics.areEqual((Object) value, (Object) true) || fMo751toDpu2uoSUM <= 0.0f) ? null : Float.valueOf(fMo751toDpu2uoSUM);
            Float fValueOf2 = (!Intrinsics.areEqual((Object) value2, (Object) true) || fMo751toDpu2uoSUM2 <= 0.0f) ? null : Float.valueOf(fMo751toDpu2uoSUM2);
            getShadowNodeProxy().setStyleSize(fValueOf != null ? Double.valueOf(fValueOf.floatValue()) : null, fValueOf2 != null ? Double.valueOf(fValueOf2.floatValue()) : null);
        }
        getOnLayoutContent().invoke(new LayoutContentEvent(Double.valueOf(fMo751toDpu2uoSUM), Double.valueOf(fMo751toDpu2uoSUM2)));
    }

    @Override // expo.modules.kotlin.views.ExpoComposeView, android.widget.LinearLayout, android.view.View
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        Boolean value = getProps().getMatchContentsHorizontal().getValue();
        Boolean value2 = getProps().getMatchContentsVertical().getValue();
        if (Intrinsics.areEqual((Object) value, (Object) true) || Intrinsics.areEqual((Object) value2, (Object) true)) {
            if (Intrinsics.areEqual((Object) value, (Object) true)) {
                widthMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            if (Intrinsics.areEqual((Object) value2, (Object) true)) {
                heightMeasureSpec = View.MeasureSpec.makeMeasureSpec(0, 0);
            }
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
            return;
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

    public final void onViewDidUpdateProps$expo_ui_release() {
        findComposeView().setLayoutParams(new LinearLayout.LayoutParams(Intrinsics.areEqual((Object) getProps().getMatchContentsHorizontal().getValue(), (Object) true) ? -2 : -1, Intrinsics.areEqual((Object) getProps().getMatchContentsVertical().getValue(), (Object) true) ? -2 : -1));
    }

    private final ComposeView findComposeView() {
        ComposeView composeView;
        int childCount = getChildCount();
        do {
            childCount--;
            if (-1 < childCount) {
                View childAt = getChildAt(childCount);
                composeView = childAt instanceof ComposeView ? (ComposeView) childAt : null;
            } else {
                throw new IllegalStateException("No ComposeView found in HostView");
            }
        } while (composeView == null);
        return composeView;
    }
}

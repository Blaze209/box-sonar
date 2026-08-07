package androidx.compose.material.internal;

import android.view.View;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionContext;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.LayoutCoordinatesKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.layout.OnRemeasuredModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.IntOffset;
import androidx.compose.ui.unit.IntRectKt;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.unit.LayoutDirection;
import androidx.compose.ui.window.PopupPositionProvider;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.UUID;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.math.MathKt;

/* JADX INFO: compiled from: ExposedDropdownMenuPopup.android.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a:\u0010\u0000\u001a\u00020\u00012\u0010\b\u0002\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0011\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0007H\u0001¢\u0006\u0002\u0010\b\u001a+\u0010\u000e\u001a\u00020\u00012\u0006\u0010\u000f\u001a\u00020\u00102\u0013\b\b\u0010\u0006\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0007H\u0083\b¢\u0006\u0002\u0010\u0011\"\u001a\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\nX\u0080\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r¨\u0006\u0012²\u0006\u0015\u0010\u0013\u001a\r\u0012\u0004\u0012\u00020\u00010\u0003¢\u0006\u0002\b\u0007X\u008a\u0084\u0002"}, d2 = {"ExposedDropdownMenuPopup", "", "onDismissRequest", "Lkotlin/Function0;", "popupPositionProvider", "Landroidx/compose/ui/window/PopupPositionProvider;", "content", "Landroidx/compose/runtime/Composable;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/window/PopupPositionProvider;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "LocalPopupTestTag", "Landroidx/compose/runtime/ProvidableCompositionLocal;", "", "getLocalPopupTestTag", "()Landroidx/compose/runtime/ProvidableCompositionLocal;", "SimpleStack", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "material", "currentContent"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ExposedDropdownMenuPopup_androidKt {
    private static final ProvidableCompositionLocal<String> LocalPopupTestTag = CompositionLocalKt.compositionLocalOf$default(null, new Function0() { // from class: androidx.compose.material.internal.ExposedDropdownMenuPopup_androidKt$$ExternalSyntheticLambda9
        @Override // kotlin.jvm.functions.Function0
        public final Object invoke() {
            return ExposedDropdownMenuPopup_androidKt.LocalPopupTestTag$lambda$0();
        }
    }, 1, null);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExposedDropdownMenuPopup$lambda$9(Function0 function0, PopupPositionProvider popupPositionProvider, Function2 function2, int i, int i2, Composer composer, int i3) {
        ExposedDropdownMenuPopup(function0, popupPositionProvider, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void ExposedDropdownMenuPopup(Function0<Unit> function0, PopupPositionProvider popupPositionProvider, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i, final int i2) {
        Function0<Unit> function1;
        int i3;
        final Function0<Unit> function3;
        boolean z;
        final PopupPositionProvider popupPositionProvider2 = popupPositionProvider;
        Composer composerStartRestartGroup = composer.startRestartGroup(1705178815);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ExposedDropdownMenuPopup)N(onDismissRequest,popupPositionProvider,content)81@3323L7,82@3362L7,83@3406L7,84@3461L7,85@3497L28,86@3552L29,87@3617L21,87@3600L38,88@3661L960,114@4657L351,114@4627L381,128@5025L182,128@5014L193,136@5253L126,136@5213L166,148@5648L494,159@6150L99,145@5557L692:ExposedDropdownMenuPopup.android.kt#mnwmf7");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
            function1 = function0;
        } else if ((i & 6) == 0) {
            function1 = function0;
            i3 = (composerStartRestartGroup.changedInstance(function1) ? 4 : 2) | i;
        } else {
            function1 = function0;
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(popupPositionProvider2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 256 : 128;
        }
        int i5 = i3;
        if (composerStartRestartGroup.shouldExecute((i5 & Token.DOTQUERY) != 146, i5 & 1)) {
            function3 = i4 != 0 ? null : function1;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1705178815, i5, -1, "androidx.compose.material.internal.ExposedDropdownMenuPopup (ExposedDropdownMenuPopup.android.kt:80)");
            }
            ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localView);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            View view = (View) objConsume;
            ProvidableCompositionLocal<Density> localDensity = CompositionLocalsKt.getLocalDensity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume2 = composerStartRestartGroup.consume(localDensity);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Density density = (Density) objConsume2;
            ProvidableCompositionLocal<String> providableCompositionLocal = LocalPopupTestTag;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume3 = composerStartRestartGroup.consume(providableCompositionLocal);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final String str = (String) objConsume3;
            ProvidableCompositionLocal<LayoutDirection> localLayoutDirection = CompositionLocalsKt.getLocalLayoutDirection();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume4 = composerStartRestartGroup.consume(localLayoutDirection);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final LayoutDirection layoutDirection = (LayoutDirection) objConsume4;
            CompositionContext compositionContextRememberCompositionContext = ComposablesKt.rememberCompositionContext(composerStartRestartGroup, 0);
            final State stateRememberUpdatedState = SnapshotStateKt.rememberUpdatedState(function2, composerStartRestartGroup, (i5 >> 6) & 14);
            Object[] objArr = new Object[0];
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2000650572, "CC(remember):ExposedDropdownMenuPopup.android.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: androidx.compose.material.internal.ExposedDropdownMenuPopup_androidKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return UUID.randomUUID();
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            UUID uuid = (UUID) RememberSaveableKt.rememberSaveable(objArr, (Function0) objRememberedValue, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2000648225, "CC(remember):ExposedDropdownMenuPopup.android.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                final PopupLayout popupLayout = new PopupLayout(function3, str, view, density, popupPositionProvider2, uuid);
                str = str;
                popupPositionProvider2 = popupPositionProvider2;
                z = true;
                popupLayout.setContent(compositionContextRememberCompositionContext, ComposableLambdaKt.composableLambdaInstance(1879981140, true, new Function2() { // from class: androidx.compose.material.internal.ExposedDropdownMenuPopup_androidKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ExposedDropdownMenuPopup_androidKt.ExposedDropdownMenuPopup$lambda$2$0$0(popupLayout, stateRememberUpdatedState, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }));
                composerStartRestartGroup.updateRememberedValue(popupLayout);
                objRememberedValue2 = popupLayout;
            } else {
                z = true;
            }
            final PopupLayout popupLayout2 = (PopupLayout) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2000616962, "CC(remember):ExposedDropdownMenuPopup.android.kt#9igjgp");
            int i6 = i5 & 14;
            LayoutDirection layoutDirection2 = layoutDirection;
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(popupLayout2) | (i6 == 4 ? z : false) | composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(layoutDirection2.ordinal());
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: androidx.compose.material.internal.ExposedDropdownMenuPopup_androidKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ExposedDropdownMenuPopup_androidKt.ExposedDropdownMenuPopup$lambda$3$0(popupLayout2, function3, str, layoutDirection, (DisposableEffectScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.DisposableEffect(popupLayout2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue3, composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2000605355, "CC(remember):ExposedDropdownMenuPopup.android.kt#9igjgp");
            boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(popupLayout2) | (i6 == 4 ? z : false) | composerStartRestartGroup.changed(str) | composerStartRestartGroup.changed(layoutDirection2.ordinal());
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance2 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = new Function0() { // from class: androidx.compose.material.internal.ExposedDropdownMenuPopup_androidKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ExposedDropdownMenuPopup_androidKt.ExposedDropdownMenuPopup$lambda$4$0(popupLayout2, function3, str, layoutDirection);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.SideEffect((Function0) objRememberedValue4, composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2000598115, "CC(remember):ExposedDropdownMenuPopup.android.kt#9igjgp");
            boolean zChangedInstance3 = composerStartRestartGroup.changedInstance(popupLayout2) | ((i5 & 112) == 32 ? z : false);
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance3 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new Function1() { // from class: androidx.compose.material.internal.ExposedDropdownMenuPopup_androidKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ExposedDropdownMenuPopup_androidKt.ExposedDropdownMenuPopup$lambda$5$0(popupLayout2, popupPositionProvider2, (DisposableEffectScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.DisposableEffect(popupPositionProvider2, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue5, composerStartRestartGroup, (i5 >> 3) & 14);
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2000585107, "CC(remember):ExposedDropdownMenuPopup.android.kt#9igjgp");
            boolean zChangedInstance4 = composerStartRestartGroup.changedInstance(popupLayout2);
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance4 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = new Function1() { // from class: androidx.compose.material.internal.ExposedDropdownMenuPopup_androidKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ExposedDropdownMenuPopup_androidKt.ExposedDropdownMenuPopup$lambda$7$0(popupLayout2, (LayoutCoordinates) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierOnGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(companion, (Function1) objRememberedValue6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2000569438, "CC(remember):ExposedDropdownMenuPopup.android.kt#9igjgp");
            boolean zChangedInstance5 = composerStartRestartGroup.changedInstance(popupLayout2) | composerStartRestartGroup.changed(layoutDirection2.ordinal());
            ExposedDropdownMenuPopup_androidKt$ExposedDropdownMenuPopup$6$1 exposedDropdownMenuPopup_androidKt$ExposedDropdownMenuPopup$6$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance5 || exposedDropdownMenuPopup_androidKt$ExposedDropdownMenuPopup$6$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                exposedDropdownMenuPopup_androidKt$ExposedDropdownMenuPopup$6$1RememberedValue = new ExposedDropdownMenuPopup_androidKt$ExposedDropdownMenuPopup$6$1(popupLayout2, layoutDirection);
                composerStartRestartGroup.updateRememberedValue(exposedDropdownMenuPopup_androidKt$ExposedDropdownMenuPopup$6$1RememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) exposedDropdownMenuPopup_androidKt$ExposedDropdownMenuPopup$6$1RememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composerStartRestartGroup, 0);
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierOnGloballyPositioned);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
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
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -88834835, "C:ExposedDropdownMenuPopup.android.kt#mnwmf7");
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            function3 = function1;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.internal.ExposedDropdownMenuPopup_androidKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ExposedDropdownMenuPopup_androidKt.ExposedDropdownMenuPopup$lambda$9(function3, popupPositionProvider2, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExposedDropdownMenuPopup$lambda$2$0$0(final PopupLayout popupLayout, State state, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C100@4111L16,102@4230L134,99@4055L528:ExposedDropdownMenuPopup.android.kt#mnwmf7");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1879981140, i, -1, "androidx.compose.material.internal.ExposedDropdownMenuPopup.<anonymous>.<anonymous>.<anonymous> (ExposedDropdownMenuPopup.android.kt:99)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1519353564, "CC(remember):ExposedDropdownMenuPopup.android.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material.internal.ExposedDropdownMenuPopup_androidKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ExposedDropdownMenuPopup_androidKt.ExposedDropdownMenuPopup$lambda$2$0$0$0$0((SemanticsPropertyReceiver) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(companion, false, (Function1) objRememberedValue, 1, null);
            ComposerKt.sourceInformationMarkerStart(composer, -1519349638, "CC(remember):ExposedDropdownMenuPopup.android.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(popupLayout);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: androidx.compose.material.internal.ExposedDropdownMenuPopup_androidKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ExposedDropdownMenuPopup_androidKt.ExposedDropdownMenuPopup$lambda$2$0$0$1$0(popupLayout, (IntSize) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierAlpha = AlphaKt.alpha(OnRemeasuredModifierKt.onSizeChanged(modifierSemantics$default, (Function1) objRememberedValue2), popupLayout.getCanCalculatePosition() ? 1.0f : 0.0f);
            Function2<Composer, Integer, Unit> function2ExposedDropdownMenuPopup$lambda$0 = ExposedDropdownMenuPopup$lambda$0(state);
            ComposerKt.sourceInformationMarkerStart(composer, -780896836, "CC(SimpleStack)N(modifier,content)175@6840L896,175@6793L943:ExposedDropdownMenuPopup.android.kt#mnwmf7");
            ComposerKt.sourceInformationMarkerStart(composer, 1177422492, "CC(remember):ExposedDropdownMenuPopup.android.kt#9igjgp");
            ExposedDropdownMenuPopup_androidKt$SimpleStack$1$1 exposedDropdownMenuPopup_androidKt$SimpleStack$1$1RememberedValue = composer.rememberedValue();
            if (exposedDropdownMenuPopup_androidKt$SimpleStack$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                exposedDropdownMenuPopup_androidKt$SimpleStack$1$1RememberedValue = ExposedDropdownMenuPopup_androidKt$SimpleStack$1$1.INSTANCE;
                composer.updateRememberedValue(exposedDropdownMenuPopup_androidKt$SimpleStack$1$1RememberedValue);
            }
            MeasurePolicy measurePolicy = (MeasurePolicy) exposedDropdownMenuPopup_androidKt$SimpleStack$1$1RememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierAlpha);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor);
            } else {
                composer.useNode();
            }
            Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composer);
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            function2ExposedDropdownMenuPopup$lambda$0.invoke(composer, 0);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExposedDropdownMenuPopup$lambda$2$0$0$0$0(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.popup(semanticsPropertyReceiver);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExposedDropdownMenuPopup$lambda$2$0$0$1$0(PopupLayout popupLayout, IntSize intSize) {
        popupLayout.m2682setPopupContentSizefhxjrPA(intSize);
        popupLayout.updatePosition();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult ExposedDropdownMenuPopup$lambda$3$0(final PopupLayout popupLayout, Function0 function0, String str, LayoutDirection layoutDirection, DisposableEffectScope disposableEffectScope) {
        popupLayout.show();
        popupLayout.updateParameters(function0, str, layoutDirection);
        return new DisposableEffectResult() { // from class: androidx.compose.material.internal.ExposedDropdownMenuPopup_androidKt$ExposedDropdownMenuPopup$lambda$3$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                popupLayout.disposeComposition();
                popupLayout.dismiss();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExposedDropdownMenuPopup$lambda$4$0(PopupLayout popupLayout, Function0 function0, String str, LayoutDirection layoutDirection) {
        popupLayout.updateParameters(function0, str, layoutDirection);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult ExposedDropdownMenuPopup$lambda$5$0(PopupLayout popupLayout, PopupPositionProvider popupPositionProvider, DisposableEffectScope disposableEffectScope) {
        popupLayout.setPositionProvider(popupPositionProvider);
        popupLayout.updatePosition();
        return new DisposableEffectResult() { // from class: androidx.compose.material.internal.ExposedDropdownMenuPopup_androidKt$ExposedDropdownMenuPopup$lambda$5$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ExposedDropdownMenuPopup$lambda$7$0(PopupLayout popupLayout, LayoutCoordinates layoutCoordinates) {
        LayoutCoordinates parentLayoutCoordinates = layoutCoordinates.getParentLayoutCoordinates();
        Intrinsics.checkNotNull(parentLayoutCoordinates);
        long jMo8273getSizeYbymL2g = parentLayoutCoordinates.mo8273getSizeYbymL2g();
        long jPositionInWindow = LayoutCoordinatesKt.positionInWindow(parentLayoutCoordinates);
        popupLayout.setParentBounds(IntRectKt.m9848IntRectVbeCjmY(IntOffset.m9809constructorimpl((((long) MathKt.roundToInt(Float.intBitsToFloat((int) (jPositionInWindow >> 32)))) << 32) | (4294967295L & ((long) MathKt.roundToInt(Float.intBitsToFloat((int) (jPositionInWindow & 4294967295L)))))), jMo8273getSizeYbymL2g));
        popupLayout.updatePosition();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String LocalPopupTestTag$lambda$0() {
        return "DEFAULT_TEST_TAG";
    }

    public static final ProvidableCompositionLocal<String> getLocalPopupTestTag() {
        return LocalPopupTestTag;
    }

    private static final void SimpleStack(Modifier modifier, Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -780896836, "CC(SimpleStack)N(modifier,content)175@6840L896,175@6793L943:ExposedDropdownMenuPopup.android.kt#mnwmf7");
        ComposerKt.sourceInformationMarkerStart(composer, 1177422492, "CC(remember):ExposedDropdownMenuPopup.android.kt#9igjgp");
        ExposedDropdownMenuPopup_androidKt$SimpleStack$1$1 exposedDropdownMenuPopup_androidKt$SimpleStack$1$1RememberedValue = composer.rememberedValue();
        if (exposedDropdownMenuPopup_androidKt$SimpleStack$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
            exposedDropdownMenuPopup_androidKt$SimpleStack$1$1RememberedValue = ExposedDropdownMenuPopup_androidKt$SimpleStack$1$1.INSTANCE;
            composer.updateRememberedValue(exposedDropdownMenuPopup_androidKt$SimpleStack$1$1RememberedValue);
        }
        MeasurePolicy measurePolicy = (MeasurePolicy) exposedDropdownMenuPopup_androidKt$SimpleStack$1$1RememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        int i2 = ((i << 3) & 112) | ((i >> 3) & 14) | 384;
        ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
        int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifier);
        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
        int i3 = ((i2 << 6) & 896) | 6;
        ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
        if (!(composer.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer.startReusableNode();
        if (composer.getInserting()) {
            composer.createNode(constructor);
        } else {
            composer.useNode();
        }
        Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composer);
        Updater.m6070setimpl(composerM6062constructorimpl, measurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
        if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
            composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
            composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
        }
        Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
        function2.invoke(composer, Integer.valueOf((i3 >> 6) & 14));
        composer.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    private static final Function2<Composer, Integer, Unit> ExposedDropdownMenuPopup$lambda$0(State<? extends Function2<? super Composer, ? super Integer, Unit>> state) {
        return (Function2) state.getValue();
    }
}

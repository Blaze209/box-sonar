package androidx.compose.material3;

import androidx.compose.animation.core.AnimationSpec;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import com.box.android.domain.metrics.hubs.HubsObservability;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.ranges.RangesKt;

/* JADX INFO: compiled from: ButtonGroup.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0001\u0018\u00002\u00020\u0001BP\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u0013\u0010\u0005\u001a\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\b\u0006\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\f\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\u0006\u0010\r\u001a\u00020\u000e¢\u0006\u0004\b\u000f\u0010\u0010J\r\u0010\u0012\u001a\u00020\u0004H\u0017¢\u0006\u0002\u0010\u0013J\u0015\u0010\u0014\u001a\u00020\u00042\u0006\u0010\u0015\u001a\u00020\u0016H\u0017¢\u0006\u0002\u0010\u0017R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004¢\u0006\u0002\n\u0000R\u001d\u0010\u0005\u001a\u000f\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u0003¢\u0006\u0002\b\u0006X\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u0011R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\b0\nX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Landroidx/compose/material3/ClickableButtonGroupItem;", "Landroidx/compose/material3/ButtonGroupItem;", ViewProps.ON_CLICK, "Lkotlin/Function0;", "", HubsObservability.HUB_ASSET_ICON, "Landroidx/compose/runtime/Composable;", "weight", "", "animationSpec", "Landroidx/compose/animation/core/AnimationSpec;", "enabled", "", "label", "", "<init>", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function2;FLandroidx/compose/animation/core/AnimationSpec;ZLjava/lang/String;)V", "Lkotlin/jvm/functions/Function2;", "ButtonGroupContent", "(Landroidx/compose/runtime/Composer;I)V", "MenuContent", "state", "Landroidx/compose/material3/ButtonGroupMenuState;", "(Landroidx/compose/material3/ButtonGroupMenuState;Landroidx/compose/runtime/Composer;I)V", "material3"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class ClickableButtonGroupItem implements ButtonGroupItem {
    public static final int $stable = 8;
    private final AnimationSpec<Float> animationSpec;
    private final boolean enabled;
    private final Function2<Composer, Integer, Unit> icon;
    private final String label;
    private final Function0<Unit> onClick;
    private final float weight;

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ButtonGroupContent$lambda$2(ClickableButtonGroupItem clickableButtonGroupItem, int i, Composer composer, int i2) {
        clickableButtonGroupItem.ButtonGroupContent(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MenuContent$lambda$2(ClickableButtonGroupItem clickableButtonGroupItem, ButtonGroupMenuState buttonGroupMenuState, int i, Composer composer, int i2) {
        clickableButtonGroupItem.MenuContent(buttonGroupMenuState, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ClickableButtonGroupItem(Function0<Unit> function0, Function2<? super Composer, ? super Integer, Unit> function2, float f, AnimationSpec<Float> animationSpec, boolean z, String str) {
        this.onClick = function0;
        this.icon = function2;
        this.weight = f;
        this.animationSpec = animationSpec;
        this.enabled = z;
        this.label = str;
    }

    @Override // androidx.compose.material3.ButtonGroupItem
    public void ButtonGroupContent(Composer composer, final int i) {
        int i2;
        Modifier.Companion buttonGroupElement;
        Composer composerStartRestartGroup = composer.startRestartGroup(1970104548);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ButtonGroupContent)1171@51720L39,1191@52432L167,1186@52268L331:ButtonGroup.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(this) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1970104548, i2, -1, "androidx.compose.material3.ClickableButtonGroupItem.ButtonGroupContent (ButtonGroup.kt:1170)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -810104981, "CC(remember):ButtonGroup.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierThen = Modifier.INSTANCE.then(new EnlargeOnPressElement(mutableInteractionSource, this.animationSpec));
            if (!Float.isNaN(this.weight)) {
                buttonGroupElement = new ButtonGroupElement(RangesKt.coerceAtMost(this.weight, Float.MAX_VALUE));
            } else {
                buttonGroupElement = Modifier.INSTANCE;
            }
            ButtonKt.Button(this.onClick, modifierThen.then(buttonGroupElement), this.enabled, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, mutableInteractionSource, ComposableLambdaKt.rememberComposableLambda(241841908, true, new Function3() { // from class: androidx.compose.material3.ClickableButtonGroupItem$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ClickableButtonGroupItem.ButtonGroupContent$lambda$1(this.f$0, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 905969664, 248);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ClickableButtonGroupItem$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ClickableButtonGroupItem.ButtonGroupContent$lambda$2(this.f$0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ButtonGroupContent$lambda$1(ClickableButtonGroupItem clickableButtonGroupItem, RowScope rowScope, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C1196@52578L11:ButtonGroup.kt#uh7d8r");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(241841908, i, -1, "androidx.compose.material3.ClickableButtonGroupItem.ButtonGroupContent.<anonymous> (ButtonGroup.kt:1192)");
            }
            Function2<Composer, Integer, Unit> function2 = clickableButtonGroupItem.icon;
            if (function2 == null) {
                composer.startReplaceGroup(2052149180);
            } else {
                composer.startReplaceGroup(2052149181);
                ComposerKt.sourceInformation(composer, "*1193@52477L8,1194@52502L49");
                function2.invoke(composer, 0);
                SpacerKt.Spacer(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, ButtonDefaults.INSTANCE.m2864getIconSpacingD9Ej5fM()), composer, 6);
            }
            composer.endReplaceGroup();
            TextKt.m4494TextNvy7gAk(clickableButtonGroupItem.label, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    @Override // androidx.compose.material3.ButtonGroupItem
    public void MenuContent(final ButtonGroupMenuState buttonGroupMenuState, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-30600495);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(MenuContent)N(state)1205@52791L15,1206@52830L73,1202@52691L223:ButtonGroup.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(buttonGroupMenuState) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(this) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-30600495, i2, -1, "androidx.compose.material3.ClickableButtonGroupItem.MenuContent (ButtonGroup.kt:1201)");
            }
            boolean z = this.enabled;
            Function2<Composer, Integer, Unit> function2 = this.icon;
            ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-808296799, true, new Function2() { // from class: androidx.compose.material3.ClickableButtonGroupItem$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ClickableButtonGroupItem.MenuContent$lambda$0(this.f$0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 657701658, "CC(remember):ButtonGroup.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(this) | composerStartRestartGroup.changedInstance(buttonGroupMenuState);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: androidx.compose.material3.ClickableButtonGroupItem$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ClickableButtonGroupItem.MenuContent$lambda$1$0(this.f$0, buttonGroupMenuState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            AndroidMenu_androidKt.DropdownMenuItem(composableLambdaRememberComposableLambda, (Function0) objRememberedValue, null, function2, null, z, null, null, null, composerStartRestartGroup, 6, 468);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.ClickableButtonGroupItem$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ClickableButtonGroupItem.MenuContent$lambda$2(this.f$0, buttonGroupMenuState, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MenuContent$lambda$0(ClickableButtonGroupItem clickableButtonGroupItem, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C1205@52793L11:ButtonGroup.kt#uh7d8r");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-808296799, i, -1, "androidx.compose.material3.ClickableButtonGroupItem.MenuContent.<anonymous> (ButtonGroup.kt:1205)");
            }
            TextKt.m4494TextNvy7gAk(clickableButtonGroupItem.label, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MenuContent$lambda$1$0(ClickableButtonGroupItem clickableButtonGroupItem, ButtonGroupMenuState buttonGroupMenuState) {
        clickableButtonGroupItem.onClick.invoke();
        buttonGroupMenuState.dismiss();
        return Unit.INSTANCE;
    }
}

package androidx.compose.material;

import android.graphics.Rect;
import android.view.View;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.graphics.RectHelper_androidKt;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.unit.IntRect;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: ExposedDropdownMenu.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002\u001a\u001b\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00040\u0006H\u0001¢\u0006\u0002\u0010\u0007\u001a\f\u0010\b\u001a\u00020\t*\u00020\nH\u0002¨\u0006\u000b"}, d2 = {"platformWindowBoundsCalculator", "Landroidx/compose/material/WindowBoundsCalculator;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material/WindowBoundsCalculator;", "OnPlatformWindowBoundsChange", "", "block", "Lkotlin/Function0;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "getWindowBounds", "Landroidx/compose/ui/unit/IntRect;", "Landroid/view/View;", "material"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ExposedDropdownMenu_android {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OnPlatformWindowBoundsChange$lambda$1(Function0 function0, int i, Composer composer, int i2) {
        OnPlatformWindowBoundsChange(function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final WindowBoundsCalculator platformWindowBoundsCalculator(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1216067952, "C(platformWindowBoundsCalculator)36@1338L7,37@1357L47:ExposedDropdownMenu.android.kt#jmzs0o");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1216067952, i, -1, "androidx.compose.material.platformWindowBoundsCalculator (ExposedDropdownMenu.android.kt:35)");
        }
        ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
        ComposerKt.sourceInformationMarkerStart(composer, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
        Object objConsume = composer.consume(localView);
        ComposerKt.sourceInformationMarkerEnd(composer);
        View view = (View) objConsume;
        ComposerKt.sourceInformationMarkerStart(composer, -410193889, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
        boolean zChanged = composer.changed(view);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new WindowBoundsCalculator(view);
            composer.updateRememberedValue(objRememberedValue);
        }
        WindowBoundsCalculator windowBoundsCalculator = (WindowBoundsCalculator) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return windowBoundsCalculator;
    }

    public static final void OnPlatformWindowBoundsChange(final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1063434120);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OnPlatformWindowBoundsChange)N(block)42@1515L7,43@1550L107,43@1527L130:ExposedDropdownMenu.android.kt#jmzs0o");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1063434120, i2, -1, "androidx.compose.material.OnPlatformWindowBoundsChange (ExposedDropdownMenu.android.kt:41)");
            }
            ProvidableCompositionLocal<View> localView = AndroidCompositionLocals_androidKt.getLocalView();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localView);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final View view = (View) objConsume;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -242023373, "CC(remember):ExposedDropdownMenu.android.kt#9igjgp");
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(view) | ((i2 & 14) == 4);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material.ExposedDropdownMenu_android$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ExposedDropdownMenu_android.OnPlatformWindowBoundsChange$lambda$0$0(view, function0, (DisposableEffectScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.DisposableEffect(view, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ExposedDropdownMenu_android$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ExposedDropdownMenu_android.OnPlatformWindowBoundsChange$lambda$1(function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult OnPlatformWindowBoundsChange$lambda$0$0(View view, Function0 function0, DisposableEffectScope disposableEffectScope) {
        final OnGlobalLayoutListener onGlobalLayoutListener = new OnGlobalLayoutListener(view, function0);
        return new DisposableEffectResult() { // from class: androidx.compose.material.ExposedDropdownMenu_android$OnPlatformWindowBoundsChange$lambda$0$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                onGlobalLayoutListener.dispose();
            }
        };
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntRect getWindowBounds(View view) {
        Rect rect = new Rect();
        view.getWindowVisibleDisplayFrame(rect);
        return RectHelper_androidKt.toComposeIntRect(rect);
    }
}

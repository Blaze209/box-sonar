package com.box.android.base.compose;

import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.input.pointer.PointerInputEventHandler;
import androidx.compose.ui.input.pointer.SuspendingPointerInputFilterKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.platform.SoftwareKeyboardController;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: KeyboardOpenedGesturesBlocker.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\u001a\u0017\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004¨\u0006\u0005²\u0006\n\u0010\u0006\u001a\u00020\u0007X\u008a\u0084\u0002"}, d2 = {"KeyboardOpenedGesturesBlocker", "", "modifier", "Landroidx/compose/ui/Modifier;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "base_generalProdRelease", "isKeyboardOpened", ""}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class KeyboardOpenedGesturesBlockerKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit KeyboardOpenedGesturesBlocker$lambda$2(Modifier modifier, int i, int i2, Composer composer, int i3) {
        KeyboardOpenedGesturesBlocker(modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void KeyboardOpenedGesturesBlocker(final Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-680874067);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(KeyboardOpenedGesturesBlocker)N(modifier)17@700L25,18@777L7:KeyboardOpenedGesturesBlocker.kt#vejmn0");
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 3) != 2, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-680874067, i3, -1, "com.box.android.base.compose.KeyboardOpenedGesturesBlocker (KeyboardOpenedGesturesBlocker.kt:16)");
            }
            State<Boolean> stateKeyboardIsOpenedAsState = ComposeUtilsKt.keyboardIsOpenedAsState(composerStartRestartGroup, 0);
            ProvidableCompositionLocal<SoftwareKeyboardController> localSoftwareKeyboardController = CompositionLocalsKt.getLocalSoftwareKeyboardController();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localSoftwareKeyboardController);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            SoftwareKeyboardController softwareKeyboardController = (SoftwareKeyboardController) objConsume;
            if (!KeyboardOpenedGesturesBlocker$lambda$0(stateKeyboardIsOpenedAsState)) {
                composerStartRestartGroup.startReplaceGroup(1210607861);
            } else {
                composerStartRestartGroup.startReplaceGroup(1211418697);
                ComposerKt.sourceInformation(composerStartRestartGroup, "22@894L42,20@821L156");
                Unit unit = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1484940105, "CC(remember):KeyboardOpenedGesturesBlocker.kt#9igjgp");
                boolean zChanged = composerStartRestartGroup.changed(softwareKeyboardController);
                KeyboardOpenedGesturesBlockerKt$KeyboardOpenedGesturesBlocker$1$1 keyboardOpenedGesturesBlockerKt$KeyboardOpenedGesturesBlocker$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged || keyboardOpenedGesturesBlockerKt$KeyboardOpenedGesturesBlocker$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    keyboardOpenedGesturesBlockerKt$KeyboardOpenedGesturesBlocker$1$1RememberedValue = new KeyboardOpenedGesturesBlockerKt$KeyboardOpenedGesturesBlocker$1$1(softwareKeyboardController);
                    composerStartRestartGroup.updateRememberedValue(keyboardOpenedGesturesBlockerKt$KeyboardOpenedGesturesBlocker$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                BoxKt.Box(SizeKt.fillMaxSize$default(SuspendingPointerInputFilterKt.pointerInput(modifier, unit, (PointerInputEventHandler) keyboardOpenedGesturesBlockerKt$KeyboardOpenedGesturesBlocker$1$1RememberedValue), 0.0f, 1, null), composerStartRestartGroup, 0);
            }
            composerStartRestartGroup.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.KeyboardOpenedGesturesBlockerKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return KeyboardOpenedGesturesBlockerKt.KeyboardOpenedGesturesBlocker$lambda$2(modifier, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean KeyboardOpenedGesturesBlocker$lambda$0(State<Boolean> state) {
        return state.getValue().booleanValue();
    }
}

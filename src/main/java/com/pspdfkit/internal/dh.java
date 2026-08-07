package com.pspdfkit.internal;

import android.content.Context;
import android.content.res.Resources;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.RadioButtonDefaults;
import androidx.compose.material3.RadioButtonKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.TextUnit;
import androidx.compose.ui.unit.TextUnitKt;
import com.pspdfkit.R;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final class dh {
    public static final Unit a(String str, boolean z, Function0 function0, TextStyle textStyle, long j, long j2, int i, Composer composer, int i2) {
        a(str, z, function0, textStyle, j, j2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(final String str, final boolean z, final Function0<Unit> function0, final TextStyle textStyle, final long j, final long j2, Composer composer, final int i) {
        int i2;
        boolean z2;
        Function0<Unit> function1;
        TextStyle textStyle2;
        Composer composer2;
        str.getClass();
        function0.getClass();
        textStyle.getClass();
        Composer composerStartRestartGroup = composer.startRestartGroup(1336925521);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            z2 = z;
            i2 |= composerStartRestartGroup.changed(z2) ? 32 : 16;
        } else {
            z2 = z;
        }
        if ((i & 384) == 0) {
            function1 = function0;
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        } else {
            function1 = function0;
        }
        if ((i & 3072) == 0) {
            textStyle2 = textStyle;
            i2 |= composerStartRestartGroup.changed(textStyle2) ? 2048 : 1024;
        } else {
            textStyle2 = textStyle;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changed(j) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(j2) ? 131072 : 65536;
        }
        if (composerStartRestartGroup.shouldExecute((74899 & i2) != 74898, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1336925521, i2, -1, "com.pspdfkit.internal.ui.dialog.signatures.composables.FontItem (FontItem.kt:43)");
            }
            final Resources resources = (Resources) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalResources());
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(TextUnit.m9871boximpl(j2), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            Modifier.Companion companion2 = Modifier.INSTANCE;
            Modifier modifierM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(SizeKt.m1252height3ABfNKs(SizeKt.fillMaxWidth$default(companion2, 0.0f, 1, null), PrimitiveResources_androidKt.dimensionResource(R.dimen.pspdf__signatures_font_item_height, composerStartRestartGroup, 0)), PrimitiveResources_androidKt.dimensionResource(R.dimen.pspdf__signatures_font_item_padding, composerStartRestartGroup, 0), 0.0f, PrimitiveResources_androidKt.dimensionResource(R.dimen.pspdf__signatures_font_item_padding, composerStartRestartGroup, 0), 0.0f, 10, null);
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), composerStartRestartGroup, 48);
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1222paddingqDBjuR0$default);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion3.getConstructor();
            int i3 = i2;
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
            f2.a(companion3, composerM6062constructorimpl, measurePolicyRowMeasurePolicy, composerM6062constructorimpl, currentCompositionLocalMap);
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion3, composerM6062constructorimpl, Integer.valueOf(iHashCode), composerM6062constructorimpl));
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            RadioButtonKt.RadioButton(z2, function1, null, false, RadioButtonDefaults.INSTANCE.m4018colorsro_MJ88(ColorKt.Color(f60.a((Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext()), androidx.appcompat.R.attr.colorAccent)), 0L, 0L, 0L, composerStartRestartGroup, RadioButtonDefaults.$stable << 12, 14), null, composerStartRestartGroup, (i3 >> 3) & 126, 44);
            TextStyle textStyleM9104copyp1EtxEg$default = TextStyle.m9104copyp1EtxEg$default(textStyle2, 0L, ((TextUnit) mutableState.getValue()).getPackedValue(), null, null, null, null, null, 0L, null, null, null, 0L, null, null, null, 0, 0, 0L, null, null, null, 0, 0, null, 16777213, null);
            Modifier modifierM1222paddingqDBjuR0$default2 = PaddingKt.m1222paddingqDBjuR0$default(companion2, PrimitiveResources_androidKt.dimensionResource(R.dimen.pspdf__signatures_font_item_text_padding, composerStartRestartGroup, 0), 0.0f, 0.0f, 0.0f, 14, null);
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(resources) | ((i3 & 458752) == 131072) | ((i3 & 57344) == 16384);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == companion.getEmpty()) {
                Function1 function2 = new Function1() { // from class: com.pspdfkit.internal.dh$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return dh.a(resources, j2, j, mutableState, (TextLayoutResult) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(function2);
                objRememberedValue2 = function2;
            }
            TextKt.m4494TextNvy7gAk(str, modifierM1222paddingqDBjuR0$default2, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 1, 0, (Function1) objRememberedValue2, textStyleM9104copyp1EtxEg$default, composerStartRestartGroup, i3 & 14, 24576, 49148);
            composer2 = composerStartRestartGroup;
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.dh$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return dh.a(str, z, function0, textStyle, j, j2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit a(Resources resources, long j, long j2, MutableState mutableState, TextLayoutResult textLayoutResult) {
        textLayoutResult.getClass();
        int i = resources.getDisplayMetrics().widthPixels;
        if (((int) (textLayoutResult.getSize() >> 32)) > i) {
            while (((int) (textLayoutResult.getSize() >> 32)) > i) {
                long packedValue = ((TextUnit) mutableState.getValue()).getPackedValue();
                TextUnitKt.m9895checkArithmeticNB67dxo(packedValue, j);
                if (Float.compare(TextUnit.m9881getValueimpl(packedValue), TextUnit.m9881getValueimpl(j)) <= 0) {
                    break;
                }
                mutableState.setValue(TextUnit.m9871boximpl(TextUnitKt.getSp(TextUnit.m9881getValueimpl(((TextUnit) mutableState.getValue()).getPackedValue()) - 1.0f)));
            }
        } else if (((int) (textLayoutResult.getSize() >> 32)) < i) {
            long packedValue2 = ((TextUnit) mutableState.getValue()).getPackedValue();
            TextUnitKt.m9895checkArithmeticNB67dxo(packedValue2, j2);
            if (Float.compare(TextUnit.m9881getValueimpl(packedValue2), TextUnit.m9881getValueimpl(j2)) < 0) {
                mutableState.setValue(TextUnit.m9871boximpl(TextUnitKt.getSp(TextUnit.m9881getValueimpl(((TextUnit) mutableState.getValue()).getPackedValue()) + 1.0f)));
            }
        }
        return Unit.INSTANCE;
    }
}

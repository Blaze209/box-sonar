package com.pspdfkit.internal;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Density;
import com.pspdfkit.R;
import com.pspdfkit.annotations.stamps.StampPickerItem;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final class c40 {
    public static final Unit a(Modifier modifier, StampPickerItem stampPickerItem, int i, Composer composer, int i2) {
        a(modifier, stampPickerItem, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void a(final Modifier modifier, final StampPickerItem stampPickerItem, Composer composer, final int i) {
        int i2;
        modifier.getClass();
        stampPickerItem.getClass();
        Composer composerStartRestartGroup = composer.startRestartGroup(-929720576);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(stampPickerItem) ? 32 : 16;
        }
        int i3 = i2;
        if (composerStartRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-929720576, i3, -1, "com.pspdfkit.internal.ui.dialog.stamps.composables.StampGridHeader (StampGridHeader.kt:35)");
            }
            Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            context.getClass();
            density.getClass();
            float fMo750toDpu2uoSUM = density.mo750toDpu2uoSUM(context.getResources().getDimension(R.dimen.pspdf__stamp_picker_horizontal_padding));
            float fMo750toDpu2uoSUM2 = density.mo750toDpu2uoSUM(context.getResources().getDimension(R.dimen.pspdf__stamp_picker_vertical_padding));
            density.mo750toDpu2uoSUM(context.getResources().getDimension(R.dimen.pspdf__stamp_picker_fab_padding));
            context.getResources().getDimension(R.dimen.pspdf__stamp_picker_color_grid_padding);
            density.mo750toDpu2uoSUM(context.getResources().getDimension(R.dimen.pspdf__stamp_picker_color_grid_spacing));
            float fMo750toDpu2uoSUM3 = density.mo750toDpu2uoSUM(context.getResources().getDimension(R.dimen.pspdf__stamp_picker_header_padding));
            i40 i40Var = new i40((Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext()));
            Modifier modifierM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null), ColorKt.Color(i40Var.g), null, 2, null), fMo750toDpu2uoSUM, fMo750toDpu2uoSUM, fMo750toDpu2uoSUM2, 0.0f, 8, null);
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Vertical top = arrangement.getTop();
            Alignment.Companion companion = Alignment.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion.getStart(), composerStartRestartGroup, 0);
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1222paddingqDBjuR0$default);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion2.getConstructor();
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
            f2.a(companion2, composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, composerM6062constructorimpl, currentCompositionLocalMap);
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion2, composerM6062constructorimpl, Integer.valueOf(iHashCode), composerM6062constructorimpl));
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            Modifier.Companion companion3 = Modifier.INSTANCE;
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion3, 0.0f, 1, null);
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getSpaceBetween(), companion.getCenterVertically(), composerStartRestartGroup, 54);
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default);
            Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
            f2.a(companion2, composerM6062constructorimpl2, measurePolicyRowMeasurePolicy, composerM6062constructorimpl2, currentCompositionLocalMap2);
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion2, composerM6062constructorimpl2, Integer.valueOf(iHashCode2), composerM6062constructorimpl2));
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion.getTop(), composerStartRestartGroup, 0);
            int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion3);
            Function0<ComposeUiNode> constructor3 = companion2.getConstructor();
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl3 = Updater.m6062constructorimpl(composerStartRestartGroup);
            f2.a(companion2, composerM6062constructorimpl3, measurePolicyRowMeasurePolicy2, composerM6062constructorimpl3, currentCompositionLocalMap3);
            Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier3, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion2, composerM6062constructorimpl3, Integer.valueOf(iHashCode3), composerM6062constructorimpl3));
            Painter painterPainterResource = PainterResources_androidKt.painterResource(R.drawable.pspdf__ic_stamp, composerStartRestartGroup, 0);
            long jColor = ColorKt.Color(i40Var.b);
            int i4 = Painter.$stable | 48;
            IconKt.m3575Iconww6aTOc(painterPainterResource, "", (Modifier) null, jColor, composerStartRestartGroup, i4, 4);
            SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(companion3, fMo750toDpu2uoSUM), composerStartRestartGroup, 0);
            TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(R.string.pspdf__create_stamp, composerStartRestartGroup, 0), rowScopeInstance.align(companion3, companion.getCenterVertically()), ColorKt.Color(i40Var.b), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 0, 0, 262136);
            composerStartRestartGroup.endNode();
            Alignment.Vertical centerVertically = companion.getCenterVertically();
            Modifier modifierM1222paddingqDBjuR0$default2 = PaddingKt.m1222paddingqDBjuR0$default(companion3, 0.0f, fMo750toDpu2uoSUM2, 0.0f, fMo750toDpu2uoSUM2, 5, null);
            MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(arrangement.getStart(), centerVertically, composerStartRestartGroup, 48);
            int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1222paddingqDBjuR0$default2);
            Function0<ComposeUiNode> constructor4 = companion2.getConstructor();
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor4);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl4 = Updater.m6062constructorimpl(composerStartRestartGroup);
            f2.a(companion2, composerM6062constructorimpl4, measurePolicyRowMeasurePolicy3, composerM6062constructorimpl4, currentCompositionLocalMap4);
            Updater.m6070setimpl(composerM6062constructorimpl4, modifierMaterializeModifier4, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion2, composerM6062constructorimpl4, Integer.valueOf(iHashCode4), composerM6062constructorimpl4));
            d40.a(companion3, stampPickerItem, composerStartRestartGroup, (i3 & 112) | 6);
            IconKt.m3575Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.pspdf__ic_chevron_right, composerStartRestartGroup, 0), "", (Modifier) null, ColorKt.Color(i40Var.b), composerStartRestartGroup, i4, 4);
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endNode();
            TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(R.string.pspdf__stamp_custom_description, composerStartRestartGroup, 0), PaddingKt.m1222paddingqDBjuR0$default(companion3, 0.0f, fMo750toDpu2uoSUM3, 0.0f, fMo750toDpu2uoSUM3, 5, null), ColorKt.Color(i40Var.b), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 0, 0, 262136);
            composerStartRestartGroup = composerStartRestartGroup;
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.c40$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return c40.a(modifier, stampPickerItem, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}

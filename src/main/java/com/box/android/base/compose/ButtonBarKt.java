package com.box.android.base.compose;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.material3.BottomAppBarDefaults;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import com.box.android.base.compose.button.BoxTextButtonKt;
import com.box.android.base.compose.button.model.ButtonItem;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ButtonBar.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u0015\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0004\u001a\u001b\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u0007¢\u0006\u0002\u0010\u0007¨\u0006\b"}, d2 = {"ButtonBar", "", "buttonBars", "Lcom/box/android/base/compose/ImmutableButtonItems;", "(Lcom/box/android/base/compose/ImmutableButtonItems;Landroidx/compose/runtime/Composer;I)V", "", "Lcom/box/android/base/compose/button/model/ButtonItem$TextButtonItem;", "(Ljava/util/List;Landroidx/compose/runtime/Composer;I)V", "base_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ButtonBarKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ButtonBar$lambda$0(ImmutableButtonItems immutableButtonItems, int i, Composer composer, int i2) {
        ButtonBar(immutableButtonItems, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ButtonBar$lambda$2(List list, int i, Composer composer, int i2) {
        ButtonBar((List<ButtonItem.TextButtonItem>) list, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void ButtonBar(final ImmutableButtonItems buttonBars, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(buttonBars, "buttonBars");
        Composer composerStartRestartGroup = composer.startRestartGroup(450331808);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ButtonBar)N(buttonBars)24@948L40:ButtonBar.kt#vejmn0");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(buttonBars) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(450331808, i2, -1, "com.box.android.base.compose.ButtonBar (ButtonBar.kt:23)");
            }
            ButtonBar(buttonBars.getItems(), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.ButtonBarKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ButtonBarKt.ButtonBar$lambda$0(buttonBars, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void ButtonBar(final List<ButtonItem.TextButtonItem> buttonBars, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(buttonBars, "buttonBars");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1590626190);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ButtonBar)N(buttonBars)31@1135L6,33@1232L12,33@1245L17,35@1323L6,29@1069L465:ButtonBar.kt#vejmn0");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(buttonBars) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1590626190, i2, -1, "com.box.android.base.compose.ButtonBar (ButtonBar.kt:28)");
            }
            Modifier modifierM11640topBorderHht5A8o$default = ComposeUtilsKt.m11640topBorderHht5A8o$default(SizeKt.m1252height3ABfNKs(PaddingKt.padding(SizeKt.fillMaxWidth$default(BackgroundKt.m589backgroundbw27NRU$default(Modifier.INSTANCE, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11581getTopLayerBackground0d7_KjU(), null, 2, null), 0.0f, 1, null), WindowInsetsKt.asPaddingValues(BottomAppBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, BottomAppBarDefaults.$stable), composerStartRestartGroup, 0)), Dp.m9687constructorimpl(48)), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11517getDivider0d7_KjU(), 0.0f, 2, null);
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Arrangement.Horizontal end = Arrangement.INSTANCE.getEnd();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(end, centerVertically, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM11640topBorderHht5A8o$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1934063695, "C:ButtonBar.kt#vejmn0");
            composerStartRestartGroup.startReplaceGroup(1600178834);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*40@1499L19");
            Iterator<ButtonItem.TextButtonItem> it = buttonBars.iterator();
            while (it.hasNext()) {
                BoxTextButtonKt.BoxTextButton(it.next(), null, null, composerStartRestartGroup, 0, 6);
            }
            composerStartRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.ButtonBarKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ButtonBarKt.ButtonBar$lambda$2(buttonBars, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}

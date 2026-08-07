package com.box.android.boxai.agents;

import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.CheckKt;
import androidx.compose.material3.AndroidMenu_androidKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import com.box.android.base.compose.BoxTheme;
import com.box.android.domain.models.boxai.AiAgentModel;
import com.facebook.react.modules.dialog.AlertFragment;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxAiAgentPopupMenu.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001aO\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0012\u0010\t\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00010\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\fH\u0007¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"BoxAiAgentPopupMenu", "", "expanded", "", AlertFragment.ARG_ITEMS, "", "Lcom/box/android/domain/models/boxai/AiAgentModel;", "selectedId", "", "onItemSelected", "Lkotlin/Function1;", "onDismissRequest", "Lkotlin/Function0;", "(ZLjava/util/List;Ljava/lang/String;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "boxai_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BoxAiAgentPopupMenuKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiAgentPopupMenu$lambda$1(boolean z, List list, String str, Function1 function1, Function0 function0, int i, Composer composer, int i2) {
        BoxAiAgentPopupMenu(z, list, str, function1, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void BoxAiAgentPopupMenu(final boolean z, final List<AiAgentModel> items, final String str, final Function1<? super AiAgentModel, Unit> onItemSelected, final Function0<Unit> onDismissRequest, Composer composer, final int i) {
        boolean z2;
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(items, "items");
        Intrinsics.checkNotNullParameter(onItemSelected, "onItemSelected");
        Intrinsics.checkNotNullParameter(onDismissRequest, "onDismissRequest");
        Composer composerStartRestartGroup = composer.startRestartGroup(-278762126);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAiAgentPopupMenu)N(expanded,items,selectedId,onItemSelected,onDismissRequest)29@1044L6,30@1073L738,25@862L949:BoxAiAgentPopupMenu.kt#3inxaw");
        if ((i & 6) == 0) {
            z2 = z;
            i2 = (composerStartRestartGroup.changed(z2) ? 4 : 2) | i;
        } else {
            z2 = z;
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(items) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(str) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onItemSelected) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onDismissRequest) ? 16384 : 8192;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 9363) != 9362, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-278762126, i2, -1, "com.box.android.boxai.agents.BoxAiAgentPopupMenu (BoxAiAgentPopupMenu.kt:24)");
            }
            composer2 = composerStartRestartGroup;
            AndroidMenu_androidKt.m2743DropdownMenuIlH_yew(z2, onDismissRequest, TestTagKt.testTag(Modifier.INSTANCE, "BoxAi:AgentDropdown"), 0L, null, null, null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11542getPopupBackground0d7_KjU(), 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(1834054551, true, new Function3() { // from class: com.box.android.boxai.agents.BoxAiAgentPopupMenuKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return BoxAiAgentPopupMenuKt.BoxAiAgentPopupMenu$lambda$0(items, str, onItemSelected, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, (i2 & 14) | 384 | ((i2 >> 9) & 112), 48, 1912);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.agents.BoxAiAgentPopupMenuKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiAgentPopupMenuKt.BoxAiAgentPopupMenu$lambda$1(z, items, str, onItemSelected, onDismissRequest, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiAgentPopupMenu$lambda$0(List list, String str, final Function1 function1, ColumnScope DropdownMenu, Composer composer, int i) {
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(DropdownMenu, "$this$DropdownMenu");
        ComposerKt.sourceInformation(composer2, "C*34@1224L25,35@1274L110,36@1412L22,37@1467L314,33@1160L635:BoxAiAgentPopupMenu.kt#3inxaw");
        if (!composer2.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1834054551, i, -1, "com.box.android.boxai.agents.BoxAiAgentPopupMenu.<anonymous> (BoxAiAgentPopupMenu.kt:31)");
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                final AiAgentModel aiAgentModel = (AiAgentModel) it.next();
                final boolean zAreEqual = Intrinsics.areEqual(aiAgentModel.getId(), str);
                Modifier.Companion companion = Modifier.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer2, 1280545797, "CC(remember):BoxAiAgentPopupMenu.kt#9igjgp");
                boolean zChanged = composer2.changed(zAreEqual);
                Object objRememberedValue = composer2.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.box.android.boxai.agents.BoxAiAgentPopupMenuKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return BoxAiAgentPopupMenuKt.BoxAiAgentPopupMenu$lambda$0$0$0$0(zAreEqual, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(companion, false, (Function1) objRememberedValue, 1, null);
                ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(-1774524708, true, new Function2() { // from class: com.box.android.boxai.agents.BoxAiAgentPopupMenuKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxAiAgentPopupMenuKt.BoxAiAgentPopupMenu$lambda$0$0$1(aiAgentModel, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer2, 54);
                ComposerKt.sourceInformationMarkerStart(composer2, 1280551810, "CC(remember):BoxAiAgentPopupMenu.kt#9igjgp");
                boolean zChanged2 = composer2.changed(function1) | composer2.changedInstance(aiAgentModel);
                Object objRememberedValue2 = composer2.rememberedValue();
                if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.box.android.boxai.agents.BoxAiAgentPopupMenuKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return BoxAiAgentPopupMenuKt.BoxAiAgentPopupMenu$lambda$0$0$2$0(function1, aiAgentModel);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                AndroidMenu_androidKt.DropdownMenuItem(composableLambdaRememberComposableLambda, (Function0) objRememberedValue2, modifierSemantics$default, null, ComposableLambdaKt.rememberComposableLambda(-641457440, true, new Function2() { // from class: com.box.android.boxai.agents.BoxAiAgentPopupMenuKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxAiAgentPopupMenuKt.BoxAiAgentPopupMenu$lambda$0$0$3(zAreEqual, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer2, 54), false, null, null, null, composer2, 24582, 488);
                composer2 = composer;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiAgentPopupMenu$lambda$0$0$0$0(boolean z, SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.setSelected(semantics, z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiAgentPopupMenu$lambda$0$0$1(AiAgentModel aiAgentModel, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C35@1364L6,35@1276L106:BoxAiAgentPopupMenu.kt#3inxaw");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1774524708, i, -1, "com.box.android.boxai.agents.BoxAiAgentPopupMenu.<anonymous>.<anonymous>.<anonymous> (BoxAiAgentPopupMenu.kt:35)");
            }
            String name = aiAgentModel.getName();
            if (name == null) {
                name = aiAgentModel.getId();
            }
            TextKt.m4494TextNvy7gAk(name, null, BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal16(), composer, 0, 0, 131066);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiAgentPopupMenu$lambda$0$0$2$0(Function1 function1, AiAgentModel aiAgentModel) {
        function1.invoke(aiAgentModel);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiAgentPopupMenu$lambda$0$0$3(boolean z, Composer composer, int i) {
        Composer composer2;
        ComposerKt.sourceInformation(composer, "C:BoxAiAgentPopupMenu.kt#3inxaw");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-641457440, i, -1, "com.box.android.boxai.agents.BoxAiAgentPopupMenu.<anonymous>.<anonymous>.<anonymous> (BoxAiAgentPopupMenu.kt:38)");
            }
            if (z) {
                composer.startReplaceGroup(-1349025136);
                ComposerKt.sourceInformation(composer, "41@1643L6,39@1531L210");
                composer2 = composer;
                IconKt.m3576Iconww6aTOc(CheckKt.getCheck(Icons.Filled.INSTANCE), (String) null, (Modifier) null, BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), composer2, 48, 4);
            } else {
                composer2 = composer;
                composer2.startReplaceGroup(-1350551390);
            }
            composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}

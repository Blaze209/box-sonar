package com.box.android.tasks.addtask.ui;

import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.material3.InteractiveComponentSizeKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.box.android.base.compose.BoxCheckBoxKt;
import com.box.android.base.compose.BoxColorsKt;
import com.box.android.base.compose.BoxSwitchKt;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.textfield.BoxOutlinedTextFieldKt;
import com.box.android.base.models.UserMiniUIModel;
import com.box.android.cpl.Store;
import com.box.android.domain.models.tasks.CompletionRule;
import com.box.android.tasks.R;
import com.box.android.tasks.addtask.cpl.AddTaskFormReducer;
import com.box.android.tasks.addtask.cpl.AssigneePickerReducer;
import com.box.android.tasks.ui.AssigneeChipFieldKt;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AddTaskFormContent.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000<\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a3\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0012\u0010\u0004\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\t\u001a5\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00102\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0003¢\u0006\u0002\u0010\u0011\u001a;\u0010\u0012\u001a\u00020\u00012\u0006\u0010\u0013\u001a\u00020\u000e2\u0012\u0010\u0014\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\u00152\u0006\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0003¢\u0006\u0002\u0010\u0016¨\u0006\u0017"}, d2 = {"AddTaskFormContent", "", "state", "Lcom/box/android/tasks/addtask/cpl/AddTaskFormReducer$State;", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/tasks/addtask/cpl/AddTaskFormReducer$Action;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/box/android/tasks/addtask/cpl/AddTaskFormReducer$State;Lcom/box/android/cpl/Store;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "CompletionRuleRow", "completionRule", "Lcom/box/android/domain/models/tasks/CompletionRule;", "enabled", "", "onToggle", "Lkotlin/Function0;", "(Lcom/box/android/domain/models/tasks/CompletionRule;ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "DueDateEnableRow", "isDueDateEnabled", "onDueDateEnabledChange", "Lkotlin/Function1;", "(ZLkotlin/jvm/functions/Function1;ZLandroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "tasks_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AddTaskFormContentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddTaskFormContent$lambda$1(AddTaskFormReducer.State state, Store store, Modifier modifier, int i, int i2, Composer composer, int i3) {
        AddTaskFormContent(state, store, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CompletionRuleRow$lambda$1(CompletionRule completionRule, boolean z, Function0 function0, Modifier modifier, int i, int i2, Composer composer, int i3) {
        CompletionRuleRow(completionRule, z, function0, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DueDateEnableRow$lambda$1(boolean z, Function1 function1, boolean z2, Modifier modifier, int i, int i2, Composer composer, int i3) {
        DueDateEnableRow(z, function1, z2, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0311  */
    /* JADX WARN: Code duplicated, block: B:104:0x0340  */
    /* JADX WARN: Code duplicated, block: B:108:0x0356  */
    /* JADX WARN: Code duplicated, block: B:113:0x0366  */
    /* JADX WARN: Code duplicated, block: B:116:0x03a7  */
    /* JADX WARN: Code duplicated, block: B:118:0x03ad  */
    /* JADX WARN: Code duplicated, block: B:121:0x03b7  */
    /* JADX WARN: Code duplicated, block: B:123:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x0065  */
    /* JADX WARN: Code duplicated, block: B:31:0x0067  */
    /* JADX WARN: Code duplicated, block: B:34:0x0070 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x0072  */
    /* JADX WARN: Code duplicated, block: B:36:0x0077  */
    /* JADX WARN: Code duplicated, block: B:39:0x007e  */
    /* JADX WARN: Code duplicated, block: B:42:0x0124  */
    /* JADX WARN: Code duplicated, block: B:45:0x0130  */
    /* JADX WARN: Code duplicated, block: B:46:0x0134  */
    /* JADX WARN: Code duplicated, block: B:49:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:50:0x01b8  */
    /* JADX WARN: Code duplicated, block: B:55:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:58:0x021a  */
    /* JADX WARN: Code duplicated, block: B:59:0x021c  */
    /* JADX WARN: Code duplicated, block: B:64:0x022c  */
    /* JADX WARN: Code duplicated, block: B:67:0x0242  */
    /* JADX WARN: Code duplicated, block: B:68:0x0244  */
    /* JADX WARN: Code duplicated, block: B:73:0x0254  */
    /* JADX WARN: Code duplicated, block: B:76:0x0269  */
    /* JADX WARN: Code duplicated, block: B:77:0x026b  */
    /* JADX WARN: Code duplicated, block: B:82:0x027b  */
    /* JADX WARN: Code duplicated, block: B:85:0x0291  */
    /* JADX WARN: Code duplicated, block: B:86:0x0293  */
    /* JADX WARN: Code duplicated, block: B:91:0x02a3  */
    /* JADX WARN: Code duplicated, block: B:94:0x02e8  */
    /* JADX WARN: Code duplicated, block: B:96:0x02ff  */
    /* JADX WARN: Code duplicated, block: B:97:0x0301  */
    public static final void AddTaskFormContent(final AddTaskFormReducer.State state, final Store<AddTaskFormReducer.State, AddTaskFormReducer.Action> store, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        boolean z;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        List<UserMiniUIModel> selected;
        float f;
        Function0<ComposeUiNode> constructor;
        int i4;
        boolean z2;
        Object objRememberedValue;
        boolean z3;
        Object objRememberedValue2;
        boolean z4;
        Object objRememberedValue3;
        boolean z5;
        Object objRememberedValue4;
        boolean z6;
        Object objRememberedValue5;
        boolean z7;
        boolean z8;
        Object objRememberedValue6;
        boolean z9;
        Object objRememberedValue7;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(store, "store");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1267632336);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AddTaskFormContent)N(state,store,modifier)49@2179L21,51@2206L2245:AddTaskFormContent.kt#184uln");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(state) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(store) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i3 & Token.DOTQUERY) != 146) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                if (i5 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1267632336, i3, -1, "com.box.android.tasks.addtask.ui.AddTaskFormContent (AddTaskFormContent.kt:40)");
                }
                selected = state.getAssigneePickerState().getSelected();
                String query = state.getAssigneePickerState().getQuery();
                List<UserMiniUIModel> suggestions = state.getAssigneePickerState().getSuggestions();
                boolean zIsLoading = state.getAssigneePickerState().isLoading();
                boolean invalidUser = state.getAssigneePickerState().getInvalidUser();
                boolean z10 = !state.isSubmitting();
                f = 16;
                Modifier modifierM1219paddingVpY3zN4 = PaddingKt.m1219paddingVpY3zN4(WindowInsetsPadding_androidKt.imePadding(ScrollKt.verticalScroll$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), false, null, false, 14, null)), Dp.m9687constructorimpl(24), Dp.m9687constructorimpl(f));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1219paddingVpY3zN4);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1981815224, "C60@2495L60,58@2412L561,75@3099L98,77@3269L102,78@3396L101,81@3616L96,72@2983L833,97@4274L67,95@4164L281:AddTaskFormContent.kt#184uln");
                Modifier modifier4 = companion;
                String message = state.getMessage();
                Modifier modifierTestTag = TestTagKt.testTag(PaddingKt.m1222paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, 0.0f, 0.0f, Dp.m9687constructorimpl(f), 7, null), "AddTask:MessageField");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213164458, "CC(remember):AddTaskFormContent.kt#9igjgp");
                i4 = i3 & 112;
                if (i4 == 32) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.box.android.tasks.addtask.ui.AddTaskFormContentKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AddTaskFormContentKt.AddTaskFormContent$lambda$0$0$0(store, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                BoxOutlinedTextFieldKt.m11739BoxOutlinedTextFieldhtLuCmU(message, (Function1) objRememberedValue, modifierTestTag, z10, ComposableSingletons$AddTaskFormContentKt.INSTANCE.getLambda$1402067977$tasks_generalProdRelease(), ComposableSingletons$AddTaskFormContentKt.INSTANCE.getLambda$1645604840$tasks_generalProdRelease(), 2, 4, false, 0L, null, null, composerStartRestartGroup, 14377344, 0, 3840);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213145092, "CC(remember):AddTaskFormContent.kt#9igjgp");
                if (i4 == 32) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z3 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: com.box.android.tasks.addtask.ui.AddTaskFormContentKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AddTaskFormContentKt.AddTaskFormContent$lambda$0$1$0(store, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                Function1 function1 = (Function1) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213139648, "CC(remember):AddTaskFormContent.kt#9igjgp");
                if (i4 == 32) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!z4 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function1() { // from class: com.box.android.tasks.addtask.ui.AddTaskFormContentKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AddTaskFormContentKt.AddTaskFormContent$lambda$0$2$0(store, (UserMiniUIModel) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                Function1 function2 = (Function1) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213135585, "CC(remember):AddTaskFormContent.kt#9igjgp");
                if (i4 == 32) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (!z5 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new Function1() { // from class: com.box.android.tasks.addtask.ui.AddTaskFormContentKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AddTaskFormContentKt.AddTaskFormContent$lambda$0$3$0(store, (UserMiniUIModel) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                Function1 function3 = (Function1) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213128550, "CC(remember):AddTaskFormContent.kt#9igjgp");
                if (i4 == 32) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (!z6 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue5 = new Function0() { // from class: com.box.android.tasks.addtask.ui.AddTaskFormContentKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return AddTaskFormContentKt.AddTaskFormContent$lambda$0$4$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                AssigneeChipFieldKt.AssigneeChipField(selected, query, function1, suggestions, function2, function3, zIsLoading, invalidUser, (Function0) objRememberedValue5, z10, PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m9687constructorimpl(f), 7, null), composerStartRestartGroup, 0, 6, 0);
                z7 = z10;
                composerStartRestartGroup = composerStartRestartGroup;
                if (selected.size() > 1) {
                    composerStartRestartGroup.startReplaceGroup(1979358504);
                } else {
                    composerStartRestartGroup.startReplaceGroup(1983188120);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "90@4006L63,87@3864L280");
                    CompletionRule completionRule = state.getCompletionRule();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213116103, "CC(remember):AddTaskFormContent.kt#9igjgp");
                    if (i4 == 32) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (!z9 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue7 = new Function0() { // from class: com.box.android.tasks.addtask.ui.AddTaskFormContentKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return AddTaskFormContentKt.AddTaskFormContent$lambda$0$5$0(store);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    CompletionRuleRow(completionRule, z7, (Function0) objRememberedValue7, PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m9687constructorimpl(f), 7, null), composerStartRestartGroup, 3072, 0);
                    z7 = z7;
                }
                composerStartRestartGroup.endReplaceGroup();
                boolean zIsDueDateEnabled = state.isDueDateEnabled();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213107523, "CC(remember):AddTaskFormContent.kt#9igjgp");
                z8 = i4 == 32;
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (!z8 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue6 = new Function1() { // from class: com.box.android.tasks.addtask.ui.AddTaskFormContentKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AddTaskFormContentKt.AddTaskFormContent$lambda$0$6$0(store, ((Boolean) obj).booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                DueDateEnableRow(zIsDueDateEnabled, (Function1) objRememberedValue6, z7, PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m9687constructorimpl(f), 7, null), composerStartRestartGroup, 3072, 0);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.tasks.addtask.ui.AddTaskFormContentKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AddTaskFormContentKt.AddTaskFormContent$lambda$1(state, store, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        if ((i3 & Token.DOTQUERY) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i5 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1267632336, i3, -1, "com.box.android.tasks.addtask.ui.AddTaskFormContent (AddTaskFormContent.kt:40)");
            }
            selected = state.getAssigneePickerState().getSelected();
            String query2 = state.getAssigneePickerState().getQuery();
            List<UserMiniUIModel> suggestions2 = state.getAssigneePickerState().getSuggestions();
            boolean zIsLoading2 = state.getAssigneePickerState().isLoading();
            boolean invalidUser2 = state.getAssigneePickerState().getInvalidUser();
            boolean z11 = !state.isSubmitting();
            f = 16;
            Modifier modifierM1219paddingVpY3zN5 = PaddingKt.m1219paddingVpY3zN4(WindowInsetsPadding_androidKt.imePadding(ScrollKt.verticalScroll$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), false, null, false, 14, null)), Dp.m9687constructorimpl(24), Dp.m9687constructorimpl(f));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1219paddingVpY3zN5);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
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
            Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1981815224, "C60@2495L60,58@2412L561,75@3099L98,77@3269L102,78@3396L101,81@3616L96,72@2983L833,97@4274L67,95@4164L281:AddTaskFormContent.kt#184uln");
            Modifier modifier5 = companion;
            String message2 = state.getMessage();
            Modifier modifierTestTag2 = TestTagKt.testTag(PaddingKt.m1222paddingqDBjuR0$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), 0.0f, 0.0f, 0.0f, Dp.m9687constructorimpl(f), 7, null), "AddTask:MessageField");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213164458, "CC(remember):AddTaskFormContent.kt#9igjgp");
            i4 = i3 & 112;
            if (i4 == 32) {
                z2 = true;
            } else {
                z2 = false;
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z2) {
                objRememberedValue = new Function1() { // from class: com.box.android.tasks.addtask.ui.AddTaskFormContentKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AddTaskFormContentKt.AddTaskFormContent$lambda$0$0$0(store, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function1() { // from class: com.box.android.tasks.addtask.ui.AddTaskFormContentKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AddTaskFormContentKt.AddTaskFormContent$lambda$0$0$0(store, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BoxOutlinedTextFieldKt.m11739BoxOutlinedTextFieldhtLuCmU(message2, (Function1) objRememberedValue, modifierTestTag2, z11, ComposableSingletons$AddTaskFormContentKt.INSTANCE.getLambda$1402067977$tasks_generalProdRelease(), ComposableSingletons$AddTaskFormContentKt.INSTANCE.getLambda$1645604840$tasks_generalProdRelease(), 2, 4, false, 0L, null, null, composerStartRestartGroup, 14377344, 0, 3840);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213145092, "CC(remember):AddTaskFormContent.kt#9igjgp");
            if (i4 == 32) {
                z3 = true;
            } else {
                z3 = false;
            }
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!z3) {
                objRememberedValue2 = new Function1() { // from class: com.box.android.tasks.addtask.ui.AddTaskFormContentKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AddTaskFormContentKt.AddTaskFormContent$lambda$0$1$0(store, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new Function1() { // from class: com.box.android.tasks.addtask.ui.AddTaskFormContentKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AddTaskFormContentKt.AddTaskFormContent$lambda$0$1$0(store, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Function1 function4 = (Function1) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213139648, "CC(remember):AddTaskFormContent.kt#9igjgp");
            if (i4 == 32) {
                z4 = true;
            } else {
                z4 = false;
            }
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (!z4) {
                objRememberedValue3 = new Function1() { // from class: com.box.android.tasks.addtask.ui.AddTaskFormContentKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AddTaskFormContentKt.AddTaskFormContent$lambda$0$2$0(store, (UserMiniUIModel) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new Function1() { // from class: com.box.android.tasks.addtask.ui.AddTaskFormContentKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AddTaskFormContentKt.AddTaskFormContent$lambda$0$2$0(store, (UserMiniUIModel) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            Function1 function5 = (Function1) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213135585, "CC(remember):AddTaskFormContent.kt#9igjgp");
            if (i4 == 32) {
                z5 = true;
            } else {
                z5 = false;
            }
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (!z5) {
                objRememberedValue4 = new Function1() { // from class: com.box.android.tasks.addtask.ui.AddTaskFormContentKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AddTaskFormContentKt.AddTaskFormContent$lambda$0$3$0(store, (UserMiniUIModel) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            } else {
                objRememberedValue4 = new Function1() { // from class: com.box.android.tasks.addtask.ui.AddTaskFormContentKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AddTaskFormContentKt.AddTaskFormContent$lambda$0$3$0(store, (UserMiniUIModel) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            Function1 function6 = (Function1) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213128550, "CC(remember):AddTaskFormContent.kt#9igjgp");
            if (i4 == 32) {
                z6 = true;
            } else {
                z6 = false;
            }
            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (!z6) {
                objRememberedValue5 = new Function0() { // from class: com.box.android.tasks.addtask.ui.AddTaskFormContentKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AddTaskFormContentKt.AddTaskFormContent$lambda$0$4$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            } else {
                objRememberedValue5 = new Function0() { // from class: com.box.android.tasks.addtask.ui.AddTaskFormContentKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AddTaskFormContentKt.AddTaskFormContent$lambda$0$4$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            AssigneeChipFieldKt.AssigneeChipField(selected, query2, function4, suggestions2, function5, function6, zIsLoading2, invalidUser2, (Function0) objRememberedValue5, z11, PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m9687constructorimpl(f), 7, null), composerStartRestartGroup, 0, 6, 0);
            z7 = z11;
            composerStartRestartGroup = composerStartRestartGroup;
            if (selected.size() > 1) {
                composerStartRestartGroup.startReplaceGroup(1979358504);
            } else {
                composerStartRestartGroup.startReplaceGroup(1983188120);
                ComposerKt.sourceInformation(composerStartRestartGroup, "90@4006L63,87@3864L280");
                CompletionRule completionRule2 = state.getCompletionRule();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213116103, "CC(remember):AddTaskFormContent.kt#9igjgp");
                if (i4 == 32) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (!z9) {
                    objRememberedValue7 = new Function0() { // from class: com.box.android.tasks.addtask.ui.AddTaskFormContentKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return AddTaskFormContentKt.AddTaskFormContent$lambda$0$5$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                } else {
                    objRememberedValue7 = new Function0() { // from class: com.box.android.tasks.addtask.ui.AddTaskFormContentKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return AddTaskFormContentKt.AddTaskFormContent$lambda$0$5$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                CompletionRuleRow(completionRule2, z7, (Function0) objRememberedValue7, PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m9687constructorimpl(f), 7, null), composerStartRestartGroup, 3072, 0);
                z7 = z7;
            }
            composerStartRestartGroup.endReplaceGroup();
            boolean zIsDueDateEnabled2 = state.isDueDateEnabled();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -213107523, "CC(remember):AddTaskFormContent.kt#9igjgp");
            if (i4 == 32) {
            }
            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (!z8) {
                objRememberedValue6 = new Function1() { // from class: com.box.android.tasks.addtask.ui.AddTaskFormContentKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AddTaskFormContentKt.AddTaskFormContent$lambda$0$6$0(store, ((Boolean) obj).booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            } else {
                objRememberedValue6 = new Function1() { // from class: com.box.android.tasks.addtask.ui.AddTaskFormContentKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AddTaskFormContentKt.AddTaskFormContent$lambda$0$6$0(store, ((Boolean) obj).booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            DueDateEnableRow(zIsDueDateEnabled2, (Function1) objRememberedValue6, z7, PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m9687constructorimpl(f), 7, null), composerStartRestartGroup, 3072, 0);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.tasks.addtask.ui.AddTaskFormContentKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AddTaskFormContentKt.AddTaskFormContent$lambda$1(state, store, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddTaskFormContent$lambda$0$0$0(Store store, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        store.send(new AddTaskFormReducer.Action.MessageChanged(it));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddTaskFormContent$lambda$0$1$0(Store store, String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        store.send(new AddTaskFormReducer.Action.Assignees(new AssigneePickerReducer.Action.QueryChanged(it)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddTaskFormContent$lambda$0$2$0(Store store, UserMiniUIModel it) {
        Intrinsics.checkNotNullParameter(it, "it");
        store.send(new AddTaskFormReducer.Action.Assignees(new AssigneePickerReducer.Action.AssigneeSelected(it)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddTaskFormContent$lambda$0$3$0(Store store, UserMiniUIModel it) {
        Intrinsics.checkNotNullParameter(it, "it");
        store.send(new AddTaskFormReducer.Action.Assignees(new AssigneePickerReducer.Action.AssigneeRemoved(it)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddTaskFormContent$lambda$0$4$0(Store store) {
        store.send(new AddTaskFormReducer.Action.Assignees(AssigneePickerReducer.Action.QueryFocusLost.INSTANCE));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddTaskFormContent$lambda$0$5$0(Store store) {
        store.send(AddTaskFormReducer.Action.CompletionRuleToggled.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddTaskFormContent$lambda$0$6$0(Store store, boolean z) {
        store.send(new AddTaskFormReducer.Action.DueDateEnabledChanged(z));
        return Unit.INSTANCE;
    }

    private static final void CompletionRuleRow(final CompletionRule completionRule, final boolean z, final Function0<Unit> function0, final Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(1445366921);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CompletionRuleRow)N(completionRule,enabled,onToggle,modifier)113@4907L742,113@4820L829:AddTaskFormContent.kt#184uln");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(completionRule.ordinal()) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        int i4 = i2 & 8;
        if (i4 != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 2048 : 1024;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1445366921, i3, -1, "com.box.android.tasks.addtask.ui.CompletionRuleRow (AddTaskFormContent.kt:110)");
            }
            CompositionLocalKt.CompositionLocalProvider(InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentSize().provides(Dp.m9685boximpl(Dp.INSTANCE.m9707getUnspecifiedD9Ej5fM())), ComposableLambdaKt.rememberComposableLambda(835788745, true, new Function2() { // from class: com.box.android.tasks.addtask.ui.AddTaskFormContentKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AddTaskFormContentKt.CompletionRuleRow$lambda$0(modifier, completionRule, function0, z, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        final Modifier modifier2 = modifier;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.tasks.addtask.ui.AddTaskFormContentKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AddTaskFormContentKt.CompletionRuleRow$lambda$1(completionRule, z, function0, modifier2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CompletionRuleRow$lambda$0(Modifier modifier, CompletionRule completionRule, final Function0 function0, boolean z, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C114@4917L726:AddTaskFormContent.kt#184uln");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(835788745, i, -1, "com.box.android.tasks.addtask.ui.CompletionRuleRow.<anonymous> (AddTaskFormContent.kt:114)");
            }
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            Modifier modifierTestTag = TestTagKt.testTag(SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null), "AddTask:CompletionRuleRow");
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer, 48);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierTestTag);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1435498527, "C122@5244L14,120@5124L241,128@5408L51,129@5499L10,130@5554L6,127@5379L254:AddTaskFormContent.kt#184uln");
            boolean z2 = completionRule == CompletionRule.ANY_ASSIGNEE;
            Modifier modifierM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m9687constructorimpl(10), 0.0f, 11, null);
            ComposerKt.sourceInformationMarkerStart(composer, -1985965709, "CC(remember):AddTaskFormContent.kt#9igjgp");
            boolean zChanged = composer.changed(function0);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.tasks.addtask.ui.AddTaskFormContentKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AddTaskFormContentKt.CompletionRuleRow$lambda$0$0$0$0(function0, ((Boolean) obj).booleanValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BoxCheckBoxKt.BoxCheckbox(modifierM1222paddingqDBjuR0$default, z2, (Function1) objRememberedValue, z, composer, 6, 0);
            TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(R.string.add_task_any_assignee_rule, composer, 0), RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodySmall(), composer, 0, 0, 131064);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
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
    public static final Unit CompletionRuleRow$lambda$0$0$0$0(Function0 function0, boolean z) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    private static final void DueDateEnableRow(final boolean z, final Function1<? super Boolean, Unit> function1, final boolean z2, final Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(1290098465);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(DueDateEnableRow)N(isDueDateEnabled,onDueDateEnabledChange,enabled,modifier)146@6118L818,146@6031L905:AddTaskFormContent.kt#184uln");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
        }
        int i4 = i2 & 8;
        if (i4 != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 2048 : 1024;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1290098465, i3, -1, "com.box.android.tasks.addtask.ui.DueDateEnableRow (AddTaskFormContent.kt:143)");
            }
            CompositionLocalKt.CompositionLocalProvider(InteractiveComponentSizeKt.getLocalMinimumInteractiveComponentSize().provides(Dp.m9685boximpl(Dp.INSTANCE.m9707getUnspecifiedD9Ej5fM())), ComposableLambdaKt.rememberComposableLambda(1358375521, true, new Function2() { // from class: com.box.android.tasks.addtask.ui.AddTaskFormContentKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AddTaskFormContentKt.DueDateEnableRow$lambda$0(modifier, z2, z, function1, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        final Modifier modifier2 = modifier;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.tasks.addtask.ui.AddTaskFormContentKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AddTaskFormContentKt.DueDateEnableRow$lambda$1(z, function1, z2, modifier2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DueDateEnableRow$lambda$0(Modifier modifier, boolean z, boolean z2, Function1 function1, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C147@6128L802:AddTaskFormContent.kt#184uln");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1358375521, i, -1, "com.box.android.tasks.addtask.ui.DueDateEnableRow.<anonymous> (AddTaskFormContent.kt:147)");
            }
            Modifier modifierTestTag = TestTagKt.testTag(SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null), "AddTask:DueDateEnableRow");
            Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, centerVertically, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierTestTag);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 796359706, "C155@6425L58,157@6575L6,154@6396L275,160@6684L236:AddTaskFormContent.kt#184uln");
            TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(R.string.add_task_select_due_date_optional, composer, 0), RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), BoxColorsKt.m11587enabledek8zF_U$default(BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), z, 0.0f, 2, null), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal16(), composer, 0, 0, 131064);
            BoxSwitchKt.BoxSwitch(z2, function1, TestTagKt.testTag(Modifier.INSTANCE, "AddTask:DueDateEnableSwitch"), z, composer, 384, 0);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
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
}

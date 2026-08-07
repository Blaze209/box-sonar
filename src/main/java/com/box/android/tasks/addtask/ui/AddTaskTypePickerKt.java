package com.box.android.tasks.addtask.ui;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.AssignmentTurnedInKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.ListItemColors;
import androidx.compose.material3.ListItemDefaults;
import androidx.compose.material3.ListItemKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.VectorPainter;
import androidx.compose.ui.graphics.vector.VectorPainterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.box.android.base.compose.BoxTheme;
import com.box.android.domain.models.tasks.TaskType;
import com.box.android.tasks.R;
import external.sdk.pendo.io.mozilla.javascript.Token;
import io.split.android.client.service.ServiceConstants;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AddTaskTypePicker.kt */
/* JADX INFO: loaded from: classes13.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a+\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0001¢\u0006\u0002\u0010\u0007\u001a3\u0010\b\u001a\u00020\u00012\u0006\u0010\t\u001a\u00020\u00042\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u0006H\u0003¢\u0006\u0002\u0010\n¨\u0006\u000b"}, d2 = {"AddTaskTypePickerContent", "", "onSelect", "Lkotlin/Function1;", "Lcom/box/android/domain/models/tasks/TaskType;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "AddTaskTypeRow", ServiceConstants.TASK_INFO_FIELD_TYPE, "(Lcom/box/android/domain/models/tasks/TaskType;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "tasks_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AddTaskTypePickerKt {

    /* JADX INFO: compiled from: AddTaskTypePicker.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[TaskType.values().length];
            try {
                iArr[TaskType.GENERAL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[TaskType.APPROVAL.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddTaskTypePickerContent$lambda$1(Function1 function1, Modifier modifier, int i, int i2, Composer composer, int i3) {
        AddTaskTypePickerContent(function1, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddTaskTypeRow$lambda$4(TaskType taskType, Function1 function1, Modifier modifier, int i, int i2, Composer composer, int i3) {
        AddTaskTypeRow(taskType, function1, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x004d  */
    /* JADX WARN: Code duplicated, block: B:24:0x004f  */
    /* JADX WARN: Code duplicated, block: B:27:0x0058 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:28:0x005a  */
    /* JADX WARN: Code duplicated, block: B:29:0x005f  */
    /* JADX WARN: Code duplicated, block: B:32:0x0066  */
    /* JADX WARN: Code duplicated, block: B:35:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:38:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:39:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:42:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:44:0x01ae  */
    /* JADX WARN: Code duplicated, block: B:47:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:49:? A[RETURN, SYNTHETIC] */
    public static final void AddTaskTypePickerContent(Function1<? super TaskType, Unit> function1, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        final Modifier modifier2;
        boolean z;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        Function0<ComposeUiNode> constructor;
        final Function1<? super TaskType, Unit> onSelect = function1;
        Intrinsics.checkNotNullParameter(onSelect, "onSelect");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1136253070);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AddTaskTypePickerContent)N(onSelect,modifier)43@1832L630:AddTaskTypePicker.kt#184uln");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(onSelect) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            if ((i3 & 19) != 18) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
            } else {
                if (i4 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1136253070, i3, -1, "com.box.android.tasks.addtask.ui.AddTaskTypePickerContent (AddTaskTypePicker.kt:42)");
                }
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1148524160, "C45@1910L33,46@1979L10,47@2031L6,44@1885L221,51@2116L164,57@2290L166:AddTaskTypePicker.kt#184uln");
                TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(R.string.add_task, composerStartRestartGroup, 0), PaddingKt.m1218padding3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(24)), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getTitleLarge(), composerStartRestartGroup, 48, 0, 131064);
                int i5 = ((i3 << 3) & 112) | 390;
                Modifier modifier3 = companion;
                AddTaskTypeRow(TaskType.GENERAL, onSelect, TestTagKt.testTag(Modifier.INSTANCE, "AddTask:GeneralOption"), composerStartRestartGroup, i5, 0);
                onSelect = function1;
                AddTaskTypeRow(TaskType.APPROVAL, onSelect, TestTagKt.testTag(Modifier.INSTANCE, "AddTask:ApprovalOption"), composerStartRestartGroup, i5, 0);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.tasks.addtask.ui.AddTaskTypePickerKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AddTaskTypePickerKt.AddTaskTypePickerContent$lambda$1(onSelect, modifier2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        if ((i3 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i4 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1136253070, i3, -1, "com.box.android.tasks.addtask.ui.AddTaskTypePickerContent (AddTaskTypePicker.kt:42)");
            }
            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default2);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1148524160, "C45@1910L33,46@1979L10,47@2031L6,44@1885L221,51@2116L164,57@2290L166:AddTaskTypePicker.kt#184uln");
            TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(R.string.add_task, composerStartRestartGroup, 0), PaddingKt.m1218padding3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(24)), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getTitleLarge(), composerStartRestartGroup, 48, 0, 131064);
            int i6 = ((i3 << 3) & 112) | 390;
            Modifier modifier4 = companion;
            AddTaskTypeRow(TaskType.GENERAL, onSelect, TestTagKt.testTag(Modifier.INSTANCE, "AddTask:GeneralOption"), composerStartRestartGroup, i6, 0);
            onSelect = function1;
            AddTaskTypeRow(TaskType.APPROVAL, onSelect, TestTagKt.testTag(Modifier.INSTANCE, "AddTask:ApprovalOption"), composerStartRestartGroup, i6, 0);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier4;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.tasks.addtask.ui.AddTaskTypePickerKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AddTaskTypePickerKt.AddTaskTypePickerContent$lambda$1(onSelect, modifier2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0062  */
    /* JADX WARN: Code duplicated, block: B:31:0x0064  */
    /* JADX WARN: Code duplicated, block: B:34:0x006d A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x006f  */
    /* JADX WARN: Code duplicated, block: B:36:0x0074  */
    /* JADX WARN: Code duplicated, block: B:39:0x007b  */
    /* JADX WARN: Code duplicated, block: B:42:0x008b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:43:0x008d  */
    /* JADX WARN: Code duplicated, block: B:44:0x0090  */
    /* JADX WARN: Code duplicated, block: B:46:0x0096  */
    /* JADX WARN: Code duplicated, block: B:49:0x00a2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:50:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:51:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:53:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:56:0x00b9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:57:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:58:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:60:0x00df  */
    /* JADX WARN: Code duplicated, block: B:63:0x010b  */
    /* JADX WARN: Code duplicated, block: B:64:0x010d  */
    /* JADX WARN: Code duplicated, block: B:67:0x0112  */
    /* JADX WARN: Code duplicated, block: B:72:0x0123  */
    /* JADX WARN: Code duplicated, block: B:75:0x01cf  */
    /* JADX WARN: Code duplicated, block: B:77:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:80:0x01df  */
    /* JADX WARN: Code duplicated, block: B:82:? A[RETURN, SYNTHETIC] */
    private static final void AddTaskTypeRow(final TaskType taskType, final Function1<? super TaskType, Unit> function1, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        boolean z;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        int i4;
        final int i5;
        int i6;
        int i7;
        int i8;
        VectorPainter vectorPainterPainterResource;
        boolean z2;
        boolean z3;
        Object objRememberedValue;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1181680048);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AddTaskTypeRow)N(taskType,onSelect,modifier)113@4226L22,114@4284L42,82@3174L205,89@3409L216,96@3652L493,81@3138L1194:AddTaskTypePicker.kt#184uln");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(taskType.ordinal()) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i9 = i2 & 4;
        if (i9 == 0) {
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
                if (i9 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1181680048, i3, -1, "com.box.android.tasks.addtask.ui.AddTaskTypeRow (AddTaskTypePicker.kt:66)");
                }
                i4 = WhenMappings.$EnumSwitchMapping$0[taskType.ordinal()];
                if (i4 != 1) {
                    i5 = R.string.add_task_general_title;
                } else {
                    if (i4 == 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    i5 = R.string.add_task_approval_title;
                }
                i6 = WhenMappings.$EnumSwitchMapping$0[taskType.ordinal()];
                if (i6 != 1) {
                    i7 = R.string.add_task_general_subtitle;
                } else {
                    if (i6 == 2) {
                        throw new NoWhenBranchMatchedException();
                    }
                    i7 = R.string.add_task_approval_subtitle;
                }
                i8 = WhenMappings.$EnumSwitchMapping$0[taskType.ordinal()];
                if (i8 != 1) {
                    composerStartRestartGroup.startReplaceGroup(-1723143448);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "77@3001L56");
                    VectorPainter vectorPainterRememberVectorPainter = VectorPainterKt.rememberVectorPainter(AssignmentTurnedInKt.getAssignmentTurnedIn(Icons.Outlined.INSTANCE), composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                    vectorPainterPainterResource = vectorPainterRememberVectorPainter;
                } else {
                    if (i8 == 2) {
                        composerStartRestartGroup.startReplaceGroup(-1723144799);
                        composerStartRestartGroup.endReplaceGroup();
                        throw new NoWhenBranchMatchedException();
                    }
                    composerStartRestartGroup.startReplaceGroup(-1723140713);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "78@3087L39");
                    vectorPainterPainterResource = PainterResources_androidKt.painterResource(R.drawable.approval_24, composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                }
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1723104282, "CC(remember):AddTaskTypePicker.kt#9igjgp");
                if ((i3 & 112) == 32) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                z3 = z2 | ((i3 & 14) == 4);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.box.android.tasks.addtask.ui.AddTaskTypePickerKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return AddTaskTypePickerKt.AddTaskTypeRow$lambda$0$0(function1, taskType);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierM632clickableoSLSa3U$default = ClickableKt.m632clickableoSLSa3U$default(modifierFillMaxWidth$default, false, null, null, null, (Function0) objRememberedValue, 15, null);
                final int i10 = i7;
                final Painter painter = vectorPainterPainterResource;
                Modifier modifier4 = companion;
                ListItemColors listItemColorsM3668colorsJ08w3E = ListItemDefaults.INSTANCE.m3668colorsJ08w3E(Color.INSTANCE.m6849getTransparent0d7_KjU(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, (ListItemDefaults.$stable << 27) | 6, 510);
                composerStartRestartGroup = composerStartRestartGroup;
                ListItemKt.m3695ListItemHXNGIdc(ComposableLambdaKt.rememberComposableLambda(-507379406, true, new Function2() { // from class: com.box.android.tasks.addtask.ui.AddTaskTypePickerKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AddTaskTypePickerKt.AddTaskTypeRow$lambda$1(i5, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), modifierM632clickableoSLSa3U$default, null, ComposableLambdaKt.rememberComposableLambda(-1642122865, true, new Function2() { // from class: com.box.android.tasks.addtask.ui.AddTaskTypePickerKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AddTaskTypePickerKt.AddTaskTypeRow$lambda$2(i10, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(842940846, true, new Function2() { // from class: com.box.android.tasks.addtask.ui.AddTaskTypePickerKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AddTaskTypePickerKt.AddTaskTypeRow$lambda$3(painter, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), null, listItemColorsM3668colorsJ08w3E, 0.0f, 0.0f, composerStartRestartGroup, 27654, 420);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.tasks.addtask.ui.AddTaskTypePickerKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AddTaskTypePickerKt.AddTaskTypeRow$lambda$4(taskType, function1, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
            if (i9 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1181680048, i3, -1, "com.box.android.tasks.addtask.ui.AddTaskTypeRow (AddTaskTypePicker.kt:66)");
            }
            i4 = WhenMappings.$EnumSwitchMapping$0[taskType.ordinal()];
            if (i4 != 1) {
                i5 = R.string.add_task_general_title;
            } else {
                if (i4 == 2) {
                    throw new NoWhenBranchMatchedException();
                }
                i5 = R.string.add_task_approval_title;
            }
            i6 = WhenMappings.$EnumSwitchMapping$0[taskType.ordinal()];
            if (i6 != 1) {
                i7 = R.string.add_task_general_subtitle;
            } else {
                if (i6 == 2) {
                    throw new NoWhenBranchMatchedException();
                }
                i7 = R.string.add_task_approval_subtitle;
            }
            i8 = WhenMappings.$EnumSwitchMapping$0[taskType.ordinal()];
            if (i8 != 1) {
                composerStartRestartGroup.startReplaceGroup(-1723143448);
                ComposerKt.sourceInformation(composerStartRestartGroup, "77@3001L56");
                VectorPainter vectorPainterRememberVectorPainter2 = VectorPainterKt.rememberVectorPainter(AssignmentTurnedInKt.getAssignmentTurnedIn(Icons.Outlined.INSTANCE), composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
                vectorPainterPainterResource = vectorPainterRememberVectorPainter2;
            } else {
                if (i8 == 2) {
                    composerStartRestartGroup.startReplaceGroup(-1723144799);
                    composerStartRestartGroup.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
                composerStartRestartGroup.startReplaceGroup(-1723140713);
                ComposerKt.sourceInformation(composerStartRestartGroup, "78@3087L39");
                vectorPainterPainterResource = PainterResources_androidKt.painterResource(R.drawable.approval_24, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            }
            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1723104282, "CC(remember):AddTaskTypePicker.kt#9igjgp");
            if ((i3 & 112) == 32) {
                z2 = true;
            } else {
                z2 = false;
            }
            z3 = z2 | ((i3 & 14) == 4);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z3) {
                objRememberedValue = new Function0() { // from class: com.box.android.tasks.addtask.ui.AddTaskTypePickerKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AddTaskTypePickerKt.AddTaskTypeRow$lambda$0$0(function1, taskType);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function0() { // from class: com.box.android.tasks.addtask.ui.AddTaskTypePickerKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AddTaskTypePickerKt.AddTaskTypeRow$lambda$0$0(function1, taskType);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierM632clickableoSLSa3U$default2 = ClickableKt.m632clickableoSLSa3U$default(modifierFillMaxWidth$default2, false, null, null, null, (Function0) objRememberedValue, 15, null);
            final int i11 = i7;
            final Painter painter2 = vectorPainterPainterResource;
            Modifier modifier5 = companion;
            ListItemColors listItemColorsM3668colorsJ08w3E2 = ListItemDefaults.INSTANCE.m3668colorsJ08w3E(Color.INSTANCE.m6849getTransparent0d7_KjU(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, (ListItemDefaults.$stable << 27) | 6, 510);
            composerStartRestartGroup = composerStartRestartGroup;
            ListItemKt.m3695ListItemHXNGIdc(ComposableLambdaKt.rememberComposableLambda(-507379406, true, new Function2() { // from class: com.box.android.tasks.addtask.ui.AddTaskTypePickerKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AddTaskTypePickerKt.AddTaskTypeRow$lambda$1(i5, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), modifierM632clickableoSLSa3U$default2, null, ComposableLambdaKt.rememberComposableLambda(-1642122865, true, new Function2() { // from class: com.box.android.tasks.addtask.ui.AddTaskTypePickerKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AddTaskTypePickerKt.AddTaskTypeRow$lambda$2(i11, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(842940846, true, new Function2() { // from class: com.box.android.tasks.addtask.ui.AddTaskTypePickerKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AddTaskTypePickerKt.AddTaskTypeRow$lambda$3(painter2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), null, listItemColorsM3668colorsJ08w3E2, 0.0f, 0.0f, composerStartRestartGroup, 27654, 420);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.tasks.addtask.ui.AddTaskTypePickerKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AddTaskTypePickerKt.AddTaskTypeRow$lambda$4(taskType, function1, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddTaskTypeRow$lambda$1(int i, Composer composer, int i2) {
        ComposerKt.sourceInformation(composer, "C84@3217L24,85@3281L10,86@3338L6,83@3188L181:AddTaskTypePicker.kt#184uln");
        if (!composer.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-507379406, i2, -1, "com.box.android.tasks.addtask.ui.AddTaskTypeRow.<anonymous> (AddTaskTypePicker.kt:83)");
            }
            TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(i, composer, 0), null, BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleMedium(), composer, 0, 0, 131066);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddTaskTypeRow$lambda$2(int i, Composer composer, int i2) {
        ComposerKt.sourceInformation(composer, "C91@3452L30,92@3522L10,93@3578L6,90@3423L192:AddTaskTypePicker.kt#184uln");
        if (!composer.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1642122865, i2, -1, "com.box.android.tasks.addtask.ui.AddTaskTypeRow.<anonymous> (AddTaskTypePicker.kt:90)");
            }
            TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(i, composer, 0), null, BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11513getContentSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleSmall(), composer, 0, 0, 131066);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AddTaskTypeRow$lambda$3(Painter painter, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C101@3833L6,97@3666L469:AddTaskTypePicker.kt#184uln");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(842940846, i, -1, "com.box.android.tasks.addtask.ui.AddTaskTypeRow.<anonymous> (AddTaskTypePicker.kt:97)");
            }
            Modifier modifierM589backgroundbw27NRU$default = BackgroundKt.m589backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(40)), RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(8))), BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11534getMainActiveControlBackground0d7_KjU(), null, 2, null);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM589backgroundbw27NRU$default);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1471643116, "C107@4079L6,104@3954L167:AddTaskTypePicker.kt#184uln");
            IconKt.m3575Iconww6aTOc(painter, (String) null, (Modifier) null, BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), composer, Painter.$stable | 48, 4);
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
    public static final Unit AddTaskTypeRow$lambda$0$0(Function1 function1, TaskType taskType) {
        function1.invoke(taskType);
        return Unit.INSTANCE;
    }
}

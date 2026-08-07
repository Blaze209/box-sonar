package expo.modules.ui;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.selection.SelectableGroupKt;
import androidx.compose.foundation.selection.SelectableKt;
import androidx.compose.material3.RadioButtonKt;
import androidx.compose.material3.SegmentedButtonKt;
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
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.unit.Dp;
import expo.modules.kotlin.AppContext;
import expo.modules.kotlin.views.ComposableScope;
import expo.modules.kotlin.views.FunctionalComposableScope;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PickerView.kt */
/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a-\u0010\u0000\u001a\u00020\u0001*\u00020\u00022\u0006\u0010\u0003\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u00010\u0006H\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"PickerContent", "", "Lexpo/modules/kotlin/views/FunctionalComposableScope;", "props", "Lexpo/modules/ui/PickerProps;", "onOptionSelected", "Lkotlin/Function1;", "Lexpo/modules/ui/PickerOptionSelectedEvent;", "(Lexpo/modules/kotlin/views/FunctionalComposableScope;Lexpo/modules/ui/PickerProps;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "expo-ui_release"}, k = 2, mv = {2, 1, 0}, xi = 48)
public final class PickerViewKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PickerContent$lambda$5(FunctionalComposableScope functionalComposableScope, PickerProps pickerProps, Function1 function1, int i, Composer composer, int i2) {
        PickerContent(functionalComposableScope, pickerProps, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void PickerContent(FunctionalComposableScope functionalComposableScope, PickerProps props, Function1<? super PickerOptionSelectedEvent, Unit> onOptionSelected, Composer composer, final int i) {
        int i2;
        final FunctionalComposableScope functionalComposableScope2;
        final PickerProps pickerProps;
        final Function1<? super PickerOptionSelectedEvent, Unit> function1;
        Intrinsics.checkNotNullParameter(functionalComposableScope, "<this>");
        Intrinsics.checkNotNullParameter(props, "props");
        Intrinsics.checkNotNullParameter(onOptionSelected, "onOptionSelected");
        Composer composerStartRestartGroup = composer.startRestartGroup(-72252184);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PickerContent)P(1):PickerView.kt#v15e7d");
        if ((i & 6) == 0) {
            i2 = ((i & 8) == 0 ? composerStartRestartGroup.changed(functionalComposableScope) : composerStartRestartGroup.changedInstance(functionalComposableScope) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(props) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onOptionSelected) ? 256 : 128;
        }
        if ((i2 & Token.DOTQUERY) != 146 || !composerStartRestartGroup.getSkipping()) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-72252184, i2, -1, "expo.modules.ui.PickerContent (PickerView.kt:81)");
            }
            Integer selectedIndex = props.getSelectedIndex();
            String[] options = props.getOptions();
            PickerColors elementColors = props.getElementColors();
            String variant = props.getVariant();
            if (Intrinsics.areEqual(variant, "segmented")) {
                composerStartRestartGroup.startReplaceGroup(-683403813);
                ComposerKt.sourceInformation(composerStartRestartGroup, "153@4992L21");
                functionalComposableScope2 = functionalComposableScope;
                pickerProps = props;
                function1 = onOptionSelected;
                PickerContent$SegmentedComposable(pickerProps, functionalComposableScope2, options, selectedIndex, elementColors, function1, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                functionalComposableScope2 = functionalComposableScope;
                pickerProps = props;
                function1 = onOptionSelected;
                if (Intrinsics.areEqual(variant, "radio")) {
                    composerStartRestartGroup.startReplaceGroup(-683343425);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "155@5053L17");
                    PickerContent$RadioComposable(options, selectedIndex, function1, composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-683309480);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "158@5121L21");
                    PickerContent$SegmentedComposable(pickerProps, functionalComposableScope2, options, selectedIndex, elementColors, function1, composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                }
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            functionalComposableScope2 = functionalComposableScope;
            pickerProps = props;
            function1 = onOptionSelected;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: expo.modules.ui.PickerViewKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PickerViewKt.PickerContent$lambda$5(functionalComposableScope2, pickerProps, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void PickerContent$SegmentedComposable(PickerProps pickerProps, FunctionalComposableScope functionalComposableScope, String[] strArr, Integer num, PickerColors pickerColors, Function1<? super PickerOptionSelectedEvent, Unit> function1, Composer composer, int i) {
        composer.startReplaceGroup(-1555920817);
        ComposerKt.sourceInformation(composer, "C(SegmentedComposable)90@2561L83,91@2651L1537,89@2495L1693:PickerView.kt#v15e7d");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1555920817, i, -1, "expo.modules.ui.PickerContent.SegmentedComposable (PickerView.kt:88)");
        }
        SegmentedButtonKt.m4144SingleChoiceSegmentedButtonRowuFdPcIQ(ModifierRegistry.INSTANCE.applyModifiers(pickerProps.getModifiers(), functionalComposableScope.getAppContext(), functionalComposableScope.getComposableScope(), functionalComposableScope.getGlobalEventDispatcher(), composer, (AppContext.$stable << 3) | (ComposableScope.$stable << 6)), 0.0f, ComposableLambdaKt.rememberComposableLambda(-2118909852, true, new PickerViewKt$PickerContent$SegmentedComposable$1(strArr, pickerProps, functionalComposableScope, num, pickerColors, function1), composer, 54), composer, 384, 2);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
    }

    /* JADX WARN: Multi-variable type inference failed */
    private static final void PickerContent$RadioComposable(String[] strArr, Integer num, final Function1<? super PickerOptionSelectedEvent, Unit> function1, Composer composer, int i) {
        Composer composer2 = composer;
        composer2.startReplaceGroup(-1181212552);
        ComposerKt.sourceInformation(composer2, "C(RadioComposable)125@4238L712:PickerView.kt#v15e7d");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1181212552, i, -1, "expo.modules.ui.PickerContent.RadioComposable (PickerView.kt:124)");
        }
        Modifier modifierSelectableGroup = SelectableGroupKt.selectableGroup(Modifier.INSTANCE);
        ComposerKt.sourceInformationMarkerStart(composer2, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
        int i2 = 0;
        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
        int i3 = -1159599143;
        String str = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
        ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
        int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
        CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierSelectableGroup);
        Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
        int i4 = -553112988;
        String str2 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
        ComposerKt.sourceInformationMarkerStart(composer2, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
        if (!(composer2.getApplier() instanceof Applier)) {
            ComposablesKt.invalidApplier();
        }
        composer2.startReusableNode();
        if (composer2.getInserting()) {
            composer2.createNode(constructor);
        } else {
            composer2.useNode();
        }
        Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composer2);
        Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
        Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
        Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
        Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
        Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
        ComposerKt.sourceInformationMarkerStart(composer2, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
        ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
        ComposerKt.sourceInformationMarkerStart(composer2, 1089930526, "C:PickerView.kt#v15e7d");
        composer2.startReplaceGroup(-103388035);
        ComposerKt.sourceInformation(composer2, "*132@4494L91,127@4330L606");
        int length = strArr.length;
        int i5 = 0;
        final int i6 = 0;
        while (i5 < length) {
            final String str3 = strArr[i5];
            int i7 = i6 + 1;
            Modifier modifierM1252height3ABfNKs = SizeKt.m1252height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m9687constructorimpl(28));
            boolean z = (num != null && i6 == num.intValue()) ? 1 : i2;
            Role roleM8825boximpl = Role.m8825boximpl(Role.INSTANCE.m8837getRadioButtono7Vup1c());
            composer2.startReplaceGroup(-1746271574);
            ComposerKt.sourceInformation(composer2, "CC(remember):PickerView.kt#9igjgp");
            boolean zChanged = composer2.changed(function1) | composer2.changed(i6) | composer2.changed(str3);
            Object objRememberedValue = composer2.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: expo.modules.ui.PickerViewKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return PickerViewKt.PickerContent$RadioComposable$lambda$4$lambda$3$lambda$1$lambda$0(function1, i6, str3);
                    }
                };
                composer2.updateRememberedValue(objRememberedValue);
            }
            composer2.endReplaceGroup();
            Modifier modifierM1538selectableoSLSa3U$default = SelectableKt.m1538selectableoSLSa3U$default(modifierM1252height3ABfNKs, z, false, roleM8825boximpl, null, (Function0) objRememberedValue, 10, null);
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer2, 48);
            ComposerKt.sourceInformationMarkerStart(composer2, i3, str);
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, i2));
            CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, modifierM1538selectableoSLSa3U$default);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer2, i4, str2);
            if (!(composer2.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer2.startReusableNode();
            if (composer2.getInserting()) {
                composer2.createNode(constructor2);
            } else {
                composer2.useNode();
            }
            Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composer2);
            Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, -512731428, "C139@4719L98,143@4828L98:PickerView.kt#v15e7d");
            RadioButtonKt.RadioButton(num != null && i6 == num.intValue(), null, null, false, null, null, composer2, 48, 60);
            TextKt.m4494TextNvy7gAk(str3, PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m9687constructorimpl(12), 0.0f, 0.0f, 0.0f, 14, null), 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 48, 0, 262140);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            i5++;
            composer2 = composer;
            i6 = i7;
            length = length;
            i4 = i4;
            i3 = -1159599143;
            str = str;
            str2 = str2;
            i2 = 0;
        }
        composer.endReplaceGroup();
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PickerContent$RadioComposable$lambda$4$lambda$3$lambda$1$lambda$0(Function1 function1, int i, String str) {
        function1.invoke(new PickerOptionSelectedEvent(i, str));
        return Unit.INSTANCE;
    }
}

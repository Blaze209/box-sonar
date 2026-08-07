package com.box.android.preview.item.error;

import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
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
import androidx.compose.ui.res.StringResources_androidKt;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.ItemStateScreensKt;
import com.box.android.base.compose.ItemsStateConfig;
import com.box.android.base.compose.button.model.ButtonItem;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.ItemId;
import com.box.android.preview.R;
import com.box.android.preview.preview.DomainErrorPreviewErrorScreenUIModelMapper;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviewErrorScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a=\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\u0010\b\u0002\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0007H\u0007¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"PreviewErrorScreen", "", "itemId", "Lcom/box/android/domain/models/ItemId;", "domainError", "Lcom/box/android/domain/models/DomainError;", "onRetry", "Lkotlin/Function0;", ViewProps.ON_CLICK, "(Lcom/box/android/domain/models/ItemId;Lcom/box/android/domain/models/DomainError;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;II)V", "preview_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class PreviewErrorScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviewErrorScreen$lambda$4(ItemId itemId, DomainError domainError, Function0 function0, Function0 function1, int i, int i2, Composer composer, int i3) {
        PreviewErrorScreen(itemId, domainError, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0079  */
    /* JADX WARN: Code duplicated, block: B:38:0x007b  */
    /* JADX WARN: Code duplicated, block: B:41:0x0084  */
    /* JADX WARN: Code duplicated, block: B:43:0x0087  */
    /* JADX WARN: Code duplicated, block: B:44:0x008a  */
    /* JADX WARN: Code duplicated, block: B:47:0x0092  */
    /* JADX WARN: Code duplicated, block: B:50:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:51:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:54:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:55:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:58:0x0104  */
    /* JADX WARN: Code duplicated, block: B:61:0x0114  */
    /* JADX WARN: Code duplicated, block: B:63:0x0131  */
    /* JADX WARN: Code duplicated, block: B:65:0x0144  */
    /* JADX WARN: Code duplicated, block: B:68:0x019f  */
    /* JADX WARN: Code duplicated, block: B:71:0x01ab  */
    /* JADX WARN: Code duplicated, block: B:72:0x01af  */
    /* JADX WARN: Code duplicated, block: B:75:0x0240  */
    /* JADX WARN: Code duplicated, block: B:77:0x0246  */
    /* JADX WARN: Code duplicated, block: B:80:0x0250  */
    /* JADX WARN: Code duplicated, block: B:82:? A[RETURN, SYNTHETIC] */
    public static final void PreviewErrorScreen(final ItemId itemId, final DomainError domainError, final Function0<Unit> onRetry, Function0<Unit> function0, Composer composer, final int i, final int i2) {
        int i3;
        Function0<Unit> function1;
        boolean z;
        final Function0<Unit> function2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function0<Unit> function3;
        DomainErrorPreviewErrorScreenUIModelMapper.ErrorScreenUIModel errorScreenUIModel;
        ButtonItem.TextButtonItem textButtonItem;
        Integer subTitleResId;
        String strStringResource;
        Object objRememberedValue;
        Function0<Unit> function4;
        Function0<ComposeUiNode> constructor;
        Object objRememberedValue2;
        Intrinsics.checkNotNullParameter(itemId, "itemId");
        Intrinsics.checkNotNullParameter(domainError, "domainError");
        Intrinsics.checkNotNullParameter(onRetry, "onRetry");
        Composer composerStartRestartGroup = composer.startRestartGroup(1561712248);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PreviewErrorScreen)N(itemId,domainError,onRetry,onClick)40@1465L45,49@1755L39,45@1635L522:PreviewErrorScreen.kt#c1n2da");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(itemId) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(domainError) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onRetry) ? 256 : 128;
        }
        int i4 = i2 & 8;
        if (i4 == 0) {
            if ((i & 3072) == 0) {
                function1 = function0;
                i3 |= composerStartRestartGroup.changedInstance(function1) ? 2048 : 1024;
            }
            if ((i3 & 1171) != 1170) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                function2 = function1;
            } else {
                if (i4 != 0) {
                    function3 = null;
                } else {
                    function3 = function1;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1561712248, i3, -1, "com.box.android.preview.item.error.PreviewErrorScreen (PreviewErrorScreen.kt:26)");
                }
                errorScreenUIModel = DomainErrorPreviewErrorScreenUIModelMapper.INSTANCE.toErrorScreenUIModel(domainError);
                if (errorScreenUIModel.getRetryable()) {
                    textButtonItem = new ButtonItem.TextButtonItem(true, onRetry, R.string.retry);
                } else {
                    textButtonItem = null;
                }
                int drawableResId = errorScreenUIModel.getDrawableResId();
                String strStringResource2 = StringResources_androidKt.stringResource(errorScreenUIModel.getTitleResId(), composerStartRestartGroup, 0);
                subTitleResId = errorScreenUIModel.getSubTitleResId();
                if (subTitleResId == null) {
                    composerStartRestartGroup.startReplaceGroup(1884477487);
                    composerStartRestartGroup.endReplaceGroup();
                    strStringResource = null;
                } else {
                    composerStartRestartGroup.startReplaceGroup(1884477488);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*41@1570L18");
                    strStringResource = StringResources_androidKt.stringResource(subTitleResId.intValue(), composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                }
                ItemsStateConfig itemsStateConfig = new ItemsStateConfig(drawableResId, strStringResource2, strStringResource, textButtonItem);
                Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1861911039, "CC(remember):PreviewErrorScreen.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                MutableInteractionSource mutableInteractionSource = (MutableInteractionSource) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (function3 == null) {
                    composerStartRestartGroup.startReplaceGroup(1884778343);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "51@1868L3");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1861914619, "CC(remember):PreviewErrorScreen.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function0() { // from class: com.box.android.preview.item.error.PreviewErrorScreenKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endReplaceGroup();
                    function4 = (Function0) objRememberedValue2;
                } else {
                    composerStartRestartGroup.startReplaceGroup(1861914278);
                    composerStartRestartGroup.endReplaceGroup();
                    function4 = function3;
                }
                Modifier modifierM628clickableO2vRcR0$default = ClickableKt.m628clickableO2vRcR0$default(modifierFillMaxSize$default, mutableInteractionSource, null, false, null, null, function4, 28, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM628clickableO2vRcR0$default);
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
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 867294712, "C58@2117L6,54@1902L249:PreviewErrorScreen.kt#c1n2da");
                ItemStateScreensKt.m11654ItemsStateScreenV9fs2A(itemsStateConfig, "Preview:ErrorItemStateScreen:" + itemId, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), false, false, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11544getPreviewBackground0d7_KjU(), composerStartRestartGroup, 384, 24);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function2 = function3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.item.error.PreviewErrorScreenKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return PreviewErrorScreenKt.PreviewErrorScreen$lambda$4(itemId, domainError, onRetry, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        function1 = function0;
        if ((i3 & 1171) != 1170) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            function2 = function1;
        } else {
            if (i4 != 0) {
                function3 = null;
            } else {
                function3 = function1;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1561712248, i3, -1, "com.box.android.preview.item.error.PreviewErrorScreen (PreviewErrorScreen.kt:26)");
            }
            errorScreenUIModel = DomainErrorPreviewErrorScreenUIModelMapper.INSTANCE.toErrorScreenUIModel(domainError);
            if (errorScreenUIModel.getRetryable()) {
                textButtonItem = new ButtonItem.TextButtonItem(true, onRetry, R.string.retry);
            } else {
                textButtonItem = null;
            }
            int drawableResId2 = errorScreenUIModel.getDrawableResId();
            String strStringResource3 = StringResources_androidKt.stringResource(errorScreenUIModel.getTitleResId(), composerStartRestartGroup, 0);
            subTitleResId = errorScreenUIModel.getSubTitleResId();
            if (subTitleResId == null) {
                composerStartRestartGroup.startReplaceGroup(1884477487);
                composerStartRestartGroup.endReplaceGroup();
                strStringResource = null;
            } else {
                composerStartRestartGroup.startReplaceGroup(1884477488);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*41@1570L18");
                strStringResource = StringResources_androidKt.stringResource(subTitleResId.intValue(), composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            }
            ItemsStateConfig itemsStateConfig2 = new ItemsStateConfig(drawableResId2, strStringResource3, strStringResource, textButtonItem);
            Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1861911039, "CC(remember):PreviewErrorScreen.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            MutableInteractionSource mutableInteractionSource2 = (MutableInteractionSource) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (function3 == null) {
                composerStartRestartGroup.startReplaceGroup(1884778343);
                ComposerKt.sourceInformation(composerStartRestartGroup, "51@1868L3");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1861914619, "CC(remember):PreviewErrorScreen.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.box.android.preview.item.error.PreviewErrorScreenKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Unit.INSTANCE;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endReplaceGroup();
                function4 = (Function0) objRememberedValue2;
            } else {
                composerStartRestartGroup.startReplaceGroup(1861914278);
                composerStartRestartGroup.endReplaceGroup();
                function4 = function3;
            }
            Modifier modifierM628clickableO2vRcR0$default2 = ClickableKt.m628clickableO2vRcR0$default(modifierFillMaxSize$default2, mutableInteractionSource2, null, false, null, null, function4, 28, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM628clickableO2vRcR0$default2);
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
            Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 867294712, "C58@2117L6,54@1902L249:PreviewErrorScreen.kt#c1n2da");
            ItemStateScreensKt.m11654ItemsStateScreenV9fs2A(itemsStateConfig2, "Preview:ErrorItemStateScreen:" + itemId, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), false, false, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11544getPreviewBackground0d7_KjU(), composerStartRestartGroup, 384, 24);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function2 = function3;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.item.error.PreviewErrorScreenKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PreviewErrorScreenKt.PreviewErrorScreen$lambda$4(itemId, domainError, onRetry, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}

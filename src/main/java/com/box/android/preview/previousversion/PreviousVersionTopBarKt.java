package com.box.android.preview.previousversion;

import android.content.Context;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.HistoryKt;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.presentation.components.topbar.simple.BoxSimpleTopBarSecondaryKt;
import com.box.android.common.utilities.BoxDateUtils;
import com.box.android.domain.models.item.UserModel;
import com.box.android.preview.R;
import java.util.Date;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: PreviousVersionTopBar.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000\u0016\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001a%\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001a\u0015\u0010\u0007\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\b¨\u0006\t"}, d2 = {"PreviousVersionTopBar", "", "versionInfo", "Lcom/box/android/preview/previousversion/PreviousVersionReducer$VersionInfo;", "onCloseClick", "Lkotlin/Function0;", "(Lcom/box/android/preview/previousversion/PreviousVersionReducer$VersionInfo;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "PreviousVersionTopBarSubtitle", "(Lcom/box/android/preview/previousversion/PreviousVersionReducer$VersionInfo;Landroidx/compose/runtime/Composer;I)V", "preview_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class PreviousVersionTopBarKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviousVersionTopBar$lambda$1(PreviousVersionReducer.VersionInfo versionInfo, Function0 function0, int i, Composer composer, int i2) {
        PreviousVersionTopBar(versionInfo, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviousVersionTopBarSubtitle$lambda$3(PreviousVersionReducer.VersionInfo versionInfo, int i, Composer composer, int i2) {
        PreviousVersionTopBarSubtitle(versionInfo, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void PreviousVersionTopBar(final PreviousVersionReducer.VersionInfo versionInfo, Function0<Unit> onCloseClick, Composer composer, final int i) {
        int i2;
        final Function0<Unit> function0;
        String name;
        Intrinsics.checkNotNullParameter(onCloseClick, "onCloseClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-601154456);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PreviousVersionTopBar)N(versionInfo,onCloseClick)27@1278L115,24@1129L307:PreviousVersionTopBar.kt#k0omno");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(versionInfo) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onCloseClick) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            function0 = onCloseClick;
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-601154456, i2, -1, "com.box.android.preview.previousversion.PreviousVersionTopBar (PreviousVersionTopBar.kt:23)");
            }
            Modifier modifierTestTag = TestTagKt.testTag(Modifier.INSTANCE, "PreviousVersion:TopBar");
            if (versionInfo == null || (name = versionInfo.getName()) == null) {
                name = "";
            }
            function0 = onCloseClick;
            BoxSimpleTopBarSecondaryKt.BoxSimpleTopBarSecondary(name, modifierTestTag, ComposableLambdaKt.rememberComposableLambda(172319712, true, new Function2() { // from class: com.box.android.preview.previousversion.PreviousVersionTopBarKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PreviousVersionTopBarKt.PreviousVersionTopBar$lambda$0(versionInfo, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), function0, composerStartRestartGroup, ((i2 << 6) & 7168) | 432, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.previousversion.PreviousVersionTopBarKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PreviousVersionTopBarKt.PreviousVersionTopBar$lambda$1(versionInfo, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PreviousVersionTopBar$lambda$0(PreviousVersionReducer.VersionInfo versionInfo, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:PreviousVersionTopBar.kt#k0omno");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(172319712, i, -1, "com.box.android.preview.previousversion.PreviousVersionTopBar.<anonymous> (PreviousVersionTopBar.kt:28)");
            }
            if (versionInfo == null) {
                composer.startReplaceGroup(1090650675);
            } else {
                composer.startReplaceGroup(1090650676);
                ComposerKt.sourceInformation(composer, "*29@1327L42");
                PreviousVersionTopBarSubtitle(versionInfo, composer, 0);
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public static final void PreviousVersionTopBarSubtitle(final PreviousVersionReducer.VersionInfo versionInfo, Composer composer, final int i) {
        int i2;
        String dateAccordingToLocalConventions;
        String name;
        String strStringResource;
        Intrinsics.checkNotNullParameter(versionInfo, "versionInfo");
        Composer composerStartRestartGroup = composer.startRestartGroup(-345406084);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PreviousVersionTopBarSubtitle)N(versionInfo)41@1699L57,49@1976L632:PreviousVersionTopBar.kt#k0omno");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(versionInfo) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-345406084, i2, -1, "com.box.android.preview.previousversion.PreviousVersionTopBarSubtitle (PreviousVersionTopBar.kt:37)");
            }
            Date lastModified = versionInfo.getLastModified();
            if (lastModified == null) {
                composerStartRestartGroup.startReplaceGroup(749129266);
                composerStartRestartGroup.endReplaceGroup();
                dateAccordingToLocalConventions = null;
            } else {
                composerStartRestartGroup.startReplaceGroup(749129267);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*39@1656L7");
                ProvidableCompositionLocal<Context> localContext = AndroidCompositionLocals_androidKt.getLocalContext();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                Object objConsume = composerStartRestartGroup.consume(localContext);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                dateAccordingToLocalConventions = BoxDateUtils.formatDateAccordingToLocalConventions(lastModified, (Context) objConsume);
                composerStartRestartGroup.endReplaceGroup();
            }
            String strStringResource2 = StringResources_androidKt.stringResource(R.string.file_version, new Object[]{Integer.valueOf(versionInfo.getNumber())}, composerStartRestartGroup, 0);
            if (dateAccordingToLocalConventions == null) {
                composerStartRestartGroup.startReplaceGroup(749338485);
                composerStartRestartGroup.endReplaceGroup();
                strStringResource = null;
            } else {
                composerStartRestartGroup.startReplaceGroup(749338486);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*43@1809L156");
                int i3 = R.string.item_information_modified_date_by_user_format;
                UserModel modifiedBy = versionInfo.getModifiedBy();
                if (modifiedBy == null || (name = modifiedBy.getName()) == null) {
                    name = "";
                }
                strStringResource = StringResources_androidKt.stringResource(i3, new Object[]{dateAccordingToLocalConventions, name}, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            }
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -459685513, "C52@2108L6,50@2038L241,58@2288L46:PreviousVersionTopBar.kt#k0omno");
            float f = 4;
            IconKt.m3576Iconww6aTOc(HistoryKt.getHistory(Icons.Outlined.INSTANCE), (String) null, SizeKt.m1266size3ABfNKs(PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m9687constructorimpl(f), 0.0f, 11, null), Dp.m9687constructorimpl(16)), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11513getContentSecondary0d7_KjU(), composerStartRestartGroup, 432, 0);
            BoxSimpleTopBarSecondaryKt.BoxSimpleTopBarSubtitleText(strStringResource2, null, composerStartRestartGroup, 0, 2);
            if (strStringResource == null) {
                composerStartRestartGroup.startReplaceGroup(-459378956);
            } else {
                composerStartRestartGroup.startReplaceGroup(-459378955);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*61@2420L40,60@2375L163,64@2551L41");
                BoxSimpleTopBarSecondaryKt.BoxSimpleTopBarSubtitleText(StringResources_androidKt.stringResource(R.string.Interpunct, composerStartRestartGroup, 0), PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m9687constructorimpl(f), 0.0f, 2, null), composerStartRestartGroup, 48, 0);
                BoxSimpleTopBarSecondaryKt.BoxSimpleTopBarSubtitleText(strStringResource, null, composerStartRestartGroup, 0, 2);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.previousversion.PreviousVersionTopBarKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return PreviousVersionTopBarKt.PreviousVersionTopBarSubtitle$lambda$3(versionInfo, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}

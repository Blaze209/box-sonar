package com.box.android.base.presentation.components;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.shape.RoundedCornerShape;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
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
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import com.box.android.base.compose.BoxColorPalette;
import com.box.android.domain.utils.SupportedFileExtensions;
import com.box.androidsdk.content.models.BoxFile;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: FileExtensionBadge.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\u001e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\u001d\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0007¢\u0006\u0002\u0010\u0006\u001a\u0015\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¢\u0006\u0002\u0010\t¨\u0006\n"}, d2 = {"FileExtensionBadge", "", BoxFile.FIELD_EXTENSION, "", "modifier", "Landroidx/compose/ui/Modifier;", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;I)V", "getFileExtensionBadgeColor", "Landroidx/compose/ui/graphics/Color;", "(Ljava/lang/String;)J", "base_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class FileExtensionBadgeKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FileExtensionBadge$lambda$1(String str, Modifier modifier, int i, Composer composer, int i2) {
        FileExtensionBadge(str, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void FileExtensionBadge(final String extension, final Modifier modifier, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(extension, "extension");
        Intrinsics.checkNotNullParameter(modifier, "modifier");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1438866306);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FileExtensionBadge)N(extension,modifier)21@845L470:FileExtensionBadge.kt#h0at18");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(extension) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1438866306, i2, -1, "com.box.android.base.presentation.components.FileExtensionBadge (FileExtensionBadge.kt:19)");
            }
            RoundedCornerShape roundedCornerShapeM1573RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(30));
            float f = 1;
            Modifier modifierM604borderxT4_qwU = BorderKt.m604borderxT4_qwU(BackgroundKt.m589backgroundbw27NRU$default(ClipKt.clip(modifier, roundedCornerShapeM1573RoundedCornerShape0680j_4), BoxColorPalette.INSTANCE.m11361getBOX_GRAY_020d7_KjU(), null, 2, null), Dp.m9687constructorimpl(f), BoxColorPalette.INSTANCE.m11362getBOX_GRAY_050d7_KjU(), roundedCornerShapeM1573RoundedCornerShape0680j_4);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM604borderxT4_qwU);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 166602380, "C30@1193L10,27@1034L275:FileExtensionBadge.kt#h0at18");
            Modifier modifierM1219paddingVpY3zN4 = PaddingKt.m1219paddingVpY3zN4(Modifier.INSTANCE, Dp.m9687constructorimpl(6), Dp.m9687constructorimpl(f));
            String upperCase = extension.toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            composer2 = composerStartRestartGroup;
            TextKt.m4494TextNvy7gAk(upperCase, modifierM1219paddingVpY3zN4, getFileExtensionBadgeColor(extension), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 1, 0, null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getLabelSmall(), composer2, 48, 24576, 114680);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.FileExtensionBadgeKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FileExtensionBadgeKt.FileExtensionBadge$lambda$1(extension, modifier, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final long getFileExtensionBadgeColor(String str) {
        String lowerCase = str.toLowerCase(Locale.ROOT);
        Intrinsics.checkNotNullExpressionValue(lowerCase, "toLowerCase(...)");
        if (Intrinsics.areEqual(lowerCase, SupportedFileExtensions.PAGES_EXTENSION)) {
            return BoxColorPalette.INSTANCE.m11390getORANGE_1300d7_KjU();
        }
        if (Intrinsics.areEqual(lowerCase, "key")) {
            return BoxColorPalette.INSTANCE.m11381getLIGHT_BLUE_1150d7_KjU();
        }
        if (Intrinsics.areEqual(lowerCase, "numbers")) {
            return BoxColorPalette.INSTANCE.m11386getLIGHT_GREEN_1350d7_KjU();
        }
        if (SupportedFileExtensions.INSTANCE.isCodeExtension(lowerCase) || SupportedFileExtensions.INSTANCE.isOpenableDocument(lowerCase) || SupportedFileExtensions.INSTANCE.isMicrosoftPowerPointExtension(lowerCase) || SupportedFileExtensions.INSTANCE.isInDesignExtension(lowerCase)) {
            return BoxColorPalette.INSTANCE.m11401getWATERMELON_RED_1200d7_KjU();
        }
        if (SupportedFileExtensions.INSTANCE.isPresentationExtension(lowerCase) || SupportedFileExtensions.INSTANCE.isAdobeIllustratorExtension(lowerCase) || SupportedFileExtensions.INSTANCE.isBoxCanvasExtension(lowerCase)) {
            return BoxColorPalette.INSTANCE.m11390getORANGE_1300d7_KjU();
        }
        if (SupportedFileExtensions.INSTANCE.isImageExtension(lowerCase) || SupportedFileExtensions.INSTANCE.isGifExtension(lowerCase) || SupportedFileExtensions.INSTANCE.isSpreadsheetExtension(lowerCase) || SupportedFileExtensions.INSTANCE.isVectorExtension(lowerCase) || SupportedFileExtensions.INSTANCE.isMicrosoftExcelExtension(lowerCase) || SupportedFileExtensions.INSTANCE.isDocuWorksExtension(lowerCase)) {
            return BoxColorPalette.INSTANCE.m11386getLIGHT_GREEN_1350d7_KjU();
        }
        if (SupportedFileExtensions.INSTANCE.isVideoExtension(lowerCase) || SupportedFileExtensions.INSTANCE.isAdobePhotoshopExtension(lowerCase) || SupportedFileExtensions.INSTANCE.isAutoCADExtension(lowerCase)) {
            return BoxColorPalette.INSTANCE.m11381getLIGHT_BLUE_1150d7_KjU();
        }
        if (SupportedFileExtensions.INSTANCE.isDocumentExtension(lowerCase) || SupportedFileExtensions.INSTANCE.isMicrosoftWordExtension(lowerCase)) {
            return BoxColorPalette.INSTANCE.m11383getLIGHT_BLUE_1350d7_KjU();
        }
        return SupportedFileExtensions.INSTANCE.isAudioExtension(lowerCase) ? BoxColorPalette.INSTANCE.m11394getPURPLE_RAIN_1000d7_KjU() : BoxColorPalette.INSTANCE.m11364getBOX_GRAY_1000d7_KjU();
    }
}

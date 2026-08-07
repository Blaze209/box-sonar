package com.box.android.boxai.ui;

import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.outlined.ErrorOutlineKt;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.base.presentation.utilities.FileTypeIcon;
import com.box.android.base.presentation.utilities.SupportedFileExtensionIcons;
import com.box.android.boxai.R;
import com.box.android.domain.models.boxai.AiUnavailabilityReason;
import com.box.android.domain.models.item.FileModel;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.domain.models.item.ItemModelKt;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxAiFileListItem.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000,\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0007\u001a+\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0007¢\u0006\u0002\u0010\b\u001a\u0010\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\u0003H\u0003\u001a\u0015\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u0007H\u0003¢\u0006\u0002\u0010\u000f\u001a\r\u0010\u0010\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0011\u001a\r\u0010\u0012\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0011\u001a\r\u0010\u0013\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0011¨\u0006\u0014"}, d2 = {"BoxAiFileListItem", "", "itemModel", "Lcom/box/android/domain/models/item/ItemModel;", "modifier", "Landroidx/compose/ui/Modifier;", "unavailabilityReason", "Lcom/box/android/domain/models/boxai/AiUnavailabilityReason;", "(Lcom/box/android/domain/models/item/ItemModel;Landroidx/compose/ui/Modifier;Lcom/box/android/domain/models/boxai/AiUnavailabilityReason;Landroidx/compose/runtime/Composer;II)V", "getItemIconRes", "", "item", "getUnavailabilityReasonText", "", BoxNoteConstants.BOX_NOTE_BRIDGE_KEY_REASON, "(Lcom/box/android/domain/models/boxai/AiUnavailabilityReason;Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "BoxAiFileListItemSupportedPreview", "(Landroidx/compose/runtime/Composer;I)V", "BoxAiFileListItemFolderPreview", "BoxAiFileListItemUnsupportedPreview", "boxai_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BoxAiFileListItemKt {

    /* JADX INFO: compiled from: BoxAiFileListItem.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[AiUnavailabilityReason.values().length];
            try {
                iArr[AiUnavailabilityReason.NOT_SUPPORTED.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[AiUnavailabilityReason.FILE_TYPE_MIXING_NOT_ALLOWED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[AiUnavailabilityReason.NO_PERMISSION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[AiUnavailabilityReason.AI_DISABLED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiFileListItem$lambda$1(ItemModel itemModel, Modifier modifier, AiUnavailabilityReason aiUnavailabilityReason, int i, int i2, Composer composer, int i3) {
        BoxAiFileListItem(itemModel, modifier, aiUnavailabilityReason, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiFileListItemFolderPreview$lambda$0(int i, Composer composer, int i2) {
        BoxAiFileListItemFolderPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiFileListItemSupportedPreview$lambda$0(int i, Composer composer, int i2) {
        BoxAiFileListItemSupportedPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxAiFileListItemUnsupportedPreview$lambda$0(int i, Composer composer, int i2) {
        BoxAiFileListItemUnsupportedPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0048  */
    /* JADX WARN: Code duplicated, block: B:24:0x004b  */
    /* JADX WARN: Code duplicated, block: B:26:0x004f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:27:0x0051  */
    /* JADX WARN: Code duplicated, block: B:28:0x0053  */
    /* JADX WARN: Code duplicated, block: B:31:0x0061  */
    /* JADX WARN: Code duplicated, block: B:32:0x0064  */
    /* JADX WARN: Code duplicated, block: B:36:0x006f  */
    /* JADX WARN: Code duplicated, block: B:37:0x0071  */
    /* JADX WARN: Code duplicated, block: B:40:0x007a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:41:0x007c  */
    /* JADX WARN: Code duplicated, block: B:42:0x0081  */
    /* JADX WARN: Code duplicated, block: B:45:0x0085  */
    /* JADX WARN: Code duplicated, block: B:46:0x0087  */
    /* JADX WARN: Code duplicated, block: B:49:0x008f  */
    /* JADX WARN: Code duplicated, block: B:52:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:55:0x0101  */
    /* JADX WARN: Code duplicated, block: B:56:0x0105  */
    /* JADX WARN: Code duplicated, block: B:59:0x01f1  */
    /* JADX WARN: Code duplicated, block: B:62:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:63:0x0201  */
    /* JADX WARN: Code duplicated, block: B:66:0x02c0  */
    /* JADX WARN: Code duplicated, block: B:67:0x0319  */
    /* JADX WARN: Code duplicated, block: B:70:0x0336  */
    /* JADX WARN: Code duplicated, block: B:71:0x0376  */
    /* JADX WARN: Code duplicated, block: B:74:0x0397  */
    /* JADX WARN: Code duplicated, block: B:76:0x039d  */
    /* JADX WARN: Code duplicated, block: B:79:0x03a9  */
    /* JADX WARN: Code duplicated, block: B:81:? A[RETURN, SYNTHETIC] */
    public static final void BoxAiFileListItem(final ItemModel itemModel, Modifier modifier, AiUnavailabilityReason aiUnavailabilityReason, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        int iOrdinal;
        int i5;
        boolean z;
        final AiUnavailabilityReason aiUnavailabilityReason2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        AiUnavailabilityReason aiUnavailabilityReason3;
        float f;
        Function0<ComposeUiNode> constructor;
        float f2;
        Function0<ComposeUiNode> constructor2;
        AiUnavailabilityReason aiUnavailabilityReason4;
        Intrinsics.checkNotNullParameter(itemModel, "itemModel");
        Composer composerStartRestartGroup = composer.startRestartGroup(-254696413);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAiFileListItem)N(itemModel,modifier,unavailabilityReason)39@1804L1526:BoxAiFileListItem.kt#bwxcym");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(itemModel) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i6 = i2 & 2;
        if (i6 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                i3 |= 384;
            } else if ((i & 384) == 0) {
                if (aiUnavailabilityReason == null) {
                    iOrdinal = -1;
                } else {
                    iOrdinal = aiUnavailabilityReason.ordinal();
                }
                if (composerStartRestartGroup.changed(iOrdinal)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            if ((i3 & Token.DOTQUERY) != 146) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                aiUnavailabilityReason2 = aiUnavailabilityReason;
                modifier3 = modifier2;
            } else {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    aiUnavailabilityReason3 = null;
                } else {
                    aiUnavailabilityReason3 = aiUnavailabilityReason;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-254696413, i3, -1, "com.box.android.boxai.ui.BoxAiFileListItem (BoxAiFileListItem.kt:38)");
                }
                f = 24;
                Modifier modifierM1219paddingVpY3zN4 = PaddingKt.m1219paddingVpY3zN4(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), Dp.m9687constructorimpl(f), Dp.m9687constructorimpl(12));
                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composerStartRestartGroup, 48);
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
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -432229716, "C46@2024L47,45@1996L207,52@2213L40,54@2263L714:BoxAiFileListItem.kt#bwxcym");
                IconKt.m3575Iconww6aTOc(PainterResources_androidKt.painterResource(getItemIconRes(itemModel), composerStartRestartGroup, 0), (String) null, SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(40)), Color.INSTANCE.m6850getUnspecified0d7_KjU(), composerStartRestartGroup, Painter.$stable | 3504, 0);
                f2 = 16;
                SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f2)), composerStartRestartGroup, 6);
                Modifier modifierWeight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default);
                constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
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
                Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 392545361, "C60@2473L6,57@2338L242:BoxAiFileListItem.kt#bwxcym");
                aiUnavailabilityReason4 = aiUnavailabilityReason3;
                TextKt.m4494TextNvy7gAk(itemModel.getName(), null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, TextUnitKt.getSp(0.5d), null, null, TextUnitKt.getSp(24), 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal16(), composerStartRestartGroup, 100663296, 48, 128762);
                composerStartRestartGroup = composerStartRestartGroup;
                if (aiUnavailabilityReason4 != null) {
                    composerStartRestartGroup.startReplaceGroup(392840914);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "67@2679L49,69@2828L6,66@2646L307");
                    TextKt.m4494TextNvy7gAk(getUnavailabilityReasonText(aiUnavailabilityReason4, composerStartRestartGroup, (i3 >> 6) & 14), null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11513getContentSecondary0d7_KjU(), null, 0L, null, null, null, TextUnitKt.getSp(0.4d), null, null, TextUnitKt.getSp(16), 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal12(), composerStartRestartGroup, 100663296, 48, 128762);
                    composerStartRestartGroup = composerStartRestartGroup;
                } else {
                    composerStartRestartGroup.startReplaceGroup(390205573);
                }
                composerStartRestartGroup.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (aiUnavailabilityReason4 != null) {
                    composerStartRestartGroup.startReplaceGroup(-431244692);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "77@3035L40,82@3277L6,78@3088L226");
                    SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f2)), composerStartRestartGroup, 6);
                    IconKt.m3576Iconww6aTOc(ErrorOutlineKt.getErrorOutline(Icons.Outlined.INSTANCE), (String) null, SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11513getContentSecondary0d7_KjU(), composerStartRestartGroup, 432, 0);
                } else {
                    composerStartRestartGroup.startReplaceGroup(-434251909);
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
                modifier3 = companion;
                aiUnavailabilityReason2 = aiUnavailabilityReason4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.ui.BoxAiFileListItemKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxAiFileListItemKt.BoxAiFileListItem$lambda$1(itemModel, modifier3, aiUnavailabilityReason2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            if (aiUnavailabilityReason == null) {
                iOrdinal = -1;
            } else {
                iOrdinal = aiUnavailabilityReason.ordinal();
            }
            if (composerStartRestartGroup.changed(iOrdinal)) {
                i5 = 256;
            } else {
                i5 = 128;
            }
            i3 |= i5;
        }
        if ((i3 & Token.DOTQUERY) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            aiUnavailabilityReason2 = aiUnavailabilityReason;
            modifier3 = modifier2;
        } else {
            if (i6 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (i4 != 0) {
                aiUnavailabilityReason3 = null;
            } else {
                aiUnavailabilityReason3 = aiUnavailabilityReason;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-254696413, i3, -1, "com.box.android.boxai.ui.BoxAiFileListItem (BoxAiFileListItem.kt:38)");
            }
            f = 24;
            Modifier modifierM1219paddingVpY3zN5 = PaddingKt.m1219paddingVpY3zN4(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), Dp.m9687constructorimpl(f), Dp.m9687constructorimpl(12));
            Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1219paddingVpY3zN5);
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
            Composer composerM6062constructorimpl3 = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -432229716, "C46@2024L47,45@1996L207,52@2213L40,54@2263L714:BoxAiFileListItem.kt#bwxcym");
            IconKt.m3575Iconww6aTOc(PainterResources_androidKt.painterResource(getItemIconRes(itemModel), composerStartRestartGroup, 0), (String) null, SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(40)), Color.INSTANCE.m6850getUnspecified0d7_KjU(), composerStartRestartGroup, Painter.$stable | 3504, 0);
            f2 = 16;
            SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f2)), composerStartRestartGroup, 6);
            Modifier modifierWeight$default2 = RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default2);
            constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl4 = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl4, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl4, Integer.valueOf(iHashCode4), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl4, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 392545361, "C60@2473L6,57@2338L242:BoxAiFileListItem.kt#bwxcym");
            aiUnavailabilityReason4 = aiUnavailabilityReason3;
            TextKt.m4494TextNvy7gAk(itemModel.getName(), null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, TextUnitKt.getSp(0.5d), null, null, TextUnitKt.getSp(24), 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal16(), composerStartRestartGroup, 100663296, 48, 128762);
            composerStartRestartGroup = composerStartRestartGroup;
            if (aiUnavailabilityReason4 != null) {
                composerStartRestartGroup.startReplaceGroup(392840914);
                ComposerKt.sourceInformation(composerStartRestartGroup, "67@2679L49,69@2828L6,66@2646L307");
                TextKt.m4494TextNvy7gAk(getUnavailabilityReasonText(aiUnavailabilityReason4, composerStartRestartGroup, (i3 >> 6) & 14), null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11513getContentSecondary0d7_KjU(), null, 0L, null, null, null, TextUnitKt.getSp(0.4d), null, null, TextUnitKt.getSp(16), 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal12(), composerStartRestartGroup, 100663296, 48, 128762);
                composerStartRestartGroup = composerStartRestartGroup;
            } else {
                composerStartRestartGroup.startReplaceGroup(390205573);
            }
            composerStartRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (aiUnavailabilityReason4 != null) {
                composerStartRestartGroup.startReplaceGroup(-431244692);
                ComposerKt.sourceInformation(composerStartRestartGroup, "77@3035L40,82@3277L6,78@3088L226");
                SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f2)), composerStartRestartGroup, 6);
                IconKt.m3576Iconww6aTOc(ErrorOutlineKt.getErrorOutline(Icons.Outlined.INSTANCE), (String) null, SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11513getContentSecondary0d7_KjU(), composerStartRestartGroup, 432, 0);
            } else {
                composerStartRestartGroup.startReplaceGroup(-434251909);
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
            modifier3 = companion;
            aiUnavailabilityReason2 = aiUnavailabilityReason4;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.ui.BoxAiFileListItemKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiFileListItemKt.BoxAiFileListItem$lambda$1(itemModel, modifier3, aiUnavailabilityReason2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final int getItemIconRes(ItemModel itemModel) {
        FileModel fileModel = ItemModelKt.fileModel(itemModel);
        String extension = fileModel != null ? fileModel.getExtension() : null;
        if (extension != null) {
            return SupportedFileExtensionIcons.INSTANCE.findFileIcon(extension).getDrawable();
        }
        if (itemModel instanceof FolderModel) {
            FolderModel folderModel = (FolderModel) itemModel;
            return SupportedFileExtensionIcons.INSTANCE.findFolderIcon(folderModel.getHasCollaborations(), folderModel.isExternallyOwned()).getDrawable();
        }
        return FileTypeIcon.DEFAULT.getDrawable();
    }

    private static final String getUnavailabilityReasonText(AiUnavailabilityReason aiUnavailabilityReason, Composer composer, int i) {
        String strStringResource;
        ComposerKt.sourceInformationMarkerStart(composer, -1636072824, "C(getUnavailabilityReasonText)N(reason):BoxAiFileListItem.kt#bwxcym");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1636072824, i, -1, "com.box.android.boxai.ui.getUnavailabilityReasonText (BoxAiFileListItem.kt:104)");
        }
        int i2 = WhenMappings.$EnumSwitchMapping$0[aiUnavailabilityReason.ordinal()];
        if (i2 == 1 || i2 == 2) {
            composer.startReplaceGroup(-307947352);
            ComposerKt.sourceInformation(composer, "106@4045L64");
            strStringResource = StringResources_androidKt.stringResource(R.string.box_ai_unavailable_reason_not_supported, composer, 0);
            composer.endReplaceGroup();
        } else if (i2 == 3) {
            composer.startReplaceGroup(-307943832);
            ComposerKt.sourceInformation(composer, "108@4155L64");
            strStringResource = StringResources_androidKt.stringResource(R.string.box_ai_unavailable_reason_no_permission, composer, 0);
            composer.endReplaceGroup();
        } else {
            if (i2 != 4) {
                composer.startReplaceGroup(-307950761);
                composer.endReplaceGroup();
                throw new NoWhenBranchMatchedException();
            }
            composer.startReplaceGroup(-307940378);
            ComposerKt.sourceInformation(composer, "110@4263L62");
            strStringResource = StringResources_androidKt.stringResource(R.string.box_ai_unavailable_reason_ai_disabled, composer, 0);
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return strStringResource;
    }

    private static final void BoxAiFileListItemSupportedPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(925723158);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAiFileListItemSupportedPreview)119@4493L246:BoxAiFileListItem.kt#bwxcym");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(925723158, i, -1, "com.box.android.boxai.ui.BoxAiFileListItemSupportedPreview (BoxAiFileListItem.kt:118)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$BoxAiFileListItemKt.INSTANCE.getLambda$2141363179$boxai_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.ui.BoxAiFileListItemKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiFileListItemKt.BoxAiFileListItemSupportedPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void BoxAiFileListItemFolderPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(353476410);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAiFileListItemFolderPreview)132@4851L238:BoxAiFileListItem.kt#bwxcym");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(353476410, i, -1, "com.box.android.boxai.ui.BoxAiFileListItemFolderPreview (BoxAiFileListItem.kt:131)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$BoxAiFileListItemKt.INSTANCE.getLambda$19187077$boxai_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.ui.BoxAiFileListItemKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiFileListItemKt.BoxAiFileListItemFolderPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void BoxAiFileListItemUnsupportedPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(257716381);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxAiFileListItemUnsupportedPreview)145@5206L323:BoxAiFileListItem.kt#bwxcym");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(257716381, i, -1, "com.box.android.boxai.ui.BoxAiFileListItemUnsupportedPreview (BoxAiFileListItem.kt:144)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$BoxAiFileListItemKt.INSTANCE.getLambda$256672050$boxai_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.boxai.ui.BoxAiFileListItemKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxAiFileListItemKt.BoxAiFileListItemUnsupportedPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}

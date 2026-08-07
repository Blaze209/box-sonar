package com.box.android.notes.presentation.ui;

import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.animation.core.InfiniteRepeatableSpec;
import androidx.compose.animation.core.InfiniteTransition;
import androidx.compose.animation.core.InfiniteTransitionKt;
import androidx.compose.animation.core.KeyframesSpec;
import androidx.compose.animation.core.VectorConvertersKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.rounded.StarKt;
import androidx.compose.material.icons.rounded.StarOutlineKt;
import androidx.compose.material3.IconButtonColors;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.GraphicsLayerModifierKt;
import androidx.compose.ui.graphics.GraphicsLayerScope;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.ImageVector;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.notes.R;
import com.box.android.notes.presentation.cpl.NoteReadStatus;
import com.box.android.notes.presentation.cpl.NotesItemViewData;
import com.facebook.react.uimanager.ViewProps;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: NotesItem.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000F\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u000b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\u001a;\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0007¢\u0006\u0002\u0010\t\u001a\u001d\u0010\n\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0003¢\u0006\u0002\u0010\u000f\u001a\u001f\u0010\u0010\u001a\u00020\u00012\u0006\u0010\u0011\u001a\u00020\f2\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0003¢\u0006\u0002\u0010\u0012\u001a\u001f\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\f2\b\b\u0002\u0010\u0007\u001a\u00020\bH\u0003¢\u0006\u0002\u0010\u0012\u001a+\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00172\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0003¢\u0006\u0002\u0010\u0019\u001a\u0015\u0010\u001a\u001a\u00020\u00012\u0006\u0010\u001b\u001a\u00020\u000eH\u0003¢\u0006\u0002\u0010\u001c\u001a\r\u0010\u001d\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u001e\u001a\r\u0010\u001f\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u001e\u001a\u0018\u0010 \u001a\b\u0012\u0004\u0012\u00020\"0!2\b\b\u0001\u0010#\u001a\u00020$H\u0002\u001a\r\u0010(\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u001e\"\u0010\u0010%\u001a\u00020\"X\u0082\u0004¢\u0006\u0004\n\u0002\u0010&\"\u0010\u0010'\u001a\u00020\"X\u0082\u0004¢\u0006\u0004\n\u0002\u0010&¨\u0006)²\u0006\n\u0010*\u001a\u00020\"X\u008a\u0084\u0002"}, d2 = {"NotesItem", "", "item", "Lcom/box/android/notes/presentation/cpl/NotesItemViewData;", ViewProps.ON_CLICK, "Lkotlin/Function0;", "onFavoriteClick", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/box/android/notes/presentation/cpl/NotesItemViewData;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "NoteFileName", "title", "", "readStatus", "Lcom/box/android/notes/presentation/cpl/NoteReadStatus;", "(Ljava/lang/String;Lcom/box/android/notes/presentation/cpl/NoteReadStatus;Landroidx/compose/runtime/Composer;I)V", "NoteLastEditInfo", "lastEditInfo", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "NoteParentFolder", BoxCommonConstants.EXTRA_FOLDER_NAME, "NoteFavoriteButton", "isFavorite", "", "enabled", "(ZZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "NoteStatusIndicator", "status", "(Lcom/box/android/notes/presentation/cpl/NoteReadStatus;Landroidx/compose/runtime/Composer;I)V", "NoteUnreadIndicator", "(Landroidx/compose/runtime/Composer;I)V", "NoteTypingIndicator", "typingDotAnimSpec", "Landroidx/compose/animation/core/InfiniteRepeatableSpec;", "Landroidx/compose/ui/unit/Dp;", "dotIndex", "", "INDICATOR_SLOT_WIDTH", "F", "INDICATOR_GAP", "NotesItemPreview", "notes_generalProdRelease", "yOffset"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class NotesItemKt {
    private static final float INDICATOR_SLOT_WIDTH = Dp.m9687constructorimpl(16);
    private static final float INDICATOR_GAP = Dp.m9687constructorimpl(8);

    /* JADX INFO: compiled from: NotesItem.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[NoteReadStatus.values().length];
            try {
                iArr[NoteReadStatus.UNREAD.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NoteReadStatus.TYPING.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[NoteReadStatus.READ.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NoteFavoriteButton$lambda$1(boolean z, boolean z2, Function0 function0, int i, Composer composer, int i2) {
        NoteFavoriteButton(z, z2, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NoteFileName$lambda$1(String str, NoteReadStatus noteReadStatus, int i, Composer composer, int i2) {
        NoteFileName(str, noteReadStatus, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NoteLastEditInfo$lambda$0(String str, Modifier modifier, int i, int i2, Composer composer, int i3) {
        NoteLastEditInfo(str, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NoteParentFolder$lambda$1(String str, Modifier modifier, int i, int i2, Composer composer, int i3) {
        NoteParentFolder(str, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NoteStatusIndicator$lambda$0(NoteReadStatus noteReadStatus, int i, Composer composer, int i2) {
        NoteStatusIndicator(noteReadStatus, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NoteTypingIndicator$lambda$3(int i, Composer composer, int i2) {
        NoteTypingIndicator(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NoteUnreadIndicator$lambda$1(int i, Composer composer, int i2) {
        NoteUnreadIndicator(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotesItem$lambda$1(NotesItemViewData notesItemViewData, Function0 function0, Function0 function1, Modifier modifier, int i, int i2, Composer composer, int i3) {
        NotesItem(notesItemViewData, function0, function1, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotesItemPreview$lambda$0(int i, Composer composer, int i2) {
        NotesItemPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x007a  */
    /* JADX WARN: Code duplicated, block: B:38:0x007c  */
    /* JADX WARN: Code duplicated, block: B:41:0x0085 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:42:0x0087  */
    /* JADX WARN: Code duplicated, block: B:43:0x008c  */
    /* JADX WARN: Code duplicated, block: B:46:0x0093  */
    /* JADX WARN: Code duplicated, block: B:49:0x0135  */
    /* JADX WARN: Code duplicated, block: B:52:0x0141  */
    /* JADX WARN: Code duplicated, block: B:53:0x0145  */
    /* JADX WARN: Code duplicated, block: B:56:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:59:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:60:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:63:0x0255  */
    /* JADX WARN: Code duplicated, block: B:64:0x0296  */
    /* JADX WARN: Code duplicated, block: B:67:0x031b  */
    /* JADX WARN: Code duplicated, block: B:69:0x0321  */
    /* JADX WARN: Code duplicated, block: B:72:0x032b  */
    /* JADX WARN: Code duplicated, block: B:74:? A[RETURN, SYNTHETIC] */
    public static final void NotesItem(final NotesItemViewData item, final Function0<Unit> onClick, final Function0<Unit> onFavoriteClick, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        Function0<ComposeUiNode> constructor;
        Function0<ComposeUiNode> constructor2;
        Intrinsics.checkNotNullParameter(item, "item");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(onFavoriteClick, "onFavoriteClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(678335524);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NotesItem)N(item,onClick,onFavoriteClick,modifier)67@2897L6,63@2761L1259:NotesItem.kt#a1bbf8");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(item) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onClick) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onFavoriteClick) ? 256 : 128;
        }
        int i5 = i2 & 8;
        if (i5 == 0) {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            i4 = i3;
            if ((i4 & 1171) != 1170) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                if (i5 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(678335524, i4, -1, "com.box.android.notes.presentation.ui.NotesItem (NotesItem.kt:62)");
                }
                Modifier modifier4 = companion;
                Modifier modifierM1219paddingVpY3zN4 = PaddingKt.m1219paddingVpY3zN4(SizeKt.m1254heightInVpY3zN4$default(BackgroundKt.m589backgroundbw27NRU$default(ClickableKt.m632clickableoSLSa3U$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), false, null, null, null, onClick, 15, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11530getItemListingContentBackground0d7_KjU(), null, 2, null), BoxTheme.INSTANCE.getSizes().m11612getListItemHeightD9Ej5fM(), 0.0f, 2, null), Dp.m9687constructorimpl(16), Dp.m9687constructorimpl(12));
                Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, centerVertically, composerStartRestartGroup, 54);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1657332731, "C73@3182L637,88@3828L28,89@3865L149:NotesItem.kt#a1bbf8");
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -285761401, "C74@3235L41,82@3594L29,83@3636L173:NotesItem.kt#a1bbf8");
                NoteFileName(item.getTitle(), item.getReadStatus(), composerStartRestartGroup, 0);
                if (item.getLastEditInfo() != null) {
                    composerStartRestartGroup.startReplaceGroup(-288989308);
                } else {
                    composerStartRestartGroup.startReplaceGroup(-285686785);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "76@3338L29,77@3384L183");
                    SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(8)), composerStartRestartGroup, 6);
                    NoteLastEditInfo(item.getLastEditInfo(), PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m9687constructorimpl(INDICATOR_SLOT_WIDTH + INDICATOR_GAP), 0.0f, 0.0f, 0.0f, 14, null), composerStartRestartGroup, 48, 0);
                }
                composerStartRestartGroup.endReplaceGroup();
                SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(6)), composerStartRestartGroup, 6);
                NoteParentFolder(item.getParentFolderName(), PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m9687constructorimpl(INDICATOR_SLOT_WIDTH + INDICATOR_GAP), 0.0f, 0.0f, 0.0f, 14, null), composerStartRestartGroup, 48, 0);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(8)), composerStartRestartGroup, 6);
                NoteFavoriteButton(item.isFavorite(), item.getCanFavorite(), onFavoriteClick, composerStartRestartGroup, i4 & 896);
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
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.notes.presentation.ui.NotesItemKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NotesItemKt.NotesItem$lambda$1(item, onClick, onFavoriteClick, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        modifier2 = modifier;
        i4 = i3;
        if ((i4 & 1171) != 1170) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i5 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(678335524, i4, -1, "com.box.android.notes.presentation.ui.NotesItem (NotesItem.kt:62)");
            }
            Modifier modifier5 = companion;
            Modifier modifierM1219paddingVpY3zN5 = PaddingKt.m1219paddingVpY3zN4(SizeKt.m1254heightInVpY3zN4$default(BackgroundKt.m589backgroundbw27NRU$default(ClickableKt.m632clickableoSLSa3U$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), false, null, null, null, onClick, 15, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11530getItemListingContentBackground0d7_KjU(), null, 2, null), BoxTheme.INSTANCE.getSizes().m11612getListItemHeightD9Ej5fM(), 0.0f, 2, null), Dp.m9687constructorimpl(16), Dp.m9687constructorimpl(12));
            Arrangement.HorizontalOrVertical spaceBetween2 = Arrangement.INSTANCE.getSpaceBetween();
            Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(spaceBetween2, centerVertically2, composerStartRestartGroup, 54);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1657332731, "C73@3182L637,88@3828L28,89@3865L149:NotesItem.kt#a1bbf8");
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -285761401, "C74@3235L41,82@3594L29,83@3636L173:NotesItem.kt#a1bbf8");
            NoteFileName(item.getTitle(), item.getReadStatus(), composerStartRestartGroup, 0);
            if (item.getLastEditInfo() != null) {
                composerStartRestartGroup.startReplaceGroup(-288989308);
            } else {
                composerStartRestartGroup.startReplaceGroup(-285686785);
                ComposerKt.sourceInformation(composerStartRestartGroup, "76@3338L29,77@3384L183");
                SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(8)), composerStartRestartGroup, 6);
                NoteLastEditInfo(item.getLastEditInfo(), PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m9687constructorimpl(INDICATOR_SLOT_WIDTH + INDICATOR_GAP), 0.0f, 0.0f, 0.0f, 14, null), composerStartRestartGroup, 48, 0);
            }
            composerStartRestartGroup.endReplaceGroup();
            SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(6)), composerStartRestartGroup, 6);
            NoteParentFolder(item.getParentFolderName(), PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, Dp.m9687constructorimpl(INDICATOR_SLOT_WIDTH + INDICATOR_GAP), 0.0f, 0.0f, 0.0f, 14, null), composerStartRestartGroup, 48, 0);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(8)), composerStartRestartGroup, 6);
            NoteFavoriteButton(item.isFavorite(), item.getCanFavorite(), onFavoriteClick, composerStartRestartGroup, i4 & 896);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.notes.presentation.ui.NotesItemKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NotesItemKt.NotesItem$lambda$1(item, onClick, onFavoriteClick, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void NoteFileName(final String str, final NoteReadStatus noteReadStatus, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1125932902);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NoteFileName)N(title,readStatus)99@4110L515:NotesItem.kt#a1bbf8");
        if ((i & 6) == 0) {
            i2 = i | (composerStartRestartGroup.changed(str) ? 4 : 2);
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(noteReadStatus.ordinal()) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1125932902, i2, -1, "com.box.android.notes.presentation.ui.NoteFileName (NotesItem.kt:98)");
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1966213670, "C100@4172L179,106@4360L37,112@4592L6,107@4406L213:NotesItem.kt#a1bbf8");
            Modifier modifierM1271width3ABfNKs = SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, INDICATOR_SLOT_WIDTH);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1271width3ABfNKs);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
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
            Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 608035200, "C104@4310L31:NotesItem.kt#a1bbf8");
            NoteStatusIndicator(noteReadStatus, composerStartRestartGroup, (i2 >> 3) & 14);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, INDICATOR_GAP), composerStartRestartGroup, 6);
            composer2 = composerStartRestartGroup;
            TextKt.m4494TextNvy7gAk(str, null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal16(), composer2, i2 & 14, 24960, 110586);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.notes.presentation.ui.NotesItemKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NotesItemKt.NoteFileName$lambda$1(str, noteReadStatus, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0044  */
    /* JADX WARN: Code duplicated, block: B:24:0x0046  */
    /* JADX WARN: Code duplicated, block: B:27:0x004f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:28:0x0051  */
    /* JADX WARN: Code duplicated, block: B:29:0x0056  */
    /* JADX WARN: Code duplicated, block: B:32:0x005d  */
    /* JADX WARN: Code duplicated, block: B:35:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:36:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:39:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:41:? A[RETURN, SYNTHETIC] */
    private static final void NoteLastEditInfo(final String str, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        boolean z;
        Composer composer2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        Composer composerStartRestartGroup = composer.startRestartGroup(1030491926);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NoteLastEditInfo)N(lastEditInfo,modifier)124@4902L6,119@4729L231:NotesItem.kt#a1bbf8");
        if ((i & 6) == 0) {
            i3 = i | (composerStartRestartGroup.changed(str) ? 4 : 2);
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
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                if (i4 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1030491926, i3, -1, "com.box.android.notes.presentation.ui.NoteLastEditInfo (NotesItem.kt:118)");
                }
                modifier3 = companion;
                composer2 = composerStartRestartGroup;
                TextKt.m4494TextNvy7gAk(str, modifier3, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11513getContentSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal12(), composer2, i3 & 126, 24960, 110584);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.notes.presentation.ui.NotesItemKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NotesItemKt.NoteLastEditInfo$lambda$0(str, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i4 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1030491926, i3, -1, "com.box.android.notes.presentation.ui.NoteLastEditInfo (NotesItem.kt:118)");
            }
            modifier3 = companion;
            composer2 = composerStartRestartGroup;
            TextKt.m4494TextNvy7gAk(str, modifier3, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11513getContentSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal12(), composer2, i3 & 126, 24960, 110584);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.notes.presentation.ui.NotesItemKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NotesItemKt.NoteLastEditInfo$lambda$0(str, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0048  */
    /* JADX WARN: Code duplicated, block: B:24:0x004a  */
    /* JADX WARN: Code duplicated, block: B:27:0x0053 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:28:0x0055  */
    /* JADX WARN: Code duplicated, block: B:29:0x005b  */
    /* JADX WARN: Code duplicated, block: B:32:0x0062  */
    /* JADX WARN: Code duplicated, block: B:35:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:38:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:39:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:42:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:44:0x01ac  */
    /* JADX WARN: Code duplicated, block: B:47:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:49:? A[RETURN, SYNTHETIC] */
    private static final void NoteParentFolder(final String str, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        final Modifier modifier2;
        int i4;
        boolean z;
        Composer composer2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier3;
        Function0<ComposeUiNode> constructor;
        Composer composerStartRestartGroup = composer.startRestartGroup(1450284);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NoteParentFolder)N(folderName,modifier)131@5062L607:NotesItem.kt#a1bbf8");
        if ((i & 6) == 0) {
            i3 = i | (composerStartRestartGroup.changed(str) ? 4 : 2);
        } else {
            i3 = i;
        }
        int i5 = i2 & 2;
        if (i5 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i3;
            if ((i4 & 19) != 18) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
            } else {
                if (i5 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1450284, i4, -1, "com.box.android.notes.presentation.ui.NoteParentFolder (NotesItem.kt:130)");
                }
                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composerStartRestartGroup, 48);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1552827715, "C136@5195L51,138@5315L6,135@5167L226,141@5402L28,147@5630L6,142@5439L224:NotesItem.kt#a1bbf8");
                IconKt.m3575Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.ic_folder_outlined, composerStartRestartGroup, 0), (String) null, SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(16)), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11513getContentSecondary0d7_KjU(), composerStartRestartGroup, Painter.$stable | 432, 0);
                SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(4)), composerStartRestartGroup, 6);
                composer2 = composerStartRestartGroup;
                Modifier modifier4 = modifier3;
                TextKt.m4494TextNvy7gAk(str, null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11513getContentSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal12(), composer2, i4 & 14, 24960, 110586);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.notes.presentation.ui.NotesItemKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NotesItemKt.NoteParentFolder$lambda$1(str, modifier2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        i4 = i3;
        if ((i4 & 19) != 18) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (i5 != 0) {
                modifier3 = Modifier.INSTANCE;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1450284, i4, -1, "com.box.android.notes.presentation.ui.NoteParentFolder (NotesItem.kt:130)");
            }
            Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier3);
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
            Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1552827715, "C136@5195L51,138@5315L6,135@5167L226,141@5402L28,147@5630L6,142@5439L224:NotesItem.kt#a1bbf8");
            IconKt.m3575Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.ic_folder_outlined, composerStartRestartGroup, 0), (String) null, SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(16)), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11513getContentSecondary0d7_KjU(), composerStartRestartGroup, Painter.$stable | 432, 0);
            SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(4)), composerStartRestartGroup, 6);
            composer2 = composerStartRestartGroup;
            Modifier modifier5 = modifier3;
            TextKt.m4494TextNvy7gAk(str, null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11513getContentSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal12(), composer2, i4 & 14, 24960, 110586);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier5;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.notes.presentation.ui.NotesItemKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NotesItemKt.NoteParentFolder$lambda$1(str, modifier2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void NoteFavoriteButton(final boolean z, final boolean z2, Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        final boolean z3;
        final Function0<Unit> function1;
        Composer composerStartRestartGroup = composer.startRestartGroup(1104676120);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NoteFavoriteButton)N(isFavorite,enabled,onClick)154@5831L608,154@5782L657:NotesItem.kt#a1bbf8");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(z2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & Token.DOTQUERY) != 146, i2 & 1)) {
            z3 = z2;
            function1 = function0;
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1104676120, i2, -1, "com.box.android.notes.presentation.ui.NoteFavoriteButton (NotesItem.kt:153)");
            }
            z3 = z2;
            function1 = function0;
            IconButtonKt.IconButton(function1, (Modifier) null, z3, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, ComposableLambdaKt.rememberComposableLambda(-1196311754, true, new Function2() { // from class: com.box.android.notes.presentation.ui.NotesItemKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NotesItemKt.NoteFavoriteButton$lambda$0(z2, z, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i2 >> 6) & 14) | 1572864 | ((i2 << 3) & 896), 58);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.notes.presentation.ui.NotesItemKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NotesItemKt.NoteFavoriteButton$lambda$1(z, z3, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NoteFavoriteButton$lambda$0(boolean z, boolean z2, Composer composer, int i) {
        String strStringResource;
        long jM11520getFavoriteIndicatorColor0d7_KjU;
        ComposerKt.sourceInformation(composer, "C155@5841L592:NotesItem.kt#a1bbf8");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1196311754, i, -1, "com.box.android.notes.presentation.ui.NoteFavoriteButton.<anonymous> (NotesItem.kt:155)");
            }
            Modifier modifierAlpha = AlphaKt.alpha(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(24)), z ? 1.0f : 0.4f);
            Icons.Rounded rounded = Icons.Rounded.INSTANCE;
            ImageVector star = z2 ? StarKt.getStar(rounded) : StarOutlineKt.getStarOutline(rounded);
            if (z2) {
                composer.startReplaceGroup(315455032);
                ComposerKt.sourceInformation(composer, "161@6145L52");
                strStringResource = StringResources_androidKt.stringResource(R.string.notes_remove_from_favorites, composer, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(315544157);
                ComposerKt.sourceInformation(composer, "163@6235L47");
                strStringResource = StringResources_androidKt.stringResource(R.string.notes_add_to_favorites, composer, 0);
                composer.endReplaceGroup();
            }
            String str = strStringResource;
            if (z2) {
                composer.startReplaceGroup(1395656340);
                ComposerKt.sourceInformation(composer, "165@6342L6");
                jM11520getFavoriteIndicatorColor0d7_KjU = BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11521getFavoriteIndicatorSelectedColor0d7_KjU();
            } else {
                composer.startReplaceGroup(1395657996);
                ComposerKt.sourceInformation(composer, "165@6394L6");
                jM11520getFavoriteIndicatorColor0d7_KjU = BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11520getFavoriteIndicatorColor0d7_KjU();
            }
            composer.endReplaceGroup();
            IconKt.m3576Iconww6aTOc(star, str, modifierAlpha, jM11520getFavoriteIndicatorColor0d7_KjU, composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final void NoteStatusIndicator(final NoteReadStatus noteReadStatus, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(225114889);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NoteStatusIndicator)N(status):NotesItem.kt#a1bbf8");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(noteReadStatus.ordinal()) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(225114889, i2, -1, "com.box.android.notes.presentation.ui.NoteStatusIndicator (NotesItem.kt:171)");
            }
            int i3 = WhenMappings.$EnumSwitchMapping$0[noteReadStatus.ordinal()];
            if (i3 == 1) {
                composerStartRestartGroup.startReplaceGroup(1587046846);
                ComposerKt.sourceInformation(composerStartRestartGroup, "173@6566L21");
                NoteUnreadIndicator(composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else if (i3 == 2) {
                composerStartRestartGroup.startReplaceGroup(1587048606);
                ComposerKt.sourceInformation(composerStartRestartGroup, "174@6621L21");
                NoteTypingIndicator(composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                if (i3 != 3) {
                    composerStartRestartGroup.startReplaceGroup(1587045424);
                    composerStartRestartGroup.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
                composerStartRestartGroup.startReplaceGroup(1587050285);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.notes.presentation.ui.NotesItemKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NotesItemKt.NoteStatusIndicator$lambda$0(noteReadStatus, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void NoteUnreadIndicator(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1334889594);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NoteUnreadIndicator)181@6758L47,186@6932L6,187@6988L36,182@6810L220:NotesItem.kt#a1bbf8");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1334889594, i, -1, "com.box.android.notes.presentation.ui.NoteUnreadIndicator (NotesItem.kt:180)");
            }
            final String strStringResource = StringResources_androidKt.stringResource(R.string.notes_unread_indicator, composerStartRestartGroup, 0);
            Modifier modifierM589backgroundbw27NRU$default = BackgroundKt.m589backgroundbw27NRU$default(ClipKt.clip(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(10)), RoundedCornerShapeKt.getCircleShape()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11539getNoteUnreadIndicatorColor0d7_KjU(), null, 2, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1366330666, "CC(remember):NotesItem.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(strStringResource);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesItemKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NotesItemKt.NoteUnreadIndicator$lambda$0$0(strStringResource, (SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BoxKt.Box(SemanticsModifierKt.semantics$default(modifierM589backgroundbw27NRU$default, false, (Function1) objRememberedValue, 1, null), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.notes.presentation.ui.NotesItemKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NotesItemKt.NoteUnreadIndicator$lambda$1(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NoteUnreadIndicator$lambda$0$0(String str, SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription(semantics, str);
        return Unit.INSTANCE;
    }

    private static final void NoteTypingIndicator(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(2145432766);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NoteTypingIndicator)193@7104L47,195@7174L44,201@7440L36,200@7397L577:NotesItem.kt#a1bbf8");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2145432766, i, -1, "com.box.android.notes.presentation.ui.NoteTypingIndicator (NotesItem.kt:192)");
            }
            final String strStringResource = StringResources_androidKt.stringResource(R.string.notes_typing_indicator, composerStartRestartGroup, 0);
            InfiniteTransition infiniteTransitionRememberInfiniteTransition = InfiniteTransitionKt.rememberInfiniteTransition("typing", composerStartRestartGroup, 6, 0);
            composerStartRestartGroup.startReplaceGroup(176592645);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*197@7290L95");
            List listListOf = CollectionsKt.listOf((Object[]) new Integer[]{0, 1, 2});
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listListOf, 10));
            Iterator it = listListOf.iterator();
            while (it.hasNext()) {
                int iIntValue = ((Number) it.next()).intValue();
                float f = 0;
                arrayList.add(InfiniteTransitionKt.animateValue(infiniteTransitionRememberInfiniteTransition, Dp.m9685boximpl(Dp.m9687constructorimpl(f)), Dp.m9685boximpl(Dp.m9687constructorimpl(f)), VectorConvertersKt.getVectorConverter(Dp.INSTANCE), typingDotAnimSpec(iIntValue), "dot_" + iIntValue, composerStartRestartGroup, InfiniteTransition.$stable | 432 | (InfiniteRepeatableSpec.$stable << 12), 0));
            }
            ArrayList<State> arrayList2 = arrayList;
            composerStartRestartGroup.endReplaceGroup();
            Modifier.Companion companion = Modifier.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 176598434, "CC(remember):NotesItem.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(strStringResource);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesItemKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NotesItemKt.NoteTypingIndicator$lambda$1$0(strStringResource, (SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(companion, false, (Function1) objRememberedValue, 1, null);
            Arrangement.HorizontalOrVertical horizontalOrVerticalM1073spacedBy0680j_4 = Arrangement.INSTANCE.m1073spacedBy0680j_4(Dp.m9687constructorimpl(2));
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalOrVerticalM1073spacedBy0680j_4, centerVertically, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierSemantics$default);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1417669082, "C:NotesItem.kt#a1bbf8");
            composerStartRestartGroup.startReplaceGroup(461373598);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*210@7806L33,212@7920L6,207@7698L260");
            for (final State state : arrayList2) {
                Modifier modifierM1266size3ABfNKs = SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(4));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 688699645, "CC(remember):NotesItem.kt#9igjgp");
                boolean zChanged2 = composerStartRestartGroup.changed(state);
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesItemKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return NotesItemKt.NoteTypingIndicator$lambda$2$0$1$0(state, (GraphicsLayerScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                BoxKt.Box(BackgroundKt.m589backgroundbw27NRU$default(ClipKt.clip(GraphicsLayerModifierKt.graphicsLayer(modifierM1266size3ABfNKs, (Function1) objRememberedValue2), RoundedCornerShapeKt.getCircleShape()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11513getContentSecondary0d7_KjU(), null, 2, null), composerStartRestartGroup, 0);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.notes.presentation.ui.NotesItemKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NotesItemKt.NoteTypingIndicator$lambda$3(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NoteTypingIndicator$lambda$1$0(String str, SemanticsPropertyReceiver semantics) {
        Intrinsics.checkNotNullParameter(semantics, "$this$semantics");
        SemanticsPropertiesKt.setContentDescription(semantics, str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NoteTypingIndicator$lambda$2$0$1$0(State state, GraphicsLayerScope graphicsLayer) {
        Intrinsics.checkNotNullParameter(graphicsLayer, "$this$graphicsLayer");
        graphicsLayer.setTranslationY(graphicsLayer.mo754toPx0680j_4(NoteTypingIndicator$lambda$2$0$0(state)));
        return Unit.INSTANCE;
    }

    private static final InfiniteRepeatableSpec<Dp> typingDotAnimSpec(final int i) {
        return AnimationSpecKt.m475infiniteRepeatable9IiC70o$default(AnimationSpecKt.keyframes(new Function1() { // from class: com.box.android.notes.presentation.ui.NotesItemKt$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function1
            public final Object invoke(Object obj) {
                return NotesItemKt.typingDotAnimSpec$lambda$0(i, (KeyframesSpec.KeyframesSpecConfig) obj);
            }
        }), null, 0L, 6, null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit typingDotAnimSpec$lambda$0(int i, KeyframesSpec.KeyframesSpecConfig keyframes) {
        Intrinsics.checkNotNullParameter(keyframes, "$this$keyframes");
        keyframes.setDurationMillis(900);
        int i2 = i * 150;
        keyframes.using(keyframes.at(Dp.m9685boximpl(Dp.m9687constructorimpl(0)), i2), EasingKt.getLinearOutSlowInEasing());
        keyframes.using(keyframes.at(Dp.m9685boximpl(Dp.m9687constructorimpl(-4.0f)), i2 + 150), EasingKt.getFastOutLinearInEasing());
        keyframes.at(Dp.m9685boximpl(Dp.m9687constructorimpl(0.0f)), i2 + 300);
        keyframes.at(Dp.m9685boximpl(Dp.m9687constructorimpl(0.0f)), 900);
        return Unit.INSTANCE;
    }

    private static final void NotesItemPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-495723000);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NotesItemPreview)239@8597L2096:NotesItem.kt#a1bbf8");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-495723000, i, -1, "com.box.android.notes.presentation.ui.NotesItemPreview (NotesItem.kt:238)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$NotesItemKt.INSTANCE.getLambda$141387613$notes_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.notes.presentation.ui.NotesItemKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NotesItemKt.NotesItemPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final float NoteTypingIndicator$lambda$2$0$0(State<Dp> state) {
        return state.getValue().m9701unboximpl();
    }
}

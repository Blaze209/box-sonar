package com.box.android.preview.iteminformation.collaborators;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.BoxWithConstraintsKt;
import androidx.compose.foundation.layout.BoxWithConstraintsScope;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
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
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.profileinstaller.ProfileVerifier;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.ComposeUtilsKt;
import com.box.android.base.compose.DefaultAvatarControllerWrapper;
import com.box.android.base.compose.UserAvatarKt;
import com.box.android.domain.models.item.ItemCollaborationModel;
import com.box.android.domain.models.item.UserModel;
import com.box.android.preview.R;
import com.facebook.react.uimanager.ViewProps;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.collections.immutable.ImmutableList;
import org.slf4j.Marker;

/* JADX INFO: compiled from: CollaboratorsElement.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b\u0003\u001aM\u0010\u0000\u001a\u00020\u00012\u000e\u0010\u0002\u001a\n\u0012\u0004\u0012\u00020\u0004\u0018\u00010\u00032\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0002\u0010\u000e\u001a=\u0010\u000f\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00102\u0006\u0010\u0011\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\f\u001a\u00020\rH\u0007¢\u0006\u0002\u0010\u0012¨\u0006\u0013"}, d2 = {"CollaboratorsElement", "", "collaborations", "Lkotlinx/collections/immutable/ImmutableList;", "Lcom/box/android/domain/models/item/ItemCollaborationModel;", "maxCollaboratorsDisplayed", "", "maxExtraCollaboratorsNumberDisplayed", "avatarController", "Lcom/box/android/base/compose/DefaultAvatarControllerWrapper;", ViewProps.ON_CLICK, "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lkotlinx/collections/immutable/ImmutableList;IILcom/box/android/base/compose/DefaultAvatarControllerWrapper;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "CollaboratorsAvatarIconsRow", "", "displayAtMost", "(Ljava/util/List;IILcom/box/android/base/compose/DefaultAvatarControllerWrapper;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "preview_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class CollaboratorsElementKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollaboratorsAvatarIconsRow$lambda$2(List list, int i, int i2, DefaultAvatarControllerWrapper defaultAvatarControllerWrapper, Modifier modifier, int i3, int i4, Composer composer, int i5) {
        CollaboratorsAvatarIconsRow(list, i, i2, defaultAvatarControllerWrapper, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), i4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollaboratorsElement$lambda$0(ImmutableList immutableList, int i, int i2, DefaultAvatarControllerWrapper defaultAvatarControllerWrapper, Function0 function0, Modifier modifier, int i3, int i4, Composer composer, int i5) {
        CollaboratorsElement(immutableList, i, i2, defaultAvatarControllerWrapper, function0, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), i4);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollaboratorsElement$lambda$2(ImmutableList immutableList, int i, int i2, DefaultAvatarControllerWrapper defaultAvatarControllerWrapper, Function0 function0, Modifier modifier, int i3, int i4, Composer composer, int i5) {
        CollaboratorsElement(immutableList, i, i2, defaultAvatarControllerWrapper, function0, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i3 | 1), i4);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:53:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:54:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:57:0x00ad A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:58:0x00af  */
    /* JADX WARN: Code duplicated, block: B:59:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:62:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:88:0x0379  */
    /* JADX WARN: Code duplicated, block: B:91:0x0382  */
    /* JADX WARN: Code duplicated, block: B:94:0x0399  */
    /* JADX WARN: Code duplicated, block: B:97:0x03a4  */
    /* JADX WARN: Code duplicated, block: B:98:0x03b8 A[ORIG_RETURN, RETURN] */
    /* JADX WARN: Code duplicated, block: B:99:? A[RETURN, SYNTHETIC] */
    public static final void CollaboratorsElement(final ImmutableList<ItemCollaborationModel> immutableList, final int i, final int i2, final DefaultAvatarControllerWrapper avatarController, final Function0<Unit> onClick, Modifier modifier, Composer composer, final int i3, final int i4) {
        int i5;
        Modifier modifier2;
        boolean z;
        Composer composer2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function2<? super Composer, ? super Integer, Unit> function2;
        Modifier.Companion companion;
        ImmutableList<ItemCollaborationModel> immutableList2;
        final Modifier modifier4;
        Intrinsics.checkNotNullParameter(avatarController, "avatarController");
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Composer composerStartRestartGroup = composer.startRestartGroup(-336655281);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CollaboratorsElement)N(collaborations,maxCollaboratorsDisplayed,maxExtraCollaboratorsNumberDisplayed,avatarController,onClick,modifier)60@2495L69,62@2612L6,54@2287L1411:CollaboratorsElement.kt#vg2tkz");
        if ((i3 & 6) == 0) {
            i5 = (composerStartRestartGroup.changedInstance(immutableList) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i5 |= composerStartRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i3 & 384) == 0) {
            i5 |= composerStartRestartGroup.changed(i2) ? 256 : 128;
        }
        if ((i3 & 3072) == 0) {
            i5 |= composerStartRestartGroup.changed(avatarController) ? 2048 : 1024;
        }
        if ((i3 & 24576) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(onClick) ? 16384 : 8192;
        }
        int i6 = i4 & 32;
        if (i6 == 0) {
            if ((196608 & i3) == 0) {
                modifier2 = modifier;
                i5 |= composerStartRestartGroup.changed(modifier2) ? 131072 : 65536;
            }
            if ((74899 & i5) != 74898) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-336655281, i5, -1, "com.box.android.preview.iteminformation.collaborators.CollaboratorsElement (CollaboratorsElement.kt:50)");
                }
                immutableList2 = immutableList;
                if (immutableList2 != null || immutableList2.isEmpty()) {
                    modifier4 = companion;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup == null) {
                        return;
                    } else {
                        function2 = new Function2() { // from class: com.box.android.preview.iteminformation.collaborators.CollaboratorsElementKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CollaboratorsElementKt.CollaboratorsElement$lambda$0(immutableList, i, i2, avatarController, onClick, modifier4, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        };
                    }
                } else {
                    float f = 8;
                    int i7 = i5;
                    Modifier modifier5 = companion;
                    Modifier modifierTestTag = TestTagKt.testTag(BackgroundKt.m589backgroundbw27NRU$default(ClickableKt.m632clickableoSLSa3U$default(ClipKt.clip(PaddingKt.m1220paddingVpY3zN4$default(companion, Dp.m9687constructorimpl(24), 0.0f, 2, null), RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(f))), false, StringResources_androidKt.stringResource(R.string.collaborators_element_onclick_talkback_label, composerStartRestartGroup, 0), null, null, onClick, 13, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11511getContentBackground0d7_KjU(), null, 2, null), "CollaboratorsElement:Collaborators");
                    Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composerStartRestartGroup, 48);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierTestTag);
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1029607107, "C66@2769L665,86@3471L64,88@3604L6,85@3443L249:CollaboratorsElement.kt#vg2tkz");
                    Modifier modifierWeight$default = RowScope.weight$default(rowScopeInstance, PaddingKt.m1220paddingVpY3zN4$default(PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, 0.0f, Dp.m9687constructorimpl(f), 1, null), Dp.m9687constructorimpl(16), 0.0f, 2, null), 1.0f, false, 2, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default);
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
                    Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1070865682, "C73@2977L43,75@3112L6,72@2948L206,77@3167L40,78@3220L204:CollaboratorsElement.kt#vg2tkz");
                    TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(R.string.collaborators, composerStartRestartGroup, 0), null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11526getItemInfoTextSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal12(), composerStartRestartGroup, 0, 0, 131066);
                    SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(4)), composerStartRestartGroup, 6);
                    CollaboratorsAvatarIconsRow(immutableList, i, i2, avatarController, null, composerStartRestartGroup, i7 & 8190, 16);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    IconKt.m3575Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.ic_iteminfo_go_to_collaborators, composerStartRestartGroup, 0), (String) null, PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, Dp.m9687constructorimpl(12), 0.0f, 11, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), composerStartRestartGroup, Painter.$stable | 432, 0);
                    composer2 = composerStartRestartGroup;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier5;
                }
                scopeUpdateScopeEndRestartGroup.updateScope(function2);
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                function2 = new Function2() { // from class: com.box.android.preview.iteminformation.collaborators.CollaboratorsElementKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CollaboratorsElementKt.CollaboratorsElement$lambda$2(immutableList, i, i2, avatarController, onClick, modifier3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                };
                scopeUpdateScopeEndRestartGroup.updateScope(function2);
            }
        }
        i5 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        modifier2 = modifier;
        if ((74899 & i5) != 74898) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i6 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-336655281, i5, -1, "com.box.android.preview.iteminformation.collaborators.CollaboratorsElement (CollaboratorsElement.kt:50)");
            }
            immutableList2 = immutableList;
            if (immutableList2 != null) {
            }
            modifier4 = companion;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup == null) {
                function2 = new Function2() { // from class: com.box.android.preview.iteminformation.collaborators.CollaboratorsElementKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CollaboratorsElementKt.CollaboratorsElement$lambda$0(immutableList, i, i2, avatarController, onClick, modifier4, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                };
                scopeUpdateScopeEndRestartGroup.updateScope(function2);
            }
            return;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            function2 = new Function2() { // from class: com.box.android.preview.iteminformation.collaborators.CollaboratorsElementKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CollaboratorsElementKt.CollaboratorsElement$lambda$2(immutableList, i, i2, avatarController, onClick, modifier3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            };
            scopeUpdateScopeEndRestartGroup.updateScope(function2);
        }
    }

    /* JADX WARN: Code duplicated, block: B:45:0x0089  */
    /* JADX WARN: Code duplicated, block: B:46:0x008b  */
    /* JADX WARN: Code duplicated, block: B:49:0x0094 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:50:0x0096  */
    /* JADX WARN: Code duplicated, block: B:51:0x009c  */
    /* JADX WARN: Code duplicated, block: B:54:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:59:0x0107  */
    /* JADX WARN: Code duplicated, block: B:62:0x013b  */
    /* JADX WARN: Code duplicated, block: B:64:0x0140  */
    /* JADX WARN: Code duplicated, block: B:67:0x014a  */
    /* JADX WARN: Code duplicated, block: B:69:? A[RETURN, SYNTHETIC] */
    public static final void CollaboratorsAvatarIconsRow(final List<ItemCollaborationModel> collaborations, final int i, final int i2, final DefaultAvatarControllerWrapper avatarController, Modifier modifier, Composer composer, final int i3, final int i4) {
        int i5;
        final int i6;
        Modifier modifier2;
        boolean z;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        final String strStringResource;
        boolean zChanged;
        Object objRememberedValue;
        Intrinsics.checkNotNullParameter(collaborations, "collaborations");
        Intrinsics.checkNotNullParameter(avatarController, "avatarController");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1600693676);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(CollaboratorsAvatarIconsRow)N(collaborations,displayAtMost,maxExtraCollaboratorsNumberDisplayed,avatarController,modifier)103@4018L6,104@4085L87,109@4319L76,112@4402L2656,105@4177L2881:CollaboratorsElement.kt#vg2tkz");
        if ((i3 & 6) == 0) {
            i5 = (composerStartRestartGroup.changedInstance(collaborations) ? 4 : 2) | i3;
        } else {
            i5 = i3;
        }
        if ((i3 & 48) == 0) {
            i6 = i;
            i5 |= composerStartRestartGroup.changed(i6) ? 32 : 16;
        } else {
            i6 = i;
        }
        if ((i3 & 384) == 0) {
            i5 |= composerStartRestartGroup.changed(i2) ? 256 : 128;
        }
        if ((i3 & 3072) == 0) {
            i5 |= composerStartRestartGroup.changed(avatarController) ? 2048 : 1024;
        }
        int i7 = i4 & 16;
        if (i7 == 0) {
            if ((i3 & 24576) == 0) {
                modifier2 = modifier;
                i5 |= composerStartRestartGroup.changed(modifier2) ? 16384 : 8192;
            }
            if ((i5 & 9363) != 9362) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                if (i7 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1600693676, i5, -1, "com.box.android.preview.iteminformation.collaborators.CollaboratorsAvatarIconsRow (CollaboratorsElement.kt:101)");
                }
                final float fM9687constructorimpl = Dp.m9687constructorimpl(8);
                final float fM9687constructorimpl2 = Dp.m9687constructorimpl(Math.max(ComposeUtilsKt.m11637toDpo2QH7mI(TextUnitKt.getSp(30), composerStartRestartGroup, 6), BoxTheme.INSTANCE.getSizes().getAvatar().m11350getMediumD9Ej5fM()));
                strStringResource = StringResources_androidKt.stringResource(R.string.collaborators_element_talkback_label, new Object[]{Integer.valueOf(collaborations.size())}, composerStartRestartGroup, 0);
                Modifier modifierM1252height3ABfNKs = SizeKt.m1252height3ABfNKs(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null), fM9687constructorimpl2);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -668311232, "CC(remember):CollaboratorsElement.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(strStringResource);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.box.android.preview.iteminformation.collaborators.CollaboratorsElementKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return CollaboratorsElementKt.CollaboratorsAvatarIconsRow$lambda$0$0(strStringResource, (SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                BoxWithConstraintsKt.BoxWithConstraints(SemanticsModifierKt.clearAndSetSemantics(modifierM1252height3ABfNKs, (Function1) objRememberedValue), null, false, ComposableLambdaKt.rememberComposableLambda(-995763650, true, new Function3() { // from class: com.box.android.preview.iteminformation.collaborators.CollaboratorsElementKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return CollaboratorsElementKt.CollaboratorsAvatarIconsRow$lambda$1(fM9687constructorimpl2, fM9687constructorimpl, i6, collaborations, avatarController, i2, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 3072, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.iteminformation.collaborators.CollaboratorsElementKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CollaboratorsElementKt.CollaboratorsAvatarIconsRow$lambda$2(collaborations, i, i2, avatarController, modifier3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i5 |= 24576;
        modifier2 = modifier;
        if ((i5 & 9363) != 9362) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i5 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i7 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1600693676, i5, -1, "com.box.android.preview.iteminformation.collaborators.CollaboratorsAvatarIconsRow (CollaboratorsElement.kt:101)");
            }
            final float fM9687constructorimpl3 = Dp.m9687constructorimpl(8);
            final float fM9687constructorimpl4 = Dp.m9687constructorimpl(Math.max(ComposeUtilsKt.m11637toDpo2QH7mI(TextUnitKt.getSp(30), composerStartRestartGroup, 6), BoxTheme.INSTANCE.getSizes().getAvatar().m11350getMediumD9Ej5fM()));
            strStringResource = StringResources_androidKt.stringResource(R.string.collaborators_element_talkback_label, new Object[]{Integer.valueOf(collaborations.size())}, composerStartRestartGroup, 0);
            Modifier modifierM1252height3ABfNKs2 = SizeKt.m1252height3ABfNKs(SizeKt.fillMaxWidth$default(modifier4, 0.0f, 1, null), fM9687constructorimpl4);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -668311232, "CC(remember):CollaboratorsElement.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(strStringResource);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue = new Function1() { // from class: com.box.android.preview.iteminformation.collaborators.CollaboratorsElementKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CollaboratorsElementKt.CollaboratorsAvatarIconsRow$lambda$0$0(strStringResource, (SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function1() { // from class: com.box.android.preview.iteminformation.collaborators.CollaboratorsElementKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return CollaboratorsElementKt.CollaboratorsAvatarIconsRow$lambda$0$0(strStringResource, (SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BoxWithConstraintsKt.BoxWithConstraints(SemanticsModifierKt.clearAndSetSemantics(modifierM1252height3ABfNKs2, (Function1) objRememberedValue), null, false, ComposableLambdaKt.rememberComposableLambda(-995763650, true, new Function3() { // from class: com.box.android.preview.iteminformation.collaborators.CollaboratorsElementKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return CollaboratorsElementKt.CollaboratorsAvatarIconsRow$lambda$1(fM9687constructorimpl4, fM9687constructorimpl3, i6, collaborations, avatarController, i2, (BoxWithConstraintsScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 3072, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.iteminformation.collaborators.CollaboratorsElementKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CollaboratorsElementKt.CollaboratorsAvatarIconsRow$lambda$2(collaborations, i, i2, avatarController, modifier3, i3, i4, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit CollaboratorsAvatarIconsRow$lambda$0$0(String str, SemanticsPropertyReceiver clearAndSetSemantics) {
        Intrinsics.checkNotNullParameter(clearAndSetSemantics, "$this$clearAndSetSemantics");
        SemanticsPropertiesKt.setContentDescription(clearAndSetSemantics, str);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r15v4 */
    /* JADX WARN: Type inference failed for: r15v5 */
    /* JADX WARN: Type inference failed for: r27v0 */
    /* JADX WARN: Type inference failed for: r27v1 */
    /* JADX WARN: Type inference failed for: r27v2 */
    /* JADX WARN: Type inference failed for: r36v0 */
    /* JADX WARN: Type inference failed for: r36v1 */
    /* JADX WARN: Type inference failed for: r36v2 */
    /* JADX WARN: Type inference failed for: r7v0 */
    /* JADX WARN: Type inference failed for: r7v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r7v6 */
    public static final Unit CollaboratorsAvatarIconsRow$lambda$1(float f, float f2, int i, List list, DefaultAvatarControllerWrapper defaultAvatarControllerWrapper, int i2, BoxWithConstraintsScope BoxWithConstraints, Composer composer, int i3) {
        String str;
        int i4;
        int i5;
        String str2;
        ?? r36;
        int i6;
        String str3;
        String id;
        String inviteEmail;
        Composer composer2 = composer;
        Intrinsics.checkNotNullParameter(BoxWithConstraints, "$this$BoxWithConstraints");
        ComposerKt.sourceInformation(composer2, "C121@4691L2361:CollaboratorsElement.kt#vg2tkz");
        int i7 = (i3 & 6) == 0 ? i3 | (composer2.changed(BoxWithConstraints) ? 4 : 2) : i3;
        ?? r7 = 0;
        int i8 = 1;
        if (!composer2.shouldExecute((i7 & 19) != 18, i7 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-995763650, i7, -1, "com.box.android.preview.iteminformation.collaborators.CollaboratorsAvatarIconsRow.<anonymous> (CollaboratorsElement.kt:113)");
            }
            int iM12847calculateAvatarsToDisplayDRUOcmI = CollaboratorsElementHelper.INSTANCE.m12847calculateAvatarsToDisplayDRUOcmI(f, f2, BoxWithConstraints.mo1101getMaxWidthD9Ej5fM(), Math.min(i, list.size()));
            ?? r27 = iM12847calculateAvatarsToDisplayDRUOcmI < list.size();
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
            Arrangement.HorizontalOrVertical horizontalOrVerticalM1073spacedBy0680j_4 = Arrangement.INSTANCE.m1073spacedBy0680j_4(Dp.m9687constructorimpl(-f2));
            ComposerKt.sourceInformationMarkerStart(composer2, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(horizontalOrVerticalM1073spacedBy0680j_4, Alignment.INSTANCE.getTop(), composer2, 6);
            int i9 = -1159599143;
            String str4 = "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh";
            ComposerKt.sourceInformationMarkerStart(composer2, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierFillMaxWidth$default);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            int i10 = -553112988;
            String str5 = "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp";
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer2, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer2, -1473531026, "C:CollaboratorsElement.kt#vg2tkz");
            composer2.startReplaceGroup(-47532081);
            String str6 = "";
            ComposerKt.sourceInformation(composer2, "");
            int i11 = 0;
            for (Object obj : CollectionsKt.take(list, iM12847calculateAvatarsToDisplayDRUOcmI)) {
                int i12 = i11 + 1;
                if (i11 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                ItemCollaborationModel itemCollaborationModel = (ItemCollaborationModel) obj;
                if (i11 == iM12847calculateAvatarsToDisplayDRUOcmI - 1 && r27 != false) {
                    composer2.startReplaceGroup(-735259674);
                    ComposerKt.sourceInformation(composer2, "134@5298L6,137@5455L6,128@5024L1210");
                    Modifier modifierM589backgroundbw27NRU$default = BackgroundKt.m589backgroundbw27NRU$default(BorderKt.m604borderxT4_qwU(ClipKt.clip(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, f), RoundedCornerShapeKt.getCircleShape()), Dp.m9687constructorimpl(i8), BoxTheme.INSTANCE.getColors(composer2, BoxTheme.$stable).m11511getContentBackground0d7_KjU(), RoundedCornerShapeKt.getCircleShape()), BoxTheme.INSTANCE.getColors(composer2, BoxTheme.$stable).m11515getDefaultActionIconBackground0d7_KjU(), null, 2, null);
                    ComposerKt.sourceInformationMarkerStart(composer2, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), r7);
                    ComposerKt.sourceInformationMarkerStart(composer2, i9, str4);
                    int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, r7));
                    CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, modifierM589backgroundbw27NRU$default);
                    Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer2, i10, str5);
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
                    Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer2, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer2, -2142659287, "C150@6162L6,143@5744L468:CollaboratorsElement.kt#vg2tkz");
                    String str7 = Marker.ANY_NON_NULL_MARKER + Math.min(list.size() - i11, i2);
                    TextStyle boxNormal12 = BoxTheme.INSTANCE.getTypography().getBoxNormal12();
                    Modifier modifierTestTag = TestTagKt.testTag(boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getCenter()), "CollaboratorsElement:ExtraCollaboratorsIcon");
                    long jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composer2, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU();
                    str = str6;
                    i4 = iM12847calculateAvatarsToDisplayDRUOcmI;
                    i6 = i10;
                    str3 = str5;
                    str2 = str4;
                    r36 = r7 == true ? 1 : 0;
                    i5 = -1159599143;
                    TextKt.m4494TextNvy7gAk(str7, modifierTestTag, jM11533getMainActiveControl0d7_KjU, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 1, 0, null, boxNormal12, composer, 0, 24576, 114680);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    composer.endReplaceGroup();
                    i8 = 1;
                } else {
                    str = str6;
                    i4 = iM12847calculateAvatarsToDisplayDRUOcmI;
                    i5 = i9;
                    str2 = str4;
                    r36 = r7;
                    i6 = i10;
                    str3 = str5;
                    composer2.startReplaceGroup(-734028602);
                    ComposerKt.sourceInformation(composer2, "163@6802L6,154@6280L730");
                    UserModel accessibleBy = itemCollaborationModel.getAccessibleBy();
                    if (accessibleBy == null || (id = accessibleBy.getId()) == null) {
                        id = str;
                    }
                    UserModel accessibleBy2 = itemCollaborationModel.getAccessibleBy();
                    if ((accessibleBy2 == null || (inviteEmail = accessibleBy2.getName()) == null) && (inviteEmail = itemCollaborationModel.getInviteEmail()) == null) {
                        inviteEmail = str;
                    }
                    i8 = 1;
                    UserAvatarKt.UserAvatar(id, inviteEmail, defaultAvatarControllerWrapper.getDefaultAvatarController(), TestTagKt.testTag(BorderKt.m604borderxT4_qwU(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, f), Dp.m9687constructorimpl(1), BoxTheme.INSTANCE.getColors(composer2, BoxTheme.$stable).m11511getContentBackground0d7_KjU(), RoundedCornerShapeKt.getCircleShape()), "CollaboratorsElement:UserAvatar-" + i11), composer2, 0, 0);
                    composer.endReplaceGroup();
                }
                composer2 = composer;
                i11 = i12;
                str6 = str;
                iM12847calculateAvatarsToDisplayDRUOcmI = i4;
                i10 = i6;
                str5 = str3;
                str4 = str2;
                i9 = i5;
                r7 = r36;
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
        }
        return Unit.INSTANCE;
    }
}

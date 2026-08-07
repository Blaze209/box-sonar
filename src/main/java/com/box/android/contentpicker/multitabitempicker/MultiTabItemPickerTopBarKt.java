package com.box.android.contentpicker.multitabitempicker;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.ScrollState;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextOverflow;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import com.box.android.base.compose.BoxSizes;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.base.compose.button.BoxIconButtonKt;
import com.box.android.base.compose.button.model.ButtonItem;
import com.box.android.base.compose.button.model.ButtonItemIconResource;
import com.box.android.contentpicker.R;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.domain.models.item.ItemModelKt;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: MultiTabItemPickerTopBar.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0007\u001ac\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00012\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u0007¢\u0006\u0002\u0010\u0010\u001a/\u0010\u0011\u001a\u00020\u00032\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t2\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\r\u0012\u0004\u0012\u00020\u00030\fH\u0003¢\u0006\u0002\u0010\u0012\u001a\r\u0010\u0013\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0014\u001a\r\u0010\u0015\u001a\u00020\u0003H\u0007¢\u0006\u0002\u0010\u0014\"\u000e\u0010\u0000\u001a\u00020\u0001X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"BREADCRUMB_SEPARATOR", "", "MultiTabItemPickerTopBar", "", "onBackPressed", "Lkotlin/Function0;", "onSearchClicked", "subNavigationTitle", "folderStack", "", "Lcom/box/android/domain/models/item/FolderModel;", "onFolderStackItemClicked", "Lkotlin/Function1;", "Lcom/box/android/domain/models/ItemId$Remote;", "showSearchButton", "", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Ljava/lang/String;Ljava/util/List;Lkotlin/jvm/functions/Function1;ZLandroidx/compose/runtime/Composer;II)V", "FolderBreadcrumbSubtitle", "(Ljava/util/List;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "MultiTabItemPickerTopBarPreview", "(Landroidx/compose/runtime/Composer;I)V", "MultiTabItemPickerTopBarWithBreadcrumbPreview", "content-picker_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class MultiTabItemPickerTopBarKt {
    private static final String BREADCRUMB_SEPARATOR = "  >  ";

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FolderBreadcrumbSubtitle$lambda$2(List list, Function1 function1, int i, Composer composer, int i2) {
        FolderBreadcrumbSubtitle(list, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiTabItemPickerTopBar$lambda$1(Function0 function0, Function0 function1, String str, List list, Function1 function2, boolean z, int i, int i2, Composer composer, int i3) {
        MultiTabItemPickerTopBar(function0, function1, str, list, function2, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiTabItemPickerTopBarPreview$lambda$3(int i, Composer composer, int i2) {
        MultiTabItemPickerTopBarPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiTabItemPickerTopBarWithBreadcrumbPreview$lambda$0(int i, Composer composer, int i2) {
        MultiTabItemPickerTopBarWithBreadcrumbPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x02c5  */
    /* JADX WARN: Code duplicated, block: B:105:0x02d1  */
    /* JADX WARN: Code duplicated, block: B:106:0x02d5  */
    /* JADX WARN: Code duplicated, block: B:109:0x0323  */
    /* JADX WARN: Code duplicated, block: B:110:0x0339  */
    /* JADX WARN: Code duplicated, block: B:113:0x03af  */
    /* JADX WARN: Code duplicated, block: B:114:0x03c2  */
    /* JADX WARN: Code duplicated, block: B:117:0x03df  */
    /* JADX WARN: Code duplicated, block: B:119:0x0405  */
    /* JADX WARN: Code duplicated, block: B:120:0x0407  */
    /* JADX WARN: Code duplicated, block: B:123:0x040e  */
    /* JADX WARN: Code duplicated, block: B:125:0x0416  */
    /* JADX WARN: Code duplicated, block: B:127:0x044d  */
    /* JADX WARN: Code duplicated, block: B:130:0x046e  */
    /* JADX WARN: Code duplicated, block: B:132:0x0476  */
    /* JADX WARN: Code duplicated, block: B:135:0x0483  */
    /* JADX WARN: Code duplicated, block: B:137:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:30:0x0066  */
    /* JADX WARN: Code duplicated, block: B:31:0x0069  */
    /* JADX WARN: Code duplicated, block: B:33:0x006d  */
    /* JADX WARN: Code duplicated, block: B:35:0x0075  */
    /* JADX WARN: Code duplicated, block: B:36:0x0078  */
    /* JADX WARN: Code duplicated, block: B:41:0x0082  */
    /* JADX WARN: Code duplicated, block: B:43:0x0088  */
    /* JADX WARN: Code duplicated, block: B:44:0x008b  */
    /* JADX WARN: Code duplicated, block: B:48:0x0094  */
    /* JADX WARN: Code duplicated, block: B:49:0x0096  */
    /* JADX WARN: Code duplicated, block: B:51:0x0099  */
    /* JADX WARN: Code duplicated, block: B:53:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:54:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:59:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:60:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:63:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:65:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:66:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:68:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:69:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:71:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:72:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:75:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:78:0x0165  */
    /* JADX WARN: Code duplicated, block: B:81:0x0171  */
    /* JADX WARN: Code duplicated, block: B:82:0x0175  */
    /* JADX WARN: Code duplicated, block: B:85:0x01c5  */
    /* JADX WARN: Code duplicated, block: B:86:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:89:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:90:0x01e6  */
    /* JADX WARN: Code duplicated, block: B:93:0x0209  */
    /* JADX WARN: Code duplicated, block: B:94:0x020b  */
    /* JADX WARN: Code duplicated, block: B:97:0x0212  */
    /* JADX WARN: Code duplicated, block: B:99:0x021a  */
    public static final void MultiTabItemPickerTopBar(final Function0<Unit> onBackPressed, final Function0<Unit> onSearchClicked, String str, List<FolderModel> list, final Function1<? super ItemId.Remote, Unit> onFolderStackItemClicked, boolean z, Composer composer, final int i, final int i2) {
        int i3;
        int i4;
        List<FolderModel> list2;
        int i5;
        int i6;
        boolean z2;
        int i7;
        boolean z3;
        final String str2;
        final List<FolderModel> list3;
        final boolean z4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        String str3;
        List<FolderModel> listEmptyList;
        boolean z5;
        Function0<ComposeUiNode> constructor;
        boolean z6;
        String strStringResource;
        boolean z7;
        Object objRememberedValue;
        Function0<ComposeUiNode> constructor2;
        String str4;
        boolean z8;
        Object objRememberedValue2;
        int i8;
        Intrinsics.checkNotNullParameter(onBackPressed, "onBackPressed");
        Intrinsics.checkNotNullParameter(onSearchClicked, "onSearchClicked");
        Intrinsics.checkNotNullParameter(onFolderStackItemClicked, "onFolderStackItemClicked");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1353976183);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(MultiTabItemPickerTopBar)N(onBackPressed,onSearchClicked,subNavigationTitle,folderStack,onFolderStackItemClicked,showSearchButton)53@2231L6,50@2148L2088:MultiTabItemPickerTopBar.kt#aug1cj");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(onBackPressed) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onSearchClicked) ? 32 : 16;
        }
        int i9 = i2 & 4;
        if (i9 == 0) {
            if ((i & 384) == 0) {
                i3 |= composerStartRestartGroup.changed(str) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    list2 = list;
                    if (composerStartRestartGroup.changedInstance(list2)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                if ((i & 24576) == 0) {
                    if (composerStartRestartGroup.changedInstance(onFolderStackItemClicked)) {
                        i8 = 16384;
                    } else {
                        i8 = 8192;
                    }
                    i3 |= i8;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    if ((196608 & i) == 0) {
                        z2 = z;
                        if (composerStartRestartGroup.changed(z2)) {
                            i7 = 131072;
                        } else {
                            i7 = 65536;
                        }
                        i3 |= i7;
                    }
                    if ((i3 & 74899) != 74898) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        str2 = str;
                        list3 = list2;
                        z4 = z2;
                    } else {
                        if (i9 != 0) {
                            str3 = null;
                        } else {
                            str3 = str;
                        }
                        if (i4 != 0) {
                            listEmptyList = CollectionsKt.emptyList();
                        } else {
                            listEmptyList = list2;
                        }
                        if (i6 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1353976183, i3, -1, "com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerTopBar (MultiTabItemPickerTopBar.kt:49)");
                        }
                        Modifier modifierM1220paddingVpY3zN4$default = PaddingKt.m1220paddingVpY3zN4$default(SizeKt.m1252height3ABfNKs(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11498getAppBackground0d7_KjU(), null, 2, null), BoxSizes.INSTANCE.m11614getTopBarHeightD9Ej5fM()), Dp.m9687constructorimpl(12), 0.0f, 2, null);
                        Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                        MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composerStartRestartGroup, 48);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1220paddingVpY3zN4$default);
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
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -503224007, "C62@2653L55,71@2990L6,59@2462L564,74@3036L27,76@3073L715:MultiTabItemPickerTopBar.kt#aug1cj");
                        if (str3 != null) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        ButtonItemIconResource.DrawableResource drawableResource = new ButtonItemIconResource.DrawableResource(R.drawable.ic_arrow_left);
                        if (z6) {
                            composerStartRestartGroup.startReplaceGroup(-502925478);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "66@2786L51");
                            strStringResource = StringResources_androidKt.stringResource(R.string.back_button_talkback_label, composerStartRestartGroup, 0);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-502829440);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "68@2883L45");
                            strStringResource = StringResources_androidKt.stringResource(R.string.talkback_label_close, composerStartRestartGroup, 0);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        String str5 = strStringResource;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1540247644, "CC(remember):MultiTabItemPickerTopBar.kt#9igjgp");
                        if ((i3 & 14) == 4) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!z7 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function0() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerTopBarKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return MultiTabItemPickerTopBarKt.MultiTabItemPickerTopBar$lambda$0$0$0(onBackPressed);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        list3 = listEmptyList;
                        BoxIconButtonKt.m11681BoxIconButtonuDo3WH8(new ButtonItem.IconButtonItem(false, (Function0) objRememberedValue, str5, drawableResource, false, 17, null), null, null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11580getTopBarTextSecondary0d7_KjU(), 0.0f, composerStartRestartGroup, 0, 22);
                        float f = 4;
                        SpacerKt.Spacer(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composerStartRestartGroup, 6);
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
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 782626932, "C80@3319L10,81@3385L6,77@3126L379,85@3518L27:MultiTabItemPickerTopBar.kt#aug1cj");
                        if (str3 == null) {
                            composerStartRestartGroup.startReplaceGroup(1133625480);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "78@3170L37");
                            String strStringResource2 = StringResources_androidKt.stringResource(R.string.box_app_name, composerStartRestartGroup, 0);
                            composerStartRestartGroup.endReplaceGroup();
                            str4 = strStringResource2;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1133624798);
                            composerStartRestartGroup.endReplaceGroup();
                            str4 = str3;
                        }
                        TextKt.m4494TextNvy7gAk(str4, TestTagKt.testTag(Modifier.INSTANCE, "MultiTabItemPickerTitle"), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11580getTopBarTextSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getTitleLargeEmphasized(), composerStartRestartGroup, 48, 24960, 110584);
                        composerStartRestartGroup = composerStartRestartGroup;
                        SpacerKt.Spacer(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composerStartRestartGroup, 6);
                        if (list3.size() > 1) {
                            composerStartRestartGroup.startReplaceGroup(779504735);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(783067069);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "87@3602L162");
                            FolderBreadcrumbSubtitle(list3, onFolderStackItemClicked, composerStartRestartGroup, (i3 >> 9) & 126);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (z5) {
                            composerStartRestartGroup.startReplaceGroup(-501868037);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "99@4097L31,98@4033L21,101@4180L6,95@3834L386");
                            ButtonItemIconResource.DrawableResource drawableResource2 = new ButtonItemIconResource.DrawableResource(R.drawable.ic_search);
                            String strStringResource3 = StringResources_androidKt.stringResource(R.string.search, composerStartRestartGroup, 0);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1540203518, "CC(remember):MultiTabItemPickerTopBar.kt#9igjgp");
                            if ((i3 & 112) == 32) {
                                z8 = true;
                            } else {
                                z8 = false;
                            }
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (!z8 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = new Function0() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerTopBarKt$$ExternalSyntheticLambda1
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return MultiTabItemPickerTopBarKt.MultiTabItemPickerTopBar$lambda$0$2$0(onSearchClicked);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            BoxIconButtonKt.m11681BoxIconButtonuDo3WH8(new ButtonItem.IconButtonItem(false, (Function0) objRememberedValue2, strStringResource3, drawableResource2, false, 17, null), null, null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11580getTopBarTextSecondary0d7_KjU(), 0.0f, composerStartRestartGroup, 0, 22);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(-505671179);
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
                        str2 = str3;
                        z4 = z5;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerTopBarKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return MultiTabItemPickerTopBarKt.MultiTabItemPickerTopBar$lambda$1(onBackPressed, onSearchClicked, str2, list3, onFolderStackItemClicked, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                z2 = z;
                if ((i3 & 74899) != 74898) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    str2 = str;
                    list3 = list2;
                    z4 = z2;
                } else {
                    if (i9 != 0) {
                        str3 = null;
                    } else {
                        str3 = str;
                    }
                    if (i4 != 0) {
                        listEmptyList = CollectionsKt.emptyList();
                    } else {
                        listEmptyList = list2;
                    }
                    if (i6 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1353976183, i3, -1, "com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerTopBar (MultiTabItemPickerTopBar.kt:49)");
                    }
                    Modifier modifierM1220paddingVpY3zN4$default2 = PaddingKt.m1220paddingVpY3zN4$default(SizeKt.m1252height3ABfNKs(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11498getAppBackground0d7_KjU(), null, 2, null), BoxSizes.INSTANCE.m11614getTopBarHeightD9Ej5fM()), Dp.m9687constructorimpl(12), 0.0f, 2, null);
                    Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically2, composerStartRestartGroup, 48);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1220paddingVpY3zN4$default2);
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -503224007, "C62@2653L55,71@2990L6,59@2462L564,74@3036L27,76@3073L715:MultiTabItemPickerTopBar.kt#aug1cj");
                    if (str3 != null) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    ButtonItemIconResource.DrawableResource drawableResource3 = new ButtonItemIconResource.DrawableResource(R.drawable.ic_arrow_left);
                    if (z6) {
                        composerStartRestartGroup.startReplaceGroup(-502925478);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "66@2786L51");
                        strStringResource = StringResources_androidKt.stringResource(R.string.back_button_talkback_label, composerStartRestartGroup, 0);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-502829440);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "68@2883L45");
                        strStringResource = StringResources_androidKt.stringResource(R.string.talkback_label_close, composerStartRestartGroup, 0);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    String str6 = strStringResource;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1540247644, "CC(remember):MultiTabItemPickerTopBar.kt#9igjgp");
                    if ((i3 & 14) == 4) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z7) {
                        objRememberedValue = new Function0() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerTopBarKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return MultiTabItemPickerTopBarKt.MultiTabItemPickerTopBar$lambda$0$0$0(onBackPressed);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function0() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerTopBarKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return MultiTabItemPickerTopBarKt.MultiTabItemPickerTopBar$lambda$0$0$0(onBackPressed);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    list3 = listEmptyList;
                    BoxIconButtonKt.m11681BoxIconButtonuDo3WH8(new ButtonItem.IconButtonItem(false, (Function0) objRememberedValue, str6, drawableResource3, false, 17, null), null, null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11580getTopBarTextSecondary0d7_KjU(), 0.0f, composerStartRestartGroup, 0, 22);
                    float f2 = 4;
                    SpacerKt.Spacer(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f2)), composerStartRestartGroup, 6);
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 782626932, "C80@3319L10,81@3385L6,77@3126L379,85@3518L27:MultiTabItemPickerTopBar.kt#aug1cj");
                    if (str3 == null) {
                        composerStartRestartGroup.startReplaceGroup(1133625480);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "78@3170L37");
                        String strStringResource4 = StringResources_androidKt.stringResource(R.string.box_app_name, composerStartRestartGroup, 0);
                        composerStartRestartGroup.endReplaceGroup();
                        str4 = strStringResource4;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1133624798);
                        composerStartRestartGroup.endReplaceGroup();
                        str4 = str3;
                    }
                    TextKt.m4494TextNvy7gAk(str4, TestTagKt.testTag(Modifier.INSTANCE, "MultiTabItemPickerTitle"), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11580getTopBarTextSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getTitleLargeEmphasized(), composerStartRestartGroup, 48, 24960, 110584);
                    composerStartRestartGroup = composerStartRestartGroup;
                    SpacerKt.Spacer(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f2)), composerStartRestartGroup, 6);
                    if (list3.size() > 1) {
                        composerStartRestartGroup.startReplaceGroup(779504735);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(783067069);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "87@3602L162");
                        FolderBreadcrumbSubtitle(list3, onFolderStackItemClicked, composerStartRestartGroup, (i3 >> 9) & 126);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (z5) {
                        composerStartRestartGroup.startReplaceGroup(-501868037);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "99@4097L31,98@4033L21,101@4180L6,95@3834L386");
                        ButtonItemIconResource.DrawableResource drawableResource4 = new ButtonItemIconResource.DrawableResource(R.drawable.ic_search);
                        String strStringResource5 = StringResources_androidKt.stringResource(R.string.search, composerStartRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1540203518, "CC(remember):MultiTabItemPickerTopBar.kt#9igjgp");
                        if ((i3 & 112) == 32) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!z8) {
                            objRememberedValue2 = new Function0() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerTopBarKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return MultiTabItemPickerTopBarKt.MultiTabItemPickerTopBar$lambda$0$2$0(onSearchClicked);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new Function0() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerTopBarKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return MultiTabItemPickerTopBarKt.MultiTabItemPickerTopBar$lambda$0$2$0(onSearchClicked);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        BoxIconButtonKt.m11681BoxIconButtonuDo3WH8(new ButtonItem.IconButtonItem(false, (Function0) objRememberedValue2, strStringResource5, drawableResource4, false, 17, null), null, null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11580getTopBarTextSecondary0d7_KjU(), 0.0f, composerStartRestartGroup, 0, 22);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-505671179);
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
                    str2 = str3;
                    z4 = z5;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerTopBarKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return MultiTabItemPickerTopBarKt.MultiTabItemPickerTopBar$lambda$1(onBackPressed, onSearchClicked, str2, list3, onFolderStackItemClicked, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            list2 = list;
            if ((i & 24576) == 0) {
                if (composerStartRestartGroup.changedInstance(onFolderStackItemClicked)) {
                    i8 = 16384;
                } else {
                    i8 = 8192;
                }
                i3 |= i8;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((196608 & i) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                if ((i3 & 74899) != 74898) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    str2 = str;
                    list3 = list2;
                    z4 = z2;
                } else {
                    if (i9 != 0) {
                        str3 = null;
                    } else {
                        str3 = str;
                    }
                    if (i4 != 0) {
                        listEmptyList = CollectionsKt.emptyList();
                    } else {
                        listEmptyList = list2;
                    }
                    if (i6 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1353976183, i3, -1, "com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerTopBar (MultiTabItemPickerTopBar.kt:49)");
                    }
                    Modifier modifierM1220paddingVpY3zN4$default3 = PaddingKt.m1220paddingVpY3zN4$default(SizeKt.m1252height3ABfNKs(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11498getAppBackground0d7_KjU(), null, 2, null), BoxSizes.INSTANCE.m11614getTopBarHeightD9Ej5fM()), Dp.m9687constructorimpl(12), 0.0f, 2, null);
                    Alignment.Vertical centerVertically3 = Alignment.INSTANCE.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically3, composerStartRestartGroup, 48);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode5 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1220paddingVpY3zN4$default3);
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
                    Composer composerM6062constructorimpl5 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl5, measurePolicyRowMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl5, Integer.valueOf(iHashCode5), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl5, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl5, modifierMaterializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance3 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -503224007, "C62@2653L55,71@2990L6,59@2462L564,74@3036L27,76@3073L715:MultiTabItemPickerTopBar.kt#aug1cj");
                    if (str3 != null) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    ButtonItemIconResource.DrawableResource drawableResource5 = new ButtonItemIconResource.DrawableResource(R.drawable.ic_arrow_left);
                    if (z6) {
                        composerStartRestartGroup.startReplaceGroup(-502925478);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "66@2786L51");
                        strStringResource = StringResources_androidKt.stringResource(R.string.back_button_talkback_label, composerStartRestartGroup, 0);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-502829440);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "68@2883L45");
                        strStringResource = StringResources_androidKt.stringResource(R.string.talkback_label_close, composerStartRestartGroup, 0);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    String str7 = strStringResource;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1540247644, "CC(remember):MultiTabItemPickerTopBar.kt#9igjgp");
                    if ((i3 & 14) == 4) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z7) {
                        objRememberedValue = new Function0() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerTopBarKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return MultiTabItemPickerTopBarKt.MultiTabItemPickerTopBar$lambda$0$0$0(onBackPressed);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function0() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerTopBarKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return MultiTabItemPickerTopBarKt.MultiTabItemPickerTopBar$lambda$0$0$0(onBackPressed);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    list3 = listEmptyList;
                    BoxIconButtonKt.m11681BoxIconButtonuDo3WH8(new ButtonItem.IconButtonItem(false, (Function0) objRememberedValue, str7, drawableResource5, false, 17, null), null, null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11580getTopBarTextSecondary0d7_KjU(), 0.0f, composerStartRestartGroup, 0, 22);
                    float f3 = 4;
                    SpacerKt.Spacer(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f3)), composerStartRestartGroup, 6);
                    Modifier modifierWeight$default3 = RowScope.weight$default(rowScopeInstance3, Modifier.INSTANCE, 1.0f, false, 2, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode6 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default3);
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
                    Composer composerM6062constructorimpl6 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl6, measurePolicyColumnMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl6, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl6, Integer.valueOf(iHashCode6), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl6, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl6, modifierMaterializeModifier6, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 782626932, "C80@3319L10,81@3385L6,77@3126L379,85@3518L27:MultiTabItemPickerTopBar.kt#aug1cj");
                    if (str3 == null) {
                        composerStartRestartGroup.startReplaceGroup(1133625480);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "78@3170L37");
                        String strStringResource6 = StringResources_androidKt.stringResource(R.string.box_app_name, composerStartRestartGroup, 0);
                        composerStartRestartGroup.endReplaceGroup();
                        str4 = strStringResource6;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1133624798);
                        composerStartRestartGroup.endReplaceGroup();
                        str4 = str3;
                    }
                    TextKt.m4494TextNvy7gAk(str4, TestTagKt.testTag(Modifier.INSTANCE, "MultiTabItemPickerTitle"), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11580getTopBarTextSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getTitleLargeEmphasized(), composerStartRestartGroup, 48, 24960, 110584);
                    composerStartRestartGroup = composerStartRestartGroup;
                    SpacerKt.Spacer(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f3)), composerStartRestartGroup, 6);
                    if (list3.size() > 1) {
                        composerStartRestartGroup.startReplaceGroup(779504735);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(783067069);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "87@3602L162");
                        FolderBreadcrumbSubtitle(list3, onFolderStackItemClicked, composerStartRestartGroup, (i3 >> 9) & 126);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (z5) {
                        composerStartRestartGroup.startReplaceGroup(-501868037);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "99@4097L31,98@4033L21,101@4180L6,95@3834L386");
                        ButtonItemIconResource.DrawableResource drawableResource6 = new ButtonItemIconResource.DrawableResource(R.drawable.ic_search);
                        String strStringResource7 = StringResources_androidKt.stringResource(R.string.search, composerStartRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1540203518, "CC(remember):MultiTabItemPickerTopBar.kt#9igjgp");
                        if ((i3 & 112) == 32) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!z8) {
                            objRememberedValue2 = new Function0() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerTopBarKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return MultiTabItemPickerTopBarKt.MultiTabItemPickerTopBar$lambda$0$2$0(onSearchClicked);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new Function0() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerTopBarKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return MultiTabItemPickerTopBarKt.MultiTabItemPickerTopBar$lambda$0$2$0(onSearchClicked);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        BoxIconButtonKt.m11681BoxIconButtonuDo3WH8(new ButtonItem.IconButtonItem(false, (Function0) objRememberedValue2, strStringResource7, drawableResource6, false, 17, null), null, null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11580getTopBarTextSecondary0d7_KjU(), 0.0f, composerStartRestartGroup, 0, 22);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-505671179);
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
                    str2 = str3;
                    z4 = z5;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerTopBarKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return MultiTabItemPickerTopBarKt.MultiTabItemPickerTopBar$lambda$1(onBackPressed, onSearchClicked, str2, list3, onFolderStackItemClicked, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z2 = z;
            if ((i3 & 74899) != 74898) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                str2 = str;
                list3 = list2;
                z4 = z2;
            } else {
                if (i9 != 0) {
                    str3 = null;
                } else {
                    str3 = str;
                }
                if (i4 != 0) {
                    listEmptyList = CollectionsKt.emptyList();
                } else {
                    listEmptyList = list2;
                }
                if (i6 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1353976183, i3, -1, "com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerTopBar (MultiTabItemPickerTopBar.kt:49)");
                }
                Modifier modifierM1220paddingVpY3zN4$default4 = PaddingKt.m1220paddingVpY3zN4$default(SizeKt.m1252height3ABfNKs(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11498getAppBackground0d7_KjU(), null, 2, null), BoxSizes.INSTANCE.m11614getTopBarHeightD9Ej5fM()), Dp.m9687constructorimpl(12), 0.0f, 2, null);
                Alignment.Vertical centerVertically4 = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy4 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically4, composerStartRestartGroup, 48);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode7 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1220paddingVpY3zN4$default4);
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
                Composer composerM6062constructorimpl7 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl7, measurePolicyRowMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl7, currentCompositionLocalMap7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl7, Integer.valueOf(iHashCode7), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl7, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl7, modifierMaterializeModifier7, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance4 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -503224007, "C62@2653L55,71@2990L6,59@2462L564,74@3036L27,76@3073L715:MultiTabItemPickerTopBar.kt#aug1cj");
                if (str3 != null) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                ButtonItemIconResource.DrawableResource drawableResource7 = new ButtonItemIconResource.DrawableResource(R.drawable.ic_arrow_left);
                if (z6) {
                    composerStartRestartGroup.startReplaceGroup(-502925478);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "66@2786L51");
                    strStringResource = StringResources_androidKt.stringResource(R.string.back_button_talkback_label, composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-502829440);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "68@2883L45");
                    strStringResource = StringResources_androidKt.stringResource(R.string.talkback_label_close, composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                }
                String str8 = strStringResource;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1540247644, "CC(remember):MultiTabItemPickerTopBar.kt#9igjgp");
                if ((i3 & 14) == 4) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z7) {
                    objRememberedValue = new Function0() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerTopBarKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return MultiTabItemPickerTopBarKt.MultiTabItemPickerTopBar$lambda$0$0$0(onBackPressed);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function0() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerTopBarKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return MultiTabItemPickerTopBarKt.MultiTabItemPickerTopBar$lambda$0$0$0(onBackPressed);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                list3 = listEmptyList;
                BoxIconButtonKt.m11681BoxIconButtonuDo3WH8(new ButtonItem.IconButtonItem(false, (Function0) objRememberedValue, str8, drawableResource7, false, 17, null), null, null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11580getTopBarTextSecondary0d7_KjU(), 0.0f, composerStartRestartGroup, 0, 22);
                float f4 = 4;
                SpacerKt.Spacer(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f4)), composerStartRestartGroup, 6);
                Modifier modifierWeight$default4 = RowScope.weight$default(rowScopeInstance4, Modifier.INSTANCE, 1.0f, false, 2, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy4 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode8 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default4);
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
                Composer composerM6062constructorimpl8 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl8, measurePolicyColumnMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl8, currentCompositionLocalMap8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl8, Integer.valueOf(iHashCode8), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl8, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl8, modifierMaterializeModifier8, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance4 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 782626932, "C80@3319L10,81@3385L6,77@3126L379,85@3518L27:MultiTabItemPickerTopBar.kt#aug1cj");
                if (str3 == null) {
                    composerStartRestartGroup.startReplaceGroup(1133625480);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "78@3170L37");
                    String strStringResource8 = StringResources_androidKt.stringResource(R.string.box_app_name, composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                    str4 = strStringResource8;
                } else {
                    composerStartRestartGroup.startReplaceGroup(1133624798);
                    composerStartRestartGroup.endReplaceGroup();
                    str4 = str3;
                }
                TextKt.m4494TextNvy7gAk(str4, TestTagKt.testTag(Modifier.INSTANCE, "MultiTabItemPickerTitle"), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11580getTopBarTextSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getTitleLargeEmphasized(), composerStartRestartGroup, 48, 24960, 110584);
                composerStartRestartGroup = composerStartRestartGroup;
                SpacerKt.Spacer(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f4)), composerStartRestartGroup, 6);
                if (list3.size() > 1) {
                    composerStartRestartGroup.startReplaceGroup(779504735);
                } else {
                    composerStartRestartGroup.startReplaceGroup(783067069);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "87@3602L162");
                    FolderBreadcrumbSubtitle(list3, onFolderStackItemClicked, composerStartRestartGroup, (i3 >> 9) & 126);
                }
                composerStartRestartGroup.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (z5) {
                    composerStartRestartGroup.startReplaceGroup(-501868037);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "99@4097L31,98@4033L21,101@4180L6,95@3834L386");
                    ButtonItemIconResource.DrawableResource drawableResource8 = new ButtonItemIconResource.DrawableResource(R.drawable.ic_search);
                    String strStringResource9 = StringResources_androidKt.stringResource(R.string.search, composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1540203518, "CC(remember):MultiTabItemPickerTopBar.kt#9igjgp");
                    if ((i3 & 112) == 32) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z8) {
                        objRememberedValue2 = new Function0() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerTopBarKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return MultiTabItemPickerTopBarKt.MultiTabItemPickerTopBar$lambda$0$2$0(onSearchClicked);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function0() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerTopBarKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return MultiTabItemPickerTopBarKt.MultiTabItemPickerTopBar$lambda$0$2$0(onSearchClicked);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    BoxIconButtonKt.m11681BoxIconButtonuDo3WH8(new ButtonItem.IconButtonItem(false, (Function0) objRememberedValue2, strStringResource9, drawableResource8, false, 17, null), null, null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11580getTopBarTextSecondary0d7_KjU(), 0.0f, composerStartRestartGroup, 0, 22);
                } else {
                    composerStartRestartGroup.startReplaceGroup(-505671179);
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
                str2 = str3;
                z4 = z5;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerTopBarKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return MultiTabItemPickerTopBarKt.MultiTabItemPickerTopBar$lambda$1(onBackPressed, onSearchClicked, str2, list3, onFolderStackItemClicked, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 3072) == 0) {
                list2 = list;
                if (composerStartRestartGroup.changedInstance(list2)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            if ((i & 24576) == 0) {
                if (composerStartRestartGroup.changedInstance(onFolderStackItemClicked)) {
                    i8 = 16384;
                } else {
                    i8 = 8192;
                }
                i3 |= i8;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((196608 & i) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                if ((i3 & 74899) != 74898) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    str2 = str;
                    list3 = list2;
                    z4 = z2;
                } else {
                    if (i9 != 0) {
                        str3 = null;
                    } else {
                        str3 = str;
                    }
                    if (i4 != 0) {
                        listEmptyList = CollectionsKt.emptyList();
                    } else {
                        listEmptyList = list2;
                    }
                    if (i6 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1353976183, i3, -1, "com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerTopBar (MultiTabItemPickerTopBar.kt:49)");
                    }
                    Modifier modifierM1220paddingVpY3zN4$default5 = PaddingKt.m1220paddingVpY3zN4$default(SizeKt.m1252height3ABfNKs(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11498getAppBackground0d7_KjU(), null, 2, null), BoxSizes.INSTANCE.m11614getTopBarHeightD9Ej5fM()), Dp.m9687constructorimpl(12), 0.0f, 2, null);
                    Alignment.Vertical centerVertically5 = Alignment.INSTANCE.getCenterVertically();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                    MeasurePolicy measurePolicyRowMeasurePolicy5 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically5, composerStartRestartGroup, 48);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode9 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap9 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier9 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1220paddingVpY3zN4$default5);
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
                    Composer composerM6062constructorimpl9 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl9, measurePolicyRowMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl9, currentCompositionLocalMap9, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl9, Integer.valueOf(iHashCode9), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl9, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl9, modifierMaterializeModifier9, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                    RowScopeInstance rowScopeInstance5 = RowScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -503224007, "C62@2653L55,71@2990L6,59@2462L564,74@3036L27,76@3073L715:MultiTabItemPickerTopBar.kt#aug1cj");
                    if (str3 != null) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    ButtonItemIconResource.DrawableResource drawableResource9 = new ButtonItemIconResource.DrawableResource(R.drawable.ic_arrow_left);
                    if (z6) {
                        composerStartRestartGroup.startReplaceGroup(-502925478);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "66@2786L51");
                        strStringResource = StringResources_androidKt.stringResource(R.string.back_button_talkback_label, composerStartRestartGroup, 0);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-502829440);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "68@2883L45");
                        strStringResource = StringResources_androidKt.stringResource(R.string.talkback_label_close, composerStartRestartGroup, 0);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    String str9 = strStringResource;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1540247644, "CC(remember):MultiTabItemPickerTopBar.kt#9igjgp");
                    if ((i3 & 14) == 4) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z7) {
                        objRememberedValue = new Function0() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerTopBarKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return MultiTabItemPickerTopBarKt.MultiTabItemPickerTopBar$lambda$0$0$0(onBackPressed);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function0() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerTopBarKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return MultiTabItemPickerTopBarKt.MultiTabItemPickerTopBar$lambda$0$0$0(onBackPressed);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    list3 = listEmptyList;
                    BoxIconButtonKt.m11681BoxIconButtonuDo3WH8(new ButtonItem.IconButtonItem(false, (Function0) objRememberedValue, str9, drawableResource9, false, 17, null), null, null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11580getTopBarTextSecondary0d7_KjU(), 0.0f, composerStartRestartGroup, 0, 22);
                    float f5 = 4;
                    SpacerKt.Spacer(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f5)), composerStartRestartGroup, 6);
                    Modifier modifierWeight$default5 = RowScope.weight$default(rowScopeInstance5, Modifier.INSTANCE, 1.0f, false, 2, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy5 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode10 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap10 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier10 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default5);
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
                    Composer composerM6062constructorimpl10 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl10, measurePolicyColumnMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl10, currentCompositionLocalMap10, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl10, Integer.valueOf(iHashCode10), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl10, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl10, modifierMaterializeModifier10, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                    ColumnScopeInstance columnScopeInstance5 = ColumnScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 782626932, "C80@3319L10,81@3385L6,77@3126L379,85@3518L27:MultiTabItemPickerTopBar.kt#aug1cj");
                    if (str3 == null) {
                        composerStartRestartGroup.startReplaceGroup(1133625480);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "78@3170L37");
                        String strStringResource10 = StringResources_androidKt.stringResource(R.string.box_app_name, composerStartRestartGroup, 0);
                        composerStartRestartGroup.endReplaceGroup();
                        str4 = strStringResource10;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1133624798);
                        composerStartRestartGroup.endReplaceGroup();
                        str4 = str3;
                    }
                    TextKt.m4494TextNvy7gAk(str4, TestTagKt.testTag(Modifier.INSTANCE, "MultiTabItemPickerTitle"), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11580getTopBarTextSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getTitleLargeEmphasized(), composerStartRestartGroup, 48, 24960, 110584);
                    composerStartRestartGroup = composerStartRestartGroup;
                    SpacerKt.Spacer(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f5)), composerStartRestartGroup, 6);
                    if (list3.size() > 1) {
                        composerStartRestartGroup.startReplaceGroup(779504735);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(783067069);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "87@3602L162");
                        FolderBreadcrumbSubtitle(list3, onFolderStackItemClicked, composerStartRestartGroup, (i3 >> 9) & 126);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (z5) {
                        composerStartRestartGroup.startReplaceGroup(-501868037);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "99@4097L31,98@4033L21,101@4180L6,95@3834L386");
                        ButtonItemIconResource.DrawableResource drawableResource10 = new ButtonItemIconResource.DrawableResource(R.drawable.ic_search);
                        String strStringResource11 = StringResources_androidKt.stringResource(R.string.search, composerStartRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1540203518, "CC(remember):MultiTabItemPickerTopBar.kt#9igjgp");
                        if ((i3 & 112) == 32) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (!z8) {
                            objRememberedValue2 = new Function0() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerTopBarKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return MultiTabItemPickerTopBarKt.MultiTabItemPickerTopBar$lambda$0$2$0(onSearchClicked);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        } else {
                            objRememberedValue2 = new Function0() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerTopBarKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return MultiTabItemPickerTopBarKt.MultiTabItemPickerTopBar$lambda$0$2$0(onSearchClicked);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        BoxIconButtonKt.m11681BoxIconButtonuDo3WH8(new ButtonItem.IconButtonItem(false, (Function0) objRememberedValue2, strStringResource11, drawableResource10, false, 17, null), null, null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11580getTopBarTextSecondary0d7_KjU(), 0.0f, composerStartRestartGroup, 0, 22);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-505671179);
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
                    str2 = str3;
                    z4 = z5;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerTopBarKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return MultiTabItemPickerTopBarKt.MultiTabItemPickerTopBar$lambda$1(onBackPressed, onSearchClicked, str2, list3, onFolderStackItemClicked, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            z2 = z;
            if ((i3 & 74899) != 74898) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                str2 = str;
                list3 = list2;
                z4 = z2;
            } else {
                if (i9 != 0) {
                    str3 = null;
                } else {
                    str3 = str;
                }
                if (i4 != 0) {
                    listEmptyList = CollectionsKt.emptyList();
                } else {
                    listEmptyList = list2;
                }
                if (i6 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1353976183, i3, -1, "com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerTopBar (MultiTabItemPickerTopBar.kt:49)");
                }
                Modifier modifierM1220paddingVpY3zN4$default6 = PaddingKt.m1220paddingVpY3zN4$default(SizeKt.m1252height3ABfNKs(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11498getAppBackground0d7_KjU(), null, 2, null), BoxSizes.INSTANCE.m11614getTopBarHeightD9Ej5fM()), Dp.m9687constructorimpl(12), 0.0f, 2, null);
                Alignment.Vertical centerVertically6 = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy6 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically6, composerStartRestartGroup, 48);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode11 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap11 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier11 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1220paddingVpY3zN4$default6);
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
                Composer composerM6062constructorimpl11 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl11, measurePolicyRowMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl11, currentCompositionLocalMap11, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl11, Integer.valueOf(iHashCode11), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl11, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl11, modifierMaterializeModifier11, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance6 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -503224007, "C62@2653L55,71@2990L6,59@2462L564,74@3036L27,76@3073L715:MultiTabItemPickerTopBar.kt#aug1cj");
                if (str3 != null) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                ButtonItemIconResource.DrawableResource drawableResource11 = new ButtonItemIconResource.DrawableResource(R.drawable.ic_arrow_left);
                if (z6) {
                    composerStartRestartGroup.startReplaceGroup(-502925478);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "66@2786L51");
                    strStringResource = StringResources_androidKt.stringResource(R.string.back_button_talkback_label, composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-502829440);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "68@2883L45");
                    strStringResource = StringResources_androidKt.stringResource(R.string.talkback_label_close, composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                }
                String str10 = strStringResource;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1540247644, "CC(remember):MultiTabItemPickerTopBar.kt#9igjgp");
                if ((i3 & 14) == 4) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z7) {
                    objRememberedValue = new Function0() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerTopBarKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return MultiTabItemPickerTopBarKt.MultiTabItemPickerTopBar$lambda$0$0$0(onBackPressed);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function0() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerTopBarKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return MultiTabItemPickerTopBarKt.MultiTabItemPickerTopBar$lambda$0$0$0(onBackPressed);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                list3 = listEmptyList;
                BoxIconButtonKt.m11681BoxIconButtonuDo3WH8(new ButtonItem.IconButtonItem(false, (Function0) objRememberedValue, str10, drawableResource11, false, 17, null), null, null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11580getTopBarTextSecondary0d7_KjU(), 0.0f, composerStartRestartGroup, 0, 22);
                float f6 = 4;
                SpacerKt.Spacer(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f6)), composerStartRestartGroup, 6);
                Modifier modifierWeight$default6 = RowScope.weight$default(rowScopeInstance6, Modifier.INSTANCE, 1.0f, false, 2, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy6 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode12 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap12 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier12 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default6);
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
                Composer composerM6062constructorimpl12 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl12, measurePolicyColumnMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl12, currentCompositionLocalMap12, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl12, Integer.valueOf(iHashCode12), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl12, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl12, modifierMaterializeModifier12, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance6 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 782626932, "C80@3319L10,81@3385L6,77@3126L379,85@3518L27:MultiTabItemPickerTopBar.kt#aug1cj");
                if (str3 == null) {
                    composerStartRestartGroup.startReplaceGroup(1133625480);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "78@3170L37");
                    String strStringResource12 = StringResources_androidKt.stringResource(R.string.box_app_name, composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                    str4 = strStringResource12;
                } else {
                    composerStartRestartGroup.startReplaceGroup(1133624798);
                    composerStartRestartGroup.endReplaceGroup();
                    str4 = str3;
                }
                TextKt.m4494TextNvy7gAk(str4, TestTagKt.testTag(Modifier.INSTANCE, "MultiTabItemPickerTitle"), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11580getTopBarTextSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getTitleLargeEmphasized(), composerStartRestartGroup, 48, 24960, 110584);
                composerStartRestartGroup = composerStartRestartGroup;
                SpacerKt.Spacer(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f6)), composerStartRestartGroup, 6);
                if (list3.size() > 1) {
                    composerStartRestartGroup.startReplaceGroup(779504735);
                } else {
                    composerStartRestartGroup.startReplaceGroup(783067069);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "87@3602L162");
                    FolderBreadcrumbSubtitle(list3, onFolderStackItemClicked, composerStartRestartGroup, (i3 >> 9) & 126);
                }
                composerStartRestartGroup.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (z5) {
                    composerStartRestartGroup.startReplaceGroup(-501868037);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "99@4097L31,98@4033L21,101@4180L6,95@3834L386");
                    ButtonItemIconResource.DrawableResource drawableResource12 = new ButtonItemIconResource.DrawableResource(R.drawable.ic_search);
                    String strStringResource13 = StringResources_androidKt.stringResource(R.string.search, composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1540203518, "CC(remember):MultiTabItemPickerTopBar.kt#9igjgp");
                    if ((i3 & 112) == 32) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z8) {
                        objRememberedValue2 = new Function0() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerTopBarKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return MultiTabItemPickerTopBarKt.MultiTabItemPickerTopBar$lambda$0$2$0(onSearchClicked);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function0() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerTopBarKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return MultiTabItemPickerTopBarKt.MultiTabItemPickerTopBar$lambda$0$2$0(onSearchClicked);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    BoxIconButtonKt.m11681BoxIconButtonuDo3WH8(new ButtonItem.IconButtonItem(false, (Function0) objRememberedValue2, strStringResource13, drawableResource12, false, 17, null), null, null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11580getTopBarTextSecondary0d7_KjU(), 0.0f, composerStartRestartGroup, 0, 22);
                } else {
                    composerStartRestartGroup.startReplaceGroup(-505671179);
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
                str2 = str3;
                z4 = z5;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerTopBarKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return MultiTabItemPickerTopBarKt.MultiTabItemPickerTopBar$lambda$1(onBackPressed, onSearchClicked, str2, list3, onFolderStackItemClicked, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        list2 = list;
        if ((i & 24576) == 0) {
            if (composerStartRestartGroup.changedInstance(onFolderStackItemClicked)) {
                i8 = 16384;
            } else {
                i8 = 8192;
            }
            i3 |= i8;
        }
        i6 = i2 & 32;
        if (i6 != 0) {
            if ((196608 & i) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
            if ((i3 & 74899) != 74898) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                str2 = str;
                list3 = list2;
                z4 = z2;
            } else {
                if (i9 != 0) {
                    str3 = null;
                } else {
                    str3 = str;
                }
                if (i4 != 0) {
                    listEmptyList = CollectionsKt.emptyList();
                } else {
                    listEmptyList = list2;
                }
                if (i6 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1353976183, i3, -1, "com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerTopBar (MultiTabItemPickerTopBar.kt:49)");
                }
                Modifier modifierM1220paddingVpY3zN4$default7 = PaddingKt.m1220paddingVpY3zN4$default(SizeKt.m1252height3ABfNKs(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11498getAppBackground0d7_KjU(), null, 2, null), BoxSizes.INSTANCE.m11614getTopBarHeightD9Ej5fM()), Dp.m9687constructorimpl(12), 0.0f, 2, null);
                Alignment.Vertical centerVertically7 = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy7 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically7, composerStartRestartGroup, 48);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode13 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap13 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier13 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1220paddingVpY3zN4$default7);
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
                Composer composerM6062constructorimpl13 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl13, measurePolicyRowMeasurePolicy7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl13, currentCompositionLocalMap13, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl13, Integer.valueOf(iHashCode13), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl13, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl13, modifierMaterializeModifier13, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
                RowScopeInstance rowScopeInstance7 = RowScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -503224007, "C62@2653L55,71@2990L6,59@2462L564,74@3036L27,76@3073L715:MultiTabItemPickerTopBar.kt#aug1cj");
                if (str3 != null) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                ButtonItemIconResource.DrawableResource drawableResource13 = new ButtonItemIconResource.DrawableResource(R.drawable.ic_arrow_left);
                if (z6) {
                    composerStartRestartGroup.startReplaceGroup(-502925478);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "66@2786L51");
                    strStringResource = StringResources_androidKt.stringResource(R.string.back_button_talkback_label, composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-502829440);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "68@2883L45");
                    strStringResource = StringResources_androidKt.stringResource(R.string.talkback_label_close, composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                }
                String str11 = strStringResource;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1540247644, "CC(remember):MultiTabItemPickerTopBar.kt#9igjgp");
                if ((i3 & 14) == 4) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z7) {
                    objRememberedValue = new Function0() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerTopBarKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return MultiTabItemPickerTopBarKt.MultiTabItemPickerTopBar$lambda$0$0$0(onBackPressed);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function0() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerTopBarKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return MultiTabItemPickerTopBarKt.MultiTabItemPickerTopBar$lambda$0$0$0(onBackPressed);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                list3 = listEmptyList;
                BoxIconButtonKt.m11681BoxIconButtonuDo3WH8(new ButtonItem.IconButtonItem(false, (Function0) objRememberedValue, str11, drawableResource13, false, 17, null), null, null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11580getTopBarTextSecondary0d7_KjU(), 0.0f, composerStartRestartGroup, 0, 22);
                float f7 = 4;
                SpacerKt.Spacer(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f7)), composerStartRestartGroup, 6);
                Modifier modifierWeight$default7 = RowScope.weight$default(rowScopeInstance7, Modifier.INSTANCE, 1.0f, false, 2, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy7 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode14 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap14 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier14 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default7);
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
                Composer composerM6062constructorimpl14 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl14, measurePolicyColumnMeasurePolicy7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl14, currentCompositionLocalMap14, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl14, Integer.valueOf(iHashCode14), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl14, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl14, modifierMaterializeModifier14, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance7 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 782626932, "C80@3319L10,81@3385L6,77@3126L379,85@3518L27:MultiTabItemPickerTopBar.kt#aug1cj");
                if (str3 == null) {
                    composerStartRestartGroup.startReplaceGroup(1133625480);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "78@3170L37");
                    String strStringResource14 = StringResources_androidKt.stringResource(R.string.box_app_name, composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                    str4 = strStringResource14;
                } else {
                    composerStartRestartGroup.startReplaceGroup(1133624798);
                    composerStartRestartGroup.endReplaceGroup();
                    str4 = str3;
                }
                TextKt.m4494TextNvy7gAk(str4, TestTagKt.testTag(Modifier.INSTANCE, "MultiTabItemPickerTitle"), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11580getTopBarTextSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getTitleLargeEmphasized(), composerStartRestartGroup, 48, 24960, 110584);
                composerStartRestartGroup = composerStartRestartGroup;
                SpacerKt.Spacer(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f7)), composerStartRestartGroup, 6);
                if (list3.size() > 1) {
                    composerStartRestartGroup.startReplaceGroup(779504735);
                } else {
                    composerStartRestartGroup.startReplaceGroup(783067069);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "87@3602L162");
                    FolderBreadcrumbSubtitle(list3, onFolderStackItemClicked, composerStartRestartGroup, (i3 >> 9) & 126);
                }
                composerStartRestartGroup.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (z5) {
                    composerStartRestartGroup.startReplaceGroup(-501868037);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "99@4097L31,98@4033L21,101@4180L6,95@3834L386");
                    ButtonItemIconResource.DrawableResource drawableResource14 = new ButtonItemIconResource.DrawableResource(R.drawable.ic_search);
                    String strStringResource15 = StringResources_androidKt.stringResource(R.string.search, composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1540203518, "CC(remember):MultiTabItemPickerTopBar.kt#9igjgp");
                    if ((i3 & 112) == 32) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z8) {
                        objRememberedValue2 = new Function0() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerTopBarKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return MultiTabItemPickerTopBarKt.MultiTabItemPickerTopBar$lambda$0$2$0(onSearchClicked);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function0() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerTopBarKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return MultiTabItemPickerTopBarKt.MultiTabItemPickerTopBar$lambda$0$2$0(onSearchClicked);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    BoxIconButtonKt.m11681BoxIconButtonuDo3WH8(new ButtonItem.IconButtonItem(false, (Function0) objRememberedValue2, strStringResource15, drawableResource14, false, 17, null), null, null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11580getTopBarTextSecondary0d7_KjU(), 0.0f, composerStartRestartGroup, 0, 22);
                } else {
                    composerStartRestartGroup.startReplaceGroup(-505671179);
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
                str2 = str3;
                z4 = z5;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerTopBarKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return MultiTabItemPickerTopBarKt.MultiTabItemPickerTopBar$lambda$1(onBackPressed, onSearchClicked, str2, list3, onFolderStackItemClicked, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        z2 = z;
        if ((i3 & 74899) != 74898) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            str2 = str;
            list3 = list2;
            z4 = z2;
        } else {
            if (i9 != 0) {
                str3 = null;
            } else {
                str3 = str;
            }
            if (i4 != 0) {
                listEmptyList = CollectionsKt.emptyList();
            } else {
                listEmptyList = list2;
            }
            if (i6 != 0) {
                z5 = true;
            } else {
                z5 = z2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1353976183, i3, -1, "com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerTopBar (MultiTabItemPickerTopBar.kt:49)");
            }
            Modifier modifierM1220paddingVpY3zN4$default8 = PaddingKt.m1220paddingVpY3zN4$default(SizeKt.m1252height3ABfNKs(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11498getAppBackground0d7_KjU(), null, 2, null), BoxSizes.INSTANCE.m11614getTopBarHeightD9Ej5fM()), Dp.m9687constructorimpl(12), 0.0f, 2, null);
            Alignment.Vertical centerVertically8 = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy8 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically8, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode15 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap15 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier15 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1220paddingVpY3zN4$default8);
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
            Composer composerM6062constructorimpl15 = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl15, measurePolicyRowMeasurePolicy8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl15, currentCompositionLocalMap15, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl15, Integer.valueOf(iHashCode15), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl15, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl15, modifierMaterializeModifier15, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance8 = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -503224007, "C62@2653L55,71@2990L6,59@2462L564,74@3036L27,76@3073L715:MultiTabItemPickerTopBar.kt#aug1cj");
            if (str3 != null) {
                z6 = true;
            } else {
                z6 = false;
            }
            ButtonItemIconResource.DrawableResource drawableResource15 = new ButtonItemIconResource.DrawableResource(R.drawable.ic_arrow_left);
            if (z6) {
                composerStartRestartGroup.startReplaceGroup(-502925478);
                ComposerKt.sourceInformation(composerStartRestartGroup, "66@2786L51");
                strStringResource = StringResources_androidKt.stringResource(R.string.back_button_talkback_label, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-502829440);
                ComposerKt.sourceInformation(composerStartRestartGroup, "68@2883L45");
                strStringResource = StringResources_androidKt.stringResource(R.string.talkback_label_close, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            }
            String str12 = strStringResource;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1540247644, "CC(remember):MultiTabItemPickerTopBar.kt#9igjgp");
            if ((i3 & 14) == 4) {
                z7 = true;
            } else {
                z7 = false;
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z7) {
                objRememberedValue = new Function0() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerTopBarKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return MultiTabItemPickerTopBarKt.MultiTabItemPickerTopBar$lambda$0$0$0(onBackPressed);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function0() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerTopBarKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return MultiTabItemPickerTopBarKt.MultiTabItemPickerTopBar$lambda$0$0$0(onBackPressed);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            list3 = listEmptyList;
            BoxIconButtonKt.m11681BoxIconButtonuDo3WH8(new ButtonItem.IconButtonItem(false, (Function0) objRememberedValue, str12, drawableResource15, false, 17, null), null, null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11580getTopBarTextSecondary0d7_KjU(), 0.0f, composerStartRestartGroup, 0, 22);
            float f8 = 4;
            SpacerKt.Spacer(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f8)), composerStartRestartGroup, 6);
            Modifier modifierWeight$default8 = RowScope.weight$default(rowScopeInstance8, Modifier.INSTANCE, 1.0f, false, 2, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy8 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode16 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap16 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier16 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default8);
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
            Composer composerM6062constructorimpl16 = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl16, measurePolicyColumnMeasurePolicy8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl16, currentCompositionLocalMap16, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl16, Integer.valueOf(iHashCode16), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl16, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl16, modifierMaterializeModifier16, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance8 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 782626932, "C80@3319L10,81@3385L6,77@3126L379,85@3518L27:MultiTabItemPickerTopBar.kt#aug1cj");
            if (str3 == null) {
                composerStartRestartGroup.startReplaceGroup(1133625480);
                ComposerKt.sourceInformation(composerStartRestartGroup, "78@3170L37");
                String strStringResource16 = StringResources_androidKt.stringResource(R.string.box_app_name, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
                str4 = strStringResource16;
            } else {
                composerStartRestartGroup.startReplaceGroup(1133624798);
                composerStartRestartGroup.endReplaceGroup();
                str4 = str3;
            }
            TextKt.m4494TextNvy7gAk(str4, TestTagKt.testTag(Modifier.INSTANCE, "MultiTabItemPickerTitle"), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11580getTopBarTextSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getTitleLargeEmphasized(), composerStartRestartGroup, 48, 24960, 110584);
            composerStartRestartGroup = composerStartRestartGroup;
            SpacerKt.Spacer(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f8)), composerStartRestartGroup, 6);
            if (list3.size() > 1) {
                composerStartRestartGroup.startReplaceGroup(779504735);
            } else {
                composerStartRestartGroup.startReplaceGroup(783067069);
                ComposerKt.sourceInformation(composerStartRestartGroup, "87@3602L162");
                FolderBreadcrumbSubtitle(list3, onFolderStackItemClicked, composerStartRestartGroup, (i3 >> 9) & 126);
            }
            composerStartRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (z5) {
                composerStartRestartGroup.startReplaceGroup(-501868037);
                ComposerKt.sourceInformation(composerStartRestartGroup, "99@4097L31,98@4033L21,101@4180L6,95@3834L386");
                ButtonItemIconResource.DrawableResource drawableResource16 = new ButtonItemIconResource.DrawableResource(R.drawable.ic_search);
                String strStringResource17 = StringResources_androidKt.stringResource(R.string.search, composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1540203518, "CC(remember):MultiTabItemPickerTopBar.kt#9igjgp");
                if ((i3 & 112) == 32) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z8) {
                    objRememberedValue2 = new Function0() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerTopBarKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return MultiTabItemPickerTopBarKt.MultiTabItemPickerTopBar$lambda$0$2$0(onSearchClicked);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function0() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerTopBarKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return MultiTabItemPickerTopBarKt.MultiTabItemPickerTopBar$lambda$0$2$0(onSearchClicked);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                BoxIconButtonKt.m11681BoxIconButtonuDo3WH8(new ButtonItem.IconButtonItem(false, (Function0) objRememberedValue2, strStringResource17, drawableResource16, false, 17, null), null, null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11580getTopBarTextSecondary0d7_KjU(), 0.0f, composerStartRestartGroup, 0, 22);
            } else {
                composerStartRestartGroup.startReplaceGroup(-505671179);
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
            str2 = str3;
            z4 = z5;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerTopBarKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MultiTabItemPickerTopBarKt.MultiTabItemPickerTopBar$lambda$1(onBackPressed, onSearchClicked, str2, list3, onFolderStackItemClicked, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiTabItemPickerTopBar$lambda$0$0$0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiTabItemPickerTopBar$lambda$0$2$0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    private static final void FolderBreadcrumbSubtitle(final List<FolderModel> list, final Function1<? super ItemId.Remote, Unit> function1, Composer composer, final int i) {
        Composer composer2;
        int i2;
        String str;
        int i3;
        boolean z;
        boolean z2;
        long j;
        FolderModel folderModel;
        Modifier.Companion companionM632clickableoSLSa3U$default;
        long jM11585getTopbarTextTertiary0d7_KjU;
        List<FolderModel> list2 = list;
        Composer composerStartRestartGroup = composer.startRestartGroup(1813527880);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FolderBreadcrumbSubtitle)N(folderStack,onFolderStackItemClicked)109@4396L21,110@4450L228,110@4422L256,119@4683L1234:MultiTabItemPickerTopBar.kt#aug1cj");
        int i4 = (i & 6) == 0 ? (composerStartRestartGroup.changedInstance(list2) ? 4 : 2) | i : i;
        int i5 = 32;
        if ((i & 48) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        boolean z3 = true;
        boolean z4 = false;
        if (!composerStartRestartGroup.shouldExecute((i4 & 19) != 18, i4 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1813527880, i4, -1, "com.box.android.contentpicker.multitabitempicker.FolderBreadcrumbSubtitle (MultiTabItemPickerTopBar.kt:108)");
            }
            ScrollState scrollStateRememberScrollState = ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1);
            String str2 = "CC(remember):MultiTabItemPickerTopBar.kt#9igjgp";
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -956423188, "CC(remember):MultiTabItemPickerTopBar.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(scrollStateRememberScrollState);
            MultiTabItemPickerTopBarKt$FolderBreadcrumbSubtitle$1$1 multiTabItemPickerTopBarKt$FolderBreadcrumbSubtitle$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || multiTabItemPickerTopBarKt$FolderBreadcrumbSubtitle$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                multiTabItemPickerTopBarKt$FolderBreadcrumbSubtitle$1$1RememberedValue = new MultiTabItemPickerTopBarKt$FolderBreadcrumbSubtitle$1$1(scrollStateRememberScrollState, null);
                composerStartRestartGroup.updateRememberedValue(multiTabItemPickerTopBarKt$FolderBreadcrumbSubtitle$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(list2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) multiTabItemPickerTopBarKt$FolderBreadcrumbSubtitle$1$1RememberedValue, composerStartRestartGroup, i4 & 14);
            Modifier modifierHorizontalScroll$default = ScrollKt.horizontalScroll$default(TestTagKt.testTag(Modifier.INSTANCE, "MultiTabItemPickerBreadcrumb"), scrollStateRememberScrollState, false, null, false, 14, null);
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composerStartRestartGroup, 48);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierHorizontalScroll$default);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -626118340, "C125@4909L6:MultiTabItemPickerTopBar.kt#aug1cj");
            long jM11580getTopBarTextSecondary0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11580getTopBarTextSecondary0d7_KjU();
            composerStartRestartGroup.startReplaceGroup(949636191);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*142@5609L10,135@5303L598");
            int i6 = 0;
            for (Iterator it = list2.iterator(); it.hasNext(); it = it) {
                Object next = it.next();
                int i7 = i6 + 1;
                if (i6 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                FolderModel folderModel2 = (FolderModel) next;
                boolean z5 = i6 == CollectionsKt.getLastIndex(list2) ? z3 : z4;
                if (i6 > 0) {
                    composerStartRestartGroup.startReplaceGroup(-516262502);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "131@5197L10,129@5100L176");
                    Composer composer3 = composerStartRestartGroup;
                    long j2 = jM11580getTopBarTextSecondary0d7_KjU;
                    i2 = i4;
                    z = z3;
                    z2 = z4;
                    folderModel = folderModel2;
                    i3 = i5;
                    str = str2;
                    TextKt.m4494TextNvy7gAk(BREADCRUMB_SEPARATOR, null, j2, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getLabelMedium(), composer3, 6, 0, 131066);
                    j = j2;
                    composerStartRestartGroup = composer3;
                } else {
                    i2 = i4;
                    str = str2;
                    i3 = i5;
                    z = z3;
                    z2 = z4;
                    j = jM11580getTopBarTextSecondary0d7_KjU;
                    folderModel = folderModel2;
                    composerStartRestartGroup.startReplaceGroup(-521328150);
                }
                composerStartRestartGroup.endReplaceGroup();
                String name = folderModel.getName();
                if (!z5) {
                    composerStartRestartGroup.startReplaceGroup(-515972559);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "138@5435L62");
                    Modifier.Companion companion = Modifier.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1230282966, str);
                    final FolderModel folderModel3 = folderModel;
                    boolean zChangedInstance = composerStartRestartGroup.changedInstance(folderModel3) | ((i2 & 112) == i3 ? z : z2);
                    Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function0() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerTopBarKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return MultiTabItemPickerTopBarKt.FolderBreadcrumbSubtitle$lambda$1$0$0$0(function1, folderModel3);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    companionM632clickableoSLSa3U$default = ClickableKt.m632clickableoSLSa3U$default(companion, false, null, null, null, (Function0) objRememberedValue, 15, null);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-515848838);
                    composerStartRestartGroup.endReplaceGroup();
                    companionM632clickableoSLSa3U$default = Modifier.INSTANCE;
                }
                TextStyle labelMedium = MaterialTheme.INSTANCE.getTypography(composerStartRestartGroup, MaterialTheme.$stable).getLabelMedium();
                if (z5) {
                    composerStartRestartGroup.startReplaceGroup(-515693063);
                    composerStartRestartGroup.endReplaceGroup();
                    jM11585getTopbarTextTertiary0d7_KjU = j;
                } else {
                    composerStartRestartGroup.startReplaceGroup(-515637728);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "146@5764L6");
                    jM11585getTopbarTextTertiary0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11585getTopbarTextTertiary0d7_KjU();
                    composerStartRestartGroup.endReplaceGroup();
                }
                Composer composer4 = composerStartRestartGroup;
                TextKt.m4494TextNvy7gAk(name, companionM632clickableoSLSa3U$default, jM11585getTopbarTextTertiary0d7_KjU, null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, labelMedium, composer4, 0, 24960, 110584);
                i5 = i3;
                str2 = str;
                composerStartRestartGroup = composer4;
                i6 = i7;
                i4 = i2;
                z3 = z;
                z4 = z2;
                jM11580getTopBarTextSecondary0d7_KjU = j;
                list2 = list;
            }
            composer2 = composerStartRestartGroup;
            composer2.endReplaceGroup();
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerTopBarKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MultiTabItemPickerTopBarKt.FolderBreadcrumbSubtitle$lambda$2(list, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FolderBreadcrumbSubtitle$lambda$1$0$0$0(Function1 function1, FolderModel folderModel) {
        function1.invoke(ItemModelKt.toItemIdRemoteId(folderModel));
        return Unit.INSTANCE;
    }

    public static final void MultiTabItemPickerTopBarPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1978841851);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(MultiTabItemPickerTopBarPreview)161@6105L2,162@6117L2,163@6156L8,160@6071L99:MultiTabItemPickerTopBar.kt#aug1cj");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1978841851, i, -1, "com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerTopBarPreview (MultiTabItemPickerTopBar.kt:159)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1003490819, "CC(remember):MultiTabItemPickerTopBar.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerTopBarKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Function0 function0 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1003490435, "CC(remember):MultiTabItemPickerTopBar.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerTopBarKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Function0 function1 = (Function0) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1003489181, "CC(remember):MultiTabItemPickerTopBar.kt#9igjgp");
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerTopBarKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return MultiTabItemPickerTopBarKt.MultiTabItemPickerTopBarPreview$lambda$2$0((ItemId.Remote) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            MultiTabItemPickerTopBar(function0, function1, null, null, (Function1) objRememberedValue3, false, composerStartRestartGroup, 24630, 44);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerTopBarKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MultiTabItemPickerTopBarKt.MultiTabItemPickerTopBarPreview$lambda$3(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiTabItemPickerTopBarPreview$lambda$2$0(ItemId.Remote remote) {
        Intrinsics.checkNotNullParameter(remote, "<unused var>");
        return Unit.INSTANCE;
    }

    public static final void MultiTabItemPickerTopBarWithBreadcrumbPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1351463058);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(MultiTabItemPickerTopBarWithBreadcrumbPreview)170@6253L341:MultiTabItemPickerTopBar.kt#aug1cj");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1351463058, i, -1, "com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerTopBarWithBreadcrumbPreview (MultiTabItemPickerTopBar.kt:169)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$MultiTabItemPickerTopBarKt.INSTANCE.m12437getLambda$1613263971$content_picker_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerTopBarKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MultiTabItemPickerTopBarKt.MultiTabItemPickerTopBarWithBreadcrumbPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}

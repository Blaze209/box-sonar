package com.box.android.browse.compose;

import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.IconButtonColors;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TopAppBarDefaults;
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
import androidx.compose.ui.draw.AlphaKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.style.TextOverflow;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.CustomRippleConfigurationKt;
import com.box.android.browse.R;
import com.box.android.common.utilities.BoxCommonConstants;
import com.box.android.domain.models.item.FolderModel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxBrowseToolbars.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000 \n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a;\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00032\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00010\u00062\u000e\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0006H\u0007¢\u0006\u0002\u0010\b\u001a\u0015\u0010\t\u001a\u00020\u00032\u0006\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\f¨\u0006\r"}, d2 = {"ItemPickerToolbar", "", "toolbarTitle", "", "toolbarSubtitle", "onClose", "Lkotlin/Function0;", "onCreateFolder", "(Ljava/lang/String;Ljava/lang/String;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", BoxCommonConstants.EXTRA_FOLDER_NAME, "folder", "Lcom/box/android/domain/models/item/FolderModel;", "(Lcom/box/android/domain/models/item/FolderModel;Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "browse_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BoxBrowseToolbarsKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemPickerToolbar$lambda$1(String str, String str2, Function0 function0, Function0 function1, int i, Composer composer, int i2) {
        ItemPickerToolbar(str, str2, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void ItemPickerToolbar(final String toolbarTitle, final String toolbarSubtitle, final Function0<Unit> onClose, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Intrinsics.checkNotNullParameter(toolbarTitle, "toolbarTitle");
        Intrinsics.checkNotNullParameter(toolbarSubtitle, "toolbarSubtitle");
        Intrinsics.checkNotNullParameter(onClose, "onClose");
        Composer composerStartRestartGroup = composer.startRestartGroup(1088651604);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ItemPickerToolbar)N(toolbarTitle,toolbarSubtitle,onClose,onCreateFolder)32@1219L2244,32@1193L2270:BoxBrowseToolbars.kt#9mvyw3");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(toolbarTitle) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(toolbarSubtitle) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(onClose) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 2048 : 1024;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1088651604, i2, -1, "com.box.android.browse.compose.ItemPickerToolbar (BoxBrowseToolbars.kt:31)");
            }
            CustomRippleConfigurationKt.m11643CustomRippleConfiguration3JVO9M(0L, ComposableLambdaKt.rememberComposableLambda(-1118246595, true, new Function2() { // from class: com.box.android.browse.compose.BoxBrowseToolbarsKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxBrowseToolbarsKt.ItemPickerToolbar$lambda$0(toolbarTitle, toolbarSubtitle, onClose, function0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 48, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.compose.BoxBrowseToolbarsKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxBrowseToolbarsKt.ItemPickerToolbar$lambda$1(toolbarTitle, toolbarSubtitle, onClose, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemPickerToolbar$lambda$0$1(final Function0 function0, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C36@1329L13,35@1287L391:BoxBrowseToolbars.kt#9mvyw3");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(461237763, i, -1, "com.box.android.browse.compose.ItemPickerToolbar.<anonymous>.<anonymous> (BoxBrowseToolbars.kt:35)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 867860688, "CC(remember):BoxBrowseToolbars.kt#9igjgp");
            boolean zChanged = composer.changed(function0);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.browse.compose.BoxBrowseToolbarsKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BoxBrowseToolbarsKt.ItemPickerToolbar$lambda$0$1$0$0(function0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            IconButtonKt.IconButton((Function0<Unit>) objRememberedValue, TestTagKt.testTag(Modifier.INSTANCE, "CloseButton"), false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$BoxBrowseToolbarsKt.INSTANCE.getLambda$540913569$browse_generalProdRelease(), composer, 1572912, 60);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemPickerToolbar$lambda$0$1$0$0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemPickerToolbar$lambda$0$0(String str, String str2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C46@1732L611:BoxBrowseToolbars.kt#9mvyw3");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2108887295, i, -1, "com.box.android.browse.compose.ItemPickerToolbar.<anonymous>.<anonymous> (BoxBrowseToolbars.kt:46)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, companion);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1081203256, "C51@1954L10,47@1761L305,58@2283L10,54@2087L238:BoxBrowseToolbars.kt#9mvyw3");
            TextKt.m4494TextNvy7gAk(str, TestTagKt.testTag(Modifier.INSTANCE, "ToolbarTitle"), 0L, null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleLarge(), composer, 48, 24960, 110588);
            TextKt.m4494TextNvy7gAk(str2, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodyLarge(), composer, 0, 24960, 110590);
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
    public static final Unit ItemPickerToolbar$lambda$0$2(final Function0 function0, RowScope TopAppBar, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(TopAppBar, "$this$TopAppBar");
        ComposerKt.sourceInformation(composer, "C65@2495L72,68@2586L429,63@2399L616:BoxBrowseToolbars.kt#9mvyw3");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1303172396, i, -1, "com.box.android.browse.compose.ItemPickerToolbar.<anonymous>.<anonymous> (BoxBrowseToolbars.kt:63)");
            }
            boolean z = function0 != null;
            ComposerKt.sourceInformationMarkerStart(composer, -1781774156, "CC(remember):BoxBrowseToolbars.kt#9igjgp");
            boolean zChanged = composer.changed(function0);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.browse.compose.BoxBrowseToolbarsKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return BoxBrowseToolbarsKt.ItemPickerToolbar$lambda$0$2$0$0(function0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            IconButtonKt.IconButton((Function0<Unit>) objRememberedValue, (Modifier) null, z, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, ComposableLambdaKt.rememberComposableLambda(1399457102, true, new Function2() { // from class: com.box.android.browse.compose.BoxBrowseToolbarsKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxBrowseToolbarsKt.ItemPickerToolbar$lambda$0$2$1(function0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 1572864, 58);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemPickerToolbar$lambda$0$2$0$0(Function0 function0) {
        if (function0 != null) {
            function0.invoke();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemPickerToolbar$lambda$0$2$1(Function0 function0, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C70@2649L49,71@2745L48,73@2954L6,69@2608L389:BoxBrowseToolbars.kt#9mvyw3");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1399457102, i, -1, "com.box.android.browse.compose.ItemPickerToolbar.<anonymous>.<anonymous>.<anonymous> (BoxBrowseToolbars.kt:69)");
            }
            ImageKt.Image(PainterResources_androidKt.painterResource(R.drawable.add_folder_white, composer, 0), StringResources_androidKt.stringResource(R.string.LS_Create_folder_n, composer, 0), AlphaKt.alpha(Modifier.INSTANCE, function0 != null ? 1.0f : 0.3f), (Alignment) null, (ContentScale) null, 0.0f, ColorFilter.Companion.m6855tintxETnrds$default(ColorFilter.INSTANCE, BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11577getTopBarControl0d7_KjU(), 0, 2, null), composer, Painter.$stable, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemPickerToolbar$lambda$0(final String str, final String str2, final Function0 function0, final Function0 function1, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C78@3129L6,79@3204L6,80@3283L6,81@3347L6,82@3416L6,77@3070L377,45@1714L643,34@1269L423,62@2381L648,33@1229L2228:BoxBrowseToolbars.kt#9mvyw3");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1118246595, i, -1, "com.box.android.browse.compose.ItemPickerToolbar.<anonymous> (BoxBrowseToolbars.kt:33)");
            }
            AppBarKt.m2785TopAppBargNPyAyM(ComposableLambdaKt.rememberComposableLambda(-2108887295, true, new Function2() { // from class: com.box.android.browse.compose.BoxBrowseToolbarsKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxBrowseToolbarsKt.ItemPickerToolbar$lambda$0$0(str, str2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, ComposableLambdaKt.rememberComposableLambda(461237763, true, new Function2() { // from class: com.box.android.browse.compose.BoxBrowseToolbarsKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxBrowseToolbarsKt.ItemPickerToolbar$lambda$0$1(function0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), ComposableLambdaKt.rememberComposableLambda(1303172396, true, new Function3() { // from class: com.box.android.browse.compose.BoxBrowseToolbarsKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return BoxBrowseToolbarsKt.ItemPickerToolbar$lambda$0$2(function1, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), 0.0f, null, TopAppBarDefaults.INSTANCE.m4782topAppBarColors5tl4gsc(BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11575getTopBarBackground0d7_KjU(), BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11575getTopBarBackground0d7_KjU(), BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11579getTopBarText0d7_KjU(), BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11579getTopBarText0d7_KjU(), BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11579getTopBarText0d7_KjU(), 0L, composer, TopAppBarDefaults.$stable << 18, 32), null, null, composer, 3462, 434);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public static final String folderName(FolderModel folder, Composer composer, int i) {
        String name;
        Intrinsics.checkNotNullParameter(folder, "folder");
        ComposerKt.sourceInformationMarkerStart(composer, -80258023, "C(folderName)N(folder):BoxBrowseToolbars.kt#9mvyw3");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-80258023, i, -1, "com.box.android.browse.compose.folderName (BoxBrowseToolbars.kt:91)");
        }
        if (folder.isRoot()) {
            composer.startReplaceGroup(1330078558);
            ComposerKt.sourceInformation(composer, "92@3573L35");
            name = StringResources_androidKt.stringResource(R.string.files, composer, 0);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(1330126422);
            composer.endReplaceGroup();
            name = folder.getName();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return name;
    }
}

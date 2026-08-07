package com.box.android.preview.filesandfolders;

import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.button.model.ButtonItem;
import com.box.android.base.compose.dialog.BoxDismissAlertDialogKt;
import com.box.android.base.presentation.components.topbar.simple.BoxSimpleTopBarKt;
import com.box.android.cpl.Store;
import com.box.android.domain.models.preview.PageFitMode;
import com.box.android.domain.models.preview.ScrollSettings;
import com.box.android.domain.models.preview.ScrollableFileType;
import com.box.android.preview.R;
import com.box.android.preview.filesandfolders.component.RadioButtonWithLabelKt;
import com.box.android.preview.filesandfolders.component.SettingsWithLabelContainerKt;
import com.box.android.preview.filesandfolders.component.SettingsWithLabelItemKt;
import com.swmansion.rnscreens.gamma.stack.screen.event.StackScreenDismissEvent;
import java.util.Locale;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: FilesAndFoldersSettingsScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000D\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a/\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0007¢\u0006\u0002\u0010\b\u001a+\u0010\t\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0003¢\u0006\u0002\u0010\f\u001a!\u0010\r\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0003¢\u0006\u0002\u0010\u000e\u001a!\u0010\u000f\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0003¢\u0006\u0002\u0010\u000e\u001aI\u0010\u0010\u001a\u00020\u00012\b\b\u0001\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u00142\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0003¢\u0006\u0002\u0010\u0018\u001aW\u0010\u0019\u001a\u00020\u00012\b\b\u0001\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u001a\u001a\u00020\u001b2\f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00010\u0007H\u0003¢\u0006\u0002\u0010\u001f\u001a\f\u0010 \u001a\u00020\u0012*\u00020!H\u0002¨\u0006\"²\u0006\n\u0010#\u001a\u00020\u0004X\u008a\u0084\u0002²\u0006\n\u0010#\u001a\u00020\u0004X\u008a\u0084\u0002²\u0006\n\u0010#\u001a\u00020\u0004X\u008a\u0084\u0002"}, d2 = {"FilesAndFoldersSettingsScreen", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/preview/filesandfolders/FilesAndFoldersReducer$State;", "Lcom/box/android/preview/filesandfolders/FilesAndFoldersReducer$Action;", "handleClose", "Lkotlin/Function0;", "(Lcom/box/android/cpl/Store;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "FilesAndFoldersSettingsContent", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/box/android/cpl/Store;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "PageDisplaySetting", "(Lcom/box/android/cpl/Store;Landroidx/compose/runtime/Composer;I)V", "PagingModeSettings", "PageDisplaySelectDialog", "titleRes", "", "selectedPageFitMode", "Lcom/box/android/domain/models/preview/PageFitMode;", StackScreenDismissEvent.EVENT_REGISTRATION_NAME, "onFitToWidthSelected", "onFitToScreenSelected", "(ILcom/box/android/domain/models/preview/PageFitMode;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "PagingModeSelectDialog", "selectedPagingMode", "Lcom/box/android/preview/filesandfolders/PagingMode;", "onHorizontalSelected", "onVerticalSelected", "onContinuousSelected", "(ILcom/box/android/preview/filesandfolders/PagingMode;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "titleStringRes", "Lcom/box/android/domain/models/preview/ScrollableFileType;", "preview_generalProdRelease", "state"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class FilesAndFoldersSettingsScreenKt {

    /* JADX INFO: compiled from: FilesAndFoldersSettingsScreen.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1;

        static {
            int[] iArr = new int[PageFitMode.values().length];
            try {
                iArr[PageFitMode.FIT_TO_WIDTH.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PageFitMode.FIT_TO_SCREEN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
            int[] iArr2 = new int[ScrollableFileType.values().length];
            try {
                iArr2[ScrollableFileType.PDF.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr2[ScrollableFileType.POWERPOINT.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                iArr2[ScrollableFileType.WORD.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            $EnumSwitchMapping$1 = iArr2;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FilesAndFoldersSettingsContent$lambda$1(Store store, Modifier modifier, int i, int i2, Composer composer, int i3) {
        FilesAndFoldersSettingsContent(store, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FilesAndFoldersSettingsScreen$lambda$4(Store store, Function0 function0, int i, Composer composer, int i2) {
        FilesAndFoldersSettingsScreen(store, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PageDisplaySelectDialog$lambda$1(int i, PageFitMode pageFitMode, Function0 function0, Function0 function1, Function0 function2, int i2, Composer composer, int i3) {
        PageDisplaySelectDialog(i, pageFitMode, function0, function1, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PageDisplaySetting$lambda$5(Store store, int i, Composer composer, int i2) {
        PageDisplaySetting(store, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PagingModeSelectDialog$lambda$1(int i, PagingMode pagingMode, Function0 function0, Function0 function1, Function0 function2, Function0 function3, int i2, Composer composer, int i3) {
        PagingModeSelectDialog(i, pagingMode, function0, function1, function2, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PagingModeSettings$lambda$6(Store store, int i, Composer composer, int i2) {
        PagingModeSettings(store, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void FilesAndFoldersSettingsScreen(final Store<FilesAndFoldersReducer.State, FilesAndFoldersReducer.Action> store, final Function0<Unit> handleClose, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(handleClose, "handleClose");
        Composer composerStartRestartGroup = composer.startRestartGroup(-286003417);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FilesAndFoldersSettingsScreen)N(store,handleClose)31@1587L29,33@1654L74,33@1622L106,40@1761L221,46@2018L6,47@2045L156,39@1734L467:FilesAndFoldersSettingsScreen.kt#p3cvtc");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(handleClose) ? 32 : 16;
        }
        int i3 = i2;
        if (!composerStartRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-286003417, i3, -1, "com.box.android.preview.filesandfolders.FilesAndFoldersSettingsScreen (FilesAndFoldersSettingsScreen.kt:30)");
            }
            State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            Boolean boolValueOf = Boolean.valueOf(FilesAndFoldersSettingsScreen$lambda$0(stateCollectAsStateWithLifecycle).isClosing());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 28630705, "CC(remember):FilesAndFoldersSettingsScreen.kt#9igjgp");
            boolean zChanged = composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle) | ((i3 & 112) == 32);
            FilesAndFoldersSettingsScreenKt$FilesAndFoldersSettingsScreen$1$1 filesAndFoldersSettingsScreenKt$FilesAndFoldersSettingsScreen$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || filesAndFoldersSettingsScreenKt$FilesAndFoldersSettingsScreen$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                filesAndFoldersSettingsScreenKt$FilesAndFoldersSettingsScreen$1$1RememberedValue = new FilesAndFoldersSettingsScreenKt$FilesAndFoldersSettingsScreen$1$1(handleClose, stateCollectAsStateWithLifecycle, null);
                composerStartRestartGroup.updateRememberedValue(filesAndFoldersSettingsScreenKt$FilesAndFoldersSettingsScreen$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) filesAndFoldersSettingsScreenKt$FilesAndFoldersSettingsScreen$1$1RememberedValue, composerStartRestartGroup, 0);
            composer2 = composerStartRestartGroup;
            ScaffoldKt.m4038ScaffoldTvnljyQ(null, ComposableLambdaKt.rememberComposableLambda(-676760093, true, new Function2() { // from class: com.box.android.preview.filesandfolders.FilesAndFoldersSettingsScreenKt$$ExternalSyntheticLambda20
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FilesAndFoldersSettingsScreenKt.FilesAndFoldersSettingsScreen$lambda$2(store, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), null, null, null, 0, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11498getAppBackground0d7_KjU(), 0L, null, ComposableLambdaKt.rememberComposableLambda(676818104, true, new Function3() { // from class: com.box.android.preview.filesandfolders.FilesAndFoldersSettingsScreenKt$$ExternalSyntheticLambda21
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return FilesAndFoldersSettingsScreenKt.FilesAndFoldersSettingsScreen$lambda$3(store, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, 805306416, 445);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.filesandfolders.FilesAndFoldersSettingsScreenKt$$ExternalSyntheticLambda22
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FilesAndFoldersSettingsScreenKt.FilesAndFoldersSettingsScreen$lambda$4(store, handleClose, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FilesAndFoldersSettingsScreen$lambda$2(final Store store, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C42@1816L57,43@1901L57,41@1775L197:FilesAndFoldersSettingsScreen.kt#p3cvtc");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-676760093, i, -1, "com.box.android.preview.filesandfolders.FilesAndFoldersSettingsScreen.<anonymous> (FilesAndFoldersSettingsScreen.kt:41)");
            }
            String strStringResource = StringResources_androidKt.stringResource(R.string.files_and_folders_settings_title, composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1826383140, "CC(remember):FilesAndFoldersSettingsScreen.kt#9igjgp");
            boolean zChanged = composer.changed(store);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.preview.filesandfolders.FilesAndFoldersSettingsScreenKt$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilesAndFoldersSettingsScreenKt.FilesAndFoldersSettingsScreen$lambda$2$0$0(store);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BoxSimpleTopBarKt.BoxSimpleTopBar(strStringResource, (Function0) objRememberedValue, null, false, null, composer, 0, 28);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FilesAndFoldersSettingsScreen$lambda$2$0$0(Store store) {
        store.send(FilesAndFoldersReducer.Action.CloseScreen.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FilesAndFoldersSettingsScreen$lambda$3(Store store, PaddingValues paddingValues, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        ComposerKt.sourceInformation(composer, "CN(paddingValues)48@2072L123:FilesAndFoldersSettingsScreen.kt#p3cvtc");
        if ((i & 6) == 0) {
            i |= composer.changed(paddingValues) ? 4 : 2;
        }
        if (!composer.shouldExecute((i & 19) != 18, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(676818104, i, -1, "com.box.android.preview.filesandfolders.FilesAndFoldersSettingsScreen.<anonymous> (FilesAndFoldersSettingsScreen.kt:48)");
            }
            FilesAndFoldersSettingsContent(store, PaddingKt.padding(Modifier.INSTANCE, paddingValues), composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0048  */
    /* JADX WARN: Code duplicated, block: B:24:0x004a  */
    /* JADX WARN: Code duplicated, block: B:27:0x0053 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:28:0x0055  */
    /* JADX WARN: Code duplicated, block: B:29:0x005b  */
    /* JADX WARN: Code duplicated, block: B:32:0x0062  */
    /* JADX WARN: Code duplicated, block: B:35:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:38:0x00e4  */
    /* JADX WARN: Code duplicated, block: B:39:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:42:0x0154  */
    /* JADX WARN: Code duplicated, block: B:43:0x0158  */
    /* JADX WARN: Code duplicated, block: B:46:0x0162  */
    /* JADX WARN: Code duplicated, block: B:48:? A[RETURN, SYNTHETIC] */
    private static final void FilesAndFoldersSettingsContent(final Store<FilesAndFoldersReducer.State, FilesAndFoldersReducer.Action> store, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        boolean z;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function0<ComposeUiNode> constructor;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1882321305);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FilesAndFoldersSettingsContent)N(store,modifier)62@2446L21,60@2382L331:FilesAndFoldersSettingsScreen.kt#p3cvtc");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
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
                modifier3 = modifier2;
            } else {
                if (i4 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1882321305, i3, -1, "com.box.android.preview.filesandfolders.FilesAndFoldersSettingsContent (FilesAndFoldersSettingsScreen.kt:59)");
                }
                Modifier modifierM1219paddingVpY3zN4 = PaddingKt.m1219paddingVpY3zN4(ScrollKt.verticalScroll$default(modifier3, ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), false, null, false, 14, null), Dp.m9687constructorimpl(10), Dp.m9687constructorimpl(6));
                Arrangement.HorizontalOrVertical horizontalOrVerticalM1073spacedBy0680j_4 = Arrangement.INSTANCE.m1073spacedBy0680j_4(Dp.m9687constructorimpl(12));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM1073spacedBy0680j_4, Alignment.INSTANCE.getStart(), composerStartRestartGroup, 6);
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
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1565052393, "C69@2648L25,70@2682L25:FilesAndFoldersSettingsScreen.kt#p3cvtc");
                int i5 = i3 & 14;
                PageDisplaySetting(store, composerStartRestartGroup, i5);
                PagingModeSettings(store, composerStartRestartGroup, i5);
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
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.filesandfolders.FilesAndFoldersSettingsScreenKt$$ExternalSyntheticLambda19
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return FilesAndFoldersSettingsScreenKt.FilesAndFoldersSettingsContent$lambda$1(store, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
            modifier3 = modifier2;
        } else {
            if (i4 != 0) {
                modifier3 = Modifier.INSTANCE;
            } else {
                modifier3 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1882321305, i3, -1, "com.box.android.preview.filesandfolders.FilesAndFoldersSettingsContent (FilesAndFoldersSettingsScreen.kt:59)");
            }
            Modifier modifierM1219paddingVpY3zN5 = PaddingKt.m1219paddingVpY3zN4(ScrollKt.verticalScroll$default(modifier3, ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), false, null, false, 14, null), Dp.m9687constructorimpl(10), Dp.m9687constructorimpl(6));
            Arrangement.HorizontalOrVertical horizontalOrVerticalM1073spacedBy0680j_5 = Arrangement.INSTANCE.m1073spacedBy0680j_4(Dp.m9687constructorimpl(12));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(horizontalOrVerticalM1073spacedBy0680j_5, Alignment.INSTANCE.getStart(), composerStartRestartGroup, 6);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1219paddingVpY3zN5);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1565052393, "C69@2648L25,70@2682L25:FilesAndFoldersSettingsScreen.kt#p3cvtc");
            int i6 = i3 & 14;
            PageDisplaySetting(store, composerStartRestartGroup, i6);
            PagingModeSettings(store, composerStartRestartGroup, i6);
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
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.filesandfolders.FilesAndFoldersSettingsScreenKt$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FilesAndFoldersSettingsScreenKt.FilesAndFoldersSettingsContent$lambda$1(store, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void PageDisplaySetting(final Store<FilesAndFoldersReducer.State, FilesAndFoldersReducer.Action> store, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1561767570);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PageDisplaySetting)N(store)76@2866L29,79@2945L38,80@3002L571,78@2901L672:FilesAndFoldersSettingsScreen.kt#p3cvtc");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1561767570, i2, -1, "com.box.android.preview.filesandfolders.PageDisplaySetting (FilesAndFoldersSettingsScreen.kt:75)");
            }
            final State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            String upperCase = StringResources_androidKt.stringResource(R.string.display_label, composerStartRestartGroup, 0).toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            SettingsWithLabelContainerKt.SettingsWithLabelContainer(null, upperCase, ComposableLambdaKt.rememberComposableLambda(1865444579, true, new Function3() { // from class: com.box.android.preview.filesandfolders.FilesAndFoldersSettingsScreenKt$$ExternalSyntheticLambda23
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return FilesAndFoldersSettingsScreenKt.PageDisplaySetting$lambda$1(store, stateCollectAsStateWithLifecycle, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 384, 1);
            composer2 = composerStartRestartGroup;
            if (!(PageDisplaySetting$lambda$0(stateCollectAsStateWithLifecycle).getSelectionDialogState() instanceof FilesAndFoldersReducer.SelectionDialogState.PageDisplay)) {
                composer2.startReplaceGroup(760323604);
            } else {
                composer2.startReplaceGroup(763985882);
                ComposerKt.sourceInformation(composer2, "101@3834L96,104@3967L157,109@4162L158,98@3680L650");
                int i3 = R.string.page_display_label;
                PageFitMode pageFitMode = PageDisplaySetting$lambda$0(stateCollectAsStateWithLifecycle).getPageFitMode();
                ComposerKt.sourceInformationMarkerStart(composer2, -1915013266, "CC(remember):FilesAndFoldersSettingsScreen.kt#9igjgp");
                int i4 = i2 & 14;
                boolean z = i4 == 4;
                Object objRememberedValue = composer2.rememberedValue();
                if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.box.android.preview.filesandfolders.FilesAndFoldersSettingsScreenKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return FilesAndFoldersSettingsScreenKt.PageDisplaySetting$lambda$2$0(store);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                }
                Function0 function0 = (Function0) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerStart(composer2, -1915008949, "CC(remember):FilesAndFoldersSettingsScreen.kt#9igjgp");
                boolean z2 = i4 == 4;
                Object objRememberedValue2 = composer2.rememberedValue();
                if (z2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.box.android.preview.filesandfolders.FilesAndFoldersSettingsScreenKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return FilesAndFoldersSettingsScreenKt.PageDisplaySetting$lambda$3$0(store);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue2);
                }
                Function0 function1 = (Function0) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerStart(composer2, -1915002708, "CC(remember):FilesAndFoldersSettingsScreen.kt#9igjgp");
                boolean z3 = i4 == 4;
                Object objRememberedValue3 = composer2.rememberedValue();
                if (z3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function0() { // from class: com.box.android.preview.filesandfolders.FilesAndFoldersSettingsScreenKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return FilesAndFoldersSettingsScreenKt.PageDisplaySetting$lambda$4$0(store);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                PageDisplaySelectDialog(i3, pageFitMode, function0, function1, (Function0) objRememberedValue3, composer2, 0);
                composer2 = composer2;
            }
            composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.filesandfolders.FilesAndFoldersSettingsScreenKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FilesAndFoldersSettingsScreenKt.PageDisplaySetting$lambda$5(store, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PageDisplaySetting$lambda$1(final Store store, State state, ColumnScope SettingsWithLabelContainer, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(SettingsWithLabelContainer, "$this$SettingsWithLabelContainer");
        ComposerKt.sourceInformation(composer, "C81@3030L238,88@3319L43,90@3425L91,87@3277L290:FilesAndFoldersSettingsScreen.kt#p3cvtc");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1865444579, i, -1, "com.box.android.preview.filesandfolders.PageDisplaySetting.<anonymous> (FilesAndFoldersSettingsScreen.kt:81)");
            }
            int i3 = WhenMappings.$EnumSwitchMapping$0[PageDisplaySetting$lambda$0(state).getPageFitMode().ordinal()];
            if (i3 == 1) {
                i2 = R.string.page_display_fit_to_width;
            } else {
                if (i3 != 2) {
                    throw new NoWhenBranchMatchedException();
                }
                i2 = R.string.page_display_fit_to_screen;
            }
            String strStringResource = StringResources_androidKt.stringResource(i2, composer, 0);
            String strStringResource2 = StringResources_androidKt.stringResource(R.string.page_display_label, composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, 1690891614, "CC(remember):FilesAndFoldersSettingsScreen.kt#9igjgp");
            boolean zChanged = composer.changed(store);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.preview.filesandfolders.FilesAndFoldersSettingsScreenKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilesAndFoldersSettingsScreenKt.PageDisplaySetting$lambda$1$0$0(store);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            SettingsWithLabelItemKt.SettingsWithLabelItem(null, strStringResource2, strStringResource, (Function0) objRememberedValue, "PageDisplayItem", composer, 24576, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PageDisplaySetting$lambda$1$0$0(Store store) {
        store.send(FilesAndFoldersReducer.Action.SelectPageFitMode.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PageDisplaySetting$lambda$2$0(Store store) {
        store.send(FilesAndFoldersReducer.Action.DismissSelectionDialog.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PageDisplaySetting$lambda$3$0(Store store) {
        store.send(new FilesAndFoldersReducer.Action.PageFitModeSelected(PageFitMode.FIT_TO_WIDTH));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PageDisplaySetting$lambda$4$0(Store store) {
        store.send(new FilesAndFoldersReducer.Action.PageFitModeSelected(PageFitMode.FIT_TO_SCREEN));
        return Unit.INSTANCE;
    }

    private static final void PagingModeSettings(final Store<FilesAndFoldersReducer.State, FilesAndFoldersReducer.Action> store, Composer composer, final int i) {
        int i2;
        Composer composer2;
        ScrollSettings pdfScrollSettings;
        Composer composerStartRestartGroup = composer.startRestartGroup(1115607193);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PagingModeSettings)N(store)120@4489L29,123@4568L49,124@4636L1434,122@4524L1546:FilesAndFoldersSettingsScreen.kt#p3cvtc");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1115607193, i2, -1, "com.box.android.preview.filesandfolders.PagingModeSettings (FilesAndFoldersSettingsScreen.kt:119)");
            }
            final State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            String upperCase = StringResources_androidKt.stringResource(R.string.paging_mode_option_label, composerStartRestartGroup, 0).toUpperCase(Locale.ROOT);
            Intrinsics.checkNotNullExpressionValue(upperCase, "toUpperCase(...)");
            SettingsWithLabelContainerKt.SettingsWithLabelContainer(null, upperCase, ComposableLambdaKt.rememberComposableLambda(247852046, true, new Function3() { // from class: com.box.android.preview.filesandfolders.FilesAndFoldersSettingsScreenKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return FilesAndFoldersSettingsScreenKt.PagingModeSettings$lambda$1(store, stateCollectAsStateWithLifecycle, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 384, 1);
            composer2 = composerStartRestartGroup;
            if (!(PagingModeSettings$lambda$0(stateCollectAsStateWithLifecycle).getSelectionDialogState() instanceof FilesAndFoldersReducer.SelectionDialogState.PagingMode)) {
                composer2.startReplaceGroup(592624105);
            } else {
                composer2.startReplaceGroup(598794593);
                ComposerKt.sourceInformation(composer2, "176@6875L134,181@7046L243,189@7324L241,197@7602L252,173@6729L1135");
                FilesAndFoldersReducer.SelectionDialogState selectionDialogState = PagingModeSettings$lambda$0(stateCollectAsStateWithLifecycle).getSelectionDialogState();
                Intrinsics.checkNotNull(selectionDialogState, "null cannot be cast to non-null type com.box.android.preview.filesandfolders.FilesAndFoldersReducer.SelectionDialogState.PagingMode");
                final ScrollableFileType scrollableFileType = ((FilesAndFoldersReducer.SelectionDialogState.PagingMode) selectionDialogState).getScrollableFileType();
                int iTitleStringRes = titleStringRes(scrollableFileType);
                PagingModeHelper pagingModeHelper = PagingModeHelper.INSTANCE;
                int i3 = WhenMappings.$EnumSwitchMapping$1[scrollableFileType.ordinal()];
                if (i3 == 1) {
                    pdfScrollSettings = PagingModeSettings$lambda$0(stateCollectAsStateWithLifecycle).getPdfScrollSettings();
                } else if (i3 == 2) {
                    pdfScrollSettings = PagingModeSettings$lambda$0(stateCollectAsStateWithLifecycle).getPowerPointScrollSettings();
                } else {
                    if (i3 != 3) {
                        throw new NoWhenBranchMatchedException();
                    }
                    pdfScrollSettings = PagingModeSettings$lambda$0(stateCollectAsStateWithLifecycle).getWordScrollSettings();
                }
                PagingMode pagingMode = pagingModeHelper.getPagingMode(pdfScrollSettings);
                ComposerKt.sourceInformationMarkerStart(composer2, -1643230913, "CC(remember):FilesAndFoldersSettingsScreen.kt#9igjgp");
                int i4 = i2 & 14;
                boolean z = i4 == 4;
                Object objRememberedValue = composer2.rememberedValue();
                if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.box.android.preview.filesandfolders.FilesAndFoldersSettingsScreenKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return FilesAndFoldersSettingsScreenKt.PagingModeSettings$lambda$2$0(store);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                }
                Function0 function0 = (Function0) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerStart(composer2, -1643225332, "CC(remember):FilesAndFoldersSettingsScreen.kt#9igjgp");
                ScrollableFileType scrollableFileType2 = scrollableFileType;
                boolean zChanged = (i4 == 4) | composer2.changed(scrollableFileType2.ordinal());
                Object objRememberedValue2 = composer2.rememberedValue();
                if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.box.android.preview.filesandfolders.FilesAndFoldersSettingsScreenKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return FilesAndFoldersSettingsScreenKt.PagingModeSettings$lambda$3$0(store, scrollableFileType);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue2);
                }
                Function0 function1 = (Function0) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerStart(composer2, -1643216438, "CC(remember):FilesAndFoldersSettingsScreen.kt#9igjgp");
                boolean zChanged2 = (i4 == 4) | composer2.changed(scrollableFileType2.ordinal());
                Object objRememberedValue3 = composer2.rememberedValue();
                if (zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function0() { // from class: com.box.android.preview.filesandfolders.FilesAndFoldersSettingsScreenKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return FilesAndFoldersSettingsScreenKt.PagingModeSettings$lambda$4$0(store, scrollableFileType);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue3);
                }
                Function0 function2 = (Function0) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerStart(composer2, -1643207531, "CC(remember):FilesAndFoldersSettingsScreen.kt#9igjgp");
                boolean zChanged3 = composer2.changed(scrollableFileType2.ordinal()) | (i4 == 4);
                Object objRememberedValue4 = composer2.rememberedValue();
                if (zChanged3 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new Function0() { // from class: com.box.android.preview.filesandfolders.FilesAndFoldersSettingsScreenKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return FilesAndFoldersSettingsScreenKt.PagingModeSettings$lambda$5$0(store, scrollableFileType);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                PagingModeSelectDialog(iTitleStringRes, pagingMode, function0, function1, function2, (Function0) objRememberedValue4, composer2, 0);
                composer2 = composer2;
            }
            composer2.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.filesandfolders.FilesAndFoldersSettingsScreenKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FilesAndFoldersSettingsScreenKt.PagingModeSettings$lambda$6(store, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PagingModeSettings$lambda$1(final Store store, State state, ColumnScope SettingsWithLabelContainer, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(SettingsWithLabelContainer, "$this$SettingsWithLabelContainer");
        ComposerKt.sourceInformation(composer, "C126@4688L46,127@4762L111,130@4897L152,125@4646L456,138@5153L53,139@5234L118,142@5376L159,137@5111L484,150@5646L47,151@5721L112,154@5857L153,149@5604L460:FilesAndFoldersSettingsScreen.kt#p3cvtc");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(247852046, i, -1, "com.box.android.preview.filesandfolders.PagingModeSettings.<anonymous> (FilesAndFoldersSettingsScreen.kt:125)");
            }
            String strStringResource = StringResources_androidKt.stringResource(R.string.pdf_paging_mode_label, composer, 0);
            String strStringResource2 = StringResources_androidKt.stringResource(PagingModeHelper.INSTANCE.getPagingMode(PagingModeSettings$lambda$0(state).getPdfScrollSettings()).getStringRes(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, 1962623430, "CC(remember):FilesAndFoldersSettingsScreen.kt#9igjgp");
            boolean zChanged = composer.changed(store);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.preview.filesandfolders.FilesAndFoldersSettingsScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilesAndFoldersSettingsScreenKt.PagingModeSettings$lambda$1$0$0(store);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            SettingsWithLabelItemKt.SettingsWithLabelItem(null, strStringResource, strStringResource2, (Function0) objRememberedValue, "PdfPagingModeItem", composer, 24576, 1);
            String strStringResource3 = StringResources_androidKt.stringResource(R.string.powerpoint_paging_mode_label, composer, 0);
            String strStringResource4 = StringResources_androidKt.stringResource(PagingModeHelper.INSTANCE.getPagingMode(PagingModeSettings$lambda$0(state).getPowerPointScrollSettings()).getStringRes(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, 1962638765, "CC(remember):FilesAndFoldersSettingsScreen.kt#9igjgp");
            boolean zChanged2 = composer.changed(store);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.preview.filesandfolders.FilesAndFoldersSettingsScreenKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilesAndFoldersSettingsScreenKt.PagingModeSettings$lambda$1$1$0(store);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            SettingsWithLabelItemKt.SettingsWithLabelItem(null, strStringResource3, strStringResource4, (Function0) objRememberedValue2, "PowerPointPagingModeItem", composer, 24576, 1);
            String strStringResource5 = StringResources_androidKt.stringResource(R.string.word_paging_mode_label, composer, 0);
            String strStringResource6 = StringResources_androidKt.stringResource(PagingModeHelper.INSTANCE.getPagingMode(PagingModeSettings$lambda$0(state).getWordScrollSettings()).getStringRes(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, 1962654151, "CC(remember):FilesAndFoldersSettingsScreen.kt#9igjgp");
            boolean zChanged3 = composer.changed(store);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: com.box.android.preview.filesandfolders.FilesAndFoldersSettingsScreenKt$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return FilesAndFoldersSettingsScreenKt.PagingModeSettings$lambda$1$2$0(store);
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            SettingsWithLabelItemKt.SettingsWithLabelItem(null, strStringResource5, strStringResource6, (Function0) objRememberedValue3, "WordPagingModeItem", composer, 24576, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PagingModeSettings$lambda$1$0$0(Store store) {
        store.send(new FilesAndFoldersReducer.Action.SelectPagingMode(ScrollableFileType.PDF));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PagingModeSettings$lambda$1$1$0(Store store) {
        store.send(new FilesAndFoldersReducer.Action.SelectPagingMode(ScrollableFileType.POWERPOINT));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PagingModeSettings$lambda$1$2$0(Store store) {
        store.send(new FilesAndFoldersReducer.Action.SelectPagingMode(ScrollableFileType.WORD));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PagingModeSettings$lambda$2$0(Store store) {
        store.send(FilesAndFoldersReducer.Action.DismissSelectionDialog.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PagingModeSettings$lambda$3$0(Store store, ScrollableFileType scrollableFileType) {
        store.send(new FilesAndFoldersReducer.Action.PagingModeSelected(PagingMode.HORIZONTAL, scrollableFileType));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PagingModeSettings$lambda$4$0(Store store, ScrollableFileType scrollableFileType) {
        store.send(new FilesAndFoldersReducer.Action.PagingModeSelected(PagingMode.VERTICAL, scrollableFileType));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PagingModeSettings$lambda$5$0(Store store, ScrollableFileType scrollableFileType) {
        store.send(new FilesAndFoldersReducer.Action.PagingModeSelected(PagingMode.VERTICAL_CONTINUOUS, scrollableFileType));
        return Unit.INSTANCE;
    }

    private static final void PageDisplaySelectDialog(final int i, final PageFitMode pageFitMode, final Function0<Unit> function0, final Function0<Unit> function1, final Function0<Unit> function2, Composer composer, final int i2) {
        int i3;
        int i4;
        Composer composerStartRestartGroup = composer.startRestartGroup(-445954907);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PageDisplaySelectDialog)N(titleRes,selectedPageFitMode,onDismiss,onFitToWidthSelected,onFitToScreenSelected)219@8169L907,217@8102L1127:FilesAndFoldersSettingsScreen.kt#p3cvtc");
        if ((i2 & 6) == 0) {
            i3 = i;
            i4 = (composerStartRestartGroup.changed(i3) ? 4 : 2) | i2;
        } else {
            i3 = i;
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(pageFitMode.ordinal()) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function1) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function2) ? 16384 : 8192;
        }
        if (!composerStartRestartGroup.shouldExecute((i4 & 9363) != 9362, i4 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-445954907, i4, -1, "com.box.android.preview.filesandfolders.PageDisplaySelectDialog (FilesAndFoldersSettingsScreen.kt:216)");
            }
            BoxDismissAlertDialogKt.m11712BoxDismissAlertDialogV9fs2A(i3, ComposableLambdaKt.rememberComposableLambda(1391658124, true, new Function2() { // from class: com.box.android.preview.filesandfolders.FilesAndFoldersSettingsScreenKt$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FilesAndFoldersSettingsScreenKt.PageDisplaySelectDialog$lambda$0(function1, pageFitMode, function2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), new ButtonItem.TextButtonItem(false, function0, R.string.alert_dialog_cancel, 1, null), null, null, 0L, composerStartRestartGroup, (i4 & 14) | 48, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.filesandfolders.FilesAndFoldersSettingsScreenKt$$ExternalSyntheticLambda18
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FilesAndFoldersSettingsScreenKt.PageDisplaySelectDialog$lambda$1(i, pageFitMode, function0, function1, function2, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PageDisplaySelectDialog$lambda$0(Function0 function0, PageFitMode pageFitMode, Function0 function1, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C220@8183L883:FilesAndFoldersSettingsScreen.kt#p3cvtc");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1391658124, i, -1, "com.box.android.preview.filesandfolders.PageDisplaySelectDialog.<anonymous> (FilesAndFoldersSettingsScreen.kt:220)");
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
            ComposerKt.sourceInformationMarkerStart(composer, 853791029, "C224@8390L50,225@8479L66,221@8208L411,231@8820L51,232@8910L67,228@8636L416:FilesAndFoldersSettingsScreen.kt#p3cvtc");
            RadioButtonWithLabelKt.RadioButtonWithLabel(function0, pageFitMode == PageFitMode.FIT_TO_WIDTH, StringResources_androidKt.stringResource(R.string.page_display_fit_to_width, composer, 0), StringResources_androidKt.stringResource(R.string.page_display_fit_to_width_additional_info, composer, 0), "PageDisplay:FitToWidth", composer, 24576);
            RadioButtonWithLabelKt.RadioButtonWithLabel(function1, pageFitMode == PageFitMode.FIT_TO_SCREEN, StringResources_androidKt.stringResource(R.string.page_display_fit_to_screen, composer, 0), StringResources_androidKt.stringResource(R.string.page_display_fit_to_screen_additional_info, composer, 0), "PageDisplay:FitToScreen", composer, 24576);
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

    private static final void PagingModeSelectDialog(final int i, final PagingMode pagingMode, final Function0<Unit> function0, final Function0<Unit> function1, final Function0<Unit> function2, final Function0<Unit> function3, Composer composer, final int i2) {
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(1386327695);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PagingModeSelectDialog)N(titleRes,selectedPagingMode,onDismiss,onHorizontalSelected,onVerticalSelected,onContinuousSelected)255@9560L1322,253@9493L1542:FilesAndFoldersSettingsScreen.kt#p3cvtc");
        if ((i2 & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(pagingMode.ordinal()) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 16384 : 8192;
        }
        if ((196608 & i2) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function3) ? 131072 : 65536;
        }
        if (!composerStartRestartGroup.shouldExecute((74899 & i3) != 74898, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1386327695, i3, -1, "com.box.android.preview.filesandfolders.PagingModeSelectDialog (FilesAndFoldersSettingsScreen.kt:252)");
            }
            BoxDismissAlertDialogKt.m11712BoxDismissAlertDialogV9fs2A(i, ComposableLambdaKt.rememberComposableLambda(565876598, true, new Function2() { // from class: com.box.android.preview.filesandfolders.FilesAndFoldersSettingsScreenKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FilesAndFoldersSettingsScreenKt.PagingModeSelectDialog$lambda$0(function1, pagingMode, function2, function3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), new ButtonItem.TextButtonItem(false, function0, R.string.alert_dialog_cancel, 1, null), null, null, 0L, composerStartRestartGroup, (i3 & 14) | 48, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.filesandfolders.FilesAndFoldersSettingsScreenKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return FilesAndFoldersSettingsScreenKt.PagingModeSelectDialog$lambda$1(i, pagingMode, function0, function1, function2, function3, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PagingModeSelectDialog$lambda$0(Function0 function0, PagingMode pagingMode, Function0 function1, Function0 function2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C256@9574L1298:FilesAndFoldersSettingsScreen.kt#p3cvtc");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(565876598, i, -1, "com.box.android.preview.filesandfolders.PagingModeSelectDialog.<anonymous> (FilesAndFoldersSettingsScreen.kt:256)");
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
            ComposerKt.sourceInformationMarkerStart(composer, 444114508, "C260@9777L47,261@9863L63,257@9599L400,267@10190L45,268@10274L61,264@10016L390,274@10610L56,275@10705L72,271@10423L435:FilesAndFoldersSettingsScreen.kt#p3cvtc");
            RadioButtonWithLabelKt.RadioButtonWithLabel(function0, pagingMode == PagingMode.HORIZONTAL, StringResources_androidKt.stringResource(R.string.paging_mode_horizontal, composer, 0), StringResources_androidKt.stringResource(R.string.paging_mode_horizontal_additional_info, composer, 0), "PagingMode:Horizontal", composer, 24576);
            RadioButtonWithLabelKt.RadioButtonWithLabel(function1, pagingMode == PagingMode.VERTICAL, StringResources_androidKt.stringResource(R.string.paging_mode_vertical, composer, 0), StringResources_androidKt.stringResource(R.string.paging_mode_vertical_additional_info, composer, 0), "PagingMode:Vertical", composer, 24576);
            RadioButtonWithLabelKt.RadioButtonWithLabel(function2, pagingMode == PagingMode.VERTICAL_CONTINUOUS, StringResources_androidKt.stringResource(R.string.paging_mode_vertical_continuous, composer, 0), StringResources_androidKt.stringResource(R.string.paging_mode_vertical_continuous_additional_info, composer, 0), "PagingMode:VerticalContinuous", composer, 24576);
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

    private static final int titleStringRes(ScrollableFileType scrollableFileType) {
        int i = WhenMappings.$EnumSwitchMapping$1[scrollableFileType.ordinal()];
        if (i == 1) {
            return R.string.paging_mode_select_pdf_title;
        }
        if (i == 2) {
            return R.string.paging_mode_select_powerpoint_title;
        }
        if (i != 3) {
            throw new NoWhenBranchMatchedException();
        }
        return R.string.paging_mode_select_word_title;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FilesAndFoldersReducer.State FilesAndFoldersSettingsScreen$lambda$0(State<FilesAndFoldersReducer.State> state) {
        return state.getValue();
    }

    private static final FilesAndFoldersReducer.State PageDisplaySetting$lambda$0(State<FilesAndFoldersReducer.State> state) {
        return state.getValue();
    }

    private static final FilesAndFoldersReducer.State PagingModeSettings$lambda$0(State<FilesAndFoldersReducer.State> state) {
        return state.getValue();
    }
}

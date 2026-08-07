package com.box.android.base.presentation.watermarking;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ScrollKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.ProgressIndicatorKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.SwitchColors;
import androidx.compose.material3.SwitchDefaults;
import androidx.compose.material3.SwitchKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TopAppBarDefaults;
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
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.AnnotatedString;
import androidx.compose.ui.text.PlatformSpanStyle;
import androidx.compose.ui.text.SpanStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.media3.exoplayer.analytics.AnalyticsListener;
import androidx.media3.extractor.WavUtil;
import androidx.media3.extractor.ts.TsExtractor;
import com.box.android.base.R;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.base.compose.button.BoxIconButtonKt;
import com.box.android.base.compose.button.model.ButtonItem;
import com.box.android.base.compose.button.model.ButtonItemIconResource;
import com.box.android.base.compose.divider.BoxHorizontalDividerKt;
import com.box.android.cpl.Store;
import com.box.android.preview.previewtype.boxnote.BoxNoteConstants;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import okio.Utf8;

/* JADX INFO: compiled from: WatermarkingScreen.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000R\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\u001a9\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\n\u001aO\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00042\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0002\u0010\u0010\u001a1\u0010\u0011\u001a\u00020\u00012\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00010\u00072\u0006\u0010\u0012\u001a\u00020\tH\u0003¢\u0006\u0002\u0010\u0013\u001a=\u0010\u0014\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00042\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\r2\b\b\u0002\u0010\u0015\u001a\u00020\u00162\b\b\u0002\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0002\u0010\u0017\u001a3\u0010\u0018\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00192\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\r2\b\b\u0002\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0002\u0010\u001a\u001a3\u0010\u001b\u001a\u00020\u00012\u0006\u0010\u000b\u001a\u00020\u00192\u0012\u0010\f\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u00010\r2\b\b\u0002\u0010\b\u001a\u00020\tH\u0003¢\u0006\u0002\u0010\u001a\u001a\r\u0010\u001c\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u001d\u001a\u0015\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0003¢\u0006\u0002\u0010\"\u001a\u001f\u0010#\u001a\u00020\u00012\u0006\u0010$\u001a\u00020\u001f2\b\b\u0002\u0010\u0015\u001a\u00020\u0016H\u0003¢\u0006\u0002\u0010%\u001a\u0015\u0010&\u001a\u00020\u00012\u0006\u0010'\u001a\u00020(H\u0003¢\u0006\u0002\u0010)\u001a\r\u0010*\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u001d\u001a\r\u0010+\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u001d\u001a\r\u0010,\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u001d\u001a\r\u0010-\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u001d\u001a\r\u0010.\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u001d\u001a\r\u0010/\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u001d¨\u00060²\u0006\n\u0010\u000b\u001a\u00020\u0004X\u008a\u0084\u0002"}, d2 = {"WatermarkingScreen", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$State;", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$Action;", "onClose", "Lkotlin/Function0;", "isRedesignedVersion", "", "(Lcom/box/android/cpl/Store;Lkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;II)V", "state", "onToggleChanged", "Lkotlin/Function1;", "onCancelClicked", "onSaveClicked", "(Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$State;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;II)V", "WatermarkingTopBar", "isSaveEnabled", "(Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;I)V", "WatermarkingContent", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$State;Lkotlin/jvm/functions/Function1;Landroidx/compose/ui/Modifier;ZLandroidx/compose/runtime/Composer;II)V", "WatermarkingToggleSection", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$State$Loaded;", "(Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$State$Loaded;Lkotlin/jvm/functions/Function1;ZLandroidx/compose/runtime/Composer;II)V", "WatermarkingToggleRow", "WatermarkingDescription", "(Landroidx/compose/runtime/Composer;I)V", "mapErrorToMessage", "", "error", "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingError;", "(Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingError;Landroidx/compose/runtime/Composer;I)Ljava/lang/String;", "WatermarkingErrorSection", "errorMessage", "(Ljava/lang/String;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "WatermarkingDisabledReasonText", BoxNoteConstants.BOX_NOTE_BRIDGE_KEY_REASON, "Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingDisabledReason;", "(Lcom/box/android/base/presentation/watermarking/WatermarkingReducer$WatermarkingDisabledReason;Landroidx/compose/runtime/Composer;I)V", "WatermarkingScreenPreviewFileToggleOff", "WatermarkingScreenPreviewFileToggleOn", "WatermarkingScreenPreviewFolderToggleOn", "WatermarkingScreenPreviewDisabledParentLevel", "WatermarkingScreenPreviewDisabledAccessPolicy", "WatermarkingScreenPreviewNotSupported", "base_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class WatermarkingScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatermarkingContent$lambda$1(WatermarkingReducer.State state, Function1 function1, Modifier modifier, boolean z, int i, int i2, Composer composer, int i3) {
        WatermarkingContent(state, function1, modifier, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatermarkingDescription$lambda$0(int i, Composer composer, int i2) {
        WatermarkingDescription(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatermarkingDisabledReasonText$lambda$1(WatermarkingReducer.WatermarkingDisabledReason watermarkingDisabledReason, int i, Composer composer, int i2) {
        WatermarkingDisabledReasonText(watermarkingDisabledReason, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatermarkingErrorSection$lambda$1(String str, Modifier modifier, int i, int i2, Composer composer, int i3) {
        WatermarkingErrorSection(str, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatermarkingScreen$lambda$4(Store store, Function0 function0, boolean z, int i, int i2, Composer composer, int i3) {
        WatermarkingScreen(store, function0, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatermarkingScreen$lambda$7(WatermarkingReducer.State state, Function1 function1, Function0 function0, Function0 function2, boolean z, int i, int i2, Composer composer, int i3) {
        WatermarkingScreen(state, function1, function0, function2, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatermarkingScreenPreviewDisabledAccessPolicy$lambda$0(int i, Composer composer, int i2) {
        WatermarkingScreenPreviewDisabledAccessPolicy(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatermarkingScreenPreviewDisabledParentLevel$lambda$0(int i, Composer composer, int i2) {
        WatermarkingScreenPreviewDisabledParentLevel(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatermarkingScreenPreviewFileToggleOff$lambda$0(int i, Composer composer, int i2) {
        WatermarkingScreenPreviewFileToggleOff(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatermarkingScreenPreviewFileToggleOn$lambda$0(int i, Composer composer, int i2) {
        WatermarkingScreenPreviewFileToggleOn(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatermarkingScreenPreviewFolderToggleOn$lambda$0(int i, Composer composer, int i2) {
        WatermarkingScreenPreviewFolderToggleOn(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatermarkingScreenPreviewNotSupported$lambda$0(int i, Composer composer, int i2) {
        WatermarkingScreenPreviewNotSupported(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatermarkingToggleRow$lambda$1(WatermarkingReducer.State.Loaded loaded, Function1 function1, boolean z, int i, int i2, Composer composer, int i3) {
        WatermarkingToggleRow(loaded, function1, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatermarkingToggleSection$lambda$1(WatermarkingReducer.State.Loaded loaded, Function1 function1, boolean z, int i, int i2, Composer composer, int i3) {
        WatermarkingToggleSection(loaded, function1, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatermarkingTopBar$lambda$1(Function0 function0, Function0 function1, boolean z, int i, Composer composer, int i2) {
        WatermarkingTopBar(function0, function1, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0065  */
    /* JADX WARN: Code duplicated, block: B:31:0x0067  */
    /* JADX WARN: Code duplicated, block: B:34:0x0070 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x0072  */
    /* JADX WARN: Code duplicated, block: B:36:0x0075  */
    /* JADX WARN: Code duplicated, block: B:39:0x007d  */
    /* JADX WARN: Code duplicated, block: B:42:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:43:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:48:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:51:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:52:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:55:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:56:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:61:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:65:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:70:0x0106  */
    /* JADX WARN: Code duplicated, block: B:73:0x012b  */
    /* JADX WARN: Code duplicated, block: B:75:0x0130  */
    /* JADX WARN: Code duplicated, block: B:78:0x013b  */
    /* JADX WARN: Code duplicated, block: B:80:? A[RETURN, SYNTHETIC] */
    public static final void WatermarkingScreen(final Store<WatermarkingReducer.State, WatermarkingReducer.Action> store, final Function0<Unit> onClose, boolean z, Composer composer, final int i, final int i2) {
        int i3;
        boolean z2;
        boolean z3;
        Composer composer2;
        final boolean z4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        boolean z5;
        int i4;
        boolean z6;
        Object objRememberedValue;
        boolean z7;
        boolean z8;
        boolean z9;
        Object objRememberedValue2;
        boolean z10;
        Object objRememberedValue3;
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(onClose, "onClose");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1253143285);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(WatermarkingScreen)N(store,onClose,isRedesignedVersion)51@2308L29,54@2411L101,57@2540L91,61@2657L47,52@2342L419:WatermarkingScreen.kt#9p5c7w");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onClose) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 == 0) {
            if ((i & 384) == 0) {
                z2 = z;
                i3 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
            }
            if ((i3 & Token.DOTQUERY) != 146) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                z4 = z2;
            } else {
                if (i5 != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1253143285, i3, -1, "com.box.android.base.presentation.watermarking.WatermarkingScreen (WatermarkingScreen.kt:50)");
                }
                WatermarkingReducer.State stateWatermarkingScreen$lambda$0 = WatermarkingScreen$lambda$0(FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7));
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1679844336, "CC(remember):WatermarkingScreen.kt#9igjgp");
                i4 = i3 & 14;
                if (i4 == 4) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z6 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.watermarking.WatermarkingScreenKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return WatermarkingScreenKt.WatermarkingScreen$lambda$1$0(store, ((Boolean) obj).booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                Function1 function1 = (Function1) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1679840218, "CC(remember):WatermarkingScreen.kt#9igjgp");
                if (i4 == 4) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if ((i3 & 112) == 32) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                z9 = z7 | z8;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z9 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.box.android.base.presentation.watermarking.WatermarkingScreenKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return WatermarkingScreenKt.WatermarkingScreen$lambda$2$0(store, onClose);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                Function0 function0 = (Function0) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1679836518, "CC(remember):WatermarkingScreen.kt#9igjgp");
                z10 = i4 == 4;
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!z10 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function0() { // from class: com.box.android.base.presentation.watermarking.WatermarkingScreenKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return WatermarkingScreenKt.WatermarkingScreen$lambda$3$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                boolean z11 = z5;
                WatermarkingScreen(stateWatermarkingScreen$lambda$0, function1, function0, (Function0) objRememberedValue3, z11, composerStartRestartGroup, (i3 << 6) & 57344, 0);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z4 = z11;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.watermarking.WatermarkingScreenKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return WatermarkingScreenKt.WatermarkingScreen$lambda$4(store, onClose, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        z2 = z;
        if ((i3 & Token.DOTQUERY) != 146) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            z4 = z2;
        } else {
            if (i5 != 0) {
                z5 = false;
            } else {
                z5 = z2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1253143285, i3, -1, "com.box.android.base.presentation.watermarking.WatermarkingScreen (WatermarkingScreen.kt:50)");
            }
            WatermarkingReducer.State stateWatermarkingScreen$lambda$1 = WatermarkingScreen$lambda$0(FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7));
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1679844336, "CC(remember):WatermarkingScreen.kt#9igjgp");
            i4 = i3 & 14;
            if (i4 == 4) {
                z6 = true;
            } else {
                z6 = false;
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z6) {
                objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.watermarking.WatermarkingScreenKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return WatermarkingScreenKt.WatermarkingScreen$lambda$1$0(store, ((Boolean) obj).booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.watermarking.WatermarkingScreenKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return WatermarkingScreenKt.WatermarkingScreen$lambda$1$0(store, ((Boolean) obj).booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Function1 function2 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1679840218, "CC(remember):WatermarkingScreen.kt#9igjgp");
            if (i4 == 4) {
                z7 = true;
            } else {
                z7 = false;
            }
            if ((i3 & 112) == 32) {
                z8 = true;
            } else {
                z8 = false;
            }
            z9 = z7 | z8;
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!z9) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.base.presentation.watermarking.WatermarkingScreenKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return WatermarkingScreenKt.WatermarkingScreen$lambda$2$0(store, onClose);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new Function0() { // from class: com.box.android.base.presentation.watermarking.WatermarkingScreenKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return WatermarkingScreenKt.WatermarkingScreen$lambda$2$0(store, onClose);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Function0 function3 = (Function0) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1679836518, "CC(remember):WatermarkingScreen.kt#9igjgp");
            if (i4 == 4) {
            }
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (!z10) {
                objRememberedValue3 = new Function0() { // from class: com.box.android.base.presentation.watermarking.WatermarkingScreenKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return WatermarkingScreenKt.WatermarkingScreen$lambda$3$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new Function0() { // from class: com.box.android.base.presentation.watermarking.WatermarkingScreenKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return WatermarkingScreenKt.WatermarkingScreen$lambda$3$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            boolean z12 = z5;
            WatermarkingScreen(stateWatermarkingScreen$lambda$1, function2, function3, (Function0) objRememberedValue3, z12, composerStartRestartGroup, (i3 << 6) & 57344, 0);
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z4 = z12;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.watermarking.WatermarkingScreenKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WatermarkingScreenKt.WatermarkingScreen$lambda$4(store, onClose, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatermarkingScreen$lambda$1$0(Store store, boolean z) {
        store.send(new WatermarkingReducer.Action.ToggleWatermarking(z));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatermarkingScreen$lambda$2$0(Store store, Function0 function0) {
        store.send(WatermarkingReducer.Action.Cancel.INSTANCE);
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatermarkingScreen$lambda$3$0(Store store) {
        store.send(WatermarkingReducer.Action.Save.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:44:0x0091  */
    /* JADX WARN: Code duplicated, block: B:45:0x0093  */
    /* JADX WARN: Code duplicated, block: B:48:0x009c A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:49:0x009e  */
    /* JADX WARN: Code duplicated, block: B:50:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:53:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:56:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:57:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:60:0x0130  */
    /* JADX WARN: Code duplicated, block: B:62:0x0135  */
    /* JADX WARN: Code duplicated, block: B:65:0x0141  */
    /* JADX WARN: Code duplicated, block: B:67:? A[RETURN, SYNTHETIC] */
    public static final void WatermarkingScreen(final WatermarkingReducer.State state, final Function1<? super Boolean, Unit> onToggleChanged, final Function0<Unit> onCancelClicked, final Function0<Unit> onSaveClicked, boolean z, Composer composer, final int i, final int i2) {
        int i3;
        boolean z2;
        boolean z3;
        Composer composer2;
        final boolean z4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final boolean z5;
        long jM11544getPreviewBackground0d7_KjU;
        Intrinsics.checkNotNullParameter(state, "state");
        Intrinsics.checkNotNullParameter(onToggleChanged, "onToggleChanged");
        Intrinsics.checkNotNullParameter(onCancelClicked, "onCancelClicked");
        Intrinsics.checkNotNullParameter(onSaveClicked, "onSaveClicked");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1022562142);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(WatermarkingScreen)N(state,onToggleChanged,onCancelClicked,onSaveClicked,isRedesignedVersion)90@3724L11,80@3278L401,91@3742L247,75@3032L957:WatermarkingScreen.kt#9p5c7w");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(state) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onToggleChanged) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onCancelClicked) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onSaveClicked) ? 2048 : 1024;
        }
        int i4 = i2 & 16;
        if (i4 == 0) {
            if ((i & 24576) == 0) {
                z2 = z;
                i3 |= composerStartRestartGroup.changed(z2) ? 16384 : 8192;
            }
            if ((i3 & 9363) != 9362) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                z4 = z2;
            } else {
                if (i4 != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1022562142, i3, -1, "com.box.android.base.presentation.watermarking.WatermarkingScreen (WatermarkingScreen.kt:74)");
                }
                Modifier modifierTestTag = TestTagKt.testTag(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), "WatermarkingScreen");
                if (z5) {
                    composerStartRestartGroup.startReplaceGroup(865304815);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "79@3200L6");
                    jM11544getPreviewBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                } else {
                    composerStartRestartGroup.startReplaceGroup(865305939);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "79@3235L6");
                    jM11544getPreviewBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11544getPreviewBackground0d7_KjU();
                }
                composerStartRestartGroup.endReplaceGroup();
                boolean z6 = z5;
                composer2 = composerStartRestartGroup;
                ScaffoldKt.m4038ScaffoldTvnljyQ(modifierTestTag, ComposableLambdaKt.rememberComposableLambda(1591819110, true, new Function2() { // from class: com.box.android.base.presentation.watermarking.WatermarkingScreenKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return WatermarkingScreenKt.WatermarkingScreen$lambda$5(onCancelClicked, onSaveClicked, state, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), null, null, null, 0, jM11544getPreviewBackground0d7_KjU, 0L, WindowInsets_androidKt.getSafeDrawing(WindowInsets.INSTANCE, composerStartRestartGroup, 6), ComposableLambdaKt.rememberComposableLambda(1553712817, true, new Function3() { // from class: com.box.android.base.presentation.watermarking.WatermarkingScreenKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return WatermarkingScreenKt.WatermarkingScreen$lambda$6(state, onToggleChanged, z5, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, 805306422, TsExtractor.TS_PACKET_SIZE);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z4 = z6;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.watermarking.WatermarkingScreenKt$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return WatermarkingScreenKt.WatermarkingScreen$lambda$7(state, onToggleChanged, onCancelClicked, onSaveClicked, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        z2 = z;
        if ((i3 & 9363) != 9362) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            z4 = z2;
        } else {
            if (i4 != 0) {
                z5 = false;
            } else {
                z5 = z2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1022562142, i3, -1, "com.box.android.base.presentation.watermarking.WatermarkingScreen (WatermarkingScreen.kt:74)");
            }
            Modifier modifierTestTag2 = TestTagKt.testTag(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), "WatermarkingScreen");
            if (z5) {
                composerStartRestartGroup.startReplaceGroup(865304815);
                ComposerKt.sourceInformation(composerStartRestartGroup, "79@3200L6");
                jM11544getPreviewBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
            } else {
                composerStartRestartGroup.startReplaceGroup(865305939);
                ComposerKt.sourceInformation(composerStartRestartGroup, "79@3235L6");
                jM11544getPreviewBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11544getPreviewBackground0d7_KjU();
            }
            composerStartRestartGroup.endReplaceGroup();
            boolean z7 = z5;
            composer2 = composerStartRestartGroup;
            ScaffoldKt.m4038ScaffoldTvnljyQ(modifierTestTag2, ComposableLambdaKt.rememberComposableLambda(1591819110, true, new Function2() { // from class: com.box.android.base.presentation.watermarking.WatermarkingScreenKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WatermarkingScreenKt.WatermarkingScreen$lambda$5(onCancelClicked, onSaveClicked, state, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), null, null, null, 0, jM11544getPreviewBackground0d7_KjU, 0L, WindowInsets_androidKt.getSafeDrawing(WindowInsets.INSTANCE, composerStartRestartGroup, 6), ComposableLambdaKt.rememberComposableLambda(1553712817, true, new Function3() { // from class: com.box.android.base.presentation.watermarking.WatermarkingScreenKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return WatermarkingScreenKt.WatermarkingScreen$lambda$6(state, onToggleChanged, z5, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, 805306422, TsExtractor.TS_PACKET_SIZE);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z4 = z7;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.watermarking.WatermarkingScreenKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WatermarkingScreenKt.WatermarkingScreen$lambda$7(state, onToggleChanged, onCancelClicked, onSaveClicked, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatermarkingScreen$lambda$5(Function0 function0, Function0 function1, WatermarkingReducer.State state, Composer composer, int i) {
        boolean zIsSaveEnabled;
        ComposerKt.sourceInformation(composer, "C81@3292L377:WatermarkingScreen.kt#9p5c7w");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1591819110, i, -1, "com.box.android.base.presentation.watermarking.WatermarkingScreen.<anonymous> (WatermarkingScreen.kt:81)");
            }
            if (state instanceof WatermarkingReducer.State.Loaded) {
                zIsSaveEnabled = state.isSaveEnabled();
            } else {
                if (!(state instanceof WatermarkingReducer.State.Loading) && !(state instanceof WatermarkingReducer.State.Error)) {
                    throw new NoWhenBranchMatchedException();
                }
                zIsSaveEnabled = false;
            }
            WatermarkingTopBar(function0, function1, zIsSaveEnabled, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatermarkingScreen$lambda$6(WatermarkingReducer.State state, Function1 function1, boolean z, PaddingValues paddingValues, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        ComposerKt.sourceInformation(composer, "CN(paddingValues)92@3769L214:WatermarkingScreen.kt#9p5c7w");
        if ((i & 6) == 0) {
            i |= composer.changed(paddingValues) ? 4 : 2;
        }
        if (!composer.shouldExecute((i & 19) != 18, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1553712817, i, -1, "com.box.android.base.presentation.watermarking.WatermarkingScreen.<anonymous> (WatermarkingScreen.kt:92)");
            }
            WatermarkingContent(state, function1, PaddingKt.padding(Modifier.INSTANCE, paddingValues), z, composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final void WatermarkingTopBar(final Function0<Unit> function0, final Function0<Unit> function1, final boolean z, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(220129442);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(WatermarkingTopBar)N(onCancelClicked,onSaveClicked,isSaveEnabled)104@4162L1688:WatermarkingScreen.kt#9p5c7w");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & Token.DOTQUERY) != 146, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(220129442, i2, -1, "com.box.android.base.presentation.watermarking.WatermarkingTopBar (WatermarkingScreen.kt:103)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            final ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -916676534, "C106@4210L386,116@4627L487,126@5138L519,138@5757L6,137@5698L105,105@4179L1634,141@5822L22:WatermarkingScreen.kt#9p5c7w");
            composer2 = composerStartRestartGroup;
            AppBarKt.m2784TopAppBarGHTll3U(ComposableLambdaKt.rememberComposableLambda(-1124495916, true, new Function2() { // from class: com.box.android.base.presentation.watermarking.WatermarkingScreenKt$$ExternalSyntheticLambda21
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WatermarkingScreenKt.WatermarkingTopBar$lambda$0$0(columnScopeInstance, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), null, ComposableLambdaKt.rememberComposableLambda(-1996906478, true, new Function2() { // from class: com.box.android.base.presentation.watermarking.WatermarkingScreenKt$$ExternalSyntheticLambda22
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WatermarkingScreenKt.WatermarkingTopBar$lambda$0$1(function0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), ComposableLambdaKt.rememberComposableLambda(-117847415, true, new Function3() { // from class: com.box.android.base.presentation.watermarking.WatermarkingScreenKt$$ExternalSyntheticLambda23
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return WatermarkingScreenKt.WatermarkingTopBar$lambda$0$2(z, function1, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), 0.0f, null, TopAppBarDefaults.INSTANCE.m4782topAppBarColors5tl4gsc(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11576getTopBarBackgroundSecondary0d7_KjU(), 0L, 0L, 0L, 0L, 0L, composer2, TopAppBarDefaults.$stable << 18, 62), null, composer2, 3462, 178);
            BoxHorizontalDividerKt.m11724BoxHorizontalDivider9IZ8Weo(null, 0.0f, 0L, composer2, 0, 7);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.watermarking.WatermarkingScreenKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WatermarkingScreenKt.WatermarkingTopBar$lambda$1(function0, function1, z, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatermarkingTopBar$lambda$0$0(ColumnScope columnScope, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C108@4261L43,110@4406L6,107@4228L354:WatermarkingScreen.kt#9p5c7w");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1124495916, i, -1, "com.box.android.base.presentation.watermarking.WatermarkingTopBar.<anonymous>.<anonymous> (WatermarkingScreen.kt:107)");
            }
            TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(R.string.watermarking_title, composer, 0), TestTagKt.testTag(ColumnScope.weight$default(columnScope, Modifier.INSTANCE, 1.0f, false, 2, null), "WatermarkingScreen:Subtitle"), BoxTheme.INSTANCE.getColors(composer, 6).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxSemiBold22(), composer, 0, 12582912, 131064);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatermarkingTopBar$lambda$0$1(Function0 function0, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C121@4932L44,117@4645L455:WatermarkingScreen.kt#9p5c7w");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1996906478, i, -1, "com.box.android.base.presentation.watermarking.WatermarkingTopBar.<anonymous>.<anonymous> (WatermarkingScreen.kt:117)");
            }
            BoxIconButtonKt.m11681BoxIconButtonuDo3WH8(new ButtonItem.IconButtonItem(false, function0, StringResources_androidKt.stringResource(R.string.watermarking_cancel, composer, 0), new ButtonItemIconResource.DrawableResource(R.drawable.ic_arrow_left_secondary), false, 17, null), TestTagKt.testTag(Modifier.INSTANCE, "WatermarkingScreen:CancelButton"), null, 0L, 0.0f, composer, 48, 28);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatermarkingTopBar$lambda$0$2(boolean z, Function0 function0, RowScope TopAppBar, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(TopAppBar, "$this$TopAppBar");
        ComposerKt.sourceInformation(composer, "C132@5479L42,127@5156L487:WatermarkingScreen.kt#9p5c7w");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-117847415, i, -1, "com.box.android.base.presentation.watermarking.WatermarkingTopBar.<anonymous>.<anonymous> (WatermarkingScreen.kt:127)");
            }
            BoxIconButtonKt.m11681BoxIconButtonuDo3WH8(new ButtonItem.IconButtonItem(z, function0, StringResources_androidKt.stringResource(R.string.watermarking_save, composer, 0), new ButtonItemIconResource.DrawableResource(R.drawable.ic_done_24), false, 16, null), TestTagKt.testTag(Modifier.INSTANCE, "WatermarkingScreen:SaveButton"), null, 0L, 0.0f, composer, 48, 28);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:31:0x0057  */
    /* JADX WARN: Code duplicated, block: B:32:0x005a  */
    /* JADX WARN: Code duplicated, block: B:34:0x005e  */
    /* JADX WARN: Code duplicated, block: B:36:0x0066  */
    /* JADX WARN: Code duplicated, block: B:37:0x0069  */
    /* JADX WARN: Code duplicated, block: B:42:0x0077  */
    /* JADX WARN: Code duplicated, block: B:43:0x0079  */
    /* JADX WARN: Code duplicated, block: B:46:0x0082 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:47:0x0084  */
    /* JADX WARN: Code duplicated, block: B:48:0x0089  */
    /* JADX WARN: Code duplicated, block: B:50:0x008c  */
    /* JADX WARN: Code duplicated, block: B:51:0x008f  */
    /* JADX WARN: Code duplicated, block: B:54:0x0097  */
    /* JADX WARN: Code duplicated, block: B:57:0x0101  */
    /* JADX WARN: Code duplicated, block: B:60:0x010d  */
    /* JADX WARN: Code duplicated, block: B:61:0x0111  */
    /* JADX WARN: Code duplicated, block: B:64:0x0161  */
    /* JADX WARN: Code duplicated, block: B:66:0x01b2  */
    /* JADX WARN: Code duplicated, block: B:69:0x01be  */
    /* JADX WARN: Code duplicated, block: B:70:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:72:0x023c  */
    /* JADX WARN: Code duplicated, block: B:74:0x0241  */
    /* JADX WARN: Code duplicated, block: B:76:0x026d  */
    /* JADX WARN: Code duplicated, block: B:78:0x0271  */
    /* JADX WARN: Code duplicated, block: B:81:0x02aa  */
    /* JADX WARN: Code duplicated, block: B:83:0x02af  */
    /* JADX WARN: Code duplicated, block: B:85:0x02be  */
    /* JADX WARN: Code duplicated, block: B:88:0x02ca  */
    /* JADX WARN: Code duplicated, block: B:90:? A[RETURN, SYNTHETIC] */
    private static final void WatermarkingContent(final WatermarkingReducer.State state, final Function1<? super Boolean, Unit> function1, Modifier modifier, boolean z, Composer composer, final int i, final int i2) {
        int i3;
        Function1<? super Boolean, Unit> function2;
        Modifier modifier2;
        int i4;
        boolean z2;
        int i5;
        boolean z3;
        Composer composer2;
        final Modifier modifier3;
        final boolean z4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        boolean z5;
        Function0<ComposeUiNode> constructor;
        Function0<ComposeUiNode> constructor2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-951221624);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(WatermarkingContent)N(state,onToggleChanged,modifier,isRedesignedVersion)155@6152L21,152@6061L1128:WatermarkingScreen.kt#9p5c7w");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(state) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            function2 = function1;
            i3 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        } else {
            function2 = function1;
        }
        int i6 = i2 & 4;
        if (i6 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                if ((i3 & 1171) != 1170) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                } else {
                    if (i6 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-951221624, i3, -1, "com.box.android.base.presentation.watermarking.WatermarkingContent (WatermarkingScreen.kt:151)");
                    }
                    Modifier modifierTestTag = TestTagKt.testTag(ScrollKt.verticalScroll$default(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), false, null, false, 14, null), "WatermarkingScreen:Content");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                    MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierTestTag);
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2020860552, "C:WatermarkingScreen.kt#9p5c7w");
                    if (state instanceof WatermarkingReducer.State.Loading) {
                        composerStartRestartGroup.startReplaceGroup(-2020813557);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "160@6327L281");
                        Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                        Alignment center = Alignment.INSTANCE.getCenter();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default);
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
                        Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1857164604, "C165@6551L6,164@6483L107:WatermarkingScreen.kt#9p5c7w");
                        composer2 = composerStartRestartGroup;
                        ProgressIndicatorKt.m3993CircularProgressIndicator4lLiAd8(null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), 0.0f, 0L, 0, 0.0f, composer2, 0, 61);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endReplaceGroup();
                    } else {
                        composer2 = composerStartRestartGroup;
                        if (state instanceof WatermarkingReducer.State.Error) {
                            composer2.startReplaceGroup(-2020454422);
                            ComposerKt.sourceInformation(composer2, "172@6753L30,171@6692L186");
                            WatermarkingErrorSection(mapErrorToMessage(((WatermarkingReducer.State.Error) state).getError(), composer2, 0), TestTagKt.testTag(Modifier.INSTANCE, "WatermarkingScreen:Error"), composer2, 48, 0);
                            composer2.endReplaceGroup();
                        } else {
                            if (state instanceof WatermarkingReducer.State.Loaded) {
                                composer2.startReplaceGroup(1181736939);
                                composer2.endReplaceGroup();
                                throw new NoWhenBranchMatchedException();
                            }
                            composer2.startReplaceGroup(-2020185280);
                            ComposerKt.sourceInformation(composer2, "178@6963L196");
                            z2 = z5;
                            WatermarkingToggleSection((WatermarkingReducer.State.Loaded) state, function2, z2, composer2, (i3 & 126) | ((i3 >> 3) & 896), 0);
                            composer2.endReplaceGroup();
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        composer2.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = companion;
                    }
                    z2 = z5;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = companion;
                }
                z4 = z2;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.watermarking.WatermarkingScreenKt$$ExternalSyntheticLambda14
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return WatermarkingScreenKt.WatermarkingContent$lambda$1(state, function1, modifier3, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            z2 = z;
            if ((i3 & 1171) != 1170) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-951221624, i3, -1, "com.box.android.base.presentation.watermarking.WatermarkingContent (WatermarkingScreen.kt:151)");
                }
                Modifier modifierTestTag2 = TestTagKt.testTag(ScrollKt.verticalScroll$default(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), false, null, false, 14, null), "WatermarkingScreen:Content");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierTestTag2);
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
                Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicyColumnMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2020860552, "C:WatermarkingScreen.kt#9p5c7w");
                if (state instanceof WatermarkingReducer.State.Loading) {
                    composerStartRestartGroup.startReplaceGroup(-2020813557);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "160@6327L281");
                    Modifier modifierFillMaxSize$default2 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                    Alignment center2 = Alignment.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center2, false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default2);
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
                    Updater.m6070setimpl(composerM6062constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl4, Integer.valueOf(iHashCode4), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl4, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1857164604, "C165@6551L6,164@6483L107:WatermarkingScreen.kt#9p5c7w");
                    composer2 = composerStartRestartGroup;
                    ProgressIndicatorKt.m3993CircularProgressIndicator4lLiAd8(null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), 0.0f, 0L, 0, 0.0f, composer2, 0, 61);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endReplaceGroup();
                } else {
                    composer2 = composerStartRestartGroup;
                    if (state instanceof WatermarkingReducer.State.Error) {
                        composer2.startReplaceGroup(-2020454422);
                        ComposerKt.sourceInformation(composer2, "172@6753L30,171@6692L186");
                        WatermarkingErrorSection(mapErrorToMessage(((WatermarkingReducer.State.Error) state).getError(), composer2, 0), TestTagKt.testTag(Modifier.INSTANCE, "WatermarkingScreen:Error"), composer2, 48, 0);
                        composer2.endReplaceGroup();
                    } else {
                        if (state instanceof WatermarkingReducer.State.Loaded) {
                            composer2.startReplaceGroup(1181736939);
                            composer2.endReplaceGroup();
                            throw new NoWhenBranchMatchedException();
                        }
                        composer2.startReplaceGroup(-2020185280);
                        ComposerKt.sourceInformation(composer2, "178@6963L196");
                        z2 = z5;
                        WatermarkingToggleSection((WatermarkingReducer.State.Loaded) state, function2, z2, composer2, (i3 & 126) | ((i3 >> 3) & 896), 0);
                        composer2.endReplaceGroup();
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = companion;
                }
                z2 = z5;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = companion;
            }
            z4 = z2;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.watermarking.WatermarkingScreenKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return WatermarkingScreenKt.WatermarkingContent$lambda$1(state, function1, modifier3, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 3072) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            if ((i3 & 1171) != 1170) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-951221624, i3, -1, "com.box.android.base.presentation.watermarking.WatermarkingContent (WatermarkingScreen.kt:151)");
                }
                Modifier modifierTestTag3 = TestTagKt.testTag(ScrollKt.verticalScroll$default(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), false, null, false, 14, null), "WatermarkingScreen:Content");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy3 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode5 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierTestTag3);
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
                Updater.m6070setimpl(composerM6062constructorimpl5, measurePolicyColumnMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl5, Integer.valueOf(iHashCode5), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl5, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl5, modifierMaterializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
                ColumnScopeInstance columnScopeInstance3 = ColumnScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2020860552, "C:WatermarkingScreen.kt#9p5c7w");
                if (state instanceof WatermarkingReducer.State.Loading) {
                    composerStartRestartGroup.startReplaceGroup(-2020813557);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "160@6327L281");
                    Modifier modifierFillMaxSize$default3 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                    Alignment center3 = Alignment.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(center3, false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode6 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default3);
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
                    Updater.m6070setimpl(composerM6062constructorimpl6, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl6, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl6, Integer.valueOf(iHashCode6), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl6, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl6, modifierMaterializeModifier6, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1857164604, "C165@6551L6,164@6483L107:WatermarkingScreen.kt#9p5c7w");
                    composer2 = composerStartRestartGroup;
                    ProgressIndicatorKt.m3993CircularProgressIndicator4lLiAd8(null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), 0.0f, 0L, 0, 0.0f, composer2, 0, 61);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endReplaceGroup();
                } else {
                    composer2 = composerStartRestartGroup;
                    if (state instanceof WatermarkingReducer.State.Error) {
                        composer2.startReplaceGroup(-2020454422);
                        ComposerKt.sourceInformation(composer2, "172@6753L30,171@6692L186");
                        WatermarkingErrorSection(mapErrorToMessage(((WatermarkingReducer.State.Error) state).getError(), composer2, 0), TestTagKt.testTag(Modifier.INSTANCE, "WatermarkingScreen:Error"), composer2, 48, 0);
                        composer2.endReplaceGroup();
                    } else {
                        if (state instanceof WatermarkingReducer.State.Loaded) {
                            composer2.startReplaceGroup(1181736939);
                            composer2.endReplaceGroup();
                            throw new NoWhenBranchMatchedException();
                        }
                        composer2.startReplaceGroup(-2020185280);
                        ComposerKt.sourceInformation(composer2, "178@6963L196");
                        z2 = z5;
                        WatermarkingToggleSection((WatermarkingReducer.State.Loaded) state, function2, z2, composer2, (i3 & 126) | ((i3 >> 3) & 896), 0);
                        composer2.endReplaceGroup();
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    composer2.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = companion;
                }
                z2 = z5;
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = companion;
            }
            z4 = z2;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.watermarking.WatermarkingScreenKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return WatermarkingScreenKt.WatermarkingContent$lambda$1(state, function1, modifier3, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        z2 = z;
        if ((i3 & 1171) != 1170) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i6 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (i4 != 0) {
                z5 = false;
            } else {
                z5 = z2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-951221624, i3, -1, "com.box.android.base.presentation.watermarking.WatermarkingContent (WatermarkingScreen.kt:151)");
            }
            Modifier modifierTestTag4 = TestTagKt.testTag(ScrollKt.verticalScroll$default(SizeKt.fillMaxSize$default(companion, 0.0f, 1, null), ScrollKt.rememberScrollState(0, composerStartRestartGroup, 0, 1), false, null, false, 14, null), "WatermarkingScreen:Content");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy4 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode7 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierTestTag4);
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
            Updater.m6070setimpl(composerM6062constructorimpl7, measurePolicyColumnMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl7, currentCompositionLocalMap7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl7, Integer.valueOf(iHashCode7), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl7, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl7, modifierMaterializeModifier7, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance4 = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2020860552, "C:WatermarkingScreen.kt#9p5c7w");
            if (state instanceof WatermarkingReducer.State.Loading) {
                composerStartRestartGroup.startReplaceGroup(-2020813557);
                ComposerKt.sourceInformation(composerStartRestartGroup, "160@6327L281");
                Modifier modifierFillMaxSize$default4 = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
                Alignment center4 = Alignment.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(center4, false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode8 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default4);
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
                Updater.m6070setimpl(composerM6062constructorimpl8, measurePolicyMaybeCachedBoxMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl8, currentCompositionLocalMap8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl8, Integer.valueOf(iHashCode8), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl8, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl8, modifierMaterializeModifier8, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1857164604, "C165@6551L6,164@6483L107:WatermarkingScreen.kt#9p5c7w");
                composer2 = composerStartRestartGroup;
                ProgressIndicatorKt.m3993CircularProgressIndicator4lLiAd8(null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), 0.0f, 0L, 0, 0.0f, composer2, 0, 61);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endReplaceGroup();
            } else {
                composer2 = composerStartRestartGroup;
                if (state instanceof WatermarkingReducer.State.Error) {
                    composer2.startReplaceGroup(-2020454422);
                    ComposerKt.sourceInformation(composer2, "172@6753L30,171@6692L186");
                    WatermarkingErrorSection(mapErrorToMessage(((WatermarkingReducer.State.Error) state).getError(), composer2, 0), TestTagKt.testTag(Modifier.INSTANCE, "WatermarkingScreen:Error"), composer2, 48, 0);
                    composer2.endReplaceGroup();
                } else {
                    if (state instanceof WatermarkingReducer.State.Loaded) {
                        composer2.startReplaceGroup(1181736939);
                        composer2.endReplaceGroup();
                        throw new NoWhenBranchMatchedException();
                    }
                    composer2.startReplaceGroup(-2020185280);
                    ComposerKt.sourceInformation(composer2, "178@6963L196");
                    z2 = z5;
                    WatermarkingToggleSection((WatermarkingReducer.State.Loaded) state, function2, z2, composer2, (i3 & 126) | ((i3 >> 3) & 896), 0);
                    composer2.endReplaceGroup();
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = companion;
            }
            z2 = z5;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = companion;
        }
        z4 = z2;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.watermarking.WatermarkingScreenKt$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WatermarkingScreenKt.WatermarkingContent$lambda$1(state, function1, modifier3, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:31:0x005f  */
    /* JADX WARN: Code duplicated, block: B:32:0x0061  */
    /* JADX WARN: Code duplicated, block: B:35:0x006a A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:36:0x006c  */
    /* JADX WARN: Code duplicated, block: B:37:0x006f  */
    /* JADX WARN: Code duplicated, block: B:40:0x0077  */
    /* JADX WARN: Code duplicated, block: B:43:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:46:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:47:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:50:0x0196  */
    /* JADX WARN: Code duplicated, block: B:51:0x019d  */
    /* JADX WARN: Code duplicated, block: B:54:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:56:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:59:0x01d5  */
    /* JADX WARN: Code duplicated, block: B:61:? A[RETURN, SYNTHETIC] */
    private static final void WatermarkingToggleSection(final WatermarkingReducer.State.Loaded loaded, final Function1<? super Boolean, Unit> function1, boolean z, Composer composer, final int i, final int i2) {
        WatermarkingReducer.State.Loaded loaded2;
        int i3;
        boolean z2;
        boolean z3;
        final boolean z4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        boolean z5;
        Function0<ComposeUiNode> constructor;
        WatermarkingReducer.WatermarkingDisabledReason disabledReason;
        Composer composerStartRestartGroup = composer.startRestartGroup(1433902995);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(WatermarkingToggleSection)N(state,onToggleChanged,isRedesignedVersion)194@7378L701:WatermarkingScreen.kt#9p5c7w");
        if ((i & 6) == 0) {
            loaded2 = loaded;
            i3 = (composerStartRestartGroup.changed(loaded2) ? 4 : 2) | i;
        } else {
            loaded2 = loaded;
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i4 = i2 & 4;
        if (i4 == 0) {
            if ((i & 384) == 0) {
                z2 = z;
                i3 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
            }
            if ((i3 & Token.DOTQUERY) != 146) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                z4 = z2;
            } else {
                if (i4 != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1433902995, i3, -1, "com.box.android.base.presentation.watermarking.WatermarkingToggleSection (WatermarkingScreen.kt:193)");
                }
                float f = 16;
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, 0.0f, Dp.m9687constructorimpl(f), 1, null), 0.0f, 1, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -602259750, "C201@7583L51,203@7718L6,199@7497L254,206@7761L160,212@7931L25:WatermarkingScreen.kt#9p5c7w");
                TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(R.string.watermarking_section_title, composerStartRestartGroup, 0), PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m9687constructorimpl(f), 0.0f, 2, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11513getContentSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal13(), composerStartRestartGroup, 48, 12582912, 131064);
                composerStartRestartGroup = composerStartRestartGroup;
                boolean z6 = z5;
                WatermarkingToggleRow(loaded2, function1, z6, composerStartRestartGroup, i3 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED, 0);
                WatermarkingDescription(composerStartRestartGroup, 0);
                disabledReason = loaded.getDisabledReason();
                if (disabledReason == null) {
                    composerStartRestartGroup.startReplaceGroup(-601787901);
                } else {
                    composerStartRestartGroup.startReplaceGroup(-601787900);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*215@8016L47");
                    WatermarkingDisabledReasonText(disabledReason, composerStartRestartGroup, 0);
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
                z4 = z6;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.watermarking.WatermarkingScreenKt$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return WatermarkingScreenKt.WatermarkingToggleSection$lambda$1(loaded, function1, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        z2 = z;
        if ((i3 & Token.DOTQUERY) != 146) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            z4 = z2;
        } else {
            if (i4 != 0) {
                z5 = false;
            } else {
                z5 = z2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1433902995, i3, -1, "com.box.android.base.presentation.watermarking.WatermarkingToggleSection (WatermarkingScreen.kt:193)");
            }
            float f2 = 16;
            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, 0.0f, Dp.m9687constructorimpl(f2), 1, null), 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default2);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -602259750, "C201@7583L51,203@7718L6,199@7497L254,206@7761L160,212@7931L25:WatermarkingScreen.kt#9p5c7w");
            TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(R.string.watermarking_section_title, composerStartRestartGroup, 0), PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m9687constructorimpl(f2), 0.0f, 2, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11513getContentSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal13(), composerStartRestartGroup, 48, 12582912, 131064);
            composerStartRestartGroup = composerStartRestartGroup;
            boolean z7 = z5;
            WatermarkingToggleRow(loaded2, function1, z7, composerStartRestartGroup, i3 & AnalyticsListener.EVENT_DRM_SESSION_ACQUIRED, 0);
            WatermarkingDescription(composerStartRestartGroup, 0);
            disabledReason = loaded.getDisabledReason();
            if (disabledReason == null) {
                composerStartRestartGroup.startReplaceGroup(-601787901);
            } else {
                composerStartRestartGroup.startReplaceGroup(-601787900);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*215@8016L47");
                WatermarkingDisabledReasonText(disabledReason, composerStartRestartGroup, 0);
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
            z4 = z7;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.watermarking.WatermarkingScreenKt$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WatermarkingScreenKt.WatermarkingToggleSection$lambda$1(loaded, function1, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:30:0x005a  */
    /* JADX WARN: Code duplicated, block: B:31:0x005c  */
    /* JADX WARN: Code duplicated, block: B:34:0x0065 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:35:0x0067  */
    /* JADX WARN: Code duplicated, block: B:36:0x006a  */
    /* JADX WARN: Code duplicated, block: B:39:0x0072  */
    /* JADX WARN: Code duplicated, block: B:42:0x007e  */
    /* JADX WARN: Code duplicated, block: B:43:0x0093  */
    /* JADX WARN: Code duplicated, block: B:46:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:47:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:50:0x014f  */
    /* JADX WARN: Code duplicated, block: B:53:0x015b  */
    /* JADX WARN: Code duplicated, block: B:54:0x015f  */
    /* JADX WARN: Code duplicated, block: B:57:0x027a  */
    /* JADX WARN: Code duplicated, block: B:58:0x027c  */
    /* JADX WARN: Code duplicated, block: B:61:0x0284  */
    /* JADX WARN: Code duplicated, block: B:66:0x0296  */
    /* JADX WARN: Code duplicated, block: B:69:0x02cd  */
    /* JADX WARN: Code duplicated, block: B:71:0x02d3  */
    /* JADX WARN: Code duplicated, block: B:74:0x02df  */
    /* JADX WARN: Code duplicated, block: B:76:? A[RETURN, SYNTHETIC] */
    private static final void WatermarkingToggleRow(final WatermarkingReducer.State.Loaded loaded, final Function1<? super Boolean, Unit> function1, boolean z, Composer composer, final int i, final int i2) {
        int i3;
        boolean z2;
        boolean z3;
        Composer composer2;
        final boolean z4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        boolean z5;
        String strStringResource;
        long jM11511getContentBackground0d7_KjU;
        Function0<ComposeUiNode> constructor;
        boolean z6;
        boolean z7;
        boolean z8;
        Object objRememberedValue;
        Composer composerStartRestartGroup = composer.startRestartGroup(1274033928);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(WatermarkingToggleRow)N(state,onToggleChanged,isRedesignedVersion)232@8462L1166:WatermarkingScreen.kt#9p5c7w");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(loaded) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i4 = i2 & 4;
        if (i4 == 0) {
            if ((i & 384) == 0) {
                z2 = z;
                i3 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
            }
            if ((i3 & Token.DOTQUERY) != 146) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                z4 = z2;
            } else {
                if (i4 != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1274033928, i3, -1, "com.box.android.base.presentation.watermarking.WatermarkingToggleRow (WatermarkingScreen.kt:225)");
                }
                if (loaded.isTargetFile()) {
                    composerStartRestartGroup.startReplaceGroup(118957875);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "227@8316L55");
                    strStringResource = StringResources_androidKt.stringResource(R.string.watermarking_toggle_label_file, composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(119034321);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "229@8393L57");
                    strStringResource = StringResources_androidKt.stringResource(R.string.watermarking_toggle_label_folder, composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                }
                Modifier modifierM1220paddingVpY3zN4$default = PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, 0.0f, Dp.m9687constructorimpl(8), 1, null);
                if (z5) {
                    composerStartRestartGroup.startReplaceGroup(280941301);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "235@8591L6");
                    jM11511getContentBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                } else {
                    composerStartRestartGroup.startReplaceGroup(280942425);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "235@8626L6");
                    jM11511getContentBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11511getContentBackground0d7_KjU();
                }
                composerStartRestartGroup.endReplaceGroup();
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.m1219paddingVpY3zN4(BackgroundKt.m589backgroundbw27NRU$default(modifierM1220paddingVpY3zN4$default, jM11511getContentBackground0d7_KjU, null, 2, null), Dp.m9687constructorimpl(16), Dp.m9687constructorimpl(4)), 0.0f, 1, null);
                Arrangement.HorizontalOrVertical spaceBetween = Arrangement.INSTANCE.getSpaceBetween();
                Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(spaceBetween, centerVertically, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2024849701, "C244@8988L6,241@8868L267,260@9574L6,259@9521L91,252@9234L134,250@9145L477:WatermarkingScreen.kt#9p5c7w");
                z6 = false;
                TextKt.m4494TextNvy7gAk(strStringResource, TestTagKt.testTag(RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), "WatermarkingScreen:ToggleLabel"), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal16(), composerStartRestartGroup, 0, 12582912, 131064);
                boolean zIsWatermarkingEnabled = loaded.isWatermarkingEnabled();
                boolean zIsToggleEnabled = loaded.isToggleEnabled();
                Modifier modifierTestTag = TestTagKt.testTag(Modifier.INSTANCE, "WatermarkingScreen:Toggle");
                SwitchColors switchColorsM4356colorsV1nXRL4 = SwitchDefaults.INSTANCE.m4356colorsV1nXRL4(0L, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, SwitchDefaults.$stable << 18, Utf8.REPLACEMENT_CODE_POINT);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2004991474, "CC(remember):WatermarkingScreen.kt#9igjgp");
                if ((i3 & 14) == 4) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                if ((i3 & 112) == 32) {
                    z6 = true;
                }
                z8 = z7 | z6;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z8 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.watermarking.WatermarkingScreenKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return WatermarkingScreenKt.WatermarkingToggleRow$lambda$0$0$0(loaded, function1, ((Boolean) obj).booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                SwitchKt.Switch(zIsWatermarkingEnabled, (Function1) objRememberedValue, modifierTestTag, null, zIsToggleEnabled, switchColorsM4356colorsV1nXRL4, null, composerStartRestartGroup, 384, 72);
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
                z4 = z5;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.watermarking.WatermarkingScreenKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return WatermarkingScreenKt.WatermarkingToggleRow$lambda$1(loaded, function1, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        z2 = z;
        if ((i3 & Token.DOTQUERY) != 146) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            z4 = z2;
        } else {
            if (i4 != 0) {
                z5 = false;
            } else {
                z5 = z2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1274033928, i3, -1, "com.box.android.base.presentation.watermarking.WatermarkingToggleRow (WatermarkingScreen.kt:225)");
            }
            if (loaded.isTargetFile()) {
                composerStartRestartGroup.startReplaceGroup(118957875);
                ComposerKt.sourceInformation(composerStartRestartGroup, "227@8316L55");
                strStringResource = StringResources_androidKt.stringResource(R.string.watermarking_toggle_label_file, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(119034321);
                ComposerKt.sourceInformation(composerStartRestartGroup, "229@8393L57");
                strStringResource = StringResources_androidKt.stringResource(R.string.watermarking_toggle_label_folder, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            }
            Modifier modifierM1220paddingVpY3zN4$default2 = PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, 0.0f, Dp.m9687constructorimpl(8), 1, null);
            if (z5) {
                composerStartRestartGroup.startReplaceGroup(280941301);
                ComposerKt.sourceInformation(composerStartRestartGroup, "235@8591L6");
                jM11511getContentBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
            } else {
                composerStartRestartGroup.startReplaceGroup(280942425);
                ComposerKt.sourceInformation(composerStartRestartGroup, "235@8626L6");
                jM11511getContentBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11511getContentBackground0d7_KjU();
            }
            composerStartRestartGroup.endReplaceGroup();
            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(PaddingKt.m1219paddingVpY3zN4(BackgroundKt.m589backgroundbw27NRU$default(modifierM1220paddingVpY3zN4$default2, jM11511getContentBackground0d7_KjU, null, 2, null), Dp.m9687constructorimpl(16), Dp.m9687constructorimpl(4)), 0.0f, 1, null);
            Arrangement.HorizontalOrVertical spaceBetween2 = Arrangement.INSTANCE.getSpaceBetween();
            Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(spaceBetween2, centerVertically2, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxWidth$default2);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2024849701, "C244@8988L6,241@8868L267,260@9574L6,259@9521L91,252@9234L134,250@9145L477:WatermarkingScreen.kt#9p5c7w");
            z6 = false;
            TextKt.m4494TextNvy7gAk(strStringResource, TestTagKt.testTag(RowScope.weight$default(rowScopeInstance2, Modifier.INSTANCE, 1.0f, false, 2, null), "WatermarkingScreen:ToggleLabel"), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal16(), composerStartRestartGroup, 0, 12582912, 131064);
            boolean zIsWatermarkingEnabled2 = loaded.isWatermarkingEnabled();
            boolean zIsToggleEnabled2 = loaded.isToggleEnabled();
            Modifier modifierTestTag2 = TestTagKt.testTag(Modifier.INSTANCE, "WatermarkingScreen:Toggle");
            SwitchColors switchColorsM4356colorsV1nXRL5 = SwitchDefaults.INSTANCE.m4356colorsV1nXRL4(0L, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU(), 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 0, SwitchDefaults.$stable << 18, Utf8.REPLACEMENT_CODE_POINT);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2004991474, "CC(remember):WatermarkingScreen.kt#9igjgp");
            if ((i3 & 14) == 4) {
                z7 = true;
            } else {
                z7 = false;
            }
            if ((i3 & 112) == 32) {
                z6 = true;
            }
            z8 = z7 | z6;
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z8) {
                objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.watermarking.WatermarkingScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return WatermarkingScreenKt.WatermarkingToggleRow$lambda$0$0$0(loaded, function1, ((Boolean) obj).booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function1() { // from class: com.box.android.base.presentation.watermarking.WatermarkingScreenKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return WatermarkingScreenKt.WatermarkingToggleRow$lambda$0$0$0(loaded, function1, ((Boolean) obj).booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            SwitchKt.Switch(zIsWatermarkingEnabled2, (Function1) objRememberedValue, modifierTestTag2, null, zIsToggleEnabled2, switchColorsM4356colorsV1nXRL5, null, composerStartRestartGroup, 384, 72);
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
            z4 = z5;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.watermarking.WatermarkingScreenKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WatermarkingScreenKt.WatermarkingToggleRow$lambda$1(loaded, function1, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit WatermarkingToggleRow$lambda$0$0$0(WatermarkingReducer.State.Loaded loaded, Function1 function1, boolean z) {
        if (loaded.isToggleEnabled()) {
            function1.invoke(Boolean.valueOf(z));
        }
        return Unit.INSTANCE;
    }

    private static final void WatermarkingDescription(Composer composer, final int i) {
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(2064230572);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(WatermarkingDescription)272@9834L49,274@9959L6,268@9688L300:WatermarkingScreen.kt#9p5c7w");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2064230572, i, -1, "com.box.android.base.presentation.watermarking.WatermarkingDescription (WatermarkingScreen.kt:267)");
            }
            composer2 = composerStartRestartGroup;
            TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(R.string.watermarking_description, composerStartRestartGroup, 0), TestTagKt.testTag(PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m9687constructorimpl(16), 0.0f, 2, null), "WatermarkingScreen:Description"), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11513getContentSecondary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal12(), composer2, 48, 12582912, 131064);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.watermarking.WatermarkingScreenKt$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WatermarkingScreenKt.WatermarkingDescription$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final String mapErrorToMessage(WatermarkingReducer.WatermarkingError watermarkingError, Composer composer, int i) {
        String strStringResource;
        ComposerKt.sourceInformationMarkerStart(composer, 1761282749, "C(mapErrorToMessage)N(error):WatermarkingScreen.kt#9p5c7w");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1761282749, i, -1, "com.box.android.base.presentation.watermarking.mapErrorToMessage (WatermarkingScreen.kt:279)");
        }
        if (Intrinsics.areEqual(watermarkingError, WatermarkingReducer.WatermarkingError.NetworkError.INSTANCE)) {
            composer.startReplaceGroup(375612048);
            ComposerKt.sourceInformation(composer, "280@10163L51");
            strStringResource = StringResources_androidKt.stringResource(R.string.box_sharesdk_network_error, composer, 0);
            composer.endReplaceGroup();
        } else if (Intrinsics.areEqual(watermarkingError, WatermarkingReducer.WatermarkingError.ItemNotFound.INSTANCE)) {
            composer.startReplaceGroup(375615568);
            ComposerKt.sourceInformation(composer, "281@10273L51");
            strStringResource = StringResources_androidKt.stringResource(R.string.box_sharesdk_generic_error, composer, 0);
            composer.endReplaceGroup();
        } else if (Intrinsics.areEqual(watermarkingError, WatermarkingReducer.WatermarkingError.SaveError.INSTANCE)) {
            composer.startReplaceGroup(375618989);
            ComposerKt.sourceInformation(composer, "282@10380L48");
            strStringResource = StringResources_androidKt.stringResource(R.string.watermarking_save_error, composer, 0);
            composer.endReplaceGroup();
        } else if (Intrinsics.areEqual(watermarkingError, WatermarkingReducer.WatermarkingError.UnknownError.INSTANCE)) {
            composer.startReplaceGroup(375622416);
            ComposerKt.sourceInformation(composer, "283@10487L51");
            strStringResource = StringResources_androidKt.stringResource(R.string.box_sharesdk_generic_error, composer, 0);
            composer.endReplaceGroup();
        } else {
            if (!Intrinsics.areEqual(watermarkingError, WatermarkingReducer.WatermarkingError.PermissionDataMissing.INSTANCE)) {
                composer.startReplaceGroup(375610230);
                composer.endReplaceGroup();
                throw new NoWhenBranchMatchedException();
            }
            composer.startReplaceGroup(375626224);
            ComposerKt.sourceInformation(composer, "284@10606L51");
            strStringResource = StringResources_androidKt.stringResource(R.string.box_sharesdk_generic_error, composer, 0);
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return strStringResource;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0047  */
    /* JADX WARN: Code duplicated, block: B:24:0x0049  */
    /* JADX WARN: Code duplicated, block: B:27:0x0052 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:28:0x0054  */
    /* JADX WARN: Code duplicated, block: B:29:0x0059  */
    /* JADX WARN: Code duplicated, block: B:32:0x0060  */
    /* JADX WARN: Code duplicated, block: B:35:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:38:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:39:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:42:0x0180  */
    /* JADX WARN: Code duplicated, block: B:44:0x0186  */
    /* JADX WARN: Code duplicated, block: B:47:0x0191  */
    /* JADX WARN: Code duplicated, block: B:49:? A[RETURN, SYNTHETIC] */
    private static final void WatermarkingErrorSection(final String str, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        final Modifier modifier2;
        boolean z;
        Composer composer2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        Function0<ComposeUiNode> constructor;
        Composer composerStartRestartGroup = composer.startRestartGroup(1552101841);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(WatermarkingErrorSection)N(errorMessage,modifier)289@10769L376:WatermarkingScreen.kt#9p5c7w");
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
            } else {
                if (i4 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1552101841, i3, -1, "com.box.android.base.presentation.watermarking.WatermarkingErrorSection (WatermarkingScreen.kt:288)");
                }
                Modifier modifierM1218padding3ABfNKs = PaddingKt.m1218padding3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), Dp.m9687constructorimpl(16));
                Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
                Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(center, centerHorizontally, composerStartRestartGroup, 54);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1218padding3ABfNKs);
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
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 17399044, "C299@11108L6,296@10987L152:WatermarkingScreen.kt#9p5c7w");
                int i5 = i3 & 14;
                Modifier modifier3 = companion;
                composer2 = composerStartRestartGroup;
                TextKt.m4494TextNvy7gAk(str, null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11563getTextFieldError0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal16(), composer2, i5, 12582912, 131066);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                composer2.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                ComposerKt.sourceInformationMarkerEnd(composer2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.watermarking.WatermarkingScreenKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return WatermarkingScreenKt.WatermarkingErrorSection$lambda$1(str, modifier2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
        } else {
            if (i4 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1552101841, i3, -1, "com.box.android.base.presentation.watermarking.WatermarkingErrorSection (WatermarkingScreen.kt:288)");
            }
            Modifier modifierM1218padding3ABfNKs2 = PaddingKt.m1218padding3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), Dp.m9687constructorimpl(16));
            Alignment.Horizontal centerHorizontally2 = Alignment.INSTANCE.getCenterHorizontally();
            Arrangement.HorizontalOrVertical center2 = Arrangement.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(center2, centerHorizontally2, composerStartRestartGroup, 54);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1218padding3ABfNKs2);
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
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 17399044, "C299@11108L6,296@10987L152:WatermarkingScreen.kt#9p5c7w");
            int i6 = i3 & 14;
            Modifier modifier4 = companion;
            composer2 = composerStartRestartGroup;
            TextKt.m4494TextNvy7gAk(str, null, BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11563getTextFieldError0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, BoxTheme.INSTANCE.getTypography().getBoxNormal16(), composer2, i6, 12582912, 131066);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.watermarking.WatermarkingScreenKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WatermarkingScreenKt.WatermarkingErrorSection$lambda$1(str, modifier2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void WatermarkingDisabledReasonText(final WatermarkingReducer.WatermarkingDisabledReason watermarkingDisabledReason, Composer composer, final int i) {
        int i2;
        Composer composer2;
        String strStringResource;
        Composer composerStartRestartGroup = composer.startRestartGroup(-118141737);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(WatermarkingDisabledReasonText)N(reason)320@11937L48,335@12457L250:WatermarkingScreen.kt#9p5c7w");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(watermarkingDisabledReason) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        int i3 = 1;
        int i4 = 0;
        if (!composerStartRestartGroup.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-118141737, i2, -1, "com.box.android.base.presentation.watermarking.WatermarkingDisabledReasonText (WatermarkingScreen.kt:305)");
            }
            if (Intrinsics.areEqual(watermarkingDisabledReason, WatermarkingReducer.WatermarkingDisabledReason.EnabledAtParentLevel.INSTANCE)) {
                composerStartRestartGroup.startReplaceGroup(-1865052430);
                ComposerKt.sourceInformation(composerStartRestartGroup, "308@11390L59");
                strStringResource = StringResources_androidKt.stringResource(R.string.watermarking_disabled_parent_level, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else if (Intrinsics.areEqual(watermarkingDisabledReason, WatermarkingReducer.WatermarkingDisabledReason.EnforcedByAccessPolicy.INSTANCE)) {
                composerStartRestartGroup.startReplaceGroup(-1865047501);
                ComposerKt.sourceInformation(composerStartRestartGroup, "311@11544L60");
                strStringResource = StringResources_androidKt.stringResource(R.string.watermarking_disabled_access_policy, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else if (Intrinsics.areEqual(watermarkingDisabledReason, WatermarkingReducer.WatermarkingDisabledReason.NotSupportedForFileType.INSTANCE)) {
                composerStartRestartGroup.startReplaceGroup(-1865042509);
                ComposerKt.sourceInformation(composerStartRestartGroup, "314@11700L60");
                strStringResource = StringResources_androidKt.stringResource(R.string.watermarking_disabled_not_supported, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                if (!Intrinsics.areEqual(watermarkingDisabledReason, WatermarkingReducer.WatermarkingDisabledReason.NoPermission.INSTANCE)) {
                    composerStartRestartGroup.startReplaceGroup(-1865055285);
                    composerStartRestartGroup.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
                composerStartRestartGroup.startReplaceGroup(-1865037869);
                ComposerKt.sourceInformation(composerStartRestartGroup, "317@11845L60");
                strStringResource = StringResources_androidKt.stringResource(R.string.watermarking_disabled_no_permission, composerStartRestartGroup, 0);
                composerStartRestartGroup.endReplaceGroup();
            }
            String strStringResource2 = StringResources_androidKt.stringResource(R.string.watermarking_learn_more, composerStartRestartGroup, 0);
            boolean z = watermarkingDisabledReason instanceof WatermarkingReducer.WatermarkingDisabledReason.NotSupportedForFileType;
            composerStartRestartGroup.startReplaceGroup(-1865028922);
            ComposerKt.sourceInformation(composerStartRestartGroup, "*324@12184L6");
            AnnotatedString.Builder builder = new AnnotatedString.Builder(i4, i3, null);
            int iPushStyle = builder.pushStyle(new SpanStyle(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11513getContentSecondary0d7_KjU(), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE, (DefaultConstructorMarker) null));
            try {
                builder.append(strStringResource);
                Unit unit = Unit.INSTANCE;
                builder.pop(iPushStyle);
                if (z) {
                    composerStartRestartGroup.startReplaceGroup(683316613);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "329@12355L6");
                    builder.append(" ");
                    int iPushStyle2 = builder.pushStyle(new SpanStyle(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU(), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (PlatformSpanStyle) null, (DrawStyle) null, WavUtil.TYPE_WAVE_FORMAT_EXTENSIBLE, (DefaultConstructorMarker) null));
                    try {
                        builder.append(strStringResource2);
                        Unit unit2 = Unit.INSTANCE;
                        builder.pop(iPushStyle2);
                    } catch (Throwable th) {
                        builder.pop(iPushStyle2);
                        throw th;
                    }
                } else {
                    composerStartRestartGroup.startReplaceGroup(671128746);
                }
                composerStartRestartGroup.endReplaceGroup();
                AnnotatedString annotatedString = builder.toAnnotatedString();
                composerStartRestartGroup.endReplaceGroup();
                TextKt.m4495TextZ58ophY(annotatedString, TestTagKt.testTag(PaddingKt.m1220paddingVpY3zN4$default(PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, Dp.m9687constructorimpl(8), 0.0f, 0.0f, 13, null), Dp.m9687constructorimpl(16), 0.0f, 2, null), "WatermarkingScreen:DisabledReason"), 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, BoxTheme.INSTANCE.getTypography().getBoxNormal12(), composerStartRestartGroup, 48, 100663296, 262140);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } catch (Throwable th2) {
                builder.pop(iPushStyle);
                throw th2;
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.watermarking.WatermarkingScreenKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WatermarkingScreenKt.WatermarkingDisabledReasonText$lambda$1(watermarkingDisabledReason, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void WatermarkingScreenPreviewFileToggleOff(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1763097525);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(WatermarkingScreenPreviewFileToggleOff)350@12853L466:WatermarkingScreen.kt#9p5c7w");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1763097525, i, -1, "com.box.android.base.presentation.watermarking.WatermarkingScreenPreviewFileToggleOff (WatermarkingScreen.kt:349)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$WatermarkingScreenKt.INSTANCE.m11903getLambda$132901728$base_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.watermarking.WatermarkingScreenKt$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WatermarkingScreenKt.WatermarkingScreenPreviewFileToggleOff$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void WatermarkingScreenPreviewFileToggleOn(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1526118917);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(WatermarkingScreenPreviewFileToggleOn)369@13411L465:WatermarkingScreen.kt#9p5c7w");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1526118917, i, -1, "com.box.android.base.presentation.watermarking.WatermarkingScreenPreviewFileToggleOn (WatermarkingScreen.kt:368)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$WatermarkingScreenKt.INSTANCE.getLambda$466130694$base_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.watermarking.WatermarkingScreenKt$$ExternalSyntheticLambda20
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WatermarkingScreenKt.WatermarkingScreenPreviewFileToggleOn$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void WatermarkingScreenPreviewFolderToggleOn(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1335789075);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(WatermarkingScreenPreviewFolderToggleOn)388@13970L468:WatermarkingScreen.kt#9p5c7w");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1335789075, i, -1, "com.box.android.base.presentation.watermarking.WatermarkingScreenPreviewFolderToggleOn (WatermarkingScreen.kt:387)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$WatermarkingScreenKt.INSTANCE.getLambda$1955640376$base_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.watermarking.WatermarkingScreenKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WatermarkingScreenKt.WatermarkingScreenPreviewFolderToggleOn$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void WatermarkingScreenPreviewDisabledParentLevel(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1445144650);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(WatermarkingScreenPreviewDisabledParentLevel)407@14537L566:WatermarkingScreen.kt#9p5c7w");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1445144650, i, -1, "com.box.android.base.presentation.watermarking.WatermarkingScreenPreviewDisabledParentLevel (WatermarkingScreen.kt:406)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$WatermarkingScreenKt.INSTANCE.getLambda$1348707551$base_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.watermarking.WatermarkingScreenKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WatermarkingScreenKt.WatermarkingScreenPreviewDisabledParentLevel$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void WatermarkingScreenPreviewDisabledAccessPolicy(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(2027557086);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(WatermarkingScreenPreviewDisabledAccessPolicy)427@15203L568:WatermarkingScreen.kt#9p5c7w");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2027557086, i, -1, "com.box.android.base.presentation.watermarking.WatermarkingScreenPreviewDisabledAccessPolicy (WatermarkingScreen.kt:426)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$WatermarkingScreenKt.INSTANCE.m11905getLambda$961992983$base_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.watermarking.WatermarkingScreenKt$$ExternalSyntheticLambda18
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WatermarkingScreenKt.WatermarkingScreenPreviewDisabledAccessPolicy$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void WatermarkingScreenPreviewNotSupported(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(1899430183);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(WatermarkingScreenPreviewNotSupported)448@15872L571:WatermarkingScreen.kt#9p5c7w");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1899430183, i, -1, "com.box.android.base.presentation.watermarking.WatermarkingScreenPreviewNotSupported (WatermarkingScreen.kt:447)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$WatermarkingScreenKt.INSTANCE.m11904getLambda$403287502$base_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.watermarking.WatermarkingScreenKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return WatermarkingScreenKt.WatermarkingScreenPreviewNotSupported$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final WatermarkingReducer.State WatermarkingScreen$lambda$0(State<? extends WatermarkingReducer.State> state) {
        return state.getValue();
    }
}

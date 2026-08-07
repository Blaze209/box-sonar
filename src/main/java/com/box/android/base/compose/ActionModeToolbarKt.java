package com.box.android.base.compose;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.IconButtonColors;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.text.style.TextOverflow;
import com.box.android.base.R;
import com.box.android.base.compose.button.BoxIconButtonKt;
import com.box.android.base.compose.button.model.ButtonItem;
import com.box.android.base.compose.button.model.ButtonItemKt;
import com.box.android.base.compose.popup.BoxPopupMenuKt;
import com.box.android.base.compose.popup.model.PopupMenuItem;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: ActionModeToolbar.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\u001a;\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0002\u0010\u000b\u001a\r\u0010\f\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\r\u001a\r\u0010\u000e\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\r¨\u0006\u000f²\u0006\n\u0010\u0010\u001a\u00020\nX\u008a\u008e\u0002"}, d2 = {"ActionModeToolbar", "", "title", "", "onClose", "Lkotlin/Function0;", "menuActions", "", "Lcom/box/android/base/compose/button/model/ButtonItem;", "isRedesignedVersion", "", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Ljava/util/List;ZLandroidx/compose/runtime/Composer;II)V", "ActionModeToolbarPreview", "(Landroidx/compose/runtime/Composer;I)V", "RedesignedActionModeToolbarPreview", "base_generalProdRelease", "showMenu"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ActionModeToolbarKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ActionModeToolbar$lambda$4(String str, Function0 function0, List list, boolean z, int i, int i2, Composer composer, int i3) {
        ActionModeToolbar(str, function0, list, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ActionModeToolbarPreview$lambda$0(int i, Composer composer, int i2) {
        ActionModeToolbarPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RedesignedActionModeToolbarPreview$lambda$0(int i, Composer composer, int i2) {
        RedesignedActionModeToolbarPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x007b  */
    /* JADX WARN: Code duplicated, block: B:38:0x007d  */
    /* JADX WARN: Code duplicated, block: B:41:0x0086 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:42:0x0088  */
    /* JADX WARN: Code duplicated, block: B:43:0x008a  */
    /* JADX WARN: Code duplicated, block: B:46:0x0091  */
    /* JADX WARN: Code duplicated, block: B:49:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:52:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:53:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:56:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:57:0x0106  */
    /* JADX WARN: Code duplicated, block: B:60:0x0120  */
    /* JADX WARN: Code duplicated, block: B:61:0x0136  */
    /* JADX WARN: Code duplicated, block: B:64:0x0173  */
    /* JADX WARN: Code duplicated, block: B:65:0x0177  */
    /* JADX WARN: Code duplicated, block: B:68:0x0182  */
    /* JADX WARN: Code duplicated, block: B:70:? A[RETURN, SYNTHETIC] */
    public static final void ActionModeToolbar(final String title, final Function0<Unit> onClose, final List<? extends ButtonItem> menuActions, boolean z, Composer composer, final int i, final int i2) {
        int i3;
        boolean z2;
        boolean z3;
        Composer composer2;
        boolean z4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Object objRememberedValue;
        long jM11575getTopBarBackground0d7_KjU;
        final long jM11579getTopBarText0d7_KjU;
        long jM11577getTopBarControl0d7_KjU;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(onClose, "onClose");
        Intrinsics.checkNotNullParameter(menuActions, "menuActions");
        Composer composerStartRestartGroup = composer.startRestartGroup(-17184781);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ActionModeToolbar)N(title,onClose,menuActions,isRedesignedVersion)39@1606L34,46@2030L2398,46@2004L2424:ActionModeToolbar.kt#vejmn0");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(title) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onClose) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(menuActions) ? 256 : 128;
        }
        int i4 = i2 & 8;
        if (i4 == 0) {
            if ((i & 3072) == 0) {
                z2 = z;
                i3 |= composerStartRestartGroup.changed(z2) ? 2048 : 1024;
            }
            if ((i3 & 1171) != 1170) {
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
                    z4 = false;
                } else {
                    z4 = z2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-17184781, i3, -1, "com.box.android.base.compose.ActionModeToolbar (ActionModeToolbar.kt:38)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 665300021, "CC(remember):ActionModeToolbar.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                final MutableState mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (z4) {
                    composerStartRestartGroup.startReplaceGroup(665303584);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "41@1711L6");
                    jM11575getTopBarBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
                } else {
                    composerStartRestartGroup.startReplaceGroup(665304707);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "41@1746L6");
                    jM11575getTopBarBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11575getTopBarBackground0d7_KjU();
                }
                composerStartRestartGroup.endReplaceGroup();
                if (z4) {
                    composerStartRestartGroup.startReplaceGroup(665307488);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "43@1833L6");
                    jM11579getTopBarText0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11572getTextFieldText0d7_KjU();
                } else {
                    composerStartRestartGroup.startReplaceGroup(665308605);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "43@1868L6");
                    jM11579getTopBarText0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11579getTopBarText0d7_KjU();
                }
                composerStartRestartGroup.endReplaceGroup();
                if (z4) {
                    composerStartRestartGroup.startReplaceGroup(665311133);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "45@1947L6");
                    jM11577getTopBarControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU();
                } else {
                    composerStartRestartGroup.startReplaceGroup(665312160);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "45@1979L6");
                    jM11577getTopBarControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11577getTopBarControl0d7_KjU();
                }
                composerStartRestartGroup.endReplaceGroup();
                final long j = jM11577getTopBarControl0d7_KjU;
                final long j2 = jM11575getTopBarBackground0d7_KjU;
                composer2 = composerStartRestartGroup;
                CustomRippleConfigurationKt.m11643CustomRippleConfiguration3JVO9M(0L, ComposableLambdaKt.rememberComposableLambda(972133020, true, new Function2() { // from class: com.box.android.base.compose.ActionModeToolbarKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ActionModeToolbarKt.ActionModeToolbar$lambda$3(j2, j, jM11579getTopBarText0d7_KjU, title, onClose, menuActions, mutableState, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, 48, 1);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final boolean z5 = z4;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.ActionModeToolbarKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ActionModeToolbarKt.ActionModeToolbar$lambda$4(title, onClose, menuActions, z5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
            z4 = z2;
        } else {
            if (i4 != 0) {
                z4 = false;
            } else {
                z4 = z2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-17184781, i3, -1, "com.box.android.base.compose.ActionModeToolbar (ActionModeToolbar.kt:38)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 665300021, "CC(remember):ActionModeToolbar.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (z4) {
                composerStartRestartGroup.startReplaceGroup(665303584);
                ComposerKt.sourceInformation(composerStartRestartGroup, "41@1711L6");
                jM11575getTopBarBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU();
            } else {
                composerStartRestartGroup.startReplaceGroup(665304707);
                ComposerKt.sourceInformation(composerStartRestartGroup, "41@1746L6");
                jM11575getTopBarBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11575getTopBarBackground0d7_KjU();
            }
            composerStartRestartGroup.endReplaceGroup();
            if (z4) {
                composerStartRestartGroup.startReplaceGroup(665307488);
                ComposerKt.sourceInformation(composerStartRestartGroup, "43@1833L6");
                jM11579getTopBarText0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11572getTextFieldText0d7_KjU();
            } else {
                composerStartRestartGroup.startReplaceGroup(665308605);
                ComposerKt.sourceInformation(composerStartRestartGroup, "43@1868L6");
                jM11579getTopBarText0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11579getTopBarText0d7_KjU();
            }
            composerStartRestartGroup.endReplaceGroup();
            if (z4) {
                composerStartRestartGroup.startReplaceGroup(665311133);
                ComposerKt.sourceInformation(composerStartRestartGroup, "45@1947L6");
                jM11577getTopBarControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU();
            } else {
                composerStartRestartGroup.startReplaceGroup(665312160);
                ComposerKt.sourceInformation(composerStartRestartGroup, "45@1979L6");
                jM11577getTopBarControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11577getTopBarControl0d7_KjU();
            }
            composerStartRestartGroup.endReplaceGroup();
            final long j3 = jM11577getTopBarControl0d7_KjU;
            final long j4 = jM11575getTopBarBackground0d7_KjU;
            composer2 = composerStartRestartGroup;
            CustomRippleConfigurationKt.m11643CustomRippleConfiguration3JVO9M(0L, ComposableLambdaKt.rememberComposableLambda(972133020, true, new Function2() { // from class: com.box.android.base.compose.ActionModeToolbarKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ActionModeToolbarKt.ActionModeToolbar$lambda$3(j4, j3, jM11579getTopBarText0d7_KjU, title, onClose, menuActions, mutableState2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, 48, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final boolean z6 = z4;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.ActionModeToolbarKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ActionModeToolbarKt.ActionModeToolbar$lambda$4(title, onClose, menuActions, z6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean ActionModeToolbar$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void ActionModeToolbar$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ActionModeToolbar$lambda$3(long j, final long j2, final long j3, final String str, final Function0 function0, final List list, final MutableState mutableState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C48@2071L209,56@2311L287,65@2622L1454,98@4117L295,47@2040L2382:ActionModeToolbar.kt#vejmn0");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(972133020, i, -1, "com.box.android.base.compose.ActionModeToolbar.<anonymous> (ActionModeToolbar.kt:47)");
            }
            AppBarKt.m2784TopAppBarGHTll3U(ComposableLambdaKt.rememberComposableLambda(-1329710240, true, new Function2() { // from class: com.box.android.base.compose.ActionModeToolbarKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ActionModeToolbarKt.ActionModeToolbar$lambda$3$0(str, j3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, ComposableLambdaKt.rememberComposableLambda(1179853794, true, new Function2() { // from class: com.box.android.base.compose.ActionModeToolbarKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ActionModeToolbarKt.ActionModeToolbar$lambda$3$1(function0, j2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), ComposableLambdaKt.rememberComposableLambda(1659166155, true, new Function3() { // from class: com.box.android.base.compose.ActionModeToolbarKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ActionModeToolbarKt.ActionModeToolbar$lambda$3$2(list, j2, mutableState, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), 0.0f, null, TopAppBarDefaults.INSTANCE.m4782topAppBarColors5tl4gsc(j, j, j2, j3, j2, 0L, composer, TopAppBarDefaults.$stable << 18, 32), null, composer, 3462, 178);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ActionModeToolbar$lambda$3$0(String str, long j, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C49@2089L177:ActionModeToolbar.kt#vejmn0");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1329710240, i, -1, "com.box.android.base.compose.ActionModeToolbar.<anonymous>.<anonymous> (ActionModeToolbar.kt:49)");
            }
            TextKt.m4494TextNvy7gAk(str, null, j, null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, null, composer, 0, 24960, 241658);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ActionModeToolbar$lambda$3$1(Function0 function0, final long j, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C57@2359L225,57@2329L255:ActionModeToolbar.kt#vejmn0");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1179853794, i, -1, "com.box.android.base.compose.ActionModeToolbar.<anonymous>.<anonymous> (ActionModeToolbar.kt:57)");
            }
            IconButtonKt.IconButton((Function0<Unit>) function0, (Modifier) null, false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-1074531328, true, new Function2() { // from class: com.box.android.base.compose.ActionModeToolbarKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ActionModeToolbarKt.ActionModeToolbar$lambda$3$1$0(j, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 1572864, 62);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ActionModeToolbar$lambda$3$1$0(long j, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C59@2411L41,58@2381L185:ActionModeToolbar.kt#vejmn0");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1074531328, i, -1, "com.box.android.base.compose.ActionModeToolbar.<anonymous>.<anonymous>.<anonymous> (ActionModeToolbar.kt:58)");
            }
            IconKt.m3575Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.ic_close_24dp, composer, 0), (String) null, (Modifier) null, j, composer, Painter.$stable | 48, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ActionModeToolbar$lambda$3$2(List list, final long j, final MutableState mutableState, RowScope TopAppBar, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(TopAppBar, "$this$TopAppBar");
        ComposerKt.sourceInformation(composer, "C72@2928L1134:ActionModeToolbar.kt#vejmn0");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1659166155, i, -1, "com.box.android.base.compose.ActionModeToolbar.<anonymous>.<anonymous> (ActionModeToolbar.kt:66)");
            }
            composer.startReplaceGroup(1025810970);
            ComposerKt.sourceInformation(composer, "*67@2734L159");
            List list2 = list;
            ArrayList arrayList = new ArrayList();
            for (Object obj : list2) {
                if (obj instanceof ButtonItem.BadgedIconButtonItem) {
                    arrayList.add(obj);
                }
            }
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                BoxIconButtonKt.m11681BoxIconButtonuDo3WH8(ButtonItem.IconButtonItem.copy$default(ButtonItemKt.toIconButtonItem((ButtonItem.BadgedIconButtonItem) it.next()), true, null, null, null, false, 30, null), null, null, j, 0.0f, composer, 0, 22);
            }
            composer.endReplaceGroup();
            Alignment topEnd = Alignment.INSTANCE.getTopEnd();
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(topEnd, false);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1908022495, "C74@3037L24,75@3084L331,73@2991L424,85@3531L20,83@3436L608:ActionModeToolbar.kt#vejmn0");
            ComposerKt.sourceInformationMarkerStart(composer, -1308474659, "CC(remember):ActionModeToolbar.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.base.compose.ActionModeToolbarKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ActionModeToolbarKt.ActionModeToolbar$lambda$3$2$1$0$0(mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            IconButtonKt.IconButton((Function0<Unit>) objRememberedValue, (Modifier) null, false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(1836641703, true, new Function2() { // from class: com.box.android.base.compose.ActionModeToolbarKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return ActionModeToolbarKt.ActionModeToolbar$lambda$3$2$1$1(j, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 1572870, 62);
            boolean zActionModeToolbar$lambda$1 = ActionModeToolbar$lambda$1(mutableState);
            ComposerKt.sourceInformationMarkerStart(composer, -1308458855, "CC(remember):ActionModeToolbar.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.base.compose.ActionModeToolbarKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ActionModeToolbarKt.ActionModeToolbar$lambda$3$2$1$2$0(mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Function0 function0 = (Function0) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.startReplaceGroup(-1308454788);
            ComposerKt.sourceInformation(composer, "*89@3814L152");
            ArrayList arrayList2 = new ArrayList();
            for (Object obj2 : list2) {
                if (obj2 instanceof ButtonItem.TextButtonItem) {
                    arrayList2.add(obj2);
                }
            }
            ArrayList<ButtonItem.TextButtonItem> arrayList3 = arrayList2;
            ArrayList arrayList4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(arrayList3, 10));
            for (final ButtonItem.TextButtonItem textButtonItem : arrayList3) {
                int textRes = textButtonItem.getTextRes();
                ComposerKt.sourceInformationMarkerStart(composer, 2002407792, "CC(remember):ActionModeToolbar.kt#9igjgp");
                boolean zChanged = composer.changed(textButtonItem);
                Object objRememberedValue3 = composer.rememberedValue();
                if (zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function0() { // from class: com.box.android.base.compose.ActionModeToolbarKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return ActionModeToolbarKt.ActionModeToolbar$lambda$3$2$1$3$0$0(textButtonItem, mutableState);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                arrayList4.add(new PopupMenuItem(textRes, (Function0) objRememberedValue3, (PaddingValues) null, false, 12, (DefaultConstructorMarker) null));
            }
            composer.endReplaceGroup();
            BoxPopupMenuKt.m11733BoxPopupMenuUTokNlU(zActionModeToolbar$lambda$1, function0, arrayList4, null, null, 0L, composer, 48, 56);
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
    public static final Unit ActionModeToolbar$lambda$3$2$1$0$0(MutableState mutableState) {
        ActionModeToolbar$lambda$2(mutableState, !ActionModeToolbar$lambda$1(mutableState));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ActionModeToolbar$lambda$3$2$1$1(long j, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C77@3144L44,76@3110L283:ActionModeToolbar.kt#vejmn0");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1836641703, i, -1, "com.box.android.base.compose.ActionModeToolbar.<anonymous>.<anonymous>.<anonymous>.<anonymous> (ActionModeToolbar.kt:76)");
            }
            IconKt.m3575Iconww6aTOc(PainterResources_androidKt.painterResource(R.drawable.ic_menu_overflow, composer, 0), (String) null, TestTagKt.testTag(Modifier.INSTANCE, "OverflowMenuButton"), j, composer, Painter.$stable | 432, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ActionModeToolbar$lambda$3$2$1$2$0(MutableState mutableState) {
        ActionModeToolbar$lambda$2(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ActionModeToolbar$lambda$3$2$1$3$0$0(ButtonItem.TextButtonItem textButtonItem, MutableState mutableState) {
        textButtonItem.getOnClick().invoke();
        ActionModeToolbar$lambda$2(mutableState, false);
        return Unit.INSTANCE;
    }

    private static final void ActionModeToolbarPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-2036475726);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ActionModeToolbarPreview)114@4560L315:ActionModeToolbar.kt#vejmn0");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2036475726, i, -1, "com.box.android.base.compose.ActionModeToolbarPreview (ActionModeToolbar.kt:113)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$ActionModeToolbarKt.INSTANCE.getLambda$1699485117$base_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.ActionModeToolbarKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ActionModeToolbarKt.ActionModeToolbarPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void RedesignedActionModeToolbarPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1839072766);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RedesignedActionModeToolbarPreview)131@4964L355:ActionModeToolbar.kt#vejmn0");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1839072766, i, -1, "com.box.android.base.compose.RedesignedActionModeToolbarPreview (ActionModeToolbar.kt:130)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$ActionModeToolbarKt.INSTANCE.getLambda$1409000781$base_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.ActionModeToolbarKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ActionModeToolbarKt.RedesignedActionModeToolbarPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}

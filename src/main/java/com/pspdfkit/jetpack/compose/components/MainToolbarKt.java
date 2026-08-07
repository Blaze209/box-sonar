package com.pspdfkit.jetpack.compose.components;

import android.content.res.Resources;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.material3.AndroidMenu_androidKt;
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
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.ZIndexModifierKt;
import androidx.compose.ui.draw.ShadowKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.media3.common.C;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.react.uimanager.ViewProps;
import com.pspdfkit.R;
import com.pspdfkit.compose.theme.UiColorScheme;
import com.pspdfkit.compose.theme.UiTheme;
import com.pspdfkit.compose.theme.UiThemeKt;
import com.pspdfkit.configuration.activity.PdfActivityConfiguration;
import com.pspdfkit.internal.bv;
import com.pspdfkit.internal.cv;
import com.pspdfkit.internal.e2;
import com.pspdfkit.internal.f2;
import com.pspdfkit.internal.gc;
import com.pspdfkit.jetpack.compose.interactors.DocumentState;
import com.pspdfkit.ui.PdfActivity;
import external.sdk.pendo.io.mozilla.javascript.Token;
import io.nutrient.ui.theme.ThemeWrapperKt;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000|\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010 \n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a\u008a\u0002\u0010\u001c\u001a\u00020\n2\b\b\u0002\u0010\u0001\u001a\u00020\u00002\u0006\u0010\u0003\u001a\u00020\u00022\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0007\u001a\u00020\u00062\u001b\b\u0002\u0010\f\u001a\u0015\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\b¢\u0006\u0002\b\u000b2(\b\u0002\u0010\u0011\u001a\"\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\n0\b¢\u0006\u0002\b\u000b23\b\u0002\u0010\u0015\u001a-\u0012\u0004\u0012\u00020\u0013\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\n0\u0012¢\u0006\u0002\b\u000b¢\u0006\u0002\b\u001425\b\u0002\u0010\u0017\u001a/\u0012\u0004\u0012\u00020\u0016\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\n\u0018\u00010\u0012¢\u0006\u0002\b\u000b¢\u0006\u0002\b\u00142\b\b\u0002\u0010\u0019\u001a\u00020\u00182\u0016\b\u0002\u0010\u001b\u001a\u0010\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\n\u0018\u00010\bH\u0007¢\u0006\u0004\b\u001c\u0010\u001d\u001a\u0082\u0001\u0010&\u001a\u00020\n2\u0006\u0010\u001e\u001a\u00020\u00182\f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u001a0\u001f21\u0010\u0017\u001a-\u0012\u0004\u0012\u00020\u0016\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\n0\u0012¢\u0006\u0002\b\u000b¢\u0006\u0002\b\u00142\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\n0!2\u0006\u0010$\u001a\u00020#2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020\u001a\u0012\u0004\u0012\u00020\n0\bH\u0003¢\u0006\u0004\b&\u0010'\u001a)\u0010+\u001a\u00020\n2\u0006\u0010(\u001a\u00020\u00182\b\u0010)\u001a\u0004\u0018\u00010\t2\u0006\u0010$\u001a\u00020*H\u0003¢\u0006\u0004\b+\u0010,\u001a\u0019\u0010-\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001f*\u00020#H\u0002¢\u0006\u0004\b-\u0010.\u001a\u0019\u0010/\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001f*\u00020#H\u0002¢\u0006\u0004\b/\u0010.¨\u00067²\u0006\u000e\u0010\u001e\u001a\u00020\u00188\n@\nX\u008a\u008e\u0002²\u0006\f\u00100\u001a\u00020#8\nX\u008a\u0084\u0002²\u0006\f\u00102\u001a\u0002018\nX\u008a\u0084\u0002²\u0006\f\u00103\u001a\u00020\t8\nX\u008a\u0084\u0002²\u0006\f\u0010(\u001a\u00020\u00188\nX\u008a\u0084\u0002²\u0006\u000e\u00104\u001a\u00020\u001a8\n@\nX\u008a\u008e\u0002²\u0006\u0012\u00105\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001f8\nX\u008a\u0084\u0002²\u0006\u0012\u00106\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001f8\nX\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/ui/Modifier;", "modifier", "Lcom/pspdfkit/jetpack/compose/interactors/DocumentState;", "documentState", "Lcom/pspdfkit/compose/theme/UiColorScheme;", "colorScheme", "Landroidx/compose/foundation/layout/WindowInsets;", "windowInsets", "Lkotlin/Function1;", "", "", "Landroidx/compose/runtime/Composable;", "customTitle", "Landroidx/compose/ui/graphics/Color;", "Lkotlin/ParameterName;", "name", "tintColor", "navigationIcon", "Lkotlin/Function2;", "Landroidx/compose/foundation/layout/RowScope;", "Lkotlin/ExtensionFunctionType;", "actions", "Landroidx/compose/foundation/layout/ColumnScope;", "overFlowActions", "", "showTitleBar", "", "onHeightChanged", "MainToolbar", "(Landroidx/compose/ui/Modifier;Lcom/pspdfkit/jetpack/compose/interactors/DocumentState;Lcom/pspdfkit/compose/theme/UiColorScheme;Landroidx/compose/foundation/layout/WindowInsets;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function3;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function4;ZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "expanded", "", "menuItems", "Lkotlin/Function0;", "onDismissRequest", "Lcom/pspdfkit/internal/bv;", "configuration", ViewProps.ON_CLICK, "DropDownBox", "(ZLjava/util/List;Lkotlin/jvm/functions/Function4;Lkotlin/jvm/functions/Function0;Lcom/pspdfkit/internal/bv;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "titleInActionBar", "title", "Lcom/pspdfkit/configuration/activity/PdfActivityConfiguration;", "TitleBar", "(ZLjava/lang/String;Lcom/pspdfkit/configuration/activity/PdfActivityConfiguration;Landroidx/compose/runtime/Composer;I)V", "getActionMenu", "(Lcom/pspdfkit/internal/bv;)Ljava/util/List;", "getHiddenMenu", "menuConfiguration", "Lcom/pspdfkit/internal/bv$a;", "activeView", "titleName", "toolbarHeight", "actionIcons", "overFlowIcons", "sdk-nutrient"}, k = 2, mv = {2, 3, 0}, xi = 48)
public final class MainToolbarKt {
    private static final void DropDownBox(final boolean z, final List<Integer> list, final Function4<? super ColumnScope, ? super Color, ? super Composer, ? super Integer, Unit> function4, final Function0<Unit> function0, final bv bvVar, final Function1<? super Integer, Unit> function1, Composer composer, final int i) {
        int i2;
        Function0<Unit> function2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1574925320);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(list) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function4) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            function2 = function0;
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 2048 : 1024;
        } else {
            function2 = function0;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(bvVar) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 131072 : 65536;
        }
        if (composerStartRestartGroup.shouldExecute((74899 & i2) != 74898, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1574925320, i2, -1, "com.pspdfkit.jetpack.compose.components.DropDownBox (MainToolbar.kt:232)");
            }
            composer2 = composerStartRestartGroup;
            AndroidMenu_androidKt.m2743DropdownMenuIlH_yew(z, function2, BackgroundKt.m589backgroundbw27NRU$default(Modifier.INSTANCE, UiTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getMainToolbar().getPopup().m13965getBackgroundColor0d7_KjU(), null, 2, null), 0L, null, null, null, 0L, 0.0f, 0.0f, null, ComposableLambdaKt.rememberComposableLambda(2116937971, true, new Function3() { // from class: com.pspdfkit.jetpack.compose.components.MainToolbarKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return MainToolbarKt.DropDownBox$lambda$0(list, function4, bvVar, function1, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, (i2 & 14) | ((i2 >> 6) & 112), 48, 2040);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.jetpack.compose.components.MainToolbarKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MainToolbarKt.DropDownBox$lambda$1(z, list, function4, function0, bvVar, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropDownBox$lambda$0(List list, Function4 function4, final bv bvVar, final Function1 function1, ColumnScope columnScope, Composer composer, int i) {
        columnScope.getClass();
        int i2 = (i & 6) == 0 ? i | (composer.changed(columnScope) ? 4 : 2) : i;
        int i3 = 0;
        boolean z = true;
        if (composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2116937971, i2, -1, "com.pspdfkit.jetpack.compose.components.DropDownBox.<anonymous> (MainToolbar.kt:238)");
            }
            composer.startReplaceGroup(-1437106658);
            for (Object obj : list) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                final int iIntValue = ((Number) obj).intValue();
                ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(1769612379, z, new Function2() { // from class: com.pspdfkit.jetpack.compose.components.MainToolbarKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return MainToolbarKt.DropDownBox$lambda$0$0$0(bvVar, iIntValue, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer, 54);
                boolean zChangedInstance = composer.changedInstance(bvVar) | composer.changed(iIntValue) | composer.changed(function1);
                Object objRememberedValue = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.pspdfkit.jetpack.compose.components.MainToolbarKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return MainToolbarKt.DropDownBox$lambda$0$0$1$0(bvVar, iIntValue, function1);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                AndroidMenu_androidKt.DropdownMenuItem(composableLambdaRememberComposableLambda, (Function0) objRememberedValue, null, ComposableLambdaKt.rememberComposableLambda(1701603832, z, new Function2() { // from class: com.pspdfkit.jetpack.compose.components.MainToolbarKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj2, Object obj3) {
                        return MainToolbarKt.DropDownBox$lambda$0$0$2(bvVar, iIntValue, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer, 54), null, false, null, null, null, composer, 3078, 500);
                i3 = i4;
                z = z;
            }
            composer.endReplaceGroup();
            function4.invoke(columnScope, Color.m6804boximpl(ColorKt.Color(bvVar.c.b)), composer, Integer.valueOf(i2 & 14));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropDownBox$lambda$0$0$0(bv bvVar, int i, Composer composer, int i2) {
        if (composer.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1769612379, i2, -1, "com.pspdfkit.jetpack.compose.components.DropDownBox.<anonymous>.<anonymous>.<anonymous> (MainToolbar.kt:246)");
            }
            String strB = bvVar.b(i);
            if (strB == null) {
                strB = "";
            }
            TextKt.m4494TextNvy7gAk(strB, null, UiTheme.INSTANCE.getColors(composer, 6).getMainToolbar().m13943getTextColor0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 262138);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropDownBox$lambda$0$0$1$0(bv bvVar, int i, Function1 function1) {
        if (bvVar.d(i)) {
            function1.invoke(Integer.valueOf(i));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropDownBox$lambda$0$0$2(bv bvVar, int i, Composer composer, int i2) {
        if (composer.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1701603832, i2, -1, "com.pspdfkit.jetpack.compose.components.DropDownBox.<anonymous>.<anonymous>.<anonymous> (MainToolbar.kt:252)");
            }
            ImageKt.Image(PainterResources_androidKt.painterResource(bvVar.a(i), composer, 0), bvVar.b(i), (Modifier) null, (Alignment) null, (ContentScale) null, 0.0f, ColorFilter.Companion.m6855tintxETnrds$default(ColorFilter.INSTANCE, ColorKt.Color(bvVar.c.b), 0, 2, null), composer, Painter.$stable, 60);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit DropDownBox$lambda$1(boolean z, List list, Function4 function4, Function0 function0, bv bvVar, Function1 function1, int i, Composer composer, int i2) {
        DropDownBox(z, list, function4, function0, bvVar, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x011a  */
    /* JADX WARN: Code duplicated, block: B:102:0x0124  */
    /* JADX WARN: Code duplicated, block: B:103:0x0127  */
    /* JADX WARN: Code duplicated, block: B:108:0x013c  */
    /* JADX WARN: Code duplicated, block: B:109:0x013e  */
    /* JADX WARN: Code duplicated, block: B:112:0x0147  */
    /* JADX WARN: Code duplicated, block: B:114:0x014e  */
    /* JADX WARN: Code duplicated, block: B:124:0x016c A[PHI: r0 r4 r5 r7 r9 r10 r11 r14 r15
      0x016c: PHI (r0v67 kotlin.jvm.functions.Function4<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.ui.graphics.Color, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) = 
      (r0v15 kotlin.jvm.functions.Function4<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.ui.graphics.Color, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>)
      (r0v71 kotlin.jvm.functions.Function4<? super androidx.compose.foundation.layout.ColumnScope, ? super androidx.compose.ui.graphics.Color, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>)
     binds: [B:147:0x01b5, B:123:0x0164] A[DONT_GENERATE, DONT_INLINE]
      0x016c: PHI (r4v16 com.pspdfkit.compose.theme.UiColorScheme) = (r4v4 com.pspdfkit.compose.theme.UiColorScheme), (r4v17 com.pspdfkit.compose.theme.UiColorScheme) binds: [B:147:0x01b5, B:123:0x0164] A[DONT_GENERATE, DONT_INLINE]
      0x016c: PHI (r5v17 boolean) = (r5v5 boolean), (r5v18 boolean) binds: [B:147:0x01b5, B:123:0x0164] A[DONT_GENERATE, DONT_INLINE]
      0x016c: PHI (r7v11 androidx.compose.ui.Modifier) = (r7v6 androidx.compose.ui.Modifier), (r7v3 androidx.compose.ui.Modifier) binds: [B:147:0x01b5, B:123:0x0164] A[DONT_GENERATE, DONT_INLINE]
      0x016c: PHI (r9v16 int) = (r9v8 int), (r9v17 int) binds: [B:147:0x01b5, B:123:0x0164] A[DONT_GENERATE, DONT_INLINE]
      0x016c: PHI (r10v10 androidx.compose.foundation.layout.WindowInsets) = (r10v5 androidx.compose.foundation.layout.WindowInsets), (r10v2 androidx.compose.foundation.layout.WindowInsets) binds: [B:147:0x01b5, B:123:0x0164] A[DONT_GENERATE, DONT_INLINE]
      0x016c: PHI (r11v4 kotlin.jvm.functions.Function3<? super java.lang.String, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) = 
      (r11v2 kotlin.jvm.functions.Function3<? super java.lang.String, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>)
      (r11v5 kotlin.jvm.functions.Function3<? super java.lang.String, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>)
     binds: [B:147:0x01b5, B:123:0x0164] A[DONT_GENERATE, DONT_INLINE]
      0x016c: PHI (r14v8 kotlin.jvm.functions.Function3<? super androidx.compose.ui.graphics.Color, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) = 
      (r14v5 kotlin.jvm.functions.Function3<? super androidx.compose.ui.graphics.Color, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>)
      (r14v3 kotlin.jvm.functions.Function3<? super androidx.compose.ui.graphics.Color, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>)
     binds: [B:147:0x01b5, B:123:0x0164] A[DONT_GENERATE, DONT_INLINE]
      0x016c: PHI (r15v7 kotlin.jvm.functions.Function4<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.ui.graphics.Color, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>) = 
      (r15v5 kotlin.jvm.functions.Function4<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.ui.graphics.Color, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>)
      (r15v8 kotlin.jvm.functions.Function4<? super androidx.compose.foundation.layout.RowScope, ? super androidx.compose.ui.graphics.Color, ? super androidx.compose.runtime.Composer, ? super java.lang.Integer, kotlin.Unit>)
     binds: [B:147:0x01b5, B:123:0x0164] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:125:0x016f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:126:0x0171  */
    /* JADX WARN: Code duplicated, block: B:129:0x0178  */
    /* JADX WARN: Code duplicated, block: B:130:0x0180  */
    /* JADX WARN: Code duplicated, block: B:133:0x0185  */
    /* JADX WARN: Code duplicated, block: B:135:0x0192  */
    /* JADX WARN: Code duplicated, block: B:137:0x0195  */
    /* JADX WARN: Code duplicated, block: B:139:0x019e  */
    /* JADX WARN: Code duplicated, block: B:141:0x01a7  */
    /* JADX WARN: Code duplicated, block: B:142:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:144:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:145:0x01af  */
    /* JADX WARN: Code duplicated, block: B:148:0x01b7  */
    /* JADX WARN: Code duplicated, block: B:151:0x01c1  */
    /* JADX WARN: Code duplicated, block: B:154:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:157:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:158:0x0204  */
    /* JADX WARN: Code duplicated, block: B:161:0x023f  */
    /* JADX WARN: Code duplicated, block: B:163:0x0245  */
    /* JADX WARN: Code duplicated, block: B:165:0x024f  */
    /* JADX WARN: Code duplicated, block: B:171:0x0277  */
    /* JADX WARN: Code duplicated, block: B:174:0x0297  */
    /* JADX WARN: Code duplicated, block: B:177:0x02ba  */
    /* JADX WARN: Code duplicated, block: B:179:0x02c0  */
    /* JADX WARN: Code duplicated, block: B:182:0x02dd  */
    /* JADX WARN: Code duplicated, block: B:184:0x02e3  */
    /* JADX WARN: Code duplicated, block: B:187:0x0305  */
    /* JADX WARN: Code duplicated, block: B:189:0x030b  */
    /* JADX WARN: Code duplicated, block: B:192:0x0358  */
    /* JADX WARN: Code duplicated, block: B:194:0x0365  */
    /* JADX WARN: Code duplicated, block: B:197:0x037d  */
    /* JADX WARN: Code duplicated, block: B:199:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:55:0x0098  */
    /* JADX WARN: Code duplicated, block: B:56:0x009a  */
    /* JADX WARN: Code duplicated, block: B:58:0x009d  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:69:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:79:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:86:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:87:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:89:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:91:0x0101  */
    /* JADX WARN: Code duplicated, block: B:92:0x0104  */
    /* JADX WARN: Code duplicated, block: B:97:0x0113  */
    /* JADX WARN: Code duplicated, block: B:98:0x0116  */
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
    public static final void MainToolbar(Modifier modifier, final DocumentState documentState, UiColorScheme uiColorScheme, WindowInsets windowInsets, Function3<? super String, ? super Composer, ? super Integer, Unit> function3, Function3<? super Color, ? super Composer, ? super Integer, Unit> function4, Function4<? super RowScope, ? super Color, ? super Composer, ? super Integer, Unit> function5, Function4<? super ColumnScope, ? super Color, ? super Composer, ? super Integer, Unit> function6, boolean z, Function1<? super Integer, Unit> function1, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        UiColorScheme uiColorScheme2;
        WindowInsets windowInsets2;
        Function3<? super String, ? super Composer, ? super Integer, Unit> function7;
        int i4;
        final Function3<? super Color, ? super Composer, ? super Integer, Unit> lambda$1623726612$sdk_nutrient;
        int i5;
        int i6;
        Function4<? super RowScope, ? super Color, ? super Composer, ? super Integer, Unit> lambda$1210789952$sdk_nutrient;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int i13;
        boolean z2;
        final Modifier modifier3;
        Composer composer2;
        final UiColorScheme uiColorScheme3;
        final WindowInsets windowInsets3;
        final Function4<? super ColumnScope, ? super Color, ? super Composer, ? super Integer, Unit> function8;
        final boolean z3;
        final Function1<? super Integer, Unit> function2;
        final Function4<? super RowScope, ? super Color, ? super Composer, ? super Integer, Unit> function9;
        final Function3<? super String, ? super Composer, ? super Integer, Unit> function10;
        final Function3<? super Color, ? super Composer, ? super Integer, Unit> function11;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        UiColorScheme uiColors;
        Function4<? super ColumnScope, ? super Color, ? super Composer, ? super Integer, Unit> function12;
        boolean z4;
        final Function4<? super RowScope, ? super Color, ? super Composer, ? super Integer, Unit> function13;
        boolean z5;
        final Function3<? super String, ? super Composer, ? super Integer, Unit> function14;
        int i14;
        Function1<? super Integer, Unit> function15;
        Object objRememberedValue;
        Composer.Companion companion;
        CoroutineScope coroutineScope;
        Object objRememberedValue2;
        CoroutineContext coroutineContext;
        final MutableState mutableState;
        final State stateCollectAsState;
        boolean zChanged;
        Object objRememberedValue3;
        String activityTitle;
        Resources resources;
        Object objRememberedValue4;
        Object objRememberedValue5;
        boolean zChangedInstance;
        Object objRememberedValue6;
        boolean zChanged2;
        Object objRememberedValue7;
        boolean zChanged3;
        Object objRememberedValue8;
        documentState.getClass();
        Composer composerStartRestartGroup = composer.startRestartGroup(-55603716);
        int i15 = i2 & 1;
        if (i15 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(documentState) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                uiColorScheme2 = uiColorScheme;
                int i16 = composerStartRestartGroup.changed(uiColorScheme2) ? 256 : 128;
                i3 |= i16;
            } else {
                uiColorScheme2 = uiColorScheme;
            }
            i3 |= i16;
        } else {
            uiColorScheme2 = uiColorScheme;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                windowInsets2 = windowInsets;
                int i17 = composerStartRestartGroup.changed(windowInsets2) ? 2048 : 1024;
                i3 |= i17;
            } else {
                windowInsets2 = windowInsets;
            }
            i3 |= i17;
        } else {
            windowInsets2 = windowInsets;
        }
        int i18 = i2 & 16;
        if (i18 == 0) {
            if ((i & 24576) == 0) {
                function7 = function3;
                i3 |= composerStartRestartGroup.changedInstance(function7) ? 16384 : 8192;
            }
            i4 = i2 & 32;
            if (i4 != 0) {
                if ((196608 & i) == 0) {
                    lambda$1623726612$sdk_nutrient = function4;
                    if (composerStartRestartGroup.changedInstance(lambda$1623726612$sdk_nutrient)) {
                        i5 = 131072;
                    } else {
                        i5 = 65536;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 64;
                if (i6 != 0) {
                    i3 |= 1572864;
                    lambda$1210789952$sdk_nutrient = function5;
                } else {
                    lambda$1210789952$sdk_nutrient = function5;
                    if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changedInstance(lambda$1210789952$sdk_nutrient)) {
                            i7 = 1048576;
                        } else {
                            i7 = 524288;
                        }
                        i3 |= i7;
                    }
                }
                i8 = i2 & 128;
                if (i8 != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i9 = 8388608;
                    } else {
                        i9 = 4194304;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 256;
                if (i10 != 0) {
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(z)) {
                            i11 = 67108864;
                        } else {
                            i11 = 33554432;
                        }
                        i3 |= i11;
                    }
                    i12 = i2 & 512;
                    if (i12 != 0) {
                        if ((i & 805306368) == 0) {
                            if (composerStartRestartGroup.changedInstance(function1)) {
                                i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                            } else {
                                i13 = 268435456;
                            }
                            i3 |= i13;
                        }
                        if ((i3 & 306783379) != 306783378) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i15 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if ((i2 & 4) != 0) {
                                    uiColors = UiThemeKt.getUiColors(composerStartRestartGroup, 0);
                                    i3 &= -897;
                                } else {
                                    uiColors = uiColorScheme2;
                                }
                                if ((i2 & 8) != 0) {
                                    i3 &= -7169;
                                    windowInsets2 = TopAppBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, TopAppBarDefaults.$stable);
                                }
                                if (i18 != 0) {
                                    function7 = null;
                                }
                                if (i4 != 0) {
                                    lambda$1623726612$sdk_nutrient = ComposableSingletons$MainToolbarKt.INSTANCE.getLambda$1623726612$sdk_nutrient();
                                }
                                if (i6 != 0) {
                                    lambda$1210789952$sdk_nutrient = ComposableSingletons$MainToolbarKt.INSTANCE.getLambda$1210789952$sdk_nutrient();
                                }
                                if (i8 != 0) {
                                    function12 = null;
                                } else {
                                    function12 = function6;
                                }
                                if (i10 != 0) {
                                    z4 = true;
                                } else {
                                    z4 = z;
                                }
                                function13 = lambda$1210789952$sdk_nutrient;
                                z5 = z4;
                                function14 = function7;
                                i14 = i3;
                                if (i12 != 0) {
                                    function15 = null;
                                }
                                composerStartRestartGroup.endDefaults();
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-55603716, i14, -1, "com.pspdfkit.jetpack.compose.components.MainToolbar (MainToolbar.kt:97)");
                                }
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                companion = Composer.INSTANCE;
                                if (objRememberedValue == companion.getEmpty()) {
                                    objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                coroutineScope = (CoroutineScope) objRememberedValue;
                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue2 == companion.getEmpty()) {
                                    coroutineContext = null;
                                    MutableState mutableStateMutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                                    composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default);
                                    objRememberedValue2 = mutableStateMutableStateOf$default;
                                } else {
                                    coroutineContext = null;
                                }
                                mutableState = (MutableState) objRememberedValue2;
                                UiColorScheme uiColorScheme4 = uiColors;
                                final boolean z6 = z5;
                                stateCollectAsState = SnapshotStateKt.collectAsState(documentState.getMenuConfigurationState$sdk_nutrient(), coroutineContext, composerStartRestartGroup, 0, 1);
                                State stateCollectAsState2 = SnapshotStateKt.collectAsState(documentState.getActiveViewState(), coroutineContext, composerStartRestartGroup, 0, 1);
                                bv bvVarMainToolbar$lambda$3 = MainToolbar$lambda$3(stateCollectAsState);
                                bv.a aVarMainToolbar$lambda$4 = MainToolbar$lambda$4(stateCollectAsState2);
                                bvVarMainToolbar$lambda$3.getClass();
                                aVarMainToolbar$lambda$4.getClass();
                                bvVarMainToolbar$lambda$3.e = aVarMainToolbar$lambda$4;
                                zChanged = composerStartRestartGroup.changed(documentState.getTitle());
                                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                if (zChanged || objRememberedValue3 == companion.getEmpty()) {
                                    activityTitle = documentState.getConfiguration().getActivityTitle();
                                    if (activityTitle == null && (activityTitle = documentState.getTitle()) == null) {
                                        activityTitle = "";
                                    }
                                    MutableState mutableStateMutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(activityTitle, null, 2, null);
                                    composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default2);
                                    objRememberedValue3 = mutableStateMutableStateOf$default2;
                                }
                                final MutableState mutableState2 = (MutableState) objRememberedValue3;
                                resources = (Resources) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalResources());
                                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue4 == companion.getEmpty()) {
                                    MutableState mutableStateMutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(resources.getBoolean(R.bool.pspdf__display_document_title_in_actionbar)), null, 2, null);
                                    composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default3);
                                    objRememberedValue4 = mutableStateMutableStateOf$default3;
                                }
                                final MutableState mutableState3 = (MutableState) objRememberedValue4;
                                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue5 == companion.getEmpty()) {
                                    objRememberedValue5 = SnapshotIntStateKt.mutableIntStateOf(0);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                                }
                                final MutableIntState mutableIntState = (MutableIntState) objRememberedValue5;
                                gc customPdfActions = documentState.getCustomPdfActions();
                                zChangedInstance = composerStartRestartGroup.changedInstance(documentState) | composerStartRestartGroup.changedInstance(coroutineScope);
                                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                                if (zChangedInstance || objRememberedValue6 == companion.getEmpty()) {
                                    objRememberedValue6 = new MainToolbarKt$MainToolbar$1$1(documentState, coroutineScope, mutableState, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                                }
                                EffectsKt.LaunchedEffect(customPdfActions, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue6, composerStartRestartGroup, 0);
                                zChanged2 = composerStartRestartGroup.changed(MainToolbar$lambda$3(stateCollectAsState));
                                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                                if (zChanged2 || objRememberedValue7 == companion.getEmpty()) {
                                    MutableState mutableStateMutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getActionMenu(MainToolbar$lambda$3(stateCollectAsState)), null, 2, null);
                                    composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default4);
                                    objRememberedValue7 = mutableStateMutableStateOf$default4;
                                }
                                final MutableState mutableState4 = (MutableState) objRememberedValue7;
                                zChanged3 = composerStartRestartGroup.changed(MainToolbar$lambda$3(stateCollectAsState));
                                objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                                if (zChanged3 || objRememberedValue8 == companion.getEmpty()) {
                                    objRememberedValue8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getHiddenMenu(MainToolbar$lambda$3(stateCollectAsState)), null, 2, null);
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                                }
                                final MutableState mutableState5 = (MutableState) objRememberedValue8;
                                final Modifier modifier4 = modifier2;
                                final Function1<? super Integer, Unit> function16 = function15;
                                final Function4<? super ColumnScope, ? super Color, ? super Composer, ? super Integer, Unit> function17 = function12;
                                windowInsets3 = windowInsets2;
                                ThemeWrapperKt.WithUiTheme(uiColorScheme4, ComposableLambdaKt.rememberComposableLambda(38712441, true, new Function2() { // from class: com.pspdfkit.jetpack.compose.components.MainToolbarKt$$ExternalSyntheticLambda4
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return MainToolbarKt.MainToolbar$lambda$17(function16, mutableIntState, modifier4, windowInsets3, z6, documentState, function17, mutableState, mutableState5, stateCollectAsState, function14, mutableState2, mutableState3, lambda$1623726612$sdk_nutrient, function13, mutableState4, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i14 >> 6) & 14) | 48);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                function2 = function16;
                                modifier3 = modifier4;
                                composer2 = composerStartRestartGroup;
                                uiColorScheme3 = uiColorScheme4;
                                z3 = z6;
                                function8 = function17;
                                function10 = function14;
                                function9 = function13;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 4) != 0) {
                                    i3 &= -897;
                                }
                                if ((i2 & 8) != 0) {
                                    i3 &= -7169;
                                }
                                function12 = function6;
                                function13 = lambda$1210789952$sdk_nutrient;
                                uiColors = uiColorScheme2;
                                function14 = function7;
                                z5 = z;
                                i14 = i3;
                            }
                            function15 = function1;
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-55603716, i14, -1, "com.pspdfkit.jetpack.compose.components.MainToolbar (MainToolbar.kt:97)");
                            }
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            companion = Composer.INSTANCE;
                            if (objRememberedValue == companion.getEmpty()) {
                                objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            coroutineScope = (CoroutineScope) objRememberedValue;
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == companion.getEmpty()) {
                                coroutineContext = null;
                                MutableState mutableStateMutableStateOf$default5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default5);
                                objRememberedValue2 = mutableStateMutableStateOf$default5;
                            } else {
                                coroutineContext = null;
                            }
                            mutableState = (MutableState) objRememberedValue2;
                            UiColorScheme uiColorScheme5 = uiColors;
                            final boolean z7 = z5;
                            stateCollectAsState = SnapshotStateKt.collectAsState(documentState.getMenuConfigurationState$sdk_nutrient(), coroutineContext, composerStartRestartGroup, 0, 1);
                            State stateCollectAsState3 = SnapshotStateKt.collectAsState(documentState.getActiveViewState(), coroutineContext, composerStartRestartGroup, 0, 1);
                            bv bvVarMainToolbar$lambda$4 = MainToolbar$lambda$3(stateCollectAsState);
                            bv.a aVarMainToolbar$lambda$5 = MainToolbar$lambda$4(stateCollectAsState3);
                            bvVarMainToolbar$lambda$4.getClass();
                            aVarMainToolbar$lambda$5.getClass();
                            bvVarMainToolbar$lambda$4.e = aVarMainToolbar$lambda$5;
                            zChanged = composerStartRestartGroup.changed(documentState.getTitle());
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (zChanged) {
                                activityTitle = documentState.getConfiguration().getActivityTitle();
                                if (activityTitle == null) {
                                    activityTitle = "";
                                }
                                MutableState mutableStateMutableStateOf$default6 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(activityTitle, null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default6);
                                objRememberedValue3 = mutableStateMutableStateOf$default6;
                            } else {
                                activityTitle = documentState.getConfiguration().getActivityTitle();
                                if (activityTitle == null) {
                                    activityTitle = "";
                                }
                                MutableState mutableStateMutableStateOf$default7 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(activityTitle, null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default7);
                                objRememberedValue3 = mutableStateMutableStateOf$default7;
                            }
                            final MutableState mutableState6 = (MutableState) objRememberedValue3;
                            resources = (Resources) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalResources());
                            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue4 == companion.getEmpty()) {
                                MutableState mutableStateMutableStateOf$default8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(resources.getBoolean(R.bool.pspdf__display_document_title_in_actionbar)), null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default8);
                                objRememberedValue4 = mutableStateMutableStateOf$default8;
                            }
                            final MutableState mutableState7 = (MutableState) objRememberedValue4;
                            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue5 == companion.getEmpty()) {
                                objRememberedValue5 = SnapshotIntStateKt.mutableIntStateOf(0);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                            }
                            final MutableIntState mutableIntState2 = (MutableIntState) objRememberedValue5;
                            gc customPdfActions2 = documentState.getCustomPdfActions();
                            zChangedInstance = composerStartRestartGroup.changedInstance(documentState) | composerStartRestartGroup.changedInstance(coroutineScope);
                            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                            if (zChangedInstance) {
                                objRememberedValue6 = new MainToolbarKt$MainToolbar$1$1(documentState, coroutineScope, mutableState, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                            } else {
                                objRememberedValue6 = new MainToolbarKt$MainToolbar$1$1(documentState, coroutineScope, mutableState, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                            }
                            EffectsKt.LaunchedEffect(customPdfActions2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue6, composerStartRestartGroup, 0);
                            zChanged2 = composerStartRestartGroup.changed(MainToolbar$lambda$3(stateCollectAsState));
                            objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                            if (zChanged2) {
                                MutableState mutableStateMutableStateOf$default9 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getActionMenu(MainToolbar$lambda$3(stateCollectAsState)), null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default9);
                                objRememberedValue7 = mutableStateMutableStateOf$default9;
                            } else {
                                MutableState mutableStateMutableStateOf$default10 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getActionMenu(MainToolbar$lambda$3(stateCollectAsState)), null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default10);
                                objRememberedValue7 = mutableStateMutableStateOf$default10;
                            }
                            final MutableState mutableState8 = (MutableState) objRememberedValue7;
                            zChanged3 = composerStartRestartGroup.changed(MainToolbar$lambda$3(stateCollectAsState));
                            objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                            if (zChanged3) {
                                objRememberedValue8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getHiddenMenu(MainToolbar$lambda$3(stateCollectAsState)), null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                            } else {
                                objRememberedValue8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getHiddenMenu(MainToolbar$lambda$3(stateCollectAsState)), null, 2, null);
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                            }
                            final MutableState mutableState9 = (MutableState) objRememberedValue8;
                            final Modifier modifier5 = modifier2;
                            final Function1 function18 = function15;
                            final Function4 function19 = function12;
                            windowInsets3 = windowInsets2;
                            ThemeWrapperKt.WithUiTheme(uiColorScheme5, ComposableLambdaKt.rememberComposableLambda(38712441, true, new Function2() { // from class: com.pspdfkit.jetpack.compose.components.MainToolbarKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return MainToolbarKt.MainToolbar$lambda$17(function18, mutableIntState2, modifier5, windowInsets3, z7, documentState, function19, mutableState, mutableState9, stateCollectAsState, function14, mutableState6, mutableState7, lambda$1623726612$sdk_nutrient, function13, mutableState8, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i14 >> 6) & 14) | 48);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            function2 = function18;
                            modifier3 = modifier5;
                            composer2 = composerStartRestartGroup;
                            uiColorScheme3 = uiColorScheme5;
                            z3 = z7;
                            function8 = function19;
                            function10 = function14;
                            function9 = function13;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier3 = modifier2;
                            composer2 = composerStartRestartGroup;
                            uiColorScheme3 = uiColorScheme2;
                            windowInsets3 = windowInsets2;
                            function8 = function6;
                            z3 = z;
                            function2 = function1;
                            function9 = lambda$1210789952$sdk_nutrient;
                            function10 = function7;
                        }
                        function11 = lambda$1623726612$sdk_nutrient;
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.jetpack.compose.components.MainToolbarKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return MainToolbarKt.MainToolbar$lambda$18(modifier3, documentState, uiColorScheme3, windowInsets3, function10, function11, function9, function8, z3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 805306368;
                    if ((i3 & 306783379) != 306783378) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 4) != 0) {
                                uiColors = UiThemeKt.getUiColors(composerStartRestartGroup, 0);
                                i3 &= -897;
                            } else {
                                uiColors = uiColorScheme2;
                            }
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                                windowInsets2 = TopAppBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, TopAppBarDefaults.$stable);
                            }
                            if (i18 != 0) {
                                function7 = null;
                            }
                            if (i4 != 0) {
                                lambda$1623726612$sdk_nutrient = ComposableSingletons$MainToolbarKt.INSTANCE.getLambda$1623726612$sdk_nutrient();
                            }
                            if (i6 != 0) {
                                lambda$1210789952$sdk_nutrient = ComposableSingletons$MainToolbarKt.INSTANCE.getLambda$1210789952$sdk_nutrient();
                            }
                            if (i8 != 0) {
                                function12 = null;
                            } else {
                                function12 = function6;
                            }
                            if (i10 != 0) {
                                z4 = true;
                            } else {
                                z4 = z;
                            }
                            function13 = lambda$1210789952$sdk_nutrient;
                            z5 = z4;
                            function14 = function7;
                            i14 = i3;
                            if (i12 != 0) {
                                function15 = null;
                            } else {
                                function15 = function1;
                            }
                        } else {
                            if (i15 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 4) != 0) {
                                uiColors = UiThemeKt.getUiColors(composerStartRestartGroup, 0);
                                i3 &= -897;
                            } else {
                                uiColors = uiColorScheme2;
                            }
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                                windowInsets2 = TopAppBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, TopAppBarDefaults.$stable);
                            }
                            if (i18 != 0) {
                                function7 = null;
                            }
                            if (i4 != 0) {
                                lambda$1623726612$sdk_nutrient = ComposableSingletons$MainToolbarKt.INSTANCE.getLambda$1623726612$sdk_nutrient();
                            }
                            if (i6 != 0) {
                                lambda$1210789952$sdk_nutrient = ComposableSingletons$MainToolbarKt.INSTANCE.getLambda$1210789952$sdk_nutrient();
                            }
                            if (i8 != 0) {
                                function12 = null;
                            } else {
                                function12 = function6;
                            }
                            if (i10 != 0) {
                                z4 = true;
                            } else {
                                z4 = z;
                            }
                            function13 = lambda$1210789952$sdk_nutrient;
                            z5 = z4;
                            function14 = function7;
                            i14 = i3;
                            if (i12 != 0) {
                                function15 = null;
                            } else {
                                function15 = function1;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-55603716, i14, -1, "com.pspdfkit.jetpack.compose.components.MainToolbar (MainToolbar.kt:97)");
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        companion = Composer.INSTANCE;
                        if (objRememberedValue == companion.getEmpty()) {
                            objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        coroutineScope = (CoroutineScope) objRememberedValue;
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == companion.getEmpty()) {
                            coroutineContext = null;
                            MutableState mutableStateMutableStateOf$default11 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default11);
                            objRememberedValue2 = mutableStateMutableStateOf$default11;
                        } else {
                            coroutineContext = null;
                        }
                        mutableState = (MutableState) objRememberedValue2;
                        UiColorScheme uiColorScheme6 = uiColors;
                        final boolean z8 = z5;
                        stateCollectAsState = SnapshotStateKt.collectAsState(documentState.getMenuConfigurationState$sdk_nutrient(), coroutineContext, composerStartRestartGroup, 0, 1);
                        State stateCollectAsState4 = SnapshotStateKt.collectAsState(documentState.getActiveViewState(), coroutineContext, composerStartRestartGroup, 0, 1);
                        bv bvVarMainToolbar$lambda$5 = MainToolbar$lambda$3(stateCollectAsState);
                        bv.a aVarMainToolbar$lambda$6 = MainToolbar$lambda$4(stateCollectAsState4);
                        bvVarMainToolbar$lambda$5.getClass();
                        aVarMainToolbar$lambda$6.getClass();
                        bvVarMainToolbar$lambda$5.e = aVarMainToolbar$lambda$6;
                        zChanged = composerStartRestartGroup.changed(documentState.getTitle());
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            activityTitle = documentState.getConfiguration().getActivityTitle();
                            if (activityTitle == null) {
                                activityTitle = "";
                            }
                            MutableState mutableStateMutableStateOf$default12 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(activityTitle, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default12);
                            objRememberedValue3 = mutableStateMutableStateOf$default12;
                        } else {
                            activityTitle = documentState.getConfiguration().getActivityTitle();
                            if (activityTitle == null) {
                                activityTitle = "";
                            }
                            MutableState mutableStateMutableStateOf$default13 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(activityTitle, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default13);
                            objRememberedValue3 = mutableStateMutableStateOf$default13;
                        }
                        final MutableState mutableState10 = (MutableState) objRememberedValue3;
                        resources = (Resources) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalResources());
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue4 == companion.getEmpty()) {
                            MutableState mutableStateMutableStateOf$default14 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(resources.getBoolean(R.bool.pspdf__display_document_title_in_actionbar)), null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default14);
                            objRememberedValue4 = mutableStateMutableStateOf$default14;
                        }
                        final MutableState mutableState11 = (MutableState) objRememberedValue4;
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == companion.getEmpty()) {
                            objRememberedValue5 = SnapshotIntStateKt.mutableIntStateOf(0);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        final MutableIntState mutableIntState3 = (MutableIntState) objRememberedValue5;
                        gc customPdfActions3 = documentState.getCustomPdfActions();
                        zChangedInstance = composerStartRestartGroup.changedInstance(documentState) | composerStartRestartGroup.changedInstance(coroutineScope);
                        objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (zChangedInstance) {
                            objRememberedValue6 = new MainToolbarKt$MainToolbar$1$1(documentState, coroutineScope, mutableState, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        } else {
                            objRememberedValue6 = new MainToolbarKt$MainToolbar$1$1(documentState, coroutineScope, mutableState, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        }
                        EffectsKt.LaunchedEffect(customPdfActions3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue6, composerStartRestartGroup, 0);
                        zChanged2 = composerStartRestartGroup.changed(MainToolbar$lambda$3(stateCollectAsState));
                        objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                        if (zChanged2) {
                            MutableState mutableStateMutableStateOf$default15 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getActionMenu(MainToolbar$lambda$3(stateCollectAsState)), null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default15);
                            objRememberedValue7 = mutableStateMutableStateOf$default15;
                        } else {
                            MutableState mutableStateMutableStateOf$default16 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getActionMenu(MainToolbar$lambda$3(stateCollectAsState)), null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default16);
                            objRememberedValue7 = mutableStateMutableStateOf$default16;
                        }
                        final MutableState mutableState12 = (MutableState) objRememberedValue7;
                        zChanged3 = composerStartRestartGroup.changed(MainToolbar$lambda$3(stateCollectAsState));
                        objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                        if (zChanged3) {
                            objRememberedValue8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getHiddenMenu(MainToolbar$lambda$3(stateCollectAsState)), null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                        } else {
                            objRememberedValue8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getHiddenMenu(MainToolbar$lambda$3(stateCollectAsState)), null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                        }
                        final MutableState mutableState13 = (MutableState) objRememberedValue8;
                        final Modifier modifier6 = modifier2;
                        final Function1 function110 = function15;
                        final Function4 function111 = function12;
                        windowInsets3 = windowInsets2;
                        ThemeWrapperKt.WithUiTheme(uiColorScheme6, ComposableLambdaKt.rememberComposableLambda(38712441, true, new Function2() { // from class: com.pspdfkit.jetpack.compose.components.MainToolbarKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return MainToolbarKt.MainToolbar$lambda$17(function110, mutableIntState3, modifier6, windowInsets3, z8, documentState, function111, mutableState, mutableState13, stateCollectAsState, function14, mutableState10, mutableState11, lambda$1623726612$sdk_nutrient, function13, mutableState12, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i14 >> 6) & 14) | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function2 = function110;
                        modifier3 = modifier6;
                        composer2 = composerStartRestartGroup;
                        uiColorScheme3 = uiColorScheme6;
                        z3 = z8;
                        function8 = function111;
                        function10 = function14;
                        function9 = function13;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        composer2 = composerStartRestartGroup;
                        uiColorScheme3 = uiColorScheme2;
                        windowInsets3 = windowInsets2;
                        function8 = function6;
                        z3 = z;
                        function2 = function1;
                        function9 = lambda$1210789952$sdk_nutrient;
                        function10 = function7;
                    }
                    function11 = lambda$1623726612$sdk_nutrient;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.jetpack.compose.components.MainToolbarKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return MainToolbarKt.MainToolbar$lambda$18(modifier3, documentState, uiColorScheme3, windowInsets3, function10, function11, function9, function8, z3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 100663296;
                i12 = i2 & 512;
                if (i12 != 0) {
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(function1)) {
                            i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i13 = 268435456;
                        }
                        i3 |= i13;
                    }
                    if ((i3 & 306783379) != 306783378) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 4) != 0) {
                                uiColors = UiThemeKt.getUiColors(composerStartRestartGroup, 0);
                                i3 &= -897;
                            } else {
                                uiColors = uiColorScheme2;
                            }
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                                windowInsets2 = TopAppBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, TopAppBarDefaults.$stable);
                            }
                            if (i18 != 0) {
                                function7 = null;
                            }
                            if (i4 != 0) {
                                lambda$1623726612$sdk_nutrient = ComposableSingletons$MainToolbarKt.INSTANCE.getLambda$1623726612$sdk_nutrient();
                            }
                            if (i6 != 0) {
                                lambda$1210789952$sdk_nutrient = ComposableSingletons$MainToolbarKt.INSTANCE.getLambda$1210789952$sdk_nutrient();
                            }
                            if (i8 != 0) {
                                function12 = null;
                            } else {
                                function12 = function6;
                            }
                            if (i10 != 0) {
                                z4 = true;
                            } else {
                                z4 = z;
                            }
                            function13 = lambda$1210789952$sdk_nutrient;
                            z5 = z4;
                            function14 = function7;
                            i14 = i3;
                            if (i12 != 0) {
                                function15 = null;
                            } else {
                                function15 = function1;
                            }
                        } else {
                            if (i15 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 4) != 0) {
                                uiColors = UiThemeKt.getUiColors(composerStartRestartGroup, 0);
                                i3 &= -897;
                            } else {
                                uiColors = uiColorScheme2;
                            }
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                                windowInsets2 = TopAppBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, TopAppBarDefaults.$stable);
                            }
                            if (i18 != 0) {
                                function7 = null;
                            }
                            if (i4 != 0) {
                                lambda$1623726612$sdk_nutrient = ComposableSingletons$MainToolbarKt.INSTANCE.getLambda$1623726612$sdk_nutrient();
                            }
                            if (i6 != 0) {
                                lambda$1210789952$sdk_nutrient = ComposableSingletons$MainToolbarKt.INSTANCE.getLambda$1210789952$sdk_nutrient();
                            }
                            if (i8 != 0) {
                                function12 = null;
                            } else {
                                function12 = function6;
                            }
                            if (i10 != 0) {
                                z4 = true;
                            } else {
                                z4 = z;
                            }
                            function13 = lambda$1210789952$sdk_nutrient;
                            z5 = z4;
                            function14 = function7;
                            i14 = i3;
                            if (i12 != 0) {
                                function15 = null;
                            } else {
                                function15 = function1;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-55603716, i14, -1, "com.pspdfkit.jetpack.compose.components.MainToolbar (MainToolbar.kt:97)");
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        companion = Composer.INSTANCE;
                        if (objRememberedValue == companion.getEmpty()) {
                            objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        coroutineScope = (CoroutineScope) objRememberedValue;
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == companion.getEmpty()) {
                            coroutineContext = null;
                            MutableState mutableStateMutableStateOf$default17 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default17);
                            objRememberedValue2 = mutableStateMutableStateOf$default17;
                        } else {
                            coroutineContext = null;
                        }
                        mutableState = (MutableState) objRememberedValue2;
                        UiColorScheme uiColorScheme7 = uiColors;
                        final boolean z9 = z5;
                        stateCollectAsState = SnapshotStateKt.collectAsState(documentState.getMenuConfigurationState$sdk_nutrient(), coroutineContext, composerStartRestartGroup, 0, 1);
                        State stateCollectAsState5 = SnapshotStateKt.collectAsState(documentState.getActiveViewState(), coroutineContext, composerStartRestartGroup, 0, 1);
                        bv bvVarMainToolbar$lambda$6 = MainToolbar$lambda$3(stateCollectAsState);
                        bv.a aVarMainToolbar$lambda$7 = MainToolbar$lambda$4(stateCollectAsState5);
                        bvVarMainToolbar$lambda$6.getClass();
                        aVarMainToolbar$lambda$7.getClass();
                        bvVarMainToolbar$lambda$6.e = aVarMainToolbar$lambda$7;
                        zChanged = composerStartRestartGroup.changed(documentState.getTitle());
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            activityTitle = documentState.getConfiguration().getActivityTitle();
                            if (activityTitle == null) {
                                activityTitle = "";
                            }
                            MutableState mutableStateMutableStateOf$default18 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(activityTitle, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default18);
                            objRememberedValue3 = mutableStateMutableStateOf$default18;
                        } else {
                            activityTitle = documentState.getConfiguration().getActivityTitle();
                            if (activityTitle == null) {
                                activityTitle = "";
                            }
                            MutableState mutableStateMutableStateOf$default19 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(activityTitle, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default19);
                            objRememberedValue3 = mutableStateMutableStateOf$default19;
                        }
                        final MutableState mutableState14 = (MutableState) objRememberedValue3;
                        resources = (Resources) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalResources());
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue4 == companion.getEmpty()) {
                            MutableState mutableStateMutableStateOf$default110 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(resources.getBoolean(R.bool.pspdf__display_document_title_in_actionbar)), null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default110);
                            objRememberedValue4 = mutableStateMutableStateOf$default110;
                        }
                        final MutableState mutableState15 = (MutableState) objRememberedValue4;
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == companion.getEmpty()) {
                            objRememberedValue5 = SnapshotIntStateKt.mutableIntStateOf(0);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        final MutableIntState mutableIntState4 = (MutableIntState) objRememberedValue5;
                        gc customPdfActions4 = documentState.getCustomPdfActions();
                        zChangedInstance = composerStartRestartGroup.changedInstance(documentState) | composerStartRestartGroup.changedInstance(coroutineScope);
                        objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (zChangedInstance) {
                            objRememberedValue6 = new MainToolbarKt$MainToolbar$1$1(documentState, coroutineScope, mutableState, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        } else {
                            objRememberedValue6 = new MainToolbarKt$MainToolbar$1$1(documentState, coroutineScope, mutableState, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        }
                        EffectsKt.LaunchedEffect(customPdfActions4, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue6, composerStartRestartGroup, 0);
                        zChanged2 = composerStartRestartGroup.changed(MainToolbar$lambda$3(stateCollectAsState));
                        objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                        if (zChanged2) {
                            MutableState mutableStateMutableStateOf$default111 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getActionMenu(MainToolbar$lambda$3(stateCollectAsState)), null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default111);
                            objRememberedValue7 = mutableStateMutableStateOf$default111;
                        } else {
                            MutableState mutableStateMutableStateOf$default112 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getActionMenu(MainToolbar$lambda$3(stateCollectAsState)), null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default112);
                            objRememberedValue7 = mutableStateMutableStateOf$default112;
                        }
                        final MutableState mutableState16 = (MutableState) objRememberedValue7;
                        zChanged3 = composerStartRestartGroup.changed(MainToolbar$lambda$3(stateCollectAsState));
                        objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                        if (zChanged3) {
                            objRememberedValue8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getHiddenMenu(MainToolbar$lambda$3(stateCollectAsState)), null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                        } else {
                            objRememberedValue8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getHiddenMenu(MainToolbar$lambda$3(stateCollectAsState)), null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                        }
                        final MutableState mutableState17 = (MutableState) objRememberedValue8;
                        final Modifier modifier7 = modifier2;
                        final Function1 function112 = function15;
                        final Function4 function113 = function12;
                        windowInsets3 = windowInsets2;
                        ThemeWrapperKt.WithUiTheme(uiColorScheme7, ComposableLambdaKt.rememberComposableLambda(38712441, true, new Function2() { // from class: com.pspdfkit.jetpack.compose.components.MainToolbarKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return MainToolbarKt.MainToolbar$lambda$17(function112, mutableIntState4, modifier7, windowInsets3, z9, documentState, function113, mutableState, mutableState17, stateCollectAsState, function14, mutableState14, mutableState15, lambda$1623726612$sdk_nutrient, function13, mutableState16, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i14 >> 6) & 14) | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function2 = function112;
                        modifier3 = modifier7;
                        composer2 = composerStartRestartGroup;
                        uiColorScheme3 = uiColorScheme7;
                        z3 = z9;
                        function8 = function113;
                        function10 = function14;
                        function9 = function13;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        composer2 = composerStartRestartGroup;
                        uiColorScheme3 = uiColorScheme2;
                        windowInsets3 = windowInsets2;
                        function8 = function6;
                        z3 = z;
                        function2 = function1;
                        function9 = lambda$1210789952$sdk_nutrient;
                        function10 = function7;
                    }
                    function11 = lambda$1623726612$sdk_nutrient;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.jetpack.compose.components.MainToolbarKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return MainToolbarKt.MainToolbar$lambda$18(modifier3, documentState, uiColorScheme3, windowInsets3, function10, function11, function9, function8, z3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 805306368;
                if ((i3 & 306783379) != 306783378) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 4) != 0) {
                            uiColors = UiThemeKt.getUiColors(composerStartRestartGroup, 0);
                            i3 &= -897;
                        } else {
                            uiColors = uiColorScheme2;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            windowInsets2 = TopAppBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, TopAppBarDefaults.$stable);
                        }
                        if (i18 != 0) {
                            function7 = null;
                        }
                        if (i4 != 0) {
                            lambda$1623726612$sdk_nutrient = ComposableSingletons$MainToolbarKt.INSTANCE.getLambda$1623726612$sdk_nutrient();
                        }
                        if (i6 != 0) {
                            lambda$1210789952$sdk_nutrient = ComposableSingletons$MainToolbarKt.INSTANCE.getLambda$1210789952$sdk_nutrient();
                        }
                        if (i8 != 0) {
                            function12 = null;
                        } else {
                            function12 = function6;
                        }
                        if (i10 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        function13 = lambda$1210789952$sdk_nutrient;
                        z5 = z4;
                        function14 = function7;
                        i14 = i3;
                        if (i12 != 0) {
                            function15 = null;
                        } else {
                            function15 = function1;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 4) != 0) {
                            uiColors = UiThemeKt.getUiColors(composerStartRestartGroup, 0);
                            i3 &= -897;
                        } else {
                            uiColors = uiColorScheme2;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            windowInsets2 = TopAppBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, TopAppBarDefaults.$stable);
                        }
                        if (i18 != 0) {
                            function7 = null;
                        }
                        if (i4 != 0) {
                            lambda$1623726612$sdk_nutrient = ComposableSingletons$MainToolbarKt.INSTANCE.getLambda$1623726612$sdk_nutrient();
                        }
                        if (i6 != 0) {
                            lambda$1210789952$sdk_nutrient = ComposableSingletons$MainToolbarKt.INSTANCE.getLambda$1210789952$sdk_nutrient();
                        }
                        if (i8 != 0) {
                            function12 = null;
                        } else {
                            function12 = function6;
                        }
                        if (i10 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        function13 = lambda$1210789952$sdk_nutrient;
                        z5 = z4;
                        function14 = function7;
                        i14 = i3;
                        if (i12 != 0) {
                            function15 = null;
                        } else {
                            function15 = function1;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-55603716, i14, -1, "com.pspdfkit.jetpack.compose.components.MainToolbar (MainToolbar.kt:97)");
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.INSTANCE;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    coroutineScope = (CoroutineScope) objRememberedValue;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        coroutineContext = null;
                        MutableState mutableStateMutableStateOf$default113 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default113);
                        objRememberedValue2 = mutableStateMutableStateOf$default113;
                    } else {
                        coroutineContext = null;
                    }
                    mutableState = (MutableState) objRememberedValue2;
                    UiColorScheme uiColorScheme8 = uiColors;
                    final boolean z10 = z5;
                    stateCollectAsState = SnapshotStateKt.collectAsState(documentState.getMenuConfigurationState$sdk_nutrient(), coroutineContext, composerStartRestartGroup, 0, 1);
                    State stateCollectAsState6 = SnapshotStateKt.collectAsState(documentState.getActiveViewState(), coroutineContext, composerStartRestartGroup, 0, 1);
                    bv bvVarMainToolbar$lambda$7 = MainToolbar$lambda$3(stateCollectAsState);
                    bv.a aVarMainToolbar$lambda$8 = MainToolbar$lambda$4(stateCollectAsState6);
                    bvVarMainToolbar$lambda$7.getClass();
                    aVarMainToolbar$lambda$8.getClass();
                    bvVarMainToolbar$lambda$7.e = aVarMainToolbar$lambda$8;
                    zChanged = composerStartRestartGroup.changed(documentState.getTitle());
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        activityTitle = documentState.getConfiguration().getActivityTitle();
                        if (activityTitle == null) {
                            activityTitle = "";
                        }
                        MutableState mutableStateMutableStateOf$default114 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(activityTitle, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default114);
                        objRememberedValue3 = mutableStateMutableStateOf$default114;
                    } else {
                        activityTitle = documentState.getConfiguration().getActivityTitle();
                        if (activityTitle == null) {
                            activityTitle = "";
                        }
                        MutableState mutableStateMutableStateOf$default115 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(activityTitle, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default115);
                        objRememberedValue3 = mutableStateMutableStateOf$default115;
                    }
                    final MutableState mutableState18 = (MutableState) objRememberedValue3;
                    resources = (Resources) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalResources());
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == companion.getEmpty()) {
                        MutableState mutableStateMutableStateOf$default116 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(resources.getBoolean(R.bool.pspdf__display_document_title_in_actionbar)), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default116);
                        objRememberedValue4 = mutableStateMutableStateOf$default116;
                    }
                    final MutableState mutableState19 = (MutableState) objRememberedValue4;
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == companion.getEmpty()) {
                        objRememberedValue5 = SnapshotIntStateKt.mutableIntStateOf(0);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    final MutableIntState mutableIntState5 = (MutableIntState) objRememberedValue5;
                    gc customPdfActions5 = documentState.getCustomPdfActions();
                    zChangedInstance = composerStartRestartGroup.changedInstance(documentState) | composerStartRestartGroup.changedInstance(coroutineScope);
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance) {
                        objRememberedValue6 = new MainToolbarKt$MainToolbar$1$1(documentState, coroutineScope, mutableState, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    } else {
                        objRememberedValue6 = new MainToolbarKt$MainToolbar$1$1(documentState, coroutineScope, mutableState, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    EffectsKt.LaunchedEffect(customPdfActions5, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue6, composerStartRestartGroup, 0);
                    zChanged2 = composerStartRestartGroup.changed(MainToolbar$lambda$3(stateCollectAsState));
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2) {
                        MutableState mutableStateMutableStateOf$default117 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getActionMenu(MainToolbar$lambda$3(stateCollectAsState)), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default117);
                        objRememberedValue7 = mutableStateMutableStateOf$default117;
                    } else {
                        MutableState mutableStateMutableStateOf$default118 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getActionMenu(MainToolbar$lambda$3(stateCollectAsState)), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default118);
                        objRememberedValue7 = mutableStateMutableStateOf$default118;
                    }
                    final MutableState mutableState110 = (MutableState) objRememberedValue7;
                    zChanged3 = composerStartRestartGroup.changed(MainToolbar$lambda$3(stateCollectAsState));
                    objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                    if (zChanged3) {
                        objRememberedValue8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getHiddenMenu(MainToolbar$lambda$3(stateCollectAsState)), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    } else {
                        objRememberedValue8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getHiddenMenu(MainToolbar$lambda$3(stateCollectAsState)), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    }
                    final MutableState mutableState111 = (MutableState) objRememberedValue8;
                    final Modifier modifier8 = modifier2;
                    final Function1 function114 = function15;
                    final Function4 function115 = function12;
                    windowInsets3 = windowInsets2;
                    ThemeWrapperKt.WithUiTheme(uiColorScheme8, ComposableLambdaKt.rememberComposableLambda(38712441, true, new Function2() { // from class: com.pspdfkit.jetpack.compose.components.MainToolbarKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return MainToolbarKt.MainToolbar$lambda$17(function114, mutableIntState5, modifier8, windowInsets3, z10, documentState, function115, mutableState, mutableState111, stateCollectAsState, function14, mutableState18, mutableState19, lambda$1623726612$sdk_nutrient, function13, mutableState110, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i14 >> 6) & 14) | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function2 = function114;
                    modifier3 = modifier8;
                    composer2 = composerStartRestartGroup;
                    uiColorScheme3 = uiColorScheme8;
                    z3 = z10;
                    function8 = function115;
                    function10 = function14;
                    function9 = function13;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    composer2 = composerStartRestartGroup;
                    uiColorScheme3 = uiColorScheme2;
                    windowInsets3 = windowInsets2;
                    function8 = function6;
                    z3 = z;
                    function2 = function1;
                    function9 = lambda$1210789952$sdk_nutrient;
                    function10 = function7;
                }
                function11 = lambda$1623726612$sdk_nutrient;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.jetpack.compose.components.MainToolbarKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return MainToolbarKt.MainToolbar$lambda$18(modifier3, documentState, uiColorScheme3, windowInsets3, function10, function11, function9, function8, z3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            lambda$1623726612$sdk_nutrient = function4;
            i6 = i2 & 64;
            if (i6 != 0) {
                i3 |= 1572864;
                lambda$1210789952$sdk_nutrient = function5;
            } else {
                lambda$1210789952$sdk_nutrient = function5;
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(lambda$1210789952$sdk_nutrient)) {
                        i7 = 1048576;
                    } else {
                        i7 = 524288;
                    }
                    i3 |= i7;
                }
            }
            i8 = i2 & 128;
            if (i8 != 0) {
                i3 |= 12582912;
            } else if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function6)) {
                    i9 = 8388608;
                } else {
                    i9 = 4194304;
                }
                i3 |= i9;
            }
            i10 = i2 & 256;
            if (i10 != 0) {
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(z)) {
                        i11 = 67108864;
                    } else {
                        i11 = 33554432;
                    }
                    i3 |= i11;
                }
                i12 = i2 & 512;
                if (i12 != 0) {
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(function1)) {
                            i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i13 = 268435456;
                        }
                        i3 |= i13;
                    }
                    if ((i3 & 306783379) != 306783378) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 4) != 0) {
                                uiColors = UiThemeKt.getUiColors(composerStartRestartGroup, 0);
                                i3 &= -897;
                            } else {
                                uiColors = uiColorScheme2;
                            }
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                                windowInsets2 = TopAppBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, TopAppBarDefaults.$stable);
                            }
                            if (i18 != 0) {
                                function7 = null;
                            }
                            if (i4 != 0) {
                                lambda$1623726612$sdk_nutrient = ComposableSingletons$MainToolbarKt.INSTANCE.getLambda$1623726612$sdk_nutrient();
                            }
                            if (i6 != 0) {
                                lambda$1210789952$sdk_nutrient = ComposableSingletons$MainToolbarKt.INSTANCE.getLambda$1210789952$sdk_nutrient();
                            }
                            if (i8 != 0) {
                                function12 = null;
                            } else {
                                function12 = function6;
                            }
                            if (i10 != 0) {
                                z4 = true;
                            } else {
                                z4 = z;
                            }
                            function13 = lambda$1210789952$sdk_nutrient;
                            z5 = z4;
                            function14 = function7;
                            i14 = i3;
                            if (i12 != 0) {
                                function15 = null;
                            } else {
                                function15 = function1;
                            }
                        } else {
                            if (i15 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 4) != 0) {
                                uiColors = UiThemeKt.getUiColors(composerStartRestartGroup, 0);
                                i3 &= -897;
                            } else {
                                uiColors = uiColorScheme2;
                            }
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                                windowInsets2 = TopAppBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, TopAppBarDefaults.$stable);
                            }
                            if (i18 != 0) {
                                function7 = null;
                            }
                            if (i4 != 0) {
                                lambda$1623726612$sdk_nutrient = ComposableSingletons$MainToolbarKt.INSTANCE.getLambda$1623726612$sdk_nutrient();
                            }
                            if (i6 != 0) {
                                lambda$1210789952$sdk_nutrient = ComposableSingletons$MainToolbarKt.INSTANCE.getLambda$1210789952$sdk_nutrient();
                            }
                            if (i8 != 0) {
                                function12 = null;
                            } else {
                                function12 = function6;
                            }
                            if (i10 != 0) {
                                z4 = true;
                            } else {
                                z4 = z;
                            }
                            function13 = lambda$1210789952$sdk_nutrient;
                            z5 = z4;
                            function14 = function7;
                            i14 = i3;
                            if (i12 != 0) {
                                function15 = null;
                            } else {
                                function15 = function1;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-55603716, i14, -1, "com.pspdfkit.jetpack.compose.components.MainToolbar (MainToolbar.kt:97)");
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        companion = Composer.INSTANCE;
                        if (objRememberedValue == companion.getEmpty()) {
                            objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        coroutineScope = (CoroutineScope) objRememberedValue;
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == companion.getEmpty()) {
                            coroutineContext = null;
                            MutableState mutableStateMutableStateOf$default119 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default119);
                            objRememberedValue2 = mutableStateMutableStateOf$default119;
                        } else {
                            coroutineContext = null;
                        }
                        mutableState = (MutableState) objRememberedValue2;
                        UiColorScheme uiColorScheme9 = uiColors;
                        final boolean z11 = z5;
                        stateCollectAsState = SnapshotStateKt.collectAsState(documentState.getMenuConfigurationState$sdk_nutrient(), coroutineContext, composerStartRestartGroup, 0, 1);
                        State stateCollectAsState7 = SnapshotStateKt.collectAsState(documentState.getActiveViewState(), coroutineContext, composerStartRestartGroup, 0, 1);
                        bv bvVarMainToolbar$lambda$8 = MainToolbar$lambda$3(stateCollectAsState);
                        bv.a aVarMainToolbar$lambda$9 = MainToolbar$lambda$4(stateCollectAsState7);
                        bvVarMainToolbar$lambda$8.getClass();
                        aVarMainToolbar$lambda$9.getClass();
                        bvVarMainToolbar$lambda$8.e = aVarMainToolbar$lambda$9;
                        zChanged = composerStartRestartGroup.changed(documentState.getTitle());
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            activityTitle = documentState.getConfiguration().getActivityTitle();
                            if (activityTitle == null) {
                                activityTitle = "";
                            }
                            MutableState mutableStateMutableStateOf$default1110 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(activityTitle, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default1110);
                            objRememberedValue3 = mutableStateMutableStateOf$default1110;
                        } else {
                            activityTitle = documentState.getConfiguration().getActivityTitle();
                            if (activityTitle == null) {
                                activityTitle = "";
                            }
                            MutableState mutableStateMutableStateOf$default1111 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(activityTitle, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default1111);
                            objRememberedValue3 = mutableStateMutableStateOf$default1111;
                        }
                        final MutableState mutableState112 = (MutableState) objRememberedValue3;
                        resources = (Resources) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalResources());
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue4 == companion.getEmpty()) {
                            MutableState mutableStateMutableStateOf$default1112 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(resources.getBoolean(R.bool.pspdf__display_document_title_in_actionbar)), null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default1112);
                            objRememberedValue4 = mutableStateMutableStateOf$default1112;
                        }
                        final MutableState mutableState113 = (MutableState) objRememberedValue4;
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == companion.getEmpty()) {
                            objRememberedValue5 = SnapshotIntStateKt.mutableIntStateOf(0);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        final MutableIntState mutableIntState6 = (MutableIntState) objRememberedValue5;
                        gc customPdfActions6 = documentState.getCustomPdfActions();
                        zChangedInstance = composerStartRestartGroup.changedInstance(documentState) | composerStartRestartGroup.changedInstance(coroutineScope);
                        objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (zChangedInstance) {
                            objRememberedValue6 = new MainToolbarKt$MainToolbar$1$1(documentState, coroutineScope, mutableState, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        } else {
                            objRememberedValue6 = new MainToolbarKt$MainToolbar$1$1(documentState, coroutineScope, mutableState, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        }
                        EffectsKt.LaunchedEffect(customPdfActions6, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue6, composerStartRestartGroup, 0);
                        zChanged2 = composerStartRestartGroup.changed(MainToolbar$lambda$3(stateCollectAsState));
                        objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                        if (zChanged2) {
                            MutableState mutableStateMutableStateOf$default1113 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getActionMenu(MainToolbar$lambda$3(stateCollectAsState)), null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default1113);
                            objRememberedValue7 = mutableStateMutableStateOf$default1113;
                        } else {
                            MutableState mutableStateMutableStateOf$default1114 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getActionMenu(MainToolbar$lambda$3(stateCollectAsState)), null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default1114);
                            objRememberedValue7 = mutableStateMutableStateOf$default1114;
                        }
                        final MutableState mutableState114 = (MutableState) objRememberedValue7;
                        zChanged3 = composerStartRestartGroup.changed(MainToolbar$lambda$3(stateCollectAsState));
                        objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                        if (zChanged3) {
                            objRememberedValue8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getHiddenMenu(MainToolbar$lambda$3(stateCollectAsState)), null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                        } else {
                            objRememberedValue8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getHiddenMenu(MainToolbar$lambda$3(stateCollectAsState)), null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                        }
                        final MutableState mutableState115 = (MutableState) objRememberedValue8;
                        final Modifier modifier9 = modifier2;
                        final Function1 function116 = function15;
                        final Function4 function117 = function12;
                        windowInsets3 = windowInsets2;
                        ThemeWrapperKt.WithUiTheme(uiColorScheme9, ComposableLambdaKt.rememberComposableLambda(38712441, true, new Function2() { // from class: com.pspdfkit.jetpack.compose.components.MainToolbarKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return MainToolbarKt.MainToolbar$lambda$17(function116, mutableIntState6, modifier9, windowInsets3, z11, documentState, function117, mutableState, mutableState115, stateCollectAsState, function14, mutableState112, mutableState113, lambda$1623726612$sdk_nutrient, function13, mutableState114, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i14 >> 6) & 14) | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function2 = function116;
                        modifier3 = modifier9;
                        composer2 = composerStartRestartGroup;
                        uiColorScheme3 = uiColorScheme9;
                        z3 = z11;
                        function8 = function117;
                        function10 = function14;
                        function9 = function13;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        composer2 = composerStartRestartGroup;
                        uiColorScheme3 = uiColorScheme2;
                        windowInsets3 = windowInsets2;
                        function8 = function6;
                        z3 = z;
                        function2 = function1;
                        function9 = lambda$1210789952$sdk_nutrient;
                        function10 = function7;
                    }
                    function11 = lambda$1623726612$sdk_nutrient;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.jetpack.compose.components.MainToolbarKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return MainToolbarKt.MainToolbar$lambda$18(modifier3, documentState, uiColorScheme3, windowInsets3, function10, function11, function9, function8, z3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 805306368;
                if ((i3 & 306783379) != 306783378) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 4) != 0) {
                            uiColors = UiThemeKt.getUiColors(composerStartRestartGroup, 0);
                            i3 &= -897;
                        } else {
                            uiColors = uiColorScheme2;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            windowInsets2 = TopAppBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, TopAppBarDefaults.$stable);
                        }
                        if (i18 != 0) {
                            function7 = null;
                        }
                        if (i4 != 0) {
                            lambda$1623726612$sdk_nutrient = ComposableSingletons$MainToolbarKt.INSTANCE.getLambda$1623726612$sdk_nutrient();
                        }
                        if (i6 != 0) {
                            lambda$1210789952$sdk_nutrient = ComposableSingletons$MainToolbarKt.INSTANCE.getLambda$1210789952$sdk_nutrient();
                        }
                        if (i8 != 0) {
                            function12 = null;
                        } else {
                            function12 = function6;
                        }
                        if (i10 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        function13 = lambda$1210789952$sdk_nutrient;
                        z5 = z4;
                        function14 = function7;
                        i14 = i3;
                        if (i12 != 0) {
                            function15 = null;
                        } else {
                            function15 = function1;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 4) != 0) {
                            uiColors = UiThemeKt.getUiColors(composerStartRestartGroup, 0);
                            i3 &= -897;
                        } else {
                            uiColors = uiColorScheme2;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            windowInsets2 = TopAppBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, TopAppBarDefaults.$stable);
                        }
                        if (i18 != 0) {
                            function7 = null;
                        }
                        if (i4 != 0) {
                            lambda$1623726612$sdk_nutrient = ComposableSingletons$MainToolbarKt.INSTANCE.getLambda$1623726612$sdk_nutrient();
                        }
                        if (i6 != 0) {
                            lambda$1210789952$sdk_nutrient = ComposableSingletons$MainToolbarKt.INSTANCE.getLambda$1210789952$sdk_nutrient();
                        }
                        if (i8 != 0) {
                            function12 = null;
                        } else {
                            function12 = function6;
                        }
                        if (i10 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        function13 = lambda$1210789952$sdk_nutrient;
                        z5 = z4;
                        function14 = function7;
                        i14 = i3;
                        if (i12 != 0) {
                            function15 = null;
                        } else {
                            function15 = function1;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-55603716, i14, -1, "com.pspdfkit.jetpack.compose.components.MainToolbar (MainToolbar.kt:97)");
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.INSTANCE;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    coroutineScope = (CoroutineScope) objRememberedValue;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        coroutineContext = null;
                        MutableState mutableStateMutableStateOf$default1115 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default1115);
                        objRememberedValue2 = mutableStateMutableStateOf$default1115;
                    } else {
                        coroutineContext = null;
                    }
                    mutableState = (MutableState) objRememberedValue2;
                    UiColorScheme uiColorScheme10 = uiColors;
                    final boolean z12 = z5;
                    stateCollectAsState = SnapshotStateKt.collectAsState(documentState.getMenuConfigurationState$sdk_nutrient(), coroutineContext, composerStartRestartGroup, 0, 1);
                    State stateCollectAsState8 = SnapshotStateKt.collectAsState(documentState.getActiveViewState(), coroutineContext, composerStartRestartGroup, 0, 1);
                    bv bvVarMainToolbar$lambda$9 = MainToolbar$lambda$3(stateCollectAsState);
                    bv.a aVarMainToolbar$lambda$10 = MainToolbar$lambda$4(stateCollectAsState8);
                    bvVarMainToolbar$lambda$9.getClass();
                    aVarMainToolbar$lambda$10.getClass();
                    bvVarMainToolbar$lambda$9.e = aVarMainToolbar$lambda$10;
                    zChanged = composerStartRestartGroup.changed(documentState.getTitle());
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        activityTitle = documentState.getConfiguration().getActivityTitle();
                        if (activityTitle == null) {
                            activityTitle = "";
                        }
                        MutableState mutableStateMutableStateOf$default1116 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(activityTitle, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default1116);
                        objRememberedValue3 = mutableStateMutableStateOf$default1116;
                    } else {
                        activityTitle = documentState.getConfiguration().getActivityTitle();
                        if (activityTitle == null) {
                            activityTitle = "";
                        }
                        MutableState mutableStateMutableStateOf$default1117 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(activityTitle, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default1117);
                        objRememberedValue3 = mutableStateMutableStateOf$default1117;
                    }
                    final MutableState mutableState116 = (MutableState) objRememberedValue3;
                    resources = (Resources) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalResources());
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == companion.getEmpty()) {
                        MutableState mutableStateMutableStateOf$default1118 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(resources.getBoolean(R.bool.pspdf__display_document_title_in_actionbar)), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default1118);
                        objRememberedValue4 = mutableStateMutableStateOf$default1118;
                    }
                    final MutableState mutableState117 = (MutableState) objRememberedValue4;
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == companion.getEmpty()) {
                        objRememberedValue5 = SnapshotIntStateKt.mutableIntStateOf(0);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    final MutableIntState mutableIntState7 = (MutableIntState) objRememberedValue5;
                    gc customPdfActions7 = documentState.getCustomPdfActions();
                    zChangedInstance = composerStartRestartGroup.changedInstance(documentState) | composerStartRestartGroup.changedInstance(coroutineScope);
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance) {
                        objRememberedValue6 = new MainToolbarKt$MainToolbar$1$1(documentState, coroutineScope, mutableState, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    } else {
                        objRememberedValue6 = new MainToolbarKt$MainToolbar$1$1(documentState, coroutineScope, mutableState, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    EffectsKt.LaunchedEffect(customPdfActions7, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue6, composerStartRestartGroup, 0);
                    zChanged2 = composerStartRestartGroup.changed(MainToolbar$lambda$3(stateCollectAsState));
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2) {
                        MutableState mutableStateMutableStateOf$default1119 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getActionMenu(MainToolbar$lambda$3(stateCollectAsState)), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default1119);
                        objRememberedValue7 = mutableStateMutableStateOf$default1119;
                    } else {
                        MutableState mutableStateMutableStateOf$default11110 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getActionMenu(MainToolbar$lambda$3(stateCollectAsState)), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default11110);
                        objRememberedValue7 = mutableStateMutableStateOf$default11110;
                    }
                    final MutableState mutableState118 = (MutableState) objRememberedValue7;
                    zChanged3 = composerStartRestartGroup.changed(MainToolbar$lambda$3(stateCollectAsState));
                    objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                    if (zChanged3) {
                        objRememberedValue8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getHiddenMenu(MainToolbar$lambda$3(stateCollectAsState)), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    } else {
                        objRememberedValue8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getHiddenMenu(MainToolbar$lambda$3(stateCollectAsState)), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    }
                    final MutableState mutableState119 = (MutableState) objRememberedValue8;
                    final Modifier modifier10 = modifier2;
                    final Function1 function118 = function15;
                    final Function4 function119 = function12;
                    windowInsets3 = windowInsets2;
                    ThemeWrapperKt.WithUiTheme(uiColorScheme10, ComposableLambdaKt.rememberComposableLambda(38712441, true, new Function2() { // from class: com.pspdfkit.jetpack.compose.components.MainToolbarKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return MainToolbarKt.MainToolbar$lambda$17(function118, mutableIntState7, modifier10, windowInsets3, z12, documentState, function119, mutableState, mutableState119, stateCollectAsState, function14, mutableState116, mutableState117, lambda$1623726612$sdk_nutrient, function13, mutableState118, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i14 >> 6) & 14) | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function2 = function118;
                    modifier3 = modifier10;
                    composer2 = composerStartRestartGroup;
                    uiColorScheme3 = uiColorScheme10;
                    z3 = z12;
                    function8 = function119;
                    function10 = function14;
                    function9 = function13;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    composer2 = composerStartRestartGroup;
                    uiColorScheme3 = uiColorScheme2;
                    windowInsets3 = windowInsets2;
                    function8 = function6;
                    z3 = z;
                    function2 = function1;
                    function9 = lambda$1210789952$sdk_nutrient;
                    function10 = function7;
                }
                function11 = lambda$1623726612$sdk_nutrient;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.jetpack.compose.components.MainToolbarKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return MainToolbarKt.MainToolbar$lambda$18(modifier3, documentState, uiColorScheme3, windowInsets3, function10, function11, function9, function8, z3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 100663296;
            i12 = i2 & 512;
            if (i12 != 0) {
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i13 = 268435456;
                    }
                    i3 |= i13;
                }
                if ((i3 & 306783379) != 306783378) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 4) != 0) {
                            uiColors = UiThemeKt.getUiColors(composerStartRestartGroup, 0);
                            i3 &= -897;
                        } else {
                            uiColors = uiColorScheme2;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            windowInsets2 = TopAppBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, TopAppBarDefaults.$stable);
                        }
                        if (i18 != 0) {
                            function7 = null;
                        }
                        if (i4 != 0) {
                            lambda$1623726612$sdk_nutrient = ComposableSingletons$MainToolbarKt.INSTANCE.getLambda$1623726612$sdk_nutrient();
                        }
                        if (i6 != 0) {
                            lambda$1210789952$sdk_nutrient = ComposableSingletons$MainToolbarKt.INSTANCE.getLambda$1210789952$sdk_nutrient();
                        }
                        if (i8 != 0) {
                            function12 = null;
                        } else {
                            function12 = function6;
                        }
                        if (i10 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        function13 = lambda$1210789952$sdk_nutrient;
                        z5 = z4;
                        function14 = function7;
                        i14 = i3;
                        if (i12 != 0) {
                            function15 = null;
                        } else {
                            function15 = function1;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 4) != 0) {
                            uiColors = UiThemeKt.getUiColors(composerStartRestartGroup, 0);
                            i3 &= -897;
                        } else {
                            uiColors = uiColorScheme2;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            windowInsets2 = TopAppBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, TopAppBarDefaults.$stable);
                        }
                        if (i18 != 0) {
                            function7 = null;
                        }
                        if (i4 != 0) {
                            lambda$1623726612$sdk_nutrient = ComposableSingletons$MainToolbarKt.INSTANCE.getLambda$1623726612$sdk_nutrient();
                        }
                        if (i6 != 0) {
                            lambda$1210789952$sdk_nutrient = ComposableSingletons$MainToolbarKt.INSTANCE.getLambda$1210789952$sdk_nutrient();
                        }
                        if (i8 != 0) {
                            function12 = null;
                        } else {
                            function12 = function6;
                        }
                        if (i10 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        function13 = lambda$1210789952$sdk_nutrient;
                        z5 = z4;
                        function14 = function7;
                        i14 = i3;
                        if (i12 != 0) {
                            function15 = null;
                        } else {
                            function15 = function1;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-55603716, i14, -1, "com.pspdfkit.jetpack.compose.components.MainToolbar (MainToolbar.kt:97)");
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.INSTANCE;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    coroutineScope = (CoroutineScope) objRememberedValue;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        coroutineContext = null;
                        MutableState mutableStateMutableStateOf$default11111 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default11111);
                        objRememberedValue2 = mutableStateMutableStateOf$default11111;
                    } else {
                        coroutineContext = null;
                    }
                    mutableState = (MutableState) objRememberedValue2;
                    UiColorScheme uiColorScheme11 = uiColors;
                    final boolean z13 = z5;
                    stateCollectAsState = SnapshotStateKt.collectAsState(documentState.getMenuConfigurationState$sdk_nutrient(), coroutineContext, composerStartRestartGroup, 0, 1);
                    State stateCollectAsState9 = SnapshotStateKt.collectAsState(documentState.getActiveViewState(), coroutineContext, composerStartRestartGroup, 0, 1);
                    bv bvVarMainToolbar$lambda$10 = MainToolbar$lambda$3(stateCollectAsState);
                    bv.a aVarMainToolbar$lambda$11 = MainToolbar$lambda$4(stateCollectAsState9);
                    bvVarMainToolbar$lambda$10.getClass();
                    aVarMainToolbar$lambda$11.getClass();
                    bvVarMainToolbar$lambda$10.e = aVarMainToolbar$lambda$11;
                    zChanged = composerStartRestartGroup.changed(documentState.getTitle());
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        activityTitle = documentState.getConfiguration().getActivityTitle();
                        if (activityTitle == null) {
                            activityTitle = "";
                        }
                        MutableState mutableStateMutableStateOf$default11112 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(activityTitle, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default11112);
                        objRememberedValue3 = mutableStateMutableStateOf$default11112;
                    } else {
                        activityTitle = documentState.getConfiguration().getActivityTitle();
                        if (activityTitle == null) {
                            activityTitle = "";
                        }
                        MutableState mutableStateMutableStateOf$default11113 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(activityTitle, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default11113);
                        objRememberedValue3 = mutableStateMutableStateOf$default11113;
                    }
                    final MutableState mutableState1110 = (MutableState) objRememberedValue3;
                    resources = (Resources) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalResources());
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == companion.getEmpty()) {
                        MutableState mutableStateMutableStateOf$default11114 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(resources.getBoolean(R.bool.pspdf__display_document_title_in_actionbar)), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default11114);
                        objRememberedValue4 = mutableStateMutableStateOf$default11114;
                    }
                    final MutableState mutableState1111 = (MutableState) objRememberedValue4;
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == companion.getEmpty()) {
                        objRememberedValue5 = SnapshotIntStateKt.mutableIntStateOf(0);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    final MutableIntState mutableIntState8 = (MutableIntState) objRememberedValue5;
                    gc customPdfActions8 = documentState.getCustomPdfActions();
                    zChangedInstance = composerStartRestartGroup.changedInstance(documentState) | composerStartRestartGroup.changedInstance(coroutineScope);
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance) {
                        objRememberedValue6 = new MainToolbarKt$MainToolbar$1$1(documentState, coroutineScope, mutableState, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    } else {
                        objRememberedValue6 = new MainToolbarKt$MainToolbar$1$1(documentState, coroutineScope, mutableState, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    EffectsKt.LaunchedEffect(customPdfActions8, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue6, composerStartRestartGroup, 0);
                    zChanged2 = composerStartRestartGroup.changed(MainToolbar$lambda$3(stateCollectAsState));
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2) {
                        MutableState mutableStateMutableStateOf$default11115 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getActionMenu(MainToolbar$lambda$3(stateCollectAsState)), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default11115);
                        objRememberedValue7 = mutableStateMutableStateOf$default11115;
                    } else {
                        MutableState mutableStateMutableStateOf$default11116 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getActionMenu(MainToolbar$lambda$3(stateCollectAsState)), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default11116);
                        objRememberedValue7 = mutableStateMutableStateOf$default11116;
                    }
                    final MutableState mutableState1112 = (MutableState) objRememberedValue7;
                    zChanged3 = composerStartRestartGroup.changed(MainToolbar$lambda$3(stateCollectAsState));
                    objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                    if (zChanged3) {
                        objRememberedValue8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getHiddenMenu(MainToolbar$lambda$3(stateCollectAsState)), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    } else {
                        objRememberedValue8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getHiddenMenu(MainToolbar$lambda$3(stateCollectAsState)), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    }
                    final MutableState mutableState1113 = (MutableState) objRememberedValue8;
                    final Modifier modifier11 = modifier2;
                    final Function1 function1110 = function15;
                    final Function4 function1111 = function12;
                    windowInsets3 = windowInsets2;
                    ThemeWrapperKt.WithUiTheme(uiColorScheme11, ComposableLambdaKt.rememberComposableLambda(38712441, true, new Function2() { // from class: com.pspdfkit.jetpack.compose.components.MainToolbarKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return MainToolbarKt.MainToolbar$lambda$17(function1110, mutableIntState8, modifier11, windowInsets3, z13, documentState, function1111, mutableState, mutableState1113, stateCollectAsState, function14, mutableState1110, mutableState1111, lambda$1623726612$sdk_nutrient, function13, mutableState1112, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i14 >> 6) & 14) | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function2 = function1110;
                    modifier3 = modifier11;
                    composer2 = composerStartRestartGroup;
                    uiColorScheme3 = uiColorScheme11;
                    z3 = z13;
                    function8 = function1111;
                    function10 = function14;
                    function9 = function13;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    composer2 = composerStartRestartGroup;
                    uiColorScheme3 = uiColorScheme2;
                    windowInsets3 = windowInsets2;
                    function8 = function6;
                    z3 = z;
                    function2 = function1;
                    function9 = lambda$1210789952$sdk_nutrient;
                    function10 = function7;
                }
                function11 = lambda$1623726612$sdk_nutrient;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.jetpack.compose.components.MainToolbarKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return MainToolbarKt.MainToolbar$lambda$18(modifier3, documentState, uiColorScheme3, windowInsets3, function10, function11, function9, function8, z3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 805306368;
            if ((i3 & 306783379) != 306783378) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i15 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 4) != 0) {
                        uiColors = UiThemeKt.getUiColors(composerStartRestartGroup, 0);
                        i3 &= -897;
                    } else {
                        uiColors = uiColorScheme2;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        windowInsets2 = TopAppBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, TopAppBarDefaults.$stable);
                    }
                    if (i18 != 0) {
                        function7 = null;
                    }
                    if (i4 != 0) {
                        lambda$1623726612$sdk_nutrient = ComposableSingletons$MainToolbarKt.INSTANCE.getLambda$1623726612$sdk_nutrient();
                    }
                    if (i6 != 0) {
                        lambda$1210789952$sdk_nutrient = ComposableSingletons$MainToolbarKt.INSTANCE.getLambda$1210789952$sdk_nutrient();
                    }
                    if (i8 != 0) {
                        function12 = null;
                    } else {
                        function12 = function6;
                    }
                    if (i10 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    function13 = lambda$1210789952$sdk_nutrient;
                    z5 = z4;
                    function14 = function7;
                    i14 = i3;
                    if (i12 != 0) {
                        function15 = null;
                    } else {
                        function15 = function1;
                    }
                } else {
                    if (i15 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 4) != 0) {
                        uiColors = UiThemeKt.getUiColors(composerStartRestartGroup, 0);
                        i3 &= -897;
                    } else {
                        uiColors = uiColorScheme2;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        windowInsets2 = TopAppBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, TopAppBarDefaults.$stable);
                    }
                    if (i18 != 0) {
                        function7 = null;
                    }
                    if (i4 != 0) {
                        lambda$1623726612$sdk_nutrient = ComposableSingletons$MainToolbarKt.INSTANCE.getLambda$1623726612$sdk_nutrient();
                    }
                    if (i6 != 0) {
                        lambda$1210789952$sdk_nutrient = ComposableSingletons$MainToolbarKt.INSTANCE.getLambda$1210789952$sdk_nutrient();
                    }
                    if (i8 != 0) {
                        function12 = null;
                    } else {
                        function12 = function6;
                    }
                    if (i10 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    function13 = lambda$1210789952$sdk_nutrient;
                    z5 = z4;
                    function14 = function7;
                    i14 = i3;
                    if (i12 != 0) {
                        function15 = null;
                    } else {
                        function15 = function1;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-55603716, i14, -1, "com.pspdfkit.jetpack.compose.components.MainToolbar (MainToolbar.kt:97)");
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                coroutineScope = (CoroutineScope) objRememberedValue;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    coroutineContext = null;
                    MutableState mutableStateMutableStateOf$default11117 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default11117);
                    objRememberedValue2 = mutableStateMutableStateOf$default11117;
                } else {
                    coroutineContext = null;
                }
                mutableState = (MutableState) objRememberedValue2;
                UiColorScheme uiColorScheme12 = uiColors;
                final boolean z14 = z5;
                stateCollectAsState = SnapshotStateKt.collectAsState(documentState.getMenuConfigurationState$sdk_nutrient(), coroutineContext, composerStartRestartGroup, 0, 1);
                State stateCollectAsState10 = SnapshotStateKt.collectAsState(documentState.getActiveViewState(), coroutineContext, composerStartRestartGroup, 0, 1);
                bv bvVarMainToolbar$lambda$11 = MainToolbar$lambda$3(stateCollectAsState);
                bv.a aVarMainToolbar$lambda$12 = MainToolbar$lambda$4(stateCollectAsState10);
                bvVarMainToolbar$lambda$11.getClass();
                aVarMainToolbar$lambda$12.getClass();
                bvVarMainToolbar$lambda$11.e = aVarMainToolbar$lambda$12;
                zChanged = composerStartRestartGroup.changed(documentState.getTitle());
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    activityTitle = documentState.getConfiguration().getActivityTitle();
                    if (activityTitle == null) {
                        activityTitle = "";
                    }
                    MutableState mutableStateMutableStateOf$default11118 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(activityTitle, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default11118);
                    objRememberedValue3 = mutableStateMutableStateOf$default11118;
                } else {
                    activityTitle = documentState.getConfiguration().getActivityTitle();
                    if (activityTitle == null) {
                        activityTitle = "";
                    }
                    MutableState mutableStateMutableStateOf$default11119 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(activityTitle, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default11119);
                    objRememberedValue3 = mutableStateMutableStateOf$default11119;
                }
                final MutableState mutableState1114 = (MutableState) objRememberedValue3;
                resources = (Resources) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalResources());
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == companion.getEmpty()) {
                    MutableState mutableStateMutableStateOf$default111110 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(resources.getBoolean(R.bool.pspdf__display_document_title_in_actionbar)), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default111110);
                    objRememberedValue4 = mutableStateMutableStateOf$default111110;
                }
                final MutableState mutableState1115 = (MutableState) objRememberedValue4;
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == companion.getEmpty()) {
                    objRememberedValue5 = SnapshotIntStateKt.mutableIntStateOf(0);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                final MutableIntState mutableIntState9 = (MutableIntState) objRememberedValue5;
                gc customPdfActions9 = documentState.getCustomPdfActions();
                zChangedInstance = composerStartRestartGroup.changedInstance(documentState) | composerStartRestartGroup.changedInstance(coroutineScope);
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance) {
                    objRememberedValue6 = new MainToolbarKt$MainToolbar$1$1(documentState, coroutineScope, mutableState, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                } else {
                    objRememberedValue6 = new MainToolbarKt$MainToolbar$1$1(documentState, coroutineScope, mutableState, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                EffectsKt.LaunchedEffect(customPdfActions9, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue6, composerStartRestartGroup, 0);
                zChanged2 = composerStartRestartGroup.changed(MainToolbar$lambda$3(stateCollectAsState));
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (zChanged2) {
                    MutableState mutableStateMutableStateOf$default111111 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getActionMenu(MainToolbar$lambda$3(stateCollectAsState)), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default111111);
                    objRememberedValue7 = mutableStateMutableStateOf$default111111;
                } else {
                    MutableState mutableStateMutableStateOf$default111112 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getActionMenu(MainToolbar$lambda$3(stateCollectAsState)), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default111112);
                    objRememberedValue7 = mutableStateMutableStateOf$default111112;
                }
                final MutableState mutableState1116 = (MutableState) objRememberedValue7;
                zChanged3 = composerStartRestartGroup.changed(MainToolbar$lambda$3(stateCollectAsState));
                objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                if (zChanged3) {
                    objRememberedValue8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getHiddenMenu(MainToolbar$lambda$3(stateCollectAsState)), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                } else {
                    objRememberedValue8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getHiddenMenu(MainToolbar$lambda$3(stateCollectAsState)), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                }
                final MutableState mutableState1117 = (MutableState) objRememberedValue8;
                final Modifier modifier12 = modifier2;
                final Function1 function1112 = function15;
                final Function4 function1113 = function12;
                windowInsets3 = windowInsets2;
                ThemeWrapperKt.WithUiTheme(uiColorScheme12, ComposableLambdaKt.rememberComposableLambda(38712441, true, new Function2() { // from class: com.pspdfkit.jetpack.compose.components.MainToolbarKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return MainToolbarKt.MainToolbar$lambda$17(function1112, mutableIntState9, modifier12, windowInsets3, z14, documentState, function1113, mutableState, mutableState1117, stateCollectAsState, function14, mutableState1114, mutableState1115, lambda$1623726612$sdk_nutrient, function13, mutableState1116, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i14 >> 6) & 14) | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function2 = function1112;
                modifier3 = modifier12;
                composer2 = composerStartRestartGroup;
                uiColorScheme3 = uiColorScheme12;
                z3 = z14;
                function8 = function1113;
                function10 = function14;
                function9 = function13;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                composer2 = composerStartRestartGroup;
                uiColorScheme3 = uiColorScheme2;
                windowInsets3 = windowInsets2;
                function8 = function6;
                z3 = z;
                function2 = function1;
                function9 = lambda$1210789952$sdk_nutrient;
                function10 = function7;
            }
            function11 = lambda$1623726612$sdk_nutrient;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.jetpack.compose.components.MainToolbarKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return MainToolbarKt.MainToolbar$lambda$18(modifier3, documentState, uiColorScheme3, windowInsets3, function10, function11, function9, function8, z3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        function7 = function3;
        i4 = i2 & 32;
        if (i4 != 0) {
            if ((196608 & i) == 0) {
                lambda$1623726612$sdk_nutrient = function4;
                if (composerStartRestartGroup.changedInstance(lambda$1623726612$sdk_nutrient)) {
                    i5 = 131072;
                } else {
                    i5 = 65536;
                }
                i3 |= i5;
            }
            i6 = i2 & 64;
            if (i6 != 0) {
                i3 |= 1572864;
                lambda$1210789952$sdk_nutrient = function5;
            } else {
                lambda$1210789952$sdk_nutrient = function5;
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changedInstance(lambda$1210789952$sdk_nutrient)) {
                        i7 = 1048576;
                    } else {
                        i7 = 524288;
                    }
                    i3 |= i7;
                }
            }
            i8 = i2 & 128;
            if (i8 != 0) {
                i3 |= 12582912;
            } else if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function6)) {
                    i9 = 8388608;
                } else {
                    i9 = 4194304;
                }
                i3 |= i9;
            }
            i10 = i2 & 256;
            if (i10 != 0) {
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(z)) {
                        i11 = 67108864;
                    } else {
                        i11 = 33554432;
                    }
                    i3 |= i11;
                }
                i12 = i2 & 512;
                if (i12 != 0) {
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(function1)) {
                            i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i13 = 268435456;
                        }
                        i3 |= i13;
                    }
                    if ((i3 & 306783379) != 306783378) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        if ((i & 1) != 0) {
                            if (i15 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 4) != 0) {
                                uiColors = UiThemeKt.getUiColors(composerStartRestartGroup, 0);
                                i3 &= -897;
                            } else {
                                uiColors = uiColorScheme2;
                            }
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                                windowInsets2 = TopAppBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, TopAppBarDefaults.$stable);
                            }
                            if (i18 != 0) {
                                function7 = null;
                            }
                            if (i4 != 0) {
                                lambda$1623726612$sdk_nutrient = ComposableSingletons$MainToolbarKt.INSTANCE.getLambda$1623726612$sdk_nutrient();
                            }
                            if (i6 != 0) {
                                lambda$1210789952$sdk_nutrient = ComposableSingletons$MainToolbarKt.INSTANCE.getLambda$1210789952$sdk_nutrient();
                            }
                            if (i8 != 0) {
                                function12 = null;
                            } else {
                                function12 = function6;
                            }
                            if (i10 != 0) {
                                z4 = true;
                            } else {
                                z4 = z;
                            }
                            function13 = lambda$1210789952$sdk_nutrient;
                            z5 = z4;
                            function14 = function7;
                            i14 = i3;
                            if (i12 != 0) {
                                function15 = null;
                            } else {
                                function15 = function1;
                            }
                        } else {
                            if (i15 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if ((i2 & 4) != 0) {
                                uiColors = UiThemeKt.getUiColors(composerStartRestartGroup, 0);
                                i3 &= -897;
                            } else {
                                uiColors = uiColorScheme2;
                            }
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                                windowInsets2 = TopAppBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, TopAppBarDefaults.$stable);
                            }
                            if (i18 != 0) {
                                function7 = null;
                            }
                            if (i4 != 0) {
                                lambda$1623726612$sdk_nutrient = ComposableSingletons$MainToolbarKt.INSTANCE.getLambda$1623726612$sdk_nutrient();
                            }
                            if (i6 != 0) {
                                lambda$1210789952$sdk_nutrient = ComposableSingletons$MainToolbarKt.INSTANCE.getLambda$1210789952$sdk_nutrient();
                            }
                            if (i8 != 0) {
                                function12 = null;
                            } else {
                                function12 = function6;
                            }
                            if (i10 != 0) {
                                z4 = true;
                            } else {
                                z4 = z;
                            }
                            function13 = lambda$1210789952$sdk_nutrient;
                            z5 = z4;
                            function14 = function7;
                            i14 = i3;
                            if (i12 != 0) {
                                function15 = null;
                            } else {
                                function15 = function1;
                            }
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-55603716, i14, -1, "com.pspdfkit.jetpack.compose.components.MainToolbar (MainToolbar.kt:97)");
                        }
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        companion = Composer.INSTANCE;
                        if (objRememberedValue == companion.getEmpty()) {
                            objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        coroutineScope = (CoroutineScope) objRememberedValue;
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == companion.getEmpty()) {
                            coroutineContext = null;
                            MutableState mutableStateMutableStateOf$default111113 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default111113);
                            objRememberedValue2 = mutableStateMutableStateOf$default111113;
                        } else {
                            coroutineContext = null;
                        }
                        mutableState = (MutableState) objRememberedValue2;
                        UiColorScheme uiColorScheme13 = uiColors;
                        final boolean z15 = z5;
                        stateCollectAsState = SnapshotStateKt.collectAsState(documentState.getMenuConfigurationState$sdk_nutrient(), coroutineContext, composerStartRestartGroup, 0, 1);
                        State stateCollectAsState11 = SnapshotStateKt.collectAsState(documentState.getActiveViewState(), coroutineContext, composerStartRestartGroup, 0, 1);
                        bv bvVarMainToolbar$lambda$12 = MainToolbar$lambda$3(stateCollectAsState);
                        bv.a aVarMainToolbar$lambda$13 = MainToolbar$lambda$4(stateCollectAsState11);
                        bvVarMainToolbar$lambda$12.getClass();
                        aVarMainToolbar$lambda$13.getClass();
                        bvVarMainToolbar$lambda$12.e = aVarMainToolbar$lambda$13;
                        zChanged = composerStartRestartGroup.changed(documentState.getTitle());
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (zChanged) {
                            activityTitle = documentState.getConfiguration().getActivityTitle();
                            if (activityTitle == null) {
                                activityTitle = "";
                            }
                            MutableState mutableStateMutableStateOf$default111114 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(activityTitle, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default111114);
                            objRememberedValue3 = mutableStateMutableStateOf$default111114;
                        } else {
                            activityTitle = documentState.getConfiguration().getActivityTitle();
                            if (activityTitle == null) {
                                activityTitle = "";
                            }
                            MutableState mutableStateMutableStateOf$default111115 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(activityTitle, null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default111115);
                            objRememberedValue3 = mutableStateMutableStateOf$default111115;
                        }
                        final MutableState mutableState1118 = (MutableState) objRememberedValue3;
                        resources = (Resources) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalResources());
                        objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue4 == companion.getEmpty()) {
                            MutableState mutableStateMutableStateOf$default111116 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(resources.getBoolean(R.bool.pspdf__display_document_title_in_actionbar)), null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default111116);
                            objRememberedValue4 = mutableStateMutableStateOf$default111116;
                        }
                        final MutableState mutableState1119 = (MutableState) objRememberedValue4;
                        objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue5 == companion.getEmpty()) {
                            objRememberedValue5 = SnapshotIntStateKt.mutableIntStateOf(0);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                        }
                        final MutableIntState mutableIntState10 = (MutableIntState) objRememberedValue5;
                        gc customPdfActions10 = documentState.getCustomPdfActions();
                        zChangedInstance = composerStartRestartGroup.changedInstance(documentState) | composerStartRestartGroup.changedInstance(coroutineScope);
                        objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                        if (zChangedInstance) {
                            objRememberedValue6 = new MainToolbarKt$MainToolbar$1$1(documentState, coroutineScope, mutableState, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        } else {
                            objRememberedValue6 = new MainToolbarKt$MainToolbar$1$1(documentState, coroutineScope, mutableState, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                        }
                        EffectsKt.LaunchedEffect(customPdfActions10, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue6, composerStartRestartGroup, 0);
                        zChanged2 = composerStartRestartGroup.changed(MainToolbar$lambda$3(stateCollectAsState));
                        objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                        if (zChanged2) {
                            MutableState mutableStateMutableStateOf$default111117 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getActionMenu(MainToolbar$lambda$3(stateCollectAsState)), null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default111117);
                            objRememberedValue7 = mutableStateMutableStateOf$default111117;
                        } else {
                            MutableState mutableStateMutableStateOf$default111118 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getActionMenu(MainToolbar$lambda$3(stateCollectAsState)), null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default111118);
                            objRememberedValue7 = mutableStateMutableStateOf$default111118;
                        }
                        final MutableState mutableState11110 = (MutableState) objRememberedValue7;
                        zChanged3 = composerStartRestartGroup.changed(MainToolbar$lambda$3(stateCollectAsState));
                        objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                        if (zChanged3) {
                            objRememberedValue8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getHiddenMenu(MainToolbar$lambda$3(stateCollectAsState)), null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                        } else {
                            objRememberedValue8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getHiddenMenu(MainToolbar$lambda$3(stateCollectAsState)), null, 2, null);
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                        }
                        final MutableState mutableState11111 = (MutableState) objRememberedValue8;
                        final Modifier modifier13 = modifier2;
                        final Function1 function1114 = function15;
                        final Function4 function1115 = function12;
                        windowInsets3 = windowInsets2;
                        ThemeWrapperKt.WithUiTheme(uiColorScheme13, ComposableLambdaKt.rememberComposableLambda(38712441, true, new Function2() { // from class: com.pspdfkit.jetpack.compose.components.MainToolbarKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return MainToolbarKt.MainToolbar$lambda$17(function1114, mutableIntState10, modifier13, windowInsets3, z15, documentState, function1115, mutableState, mutableState11111, stateCollectAsState, function14, mutableState1118, mutableState1119, lambda$1623726612$sdk_nutrient, function13, mutableState11110, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i14 >> 6) & 14) | 48);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function2 = function1114;
                        modifier3 = modifier13;
                        composer2 = composerStartRestartGroup;
                        uiColorScheme3 = uiColorScheme13;
                        z3 = z15;
                        function8 = function1115;
                        function10 = function14;
                        function9 = function13;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        composer2 = composerStartRestartGroup;
                        uiColorScheme3 = uiColorScheme2;
                        windowInsets3 = windowInsets2;
                        function8 = function6;
                        z3 = z;
                        function2 = function1;
                        function9 = lambda$1210789952$sdk_nutrient;
                        function10 = function7;
                    }
                    function11 = lambda$1623726612$sdk_nutrient;
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.jetpack.compose.components.MainToolbarKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return MainToolbarKt.MainToolbar$lambda$18(modifier3, documentState, uiColorScheme3, windowInsets3, function10, function11, function9, function8, z3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 805306368;
                if ((i3 & 306783379) != 306783378) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 4) != 0) {
                            uiColors = UiThemeKt.getUiColors(composerStartRestartGroup, 0);
                            i3 &= -897;
                        } else {
                            uiColors = uiColorScheme2;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            windowInsets2 = TopAppBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, TopAppBarDefaults.$stable);
                        }
                        if (i18 != 0) {
                            function7 = null;
                        }
                        if (i4 != 0) {
                            lambda$1623726612$sdk_nutrient = ComposableSingletons$MainToolbarKt.INSTANCE.getLambda$1623726612$sdk_nutrient();
                        }
                        if (i6 != 0) {
                            lambda$1210789952$sdk_nutrient = ComposableSingletons$MainToolbarKt.INSTANCE.getLambda$1210789952$sdk_nutrient();
                        }
                        if (i8 != 0) {
                            function12 = null;
                        } else {
                            function12 = function6;
                        }
                        if (i10 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        function13 = lambda$1210789952$sdk_nutrient;
                        z5 = z4;
                        function14 = function7;
                        i14 = i3;
                        if (i12 != 0) {
                            function15 = null;
                        } else {
                            function15 = function1;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 4) != 0) {
                            uiColors = UiThemeKt.getUiColors(composerStartRestartGroup, 0);
                            i3 &= -897;
                        } else {
                            uiColors = uiColorScheme2;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            windowInsets2 = TopAppBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, TopAppBarDefaults.$stable);
                        }
                        if (i18 != 0) {
                            function7 = null;
                        }
                        if (i4 != 0) {
                            lambda$1623726612$sdk_nutrient = ComposableSingletons$MainToolbarKt.INSTANCE.getLambda$1623726612$sdk_nutrient();
                        }
                        if (i6 != 0) {
                            lambda$1210789952$sdk_nutrient = ComposableSingletons$MainToolbarKt.INSTANCE.getLambda$1210789952$sdk_nutrient();
                        }
                        if (i8 != 0) {
                            function12 = null;
                        } else {
                            function12 = function6;
                        }
                        if (i10 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        function13 = lambda$1210789952$sdk_nutrient;
                        z5 = z4;
                        function14 = function7;
                        i14 = i3;
                        if (i12 != 0) {
                            function15 = null;
                        } else {
                            function15 = function1;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-55603716, i14, -1, "com.pspdfkit.jetpack.compose.components.MainToolbar (MainToolbar.kt:97)");
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.INSTANCE;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    coroutineScope = (CoroutineScope) objRememberedValue;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        coroutineContext = null;
                        MutableState mutableStateMutableStateOf$default111119 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default111119);
                        objRememberedValue2 = mutableStateMutableStateOf$default111119;
                    } else {
                        coroutineContext = null;
                    }
                    mutableState = (MutableState) objRememberedValue2;
                    UiColorScheme uiColorScheme14 = uiColors;
                    final boolean z16 = z5;
                    stateCollectAsState = SnapshotStateKt.collectAsState(documentState.getMenuConfigurationState$sdk_nutrient(), coroutineContext, composerStartRestartGroup, 0, 1);
                    State stateCollectAsState12 = SnapshotStateKt.collectAsState(documentState.getActiveViewState(), coroutineContext, composerStartRestartGroup, 0, 1);
                    bv bvVarMainToolbar$lambda$13 = MainToolbar$lambda$3(stateCollectAsState);
                    bv.a aVarMainToolbar$lambda$14 = MainToolbar$lambda$4(stateCollectAsState12);
                    bvVarMainToolbar$lambda$13.getClass();
                    aVarMainToolbar$lambda$14.getClass();
                    bvVarMainToolbar$lambda$13.e = aVarMainToolbar$lambda$14;
                    zChanged = composerStartRestartGroup.changed(documentState.getTitle());
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        activityTitle = documentState.getConfiguration().getActivityTitle();
                        if (activityTitle == null) {
                            activityTitle = "";
                        }
                        MutableState mutableStateMutableStateOf$default1111110 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(activityTitle, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default1111110);
                        objRememberedValue3 = mutableStateMutableStateOf$default1111110;
                    } else {
                        activityTitle = documentState.getConfiguration().getActivityTitle();
                        if (activityTitle == null) {
                            activityTitle = "";
                        }
                        MutableState mutableStateMutableStateOf$default1111111 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(activityTitle, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default1111111);
                        objRememberedValue3 = mutableStateMutableStateOf$default1111111;
                    }
                    final MutableState mutableState11112 = (MutableState) objRememberedValue3;
                    resources = (Resources) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalResources());
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == companion.getEmpty()) {
                        MutableState mutableStateMutableStateOf$default1111112 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(resources.getBoolean(R.bool.pspdf__display_document_title_in_actionbar)), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default1111112);
                        objRememberedValue4 = mutableStateMutableStateOf$default1111112;
                    }
                    final MutableState mutableState11113 = (MutableState) objRememberedValue4;
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == companion.getEmpty()) {
                        objRememberedValue5 = SnapshotIntStateKt.mutableIntStateOf(0);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    final MutableIntState mutableIntState11 = (MutableIntState) objRememberedValue5;
                    gc customPdfActions11 = documentState.getCustomPdfActions();
                    zChangedInstance = composerStartRestartGroup.changedInstance(documentState) | composerStartRestartGroup.changedInstance(coroutineScope);
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance) {
                        objRememberedValue6 = new MainToolbarKt$MainToolbar$1$1(documentState, coroutineScope, mutableState, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    } else {
                        objRememberedValue6 = new MainToolbarKt$MainToolbar$1$1(documentState, coroutineScope, mutableState, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    EffectsKt.LaunchedEffect(customPdfActions11, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue6, composerStartRestartGroup, 0);
                    zChanged2 = composerStartRestartGroup.changed(MainToolbar$lambda$3(stateCollectAsState));
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2) {
                        MutableState mutableStateMutableStateOf$default1111113 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getActionMenu(MainToolbar$lambda$3(stateCollectAsState)), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default1111113);
                        objRememberedValue7 = mutableStateMutableStateOf$default1111113;
                    } else {
                        MutableState mutableStateMutableStateOf$default1111114 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getActionMenu(MainToolbar$lambda$3(stateCollectAsState)), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default1111114);
                        objRememberedValue7 = mutableStateMutableStateOf$default1111114;
                    }
                    final MutableState mutableState11114 = (MutableState) objRememberedValue7;
                    zChanged3 = composerStartRestartGroup.changed(MainToolbar$lambda$3(stateCollectAsState));
                    objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                    if (zChanged3) {
                        objRememberedValue8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getHiddenMenu(MainToolbar$lambda$3(stateCollectAsState)), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    } else {
                        objRememberedValue8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getHiddenMenu(MainToolbar$lambda$3(stateCollectAsState)), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    }
                    final MutableState mutableState11115 = (MutableState) objRememberedValue8;
                    final Modifier modifier14 = modifier2;
                    final Function1 function1116 = function15;
                    final Function4 function1117 = function12;
                    windowInsets3 = windowInsets2;
                    ThemeWrapperKt.WithUiTheme(uiColorScheme14, ComposableLambdaKt.rememberComposableLambda(38712441, true, new Function2() { // from class: com.pspdfkit.jetpack.compose.components.MainToolbarKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return MainToolbarKt.MainToolbar$lambda$17(function1116, mutableIntState11, modifier14, windowInsets3, z16, documentState, function1117, mutableState, mutableState11115, stateCollectAsState, function14, mutableState11112, mutableState11113, lambda$1623726612$sdk_nutrient, function13, mutableState11114, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i14 >> 6) & 14) | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function2 = function1116;
                    modifier3 = modifier14;
                    composer2 = composerStartRestartGroup;
                    uiColorScheme3 = uiColorScheme14;
                    z3 = z16;
                    function8 = function1117;
                    function10 = function14;
                    function9 = function13;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    composer2 = composerStartRestartGroup;
                    uiColorScheme3 = uiColorScheme2;
                    windowInsets3 = windowInsets2;
                    function8 = function6;
                    z3 = z;
                    function2 = function1;
                    function9 = lambda$1210789952$sdk_nutrient;
                    function10 = function7;
                }
                function11 = lambda$1623726612$sdk_nutrient;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.jetpack.compose.components.MainToolbarKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return MainToolbarKt.MainToolbar$lambda$18(modifier3, documentState, uiColorScheme3, windowInsets3, function10, function11, function9, function8, z3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 100663296;
            i12 = i2 & 512;
            if (i12 != 0) {
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i13 = 268435456;
                    }
                    i3 |= i13;
                }
                if ((i3 & 306783379) != 306783378) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 4) != 0) {
                            uiColors = UiThemeKt.getUiColors(composerStartRestartGroup, 0);
                            i3 &= -897;
                        } else {
                            uiColors = uiColorScheme2;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            windowInsets2 = TopAppBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, TopAppBarDefaults.$stable);
                        }
                        if (i18 != 0) {
                            function7 = null;
                        }
                        if (i4 != 0) {
                            lambda$1623726612$sdk_nutrient = ComposableSingletons$MainToolbarKt.INSTANCE.getLambda$1623726612$sdk_nutrient();
                        }
                        if (i6 != 0) {
                            lambda$1210789952$sdk_nutrient = ComposableSingletons$MainToolbarKt.INSTANCE.getLambda$1210789952$sdk_nutrient();
                        }
                        if (i8 != 0) {
                            function12 = null;
                        } else {
                            function12 = function6;
                        }
                        if (i10 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        function13 = lambda$1210789952$sdk_nutrient;
                        z5 = z4;
                        function14 = function7;
                        i14 = i3;
                        if (i12 != 0) {
                            function15 = null;
                        } else {
                            function15 = function1;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 4) != 0) {
                            uiColors = UiThemeKt.getUiColors(composerStartRestartGroup, 0);
                            i3 &= -897;
                        } else {
                            uiColors = uiColorScheme2;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            windowInsets2 = TopAppBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, TopAppBarDefaults.$stable);
                        }
                        if (i18 != 0) {
                            function7 = null;
                        }
                        if (i4 != 0) {
                            lambda$1623726612$sdk_nutrient = ComposableSingletons$MainToolbarKt.INSTANCE.getLambda$1623726612$sdk_nutrient();
                        }
                        if (i6 != 0) {
                            lambda$1210789952$sdk_nutrient = ComposableSingletons$MainToolbarKt.INSTANCE.getLambda$1210789952$sdk_nutrient();
                        }
                        if (i8 != 0) {
                            function12 = null;
                        } else {
                            function12 = function6;
                        }
                        if (i10 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        function13 = lambda$1210789952$sdk_nutrient;
                        z5 = z4;
                        function14 = function7;
                        i14 = i3;
                        if (i12 != 0) {
                            function15 = null;
                        } else {
                            function15 = function1;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-55603716, i14, -1, "com.pspdfkit.jetpack.compose.components.MainToolbar (MainToolbar.kt:97)");
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.INSTANCE;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    coroutineScope = (CoroutineScope) objRememberedValue;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        coroutineContext = null;
                        MutableState mutableStateMutableStateOf$default1111115 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default1111115);
                        objRememberedValue2 = mutableStateMutableStateOf$default1111115;
                    } else {
                        coroutineContext = null;
                    }
                    mutableState = (MutableState) objRememberedValue2;
                    UiColorScheme uiColorScheme15 = uiColors;
                    final boolean z17 = z5;
                    stateCollectAsState = SnapshotStateKt.collectAsState(documentState.getMenuConfigurationState$sdk_nutrient(), coroutineContext, composerStartRestartGroup, 0, 1);
                    State stateCollectAsState13 = SnapshotStateKt.collectAsState(documentState.getActiveViewState(), coroutineContext, composerStartRestartGroup, 0, 1);
                    bv bvVarMainToolbar$lambda$14 = MainToolbar$lambda$3(stateCollectAsState);
                    bv.a aVarMainToolbar$lambda$15 = MainToolbar$lambda$4(stateCollectAsState13);
                    bvVarMainToolbar$lambda$14.getClass();
                    aVarMainToolbar$lambda$15.getClass();
                    bvVarMainToolbar$lambda$14.e = aVarMainToolbar$lambda$15;
                    zChanged = composerStartRestartGroup.changed(documentState.getTitle());
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        activityTitle = documentState.getConfiguration().getActivityTitle();
                        if (activityTitle == null) {
                            activityTitle = "";
                        }
                        MutableState mutableStateMutableStateOf$default1111116 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(activityTitle, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default1111116);
                        objRememberedValue3 = mutableStateMutableStateOf$default1111116;
                    } else {
                        activityTitle = documentState.getConfiguration().getActivityTitle();
                        if (activityTitle == null) {
                            activityTitle = "";
                        }
                        MutableState mutableStateMutableStateOf$default1111117 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(activityTitle, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default1111117);
                        objRememberedValue3 = mutableStateMutableStateOf$default1111117;
                    }
                    final MutableState mutableState11116 = (MutableState) objRememberedValue3;
                    resources = (Resources) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalResources());
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == companion.getEmpty()) {
                        MutableState mutableStateMutableStateOf$default1111118 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(resources.getBoolean(R.bool.pspdf__display_document_title_in_actionbar)), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default1111118);
                        objRememberedValue4 = mutableStateMutableStateOf$default1111118;
                    }
                    final MutableState mutableState11117 = (MutableState) objRememberedValue4;
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == companion.getEmpty()) {
                        objRememberedValue5 = SnapshotIntStateKt.mutableIntStateOf(0);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    final MutableIntState mutableIntState12 = (MutableIntState) objRememberedValue5;
                    gc customPdfActions12 = documentState.getCustomPdfActions();
                    zChangedInstance = composerStartRestartGroup.changedInstance(documentState) | composerStartRestartGroup.changedInstance(coroutineScope);
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance) {
                        objRememberedValue6 = new MainToolbarKt$MainToolbar$1$1(documentState, coroutineScope, mutableState, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    } else {
                        objRememberedValue6 = new MainToolbarKt$MainToolbar$1$1(documentState, coroutineScope, mutableState, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    EffectsKt.LaunchedEffect(customPdfActions12, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue6, composerStartRestartGroup, 0);
                    zChanged2 = composerStartRestartGroup.changed(MainToolbar$lambda$3(stateCollectAsState));
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2) {
                        MutableState mutableStateMutableStateOf$default1111119 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getActionMenu(MainToolbar$lambda$3(stateCollectAsState)), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default1111119);
                        objRememberedValue7 = mutableStateMutableStateOf$default1111119;
                    } else {
                        MutableState mutableStateMutableStateOf$default11111110 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getActionMenu(MainToolbar$lambda$3(stateCollectAsState)), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default11111110);
                        objRememberedValue7 = mutableStateMutableStateOf$default11111110;
                    }
                    final MutableState mutableState11118 = (MutableState) objRememberedValue7;
                    zChanged3 = composerStartRestartGroup.changed(MainToolbar$lambda$3(stateCollectAsState));
                    objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                    if (zChanged3) {
                        objRememberedValue8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getHiddenMenu(MainToolbar$lambda$3(stateCollectAsState)), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    } else {
                        objRememberedValue8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getHiddenMenu(MainToolbar$lambda$3(stateCollectAsState)), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    }
                    final MutableState mutableState11119 = (MutableState) objRememberedValue8;
                    final Modifier modifier15 = modifier2;
                    final Function1 function1118 = function15;
                    final Function4 function1119 = function12;
                    windowInsets3 = windowInsets2;
                    ThemeWrapperKt.WithUiTheme(uiColorScheme15, ComposableLambdaKt.rememberComposableLambda(38712441, true, new Function2() { // from class: com.pspdfkit.jetpack.compose.components.MainToolbarKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return MainToolbarKt.MainToolbar$lambda$17(function1118, mutableIntState12, modifier15, windowInsets3, z17, documentState, function1119, mutableState, mutableState11119, stateCollectAsState, function14, mutableState11116, mutableState11117, lambda$1623726612$sdk_nutrient, function13, mutableState11118, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i14 >> 6) & 14) | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function2 = function1118;
                    modifier3 = modifier15;
                    composer2 = composerStartRestartGroup;
                    uiColorScheme3 = uiColorScheme15;
                    z3 = z17;
                    function8 = function1119;
                    function10 = function14;
                    function9 = function13;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    composer2 = composerStartRestartGroup;
                    uiColorScheme3 = uiColorScheme2;
                    windowInsets3 = windowInsets2;
                    function8 = function6;
                    z3 = z;
                    function2 = function1;
                    function9 = lambda$1210789952$sdk_nutrient;
                    function10 = function7;
                }
                function11 = lambda$1623726612$sdk_nutrient;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.jetpack.compose.components.MainToolbarKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return MainToolbarKt.MainToolbar$lambda$18(modifier3, documentState, uiColorScheme3, windowInsets3, function10, function11, function9, function8, z3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 805306368;
            if ((i3 & 306783379) != 306783378) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i15 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 4) != 0) {
                        uiColors = UiThemeKt.getUiColors(composerStartRestartGroup, 0);
                        i3 &= -897;
                    } else {
                        uiColors = uiColorScheme2;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        windowInsets2 = TopAppBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, TopAppBarDefaults.$stable);
                    }
                    if (i18 != 0) {
                        function7 = null;
                    }
                    if (i4 != 0) {
                        lambda$1623726612$sdk_nutrient = ComposableSingletons$MainToolbarKt.INSTANCE.getLambda$1623726612$sdk_nutrient();
                    }
                    if (i6 != 0) {
                        lambda$1210789952$sdk_nutrient = ComposableSingletons$MainToolbarKt.INSTANCE.getLambda$1210789952$sdk_nutrient();
                    }
                    if (i8 != 0) {
                        function12 = null;
                    } else {
                        function12 = function6;
                    }
                    if (i10 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    function13 = lambda$1210789952$sdk_nutrient;
                    z5 = z4;
                    function14 = function7;
                    i14 = i3;
                    if (i12 != 0) {
                        function15 = null;
                    } else {
                        function15 = function1;
                    }
                } else {
                    if (i15 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 4) != 0) {
                        uiColors = UiThemeKt.getUiColors(composerStartRestartGroup, 0);
                        i3 &= -897;
                    } else {
                        uiColors = uiColorScheme2;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        windowInsets2 = TopAppBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, TopAppBarDefaults.$stable);
                    }
                    if (i18 != 0) {
                        function7 = null;
                    }
                    if (i4 != 0) {
                        lambda$1623726612$sdk_nutrient = ComposableSingletons$MainToolbarKt.INSTANCE.getLambda$1623726612$sdk_nutrient();
                    }
                    if (i6 != 0) {
                        lambda$1210789952$sdk_nutrient = ComposableSingletons$MainToolbarKt.INSTANCE.getLambda$1210789952$sdk_nutrient();
                    }
                    if (i8 != 0) {
                        function12 = null;
                    } else {
                        function12 = function6;
                    }
                    if (i10 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    function13 = lambda$1210789952$sdk_nutrient;
                    z5 = z4;
                    function14 = function7;
                    i14 = i3;
                    if (i12 != 0) {
                        function15 = null;
                    } else {
                        function15 = function1;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-55603716, i14, -1, "com.pspdfkit.jetpack.compose.components.MainToolbar (MainToolbar.kt:97)");
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                coroutineScope = (CoroutineScope) objRememberedValue;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    coroutineContext = null;
                    MutableState mutableStateMutableStateOf$default11111111 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default11111111);
                    objRememberedValue2 = mutableStateMutableStateOf$default11111111;
                } else {
                    coroutineContext = null;
                }
                mutableState = (MutableState) objRememberedValue2;
                UiColorScheme uiColorScheme16 = uiColors;
                final boolean z18 = z5;
                stateCollectAsState = SnapshotStateKt.collectAsState(documentState.getMenuConfigurationState$sdk_nutrient(), coroutineContext, composerStartRestartGroup, 0, 1);
                State stateCollectAsState14 = SnapshotStateKt.collectAsState(documentState.getActiveViewState(), coroutineContext, composerStartRestartGroup, 0, 1);
                bv bvVarMainToolbar$lambda$15 = MainToolbar$lambda$3(stateCollectAsState);
                bv.a aVarMainToolbar$lambda$16 = MainToolbar$lambda$4(stateCollectAsState14);
                bvVarMainToolbar$lambda$15.getClass();
                aVarMainToolbar$lambda$16.getClass();
                bvVarMainToolbar$lambda$15.e = aVarMainToolbar$lambda$16;
                zChanged = composerStartRestartGroup.changed(documentState.getTitle());
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    activityTitle = documentState.getConfiguration().getActivityTitle();
                    if (activityTitle == null) {
                        activityTitle = "";
                    }
                    MutableState mutableStateMutableStateOf$default11111112 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(activityTitle, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default11111112);
                    objRememberedValue3 = mutableStateMutableStateOf$default11111112;
                } else {
                    activityTitle = documentState.getConfiguration().getActivityTitle();
                    if (activityTitle == null) {
                        activityTitle = "";
                    }
                    MutableState mutableStateMutableStateOf$default11111113 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(activityTitle, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default11111113);
                    objRememberedValue3 = mutableStateMutableStateOf$default11111113;
                }
                final MutableState mutableState111110 = (MutableState) objRememberedValue3;
                resources = (Resources) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalResources());
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == companion.getEmpty()) {
                    MutableState mutableStateMutableStateOf$default11111114 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(resources.getBoolean(R.bool.pspdf__display_document_title_in_actionbar)), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default11111114);
                    objRememberedValue4 = mutableStateMutableStateOf$default11111114;
                }
                final MutableState mutableState111111 = (MutableState) objRememberedValue4;
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == companion.getEmpty()) {
                    objRememberedValue5 = SnapshotIntStateKt.mutableIntStateOf(0);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                final MutableIntState mutableIntState13 = (MutableIntState) objRememberedValue5;
                gc customPdfActions13 = documentState.getCustomPdfActions();
                zChangedInstance = composerStartRestartGroup.changedInstance(documentState) | composerStartRestartGroup.changedInstance(coroutineScope);
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance) {
                    objRememberedValue6 = new MainToolbarKt$MainToolbar$1$1(documentState, coroutineScope, mutableState, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                } else {
                    objRememberedValue6 = new MainToolbarKt$MainToolbar$1$1(documentState, coroutineScope, mutableState, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                EffectsKt.LaunchedEffect(customPdfActions13, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue6, composerStartRestartGroup, 0);
                zChanged2 = composerStartRestartGroup.changed(MainToolbar$lambda$3(stateCollectAsState));
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (zChanged2) {
                    MutableState mutableStateMutableStateOf$default11111115 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getActionMenu(MainToolbar$lambda$3(stateCollectAsState)), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default11111115);
                    objRememberedValue7 = mutableStateMutableStateOf$default11111115;
                } else {
                    MutableState mutableStateMutableStateOf$default11111116 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getActionMenu(MainToolbar$lambda$3(stateCollectAsState)), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default11111116);
                    objRememberedValue7 = mutableStateMutableStateOf$default11111116;
                }
                final MutableState mutableState111112 = (MutableState) objRememberedValue7;
                zChanged3 = composerStartRestartGroup.changed(MainToolbar$lambda$3(stateCollectAsState));
                objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                if (zChanged3) {
                    objRememberedValue8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getHiddenMenu(MainToolbar$lambda$3(stateCollectAsState)), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                } else {
                    objRememberedValue8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getHiddenMenu(MainToolbar$lambda$3(stateCollectAsState)), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                }
                final MutableState mutableState111113 = (MutableState) objRememberedValue8;
                final Modifier modifier16 = modifier2;
                final Function1 function11110 = function15;
                final Function4 function11111 = function12;
                windowInsets3 = windowInsets2;
                ThemeWrapperKt.WithUiTheme(uiColorScheme16, ComposableLambdaKt.rememberComposableLambda(38712441, true, new Function2() { // from class: com.pspdfkit.jetpack.compose.components.MainToolbarKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return MainToolbarKt.MainToolbar$lambda$17(function11110, mutableIntState13, modifier16, windowInsets3, z18, documentState, function11111, mutableState, mutableState111113, stateCollectAsState, function14, mutableState111110, mutableState111111, lambda$1623726612$sdk_nutrient, function13, mutableState111112, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i14 >> 6) & 14) | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function2 = function11110;
                modifier3 = modifier16;
                composer2 = composerStartRestartGroup;
                uiColorScheme3 = uiColorScheme16;
                z3 = z18;
                function8 = function11111;
                function10 = function14;
                function9 = function13;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                composer2 = composerStartRestartGroup;
                uiColorScheme3 = uiColorScheme2;
                windowInsets3 = windowInsets2;
                function8 = function6;
                z3 = z;
                function2 = function1;
                function9 = lambda$1210789952$sdk_nutrient;
                function10 = function7;
            }
            function11 = lambda$1623726612$sdk_nutrient;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.jetpack.compose.components.MainToolbarKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return MainToolbarKt.MainToolbar$lambda$18(modifier3, documentState, uiColorScheme3, windowInsets3, function10, function11, function9, function8, z3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        lambda$1623726612$sdk_nutrient = function4;
        i6 = i2 & 64;
        if (i6 != 0) {
            i3 |= 1572864;
            lambda$1210789952$sdk_nutrient = function5;
        } else {
            lambda$1210789952$sdk_nutrient = function5;
            if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changedInstance(lambda$1210789952$sdk_nutrient)) {
                    i7 = 1048576;
                } else {
                    i7 = 524288;
                }
                i3 |= i7;
            }
        }
        i8 = i2 & 128;
        if (i8 != 0) {
            i3 |= 12582912;
        } else if ((i & 12582912) == 0) {
            if (composerStartRestartGroup.changedInstance(function6)) {
                i9 = 8388608;
            } else {
                i9 = 4194304;
            }
            i3 |= i9;
        }
        i10 = i2 & 256;
        if (i10 != 0) {
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changed(z)) {
                    i11 = 67108864;
                } else {
                    i11 = 33554432;
                }
                i3 |= i11;
            }
            i12 = i2 & 512;
            if (i12 != 0) {
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i13 = 268435456;
                    }
                    i3 |= i13;
                }
                if ((i3 & 306783379) != 306783378) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i & 1) != 0) {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 4) != 0) {
                            uiColors = UiThemeKt.getUiColors(composerStartRestartGroup, 0);
                            i3 &= -897;
                        } else {
                            uiColors = uiColorScheme2;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            windowInsets2 = TopAppBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, TopAppBarDefaults.$stable);
                        }
                        if (i18 != 0) {
                            function7 = null;
                        }
                        if (i4 != 0) {
                            lambda$1623726612$sdk_nutrient = ComposableSingletons$MainToolbarKt.INSTANCE.getLambda$1623726612$sdk_nutrient();
                        }
                        if (i6 != 0) {
                            lambda$1210789952$sdk_nutrient = ComposableSingletons$MainToolbarKt.INSTANCE.getLambda$1210789952$sdk_nutrient();
                        }
                        if (i8 != 0) {
                            function12 = null;
                        } else {
                            function12 = function6;
                        }
                        if (i10 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        function13 = lambda$1210789952$sdk_nutrient;
                        z5 = z4;
                        function14 = function7;
                        i14 = i3;
                        if (i12 != 0) {
                            function15 = null;
                        } else {
                            function15 = function1;
                        }
                    } else {
                        if (i15 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if ((i2 & 4) != 0) {
                            uiColors = UiThemeKt.getUiColors(composerStartRestartGroup, 0);
                            i3 &= -897;
                        } else {
                            uiColors = uiColorScheme2;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            windowInsets2 = TopAppBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, TopAppBarDefaults.$stable);
                        }
                        if (i18 != 0) {
                            function7 = null;
                        }
                        if (i4 != 0) {
                            lambda$1623726612$sdk_nutrient = ComposableSingletons$MainToolbarKt.INSTANCE.getLambda$1623726612$sdk_nutrient();
                        }
                        if (i6 != 0) {
                            lambda$1210789952$sdk_nutrient = ComposableSingletons$MainToolbarKt.INSTANCE.getLambda$1210789952$sdk_nutrient();
                        }
                        if (i8 != 0) {
                            function12 = null;
                        } else {
                            function12 = function6;
                        }
                        if (i10 != 0) {
                            z4 = true;
                        } else {
                            z4 = z;
                        }
                        function13 = lambda$1210789952$sdk_nutrient;
                        z5 = z4;
                        function14 = function7;
                        i14 = i3;
                        if (i12 != 0) {
                            function15 = null;
                        } else {
                            function15 = function1;
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-55603716, i14, -1, "com.pspdfkit.jetpack.compose.components.MainToolbar (MainToolbar.kt:97)");
                    }
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    companion = Composer.INSTANCE;
                    if (objRememberedValue == companion.getEmpty()) {
                        objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    coroutineScope = (CoroutineScope) objRememberedValue;
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == companion.getEmpty()) {
                        coroutineContext = null;
                        MutableState mutableStateMutableStateOf$default11111117 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default11111117);
                        objRememberedValue2 = mutableStateMutableStateOf$default11111117;
                    } else {
                        coroutineContext = null;
                    }
                    mutableState = (MutableState) objRememberedValue2;
                    UiColorScheme uiColorScheme17 = uiColors;
                    final boolean z19 = z5;
                    stateCollectAsState = SnapshotStateKt.collectAsState(documentState.getMenuConfigurationState$sdk_nutrient(), coroutineContext, composerStartRestartGroup, 0, 1);
                    State stateCollectAsState15 = SnapshotStateKt.collectAsState(documentState.getActiveViewState(), coroutineContext, composerStartRestartGroup, 0, 1);
                    bv bvVarMainToolbar$lambda$16 = MainToolbar$lambda$3(stateCollectAsState);
                    bv.a aVarMainToolbar$lambda$17 = MainToolbar$lambda$4(stateCollectAsState15);
                    bvVarMainToolbar$lambda$16.getClass();
                    aVarMainToolbar$lambda$17.getClass();
                    bvVarMainToolbar$lambda$16.e = aVarMainToolbar$lambda$17;
                    zChanged = composerStartRestartGroup.changed(documentState.getTitle());
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (zChanged) {
                        activityTitle = documentState.getConfiguration().getActivityTitle();
                        if (activityTitle == null) {
                            activityTitle = "";
                        }
                        MutableState mutableStateMutableStateOf$default11111118 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(activityTitle, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default11111118);
                        objRememberedValue3 = mutableStateMutableStateOf$default11111118;
                    } else {
                        activityTitle = documentState.getConfiguration().getActivityTitle();
                        if (activityTitle == null) {
                            activityTitle = "";
                        }
                        MutableState mutableStateMutableStateOf$default11111119 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(activityTitle, null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default11111119);
                        objRememberedValue3 = mutableStateMutableStateOf$default11111119;
                    }
                    final MutableState mutableState111114 = (MutableState) objRememberedValue3;
                    resources = (Resources) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalResources());
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == companion.getEmpty()) {
                        MutableState mutableStateMutableStateOf$default111111110 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(resources.getBoolean(R.bool.pspdf__display_document_title_in_actionbar)), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default111111110);
                        objRememberedValue4 = mutableStateMutableStateOf$default111111110;
                    }
                    final MutableState mutableState111115 = (MutableState) objRememberedValue4;
                    objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue5 == companion.getEmpty()) {
                        objRememberedValue5 = SnapshotIntStateKt.mutableIntStateOf(0);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                    }
                    final MutableIntState mutableIntState14 = (MutableIntState) objRememberedValue5;
                    gc customPdfActions14 = documentState.getCustomPdfActions();
                    zChangedInstance = composerStartRestartGroup.changedInstance(documentState) | composerStartRestartGroup.changedInstance(coroutineScope);
                    objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                    if (zChangedInstance) {
                        objRememberedValue6 = new MainToolbarKt$MainToolbar$1$1(documentState, coroutineScope, mutableState, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    } else {
                        objRememberedValue6 = new MainToolbarKt$MainToolbar$1$1(documentState, coroutineScope, mutableState, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                    }
                    EffectsKt.LaunchedEffect(customPdfActions14, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue6, composerStartRestartGroup, 0);
                    zChanged2 = composerStartRestartGroup.changed(MainToolbar$lambda$3(stateCollectAsState));
                    objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                    if (zChanged2) {
                        MutableState mutableStateMutableStateOf$default111111111 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getActionMenu(MainToolbar$lambda$3(stateCollectAsState)), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default111111111);
                        objRememberedValue7 = mutableStateMutableStateOf$default111111111;
                    } else {
                        MutableState mutableStateMutableStateOf$default111111112 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getActionMenu(MainToolbar$lambda$3(stateCollectAsState)), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default111111112);
                        objRememberedValue7 = mutableStateMutableStateOf$default111111112;
                    }
                    final MutableState mutableState111116 = (MutableState) objRememberedValue7;
                    zChanged3 = composerStartRestartGroup.changed(MainToolbar$lambda$3(stateCollectAsState));
                    objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                    if (zChanged3) {
                        objRememberedValue8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getHiddenMenu(MainToolbar$lambda$3(stateCollectAsState)), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    } else {
                        objRememberedValue8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getHiddenMenu(MainToolbar$lambda$3(stateCollectAsState)), null, 2, null);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                    }
                    final MutableState mutableState111117 = (MutableState) objRememberedValue8;
                    final Modifier modifier17 = modifier2;
                    final Function1 function11112 = function15;
                    final Function4 function11113 = function12;
                    windowInsets3 = windowInsets2;
                    ThemeWrapperKt.WithUiTheme(uiColorScheme17, ComposableLambdaKt.rememberComposableLambda(38712441, true, new Function2() { // from class: com.pspdfkit.jetpack.compose.components.MainToolbarKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return MainToolbarKt.MainToolbar$lambda$17(function11112, mutableIntState14, modifier17, windowInsets3, z19, documentState, function11113, mutableState, mutableState111117, stateCollectAsState, function14, mutableState111114, mutableState111115, lambda$1623726612$sdk_nutrient, function13, mutableState111116, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i14 >> 6) & 14) | 48);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function2 = function11112;
                    modifier3 = modifier17;
                    composer2 = composerStartRestartGroup;
                    uiColorScheme3 = uiColorScheme17;
                    z3 = z19;
                    function8 = function11113;
                    function10 = function14;
                    function9 = function13;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    composer2 = composerStartRestartGroup;
                    uiColorScheme3 = uiColorScheme2;
                    windowInsets3 = windowInsets2;
                    function8 = function6;
                    z3 = z;
                    function2 = function1;
                    function9 = lambda$1210789952$sdk_nutrient;
                    function10 = function7;
                }
                function11 = lambda$1623726612$sdk_nutrient;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.jetpack.compose.components.MainToolbarKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return MainToolbarKt.MainToolbar$lambda$18(modifier3, documentState, uiColorScheme3, windowInsets3, function10, function11, function9, function8, z3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 805306368;
            if ((i3 & 306783379) != 306783378) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i15 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 4) != 0) {
                        uiColors = UiThemeKt.getUiColors(composerStartRestartGroup, 0);
                        i3 &= -897;
                    } else {
                        uiColors = uiColorScheme2;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        windowInsets2 = TopAppBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, TopAppBarDefaults.$stable);
                    }
                    if (i18 != 0) {
                        function7 = null;
                    }
                    if (i4 != 0) {
                        lambda$1623726612$sdk_nutrient = ComposableSingletons$MainToolbarKt.INSTANCE.getLambda$1623726612$sdk_nutrient();
                    }
                    if (i6 != 0) {
                        lambda$1210789952$sdk_nutrient = ComposableSingletons$MainToolbarKt.INSTANCE.getLambda$1210789952$sdk_nutrient();
                    }
                    if (i8 != 0) {
                        function12 = null;
                    } else {
                        function12 = function6;
                    }
                    if (i10 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    function13 = lambda$1210789952$sdk_nutrient;
                    z5 = z4;
                    function14 = function7;
                    i14 = i3;
                    if (i12 != 0) {
                        function15 = null;
                    } else {
                        function15 = function1;
                    }
                } else {
                    if (i15 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 4) != 0) {
                        uiColors = UiThemeKt.getUiColors(composerStartRestartGroup, 0);
                        i3 &= -897;
                    } else {
                        uiColors = uiColorScheme2;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        windowInsets2 = TopAppBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, TopAppBarDefaults.$stable);
                    }
                    if (i18 != 0) {
                        function7 = null;
                    }
                    if (i4 != 0) {
                        lambda$1623726612$sdk_nutrient = ComposableSingletons$MainToolbarKt.INSTANCE.getLambda$1623726612$sdk_nutrient();
                    }
                    if (i6 != 0) {
                        lambda$1210789952$sdk_nutrient = ComposableSingletons$MainToolbarKt.INSTANCE.getLambda$1210789952$sdk_nutrient();
                    }
                    if (i8 != 0) {
                        function12 = null;
                    } else {
                        function12 = function6;
                    }
                    if (i10 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    function13 = lambda$1210789952$sdk_nutrient;
                    z5 = z4;
                    function14 = function7;
                    i14 = i3;
                    if (i12 != 0) {
                        function15 = null;
                    } else {
                        function15 = function1;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-55603716, i14, -1, "com.pspdfkit.jetpack.compose.components.MainToolbar (MainToolbar.kt:97)");
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                coroutineScope = (CoroutineScope) objRememberedValue;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    coroutineContext = null;
                    MutableState mutableStateMutableStateOf$default111111113 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default111111113);
                    objRememberedValue2 = mutableStateMutableStateOf$default111111113;
                } else {
                    coroutineContext = null;
                }
                mutableState = (MutableState) objRememberedValue2;
                UiColorScheme uiColorScheme18 = uiColors;
                final boolean z110 = z5;
                stateCollectAsState = SnapshotStateKt.collectAsState(documentState.getMenuConfigurationState$sdk_nutrient(), coroutineContext, composerStartRestartGroup, 0, 1);
                State stateCollectAsState16 = SnapshotStateKt.collectAsState(documentState.getActiveViewState(), coroutineContext, composerStartRestartGroup, 0, 1);
                bv bvVarMainToolbar$lambda$17 = MainToolbar$lambda$3(stateCollectAsState);
                bv.a aVarMainToolbar$lambda$18 = MainToolbar$lambda$4(stateCollectAsState16);
                bvVarMainToolbar$lambda$17.getClass();
                aVarMainToolbar$lambda$18.getClass();
                bvVarMainToolbar$lambda$17.e = aVarMainToolbar$lambda$18;
                zChanged = composerStartRestartGroup.changed(documentState.getTitle());
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    activityTitle = documentState.getConfiguration().getActivityTitle();
                    if (activityTitle == null) {
                        activityTitle = "";
                    }
                    MutableState mutableStateMutableStateOf$default111111114 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(activityTitle, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default111111114);
                    objRememberedValue3 = mutableStateMutableStateOf$default111111114;
                } else {
                    activityTitle = documentState.getConfiguration().getActivityTitle();
                    if (activityTitle == null) {
                        activityTitle = "";
                    }
                    MutableState mutableStateMutableStateOf$default111111115 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(activityTitle, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default111111115);
                    objRememberedValue3 = mutableStateMutableStateOf$default111111115;
                }
                final MutableState mutableState111118 = (MutableState) objRememberedValue3;
                resources = (Resources) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalResources());
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == companion.getEmpty()) {
                    MutableState mutableStateMutableStateOf$default111111116 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(resources.getBoolean(R.bool.pspdf__display_document_title_in_actionbar)), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default111111116);
                    objRememberedValue4 = mutableStateMutableStateOf$default111111116;
                }
                final MutableState mutableState111119 = (MutableState) objRememberedValue4;
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == companion.getEmpty()) {
                    objRememberedValue5 = SnapshotIntStateKt.mutableIntStateOf(0);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                final MutableIntState mutableIntState15 = (MutableIntState) objRememberedValue5;
                gc customPdfActions15 = documentState.getCustomPdfActions();
                zChangedInstance = composerStartRestartGroup.changedInstance(documentState) | composerStartRestartGroup.changedInstance(coroutineScope);
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance) {
                    objRememberedValue6 = new MainToolbarKt$MainToolbar$1$1(documentState, coroutineScope, mutableState, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                } else {
                    objRememberedValue6 = new MainToolbarKt$MainToolbar$1$1(documentState, coroutineScope, mutableState, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                EffectsKt.LaunchedEffect(customPdfActions15, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue6, composerStartRestartGroup, 0);
                zChanged2 = composerStartRestartGroup.changed(MainToolbar$lambda$3(stateCollectAsState));
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (zChanged2) {
                    MutableState mutableStateMutableStateOf$default111111117 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getActionMenu(MainToolbar$lambda$3(stateCollectAsState)), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default111111117);
                    objRememberedValue7 = mutableStateMutableStateOf$default111111117;
                } else {
                    MutableState mutableStateMutableStateOf$default111111118 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getActionMenu(MainToolbar$lambda$3(stateCollectAsState)), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default111111118);
                    objRememberedValue7 = mutableStateMutableStateOf$default111111118;
                }
                final MutableState mutableState1111110 = (MutableState) objRememberedValue7;
                zChanged3 = composerStartRestartGroup.changed(MainToolbar$lambda$3(stateCollectAsState));
                objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                if (zChanged3) {
                    objRememberedValue8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getHiddenMenu(MainToolbar$lambda$3(stateCollectAsState)), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                } else {
                    objRememberedValue8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getHiddenMenu(MainToolbar$lambda$3(stateCollectAsState)), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                }
                final MutableState mutableState1111111 = (MutableState) objRememberedValue8;
                final Modifier modifier18 = modifier2;
                final Function1 function11114 = function15;
                final Function4 function11115 = function12;
                windowInsets3 = windowInsets2;
                ThemeWrapperKt.WithUiTheme(uiColorScheme18, ComposableLambdaKt.rememberComposableLambda(38712441, true, new Function2() { // from class: com.pspdfkit.jetpack.compose.components.MainToolbarKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return MainToolbarKt.MainToolbar$lambda$17(function11114, mutableIntState15, modifier18, windowInsets3, z110, documentState, function11115, mutableState, mutableState1111111, stateCollectAsState, function14, mutableState111118, mutableState111119, lambda$1623726612$sdk_nutrient, function13, mutableState1111110, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i14 >> 6) & 14) | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function2 = function11114;
                modifier3 = modifier18;
                composer2 = composerStartRestartGroup;
                uiColorScheme3 = uiColorScheme18;
                z3 = z110;
                function8 = function11115;
                function10 = function14;
                function9 = function13;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                composer2 = composerStartRestartGroup;
                uiColorScheme3 = uiColorScheme2;
                windowInsets3 = windowInsets2;
                function8 = function6;
                z3 = z;
                function2 = function1;
                function9 = lambda$1210789952$sdk_nutrient;
                function10 = function7;
            }
            function11 = lambda$1623726612$sdk_nutrient;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.jetpack.compose.components.MainToolbarKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return MainToolbarKt.MainToolbar$lambda$18(modifier3, documentState, uiColorScheme3, windowInsets3, function10, function11, function9, function8, z3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 100663296;
        i12 = i2 & 512;
        if (i12 != 0) {
            if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i13 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i13 = 268435456;
                }
                i3 |= i13;
            }
            if ((i3 & 306783379) != 306783378) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0) {
                    if (i15 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 4) != 0) {
                        uiColors = UiThemeKt.getUiColors(composerStartRestartGroup, 0);
                        i3 &= -897;
                    } else {
                        uiColors = uiColorScheme2;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        windowInsets2 = TopAppBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, TopAppBarDefaults.$stable);
                    }
                    if (i18 != 0) {
                        function7 = null;
                    }
                    if (i4 != 0) {
                        lambda$1623726612$sdk_nutrient = ComposableSingletons$MainToolbarKt.INSTANCE.getLambda$1623726612$sdk_nutrient();
                    }
                    if (i6 != 0) {
                        lambda$1210789952$sdk_nutrient = ComposableSingletons$MainToolbarKt.INSTANCE.getLambda$1210789952$sdk_nutrient();
                    }
                    if (i8 != 0) {
                        function12 = null;
                    } else {
                        function12 = function6;
                    }
                    if (i10 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    function13 = lambda$1210789952$sdk_nutrient;
                    z5 = z4;
                    function14 = function7;
                    i14 = i3;
                    if (i12 != 0) {
                        function15 = null;
                    } else {
                        function15 = function1;
                    }
                } else {
                    if (i15 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if ((i2 & 4) != 0) {
                        uiColors = UiThemeKt.getUiColors(composerStartRestartGroup, 0);
                        i3 &= -897;
                    } else {
                        uiColors = uiColorScheme2;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        windowInsets2 = TopAppBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, TopAppBarDefaults.$stable);
                    }
                    if (i18 != 0) {
                        function7 = null;
                    }
                    if (i4 != 0) {
                        lambda$1623726612$sdk_nutrient = ComposableSingletons$MainToolbarKt.INSTANCE.getLambda$1623726612$sdk_nutrient();
                    }
                    if (i6 != 0) {
                        lambda$1210789952$sdk_nutrient = ComposableSingletons$MainToolbarKt.INSTANCE.getLambda$1210789952$sdk_nutrient();
                    }
                    if (i8 != 0) {
                        function12 = null;
                    } else {
                        function12 = function6;
                    }
                    if (i10 != 0) {
                        z4 = true;
                    } else {
                        z4 = z;
                    }
                    function13 = lambda$1210789952$sdk_nutrient;
                    z5 = z4;
                    function14 = function7;
                    i14 = i3;
                    if (i12 != 0) {
                        function15 = null;
                    } else {
                        function15 = function1;
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-55603716, i14, -1, "com.pspdfkit.jetpack.compose.components.MainToolbar (MainToolbar.kt:97)");
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                coroutineScope = (CoroutineScope) objRememberedValue;
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == companion.getEmpty()) {
                    coroutineContext = null;
                    MutableState mutableStateMutableStateOf$default111111119 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default111111119);
                    objRememberedValue2 = mutableStateMutableStateOf$default111111119;
                } else {
                    coroutineContext = null;
                }
                mutableState = (MutableState) objRememberedValue2;
                UiColorScheme uiColorScheme19 = uiColors;
                final boolean z111 = z5;
                stateCollectAsState = SnapshotStateKt.collectAsState(documentState.getMenuConfigurationState$sdk_nutrient(), coroutineContext, composerStartRestartGroup, 0, 1);
                State stateCollectAsState17 = SnapshotStateKt.collectAsState(documentState.getActiveViewState(), coroutineContext, composerStartRestartGroup, 0, 1);
                bv bvVarMainToolbar$lambda$18 = MainToolbar$lambda$3(stateCollectAsState);
                bv.a aVarMainToolbar$lambda$19 = MainToolbar$lambda$4(stateCollectAsState17);
                bvVarMainToolbar$lambda$18.getClass();
                aVarMainToolbar$lambda$19.getClass();
                bvVarMainToolbar$lambda$18.e = aVarMainToolbar$lambda$19;
                zChanged = composerStartRestartGroup.changed(documentState.getTitle());
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged) {
                    activityTitle = documentState.getConfiguration().getActivityTitle();
                    if (activityTitle == null) {
                        activityTitle = "";
                    }
                    MutableState mutableStateMutableStateOf$default1111111110 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(activityTitle, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default1111111110);
                    objRememberedValue3 = mutableStateMutableStateOf$default1111111110;
                } else {
                    activityTitle = documentState.getConfiguration().getActivityTitle();
                    if (activityTitle == null) {
                        activityTitle = "";
                    }
                    MutableState mutableStateMutableStateOf$default1111111111 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(activityTitle, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default1111111111);
                    objRememberedValue3 = mutableStateMutableStateOf$default1111111111;
                }
                final MutableState mutableState1111112 = (MutableState) objRememberedValue3;
                resources = (Resources) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalResources());
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == companion.getEmpty()) {
                    MutableState mutableStateMutableStateOf$default1111111112 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(resources.getBoolean(R.bool.pspdf__display_document_title_in_actionbar)), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default1111111112);
                    objRememberedValue4 = mutableStateMutableStateOf$default1111111112;
                }
                final MutableState mutableState1111113 = (MutableState) objRememberedValue4;
                objRememberedValue5 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue5 == companion.getEmpty()) {
                    objRememberedValue5 = SnapshotIntStateKt.mutableIntStateOf(0);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
                }
                final MutableIntState mutableIntState16 = (MutableIntState) objRememberedValue5;
                gc customPdfActions16 = documentState.getCustomPdfActions();
                zChangedInstance = composerStartRestartGroup.changedInstance(documentState) | composerStartRestartGroup.changedInstance(coroutineScope);
                objRememberedValue6 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance) {
                    objRememberedValue6 = new MainToolbarKt$MainToolbar$1$1(documentState, coroutineScope, mutableState, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                } else {
                    objRememberedValue6 = new MainToolbarKt$MainToolbar$1$1(documentState, coroutineScope, mutableState, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
                }
                EffectsKt.LaunchedEffect(customPdfActions16, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue6, composerStartRestartGroup, 0);
                zChanged2 = composerStartRestartGroup.changed(MainToolbar$lambda$3(stateCollectAsState));
                objRememberedValue7 = composerStartRestartGroup.rememberedValue();
                if (zChanged2) {
                    MutableState mutableStateMutableStateOf$default1111111113 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getActionMenu(MainToolbar$lambda$3(stateCollectAsState)), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default1111111113);
                    objRememberedValue7 = mutableStateMutableStateOf$default1111111113;
                } else {
                    MutableState mutableStateMutableStateOf$default1111111114 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getActionMenu(MainToolbar$lambda$3(stateCollectAsState)), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default1111111114);
                    objRememberedValue7 = mutableStateMutableStateOf$default1111111114;
                }
                final MutableState mutableState1111114 = (MutableState) objRememberedValue7;
                zChanged3 = composerStartRestartGroup.changed(MainToolbar$lambda$3(stateCollectAsState));
                objRememberedValue8 = composerStartRestartGroup.rememberedValue();
                if (zChanged3) {
                    objRememberedValue8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getHiddenMenu(MainToolbar$lambda$3(stateCollectAsState)), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                } else {
                    objRememberedValue8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getHiddenMenu(MainToolbar$lambda$3(stateCollectAsState)), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
                }
                final MutableState mutableState1111115 = (MutableState) objRememberedValue8;
                final Modifier modifier19 = modifier2;
                final Function1 function11116 = function15;
                final Function4 function11117 = function12;
                windowInsets3 = windowInsets2;
                ThemeWrapperKt.WithUiTheme(uiColorScheme19, ComposableLambdaKt.rememberComposableLambda(38712441, true, new Function2() { // from class: com.pspdfkit.jetpack.compose.components.MainToolbarKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return MainToolbarKt.MainToolbar$lambda$17(function11116, mutableIntState16, modifier19, windowInsets3, z111, documentState, function11117, mutableState, mutableState1111115, stateCollectAsState, function14, mutableState1111112, mutableState1111113, lambda$1623726612$sdk_nutrient, function13, mutableState1111114, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i14 >> 6) & 14) | 48);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function2 = function11116;
                modifier3 = modifier19;
                composer2 = composerStartRestartGroup;
                uiColorScheme3 = uiColorScheme19;
                z3 = z111;
                function8 = function11117;
                function10 = function14;
                function9 = function13;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                composer2 = composerStartRestartGroup;
                uiColorScheme3 = uiColorScheme2;
                windowInsets3 = windowInsets2;
                function8 = function6;
                z3 = z;
                function2 = function1;
                function9 = lambda$1210789952$sdk_nutrient;
                function10 = function7;
            }
            function11 = lambda$1623726612$sdk_nutrient;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.jetpack.compose.components.MainToolbarKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return MainToolbarKt.MainToolbar$lambda$18(modifier3, documentState, uiColorScheme3, windowInsets3, function10, function11, function9, function8, z3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 805306368;
        if ((i3 & 306783379) != 306783378) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i15 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i2 & 4) != 0) {
                    uiColors = UiThemeKt.getUiColors(composerStartRestartGroup, 0);
                    i3 &= -897;
                } else {
                    uiColors = uiColorScheme2;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    windowInsets2 = TopAppBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, TopAppBarDefaults.$stable);
                }
                if (i18 != 0) {
                    function7 = null;
                }
                if (i4 != 0) {
                    lambda$1623726612$sdk_nutrient = ComposableSingletons$MainToolbarKt.INSTANCE.getLambda$1623726612$sdk_nutrient();
                }
                if (i6 != 0) {
                    lambda$1210789952$sdk_nutrient = ComposableSingletons$MainToolbarKt.INSTANCE.getLambda$1210789952$sdk_nutrient();
                }
                if (i8 != 0) {
                    function12 = null;
                } else {
                    function12 = function6;
                }
                if (i10 != 0) {
                    z4 = true;
                } else {
                    z4 = z;
                }
                function13 = lambda$1210789952$sdk_nutrient;
                z5 = z4;
                function14 = function7;
                i14 = i3;
                if (i12 != 0) {
                    function15 = null;
                } else {
                    function15 = function1;
                }
            } else {
                if (i15 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if ((i2 & 4) != 0) {
                    uiColors = UiThemeKt.getUiColors(composerStartRestartGroup, 0);
                    i3 &= -897;
                } else {
                    uiColors = uiColorScheme2;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    windowInsets2 = TopAppBarDefaults.INSTANCE.getWindowInsets(composerStartRestartGroup, TopAppBarDefaults.$stable);
                }
                if (i18 != 0) {
                    function7 = null;
                }
                if (i4 != 0) {
                    lambda$1623726612$sdk_nutrient = ComposableSingletons$MainToolbarKt.INSTANCE.getLambda$1623726612$sdk_nutrient();
                }
                if (i6 != 0) {
                    lambda$1210789952$sdk_nutrient = ComposableSingletons$MainToolbarKt.INSTANCE.getLambda$1210789952$sdk_nutrient();
                }
                if (i8 != 0) {
                    function12 = null;
                } else {
                    function12 = function6;
                }
                if (i10 != 0) {
                    z4 = true;
                } else {
                    z4 = z;
                }
                function13 = lambda$1210789952$sdk_nutrient;
                z5 = z4;
                function14 = function7;
                i14 = i3;
                if (i12 != 0) {
                    function15 = null;
                } else {
                    function15 = function1;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-55603716, i14, -1, "com.pspdfkit.jetpack.compose.components.MainToolbar (MainToolbar.kt:97)");
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            coroutineScope = (CoroutineScope) objRememberedValue;
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == companion.getEmpty()) {
                coroutineContext = null;
                MutableState mutableStateMutableStateOf$default1111111115 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.FALSE, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default1111111115);
                objRememberedValue2 = mutableStateMutableStateOf$default1111111115;
            } else {
                coroutineContext = null;
            }
            mutableState = (MutableState) objRememberedValue2;
            UiColorScheme uiColorScheme110 = uiColors;
            final boolean z112 = z5;
            stateCollectAsState = SnapshotStateKt.collectAsState(documentState.getMenuConfigurationState$sdk_nutrient(), coroutineContext, composerStartRestartGroup, 0, 1);
            State stateCollectAsState18 = SnapshotStateKt.collectAsState(documentState.getActiveViewState(), coroutineContext, composerStartRestartGroup, 0, 1);
            bv bvVarMainToolbar$lambda$19 = MainToolbar$lambda$3(stateCollectAsState);
            bv.a aVarMainToolbar$lambda$110 = MainToolbar$lambda$4(stateCollectAsState18);
            bvVarMainToolbar$lambda$19.getClass();
            aVarMainToolbar$lambda$110.getClass();
            bvVarMainToolbar$lambda$19.e = aVarMainToolbar$lambda$110;
            zChanged = composerStartRestartGroup.changed(documentState.getTitle());
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                activityTitle = documentState.getConfiguration().getActivityTitle();
                if (activityTitle == null) {
                    activityTitle = "";
                }
                MutableState mutableStateMutableStateOf$default1111111116 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(activityTitle, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default1111111116);
                objRememberedValue3 = mutableStateMutableStateOf$default1111111116;
            } else {
                activityTitle = documentState.getConfiguration().getActivityTitle();
                if (activityTitle == null) {
                    activityTitle = "";
                }
                MutableState mutableStateMutableStateOf$default1111111117 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(activityTitle, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default1111111117);
                objRememberedValue3 = mutableStateMutableStateOf$default1111111117;
            }
            final MutableState mutableState1111116 = (MutableState) objRememberedValue3;
            resources = (Resources) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalResources());
            objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == companion.getEmpty()) {
                MutableState mutableStateMutableStateOf$default1111111118 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.valueOf(resources.getBoolean(R.bool.pspdf__display_document_title_in_actionbar)), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default1111111118);
                objRememberedValue4 = mutableStateMutableStateOf$default1111111118;
            }
            final MutableState mutableState1111117 = (MutableState) objRememberedValue4;
            objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue5 == companion.getEmpty()) {
                objRememberedValue5 = SnapshotIntStateKt.mutableIntStateOf(0);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            final MutableIntState mutableIntState17 = (MutableIntState) objRememberedValue5;
            gc customPdfActions17 = documentState.getCustomPdfActions();
            zChangedInstance = composerStartRestartGroup.changedInstance(documentState) | composerStartRestartGroup.changedInstance(coroutineScope);
            objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance) {
                objRememberedValue6 = new MainToolbarKt$MainToolbar$1$1(documentState, coroutineScope, mutableState, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            } else {
                objRememberedValue6 = new MainToolbarKt$MainToolbar$1$1(documentState, coroutineScope, mutableState, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            EffectsKt.LaunchedEffect(customPdfActions17, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue6, composerStartRestartGroup, 0);
            zChanged2 = composerStartRestartGroup.changed(MainToolbar$lambda$3(stateCollectAsState));
            objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (zChanged2) {
                MutableState mutableStateMutableStateOf$default1111111119 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getActionMenu(MainToolbar$lambda$3(stateCollectAsState)), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default1111111119);
                objRememberedValue7 = mutableStateMutableStateOf$default1111111119;
            } else {
                MutableState mutableStateMutableStateOf$default11111111110 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getActionMenu(MainToolbar$lambda$3(stateCollectAsState)), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default11111111110);
                objRememberedValue7 = mutableStateMutableStateOf$default11111111110;
            }
            final MutableState mutableState1111118 = (MutableState) objRememberedValue7;
            zChanged3 = composerStartRestartGroup.changed(MainToolbar$lambda$3(stateCollectAsState));
            objRememberedValue8 = composerStartRestartGroup.rememberedValue();
            if (zChanged3) {
                objRememberedValue8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getHiddenMenu(MainToolbar$lambda$3(stateCollectAsState)), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
            } else {
                objRememberedValue8 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(getHiddenMenu(MainToolbar$lambda$3(stateCollectAsState)), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
            }
            final MutableState mutableState1111119 = (MutableState) objRememberedValue8;
            final Modifier modifier110 = modifier2;
            final Function1 function11118 = function15;
            final Function4 function11119 = function12;
            windowInsets3 = windowInsets2;
            ThemeWrapperKt.WithUiTheme(uiColorScheme110, ComposableLambdaKt.rememberComposableLambda(38712441, true, new Function2() { // from class: com.pspdfkit.jetpack.compose.components.MainToolbarKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MainToolbarKt.MainToolbar$lambda$17(function11118, mutableIntState17, modifier110, windowInsets3, z112, documentState, function11119, mutableState, mutableState1111119, stateCollectAsState, function14, mutableState1111116, mutableState1111117, lambda$1623726612$sdk_nutrient, function13, mutableState1111118, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i14 >> 6) & 14) | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function2 = function11118;
            modifier3 = modifier110;
            composer2 = composerStartRestartGroup;
            uiColorScheme3 = uiColorScheme110;
            z3 = z112;
            function8 = function11119;
            function10 = function14;
            function9 = function13;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            composer2 = composerStartRestartGroup;
            uiColorScheme3 = uiColorScheme2;
            windowInsets3 = windowInsets2;
            function8 = function6;
            z3 = z;
            function2 = function1;
            function9 = lambda$1210789952$sdk_nutrient;
            function10 = function7;
        }
        function11 = lambda$1623726612$sdk_nutrient;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.jetpack.compose.components.MainToolbarKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MainToolbarKt.MainToolbar$lambda$18(modifier3, documentState, uiColorScheme3, windowInsets3, function10, function11, function9, function8, z3, function2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean MainToolbar$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final List<Integer> MainToolbar$lambda$14(MutableState<List<Integer>> mutableState) {
        return mutableState.getValue();
    }

    private static final List<Integer> MainToolbar$lambda$16(MutableState<List<Integer>> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MainToolbar$lambda$17(final Function1 function1, final MutableIntState mutableIntState, Modifier modifier, WindowInsets windowInsets, boolean z, final DocumentState documentState, final Function4 function4, final MutableState mutableState, final MutableState mutableState2, final State state, final Function3 function3, final MutableState mutableState3, final MutableState mutableState4, final Function3 function5, final Function4 function6, final MutableState mutableState5, Composer composer, int i) {
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(38712441, i, -1, "com.pspdfkit.jetpack.compose.components.MainToolbar.<anonymous> (MainToolbar.kt:125)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            boolean zChanged = composer.changed(function1);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.pspdfkit.jetpack.compose.components.MainToolbarKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return MainToolbarKt.MainToolbar$lambda$17$0$0(function1, mutableIntState, (LayoutCoordinates) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Modifier modifierOnGloballyPositioned = OnGloballyPositionedModifierKt.onGloballyPositioned(companion, (Function1) objRememberedValue);
            Arrangement.Vertical top = Arrangement.INSTANCE.getTop();
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), composer, 0);
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierOnGloballyPositioned);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion3.getConstructor();
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
            f2.a(companion3, composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, composerM6062constructorimpl, currentCompositionLocalMap);
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion3, composerM6062constructorimpl, Integer.valueOf(iHashCode), composerM6062constructorimpl));
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopEnd(), false);
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth$default);
            Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor2);
            } else {
                composer.useNode();
            }
            Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composer);
            f2.a(companion3, composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, composerM6062constructorimpl2, currentCompositionLocalMap2);
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion3, composerM6062constructorimpl2, Integer.valueOf(iHashCode2), composerM6062constructorimpl2));
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            Modifier modifierWrapContentSize$default = SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), companion2.getTopEnd(), false, 2, null);
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
            int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer, modifierWrapContentSize$default);
            Function0<ComposeUiNode> constructor3 = companion3.getConstructor();
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor3);
            } else {
                composer.useNode();
            }
            Composer composerM6062constructorimpl3 = Updater.m6062constructorimpl(composer);
            f2.a(companion3, composerM6062constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy2, composerM6062constructorimpl3, currentCompositionLocalMap3);
            Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier3, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion3, composerM6062constructorimpl3, Integer.valueOf(iHashCode3), composerM6062constructorimpl3));
            boolean zMainToolbar$lambda$1 = MainToolbar$lambda$1(mutableState);
            List<Integer> listMainToolbar$lambda$16 = MainToolbar$lambda$16(mutableState2);
            Function4 function4M14054getLambda$414266515$sdk_nutrient = function4 == null ? ComposableSingletons$MainToolbarKt.INSTANCE.m14054getLambda$414266515$sdk_nutrient() : function4;
            Object objRememberedValue2 = composer.rememberedValue();
            Composer.Companion companion4 = Composer.INSTANCE;
            if (objRememberedValue2 == companion4.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.pspdfkit.jetpack.compose.components.MainToolbarKt$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return MainToolbarKt.MainToolbar$lambda$17$1$0$0$0$0(mutableState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            Function0 function0 = (Function0) objRememberedValue2;
            bv bvVarMainToolbar$lambda$3 = MainToolbar$lambda$3(state);
            boolean zChangedInstance = composer.changedInstance(documentState);
            Object objRememberedValue3 = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue3 == companion4.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: com.pspdfkit.jetpack.compose.components.MainToolbarKt$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return MainToolbarKt.MainToolbar$lambda$17$1$0$0$1$0(documentState, mutableState, ((Integer) obj).intValue());
                    }
                };
                composer.updateRememberedValue(objRememberedValue3);
            }
            DropDownBox(zMainToolbar$lambda$1, listMainToolbar$lambda$16, function4M14054getLambda$414266515$sdk_nutrient, function0, bvVarMainToolbar$lambda$3, (Function1) objRememberedValue3, composer, 3072);
            composer.endNode();
            composer.endNode();
            AppBarKt.m2784TopAppBarGHTll3U(ComposableLambdaKt.rememberComposableLambda(1437046187, true, new Function2() { // from class: com.pspdfkit.jetpack.compose.components.MainToolbarKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MainToolbarKt.MainToolbar$lambda$17$1$1(function3, mutableState3, mutableState4, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), ShadowKt.m6412shadows4CzXII$default(ZIndexModifierKt.zIndex(companion, 1.0f), Dp.m9687constructorimpl(4), null, false, 0L, 0L, 30, null), ComposableLambdaKt.rememberComposableLambda(1900383209, true, new Function2() { // from class: com.pspdfkit.jetpack.compose.components.MainToolbarKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MainToolbarKt.MainToolbar$lambda$17$1$2(function5, state, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), ComposableLambdaKt.rememberComposableLambda(-1700169632, true, new Function3() { // from class: com.pspdfkit.jetpack.compose.components.MainToolbarKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return MainToolbarKt.MainToolbar$lambda$17$1$3(function6, function4, mutableState5, state, documentState, mutableState2, mutableState, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), Dp.m9687constructorimpl(58), windowInsets, TopAppBarDefaults.INSTANCE.m4782topAppBarColors5tl4gsc(UiTheme.INSTANCE.getColors(composer, 6).getMainToolbar().m13942getBackgroundColor0d7_KjU(), 0L, 0L, 0L, 0L, 0L, composer, TopAppBarDefaults.$stable << 18, 62), null, composer, 28086, 128);
            if (z) {
                composer.startReplaceGroup(1143369329);
                TitleBar(MainToolbar$lambda$8(mutableState4), MainToolbar$lambda$6(mutableState3), documentState.getConfiguration(), composer, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1143463507);
                composer.endReplaceGroup();
            }
            composer.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MainToolbar$lambda$17$0$0(Function1 function1, MutableIntState mutableIntState, LayoutCoordinates layoutCoordinates) {
        layoutCoordinates.getClass();
        if (function1 != null && mutableIntState.getIntValue() != ((int) (layoutCoordinates.mo8273getSizeYbymL2g() & 4294967295L))) {
            mutableIntState.setIntValue((int) (layoutCoordinates.mo8273getSizeYbymL2g() & 4294967295L));
            function1.invoke(Integer.valueOf(mutableIntState.getIntValue()));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MainToolbar$lambda$17$1$0$0$0$0(MutableState mutableState) {
        MainToolbar$lambda$2(mutableState, false);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MainToolbar$lambda$17$1$0$0$1$0(DocumentState documentState, MutableState mutableState, int i) {
        MainToolbar$lambda$2(mutableState, false);
        documentState.toggleView(i);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MainToolbar$lambda$17$1$1(Function3 function3, MutableState mutableState, MutableState mutableState2, Composer composer, int i) {
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1437046187, i, -1, "com.pspdfkit.jetpack.compose.components.MainToolbar.<anonymous>.<anonymous>.<anonymous> (MainToolbar.kt:164)");
            }
            if (function3 != null) {
                composer.startReplaceGroup(-1191000598);
                function3.invoke(MainToolbar$lambda$6(mutableState), composer, 0);
                composer.endReplaceGroup();
            } else if (MainToolbar$lambda$8(mutableState2)) {
                composer.startReplaceGroup(-1190892656);
                TextKt.m4494TextNvy7gAk(MainToolbar$lambda$6(mutableState), null, UiTheme.INSTANCE.getColors(composer, 6).getMainToolbar().m13943getTextColor0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 262138);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1190701417);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MainToolbar$lambda$17$1$2(Function3 function3, State state, Composer composer, int i) {
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1900383209, i, -1, "com.pspdfkit.jetpack.compose.components.MainToolbar.<anonymous>.<anonymous>.<anonymous> (MainToolbar.kt:162)");
            }
            function3.invoke(Color.m6804boximpl(ColorKt.Color(MainToolbar$lambda$3(state).c.b)), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MainToolbar$lambda$17$1$3(Function4 function4, Function4 function5, MutableState mutableState, final State state, final DocumentState documentState, MutableState mutableState2, final MutableState mutableState3, RowScope rowScope, Composer composer, int i) {
        int i2;
        Composer composer2 = composer;
        rowScope.getClass();
        if ((i & 6) == 0) {
            i2 = i | (composer2.changed(rowScope) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (composer2.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1700169632, i2, -1, "com.pspdfkit.jetpack.compose.components.MainToolbar.<anonymous>.<anonymous>.<anonymous> (MainToolbar.kt:174)");
            }
            composer2.startReplaceGroup(-1775441851);
            Iterator<T> it = MainToolbar$lambda$14(mutableState).iterator();
            while (it.hasNext()) {
                final int iIntValue = ((Number) it.next()).intValue();
                boolean zChanged = composer2.changed(state) | composer2.changed(iIntValue) | composer2.changedInstance(documentState);
                Object objRememberedValue = composer2.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.pspdfkit.jetpack.compose.components.MainToolbarKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return MainToolbarKt.MainToolbar$lambda$17$1$3$0$0$0(iIntValue, documentState, state);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue);
                }
                IconButtonKt.IconButton((Function0<Unit>) objRememberedValue, (Modifier) null, false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(1555109782, true, new Function2() { // from class: com.pspdfkit.jetpack.compose.components.MainToolbarKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return MainToolbarKt.MainToolbar$lambda$17$1$3$0$1(iIntValue, state, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer2, 54), composer, 1572864, 62);
                composer2 = composer;
            }
            composer2.endReplaceGroup();
            function4.invoke(rowScope, Color.m6804boximpl(ColorKt.Color(MainToolbar$lambda$3(state).c.b)), composer2, Integer.valueOf(i2 & 14));
            if (MainToolbar$lambda$16(mutableState2).isEmpty() && function5 == null) {
                composer2.startReplaceGroup(797403010);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(796956145);
                Object objRememberedValue2 = composer2.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.pspdfkit.jetpack.compose.components.MainToolbarKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return MainToolbarKt.MainToolbar$lambda$17$1$3$1$0(mutableState3);
                        }
                    };
                    composer2.updateRememberedValue(objRememberedValue2);
                }
                IconButtonKt.IconButton((Function0<Unit>) objRememberedValue2, (Modifier) null, false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$MainToolbarKt.INSTANCE.m14053getLambda$1062889127$sdk_nutrient(), composer2, 1572870, 62);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MainToolbar$lambda$17$1$3$0$0$0(int i, DocumentState documentState, State state) {
        if (MainToolbar$lambda$3(state).d(i)) {
            documentState.toggleView(i);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MainToolbar$lambda$17$1$3$0$1(int i, State state, Composer composer, int i2) {
        if (composer.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1555109782, i2, -1, "com.pspdfkit.jetpack.compose.components.MainToolbar.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MainToolbar.kt:180)");
            }
            Painter painterPainterResource = PainterResources_androidKt.painterResource(MainToolbar$lambda$3(state).a(i), composer, 0);
            String strB = MainToolbar$lambda$3(state).b(i);
            bv bvVarMainToolbar$lambda$3 = MainToolbar$lambda$3(state);
            boolean zC = bvVarMainToolbar$lambda$3.c(i);
            cv cvVar = bvVarMainToolbar$lambda$3.c;
            IconKt.m3575Iconww6aTOc(painterPainterResource, strB, (Modifier) null, Color.m6813copywmQWz5c$default(ColorKt.Color(zC ? cvVar.b : cvVar.a), MainToolbar$lambda$3(state).d(i) ? 1.0f : 0.5f, 0.0f, 0.0f, 0.0f, 14, null), composer, Painter.$stable, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MainToolbar$lambda$17$1$3$1$0(MutableState mutableState) {
        MainToolbar$lambda$2(mutableState, !MainToolbar$lambda$1(mutableState));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MainToolbar$lambda$18(Modifier modifier, DocumentState documentState, UiColorScheme uiColorScheme, WindowInsets windowInsets, Function3 function3, Function3 function4, Function4 function5, Function4 function6, boolean z, Function1 function1, int i, int i2, Composer composer, int i3) {
        MainToolbar(modifier, documentState, uiColorScheme, windowInsets, function3, function4, function5, function6, z, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final void MainToolbar$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    private static final bv MainToolbar$lambda$3(State<bv> state) {
        return state.getValue();
    }

    private static final bv.a MainToolbar$lambda$4(State<? extends bv.a> state) {
        return state.getValue();
    }

    private static final String MainToolbar$lambda$6(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean MainToolbar$lambda$8(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void TitleBar(final boolean z, final String str, final PdfActivityConfiguration pdfActivityConfiguration, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(441563471);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(str) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(pdfActivityConfiguration) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & Token.DOTQUERY) != 146, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(441563471, i2, -1, "com.pspdfkit.jetpack.compose.components.TitleBar (MainToolbar.kt:273)");
            }
            if (str == null) {
                composerStartRestartGroup.startReplaceGroup(-867332266);
                composerStartRestartGroup.endReplaceGroup();
                composer2 = composerStartRestartGroup;
            } else {
                composerStartRestartGroup.startReplaceGroup(-867332265);
                if (z || !pdfActivityConfiguration.isShowDocumentTitleOverlayEnabled()) {
                    composer2 = composerStartRestartGroup;
                    composer2.startReplaceGroup(-283348015);
                    composer2.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-283930381);
                    Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null);
                    UiTheme uiTheme = UiTheme.INSTANCE;
                    Modifier modifierM1219paddingVpY3zN4 = PaddingKt.m1219paddingVpY3zN4(BackgroundKt.m589backgroundbw27NRU$default(modifierFillMaxWidth$default, uiTheme.getColors(composerStartRestartGroup, 6).getMainToolbar().m13942getBackgroundColor0d7_KjU(), null, 2, null), Dp.m9687constructorimpl(16), Dp.m9687constructorimpl(4));
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), false);
                    int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1219paddingVpY3zN4);
                    ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                    Function0<ComposeUiNode> constructor = companion.getConstructor();
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
                    f2.a(companion, composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, composerM6062constructorimpl, currentCompositionLocalMap);
                    Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion, composerM6062constructorimpl, Integer.valueOf(iHashCode), composerM6062constructorimpl));
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    TextKt.m4494TextNvy7gAk(str, null, uiTheme.getColors(composerStartRestartGroup, 6).getMainToolbar().m13944getTitleTextColor0d7_KjU(), null, TextUnitKt.getSp(16), null, FontWeight.INSTANCE.getBold(), null, 0L, null, null, 0L, 0, false, 2, 0, null, null, composerStartRestartGroup, 1597440, 24576, 245674);
                    composer2 = composerStartRestartGroup;
                    composer2.endNode();
                    composer2.endReplaceGroup();
                }
                composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.jetpack.compose.components.MainToolbarKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MainToolbarKt.TitleBar$lambda$1(z, str, pdfActivityConfiguration, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit TitleBar$lambda$1(boolean z, String str, PdfActivityConfiguration pdfActivityConfiguration, int i, Composer composer, int i2) {
        TitleBar(z, str, pdfActivityConfiguration, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    private static final List<Integer> getActionMenu(bv bvVar) {
        ArrayList arrayListA = bvVar.a();
        ArrayList arrayList = new ArrayList();
        int size = arrayListA.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayListA.get(i);
            i++;
            int iIntValue = ((Number) obj).intValue();
            if (iIntValue != PdfActivity.MENU_OPTION_DOCUMENT_INFO && iIntValue != PdfActivity.MENU_OPTION_SETTINGS && iIntValue != PdfActivity.MENU_OPTION_SHARE) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }

    private static final List<Integer> getHiddenMenu(bv bvVar) {
        ArrayList arrayListA = bvVar.a();
        ArrayList arrayList = new ArrayList();
        int size = arrayListA.size();
        int i = 0;
        while (i < size) {
            Object obj = arrayListA.get(i);
            i++;
            int iIntValue = ((Number) obj).intValue();
            if (iIntValue == PdfActivity.MENU_OPTION_DOCUMENT_INFO || iIntValue == PdfActivity.MENU_OPTION_SETTINGS || iIntValue == PdfActivity.MENU_OPTION_SHARE) {
                arrayList.add(obj);
            }
        }
        return arrayList;
    }
}

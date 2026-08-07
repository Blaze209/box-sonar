package com.pspdfkit.internal;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.FloatingActionButtonKt;
import androidx.compose.material3.TextKt;
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
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextMeasurer;
import androidx.compose.ui.text.TextMeasurerHelperKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.PlatformImeOptions;
import androidx.compose.ui.text.input.VisualTransformation;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.profileinstaller.ProfileVerifier;
import com.pspdfkit.R;
import com.pspdfkit.compose.theme.DocumentInfoColorScheme;
import com.pspdfkit.compose.theme.DocumentInfoIconScheme;
import com.pspdfkit.compose.theme.UiTheme;
import com.pspdfkit.document.PageBinding;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
public final class jd {
    public static final Unit a(String str, String str2, boolean z, long j, Function1 function1, int i, Composer composer, int i2) {
        a(str, str2, z, j, (Function1<? super String, Unit>) function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final Unit b(PageBinding pageBinding, PageBinding pageBinding2, boolean z, Function0 function0, int i, Composer composer, int i2) {
        a(pageBinding, pageBinding2, z, (Function0<Unit>) function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final Unit a(Modifier modifier, rd rdVar, Function0 function0, int i, int i2, Composer composer, int i3) {
        a(modifier, rdVar, (Function0<Unit>) function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final Unit b(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    public static final Unit a(od odVar, rd rdVar, sd sdVar, int i, Composer composer, int i2) {
        a(odVar, rdVar, sdVar, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final Unit b(tt ttVar, MutableState mutableState) {
        PageBinding pageBinding = PageBinding.RIGHT_EDGE;
        ttVar.getClass();
        pageBinding.getClass();
        ttVar.e = pageBinding;
        ttVar.a(pageBinding.toString());
        mutableState.setValue(pageBinding);
        return Unit.INSTANCE;
    }

    public static final Unit a(tt ttVar, rd rdVar, sd sdVar, int i, Composer composer, int i2) {
        a(ttVar, rdVar, sdVar, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final Unit a(PageBinding pageBinding, PageBinding pageBinding2, boolean z, Function0 function0, int i, Composer composer, int i2) {
        a(pageBinding, pageBinding2, z, (Function0<Unit>) function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void a(Modifier modifier, final rd rdVar, final Function0<Unit> function0, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        final Modifier modifier3;
        rdVar.getClass();
        function0.getClass();
        Composer composerStartRestartGroup = composer.startRestartGroup(-2009077781);
        int i4 = i2 & 1;
        if (i4 != 0) {
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
            i3 |= composerStartRestartGroup.changedInstance(rdVar) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i3 & Token.DOTQUERY) != 146, i3 & 1)) {
            modifier3 = i4 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2009077781, i3, -1, "io.nutrient.internal.ui.documentinfo.DocumentInfoFab (DocumentInfoComponents.kt:63)");
            }
            UiTheme uiTheme = UiTheme.INSTANCE;
            DocumentInfoIconScheme documentInfoIconScheme = uiTheme.getIcons(composerStartRestartGroup, 6).getDocumentInfoIconScheme();
            final DocumentInfoColorScheme documentInfoColorScheme = uiTheme.getColors(composerStartRestartGroup, 6).getDocumentInfoColorScheme();
            if (!rdVar.a) {
                composerStartRestartGroup.startReplaceGroup(-2066649561);
                final int documentInfoFabDoneIcon = rdVar.c ? documentInfoIconScheme.getDocumentInfoFabDoneIcon() : documentInfoIconScheme.getDocumentInfoFabEditIcon();
                boolean z = (i3 & 896) == 256;
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.pspdfkit.internal.jd$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return jd.a(function0);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                Modifier modifierM1218padding3ABfNKs = PaddingKt.m1218padding3ABfNKs(modifier3, Dp.m9687constructorimpl(12));
                modifierM1218padding3ABfNKs.getClass();
                FloatingActionButtonKt.m3394FloatingActionButtonXz6DiA((Function0) objRememberedValue, modifierM1218padding3ABfNKs, null, documentInfoColorScheme.m13930getFabBackgroundColor0d7_KjU(), 0L, null, null, ComposableLambdaKt.rememberComposableLambda(2115635528, true, new Function2() { // from class: com.pspdfkit.internal.jd$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return jd.a(documentInfoFabDoneIcon, documentInfoColorScheme, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 12582912, 116);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-2066019145);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.jd$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return jd.a(modifier3, rdVar, function0, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final Unit a(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    public static final Unit a(int i, DocumentInfoColorScheme documentInfoColorScheme, Composer composer, int i2) {
        if (composer.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2115635528, i2, -1, "io.nutrient.internal.ui.documentinfo.DocumentInfoFab.<anonymous> (DocumentInfoComponents.kt:76)");
            }
            ImageKt.Image(PainterResources_androidKt.painterResource(i, composer, 0), (String) null, (Modifier) null, (Alignment) null, (ContentScale) null, 0.0f, ColorFilter.Companion.m6855tintxETnrds$default(ColorFilter.INSTANCE, documentInfoColorScheme.m13931getFabIconColor0d7_KjU(), 0, 2, null), composer, Painter.$stable | 48, 60);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final void a(final od odVar, final rd rdVar, final sd sdVar, Composer composer, final int i) {
        int i2;
        Composer composer2;
        odVar.getClass();
        rdVar.getClass();
        sdVar.getClass();
        Composer composerStartRestartGroup = composer.startRestartGroup(1306225332);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(odVar) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(rdVar) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(sdVar) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & Token.DOTQUERY) != 146, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1306225332, i2, -1, "io.nutrient.internal.ui.documentinfo.DocumentInfoItemComposable (DocumentInfoComponents.kt:95)");
            }
            long jM13934getItemTitleTextColor0d7_KjU = UiTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getDocumentInfoColorScheme().m13934getItemTitleTextColor0d7_KjU();
            Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            String str = odVar.b;
            str.getClass();
            TextKt.m4494TextNvy7gAk(str, null, jM13934getItemTitleTextColor0d7_KjU, null, sdVar.g, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 0, 0, 262122);
            SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), sdVar.l), composerStartRestartGroup, 0);
            String strA = no.a(context, R.string.pspdf__document_info_not_set, null);
            strA.getClass();
            String strA2 = odVar.a(context);
            strA2.getClass();
            boolean z = rdVar.c && odVar.d;
            long j = sdVar.h;
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(odVar);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.pspdfkit.internal.jd$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return jd.a(odVar, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            a(strA, strA2, z, j, (Function1<? super String, Unit>) objRememberedValue, composerStartRestartGroup, 0);
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.jd$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return jd.a(odVar, rdVar, sdVar, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final Unit a(od odVar, String str) {
        str.getClass();
        odVar.a(str);
        return Unit.INSTANCE;
    }

    public static final void a(final PageBinding pageBinding, final PageBinding pageBinding2, final boolean z, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Composer composer2;
        int i3;
        pageBinding.getClass();
        pageBinding2.getClass();
        function0.getClass();
        Composer composerStartRestartGroup = composer.startRestartGroup(-2145912543);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(pageBinding.ordinal()) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(pageBinding2.ordinal()) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 2048 : 1024;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2145912543, i2, -1, "io.nutrient.internal.ui.documentinfo.PageBindingIcon (DocumentInfoComponents.kt:123)");
            }
            if (!z) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.jd$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return jd.a(pageBinding, pageBinding2, z, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            DocumentInfoColorScheme documentInfoColorScheme = UiTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getDocumentInfoColorScheme();
            long jM13933getGroupTitleTextColor0d7_KjU = documentInfoColorScheme.m13933getGroupTitleTextColor0d7_KjU();
            Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            boolean z2 = pageBinding == pageBinding2;
            long jM13936getItemValueTextColor0d7_KjU = z2 ? jM13933getGroupTitleTextColor0d7_KjU : documentInfoColorScheme.m13936getItemValueTextColor0d7_KjU();
            if (!z2) {
                jM13933getGroupTitleTextColor0d7_KjU = documentInfoColorScheme.m13935getItemValueHintTextColor0d7_KjU();
            }
            long j = jM13933getGroupTitleTextColor0d7_KjU;
            PageBinding pageBinding3 = PageBinding.LEFT_EDGE;
            if (pageBinding == pageBinding3) {
                i3 = R.drawable.pspdf__document_binding_left;
            } else {
                i3 = R.drawable.pspdf__document_binding_right;
            }
            int i4 = pageBinding == pageBinding3 ? R.string.pspdf__page_binding_left : R.string.pspdf__page_binding_right;
            Alignment.Horizontal centerHorizontally = Alignment.INSTANCE.getCenterHorizontally();
            Modifier.Companion companion = Modifier.INSTANCE;
            boolean z3 = (i2 & 7168) == 2048;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.pspdfkit.internal.jd$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return jd.b(function0);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Modifier modifierM588backgroundbw27NRU = BackgroundKt.m588backgroundbw27NRU(PaddingKt.m1219paddingVpY3zN4(ClickableKt.m632clickableoSLSa3U$default(companion, false, null, null, null, (Function0) objRememberedValue, 15, null), Dp.m9687constructorimpl(16), Dp.m9687constructorimpl(4)), Color.INSTANCE.m6849getTransparent0d7_KjU(), RoundedCornerShapeKt.getCircleShape());
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), centerHorizontally, composerStartRestartGroup, 48);
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM588backgroundbw27NRU);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion2.getConstructor();
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
            f2.a(companion2, composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, composerM6062constructorimpl, currentCompositionLocalMap);
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion2, composerM6062constructorimpl, Integer.valueOf(iHashCode), composerM6062constructorimpl));
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ImageKt.Image(PainterResources_androidKt.painterResource(i3, composerStartRestartGroup, 0), (String) null, (Modifier) null, (Alignment) null, (ContentScale) null, 0.0f, ColorFilter.Companion.m6855tintxETnrds$default(ColorFilter.INSTANCE, jM13936getItemValueTextColor0d7_KjU, 0, 2, null), composerStartRestartGroup, Painter.$stable | 48, 60);
            composer2 = composerStartRestartGroup;
            String strA = no.a(context, i4, null);
            strA.getClass();
            TextKt.m4494TextNvy7gAk(strA, null, j, null, TextUnitKt.getSp(12), null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 24576, 0, 262122);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup2 != null) {
            scopeUpdateScopeEndRestartGroup2.updateScope(new Function2() { // from class: com.pspdfkit.internal.jd$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return jd.b(pageBinding, pageBinding2, z, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(final String str, final String str2, final boolean z, final long j, final Function1<? super String, Unit> function1, Composer composer, final int i) {
        int i2;
        boolean z2;
        Composer composer2;
        str.getClass();
        str2.getClass();
        function1.getClass();
        Composer composerStartRestartGroup = composer.startRestartGroup(-371881508);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(str2) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            z2 = z;
            i2 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
        } else {
            z2 = z;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changed(j) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 16384 : 8192;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 9363) != 9362, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-371881508, i2, -1, "io.nutrient.internal.ui.documentinfo.BottomOutlineTextField (DocumentInfoComponents.kt:161)");
            }
            boolean z3 = (i2 & 112) == 32;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z3 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str2, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            boolean zChanged = composerStartRestartGroup.changed((String) mutableState.getValue());
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                String str3 = (String) mutableState.getValue();
                if (str3.length() == 0) {
                    str3 = str;
                }
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(str3, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue2;
            final DocumentInfoColorScheme documentInfoColorScheme = UiTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getDocumentInfoColorScheme();
            final TextStyle textStyle = new TextStyle(documentInfoColorScheme.m13936getItemValueTextColor0d7_KjU(), j, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777212, (DefaultConstructorMarker) null);
            String str4 = (String) mutableState.getValue();
            KeyboardOptions keyboardOptions = new KeyboardOptions(0, Boolean.FALSE, 0, 0, (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 125, (DefaultConstructorMarker) null);
            boolean zChanged2 = composerStartRestartGroup.changed(mutableState) | ((57344 & i2) == 16384);
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = new Function1() { // from class: com.pspdfkit.internal.jd$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return jd.a(function1, mutableState, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            composer2 = composerStartRestartGroup;
            BasicTextFieldKt.BasicTextField(str4, (Function1<? super String, Unit>) objRememberedValue3, (Modifier) null, z2, false, textStyle, keyboardOptions, (KeyboardActions) null, true, 0, 0, (VisualTransformation) null, (Function1<? super TextLayoutResult, Unit>) null, (MutableInteractionSource) null, (Brush) null, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-733122625, true, new Function3() { // from class: com.pspdfkit.internal.jd$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return jd.a(textStyle, documentInfoColorScheme, str, j, mutableState, mutableState2, (Function2) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, ((i2 << 3) & 7168) | 102236160, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 32404);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.jd$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return jd.a(str, str2, z, j, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:70:0x0218  */
    /* JADX WARN: Code duplicated, block: B:75:0x0260  */
    /* JADX WARN: Code duplicated, block: B:80:0x0291  */
    /* JADX WARN: Code duplicated, block: B:83:0x02a9  */
    /* JADX WARN: Multi-variable type inference failed */
    public static final void a(tt ttVar, final rd rdVar, final sd sdVar, Composer composer, final int i) {
        int i2;
        final tt ttVar2;
        int i3;
        Object objMutableStateOf$default;
        boolean z;
        boolean zChangedInstance;
        Object objRememberedValue;
        boolean zChangedInstance2;
        Object objRememberedValue2;
        boolean zChangedInstance3;
        Object objRememberedValue3;
        ttVar.getClass();
        rdVar.getClass();
        sdVar.getClass();
        Composer composerStartRestartGroup = composer.startRestartGroup(-489902306);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(ttVar) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(rdVar) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(sdVar) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & Token.DOTQUERY) != 146, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-489902306, i2, -1, "io.nutrient.internal.ui.documentinfo.DocumentIntoPageBindingItemComposable (DocumentInfoComponents.kt:213)");
            }
            Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            DocumentInfoColorScheme documentInfoColorScheme = UiTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getDocumentInfoColorScheme();
            Alignment.Companion companion = Alignment.INSTANCE;
            Alignment.Vertical centerVertically = companion.getCenterVertically();
            Modifier.Companion companion2 = Modifier.INSTANCE;
            Arrangement arrangement = Arrangement.INSTANCE;
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), centerVertically, composerStartRestartGroup, 48);
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion2);
            ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion3.getConstructor();
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
            f2.a(companion3, composerM6062constructorimpl, measurePolicyRowMeasurePolicy, composerM6062constructorimpl, currentCompositionLocalMap);
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion3, composerM6062constructorimpl, Integer.valueOf(iHashCode), composerM6062constructorimpl));
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            boolean zChanged = composerStartRestartGroup.changed(ttVar.a(context));
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                MutableState mutableStateMutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(ttVar.e, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default);
                objRememberedValue4 = mutableStateMutableStateOf$default;
            }
            final MutableState mutableState = (MutableState) objRememberedValue4;
            boolean zChanged2 = composerStartRestartGroup.changed(ttVar.e.ordinal());
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                i3 = 2;
                objMutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(ttVar.a(context), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objMutableStateOf$default);
            } else {
                objMutableStateOf$default = objRememberedValue5;
                i3 = 2;
            }
            MutableState mutableState2 = (MutableState) objMutableStateOf$default;
            Modifier modifierWrapContentWidth$default = SizeKt.wrapContentWidth$default(companion2, companion.getStart(), false, i3, null);
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion.getStart(), composerStartRestartGroup, 0);
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWrapContentWidth$default);
            Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
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
            f2.a(companion3, composerM6062constructorimpl2, measurePolicyColumnMeasurePolicy, composerM6062constructorimpl2, currentCompositionLocalMap2);
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion3, composerM6062constructorimpl2, Integer.valueOf(iHashCode2), composerM6062constructorimpl2));
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            String str = ttVar.b;
            str.getClass();
            TextKt.m4494TextNvy7gAk(str, null, documentInfoColorScheme.m13934getItemTitleTextColor0d7_KjU(), null, sdVar.g, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 0, 0, 262122);
            SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(companion2, sdVar.l), composerStartRestartGroup, 0);
            String strA = no.a(context, R.string.pspdf__document_info_not_set, null);
            strA.getClass();
            String str2 = (String) mutableState2.getValue();
            if (rdVar.c) {
                ttVar2 = ttVar;
                if (ttVar2.d) {
                    z = true;
                }
                long j = sdVar.h;
                zChangedInstance = composerStartRestartGroup.changedInstance(ttVar2);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.pspdfkit.internal.jd$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return jd.a(ttVar2, (String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                a(strA, str2, z, j, (Function1<? super String, Unit>) objRememberedValue, composerStartRestartGroup, 0);
                composerStartRestartGroup = composerStartRestartGroup;
                composerStartRestartGroup.endNode();
                SpacerKt.Spacer(rowScopeInstance.weight(companion2, 1.0f, true), composerStartRestartGroup, 0);
                PageBinding pageBinding = PageBinding.LEFT_EDGE;
                PageBinding pageBinding2 = (PageBinding) mutableState.getValue();
                boolean z2 = rdVar.c;
                zChangedInstance2 = composerStartRestartGroup.changedInstance(ttVar2) | composerStartRestartGroup.changed(mutableState);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function0() { // from class: com.pspdfkit.internal.jd$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return jd.a(ttVar2, mutableState);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                a(pageBinding, pageBinding2, z2, (Function0<Unit>) objRememberedValue2, composerStartRestartGroup, 6);
                PageBinding pageBinding3 = PageBinding.RIGHT_EDGE;
                PageBinding pageBinding4 = (PageBinding) mutableState.getValue();
                boolean z3 = rdVar.c;
                zChangedInstance3 = composerStartRestartGroup.changedInstance(ttVar2) | composerStartRestartGroup.changed(mutableState);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function0() { // from class: com.pspdfkit.internal.jd$$ExternalSyntheticLambda13
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return jd.b(ttVar2, mutableState);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                a(pageBinding3, pageBinding4, z3, (Function0<Unit>) objRememberedValue3, composerStartRestartGroup, 6);
                composerStartRestartGroup.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                ttVar2 = ttVar;
            }
            z = false;
            long j2 = sdVar.h;
            zChangedInstance = composerStartRestartGroup.changedInstance(ttVar2);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChangedInstance) {
                objRememberedValue = new Function1() { // from class: com.pspdfkit.internal.jd$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return jd.a(ttVar2, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function1() { // from class: com.pspdfkit.internal.jd$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return jd.a(ttVar2, (String) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            a(strA, str2, z, j2, (Function1<? super String, Unit>) objRememberedValue, composerStartRestartGroup, 0);
            composerStartRestartGroup = composerStartRestartGroup;
            composerStartRestartGroup.endNode();
            SpacerKt.Spacer(rowScopeInstance.weight(companion2, 1.0f, true), composerStartRestartGroup, 0);
            PageBinding pageBinding5 = PageBinding.LEFT_EDGE;
            PageBinding pageBinding6 = (PageBinding) mutableState.getValue();
            boolean z4 = rdVar.c;
            zChangedInstance2 = composerStartRestartGroup.changedInstance(ttVar2) | composerStartRestartGroup.changed(mutableState);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!zChangedInstance2) {
                objRememberedValue2 = new Function0() { // from class: com.pspdfkit.internal.jd$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return jd.a(ttVar2, mutableState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new Function0() { // from class: com.pspdfkit.internal.jd$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return jd.a(ttVar2, mutableState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            a(pageBinding5, pageBinding6, z4, (Function0<Unit>) objRememberedValue2, composerStartRestartGroup, 6);
            PageBinding pageBinding7 = PageBinding.RIGHT_EDGE;
            PageBinding pageBinding8 = (PageBinding) mutableState.getValue();
            boolean z5 = rdVar.c;
            zChangedInstance3 = composerStartRestartGroup.changedInstance(ttVar2) | composerStartRestartGroup.changed(mutableState);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (!zChangedInstance3) {
                objRememberedValue3 = new Function0() { // from class: com.pspdfkit.internal.jd$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return jd.b(ttVar2, mutableState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new Function0() { // from class: com.pspdfkit.internal.jd$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return jd.b(ttVar2, mutableState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            a(pageBinding7, pageBinding8, z5, (Function0<Unit>) objRememberedValue3, composerStartRestartGroup, 6);
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            ttVar2 = ttVar;
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.jd$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return jd.a(ttVar2, rdVar, sdVar, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final Unit a(tt ttVar, String str) {
        str.getClass();
        ttVar.a(str);
        return Unit.INSTANCE;
    }

    public static final Unit a(tt ttVar, MutableState mutableState) {
        PageBinding pageBinding = PageBinding.LEFT_EDGE;
        ttVar.getClass();
        pageBinding.getClass();
        ttVar.e = pageBinding;
        ttVar.a(pageBinding.toString());
        mutableState.setValue(pageBinding);
        return Unit.INSTANCE;
    }

    public static final Unit a(Function1 function1, MutableState mutableState, String str) {
        str.getClass();
        mutableState.setValue(str);
        function1.invoke(str);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit a(TextStyle textStyle, DocumentInfoColorScheme documentInfoColorScheme, String str, long j, MutableState mutableState, MutableState mutableState2, Function2 function2, Composer composer, int i) {
        int i2;
        int i3;
        Modifier.Companion companion;
        int i4;
        Composer composer2 = composer;
        function2.getClass();
        if ((i & 6) == 0) {
            i2 = i | (composer2.changedInstance(function2) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (composer2.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-733122625, i2, -1, "io.nutrient.internal.ui.documentinfo.BottomOutlineTextField.<anonymous> (DocumentInfoComponents.kt:183)");
            }
            Modifier.Companion companion2 = Modifier.INSTANCE;
            Arrangement.Vertical top = Arrangement.INSTANCE.getTop();
            Alignment.Companion companion3 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion3.getStart(), composer2, 0);
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
            CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, companion2);
            ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion4.getConstructor();
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
            f2.a(companion4, composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, composerM6062constructorimpl, currentCompositionLocalMap);
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion4, composerM6062constructorimpl, Integer.valueOf(iHashCode), composerM6062constructorimpl));
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion3.getTopStart(), false);
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, companion2);
            Function0<ComposeUiNode> constructor2 = companion4.getConstructor();
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
            f2.a(companion4, composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, composerM6062constructorimpl2, currentCompositionLocalMap2);
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion4, composerM6062constructorimpl2, Integer.valueOf(iHashCode2), composerM6062constructorimpl2));
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            if (((String) mutableState.getValue()).length() == 0) {
                composer2.startReplaceGroup(-231639603);
                companion = companion2;
                i3 = i2;
                TextKt.m4494TextNvy7gAk(str, null, documentInfoColorScheme.m13935getItemValueHintTextColor0d7_KjU(), null, j, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 0, 0, 262122);
                composer2 = composer2;
                composer2.endReplaceGroup();
            } else {
                i3 = i2;
                companion = companion2;
                composer2.startReplaceGroup(-231407041);
                composer2.endReplaceGroup();
            }
            function2.invoke(composer2, Integer.valueOf(i3 & 14));
            composer2.endNode();
            String str2 = (String) mutableState2.getValue();
            str2.getClass();
            textStyle.getClass();
            if (ComposerKt.isTraceInProgress()) {
                i4 = 0;
                ComposerKt.traceEventStart(812022242, 0, -1, "io.nutrient.internal.ui.documentinfo.measureTextWidth (DocumentInfoComponents.kt:262)");
            } else {
                i4 = 0;
            }
            int i5 = i4;
            float fMo751toDpu2uoSUM = ((Density) composer2.consume(CompositionLocalsKt.getLocalDensity())).mo751toDpu2uoSUM((int) (TextMeasurer.m9064measurewNUYSr0$default(TextMeasurerHelperKt.rememberTextMeasurer(i4, composer2, i4, 1), str2, textStyle, 0, false, 0, 0L, null, null, null, false, 1020, null).getSize() >> 32));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            BoxKt.Box(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.m1252height3ABfNKs(SizeKt.m1271width3ABfNKs(companion, fMo751toDpu2uoSUM), Dp.m9687constructorimpl((float) 0.8d)), documentInfoColorScheme.m13935getItemValueHintTextColor0d7_KjU(), null, 2, null), composer2, i5);
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}

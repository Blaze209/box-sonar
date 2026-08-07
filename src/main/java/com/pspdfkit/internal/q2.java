package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.foundation.BackgroundKt;
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
import androidx.compose.ui.graphics.AndroidImageBitmap_androidKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.AndroidTypeface_androidKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.intl.LocaleList;
import androidx.compose.ui.text.style.BaselineShift;
import androidx.compose.ui.text.style.LineHeightStyle;
import androidx.compose.ui.text.style.TextDecoration;
import androidx.compose.ui.text.style.TextGeometricTransform;
import androidx.compose.ui.text.style.TextIndent;
import androidx.compose.ui.text.style.TextMotion;
import androidx.core.graphics.drawable.DrawableKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;

/* JADX INFO: loaded from: classes3.dex */
public final class q2 {
    public static final Unit a(fo foVar, boolean z, boolean z2, r2 r2Var, y2 y2Var, Modifier modifier, Modifier modifier2, int i, int i2, Composer composer, int i3) {
        a(foVar, z, z2, r2Var, y2Var, modifier, modifier2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0291  */
    /* JADX WARN: Code duplicated, block: B:102:0x0295  */
    /* JADX WARN: Code duplicated, block: B:105:0x02b2  */
    /* JADX WARN: Code duplicated, block: B:106:0x02bd  */
    /* JADX WARN: Code duplicated, block: B:109:0x0340  */
    /* JADX WARN: Code duplicated, block: B:110:0x034b  */
    /* JADX WARN: Code duplicated, block: B:113:0x040b  */
    /* JADX WARN: Code duplicated, block: B:114:0x040f  */
    /* JADX WARN: Code duplicated, block: B:117:0x041b  */
    /* JADX WARN: Code duplicated, block: B:119:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:52:0x009c  */
    /* JADX WARN: Code duplicated, block: B:53:0x009e  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:57:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:58:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:64:0x0101  */
    /* JADX WARN: Code duplicated, block: B:67:0x010d  */
    /* JADX WARN: Code duplicated, block: B:68:0x0111  */
    /* JADX WARN: Code duplicated, block: B:71:0x0166  */
    /* JADX WARN: Code duplicated, block: B:74:0x0172  */
    /* JADX WARN: Code duplicated, block: B:75:0x0176  */
    /* JADX WARN: Code duplicated, block: B:78:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:81:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:82:0x01da  */
    /* JADX WARN: Code duplicated, block: B:85:0x01f5  */
    /* JADX WARN: Code duplicated, block: B:86:0x0201  */
    /* JADX WARN: Code duplicated, block: B:91:0x0224  */
    /* JADX WARN: Code duplicated, block: B:93:0x0227  */
    /* JADX WARN: Code duplicated, block: B:94:0x0233  */
    /* JADX WARN: Code duplicated, block: B:98:0x0285  */
    public static final void a(final fo foVar, final boolean z, final boolean z2, final r2 r2Var, final y2 y2Var, final Modifier modifier, Modifier modifier2, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier3;
        boolean z3;
        Composer composer2;
        final Modifier modifier4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Context context;
        ComposeUiNode.Companion companion;
        Function0<ComposeUiNode> constructor;
        Function0<ComposeUiNode> constructor2;
        Function0<ComposeUiNode> constructor3;
        Drawable drawableA;
        ImageBitmap imageBitmapAsImageBitmap;
        int i4;
        Bitmap bitmap$default;
        Function0<ComposeUiNode> constructor4;
        String strB;
        String strA;
        foVar.getClass();
        r2Var.getClass();
        y2Var.getClass();
        modifier.getClass();
        Composer composerStartRestartGroup = composer.startRestartGroup(-1283711717);
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(foVar) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(z2) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(r2Var) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changed(y2Var) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 131072 : 65536;
        }
        int i5 = i2 & 64;
        if (i5 == 0) {
            if ((1572864 & i) == 0) {
                modifier3 = modifier2;
                i3 |= composerStartRestartGroup.changed(modifier3) ? 1048576 : 524288;
            }
            if ((599171 & i3) != 599170) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                if (i5 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier3;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1283711717, i3, -1, "com.pspdfkit.internal.ui.annotations.AnnotationListItem (AnnotationListItem.kt:58)");
                }
                context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
                Modifier modifierM589backgroundbw27NRU$default = BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null), ColorKt.Color(r2Var.a), null, 2, null);
                Alignment.Companion companion2 = Alignment.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM589backgroundbw27NRU$default);
                companion = ComposeUiNode.INSTANCE;
                constructor = companion.getConstructor();
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
                Modifier.Companion companion3 = Modifier.INSTANCE;
                Modifier modifierM1218padding3ABfNKs = PaddingKt.m1218padding3ABfNKs(SizeKt.fillMaxSize$default(companion3, 0.0f, 1, null), y2Var.d);
                Arrangement arrangement = Arrangement.INSTANCE;
                int i6 = i3;
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getSpaceBetween(), companion2.getCenterVertically(), composerStartRestartGroup, 54);
                int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1218padding3ABfNKs);
                constructor2 = companion.getConstructor();
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
                f2.a(companion, composerM6062constructorimpl2, measurePolicyRowMeasurePolicy, composerM6062constructorimpl2, currentCompositionLocalMap2);
                Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion, composerM6062constructorimpl2, Integer.valueOf(iHashCode2), composerM6062constructorimpl2));
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                Modifier modifierWeight$default = RowScope.weight$default(rowScopeInstance, companion3, 1.0f, false, 2, null);
                MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getCenterVertically(), composerStartRestartGroup, 48);
                int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default);
                constructor3 = companion.getConstructor();
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor3);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM6062constructorimpl3 = Updater.m6062constructorimpl(composerStartRestartGroup);
                f2.a(companion, composerM6062constructorimpl3, measurePolicyRowMeasurePolicy2, composerM6062constructorimpl3, currentCompositionLocalMap3);
                Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier3, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion, composerM6062constructorimpl3, Integer.valueOf(iHashCode3), composerM6062constructorimpl3));
                if (foVar.a() == null) {
                    composerStartRestartGroup.startReplaceGroup(-2146502608);
                    composerStartRestartGroup.endReplaceGroup();
                    companion = companion;
                    i4 = 0;
                } else {
                    composerStartRestartGroup.startReplaceGroup(-2146502607);
                    drawableA = foVar.a(context, r2Var.b);
                    if (drawableA != null || (bitmap$default = DrawableKt.toBitmap$default(drawableA, 0, 0, null, 7, null)) == null) {
                        imageBitmapAsImageBitmap = null;
                    } else {
                        imageBitmapAsImageBitmap = AndroidImageBitmap_androidKt.asImageBitmap(bitmap$default);
                    }
                    if (imageBitmapAsImageBitmap == null) {
                        composerStartRestartGroup.startReplaceGroup(-1689161628);
                        composerStartRestartGroup.endReplaceGroup();
                        i4 = 0;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(-1689161627);
                        i4 = 0;
                        IconKt.m3574Iconww6aTOc(imageBitmapAsImageBitmap, "", (Modifier) null, Color.INSTANCE.m6850getUnspecified0d7_KjU(), composerStartRestartGroup, 3120, 4);
                        Unit unit = Unit.INSTANCE;
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    composerStartRestartGroup.endReplaceGroup();
                }
                SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(companion3, y2Var.d), composerStartRestartGroup, i4);
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getStart(), composerStartRestartGroup, i4);
                int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, i4));
                CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion3);
                constructor4 = companion.getConstructor();
                if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composerStartRestartGroup.startReusableNode();
                if (composerStartRestartGroup.getInserting()) {
                    composerStartRestartGroup.createNode(constructor4);
                } else {
                    composerStartRestartGroup.useNode();
                }
                Composer composerM6062constructorimpl4 = Updater.m6062constructorimpl(composerStartRestartGroup);
                f2.a(companion, composerM6062constructorimpl4, measurePolicyColumnMeasurePolicy, composerM6062constructorimpl4, currentCompositionLocalMap4);
                Updater.m6070setimpl(composerM6062constructorimpl4, modifierMaterializeModifier4, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion, composerM6062constructorimpl4, Integer.valueOf(iHashCode4), composerM6062constructorimpl4));
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                strB = foVar.b(context);
                if (strB == null) {
                    composerStartRestartGroup.startReplaceGroup(-874372688);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-874372687);
                    TextKt.m4494TextNvy7gAk(strB, null, 0L, null, 0L, null, null, AndroidTypeface_androidKt.FontFamily(r2Var.g), 0L, null, null, 0L, 0, false, 1, 0, null, new TextStyle(ColorKt.Color(r2Var.b), y2Var.c, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777212, (DefaultConstructorMarker) null), composerStartRestartGroup, 0, 24576, 114558);
                    composerStartRestartGroup = composerStartRestartGroup;
                    Unit unit2 = Unit.INSTANCE;
                    composerStartRestartGroup.endReplaceGroup();
                }
                strA = foVar.a(context);
                if (strA == null) {
                    composerStartRestartGroup.startReplaceGroup(-873827460);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-873827459);
                    Composer composer3 = composerStartRestartGroup;
                    TextKt.m4494TextNvy7gAk(strA, null, 0L, null, 0L, null, null, AndroidTypeface_androidKt.FontFamily(r2Var.h), 0L, null, null, 0L, 0, false, 0, 0, null, new TextStyle(ColorKt.Color(r2Var.c), y2Var.c, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777212, (DefaultConstructorMarker) null), composer3, 0, 0, 130942);
                    composerStartRestartGroup = composer3;
                    Unit unit3 = Unit.INSTANCE;
                    composerStartRestartGroup.endReplaceGroup();
                }
                composerStartRestartGroup.endNode();
                composerStartRestartGroup.endNode();
                final Drawable drawableA2 = a80.a(context, r2Var.d, r2Var.e);
                composer2 = composerStartRestartGroup;
                AnimatedVisibilityKt.AnimatedVisibility(rowScopeInstance, z2, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(1620960349, true, new Function3() { // from class: com.pspdfkit.internal.q2$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return q2.a(drawableA2, modifier4, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, ((i6 >> 3) & 112) | 1572870, 30);
                composer2.endNode();
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier4 = modifier3;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.q2$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return q2.a(foVar, z, z2, r2Var, y2Var, modifier, modifier4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 1572864;
        modifier3 = modifier2;
        if ((599171 & i3) != 599170) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            if (i5 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier3;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1283711717, i3, -1, "com.pspdfkit.internal.ui.annotations.AnnotationListItem (AnnotationListItem.kt:58)");
            }
            context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            Modifier modifierM589backgroundbw27NRU$default2 = BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null), ColorKt.Color(r2Var.a), null, 2, null);
            Alignment.Companion companion4 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(companion4.getTopStart(), false);
            int iHashCode5 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM589backgroundbw27NRU$default2);
            companion = ComposeUiNode.INSTANCE;
            constructor = companion.getConstructor();
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
            f2.a(companion, composerM6062constructorimpl5, measurePolicyMaybeCachedBoxMeasurePolicy2, composerM6062constructorimpl5, currentCompositionLocalMap5);
            Updater.m6070setimpl(composerM6062constructorimpl5, modifierMaterializeModifier5, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion, composerM6062constructorimpl5, Integer.valueOf(iHashCode5), composerM6062constructorimpl5));
            BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
            Modifier.Companion companion5 = Modifier.INSTANCE;
            Modifier modifierM1218padding3ABfNKs2 = PaddingKt.m1218padding3ABfNKs(SizeKt.fillMaxSize$default(companion5, 0.0f, 1, null), y2Var.d);
            Arrangement arrangement2 = Arrangement.INSTANCE;
            int i7 = i3;
            MeasurePolicy measurePolicyRowMeasurePolicy3 = RowKt.rowMeasurePolicy(arrangement2.getSpaceBetween(), companion4.getCenterVertically(), composerStartRestartGroup, 54);
            int iHashCode6 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1218padding3ABfNKs2);
            constructor2 = companion.getConstructor();
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
            f2.a(companion, composerM6062constructorimpl6, measurePolicyRowMeasurePolicy3, composerM6062constructorimpl6, currentCompositionLocalMap6);
            Updater.m6070setimpl(composerM6062constructorimpl6, modifierMaterializeModifier6, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion, composerM6062constructorimpl6, Integer.valueOf(iHashCode6), composerM6062constructorimpl6));
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            Modifier modifierWeight$default2 = RowScope.weight$default(rowScopeInstance2, companion5, 1.0f, false, 2, null);
            MeasurePolicy measurePolicyRowMeasurePolicy4 = RowKt.rowMeasurePolicy(arrangement2.getStart(), companion4.getCenterVertically(), composerStartRestartGroup, 48);
            int iHashCode7 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default2);
            constructor3 = companion.getConstructor();
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor3);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl7 = Updater.m6062constructorimpl(composerStartRestartGroup);
            f2.a(companion, composerM6062constructorimpl7, measurePolicyRowMeasurePolicy4, composerM6062constructorimpl7, currentCompositionLocalMap7);
            Updater.m6070setimpl(composerM6062constructorimpl7, modifierMaterializeModifier7, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion, composerM6062constructorimpl7, Integer.valueOf(iHashCode7), composerM6062constructorimpl7));
            if (foVar.a() == null) {
                composerStartRestartGroup.startReplaceGroup(-2146502608);
                composerStartRestartGroup.endReplaceGroup();
                companion = companion;
                i4 = 0;
            } else {
                composerStartRestartGroup.startReplaceGroup(-2146502607);
                drawableA = foVar.a(context, r2Var.b);
                if (drawableA != null) {
                    imageBitmapAsImageBitmap = null;
                } else {
                    imageBitmapAsImageBitmap = null;
                }
                if (imageBitmapAsImageBitmap == null) {
                    composerStartRestartGroup.startReplaceGroup(-1689161628);
                    composerStartRestartGroup.endReplaceGroup();
                    i4 = 0;
                } else {
                    composerStartRestartGroup.startReplaceGroup(-1689161627);
                    i4 = 0;
                    IconKt.m3574Iconww6aTOc(imageBitmapAsImageBitmap, "", (Modifier) null, Color.INSTANCE.m6850getUnspecified0d7_KjU(), composerStartRestartGroup, 3120, 4);
                    Unit unit4 = Unit.INSTANCE;
                    composerStartRestartGroup.endReplaceGroup();
                }
                composerStartRestartGroup.endReplaceGroup();
            }
            SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(companion5, y2Var.d), composerStartRestartGroup, i4);
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement2.getTop(), companion4.getStart(), composerStartRestartGroup, i4);
            int iHashCode8 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, i4));
            CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion5);
            constructor4 = companion.getConstructor();
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor4);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl8 = Updater.m6062constructorimpl(composerStartRestartGroup);
            f2.a(companion, composerM6062constructorimpl8, measurePolicyColumnMeasurePolicy2, composerM6062constructorimpl8, currentCompositionLocalMap8);
            Updater.m6070setimpl(composerM6062constructorimpl8, modifierMaterializeModifier8, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion, composerM6062constructorimpl8, Integer.valueOf(iHashCode8), composerM6062constructorimpl8));
            ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
            strB = foVar.b(context);
            if (strB == null) {
                composerStartRestartGroup.startReplaceGroup(-874372688);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-874372687);
                TextKt.m4494TextNvy7gAk(strB, null, 0L, null, 0L, null, null, AndroidTypeface_androidKt.FontFamily(r2Var.g), 0L, null, null, 0L, 0, false, 1, 0, null, new TextStyle(ColorKt.Color(r2Var.b), y2Var.c, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777212, (DefaultConstructorMarker) null), composerStartRestartGroup, 0, 24576, 114558);
                composerStartRestartGroup = composerStartRestartGroup;
                Unit unit5 = Unit.INSTANCE;
                composerStartRestartGroup.endReplaceGroup();
            }
            strA = foVar.a(context);
            if (strA == null) {
                composerStartRestartGroup.startReplaceGroup(-873827460);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-873827459);
                Composer composer4 = composerStartRestartGroup;
                TextKt.m4494TextNvy7gAk(strA, null, 0L, null, 0L, null, null, AndroidTypeface_androidKt.FontFamily(r2Var.h), 0L, null, null, 0L, 0, false, 0, 0, null, new TextStyle(ColorKt.Color(r2Var.c), y2Var.c, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777212, (DefaultConstructorMarker) null), composer4, 0, 0, 130942);
                composerStartRestartGroup = composer4;
                Unit unit6 = Unit.INSTANCE;
                composerStartRestartGroup.endReplaceGroup();
            }
            composerStartRestartGroup.endNode();
            composerStartRestartGroup.endNode();
            final Drawable drawableA3 = a80.a(context, r2Var.d, r2Var.e);
            composer2 = composerStartRestartGroup;
            AnimatedVisibilityKt.AnimatedVisibility(rowScopeInstance2, z2, (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(1620960349, true, new Function3() { // from class: com.pspdfkit.internal.q2$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return q2.a(drawableA3, modifier4, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, ((i7 >> 3) & 112) | 1572870, 30);
            composer2.endNode();
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier4 = modifier3;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.q2$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return q2.a(foVar, z, z2, r2Var, y2Var, modifier, modifier4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final Unit a(Drawable drawable, Modifier modifier, AnimatedVisibilityScope animatedVisibilityScope, Composer composer, int i) {
        Bitmap bitmap$default;
        animatedVisibilityScope.getClass();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1620960349, i, -1, "com.pspdfkit.internal.ui.annotations.AnnotationListItem.<anonymous>.<anonymous>.<anonymous> (AnnotationListItem.kt:125)");
        }
        ImageBitmap imageBitmapAsImageBitmap = (drawable == null || (bitmap$default = DrawableKt.toBitmap$default(drawable, 0, 0, null, 7, null)) == null) ? null : AndroidImageBitmap_androidKt.asImageBitmap(bitmap$default);
        if (imageBitmapAsImageBitmap == null) {
            composer.startReplaceGroup(1712521168);
            composer.endReplaceGroup();
        } else {
            composer.startReplaceGroup(1712521169);
            IconKt.m3574Iconww6aTOc(imageBitmapAsImageBitmap, "", modifier, 0L, composer, 48, 8);
            composer.endReplaceGroup();
        }
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}

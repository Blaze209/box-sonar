package com.pspdfkit.internal;

import android.content.Context;
import android.widget.Toast;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.ImageKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.material3.DividerKt;
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
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.ContentScale;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import com.pspdfkit.R;
import com.pspdfkit.compose.theme.DocumentInfoColorScheme;
import com.pspdfkit.compose.theme.UiTheme;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes3.dex */
public final class kd {

    public static final class a implements Function0<Unit> {
        public static final a a = new a();

        @Override // kotlin.jvm.functions.Function0
        public final /* bridge */ /* synthetic */ Unit invoke() {
            return Unit.INSTANCE;
        }
    }

    public static final class b implements Function1<Integer, Object> {
        public final /* synthetic */ List a;

        public b(List list) {
            this.a = list;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Integer num) {
            this.a.get(num.intValue());
            return null;
        }
    }

    public static final class c implements Function4<LazyItemScope, Integer, Composer, Integer, Unit> {
        public final /* synthetic */ List a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ rd c;
        public final /* synthetic */ sd d;
        public final /* synthetic */ DocumentInfoColorScheme e;

        public c(List list, Context context, rd rdVar, sd sdVar, DocumentInfoColorScheme documentInfoColorScheme) {
            this.a = list;
            this.b = context;
            this.c = rdVar;
            this.d = sdVar;
            this.e = documentInfoColorScheme;
        }

        @Override // kotlin.jvm.functions.Function4
        public final Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
            Object next;
            LazyItemScope lazyItemScope2 = lazyItemScope;
            int iIntValue = num.intValue();
            Composer composer2 = composer;
            int iIntValue2 = num2.intValue();
            int i = (iIntValue2 & 6) == 0 ? (composer2.changed(lazyItemScope2) ? 4 : 2) | iIntValue2 : iIntValue2;
            if ((iIntValue2 & 48) == 0) {
                i |= composer2.changed(iIntValue) ? 32 : 16;
            }
            if (composer2.shouldExecute((i & Token.DOTQUERY) != 146, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(802480018, i, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                }
                ld ldVar = (ld) this.a.get(iIntValue);
                composer2.startReplaceGroup(-1086341049);
                md.a(ldVar, composer2, 0);
                Context context = this.b;
                boolean z = this.c.c;
                context.getClass();
                List<od> list = ldVar.d;
                list.getClass();
                Iterator<T> it = list.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        next = null;
                        break;
                    }
                    next = it.next();
                    od odVar = (od) next;
                    if (odVar instanceof tt) {
                        if (!Intrinsics.areEqual(((tt) odVar).a(context), no.a(context, R.string.pspdf__page_binding_unknown, null))) {
                            break;
                        }
                    } else {
                        String strA = odVar.a(context);
                        strA.getClass();
                        if (strA.length() > 0) {
                            break;
                        }
                    }
                }
                boolean z2 = next == null;
                if (z && ldVar.a == 1) {
                    z2 = false;
                }
                if (z2) {
                    composer2.startReplaceGroup(-1083451323);
                    composer2.endReplaceGroup();
                } else {
                    composer2.startReplaceGroup(-1086226691);
                    Modifier.Companion companion = Modifier.INSTANCE;
                    Object objRememberedValue = composer2.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = a.a;
                        composer2.updateRememberedValue(objRememberedValue);
                    }
                    Modifier modifierM632clickableoSLSa3U$default = ClickableKt.m632clickableoSLSa3U$default(companion, false, null, null, null, (Function0) objRememberedValue, 15, null);
                    sd sdVar = this.d;
                    Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(PaddingKt.m1221paddingqDBjuR0(modifierM632clickableoSLSa3U$default, sdVar.c, sdVar.a, sdVar.d, sdVar.b), 0.0f, 1, null);
                    Arrangement arrangement = Arrangement.INSTANCE;
                    Arrangement.Vertical top = arrangement.getTop();
                    Alignment.Companion companion2 = Alignment.INSTANCE;
                    MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), composer2, 0);
                    int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                    CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierFillMaxWidth$default);
                    ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
                    Function0<ComposeUiNode> constructor = companion3.getConstructor();
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
                    f2.a(companion3, composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, composerM6062constructorimpl, currentCompositionLocalMap);
                    Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion3, composerM6062constructorimpl, Integer.valueOf(iHashCode), composerM6062constructorimpl));
                    ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                    String str = ldVar.b;
                    str.getClass();
                    TextKt.m4494TextNvy7gAk(str, null, this.e.m13933getGroupTitleTextColor0d7_KjU(), null, this.d.f, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer2, 0, 0, 262122);
                    SpacerKt.Spacer(SizeKt.fillMaxWidth$default(SizeKt.m1252height3ABfNKs(companion, this.d.e), 0.0f, 1, null), composer2, 0);
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
                    int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                    CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, companion);
                    Function0<ComposeUiNode> constructor2 = companion3.getConstructor();
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
                    f2.a(companion3, composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, composerM6062constructorimpl2, currentCompositionLocalMap2);
                    Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion3, composerM6062constructorimpl2, Integer.valueOf(iHashCode2), composerM6062constructorimpl2));
                    BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                    float f = 0;
                    ImageKt.Image(PainterResources_androidKt.painterResource(ldVar.c, composer2, 0), (String) null, SizeKt.m1266size3ABfNKs(PaddingKt.m1221paddingqDBjuR0(companion, this.d.m, Dp.m9687constructorimpl(f), Dp.m9687constructorimpl(f), Dp.m9687constructorimpl(f)), this.d.k), (Alignment) null, (ContentScale) null, 0.0f, ColorFilter.Companion.m6855tintxETnrds$default(ColorFilter.INSTANCE, this.e.m13932getGroupIconColor0d7_KjU(), 0, 2, null), composer2, Painter.$stable | 48, 56);
                    composer2 = composer2;
                    Modifier modifierM1221paddingqDBjuR0 = PaddingKt.m1221paddingqDBjuR0(companion, this.d.i, Dp.m9687constructorimpl(f), Dp.m9687constructorimpl(f), Dp.m9687constructorimpl(f));
                    MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getStart(), composer2, 0);
                    int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                    CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer2, modifierM1221paddingqDBjuR0);
                    Function0<ComposeUiNode> constructor3 = companion3.getConstructor();
                    if (!(composer2.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer2.startReusableNode();
                    if (composer2.getInserting()) {
                        composer2.createNode(constructor3);
                    } else {
                        composer2.useNode();
                    }
                    Composer composerM6062constructorimpl3 = Updater.m6062constructorimpl(composer2);
                    f2.a(companion3, composerM6062constructorimpl3, measurePolicyColumnMeasurePolicy2, composerM6062constructorimpl3, currentCompositionLocalMap3);
                    Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier3, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion3, composerM6062constructorimpl3, Integer.valueOf(iHashCode3), composerM6062constructorimpl3));
                    composer2.startReplaceGroup(-1758498317);
                    List<od> list2 = ldVar.d;
                    list2.getClass();
                    int i2 = 0;
                    for (Object obj : list2) {
                        int i3 = i2 + 1;
                        if (i2 < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        od odVar2 = (od) obj;
                        odVar2.getClass();
                        if (!this.c.c && odVar2.a()) {
                            composer2.startReplaceGroup(1860290477);
                            composer2.endReplaceGroup();
                        } else {
                            composer2.startReplaceGroup(1859686969);
                            if (odVar2 instanceof tt) {
                                composer2.startReplaceGroup(1859758362);
                                jd.a((tt) odVar2, this.c, this.d, composer2, 0);
                                composer2.endReplaceGroup();
                            } else {
                                composer2.startReplaceGroup(1859909797);
                                jd.a(odVar2, this.c, this.d, composer2, 0);
                                composer2.endReplaceGroup();
                            }
                            if (ldVar.d.size() - 1 > i2) {
                                composer2.startReplaceGroup(1860119202);
                                SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, this.d.j), composer2, 0);
                                composer2.endReplaceGroup();
                            } else {
                                composer2.startReplaceGroup(1860252781);
                                composer2.endReplaceGroup();
                            }
                            composer2.endReplaceGroup();
                        }
                        i2 = i3;
                    }
                    composer2.endReplaceGroup();
                    composer2.endNode();
                    composer2.endNode();
                    composer2.endNode();
                    DividerKt.m3284HorizontalDivider9IZ8Weo(SizeKt.m1252height3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m9687constructorimpl((float) 0.5d)), 0.0f, MaterialTheme.INSTANCE.getColorScheme(composer2, MaterialTheme.$stable).getOutline(), composer2, 6, 2);
                    composer2.endReplaceGroup();
                }
                composer2.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composer2.skipToGroupEnd();
            }
            return Unit.INSTANCE;
        }
    }

    public static final Unit a(Modifier modifier, rd rdVar, Function0 function0, int i, int i2, Composer composer, int i3) {
        a(modifier, rdVar, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final Unit a(rd rdVar, Context context, sd sdVar, DocumentInfoColorScheme documentInfoColorScheme, LazyListScope lazyListScope) {
        lazyListScope.getClass();
        List<ld> list = rdVar.b;
        lazyListScope.items(list.size(), null, new b(list), ComposableLambdaKt.composableLambdaInstance(802480018, true, new c(list, context, rdVar, sdVar, documentInfoColorScheme)));
        return Unit.INSTANCE;
    }

    public static final Unit a(rd rdVar, Context context) {
        if (rdVar.d) {
            Toast.makeText(context, R.string.pspdf__document_could_not_be_saved, 0).show();
        }
        return Unit.INSTANCE;
    }

    public static final void a(Modifier modifier, final rd rdVar, final Function0<Unit> function0, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        rdVar.getClass();
        function0.getClass();
        Composer composerStartRestartGroup = composer.startRestartGroup(-1688070488);
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
            Modifier modifier3 = i4 != 0 ? Modifier.INSTANCE : modifier2;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1688070488, i3, -1, "io.nutrient.internal.ui.documentinfo.DocumentInfoComposable (DocumentInfoComposable.kt:54)");
            }
            final Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            final sd sdVar = new sd(context, (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity()));
            final DocumentInfoColorScheme documentInfoColorScheme = UiTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getDocumentInfoColorScheme();
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierM589backgroundbw27NRU$default = BackgroundKt.m589backgroundbw27NRU$default(companion, documentInfoColorScheme.m13929getBackgroundColor0d7_KjU(), null, 2, null);
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM589backgroundbw27NRU$default);
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
            f2.a(companion3, composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, composerM6062constructorimpl, currentCompositionLocalMap);
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion3, composerM6062constructorimpl, Integer.valueOf(iHashCode), composerM6062constructorimpl));
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(rdVar) | composerStartRestartGroup.changedInstance(context) | composerStartRestartGroup.changed(sdVar) | composerStartRestartGroup.changed(documentInfoColorScheme);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.pspdfkit.internal.kd$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return kd.a(rdVar, context, sdVar, documentInfoColorScheme, (LazyListScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            LazyDslKt.LazyColumn(modifier3, null, null, false, null, null, null, false, null, (Function1) objRememberedValue, composerStartRestartGroup, i3 & 14, 510);
            composerStartRestartGroup = composerStartRestartGroup;
            jd.a(boxScopeInstance.align(companion, companion2.getBottomEnd()), rdVar, function0, composerStartRestartGroup, i3 & 1008, 0);
            composerStartRestartGroup.endNode();
            boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(rdVar) | composerStartRestartGroup.changedInstance(context);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.pspdfkit.internal.kd$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return kd.a(rdVar, context);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            EffectsKt.SideEffect((Function0) objRememberedValue2, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier4 = modifier2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.kd$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return kd.a(modifier4, rdVar, function0, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}

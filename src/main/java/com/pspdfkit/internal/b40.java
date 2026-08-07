package com.pspdfkit.internal;

import android.content.Context;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.ClickableKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.lazy.grid.GridCells;
import androidx.compose.foundation.lazy.grid.LazyGridDslKt;
import androidx.compose.foundation.lazy.grid.LazyGridItemScope;
import androidx.compose.foundation.lazy.grid.LazyGridScope;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.IconButtonColors;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.ScaffoldKt;
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
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Density;
import com.pspdfkit.R;
import com.pspdfkit.annotations.stamps.StampPickerItem;
import com.pspdfkit.ui.toolbar.ContextualToolbar;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.ArrayList;
import java.util.List;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;

/* JADX INFO: loaded from: classes3.dex */
public final class b40 {

    public static final class a implements Function0<Unit> {
        public final /* synthetic */ Function1<StampPickerItem, Unit> a;
        public final /* synthetic */ StampPickerItem b;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Function1<? super StampPickerItem, Unit> function1, StampPickerItem stampPickerItem) {
            this.a = function1;
            this.b = stampPickerItem;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            this.a.invoke(this.b);
            return Unit.INSTANCE;
        }
    }

    public static final class b implements Function1<Integer, Object> {
        public final /* synthetic */ Function2 a;
        public final /* synthetic */ List b;

        public b(Function2 function2, List list) {
            this.a = function2;
            this.b = list;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Integer num) {
            int iIntValue = num.intValue();
            return this.a.invoke(Integer.valueOf(iIntValue), this.b.get(iIntValue));
        }
    }

    public static final class c implements Function1<Integer, Object> {
        public final /* synthetic */ List a;

        public c(List list) {
            this.a = list;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Integer num) {
            this.a.get(num.intValue());
            return null;
        }
    }

    public static final class d implements Function4<LazyGridItemScope, Integer, Composer, Integer, Unit> {
        public final /* synthetic */ List a;
        public final /* synthetic */ k40 b;
        public final /* synthetic */ Function1 c;

        public d(List list, k40 k40Var, Function1 function1) {
            this.a = list;
            this.b = k40Var;
            this.c = function1;
        }

        public final void a(LazyGridItemScope lazyGridItemScope, int i, Composer composer, int i2) {
            int i3;
            if ((i2 & 6) == 0) {
                i3 = (composer.changed(lazyGridItemScope) ? 4 : 2) | i2;
            } else {
                i3 = i2;
            }
            if ((i2 & 48) == 0) {
                i3 |= composer.changed(i) ? 32 : 16;
            }
            if (!composer.shouldExecute((i3 & Token.DOTQUERY) != 146, i3 & 1)) {
                composer.skipToGroupEnd();
                return;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1942245546, i3, -1, "androidx.compose.foundation.lazy.grid.itemsIndexed.<anonymous> (LazyGridDsl.kt:576)");
            }
            StampPickerItem stampPickerItem = (StampPickerItem) this.a.get(i);
            composer.startReplaceGroup(-238151529);
            Modifier modifierM1218padding3ABfNKs = PaddingKt.m1218padding3ABfNKs(Modifier.INSTANCE, this.b.d);
            boolean zChanged = composer.changed(this.c) | composer.changedInstance(stampPickerItem);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new a(this.c, stampPickerItem);
                composer.updateRememberedValue(objRememberedValue);
            }
            Modifier modifierM632clickableoSLSa3U$default = ClickableKt.m632clickableoSLSa3U$default(modifierM1218padding3ABfNKs, false, null, null, null, (Function0) objRememberedValue, 15, null);
            modifierM632clickableoSLSa3U$default.getClass();
            ("existing_stamp_" + i).getClass();
            d40.a(modifierM632clickableoSLSa3U$default, stampPickerItem, composer, 0);
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }

        @Override // kotlin.jvm.functions.Function4
        public final /* bridge */ /* synthetic */ Unit invoke(LazyGridItemScope lazyGridItemScope, Integer num, Composer composer, Integer num2) {
            a(lazyGridItemScope, num.intValue(), composer, num2.intValue());
            return Unit.INSTANCE;
        }
    }

    public static final Unit a(String str, List list, Function1 function1, Function0 function0, wc.a aVar, Modifier modifier, int i, Composer composer, int i2) {
        a(str, list, function1, function0, aVar, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void a(final String str, List<? extends StampPickerItem> list, final Function1<? super StampPickerItem, Unit> function1, final Function0<Unit> function0, final wc.a aVar, final Modifier modifier, Composer composer, final int i) {
        List<? extends StampPickerItem> list2;
        Composer composer2;
        str.getClass();
        list.getClass();
        function1.getClass();
        function0.getClass();
        aVar.getClass();
        modifier.getClass();
        Composer composerStartRestartGroup = composer.startRestartGroup(349129854);
        int i2 = (i & 6) == 0 ? (composerStartRestartGroup.changed(str) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            list2 = list;
            i2 |= composerStartRestartGroup.changedInstance(list2) ? 32 : 16;
        } else {
            list2 = list;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(aVar) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(modifier) ? 131072 : 65536;
        }
        if (composerStartRestartGroup.shouldExecute((74899 & i2) != 74898, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(349129854, i2, -1, "com.pspdfkit.internal.ui.dialog.stamps.composables.StampGridComposable (StampGridComposable.kt:55)");
            }
            Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            ArrayList arrayList = new ArrayList();
            ArrayList arrayList2 = new ArrayList();
            for (Object obj : list2) {
                if (((StampPickerItem) obj).isCustomStamp()) {
                    arrayList.add(obj);
                } else {
                    arrayList2.add(obj);
                }
            }
            Pair pair = new Pair(arrayList, arrayList2);
            List list3 = (List) pair.component1();
            final List list4 = (List) pair.component2();
            final StampPickerItem stampPickerItem = (StampPickerItem) CollectionsKt.firstOrNull(list3);
            final i40 i40Var = new i40(context);
            final k40 k40Var = new k40(context, (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity()));
            composer2 = composerStartRestartGroup;
            ScaffoldKt.m4038ScaffoldTvnljyQ(WindowInsetsPadding_androidKt.statusBarsPadding(Modifier.INSTANCE), ComposableLambdaKt.rememberComposableLambda(-1612674238, true, new Function2() { // from class: com.pspdfkit.internal.b40$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return b40.a(aVar, str, function0, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(-2087672435, true, new Function3() { // from class: com.pspdfkit.internal.b40$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return b40.a(modifier, stampPickerItem, function1, i40Var, k40Var, list4, (PaddingValues) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, 805306416, 508);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final List<? extends StampPickerItem> list5 = list2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.b40$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return b40.a(str, list5, function1, function0, aVar, modifier, i, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    public static final Unit a(wc.a aVar, final String str, final Function0 function0, Composer composer, int i) {
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1612674238, i, -1, "com.pspdfkit.internal.ui.dialog.stamps.composables.StampGridComposable.<anonymous> (StampGridComposable.kt:66)");
            }
            AppBarKt.m2784TopAppBarGHTll3U(ComposableLambdaKt.rememberComposableLambda(1391300350, true, new Function2() { // from class: com.pspdfkit.internal.b40$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return b40.a(str, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, ComposableLambdaKt.rememberComposableLambda(-1922916164, true, new Function2() { // from class: com.pspdfkit.internal.b40$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return b40.a(function0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, 0.0f, null, TopAppBarDefaults.INSTANCE.m4782topAppBarColors5tl4gsc(ColorKt.Color(aVar.getTitleColor()), 0L, ColorKt.Color(aVar.getTitleIconsColor()), ColorKt.Color(aVar.getTitleTextColor()), 0L, 0L, composer, TopAppBarDefaults.$stable << 18, 50), null, composer, 390, ContextualToolbar.DRAG_BUTTON_ALPHA);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final Unit a(String str, Composer composer, int i) {
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1391300350, i, -1, "com.pspdfkit.internal.ui.dialog.stamps.composables.StampGridComposable.<anonymous>.<anonymous> (StampGridComposable.kt:68)");
            }
            TextKt.m4494TextNvy7gAk(str, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final Unit a(Function0 function0, Composer composer, int i) {
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1922916164, i, -1, "com.pspdfkit.internal.ui.dialog.stamps.composables.StampGridComposable.<anonymous>.<anonymous> (StampGridComposable.kt:71)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            companion.getClass();
            IconButtonKt.IconButton((Function0<Unit>) function0, (Modifier) companion, false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, (Function2<? super Composer, ? super Integer, Unit>) t9.a, composer, 1572864, 60);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final Unit a(Modifier modifier, final StampPickerItem stampPickerItem, final Function1 function1, i40 i40Var, final k40 k40Var, final List list, PaddingValues paddingValues, Composer composer, int i) {
        int i2;
        paddingValues.getClass();
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(paddingValues) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2087672435, i2, -1, "com.pspdfkit.internal.ui.dialog.stamps.composables.StampGridComposable.<anonymous> (StampGridComposable.kt:84)");
            }
            Modifier modifierPadding = PaddingKt.padding(modifier, paddingValues);
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Vertical top = arrangement.getTop();
            Alignment.Companion companion = Alignment.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion.getStart(), composer, 0);
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierPadding);
            ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
            Function0<ComposeUiNode> constructor = companion2.getConstructor();
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
            f2.a(companion2, composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, composerM6062constructorimpl, currentCompositionLocalMap);
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion2, composerM6062constructorimpl, Integer.valueOf(iHashCode), composerM6062constructorimpl));
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            if (stampPickerItem != null) {
                composer.startReplaceGroup(607742091);
                Modifier.Companion companion3 = Modifier.INSTANCE;
                boolean zChanged = composer.changed(function1) | composer.changedInstance(stampPickerItem);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.pspdfkit.internal.b40$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return b40.a(function1, stampPickerItem);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                c40.a(ClickableKt.m632clickableoSLSa3U$default(companion3, false, null, null, null, (Function0) objRememberedValue, 15, null), stampPickerItem, composer, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(607957355);
                composer.endReplaceGroup();
            }
            Modifier.Companion companion4 = Modifier.INSTANCE;
            Modifier modifierM589backgroundbw27NRU$default = BackgroundKt.m589backgroundbw27NRU$default(companion4, ColorKt.Color(i40Var.f), null, 2, null);
            MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion.getStart(), composer, 0);
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, modifierM589backgroundbw27NRU$default);
            Function0<ComposeUiNode> constructor2 = companion2.getConstructor();
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
            f2.a(companion2, composerM6062constructorimpl2, measurePolicyColumnMeasurePolicy2, composerM6062constructorimpl2, currentCompositionLocalMap2);
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion2, composerM6062constructorimpl2, Integer.valueOf(iHashCode2), composerM6062constructorimpl2));
            String strStringResource = StringResources_androidKt.stringResource(R.string.pspdf__stamp_standard_section, composer, 0);
            float f = k40Var.b;
            TextKt.m4494TextNvy7gAk(strStringResource, PaddingKt.m1222paddingqDBjuR0$default(companion4, f, f, f, 0.0f, 8, null), ColorKt.Color(i40Var.b), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 262136);
            GridCells.Fixed fixed = new GridCells.Fixed(2);
            PaddingValues paddingValuesM1211PaddingValues0680j_4 = PaddingKt.m1211PaddingValues0680j_4(k40Var.d);
            boolean zChangedInstance = composer.changedInstance(list) | composer.changed(k40Var) | composer.changed(function1);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.pspdfkit.internal.b40$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return b40.a(list, k40Var, function1, (LazyGridScope) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            LazyGridDslKt.LazyVerticalGrid(fixed, null, null, paddingValuesM1211PaddingValues0680j_4, false, null, null, null, false, null, (Function1) objRememberedValue2, composer, 0, 0, 1014);
            composer.endNode();
            composer.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final Unit a(Function1 function1, StampPickerItem stampPickerItem) {
        function1.invoke(stampPickerItem);
        return Unit.INSTANCE;
    }

    public static final Unit a(List list, k40 k40Var, Function1 function1, LazyGridScope lazyGridScope) {
        lazyGridScope.getClass();
        lazyGridScope.items(list.size(), new b(new Function2() { // from class: com.pspdfkit.internal.b40$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return b40.a(((Integer) obj).intValue(), (StampPickerItem) obj2);
            }
        }, list), null, new c(list), ComposableLambdaKt.composableLambdaInstance(-1942245546, true, new d(list, k40Var, function1)));
        return Unit.INSTANCE;
    }

    public static final Object a(int i, StampPickerItem stampPickerItem) {
        stampPickerItem.getClass();
        return Integer.valueOf(i);
    }
}

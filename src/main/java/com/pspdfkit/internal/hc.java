package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.RectF;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.ContextThemeWrapper;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
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
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.grid.GridCells;
import androidx.compose.foundation.lazy.grid.LazyGridDslKt;
import androidx.compose.foundation.lazy.grid.LazyGridItemScope;
import androidx.compose.foundation.lazy.grid.LazyGridScope;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.foundation.text.BasicTextFieldKt;
import androidx.compose.foundation.text.KeyboardActions;
import androidx.compose.foundation.text.KeyboardOptions;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.FloatingActionButtonKt;
import androidx.compose.material3.IconButtonColors;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.SwitchColors;
import androidx.compose.material3.SwitchKt;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.AndroidImageBitmap_androidKt;
import androidx.compose.ui.graphics.Brush;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.ImageBitmap;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.LayoutCoordinates;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.layout.OnGloballyPositionedModifierKt;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextLayoutResult;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontStyle;
import androidx.compose.ui.text.font.FontSynthesis;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.input.ImeAction;
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
import androidx.core.graphics.drawable.DrawableKt;
import androidx.profileinstaller.ProfileVerifier;
import com.pspdfkit.R;
import com.pspdfkit.annotations.StampAnnotation;
import com.pspdfkit.annotations.stamps.StampPickerItem;
import com.pspdfkit.compose.theme.SettingsColorScheme;
import com.pspdfkit.compose.theme.UiTheme;
import com.pspdfkit.compose.theme.UiThemeKt;
import com.pspdfkit.ui.toolbar.ContextualToolbar;
import external.sdk.pendo.io.mozilla.javascript.Token;
import io.nutrient.ui.theme.ThemeWrapperKt;
import java.util.List;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.text.StringsKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
public final class hc {

    @DebugMetadata(c = "com.pspdfkit.internal.ui.dialog.stamps.composables.CustomStampCreatorComposableKt$CustomStampCreatorComposable$3$1$1$2$1$1$1$1", f = "CustomStampCreatorComposable.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, nl = {}, s = {}, v = 2)
    public static final class a extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public final /* synthetic */ k40 a;
        public final /* synthetic */ MutableIntState b;
        public final /* synthetic */ MutableIntState c;
        public final /* synthetic */ MutableIntState d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(k40 k40Var, MutableIntState mutableIntState, MutableIntState mutableIntState2, MutableIntState mutableIntState3, Continuation<? super a> continuation) {
            super(2, continuation);
            this.a = k40Var;
            this.b = mutableIntState;
            this.c = mutableIntState2;
            this.d = mutableIntState3;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new a(this.a, this.b, this.c, this.d, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return ((a) create(coroutineScope, continuation)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            ResultKt.throwOnFailure(obj);
            if (this.b.getIntValue() > 0) {
                MutableIntState mutableIntState = this.c;
                int intValue = this.b.getIntValue();
                k40 k40Var = this.a;
                mutableIntState.setIntValue((((int) (intValue - (k40Var.a * 2))) / 5) - (((int) k40Var.g) * 5));
                MutableIntState mutableIntState2 = this.d;
                int intValue2 = this.c.getIntValue();
                int size = ww.j.size();
                k40 k40Var2 = this.a;
                float f = k40Var2.g;
                int i = (int) f;
                mutableIntState2.setIntValue((((int) k40Var2.c) * 2) + (((i * 2) + intValue2) * ((int) Math.ceil(((double) size) / 5.0d))) + i);
            }
            return Unit.INSTANCE;
        }
    }

    public static final class b implements Function0<Unit> {
        public final /* synthetic */ int a;
        public final /* synthetic */ Context b;
        public final /* synthetic */ StampPickerItem c;
        public final /* synthetic */ MutableIntState d;
        public final /* synthetic */ MutableState<String> e;
        public final /* synthetic */ MutableState<String> f;
        public final /* synthetic */ MutableState<StampPickerItem> g;

        public b(int i, Context context, StampPickerItem stampPickerItem, MutableIntState mutableIntState, MutableState<String> mutableState, MutableState<String> mutableState2, MutableState<StampPickerItem> mutableState3) {
            this.a = i;
            this.b = context;
            this.c = stampPickerItem;
            this.d = mutableIntState;
            this.e = mutableState;
            this.f = mutableState2;
            this.g = mutableState3;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            this.d.setIntValue(this.a);
            this.g.setValue(g40.a(this.b, this.d.getIntValue(), this.e.getValue(), this.f.getValue(), this.c));
            return Unit.INSTANCE;
        }
    }

    public static final class c implements Function1<Integer, Object> {
        public final /* synthetic */ Function2 a;
        public final /* synthetic */ List b;

        public c(Function2 function2, List list) {
            this.a = function2;
            this.b = list;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Integer num) {
            int iIntValue = num.intValue();
            return this.a.invoke(Integer.valueOf(iIntValue), this.b.get(iIntValue));
        }
    }

    public static final class d implements Function1<Integer, Object> {
        public final /* synthetic */ List a;

        public d(List list) {
            this.a = list;
        }

        @Override // kotlin.jvm.functions.Function1
        public final Object invoke(Integer num) {
            this.a.get(num.intValue());
            return null;
        }
    }

    public static final class e implements Function4<LazyGridItemScope, Integer, Composer, Integer, Unit> {
        public final /* synthetic */ List a;
        public final /* synthetic */ k40 b;
        public final /* synthetic */ MutableIntState c;
        public final /* synthetic */ MutableState d;
        public final /* synthetic */ Context e;
        public final /* synthetic */ MutableState f;
        public final /* synthetic */ MutableState g;
        public final /* synthetic */ StampPickerItem h;
        public final /* synthetic */ MutableIntState i;
        public final /* synthetic */ Density j;

        public e(List list, k40 k40Var, MutableIntState mutableIntState, MutableState mutableState, Context context, MutableState mutableState2, MutableState mutableState3, StampPickerItem stampPickerItem, MutableIntState mutableIntState2, Density density) {
            this.a = list;
            this.b = k40Var;
            this.c = mutableIntState;
            this.d = mutableState;
            this.e = context;
            this.f = mutableState2;
            this.g = mutableState3;
            this.h = stampPickerItem;
            this.i = mutableIntState2;
            this.j = density;
        }

        public final void a(LazyGridItemScope lazyGridItemScope, int i, Composer composer, int i2) {
            int i3;
            Modifier modifierThen;
            if ((i2 & 6) == 0) {
                i3 = i2 | (composer.changed(lazyGridItemScope) ? 4 : 2);
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
            int iIntValue = ((Number) this.a.get(i)).intValue();
            composer.startReplaceGroup(1377736813);
            Modifier modifier = Modifier.INSTANCE;
            Modifier modifierM1218padding3ABfNKs = PaddingKt.m1218padding3ABfNKs(modifier, this.b.h);
            modifierM1218padding3ABfNKs.getClass();
            ("custom_stamp_color_picker_" + i).getClass();
            Alignment.Companion companion = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion.getTopStart(), false);
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1218padding3ABfNKs);
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
            f2.a(companion2, composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, composerM6062constructorimpl, currentCompositionLocalMap);
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion2, composerM6062constructorimpl, Integer.valueOf(iHashCode), composerM6062constructorimpl));
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            if (this.i.getIntValue() > 0) {
                int intValue = this.i.getIntValue();
                Density density = this.j;
                density.getClass();
                modifierThen = modifier.then(SizeKt.m1266size3ABfNKs(modifier, density.mo751toDpu2uoSUM(intValue)));
            } else {
                modifierThen = modifier.then(modifier);
            }
            Modifier modifierM589backgroundbw27NRU$default = BackgroundKt.m589backgroundbw27NRU$default(ClipKt.clip(boxScopeInstance.align(modifierThen, companion.getCenter()), RoundedCornerShapeKt.RoundedCornerShape(this.b.f)), ColorKt.Color(iIntValue), null, 2, null);
            boolean zChanged = composer.changed(this.c) | composer.changed(iIntValue) | composer.changed(this.d) | composer.changedInstance(this.e) | composer.changed(this.f) | composer.changed(this.g) | composer.changedInstance(this.h);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                b bVar = new b(iIntValue, this.e, this.h, this.c, this.f, this.g, this.d);
                composer.updateRememberedValue(bVar);
                objRememberedValue = bVar;
            }
            SpacerKt.Spacer(ClickableKt.m632clickableoSLSa3U$default(modifierM589backgroundbw27NRU$default, false, null, null, null, (Function0) objRememberedValue, 15, null), composer, 0);
            if (iIntValue == this.c.getIntValue()) {
                composer.startReplaceGroup(-170439288);
                Painter painterPainterResource = PainterResources_androidKt.painterResource(R.drawable.pspdf__ic_done, composer, 0);
                long jM6851getWhite0d7_KjU = Color.INSTANCE.m6851getWhite0d7_KjU();
                Modifier modifierAlign = boxScopeInstance.align(modifier, companion.getCenter());
                modifierAlign.getClass();
                ("custom_stamp_check_" + i).getClass();
                IconKt.m3575Iconww6aTOc(painterPainterResource, "", modifierAlign, jM6851getWhite0d7_KjU, composer, Painter.$stable | 3120, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-169867276);
                composer.endReplaceGroup();
            }
            composer.endNode();
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

    public static final Unit a(Function0 function0, Composer composer, int i) {
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1300750671, i, -1, "com.pspdfkit.internal.ui.dialog.stamps.composables.CustomStampCreatorComposable.<anonymous>.<anonymous> (CustomStampCreatorComposable.kt:120)");
            }
            IconButtonKt.IconButton((Function0<Unit>) function0, (Modifier) null, false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, (Function2<? super Composer, ? super Integer, Unit>) q9.a, composer, 1572864, 62);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final MutableState b() {
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default("", null, 2, null);
    }

    public static final MutableState c() {
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
    }

    public static final MutableState d() {
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(Boolean.TRUE, null, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit b(Context context, StampPickerItem stampPickerItem, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableIntState mutableIntState, MutableState mutableState4, MutableState mutableState5, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
        mutableState3.setValue(g40.a(context, ((Boolean) mutableState2.getValue()).booleanValue(), ((Boolean) mutableState.getValue()).booleanValue()));
        mutableState5.setValue(g40.a(context, mutableIntState.getIntValue(), (String) mutableState4.getValue(), (String) mutableState3.getValue(), stampPickerItem));
        return Unit.INSTANCE;
    }

    public static final Unit a(String str, StampPickerItem stampPickerItem, Function0 function0, Function1 function1, j40 j40Var, wc.a aVar, Modifier modifier, int i, Composer composer, int i2) {
        a(str, stampPickerItem, (Function0<Unit>) function0, (Function1<? super StampPickerItem, Unit>) function1, j40Var, aVar, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final void a(final String str, final StampPickerItem stampPickerItem, final Function0<Unit> function0, final Function1<? super StampPickerItem, Unit> function1, final j40 j40Var, final wc.a aVar, final Modifier modifier, Composer composer, final int i) {
        int i2;
        Function1<? super StampPickerItem, Unit> function2;
        Composer composer2;
        str.getClass();
        function0.getClass();
        function1.getClass();
        j40Var.getClass();
        aVar.getClass();
        modifier.getClass();
        Composer composerStartRestartGroup = composer.startRestartGroup(1561936145);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(str) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(stampPickerItem) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            function2 = function1;
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 2048 : 1024;
        } else {
            function2 = function1;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(j40Var) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(aVar) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(modifier) ? 1048576 : 524288;
        }
        if (composerStartRestartGroup.shouldExecute((599187 & i2) != 599186, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1561936145, i2, -1, "com.pspdfkit.internal.ui.dialog.stamps.composables.CustomStampCreatorComposable (CustomStampCreatorComposable.kt:99)");
            }
            final Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            final k40 k40Var = new k40(context, (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity()));
            Object[] objArr = new Object[0];
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(stampPickerItem);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.pspdfkit.internal.hc$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return hc.a(stampPickerItem);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) RememberSaveableKt.rememberSaveable(objArr, (Function0) objRememberedValue, composerStartRestartGroup, 0);
            Object[] objArr2 = new Object[0];
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            Composer.Companion companion = Composer.INSTANCE;
            if (objRememberedValue2 == companion.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.pspdfkit.internal.hc$$ExternalSyntheticLambda21
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return hc.b();
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState2 = (MutableState) RememberSaveableKt.rememberSaveable(objArr2, (Function0) objRememberedValue2, composerStartRestartGroup, 48);
            Object[] objArr3 = new Object[0];
            Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue3 == companion.getEmpty()) {
                objRememberedValue3 = new Function0() { // from class: com.pspdfkit.internal.hc$$ExternalSyntheticLambda22
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return hc.c();
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            final MutableState mutableState3 = (MutableState) RememberSaveableKt.rememberSaveable(objArr3, (Function0) objRememberedValue3, composerStartRestartGroup, 48);
            Object[] objArr4 = new Object[0];
            Object objRememberedValue4 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue4 == companion.getEmpty()) {
                objRememberedValue4 = new Function0() { // from class: com.pspdfkit.internal.hc$$ExternalSyntheticLambda23
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return hc.d();
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
            }
            final MutableState mutableState4 = (MutableState) RememberSaveableKt.rememberSaveable(objArr4, (Function0) objRememberedValue4, composerStartRestartGroup, 48);
            Object[] objArr5 = new Object[0];
            boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(context) | composerStartRestartGroup.changed(mutableState3) | composerStartRestartGroup.changed(mutableState4);
            Object objRememberedValue5 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance2 || objRememberedValue5 == companion.getEmpty()) {
                objRememberedValue5 = new Function0() { // from class: com.pspdfkit.internal.hc$$ExternalSyntheticLambda24
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return hc.a(context, mutableState3, mutableState4);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue5);
            }
            final MutableState mutableState5 = (MutableState) RememberSaveableKt.rememberSaveable(objArr5, (Function0) objRememberedValue5, composerStartRestartGroup, 0);
            Object[] objArr6 = new Object[0];
            Object objRememberedValue6 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue6 == companion.getEmpty()) {
                objRememberedValue6 = new Function0() { // from class: com.pspdfkit.internal.hc$$ExternalSyntheticLambda25
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return hc.a();
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue6);
            }
            final MutableIntState mutableIntState = (MutableIntState) RememberSaveableKt.rememberSaveable(objArr6, (Function0) objRememberedValue6, composerStartRestartGroup, 48);
            final Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            Object objRememberedValue7 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue7 == companion.getEmpty()) {
                objRememberedValue7 = SnapshotIntStateKt.mutableIntStateOf(0);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue7);
            }
            final MutableIntState mutableIntState2 = (MutableIntState) objRememberedValue7;
            Object objRememberedValue8 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue8 == companion.getEmpty()) {
                objRememberedValue8 = SnapshotIntStateKt.mutableIntStateOf(0);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue8);
            }
            final MutableIntState mutableIntState3 = (MutableIntState) objRememberedValue8;
            Object objRememberedValue9 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue9 == companion.getEmpty()) {
                objRememberedValue9 = SnapshotIntStateKt.mutableIntStateOf(0);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue9);
            }
            final MutableIntState mutableIntState4 = (MutableIntState) objRememberedValue9;
            final i40 i40Var = new i40(context);
            Object objRememberedValue10 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue10 == companion.getEmpty()) {
                objRememberedValue10 = new Function1() { // from class: com.pspdfkit.internal.hc$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return hc.a(mutableIntState2, (LayoutCoordinates) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue10);
            }
            composer2 = composerStartRestartGroup;
            final Function1<? super StampPickerItem, Unit> function3 = function2;
            ScaffoldKt.m4038ScaffoldTvnljyQ(OnGloballyPositionedModifierKt.onGloballyPositioned(modifier, (Function1) objRememberedValue10), ComposableLambdaKt.rememberComposableLambda(449865685, true, new Function2() { // from class: com.pspdfkit.internal.hc$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return hc.a(aVar, str, function0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), null, null, null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(-1250648032, true, new Function3() { // from class: com.pspdfkit.internal.hc$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return hc.a(i40Var, k40Var, context, density, mutableIntState, mutableState, mutableState2, mutableState5, stampPickerItem, j40Var, mutableState3, mutableState4, mutableIntState2, mutableIntState3, mutableIntState4, function3, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer2, 54), composer2, 805306416, 508);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.hc$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return hc.a(str, stampPickerItem, function0, function1, j40Var, aVar, modifier, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit b(k40 k40Var, i40 i40Var, j40 j40Var, final MutableState mutableState, final MutableState mutableState2, final Context context, final MutableState mutableState3, final MutableState mutableState4, final MutableIntState mutableIntState, final MutableState mutableState5, final StampPickerItem stampPickerItem, Composer composer, int i) {
        Object obj;
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2132915243, i, -1, "com.pspdfkit.internal.ui.dialog.stamps.composables.CustomStampCreatorComposable.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (CustomStampCreatorComposable.kt:287)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierM1220paddingVpY3zN4$default = PaddingKt.m1220paddingVpY3zN4$default(companion, k40Var.b, 0.0f, 2, null);
            Arrangement arrangement = Arrangement.INSTANCE;
            Arrangement.Vertical top = arrangement.getTop();
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), composer, 0);
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1220paddingVpY3zN4$default);
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
            SettingsColorScheme settingsColorScheme = UiTheme.INSTANCE.getColors(composer, 6).getSettingsColorScheme();
            SwitchColors switchColorsForSwitch = settingsColorScheme.m13954copy4JmcsL4((119 & 1) != 0 ? settingsColorScheme.selectedColor : 0L, (119 & 2) != 0 ? settingsColorScheme.unselectedColor : 0L, (119 & 4) != 0 ? settingsColorScheme.unselectedTextColor : 0L, (119 & 8) != 0 ? settingsColorScheme.background : ColorKt.Color(i40Var.g), (119 & 16) != 0 ? settingsColorScheme.dividerColor : 0L, (119 & 32) != 0 ? settingsColorScheme.titleTextColor : 0L, (119 & 64) != 0 ? settingsColorScheme.labelTextColor : 0L).forSwitch(composer, 0);
            Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null);
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getSpaceBetween(), companion2.getCenterVertically(), composer, 54);
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
            f2.a(companion3, composerM6062constructorimpl2, measurePolicyRowMeasurePolicy, composerM6062constructorimpl2, currentCompositionLocalMap2);
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion3, composerM6062constructorimpl2, Integer.valueOf(iHashCode2), composerM6062constructorimpl2));
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(R.string.pspdf__date_switch, composer, 0), null, ColorKt.Color(j40Var.b), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 262138);
            boolean zBooleanValue = ((Boolean) mutableState.getValue()).booleanValue();
            companion.getClass();
            boolean zChanged = composer.changed(mutableState) | composer.changed(mutableState2) | composer.changedInstance(context) | composer.changed(mutableState3) | composer.changed(mutableState4) | composer.changed(mutableIntState) | composer.changed(mutableState5) | composer.changedInstance(stampPickerItem);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                obj = new Function1() { // from class: com.pspdfkit.internal.hc$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return hc.a(context, stampPickerItem, mutableState, mutableState3, mutableState2, mutableIntState, mutableState5, mutableState4, ((Boolean) obj2).booleanValue());
                    }
                };
                composer.updateRememberedValue(obj);
            } else {
                obj = objRememberedValue;
            }
            SwitchKt.Switch(zBooleanValue, (Function1) obj, companion, null, false, switchColorsForSwitch, null, composer, 0, 88);
            composer.endNode();
            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(companion, 0.0f, 1, 0);
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(arrangement.getSpaceBetween(), companion2.getCenterVertically(), composer, 54);
            int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer, modifierFillMaxWidth$default2);
            Function0<ComposeUiNode> constructor3 = r40.getConstructor();
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
            f2.a(r40, composerM6062constructorimpl3, measurePolicyRowMeasurePolicy2, composerM6062constructorimpl3, currentCompositionLocalMap3);
            Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier3, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion3, composerM6062constructorimpl3, Integer.valueOf(iHashCode3), composerM6062constructorimpl3));
            TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(R.string.pspdf__time_switch, composer, 0), null, ColorKt.Color(j40Var.b), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 262138);
            boolean zBooleanValue2 = ((Boolean) mutableState3.getValue()).booleanValue();
            companion.getClass();
            boolean zChanged2 = composer.changed(mutableState3) | composer.changed(mutableState2) | composer.changedInstance(context) | composer.changed(mutableState) | composer.changed(mutableState4) | composer.changed(mutableIntState) | composer.changed(mutableState5) | composer.changedInstance(stampPickerItem);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                Function1 function1 = new Function1() { // from class: com.pspdfkit.internal.hc$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return hc.b(context, stampPickerItem, mutableState3, mutableState, mutableState2, mutableIntState, mutableState5, mutableState4, ((Boolean) obj2).booleanValue());
                    }
                };
                composer.updateRememberedValue(function1);
                objRememberedValue2 = function1;
            }
            SwitchKt.Switch(zBooleanValue2, (Function1) objRememberedValue2, companion, null, false, switchColorsForSwitch, null, composer, 0, 88);
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

    public static final MutableState a(StampPickerItem stampPickerItem) {
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(stampPickerItem, null, 2, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit a(Context context, StampPickerItem stampPickerItem, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableIntState mutableIntState, MutableState mutableState4, MutableState mutableState5, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
        mutableState3.setValue(g40.a(context, ((Boolean) mutableState.getValue()).booleanValue(), ((Boolean) mutableState2.getValue()).booleanValue()));
        mutableState5.setValue(g40.a(context, mutableIntState.getIntValue(), (String) mutableState4.getValue(), (String) mutableState3.getValue(), stampPickerItem));
        return Unit.INSTANCE;
    }

    public static final MutableIntState a() {
        return SnapshotIntStateKt.mutableIntStateOf(ww.j.get(2).intValue());
    }

    public static final Unit a(wc.a aVar, final String str, final Function0 function0, Composer composer, int i) {
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(449865685, i, -1, "com.pspdfkit.internal.ui.dialog.stamps.composables.CustomStampCreatorComposable.<anonymous> (CustomStampCreatorComposable.kt:117)");
            }
            AppBarKt.m2784TopAppBarGHTll3U(ComposableLambdaKt.rememberComposableLambda(-440892527, true, new Function2() { // from class: com.pspdfkit.internal.hc$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return hc.a(str, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, ComposableLambdaKt.rememberComposableLambda(1300750671, true, new Function2() { // from class: com.pspdfkit.internal.hc$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return hc.a(function0, (Composer) obj, ((Integer) obj2).intValue());
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
                ComposerKt.traceEventStart(-440892527, i, -1, "com.pspdfkit.internal.ui.dialog.stamps.composables.CustomStampCreatorComposable.<anonymous>.<anonymous> (CustomStampCreatorComposable.kt:118)");
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

    public static final Unit a(MutableIntState mutableIntState, LayoutCoordinates layoutCoordinates) {
        layoutCoordinates.getClass();
        mutableIntState.setIntValue((int) (layoutCoordinates.mo8273getSizeYbymL2g() >> 32));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v10 */
    /* JADX WARN: Type inference failed for: r10v2, types: [int] */
    /* JADX WARN: Type inference failed for: r10v8 */
    public static final Unit a(final i40 i40Var, final k40 k40Var, final Context context, final Density density, final MutableIntState mutableIntState, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, final StampPickerItem stampPickerItem, final j40 j40Var, final MutableState mutableState4, final MutableState mutableState5, final MutableIntState mutableIntState2, final MutableIntState mutableIntState3, final MutableIntState mutableIntState4, final Function1 function1, PaddingValues paddingValues, Composer composer, int i) {
        int i2;
        boolean z;
        z30 z30Var;
        boolean z2;
        MutableIntState mutableIntState5;
        final MutableState mutableState6;
        MutableState mutableState7;
        MutableState mutableState8;
        Composer composer2;
        ?? r10;
        Object obj;
        Composer composer3;
        Bitmap bitmap$default;
        final Context context2 = context;
        paddingValues.getClass();
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(paddingValues) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1250648032, i2, -1, "com.pspdfkit.internal.ui.dialog.stamps.composables.CustomStampCreatorComposable.<anonymous> (CustomStampCreatorComposable.kt:138)");
            }
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierPadding = PaddingKt.padding(SizeKt.fillMaxSize$default(BackgroundKt.m589backgroundbw27NRU$default(companion, ColorKt.Color(i40Var.g), null, 2, null), 0.0f, 1, null), paddingValues);
            Alignment.Companion companion2 = Alignment.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion2.getTopStart(), false);
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierPadding);
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
            f2.a(companion3, composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, composerM6062constructorimpl, currentCompositionLocalMap);
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion3, composerM6062constructorimpl, Integer.valueOf(iHashCode), composerM6062constructorimpl));
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), companion2.getStart(), composer, 0);
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, companion);
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
            f2.a(companion3, composerM6062constructorimpl2, measurePolicyColumnMeasurePolicy, composerM6062constructorimpl2, currentCompositionLocalMap2);
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion3, composerM6062constructorimpl2, Integer.valueOf(iHashCode2), composerM6062constructorimpl2));
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            String str = (String) mutableState3.getValue();
            StampPickerItem stampPickerItem2 = (StampPickerItem) mutableState.getValue();
            context2.getClass();
            if (stampPickerItem2 == null) {
                z = true;
                z30Var = null;
            } else {
                StampAnnotation stampAnnotationCreateStampAnnotation = stampPickerItem2.createStampAnnotation(0);
                stampAnnotationCreateStampAnnotation.getClass();
                stampAnnotationCreateStampAnnotation.setSubtitle(str);
                z30 z30Var2 = new z30(context2, stampAnnotationCreateStampAnnotation);
                RectF boundingBox = stampAnnotationCreateStampAnnotation.getBoundingBox();
                boundingBox.sort();
                float fWidth = boundingBox.width();
                DisplayMetrics displayMetrics = context2.getResources().getDisplayMetrics();
                displayMetrics.getClass();
                z = true;
                int iApplyDimension = (int) TypedValue.applyDimension(1, fWidth, displayMetrics);
                float fHeight = boundingBox.height();
                DisplayMetrics displayMetrics2 = context2.getResources().getDisplayMetrics();
                displayMetrics2.getClass();
                int iApplyDimension2 = (int) TypedValue.applyDimension(1, fHeight, displayMetrics2);
                z30Var2.r = iApplyDimension;
                z30Var2.s = iApplyDimension2;
                z30Var = z30Var2;
            }
            ImageBitmap imageBitmapAsImageBitmap = (z30Var == null || (bitmap$default = DrawableKt.toBitmap$default(z30Var, 0, 0, null, 7, null)) == null) ? null : AndroidImageBitmap_androidKt.asImageBitmap(bitmap$default);
            if (imageBitmapAsImageBitmap == null) {
                composer.startReplaceGroup(-1936022367);
                composer.endReplaceGroup();
                context2 = context2;
                mutableState7 = mutableState2;
                mutableIntState5 = mutableIntState;
                mutableState8 = mutableState3;
                composer2 = composer;
                r10 = z;
                z2 = false;
                mutableState6 = mutableState;
            } else {
                composer.startReplaceGroup(-1936022366);
                boolean z3 = z;
                z2 = false;
                ImageKt.m656Image5hnEew(imageBitmapAsImageBitmap, stampPickerItem != null ? stampPickerItem.getTitle() : null, PaddingKt.m1218padding3ABfNKs(columnScopeInstance.align(companion, companion2.getCenterHorizontally()), k40Var.d), null, null, 0.0f, null, 0, composer, 0, 248);
                String str2 = (String) mutableState2.getValue();
                KeyboardOptions keyboardOptions = new KeyboardOptions(0, (Boolean) null, 0, ImeAction.INSTANCE.m9277getDoneeUduSuo(), (PlatformImeOptions) null, (Boolean) null, (LocaleList) null, 119, (DefaultConstructorMarker) null);
                TextStyle textStyle = new TextStyle(ColorKt.Color(j40Var.b), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null);
                Modifier modifierFillMaxWidth$default = SizeKt.fillMaxWidth$default(companion, 0.0f, z3 ? 1 : 0, null);
                float f = k40Var.b;
                Modifier modifierM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(modifierFillMaxWidth$default, f, k40Var.d, f, 0.0f, 8, null);
                boolean zChanged = composer.changed(mutableState2) | composer.changed(mutableState) | composer.changedInstance(context2) | composer.changed(mutableIntState) | composer.changed(mutableState3) | composer.changedInstance(stampPickerItem);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.pspdfkit.internal.hc$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return hc.a(context2, stampPickerItem, mutableState2, mutableIntState, mutableState3, mutableState, (String) obj2);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                BasicTextFieldKt.BasicTextField(str2, (Function1<? super String, Unit>) objRememberedValue, modifierM1222paddingqDBjuR0$default, false, false, textStyle, keyboardOptions, (KeyboardActions) null, true, 0, 0, (VisualTransformation) null, (Function1<? super TextLayoutResult, Unit>) null, (MutableInteractionSource) null, (Brush) null, (Function3<? super Function2<? super Composer, ? super Integer, Unit>, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(1062154850, z3, new Function3() { // from class: com.pspdfkit.internal.hc$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj2, Object obj3, Object obj4) {
                        return hc.a(j40Var, mutableState2, (Function2) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                    }
                }, composer, 54), composer, 102236160, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 32408);
                float f2 = k40Var.b;
                mutableIntState5 = mutableIntState;
                mutableState6 = mutableState;
                mutableState7 = mutableState2;
                mutableState8 = mutableState3;
                DividerKt.m3284HorizontalDivider9IZ8Weo(PaddingKt.m1222paddingqDBjuR0$default(companion, f2, k40Var.d, f2, 0.0f, 8, null), 0.0f, 0L, composer, 0, 6);
                composer2 = composer;
                Unit unit = Unit.INSTANCE;
                composer2.endReplaceGroup();
                r10 = z3;
            }
            Modifier modifierFillMaxWidth$default2 = SizeKt.fillMaxWidth$default(companion, 0.0f, r10, null);
            Alignment.Horizontal centerHorizontally = companion2.getCenterHorizontally();
            boolean zChanged2 = composer2.changed(k40Var) | composer2.changed(density) | composer2.changed(mutableIntState5) | composer2.changed(mutableState6) | composer2.changedInstance(context2) | composer2.changed(mutableState7) | composer2.changed(mutableState8) | composer2.changedInstance(stampPickerItem) | composer2.changedInstance(i40Var) | composer2.changedInstance(j40Var) | composer2.changed(mutableState4) | composer2.changed(mutableState5);
            Object objRememberedValue2 = composer2.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                final MutableIntState mutableIntState6 = mutableIntState5;
                final MutableState mutableState9 = mutableState6;
                final MutableState mutableState10 = mutableState7;
                final MutableState mutableState11 = mutableState8;
                obj = new Function1() { // from class: com.pspdfkit.internal.hc$$ExternalSyntheticLambda18
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj2) {
                        return hc.a(k40Var, density, mutableIntState6, mutableState9, context, mutableState10, mutableState11, stampPickerItem, mutableIntState2, mutableIntState3, mutableIntState4, i40Var, j40Var, mutableState4, mutableState5, (LazyListScope) obj2);
                    }
                };
                composer3 = composer;
                mutableState6 = mutableState9;
                composer3.updateRememberedValue(obj);
            } else {
                obj = objRememberedValue2;
                composer3 = composer2;
            }
            LazyDslKt.LazyColumn(modifierFillMaxWidth$default2, null, null, false, null, centerHorizontally, null, false, null, (Function1) obj, composer3, 196614, 478);
            composer3.endNode();
            if (((String) mutableState2.getValue()).length() > 0) {
                z2 = true;
            }
            Modifier modifierAlign = boxScopeInstance.align(companion, companion2.getBottomEnd());
            float f3 = k40Var.e;
            Modifier modifierM1222paddingqDBjuR0$default2 = PaddingKt.m1222paddingqDBjuR0$default(modifierAlign, 0.0f, 0.0f, f3, f3, 3, null);
            modifierM1222paddingqDBjuR0$default2.getClass();
            AnimatedVisibilityKt.AnimatedVisibility(z2, modifierM1222paddingqDBjuR0$default2, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(-849027710, true, new Function3() { // from class: com.pspdfkit.internal.hc$$ExternalSyntheticLambda19
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj2, Object obj3, Object obj4) {
                    return hc.a(j40Var, function1, mutableState6, (AnimatedVisibilityScope) obj2, (Composer) obj3, ((Integer) obj4).intValue());
                }
            }, composer3, 54), composer3, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
            composer.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit a(Context context, StampPickerItem stampPickerItem, MutableState mutableState, MutableIntState mutableIntState, MutableState mutableState2, MutableState mutableState3, String str) {
        str.getClass();
        mutableState.setValue(StringsKt.take(str, 40));
        mutableState3.setValue(g40.a(context, mutableIntState.getIntValue(), (String) mutableState.getValue(), (String) mutableState2.getValue(), stampPickerItem));
        return Unit.INSTANCE;
    }

    public static final Unit a(final k40 k40Var, final Density density, final MutableIntState mutableIntState, final MutableState mutableState, final Context context, final MutableState mutableState2, final MutableState mutableState3, final StampPickerItem stampPickerItem, final MutableIntState mutableIntState2, final MutableIntState mutableIntState3, final MutableIntState mutableIntState4, final i40 i40Var, final j40 j40Var, final MutableState mutableState4, final MutableState mutableState5, LazyListScope lazyListScope) {
        lazyListScope.getClass();
        LazyListScope.item$default(lazyListScope, null, null, ComposableLambdaKt.composableLambdaInstance(1494865775, true, new Function3() { // from class: com.pspdfkit.internal.hc$$ExternalSyntheticLambda13
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return hc.a(k40Var, density, mutableIntState, mutableState, context, mutableState2, mutableState3, stampPickerItem, mutableIntState2, mutableIntState3, mutableIntState4, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        LazyListScope.item$default(lazyListScope, null, null, ComposableLambdaKt.composableLambdaInstance(-189358824, true, new Function3() { // from class: com.pspdfkit.internal.hc$$ExternalSyntheticLambda14
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return hc.a(context, k40Var, i40Var, j40Var, mutableState4, mutableState3, mutableState5, mutableState, mutableIntState, mutableState2, stampPickerItem, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        return Unit.INSTANCE;
    }

    public static final Unit a(k40 k40Var, MutableIntState mutableIntState, MutableState mutableState, Context context, MutableState mutableState2, MutableState mutableState3, StampPickerItem stampPickerItem, MutableIntState mutableIntState2, Density density, LazyGridScope lazyGridScope) {
        lazyGridScope.getClass();
        List<Integer> list = ww.j;
        lazyGridScope.items(list.size(), new c(new Function2() { // from class: com.pspdfkit.internal.hc$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return hc.a(((Integer) obj).intValue(), ((Integer) obj2).intValue());
            }
        }, list), null, new d(list), ComposableLambdaKt.composableLambdaInstance(-1942245546, true, new e(list, k40Var, mutableIntState, mutableState, context, mutableState2, mutableState3, stampPickerItem, mutableIntState2, density)));
        return Unit.INSTANCE;
    }

    public static final Object a(int i, int i2) {
        return Integer.valueOf(i2);
    }

    public static final Unit a(final Context context, final k40 k40Var, final i40 i40Var, final j40 j40Var, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, final MutableIntState mutableIntState, final MutableState mutableState5, final StampPickerItem stampPickerItem, LazyItemScope lazyItemScope, Composer composer, int i) {
        lazyItemScope.getClass();
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-189358824, i, -1, "com.pspdfkit.internal.ui.dialog.stamps.composables.CustomStampCreatorComposable.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (CustomStampCreatorComposable.kt:280)");
            }
            CompositionLocalKt.CompositionLocalProvider(AndroidCompositionLocals_androidKt.getLocalContext().provides(new ContextThemeWrapper(context, f60.b(context, R.attr.pspdf__settingsDialogStyle, R.style.PSPDFKit_SettingsDialog))), ComposableLambdaKt.rememberComposableLambda(1401577560, true, new Function2() { // from class: com.pspdfkit.internal.hc$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return hc.a(k40Var, i40Var, j40Var, mutableState, mutableState2, context, mutableState3, mutableState4, mutableIntState, mutableState5, stampPickerItem, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final Unit a(final k40 k40Var, final i40 i40Var, final j40 j40Var, final MutableState mutableState, final MutableState mutableState2, final Context context, final MutableState mutableState3, final MutableState mutableState4, final MutableIntState mutableIntState, final MutableState mutableState5, final StampPickerItem stampPickerItem, Composer composer, int i) {
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1401577560, i, -1, "com.pspdfkit.internal.ui.dialog.stamps.composables.CustomStampCreatorComposable.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (CustomStampCreatorComposable.kt:286)");
            }
            ThemeWrapperKt.WithUiTheme(UiThemeKt.getUiColors(composer, 0), ComposableLambdaKt.rememberComposableLambda(-2132915243, true, new Function2() { // from class: com.pspdfkit.internal.hc$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return hc.b(k40Var, i40Var, j40Var, mutableState, mutableState2, context, mutableState3, mutableState4, mutableIntState, mutableState5, stampPickerItem, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final Unit a(final j40 j40Var, final Function1 function1, final MutableState mutableState, AnimatedVisibilityScope animatedVisibilityScope, Composer composer, int i) {
        animatedVisibilityScope.getClass();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-849027710, i, -1, "com.pspdfkit.internal.ui.dialog.stamps.composables.CustomStampCreatorComposable.<anonymous>.<anonymous>.<anonymous> (CustomStampCreatorComposable.kt:359)");
        }
        long jColor = ColorKt.Color(j40Var.d);
        boolean zChanged = composer.changed(function1) | composer.changed(mutableState);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: com.pspdfkit.internal.hc$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return hc.a(function1, mutableState);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        FloatingActionButtonKt.m3394FloatingActionButtonXz6DiA((Function0) objRememberedValue, null, null, jColor, 0L, null, null, ComposableLambdaKt.rememberComposableLambda(-1448763840, true, new Function2() { // from class: com.pspdfkit.internal.hc$$ExternalSyntheticLambda9
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return hc.a(j40Var, (Composer) obj, ((Integer) obj2).intValue());
            }
        }, composer, 54), composer, 12582912, 118);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    public static final Unit a(j40 j40Var, Composer composer, int i) {
        Bitmap bitmap$default;
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1448763840, i, -1, "com.pspdfkit.internal.ui.dialog.stamps.composables.CustomStampCreatorComposable.<anonymous>.<anonymous>.<anonymous>.<anonymous> (CustomStampCreatorComposable.kt:363)");
            }
            Drawable drawable = j40Var.f;
            ImageBitmap imageBitmapAsImageBitmap = (drawable == null || (bitmap$default = DrawableKt.toBitmap$default(drawable, 0, 0, null, 7, null)) == null) ? null : AndroidImageBitmap_androidKt.asImageBitmap(bitmap$default);
            if (imageBitmapAsImageBitmap == null) {
                composer.startReplaceGroup(2885873);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(2885874);
                IconKt.m3574Iconww6aTOc(imageBitmapAsImageBitmap, "", (Modifier) null, ColorKt.Color(j40Var.e), composer, 48, 4);
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

    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit a(Function1 function1, MutableState mutableState) {
        function1.invoke((StampPickerItem) mutableState.getValue());
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final Unit a(j40 j40Var, MutableState mutableState, Function2 function2, Composer composer, int i) {
        int i2;
        int i3;
        Composer composer2 = composer;
        function2.getClass();
        if ((i & 6) == 0) {
            i2 = i | (composer2.changedInstance(function2) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (composer2.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1062154850, i2, -1, "com.pspdfkit.internal.ui.dialog.stamps.composables.CustomStampCreatorComposable.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (CustomStampCreatorComposable.kt:165)");
            }
            if (((String) mutableState.getValue()).length() == 0) {
                composer2.startReplaceGroup(1631148777);
                i3 = i2;
                TextKt.m4494TextNvy7gAk(StringResources_androidKt.stringResource(R.string.pspdf__stamp_text, composer2, 0), null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, new TextStyle(ColorKt.Color(j40Var.c), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, (FontFamily) null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777214, (DefaultConstructorMarker) null), composer, 0, 0, 131070);
                composer2 = composer;
                composer2.endReplaceGroup();
            } else {
                i3 = i2;
                composer2.startReplaceGroup(1631416896);
                composer2.endReplaceGroup();
            }
            function2.invoke(composer2, Integer.valueOf(i3 & 14));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static final MutableState a(Context context, MutableState mutableState, MutableState mutableState2) {
        return SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(g40.a(context, ((Boolean) mutableState.getValue()).booleanValue(), ((Boolean) mutableState2.getValue()).booleanValue()), null, 2, null);
    }

    public static final Unit a(final k40 k40Var, final Density density, final MutableIntState mutableIntState, final MutableState mutableState, final Context context, final MutableState mutableState2, final MutableState mutableState3, final StampPickerItem stampPickerItem, MutableIntState mutableIntState2, final MutableIntState mutableIntState3, MutableIntState mutableIntState4, LazyItemScope lazyItemScope, Composer composer, int i) {
        Modifier modifierThen;
        lazyItemScope.getClass();
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1494865775, i, -1, "com.pspdfkit.internal.ui.dialog.stamps.composables.CustomStampCreatorComposable.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (CustomStampCreatorComposable.kt:195)");
            }
            Integer numValueOf = Integer.valueOf(mutableIntState2.getIntValue());
            boolean zChanged = composer.changed(k40Var);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                a aVar = new a(k40Var, mutableIntState2, mutableIntState3, mutableIntState4, null);
                composer.updateRememberedValue(aVar);
                objRememberedValue = aVar;
            }
            EffectsKt.LaunchedEffect(numValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue, composer, 0);
            GridCells.Fixed fixed = new GridCells.Fixed(5);
            Modifier.Companion companion = Modifier.INSTANCE;
            Modifier modifierM1220paddingVpY3zN4$default = PaddingKt.m1220paddingVpY3zN4$default(PaddingKt.m1220paddingVpY3zN4$default(companion, 0.0f, k40Var.d, 1, null), k40Var.b, 0.0f, 2, null);
            if (mutableIntState2.getIntValue() > 0) {
                int intValue = mutableIntState4.getIntValue();
                density.getClass();
                modifierThen = modifierM1220paddingVpY3zN4$default.then(SizeKt.m1254heightInVpY3zN4$default(companion, 0.0f, density.mo751toDpu2uoSUM(intValue), 1, null));
            } else {
                modifierThen = modifierM1220paddingVpY3zN4$default.then(SizeKt.m1254heightInVpY3zN4$default(companion, 0.0f, Dp.m9687constructorimpl(0), 1, null));
            }
            Modifier modifier = modifierThen;
            boolean zChanged2 = composer.changed(k40Var) | composer.changed(density) | composer.changed(mutableIntState) | composer.changed(mutableState) | composer.changedInstance(context) | composer.changed(mutableState2) | composer.changed(mutableState3) | composer.changedInstance(stampPickerItem);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                Function1 function1 = new Function1() { // from class: com.pspdfkit.internal.hc$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return hc.a(k40Var, mutableIntState, mutableState, context, mutableState2, mutableState3, stampPickerItem, mutableIntState3, density, (LazyGridScope) obj);
                    }
                };
                composer.updateRememberedValue(function1);
                objRememberedValue2 = function1;
            }
            LazyGridDslKt.LazyVerticalGrid(fixed, modifier, null, null, false, null, null, null, false, null, (Function1) objRememberedValue2, composer, 0, 0, 1020);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }
}

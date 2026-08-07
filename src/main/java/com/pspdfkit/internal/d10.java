package com.pspdfkit.internal;

import android.content.Context;
import android.content.res.Resources;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.TweenSpec;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.gestures.ScrollExtensionsKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.CardKt;
import androidx.compose.material3.IconButtonColors;
import androidx.compose.material3.IconButtonKt;
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
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.RectangleShapeKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.text.font.DeviceFontFamilyName;
import androidx.compose.ui.text.font.DeviceFontFamilyNameFontKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontFamilyKt;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.profileinstaller.ProfileVerifier;
import com.pspdfkit.R;
import com.pspdfkit.compose.theme.SettingsColorScheme;
import com.pspdfkit.compose.theme.UiTheme;
import com.pspdfkit.configuration.page.PageLayoutMode;
import com.pspdfkit.configuration.page.PageScrollDirection;
import com.pspdfkit.configuration.page.PageScrollMode;
import com.pspdfkit.configuration.settings.SettingsMenuItemType;
import com.pspdfkit.configuration.theming.ThemeMode;
import com.pspdfkit.internal.jni.NativeLicense;
import com.pspdfkit.internal.jni.NativeLicenseFeatures;
import io.nutrient.ui.settings.SettingsOptions;
import java.util.EnumSet;
import java.util.Iterator;
import java.util.Set;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: loaded from: classes3.dex */
public final class d10 {

    public static final /* synthetic */ class a {
        public static final /* synthetic */ EnumEntries<PageScrollMode> a = EnumEntriesKt.enumEntries(PageScrollMode.values());
        public static final /* synthetic */ EnumEntries<PageLayoutMode> b = EnumEntriesKt.enumEntries(PageLayoutMode.values());
        public static final /* synthetic */ EnumEntries<PageScrollDirection> c = EnumEntriesKt.enumEntries(PageScrollDirection.values());
        public static final /* synthetic */ EnumEntries<ThemeMode> d = EnumEntriesKt.enumEntries(ThemeMode.values());
    }

    @DebugMetadata(c = "io.nutrient.internal.ui.settings.SettingsViewKt$SettingsView$1$1$1$4$1$2$1$2", f = "SettingsView.kt", i = {}, l = {343}, m = "invokeSuspend", n = {}, nl = {344}, s = {}, v = 2)
    public static final class b extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        public int a;
        public final /* synthetic */ LazyListState b;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(LazyListState lazyListState, Continuation<? super b> continuation) {
            super(2, continuation);
            this.b = lazyListState;
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object obj, Continuation<?> continuation) {
            return new b(this.b, continuation);
        }

        @Override // kotlin.jvm.functions.Function2
        public final Object invoke(CoroutineScope coroutineScope, Continuation<? super Unit> continuation) {
            return new b(this.b, continuation).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object obj) {
            Object coroutine_suspended = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int i = this.a;
            if (i == 0) {
                ResultKt.throwOnFailure(obj);
                LazyListState lazyListState = this.b;
                TweenSpec tweenSpecTween$default = AnimationSpecKt.tween$default(500, 200, null, 4, null);
                this.a = 1;
                if (ScrollExtensionsKt.animateScrollBy(lazyListState, 600.0f, tweenSpecTween$default, this) == coroutine_suspended) {
                    return coroutine_suspended;
                }
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                ResultKt.throwOnFailure(obj);
            }
            return Unit.INSTANCE;
        }
    }

    public static final /* synthetic */ class c {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[SettingsMenuItemType.values().length];
            try {
                iArr[SettingsMenuItemType.PAGE_TRANSITION.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[SettingsMenuItemType.PAGE_LAYOUT.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[SettingsMenuItemType.SCROLL_DIRECTION.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            a = iArr;
        }
    }

    public static final Unit a(z00 z00Var, boolean z, Function2 function2, Function1 function1, int i, Composer composer, int i2) {
        a(z00Var, z, (Function2<? super Composer, ? super Integer, Unit>) function2, (Function1<? super SettingsOptions, Unit>) function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final Unit b(Function1 function1, z00 z00Var, boolean z) {
        SettingsOptions settingsOptionsCopy = z00Var.a.copy();
        settingsOptionsCopy.setSnapToPoint(z);
        function1.invoke(settingsOptionsCopy);
        return Unit.INSTANCE;
    }

    public static final Unit c(Function1 function1, z00 z00Var, boolean z) {
        SettingsOptions settingsOptionsCopy = z00Var.a.copy();
        settingsOptionsCopy.setShowSmartGuides(z);
        function1.invoke(settingsOptionsCopy);
        return Unit.INSTANCE;
    }

    public static final Unit a(final z00 z00Var, final Function1 function1, LazyItemScope lazyItemScope, Composer composer, int i) {
        lazyItemScope.getClass();
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-373546110, i, -1, "io.nutrient.internal.ui.settings.SettingsView.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SettingsView.kt:125)");
            }
            if (z00Var.a.getVisibleItems().contains(SettingsMenuItemType.PRESETS)) {
                composer.startReplaceGroup(-51757805);
                boolean zChanged = composer.changed(function1) | composer.changedInstance(z00Var);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.pspdfkit.internal.d10$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return d10.a(function1, z00Var, (xw) obj);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                b10.a(z00Var, (Function1) objRememberedValue, composer, 0);
                b10.a(composer, 0);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-51284032);
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

    public static final Unit a(Function1 function1, z00 z00Var, xw xwVar) {
        xwVar.getClass();
        SettingsOptions settingsOptionsCopy = z00Var.a.copy();
        settingsOptionsCopy.setScrollMode(xwVar.a);
        settingsOptionsCopy.setLayoutMode(xwVar.b);
        settingsOptionsCopy.setScrollDirection(xwVar.c);
        function1.invoke(settingsOptionsCopy);
        return Unit.INSTANCE;
    }

    public static final Unit a(Function1 function1, z00 z00Var, PageScrollMode pageScrollMode) {
        SettingsOptions settingsOptionsCopy = z00Var.a.copy();
        settingsOptionsCopy.setScrollMode(pageScrollMode);
        settingsOptionsCopy.setLayoutMode(PageLayoutMode.AUTO);
        function1.invoke(settingsOptionsCopy);
        return Unit.INSTANCE;
    }

    public static final Unit a(Function1 function1, z00 z00Var, PageLayoutMode pageLayoutMode) {
        SettingsOptions settingsOptionsCopy = z00Var.a.copy();
        settingsOptionsCopy.setLayoutMode(pageLayoutMode);
        function1.invoke(settingsOptionsCopy);
        return Unit.INSTANCE;
    }

    public static final Unit a(Function1 function1, z00 z00Var, PageScrollDirection pageScrollDirection) {
        SettingsOptions settingsOptionsCopy = z00Var.a.copy();
        settingsOptionsCopy.setScrollDirection(pageScrollDirection);
        function1.invoke(settingsOptionsCopy);
        return Unit.INSTANCE;
    }

    public static final Unit a(Function1 function1, z00 z00Var, ThemeMode themeMode) {
        SettingsOptions settingsOptionsCopy = z00Var.a.copy();
        settingsOptionsCopy.setThemeMode(themeMode);
        function1.invoke(settingsOptionsCopy);
        return Unit.INSTANCE;
    }

    public static final Unit a(Function1 function1, z00 z00Var, boolean z) {
        SettingsOptions settingsOptionsCopy = z00Var.a.copy();
        settingsOptionsCopy.setScreenTimeoutMillis(z ? Long.MAX_VALUE : 0L);
        function1.invoke(settingsOptionsCopy);
        return Unit.INSTANCE;
    }

    public static final Unit a(Function1 function1, z00 z00Var, CoroutineScope coroutineScope, LazyListState lazyListState, boolean z) {
        SettingsOptions settingsOptionsCopy = z00Var.a.copy();
        settingsOptionsCopy.setSnapToSelf(z);
        settingsOptionsCopy.setShowSmartGuides(false);
        function1.invoke(settingsOptionsCopy);
        if (z) {
            BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, new b(lazyListState, null), 3, null);
        }
        return Unit.INSTANCE;
    }

    public static final void a(final z00 z00Var, final boolean z, final Function2<? super Composer, ? super Integer, Unit> function2, final Function1<? super SettingsOptions, Unit> function1, Composer composer, final int i) {
        int i2;
        Function2<? super Composer, ? super Integer, Unit> function3;
        Function1<? super SettingsOptions, Unit> function4;
        Composer composer2;
        long jM6849getTransparent0d7_KjU;
        Shape shapeM1573RoundedCornerShape0680j_4;
        z00Var.getClass();
        function2.getClass();
        function1.getClass();
        Composer composerStartRestartGroup = composer.startRestartGroup(1689163963);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(z00Var) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            function3 = function2;
            i2 |= composerStartRestartGroup.changedInstance(function3) ? 256 : 128;
        } else {
            function3 = function2;
        }
        if ((i & 3072) == 0) {
            function4 = function1;
            i2 |= composerStartRestartGroup.changedInstance(function4) ? 2048 : 1024;
        } else {
            function4 = function1;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1689163963, i2, -1, "io.nutrient.internal.ui.settings.SettingsView (SettingsView.kt:89)");
            }
            final Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            final Resources resources = (Resources) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalResources());
            final LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
            final Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            final SettingsColorScheme settingsColorScheme = UiTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getSettingsColorScheme();
            float dimension = resources.getDimension(R.dimen.pspdf__settings_mode_popup_window_padding);
            density.getClass();
            final float fMo750toDpu2uoSUM = density.mo750toDpu2uoSUM(dimension);
            final Set setIntersect = CollectionsKt.intersect(z00Var.a.getVisibleItems(), z00Var.d);
            final Set setIntersect2 = CollectionsKt.intersect(z00Var.a.getVisibleItems(), z00Var.e);
            final FontFamily FontFamily = FontFamilyKt.FontFamily(DeviceFontFamilyNameFontKt.m9175Fontvxs03AY$default(DeviceFontFamilyName.m9168constructorimpl("sans-serif-medium"), FontWeight.INSTANCE.getMedium(), 0, null, 12, null));
            a10 a10Var = z00Var.c;
            if (a10Var == null) {
                a10Var = new a10(context);
            }
            if (z) {
                jM6849getTransparent0d7_KjU = settingsColorScheme.m13955getBackground0d7_KjU();
            } else {
                jM6849getTransparent0d7_KjU = Color.INSTANCE.m6849getTransparent0d7_KjU();
            }
            Modifier modifierM589backgroundbw27NRU$default = BackgroundKt.m589backgroundbw27NRU$default(Modifier.INSTANCE, jM6849getTransparent0d7_KjU, null, 2, null);
            if (z) {
                shapeM1573RoundedCornerShape0680j_4 = RectangleShapeKt.getRectangleShape();
            } else {
                shapeM1573RoundedCornerShape0680j_4 = RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(16));
            }
            final Function2<? super Composer, ? super Integer, Unit> function5 = function3;
            final Function1<? super SettingsOptions, Unit> function6 = function4;
            final a10 a10Var2 = a10Var;
            composer2 = composerStartRestartGroup;
            CardKt.Card(modifierM589backgroundbw27NRU$default, shapeM1573RoundedCornerShape0680j_4, null, null, null, ComposableLambdaKt.rememberComposableLambda(-1364296275, true, new Function3() { // from class: com.pspdfkit.internal.d10$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return d10.a(function5, settingsColorScheme, lazyListStateRememberLazyListState, z00Var, function6, setIntersect, fMo750toDpu2uoSUM, resources, density, context, FontFamily, a10Var2, setIntersect2, coroutineScope, (ColumnScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer2, 54), composer2, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 28);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.d10$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return d10.a(z00Var, z, function2, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final Unit a(Function2 function2, final SettingsColorScheme settingsColorScheme, final LazyListState lazyListState, final z00 z00Var, final Function1 function1, final Set set, final float f, final Resources resources, final Density density, final Context context, final FontFamily fontFamily, final a10 a10Var, final Set set2, final CoroutineScope coroutineScope, ColumnScope columnScope, Composer composer, int i) {
        int i2;
        columnScope.getClass();
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(columnScope) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1364296275, i2, -1, "io.nutrient.internal.ui.settings.SettingsView.<anonymous> (SettingsView.kt:115)");
            }
            function2.invoke(composer, 0);
            Modifier modifierM589backgroundbw27NRU$default = BackgroundKt.m589backgroundbw27NRU$default(columnScope.weight(Modifier.INSTANCE, 1.0f, true), settingsColorScheme.m13955getBackground0d7_KjU(), null, 2, null);
            boolean zChangedInstance = composer.changedInstance(z00Var) | composer.changed(function1) | composer.changedInstance(set) | composer.changed(f) | composer.changedInstance(resources) | composer.changed(density) | composer.changedInstance(context) | composer.changed(settingsColorScheme) | composer.changed(fontFamily) | composer.changedInstance(a10Var) | composer.changedInstance(set2) | composer.changedInstance(coroutineScope) | composer.changed(lazyListState);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                Function1 function3 = new Function1() { // from class: com.pspdfkit.internal.d10$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return d10.a(z00Var, function1, set, f, resources, density, context, settingsColorScheme, fontFamily, a10Var, set2, coroutineScope, lazyListState, (LazyListScope) obj);
                    }
                };
                composer.updateRememberedValue(function3);
                objRememberedValue = function3;
            }
            LazyDslKt.LazyColumn(modifierM589backgroundbw27NRU$default, lazyListState, null, false, null, null, null, false, null, (Function1) objRememberedValue, composer, 0, 508);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final Unit a(final z00 z00Var, final Function1 function1, final Set set, final float f, final Resources resources, final Density density, final Context context, final SettingsColorScheme settingsColorScheme, final FontFamily fontFamily, final a10 a10Var, final Set set2, final CoroutineScope coroutineScope, final LazyListState lazyListState, LazyListScope lazyListScope) {
        lazyListScope.getClass();
        LazyListScope.item$default(lazyListScope, null, null, ComposableLambdaKt.composableLambdaInstance(-373546110, true, new Function3() { // from class: com.pspdfkit.internal.d10$$ExternalSyntheticLambda5
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return d10.a(z00Var, function1, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        LazyListScope.item$default(lazyListScope, null, null, ComposableLambdaKt.composableLambdaInstance(-524604231, true, new Function3() { // from class: com.pspdfkit.internal.d10$$ExternalSyntheticLambda6
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return d10.a(set, f, resources, density, context, settingsColorScheme, fontFamily, z00Var, a10Var, function1, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        LazyListScope.item$default(lazyListScope, null, null, ComposableLambdaKt.composableLambdaInstance(1423126202, true, new Function3() { // from class: com.pspdfkit.internal.d10$$ExternalSyntheticLambda7
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return d10.a(set2, f, z00Var, function1, resources, density, context, settingsColorScheme, fontFamily, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        LazyListScope.item$default(lazyListScope, null, null, ComposableLambdaKt.composableLambdaInstance(-924110661, true, new Function3() { // from class: com.pspdfkit.internal.d10$$ExternalSyntheticLambda8
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return d10.a(f, z00Var, function1, coroutineScope, lazyListState, (LazyItemScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }), 3, null);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v19, types: [androidx.compose.foundation.layout.RowScope, androidx.compose.foundation.layout.RowScopeInstance] */
    /* JADX WARN: Type inference failed for: r11v0 */
    /* JADX WARN: Type inference failed for: r11v1, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r11v10 */
    /* JADX WARN: Type inference failed for: r11v11, types: [boolean] */
    /* JADX WARN: Type inference failed for: r11v12 */
    /* JADX WARN: Type inference failed for: r11v13 */
    /* JADX WARN: Type inference failed for: r11v20 */
    /* JADX WARN: Type inference failed for: r11v21, types: [boolean] */
    /* JADX WARN: Type inference failed for: r11v22 */
    /* JADX WARN: Type inference failed for: r11v29 */
    /* JADX WARN: Type inference failed for: r11v30, types: [boolean] */
    /* JADX WARN: Type inference failed for: r11v31 */
    /* JADX WARN: Type inference failed for: r13v15 */
    /* JADX WARN: Type inference failed for: r13v16, types: [boolean] */
    /* JADX WARN: Type inference failed for: r13v17 */
    /* JADX WARN: Type inference failed for: r2v13, types: [int] */
    /* JADX WARN: Type inference failed for: r6v10 */
    /* JADX WARN: Type inference failed for: r6v11 */
    /* JADX WARN: Type inference failed for: r6v6 */
    /* JADX WARN: Type inference failed for: r6v7 */
    /* JADX WARN: Type inference failed for: r6v8 */
    /* JADX WARN: Type inference failed for: r6v9 */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final Unit a(Set set, float f, Resources resources, Density density, Context context, SettingsColorScheme settingsColorScheme, FontFamily fontFamily, final z00 z00Var, a10 a10Var, final Function1 function1, LazyItemScope lazyItemScope, Composer composer, int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        Composer composer2 = composer;
        lazyItemScope.getClass();
        int i8 = 0;
        ?? r11 = 1;
        if (composer2.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-524604231, i, -1, "io.nutrient.internal.ui.settings.SettingsView.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SettingsView.kt:141)");
            }
            if (!set.isEmpty()) {
                composer2.startReplaceGroup(901575840);
                Modifier modifierM1220paddingVpY3zN4$default = PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, 0.0f, f, 1, null);
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer2, 0);
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierM1220paddingVpY3zN4$default);
                ComposeUiNode.Companion companion = ComposeUiNode.INSTANCE;
                Function0<ComposeUiNode> constructor = companion.getConstructor();
                int i9 = 16;
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
                f2.a(companion, composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, composerM6062constructorimpl, currentCompositionLocalMap);
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion, composerM6062constructorimpl, Integer.valueOf(iHashCode), composerM6062constructorimpl));
                ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
                composer2.startReplaceGroup(-1919388525);
                int i10 = 0;
                for (Object obj : set) {
                    int i11 = i10 + 1;
                    if (i10 < 0) {
                        CollectionsKt.throwIndexOverflow();
                    }
                    SettingsMenuItemType settingsMenuItemType = (SettingsMenuItemType) obj;
                    Modifier modifierM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(i10 != set.size() - r11 ? PaddingKt.m1222paddingqDBjuR0$default(Modifier.INSTANCE, 0.0f, 0.0f, 0.0f, Dp.m9687constructorimpl(24), 7, null) : Modifier.INSTANCE, 0.0f, 0.0f, Dp.m9687constructorimpl(8), 0.0f, 11, null);
                    Arrangement arrangement = Arrangement.INSTANCE;
                    Arrangement.Horizontal start = arrangement.getStart();
                    Alignment.Companion companion2 = Alignment.INSTANCE;
                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, companion2.getTop(), composer2, i8);
                    int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, i8));
                    CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, modifierM1222paddingqDBjuR0$default);
                    ComposeUiNode.Companion companion3 = ComposeUiNode.INSTANCE;
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
                    f2.a(companion3, composerM6062constructorimpl2, measurePolicyRowMeasurePolicy, composerM6062constructorimpl2, currentCompositionLocalMap2);
                    Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion3, composerM6062constructorimpl2, Integer.valueOf(iHashCode2), composerM6062constructorimpl2));
                    ?? r0 = RowScopeInstance.INSTANCE;
                    Modifier.Companion companion4 = Modifier.INSTANCE;
                    Modifier modifierWeight = r0.weight(companion4, 1.0f, r11);
                    MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getStart(), composer2, i8);
                    int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, i8));
                    CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer2, modifierWeight);
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
                    ColumnScopeInstance columnScopeInstance2 = ColumnScopeInstance.INSTANCE;
                    float dimension = resources.getDimension(R.dimen.pspdf__settings_mode_section_title_margin_bottom);
                    density.getClass();
                    float fMo750toDpu2uoSUM = density.mo750toDpu2uoSUM(dimension);
                    settingsMenuItemType.getClass();
                    settingsMenuItemType.getClass();
                    int[] iArr = c10.b;
                    int i12 = iArr[settingsMenuItemType.ordinal()];
                    if (i12 == r11) {
                        i2 = R.string.pspdf__settings_menu_page_transition;
                    } else if (i12 != 2) {
                        i2 = i12 != 3 ? i8 : R.string.pspdf__settings_menu_scroll_direction;
                    } else {
                        i2 = R.string.pspdf__settings_menu_page_layout;
                    }
                    String strA = no.a(context, i2, null);
                    strA.getClass();
                    int i13 = i8;
                    int i14 = i9;
                    ?? r6 = r11;
                    TextKt.m4494TextNvy7gAk(strA, PaddingKt.m1222paddingqDBjuR0$default(companion4, f, 0.0f, f, fMo750toDpu2uoSUM, 2, null), settingsColorScheme.m13959getTitleTextColor0d7_KjU(), null, TextUnitKt.getSp(i9), null, null, fontFamily, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 24576, 0, 261992);
                    z00Var.getClass();
                    int i15 = iArr[settingsMenuItemType.ordinal()];
                    if (i15 != r6) {
                        i3 = 2;
                        if (i15 == 2) {
                            int i16 = c10.a[z00Var.a.getLayoutMode().ordinal()];
                            if (i16 == r6) {
                                i4 = R.string.pspdf__settings_menu_single;
                            } else if (i16 != 2) {
                                i4 = R.string.pspdf__settings_menu_auto;
                            } else {
                                i4 = R.string.pspdf__settings_menu_double;
                            }
                        } else if (i15 != 3) {
                            i4 = i13;
                        } else if (z00Var.a.getScrollDirection() == PageScrollDirection.HORIZONTAL) {
                            i4 = R.string.pspdf__settings_menu_horizontal;
                        } else {
                            i4 = R.string.pspdf__settings_menu_vertical;
                        }
                    } else {
                        i3 = 2;
                        if (z00Var.a.getScrollMode() == PageScrollMode.PER_PAGE) {
                            i4 = R.string.pspdf__settings_menu_jump;
                        } else {
                            i4 = R.string.pspdf__settings_menu_continuous;
                        }
                    }
                    String strA2 = no.a(context, i4, null);
                    strA2.getClass();
                    int i17 = i3;
                    TextKt.m4494TextNvy7gAk(strA2, PaddingKt.m1220paddingVpY3zN4$default(companion4, f, 0.0f, i3, null), settingsColorScheme.m13957getLabelTextColor0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 262136);
                    composer2 = composer;
                    composer2.endNode();
                    int i18 = c.a[settingsMenuItemType.ordinal()];
                    if (i18 == r6) {
                        composer2.startReplaceGroup(-988437560);
                        Iterator<PageScrollMode> it = a.a.iterator();
                        while (it.hasNext()) {
                            final PageScrollMode next = it.next();
                            next.getClass();
                            if (next == PageScrollMode.PER_PAGE) {
                                i5 = R.drawable.pspdf__ic_settings_jump;
                            } else if (z00Var.a.getScrollDirection() == PageScrollDirection.HORIZONTAL) {
                                i5 = R.drawable.pspdf__ic_settings_continuous_horizontal;
                            } else {
                                i5 = R.drawable.pspdf__ic_settings_continuous_vertical;
                            }
                            ?? r12 = z00Var.a.getScrollMode() == next ? r6 == true ? 1 : 0 : i13;
                            boolean zChanged = composer2.changed(function1) | composer2.changedInstance(z00Var) | composer2.changed(next.ordinal());
                            Object objRememberedValue = composer2.rememberedValue();
                            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function0() { // from class: com.pspdfkit.internal.d10$$ExternalSyntheticLambda1
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return d10.a(function1, z00Var, next);
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue);
                            }
                            b10.a(i5, (boolean) r12, a10Var, false, (Function0<Unit>) objRememberedValue, composer2, 0, 8);
                        }
                        composer2.endReplaceGroup();
                        Unit unit = Unit.INSTANCE;
                    } else if (i18 == i17) {
                        composer2.startReplaceGroup(-987410902);
                        Iterator<PageLayoutMode> it2 = a.b.iterator();
                        while (it2.hasNext()) {
                            final PageLayoutMode next2 = it2.next();
                            ?? r13 = (z00Var.a.getScrollMode() == PageScrollMode.PER_PAGE || next2 == PageLayoutMode.AUTO) ? r6 == true ? 1 : 0 : i13;
                            next2.getClass();
                            int i19 = c10.a[next2.ordinal()];
                            if (i19 == r6) {
                                i6 = R.drawable.pspdf__ic_settings_single_layout;
                            } else if (i19 != i17) {
                                i6 = R.drawable.pspdf__ic_settings_automatic_layout;
                            } else {
                                i6 = R.drawable.pspdf__ic_settings_double_layout;
                            }
                            ?? r14 = z00Var.a.getLayoutMode() == next2 ? r6 == true ? 1 : 0 : i13;
                            boolean zChanged2 = composer2.changed(next2.ordinal()) | composer2.changed(function1) | composer2.changedInstance(z00Var);
                            Object objRememberedValue2 = composer2.rememberedValue();
                            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = new Function0() { // from class: com.pspdfkit.internal.d10$$ExternalSyntheticLambda17
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return d10.a(function1, z00Var, next2);
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue2);
                            }
                            b10.a(i6, (boolean) r14, a10Var, (boolean) r13, (Function0<Unit>) objRememberedValue2, composer2, 0, 0);
                            i17 = 2;
                        }
                        composer2.endReplaceGroup();
                        Unit unit2 = Unit.INSTANCE;
                    } else if (i18 != 3) {
                        composer2.startReplaceGroup(-985783030);
                        composer2.endReplaceGroup();
                        Unit unit3 = Unit.INSTANCE;
                    } else {
                        composer2.startReplaceGroup(-986479321);
                        Iterator<PageScrollDirection> it3 = a.c.iterator();
                        while (it3.hasNext()) {
                            final PageScrollDirection next3 = it3.next();
                            next3.getClass();
                            if (c10.c[next3.ordinal()] == r6) {
                                i7 = R.drawable.pspdf__ic_settings_horizontal;
                            } else {
                                i7 = R.drawable.pspdf__ic_settings_vertical;
                            }
                            ?? r15 = z00Var.a.getScrollDirection() == next3 ? r6 == true ? 1 : 0 : i13;
                            boolean zChanged3 = composer2.changed(function1) | composer2.changedInstance(z00Var) | composer2.changed(next3.ordinal());
                            Object objRememberedValue3 = composer2.rememberedValue();
                            if (zChanged3 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue3 = new Function0() { // from class: com.pspdfkit.internal.d10$$ExternalSyntheticLambda16
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return d10.a(function1, z00Var, next3);
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue3);
                            }
                            b10.a(i7, (boolean) r15, a10Var, false, (Function0<Unit>) objRememberedValue3, composer2, 0, 8);
                        }
                        composer2.endReplaceGroup();
                        Unit unit4 = Unit.INSTANCE;
                    }
                    composer2.endNode();
                    i8 = i13;
                    r11 = r6 == true ? 1 : 0;
                    i10 = i11;
                    i9 = i14;
                }
                composer2.endReplaceGroup();
                composer2.endNode();
                b10.a(composer2, i8);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(906166537);
                composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX WARN: Type inference failed for: r5v12 */
    /* JADX WARN: Type inference failed for: r5v13, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r5v17 */
    public static final Unit a(Set set, float f, final z00 z00Var, final Function1 function1, Resources resources, Density density, Context context, SettingsColorScheme settingsColorScheme, FontFamily fontFamily, LazyItemScope lazyItemScope, Composer composer, int i) {
        boolean z;
        int i2;
        final int i3;
        int i4;
        Composer composer2 = composer;
        lazyItemScope.getClass();
        if (composer2.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1423126202, i, -1, "io.nutrient.internal.ui.settings.SettingsView.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SettingsView.kt:223)");
            }
            if (!set.isEmpty()) {
                composer2.startReplaceGroup(730758982);
                Modifier.Companion companion = Modifier.INSTANCE;
                Modifier modifierM1220paddingVpY3zN4$default = PaddingKt.m1220paddingVpY3zN4$default(companion, 0.0f, f, 1, null);
                Arrangement arrangement = Arrangement.INSTANCE;
                Arrangement.Vertical top = arrangement.getTop();
                Alignment.Companion companion2 = Alignment.INSTANCE;
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, companion2.getStart(), composer2, 0);
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                CompositionLocalMap currentCompositionLocalMap = composer2.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer2, modifierM1220paddingVpY3zN4$default);
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
                if (set.contains(SettingsMenuItemType.THEME)) {
                    composer2.startReplaceGroup(457692762);
                    float f2 = 8;
                    Modifier modifierM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(companion, 0.0f, 0.0f, Dp.m9687constructorimpl(f2), 0.0f, 11, null);
                    MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(arrangement.getStart(), companion2.getCenterVertically(), composer2, 48);
                    int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                    CompositionLocalMap currentCompositionLocalMap2 = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer2, modifierM1222paddingqDBjuR0$default);
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
                    f2.a(companion3, composerM6062constructorimpl2, measurePolicyRowMeasurePolicy, composerM6062constructorimpl2, currentCompositionLocalMap2);
                    Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion3, composerM6062constructorimpl2, Integer.valueOf(iHashCode2), composerM6062constructorimpl2));
                    Modifier modifierWeight = RowScopeInstance.INSTANCE.weight(companion, 1.0f, true);
                    MeasurePolicy measurePolicyColumnMeasurePolicy2 = ColumnKt.columnMeasurePolicy(arrangement.getTop(), companion2.getStart(), composer2, 0);
                    int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, 0));
                    CompositionLocalMap currentCompositionLocalMap3 = composer2.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer2, modifierWeight);
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
                    if (z00Var.a.getThemeMode() == ThemeMode.DEFAULT) {
                        i2 = R.string.pspdf__settings_menu_default;
                    } else {
                        i2 = R.string.pspdf__settings_menu_night;
                    }
                    int i5 = i2;
                    float dimension = resources.getDimension(R.dimen.pspdf__settings_mode_section_title_margin_bottom);
                    density.getClass();
                    float fMo750toDpu2uoSUM = density.mo750toDpu2uoSUM(dimension);
                    String strA = no.a(context, R.string.pspdf__settings_menu_theme, null);
                    strA.getClass();
                    long sp = TextUnitKt.getSp(16);
                    long jM13959getTitleTextColor0d7_KjU = settingsColorScheme.m13959getTitleTextColor0d7_KjU();
                    Modifier modifierM1222paddingqDBjuR0$default2 = PaddingKt.m1222paddingqDBjuR0$default(companion, f, 0.0f, f, fMo750toDpu2uoSUM, 2, null);
                    ?? r5 = 0;
                    z = true;
                    TextKt.m4494TextNvy7gAk(strA, modifierM1222paddingqDBjuR0$default2, jM13959getTitleTextColor0d7_KjU, null, sp, null, null, fontFamily, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 24576, 0, 261992);
                    String strA2 = no.a(context, i5, null);
                    strA2.getClass();
                    TextKt.m4494TextNvy7gAk(strA2, PaddingKt.m1220paddingVpY3zN4$default(companion, f, 0.0f, 2, null), settingsColorScheme.m13957getLabelTextColor0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 262136);
                    composer2 = composer;
                    composer2.endNode();
                    composer2.startReplaceGroup(-418534035);
                    for (final ThemeMode themeMode : a.d) {
                        if (ThemeMode.DEFAULT == themeMode) {
                            i3 = R.drawable.pspdf__ic_settings_default_theme2;
                        } else {
                            i3 = R.drawable.pspdf__ic_settings_night_theme2;
                        }
                        if (z00Var.a.getThemeMode() == themeMode) {
                            i4 = R.drawable.pspdf__ic_settings_selected_circular;
                        } else {
                            i4 = R.drawable.pspdf__ic_settings_not_selected_circular;
                        }
                        Modifier.Companion companion4 = Modifier.INSTANCE;
                        Modifier modifierM1266size3ABfNKs = SizeKt.m1266size3ABfNKs(companion4, Dp.m9687constructorimpl(48));
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getCenter(), r5);
                        int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer2, r5));
                        CompositionLocalMap currentCompositionLocalMap4 = composer2.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composer2, modifierM1266size3ABfNKs);
                        ComposeUiNode.Companion companion5 = ComposeUiNode.INSTANCE;
                        Function0<ComposeUiNode> constructor4 = companion5.getConstructor();
                        if (!(composer2.getApplier() instanceof Applier)) {
                            ComposablesKt.invalidApplier();
                        }
                        composer2.startReusableNode();
                        if (composer2.getInserting()) {
                            composer2.createNode(constructor4);
                        } else {
                            composer2.useNode();
                        }
                        Composer composerM6062constructorimpl4 = Updater.m6062constructorimpl(composer2);
                        f2.a(companion5, composerM6062constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy, composerM6062constructorimpl4, currentCompositionLocalMap4);
                        Updater.m6070setimpl(composerM6062constructorimpl4, modifierMaterializeModifier4, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion5, composerM6062constructorimpl4, Integer.valueOf(iHashCode4), composerM6062constructorimpl4));
                        BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                        boolean zChanged = composer2.changed(function1) | composer2.changedInstance(z00Var) | composer2.changed(themeMode.ordinal());
                        Object objRememberedValue = composer2.rememberedValue();
                        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function0() { // from class: com.pspdfkit.internal.d10$$ExternalSyntheticLambda13
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return d10.a(function1, z00Var, themeMode);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue);
                        }
                        z = true;
                        IconButtonKt.IconButton((Function0<Unit>) objRememberedValue, (Modifier) null, false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(-735091677, true, new Function2() { // from class: com.pspdfkit.internal.d10$$ExternalSyntheticLambda14
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return d10.a(i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer2, 54), composer, 1572864, 62);
                        composer2 = composer;
                        b10.a((Modifier) null, i4, composer2, 0, 1);
                        composer2.endNode();
                        SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(companion4, Dp.m9687constructorimpl(f2)), composer2, 6);
                        r5 = 0;
                    }
                    composer2.endReplaceGroup();
                    composer2.endNode();
                    composer2.endReplaceGroup();
                } else {
                    z = true;
                    composer2.startReplaceGroup(461872151);
                    composer2.endReplaceGroup();
                }
                if (set.size() == 2) {
                    composer2.startReplaceGroup(461929718);
                    SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(24)), composer2, 6);
                    composer2.endReplaceGroup();
                } else {
                    composer2.startReplaceGroup(462022935);
                    composer2.endReplaceGroup();
                }
                if (set.contains(SettingsMenuItemType.SCREEN_AWAKE)) {
                    composer2.startReplaceGroup(462132365);
                    boolean z2 = z00Var.a.getScreenTimeoutMillis() == Long.MAX_VALUE ? z : false;
                    int i6 = R.string.pspdf__settings_menu_keep_screen_on;
                    boolean zChanged2 = composer2.changed(function1) | composer2.changedInstance(z00Var);
                    Object objRememberedValue2 = composer2.rememberedValue();
                    if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function1() { // from class: com.pspdfkit.internal.d10$$ExternalSyntheticLambda15
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return d10.a(function1, z00Var, ((Boolean) obj).booleanValue());
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue2);
                    }
                    b10.a(z2, i6, f, false, (Function1<? super Boolean, Unit>) objRememberedValue2, composer2, 0, 8);
                    composer2.endReplaceGroup();
                } else {
                    composer2.startReplaceGroup(462787767);
                    composer2.endReplaceGroup();
                }
                composer2.endNode();
                b10.a(composer2, 0);
                composer2.endReplaceGroup();
            } else {
                composer2.startReplaceGroup(736050248);
                composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final Unit a(int i, Composer composer, int i2) {
        if (composer.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-735091677, i2, -1, "io.nutrient.internal.ui.settings.SettingsView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SettingsView.kt:291)");
            }
            b10.a((Modifier) null, i, composer, 0, 1);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    public static final Unit a(final float f, final z00 z00Var, final Function1 function1, final CoroutineScope coroutineScope, final LazyListState lazyListState, LazyItemScope lazyItemScope, Composer composer, int i) {
        lazyItemScope.getClass();
        if (composer.shouldExecute((i & 17) != 16, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-924110661, i, -1, "io.nutrient.internal.ui.settings.SettingsView.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SettingsView.kt:322)");
            }
            if (NativeLicense.license().supportsFeatures(EnumSet.of(NativeLicenseFeatures.MEASUREMENT_TOOLS))) {
                composer.startReplaceGroup(559907311);
                Modifier.Companion companion = Modifier.INSTANCE;
                Modifier modifierM1220paddingVpY3zN4$default = PaddingKt.m1220paddingVpY3zN4$default(companion, 0.0f, f, 1, null);
                MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
                CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1220paddingVpY3zN4$default);
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
                boolean snapToPoint = z00Var.a.getSnapToPoint();
                int i2 = R.string.pspdf__snap_to_point;
                boolean zChanged = composer.changed(function1) | composer.changedInstance(z00Var);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.pspdfkit.internal.d10$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return d10.b(function1, z00Var, ((Boolean) obj).booleanValue());
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                b10.a(snapToPoint, i2, f, false, (Function1<? super Boolean, Unit>) objRememberedValue, composer, 0, 8);
                float f2 = 24;
                SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(companion, Dp.m9687constructorimpl(f2)), composer, 6);
                boolean snapToSelf = z00Var.a.getSnapToSelf();
                int i3 = R.string.pspdf__snap_to_self;
                boolean zChanged2 = composer.changed(function1) | composer.changedInstance(z00Var) | composer.changedInstance(coroutineScope) | composer.changed(lazyListState);
                Object objRememberedValue2 = composer.rememberedValue();
                if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: com.pspdfkit.internal.d10$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return d10.a(function1, z00Var, coroutineScope, lazyListState, ((Boolean) obj).booleanValue());
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                b10.a(snapToSelf, i3, f, false, (Function1<? super Boolean, Unit>) objRememberedValue2, composer, 0, 8);
                AnimatedVisibilityKt.AnimatedVisibility(columnScopeInstance, z00Var.a.getSnapToSelf(), (Modifier) null, (EnterTransition) null, (ExitTransition) null, (String) null, ComposableLambdaKt.rememberComposableLambda(1491331812, true, new Function3() { // from class: com.pspdfkit.internal.d10$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return d10.a(z00Var, f, function1, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composer, 54), composer, 1572870, 30);
                SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(companion, Dp.m9687constructorimpl(f2)), composer, 6);
                composer.endNode();
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(562052263);
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

    public static final Unit a(final z00 z00Var, float f, final Function1 function1, AnimatedVisibilityScope animatedVisibilityScope, Composer composer, int i) {
        animatedVisibilityScope.getClass();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1491331812, i, -1, "io.nutrient.internal.ui.settings.SettingsView.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (SettingsView.kt:347)");
        }
        Modifier.Companion companion = Modifier.INSTANCE;
        MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
        int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, companion);
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
        SpacerKt.Spacer(SizeKt.m1252height3ABfNKs(companion, Dp.m9687constructorimpl(24)), composer, 6);
        boolean showSmartGuides = z00Var.a.getShowSmartGuides();
        int i2 = R.string.pspdf__show_smart_guides;
        boolean zChanged = composer.changed(function1) | composer.changedInstance(z00Var);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function1() { // from class: com.pspdfkit.internal.d10$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return d10.c(function1, z00Var, ((Boolean) obj).booleanValue());
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        b10.a(showSmartGuides, i2, f, false, (Function1<? super Boolean, Unit>) objRememberedValue, composer, 0, 8);
        composer.endNode();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }
}

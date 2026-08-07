package com.pspdfkit.internal;

import android.content.Context;
import android.graphics.Typeface;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.material3.DividerKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shadow;
import androidx.compose.ui.graphics.drawscope.DrawStyle;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.res.PrimitiveResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.text.PlatformTextStyle;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.font.AndroidTypeface_androidKt;
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
import androidx.compose.ui.unit.TextUnitKt;
import androidx.core.content.ContextCompat;
import androidx.core.graphics.ColorUtils;
import com.pspdfkit.R;
import com.pspdfkit.ui.fonts.Font;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes3.dex */
public final class eh {

    public static final class a implements Function0<Unit> {
        public final /* synthetic */ Font a;
        public final /* synthetic */ Function1<Font, Unit> b;
        public final /* synthetic */ MutableState<Font> c;

        /* JADX WARN: Multi-variable type inference failed */
        public a(Font font, Function1<? super Font, Unit> function1, MutableState<Font> mutableState) {
            this.a = font;
            this.b = function1;
            this.c = mutableState;
        }

        @Override // kotlin.jvm.functions.Function0
        public final Unit invoke() {
            this.c.setValue(this.a);
            this.b.invoke(this.a);
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
        public final /* synthetic */ MutableState b;
        public final /* synthetic */ int c;
        public final /* synthetic */ int d;
        public final /* synthetic */ Function1 e;
        public final /* synthetic */ MutableState f;

        public c(List list, MutableState mutableState, int i, int i2, Function1 function1, MutableState mutableState2) {
            this.a = list;
            this.b = mutableState;
            this.c = i;
            this.d = i2;
            this.e = function1;
            this.f = mutableState2;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // kotlin.jvm.functions.Function4
        public final Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
            int i;
            LazyItemScope lazyItemScope2 = lazyItemScope;
            int iIntValue = num.intValue();
            Composer composer2 = composer;
            int iIntValue2 = num2.intValue();
            if ((iIntValue2 & 6) == 0) {
                i = (composer2.changed(lazyItemScope2) ? 4 : 2) | iIntValue2;
            } else {
                i = iIntValue2;
            }
            if ((iIntValue2 & 48) == 0) {
                i |= composer2.changed(iIntValue) ? 32 : 16;
            }
            if (composer2.shouldExecute((i & Token.DOTQUERY) != 146, i & 1)) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(802480018, i, -1, "androidx.compose.foundation.lazy.items.<anonymous> (LazyDsl.kt:178)");
                }
                Font font = (Font) this.a.get(iIntValue);
                composer2.startReplaceGroup(696215483);
                boolean zAreEqual = Intrinsics.areEqual((Font) this.f.getValue(), font);
                String str = (String) this.b.getValue();
                Typeface defaultTypeface = font.getDefaultTypeface();
                TextStyle textStyle = new TextStyle(zAreEqual ? ColorKt.Color(this.c) : ColorKt.Color(ColorUtils.blendARGB(this.d, this.c, 0.3f)), 0L, (FontWeight) null, (FontStyle) null, (FontSynthesis) null, defaultTypeface != null ? AndroidTypeface_androidKt.FontFamily(defaultTypeface) : null, (String) null, 0L, (BaselineShift) null, (TextGeometricTransform) null, (LocaleList) null, 0L, (TextDecoration) null, (Shadow) null, (DrawStyle) null, 0, 0, 0L, (TextIndent) null, (PlatformTextStyle) null, (LineHeightStyle) null, 0, 0, (TextMotion) null, 16777182, (DefaultConstructorMarker) null);
                long sp = TextUnitKt.getSp(30);
                long sp2 = TextUnitKt.getSp(12);
                boolean zChangedInstance = composer2.changedInstance(font) | composer2.changed(this.e);
                Object objRememberedValue = composer2.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new a(font, this.e, this.f);
                    composer2.updateRememberedValue(objRememberedValue);
                }
                dh.a(str, zAreEqual, (Function0) objRememberedValue, textStyle, sp, sp2, composer2, 221184);
                DividerKt.m3284HorizontalDivider9IZ8Weo(null, 0.0f, 0L, composer2, 0, 7);
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

    public static final Unit a(List list, Function1 function1, Modifier modifier, int i, String str, g20 g20Var, int i2, int i3, Composer composer, int i4) {
        a(list, function1, modifier, i, str, g20Var, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:101:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x0060  */
    /* JADX WARN: Code duplicated, block: B:33:0x0068  */
    /* JADX WARN: Code duplicated, block: B:34:0x006b  */
    /* JADX WARN: Code duplicated, block: B:36:0x006f  */
    /* JADX WARN: Code duplicated, block: B:39:0x0075  */
    /* JADX WARN: Code duplicated, block: B:41:0x007b  */
    /* JADX WARN: Code duplicated, block: B:42:0x007e  */
    /* JADX WARN: Code duplicated, block: B:46:0x0086  */
    /* JADX WARN: Code duplicated, block: B:48:0x008c  */
    /* JADX WARN: Code duplicated, block: B:49:0x008f  */
    /* JADX WARN: Code duplicated, block: B:53:0x009e  */
    /* JADX WARN: Code duplicated, block: B:54:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:57:0x00aa A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:58:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:59:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:65:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:68:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:69:0x0100  */
    /* JADX WARN: Code duplicated, block: B:74:0x0112 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:75:0x0114  */
    /* JADX WARN: Code duplicated, block: B:81:0x0164  */
    /* JADX WARN: Code duplicated, block: B:82:0x0167  */
    /* JADX WARN: Code duplicated, block: B:86:0x0175  */
    /* JADX WARN: Code duplicated, block: B:91:0x0185  */
    /* JADX WARN: Code duplicated, block: B:94:0x01b4  */
    /* JADX WARN: Code duplicated, block: B:96:0x01ba  */
    /* JADX WARN: Code duplicated, block: B:99:0x01c6  */
    public static final void a(final List<? extends Font> list, final Function1<? super Font, Unit> function1, Modifier modifier, final int i, final String str, final g20 g20Var, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        int i5;
        boolean z;
        Composer composer2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        final int color;
        Object objRememberedValue;
        Composer.Companion companion;
        final MutableState mutableState;
        String strStringResource;
        boolean z2;
        boolean zChanged;
        Object objRememberedValue2;
        final MutableState mutableState2;
        boolean z3;
        boolean zChanged2;
        Object objRememberedValue3;
        int i6;
        int i7;
        int i8;
        list.getClass();
        function1.getClass();
        g20Var.getClass();
        Composer composerStartRestartGroup = composer.startRestartGroup(-1771320029);
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changedInstance(list) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        int i9 = i3 & 4;
        if (i9 == 0) {
            if ((i2 & 384) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i2 & 3072) == 0) {
                i5 = i;
                if (composerStartRestartGroup.changed(i5)) {
                    i8 = 2048;
                } else {
                    i8 = 1024;
                }
                i4 |= i8;
            } else {
                i5 = i;
            }
            if ((i2 & 24576) == 0) {
                if (composerStartRestartGroup.changed(str)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i4 |= i7;
            }
            if ((196608 & i2) == 0) {
                if (composerStartRestartGroup.changed(g20Var)) {
                    i6 = 131072;
                } else {
                    i6 = 65536;
                }
                i4 |= i6;
            }
            if ((74899 & i4) != 74898) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                if (i9 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1771320029, i4, -1, "com.pspdfkit.internal.ui.dialog.signatures.composables.FontList (FontList.kt:46)");
                }
                LazyListState lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
                color = ContextCompat.getColor((Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext()), R.color.pspdf__surfaceLight);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                companion = Composer.INSTANCE;
                if (objRememberedValue == companion.getEmpty()) {
                    objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(CollectionsKt.first((List) list), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                mutableState = (MutableState) objRememberedValue;
                strStringResource = StringResources_androidKt.stringResource(R.string.pspdf__signature, composerStartRestartGroup, 0);
                if ((i4 & 57344) == 16384) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                zChanged = z2 | composerStartRestartGroup.changed(strStringResource);
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (zChanged || objRememberedValue2 == companion.getEmpty()) {
                    if (str != null && StringsKt.trim((CharSequence) str).toString().length() > 0) {
                        strStringResource = str;
                    }
                    objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(strStringResource, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableState2 = (MutableState) objRememberedValue2;
                Modifier modifier5 = modifier4;
                Modifier modifierM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(BackgroundKt.m589backgroundbw27NRU$default(modifier4, ColorKt.Color(g20Var.l), null, 2, null), 0.0f, 0.0f, 0.0f, PrimitiveResources_androidKt.dimensionResource(R.dimen.pspdf__signatures_font_list_bottom_padding, composerStartRestartGroup, 0), 7, null);
                boolean zChangedInstance = composerStartRestartGroup.changedInstance(list) | composerStartRestartGroup.changed(mutableState2);
                if ((i4 & 7168) == 2048) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                zChanged2 = z3 | zChangedInstance | composerStartRestartGroup.changed(color) | ((i4 & 112) == 32);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChanged2 || objRememberedValue3 == companion.getEmpty()) {
                    final int i10 = i5;
                    Function1 function2 = new Function1() { // from class: com.pspdfkit.internal.eh$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return eh.a(list, mutableState2, i10, color, function1, mutableState, (LazyListScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(function2);
                    objRememberedValue3 = function2;
                }
                composer2 = composerStartRestartGroup;
                LazyDslKt.LazyColumn(modifierM1222paddingqDBjuR0$default, lazyListStateRememberLazyListState, null, false, null, null, null, false, null, (Function1) objRememberedValue3, composer2, 0, 508);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier5;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.eh$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return eh.a(list, function1, modifier3, i, str, g20Var, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 384;
        modifier2 = modifier;
        if ((i2 & 3072) == 0) {
            i5 = i;
            if (composerStartRestartGroup.changed(i5)) {
                i8 = 2048;
            } else {
                i8 = 1024;
            }
            i4 |= i8;
        } else {
            i5 = i;
        }
        if ((i2 & 24576) == 0) {
            if (composerStartRestartGroup.changed(str)) {
                i7 = 16384;
            } else {
                i7 = 8192;
            }
            i4 |= i7;
        }
        if ((196608 & i2) == 0) {
            if (composerStartRestartGroup.changed(g20Var)) {
                i6 = 131072;
            } else {
                i6 = 65536;
            }
            i4 |= i6;
        }
        if ((74899 & i4) != 74898) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
            if (i9 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1771320029, i4, -1, "com.pspdfkit.internal.ui.dialog.signatures.composables.FontList (FontList.kt:46)");
            }
            LazyListState lazyListStateRememberLazyListState2 = LazyListStateKt.rememberLazyListState(0, 0, composerStartRestartGroup, 0, 3);
            color = ContextCompat.getColor((Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext()), R.color.pspdf__surfaceLight);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            companion = Composer.INSTANCE;
            if (objRememberedValue == companion.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(CollectionsKt.first((List) list), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            mutableState = (MutableState) objRememberedValue;
            strStringResource = StringResources_androidKt.stringResource(R.string.pspdf__signature, composerStartRestartGroup, 0);
            if ((i4 & 57344) == 16384) {
                z2 = true;
            } else {
                z2 = false;
            }
            zChanged = z2 | composerStartRestartGroup.changed(strStringResource);
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged) {
                if (str != null) {
                    strStringResource = str;
                }
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(strStringResource, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                if (str != null) {
                    strStringResource = str;
                }
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(strStringResource, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            mutableState2 = (MutableState) objRememberedValue2;
            Modifier modifier6 = modifier4;
            Modifier modifierM1222paddingqDBjuR0$default2 = PaddingKt.m1222paddingqDBjuR0$default(BackgroundKt.m589backgroundbw27NRU$default(modifier4, ColorKt.Color(g20Var.l), null, 2, null), 0.0f, 0.0f, 0.0f, PrimitiveResources_androidKt.dimensionResource(R.dimen.pspdf__signatures_font_list_bottom_padding, composerStartRestartGroup, 0), 7, null);
            boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(list) | composerStartRestartGroup.changed(mutableState2);
            if ((i4 & 7168) == 2048) {
                z3 = true;
            } else {
                z3 = false;
            }
            zChanged2 = z3 | zChangedInstance2 | composerStartRestartGroup.changed(color) | ((i4 & 112) == 32);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChanged2) {
                final int i11 = i5;
                Function1 function3 = new Function1() { // from class: com.pspdfkit.internal.eh$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return eh.a(list, mutableState2, i11, color, function1, mutableState, (LazyListScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(function3);
                objRememberedValue3 = function3;
            } else {
                final int i12 = i5;
                Function1 function4 = new Function1() { // from class: com.pspdfkit.internal.eh$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return eh.a(list, mutableState2, i12, color, function1, mutableState, (LazyListScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(function4);
                objRememberedValue3 = function4;
            }
            composer2 = composerStartRestartGroup;
            LazyDslKt.LazyColumn(modifierM1222paddingqDBjuR0$default2, lazyListStateRememberLazyListState2, null, false, null, null, null, false, null, (Function1) objRememberedValue3, composer2, 0, 508);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier6;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.eh$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return eh.a(list, function1, modifier3, i, str, g20Var, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final Unit a(List list, MutableState mutableState, int i, int i2, Function1 function1, MutableState mutableState2, LazyListScope lazyListScope) {
        lazyListScope.getClass();
        lazyListScope.items(list.size(), null, new b(list), ComposableLambdaKt.composableLambdaInstance(802480018, true, new c(list, mutableState, i, i2, function1, mutableState2)));
        return Unit.INSTANCE;
    }
}

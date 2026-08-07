package com.pspdfkit.internal;

import android.R;
import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.view.ViewGroup;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.ImageView;
import androidx.compose.animation.SingleValueAnimationKt;
import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderKt;
import androidx.compose.foundation.ClickableKt;
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
import androidx.compose.material3.DividerKt;
import androidx.compose.material3.IconButtonColors;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.material3.RadioButtonDefaults;
import androidx.compose.material3.RadioButtonKt;
import androidx.compose.material3.SwitchColors;
import androidx.compose.material3.SwitchKt;
import androidx.compose.material3.TextKt;
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
import androidx.compose.ui.draw.ClipKt;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.ColorKt;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.AndroidCompositionLocals_androidKt;
import androidx.compose.ui.platform.CompositionLocalsKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.text.font.DeviceFontFamilyName;
import androidx.compose.ui.text.font.DeviceFontFamilyNameFontKt;
import androidx.compose.ui.text.font.FontFamily;
import androidx.compose.ui.text.font.FontFamilyKt;
import androidx.compose.ui.text.font.FontWeight;
import androidx.compose.ui.text.style.TextAlign;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.TextUnitKt;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import androidx.webkit.WebViewAssetLoader;
import androidx.webkit.WebViewClientCompat;
import com.microsoft.intune.mam.client.widget.MAMWebView;
import com.pspdfkit.compose.theme.SettingsColorScheme;
import com.pspdfkit.compose.theme.UiTheme;
import external.sdk.pendo.io.mozilla.javascript.Token;
import io.nutrient.ui.settings.SettingsOptions;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;

/* JADX INFO: loaded from: classes3.dex */
public final class b10 {

    public static final class a extends WebViewClientCompat {
        public final AtomicBoolean a;
        public final /* synthetic */ WebView b;
        public final /* synthetic */ WebViewAssetLoader c;

        public a(boolean z, WebView webView, WebViewAssetLoader webViewAssetLoader) {
            this.b = webView;
            this.c = webViewAssetLoader;
            this.a = new AtomicBoolean(z);
        }

        @Override // android.webkit.WebViewClient
        public final void onPageFinished(WebView webView, String str) {
            if (this.a.get()) {
                this.b.setVisibility(0);
            }
        }

        @Override // android.webkit.WebViewClient
        public final WebResourceResponse shouldInterceptRequest(WebView webView, WebResourceRequest webResourceRequest) {
            webView.getClass();
            webResourceRequest.getClass();
            return this.c.shouldInterceptRequest(webResourceRequest.getUrl());
        }
    }

    public static final Unit a(Modifier modifier, int i, int i2, int i3, Composer composer, int i4) {
        a(modifier, i, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    public static final Unit b(xw xwVar, z00 z00Var, Function1 function1, int i, Composer composer, int i2) {
        a(xwVar, z00Var, (Function1<? super xw, Unit>) function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final Unit c(Function1 function1, xw xwVar) {
        xwVar.getClass();
        function1.invoke(xwVar);
        return Unit.INSTANCE;
    }

    public static final Unit a(Modifier modifier, Drawable drawable, int i, int i2, Composer composer, int i3) {
        a(modifier, drawable, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final Unit b(Function1 function1, xw xwVar) {
        function1.invoke(xwVar);
        return Unit.INSTANCE;
    }

    public static final Unit a(int i, Composer composer, int i2) {
        a(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final Unit a(boolean z, int i, float f, boolean z2, Function1 function1, int i2, int i3, Composer composer, int i4) {
        a(z, i, f, z2, (Function1<? super Boolean, Unit>) function1, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    public static final Unit a(int i, boolean z, a10 a10Var, boolean z2, Function0 function0, int i2, int i3, Composer composer, int i4) {
        a(i, z, a10Var, z2, (Function0<Unit>) function0, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    public static final Unit a(xw xwVar, z00 z00Var, Function1 function1, int i, Composer composer, int i2) {
        a(xwVar, z00Var, (Function1<? super xw, Unit>) function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final Unit a(z00 z00Var, Function1 function1, int i, Composer composer, int i2) {
        a(z00Var, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final Unit a(xw xwVar, boolean z, a10 a10Var, int i, Composer composer, int i2) {
        a(xwVar, z, a10Var, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final Unit a(a10 a10Var, int i, Modifier modifier, boolean z, boolean z2, int i2, int i3, int i4, Composer composer, int i5) {
        long jColor;
        if (composer.shouldExecute((i5 & 3) != 2, i5 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1819460457, i5, -1, "io.nutrient.internal.ui.settings.SettingsIconButton.<anonymous> (SettingsUiComponents.kt:200)");
            }
            if (a10Var.h) {
                composer.startReplaceGroup(-1059163563);
                IconKt.m3575Iconww6aTOc(PainterResources_androidKt.painterResource(i, composer, 0), (String) null, modifier, 0L, composer, Painter.$stable | 432, 8);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(-1059028992);
                Painter painterPainterResource = PainterResources_androidKt.painterResource(i, composer, 0);
                if (!z) {
                    jColor = ColorKt.Color(i4);
                } else if (z2) {
                    jColor = ColorKt.Color(i2);
                } else {
                    jColor = ColorKt.Color(i3);
                }
                IconKt.m3575Iconww6aTOc(painterPainterResource, (String) null, modifier, jColor, composer, Painter.$stable | 432, 0);
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

    public static final void a(final Modifier modifier, final int i, Composer composer, final int i2, final int i3) {
        int i4;
        Composer composerStartRestartGroup = composer.startRestartGroup(548755274);
        int i5 = i3 & 1;
        if (i5 != 0) {
            i4 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(i) ? 32 : 16;
        }
        if (composerStartRestartGroup.shouldExecute((i4 & 19) != 18, i4 & 1)) {
            if (i5 != 0) {
                modifier = Modifier.INSTANCE;
            }
            Modifier modifier2 = modifier;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(548755274, i4, -1, "io.nutrient.internal.ui.settings.ImageView (SettingsUiComponents.kt:77)");
            }
            int i6 = i4 & 112;
            boolean z = i6 == 32;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.pspdfkit.internal.b10$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return b10.a(i, (Context) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Function1 function1 = (Function1) objRememberedValue;
            boolean z2 = i6 == 32;
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.pspdfkit.internal.b10$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return b10.a(i, (ImageView) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            AndroidView_androidKt.AndroidView(function1, modifier2, (Function1) objRememberedValue2, composerStartRestartGroup, (i4 << 3) & 112, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier = modifier2;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.b10$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return b10.a(modifier, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final ImageView a(int i, Context context) {
        context.getClass();
        ImageView imageView = new ImageView(context);
        imageView.setImageResource(i);
        return imageView;
    }

    public static final Unit a(int i, ImageView imageView) {
        imageView.getClass();
        imageView.setImageResource(i);
        return Unit.INSTANCE;
    }

    public static final void a(final Modifier modifier, final Drawable drawable, Composer composer, final int i, final int i2) {
        int i3;
        drawable.getClass();
        Composer composerStartRestartGroup = composer.startRestartGroup(1845632029);
        int i4 = i2 & 1;
        if (i4 != 0) {
            i3 = i | 6;
        } else if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(modifier) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(drawable) ? 32 : 16;
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 19) != 18, i3 & 1)) {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            Modifier modifier2 = modifier;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1845632029, i3, -1, "io.nutrient.internal.ui.settings.ImageView (SettingsUiComponents.kt:91)");
            }
            boolean zChangedInstance = composerStartRestartGroup.changedInstance(drawable);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.pspdfkit.internal.b10$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return b10.a(drawable, (Context) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Function1 function1 = (Function1) objRememberedValue;
            boolean zChangedInstance2 = composerStartRestartGroup.changedInstance(drawable);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.pspdfkit.internal.b10$$ExternalSyntheticLambda13
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return b10.a(drawable, (ImageView) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            AndroidView_androidKt.AndroidView(function1, modifier2, (Function1) objRememberedValue2, composerStartRestartGroup, (i3 << 3) & 112, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier = modifier2;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.b10$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return b10.a(modifier, drawable, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final ImageView a(Drawable drawable, Context context) {
        context.getClass();
        ImageView imageView = new ImageView(context);
        imageView.setImageDrawable(drawable);
        return imageView;
    }

    public static final Unit a(Drawable drawable, ImageView imageView) {
        imageView.getClass();
        imageView.setImageDrawable(drawable);
        return Unit.INSTANCE;
    }

    public static final void a(final xw xwVar, final boolean z, final a10 a10Var, Composer composer, final int i) {
        int i2;
        final String str;
        xwVar.getClass();
        a10Var.getClass();
        Composer composerStartRestartGroup = composer.startRestartGroup(-1154745704);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(xwVar.ordinal()) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(a10Var) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & Token.DOTQUERY) != 146, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1154745704, i2, -1, "io.nutrient.internal.ui.settings.SettingsPresetWebView (SettingsUiComponents.kt:111)");
            }
            if (xwVar == xw.e) {
                str = a10Var.e;
            } else {
                str = a10Var.f;
            }
            int i3 = i2 & 112;
            boolean zChanged = (i3 == 32) | composerStartRestartGroup.changed(str);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.pspdfkit.internal.b10$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return b10.a(str, z, (Context) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Function1 function1 = (Function1) objRememberedValue;
            boolean zChanged2 = composerStartRestartGroup.changed(str) | (i3 == 32);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.pspdfkit.internal.b10$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return b10.a(str, z, (WebView) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            AndroidView_androidKt.AndroidView(function1, null, (Function1) objRememberedValue2, composerStartRestartGroup, 0, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.b10$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return b10.a(xwVar, z, a10Var, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final WebView a(String str, boolean z, Context context) {
        context.getClass();
        MAMWebView mAMWebView = new MAMWebView(context);
        mAMWebView.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        WebSettings settings = mAMWebView.getSettings();
        settings.setJavaScriptEnabled(z);
        settings.setAllowFileAccessFromFileURLs(false);
        settings.setAllowUniversalAccessFromFileURLs(false);
        settings.setAllowFileAccess(false);
        settings.setAllowContentAccess(false);
        mAMWebView.loadUrl(str);
        return mAMWebView;
    }

    public static final Unit a(String str, boolean z, WebView webView) {
        webView.getClass();
        WebViewAssetLoader webViewAssetLoaderBuild = new WebViewAssetLoader.Builder().addPathHandler("/assets/", new WebViewAssetLoader.AssetsPathHandler(webView.getContext())).build();
        webViewAssetLoaderBuild.getClass();
        webView.getSettings().setJavaScriptEnabled(z);
        webView.setVisibility(4);
        webView.setWebViewClient(new a(z, webView, webViewAssetLoaderBuild));
        webView.loadUrl(str);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:37:0x006b  */
    /* JADX WARN: Code duplicated, block: B:39:0x0071  */
    /* JADX WARN: Code duplicated, block: B:40:0x0074  */
    /* JADX WARN: Code duplicated, block: B:44:0x007e  */
    /* JADX WARN: Code duplicated, block: B:45:0x0080  */
    /* JADX WARN: Code duplicated, block: B:48:0x0089 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:49:0x008b  */
    /* JADX WARN: Code duplicated, block: B:50:0x008d  */
    /* JADX WARN: Code duplicated, block: B:53:0x0095  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:57:0x00af  */
    /* JADX WARN: Code duplicated, block: B:60:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:61:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:64:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:65:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:68:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:69:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:72:0x015a  */
    /* JADX WARN: Code duplicated, block: B:73:0x015e  */
    /* JADX WARN: Code duplicated, block: B:76:0x016a  */
    /* JADX WARN: Code duplicated, block: B:78:? A[RETURN, SYNTHETIC] */
    public static final void a(final int i, final boolean z, final a10 a10Var, boolean z2, final Function0<Unit> function0, Composer composer, final int i2, final int i3) {
        int i4;
        int i5;
        boolean z3;
        int i6;
        boolean z4;
        Composer composer2;
        final boolean z5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        SettingsColorScheme settingsColorScheme;
        ColorStateList colorStateList;
        final int defaultColor;
        ColorStateList colorStateList2;
        int colorForState;
        ColorStateList colorStateList3;
        final int colorForState2;
        long jM6849getTransparent0d7_KjU;
        int i7;
        a10Var.getClass();
        function0.getClass();
        Composer composerStartRestartGroup = composer.startRestartGroup(1673451509);
        if ((i2 & 6) == 0) {
            i4 = i;
            i5 = (composerStartRestartGroup.changed(i4) ? 4 : 2) | i2;
        } else {
            i4 = i;
            i5 = i2;
        }
        if ((i2 & 48) == 0) {
            i5 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i5 |= composerStartRestartGroup.changedInstance(a10Var) ? 256 : 128;
        }
        int i8 = i3 & 8;
        if (i8 == 0) {
            if ((i2 & 3072) == 0) {
                z3 = z2;
                i5 |= composerStartRestartGroup.changed(z3) ? 2048 : 1024;
            }
            if ((i2 & 24576) == 0) {
                if (composerStartRestartGroup.changedInstance(function0)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i5 |= i7;
            }
            i6 = i5;
            if ((i6 & 9363) != 9362) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i6 & 1)) {
                if (i8 != 0) {
                    z5 = true;
                } else {
                    z5 = z3;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1673451509, i6, -1, "io.nutrient.internal.ui.settings.SettingsIconButton (SettingsUiComponents.kt:180)");
                }
                settingsColorScheme = UiTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getSettingsColorScheme();
                colorStateList = a10Var.g;
                if (colorStateList != null) {
                    defaultColor = colorStateList.getDefaultColor();
                } else {
                    defaultColor = -1;
                }
                colorStateList2 = a10Var.g;
                if (colorStateList2 != null) {
                    colorForState = colorStateList2.getColorForState(new int[]{R.attr.state_enabled, R.attr.state_activated}, -1);
                } else {
                    colorForState = defaultColor;
                }
                colorStateList3 = a10Var.g;
                if (colorStateList3 != null) {
                    colorForState2 = colorStateList3.getColorForState(new int[]{-16842910}, -1);
                } else {
                    colorForState2 = defaultColor;
                }
                Modifier.Companion companion = Modifier.INSTANCE;
                Modifier modifierM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(companion, 0.0f, 0.0f, Dp.m9687constructorimpl(8), 0.0f, 11, null);
                if (z) {
                    jM6849getTransparent0d7_KjU = settingsColorScheme.m13958getSelectedColor0d7_KjU();
                } else {
                    jM6849getTransparent0d7_KjU = Color.INSTANCE.m6849getTransparent0d7_KjU();
                }
                Modifier modifierM588backgroundbw27NRU = BackgroundKt.m588backgroundbw27NRU(modifierM1222paddingqDBjuR0$default, jM6849getTransparent0d7_KjU, RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(14)));
                final Modifier modifierM1218padding3ABfNKs = PaddingKt.m1218padding3ABfNKs(companion, Dp.m9687constructorimpl(12));
                final int i9 = colorForState;
                final int i10 = i4;
                composer2 = composerStartRestartGroup;
                IconButtonKt.IconButton(function0, SizeKt.m1266size3ABfNKs(modifierM588backgroundbw27NRU, Dp.m9687constructorimpl(48)), z5, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, ComposableLambdaKt.rememberComposableLambda(-1819460457, true, new Function2() { // from class: com.pspdfkit.internal.b10$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return b10.a(a10Var, i10, modifierM1218padding3ABfNKs, z5, z, i9, defaultColor, colorForState2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, ((i6 >> 12) & 14) | 1572864 | ((i6 >> 3) & 896), 56);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                z5 = z3;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.b10$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return b10.a(i, z, a10Var, z5, function0, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i5 |= 3072;
        z3 = z2;
        if ((i2 & 24576) == 0) {
            if (composerStartRestartGroup.changedInstance(function0)) {
                i7 = 16384;
            } else {
                i7 = 8192;
            }
            i5 |= i7;
        }
        i6 = i5;
        if ((i6 & 9363) != 9362) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z4, i6 & 1)) {
            if (i8 != 0) {
                z5 = true;
            } else {
                z5 = z3;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1673451509, i6, -1, "io.nutrient.internal.ui.settings.SettingsIconButton (SettingsUiComponents.kt:180)");
            }
            settingsColorScheme = UiTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getSettingsColorScheme();
            colorStateList = a10Var.g;
            if (colorStateList != null) {
                defaultColor = colorStateList.getDefaultColor();
            } else {
                defaultColor = -1;
            }
            colorStateList2 = a10Var.g;
            if (colorStateList2 != null) {
                colorForState = colorStateList2.getColorForState(new int[]{R.attr.state_enabled, R.attr.state_activated}, -1);
            } else {
                colorForState = defaultColor;
            }
            colorStateList3 = a10Var.g;
            if (colorStateList3 != null) {
                colorForState2 = colorStateList3.getColorForState(new int[]{-16842910}, -1);
            } else {
                colorForState2 = defaultColor;
            }
            Modifier.Companion companion2 = Modifier.INSTANCE;
            Modifier modifierM1222paddingqDBjuR0$default2 = PaddingKt.m1222paddingqDBjuR0$default(companion2, 0.0f, 0.0f, Dp.m9687constructorimpl(8), 0.0f, 11, null);
            if (z) {
                jM6849getTransparent0d7_KjU = settingsColorScheme.m13958getSelectedColor0d7_KjU();
            } else {
                jM6849getTransparent0d7_KjU = Color.INSTANCE.m6849getTransparent0d7_KjU();
            }
            Modifier modifierM588backgroundbw27NRU2 = BackgroundKt.m588backgroundbw27NRU(modifierM1222paddingqDBjuR0$default2, jM6849getTransparent0d7_KjU, RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(14)));
            final Modifier modifierM1218padding3ABfNKs2 = PaddingKt.m1218padding3ABfNKs(companion2, Dp.m9687constructorimpl(12));
            final int i11 = colorForState;
            final int i12 = i4;
            composer2 = composerStartRestartGroup;
            IconButtonKt.IconButton(function0, SizeKt.m1266size3ABfNKs(modifierM588backgroundbw27NRU2, Dp.m9687constructorimpl(48)), z5, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, ComposableLambdaKt.rememberComposableLambda(-1819460457, true, new Function2() { // from class: com.pspdfkit.internal.b10$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return b10.a(a10Var, i12, modifierM1218padding3ABfNKs2, z5, z, i11, defaultColor, colorForState2, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, ((i6 >> 12) & 14) | 1572864 | ((i6 >> 3) & 896), 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            z5 = z3;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.b10$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return b10.a(i, z, a10Var, z5, function0, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void a(final z00 z00Var, final Function1<? super xw, Unit> function1, Composer composer, final int i) {
        z00Var.getClass();
        function1.getClass();
        Composer composerStartRestartGroup = composer.startRestartGroup(1905619698);
        int i2 = (i & 6) == 0 ? (composerStartRestartGroup.changedInstance(z00Var) ? 4 : 2) | i : i;
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1905619698, i2, -1, "io.nutrient.internal.ui.settings.SettingsPresetSection (SettingsUiComponents.kt:228)");
            }
            float f = 32;
            Modifier modifierM1218padding3ABfNKs = PaddingKt.m1218padding3ABfNKs(SizeKt.fillMaxWidth$default(Modifier.INSTANCE, 0.0f, 1, null), Dp.m9687constructorimpl(f));
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getCenter(), Alignment.INSTANCE.getCenterVertically(), composerStartRestartGroup, 54);
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1218padding3ABfNKs);
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
            f2.a(companion, composerM6062constructorimpl, measurePolicyRowMeasurePolicy, composerM6062constructorimpl, currentCompositionLocalMap);
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion, composerM6062constructorimpl, Integer.valueOf(iHashCode), composerM6062constructorimpl));
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            composerStartRestartGroup.startReplaceGroup(-1804330459);
            int i3 = 0;
            for (Object obj : CollectionsKt.listOf((Object[]) new xw[]{xw.e, xw.d})) {
                int i4 = i3 + 1;
                if (i3 < 0) {
                    CollectionsKt.throwIndexOverflow();
                }
                xw xwVar = (xw) obj;
                boolean z = (i2 & 112) == 32;
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.pspdfkit.internal.b10$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj2) {
                            return b10.c(function1, (xw) obj2);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                a(xwVar, z00Var, (Function1<? super xw, Unit>) objRememberedValue, composerStartRestartGroup, (i2 << 3) & 112);
                if (i3 == 0) {
                    composerStartRestartGroup.startReplaceGroup(-653799548);
                    SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composerStartRestartGroup, 6);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(-653730356);
                    composerStartRestartGroup.endReplaceGroup();
                }
                i3 = i4;
            }
            composerStartRestartGroup.endReplaceGroup();
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.b10$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj2, Object obj3) {
                    return b10.a(z00Var, function1, i, (Composer) obj2, ((Integer) obj3).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:37:0x0068  */
    /* JADX WARN: Code duplicated, block: B:39:0x006e  */
    /* JADX WARN: Code duplicated, block: B:40:0x0071  */
    /* JADX WARN: Code duplicated, block: B:44:0x007c  */
    /* JADX WARN: Code duplicated, block: B:45:0x007e  */
    /* JADX WARN: Code duplicated, block: B:48:0x0087 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:49:0x0089  */
    /* JADX WARN: Code duplicated, block: B:50:0x008c  */
    /* JADX WARN: Code duplicated, block: B:53:0x0094  */
    /* JADX WARN: Code duplicated, block: B:56:0x0111  */
    /* JADX WARN: Code duplicated, block: B:59:0x011d  */
    /* JADX WARN: Code duplicated, block: B:60:0x0121  */
    /* JADX WARN: Code duplicated, block: B:63:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:64:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:69:0x01d6  */
    /* JADX WARN: Code duplicated, block: B:72:0x0200  */
    /* JADX WARN: Code duplicated, block: B:74:0x0205  */
    /* JADX WARN: Code duplicated, block: B:77:0x0211  */
    /* JADX WARN: Code duplicated, block: B:79:? A[RETURN, SYNTHETIC] */
    public static final void a(final boolean z, final int i, final float f, boolean z2, final Function1<? super Boolean, Unit> function1, Composer composer, final int i2, final int i3) {
        int i4;
        boolean z3;
        boolean z4;
        Composer composer2;
        final boolean z5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        boolean z6;
        Function0<ComposeUiNode> constructor;
        int i5;
        boolean z7;
        Object objRememberedValue;
        int i6;
        function1.getClass();
        Composer composerStartRestartGroup = composer.startRestartGroup(-1123262369);
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i4 |= composerStartRestartGroup.changed(f) ? 256 : 128;
        }
        int i7 = i3 & 8;
        if (i7 == 0) {
            if ((i2 & 3072) == 0) {
                z3 = z2;
                i4 |= composerStartRestartGroup.changed(z3) ? 2048 : 1024;
            }
            if ((i2 & 24576) == 0) {
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i6 = 16384;
                } else {
                    i6 = 8192;
                }
                i4 |= i6;
            }
            if ((i4 & 9363) != 9362) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                if (i7 != 0) {
                    z6 = true;
                } else {
                    z6 = z3;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1123262369, i4, -1, "io.nutrient.internal.ui.settings.SettingsFieldWithSwitch (SettingsUiComponents.kt:261)");
                }
                SettingsColorScheme settingsColorScheme = UiTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getSettingsColorScheme();
                FontFamily FontFamily = FontFamilyKt.FontFamily(DeviceFontFamilyNameFontKt.m9175Fontvxs03AY$default(DeviceFontFamilyName.m9168constructorimpl("sans-serif-medium"), FontWeight.INSTANCE.getMedium(), 0, null, 12, null));
                Modifier.Companion companion = Modifier.INSTANCE;
                Modifier modifierM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(companion, 0.0f, 0.0f, Dp.m9687constructorimpl(8), 0.0f, 11, null);
                MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), composerStartRestartGroup, 48);
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1222paddingqDBjuR0$default);
                ComposeUiNode.Companion companion2 = ComposeUiNode.INSTANCE;
                constructor = companion2.getConstructor();
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
                f2.a(companion2, composerM6062constructorimpl, measurePolicyRowMeasurePolicy, composerM6062constructorimpl, currentCompositionLocalMap);
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion2, composerM6062constructorimpl, Integer.valueOf(iHashCode), composerM6062constructorimpl));
                RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
                String strA = no.a((Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext()), i, null);
                strA.getClass();
                i5 = i4;
                TextKt.m4494TextNvy7gAk(strA, PaddingKt.m1220paddingVpY3zN4$default(rowScopeInstance.weight(companion, 1.0f, true), f, 0.0f, 2, null), settingsColorScheme.m13959getTitleTextColor0d7_KjU(), null, TextUnitKt.getSp(16), null, null, FontFamily, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 24576, 0, 261992);
                SwitchColors switchColorsForSwitch = settingsColorScheme.forSwitch(composerStartRestartGroup, 0);
                Modifier modifierM1252height3ABfNKs = SizeKt.m1252height3ABfNKs(companion, Dp.m9687constructorimpl(28));
                if ((i5 & 57344) == 16384) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z7 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.pspdfkit.internal.b10$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return b10.a(function1, ((Boolean) obj).booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                boolean z8 = z6;
                SwitchKt.Switch(z, (Function1) objRememberedValue, modifierM1252height3ABfNKs, null, z8, switchColorsForSwitch, null, composerStartRestartGroup, (i5 & 14) | 384 | (57344 & (i5 << 3)), 72);
                composer2 = composerStartRestartGroup;
                composer2.endNode();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z5 = z8;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                z5 = z3;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.b10$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return b10.a(z, i, f, z5, function1, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 3072;
        z3 = z2;
        if ((i2 & 24576) == 0) {
            if (composerStartRestartGroup.changedInstance(function1)) {
                i6 = 16384;
            } else {
                i6 = 8192;
            }
            i4 |= i6;
        }
        if ((i4 & 9363) != 9362) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
            if (i7 != 0) {
                z6 = true;
            } else {
                z6 = z3;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1123262369, i4, -1, "io.nutrient.internal.ui.settings.SettingsFieldWithSwitch (SettingsUiComponents.kt:261)");
            }
            SettingsColorScheme settingsColorScheme2 = UiTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getSettingsColorScheme();
            FontFamily FontFamily2 = FontFamilyKt.FontFamily(DeviceFontFamilyNameFontKt.m9175Fontvxs03AY$default(DeviceFontFamilyName.m9168constructorimpl("sans-serif-medium"), FontWeight.INSTANCE.getMedium(), 0, null, 12, null));
            Modifier.Companion companion3 = Modifier.INSTANCE;
            Modifier modifierM1222paddingqDBjuR0$default2 = PaddingKt.m1222paddingqDBjuR0$default(companion3, 0.0f, 0.0f, Dp.m9687constructorimpl(8), 0.0f, 11, null);
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), Alignment.INSTANCE.getCenterVertically(), composerStartRestartGroup, 48);
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM1222paddingqDBjuR0$default2);
            ComposeUiNode.Companion companion4 = ComposeUiNode.INSTANCE;
            constructor = companion4.getConstructor();
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
            f2.a(companion4, composerM6062constructorimpl2, measurePolicyRowMeasurePolicy2, composerM6062constructorimpl2, currentCompositionLocalMap2);
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion4, composerM6062constructorimpl2, Integer.valueOf(iHashCode2), composerM6062constructorimpl2));
            RowScopeInstance rowScopeInstance2 = RowScopeInstance.INSTANCE;
            String strA2 = no.a((Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext()), i, null);
            strA2.getClass();
            i5 = i4;
            TextKt.m4494TextNvy7gAk(strA2, PaddingKt.m1220paddingVpY3zN4$default(rowScopeInstance2.weight(companion3, 1.0f, true), f, 0.0f, 2, null), settingsColorScheme2.m13959getTitleTextColor0d7_KjU(), null, TextUnitKt.getSp(16), null, null, FontFamily2, 0L, null, null, 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 24576, 0, 261992);
            SwitchColors switchColorsForSwitch2 = settingsColorScheme2.forSwitch(composerStartRestartGroup, 0);
            Modifier modifierM1252height3ABfNKs2 = SizeKt.m1252height3ABfNKs(companion3, Dp.m9687constructorimpl(28));
            if ((i5 & 57344) == 16384) {
                z7 = true;
            } else {
                z7 = false;
            }
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z7) {
                objRememberedValue = new Function1() { // from class: com.pspdfkit.internal.b10$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return b10.a(function1, ((Boolean) obj).booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function1() { // from class: com.pspdfkit.internal.b10$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return b10.a(function1, ((Boolean) obj).booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            boolean z9 = z6;
            SwitchKt.Switch(z, (Function1) objRememberedValue, modifierM1252height3ABfNKs2, null, z9, switchColorsForSwitch2, null, composerStartRestartGroup, (i5 & 14) | 384 | (57344 & (i5 << 3)), 72);
            composer2 = composerStartRestartGroup;
            composer2.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z5 = z9;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            z5 = z3;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.b10$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return b10.a(z, i, f, z5, function1, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final Unit a(Function1 function1, boolean z) {
        function1.invoke(Boolean.valueOf(z));
        return Unit.INSTANCE;
    }

    public static final void a(final xw xwVar, final z00 z00Var, final Function1<? super xw, Unit> function1, Composer composer, final int i) {
        int i2;
        Drawable drawable;
        a10 a10Var;
        float f;
        boolean z;
        xwVar.getClass();
        z00Var.getClass();
        function1.getClass();
        Composer composerStartRestartGroup = composer.startRestartGroup(211324487);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(xwVar.ordinal()) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(z00Var) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & Token.DOTQUERY) != 146, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(211324487, i2, -1, "io.nutrient.internal.ui.settings.SettingsPresetItem (SettingsUiComponents.kt:293)");
            }
            Context context = (Context) composerStartRestartGroup.consume(AndroidCompositionLocals_androidKt.getLocalContext());
            a10 a10Var2 = z00Var.c;
            if (a10Var2 == null) {
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.b10$$ExternalSyntheticLambda18
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return b10.a(xwVar, z00Var, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                    return;
                }
                return;
            }
            SettingsColorScheme settingsColorScheme = UiTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getSettingsColorScheme();
            SettingsOptions settingsOptions = z00Var.a;
            xw xwVar2 = xw.d;
            if (xwVar == xwVar2) {
                drawable = a10Var2.a;
            } else {
                drawable = a10Var2.b;
            }
            int i3 = xwVar == xwVar2 ? com.pspdfkit.R.string.pspdf__settings_menu_horizontal : com.pspdfkit.R.string.pspdf__settings_menu_vertical;
            Alignment.Companion companion = Alignment.INSTANCE;
            Alignment.Horizontal centerHorizontally = companion.getCenterHorizontally();
            Arrangement.Vertical top = Arrangement.INSTANCE.getTop();
            Modifier.Companion companion2 = Modifier.INSTANCE;
            int i4 = i3;
            int i5 = i2 & 896;
            int i6 = i2 & 14;
            boolean z2 = (i5 == 256) | (i6 == 4);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.pspdfkit.internal.b10$$ExternalSyntheticLambda19
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return b10.a(function1, xwVar);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Modifier modifierM632clickableoSLSa3U$default = ClickableKt.m632clickableoSLSa3U$default(companion2, false, null, null, null, (Function0) objRememberedValue, 15, null);
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(top, centerHorizontally, composerStartRestartGroup, 54);
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM632clickableoSLSa3U$default);
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
            f2.a(companion3, composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, composerM6062constructorimpl, currentCompositionLocalMap);
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion3, composerM6062constructorimpl, Integer.valueOf(iHashCode), composerM6062constructorimpl));
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            Drawable drawable2 = drawable;
            State<Color> stateM437animateColorAsStateeuL9pac = SingleValueAnimationKt.m437animateColorAsStateeuL9pac(xwVar.a(settingsOptions) ? settingsColorScheme.m13958getSelectedColor0d7_KjU() : settingsColorScheme.m13961getUnselectedTextColor0d7_KjU(), AnimationSpecKt.tween$default(700, 0, null, 6, null), "", null, composerStartRestartGroup, 432, 8);
            State<Color> stateM437animateColorAsStateeuL9pac2 = SingleValueAnimationKt.m437animateColorAsStateeuL9pac(xwVar.a(settingsOptions) ? settingsColorScheme.m13958getSelectedColor0d7_KjU() : settingsColorScheme.m13960getUnselectedColor0d7_KjU(), AnimationSpecKt.tween$default(700, 0, null, 6, null), "", null, composerStartRestartGroup, 432, 8);
            if (xwVar.a(settingsOptions)) {
                a10Var = a10Var2;
                f = a10Var.c;
            } else {
                a10Var = a10Var2;
                f = a10Var.d;
            }
            a10 a10Var3 = a10Var;
            State<Float> stateAnimateFloatAsState = AnimateAsStateKt.animateFloatAsState(f, AnimationSpecKt.tween$default(700, 0, null, 6, null), 0.0f, "", null, composerStartRestartGroup, 3120, 20);
            Density density = (Density) composerStartRestartGroup.consume(CompositionLocalsKt.getLocalDensity());
            float f2 = 12;
            Modifier modifierClip = ClipKt.clip(SizeKt.m1266size3ABfNKs(companion2, Dp.m9687constructorimpl(64)), RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(f2)));
            float fFloatValue = stateAnimateFloatAsState.getValue().floatValue();
            density.getClass();
            Modifier modifierM604borderxT4_qwU = BorderKt.m604borderxT4_qwU(modifierClip, density.mo750toDpu2uoSUM(fFloatValue), stateM437animateColorAsStateeuL9pac2.getValue().m6824unboximpl(), RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(f2)));
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(companion.getTopStart(), false);
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM604borderxT4_qwU);
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
            f2.a(companion3, composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, composerM6062constructorimpl2, currentCompositionLocalMap2);
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, (Function2<? super T, ? super Modifier, Unit>) e2.a(companion3, composerM6062constructorimpl2, Integer.valueOf(iHashCode2), composerM6062constructorimpl2));
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            if (drawable2 == null) {
                composerStartRestartGroup.startReplaceGroup(-1750496144);
                composerStartRestartGroup.endReplaceGroup();
                z = true;
            } else {
                composerStartRestartGroup.startReplaceGroup(-1750496143);
                z = true;
                a((Modifier) null, drawable2, composerStartRestartGroup, 0, 1);
                Unit unit = Unit.INSTANCE;
                composerStartRestartGroup.endReplaceGroup();
            }
            a(xwVar, xwVar.a(settingsOptions), a10Var3, composerStartRestartGroup, i6);
            composerStartRestartGroup.endNode();
            String strA = no.a(context, i4, null);
            strA.getClass();
            boolean z3 = z;
            TextKt.m4494TextNvy7gAk(strA, PaddingKt.m1222paddingqDBjuR0$default(companion2, 0.0f, Dp.m9687constructorimpl(8), 0.0f, 0.0f, 13, null), stateM437animateColorAsStateeuL9pac.getValue().m6824unboximpl(), null, TextUnitKt.getSp(12), null, null, null, 0L, null, TextAlign.m9519boximpl(TextAlign.INSTANCE.m9526getCentere0LSkKk()), 0L, 0, false, 0, 0, null, null, composerStartRestartGroup, 24624, 0, 261096);
            boolean zA = xwVar.a(settingsOptions);
            boolean z4 = (i5 == 256 ? z3 : false) | (i6 == 4 ? z3 : false);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (z4 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.pspdfkit.internal.b10$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return b10.b(function1, xwVar);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            RadioButtonKt.RadioButton(zA, (Function0) objRememberedValue2, SizeKt.m1266size3ABfNKs(companion2, Dp.m9687constructorimpl(32)), false, RadioButtonDefaults.INSTANCE.m4018colorsro_MJ88(settingsColorScheme.m13958getSelectedColor0d7_KjU(), settingsColorScheme.m13961getUnselectedTextColor0d7_KjU(), 0L, 0L, composerStartRestartGroup, RadioButtonDefaults.$stable << 12, 12), null, composerStartRestartGroup, 384, 40);
            composerStartRestartGroup = composerStartRestartGroup;
            composerStartRestartGroup.endNode();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup2 = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup2 != null) {
            scopeUpdateScopeEndRestartGroup2.updateScope(new Function2() { // from class: com.pspdfkit.internal.b10$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return b10.b(xwVar, z00Var, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final Unit a(Function1 function1, xw xwVar) {
        function1.invoke(xwVar);
        return Unit.INSTANCE;
    }

    public static final void a(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(2096823930);
        if (composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2096823930, i, -1, "io.nutrient.internal.ui.settings.SettingsDivider (SettingsUiComponents.kt:358)");
            }
            DividerKt.m3284HorizontalDivider9IZ8Weo(SizeKt.m1252height3ABfNKs(SizeKt.fillMaxWidth$default(BackgroundKt.m589backgroundbw27NRU$default(Modifier.INSTANCE, UiTheme.INSTANCE.getColors(composerStartRestartGroup, 6).getSettingsColorScheme().m13956getDividerColor0d7_KjU(), null, 2, null), 0.0f, 1, null), Dp.m9687constructorimpl(1)), 0.0f, 0L, composerStartRestartGroup, 0, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.b10$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return b10.a(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}

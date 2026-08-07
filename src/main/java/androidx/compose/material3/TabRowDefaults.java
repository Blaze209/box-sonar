package androidx.compose.material3;

import androidx.compose.animation.core.AnimateAsStateKt;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.OffsetKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.material3.tokens.MotionSchemeKeyTokens;
import androidx.compose.material3.tokens.PrimaryNavigationTabTokens;
import androidx.compose.material3.tokens.SecondaryNavigationTabTokens;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.InspectableValueKt;
import androidx.compose.ui.platform.InspectorInfo;
import androidx.compose.ui.unit.Density;
import androidx.compose.ui.unit.Dp;
import androidx.compose.ui.unit.IntOffset;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.ReplaceWith;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: TabRow.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0003\bÇ\u0002\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J-\u0010\u001c\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u00052\b\b\u0002\u0010!\u001a\u00020\fH\u0007¢\u0006\u0004\b\"\u0010#JA\u0010$\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010%\u001a\u00020\u00052\b\b\u0002\u0010 \u001a\u00020\u00052\b\b\u0002\u0010!\u001a\u00020\f2\b\b\u0002\u0010&\u001a\u00020'H\u0007¢\u0006\u0004\b(\u0010)J-\u0010*\u001a\u00020\u001d2\b\b\u0002\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010 \u001a\u00020\u00052\b\b\u0002\u0010!\u001a\u00020\fH\u0007¢\u0006\u0004\b+\u0010#J\u0014\u0010,\u001a\u00020\u001f*\u00020\u001f2\u0006\u0010-\u001a\u00020.H\u0007R\u0013\u0010\u0004\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007R\u0013\u0010\t\u001a\u00020\u0005¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\n\u0010\u0007R\u001a\u0010\u000b\u001a\u00020\f8GX\u0087\u0004¢\u0006\f\u0012\u0004\b\r\u0010\u000e\u001a\u0004\b\u000f\u0010\u0010R\u0011\u0010\u0011\u001a\u00020\f8G¢\u0006\u0006\u001a\u0004\b\u0012\u0010\u0010R\u0011\u0010\u0013\u001a\u00020\f8G¢\u0006\u0006\u001a\u0004\b\u0014\u0010\u0010R\u001a\u0010\u0015\u001a\u00020\f8GX\u0087\u0004¢\u0006\f\u0012\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0017\u0010\u0010R\u0011\u0010\u0018\u001a\u00020\f8G¢\u0006\u0006\u001a\u0004\b\u0019\u0010\u0010R\u0011\u0010\u001a\u001a\u00020\f8G¢\u0006\u0006\u001a\u0004\b\u001b\u0010\u0010¨\u0006/²\u0006\n\u00100\u001a\u00020\u0005X\u008a\u0084\u0002²\u0006\n\u00101\u001a\u00020\u0005X\u008a\u0084\u0002"}, d2 = {"Landroidx/compose/material3/TabRowDefaults;", "", "<init>", "()V", "ScrollableTabRowMinTabWidth", "Landroidx/compose/ui/unit/Dp;", "getScrollableTabRowMinTabWidth-D9Ej5fM", "()F", "F", "ScrollableTabRowEdgeStartPadding", "getScrollableTabRowEdgeStartPadding-D9Ej5fM", "containerColor", "Landroidx/compose/ui/graphics/Color;", "getContainerColor$annotations", "(Landroidx/compose/runtime/Composer;I)V", "getContainerColor", "(Landroidx/compose/runtime/Composer;I)J", "primaryContainerColor", "getPrimaryContainerColor", "secondaryContainerColor", "getSecondaryContainerColor", "contentColor", "getContentColor$annotations", "getContentColor", "primaryContentColor", "getPrimaryContentColor", "secondaryContentColor", "getSecondaryContentColor", "Indicator", "", "modifier", "Landroidx/compose/ui/Modifier;", "height", "color", "Indicator-9IZ8Weo", "(Landroidx/compose/ui/Modifier;FJLandroidx/compose/runtime/Composer;II)V", "PrimaryIndicator", "width", "shape", "Landroidx/compose/ui/graphics/Shape;", "PrimaryIndicator-10LGxhE", "(Landroidx/compose/ui/Modifier;FFJLandroidx/compose/ui/graphics/Shape;Landroidx/compose/runtime/Composer;II)V", "SecondaryIndicator", "SecondaryIndicator-9IZ8Weo", "tabIndicatorOffset", "currentTabPosition", "Landroidx/compose/material3/TabPosition;", "material3", "currentTabWidth", "indicatorOffset"}, k = 1, mv = {2, 0, 0}, xi = 48)
public final class TabRowDefaults {
    public static final int $stable = 0;
    public static final TabRowDefaults INSTANCE = new TabRowDefaults();
    private static final float ScrollableTabRowMinTabWidth = Dp.m9687constructorimpl(90);
    private static final float ScrollableTabRowEdgeStartPadding = Dp.m9687constructorimpl(52);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Indicator_9IZ8Weo$lambda$0(TabRowDefaults tabRowDefaults, Modifier modifier, float f, long j, int i, int i2, Composer composer, int i3) {
        tabRowDefaults.m4371Indicator9IZ8Weo(modifier, f, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit PrimaryIndicator_10LGxhE$lambda$0(TabRowDefaults tabRowDefaults, Modifier modifier, float f, float f2, long j, Shape shape, int i, int i2, Composer composer, int i3) {
        tabRowDefaults.m4372PrimaryIndicator10LGxhE(modifier, f, f2, j, shape, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SecondaryIndicator_9IZ8Weo$lambda$0(TabRowDefaults tabRowDefaults, Modifier modifier, float f, long j, int i, int i2, Composer composer, int i3) {
        tabRowDefaults.m4373SecondaryIndicator9IZ8Weo(modifier, f, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    @Deprecated(message = "Use TabRowDefaults.primaryContainerColor instead", replaceWith = @ReplaceWith(expression = "primaryContainerColor", imports = {}))
    public static /* synthetic */ void getContainerColor$annotations(Composer composer, int i) {
    }

    @Deprecated(message = "Use TabRowDefaults.primaryContentColor instead", replaceWith = @ReplaceWith(expression = "primaryContentColor", imports = {}))
    public static /* synthetic */ void getContentColor$annotations(Composer composer, int i) {
    }

    private TabRowDefaults() {
    }

    /* JADX INFO: renamed from: getScrollableTabRowMinTabWidth-D9Ej5fM, reason: not valid java name */
    public final float m4375getScrollableTabRowMinTabWidthD9Ej5fM() {
        return ScrollableTabRowMinTabWidth;
    }

    /* JADX INFO: renamed from: getScrollableTabRowEdgeStartPadding-D9Ej5fM, reason: not valid java name */
    public final float m4374getScrollableTabRowEdgeStartPaddingD9Ej5fM() {
        return ScrollableTabRowEdgeStartPadding;
    }

    public final long getContainerColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -2026555673, "C(<get-containerColor>)996@42928L5:TabRow.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2026555673, i, -1, "androidx.compose.material3.TabRowDefaults.<get-containerColor> (TabRow.kt:996)");
        }
        long value = ColorSchemeKt.getValue(PrimaryNavigationTabTokens.INSTANCE.getContainerColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final long getPrimaryContainerColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -2069154037, "C(<get-primaryContainerColor>)1000@43099L5:TabRow.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-2069154037, i, -1, "androidx.compose.material3.TabRowDefaults.<get-primaryContainerColor> (TabRow.kt:1000)");
        }
        long value = ColorSchemeKt.getValue(PrimaryNavigationTabTokens.INSTANCE.getContainerColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final long getSecondaryContainerColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1938007129, "C(<get-secondaryContainerColor>)1004@43276L5:TabRow.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1938007129, i, -1, "androidx.compose.material3.TabRowDefaults.<get-secondaryContainerColor> (TabRow.kt:1004)");
        }
        long value = ColorSchemeKt.getValue(SecondaryNavigationTabTokens.INSTANCE.getContainerColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final long getContentColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1163072359, "C(<get-contentColor>)1012@43583L5:TabRow.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1163072359, i, -1, "androidx.compose.material3.TabRowDefaults.<get-contentColor> (TabRow.kt:1012)");
        }
        long value = ColorSchemeKt.getValue(PrimaryNavigationTabTokens.INSTANCE.getActiveLabelTextColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final long getPrimaryContentColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1410362619, "C(<get-primaryContentColor>)1016@43756L5:TabRow.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1410362619, i, -1, "androidx.compose.material3.TabRowDefaults.<get-primaryContentColor> (TabRow.kt:1016)");
        }
        long value = ColorSchemeKt.getValue(PrimaryNavigationTabTokens.INSTANCE.getActiveLabelTextColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    public final long getSecondaryContentColor(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 1166419479, "C(<get-secondaryContentColor>)1020@43935L5:TabRow.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1166419479, i, -1, "androidx.compose.material3.TabRowDefaults.<get-secondaryContentColor> (TabRow.kt:1020)");
        }
        long value = ColorSchemeKt.getValue(SecondaryNavigationTabTokens.INSTANCE.getActiveLabelTextColor(), composer, 6);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return value;
    }

    /* JADX WARN: Code duplicated, block: B:26:0x004e  */
    /* JADX WARN: Code duplicated, block: B:28:0x0052  */
    /* JADX WARN: Code duplicated, block: B:30:0x005a  */
    /* JADX WARN: Code duplicated, block: B:31:0x005d  */
    /* JADX WARN: Code duplicated, block: B:34:0x0063  */
    /* JADX WARN: Code duplicated, block: B:37:0x006d  */
    /* JADX WARN: Code duplicated, block: B:38:0x006f  */
    /* JADX WARN: Code duplicated, block: B:41:0x0078  */
    /* JADX WARN: Code duplicated, block: B:50:0x0096 A[PHI: r2 r3 r4
      0x0096: PHI (r2v9 androidx.compose.ui.Modifier) = (r2v5 androidx.compose.ui.Modifier), (r2v11 androidx.compose.ui.Modifier) binds: [B:58:0x00ac, B:49:0x0094] A[DONT_GENERATE, DONT_INLINE]
      0x0096: PHI (r3v11 float) = (r3v7 float), (r3v12 float) binds: [B:58:0x00ac, B:49:0x0094] A[DONT_GENERATE, DONT_INLINE]
      0x0096: PHI (r4v16 int) = (r4v9 int), (r4v17 int) binds: [B:58:0x00ac, B:49:0x0094] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:51:0x0098 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:52:0x009a  */
    /* JADX WARN: Code duplicated, block: B:53:0x009f  */
    /* JADX WARN: Code duplicated, block: B:55:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:59:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:62:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:65:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:67:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:70:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:72:? A[RETURN, SYNTHETIC] */
    @Deprecated(message = "Use SecondaryIndicator instead.", replaceWith = @ReplaceWith(expression = "SecondaryIndicator(modifier, height, color)", imports = {}))
    /* JADX INFO: renamed from: Indicator-9IZ8Weo, reason: not valid java name */
    public final void m4371Indicator9IZ8Weo(Modifier modifier, float f, long j, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        float f2;
        long j2;
        boolean z;
        final Modifier.Companion companion;
        final float fM5709getActiveIndicatorHeightD9Ej5fM;
        final long j3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        long jFromToken;
        Composer composerStartRestartGroup = composer.startRestartGroup(1454716052);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Indicator)N(modifier,height:c#ui.unit.Dp,color:c#ui.graphics.Color)1041@44664L69:TabRow.kt#uh7d8r");
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
        int i5 = i2 & 2;
        if (i5 == 0) {
            if ((i & 48) == 0) {
                f2 = f;
                i3 |= composerStartRestartGroup.changed(f2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if ((i2 & 4) == 0) {
                    j2 = j;
                    int i6 = composerStartRestartGroup.changed(j2) ? 256 : 128;
                    i3 |= i6;
                } else {
                    j2 = j;
                }
                i3 |= i6;
            } else {
                j2 = j;
            }
            if ((i3 & Token.DOTQUERY) != 146) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "1039@44576L11");
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i4 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        fM5709getActiveIndicatorHeightD9Ej5fM = PrimaryNavigationTabTokens.INSTANCE.m5709getActiveIndicatorHeightD9Ej5fM();
                    } else {
                        fM5709getActiveIndicatorHeightD9Ej5fM = f2;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        jFromToken = ColorSchemeKt.fromToken(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6), PrimaryNavigationTabTokens.INSTANCE.getActiveIndicatorColor());
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1454716052, i3, -1, "androidx.compose.material3.TabRowDefaults.Indicator (TabRow.kt:1040)");
                    }
                    BoxKt.Box(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.m1252height3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), fM5709getActiveIndicatorHeightD9Ej5fM), jFromToken, null, 2, null), composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j3 = jFromToken;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    companion = modifier2;
                    fM5709getActiveIndicatorHeightD9Ej5fM = f2;
                }
                jFromToken = j2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1454716052, i3, -1, "androidx.compose.material3.TabRowDefaults.Indicator (TabRow.kt:1040)");
                }
                BoxKt.Box(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.m1252height3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), fM5709getActiveIndicatorHeightD9Ej5fM), jFromToken, null, 2, null), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j3 = jFromToken;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                companion = modifier2;
                fM5709getActiveIndicatorHeightD9Ej5fM = f2;
                j3 = j2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowDefaults$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabRowDefaults.Indicator_9IZ8Weo$lambda$0(this.f$0, companion, fM5709getActiveIndicatorHeightD9Ej5fM, j3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        f2 = f;
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                j2 = j;
                if (composerStartRestartGroup.changed(j2)) {
                }
                i3 |= i6;
            } else {
                j2 = j;
            }
            i3 |= i6;
        } else {
            j2 = j;
        }
        if ((i3 & Token.DOTQUERY) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "1039@44576L11");
            if ((i & 1) != 0) {
                if (i4 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i5 != 0) {
                    fM5709getActiveIndicatorHeightD9Ej5fM = PrimaryNavigationTabTokens.INSTANCE.m5709getActiveIndicatorHeightD9Ej5fM();
                } else {
                    fM5709getActiveIndicatorHeightD9Ej5fM = f2;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    jFromToken = ColorSchemeKt.fromToken(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6), PrimaryNavigationTabTokens.INSTANCE.getActiveIndicatorColor());
                } else {
                    jFromToken = j2;
                }
            } else {
                if (i4 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i5 != 0) {
                    fM5709getActiveIndicatorHeightD9Ej5fM = PrimaryNavigationTabTokens.INSTANCE.m5709getActiveIndicatorHeightD9Ej5fM();
                } else {
                    fM5709getActiveIndicatorHeightD9Ej5fM = f2;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    jFromToken = ColorSchemeKt.fromToken(MaterialTheme.INSTANCE.getColorScheme(composerStartRestartGroup, 6), PrimaryNavigationTabTokens.INSTANCE.getActiveIndicatorColor());
                } else {
                    jFromToken = j2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1454716052, i3, -1, "androidx.compose.material3.TabRowDefaults.Indicator (TabRow.kt:1040)");
            }
            BoxKt.Box(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.m1252height3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), fM5709getActiveIndicatorHeightD9Ej5fM), jFromToken, null, 2, null), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            j3 = jFromToken;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            companion = modifier2;
            fM5709getActiveIndicatorHeightD9Ej5fM = f2;
            j3 = j2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowDefaults$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TabRowDefaults.Indicator_9IZ8Weo$lambda$0(this.f$0, companion, fM5709getActiveIndicatorHeightD9Ej5fM, j3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x004e  */
    /* JADX WARN: Code duplicated, block: B:27:0x0051  */
    /* JADX WARN: Code duplicated, block: B:29:0x0055  */
    /* JADX WARN: Code duplicated, block: B:31:0x005d  */
    /* JADX WARN: Code duplicated, block: B:32:0x0060  */
    /* JADX WARN: Code duplicated, block: B:37:0x006a  */
    /* JADX WARN: Code duplicated, block: B:39:0x006e  */
    /* JADX WARN: Code duplicated, block: B:41:0x0076  */
    /* JADX WARN: Code duplicated, block: B:42:0x0079  */
    /* JADX WARN: Code duplicated, block: B:45:0x007f  */
    /* JADX WARN: Code duplicated, block: B:48:0x0085  */
    /* JADX WARN: Code duplicated, block: B:49:0x0088  */
    /* JADX WARN: Code duplicated, block: B:51:0x008c  */
    /* JADX WARN: Code duplicated, block: B:53:0x0094  */
    /* JADX WARN: Code duplicated, block: B:54:0x0097  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:63:0x00af  */
    /* JADX WARN: Code duplicated, block: B:65:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:72:0x00cd A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:73:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:78:0x00e1  */
    /* JADX WARN: Code duplicated, block: B:81:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:83:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:86:0x010d  */
    /* JADX WARN: Code duplicated, block: B:89:0x012b  */
    /* JADX WARN: Code duplicated, block: B:90:0x012f  */
    /* JADX WARN: Code duplicated, block: B:93:0x013d  */
    /* JADX WARN: Code duplicated, block: B:95:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: PrimaryIndicator-10LGxhE, reason: not valid java name */
    public final void m4372PrimaryIndicator10LGxhE(Modifier modifier, float f, float f2, long j, Shape shape, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        float fM9687constructorimpl;
        int i4;
        float fM5709getActiveIndicatorHeightD9Ej5fM;
        int i5;
        long value;
        int i6;
        Shape activeIndicatorShape;
        int i7;
        boolean z;
        final Modifier.Companion companion;
        final float f3;
        final float f4;
        final long j2;
        final Shape shape2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1895596205);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(PrimaryIndicator)N(modifier,width:c#ui.unit.Dp,height:c#ui.unit.Dp,color:c#ui.graphics.Color,shape)1062@45454L174:TabRow.kt#uh7d8r");
        int i8 = i2 & 1;
        if (i8 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        int i9 = i2 & 2;
        if (i9 == 0) {
            if ((i & 48) == 0) {
                fM9687constructorimpl = f;
                i3 |= composerStartRestartGroup.changed(fM9687constructorimpl) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    fM5709getActiveIndicatorHeightD9Ej5fM = f2;
                    if (composerStartRestartGroup.changed(fM5709getActiveIndicatorHeightD9Ej5fM)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        value = j;
                        int i10 = composerStartRestartGroup.changed(value) ? 2048 : 1024;
                        i3 |= i10;
                    } else {
                        value = j;
                    }
                    i3 |= i10;
                } else {
                    value = j;
                }
                i6 = i2 & 16;
                if (i6 != 0) {
                    if ((i & 24576) == 0) {
                        activeIndicatorShape = shape;
                        if (composerStartRestartGroup.changed(activeIndicatorShape)) {
                            i7 = 16384;
                        } else {
                            i7 = 8192;
                        }
                        i3 |= i7;
                    }
                    if ((i3 & 9363) != 9362) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "1059@45359L5");
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i8 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i9 != 0) {
                                fM9687constructorimpl = Dp.m9687constructorimpl(24);
                            }
                            if (i4 != 0) {
                                fM5709getActiveIndicatorHeightD9Ej5fM = PrimaryNavigationTabTokens.INSTANCE.m5709getActiveIndicatorHeightD9Ej5fM();
                            }
                            if ((i2 & 8) != 0) {
                                value = ColorSchemeKt.getValue(PrimaryNavigationTabTokens.INSTANCE.getActiveIndicatorColor(), composerStartRestartGroup, 6);
                                i3 &= -7169;
                            }
                            if (i6 != 0) {
                                activeIndicatorShape = PrimaryNavigationTabTokens.INSTANCE.getActiveIndicatorShape();
                            }
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                            companion = modifier2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1895596205, i3, -1, "androidx.compose.material3.TabRowDefaults.PrimaryIndicator (TabRow.kt:1061)");
                        }
                        SpacerKt.Spacer(BackgroundKt.m588backgroundbw27NRU(SizeKt.m1263requiredWidth3ABfNKs(SizeKt.m1255requiredHeight3ABfNKs(companion, fM5709getActiveIndicatorHeightD9Ej5fM), fM9687constructorimpl), value, activeIndicatorShape), composerStartRestartGroup, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        companion = modifier2;
                    }
                    f3 = fM9687constructorimpl;
                    f4 = fM5709getActiveIndicatorHeightD9Ej5fM;
                    j2 = value;
                    shape2 = activeIndicatorShape;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowDefaults$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return TabRowDefaults.PrimaryIndicator_10LGxhE$lambda$0(this.f$0, companion, f3, f4, j2, shape2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 24576;
                activeIndicatorShape = shape;
                if ((i3 & 9363) != 9362) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "1059@45359L5");
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i9 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(24);
                        }
                        if (i4 != 0) {
                            fM5709getActiveIndicatorHeightD9Ej5fM = PrimaryNavigationTabTokens.INSTANCE.m5709getActiveIndicatorHeightD9Ej5fM();
                        }
                        if ((i2 & 8) != 0) {
                            value = ColorSchemeKt.getValue(PrimaryNavigationTabTokens.INSTANCE.getActiveIndicatorColor(), composerStartRestartGroup, 6);
                            i3 &= -7169;
                        }
                        if (i6 != 0) {
                            activeIndicatorShape = PrimaryNavigationTabTokens.INSTANCE.getActiveIndicatorShape();
                        }
                    } else {
                        if (i8 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i9 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(24);
                        }
                        if (i4 != 0) {
                            fM5709getActiveIndicatorHeightD9Ej5fM = PrimaryNavigationTabTokens.INSTANCE.m5709getActiveIndicatorHeightD9Ej5fM();
                        }
                        if ((i2 & 8) != 0) {
                            value = ColorSchemeKt.getValue(PrimaryNavigationTabTokens.INSTANCE.getActiveIndicatorColor(), composerStartRestartGroup, 6);
                            i3 &= -7169;
                        }
                        if (i6 != 0) {
                            activeIndicatorShape = PrimaryNavigationTabTokens.INSTANCE.getActiveIndicatorShape();
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1895596205, i3, -1, "androidx.compose.material3.TabRowDefaults.PrimaryIndicator (TabRow.kt:1061)");
                    }
                    SpacerKt.Spacer(BackgroundKt.m588backgroundbw27NRU(SizeKt.m1263requiredWidth3ABfNKs(SizeKt.m1255requiredHeight3ABfNKs(companion, fM5709getActiveIndicatorHeightD9Ej5fM), fM9687constructorimpl), value, activeIndicatorShape), composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    companion = modifier2;
                }
                f3 = fM9687constructorimpl;
                f4 = fM5709getActiveIndicatorHeightD9Ej5fM;
                j2 = value;
                shape2 = activeIndicatorShape;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowDefaults$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabRowDefaults.PrimaryIndicator_10LGxhE$lambda$0(this.f$0, companion, f3, f4, j2, shape2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 384;
            fM5709getActiveIndicatorHeightD9Ej5fM = f2;
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    value = j;
                    if (composerStartRestartGroup.changed(value)) {
                    }
                    i3 |= i10;
                } else {
                    value = j;
                }
                i3 |= i10;
            } else {
                value = j;
            }
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    activeIndicatorShape = shape;
                    if (composerStartRestartGroup.changed(activeIndicatorShape)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                if ((i3 & 9363) != 9362) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "1059@45359L5");
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i9 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(24);
                        }
                        if (i4 != 0) {
                            fM5709getActiveIndicatorHeightD9Ej5fM = PrimaryNavigationTabTokens.INSTANCE.m5709getActiveIndicatorHeightD9Ej5fM();
                        }
                        if ((i2 & 8) != 0) {
                            value = ColorSchemeKt.getValue(PrimaryNavigationTabTokens.INSTANCE.getActiveIndicatorColor(), composerStartRestartGroup, 6);
                            i3 &= -7169;
                        }
                        if (i6 != 0) {
                            activeIndicatorShape = PrimaryNavigationTabTokens.INSTANCE.getActiveIndicatorShape();
                        }
                    } else {
                        if (i8 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i9 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(24);
                        }
                        if (i4 != 0) {
                            fM5709getActiveIndicatorHeightD9Ej5fM = PrimaryNavigationTabTokens.INSTANCE.m5709getActiveIndicatorHeightD9Ej5fM();
                        }
                        if ((i2 & 8) != 0) {
                            value = ColorSchemeKt.getValue(PrimaryNavigationTabTokens.INSTANCE.getActiveIndicatorColor(), composerStartRestartGroup, 6);
                            i3 &= -7169;
                        }
                        if (i6 != 0) {
                            activeIndicatorShape = PrimaryNavigationTabTokens.INSTANCE.getActiveIndicatorShape();
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1895596205, i3, -1, "androidx.compose.material3.TabRowDefaults.PrimaryIndicator (TabRow.kt:1061)");
                    }
                    SpacerKt.Spacer(BackgroundKt.m588backgroundbw27NRU(SizeKt.m1263requiredWidth3ABfNKs(SizeKt.m1255requiredHeight3ABfNKs(companion, fM5709getActiveIndicatorHeightD9Ej5fM), fM9687constructorimpl), value, activeIndicatorShape), composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    companion = modifier2;
                }
                f3 = fM9687constructorimpl;
                f4 = fM5709getActiveIndicatorHeightD9Ej5fM;
                j2 = value;
                shape2 = activeIndicatorShape;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowDefaults$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabRowDefaults.PrimaryIndicator_10LGxhE$lambda$0(this.f$0, companion, f3, f4, j2, shape2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            activeIndicatorShape = shape;
            if ((i3 & 9363) != 9362) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "1059@45359L5");
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i9 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(24);
                    }
                    if (i4 != 0) {
                        fM5709getActiveIndicatorHeightD9Ej5fM = PrimaryNavigationTabTokens.INSTANCE.m5709getActiveIndicatorHeightD9Ej5fM();
                    }
                    if ((i2 & 8) != 0) {
                        value = ColorSchemeKt.getValue(PrimaryNavigationTabTokens.INSTANCE.getActiveIndicatorColor(), composerStartRestartGroup, 6);
                        i3 &= -7169;
                    }
                    if (i6 != 0) {
                        activeIndicatorShape = PrimaryNavigationTabTokens.INSTANCE.getActiveIndicatorShape();
                    }
                } else {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i9 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(24);
                    }
                    if (i4 != 0) {
                        fM5709getActiveIndicatorHeightD9Ej5fM = PrimaryNavigationTabTokens.INSTANCE.m5709getActiveIndicatorHeightD9Ej5fM();
                    }
                    if ((i2 & 8) != 0) {
                        value = ColorSchemeKt.getValue(PrimaryNavigationTabTokens.INSTANCE.getActiveIndicatorColor(), composerStartRestartGroup, 6);
                        i3 &= -7169;
                    }
                    if (i6 != 0) {
                        activeIndicatorShape = PrimaryNavigationTabTokens.INSTANCE.getActiveIndicatorShape();
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1895596205, i3, -1, "androidx.compose.material3.TabRowDefaults.PrimaryIndicator (TabRow.kt:1061)");
                }
                SpacerKt.Spacer(BackgroundKt.m588backgroundbw27NRU(SizeKt.m1263requiredWidth3ABfNKs(SizeKt.m1255requiredHeight3ABfNKs(companion, fM5709getActiveIndicatorHeightD9Ej5fM), fM9687constructorimpl), value, activeIndicatorShape), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                companion = modifier2;
            }
            f3 = fM9687constructorimpl;
            f4 = fM5709getActiveIndicatorHeightD9Ej5fM;
            j2 = value;
            shape2 = activeIndicatorShape;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowDefaults$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabRowDefaults.PrimaryIndicator_10LGxhE$lambda$0(this.f$0, companion, f3, f4, j2, shape2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        fM9687constructorimpl = f;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 384) == 0) {
                fM5709getActiveIndicatorHeightD9Ej5fM = f2;
                if (composerStartRestartGroup.changed(fM5709getActiveIndicatorHeightD9Ej5fM)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    value = j;
                    if (composerStartRestartGroup.changed(value)) {
                    }
                    i3 |= i10;
                } else {
                    value = j;
                }
                i3 |= i10;
            } else {
                value = j;
            }
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    activeIndicatorShape = shape;
                    if (composerStartRestartGroup.changed(activeIndicatorShape)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                if ((i3 & 9363) != 9362) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "1059@45359L5");
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i9 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(24);
                        }
                        if (i4 != 0) {
                            fM5709getActiveIndicatorHeightD9Ej5fM = PrimaryNavigationTabTokens.INSTANCE.m5709getActiveIndicatorHeightD9Ej5fM();
                        }
                        if ((i2 & 8) != 0) {
                            value = ColorSchemeKt.getValue(PrimaryNavigationTabTokens.INSTANCE.getActiveIndicatorColor(), composerStartRestartGroup, 6);
                            i3 &= -7169;
                        }
                        if (i6 != 0) {
                            activeIndicatorShape = PrimaryNavigationTabTokens.INSTANCE.getActiveIndicatorShape();
                        }
                    } else {
                        if (i8 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i9 != 0) {
                            fM9687constructorimpl = Dp.m9687constructorimpl(24);
                        }
                        if (i4 != 0) {
                            fM5709getActiveIndicatorHeightD9Ej5fM = PrimaryNavigationTabTokens.INSTANCE.m5709getActiveIndicatorHeightD9Ej5fM();
                        }
                        if ((i2 & 8) != 0) {
                            value = ColorSchemeKt.getValue(PrimaryNavigationTabTokens.INSTANCE.getActiveIndicatorColor(), composerStartRestartGroup, 6);
                            i3 &= -7169;
                        }
                        if (i6 != 0) {
                            activeIndicatorShape = PrimaryNavigationTabTokens.INSTANCE.getActiveIndicatorShape();
                        }
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1895596205, i3, -1, "androidx.compose.material3.TabRowDefaults.PrimaryIndicator (TabRow.kt:1061)");
                    }
                    SpacerKt.Spacer(BackgroundKt.m588backgroundbw27NRU(SizeKt.m1263requiredWidth3ABfNKs(SizeKt.m1255requiredHeight3ABfNKs(companion, fM5709getActiveIndicatorHeightD9Ej5fM), fM9687constructorimpl), value, activeIndicatorShape), composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    companion = modifier2;
                }
                f3 = fM9687constructorimpl;
                f4 = fM5709getActiveIndicatorHeightD9Ej5fM;
                j2 = value;
                shape2 = activeIndicatorShape;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowDefaults$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return TabRowDefaults.PrimaryIndicator_10LGxhE$lambda$0(this.f$0, companion, f3, f4, j2, shape2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            activeIndicatorShape = shape;
            if ((i3 & 9363) != 9362) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "1059@45359L5");
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i9 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(24);
                    }
                    if (i4 != 0) {
                        fM5709getActiveIndicatorHeightD9Ej5fM = PrimaryNavigationTabTokens.INSTANCE.m5709getActiveIndicatorHeightD9Ej5fM();
                    }
                    if ((i2 & 8) != 0) {
                        value = ColorSchemeKt.getValue(PrimaryNavigationTabTokens.INSTANCE.getActiveIndicatorColor(), composerStartRestartGroup, 6);
                        i3 &= -7169;
                    }
                    if (i6 != 0) {
                        activeIndicatorShape = PrimaryNavigationTabTokens.INSTANCE.getActiveIndicatorShape();
                    }
                } else {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i9 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(24);
                    }
                    if (i4 != 0) {
                        fM5709getActiveIndicatorHeightD9Ej5fM = PrimaryNavigationTabTokens.INSTANCE.m5709getActiveIndicatorHeightD9Ej5fM();
                    }
                    if ((i2 & 8) != 0) {
                        value = ColorSchemeKt.getValue(PrimaryNavigationTabTokens.INSTANCE.getActiveIndicatorColor(), composerStartRestartGroup, 6);
                        i3 &= -7169;
                    }
                    if (i6 != 0) {
                        activeIndicatorShape = PrimaryNavigationTabTokens.INSTANCE.getActiveIndicatorShape();
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1895596205, i3, -1, "androidx.compose.material3.TabRowDefaults.PrimaryIndicator (TabRow.kt:1061)");
                }
                SpacerKt.Spacer(BackgroundKt.m588backgroundbw27NRU(SizeKt.m1263requiredWidth3ABfNKs(SizeKt.m1255requiredHeight3ABfNKs(companion, fM5709getActiveIndicatorHeightD9Ej5fM), fM9687constructorimpl), value, activeIndicatorShape), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                companion = modifier2;
            }
            f3 = fM9687constructorimpl;
            f4 = fM5709getActiveIndicatorHeightD9Ej5fM;
            j2 = value;
            shape2 = activeIndicatorShape;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowDefaults$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabRowDefaults.PrimaryIndicator_10LGxhE$lambda$0(this.f$0, companion, f3, f4, j2, shape2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        fM5709getActiveIndicatorHeightD9Ej5fM = f2;
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                value = j;
                if (composerStartRestartGroup.changed(value)) {
                }
                i3 |= i10;
            } else {
                value = j;
            }
            i3 |= i10;
        } else {
            value = j;
        }
        i6 = i2 & 16;
        if (i6 != 0) {
            if ((i & 24576) == 0) {
                activeIndicatorShape = shape;
                if (composerStartRestartGroup.changed(activeIndicatorShape)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i3 |= i7;
            }
            if ((i3 & 9363) != 9362) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "1059@45359L5");
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i9 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(24);
                    }
                    if (i4 != 0) {
                        fM5709getActiveIndicatorHeightD9Ej5fM = PrimaryNavigationTabTokens.INSTANCE.m5709getActiveIndicatorHeightD9Ej5fM();
                    }
                    if ((i2 & 8) != 0) {
                        value = ColorSchemeKt.getValue(PrimaryNavigationTabTokens.INSTANCE.getActiveIndicatorColor(), composerStartRestartGroup, 6);
                        i3 &= -7169;
                    }
                    if (i6 != 0) {
                        activeIndicatorShape = PrimaryNavigationTabTokens.INSTANCE.getActiveIndicatorShape();
                    }
                } else {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i9 != 0) {
                        fM9687constructorimpl = Dp.m9687constructorimpl(24);
                    }
                    if (i4 != 0) {
                        fM5709getActiveIndicatorHeightD9Ej5fM = PrimaryNavigationTabTokens.INSTANCE.m5709getActiveIndicatorHeightD9Ej5fM();
                    }
                    if ((i2 & 8) != 0) {
                        value = ColorSchemeKt.getValue(PrimaryNavigationTabTokens.INSTANCE.getActiveIndicatorColor(), composerStartRestartGroup, 6);
                        i3 &= -7169;
                    }
                    if (i6 != 0) {
                        activeIndicatorShape = PrimaryNavigationTabTokens.INSTANCE.getActiveIndicatorShape();
                    }
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1895596205, i3, -1, "androidx.compose.material3.TabRowDefaults.PrimaryIndicator (TabRow.kt:1061)");
                }
                SpacerKt.Spacer(BackgroundKt.m588backgroundbw27NRU(SizeKt.m1263requiredWidth3ABfNKs(SizeKt.m1255requiredHeight3ABfNKs(companion, fM5709getActiveIndicatorHeightD9Ej5fM), fM9687constructorimpl), value, activeIndicatorShape), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                companion = modifier2;
            }
            f3 = fM9687constructorimpl;
            f4 = fM5709getActiveIndicatorHeightD9Ej5fM;
            j2 = value;
            shape2 = activeIndicatorShape;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowDefaults$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabRowDefaults.PrimaryIndicator_10LGxhE$lambda$0(this.f$0, companion, f3, f4, j2, shape2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        activeIndicatorShape = shape;
        if ((i3 & 9363) != 9362) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "1059@45359L5");
            if ((i & 1) != 0) {
                if (i8 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i9 != 0) {
                    fM9687constructorimpl = Dp.m9687constructorimpl(24);
                }
                if (i4 != 0) {
                    fM5709getActiveIndicatorHeightD9Ej5fM = PrimaryNavigationTabTokens.INSTANCE.m5709getActiveIndicatorHeightD9Ej5fM();
                }
                if ((i2 & 8) != 0) {
                    value = ColorSchemeKt.getValue(PrimaryNavigationTabTokens.INSTANCE.getActiveIndicatorColor(), composerStartRestartGroup, 6);
                    i3 &= -7169;
                }
                if (i6 != 0) {
                    activeIndicatorShape = PrimaryNavigationTabTokens.INSTANCE.getActiveIndicatorShape();
                }
            } else {
                if (i8 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i9 != 0) {
                    fM9687constructorimpl = Dp.m9687constructorimpl(24);
                }
                if (i4 != 0) {
                    fM5709getActiveIndicatorHeightD9Ej5fM = PrimaryNavigationTabTokens.INSTANCE.m5709getActiveIndicatorHeightD9Ej5fM();
                }
                if ((i2 & 8) != 0) {
                    value = ColorSchemeKt.getValue(PrimaryNavigationTabTokens.INSTANCE.getActiveIndicatorColor(), composerStartRestartGroup, 6);
                    i3 &= -7169;
                }
                if (i6 != 0) {
                    activeIndicatorShape = PrimaryNavigationTabTokens.INSTANCE.getActiveIndicatorShape();
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1895596205, i3, -1, "androidx.compose.material3.TabRowDefaults.PrimaryIndicator (TabRow.kt:1061)");
            }
            SpacerKt.Spacer(BackgroundKt.m588backgroundbw27NRU(SizeKt.m1263requiredWidth3ABfNKs(SizeKt.m1255requiredHeight3ABfNKs(companion, fM5709getActiveIndicatorHeightD9Ej5fM), fM9687constructorimpl), value, activeIndicatorShape), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            companion = modifier2;
        }
        f3 = fM9687constructorimpl;
        f4 = fM5709getActiveIndicatorHeightD9Ej5fM;
        j2 = value;
        shape2 = activeIndicatorShape;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowDefaults$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TabRowDefaults.PrimaryIndicator_10LGxhE$lambda$0(this.f$0, companion, f3, f4, j2, shape2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:26:0x004e  */
    /* JADX WARN: Code duplicated, block: B:28:0x0052  */
    /* JADX WARN: Code duplicated, block: B:30:0x005a  */
    /* JADX WARN: Code duplicated, block: B:31:0x005d  */
    /* JADX WARN: Code duplicated, block: B:34:0x0063  */
    /* JADX WARN: Code duplicated, block: B:37:0x006d  */
    /* JADX WARN: Code duplicated, block: B:38:0x006f  */
    /* JADX WARN: Code duplicated, block: B:41:0x0078  */
    /* JADX WARN: Code duplicated, block: B:50:0x0096 A[PHI: r2 r3 r4
      0x0096: PHI (r2v9 androidx.compose.ui.Modifier) = (r2v5 androidx.compose.ui.Modifier), (r2v11 androidx.compose.ui.Modifier) binds: [B:58:0x00ac, B:49:0x0094] A[DONT_GENERATE, DONT_INLINE]
      0x0096: PHI (r3v11 float) = (r3v7 float), (r3v12 float) binds: [B:58:0x00ac, B:49:0x0094] A[DONT_GENERATE, DONT_INLINE]
      0x0096: PHI (r4v16 int) = (r4v9 int), (r4v17 int) binds: [B:58:0x00ac, B:49:0x0094] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Code duplicated, block: B:51:0x0098 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:52:0x009a  */
    /* JADX WARN: Code duplicated, block: B:53:0x009f  */
    /* JADX WARN: Code duplicated, block: B:55:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:59:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:62:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:65:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:67:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:70:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:72:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: SecondaryIndicator-9IZ8Weo, reason: not valid java name */
    public final void m4373SecondaryIndicator9IZ8Weo(Modifier modifier, float f, long j, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        float f2;
        long j2;
        boolean z;
        final Modifier.Companion companion;
        final float fM5709getActiveIndicatorHeightD9Ej5fM;
        final long j3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        long value;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1498258020);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SecondaryIndicator)N(modifier,height:c#ui.unit.Dp,color:c#ui.graphics.Color)1084@46168L69:TabRow.kt#uh7d8r");
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
        int i5 = i2 & 2;
        if (i5 == 0) {
            if ((i & 48) == 0) {
                f2 = f;
                i3 |= composerStartRestartGroup.changed(f2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                if ((i2 & 4) == 0) {
                    j2 = j;
                    int i6 = composerStartRestartGroup.changed(j2) ? 256 : 128;
                    i3 |= i6;
                } else {
                    j2 = j;
                }
                i3 |= i6;
            } else {
                j2 = j;
            }
            if ((i3 & Token.DOTQUERY) != 146) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "1082@46145L5");
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i4 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        fM5709getActiveIndicatorHeightD9Ej5fM = PrimaryNavigationTabTokens.INSTANCE.m5709getActiveIndicatorHeightD9Ej5fM();
                    } else {
                        fM5709getActiveIndicatorHeightD9Ej5fM = f2;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        value = ColorSchemeKt.getValue(PrimaryNavigationTabTokens.INSTANCE.getActiveIndicatorColor(), composerStartRestartGroup, 6);
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1498258020, i3, -1, "androidx.compose.material3.TabRowDefaults.SecondaryIndicator (TabRow.kt:1083)");
                    }
                    BoxKt.Box(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.m1252height3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), fM5709getActiveIndicatorHeightD9Ej5fM), value, null, 2, null), composerStartRestartGroup, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j3 = value;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    companion = modifier2;
                    fM5709getActiveIndicatorHeightD9Ej5fM = f2;
                }
                value = j2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1498258020, i3, -1, "androidx.compose.material3.TabRowDefaults.SecondaryIndicator (TabRow.kt:1083)");
                }
                BoxKt.Box(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.m1252height3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), fM5709getActiveIndicatorHeightD9Ej5fM), value, null, 2, null), composerStartRestartGroup, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j3 = value;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                companion = modifier2;
                fM5709getActiveIndicatorHeightD9Ej5fM = f2;
                j3 = j2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowDefaults$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return TabRowDefaults.SecondaryIndicator_9IZ8Weo$lambda$0(this.f$0, companion, fM5709getActiveIndicatorHeightD9Ej5fM, j3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        f2 = f;
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                j2 = j;
                if (composerStartRestartGroup.changed(j2)) {
                }
                i3 |= i6;
            } else {
                j2 = j;
            }
            i3 |= i6;
        } else {
            j2 = j;
        }
        if ((i3 & Token.DOTQUERY) != 146) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "1082@46145L5");
            if ((i & 1) != 0) {
                if (i4 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i5 != 0) {
                    fM5709getActiveIndicatorHeightD9Ej5fM = PrimaryNavigationTabTokens.INSTANCE.m5709getActiveIndicatorHeightD9Ej5fM();
                } else {
                    fM5709getActiveIndicatorHeightD9Ej5fM = f2;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    value = ColorSchemeKt.getValue(PrimaryNavigationTabTokens.INSTANCE.getActiveIndicatorColor(), composerStartRestartGroup, 6);
                } else {
                    value = j2;
                }
            } else {
                if (i4 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i5 != 0) {
                    fM5709getActiveIndicatorHeightD9Ej5fM = PrimaryNavigationTabTokens.INSTANCE.m5709getActiveIndicatorHeightD9Ej5fM();
                } else {
                    fM5709getActiveIndicatorHeightD9Ej5fM = f2;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    value = ColorSchemeKt.getValue(PrimaryNavigationTabTokens.INSTANCE.getActiveIndicatorColor(), composerStartRestartGroup, 6);
                } else {
                    value = j2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1498258020, i3, -1, "androidx.compose.material3.TabRowDefaults.SecondaryIndicator (TabRow.kt:1083)");
            }
            BoxKt.Box(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.m1252height3ABfNKs(SizeKt.fillMaxWidth$default(companion, 0.0f, 1, null), fM5709getActiveIndicatorHeightD9Ej5fM), value, null, 2, null), composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            j3 = value;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            companion = modifier2;
            fM5709getActiveIndicatorHeightD9Ej5fM = f2;
            j3 = j2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.TabRowDefaults$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return TabRowDefaults.SecondaryIndicator_9IZ8Weo$lambda$0(this.f$0, companion, fM5709getActiveIndicatorHeightD9Ej5fM, j3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Modifier tabIndicatorOffset$lambda$1(TabPosition tabPosition, Modifier modifier, Composer composer, int i) {
        composer.startReplaceGroup(-1541271084);
        ComposerKt.sourceInformation(composer, "C1113@47548L7,1111@47397L177,1118@47776L7,1116@47626L176,1122@47910L53:TabRow.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1541271084, i, -1, "androidx.compose.material3.TabRowDefaults.tabIndicatorOffset.<anonymous> (TabRow.kt:1110)");
        }
        State<Dp> stateM464animateDpAsStateAjpBEmI = AnimateAsStateKt.m464animateDpAsStateAjpBEmI(tabPosition.getWidth(), MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composer, 6), null, null, composer, 0, 12);
        final State<Dp> stateM464animateDpAsStateAjpBEmI2 = AnimateAsStateKt.m464animateDpAsStateAjpBEmI(tabPosition.getLeft(), MotionSchemeKt.value(MotionSchemeKeyTokens.DefaultSpatial, composer, 6), null, null, composer, 0, 12);
        Modifier modifierWrapContentSize$default = SizeKt.wrapContentSize$default(SizeKt.fillMaxWidth$default(modifier, 0.0f, 1, null), Alignment.INSTANCE.getBottomStart(), false, 2, null);
        ComposerKt.sourceInformationMarkerStart(composer, 602226121, "CC(remember):TabRow.kt#9igjgp");
        boolean zChanged = composer.changed(stateM464animateDpAsStateAjpBEmI2);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function1() { // from class: androidx.compose.material3.TabRowDefaults$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function1
                public final Object invoke(Object obj) {
                    return TabRowDefaults.tabIndicatorOffset$lambda$1$2$0(stateM464animateDpAsStateAjpBEmI2, (Density) obj);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier modifierM1271width3ABfNKs = SizeKt.m1271width3ABfNKs(OffsetKt.offset(modifierWrapContentSize$default, (Function1) objRememberedValue), tabIndicatorOffset$lambda$1$0(stateM464animateDpAsStateAjpBEmI));
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return modifierM1271width3ABfNKs;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final IntOffset tabIndicatorOffset$lambda$1$2$0(State state, Density density) {
        return IntOffset.m9806boximpl(IntOffset.m9809constructorimpl((((long) density.mo748roundToPx0680j_4(tabIndicatorOffset$lambda$1$1(state))) << 32) | (((long) 0) & 4294967295L)));
    }

    @Deprecated(level = DeprecationLevel.WARNING, message = "Solely for use alongside deprecated TabRowDefaults.Indicator method. For recommended PrimaryIndicator and SecondaryIndicator methods, please use TabIndicatorScope.tabIndicatorOffset method.")
    public final Modifier tabIndicatorOffset(Modifier modifier, final TabPosition tabPosition) {
        return ComposedModifierKt.composed(modifier, InspectableValueKt.isDebugInspectorInfoEnabled() ? new Function1<InspectorInfo, Unit>() { // from class: androidx.compose.material3.TabRowDefaults$tabIndicatorOffset$$inlined$debugInspectorInfo$1
            {
                super(1);
            }

            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Unit invoke(InspectorInfo inspectorInfo) {
                invoke2(inspectorInfo);
                return Unit.INSTANCE;
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final void invoke2(InspectorInfo inspectorInfo) {
                inspectorInfo.setName("tabIndicatorOffset");
                inspectorInfo.setValue(tabPosition);
            }
        } : InspectableValueKt.getNoInspectorInfo(), new Function3() { // from class: androidx.compose.material3.TabRowDefaults$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return TabRowDefaults.tabIndicatorOffset$lambda$1(tabPosition, (Modifier) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        });
    }

    private static final float tabIndicatorOffset$lambda$1$0(State<Dp> state) {
        return state.getValue().m9701unboximpl();
    }

    private static final float tabIndicatorOffset$lambda$1$1(State<Dp> state) {
        return state.getValue().m9701unboximpl();
    }
}

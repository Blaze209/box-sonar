package com.pspdfkit.internal;

import android.graphics.Bitmap;
import androidx.compose.foundation.ImageKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.AndroidImageBitmap_androidKt;
import androidx.compose.ui.graphics.ColorFilter;
import androidx.compose.ui.layout.ContentScale;
import androidx.profileinstaller.ProfileVerifier;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: loaded from: classes3.dex */
public final class lz {

    public static final class a implements DisposableEffectResult {
        public final /* synthetic */ MutableState a;

        public a(MutableState mutableState) {
            this.a = mutableState;
        }

        @Override // androidx.compose.runtime.DisposableEffectResult
        public final void dispose() {
            x7 x7Var = (x7) this.a.getValue();
            if (x7Var != null) {
                x7Var.close();
            }
            this.a.setValue(null);
        }
    }

    public static final Unit a(long j, Function0 function0, Function3 function3, int i, Composer composer, int i2) {
        a(j, function0, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final Unit a(long j, Function0 function0, String str, Modifier modifier, ContentScale contentScale, Alignment alignment, int i, int i2, Composer composer, int i3) {
        a(j, function0, str, modifier, contentScale, alignment, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final void a(final long j, final Function0<x7> function0, final Function3<? super Bitmap, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i) {
        int i2;
        function0.getClass();
        function3.getClass();
        Composer composerStartRestartGroup = composer.startRestartGroup(-1702568497);
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(j) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function3) ? 256 : 128;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & Token.DOTQUERY) != 146, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1702568497, i2, -1, "com.pspdfkit.internal.ui.composables.RetainedBitmapContent (RetainedBitmapImage.kt:41)");
            }
            int i3 = i2 & 14;
            boolean z = i3 == 4;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(function0.invoke(), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            Long lValueOf = Long.valueOf(j);
            boolean zChanged = composerStartRestartGroup.changed(mutableState);
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: com.pspdfkit.internal.lz$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return lz.a(mutableState, (DisposableEffectScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            EffectsKt.DisposableEffect(lValueOf, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue2, composerStartRestartGroup, i3);
            x7 x7Var = (x7) mutableState.getValue();
            Bitmap bitmap = x7Var != null ? x7Var.a : null;
            if (bitmap != null) {
                composerStartRestartGroup.startReplaceGroup(-1948712396);
                function3.invoke(bitmap, composerStartRestartGroup, Integer.valueOf((i2 >> 3) & 112));
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-1948682605);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.lz$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return lz.a(j, function0, function3, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:38:0x0069  */
    /* JADX WARN: Code duplicated, block: B:39:0x006c  */
    /* JADX WARN: Code duplicated, block: B:41:0x0070  */
    /* JADX WARN: Code duplicated, block: B:43:0x0078  */
    /* JADX WARN: Code duplicated, block: B:44:0x007b  */
    /* JADX WARN: Code duplicated, block: B:49:0x0087  */
    /* JADX WARN: Code duplicated, block: B:50:0x0089  */
    /* JADX WARN: Code duplicated, block: B:52:0x008c  */
    /* JADX WARN: Code duplicated, block: B:54:0x0094  */
    /* JADX WARN: Code duplicated, block: B:55:0x0097  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a7  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a9  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b2 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:65:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:68:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:72:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d6  */
    /* JADX WARN: Code duplicated, block: B:78:0x0103  */
    /* JADX WARN: Code duplicated, block: B:80:0x0109  */
    /* JADX WARN: Code duplicated, block: B:83:0x0115  */
    /* JADX WARN: Code duplicated, block: B:85:? A[RETURN, SYNTHETIC] */
    public static final void a(final long j, final Function0<x7> function0, final String str, Modifier modifier, ContentScale contentScale, Alignment alignment, Composer composer, final int i, final int i2) {
        long j2;
        int i3;
        Function0<x7> function1;
        Modifier modifier2;
        int i4;
        ContentScale contentScale2;
        int i5;
        int i6;
        int i7;
        boolean z;
        final Alignment center;
        final ContentScale contentScale3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        final Modifier modifier3;
        final ContentScale fit;
        function0.getClass();
        Composer composerStartRestartGroup = composer.startRestartGroup(466863439);
        if ((i & 6) == 0) {
            j2 = j;
            i3 = (composerStartRestartGroup.changed(j2) ? 4 : 2) | i;
        } else {
            j2 = j;
            i3 = i;
        }
        if ((i & 48) == 0) {
            function1 = function0;
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 32 : 16;
        } else {
            function1 = function0;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(str) ? 256 : 128;
        }
        int i8 = i2 & 8;
        if (i8 == 0) {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            i4 = i2 & 16;
            if (i4 != 0) {
                if ((i & 24576) == 0) {
                    contentScale2 = contentScale;
                    if (composerStartRestartGroup.changed(contentScale2)) {
                        i5 = 16384;
                    } else {
                        i5 = 8192;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    if ((196608 & i) == 0) {
                        if (composerStartRestartGroup.changed(alignment)) {
                            i7 = 131072;
                        } else {
                            i7 = 65536;
                        }
                        i3 |= i7;
                    }
                    if ((74899 & i3) != 74898) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                        if (i8 != 0) {
                            modifier3 = Modifier.INSTANCE;
                        } else {
                            modifier3 = modifier2;
                        }
                        if (i4 != 0) {
                            fit = ContentScale.INSTANCE.getFit();
                        } else {
                            fit = contentScale2;
                        }
                        if (i6 != 0) {
                            center = Alignment.INSTANCE.getCenter();
                        } else {
                            center = alignment;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(466863439, i3, -1, "com.pspdfkit.internal.ui.composables.RetainedBitmapImage (RetainedBitmapImage.kt:71)");
                        }
                        final long j3 = j2;
                        a(j, function1, ComposableLambdaKt.rememberComposableLambda(577826295, true, new Function3() { // from class: com.pspdfkit.internal.lz$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return lz.a(j3, str, modifier3, center, fit, (Bitmap) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i3 & 14) | 384 | (i3 & 112));
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier2 = modifier3;
                        contentScale3 = fit;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        center = alignment;
                        contentScale3 = contentScale2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final Modifier modifier4 = modifier2;
                        final Alignment alignment2 = center;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.lz$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return lz.a(j, function0, str, modifier4, contentScale3, alignment2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                if ((74899 & i3) != 74898) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    if (i8 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        fit = ContentScale.INSTANCE.getFit();
                    } else {
                        fit = contentScale2;
                    }
                    if (i6 != 0) {
                        center = Alignment.INSTANCE.getCenter();
                    } else {
                        center = alignment;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(466863439, i3, -1, "com.pspdfkit.internal.ui.composables.RetainedBitmapImage (RetainedBitmapImage.kt:71)");
                    }
                    final long j4 = j2;
                    a(j, function1, ComposableLambdaKt.rememberComposableLambda(577826295, true, new Function3() { // from class: com.pspdfkit.internal.lz$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return lz.a(j4, str, modifier3, center, fit, (Bitmap) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i3 & 14) | 384 | (i3 & 112));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier3;
                    contentScale3 = fit;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    center = alignment;
                    contentScale3 = contentScale2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier5 = modifier2;
                    final Alignment alignment3 = center;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.lz$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return lz.a(j, function0, str, modifier5, contentScale3, alignment3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            contentScale2 = contentScale;
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((196608 & i) == 0) {
                    if (composerStartRestartGroup.changed(alignment)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                if ((74899 & i3) != 74898) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    if (i8 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        fit = ContentScale.INSTANCE.getFit();
                    } else {
                        fit = contentScale2;
                    }
                    if (i6 != 0) {
                        center = Alignment.INSTANCE.getCenter();
                    } else {
                        center = alignment;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(466863439, i3, -1, "com.pspdfkit.internal.ui.composables.RetainedBitmapImage (RetainedBitmapImage.kt:71)");
                    }
                    final long j5 = j2;
                    a(j, function1, ComposableLambdaKt.rememberComposableLambda(577826295, true, new Function3() { // from class: com.pspdfkit.internal.lz$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return lz.a(j5, str, modifier3, center, fit, (Bitmap) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i3 & 14) | 384 | (i3 & 112));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier3;
                    contentScale3 = fit;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    center = alignment;
                    contentScale3 = contentScale2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier6 = modifier2;
                    final Alignment alignment4 = center;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.lz$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return lz.a(j, function0, str, modifier6, contentScale3, alignment4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            if ((74899 & i3) != 74898) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                if (i8 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    fit = ContentScale.INSTANCE.getFit();
                } else {
                    fit = contentScale2;
                }
                if (i6 != 0) {
                    center = Alignment.INSTANCE.getCenter();
                } else {
                    center = alignment;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(466863439, i3, -1, "com.pspdfkit.internal.ui.composables.RetainedBitmapImage (RetainedBitmapImage.kt:71)");
                }
                final long j6 = j2;
                a(j, function1, ComposableLambdaKt.rememberComposableLambda(577826295, true, new Function3() { // from class: com.pspdfkit.internal.lz$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return lz.a(j6, str, modifier3, center, fit, (Bitmap) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i3 & 14) | 384 | (i3 & 112));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
                contentScale3 = fit;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                center = alignment;
                contentScale3 = contentScale2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier7 = modifier2;
                final Alignment alignment5 = center;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.lz$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return lz.a(j, function0, str, modifier7, contentScale3, alignment5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        modifier2 = modifier;
        i4 = i2 & 16;
        if (i4 != 0) {
            if ((i & 24576) == 0) {
                contentScale2 = contentScale;
                if (composerStartRestartGroup.changed(contentScale2)) {
                    i5 = 16384;
                } else {
                    i5 = 8192;
                }
                i3 |= i5;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((196608 & i) == 0) {
                    if (composerStartRestartGroup.changed(alignment)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                if ((74899 & i3) != 74898) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    if (i8 != 0) {
                        modifier3 = Modifier.INSTANCE;
                    } else {
                        modifier3 = modifier2;
                    }
                    if (i4 != 0) {
                        fit = ContentScale.INSTANCE.getFit();
                    } else {
                        fit = contentScale2;
                    }
                    if (i6 != 0) {
                        center = Alignment.INSTANCE.getCenter();
                    } else {
                        center = alignment;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(466863439, i3, -1, "com.pspdfkit.internal.ui.composables.RetainedBitmapImage (RetainedBitmapImage.kt:71)");
                    }
                    final long j7 = j2;
                    a(j, function1, ComposableLambdaKt.rememberComposableLambda(577826295, true, new Function3() { // from class: com.pspdfkit.internal.lz$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return lz.a(j7, str, modifier3, center, fit, (Bitmap) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i3 & 14) | 384 | (i3 & 112));
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier2 = modifier3;
                    contentScale3 = fit;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    center = alignment;
                    contentScale3 = contentScale2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier8 = modifier2;
                    final Alignment alignment6 = center;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.lz$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return lz.a(j, function0, str, modifier8, contentScale3, alignment6, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            if ((74899 & i3) != 74898) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                if (i8 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    fit = ContentScale.INSTANCE.getFit();
                } else {
                    fit = contentScale2;
                }
                if (i6 != 0) {
                    center = Alignment.INSTANCE.getCenter();
                } else {
                    center = alignment;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(466863439, i3, -1, "com.pspdfkit.internal.ui.composables.RetainedBitmapImage (RetainedBitmapImage.kt:71)");
                }
                final long j8 = j2;
                a(j, function1, ComposableLambdaKt.rememberComposableLambda(577826295, true, new Function3() { // from class: com.pspdfkit.internal.lz$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return lz.a(j8, str, modifier3, center, fit, (Bitmap) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i3 & 14) | 384 | (i3 & 112));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
                contentScale3 = fit;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                center = alignment;
                contentScale3 = contentScale2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier9 = modifier2;
                final Alignment alignment7 = center;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.lz$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return lz.a(j, function0, str, modifier9, contentScale3, alignment7, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        contentScale2 = contentScale;
        i6 = i2 & 32;
        if (i6 != 0) {
            if ((196608 & i) == 0) {
                if (composerStartRestartGroup.changed(alignment)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
            if ((74899 & i3) != 74898) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                if (i8 != 0) {
                    modifier3 = Modifier.INSTANCE;
                } else {
                    modifier3 = modifier2;
                }
                if (i4 != 0) {
                    fit = ContentScale.INSTANCE.getFit();
                } else {
                    fit = contentScale2;
                }
                if (i6 != 0) {
                    center = Alignment.INSTANCE.getCenter();
                } else {
                    center = alignment;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(466863439, i3, -1, "com.pspdfkit.internal.ui.composables.RetainedBitmapImage (RetainedBitmapImage.kt:71)");
                }
                final long j9 = j2;
                a(j, function1, ComposableLambdaKt.rememberComposableLambda(577826295, true, new Function3() { // from class: com.pspdfkit.internal.lz$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return lz.a(j9, str, modifier3, center, fit, (Bitmap) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i3 & 14) | 384 | (i3 & 112));
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier2 = modifier3;
                contentScale3 = fit;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                center = alignment;
                contentScale3 = contentScale2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier10 = modifier2;
                final Alignment alignment8 = center;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.lz$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return lz.a(j, function0, str, modifier10, contentScale3, alignment8, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        if ((74899 & i3) != 74898) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            if (i8 != 0) {
                modifier3 = Modifier.INSTANCE;
            } else {
                modifier3 = modifier2;
            }
            if (i4 != 0) {
                fit = ContentScale.INSTANCE.getFit();
            } else {
                fit = contentScale2;
            }
            if (i6 != 0) {
                center = Alignment.INSTANCE.getCenter();
            } else {
                center = alignment;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(466863439, i3, -1, "com.pspdfkit.internal.ui.composables.RetainedBitmapImage (RetainedBitmapImage.kt:71)");
            }
            final long j10 = j2;
            a(j, function1, ComposableLambdaKt.rememberComposableLambda(577826295, true, new Function3() { // from class: com.pspdfkit.internal.lz$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return lz.a(j10, str, modifier3, center, fit, (Bitmap) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i3 & 14) | 384 | (i3 & 112));
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
            contentScale3 = fit;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            center = alignment;
            contentScale3 = contentScale2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier11 = modifier2;
            final Alignment alignment9 = center;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.pspdfkit.internal.lz$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return lz.a(j, function0, str, modifier11, contentScale3, alignment9, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final Unit a(long j, String str, Modifier modifier, Alignment alignment, ContentScale contentScale, Bitmap bitmap, Composer composer, int i) {
        bitmap.getClass();
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(577826295, i, -1, "com.pspdfkit.internal.ui.composables.RetainedBitmapImage.<anonymous> (RetainedBitmapImage.kt:76)");
        }
        boolean zChanged = composer.changed(j);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new zz(AndroidImageBitmap_androidKt.asImageBitmap(bitmap));
            composer.updateRememberedValue(objRememberedValue);
        }
        ImageKt.Image((zz) objRememberedValue, str, modifier, alignment, contentScale, 0.0f, (ColorFilter) null, composer, 0, 96);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    public static final DisposableEffectResult a(MutableState mutableState, DisposableEffectScope disposableEffectScope) {
        disposableEffectScope.getClass();
        return new a(mutableState);
    }
}

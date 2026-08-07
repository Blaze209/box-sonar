package com.box.android.base.presentation.components.topbar.simple;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.material3.AppBarKt;
import androidx.compose.material3.IconButtonColors;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.TextKt;
import androidx.compose.material3.TopAppBarDefaults;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.text.TextStyle;
import androidx.compose.ui.text.style.TextOverflow;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.base.compose.CustomRippleConfigurationKt;
import com.pspdfkit.ui.toolbar.ContextualToolbar;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxSimpleTopBar.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000(\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\u001aA\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\f\u001a\r\u0010\r\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"BoxSimpleTopBar", "", "title", "", "onClose", "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "isRedesignedVersion", "", "textStyle", "Landroidx/compose/ui/text/TextStyle;", "(Ljava/lang/String;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/text/TextStyle;Landroidx/compose/runtime/Composer;II)V", "BoxSimpleTopBarPreview", "(Landroidx/compose/runtime/Composer;I)V", "base_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BoxSimpleTopBarKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxSimpleTopBar$lambda$3(String str, Function0 function0, Modifier modifier, boolean z, TextStyle textStyle, int i, int i2, Composer composer, int i3) {
        BoxSimpleTopBar(str, function0, modifier, z, textStyle, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxSimpleTopBarPreview$lambda$0(int i, Composer composer, int i2) {
        BoxSimpleTopBarPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x005f  */
    /* JADX WARN: Code duplicated, block: B:31:0x0062  */
    /* JADX WARN: Code duplicated, block: B:33:0x0066  */
    /* JADX WARN: Code duplicated, block: B:35:0x006e  */
    /* JADX WARN: Code duplicated, block: B:36:0x0071  */
    /* JADX WARN: Code duplicated, block: B:41:0x007b  */
    /* JADX WARN: Code duplicated, block: B:42:0x007e  */
    /* JADX WARN: Code duplicated, block: B:44:0x0082  */
    /* JADX WARN: Code duplicated, block: B:46:0x008a  */
    /* JADX WARN: Code duplicated, block: B:47:0x008d  */
    /* JADX WARN: Code duplicated, block: B:52:0x009b  */
    /* JADX WARN: Code duplicated, block: B:53:0x009d  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a6 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:57:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:58:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:60:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b2  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:64:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:67:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:70:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:71:0x015b  */
    /* JADX WARN: Code duplicated, block: B:74:0x018a  */
    /* JADX WARN: Code duplicated, block: B:76:0x0192  */
    /* JADX WARN: Code duplicated, block: B:79:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:81:? A[RETURN, SYNTHETIC] */
    public static final void BoxSimpleTopBar(final String title, final Function0<Unit> onClose, Modifier modifier, boolean z, TextStyle textStyle, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        int i5;
        int i6;
        TextStyle textStyle2;
        int i7;
        boolean z3;
        Composer composer2;
        final Modifier modifier3;
        final boolean z4;
        final TextStyle textStyle3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        boolean z5;
        final TextStyle boxMedium22;
        TextStyle textStyle4;
        Intrinsics.checkNotNullParameter(title, "title");
        Intrinsics.checkNotNullParameter(onClose, "onClose");
        Composer composerStartRestartGroup = composer.startRestartGroup(-806553552);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxSimpleTopBar)N(title,onClose,modifier,isRedesignedVersion,textStyle):BoxSimpleTopBar.kt#osoi5s");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(title) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onClose) ? 32 : 16;
        }
        int i8 = i2 & 4;
        if (i8 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                if ((i & 3072) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i5 = 2048;
                    } else {
                        i5 = 1024;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 16;
                if (i6 != 0) {
                    if ((i & 24576) == 0) {
                        textStyle2 = textStyle;
                        if (composerStartRestartGroup.changed(textStyle2)) {
                            i7 = 16384;
                        } else {
                            i7 = 8192;
                        }
                        i3 |= i7;
                    }
                    if ((i3 & 9363) != 9362) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                        if (i8 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z5 = false;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            boxMedium22 = BoxTheme.INSTANCE.getTypography().getBoxMedium22();
                        } else {
                            boxMedium22 = textStyle2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-806553552, i3, -1, "com.box.android.base.presentation.components.topbar.simple.BoxSimpleTopBar (BoxSimpleTopBar.kt:30)");
                        }
                        if (z5) {
                            composerStartRestartGroup.startReplaceGroup(-1989544602);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "33@1260L281,43@1632L421,55@2153L6,56@2225L6,57@2301L6,58@2365L6,54@2094L305,32@1229L1180");
                            textStyle4 = boxMedium22;
                            AppBarKt.m2784TopAppBarGHTll3U(ComposableLambdaKt.rememberComposableLambda(220931847, true, new Function2() { // from class: com.box.android.base.presentation.components.topbar.simple.BoxSimpleTopBarKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxSimpleTopBarKt.BoxSimpleTopBar$lambda$0(title, boxMedium22, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54), TestTagKt.testTag(companion, "BoxSimpleTopBar"), ComposableLambdaKt.rememberComposableLambda(-1127201723, true, new Function2() { // from class: com.box.android.base.presentation.components.topbar.simple.BoxSimpleTopBarKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxSimpleTopBarKt.BoxSimpleTopBar$lambda$1(onClose, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54), null, 0.0f, null, TopAppBarDefaults.INSTANCE.m4782topAppBarColors5tl4gsc(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11572getTextFieldText0d7_KjU(), 0L, 0L, composerStartRestartGroup, TopAppBarDefaults.$stable << 18, 48), null, composerStartRestartGroup, 390, 184);
                            composerStartRestartGroup.endReplaceGroup();
                            composer2 = composerStartRestartGroup;
                        } else {
                            textStyle4 = boxMedium22;
                            composerStartRestartGroup.startReplaceGroup(-1988349118);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "62@2457L1254,62@2431L1280");
                            CustomRippleConfigurationKt.m11643CustomRippleConfiguration3JVO9M(0L, ComposableLambdaKt.rememberComposableLambda(1134741117, true, new Function2() { // from class: com.box.android.base.presentation.components.topbar.simple.BoxSimpleTopBarKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BoxSimpleTopBarKt.BoxSimpleTopBar$lambda$2(title, onClose, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, 48, 1);
                            composer2 = composerStartRestartGroup;
                            composer2.endReplaceGroup();
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = companion;
                        z4 = z5;
                        textStyle3 = textStyle4;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier3 = modifier2;
                        z4 = z2;
                        textStyle3 = textStyle2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.topbar.simple.BoxSimpleTopBarKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxSimpleTopBarKt.BoxSimpleTopBar$lambda$3(title, onClose, modifier3, z4, textStyle3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 24576;
                textStyle2 = textStyle;
                if ((i3 & 9363) != 9362) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        boxMedium22 = BoxTheme.INSTANCE.getTypography().getBoxMedium22();
                    } else {
                        boxMedium22 = textStyle2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-806553552, i3, -1, "com.box.android.base.presentation.components.topbar.simple.BoxSimpleTopBar (BoxSimpleTopBar.kt:30)");
                    }
                    if (z5) {
                        composerStartRestartGroup.startReplaceGroup(-1989544602);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "33@1260L281,43@1632L421,55@2153L6,56@2225L6,57@2301L6,58@2365L6,54@2094L305,32@1229L1180");
                        textStyle4 = boxMedium22;
                        AppBarKt.m2784TopAppBarGHTll3U(ComposableLambdaKt.rememberComposableLambda(220931847, true, new Function2() { // from class: com.box.android.base.presentation.components.topbar.simple.BoxSimpleTopBarKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxSimpleTopBarKt.BoxSimpleTopBar$lambda$0(title, boxMedium22, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), TestTagKt.testTag(companion, "BoxSimpleTopBar"), ComposableLambdaKt.rememberComposableLambda(-1127201723, true, new Function2() { // from class: com.box.android.base.presentation.components.topbar.simple.BoxSimpleTopBarKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxSimpleTopBarKt.BoxSimpleTopBar$lambda$1(onClose, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), null, 0.0f, null, TopAppBarDefaults.INSTANCE.m4782topAppBarColors5tl4gsc(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11572getTextFieldText0d7_KjU(), 0L, 0L, composerStartRestartGroup, TopAppBarDefaults.$stable << 18, 48), null, composerStartRestartGroup, 390, 184);
                        composerStartRestartGroup.endReplaceGroup();
                        composer2 = composerStartRestartGroup;
                    } else {
                        textStyle4 = boxMedium22;
                        composerStartRestartGroup.startReplaceGroup(-1988349118);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "62@2457L1254,62@2431L1280");
                        CustomRippleConfigurationKt.m11643CustomRippleConfiguration3JVO9M(0L, ComposableLambdaKt.rememberComposableLambda(1134741117, true, new Function2() { // from class: com.box.android.base.presentation.components.topbar.simple.BoxSimpleTopBarKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxSimpleTopBarKt.BoxSimpleTopBar$lambda$2(title, onClose, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, 48, 1);
                        composer2 = composerStartRestartGroup;
                        composer2.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = companion;
                    z4 = z5;
                    textStyle3 = textStyle4;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    z4 = z2;
                    textStyle3 = textStyle2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.topbar.simple.BoxSimpleTopBarKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxSimpleTopBarKt.BoxSimpleTopBar$lambda$3(title, onClose, modifier3, z4, textStyle3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            z2 = z;
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    textStyle2 = textStyle;
                    if (composerStartRestartGroup.changed(textStyle2)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                if ((i3 & 9363) != 9362) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        boxMedium22 = BoxTheme.INSTANCE.getTypography().getBoxMedium22();
                    } else {
                        boxMedium22 = textStyle2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-806553552, i3, -1, "com.box.android.base.presentation.components.topbar.simple.BoxSimpleTopBar (BoxSimpleTopBar.kt:30)");
                    }
                    if (z5) {
                        composerStartRestartGroup.startReplaceGroup(-1989544602);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "33@1260L281,43@1632L421,55@2153L6,56@2225L6,57@2301L6,58@2365L6,54@2094L305,32@1229L1180");
                        textStyle4 = boxMedium22;
                        AppBarKt.m2784TopAppBarGHTll3U(ComposableLambdaKt.rememberComposableLambda(220931847, true, new Function2() { // from class: com.box.android.base.presentation.components.topbar.simple.BoxSimpleTopBarKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxSimpleTopBarKt.BoxSimpleTopBar$lambda$0(title, boxMedium22, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), TestTagKt.testTag(companion, "BoxSimpleTopBar"), ComposableLambdaKt.rememberComposableLambda(-1127201723, true, new Function2() { // from class: com.box.android.base.presentation.components.topbar.simple.BoxSimpleTopBarKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxSimpleTopBarKt.BoxSimpleTopBar$lambda$1(onClose, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), null, 0.0f, null, TopAppBarDefaults.INSTANCE.m4782topAppBarColors5tl4gsc(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11572getTextFieldText0d7_KjU(), 0L, 0L, composerStartRestartGroup, TopAppBarDefaults.$stable << 18, 48), null, composerStartRestartGroup, 390, 184);
                        composerStartRestartGroup.endReplaceGroup();
                        composer2 = composerStartRestartGroup;
                    } else {
                        textStyle4 = boxMedium22;
                        composerStartRestartGroup.startReplaceGroup(-1988349118);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "62@2457L1254,62@2431L1280");
                        CustomRippleConfigurationKt.m11643CustomRippleConfiguration3JVO9M(0L, ComposableLambdaKt.rememberComposableLambda(1134741117, true, new Function2() { // from class: com.box.android.base.presentation.components.topbar.simple.BoxSimpleTopBarKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxSimpleTopBarKt.BoxSimpleTopBar$lambda$2(title, onClose, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, 48, 1);
                        composer2 = composerStartRestartGroup;
                        composer2.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = companion;
                    z4 = z5;
                    textStyle3 = textStyle4;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    z4 = z2;
                    textStyle3 = textStyle2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.topbar.simple.BoxSimpleTopBarKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxSimpleTopBarKt.BoxSimpleTopBar$lambda$3(title, onClose, modifier3, z4, textStyle3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            textStyle2 = textStyle;
            if ((i3 & 9363) != 9362) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                if (i8 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
                if (i6 != 0) {
                    boxMedium22 = BoxTheme.INSTANCE.getTypography().getBoxMedium22();
                } else {
                    boxMedium22 = textStyle2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-806553552, i3, -1, "com.box.android.base.presentation.components.topbar.simple.BoxSimpleTopBar (BoxSimpleTopBar.kt:30)");
                }
                if (z5) {
                    composerStartRestartGroup.startReplaceGroup(-1989544602);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "33@1260L281,43@1632L421,55@2153L6,56@2225L6,57@2301L6,58@2365L6,54@2094L305,32@1229L1180");
                    textStyle4 = boxMedium22;
                    AppBarKt.m2784TopAppBarGHTll3U(ComposableLambdaKt.rememberComposableLambda(220931847, true, new Function2() { // from class: com.box.android.base.presentation.components.topbar.simple.BoxSimpleTopBarKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxSimpleTopBarKt.BoxSimpleTopBar$lambda$0(title, boxMedium22, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), TestTagKt.testTag(companion, "BoxSimpleTopBar"), ComposableLambdaKt.rememberComposableLambda(-1127201723, true, new Function2() { // from class: com.box.android.base.presentation.components.topbar.simple.BoxSimpleTopBarKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxSimpleTopBarKt.BoxSimpleTopBar$lambda$1(onClose, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), null, 0.0f, null, TopAppBarDefaults.INSTANCE.m4782topAppBarColors5tl4gsc(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11572getTextFieldText0d7_KjU(), 0L, 0L, composerStartRestartGroup, TopAppBarDefaults.$stable << 18, 48), null, composerStartRestartGroup, 390, 184);
                    composerStartRestartGroup.endReplaceGroup();
                    composer2 = composerStartRestartGroup;
                } else {
                    textStyle4 = boxMedium22;
                    composerStartRestartGroup.startReplaceGroup(-1988349118);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "62@2457L1254,62@2431L1280");
                    CustomRippleConfigurationKt.m11643CustomRippleConfiguration3JVO9M(0L, ComposableLambdaKt.rememberComposableLambda(1134741117, true, new Function2() { // from class: com.box.android.base.presentation.components.topbar.simple.BoxSimpleTopBarKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxSimpleTopBarKt.BoxSimpleTopBar$lambda$2(title, onClose, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 48, 1);
                    composer2 = composerStartRestartGroup;
                    composer2.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = companion;
                z4 = z5;
                textStyle3 = textStyle4;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                z4 = z2;
                textStyle3 = textStyle2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.topbar.simple.BoxSimpleTopBarKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxSimpleTopBarKt.BoxSimpleTopBar$lambda$3(title, onClose, modifier3, z4, textStyle3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        i4 = i2 & 8;
        if (i4 != 0) {
            if ((i & 3072) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    textStyle2 = textStyle;
                    if (composerStartRestartGroup.changed(textStyle2)) {
                        i7 = 16384;
                    } else {
                        i7 = 8192;
                    }
                    i3 |= i7;
                }
                if ((i3 & 9363) != 9362) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        boxMedium22 = BoxTheme.INSTANCE.getTypography().getBoxMedium22();
                    } else {
                        boxMedium22 = textStyle2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-806553552, i3, -1, "com.box.android.base.presentation.components.topbar.simple.BoxSimpleTopBar (BoxSimpleTopBar.kt:30)");
                    }
                    if (z5) {
                        composerStartRestartGroup.startReplaceGroup(-1989544602);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "33@1260L281,43@1632L421,55@2153L6,56@2225L6,57@2301L6,58@2365L6,54@2094L305,32@1229L1180");
                        textStyle4 = boxMedium22;
                        AppBarKt.m2784TopAppBarGHTll3U(ComposableLambdaKt.rememberComposableLambda(220931847, true, new Function2() { // from class: com.box.android.base.presentation.components.topbar.simple.BoxSimpleTopBarKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxSimpleTopBarKt.BoxSimpleTopBar$lambda$0(title, boxMedium22, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), TestTagKt.testTag(companion, "BoxSimpleTopBar"), ComposableLambdaKt.rememberComposableLambda(-1127201723, true, new Function2() { // from class: com.box.android.base.presentation.components.topbar.simple.BoxSimpleTopBarKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxSimpleTopBarKt.BoxSimpleTopBar$lambda$1(onClose, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), null, 0.0f, null, TopAppBarDefaults.INSTANCE.m4782topAppBarColors5tl4gsc(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11572getTextFieldText0d7_KjU(), 0L, 0L, composerStartRestartGroup, TopAppBarDefaults.$stable << 18, 48), null, composerStartRestartGroup, 390, 184);
                        composerStartRestartGroup.endReplaceGroup();
                        composer2 = composerStartRestartGroup;
                    } else {
                        textStyle4 = boxMedium22;
                        composerStartRestartGroup.startReplaceGroup(-1988349118);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "62@2457L1254,62@2431L1280");
                        CustomRippleConfigurationKt.m11643CustomRippleConfiguration3JVO9M(0L, ComposableLambdaKt.rememberComposableLambda(1134741117, true, new Function2() { // from class: com.box.android.base.presentation.components.topbar.simple.BoxSimpleTopBarKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxSimpleTopBarKt.BoxSimpleTopBar$lambda$2(title, onClose, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, 48, 1);
                        composer2 = composerStartRestartGroup;
                        composer2.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = companion;
                    z4 = z5;
                    textStyle3 = textStyle4;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    z4 = z2;
                    textStyle3 = textStyle2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.topbar.simple.BoxSimpleTopBarKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxSimpleTopBarKt.BoxSimpleTopBar$lambda$3(title, onClose, modifier3, z4, textStyle3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            textStyle2 = textStyle;
            if ((i3 & 9363) != 9362) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                if (i8 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
                if (i6 != 0) {
                    boxMedium22 = BoxTheme.INSTANCE.getTypography().getBoxMedium22();
                } else {
                    boxMedium22 = textStyle2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-806553552, i3, -1, "com.box.android.base.presentation.components.topbar.simple.BoxSimpleTopBar (BoxSimpleTopBar.kt:30)");
                }
                if (z5) {
                    composerStartRestartGroup.startReplaceGroup(-1989544602);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "33@1260L281,43@1632L421,55@2153L6,56@2225L6,57@2301L6,58@2365L6,54@2094L305,32@1229L1180");
                    textStyle4 = boxMedium22;
                    AppBarKt.m2784TopAppBarGHTll3U(ComposableLambdaKt.rememberComposableLambda(220931847, true, new Function2() { // from class: com.box.android.base.presentation.components.topbar.simple.BoxSimpleTopBarKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxSimpleTopBarKt.BoxSimpleTopBar$lambda$0(title, boxMedium22, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), TestTagKt.testTag(companion, "BoxSimpleTopBar"), ComposableLambdaKt.rememberComposableLambda(-1127201723, true, new Function2() { // from class: com.box.android.base.presentation.components.topbar.simple.BoxSimpleTopBarKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxSimpleTopBarKt.BoxSimpleTopBar$lambda$1(onClose, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), null, 0.0f, null, TopAppBarDefaults.INSTANCE.m4782topAppBarColors5tl4gsc(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11572getTextFieldText0d7_KjU(), 0L, 0L, composerStartRestartGroup, TopAppBarDefaults.$stable << 18, 48), null, composerStartRestartGroup, 390, 184);
                    composerStartRestartGroup.endReplaceGroup();
                    composer2 = composerStartRestartGroup;
                } else {
                    textStyle4 = boxMedium22;
                    composerStartRestartGroup.startReplaceGroup(-1988349118);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "62@2457L1254,62@2431L1280");
                    CustomRippleConfigurationKt.m11643CustomRippleConfiguration3JVO9M(0L, ComposableLambdaKt.rememberComposableLambda(1134741117, true, new Function2() { // from class: com.box.android.base.presentation.components.topbar.simple.BoxSimpleTopBarKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxSimpleTopBarKt.BoxSimpleTopBar$lambda$2(title, onClose, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 48, 1);
                    composer2 = composerStartRestartGroup;
                    composer2.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = companion;
                z4 = z5;
                textStyle3 = textStyle4;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                z4 = z2;
                textStyle3 = textStyle2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.topbar.simple.BoxSimpleTopBarKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxSimpleTopBarKt.BoxSimpleTopBar$lambda$3(title, onClose, modifier3, z4, textStyle3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        z2 = z;
        i6 = i2 & 16;
        if (i6 != 0) {
            if ((i & 24576) == 0) {
                textStyle2 = textStyle;
                if (composerStartRestartGroup.changed(textStyle2)) {
                    i7 = 16384;
                } else {
                    i7 = 8192;
                }
                i3 |= i7;
            }
            if ((i3 & 9363) != 9362) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                if (i8 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
                if (i6 != 0) {
                    boxMedium22 = BoxTheme.INSTANCE.getTypography().getBoxMedium22();
                } else {
                    boxMedium22 = textStyle2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-806553552, i3, -1, "com.box.android.base.presentation.components.topbar.simple.BoxSimpleTopBar (BoxSimpleTopBar.kt:30)");
                }
                if (z5) {
                    composerStartRestartGroup.startReplaceGroup(-1989544602);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "33@1260L281,43@1632L421,55@2153L6,56@2225L6,57@2301L6,58@2365L6,54@2094L305,32@1229L1180");
                    textStyle4 = boxMedium22;
                    AppBarKt.m2784TopAppBarGHTll3U(ComposableLambdaKt.rememberComposableLambda(220931847, true, new Function2() { // from class: com.box.android.base.presentation.components.topbar.simple.BoxSimpleTopBarKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxSimpleTopBarKt.BoxSimpleTopBar$lambda$0(title, boxMedium22, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), TestTagKt.testTag(companion, "BoxSimpleTopBar"), ComposableLambdaKt.rememberComposableLambda(-1127201723, true, new Function2() { // from class: com.box.android.base.presentation.components.topbar.simple.BoxSimpleTopBarKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxSimpleTopBarKt.BoxSimpleTopBar$lambda$1(onClose, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), null, 0.0f, null, TopAppBarDefaults.INSTANCE.m4782topAppBarColors5tl4gsc(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11572getTextFieldText0d7_KjU(), 0L, 0L, composerStartRestartGroup, TopAppBarDefaults.$stable << 18, 48), null, composerStartRestartGroup, 390, 184);
                    composerStartRestartGroup.endReplaceGroup();
                    composer2 = composerStartRestartGroup;
                } else {
                    textStyle4 = boxMedium22;
                    composerStartRestartGroup.startReplaceGroup(-1988349118);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "62@2457L1254,62@2431L1280");
                    CustomRippleConfigurationKt.m11643CustomRippleConfiguration3JVO9M(0L, ComposableLambdaKt.rememberComposableLambda(1134741117, true, new Function2() { // from class: com.box.android.base.presentation.components.topbar.simple.BoxSimpleTopBarKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxSimpleTopBarKt.BoxSimpleTopBar$lambda$2(title, onClose, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 48, 1);
                    composer2 = composerStartRestartGroup;
                    composer2.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = companion;
                z4 = z5;
                textStyle3 = textStyle4;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                z4 = z2;
                textStyle3 = textStyle2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.topbar.simple.BoxSimpleTopBarKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxSimpleTopBarKt.BoxSimpleTopBar$lambda$3(title, onClose, modifier3, z4, textStyle3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        textStyle2 = textStyle;
        if ((i3 & 9363) != 9362) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            if (i8 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (i4 != 0) {
                z5 = false;
            } else {
                z5 = z2;
            }
            if (i6 != 0) {
                boxMedium22 = BoxTheme.INSTANCE.getTypography().getBoxMedium22();
            } else {
                boxMedium22 = textStyle2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-806553552, i3, -1, "com.box.android.base.presentation.components.topbar.simple.BoxSimpleTopBar (BoxSimpleTopBar.kt:30)");
            }
            if (z5) {
                composerStartRestartGroup.startReplaceGroup(-1989544602);
                ComposerKt.sourceInformation(composerStartRestartGroup, "33@1260L281,43@1632L421,55@2153L6,56@2225L6,57@2301L6,58@2365L6,54@2094L305,32@1229L1180");
                textStyle4 = boxMedium22;
                AppBarKt.m2784TopAppBarGHTll3U(ComposableLambdaKt.rememberComposableLambda(220931847, true, new Function2() { // from class: com.box.android.base.presentation.components.topbar.simple.BoxSimpleTopBarKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxSimpleTopBarKt.BoxSimpleTopBar$lambda$0(title, boxMedium22, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), TestTagKt.testTag(companion, "BoxSimpleTopBar"), ComposableLambdaKt.rememberComposableLambda(-1127201723, true, new Function2() { // from class: com.box.android.base.presentation.components.topbar.simple.BoxSimpleTopBarKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxSimpleTopBarKt.BoxSimpleTopBar$lambda$1(onClose, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), null, 0.0f, null, TopAppBarDefaults.INSTANCE.m4782topAppBarColors5tl4gsc(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11498getAppBackground0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11500getAppPrimary0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11572getTextFieldText0d7_KjU(), 0L, 0L, composerStartRestartGroup, TopAppBarDefaults.$stable << 18, 48), null, composerStartRestartGroup, 390, 184);
                composerStartRestartGroup.endReplaceGroup();
                composer2 = composerStartRestartGroup;
            } else {
                textStyle4 = boxMedium22;
                composerStartRestartGroup.startReplaceGroup(-1988349118);
                ComposerKt.sourceInformation(composerStartRestartGroup, "62@2457L1254,62@2431L1280");
                CustomRippleConfigurationKt.m11643CustomRippleConfiguration3JVO9M(0L, ComposableLambdaKt.rememberComposableLambda(1134741117, true, new Function2() { // from class: com.box.android.base.presentation.components.topbar.simple.BoxSimpleTopBarKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxSimpleTopBarKt.BoxSimpleTopBar$lambda$2(title, onClose, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 48, 1);
                composer2 = composerStartRestartGroup;
                composer2.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = companion;
            z4 = z5;
            textStyle3 = textStyle4;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
            z4 = z2;
            textStyle3 = textStyle2;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.topbar.simple.BoxSimpleTopBarKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxSimpleTopBarKt.BoxSimpleTopBar$lambda$3(title, onClose, modifier3, z4, textStyle3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxSimpleTopBar$lambda$0(String str, TextStyle textStyle, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C34@1278L249:BoxSimpleTopBar.kt#osoi5s");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(220931847, i, -1, "com.box.android.base.presentation.components.topbar.simple.BoxSimpleTopBar.<anonymous> (BoxSimpleTopBar.kt:34)");
            }
            TextKt.m4494TextNvy7gAk(str, TestTagKt.testTag(Modifier.INSTANCE, "Toolbar:Title"), 0L, null, 0L, null, null, null, 0L, null, null, 0L, TextOverflow.INSTANCE.m9584getEllipsisgIe3tQ8(), false, 1, 0, null, textStyle, composer, 48, 24960, 110588);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxSimpleTopBar$lambda$1(Function0 function0, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C44@1650L389:BoxSimpleTopBar.kt#osoi5s");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1127201723, i, -1, "com.box.android.base.presentation.components.topbar.simple.BoxSimpleTopBar.<anonymous> (BoxSimpleTopBar.kt:44)");
            }
            IconButtonKt.IconButton((Function0<Unit>) function0, TestTagKt.testTag(Modifier.INSTANCE, "Toolbar:NavigationBack"), false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$BoxSimpleTopBarKt.INSTANCE.m11856getLambda$2044380569$base_generalProdRelease(), composer, 1572912, 60);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxSimpleTopBar$lambda$2$1(Function0 function0, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C65@2537L560:BoxSimpleTopBar.kt#osoi5s");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2044621763, i, -1, "com.box.android.base.presentation.components.topbar.simple.BoxSimpleTopBar.<anonymous>.<anonymous> (BoxSimpleTopBar.kt:65)");
            }
            IconButtonKt.IconButton((Function0<Unit>) function0, TestTagKt.testTag(Modifier.INSTANCE, "Toolbar:NavigationBack"), false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$BoxSimpleTopBarKt.INSTANCE.m11857getLambda$222343199$base_generalProdRelease(), composer, 1572912, 60);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxSimpleTopBar$lambda$2$0(String str, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C80@3215L10,79@3163L133:BoxSimpleTopBar.kt#osoi5s");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1691965249, i, -1, "com.box.android.base.presentation.components.topbar.simple.BoxSimpleTopBar.<anonymous>.<anonymous> (BoxSimpleTopBar.kt:79)");
            }
            TextKt.m4494TextNvy7gAk(str, null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getTitleLarge(), composer, 0, 0, 131070);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxSimpleTopBar$lambda$2(final String str, final Function0 function0, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C85@3422L6,86@3501L6,87@3584L6,88@3652L6,84@3359L328,78@3141L173,64@2515L600,63@2471L1230:BoxSimpleTopBar.kt#osoi5s");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1134741117, i, -1, "com.box.android.base.presentation.components.topbar.simple.BoxSimpleTopBar.<anonymous> (BoxSimpleTopBar.kt:63)");
            }
            AppBarKt.m2784TopAppBarGHTll3U(ComposableLambdaKt.rememberComposableLambda(1691965249, true, new Function2() { // from class: com.box.android.base.presentation.components.topbar.simple.BoxSimpleTopBarKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxSimpleTopBarKt.BoxSimpleTopBar$lambda$2$0(str, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, ComposableLambdaKt.rememberComposableLambda(2044621763, true, new Function2() { // from class: com.box.android.base.presentation.components.topbar.simple.BoxSimpleTopBarKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxSimpleTopBarKt.BoxSimpleTopBar$lambda$2$1(function0, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, 0.0f, null, TopAppBarDefaults.INSTANCE.m4782topAppBarColors5tl4gsc(BoxTheme.INSTANCE.getColors(composer, 6).m11575getTopBarBackground0d7_KjU(), BoxTheme.INSTANCE.getColors(composer, 6).m11575getTopBarBackground0d7_KjU(), BoxTheme.INSTANCE.getColors(composer, 6).m11579getTopBarText0d7_KjU(), BoxTheme.INSTANCE.getColors(composer, 6).m11579getTopBarText0d7_KjU(), 0L, 0L, composer, TopAppBarDefaults.$stable << 18, 48), null, composer, 390, ContextualToolbar.DRAG_BUTTON_ALPHA);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final void BoxSimpleTopBarPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(435417214);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxSimpleTopBarPreview)100@3847L146:BoxSimpleTopBar.kt#osoi5s");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(435417214, i, -1, "com.box.android.base.presentation.components.topbar.simple.BoxSimpleTopBarPreview (BoxSimpleTopBar.kt:99)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$BoxSimpleTopBarKt.INSTANCE.m11855getLambda$1566857783$base_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.presentation.components.topbar.simple.BoxSimpleTopBarKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxSimpleTopBarKt.BoxSimpleTopBarPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}

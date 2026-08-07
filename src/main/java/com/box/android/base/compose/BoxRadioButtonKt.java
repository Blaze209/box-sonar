package com.box.android.base.compose;

import androidx.compose.material3.RadioButtonDefaults;
import androidx.compose.material3.RadioButtonKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;

/* JADX INFO: compiled from: BoxRadioButton.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000\"\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a?\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u00072\b\b\u0002\u0010\b\u001a\u00020\tH\u0007¢\u0006\u0004\b\n\u0010\u000b\u001a\r\u0010\f\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\r¨\u0006\u000e"}, d2 = {"BoxRadioButton", "", "modifier", "Landroidx/compose/ui/Modifier;", "selected", "", ViewProps.ON_CLICK, "Lkotlin/Function0;", "backgroundColor", "Landroidx/compose/ui/graphics/Color;", "BoxRadioButton-ww6aTOc", "(Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function0;JLandroidx/compose/runtime/Composer;II)V", "BoxRadioButtonPreview", "(Landroidx/compose/runtime/Composer;I)V", "base_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BoxRadioButtonKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxRadioButtonPreview$lambda$0(int i, Composer composer, int i2) {
        BoxRadioButtonPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxRadioButton_ww6aTOc$lambda$0(Modifier modifier, boolean z, Function0 function0, long j, int i, int i2, Composer composer, int i3) {
        m11605BoxRadioButtonww6aTOc(modifier, z, function0, j, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
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
    /* JADX WARN: Code duplicated, block: B:48:0x0088  */
    /* JADX WARN: Code duplicated, block: B:49:0x008a  */
    /* JADX WARN: Code duplicated, block: B:52:0x0093  */
    /* JADX WARN: Code duplicated, block: B:54:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:61:0x00b3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:62:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:63:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:66:0x00be  */
    /* JADX WARN: Code duplicated, block: B:68:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:75:0x00df  */
    /* JADX WARN: Code duplicated, block: B:78:0x0139  */
    /* JADX WARN: Code duplicated, block: B:80:0x0141  */
    /* JADX WARN: Code duplicated, block: B:83:0x0150  */
    /* JADX WARN: Code duplicated, block: B:85:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: BoxRadioButton-ww6aTOc, reason: not valid java name */
    public static final void m11605BoxRadioButtonww6aTOc(Modifier modifier, boolean z, Function0<Unit> function0, long j, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        boolean z2;
        int i4;
        Function0<Unit> function1;
        int i5;
        long jM11530getItemListingContentBackground0d7_KjU;
        boolean z3;
        Composer composer2;
        final Modifier modifier3;
        final boolean z4;
        final long j2;
        final Function0<Unit> function2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        Function0<Unit> function3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-649631106);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxRadioButton)N(modifier,selected,onClick,backgroundColor:c#ui.graphics.Color)27@962L6,28@1027L6,26@917L251,22@782L392:BoxRadioButton.kt#vejmn0");
        int i6 = i2 & 1;
        if (i6 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        int i7 = i2 & 2;
        if (i7 == 0) {
            if ((i & 48) == 0) {
                z2 = z;
                i3 |= composerStartRestartGroup.changed(z2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    function1 = function0;
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        jM11530getItemListingContentBackground0d7_KjU = j;
                        int i8 = composerStartRestartGroup.changed(jM11530getItemListingContentBackground0d7_KjU) ? 2048 : 1024;
                        i3 |= i8;
                    } else {
                        jM11530getItemListingContentBackground0d7_KjU = j;
                    }
                    i3 |= i8;
                } else {
                    jM11530getItemListingContentBackground0d7_KjU = j;
                }
                if ((i3 & 1171) != 1170) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "20@738L6");
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i6 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        boolean z5 = i7 == 0 ? z2 : true;
                        if (i4 != 0) {
                            function1 = null;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            jM11530getItemListingContentBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11530getItemListingContentBackground0d7_KjU();
                        }
                        function3 = function1;
                        z2 = z5;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                        }
                        companion = modifier2;
                        function3 = function1;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-649631106, i3, -1, "com.box.android.base.compose.BoxRadioButton (BoxRadioButton.kt:21)");
                    }
                    int i9 = i3 >> 3;
                    composer2 = composerStartRestartGroup;
                    long j3 = jM11530getItemListingContentBackground0d7_KjU;
                    Modifier modifier4 = companion;
                    function1 = function3;
                    boolean z6 = z2;
                    RadioButtonKt.RadioButton(z6, function1, modifier4, false, RadioButtonDefaults.INSTANCE.m4018colorsro_MJ88(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11513getContentSecondary0d7_KjU(), j3, j3, composer2, (i9 & 896) | (i3 & 7168) | (RadioButtonDefaults.$stable << 12), 0), null, composer2, (i9 & 126) | ((i3 << 6) & 896), 40);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z4 = z6;
                    modifier3 = modifier4;
                    j2 = j3;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    z4 = z2;
                    j2 = jM11530getItemListingContentBackground0d7_KjU;
                }
                function2 = function1;
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.BoxRadioButtonKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxRadioButtonKt.BoxRadioButton_ww6aTOc$lambda$0(modifier3, z4, function2, j2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 384;
            function1 = function0;
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    jM11530getItemListingContentBackground0d7_KjU = j;
                    if (composerStartRestartGroup.changed(jM11530getItemListingContentBackground0d7_KjU)) {
                    }
                    i3 |= i8;
                } else {
                    jM11530getItemListingContentBackground0d7_KjU = j;
                }
                i3 |= i8;
            } else {
                jM11530getItemListingContentBackground0d7_KjU = j;
            }
            if ((i3 & 1171) != 1170) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "20@738L6");
                if ((i & 1) != 0) {
                    if (i6 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i7 == 0) {
                    }
                    if (i4 != 0) {
                        function1 = null;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        jM11530getItemListingContentBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11530getItemListingContentBackground0d7_KjU();
                    }
                    function3 = function1;
                    z2 = z5;
                } else {
                    if (i6 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i7 == 0) {
                    }
                    if (i4 != 0) {
                        function1 = null;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        jM11530getItemListingContentBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11530getItemListingContentBackground0d7_KjU();
                    }
                    function3 = function1;
                    z2 = z5;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-649631106, i3, -1, "com.box.android.base.compose.BoxRadioButton (BoxRadioButton.kt:21)");
                }
                int i10 = i3 >> 3;
                composer2 = composerStartRestartGroup;
                long j4 = jM11530getItemListingContentBackground0d7_KjU;
                Modifier modifier5 = companion;
                function1 = function3;
                boolean z7 = z2;
                RadioButtonKt.RadioButton(z7, function1, modifier5, false, RadioButtonDefaults.INSTANCE.m4018colorsro_MJ88(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11513getContentSecondary0d7_KjU(), j4, j4, composer2, (i10 & 896) | (i3 & 7168) | (RadioButtonDefaults.$stable << 12), 0), null, composer2, (i10 & 126) | ((i3 << 6) & 896), 40);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z4 = z7;
                modifier3 = modifier5;
                j2 = j4;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                z4 = z2;
                j2 = jM11530getItemListingContentBackground0d7_KjU;
            }
            function2 = function1;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.BoxRadioButtonKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxRadioButtonKt.BoxRadioButton_ww6aTOc$lambda$0(modifier3, z4, function2, j2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        z2 = z;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 384) == 0) {
                function1 = function0;
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    jM11530getItemListingContentBackground0d7_KjU = j;
                    if (composerStartRestartGroup.changed(jM11530getItemListingContentBackground0d7_KjU)) {
                    }
                    i3 |= i8;
                } else {
                    jM11530getItemListingContentBackground0d7_KjU = j;
                }
                i3 |= i8;
            } else {
                jM11530getItemListingContentBackground0d7_KjU = j;
            }
            if ((i3 & 1171) != 1170) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "20@738L6");
                if ((i & 1) != 0) {
                    if (i6 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i7 == 0) {
                    }
                    if (i4 != 0) {
                        function1 = null;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        jM11530getItemListingContentBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11530getItemListingContentBackground0d7_KjU();
                    }
                    function3 = function1;
                    z2 = z5;
                } else {
                    if (i6 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i7 == 0) {
                    }
                    if (i4 != 0) {
                        function1 = null;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        jM11530getItemListingContentBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11530getItemListingContentBackground0d7_KjU();
                    }
                    function3 = function1;
                    z2 = z5;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-649631106, i3, -1, "com.box.android.base.compose.BoxRadioButton (BoxRadioButton.kt:21)");
                }
                int i11 = i3 >> 3;
                composer2 = composerStartRestartGroup;
                long j5 = jM11530getItemListingContentBackground0d7_KjU;
                Modifier modifier6 = companion;
                function1 = function3;
                boolean z8 = z2;
                RadioButtonKt.RadioButton(z8, function1, modifier6, false, RadioButtonDefaults.INSTANCE.m4018colorsro_MJ88(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11513getContentSecondary0d7_KjU(), j5, j5, composer2, (i11 & 896) | (i3 & 7168) | (RadioButtonDefaults.$stable << 12), 0), null, composer2, (i11 & 126) | ((i3 << 6) & 896), 40);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z4 = z8;
                modifier3 = modifier6;
                j2 = j5;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                z4 = z2;
                j2 = jM11530getItemListingContentBackground0d7_KjU;
            }
            function2 = function1;
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.BoxRadioButtonKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxRadioButtonKt.BoxRadioButton_ww6aTOc$lambda$0(modifier3, z4, function2, j2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        function1 = function0;
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                jM11530getItemListingContentBackground0d7_KjU = j;
                if (composerStartRestartGroup.changed(jM11530getItemListingContentBackground0d7_KjU)) {
                }
                i3 |= i8;
            } else {
                jM11530getItemListingContentBackground0d7_KjU = j;
            }
            i3 |= i8;
        } else {
            jM11530getItemListingContentBackground0d7_KjU = j;
        }
        if ((i3 & 1171) != 1170) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "20@738L6");
            if ((i & 1) != 0) {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i7 == 0) {
                }
                if (i4 != 0) {
                    function1 = null;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    jM11530getItemListingContentBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11530getItemListingContentBackground0d7_KjU();
                }
                function3 = function1;
                z2 = z5;
            } else {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i7 == 0) {
                }
                if (i4 != 0) {
                    function1 = null;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    jM11530getItemListingContentBackground0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11530getItemListingContentBackground0d7_KjU();
                }
                function3 = function1;
                z2 = z5;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-649631106, i3, -1, "com.box.android.base.compose.BoxRadioButton (BoxRadioButton.kt:21)");
            }
            int i12 = i3 >> 3;
            composer2 = composerStartRestartGroup;
            long j6 = jM11530getItemListingContentBackground0d7_KjU;
            Modifier modifier7 = companion;
            function1 = function3;
            boolean z9 = z2;
            RadioButtonKt.RadioButton(z9, function1, modifier7, false, RadioButtonDefaults.INSTANCE.m4018colorsro_MJ88(BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11513getContentSecondary0d7_KjU(), j6, j6, composer2, (i12 & 896) | (i3 & 7168) | (RadioButtonDefaults.$stable << 12), 0), null, composer2, (i12 & 126) | ((i3 << 6) & 896), 40);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z4 = z9;
            modifier3 = modifier7;
            j2 = j6;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
            z4 = z2;
            j2 = jM11530getItemListingContentBackground0d7_KjU;
        }
        function2 = function1;
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.BoxRadioButtonKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxRadioButtonKt.BoxRadioButton_ww6aTOc$lambda$0(modifier3, z4, function2, j2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void BoxRadioButtonPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(848502780);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxRadioButtonPreview)38@1250L114:BoxRadioButton.kt#vejmn0");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(848502780, i, -1, "com.box.android.base.compose.BoxRadioButtonPreview (BoxRadioButton.kt:37)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$BoxRadioButtonKt.INSTANCE.m11617getLambda$875904697$base_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.BoxRadioButtonKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxRadioButtonKt.BoxRadioButtonPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}

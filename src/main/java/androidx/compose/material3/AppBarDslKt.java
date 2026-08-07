package androidx.compose.material3;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.material3.internal.Icons;
import androidx.compose.material3.internal.Strings;
import androidx.compose.material3.internal.Strings_androidKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.runtime.saveable.Saver;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.profileinstaller.ProfileVerifier;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;

/* JADX INFO: compiled from: AppBarDsl.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0001¢\u0006\u0002\u0010\u0002\u001aI\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0007¢\u0006\u0002\u0010\u0011¨\u0006\u0012"}, d2 = {"rememberAppBarOverflowState", "Landroidx/compose/material3/AppBarOverflowState;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/material3/AppBarOverflowState;", "AppBarOverflowIndicator", "", "menuState", "Landroidx/compose/material3/AppBarMenuState;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/IconButtonColors;", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Landroidx/compose/material3/AppBarMenuState;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/IconButtonColors;Landroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/runtime/Composer;II)V", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AppBarDslKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AppBarOverflowIndicator$lambda$2(AppBarMenuState appBarMenuState, Modifier modifier, boolean z, Shape shape, IconButtonColors iconButtonColors, MutableInteractionSource mutableInteractionSource, int i, int i2, Composer composer, int i3) {
        AppBarOverflowIndicator(appBarMenuState, modifier, z, shape, iconButtonColors, mutableInteractionSource, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    public static final AppBarOverflowState rememberAppBarOverflowState(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 209837519, "C(rememberAppBarOverflowState)276@8580L29,276@8524L85:AppBarDsl.kt#uh7d8r");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(209837519, i, -1, "androidx.compose.material3.rememberAppBarOverflowState (AppBarDsl.kt:275)");
        }
        Object[] objArr = new Object[0];
        Saver<AppBarOverflowStateImpl, ?> saver = AppBarOverflowStateImpl.INSTANCE.getSaver();
        ComposerKt.sourceInformationMarkerStart(composer, -209603156, "CC(remember):AppBarDsl.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: androidx.compose.material3.AppBarDslKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return AppBarDslKt.rememberAppBarOverflowState$lambda$0$0();
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        AppBarOverflowStateImpl appBarOverflowStateImpl = (AppBarOverflowStateImpl) RememberSaveableKt.m6247rememberSaveable(objArr, (Saver) saver, (Function0) objRememberedValue, composer, 384);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return appBarOverflowStateImpl;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final AppBarOverflowStateImpl rememberAppBarOverflowState$lambda$0$0() {
        return new AppBarOverflowStateImpl();
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0125  */
    /* JADX WARN: Code duplicated, block: B:103:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:105:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:108:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:110:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0042  */
    /* JADX WARN: Code duplicated, block: B:24:0x0045  */
    /* JADX WARN: Code duplicated, block: B:26:0x0049  */
    /* JADX WARN: Code duplicated, block: B:28:0x0051  */
    /* JADX WARN: Code duplicated, block: B:29:0x0054  */
    /* JADX WARN: Code duplicated, block: B:34:0x005e  */
    /* JADX WARN: Code duplicated, block: B:36:0x0062  */
    /* JADX WARN: Code duplicated, block: B:38:0x006a  */
    /* JADX WARN: Code duplicated, block: B:39:0x006d  */
    /* JADX WARN: Code duplicated, block: B:42:0x0073  */
    /* JADX WARN: Code duplicated, block: B:45:0x0079  */
    /* JADX WARN: Code duplicated, block: B:47:0x007d  */
    /* JADX WARN: Code duplicated, block: B:49:0x0085  */
    /* JADX WARN: Code duplicated, block: B:50:0x0088  */
    /* JADX WARN: Code duplicated, block: B:53:0x008e  */
    /* JADX WARN: Code duplicated, block: B:56:0x0096  */
    /* JADX WARN: Code duplicated, block: B:57:0x0098  */
    /* JADX WARN: Code duplicated, block: B:59:0x009b  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:62:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:68:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:83:0x00eb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:84:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:87:0x00f5  */
    /* JADX WARN: Code duplicated, block: B:90:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:93:0x0108  */
    /* JADX WARN: Code duplicated, block: B:95:0x0112  */
    /* JADX WARN: Code duplicated, block: B:96:0x0117  */
    public static final void AppBarOverflowIndicator(final AppBarMenuState appBarMenuState, Modifier modifier, boolean z, Shape shape, IconButtonColors iconButtonColors, MutableInteractionSource mutableInteractionSource, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        final boolean z2;
        int i5;
        final Shape standardShape;
        IconButtonColors iconButtonColors2;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        int i7;
        boolean z3;
        Composer composer2;
        final Modifier modifier3;
        final boolean z4;
        final Shape shape2;
        final IconButtonColors iconButtonColors3;
        final MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        final MutableInteractionSource mutableInteractionSource4;
        final IconButtonColors iconButtonColors4;
        final Modifier modifier4;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1914581769);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AppBarOverflowIndicator)N(menuState,modifier,enabled,shape,colors,interactionSource)441@15326L45,445@15444L60,446@15524L45,447@15587L22,448@15617L548,443@15377L788:AppBarDsl.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(appBarMenuState) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i8 = i2 & 2;
        if (i8 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        standardShape = shape;
                        int i9 = composerStartRestartGroup.changed(standardShape) ? 2048 : 1024;
                        i3 |= i9;
                    } else {
                        standardShape = shape;
                    }
                    i3 |= i9;
                } else {
                    standardShape = shape;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        iconButtonColors2 = iconButtonColors;
                        int i10 = composerStartRestartGroup.changed(iconButtonColors2) ? 16384 : 8192;
                        i3 |= i10;
                    } else {
                        iconButtonColors2 = iconButtonColors;
                    }
                    i3 |= i10;
                } else {
                    iconButtonColors2 = iconButtonColors;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    if ((196608 & i) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                            i7 = 131072;
                        } else {
                            i7 = 65536;
                        }
                        i3 |= i7;
                    }
                    if ((74899 & i3) != 74898) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "437@15151L13,438@15216L18");
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i8 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                                standardShape = IconButtonDefaults.INSTANCE.getStandardShape(composerStartRestartGroup, 6);
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                iconButtonColors2 = IconButtonDefaults.INSTANCE.iconButtonColors(composerStartRestartGroup, 6);
                            }
                            if (i6 != 0) {
                                mutableInteractionSource4 = null;
                            } else {
                                mutableInteractionSource4 = mutableInteractionSource2;
                            }
                            iconButtonColors4 = iconButtonColors2;
                            modifier4 = companion;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                            }
                            z2 = z2;
                            standardShape = standardShape;
                            mutableInteractionSource4 = mutableInteractionSource2;
                            iconButtonColors4 = iconButtonColors2;
                            modifier4 = modifier2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1914581769, i3, -1, "androidx.compose.material3.AppBarOverflowIndicator (AppBarDsl.kt:440)");
                        }
                        Strings.Companion companion2 = Strings.INSTANCE;
                        final String strM5086getString2EP1pXo = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_floating_toolbar_more_options), composerStartRestartGroup, 0);
                        Modifier modifier5 = modifier4;
                        boolean z5 = z2;
                        IconButtonColors iconButtonColors5 = iconButtonColors4;
                        MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource4;
                        Shape shape3 = standardShape;
                        composer2 = composerStartRestartGroup;
                        TooltipKt.TooltipBox(TooltipDefaults.INSTANCE.m4738rememberTooltipPositionProviderHu5FAss(TooltipAnchorPosition.INSTANCE.m4725getAbovelOKsHw4(), 0.0f, composerStartRestartGroup, 390, 2), ComposableLambdaKt.rememberComposableLambda(-1648759198, true, new Function3() { // from class: androidx.compose.material3.AppBarDslKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function3
                            public final Object invoke(Object obj, Object obj2, Object obj3) {
                                return AppBarDslKt.AppBarOverflowIndicator$lambda$0(strM5086getString2EP1pXo, (TooltipScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                            }
                        }, composerStartRestartGroup, 54), TooltipKt.rememberTooltipState(false, false, null, composerStartRestartGroup, 0, 7), null, null, false, false, false, ComposableLambdaKt.rememberComposableLambda(-67358598, true, new Function2() { // from class: androidx.compose.material3.AppBarDslKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AppBarDslKt.AppBarOverflowIndicator$lambda$1(appBarMenuState, modifier4, z2, iconButtonColors4, mutableInteractionSource4, standardShape, strM5086getString2EP1pXo, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composer2, 100663344, 248);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier5;
                        z4 = z5;
                        shape2 = shape3;
                        iconButtonColors3 = iconButtonColors5;
                        mutableInteractionSource3 = mutableInteractionSource5;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier3 = modifier2;
                        z4 = z2;
                        shape2 = standardShape;
                        iconButtonColors3 = iconButtonColors2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AppBarDslKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AppBarDslKt.AppBarOverflowIndicator$lambda$2(appBarMenuState, modifier3, z4, shape2, iconButtonColors3, mutableInteractionSource3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((74899 & i3) != 74898) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "437@15151L13,438@15216L18");
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            standardShape = IconButtonDefaults.INSTANCE.getStandardShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            iconButtonColors2 = IconButtonDefaults.INSTANCE.iconButtonColors(composerStartRestartGroup, 6);
                        }
                        if (i6 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        iconButtonColors4 = iconButtonColors2;
                        modifier4 = companion;
                    } else {
                        if (i8 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            standardShape = IconButtonDefaults.INSTANCE.getStandardShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            iconButtonColors2 = IconButtonDefaults.INSTANCE.iconButtonColors(composerStartRestartGroup, 6);
                        }
                        if (i6 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        iconButtonColors4 = iconButtonColors2;
                        modifier4 = companion;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1914581769, i3, -1, "androidx.compose.material3.AppBarOverflowIndicator (AppBarDsl.kt:440)");
                    }
                    Strings.Companion companion3 = Strings.INSTANCE;
                    final String strM5086getString2EP1pXo2 = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_floating_toolbar_more_options), composerStartRestartGroup, 0);
                    Modifier modifier6 = modifier4;
                    boolean z6 = z2;
                    IconButtonColors iconButtonColors6 = iconButtonColors4;
                    MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource4;
                    Shape shape4 = standardShape;
                    composer2 = composerStartRestartGroup;
                    TooltipKt.TooltipBox(TooltipDefaults.INSTANCE.m4738rememberTooltipPositionProviderHu5FAss(TooltipAnchorPosition.INSTANCE.m4725getAbovelOKsHw4(), 0.0f, composerStartRestartGroup, 390, 2), ComposableLambdaKt.rememberComposableLambda(-1648759198, true, new Function3() { // from class: androidx.compose.material3.AppBarDslKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return AppBarDslKt.AppBarOverflowIndicator$lambda$0(strM5086getString2EP1pXo2, (TooltipScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), TooltipKt.rememberTooltipState(false, false, null, composerStartRestartGroup, 0, 7), null, null, false, false, false, ComposableLambdaKt.rememberComposableLambda(-67358598, true, new Function2() { // from class: androidx.compose.material3.AppBarDslKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AppBarDslKt.AppBarOverflowIndicator$lambda$1(appBarMenuState, modifier4, z2, iconButtonColors4, mutableInteractionSource4, standardShape, strM5086getString2EP1pXo2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, 100663344, 248);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier6;
                    z4 = z6;
                    shape2 = shape4;
                    iconButtonColors3 = iconButtonColors6;
                    mutableInteractionSource3 = mutableInteractionSource6;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    z4 = z2;
                    shape2 = standardShape;
                    iconButtonColors3 = iconButtonColors2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AppBarDslKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AppBarDslKt.AppBarOverflowIndicator$lambda$2(appBarMenuState, modifier3, z4, shape2, iconButtonColors3, mutableInteractionSource3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 384;
            z2 = z;
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    standardShape = shape;
                    if (composerStartRestartGroup.changed(standardShape)) {
                    }
                    i3 |= i9;
                } else {
                    standardShape = shape;
                }
                i3 |= i9;
            } else {
                standardShape = shape;
            }
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    iconButtonColors2 = iconButtonColors;
                    if (composerStartRestartGroup.changed(iconButtonColors2)) {
                    }
                    i3 |= i10;
                } else {
                    iconButtonColors2 = iconButtonColors;
                }
                i3 |= i10;
            } else {
                iconButtonColors2 = iconButtonColors;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((196608 & i) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                if ((74899 & i3) != 74898) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "437@15151L13,438@15216L18");
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            standardShape = IconButtonDefaults.INSTANCE.getStandardShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            iconButtonColors2 = IconButtonDefaults.INSTANCE.iconButtonColors(composerStartRestartGroup, 6);
                        }
                        if (i6 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        iconButtonColors4 = iconButtonColors2;
                        modifier4 = companion;
                    } else {
                        if (i8 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            standardShape = IconButtonDefaults.INSTANCE.getStandardShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            iconButtonColors2 = IconButtonDefaults.INSTANCE.iconButtonColors(composerStartRestartGroup, 6);
                        }
                        if (i6 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        iconButtonColors4 = iconButtonColors2;
                        modifier4 = companion;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1914581769, i3, -1, "androidx.compose.material3.AppBarOverflowIndicator (AppBarDsl.kt:440)");
                    }
                    Strings.Companion companion4 = Strings.INSTANCE;
                    final String strM5086getString2EP1pXo3 = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_floating_toolbar_more_options), composerStartRestartGroup, 0);
                    Modifier modifier7 = modifier4;
                    boolean z7 = z2;
                    IconButtonColors iconButtonColors7 = iconButtonColors4;
                    MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource4;
                    Shape shape5 = standardShape;
                    composer2 = composerStartRestartGroup;
                    TooltipKt.TooltipBox(TooltipDefaults.INSTANCE.m4738rememberTooltipPositionProviderHu5FAss(TooltipAnchorPosition.INSTANCE.m4725getAbovelOKsHw4(), 0.0f, composerStartRestartGroup, 390, 2), ComposableLambdaKt.rememberComposableLambda(-1648759198, true, new Function3() { // from class: androidx.compose.material3.AppBarDslKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return AppBarDslKt.AppBarOverflowIndicator$lambda$0(strM5086getString2EP1pXo3, (TooltipScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), TooltipKt.rememberTooltipState(false, false, null, composerStartRestartGroup, 0, 7), null, null, false, false, false, ComposableLambdaKt.rememberComposableLambda(-67358598, true, new Function2() { // from class: androidx.compose.material3.AppBarDslKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AppBarDslKt.AppBarOverflowIndicator$lambda$1(appBarMenuState, modifier4, z2, iconButtonColors4, mutableInteractionSource4, standardShape, strM5086getString2EP1pXo3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, 100663344, 248);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier7;
                    z4 = z7;
                    shape2 = shape5;
                    iconButtonColors3 = iconButtonColors7;
                    mutableInteractionSource3 = mutableInteractionSource7;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    z4 = z2;
                    shape2 = standardShape;
                    iconButtonColors3 = iconButtonColors2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AppBarDslKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AppBarDslKt.AppBarOverflowIndicator$lambda$2(appBarMenuState, modifier3, z4, shape2, iconButtonColors3, mutableInteractionSource3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((74899 & i3) != 74898) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "437@15151L13,438@15216L18");
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        standardShape = IconButtonDefaults.INSTANCE.getStandardShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        iconButtonColors2 = IconButtonDefaults.INSTANCE.iconButtonColors(composerStartRestartGroup, 6);
                    }
                    if (i6 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    iconButtonColors4 = iconButtonColors2;
                    modifier4 = companion;
                } else {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        standardShape = IconButtonDefaults.INSTANCE.getStandardShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        iconButtonColors2 = IconButtonDefaults.INSTANCE.iconButtonColors(composerStartRestartGroup, 6);
                    }
                    if (i6 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    iconButtonColors4 = iconButtonColors2;
                    modifier4 = companion;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1914581769, i3, -1, "androidx.compose.material3.AppBarOverflowIndicator (AppBarDsl.kt:440)");
                }
                Strings.Companion companion5 = Strings.INSTANCE;
                final String strM5086getString2EP1pXo4 = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_floating_toolbar_more_options), composerStartRestartGroup, 0);
                Modifier modifier8 = modifier4;
                boolean z8 = z2;
                IconButtonColors iconButtonColors8 = iconButtonColors4;
                MutableInteractionSource mutableInteractionSource8 = mutableInteractionSource4;
                Shape shape6 = standardShape;
                composer2 = composerStartRestartGroup;
                TooltipKt.TooltipBox(TooltipDefaults.INSTANCE.m4738rememberTooltipPositionProviderHu5FAss(TooltipAnchorPosition.INSTANCE.m4725getAbovelOKsHw4(), 0.0f, composerStartRestartGroup, 390, 2), ComposableLambdaKt.rememberComposableLambda(-1648759198, true, new Function3() { // from class: androidx.compose.material3.AppBarDslKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return AppBarDslKt.AppBarOverflowIndicator$lambda$0(strM5086getString2EP1pXo4, (TooltipScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), TooltipKt.rememberTooltipState(false, false, null, composerStartRestartGroup, 0, 7), null, null, false, false, false, ComposableLambdaKt.rememberComposableLambda(-67358598, true, new Function2() { // from class: androidx.compose.material3.AppBarDslKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AppBarDslKt.AppBarOverflowIndicator$lambda$1(appBarMenuState, modifier4, z2, iconButtonColors4, mutableInteractionSource4, standardShape, strM5086getString2EP1pXo4, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, 100663344, 248);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier8;
                z4 = z8;
                shape2 = shape6;
                iconButtonColors3 = iconButtonColors8;
                mutableInteractionSource3 = mutableInteractionSource8;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                z4 = z2;
                shape2 = standardShape;
                iconButtonColors3 = iconButtonColors2;
                mutableInteractionSource3 = mutableInteractionSource2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AppBarDslKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AppBarDslKt.AppBarOverflowIndicator$lambda$2(appBarMenuState, modifier3, z4, shape2, iconButtonColors3, mutableInteractionSource3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 384) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    standardShape = shape;
                    if (composerStartRestartGroup.changed(standardShape)) {
                    }
                    i3 |= i9;
                } else {
                    standardShape = shape;
                }
                i3 |= i9;
            } else {
                standardShape = shape;
            }
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    iconButtonColors2 = iconButtonColors;
                    if (composerStartRestartGroup.changed(iconButtonColors2)) {
                    }
                    i3 |= i10;
                } else {
                    iconButtonColors2 = iconButtonColors;
                }
                i3 |= i10;
            } else {
                iconButtonColors2 = iconButtonColors;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((196608 & i) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                if ((74899 & i3) != 74898) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "437@15151L13,438@15216L18");
                    if ((i & 1) != 0) {
                        if (i8 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            standardShape = IconButtonDefaults.INSTANCE.getStandardShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            iconButtonColors2 = IconButtonDefaults.INSTANCE.iconButtonColors(composerStartRestartGroup, 6);
                        }
                        if (i6 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        iconButtonColors4 = iconButtonColors2;
                        modifier4 = companion;
                    } else {
                        if (i8 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            standardShape = IconButtonDefaults.INSTANCE.getStandardShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            iconButtonColors2 = IconButtonDefaults.INSTANCE.iconButtonColors(composerStartRestartGroup, 6);
                        }
                        if (i6 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        iconButtonColors4 = iconButtonColors2;
                        modifier4 = companion;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1914581769, i3, -1, "androidx.compose.material3.AppBarOverflowIndicator (AppBarDsl.kt:440)");
                    }
                    Strings.Companion companion6 = Strings.INSTANCE;
                    final String strM5086getString2EP1pXo5 = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_floating_toolbar_more_options), composerStartRestartGroup, 0);
                    Modifier modifier9 = modifier4;
                    boolean z9 = z2;
                    IconButtonColors iconButtonColors9 = iconButtonColors4;
                    MutableInteractionSource mutableInteractionSource9 = mutableInteractionSource4;
                    Shape shape7 = standardShape;
                    composer2 = composerStartRestartGroup;
                    TooltipKt.TooltipBox(TooltipDefaults.INSTANCE.m4738rememberTooltipPositionProviderHu5FAss(TooltipAnchorPosition.INSTANCE.m4725getAbovelOKsHw4(), 0.0f, composerStartRestartGroup, 390, 2), ComposableLambdaKt.rememberComposableLambda(-1648759198, true, new Function3() { // from class: androidx.compose.material3.AppBarDslKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return AppBarDslKt.AppBarOverflowIndicator$lambda$0(strM5086getString2EP1pXo5, (TooltipScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), TooltipKt.rememberTooltipState(false, false, null, composerStartRestartGroup, 0, 7), null, null, false, false, false, ComposableLambdaKt.rememberComposableLambda(-67358598, true, new Function2() { // from class: androidx.compose.material3.AppBarDslKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AppBarDslKt.AppBarOverflowIndicator$lambda$1(appBarMenuState, modifier4, z2, iconButtonColors4, mutableInteractionSource4, standardShape, strM5086getString2EP1pXo5, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composer2, 100663344, 248);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier9;
                    z4 = z9;
                    shape2 = shape7;
                    iconButtonColors3 = iconButtonColors9;
                    mutableInteractionSource3 = mutableInteractionSource9;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    z4 = z2;
                    shape2 = standardShape;
                    iconButtonColors3 = iconButtonColors2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AppBarDslKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AppBarDslKt.AppBarOverflowIndicator$lambda$2(appBarMenuState, modifier3, z4, shape2, iconButtonColors3, mutableInteractionSource3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((74899 & i3) != 74898) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "437@15151L13,438@15216L18");
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        standardShape = IconButtonDefaults.INSTANCE.getStandardShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        iconButtonColors2 = IconButtonDefaults.INSTANCE.iconButtonColors(composerStartRestartGroup, 6);
                    }
                    if (i6 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    iconButtonColors4 = iconButtonColors2;
                    modifier4 = companion;
                } else {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        standardShape = IconButtonDefaults.INSTANCE.getStandardShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        iconButtonColors2 = IconButtonDefaults.INSTANCE.iconButtonColors(composerStartRestartGroup, 6);
                    }
                    if (i6 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    iconButtonColors4 = iconButtonColors2;
                    modifier4 = companion;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1914581769, i3, -1, "androidx.compose.material3.AppBarOverflowIndicator (AppBarDsl.kt:440)");
                }
                Strings.Companion companion7 = Strings.INSTANCE;
                final String strM5086getString2EP1pXo6 = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_floating_toolbar_more_options), composerStartRestartGroup, 0);
                Modifier modifier10 = modifier4;
                boolean z10 = z2;
                IconButtonColors iconButtonColors10 = iconButtonColors4;
                MutableInteractionSource mutableInteractionSource10 = mutableInteractionSource4;
                Shape shape8 = standardShape;
                composer2 = composerStartRestartGroup;
                TooltipKt.TooltipBox(TooltipDefaults.INSTANCE.m4738rememberTooltipPositionProviderHu5FAss(TooltipAnchorPosition.INSTANCE.m4725getAbovelOKsHw4(), 0.0f, composerStartRestartGroup, 390, 2), ComposableLambdaKt.rememberComposableLambda(-1648759198, true, new Function3() { // from class: androidx.compose.material3.AppBarDslKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return AppBarDslKt.AppBarOverflowIndicator$lambda$0(strM5086getString2EP1pXo6, (TooltipScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), TooltipKt.rememberTooltipState(false, false, null, composerStartRestartGroup, 0, 7), null, null, false, false, false, ComposableLambdaKt.rememberComposableLambda(-67358598, true, new Function2() { // from class: androidx.compose.material3.AppBarDslKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AppBarDslKt.AppBarOverflowIndicator$lambda$1(appBarMenuState, modifier4, z2, iconButtonColors4, mutableInteractionSource4, standardShape, strM5086getString2EP1pXo6, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, 100663344, 248);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier10;
                z4 = z10;
                shape2 = shape8;
                iconButtonColors3 = iconButtonColors10;
                mutableInteractionSource3 = mutableInteractionSource10;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                z4 = z2;
                shape2 = standardShape;
                iconButtonColors3 = iconButtonColors2;
                mutableInteractionSource3 = mutableInteractionSource2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AppBarDslKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AppBarDslKt.AppBarOverflowIndicator$lambda$2(appBarMenuState, modifier3, z4, shape2, iconButtonColors3, mutableInteractionSource3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        z2 = z;
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                standardShape = shape;
                if (composerStartRestartGroup.changed(standardShape)) {
                }
                i3 |= i9;
            } else {
                standardShape = shape;
            }
            i3 |= i9;
        } else {
            standardShape = shape;
        }
        if ((i & 24576) == 0) {
            if ((i2 & 16) == 0) {
                iconButtonColors2 = iconButtonColors;
                if (composerStartRestartGroup.changed(iconButtonColors2)) {
                }
                i3 |= i10;
            } else {
                iconButtonColors2 = iconButtonColors;
            }
            i3 |= i10;
        } else {
            iconButtonColors2 = iconButtonColors;
        }
        i6 = i2 & 32;
        if (i6 != 0) {
            if ((196608 & i) == 0) {
                mutableInteractionSource2 = mutableInteractionSource;
                if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
            if ((74899 & i3) != 74898) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "437@15151L13,438@15216L18");
                if ((i & 1) != 0) {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        standardShape = IconButtonDefaults.INSTANCE.getStandardShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        iconButtonColors2 = IconButtonDefaults.INSTANCE.iconButtonColors(composerStartRestartGroup, 6);
                    }
                    if (i6 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    iconButtonColors4 = iconButtonColors2;
                    modifier4 = companion;
                } else {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        standardShape = IconButtonDefaults.INSTANCE.getStandardShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        iconButtonColors2 = IconButtonDefaults.INSTANCE.iconButtonColors(composerStartRestartGroup, 6);
                    }
                    if (i6 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    iconButtonColors4 = iconButtonColors2;
                    modifier4 = companion;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1914581769, i3, -1, "androidx.compose.material3.AppBarOverflowIndicator (AppBarDsl.kt:440)");
                }
                Strings.Companion companion8 = Strings.INSTANCE;
                final String strM5086getString2EP1pXo7 = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_floating_toolbar_more_options), composerStartRestartGroup, 0);
                Modifier modifier11 = modifier4;
                boolean z11 = z2;
                IconButtonColors iconButtonColors11 = iconButtonColors4;
                MutableInteractionSource mutableInteractionSource11 = mutableInteractionSource4;
                Shape shape9 = standardShape;
                composer2 = composerStartRestartGroup;
                TooltipKt.TooltipBox(TooltipDefaults.INSTANCE.m4738rememberTooltipPositionProviderHu5FAss(TooltipAnchorPosition.INSTANCE.m4725getAbovelOKsHw4(), 0.0f, composerStartRestartGroup, 390, 2), ComposableLambdaKt.rememberComposableLambda(-1648759198, true, new Function3() { // from class: androidx.compose.material3.AppBarDslKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return AppBarDslKt.AppBarOverflowIndicator$lambda$0(strM5086getString2EP1pXo7, (TooltipScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), TooltipKt.rememberTooltipState(false, false, null, composerStartRestartGroup, 0, 7), null, null, false, false, false, ComposableLambdaKt.rememberComposableLambda(-67358598, true, new Function2() { // from class: androidx.compose.material3.AppBarDslKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AppBarDslKt.AppBarOverflowIndicator$lambda$1(appBarMenuState, modifier4, z2, iconButtonColors4, mutableInteractionSource4, standardShape, strM5086getString2EP1pXo7, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, 100663344, 248);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier11;
                z4 = z11;
                shape2 = shape9;
                iconButtonColors3 = iconButtonColors11;
                mutableInteractionSource3 = mutableInteractionSource11;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                z4 = z2;
                shape2 = standardShape;
                iconButtonColors3 = iconButtonColors2;
                mutableInteractionSource3 = mutableInteractionSource2;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AppBarDslKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AppBarDslKt.AppBarOverflowIndicator$lambda$2(appBarMenuState, modifier3, z4, shape2, iconButtonColors3, mutableInteractionSource3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        mutableInteractionSource2 = mutableInteractionSource;
        if ((74899 & i3) != 74898) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "437@15151L13,438@15216L18");
            if ((i & 1) != 0) {
                if (i8 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    z2 = true;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    standardShape = IconButtonDefaults.INSTANCE.getStandardShape(composerStartRestartGroup, 6);
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    iconButtonColors2 = IconButtonDefaults.INSTANCE.iconButtonColors(composerStartRestartGroup, 6);
                }
                if (i6 != 0) {
                    mutableInteractionSource4 = null;
                } else {
                    mutableInteractionSource4 = mutableInteractionSource2;
                }
                iconButtonColors4 = iconButtonColors2;
                modifier4 = companion;
            } else {
                if (i8 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    z2 = true;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    standardShape = IconButtonDefaults.INSTANCE.getStandardShape(composerStartRestartGroup, 6);
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    iconButtonColors2 = IconButtonDefaults.INSTANCE.iconButtonColors(composerStartRestartGroup, 6);
                }
                if (i6 != 0) {
                    mutableInteractionSource4 = null;
                } else {
                    mutableInteractionSource4 = mutableInteractionSource2;
                }
                iconButtonColors4 = iconButtonColors2;
                modifier4 = companion;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1914581769, i3, -1, "androidx.compose.material3.AppBarOverflowIndicator (AppBarDsl.kt:440)");
            }
            Strings.Companion companion9 = Strings.INSTANCE;
            final String strM5086getString2EP1pXo8 = Strings_androidKt.m5086getString2EP1pXo(Strings.m5002constructorimpl(R.string.m3c_floating_toolbar_more_options), composerStartRestartGroup, 0);
            Modifier modifier12 = modifier4;
            boolean z12 = z2;
            IconButtonColors iconButtonColors12 = iconButtonColors4;
            MutableInteractionSource mutableInteractionSource12 = mutableInteractionSource4;
            Shape shape10 = standardShape;
            composer2 = composerStartRestartGroup;
            TooltipKt.TooltipBox(TooltipDefaults.INSTANCE.m4738rememberTooltipPositionProviderHu5FAss(TooltipAnchorPosition.INSTANCE.m4725getAbovelOKsHw4(), 0.0f, composerStartRestartGroup, 390, 2), ComposableLambdaKt.rememberComposableLambda(-1648759198, true, new Function3() { // from class: androidx.compose.material3.AppBarDslKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AppBarDslKt.AppBarOverflowIndicator$lambda$0(strM5086getString2EP1pXo8, (TooltipScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), TooltipKt.rememberTooltipState(false, false, null, composerStartRestartGroup, 0, 7), null, null, false, false, false, ComposableLambdaKt.rememberComposableLambda(-67358598, true, new Function2() { // from class: androidx.compose.material3.AppBarDslKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AppBarDslKt.AppBarOverflowIndicator$lambda$1(appBarMenuState, modifier4, z2, iconButtonColors4, mutableInteractionSource4, standardShape, strM5086getString2EP1pXo8, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, 100663344, 248);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier12;
            z4 = z12;
            shape2 = shape10;
            iconButtonColors3 = iconButtonColors12;
            mutableInteractionSource3 = mutableInteractionSource12;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
            z4 = z2;
            shape2 = standardShape;
            iconButtonColors3 = iconButtonColors2;
            mutableInteractionSource3 = mutableInteractionSource2;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.AppBarDslKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AppBarDslKt.AppBarOverflowIndicator$lambda$2(appBarMenuState, modifier3, z4, shape2, iconButtonColors3, mutableInteractionSource3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AppBarOverflowIndicator$lambda$0(final String str, TooltipScope tooltipScope, Composer composer, int i) {
        int i2;
        ComposerKt.sourceInformation(composer, "C446@15539L28,446@15526L41:AppBarDsl.kt#uh7d8r");
        if ((i & 6) == 0) {
            i2 = i | ((i & 8) == 0 ? composer.changed(tooltipScope) : composer.changedInstance(tooltipScope) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1648759198, i2, -1, "androidx.compose.material3.AppBarOverflowIndicator.<anonymous> (AppBarDsl.kt:446)");
            }
            TooltipKt.m4746PlainTooltipgv3ox5I(tooltipScope, null, null, 0.0f, null, 0L, 0L, 0.0f, 0.0f, ComposableLambdaKt.rememberComposableLambda(-2012512304, true, new Function2() { // from class: androidx.compose.material3.AppBarDslKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AppBarDslKt.AppBarOverflowIndicator$lambda$0$0(str, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, (i2 & 14) | 805306368, 255);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AppBarOverflowIndicator$lambda$0$0(String str, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C446@15541L24:AppBarDsl.kt#uh7d8r");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2012512304, i, -1, "androidx.compose.material3.AppBarOverflowIndicator.<anonymous>.<anonymous> (AppBarDsl.kt:446)");
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AppBarOverflowIndicator$lambda$1(final AppBarMenuState appBarMenuState, Modifier modifier, boolean z, IconButtonColors iconButtonColors, MutableInteractionSource mutableInteractionSource, Shape shape, final String str, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C450@15661L178,462@16034L114,449@15627L532:AppBarDsl.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-67358598, i, -1, "androidx.compose.material3.AppBarOverflowIndicator.<anonymous> (AppBarDsl.kt:449)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, -307101652, "CC(remember):AppBarDsl.kt#9igjgp");
            boolean zChangedInstance = composer.changedInstance(appBarMenuState);
            Object objRememberedValue = composer.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: androidx.compose.material3.AppBarDslKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AppBarDslKt.AppBarOverflowIndicator$lambda$1$0$0(appBarMenuState);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            IconButtonKt.IconButton((Function0<Unit>) objRememberedValue, modifier, z, iconButtonColors, mutableInteractionSource, shape, ComposableLambdaKt.rememberComposableLambda(83642140, true, new Function2() { // from class: androidx.compose.material3.AppBarDslKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AppBarDslKt.AppBarOverflowIndicator$lambda$1$1(str, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 1572864, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AppBarOverflowIndicator$lambda$1$0$0(AppBarMenuState appBarMenuState) {
        if (appBarMenuState.isExpanded()) {
            appBarMenuState.dismiss();
        } else {
            appBarMenuState.show();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AppBarOverflowIndicator$lambda$1$1(String str, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C463@16052L82:AppBarDsl.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(83642140, i, -1, "androidx.compose.material3.AppBarOverflowIndicator.<anonymous>.<anonymous> (AppBarDsl.kt:463)");
            }
            IconKt.m3576Iconww6aTOc(Icons.Filled.INSTANCE.getMoreVert$material3(), str, (Modifier) null, 0L, composer, 0, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}

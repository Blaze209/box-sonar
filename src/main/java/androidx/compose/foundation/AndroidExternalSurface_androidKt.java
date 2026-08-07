package androidx.compose.foundation;

import android.content.Context;
import android.graphics.SurfaceTexture;
import android.view.SurfaceView;
import android.view.TextureView;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.AndroidMatrixConversions_androidKt;
import androidx.compose.ui.graphics.Matrix;
import androidx.compose.ui.unit.IntSize;
import androidx.compose.ui.viewinterop.AndroidView_androidKt;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.react.uimanager.ViewProps;
import com.microsoft.intune.mam.client.widget.MAMSurfaceView;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: AndroidExternalSurface.android.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000J\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0002\u001aZ\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\b2\u0017\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00040\u000f¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0004\b\u0012\u0010\u0013\u001a\r\u0010\u0014\u001a\u00020\u0015H\u0003¢\u0006\u0002\u0010\u0016\u001aR\u0010\u0017\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\n\b\u0002\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0017\u0010\u000e\u001a\u0013\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00040\u000f¢\u0006\u0002\b\u0011H\u0007¢\u0006\u0004\b\u001a\u0010\u001b¨\u0006\u001c"}, d2 = {"rememberAndroidExternalSurfaceState", "Landroidx/compose/foundation/AndroidExternalSurfaceState;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/AndroidExternalSurfaceState;", "AndroidExternalSurface", "", "modifier", "Landroidx/compose/ui/Modifier;", "isOpaque", "", "surfaceSize", "Landroidx/compose/ui/unit/IntSize;", "zOrder", "Landroidx/compose/foundation/AndroidExternalSurfaceZOrder;", "isSecure", "onInit", "Lkotlin/Function1;", "Landroidx/compose/foundation/AndroidExternalSurfaceScope;", "Lkotlin/ExtensionFunctionType;", "AndroidExternalSurface-58FFMhA", "(Landroidx/compose/ui/Modifier;ZJIZLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "rememberAndroidEmbeddedExternalSurfaceState", "Landroidx/compose/foundation/AndroidEmbeddedExternalSurfaceState;", "(Landroidx/compose/runtime/Composer;I)Landroidx/compose/foundation/AndroidEmbeddedExternalSurfaceState;", "AndroidEmbeddedExternalSurface", ViewProps.TRANSFORM, "Landroidx/compose/ui/graphics/Matrix;", "AndroidEmbeddedExternalSurface-sv6N_fY", "(Landroidx/compose/ui/Modifier;ZJ[FLkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "foundation"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class AndroidExternalSurface_androidKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AndroidEmbeddedExternalSurface_sv6N_fY$lambda$3(Modifier modifier, boolean z, long j, float[] fArr, Function1 function1, int i, int i2, Composer composer, int i3) {
        m583AndroidEmbeddedExternalSurfacesv6N_fY(modifier, z, j, fArr, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AndroidExternalSurface_58FFMhA$lambda$3(Modifier modifier, boolean z, long j, int i, boolean z2, Function1 function1, int i2, int i3, Composer composer, int i4) {
        m584AndroidExternalSurface58FFMhA(modifier, z, j, i, z2, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    private static final AndroidExternalSurfaceState rememberAndroidExternalSurfaceState(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -873615933, "C(rememberAndroidExternalSurfaceState)188@7180L24,189@7216L47:AndroidExternalSurface.android.kt#71ulvw");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-873615933, i, -1, "androidx.compose.foundation.rememberAndroidExternalSurfaceState (AndroidExternalSurface.android.kt:187)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
        ComposerKt.sourceInformationMarkerStart(composer, 683736516, "CC(remember):Effects.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer);
            composer.updateRememberedValue(objRememberedValue);
        }
        CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, -2026284846, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
        Object objRememberedValue2 = composer.rememberedValue();
        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new AndroidExternalSurfaceState(coroutineScope);
            composer.updateRememberedValue(objRememberedValue2);
        }
        AndroidExternalSurfaceState androidExternalSurfaceState = (AndroidExternalSurfaceState) objRememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return androidExternalSurfaceState;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x013e  */
    /* JADX WARN: Code duplicated, block: B:102:0x0146  */
    /* JADX WARN: Code duplicated, block: B:105:0x0166  */
    /* JADX WARN: Code duplicated, block: B:108:0x0181  */
    /* JADX WARN: Code duplicated, block: B:110:0x0187  */
    /* JADX WARN: Code duplicated, block: B:116:0x0195  */
    /* JADX WARN: Code duplicated, block: B:117:0x0198  */
    /* JADX WARN: Code duplicated, block: B:120:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:121:0x01a3  */
    /* JADX WARN: Code duplicated, block: B:124:0x01ad  */
    /* JADX WARN: Code duplicated, block: B:127:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:131:0x01c4  */
    /* JADX WARN: Code duplicated, block: B:134:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:136:0x0201  */
    /* JADX WARN: Code duplicated, block: B:139:0x020f  */
    /* JADX WARN: Code duplicated, block: B:141:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0050  */
    /* JADX WARN: Code duplicated, block: B:31:0x005f  */
    /* JADX WARN: Code duplicated, block: B:33:0x0063  */
    /* JADX WARN: Code duplicated, block: B:36:0x0069  */
    /* JADX WARN: Code duplicated, block: B:37:0x006c  */
    /* JADX WARN: Code duplicated, block: B:39:0x0070  */
    /* JADX WARN: Code duplicated, block: B:41:0x0078  */
    /* JADX WARN: Code duplicated, block: B:42:0x007b  */
    /* JADX WARN: Code duplicated, block: B:47:0x0086  */
    /* JADX WARN: Code duplicated, block: B:48:0x0089  */
    /* JADX WARN: Code duplicated, block: B:50:0x008d  */
    /* JADX WARN: Code duplicated, block: B:52:0x0095  */
    /* JADX WARN: Code duplicated, block: B:53:0x0098  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:60:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:65:0x00bf  */
    /* JADX WARN: Code duplicated, block: B:66:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:69:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:71:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:78:0x00e4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:79:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:80:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:82:0x00ee  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:87:0x00ff  */
    /* JADX WARN: Code duplicated, block: B:89:0x0108  */
    /* JADX WARN: Code duplicated, block: B:93:0x0113  */
    /* JADX WARN: Code duplicated, block: B:96:0x012f  */
    /* JADX WARN: Code duplicated, block: B:97:0x0132  */
    /* JADX INFO: renamed from: AndroidExternalSurface-58FFMhA, reason: not valid java name */
    public static final void m584AndroidExternalSurface58FFMhA(Modifier modifier, boolean z, long j, int i, boolean z2, final Function1<? super AndroidExternalSurfaceScope, Unit> function1, Composer composer, final int i2, final int i3) {
        Modifier modifier2;
        int i4;
        boolean z3;
        long jM9863getZeroYbymL2g;
        int i5;
        int iM577getBehindB_4ceCc;
        int i6;
        int i7;
        boolean z4;
        int i8;
        boolean z5;
        final Modifier modifier3;
        final boolean z6;
        final long j2;
        final boolean z7;
        final int i9;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        Modifier modifier4;
        final AndroidExternalSurfaceState androidExternalSurfaceStateRememberAndroidExternalSurfaceState;
        boolean z8;
        boolean zChangedInstance;
        Object objRememberedValue;
        Object objRememberedValue2;
        boolean z9;
        boolean z10;
        boolean z11;
        Object objRememberedValue3;
        long j3;
        int i10;
        boolean z12;
        int i11;
        int i12;
        Composer composerStartRestartGroup = composer.startRestartGroup(640888974);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AndroidExternalSurface)N(modifier,isOpaque,surfaceSize:c#ui.unit.IntSize,zOrder:c#foundation.AndroidExternalSurfaceZOrder,isSecure,onInit)275@12030L37,278@12104L150,285@12303L2,286@12324L774,277@12073L1032:AndroidExternalSurface.android.kt#71ulvw");
        int i13 = i3 & 1;
        if (i13 != 0) {
            i4 = i2 | 6;
            modifier2 = modifier;
        } else if ((i2 & 6) == 0) {
            modifier2 = modifier;
            i4 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i2;
        } else {
            modifier2 = modifier;
            i4 = i2;
        }
        int i14 = i3 & 2;
        if (i14 == 0) {
            if ((i2 & 48) == 0) {
                z3 = z;
                i4 |= composerStartRestartGroup.changed(z3) ? 32 : 16;
            }
            if ((i2 & 384) == 0) {
                jM9863getZeroYbymL2g = j;
                if ((i3 & 4) == 0 || !composerStartRestartGroup.changed(jM9863getZeroYbymL2g)) {
                    i12 = 128;
                } else {
                    i12 = 256;
                }
                i4 |= i12;
            } else {
                jM9863getZeroYbymL2g = j;
            }
            i5 = i3 & 8;
            if (i5 != 0) {
                if ((i2 & 3072) == 0) {
                    iM577getBehindB_4ceCc = i;
                    if (composerStartRestartGroup.changed(iM577getBehindB_4ceCc)) {
                        i6 = 2048;
                    } else {
                        i6 = 1024;
                    }
                    i4 |= i6;
                }
                i7 = i3 & 16;
                if (i7 != 0) {
                    if ((i2 & 24576) == 0) {
                        z4 = z2;
                        if (composerStartRestartGroup.changed(z4)) {
                            i8 = 16384;
                        } else {
                            i8 = 8192;
                        }
                        i4 |= i8;
                    }
                    if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        if (composerStartRestartGroup.changedInstance(function1)) {
                            i11 = 131072;
                        } else {
                            i11 = 65536;
                        }
                        i4 |= i11;
                    }
                    if ((i4 & 74899) != 74898) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z5, i4 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        if ((i2 & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i13 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i14 != 0) {
                                z3 = true;
                            }
                            if ((i3 & 4) != 0) {
                                i4 &= -897;
                                jM9863getZeroYbymL2g = IntSize.INSTANCE.m9863getZeroYbymL2g();
                            }
                            if (i5 != 0) {
                                iM577getBehindB_4ceCc = AndroidExternalSurfaceZOrder.INSTANCE.m577getBehindB_4ceCc();
                            }
                            if (i7 != 0) {
                                z4 = false;
                            }
                            modifier4 = companion;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i3 & 4) != 0) {
                                i4 &= -897;
                            }
                            modifier4 = modifier2;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(640888974, i4, -1, "androidx.compose.foundation.AndroidExternalSurface (AndroidExternalSurface.android.kt:274)");
                        }
                        androidExternalSurfaceStateRememberAndroidExternalSurfaceState = rememberAndroidExternalSurfaceState(composerStartRestartGroup, 0);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1713993348, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
                        if ((458752 & i4) == 131072) {
                            z8 = true;
                        } else {
                            z8 = false;
                        }
                        zChangedInstance = z8 | composerStartRestartGroup.changedInstance(androidExternalSurfaceStateRememberAndroidExternalSurfaceState);
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (!zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AndroidExternalSurface_androidKt.AndroidExternalSurface_58FFMhA$lambda$0$0(function1, androidExternalSurfaceStateRememberAndroidExternalSurfaceState, (Context) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        Function1 function2 = (Function1) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1713999568, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function1() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AndroidExternalSurface_androidKt.AndroidExternalSurface_58FFMhA$lambda$1$0((SurfaceView) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        Function1 function3 = (Function1) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1714001012, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
                        boolean z13 = (((i4 & 896) ^ 384) <= 256 && composerStartRestartGroup.changed(jM9863getZeroYbymL2g)) || (i4 & 384) == 256;
                        if ((i4 & 112) == 32) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                        boolean z14 = z13 | z9;
                        if ((i4 & 7168) == 2048) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        z11 = ((57344 & i4) == 16384) | z14 | z10;
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!z11 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            final boolean z15 = z3;
                            final long j4 = jM9863getZeroYbymL2g;
                            final boolean z16 = z4;
                            final int i15 = iM577getBehindB_4ceCc;
                            objRememberedValue3 = new Function1() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return AndroidExternalSurface_androidKt.AndroidExternalSurface_58FFMhA$lambda$2$0(j4, z15, i15, z16, (SurfaceView) obj);
                                }
                            };
                            j3 = j4;
                            i10 = i15;
                            z12 = z16;
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            j3 = jM9863getZeroYbymL2g;
                            z12 = z4;
                            i10 = iM577getBehindB_4ceCc;
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        AndroidView_androidKt.AndroidView(function2, modifier4, function3, null, (Function1) objRememberedValue3, composerStartRestartGroup, ((i4 << 3) & 112) | 384, 8);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        j2 = j3;
                        z6 = z3;
                        modifier3 = modifier4;
                        z7 = z12;
                        i9 = i10;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        z6 = z3;
                        j2 = jM9863getZeroYbymL2g;
                        z7 = z4;
                        i9 = iM577getBehindB_4ceCc;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return AndroidExternalSurface_androidKt.AndroidExternalSurface_58FFMhA$lambda$3(modifier3, z6, j2, i9, z7, function1, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i4 |= 24576;
                z4 = z2;
                if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i4 |= i11;
                }
                if ((i4 & 74899) != 74898) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i14 != 0) {
                            z3 = true;
                        }
                        if ((i3 & 4) != 0) {
                            i4 &= -897;
                            jM9863getZeroYbymL2g = IntSize.INSTANCE.m9863getZeroYbymL2g();
                        }
                        if (i5 != 0) {
                            iM577getBehindB_4ceCc = AndroidExternalSurfaceZOrder.INSTANCE.m577getBehindB_4ceCc();
                        }
                        if (i7 != 0) {
                            z4 = false;
                        }
                        modifier4 = companion;
                    } else {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i14 != 0) {
                            z3 = true;
                        }
                        if ((i3 & 4) != 0) {
                            i4 &= -897;
                            jM9863getZeroYbymL2g = IntSize.INSTANCE.m9863getZeroYbymL2g();
                        }
                        if (i5 != 0) {
                            iM577getBehindB_4ceCc = AndroidExternalSurfaceZOrder.INSTANCE.m577getBehindB_4ceCc();
                        }
                        if (i7 != 0) {
                            z4 = false;
                        }
                        modifier4 = companion;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(640888974, i4, -1, "androidx.compose.foundation.AndroidExternalSurface (AndroidExternalSurface.android.kt:274)");
                    }
                    androidExternalSurfaceStateRememberAndroidExternalSurfaceState = rememberAndroidExternalSurfaceState(composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1713993348, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
                    if ((458752 & i4) == 131072) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    zChangedInstance = z8 | composerStartRestartGroup.changedInstance(androidExternalSurfaceStateRememberAndroidExternalSurfaceState);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidExternalSurface_androidKt.AndroidExternalSurface_58FFMhA$lambda$0$0(function1, androidExternalSurfaceStateRememberAndroidExternalSurfaceState, (Context) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function1() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidExternalSurface_androidKt.AndroidExternalSurface_58FFMhA$lambda$0$0(function1, androidExternalSurfaceStateRememberAndroidExternalSurfaceState, (Context) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    Function1 function4 = (Function1) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1713999568, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function1() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidExternalSurface_androidKt.AndroidExternalSurface_58FFMhA$lambda$1$0((SurfaceView) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    Function1 function5 = (Function1) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1714001012, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
                    if (((i4 & 896) ^ 384) <= 256) {
                    }
                    if ((i4 & 112) == 32) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    boolean z17 = z13 | z9;
                    if ((i4 & 7168) == 2048) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    z11 = ((57344 & i4) == 16384) | z17 | z10;
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (z11) {
                        final boolean z18 = z3;
                        final long j5 = jM9863getZeroYbymL2g;
                        final boolean z19 = z4;
                        final int i16 = iM577getBehindB_4ceCc;
                        objRememberedValue3 = new Function1() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidExternalSurface_androidKt.AndroidExternalSurface_58FFMhA$lambda$2$0(j5, z18, i16, z19, (SurfaceView) obj);
                            }
                        };
                        j3 = j5;
                        i10 = i16;
                        z12 = z19;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        final boolean z110 = z3;
                        final long j6 = jM9863getZeroYbymL2g;
                        final boolean z111 = z4;
                        final int i17 = iM577getBehindB_4ceCc;
                        objRememberedValue3 = new Function1() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidExternalSurface_androidKt.AndroidExternalSurface_58FFMhA$lambda$2$0(j6, z110, i17, z111, (SurfaceView) obj);
                            }
                        };
                        j3 = j6;
                        i10 = i17;
                        z12 = z111;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    AndroidView_androidKt.AndroidView(function4, modifier4, function5, null, (Function1) objRememberedValue3, composerStartRestartGroup, ((i4 << 3) & 112) | 384, 8);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j2 = j3;
                    z6 = z3;
                    modifier3 = modifier4;
                    z7 = z12;
                    i9 = i10;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    z6 = z3;
                    j2 = jM9863getZeroYbymL2g;
                    z7 = z4;
                    i9 = iM577getBehindB_4ceCc;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidExternalSurface_androidKt.AndroidExternalSurface_58FFMhA$lambda$3(modifier3, z6, j2, i9, z7, function1, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 3072;
            iM577getBehindB_4ceCc = i;
            i7 = i3 & 16;
            if (i7 != 0) {
                if ((i2 & 24576) == 0) {
                    z4 = z2;
                    if (composerStartRestartGroup.changed(z4)) {
                        i8 = 16384;
                    } else {
                        i8 = 8192;
                    }
                    i4 |= i8;
                }
                if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i4 |= i11;
                }
                if ((i4 & 74899) != 74898) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i14 != 0) {
                            z3 = true;
                        }
                        if ((i3 & 4) != 0) {
                            i4 &= -897;
                            jM9863getZeroYbymL2g = IntSize.INSTANCE.m9863getZeroYbymL2g();
                        }
                        if (i5 != 0) {
                            iM577getBehindB_4ceCc = AndroidExternalSurfaceZOrder.INSTANCE.m577getBehindB_4ceCc();
                        }
                        if (i7 != 0) {
                            z4 = false;
                        }
                        modifier4 = companion;
                    } else {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i14 != 0) {
                            z3 = true;
                        }
                        if ((i3 & 4) != 0) {
                            i4 &= -897;
                            jM9863getZeroYbymL2g = IntSize.INSTANCE.m9863getZeroYbymL2g();
                        }
                        if (i5 != 0) {
                            iM577getBehindB_4ceCc = AndroidExternalSurfaceZOrder.INSTANCE.m577getBehindB_4ceCc();
                        }
                        if (i7 != 0) {
                            z4 = false;
                        }
                        modifier4 = companion;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(640888974, i4, -1, "androidx.compose.foundation.AndroidExternalSurface (AndroidExternalSurface.android.kt:274)");
                    }
                    androidExternalSurfaceStateRememberAndroidExternalSurfaceState = rememberAndroidExternalSurfaceState(composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1713993348, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
                    if ((458752 & i4) == 131072) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    zChangedInstance = z8 | composerStartRestartGroup.changedInstance(androidExternalSurfaceStateRememberAndroidExternalSurfaceState);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidExternalSurface_androidKt.AndroidExternalSurface_58FFMhA$lambda$0$0(function1, androidExternalSurfaceStateRememberAndroidExternalSurfaceState, (Context) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function1() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidExternalSurface_androidKt.AndroidExternalSurface_58FFMhA$lambda$0$0(function1, androidExternalSurfaceStateRememberAndroidExternalSurfaceState, (Context) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    Function1 function6 = (Function1) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1713999568, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function1() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidExternalSurface_androidKt.AndroidExternalSurface_58FFMhA$lambda$1$0((SurfaceView) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    Function1 function7 = (Function1) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1714001012, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
                    if (((i4 & 896) ^ 384) <= 256) {
                    }
                    if ((i4 & 112) == 32) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    boolean z112 = z13 | z9;
                    if ((i4 & 7168) == 2048) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    z11 = ((57344 & i4) == 16384) | z112 | z10;
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (z11) {
                        final boolean z113 = z3;
                        final long j7 = jM9863getZeroYbymL2g;
                        final boolean z114 = z4;
                        final int i18 = iM577getBehindB_4ceCc;
                        objRememberedValue3 = new Function1() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidExternalSurface_androidKt.AndroidExternalSurface_58FFMhA$lambda$2$0(j7, z113, i18, z114, (SurfaceView) obj);
                            }
                        };
                        j3 = j7;
                        i10 = i18;
                        z12 = z114;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        final boolean z115 = z3;
                        final long j8 = jM9863getZeroYbymL2g;
                        final boolean z116 = z4;
                        final int i19 = iM577getBehindB_4ceCc;
                        objRememberedValue3 = new Function1() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidExternalSurface_androidKt.AndroidExternalSurface_58FFMhA$lambda$2$0(j8, z115, i19, z116, (SurfaceView) obj);
                            }
                        };
                        j3 = j8;
                        i10 = i19;
                        z12 = z116;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    AndroidView_androidKt.AndroidView(function6, modifier4, function7, null, (Function1) objRememberedValue3, composerStartRestartGroup, ((i4 << 3) & 112) | 384, 8);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j2 = j3;
                    z6 = z3;
                    modifier3 = modifier4;
                    z7 = z12;
                    i9 = i10;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    z6 = z3;
                    j2 = jM9863getZeroYbymL2g;
                    z7 = z4;
                    i9 = iM577getBehindB_4ceCc;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidExternalSurface_androidKt.AndroidExternalSurface_58FFMhA$lambda$3(modifier3, z6, j2, i9, z7, function1, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 24576;
            z4 = z2;
            if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i11 = 131072;
                } else {
                    i11 = 65536;
                }
                i4 |= i11;
            }
            if ((i4 & 74899) != 74898) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z5, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i14 != 0) {
                        z3 = true;
                    }
                    if ((i3 & 4) != 0) {
                        i4 &= -897;
                        jM9863getZeroYbymL2g = IntSize.INSTANCE.m9863getZeroYbymL2g();
                    }
                    if (i5 != 0) {
                        iM577getBehindB_4ceCc = AndroidExternalSurfaceZOrder.INSTANCE.m577getBehindB_4ceCc();
                    }
                    if (i7 != 0) {
                        z4 = false;
                    }
                    modifier4 = companion;
                } else {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i14 != 0) {
                        z3 = true;
                    }
                    if ((i3 & 4) != 0) {
                        i4 &= -897;
                        jM9863getZeroYbymL2g = IntSize.INSTANCE.m9863getZeroYbymL2g();
                    }
                    if (i5 != 0) {
                        iM577getBehindB_4ceCc = AndroidExternalSurfaceZOrder.INSTANCE.m577getBehindB_4ceCc();
                    }
                    if (i7 != 0) {
                        z4 = false;
                    }
                    modifier4 = companion;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(640888974, i4, -1, "androidx.compose.foundation.AndroidExternalSurface (AndroidExternalSurface.android.kt:274)");
                }
                androidExternalSurfaceStateRememberAndroidExternalSurfaceState = rememberAndroidExternalSurfaceState(composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1713993348, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
                if ((458752 & i4) == 131072) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                zChangedInstance = z8 | composerStartRestartGroup.changedInstance(androidExternalSurfaceStateRememberAndroidExternalSurfaceState);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AndroidExternalSurface_androidKt.AndroidExternalSurface_58FFMhA$lambda$0$0(function1, androidExternalSurfaceStateRememberAndroidExternalSurfaceState, (Context) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function1() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AndroidExternalSurface_androidKt.AndroidExternalSurface_58FFMhA$lambda$0$0(function1, androidExternalSurfaceStateRememberAndroidExternalSurfaceState, (Context) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                Function1 function8 = (Function1) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1713999568, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AndroidExternalSurface_androidKt.AndroidExternalSurface_58FFMhA$lambda$1$0((SurfaceView) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                Function1 function9 = (Function1) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1714001012, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
                if (((i4 & 896) ^ 384) <= 256) {
                }
                if ((i4 & 112) == 32) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                boolean z117 = z13 | z9;
                if ((i4 & 7168) == 2048) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                z11 = ((57344 & i4) == 16384) | z117 | z10;
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (z11) {
                    final boolean z118 = z3;
                    final long j9 = jM9863getZeroYbymL2g;
                    final boolean z119 = z4;
                    final int i110 = iM577getBehindB_4ceCc;
                    objRememberedValue3 = new Function1() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AndroidExternalSurface_androidKt.AndroidExternalSurface_58FFMhA$lambda$2$0(j9, z118, i110, z119, (SurfaceView) obj);
                        }
                    };
                    j3 = j9;
                    i10 = i110;
                    z12 = z119;
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    final boolean z1110 = z3;
                    final long j10 = jM9863getZeroYbymL2g;
                    final boolean z1111 = z4;
                    final int i111 = iM577getBehindB_4ceCc;
                    objRememberedValue3 = new Function1() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AndroidExternalSurface_androidKt.AndroidExternalSurface_58FFMhA$lambda$2$0(j10, z1110, i111, z1111, (SurfaceView) obj);
                        }
                    };
                    j3 = j10;
                    i10 = i111;
                    z12 = z1111;
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                AndroidView_androidKt.AndroidView(function8, modifier4, function9, null, (Function1) objRememberedValue3, composerStartRestartGroup, ((i4 << 3) & 112) | 384, 8);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j2 = j3;
                z6 = z3;
                modifier3 = modifier4;
                z7 = z12;
                i9 = i10;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                z6 = z3;
                j2 = jM9863getZeroYbymL2g;
                z7 = z4;
                i9 = iM577getBehindB_4ceCc;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AndroidExternalSurface_androidKt.AndroidExternalSurface_58FFMhA$lambda$3(modifier3, z6, j2, i9, z7, function1, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 48;
        z3 = z;
        if ((i2 & 384) == 0) {
            jM9863getZeroYbymL2g = j;
            if ((i3 & 4) == 0) {
                i12 = 128;
            } else {
                i12 = 128;
            }
            i4 |= i12;
        } else {
            jM9863getZeroYbymL2g = j;
        }
        i5 = i3 & 8;
        if (i5 != 0) {
            if ((i2 & 3072) == 0) {
                iM577getBehindB_4ceCc = i;
                if (composerStartRestartGroup.changed(iM577getBehindB_4ceCc)) {
                    i6 = 2048;
                } else {
                    i6 = 1024;
                }
                i4 |= i6;
            }
            i7 = i3 & 16;
            if (i7 != 0) {
                if ((i2 & 24576) == 0) {
                    z4 = z2;
                    if (composerStartRestartGroup.changed(z4)) {
                        i8 = 16384;
                    } else {
                        i8 = 8192;
                    }
                    i4 |= i8;
                }
                if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    if (composerStartRestartGroup.changedInstance(function1)) {
                        i11 = 131072;
                    } else {
                        i11 = 65536;
                    }
                    i4 |= i11;
                }
                if ((i4 & 74899) != 74898) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    if ((i2 & 1) != 0) {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i14 != 0) {
                            z3 = true;
                        }
                        if ((i3 & 4) != 0) {
                            i4 &= -897;
                            jM9863getZeroYbymL2g = IntSize.INSTANCE.m9863getZeroYbymL2g();
                        }
                        if (i5 != 0) {
                            iM577getBehindB_4ceCc = AndroidExternalSurfaceZOrder.INSTANCE.m577getBehindB_4ceCc();
                        }
                        if (i7 != 0) {
                            z4 = false;
                        }
                        modifier4 = companion;
                    } else {
                        if (i13 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i14 != 0) {
                            z3 = true;
                        }
                        if ((i3 & 4) != 0) {
                            i4 &= -897;
                            jM9863getZeroYbymL2g = IntSize.INSTANCE.m9863getZeroYbymL2g();
                        }
                        if (i5 != 0) {
                            iM577getBehindB_4ceCc = AndroidExternalSurfaceZOrder.INSTANCE.m577getBehindB_4ceCc();
                        }
                        if (i7 != 0) {
                            z4 = false;
                        }
                        modifier4 = companion;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(640888974, i4, -1, "androidx.compose.foundation.AndroidExternalSurface (AndroidExternalSurface.android.kt:274)");
                    }
                    androidExternalSurfaceStateRememberAndroidExternalSurfaceState = rememberAndroidExternalSurfaceState(composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1713993348, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
                    if ((458752 & i4) == 131072) {
                        z8 = true;
                    } else {
                        z8 = false;
                    }
                    zChangedInstance = z8 | composerStartRestartGroup.changedInstance(androidExternalSurfaceStateRememberAndroidExternalSurfaceState);
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidExternalSurface_androidKt.AndroidExternalSurface_58FFMhA$lambda$0$0(function1, androidExternalSurfaceStateRememberAndroidExternalSurfaceState, (Context) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function1() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidExternalSurface_androidKt.AndroidExternalSurface_58FFMhA$lambda$0$0(function1, androidExternalSurfaceStateRememberAndroidExternalSurfaceState, (Context) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    Function1 function10 = (Function1) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1713999568, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function1() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidExternalSurface_androidKt.AndroidExternalSurface_58FFMhA$lambda$1$0((SurfaceView) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    Function1 function11 = (Function1) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1714001012, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
                    if (((i4 & 896) ^ 384) <= 256) {
                    }
                    if ((i4 & 112) == 32) {
                        z9 = true;
                    } else {
                        z9 = false;
                    }
                    boolean z1112 = z13 | z9;
                    if ((i4 & 7168) == 2048) {
                        z10 = true;
                    } else {
                        z10 = false;
                    }
                    z11 = ((57344 & i4) == 16384) | z1112 | z10;
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (z11) {
                        final boolean z1113 = z3;
                        final long j11 = jM9863getZeroYbymL2g;
                        final boolean z1114 = z4;
                        final int i112 = iM577getBehindB_4ceCc;
                        objRememberedValue3 = new Function1() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidExternalSurface_androidKt.AndroidExternalSurface_58FFMhA$lambda$2$0(j11, z1113, i112, z1114, (SurfaceView) obj);
                            }
                        };
                        j3 = j11;
                        i10 = i112;
                        z12 = z1114;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        final boolean z1115 = z3;
                        final long j12 = jM9863getZeroYbymL2g;
                        final boolean z1116 = z4;
                        final int i113 = iM577getBehindB_4ceCc;
                        objRememberedValue3 = new Function1() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidExternalSurface_androidKt.AndroidExternalSurface_58FFMhA$lambda$2$0(j12, z1115, i113, z1116, (SurfaceView) obj);
                            }
                        };
                        j3 = j12;
                        i10 = i113;
                        z12 = z1116;
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    AndroidView_androidKt.AndroidView(function10, modifier4, function11, null, (Function1) objRememberedValue3, composerStartRestartGroup, ((i4 << 3) & 112) | 384, 8);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    j2 = j3;
                    z6 = z3;
                    modifier3 = modifier4;
                    z7 = z12;
                    i9 = i10;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    z6 = z3;
                    j2 = jM9863getZeroYbymL2g;
                    z7 = z4;
                    i9 = iM577getBehindB_4ceCc;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return AndroidExternalSurface_androidKt.AndroidExternalSurface_58FFMhA$lambda$3(modifier3, z6, j2, i9, z7, function1, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 24576;
            z4 = z2;
            if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i11 = 131072;
                } else {
                    i11 = 65536;
                }
                i4 |= i11;
            }
            if ((i4 & 74899) != 74898) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z5, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i14 != 0) {
                        z3 = true;
                    }
                    if ((i3 & 4) != 0) {
                        i4 &= -897;
                        jM9863getZeroYbymL2g = IntSize.INSTANCE.m9863getZeroYbymL2g();
                    }
                    if (i5 != 0) {
                        iM577getBehindB_4ceCc = AndroidExternalSurfaceZOrder.INSTANCE.m577getBehindB_4ceCc();
                    }
                    if (i7 != 0) {
                        z4 = false;
                    }
                    modifier4 = companion;
                } else {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i14 != 0) {
                        z3 = true;
                    }
                    if ((i3 & 4) != 0) {
                        i4 &= -897;
                        jM9863getZeroYbymL2g = IntSize.INSTANCE.m9863getZeroYbymL2g();
                    }
                    if (i5 != 0) {
                        iM577getBehindB_4ceCc = AndroidExternalSurfaceZOrder.INSTANCE.m577getBehindB_4ceCc();
                    }
                    if (i7 != 0) {
                        z4 = false;
                    }
                    modifier4 = companion;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(640888974, i4, -1, "androidx.compose.foundation.AndroidExternalSurface (AndroidExternalSurface.android.kt:274)");
                }
                androidExternalSurfaceStateRememberAndroidExternalSurfaceState = rememberAndroidExternalSurfaceState(composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1713993348, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
                if ((458752 & i4) == 131072) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                zChangedInstance = z8 | composerStartRestartGroup.changedInstance(androidExternalSurfaceStateRememberAndroidExternalSurfaceState);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AndroidExternalSurface_androidKt.AndroidExternalSurface_58FFMhA$lambda$0$0(function1, androidExternalSurfaceStateRememberAndroidExternalSurfaceState, (Context) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function1() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AndroidExternalSurface_androidKt.AndroidExternalSurface_58FFMhA$lambda$0$0(function1, androidExternalSurfaceStateRememberAndroidExternalSurfaceState, (Context) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                Function1 function12 = (Function1) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1713999568, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AndroidExternalSurface_androidKt.AndroidExternalSurface_58FFMhA$lambda$1$0((SurfaceView) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                Function1 function13 = (Function1) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1714001012, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
                if (((i4 & 896) ^ 384) <= 256) {
                }
                if ((i4 & 112) == 32) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                boolean z1117 = z13 | z9;
                if ((i4 & 7168) == 2048) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                z11 = ((57344 & i4) == 16384) | z1117 | z10;
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (z11) {
                    final boolean z1118 = z3;
                    final long j13 = jM9863getZeroYbymL2g;
                    final boolean z1119 = z4;
                    final int i114 = iM577getBehindB_4ceCc;
                    objRememberedValue3 = new Function1() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AndroidExternalSurface_androidKt.AndroidExternalSurface_58FFMhA$lambda$2$0(j13, z1118, i114, z1119, (SurfaceView) obj);
                        }
                    };
                    j3 = j13;
                    i10 = i114;
                    z12 = z1119;
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    final boolean z11110 = z3;
                    final long j14 = jM9863getZeroYbymL2g;
                    final boolean z11111 = z4;
                    final int i115 = iM577getBehindB_4ceCc;
                    objRememberedValue3 = new Function1() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AndroidExternalSurface_androidKt.AndroidExternalSurface_58FFMhA$lambda$2$0(j14, z11110, i115, z11111, (SurfaceView) obj);
                        }
                    };
                    j3 = j14;
                    i10 = i115;
                    z12 = z11111;
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                AndroidView_androidKt.AndroidView(function12, modifier4, function13, null, (Function1) objRememberedValue3, composerStartRestartGroup, ((i4 << 3) & 112) | 384, 8);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j2 = j3;
                z6 = z3;
                modifier3 = modifier4;
                z7 = z12;
                i9 = i10;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                z6 = z3;
                j2 = jM9863getZeroYbymL2g;
                z7 = z4;
                i9 = iM577getBehindB_4ceCc;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AndroidExternalSurface_androidKt.AndroidExternalSurface_58FFMhA$lambda$3(modifier3, z6, j2, i9, z7, function1, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 3072;
        iM577getBehindB_4ceCc = i;
        i7 = i3 & 16;
        if (i7 != 0) {
            if ((i2 & 24576) == 0) {
                z4 = z2;
                if (composerStartRestartGroup.changed(z4)) {
                    i8 = 16384;
                } else {
                    i8 = 8192;
                }
                i4 |= i8;
            }
            if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                if (composerStartRestartGroup.changedInstance(function1)) {
                    i11 = 131072;
                } else {
                    i11 = 65536;
                }
                i4 |= i11;
            }
            if ((i4 & 74899) != 74898) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z5, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i2 & 1) != 0) {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i14 != 0) {
                        z3 = true;
                    }
                    if ((i3 & 4) != 0) {
                        i4 &= -897;
                        jM9863getZeroYbymL2g = IntSize.INSTANCE.m9863getZeroYbymL2g();
                    }
                    if (i5 != 0) {
                        iM577getBehindB_4ceCc = AndroidExternalSurfaceZOrder.INSTANCE.m577getBehindB_4ceCc();
                    }
                    if (i7 != 0) {
                        z4 = false;
                    }
                    modifier4 = companion;
                } else {
                    if (i13 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i14 != 0) {
                        z3 = true;
                    }
                    if ((i3 & 4) != 0) {
                        i4 &= -897;
                        jM9863getZeroYbymL2g = IntSize.INSTANCE.m9863getZeroYbymL2g();
                    }
                    if (i5 != 0) {
                        iM577getBehindB_4ceCc = AndroidExternalSurfaceZOrder.INSTANCE.m577getBehindB_4ceCc();
                    }
                    if (i7 != 0) {
                        z4 = false;
                    }
                    modifier4 = companion;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(640888974, i4, -1, "androidx.compose.foundation.AndroidExternalSurface (AndroidExternalSurface.android.kt:274)");
                }
                androidExternalSurfaceStateRememberAndroidExternalSurfaceState = rememberAndroidExternalSurfaceState(composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1713993348, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
                if ((458752 & i4) == 131072) {
                    z8 = true;
                } else {
                    z8 = false;
                }
                zChangedInstance = z8 | composerStartRestartGroup.changedInstance(androidExternalSurfaceStateRememberAndroidExternalSurfaceState);
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChangedInstance) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AndroidExternalSurface_androidKt.AndroidExternalSurface_58FFMhA$lambda$0$0(function1, androidExternalSurfaceStateRememberAndroidExternalSurfaceState, (Context) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function1() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AndroidExternalSurface_androidKt.AndroidExternalSurface_58FFMhA$lambda$0$0(function1, androidExternalSurfaceStateRememberAndroidExternalSurfaceState, (Context) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                Function1 function14 = (Function1) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1713999568, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AndroidExternalSurface_androidKt.AndroidExternalSurface_58FFMhA$lambda$1$0((SurfaceView) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                Function1 function15 = (Function1) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1714001012, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
                if (((i4 & 896) ^ 384) <= 256) {
                }
                if ((i4 & 112) == 32) {
                    z9 = true;
                } else {
                    z9 = false;
                }
                boolean z11112 = z13 | z9;
                if ((i4 & 7168) == 2048) {
                    z10 = true;
                } else {
                    z10 = false;
                }
                z11 = ((57344 & i4) == 16384) | z11112 | z10;
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (z11) {
                    final boolean z11113 = z3;
                    final long j15 = jM9863getZeroYbymL2g;
                    final boolean z11114 = z4;
                    final int i116 = iM577getBehindB_4ceCc;
                    objRememberedValue3 = new Function1() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AndroidExternalSurface_androidKt.AndroidExternalSurface_58FFMhA$lambda$2$0(j15, z11113, i116, z11114, (SurfaceView) obj);
                        }
                    };
                    j3 = j15;
                    i10 = i116;
                    z12 = z11114;
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    final boolean z11115 = z3;
                    final long j16 = jM9863getZeroYbymL2g;
                    final boolean z11116 = z4;
                    final int i117 = iM577getBehindB_4ceCc;
                    objRememberedValue3 = new Function1() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AndroidExternalSurface_androidKt.AndroidExternalSurface_58FFMhA$lambda$2$0(j16, z11115, i117, z11116, (SurfaceView) obj);
                        }
                    };
                    j3 = j16;
                    i10 = i117;
                    z12 = z11116;
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                AndroidView_androidKt.AndroidView(function14, modifier4, function15, null, (Function1) objRememberedValue3, composerStartRestartGroup, ((i4 << 3) & 112) | 384, 8);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                j2 = j3;
                z6 = z3;
                modifier3 = modifier4;
                z7 = z12;
                i9 = i10;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                z6 = z3;
                j2 = jM9863getZeroYbymL2g;
                z7 = z4;
                i9 = iM577getBehindB_4ceCc;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AndroidExternalSurface_androidKt.AndroidExternalSurface_58FFMhA$lambda$3(modifier3, z6, j2, i9, z7, function1, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 24576;
        z4 = z2;
        if ((i2 & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            if (composerStartRestartGroup.changedInstance(function1)) {
                i11 = 131072;
            } else {
                i11 = 65536;
            }
            i4 |= i11;
        }
        if ((i4 & 74899) != 74898) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z5, i4 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i2 & 1) != 0) {
                if (i13 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i14 != 0) {
                    z3 = true;
                }
                if ((i3 & 4) != 0) {
                    i4 &= -897;
                    jM9863getZeroYbymL2g = IntSize.INSTANCE.m9863getZeroYbymL2g();
                }
                if (i5 != 0) {
                    iM577getBehindB_4ceCc = AndroidExternalSurfaceZOrder.INSTANCE.m577getBehindB_4ceCc();
                }
                if (i7 != 0) {
                    z4 = false;
                }
                modifier4 = companion;
            } else {
                if (i13 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i14 != 0) {
                    z3 = true;
                }
                if ((i3 & 4) != 0) {
                    i4 &= -897;
                    jM9863getZeroYbymL2g = IntSize.INSTANCE.m9863getZeroYbymL2g();
                }
                if (i5 != 0) {
                    iM577getBehindB_4ceCc = AndroidExternalSurfaceZOrder.INSTANCE.m577getBehindB_4ceCc();
                }
                if (i7 != 0) {
                    z4 = false;
                }
                modifier4 = companion;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(640888974, i4, -1, "androidx.compose.foundation.AndroidExternalSurface (AndroidExternalSurface.android.kt:274)");
            }
            androidExternalSurfaceStateRememberAndroidExternalSurfaceState = rememberAndroidExternalSurfaceState(composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1713993348, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
            if ((458752 & i4) == 131072) {
                z8 = true;
            } else {
                z8 = false;
            }
            zChangedInstance = z8 | composerStartRestartGroup.changedInstance(androidExternalSurfaceStateRememberAndroidExternalSurfaceState);
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChangedInstance) {
                objRememberedValue = new Function1() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AndroidExternalSurface_androidKt.AndroidExternalSurface_58FFMhA$lambda$0$0(function1, androidExternalSurfaceStateRememberAndroidExternalSurfaceState, (Context) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function1() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AndroidExternalSurface_androidKt.AndroidExternalSurface_58FFMhA$lambda$0$0(function1, androidExternalSurfaceStateRememberAndroidExternalSurfaceState, (Context) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Function1 function16 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1713999568, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AndroidExternalSurface_androidKt.AndroidExternalSurface_58FFMhA$lambda$1$0((SurfaceView) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Function1 function17 = (Function1) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1714001012, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
            if (((i4 & 896) ^ 384) <= 256) {
            }
            if ((i4 & 112) == 32) {
                z9 = true;
            } else {
                z9 = false;
            }
            boolean z11117 = z13 | z9;
            if ((i4 & 7168) == 2048) {
                z10 = true;
            } else {
                z10 = false;
            }
            z11 = ((57344 & i4) == 16384) | z11117 | z10;
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (z11) {
                final boolean z11118 = z3;
                final long j17 = jM9863getZeroYbymL2g;
                final boolean z11119 = z4;
                final int i118 = iM577getBehindB_4ceCc;
                objRememberedValue3 = new Function1() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AndroidExternalSurface_androidKt.AndroidExternalSurface_58FFMhA$lambda$2$0(j17, z11118, i118, z11119, (SurfaceView) obj);
                    }
                };
                j3 = j17;
                i10 = i118;
                z12 = z11119;
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                final boolean z111110 = z3;
                final long j18 = jM9863getZeroYbymL2g;
                final boolean z111111 = z4;
                final int i119 = iM577getBehindB_4ceCc;
                objRememberedValue3 = new Function1() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AndroidExternalSurface_androidKt.AndroidExternalSurface_58FFMhA$lambda$2$0(j18, z111110, i119, z111111, (SurfaceView) obj);
                    }
                };
                j3 = j18;
                i10 = i119;
                z12 = z111111;
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            AndroidView_androidKt.AndroidView(function16, modifier4, function17, null, (Function1) objRememberedValue3, composerStartRestartGroup, ((i4 << 3) & 112) | 384, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            j2 = j3;
            z6 = z3;
            modifier3 = modifier4;
            z7 = z12;
            i9 = i10;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            z6 = z3;
            j2 = jM9863getZeroYbymL2g;
            z7 = z4;
            i9 = iM577getBehindB_4ceCc;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AndroidExternalSurface_androidKt.AndroidExternalSurface_58FFMhA$lambda$3(modifier3, z6, j2, i9, z7, function1, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SurfaceView AndroidExternalSurface_58FFMhA$lambda$0$0(Function1 function1, AndroidExternalSurfaceState androidExternalSurfaceState, Context context) {
        MAMSurfaceView mAMSurfaceView = new MAMSurfaceView(context);
        function1.invoke(androidExternalSurfaceState);
        mAMSurfaceView.getHolder().addCallback(androidExternalSurfaceState);
        return mAMSurfaceView;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AndroidExternalSurface_58FFMhA$lambda$1$0(SurfaceView surfaceView) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AndroidExternalSurface_58FFMhA$lambda$2$0(long j, boolean z, int i, boolean z2, SurfaceView surfaceView) {
        if (!IntSize.m9856equalsimpl0(j, IntSize.INSTANCE.m9863getZeroYbymL2g())) {
            surfaceView.getHolder().setFixedSize((int) (j >> 32), (int) (j & 4294967295L));
        } else {
            surfaceView.getHolder().setSizeFromLayout();
        }
        surfaceView.getHolder().setFormat(z ? -1 : -3);
        if (AndroidExternalSurfaceZOrder.m573equalsimpl0(i, AndroidExternalSurfaceZOrder.INSTANCE.m577getBehindB_4ceCc())) {
            surfaceView.setZOrderOnTop(false);
        } else if (AndroidExternalSurfaceZOrder.m573equalsimpl0(i, AndroidExternalSurfaceZOrder.INSTANCE.m578getMediaOverlayB_4ceCc())) {
            surfaceView.setZOrderMediaOverlay(true);
        } else if (AndroidExternalSurfaceZOrder.m573equalsimpl0(i, AndroidExternalSurfaceZOrder.INSTANCE.m579getOnTopB_4ceCc())) {
            surfaceView.setZOrderOnTop(true);
        }
        surfaceView.setSecure(z2);
        return Unit.INSTANCE;
    }

    private static final AndroidEmbeddedExternalSurfaceState rememberAndroidEmbeddedExternalSurfaceState(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -1057437053, "C(rememberAndroidEmbeddedExternalSurfaceState)371@14901L24,372@14937L55:AndroidExternalSurface.android.kt#71ulvw");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1057437053, i, -1, "androidx.compose.foundation.rememberAndroidEmbeddedExternalSurfaceState (AndroidExternalSurface.android.kt:370)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
        ComposerKt.sourceInformationMarkerStart(composer, 683736516, "CC(remember):Effects.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composer);
            composer.updateRememberedValue(objRememberedValue);
        }
        CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 1710245786, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
        Object objRememberedValue2 = composer.rememberedValue();
        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new AndroidEmbeddedExternalSurfaceState(coroutineScope);
            composer.updateRememberedValue(objRememberedValue2);
        }
        AndroidEmbeddedExternalSurfaceState androidEmbeddedExternalSurfaceState = (AndroidEmbeddedExternalSurfaceState) objRememberedValue2;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return androidEmbeddedExternalSurfaceState;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0169  */
    /* JADX WARN: Code duplicated, block: B:102:0x016c  */
    /* JADX WARN: Code duplicated, block: B:105:0x0174  */
    /* JADX WARN: Code duplicated, block: B:108:0x0179  */
    /* JADX WARN: Code duplicated, block: B:109:0x017e  */
    /* JADX WARN: Code duplicated, block: B:112:0x018a  */
    /* JADX WARN: Code duplicated, block: B:116:0x0196  */
    /* JADX WARN: Code duplicated, block: B:119:0x01c0  */
    /* JADX WARN: Code duplicated, block: B:121:0x01cb  */
    /* JADX WARN: Code duplicated, block: B:124:0x01d9  */
    /* JADX WARN: Code duplicated, block: B:126:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:26:0x0050  */
    /* JADX WARN: Code duplicated, block: B:31:0x005e  */
    /* JADX WARN: Code duplicated, block: B:33:0x0062  */
    /* JADX WARN: Code duplicated, block: B:36:0x0068  */
    /* JADX WARN: Code duplicated, block: B:37:0x006b  */
    /* JADX WARN: Code duplicated, block: B:39:0x006f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:40:0x0071  */
    /* JADX WARN: Code duplicated, block: B:41:0x0076  */
    /* JADX WARN: Code duplicated, block: B:44:0x007d  */
    /* JADX WARN: Code duplicated, block: B:45:0x0080  */
    /* JADX WARN: Code duplicated, block: B:49:0x0087  */
    /* JADX WARN: Code duplicated, block: B:51:0x008f  */
    /* JADX WARN: Code duplicated, block: B:52:0x0092  */
    /* JADX WARN: Code duplicated, block: B:54:0x0097  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:71:0x00cb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:72:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:78:0x00db  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e6  */
    /* JADX WARN: Code duplicated, block: B:81:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:84:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:87:0x0115  */
    /* JADX WARN: Code duplicated, block: B:90:0x0135  */
    /* JADX WARN: Code duplicated, block: B:93:0x014e  */
    /* JADX WARN: Code duplicated, block: B:95:0x0154  */
    /* JADX INFO: renamed from: AndroidEmbeddedExternalSurface-sv6N_fY, reason: not valid java name */
    public static final void m583AndroidEmbeddedExternalSurfacesv6N_fY(Modifier modifier, boolean z, long j, final float[] fArr, final Function1<? super AndroidExternalSurfaceScope, Unit> function1, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        boolean z2;
        long jM9863getZeroYbymL2g;
        int i4;
        Matrix matrixM7058boximpl;
        int i5;
        Function1<? super AndroidExternalSurfaceScope, Unit> function2;
        boolean z3;
        final float[] fArr2;
        final Modifier modifier3;
        final boolean z4;
        final long j2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        final boolean z5;
        final AndroidEmbeddedExternalSurfaceState androidEmbeddedExternalSurfaceStateRememberAndroidEmbeddedExternalSurfaceState;
        Object objRememberedValue;
        Object objRememberedValue2;
        boolean z6;
        Matrix matrixM7058boximpl2;
        boolean zChangedInstance;
        Object objRememberedValue3;
        final long j3;
        int i6;
        int i7;
        Composer composerStartRestartGroup = composer.startRestartGroup(217541314);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AndroidEmbeddedExternalSurface)N(modifier,isOpaque,surfaceSize:c#ui.unit.IntSize,transform:c#ui.graphics.Matrix,onInit)433@18602L45,436@18684L19,438@18752L2,439@18773L639,435@18653L766:AndroidExternalSurface.android.kt#71ulvw");
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
                z2 = z;
                i3 |= composerStartRestartGroup.changed(z2) ? 32 : 16;
            }
            if ((i & 384) == 0) {
                jM9863getZeroYbymL2g = j;
                if ((i2 & 4) == 0 || !composerStartRestartGroup.changed(jM9863getZeroYbymL2g)) {
                    i7 = 128;
                } else {
                    i7 = 256;
                }
                i3 |= i7;
            } else {
                jM9863getZeroYbymL2g = j;
            }
            i4 = i2 & 8;
            if (i4 != 0) {
                i3 |= 3072;
            } else if ((i & 3072) == 0) {
                if (fArr != null) {
                    matrixM7058boximpl = Matrix.m7058boximpl(fArr);
                } else {
                    matrixM7058boximpl = null;
                }
                if (composerStartRestartGroup.changedInstance(matrixM7058boximpl)) {
                    i5 = 2048;
                } else {
                    i5 = 1024;
                }
                i3 |= i5;
            }
            if ((i & 24576) == 0) {
                function2 = function1;
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i6 = 16384;
                } else {
                    i6 = 8192;
                }
                i3 |= i6;
            } else {
                function2 = function1;
            }
            if ((i3 & 9363) != 9362) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i8 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i9 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                        jM9863getZeroYbymL2g = IntSize.INSTANCE.m9863getZeroYbymL2g();
                    }
                    if (i4 != 0) {
                        z5 = z2;
                        fArr = null;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(217541314, i3, -1, "androidx.compose.foundation.AndroidEmbeddedExternalSurface (AndroidExternalSurface.android.kt:432)");
                    }
                    androidEmbeddedExternalSurfaceStateRememberAndroidEmbeddedExternalSurfaceState = rememberAndroidEmbeddedExternalSurfaceState(composerStartRestartGroup, 0);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1396184267, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidExternalSurface_androidKt.AndroidEmbeddedExternalSurface_sv6N_fY$lambda$0$0((Context) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    Function1 function3 = (Function1) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1396182108, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function1() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidExternalSurface_androidKt.AndroidEmbeddedExternalSurface_sv6N_fY$lambda$1$0((TextureView) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    Function1 function4 = (Function1) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1396180799, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
                    boolean zChangedInstance2 = ((((i3 & 896) ^ 384) <= 256 && composerStartRestartGroup.changed(jM9863getZeroYbymL2g)) || (i3 & 384) == 256) | composerStartRestartGroup.changedInstance(androidEmbeddedExternalSurfaceStateRememberAndroidEmbeddedExternalSurfaceState);
                    if ((57344 & i3) == 16384) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    boolean z7 = zChangedInstance2 | z6 | ((i3 & 112) == 32);
                    if (fArr != null) {
                        matrixM7058boximpl2 = Matrix.m7058boximpl(fArr);
                    } else {
                        matrixM7058boximpl2 = null;
                    }
                    zChangedInstance = z7 | composerStartRestartGroup.changedInstance(matrixM7058boximpl2);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        j3 = jM9863getZeroYbymL2g;
                        final Function1<? super AndroidExternalSurfaceScope, Unit> function5 = function2;
                        objRememberedValue3 = new Function1() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return AndroidExternalSurface_androidKt.AndroidEmbeddedExternalSurface_sv6N_fY$lambda$2$0(j3, androidEmbeddedExternalSurfaceStateRememberAndroidEmbeddedExternalSurfaceState, function5, z5, fArr, (TextureView) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        j3 = jM9863getZeroYbymL2g;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifier4 = companion;
                    AndroidView_androidKt.AndroidView(function3, modifier4, function4, null, (Function1) objRememberedValue3, composerStartRestartGroup, ((i3 << 3) & 112) | 390, 8);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    j2 = j3;
                    z4 = z5;
                    fArr2 = fArr;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    companion = modifier2;
                }
                z5 = z2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(217541314, i3, -1, "androidx.compose.foundation.AndroidEmbeddedExternalSurface (AndroidExternalSurface.android.kt:432)");
                }
                androidEmbeddedExternalSurfaceStateRememberAndroidEmbeddedExternalSurfaceState = rememberAndroidEmbeddedExternalSurfaceState(composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1396184267, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AndroidExternalSurface_androidKt.AndroidEmbeddedExternalSurface_sv6N_fY$lambda$0$0((Context) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                Function1 function6 = (Function1) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1396182108, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AndroidExternalSurface_androidKt.AndroidEmbeddedExternalSurface_sv6N_fY$lambda$1$0((TextureView) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                Function1 function7 = (Function1) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1396180799, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
                boolean zChangedInstance3 = ((((i3 & 896) ^ 384) <= 256 && composerStartRestartGroup.changed(jM9863getZeroYbymL2g)) || (i3 & 384) == 256) | composerStartRestartGroup.changedInstance(androidEmbeddedExternalSurfaceStateRememberAndroidEmbeddedExternalSurfaceState);
                if ((57344 & i3) == 16384) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                boolean z8 = zChangedInstance3 | z6 | ((i3 & 112) == 32);
                if (fArr != null) {
                    matrixM7058boximpl2 = Matrix.m7058boximpl(fArr);
                } else {
                    matrixM7058boximpl2 = null;
                }
                zChangedInstance = z8 | composerStartRestartGroup.changedInstance(matrixM7058boximpl2);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance) {
                    j3 = jM9863getZeroYbymL2g;
                    final Function1 function8 = function2;
                    objRememberedValue3 = new Function1() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AndroidExternalSurface_androidKt.AndroidEmbeddedExternalSurface_sv6N_fY$lambda$2$0(j3, androidEmbeddedExternalSurfaceStateRememberAndroidEmbeddedExternalSurfaceState, function8, z5, fArr, (TextureView) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    j3 = jM9863getZeroYbymL2g;
                    final Function1 function9 = function2;
                    objRememberedValue3 = new Function1() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return AndroidExternalSurface_androidKt.AndroidEmbeddedExternalSurface_sv6N_fY$lambda$2$0(j3, androidEmbeddedExternalSurfaceStateRememberAndroidEmbeddedExternalSurfaceState, function9, z5, fArr, (TextureView) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifier5 = companion;
                AndroidView_androidKt.AndroidView(function6, modifier5, function7, null, (Function1) objRememberedValue3, composerStartRestartGroup, ((i3 << 3) & 112) | 390, 8);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier5;
                j2 = j3;
                z4 = z5;
                fArr2 = fArr;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                fArr2 = fArr;
                modifier3 = modifier2;
                z4 = z2;
                j2 = jM9863getZeroYbymL2g;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AndroidExternalSurface_androidKt.AndroidEmbeddedExternalSurface_sv6N_fY$lambda$3(modifier3, z4, j2, fArr2, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        z2 = z;
        if ((i & 384) == 0) {
            jM9863getZeroYbymL2g = j;
            if ((i2 & 4) == 0) {
                i7 = 128;
            } else {
                i7 = 128;
            }
            i3 |= i7;
        } else {
            jM9863getZeroYbymL2g = j;
        }
        i4 = i2 & 8;
        if (i4 != 0) {
            i3 |= 3072;
        } else if ((i & 3072) == 0) {
            if (fArr != null) {
                matrixM7058boximpl = Matrix.m7058boximpl(fArr);
            } else {
                matrixM7058boximpl = null;
            }
            if (composerStartRestartGroup.changedInstance(matrixM7058boximpl)) {
                i5 = 2048;
            } else {
                i5 = 1024;
            }
            i3 |= i5;
        }
        if ((i & 24576) == 0) {
            function2 = function1;
            if (composerStartRestartGroup.changedInstance(function2)) {
                i6 = 16384;
            } else {
                i6 = 8192;
            }
            i3 |= i6;
        } else {
            function2 = function1;
        }
        if ((i3 & 9363) != 9362) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            if ((i & 1) != 0) {
                if (i8 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i9 != 0) {
                    z2 = true;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    jM9863getZeroYbymL2g = IntSize.INSTANCE.m9863getZeroYbymL2g();
                }
                if (i4 != 0) {
                    z5 = z2;
                    fArr = null;
                } else {
                    z5 = z2;
                }
            } else {
                if (i8 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i9 != 0) {
                    z2 = true;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                    jM9863getZeroYbymL2g = IntSize.INSTANCE.m9863getZeroYbymL2g();
                }
                if (i4 != 0) {
                    z5 = z2;
                    fArr = null;
                } else {
                    z5 = z2;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(217541314, i3, -1, "androidx.compose.foundation.AndroidEmbeddedExternalSurface (AndroidExternalSurface.android.kt:432)");
            }
            androidEmbeddedExternalSurfaceStateRememberAndroidEmbeddedExternalSurfaceState = rememberAndroidEmbeddedExternalSurfaceState(composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1396184267, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AndroidExternalSurface_androidKt.AndroidEmbeddedExternalSurface_sv6N_fY$lambda$0$0((Context) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            Function1 function10 = (Function1) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1396182108, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function1() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AndroidExternalSurface_androidKt.AndroidEmbeddedExternalSurface_sv6N_fY$lambda$1$0((TextureView) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            Function1 function11 = (Function1) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1396180799, "CC(remember):AndroidExternalSurface.android.kt#9igjgp");
            boolean zChangedInstance4 = ((((i3 & 896) ^ 384) <= 256 && composerStartRestartGroup.changed(jM9863getZeroYbymL2g)) || (i3 & 384) == 256) | composerStartRestartGroup.changedInstance(androidEmbeddedExternalSurfaceStateRememberAndroidEmbeddedExternalSurfaceState);
            if ((57344 & i3) == 16384) {
                z6 = true;
            } else {
                z6 = false;
            }
            boolean z9 = zChangedInstance4 | z6 | ((i3 & 112) == 32);
            if (fArr != null) {
                matrixM7058boximpl2 = Matrix.m7058boximpl(fArr);
            } else {
                matrixM7058boximpl2 = null;
            }
            zChangedInstance = z9 | composerStartRestartGroup.changedInstance(matrixM7058boximpl2);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance) {
                j3 = jM9863getZeroYbymL2g;
                final Function1 function12 = function2;
                objRememberedValue3 = new Function1() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AndroidExternalSurface_androidKt.AndroidEmbeddedExternalSurface_sv6N_fY$lambda$2$0(j3, androidEmbeddedExternalSurfaceStateRememberAndroidEmbeddedExternalSurfaceState, function12, z5, fArr, (TextureView) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                j3 = jM9863getZeroYbymL2g;
                final Function1 function13 = function2;
                objRememberedValue3 = new Function1() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return AndroidExternalSurface_androidKt.AndroidEmbeddedExternalSurface_sv6N_fY$lambda$2$0(j3, androidEmbeddedExternalSurfaceStateRememberAndroidEmbeddedExternalSurfaceState, function13, z5, fArr, (TextureView) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifier6 = companion;
            AndroidView_androidKt.AndroidView(function10, modifier6, function11, null, (Function1) objRememberedValue3, composerStartRestartGroup, ((i3 << 3) & 112) | 390, 8);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier6;
            j2 = j3;
            z4 = z5;
            fArr2 = fArr;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            fArr2 = fArr;
            modifier3 = modifier2;
            z4 = z2;
            j2 = jM9863getZeroYbymL2g;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.foundation.AndroidExternalSurface_androidKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AndroidExternalSurface_androidKt.AndroidEmbeddedExternalSurface_sv6N_fY$lambda$3(modifier3, z4, j2, fArr2, function1, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final TextureView AndroidEmbeddedExternalSurface_sv6N_fY$lambda$0$0(Context context) {
        return new TextureView(context);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AndroidEmbeddedExternalSurface_sv6N_fY$lambda$1$0(TextureView textureView) {
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AndroidEmbeddedExternalSurface_sv6N_fY$lambda$2$0(long j, AndroidEmbeddedExternalSurfaceState androidEmbeddedExternalSurfaceState, Function1 function1, boolean z, float[] fArr, TextureView textureView) {
        android.graphics.Matrix matrix;
        SurfaceTexture surfaceTexture;
        if (!IntSize.m9856equalsimpl0(j, IntSize.INSTANCE.m9863getZeroYbymL2g()) && (surfaceTexture = textureView.getSurfaceTexture()) != null) {
            surfaceTexture.setDefaultBufferSize((int) (j >> 32), (int) (4294967295L & j));
        }
        androidEmbeddedExternalSurfaceState.m569setSurfaceSizeozmzZPI(j);
        if (textureView.getSurfaceTextureListener() != androidEmbeddedExternalSurfaceState) {
            function1.invoke(androidEmbeddedExternalSurfaceState);
            textureView.setSurfaceTextureListener(androidEmbeddedExternalSurfaceState);
        }
        textureView.setOpaque(z);
        if (fArr != null) {
            matrix = androidEmbeddedExternalSurfaceState.getMatrix();
            AndroidMatrixConversions_androidKt.m6681setFromEL8BTi8(matrix, fArr);
        } else {
            matrix = null;
        }
        textureView.setTransform(matrix);
        return Unit.INSTANCE;
    }
}

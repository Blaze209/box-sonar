package androidx.compose.material;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.semantics.Role;
import androidx.compose.ui.semantics.SemanticsModifierKt;
import androidx.compose.ui.semantics.SemanticsPropertiesKt;
import androidx.compose.ui.semantics.SemanticsPropertyReceiver;
import androidx.compose.ui.unit.Dp;
import androidx.media3.common.C;
import androidx.profileinstaller.ProfileVerifier;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Button.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000V\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\u001a\u008f\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u008f\u0001\u0010\u001a\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019\u001a\u008f\u0001\u0010\u001b\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\b\b\u0002\u0010\f\u001a\u00020\r2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\u00132\u001c\u0010\u0014\u001a\u0018\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u00010\u0015¢\u0006\u0002\b\u0017¢\u0006\u0002\b\u0018H\u0007¢\u0006\u0002\u0010\u0019¨\u0006\u001c²\u0006\n\u0010\u001d\u001a\u00020\u001eX\u008a\u0084\u0002"}, d2 = {"Button", "", ViewProps.ON_CLICK, "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "elevation", "Landroidx/compose/material/ButtonElevation;", "shape", "Landroidx/compose/ui/graphics/Shape;", OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "colors", "Landroidx/compose/material/ButtonColors;", "contentPadding", "Landroidx/compose/foundation/layout/PaddingValues;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/material/ButtonElevation;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/material/ButtonColors;Landroidx/compose/foundation/layout/PaddingValues;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "OutlinedButton", "TextButton", "material", "contentColor", "Landroidx/compose/ui/graphics/Color;"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ButtonKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Button$lambda$4(Function0 function0, Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, ButtonElevation buttonElevation, Shape shape, BorderStroke borderStroke, ButtonColors buttonColors, PaddingValues paddingValues, Function3 function3, int i, int i2, Composer composer, int i3) {
        Button(function0, modifier, z, mutableInteractionSource, buttonElevation, shape, borderStroke, buttonColors, paddingValues, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x011c  */
    /* JADX WARN: Code duplicated, block: B:102:0x011f  */
    /* JADX WARN: Code duplicated, block: B:106:0x0130  */
    /* JADX WARN: Code duplicated, block: B:107:0x0132  */
    /* JADX WARN: Code duplicated, block: B:110:0x013b  */
    /* JADX WARN: Code duplicated, block: B:112:0x0151  */
    /* JADX WARN: Code duplicated, block: B:125:0x017f A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:126:0x0181  */
    /* JADX WARN: Code duplicated, block: B:127:0x0186  */
    /* JADX WARN: Code duplicated, block: B:129:0x0189  */
    /* JADX WARN: Code duplicated, block: B:130:0x018c  */
    /* JADX WARN: Code duplicated, block: B:132:0x0190  */
    /* JADX WARN: Code duplicated, block: B:133:0x0193  */
    /* JADX WARN: Code duplicated, block: B:136:0x0199  */
    /* JADX WARN: Code duplicated, block: B:139:0x01b6  */
    /* JADX WARN: Code duplicated, block: B:140:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:143:0x01cc  */
    /* JADX WARN: Code duplicated, block: B:144:0x01ce  */
    /* JADX WARN: Code duplicated, block: B:147:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:148:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:151:0x01fd  */
    /* JADX WARN: Code duplicated, block: B:152:0x0204  */
    /* JADX WARN: Code duplicated, block: B:156:0x0218  */
    /* JADX WARN: Code duplicated, block: B:159:0x0225  */
    /* JADX WARN: Code duplicated, block: B:161:0x0242  */
    /* JADX WARN: Code duplicated, block: B:163:0x0254  */
    /* JADX WARN: Code duplicated, block: B:166:0x027e  */
    /* JADX WARN: Code duplicated, block: B:169:0x02c2  */
    /* JADX WARN: Code duplicated, block: B:170:0x02cd  */
    /* JADX WARN: Code duplicated, block: B:172:0x02e7  */
    /* JADX WARN: Code duplicated, block: B:173:0x02f2  */
    /* JADX WARN: Code duplicated, block: B:176:0x032d  */
    /* JADX WARN: Code duplicated, block: B:178:0x033c  */
    /* JADX WARN: Code duplicated, block: B:181:0x0353  */
    /* JADX WARN: Code duplicated, block: B:183:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0046  */
    /* JADX WARN: Code duplicated, block: B:24:0x0049  */
    /* JADX WARN: Code duplicated, block: B:26:0x004d  */
    /* JADX WARN: Code duplicated, block: B:28:0x0055  */
    /* JADX WARN: Code duplicated, block: B:29:0x0058  */
    /* JADX WARN: Code duplicated, block: B:34:0x0062  */
    /* JADX WARN: Code duplicated, block: B:35:0x0065  */
    /* JADX WARN: Code duplicated, block: B:37:0x0069  */
    /* JADX WARN: Code duplicated, block: B:39:0x0071  */
    /* JADX WARN: Code duplicated, block: B:40:0x0074  */
    /* JADX WARN: Code duplicated, block: B:45:0x007e  */
    /* JADX WARN: Code duplicated, block: B:47:0x0082  */
    /* JADX WARN: Code duplicated, block: B:49:0x008a  */
    /* JADX WARN: Code duplicated, block: B:50:0x008d  */
    /* JADX WARN: Code duplicated, block: B:53:0x0093  */
    /* JADX WARN: Code duplicated, block: B:56:0x009a  */
    /* JADX WARN: Code duplicated, block: B:58:0x009e  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a9 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:64:0x00af  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:68:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:73:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:79:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:82:0x00e4 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:85:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:88:0x00f3  */
    /* JADX WARN: Code duplicated, block: B:89:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:91:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:93:0x0104  */
    /* JADX WARN: Code duplicated, block: B:94:0x0107  */
    /* JADX WARN: Code duplicated, block: B:99:0x0116  */
    /* JADX WARN: Type inference failed for: r6v12, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r6v15 */
    /* JADX WARN: Type inference failed for: r6v16 */
    public static final void Button(final Function0<Unit> function0, Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, ButtonElevation buttonElevation, Shape shape, BorderStroke borderStroke, ButtonColors buttonColors, PaddingValues paddingValues, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        int i5;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        int i7;
        ButtonElevation buttonElevationM2302elevationR_JCAzs;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        boolean z3;
        Composer composer2;
        final Shape shape2;
        final BorderStroke borderStroke2;
        final Modifier modifier3;
        final boolean z4;
        final MutableInteractionSource mutableInteractionSource3;
        final ButtonElevation buttonElevation2;
        final ButtonColors buttonColors2;
        final PaddingValues paddingValues2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        boolean z5;
        MutableInteractionSource mutableInteractionSource4;
        CornerBasedShape small;
        int i13;
        BorderStroke borderStroke3;
        Composer composer3;
        boolean z6;
        ButtonColors buttonColorsM2301buttonColorsro_MJ88;
        final PaddingValues contentPadding;
        Shape shape3;
        BorderStroke borderStroke4;
        boolean z7;
        int i14;
        ?? r6;
        MutableInteractionSource mutableInteractionSource5;
        int i15;
        Object objRememberedValue;
        State<Dp> stateElevation;
        float fM9687constructorimpl;
        Object objRememberedValue2;
        int i16;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1084573925);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Button)N(onClick,modifier,enabled,interactionSource,elevation,shape,border,colors,contentPadding,content)108@5157L21,111@5257L22,114@5354L24,119@5603L646,109@5183L1066:Button.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i17 = i2 & 2;
        if (i17 == 0) {
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
                i6 = i2 & 8;
                if (i6 != 0) {
                    if ((i & 3072) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                            i7 = 2048;
                        } else {
                            i7 = 1024;
                        }
                        i3 |= i7;
                    }
                    if ((i & 24576) == 0) {
                        if ((i2 & 16) == 0) {
                            buttonElevationM2302elevationR_JCAzs = buttonElevation;
                            int i18 = composerStartRestartGroup.changed(buttonElevationM2302elevationR_JCAzs) ? 16384 : 8192;
                            i3 |= i18;
                        } else {
                            buttonElevationM2302elevationR_JCAzs = buttonElevation;
                        }
                        i3 |= i18;
                    } else {
                        buttonElevationM2302elevationR_JCAzs = buttonElevation;
                    }
                    if ((196608 & i) != 0) {
                        i3 |= ((i2 & 32) == 0 || !composerStartRestartGroup.changed(shape)) ? 65536 : 131072;
                    }
                    i8 = i2 & 64;
                    if (i8 != 0) {
                        i3 |= 1572864;
                    } else if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(borderStroke)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                    if ((i & 12582912) != 0) {
                        i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(buttonColors)) ? 4194304 : 8388608;
                    }
                    i10 = i2 & 256;
                    if (i10 != 0) {
                        if ((i & 100663296) == 0) {
                            if (composerStartRestartGroup.changed(paddingValues)) {
                                i11 = 67108864;
                            } else {
                                i11 = 33554432;
                            }
                            i3 |= i11;
                        }
                        if ((i & 805306368) == 0) {
                            if (composerStartRestartGroup.changedInstance(function3)) {
                                i16 = C.BUFFER_FLAG_LAST_SAMPLE;
                            } else {
                                i16 = 268435456;
                            }
                            i3 |= i16;
                        }
                        i12 = i3;
                        if ((i12 & 306783379) != 306783378) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z3, i12 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "99@4736L11,100@4782L6,102@4872L14");
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i17 != 0) {
                                    companion = Modifier.INSTANCE;
                                } else {
                                    companion = modifier2;
                                }
                                if (i4 != 0) {
                                    z5 = true;
                                } else {
                                    z5 = z2;
                                }
                                if (i6 != 0) {
                                    mutableInteractionSource4 = null;
                                } else {
                                    mutableInteractionSource4 = mutableInteractionSource2;
                                }
                                if ((i2 & 16) != 0) {
                                    i12 &= -57345;
                                    buttonElevationM2302elevationR_JCAzs = ButtonDefaults.INSTANCE.m2302elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                                }
                                if ((i2 & 32) != 0) {
                                    small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                    i12 &= -458753;
                                } else {
                                    small = shape;
                                }
                                i13 = i12;
                                if (i8 != 0) {
                                    borderStroke3 = null;
                                } else {
                                    borderStroke3 = borderStroke;
                                }
                                if ((i2 & 128) != 0) {
                                    z6 = true;
                                    buttonColorsM2301buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m2301buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                    composer3 = composerStartRestartGroup;
                                    i13 &= -29360129;
                                } else {
                                    composer3 = composerStartRestartGroup;
                                    z6 = true;
                                    buttonColorsM2301buttonColorsro_MJ88 = buttonColors;
                                }
                                int i19 = i13;
                                if (i10 != 0) {
                                    contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                                } else {
                                    contentPadding = paddingValues;
                                }
                                shape3 = small;
                                borderStroke4 = borderStroke3;
                                z7 = z5;
                                modifier2 = companion;
                                i14 = i19;
                                r6 = z6;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 16) != 0) {
                                    i12 &= -57345;
                                }
                                if ((i2 & 32) != 0) {
                                    i12 &= -458753;
                                }
                                if ((i2 & 128) != 0) {
                                    i12 &= -29360129;
                                }
                                shape3 = shape;
                                borderStroke4 = borderStroke;
                                contentPadding = paddingValues;
                                z7 = z2;
                                mutableInteractionSource4 = mutableInteractionSource2;
                                r6 = 1;
                                i14 = i12;
                                composer3 = composerStartRestartGroup;
                                buttonColorsM2301buttonColorsro_MJ88 = buttonColors;
                            }
                            composer3.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1084573925, i14, -1, "androidx.compose.material.Button (Button.kt:105)");
                            }
                            if (mutableInteractionSource4 == null) {
                                composer3.startReplaceGroup(497721888);
                                ComposerKt.sourceInformation(composer3, "107@5086L39");
                                ComposerKt.sourceInformationMarkerStart(composer3, 1401528866, "CC(remember):Button.kt#9igjgp");
                                objRememberedValue2 = composer3.rememberedValue();
                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                                    composer3.updateRememberedValue(objRememberedValue2);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                composer3.endReplaceGroup();
                                mutableInteractionSource5 = (MutableInteractionSource) objRememberedValue2;
                            } else {
                                composer3.startReplaceGroup(1401528215);
                                composer3.endReplaceGroup();
                                mutableInteractionSource5 = mutableInteractionSource4;
                            }
                            i15 = i14 >> 6;
                            int i20 = (i15 & 14) | ((i14 >> 18) & 112);
                            final State<Color> stateContentColor = buttonColorsM2301buttonColorsro_MJ88.contentColor(z7, composer3, i20);
                            ComposerKt.sourceInformationMarkerStart(composer3, 1401534321, "CC(remember):Button.kt#9igjgp");
                            objRememberedValue = composer3.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function1() { // from class: androidx.compose.material.ButtonKt$$ExternalSyntheticLambda2
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return ButtonKt.Button$lambda$2$0((SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composer3.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            Modifier modifierSemantics$default = SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, r6, null);
                            long jM6824unboximpl = buttonColorsM2301buttonColorsro_MJ88.backgroundColor(z7, composer3, i20).getValue().m6824unboximpl();
                            long jM6813copywmQWz5c$default = Color.m6813copywmQWz5c$default(Button$lambda$1(stateContentColor), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                            if (buttonElevationM2302elevationR_JCAzs == null) {
                                composer3.startReplaceGroup(498128545);
                                composer3.endReplaceGroup();
                                stateElevation = null;
                            } else {
                                composer3.startReplaceGroup(1401541984);
                                ComposerKt.sourceInformation(composer3, "117@5496L37");
                                stateElevation = buttonElevationM2302elevationR_JCAzs.elevation(z7, mutableInteractionSource5, composer3, i15 & 910);
                                composer3.endReplaceGroup();
                            }
                            if (stateElevation != null) {
                                fM9687constructorimpl = stateElevation.getValue().m9701unboximpl();
                            } else {
                                fM9687constructorimpl = Dp.m9687constructorimpl(0);
                            }
                            Composer composer4 = composer3;
                            SurfaceKt.m2585SurfaceLPr_se0(function0, modifierSemantics$default, z7, shape3, jM6824unboximpl, jM6813copywmQWz5c$default, borderStroke4, fM9687constructorimpl, mutableInteractionSource5, ComposableLambdaKt.rememberComposableLambda(-20345758, r6, new Function2() { // from class: androidx.compose.material.ButtonKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ButtonKt.Button$lambda$3(stateContentColor, contentPadding, function3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54), composer4, (i14 & 14) | 805306368 | (i14 & 896) | (i15 & 7168) | (i14 & 3670016), 0);
                            composer2 = composer4;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            buttonColors2 = buttonColorsM2301buttonColorsro_MJ88;
                            buttonElevation2 = buttonElevationM2302elevationR_JCAzs;
                            shape2 = shape3;
                            borderStroke2 = borderStroke4;
                            mutableInteractionSource3 = mutableInteractionSource4;
                            paddingValues2 = contentPadding;
                            modifier3 = modifier2;
                            z4 = z7;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            shape2 = shape;
                            borderStroke2 = borderStroke;
                            modifier3 = modifier2;
                            z4 = z2;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            buttonElevation2 = buttonElevationM2302elevationR_JCAzs;
                            buttonColors2 = buttonColors;
                            paddingValues2 = paddingValues;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ButtonKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ButtonKt.Button$lambda$4(function0, modifier3, z4, mutableInteractionSource3, buttonElevation2, shape2, borderStroke2, buttonColors2, paddingValues2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 100663296;
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i16 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i16 = 268435456;
                        }
                        i3 |= i16;
                    }
                    i12 = i3;
                    if ((i12 & 306783379) != 306783378) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i12 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "99@4736L11,100@4782L6,102@4872L14");
                        if ((i & 1) != 0) {
                            if (i17 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i6 != 0) {
                                mutableInteractionSource4 = null;
                            } else {
                                mutableInteractionSource4 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                i12 &= -57345;
                                buttonElevationM2302elevationR_JCAzs = ButtonDefaults.INSTANCE.m2302elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            }
                            if ((i2 & 32) != 0) {
                                small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                i12 &= -458753;
                            } else {
                                small = shape;
                            }
                            i13 = i12;
                            if (i8 != 0) {
                                borderStroke3 = null;
                            } else {
                                borderStroke3 = borderStroke;
                            }
                            if ((i2 & 128) != 0) {
                                z6 = true;
                                buttonColorsM2301buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m2301buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                composer3 = composerStartRestartGroup;
                                i13 &= -29360129;
                            } else {
                                composer3 = composerStartRestartGroup;
                                z6 = true;
                                buttonColorsM2301buttonColorsro_MJ88 = buttonColors;
                            }
                            int i110 = i13;
                            if (i10 != 0) {
                                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                            } else {
                                contentPadding = paddingValues;
                            }
                            shape3 = small;
                            borderStroke4 = borderStroke3;
                            z7 = z5;
                            modifier2 = companion;
                            i14 = i110;
                            r6 = z6;
                        } else {
                            if (i17 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i6 != 0) {
                                mutableInteractionSource4 = null;
                            } else {
                                mutableInteractionSource4 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                i12 &= -57345;
                                buttonElevationM2302elevationR_JCAzs = ButtonDefaults.INSTANCE.m2302elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            }
                            if ((i2 & 32) != 0) {
                                small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                i12 &= -458753;
                            } else {
                                small = shape;
                            }
                            i13 = i12;
                            if (i8 != 0) {
                                borderStroke3 = null;
                            } else {
                                borderStroke3 = borderStroke;
                            }
                            if ((i2 & 128) != 0) {
                                z6 = true;
                                buttonColorsM2301buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m2301buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                composer3 = composerStartRestartGroup;
                                i13 &= -29360129;
                            } else {
                                composer3 = composerStartRestartGroup;
                                z6 = true;
                                buttonColorsM2301buttonColorsro_MJ88 = buttonColors;
                            }
                            int i111 = i13;
                            if (i10 != 0) {
                                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                            } else {
                                contentPadding = paddingValues;
                            }
                            shape3 = small;
                            borderStroke4 = borderStroke3;
                            z7 = z5;
                            modifier2 = companion;
                            i14 = i111;
                            r6 = z6;
                        }
                        composer3.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1084573925, i14, -1, "androidx.compose.material.Button (Button.kt:105)");
                        }
                        if (mutableInteractionSource4 == null) {
                            composer3.startReplaceGroup(497721888);
                            ComposerKt.sourceInformation(composer3, "107@5086L39");
                            ComposerKt.sourceInformationMarkerStart(composer3, 1401528866, "CC(remember):Button.kt#9igjgp");
                            objRememberedValue2 = composer3.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                                composer3.updateRememberedValue(objRememberedValue2);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            composer3.endReplaceGroup();
                            mutableInteractionSource5 = (MutableInteractionSource) objRememberedValue2;
                        } else {
                            composer3.startReplaceGroup(1401528215);
                            composer3.endReplaceGroup();
                            mutableInteractionSource5 = mutableInteractionSource4;
                        }
                        i15 = i14 >> 6;
                        int i21 = (i15 & 14) | ((i14 >> 18) & 112);
                        final State stateContentColor2 = buttonColorsM2301buttonColorsro_MJ88.contentColor(z7, composer3, i21);
                        ComposerKt.sourceInformationMarkerStart(composer3, 1401534321, "CC(remember):Button.kt#9igjgp");
                        objRememberedValue = composer3.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: androidx.compose.material.ButtonKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ButtonKt.Button$lambda$2$0((SemanticsPropertyReceiver) obj);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        Modifier modifierSemantics$default2 = SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, r6, null);
                        long jM6824unboximpl2 = buttonColorsM2301buttonColorsro_MJ88.backgroundColor(z7, composer3, i21).getValue().m6824unboximpl();
                        long jM6813copywmQWz5c$default2 = Color.m6813copywmQWz5c$default(Button$lambda$1(stateContentColor2), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                        if (buttonElevationM2302elevationR_JCAzs == null) {
                            composer3.startReplaceGroup(498128545);
                            composer3.endReplaceGroup();
                            stateElevation = null;
                        } else {
                            composer3.startReplaceGroup(1401541984);
                            ComposerKt.sourceInformation(composer3, "117@5496L37");
                            stateElevation = buttonElevationM2302elevationR_JCAzs.elevation(z7, mutableInteractionSource5, composer3, i15 & 910);
                            composer3.endReplaceGroup();
                        }
                        if (stateElevation != null) {
                            fM9687constructorimpl = stateElevation.getValue().m9701unboximpl();
                        } else {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        }
                        Composer composer5 = composer3;
                        SurfaceKt.m2585SurfaceLPr_se0(function0, modifierSemantics$default2, z7, shape3, jM6824unboximpl2, jM6813copywmQWz5c$default2, borderStroke4, fM9687constructorimpl, mutableInteractionSource5, ComposableLambdaKt.rememberComposableLambda(-20345758, r6, new Function2() { // from class: androidx.compose.material.ButtonKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ButtonKt.Button$lambda$3(stateContentColor2, contentPadding, function3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54), composer5, (i14 & 14) | 805306368 | (i14 & 896) | (i15 & 7168) | (i14 & 3670016), 0);
                        composer2 = composer5;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        buttonColors2 = buttonColorsM2301buttonColorsro_MJ88;
                        buttonElevation2 = buttonElevationM2302elevationR_JCAzs;
                        shape2 = shape3;
                        borderStroke2 = borderStroke4;
                        mutableInteractionSource3 = mutableInteractionSource4;
                        paddingValues2 = contentPadding;
                        modifier3 = modifier2;
                        z4 = z7;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        shape2 = shape;
                        borderStroke2 = borderStroke;
                        modifier3 = modifier2;
                        z4 = z2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        buttonElevation2 = buttonElevationM2302elevationR_JCAzs;
                        buttonColors2 = buttonColors;
                        paddingValues2 = paddingValues;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ButtonKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ButtonKt.Button$lambda$4(function0, modifier3, z4, mutableInteractionSource3, buttonElevation2, shape2, borderStroke2, buttonColors2, paddingValues2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 3072;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        buttonElevationM2302elevationR_JCAzs = buttonElevation;
                        if (composerStartRestartGroup.changed(buttonElevationM2302elevationR_JCAzs)) {
                        }
                        i3 |= i18;
                    } else {
                        buttonElevationM2302elevationR_JCAzs = buttonElevation;
                    }
                    i3 |= i18;
                } else {
                    buttonElevationM2302elevationR_JCAzs = buttonElevation;
                }
                if ((196608 & i) != 0) {
                    i3 |= ((i2 & 32) == 0 || !composerStartRestartGroup.changed(shape)) ? 65536 : 131072;
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    i3 |= 1572864;
                } else if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(borderStroke)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                if ((i & 12582912) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(buttonColors)) ? 4194304 : 8388608;
                }
                i10 = i2 & 256;
                if (i10 != 0) {
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(paddingValues)) {
                            i11 = 67108864;
                        } else {
                            i11 = 33554432;
                        }
                        i3 |= i11;
                    }
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i16 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i16 = 268435456;
                        }
                        i3 |= i16;
                    }
                    i12 = i3;
                    if ((i12 & 306783379) != 306783378) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i12 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "99@4736L11,100@4782L6,102@4872L14");
                        if ((i & 1) != 0) {
                            if (i17 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i6 != 0) {
                                mutableInteractionSource4 = null;
                            } else {
                                mutableInteractionSource4 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                i12 &= -57345;
                                buttonElevationM2302elevationR_JCAzs = ButtonDefaults.INSTANCE.m2302elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            }
                            if ((i2 & 32) != 0) {
                                small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                i12 &= -458753;
                            } else {
                                small = shape;
                            }
                            i13 = i12;
                            if (i8 != 0) {
                                borderStroke3 = null;
                            } else {
                                borderStroke3 = borderStroke;
                            }
                            if ((i2 & 128) != 0) {
                                z6 = true;
                                buttonColorsM2301buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m2301buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                composer3 = composerStartRestartGroup;
                                i13 &= -29360129;
                            } else {
                                composer3 = composerStartRestartGroup;
                                z6 = true;
                                buttonColorsM2301buttonColorsro_MJ88 = buttonColors;
                            }
                            int i112 = i13;
                            if (i10 != 0) {
                                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                            } else {
                                contentPadding = paddingValues;
                            }
                            shape3 = small;
                            borderStroke4 = borderStroke3;
                            z7 = z5;
                            modifier2 = companion;
                            i14 = i112;
                            r6 = z6;
                        } else {
                            if (i17 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i6 != 0) {
                                mutableInteractionSource4 = null;
                            } else {
                                mutableInteractionSource4 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                i12 &= -57345;
                                buttonElevationM2302elevationR_JCAzs = ButtonDefaults.INSTANCE.m2302elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            }
                            if ((i2 & 32) != 0) {
                                small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                i12 &= -458753;
                            } else {
                                small = shape;
                            }
                            i13 = i12;
                            if (i8 != 0) {
                                borderStroke3 = null;
                            } else {
                                borderStroke3 = borderStroke;
                            }
                            if ((i2 & 128) != 0) {
                                z6 = true;
                                buttonColorsM2301buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m2301buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                composer3 = composerStartRestartGroup;
                                i13 &= -29360129;
                            } else {
                                composer3 = composerStartRestartGroup;
                                z6 = true;
                                buttonColorsM2301buttonColorsro_MJ88 = buttonColors;
                            }
                            int i113 = i13;
                            if (i10 != 0) {
                                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                            } else {
                                contentPadding = paddingValues;
                            }
                            shape3 = small;
                            borderStroke4 = borderStroke3;
                            z7 = z5;
                            modifier2 = companion;
                            i14 = i113;
                            r6 = z6;
                        }
                        composer3.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1084573925, i14, -1, "androidx.compose.material.Button (Button.kt:105)");
                        }
                        if (mutableInteractionSource4 == null) {
                            composer3.startReplaceGroup(497721888);
                            ComposerKt.sourceInformation(composer3, "107@5086L39");
                            ComposerKt.sourceInformationMarkerStart(composer3, 1401528866, "CC(remember):Button.kt#9igjgp");
                            objRememberedValue2 = composer3.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                                composer3.updateRememberedValue(objRememberedValue2);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            composer3.endReplaceGroup();
                            mutableInteractionSource5 = (MutableInteractionSource) objRememberedValue2;
                        } else {
                            composer3.startReplaceGroup(1401528215);
                            composer3.endReplaceGroup();
                            mutableInteractionSource5 = mutableInteractionSource4;
                        }
                        i15 = i14 >> 6;
                        int i22 = (i15 & 14) | ((i14 >> 18) & 112);
                        final State stateContentColor3 = buttonColorsM2301buttonColorsro_MJ88.contentColor(z7, composer3, i22);
                        ComposerKt.sourceInformationMarkerStart(composer3, 1401534321, "CC(remember):Button.kt#9igjgp");
                        objRememberedValue = composer3.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: androidx.compose.material.ButtonKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ButtonKt.Button$lambda$2$0((SemanticsPropertyReceiver) obj);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        Modifier modifierSemantics$default3 = SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, r6, null);
                        long jM6824unboximpl3 = buttonColorsM2301buttonColorsro_MJ88.backgroundColor(z7, composer3, i22).getValue().m6824unboximpl();
                        long jM6813copywmQWz5c$default3 = Color.m6813copywmQWz5c$default(Button$lambda$1(stateContentColor3), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                        if (buttonElevationM2302elevationR_JCAzs == null) {
                            composer3.startReplaceGroup(498128545);
                            composer3.endReplaceGroup();
                            stateElevation = null;
                        } else {
                            composer3.startReplaceGroup(1401541984);
                            ComposerKt.sourceInformation(composer3, "117@5496L37");
                            stateElevation = buttonElevationM2302elevationR_JCAzs.elevation(z7, mutableInteractionSource5, composer3, i15 & 910);
                            composer3.endReplaceGroup();
                        }
                        if (stateElevation != null) {
                            fM9687constructorimpl = stateElevation.getValue().m9701unboximpl();
                        } else {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        }
                        Composer composer6 = composer3;
                        SurfaceKt.m2585SurfaceLPr_se0(function0, modifierSemantics$default3, z7, shape3, jM6824unboximpl3, jM6813copywmQWz5c$default3, borderStroke4, fM9687constructorimpl, mutableInteractionSource5, ComposableLambdaKt.rememberComposableLambda(-20345758, r6, new Function2() { // from class: androidx.compose.material.ButtonKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ButtonKt.Button$lambda$3(stateContentColor3, contentPadding, function3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54), composer6, (i14 & 14) | 805306368 | (i14 & 896) | (i15 & 7168) | (i14 & 3670016), 0);
                        composer2 = composer6;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        buttonColors2 = buttonColorsM2301buttonColorsro_MJ88;
                        buttonElevation2 = buttonElevationM2302elevationR_JCAzs;
                        shape2 = shape3;
                        borderStroke2 = borderStroke4;
                        mutableInteractionSource3 = mutableInteractionSource4;
                        paddingValues2 = contentPadding;
                        modifier3 = modifier2;
                        z4 = z7;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        shape2 = shape;
                        borderStroke2 = borderStroke;
                        modifier3 = modifier2;
                        z4 = z2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        buttonElevation2 = buttonElevationM2302elevationR_JCAzs;
                        buttonColors2 = buttonColors;
                        paddingValues2 = paddingValues;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ButtonKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ButtonKt.Button$lambda$4(function0, modifier3, z4, mutableInteractionSource3, buttonElevation2, shape2, borderStroke2, buttonColors2, paddingValues2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 100663296;
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i16 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i16 = 268435456;
                    }
                    i3 |= i16;
                }
                i12 = i3;
                if ((i12 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i12 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "99@4736L11,100@4782L6,102@4872L14");
                    if ((i & 1) != 0) {
                        if (i17 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            i12 &= -57345;
                            buttonElevationM2302elevationR_JCAzs = ButtonDefaults.INSTANCE.m2302elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        }
                        if ((i2 & 32) != 0) {
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i12 &= -458753;
                        } else {
                            small = shape;
                        }
                        i13 = i12;
                        if (i8 != 0) {
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            z6 = true;
                            buttonColorsM2301buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m2301buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            composer3 = composerStartRestartGroup;
                            i13 &= -29360129;
                        } else {
                            composer3 = composerStartRestartGroup;
                            z6 = true;
                            buttonColorsM2301buttonColorsro_MJ88 = buttonColors;
                        }
                        int i114 = i13;
                        if (i10 != 0) {
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding = paddingValues;
                        }
                        shape3 = small;
                        borderStroke4 = borderStroke3;
                        z7 = z5;
                        modifier2 = companion;
                        i14 = i114;
                        r6 = z6;
                    } else {
                        if (i17 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            i12 &= -57345;
                            buttonElevationM2302elevationR_JCAzs = ButtonDefaults.INSTANCE.m2302elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        }
                        if ((i2 & 32) != 0) {
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i12 &= -458753;
                        } else {
                            small = shape;
                        }
                        i13 = i12;
                        if (i8 != 0) {
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            z6 = true;
                            buttonColorsM2301buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m2301buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            composer3 = composerStartRestartGroup;
                            i13 &= -29360129;
                        } else {
                            composer3 = composerStartRestartGroup;
                            z6 = true;
                            buttonColorsM2301buttonColorsro_MJ88 = buttonColors;
                        }
                        int i115 = i13;
                        if (i10 != 0) {
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding = paddingValues;
                        }
                        shape3 = small;
                        borderStroke4 = borderStroke3;
                        z7 = z5;
                        modifier2 = companion;
                        i14 = i115;
                        r6 = z6;
                    }
                    composer3.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1084573925, i14, -1, "androidx.compose.material.Button (Button.kt:105)");
                    }
                    if (mutableInteractionSource4 == null) {
                        composer3.startReplaceGroup(497721888);
                        ComposerKt.sourceInformation(composer3, "107@5086L39");
                        ComposerKt.sourceInformationMarkerStart(composer3, 1401528866, "CC(remember):Button.kt#9igjgp");
                        objRememberedValue2 = composer3.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                            composer3.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endReplaceGroup();
                        mutableInteractionSource5 = (MutableInteractionSource) objRememberedValue2;
                    } else {
                        composer3.startReplaceGroup(1401528215);
                        composer3.endReplaceGroup();
                        mutableInteractionSource5 = mutableInteractionSource4;
                    }
                    i15 = i14 >> 6;
                    int i23 = (i15 & 14) | ((i14 >> 18) & 112);
                    final State stateContentColor4 = buttonColorsM2301buttonColorsro_MJ88.contentColor(z7, composer3, i23);
                    ComposerKt.sourceInformationMarkerStart(composer3, 1401534321, "CC(remember):Button.kt#9igjgp");
                    objRememberedValue = composer3.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material.ButtonKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ButtonKt.Button$lambda$2$0((SemanticsPropertyReceiver) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    Modifier modifierSemantics$default4 = SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, r6, null);
                    long jM6824unboximpl4 = buttonColorsM2301buttonColorsro_MJ88.backgroundColor(z7, composer3, i23).getValue().m6824unboximpl();
                    long jM6813copywmQWz5c$default4 = Color.m6813copywmQWz5c$default(Button$lambda$1(stateContentColor4), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                    if (buttonElevationM2302elevationR_JCAzs == null) {
                        composer3.startReplaceGroup(498128545);
                        composer3.endReplaceGroup();
                        stateElevation = null;
                    } else {
                        composer3.startReplaceGroup(1401541984);
                        ComposerKt.sourceInformation(composer3, "117@5496L37");
                        stateElevation = buttonElevationM2302elevationR_JCAzs.elevation(z7, mutableInteractionSource5, composer3, i15 & 910);
                        composer3.endReplaceGroup();
                    }
                    if (stateElevation != null) {
                        fM9687constructorimpl = stateElevation.getValue().m9701unboximpl();
                    } else {
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    }
                    Composer composer7 = composer3;
                    SurfaceKt.m2585SurfaceLPr_se0(function0, modifierSemantics$default4, z7, shape3, jM6824unboximpl4, jM6813copywmQWz5c$default4, borderStroke4, fM9687constructorimpl, mutableInteractionSource5, ComposableLambdaKt.rememberComposableLambda(-20345758, r6, new Function2() { // from class: androidx.compose.material.ButtonKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ButtonKt.Button$lambda$3(stateContentColor4, contentPadding, function3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer3, 54), composer7, (i14 & 14) | 805306368 | (i14 & 896) | (i15 & 7168) | (i14 & 3670016), 0);
                    composer2 = composer7;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    buttonColors2 = buttonColorsM2301buttonColorsro_MJ88;
                    buttonElevation2 = buttonElevationM2302elevationR_JCAzs;
                    shape2 = shape3;
                    borderStroke2 = borderStroke4;
                    mutableInteractionSource3 = mutableInteractionSource4;
                    paddingValues2 = contentPadding;
                    modifier3 = modifier2;
                    z4 = z7;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    shape2 = shape;
                    borderStroke2 = borderStroke;
                    modifier3 = modifier2;
                    z4 = z2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    buttonElevation2 = buttonElevationM2302elevationR_JCAzs;
                    buttonColors2 = buttonColors;
                    paddingValues2 = paddingValues;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ButtonKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ButtonKt.Button$lambda$4(function0, modifier3, z4, mutableInteractionSource3, buttonElevation2, shape2, borderStroke2, buttonColors2, paddingValues2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 384;
            z2 = z;
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        buttonElevationM2302elevationR_JCAzs = buttonElevation;
                        if (composerStartRestartGroup.changed(buttonElevationM2302elevationR_JCAzs)) {
                        }
                        i3 |= i18;
                    } else {
                        buttonElevationM2302elevationR_JCAzs = buttonElevation;
                    }
                    i3 |= i18;
                } else {
                    buttonElevationM2302elevationR_JCAzs = buttonElevation;
                }
                if ((196608 & i) != 0) {
                    i3 |= ((i2 & 32) == 0 || !composerStartRestartGroup.changed(shape)) ? 65536 : 131072;
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    i3 |= 1572864;
                } else if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(borderStroke)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                if ((i & 12582912) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(buttonColors)) ? 4194304 : 8388608;
                }
                i10 = i2 & 256;
                if (i10 != 0) {
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(paddingValues)) {
                            i11 = 67108864;
                        } else {
                            i11 = 33554432;
                        }
                        i3 |= i11;
                    }
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i16 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i16 = 268435456;
                        }
                        i3 |= i16;
                    }
                    i12 = i3;
                    if ((i12 & 306783379) != 306783378) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i12 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "99@4736L11,100@4782L6,102@4872L14");
                        if ((i & 1) != 0) {
                            if (i17 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i6 != 0) {
                                mutableInteractionSource4 = null;
                            } else {
                                mutableInteractionSource4 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                i12 &= -57345;
                                buttonElevationM2302elevationR_JCAzs = ButtonDefaults.INSTANCE.m2302elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            }
                            if ((i2 & 32) != 0) {
                                small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                i12 &= -458753;
                            } else {
                                small = shape;
                            }
                            i13 = i12;
                            if (i8 != 0) {
                                borderStroke3 = null;
                            } else {
                                borderStroke3 = borderStroke;
                            }
                            if ((i2 & 128) != 0) {
                                z6 = true;
                                buttonColorsM2301buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m2301buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                composer3 = composerStartRestartGroup;
                                i13 &= -29360129;
                            } else {
                                composer3 = composerStartRestartGroup;
                                z6 = true;
                                buttonColorsM2301buttonColorsro_MJ88 = buttonColors;
                            }
                            int i116 = i13;
                            if (i10 != 0) {
                                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                            } else {
                                contentPadding = paddingValues;
                            }
                            shape3 = small;
                            borderStroke4 = borderStroke3;
                            z7 = z5;
                            modifier2 = companion;
                            i14 = i116;
                            r6 = z6;
                        } else {
                            if (i17 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i6 != 0) {
                                mutableInteractionSource4 = null;
                            } else {
                                mutableInteractionSource4 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                i12 &= -57345;
                                buttonElevationM2302elevationR_JCAzs = ButtonDefaults.INSTANCE.m2302elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            }
                            if ((i2 & 32) != 0) {
                                small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                i12 &= -458753;
                            } else {
                                small = shape;
                            }
                            i13 = i12;
                            if (i8 != 0) {
                                borderStroke3 = null;
                            } else {
                                borderStroke3 = borderStroke;
                            }
                            if ((i2 & 128) != 0) {
                                z6 = true;
                                buttonColorsM2301buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m2301buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                composer3 = composerStartRestartGroup;
                                i13 &= -29360129;
                            } else {
                                composer3 = composerStartRestartGroup;
                                z6 = true;
                                buttonColorsM2301buttonColorsro_MJ88 = buttonColors;
                            }
                            int i117 = i13;
                            if (i10 != 0) {
                                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                            } else {
                                contentPadding = paddingValues;
                            }
                            shape3 = small;
                            borderStroke4 = borderStroke3;
                            z7 = z5;
                            modifier2 = companion;
                            i14 = i117;
                            r6 = z6;
                        }
                        composer3.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1084573925, i14, -1, "androidx.compose.material.Button (Button.kt:105)");
                        }
                        if (mutableInteractionSource4 == null) {
                            composer3.startReplaceGroup(497721888);
                            ComposerKt.sourceInformation(composer3, "107@5086L39");
                            ComposerKt.sourceInformationMarkerStart(composer3, 1401528866, "CC(remember):Button.kt#9igjgp");
                            objRememberedValue2 = composer3.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                                composer3.updateRememberedValue(objRememberedValue2);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            composer3.endReplaceGroup();
                            mutableInteractionSource5 = (MutableInteractionSource) objRememberedValue2;
                        } else {
                            composer3.startReplaceGroup(1401528215);
                            composer3.endReplaceGroup();
                            mutableInteractionSource5 = mutableInteractionSource4;
                        }
                        i15 = i14 >> 6;
                        int i24 = (i15 & 14) | ((i14 >> 18) & 112);
                        final State stateContentColor5 = buttonColorsM2301buttonColorsro_MJ88.contentColor(z7, composer3, i24);
                        ComposerKt.sourceInformationMarkerStart(composer3, 1401534321, "CC(remember):Button.kt#9igjgp");
                        objRememberedValue = composer3.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: androidx.compose.material.ButtonKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ButtonKt.Button$lambda$2$0((SemanticsPropertyReceiver) obj);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        Modifier modifierSemantics$default5 = SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, r6, null);
                        long jM6824unboximpl5 = buttonColorsM2301buttonColorsro_MJ88.backgroundColor(z7, composer3, i24).getValue().m6824unboximpl();
                        long jM6813copywmQWz5c$default5 = Color.m6813copywmQWz5c$default(Button$lambda$1(stateContentColor5), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                        if (buttonElevationM2302elevationR_JCAzs == null) {
                            composer3.startReplaceGroup(498128545);
                            composer3.endReplaceGroup();
                            stateElevation = null;
                        } else {
                            composer3.startReplaceGroup(1401541984);
                            ComposerKt.sourceInformation(composer3, "117@5496L37");
                            stateElevation = buttonElevationM2302elevationR_JCAzs.elevation(z7, mutableInteractionSource5, composer3, i15 & 910);
                            composer3.endReplaceGroup();
                        }
                        if (stateElevation != null) {
                            fM9687constructorimpl = stateElevation.getValue().m9701unboximpl();
                        } else {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        }
                        Composer composer8 = composer3;
                        SurfaceKt.m2585SurfaceLPr_se0(function0, modifierSemantics$default5, z7, shape3, jM6824unboximpl5, jM6813copywmQWz5c$default5, borderStroke4, fM9687constructorimpl, mutableInteractionSource5, ComposableLambdaKt.rememberComposableLambda(-20345758, r6, new Function2() { // from class: androidx.compose.material.ButtonKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ButtonKt.Button$lambda$3(stateContentColor5, contentPadding, function3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54), composer8, (i14 & 14) | 805306368 | (i14 & 896) | (i15 & 7168) | (i14 & 3670016), 0);
                        composer2 = composer8;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        buttonColors2 = buttonColorsM2301buttonColorsro_MJ88;
                        buttonElevation2 = buttonElevationM2302elevationR_JCAzs;
                        shape2 = shape3;
                        borderStroke2 = borderStroke4;
                        mutableInteractionSource3 = mutableInteractionSource4;
                        paddingValues2 = contentPadding;
                        modifier3 = modifier2;
                        z4 = z7;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        shape2 = shape;
                        borderStroke2 = borderStroke;
                        modifier3 = modifier2;
                        z4 = z2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        buttonElevation2 = buttonElevationM2302elevationR_JCAzs;
                        buttonColors2 = buttonColors;
                        paddingValues2 = paddingValues;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ButtonKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ButtonKt.Button$lambda$4(function0, modifier3, z4, mutableInteractionSource3, buttonElevation2, shape2, borderStroke2, buttonColors2, paddingValues2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 100663296;
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i16 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i16 = 268435456;
                    }
                    i3 |= i16;
                }
                i12 = i3;
                if ((i12 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i12 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "99@4736L11,100@4782L6,102@4872L14");
                    if ((i & 1) != 0) {
                        if (i17 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            i12 &= -57345;
                            buttonElevationM2302elevationR_JCAzs = ButtonDefaults.INSTANCE.m2302elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        }
                        if ((i2 & 32) != 0) {
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i12 &= -458753;
                        } else {
                            small = shape;
                        }
                        i13 = i12;
                        if (i8 != 0) {
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            z6 = true;
                            buttonColorsM2301buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m2301buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            composer3 = composerStartRestartGroup;
                            i13 &= -29360129;
                        } else {
                            composer3 = composerStartRestartGroup;
                            z6 = true;
                            buttonColorsM2301buttonColorsro_MJ88 = buttonColors;
                        }
                        int i118 = i13;
                        if (i10 != 0) {
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding = paddingValues;
                        }
                        shape3 = small;
                        borderStroke4 = borderStroke3;
                        z7 = z5;
                        modifier2 = companion;
                        i14 = i118;
                        r6 = z6;
                    } else {
                        if (i17 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            i12 &= -57345;
                            buttonElevationM2302elevationR_JCAzs = ButtonDefaults.INSTANCE.m2302elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        }
                        if ((i2 & 32) != 0) {
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i12 &= -458753;
                        } else {
                            small = shape;
                        }
                        i13 = i12;
                        if (i8 != 0) {
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            z6 = true;
                            buttonColorsM2301buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m2301buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            composer3 = composerStartRestartGroup;
                            i13 &= -29360129;
                        } else {
                            composer3 = composerStartRestartGroup;
                            z6 = true;
                            buttonColorsM2301buttonColorsro_MJ88 = buttonColors;
                        }
                        int i119 = i13;
                        if (i10 != 0) {
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding = paddingValues;
                        }
                        shape3 = small;
                        borderStroke4 = borderStroke3;
                        z7 = z5;
                        modifier2 = companion;
                        i14 = i119;
                        r6 = z6;
                    }
                    composer3.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1084573925, i14, -1, "androidx.compose.material.Button (Button.kt:105)");
                    }
                    if (mutableInteractionSource4 == null) {
                        composer3.startReplaceGroup(497721888);
                        ComposerKt.sourceInformation(composer3, "107@5086L39");
                        ComposerKt.sourceInformationMarkerStart(composer3, 1401528866, "CC(remember):Button.kt#9igjgp");
                        objRememberedValue2 = composer3.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                            composer3.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endReplaceGroup();
                        mutableInteractionSource5 = (MutableInteractionSource) objRememberedValue2;
                    } else {
                        composer3.startReplaceGroup(1401528215);
                        composer3.endReplaceGroup();
                        mutableInteractionSource5 = mutableInteractionSource4;
                    }
                    i15 = i14 >> 6;
                    int i25 = (i15 & 14) | ((i14 >> 18) & 112);
                    final State stateContentColor6 = buttonColorsM2301buttonColorsro_MJ88.contentColor(z7, composer3, i25);
                    ComposerKt.sourceInformationMarkerStart(composer3, 1401534321, "CC(remember):Button.kt#9igjgp");
                    objRememberedValue = composer3.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material.ButtonKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ButtonKt.Button$lambda$2$0((SemanticsPropertyReceiver) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    Modifier modifierSemantics$default6 = SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, r6, null);
                    long jM6824unboximpl6 = buttonColorsM2301buttonColorsro_MJ88.backgroundColor(z7, composer3, i25).getValue().m6824unboximpl();
                    long jM6813copywmQWz5c$default6 = Color.m6813copywmQWz5c$default(Button$lambda$1(stateContentColor6), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                    if (buttonElevationM2302elevationR_JCAzs == null) {
                        composer3.startReplaceGroup(498128545);
                        composer3.endReplaceGroup();
                        stateElevation = null;
                    } else {
                        composer3.startReplaceGroup(1401541984);
                        ComposerKt.sourceInformation(composer3, "117@5496L37");
                        stateElevation = buttonElevationM2302elevationR_JCAzs.elevation(z7, mutableInteractionSource5, composer3, i15 & 910);
                        composer3.endReplaceGroup();
                    }
                    if (stateElevation != null) {
                        fM9687constructorimpl = stateElevation.getValue().m9701unboximpl();
                    } else {
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    }
                    Composer composer9 = composer3;
                    SurfaceKt.m2585SurfaceLPr_se0(function0, modifierSemantics$default6, z7, shape3, jM6824unboximpl6, jM6813copywmQWz5c$default6, borderStroke4, fM9687constructorimpl, mutableInteractionSource5, ComposableLambdaKt.rememberComposableLambda(-20345758, r6, new Function2() { // from class: androidx.compose.material.ButtonKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ButtonKt.Button$lambda$3(stateContentColor6, contentPadding, function3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer3, 54), composer9, (i14 & 14) | 805306368 | (i14 & 896) | (i15 & 7168) | (i14 & 3670016), 0);
                    composer2 = composer9;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    buttonColors2 = buttonColorsM2301buttonColorsro_MJ88;
                    buttonElevation2 = buttonElevationM2302elevationR_JCAzs;
                    shape2 = shape3;
                    borderStroke2 = borderStroke4;
                    mutableInteractionSource3 = mutableInteractionSource4;
                    paddingValues2 = contentPadding;
                    modifier3 = modifier2;
                    z4 = z7;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    shape2 = shape;
                    borderStroke2 = borderStroke;
                    modifier3 = modifier2;
                    z4 = z2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    buttonElevation2 = buttonElevationM2302elevationR_JCAzs;
                    buttonColors2 = buttonColors;
                    paddingValues2 = paddingValues;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ButtonKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ButtonKt.Button$lambda$4(function0, modifier3, z4, mutableInteractionSource3, buttonElevation2, shape2, borderStroke2, buttonColors2, paddingValues2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    buttonElevationM2302elevationR_JCAzs = buttonElevation;
                    if (composerStartRestartGroup.changed(buttonElevationM2302elevationR_JCAzs)) {
                    }
                    i3 |= i18;
                } else {
                    buttonElevationM2302elevationR_JCAzs = buttonElevation;
                }
                i3 |= i18;
            } else {
                buttonElevationM2302elevationR_JCAzs = buttonElevation;
            }
            if ((196608 & i) != 0) {
                i3 |= ((i2 & 32) == 0 || !composerStartRestartGroup.changed(shape)) ? 65536 : 131072;
            }
            i8 = i2 & 64;
            if (i8 != 0) {
                i3 |= 1572864;
            } else if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changed(borderStroke)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            }
            if ((i & 12582912) != 0) {
                i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(buttonColors)) ? 4194304 : 8388608;
            }
            i10 = i2 & 256;
            if (i10 != 0) {
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(paddingValues)) {
                        i11 = 67108864;
                    } else {
                        i11 = 33554432;
                    }
                    i3 |= i11;
                }
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i16 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i16 = 268435456;
                    }
                    i3 |= i16;
                }
                i12 = i3;
                if ((i12 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i12 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "99@4736L11,100@4782L6,102@4872L14");
                    if ((i & 1) != 0) {
                        if (i17 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            i12 &= -57345;
                            buttonElevationM2302elevationR_JCAzs = ButtonDefaults.INSTANCE.m2302elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        }
                        if ((i2 & 32) != 0) {
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i12 &= -458753;
                        } else {
                            small = shape;
                        }
                        i13 = i12;
                        if (i8 != 0) {
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            z6 = true;
                            buttonColorsM2301buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m2301buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            composer3 = composerStartRestartGroup;
                            i13 &= -29360129;
                        } else {
                            composer3 = composerStartRestartGroup;
                            z6 = true;
                            buttonColorsM2301buttonColorsro_MJ88 = buttonColors;
                        }
                        int i1110 = i13;
                        if (i10 != 0) {
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding = paddingValues;
                        }
                        shape3 = small;
                        borderStroke4 = borderStroke3;
                        z7 = z5;
                        modifier2 = companion;
                        i14 = i1110;
                        r6 = z6;
                    } else {
                        if (i17 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            i12 &= -57345;
                            buttonElevationM2302elevationR_JCAzs = ButtonDefaults.INSTANCE.m2302elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        }
                        if ((i2 & 32) != 0) {
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i12 &= -458753;
                        } else {
                            small = shape;
                        }
                        i13 = i12;
                        if (i8 != 0) {
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            z6 = true;
                            buttonColorsM2301buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m2301buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            composer3 = composerStartRestartGroup;
                            i13 &= -29360129;
                        } else {
                            composer3 = composerStartRestartGroup;
                            z6 = true;
                            buttonColorsM2301buttonColorsro_MJ88 = buttonColors;
                        }
                        int i1111 = i13;
                        if (i10 != 0) {
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding = paddingValues;
                        }
                        shape3 = small;
                        borderStroke4 = borderStroke3;
                        z7 = z5;
                        modifier2 = companion;
                        i14 = i1111;
                        r6 = z6;
                    }
                    composer3.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1084573925, i14, -1, "androidx.compose.material.Button (Button.kt:105)");
                    }
                    if (mutableInteractionSource4 == null) {
                        composer3.startReplaceGroup(497721888);
                        ComposerKt.sourceInformation(composer3, "107@5086L39");
                        ComposerKt.sourceInformationMarkerStart(composer3, 1401528866, "CC(remember):Button.kt#9igjgp");
                        objRememberedValue2 = composer3.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                            composer3.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endReplaceGroup();
                        mutableInteractionSource5 = (MutableInteractionSource) objRememberedValue2;
                    } else {
                        composer3.startReplaceGroup(1401528215);
                        composer3.endReplaceGroup();
                        mutableInteractionSource5 = mutableInteractionSource4;
                    }
                    i15 = i14 >> 6;
                    int i26 = (i15 & 14) | ((i14 >> 18) & 112);
                    final State stateContentColor7 = buttonColorsM2301buttonColorsro_MJ88.contentColor(z7, composer3, i26);
                    ComposerKt.sourceInformationMarkerStart(composer3, 1401534321, "CC(remember):Button.kt#9igjgp");
                    objRememberedValue = composer3.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material.ButtonKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ButtonKt.Button$lambda$2$0((SemanticsPropertyReceiver) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    Modifier modifierSemantics$default7 = SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, r6, null);
                    long jM6824unboximpl7 = buttonColorsM2301buttonColorsro_MJ88.backgroundColor(z7, composer3, i26).getValue().m6824unboximpl();
                    long jM6813copywmQWz5c$default7 = Color.m6813copywmQWz5c$default(Button$lambda$1(stateContentColor7), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                    if (buttonElevationM2302elevationR_JCAzs == null) {
                        composer3.startReplaceGroup(498128545);
                        composer3.endReplaceGroup();
                        stateElevation = null;
                    } else {
                        composer3.startReplaceGroup(1401541984);
                        ComposerKt.sourceInformation(composer3, "117@5496L37");
                        stateElevation = buttonElevationM2302elevationR_JCAzs.elevation(z7, mutableInteractionSource5, composer3, i15 & 910);
                        composer3.endReplaceGroup();
                    }
                    if (stateElevation != null) {
                        fM9687constructorimpl = stateElevation.getValue().m9701unboximpl();
                    } else {
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    }
                    Composer composer10 = composer3;
                    SurfaceKt.m2585SurfaceLPr_se0(function0, modifierSemantics$default7, z7, shape3, jM6824unboximpl7, jM6813copywmQWz5c$default7, borderStroke4, fM9687constructorimpl, mutableInteractionSource5, ComposableLambdaKt.rememberComposableLambda(-20345758, r6, new Function2() { // from class: androidx.compose.material.ButtonKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ButtonKt.Button$lambda$3(stateContentColor7, contentPadding, function3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer3, 54), composer10, (i14 & 14) | 805306368 | (i14 & 896) | (i15 & 7168) | (i14 & 3670016), 0);
                    composer2 = composer10;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    buttonColors2 = buttonColorsM2301buttonColorsro_MJ88;
                    buttonElevation2 = buttonElevationM2302elevationR_JCAzs;
                    shape2 = shape3;
                    borderStroke2 = borderStroke4;
                    mutableInteractionSource3 = mutableInteractionSource4;
                    paddingValues2 = contentPadding;
                    modifier3 = modifier2;
                    z4 = z7;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    shape2 = shape;
                    borderStroke2 = borderStroke;
                    modifier3 = modifier2;
                    z4 = z2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    buttonElevation2 = buttonElevationM2302elevationR_JCAzs;
                    buttonColors2 = buttonColors;
                    paddingValues2 = paddingValues;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ButtonKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ButtonKt.Button$lambda$4(function0, modifier3, z4, mutableInteractionSource3, buttonElevation2, shape2, borderStroke2, buttonColors2, paddingValues2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 100663296;
            if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i16 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i16 = 268435456;
                }
                i3 |= i16;
            }
            i12 = i3;
            if ((i12 & 306783379) != 306783378) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i12 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "99@4736L11,100@4782L6,102@4872L14");
                if ((i & 1) != 0) {
                    if (i17 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    if ((i2 & 16) != 0) {
                        i12 &= -57345;
                        buttonElevationM2302elevationR_JCAzs = ButtonDefaults.INSTANCE.m2302elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    }
                    if ((i2 & 32) != 0) {
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i12 &= -458753;
                    } else {
                        small = shape;
                    }
                    i13 = i12;
                    if (i8 != 0) {
                        borderStroke3 = null;
                    } else {
                        borderStroke3 = borderStroke;
                    }
                    if ((i2 & 128) != 0) {
                        z6 = true;
                        buttonColorsM2301buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m2301buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        composer3 = composerStartRestartGroup;
                        i13 &= -29360129;
                    } else {
                        composer3 = composerStartRestartGroup;
                        z6 = true;
                        buttonColorsM2301buttonColorsro_MJ88 = buttonColors;
                    }
                    int i1112 = i13;
                    if (i10 != 0) {
                        contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                    } else {
                        contentPadding = paddingValues;
                    }
                    shape3 = small;
                    borderStroke4 = borderStroke3;
                    z7 = z5;
                    modifier2 = companion;
                    i14 = i1112;
                    r6 = z6;
                } else {
                    if (i17 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    if ((i2 & 16) != 0) {
                        i12 &= -57345;
                        buttonElevationM2302elevationR_JCAzs = ButtonDefaults.INSTANCE.m2302elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    }
                    if ((i2 & 32) != 0) {
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i12 &= -458753;
                    } else {
                        small = shape;
                    }
                    i13 = i12;
                    if (i8 != 0) {
                        borderStroke3 = null;
                    } else {
                        borderStroke3 = borderStroke;
                    }
                    if ((i2 & 128) != 0) {
                        z6 = true;
                        buttonColorsM2301buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m2301buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        composer3 = composerStartRestartGroup;
                        i13 &= -29360129;
                    } else {
                        composer3 = composerStartRestartGroup;
                        z6 = true;
                        buttonColorsM2301buttonColorsro_MJ88 = buttonColors;
                    }
                    int i1113 = i13;
                    if (i10 != 0) {
                        contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                    } else {
                        contentPadding = paddingValues;
                    }
                    shape3 = small;
                    borderStroke4 = borderStroke3;
                    z7 = z5;
                    modifier2 = companion;
                    i14 = i1113;
                    r6 = z6;
                }
                composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1084573925, i14, -1, "androidx.compose.material.Button (Button.kt:105)");
                }
                if (mutableInteractionSource4 == null) {
                    composer3.startReplaceGroup(497721888);
                    ComposerKt.sourceInformation(composer3, "107@5086L39");
                    ComposerKt.sourceInformationMarkerStart(composer3, 1401528866, "CC(remember):Button.kt#9igjgp");
                    objRememberedValue2 = composer3.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                        composer3.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endReplaceGroup();
                    mutableInteractionSource5 = (MutableInteractionSource) objRememberedValue2;
                } else {
                    composer3.startReplaceGroup(1401528215);
                    composer3.endReplaceGroup();
                    mutableInteractionSource5 = mutableInteractionSource4;
                }
                i15 = i14 >> 6;
                int i27 = (i15 & 14) | ((i14 >> 18) & 112);
                final State stateContentColor8 = buttonColorsM2301buttonColorsro_MJ88.contentColor(z7, composer3, i27);
                ComposerKt.sourceInformationMarkerStart(composer3, 1401534321, "CC(remember):Button.kt#9igjgp");
                objRememberedValue = composer3.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material.ButtonKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ButtonKt.Button$lambda$2$0((SemanticsPropertyReceiver) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                Modifier modifierSemantics$default8 = SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, r6, null);
                long jM6824unboximpl8 = buttonColorsM2301buttonColorsro_MJ88.backgroundColor(z7, composer3, i27).getValue().m6824unboximpl();
                long jM6813copywmQWz5c$default8 = Color.m6813copywmQWz5c$default(Button$lambda$1(stateContentColor8), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                if (buttonElevationM2302elevationR_JCAzs == null) {
                    composer3.startReplaceGroup(498128545);
                    composer3.endReplaceGroup();
                    stateElevation = null;
                } else {
                    composer3.startReplaceGroup(1401541984);
                    ComposerKt.sourceInformation(composer3, "117@5496L37");
                    stateElevation = buttonElevationM2302elevationR_JCAzs.elevation(z7, mutableInteractionSource5, composer3, i15 & 910);
                    composer3.endReplaceGroup();
                }
                if (stateElevation != null) {
                    fM9687constructorimpl = stateElevation.getValue().m9701unboximpl();
                } else {
                    fM9687constructorimpl = Dp.m9687constructorimpl(0);
                }
                Composer composer11 = composer3;
                SurfaceKt.m2585SurfaceLPr_se0(function0, modifierSemantics$default8, z7, shape3, jM6824unboximpl8, jM6813copywmQWz5c$default8, borderStroke4, fM9687constructorimpl, mutableInteractionSource5, ComposableLambdaKt.rememberComposableLambda(-20345758, r6, new Function2() { // from class: androidx.compose.material.ButtonKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ButtonKt.Button$lambda$3(stateContentColor8, contentPadding, function3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer3, 54), composer11, (i14 & 14) | 805306368 | (i14 & 896) | (i15 & 7168) | (i14 & 3670016), 0);
                composer2 = composer11;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                buttonColors2 = buttonColorsM2301buttonColorsro_MJ88;
                buttonElevation2 = buttonElevationM2302elevationR_JCAzs;
                shape2 = shape3;
                borderStroke2 = borderStroke4;
                mutableInteractionSource3 = mutableInteractionSource4;
                paddingValues2 = contentPadding;
                modifier3 = modifier2;
                z4 = z7;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                shape2 = shape;
                borderStroke2 = borderStroke;
                modifier3 = modifier2;
                z4 = z2;
                mutableInteractionSource3 = mutableInteractionSource2;
                buttonElevation2 = buttonElevationM2302elevationR_JCAzs;
                buttonColors2 = buttonColors;
                paddingValues2 = paddingValues;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ButtonKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ButtonKt.Button$lambda$4(function0, modifier3, z4, mutableInteractionSource3, buttonElevation2, shape2, borderStroke2, buttonColors2, paddingValues2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        buttonElevationM2302elevationR_JCAzs = buttonElevation;
                        if (composerStartRestartGroup.changed(buttonElevationM2302elevationR_JCAzs)) {
                        }
                        i3 |= i18;
                    } else {
                        buttonElevationM2302elevationR_JCAzs = buttonElevation;
                    }
                    i3 |= i18;
                } else {
                    buttonElevationM2302elevationR_JCAzs = buttonElevation;
                }
                if ((196608 & i) != 0) {
                    i3 |= ((i2 & 32) == 0 || !composerStartRestartGroup.changed(shape)) ? 65536 : 131072;
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    i3 |= 1572864;
                } else if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(borderStroke)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                if ((i & 12582912) != 0) {
                    i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(buttonColors)) ? 4194304 : 8388608;
                }
                i10 = i2 & 256;
                if (i10 != 0) {
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changed(paddingValues)) {
                            i11 = 67108864;
                        } else {
                            i11 = 33554432;
                        }
                        i3 |= i11;
                    }
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i16 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i16 = 268435456;
                        }
                        i3 |= i16;
                    }
                    i12 = i3;
                    if ((i12 & 306783379) != 306783378) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i12 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "99@4736L11,100@4782L6,102@4872L14");
                        if ((i & 1) != 0) {
                            if (i17 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i6 != 0) {
                                mutableInteractionSource4 = null;
                            } else {
                                mutableInteractionSource4 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                i12 &= -57345;
                                buttonElevationM2302elevationR_JCAzs = ButtonDefaults.INSTANCE.m2302elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            }
                            if ((i2 & 32) != 0) {
                                small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                i12 &= -458753;
                            } else {
                                small = shape;
                            }
                            i13 = i12;
                            if (i8 != 0) {
                                borderStroke3 = null;
                            } else {
                                borderStroke3 = borderStroke;
                            }
                            if ((i2 & 128) != 0) {
                                z6 = true;
                                buttonColorsM2301buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m2301buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                composer3 = composerStartRestartGroup;
                                i13 &= -29360129;
                            } else {
                                composer3 = composerStartRestartGroup;
                                z6 = true;
                                buttonColorsM2301buttonColorsro_MJ88 = buttonColors;
                            }
                            int i1114 = i13;
                            if (i10 != 0) {
                                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                            } else {
                                contentPadding = paddingValues;
                            }
                            shape3 = small;
                            borderStroke4 = borderStroke3;
                            z7 = z5;
                            modifier2 = companion;
                            i14 = i1114;
                            r6 = z6;
                        } else {
                            if (i17 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i4 != 0) {
                                z5 = true;
                            } else {
                                z5 = z2;
                            }
                            if (i6 != 0) {
                                mutableInteractionSource4 = null;
                            } else {
                                mutableInteractionSource4 = mutableInteractionSource2;
                            }
                            if ((i2 & 16) != 0) {
                                i12 &= -57345;
                                buttonElevationM2302elevationR_JCAzs = ButtonDefaults.INSTANCE.m2302elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                            }
                            if ((i2 & 32) != 0) {
                                small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                                i12 &= -458753;
                            } else {
                                small = shape;
                            }
                            i13 = i12;
                            if (i8 != 0) {
                                borderStroke3 = null;
                            } else {
                                borderStroke3 = borderStroke;
                            }
                            if ((i2 & 128) != 0) {
                                z6 = true;
                                buttonColorsM2301buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m2301buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                                composer3 = composerStartRestartGroup;
                                i13 &= -29360129;
                            } else {
                                composer3 = composerStartRestartGroup;
                                z6 = true;
                                buttonColorsM2301buttonColorsro_MJ88 = buttonColors;
                            }
                            int i1115 = i13;
                            if (i10 != 0) {
                                contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                            } else {
                                contentPadding = paddingValues;
                            }
                            shape3 = small;
                            borderStroke4 = borderStroke3;
                            z7 = z5;
                            modifier2 = companion;
                            i14 = i1115;
                            r6 = z6;
                        }
                        composer3.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1084573925, i14, -1, "androidx.compose.material.Button (Button.kt:105)");
                        }
                        if (mutableInteractionSource4 == null) {
                            composer3.startReplaceGroup(497721888);
                            ComposerKt.sourceInformation(composer3, "107@5086L39");
                            ComposerKt.sourceInformationMarkerStart(composer3, 1401528866, "CC(remember):Button.kt#9igjgp");
                            objRememberedValue2 = composer3.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                                composer3.updateRememberedValue(objRememberedValue2);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            composer3.endReplaceGroup();
                            mutableInteractionSource5 = (MutableInteractionSource) objRememberedValue2;
                        } else {
                            composer3.startReplaceGroup(1401528215);
                            composer3.endReplaceGroup();
                            mutableInteractionSource5 = mutableInteractionSource4;
                        }
                        i15 = i14 >> 6;
                        int i28 = (i15 & 14) | ((i14 >> 18) & 112);
                        final State stateContentColor9 = buttonColorsM2301buttonColorsro_MJ88.contentColor(z7, composer3, i28);
                        ComposerKt.sourceInformationMarkerStart(composer3, 1401534321, "CC(remember):Button.kt#9igjgp");
                        objRememberedValue = composer3.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: androidx.compose.material.ButtonKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ButtonKt.Button$lambda$2$0((SemanticsPropertyReceiver) obj);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        Modifier modifierSemantics$default9 = SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, r6, null);
                        long jM6824unboximpl9 = buttonColorsM2301buttonColorsro_MJ88.backgroundColor(z7, composer3, i28).getValue().m6824unboximpl();
                        long jM6813copywmQWz5c$default9 = Color.m6813copywmQWz5c$default(Button$lambda$1(stateContentColor9), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                        if (buttonElevationM2302elevationR_JCAzs == null) {
                            composer3.startReplaceGroup(498128545);
                            composer3.endReplaceGroup();
                            stateElevation = null;
                        } else {
                            composer3.startReplaceGroup(1401541984);
                            ComposerKt.sourceInformation(composer3, "117@5496L37");
                            stateElevation = buttonElevationM2302elevationR_JCAzs.elevation(z7, mutableInteractionSource5, composer3, i15 & 910);
                            composer3.endReplaceGroup();
                        }
                        if (stateElevation != null) {
                            fM9687constructorimpl = stateElevation.getValue().m9701unboximpl();
                        } else {
                            fM9687constructorimpl = Dp.m9687constructorimpl(0);
                        }
                        Composer composer12 = composer3;
                        SurfaceKt.m2585SurfaceLPr_se0(function0, modifierSemantics$default9, z7, shape3, jM6824unboximpl9, jM6813copywmQWz5c$default9, borderStroke4, fM9687constructorimpl, mutableInteractionSource5, ComposableLambdaKt.rememberComposableLambda(-20345758, r6, new Function2() { // from class: androidx.compose.material.ButtonKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ButtonKt.Button$lambda$3(stateContentColor9, contentPadding, function3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54), composer12, (i14 & 14) | 805306368 | (i14 & 896) | (i15 & 7168) | (i14 & 3670016), 0);
                        composer2 = composer12;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        buttonColors2 = buttonColorsM2301buttonColorsro_MJ88;
                        buttonElevation2 = buttonElevationM2302elevationR_JCAzs;
                        shape2 = shape3;
                        borderStroke2 = borderStroke4;
                        mutableInteractionSource3 = mutableInteractionSource4;
                        paddingValues2 = contentPadding;
                        modifier3 = modifier2;
                        z4 = z7;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        shape2 = shape;
                        borderStroke2 = borderStroke;
                        modifier3 = modifier2;
                        z4 = z2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        buttonElevation2 = buttonElevationM2302elevationR_JCAzs;
                        buttonColors2 = buttonColors;
                        paddingValues2 = paddingValues;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ButtonKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ButtonKt.Button$lambda$4(function0, modifier3, z4, mutableInteractionSource3, buttonElevation2, shape2, borderStroke2, buttonColors2, paddingValues2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 100663296;
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i16 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i16 = 268435456;
                    }
                    i3 |= i16;
                }
                i12 = i3;
                if ((i12 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i12 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "99@4736L11,100@4782L6,102@4872L14");
                    if ((i & 1) != 0) {
                        if (i17 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            i12 &= -57345;
                            buttonElevationM2302elevationR_JCAzs = ButtonDefaults.INSTANCE.m2302elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        }
                        if ((i2 & 32) != 0) {
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i12 &= -458753;
                        } else {
                            small = shape;
                        }
                        i13 = i12;
                        if (i8 != 0) {
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            z6 = true;
                            buttonColorsM2301buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m2301buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            composer3 = composerStartRestartGroup;
                            i13 &= -29360129;
                        } else {
                            composer3 = composerStartRestartGroup;
                            z6 = true;
                            buttonColorsM2301buttonColorsro_MJ88 = buttonColors;
                        }
                        int i1116 = i13;
                        if (i10 != 0) {
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding = paddingValues;
                        }
                        shape3 = small;
                        borderStroke4 = borderStroke3;
                        z7 = z5;
                        modifier2 = companion;
                        i14 = i1116;
                        r6 = z6;
                    } else {
                        if (i17 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            i12 &= -57345;
                            buttonElevationM2302elevationR_JCAzs = ButtonDefaults.INSTANCE.m2302elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        }
                        if ((i2 & 32) != 0) {
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i12 &= -458753;
                        } else {
                            small = shape;
                        }
                        i13 = i12;
                        if (i8 != 0) {
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            z6 = true;
                            buttonColorsM2301buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m2301buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            composer3 = composerStartRestartGroup;
                            i13 &= -29360129;
                        } else {
                            composer3 = composerStartRestartGroup;
                            z6 = true;
                            buttonColorsM2301buttonColorsro_MJ88 = buttonColors;
                        }
                        int i1117 = i13;
                        if (i10 != 0) {
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding = paddingValues;
                        }
                        shape3 = small;
                        borderStroke4 = borderStroke3;
                        z7 = z5;
                        modifier2 = companion;
                        i14 = i1117;
                        r6 = z6;
                    }
                    composer3.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1084573925, i14, -1, "androidx.compose.material.Button (Button.kt:105)");
                    }
                    if (mutableInteractionSource4 == null) {
                        composer3.startReplaceGroup(497721888);
                        ComposerKt.sourceInformation(composer3, "107@5086L39");
                        ComposerKt.sourceInformationMarkerStart(composer3, 1401528866, "CC(remember):Button.kt#9igjgp");
                        objRememberedValue2 = composer3.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                            composer3.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endReplaceGroup();
                        mutableInteractionSource5 = (MutableInteractionSource) objRememberedValue2;
                    } else {
                        composer3.startReplaceGroup(1401528215);
                        composer3.endReplaceGroup();
                        mutableInteractionSource5 = mutableInteractionSource4;
                    }
                    i15 = i14 >> 6;
                    int i29 = (i15 & 14) | ((i14 >> 18) & 112);
                    final State stateContentColor10 = buttonColorsM2301buttonColorsro_MJ88.contentColor(z7, composer3, i29);
                    ComposerKt.sourceInformationMarkerStart(composer3, 1401534321, "CC(remember):Button.kt#9igjgp");
                    objRememberedValue = composer3.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material.ButtonKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ButtonKt.Button$lambda$2$0((SemanticsPropertyReceiver) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    Modifier modifierSemantics$default10 = SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, r6, null);
                    long jM6824unboximpl10 = buttonColorsM2301buttonColorsro_MJ88.backgroundColor(z7, composer3, i29).getValue().m6824unboximpl();
                    long jM6813copywmQWz5c$default10 = Color.m6813copywmQWz5c$default(Button$lambda$1(stateContentColor10), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                    if (buttonElevationM2302elevationR_JCAzs == null) {
                        composer3.startReplaceGroup(498128545);
                        composer3.endReplaceGroup();
                        stateElevation = null;
                    } else {
                        composer3.startReplaceGroup(1401541984);
                        ComposerKt.sourceInformation(composer3, "117@5496L37");
                        stateElevation = buttonElevationM2302elevationR_JCAzs.elevation(z7, mutableInteractionSource5, composer3, i15 & 910);
                        composer3.endReplaceGroup();
                    }
                    if (stateElevation != null) {
                        fM9687constructorimpl = stateElevation.getValue().m9701unboximpl();
                    } else {
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    }
                    Composer composer13 = composer3;
                    SurfaceKt.m2585SurfaceLPr_se0(function0, modifierSemantics$default10, z7, shape3, jM6824unboximpl10, jM6813copywmQWz5c$default10, borderStroke4, fM9687constructorimpl, mutableInteractionSource5, ComposableLambdaKt.rememberComposableLambda(-20345758, r6, new Function2() { // from class: androidx.compose.material.ButtonKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ButtonKt.Button$lambda$3(stateContentColor10, contentPadding, function3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer3, 54), composer13, (i14 & 14) | 805306368 | (i14 & 896) | (i15 & 7168) | (i14 & 3670016), 0);
                    composer2 = composer13;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    buttonColors2 = buttonColorsM2301buttonColorsro_MJ88;
                    buttonElevation2 = buttonElevationM2302elevationR_JCAzs;
                    shape2 = shape3;
                    borderStroke2 = borderStroke4;
                    mutableInteractionSource3 = mutableInteractionSource4;
                    paddingValues2 = contentPadding;
                    modifier3 = modifier2;
                    z4 = z7;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    shape2 = shape;
                    borderStroke2 = borderStroke;
                    modifier3 = modifier2;
                    z4 = z2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    buttonElevation2 = buttonElevationM2302elevationR_JCAzs;
                    buttonColors2 = buttonColors;
                    paddingValues2 = paddingValues;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ButtonKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ButtonKt.Button$lambda$4(function0, modifier3, z4, mutableInteractionSource3, buttonElevation2, shape2, borderStroke2, buttonColors2, paddingValues2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    buttonElevationM2302elevationR_JCAzs = buttonElevation;
                    if (composerStartRestartGroup.changed(buttonElevationM2302elevationR_JCAzs)) {
                    }
                    i3 |= i18;
                } else {
                    buttonElevationM2302elevationR_JCAzs = buttonElevation;
                }
                i3 |= i18;
            } else {
                buttonElevationM2302elevationR_JCAzs = buttonElevation;
            }
            if ((196608 & i) != 0) {
                i3 |= ((i2 & 32) == 0 || !composerStartRestartGroup.changed(shape)) ? 65536 : 131072;
            }
            i8 = i2 & 64;
            if (i8 != 0) {
                i3 |= 1572864;
            } else if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changed(borderStroke)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            }
            if ((i & 12582912) != 0) {
                i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(buttonColors)) ? 4194304 : 8388608;
            }
            i10 = i2 & 256;
            if (i10 != 0) {
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(paddingValues)) {
                        i11 = 67108864;
                    } else {
                        i11 = 33554432;
                    }
                    i3 |= i11;
                }
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i16 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i16 = 268435456;
                    }
                    i3 |= i16;
                }
                i12 = i3;
                if ((i12 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i12 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "99@4736L11,100@4782L6,102@4872L14");
                    if ((i & 1) != 0) {
                        if (i17 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            i12 &= -57345;
                            buttonElevationM2302elevationR_JCAzs = ButtonDefaults.INSTANCE.m2302elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        }
                        if ((i2 & 32) != 0) {
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i12 &= -458753;
                        } else {
                            small = shape;
                        }
                        i13 = i12;
                        if (i8 != 0) {
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            z6 = true;
                            buttonColorsM2301buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m2301buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            composer3 = composerStartRestartGroup;
                            i13 &= -29360129;
                        } else {
                            composer3 = composerStartRestartGroup;
                            z6 = true;
                            buttonColorsM2301buttonColorsro_MJ88 = buttonColors;
                        }
                        int i1118 = i13;
                        if (i10 != 0) {
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding = paddingValues;
                        }
                        shape3 = small;
                        borderStroke4 = borderStroke3;
                        z7 = z5;
                        modifier2 = companion;
                        i14 = i1118;
                        r6 = z6;
                    } else {
                        if (i17 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            i12 &= -57345;
                            buttonElevationM2302elevationR_JCAzs = ButtonDefaults.INSTANCE.m2302elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        }
                        if ((i2 & 32) != 0) {
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i12 &= -458753;
                        } else {
                            small = shape;
                        }
                        i13 = i12;
                        if (i8 != 0) {
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            z6 = true;
                            buttonColorsM2301buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m2301buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            composer3 = composerStartRestartGroup;
                            i13 &= -29360129;
                        } else {
                            composer3 = composerStartRestartGroup;
                            z6 = true;
                            buttonColorsM2301buttonColorsro_MJ88 = buttonColors;
                        }
                        int i1119 = i13;
                        if (i10 != 0) {
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding = paddingValues;
                        }
                        shape3 = small;
                        borderStroke4 = borderStroke3;
                        z7 = z5;
                        modifier2 = companion;
                        i14 = i1119;
                        r6 = z6;
                    }
                    composer3.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1084573925, i14, -1, "androidx.compose.material.Button (Button.kt:105)");
                    }
                    if (mutableInteractionSource4 == null) {
                        composer3.startReplaceGroup(497721888);
                        ComposerKt.sourceInformation(composer3, "107@5086L39");
                        ComposerKt.sourceInformationMarkerStart(composer3, 1401528866, "CC(remember):Button.kt#9igjgp");
                        objRememberedValue2 = composer3.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                            composer3.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endReplaceGroup();
                        mutableInteractionSource5 = (MutableInteractionSource) objRememberedValue2;
                    } else {
                        composer3.startReplaceGroup(1401528215);
                        composer3.endReplaceGroup();
                        mutableInteractionSource5 = mutableInteractionSource4;
                    }
                    i15 = i14 >> 6;
                    int i210 = (i15 & 14) | ((i14 >> 18) & 112);
                    final State stateContentColor11 = buttonColorsM2301buttonColorsro_MJ88.contentColor(z7, composer3, i210);
                    ComposerKt.sourceInformationMarkerStart(composer3, 1401534321, "CC(remember):Button.kt#9igjgp");
                    objRememberedValue = composer3.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material.ButtonKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ButtonKt.Button$lambda$2$0((SemanticsPropertyReceiver) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    Modifier modifierSemantics$default11 = SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, r6, null);
                    long jM6824unboximpl11 = buttonColorsM2301buttonColorsro_MJ88.backgroundColor(z7, composer3, i210).getValue().m6824unboximpl();
                    long jM6813copywmQWz5c$default11 = Color.m6813copywmQWz5c$default(Button$lambda$1(stateContentColor11), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                    if (buttonElevationM2302elevationR_JCAzs == null) {
                        composer3.startReplaceGroup(498128545);
                        composer3.endReplaceGroup();
                        stateElevation = null;
                    } else {
                        composer3.startReplaceGroup(1401541984);
                        ComposerKt.sourceInformation(composer3, "117@5496L37");
                        stateElevation = buttonElevationM2302elevationR_JCAzs.elevation(z7, mutableInteractionSource5, composer3, i15 & 910);
                        composer3.endReplaceGroup();
                    }
                    if (stateElevation != null) {
                        fM9687constructorimpl = stateElevation.getValue().m9701unboximpl();
                    } else {
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    }
                    Composer composer14 = composer3;
                    SurfaceKt.m2585SurfaceLPr_se0(function0, modifierSemantics$default11, z7, shape3, jM6824unboximpl11, jM6813copywmQWz5c$default11, borderStroke4, fM9687constructorimpl, mutableInteractionSource5, ComposableLambdaKt.rememberComposableLambda(-20345758, r6, new Function2() { // from class: androidx.compose.material.ButtonKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ButtonKt.Button$lambda$3(stateContentColor11, contentPadding, function3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer3, 54), composer14, (i14 & 14) | 805306368 | (i14 & 896) | (i15 & 7168) | (i14 & 3670016), 0);
                    composer2 = composer14;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    buttonColors2 = buttonColorsM2301buttonColorsro_MJ88;
                    buttonElevation2 = buttonElevationM2302elevationR_JCAzs;
                    shape2 = shape3;
                    borderStroke2 = borderStroke4;
                    mutableInteractionSource3 = mutableInteractionSource4;
                    paddingValues2 = contentPadding;
                    modifier3 = modifier2;
                    z4 = z7;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    shape2 = shape;
                    borderStroke2 = borderStroke;
                    modifier3 = modifier2;
                    z4 = z2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    buttonElevation2 = buttonElevationM2302elevationR_JCAzs;
                    buttonColors2 = buttonColors;
                    paddingValues2 = paddingValues;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ButtonKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ButtonKt.Button$lambda$4(function0, modifier3, z4, mutableInteractionSource3, buttonElevation2, shape2, borderStroke2, buttonColors2, paddingValues2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 100663296;
            if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i16 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i16 = 268435456;
                }
                i3 |= i16;
            }
            i12 = i3;
            if ((i12 & 306783379) != 306783378) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i12 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "99@4736L11,100@4782L6,102@4872L14");
                if ((i & 1) != 0) {
                    if (i17 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    if ((i2 & 16) != 0) {
                        i12 &= -57345;
                        buttonElevationM2302elevationR_JCAzs = ButtonDefaults.INSTANCE.m2302elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    }
                    if ((i2 & 32) != 0) {
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i12 &= -458753;
                    } else {
                        small = shape;
                    }
                    i13 = i12;
                    if (i8 != 0) {
                        borderStroke3 = null;
                    } else {
                        borderStroke3 = borderStroke;
                    }
                    if ((i2 & 128) != 0) {
                        z6 = true;
                        buttonColorsM2301buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m2301buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        composer3 = composerStartRestartGroup;
                        i13 &= -29360129;
                    } else {
                        composer3 = composerStartRestartGroup;
                        z6 = true;
                        buttonColorsM2301buttonColorsro_MJ88 = buttonColors;
                    }
                    int i11110 = i13;
                    if (i10 != 0) {
                        contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                    } else {
                        contentPadding = paddingValues;
                    }
                    shape3 = small;
                    borderStroke4 = borderStroke3;
                    z7 = z5;
                    modifier2 = companion;
                    i14 = i11110;
                    r6 = z6;
                } else {
                    if (i17 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    if ((i2 & 16) != 0) {
                        i12 &= -57345;
                        buttonElevationM2302elevationR_JCAzs = ButtonDefaults.INSTANCE.m2302elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    }
                    if ((i2 & 32) != 0) {
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i12 &= -458753;
                    } else {
                        small = shape;
                    }
                    i13 = i12;
                    if (i8 != 0) {
                        borderStroke3 = null;
                    } else {
                        borderStroke3 = borderStroke;
                    }
                    if ((i2 & 128) != 0) {
                        z6 = true;
                        buttonColorsM2301buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m2301buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        composer3 = composerStartRestartGroup;
                        i13 &= -29360129;
                    } else {
                        composer3 = composerStartRestartGroup;
                        z6 = true;
                        buttonColorsM2301buttonColorsro_MJ88 = buttonColors;
                    }
                    int i11111 = i13;
                    if (i10 != 0) {
                        contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                    } else {
                        contentPadding = paddingValues;
                    }
                    shape3 = small;
                    borderStroke4 = borderStroke3;
                    z7 = z5;
                    modifier2 = companion;
                    i14 = i11111;
                    r6 = z6;
                }
                composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1084573925, i14, -1, "androidx.compose.material.Button (Button.kt:105)");
                }
                if (mutableInteractionSource4 == null) {
                    composer3.startReplaceGroup(497721888);
                    ComposerKt.sourceInformation(composer3, "107@5086L39");
                    ComposerKt.sourceInformationMarkerStart(composer3, 1401528866, "CC(remember):Button.kt#9igjgp");
                    objRememberedValue2 = composer3.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                        composer3.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endReplaceGroup();
                    mutableInteractionSource5 = (MutableInteractionSource) objRememberedValue2;
                } else {
                    composer3.startReplaceGroup(1401528215);
                    composer3.endReplaceGroup();
                    mutableInteractionSource5 = mutableInteractionSource4;
                }
                i15 = i14 >> 6;
                int i211 = (i15 & 14) | ((i14 >> 18) & 112);
                final State stateContentColor12 = buttonColorsM2301buttonColorsro_MJ88.contentColor(z7, composer3, i211);
                ComposerKt.sourceInformationMarkerStart(composer3, 1401534321, "CC(remember):Button.kt#9igjgp");
                objRememberedValue = composer3.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material.ButtonKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ButtonKt.Button$lambda$2$0((SemanticsPropertyReceiver) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                Modifier modifierSemantics$default12 = SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, r6, null);
                long jM6824unboximpl12 = buttonColorsM2301buttonColorsro_MJ88.backgroundColor(z7, composer3, i211).getValue().m6824unboximpl();
                long jM6813copywmQWz5c$default12 = Color.m6813copywmQWz5c$default(Button$lambda$1(stateContentColor12), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                if (buttonElevationM2302elevationR_JCAzs == null) {
                    composer3.startReplaceGroup(498128545);
                    composer3.endReplaceGroup();
                    stateElevation = null;
                } else {
                    composer3.startReplaceGroup(1401541984);
                    ComposerKt.sourceInformation(composer3, "117@5496L37");
                    stateElevation = buttonElevationM2302elevationR_JCAzs.elevation(z7, mutableInteractionSource5, composer3, i15 & 910);
                    composer3.endReplaceGroup();
                }
                if (stateElevation != null) {
                    fM9687constructorimpl = stateElevation.getValue().m9701unboximpl();
                } else {
                    fM9687constructorimpl = Dp.m9687constructorimpl(0);
                }
                Composer composer15 = composer3;
                SurfaceKt.m2585SurfaceLPr_se0(function0, modifierSemantics$default12, z7, shape3, jM6824unboximpl12, jM6813copywmQWz5c$default12, borderStroke4, fM9687constructorimpl, mutableInteractionSource5, ComposableLambdaKt.rememberComposableLambda(-20345758, r6, new Function2() { // from class: androidx.compose.material.ButtonKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ButtonKt.Button$lambda$3(stateContentColor12, contentPadding, function3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer3, 54), composer15, (i14 & 14) | 805306368 | (i14 & 896) | (i15 & 7168) | (i14 & 3670016), 0);
                composer2 = composer15;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                buttonColors2 = buttonColorsM2301buttonColorsro_MJ88;
                buttonElevation2 = buttonElevationM2302elevationR_JCAzs;
                shape2 = shape3;
                borderStroke2 = borderStroke4;
                mutableInteractionSource3 = mutableInteractionSource4;
                paddingValues2 = contentPadding;
                modifier3 = modifier2;
                z4 = z7;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                shape2 = shape;
                borderStroke2 = borderStroke;
                modifier3 = modifier2;
                z4 = z2;
                mutableInteractionSource3 = mutableInteractionSource2;
                buttonElevation2 = buttonElevationM2302elevationR_JCAzs;
                buttonColors2 = buttonColors;
                paddingValues2 = paddingValues;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ButtonKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ButtonKt.Button$lambda$4(function0, modifier3, z4, mutableInteractionSource3, buttonElevation2, shape2, borderStroke2, buttonColors2, paddingValues2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        z2 = z;
        i6 = i2 & 8;
        if (i6 != 0) {
            if ((i & 3072) == 0) {
                mutableInteractionSource2 = mutableInteractionSource;
                if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i3 |= i7;
            }
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    buttonElevationM2302elevationR_JCAzs = buttonElevation;
                    if (composerStartRestartGroup.changed(buttonElevationM2302elevationR_JCAzs)) {
                    }
                    i3 |= i18;
                } else {
                    buttonElevationM2302elevationR_JCAzs = buttonElevation;
                }
                i3 |= i18;
            } else {
                buttonElevationM2302elevationR_JCAzs = buttonElevation;
            }
            if ((196608 & i) != 0) {
                i3 |= ((i2 & 32) == 0 || !composerStartRestartGroup.changed(shape)) ? 65536 : 131072;
            }
            i8 = i2 & 64;
            if (i8 != 0) {
                i3 |= 1572864;
            } else if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changed(borderStroke)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            }
            if ((i & 12582912) != 0) {
                i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(buttonColors)) ? 4194304 : 8388608;
            }
            i10 = i2 & 256;
            if (i10 != 0) {
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changed(paddingValues)) {
                        i11 = 67108864;
                    } else {
                        i11 = 33554432;
                    }
                    i3 |= i11;
                }
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i16 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i16 = 268435456;
                    }
                    i3 |= i16;
                }
                i12 = i3;
                if ((i12 & 306783379) != 306783378) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i12 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "99@4736L11,100@4782L6,102@4872L14");
                    if ((i & 1) != 0) {
                        if (i17 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            i12 &= -57345;
                            buttonElevationM2302elevationR_JCAzs = ButtonDefaults.INSTANCE.m2302elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        }
                        if ((i2 & 32) != 0) {
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i12 &= -458753;
                        } else {
                            small = shape;
                        }
                        i13 = i12;
                        if (i8 != 0) {
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            z6 = true;
                            buttonColorsM2301buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m2301buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            composer3 = composerStartRestartGroup;
                            i13 &= -29360129;
                        } else {
                            composer3 = composerStartRestartGroup;
                            z6 = true;
                            buttonColorsM2301buttonColorsro_MJ88 = buttonColors;
                        }
                        int i11112 = i13;
                        if (i10 != 0) {
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding = paddingValues;
                        }
                        shape3 = small;
                        borderStroke4 = borderStroke3;
                        z7 = z5;
                        modifier2 = companion;
                        i14 = i11112;
                        r6 = z6;
                    } else {
                        if (i17 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            z5 = true;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        if ((i2 & 16) != 0) {
                            i12 &= -57345;
                            buttonElevationM2302elevationR_JCAzs = ButtonDefaults.INSTANCE.m2302elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                        }
                        if ((i2 & 32) != 0) {
                            small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                            i12 &= -458753;
                        } else {
                            small = shape;
                        }
                        i13 = i12;
                        if (i8 != 0) {
                            borderStroke3 = null;
                        } else {
                            borderStroke3 = borderStroke;
                        }
                        if ((i2 & 128) != 0) {
                            z6 = true;
                            buttonColorsM2301buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m2301buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                            composer3 = composerStartRestartGroup;
                            i13 &= -29360129;
                        } else {
                            composer3 = composerStartRestartGroup;
                            z6 = true;
                            buttonColorsM2301buttonColorsro_MJ88 = buttonColors;
                        }
                        int i11113 = i13;
                        if (i10 != 0) {
                            contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                        } else {
                            contentPadding = paddingValues;
                        }
                        shape3 = small;
                        borderStroke4 = borderStroke3;
                        z7 = z5;
                        modifier2 = companion;
                        i14 = i11113;
                        r6 = z6;
                    }
                    composer3.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1084573925, i14, -1, "androidx.compose.material.Button (Button.kt:105)");
                    }
                    if (mutableInteractionSource4 == null) {
                        composer3.startReplaceGroup(497721888);
                        ComposerKt.sourceInformation(composer3, "107@5086L39");
                        ComposerKt.sourceInformationMarkerStart(composer3, 1401528866, "CC(remember):Button.kt#9igjgp");
                        objRememberedValue2 = composer3.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                            composer3.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endReplaceGroup();
                        mutableInteractionSource5 = (MutableInteractionSource) objRememberedValue2;
                    } else {
                        composer3.startReplaceGroup(1401528215);
                        composer3.endReplaceGroup();
                        mutableInteractionSource5 = mutableInteractionSource4;
                    }
                    i15 = i14 >> 6;
                    int i212 = (i15 & 14) | ((i14 >> 18) & 112);
                    final State stateContentColor13 = buttonColorsM2301buttonColorsro_MJ88.contentColor(z7, composer3, i212);
                    ComposerKt.sourceInformationMarkerStart(composer3, 1401534321, "CC(remember):Button.kt#9igjgp");
                    objRememberedValue = composer3.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material.ButtonKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ButtonKt.Button$lambda$2$0((SemanticsPropertyReceiver) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    Modifier modifierSemantics$default13 = SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, r6, null);
                    long jM6824unboximpl13 = buttonColorsM2301buttonColorsro_MJ88.backgroundColor(z7, composer3, i212).getValue().m6824unboximpl();
                    long jM6813copywmQWz5c$default13 = Color.m6813copywmQWz5c$default(Button$lambda$1(stateContentColor13), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                    if (buttonElevationM2302elevationR_JCAzs == null) {
                        composer3.startReplaceGroup(498128545);
                        composer3.endReplaceGroup();
                        stateElevation = null;
                    } else {
                        composer3.startReplaceGroup(1401541984);
                        ComposerKt.sourceInformation(composer3, "117@5496L37");
                        stateElevation = buttonElevationM2302elevationR_JCAzs.elevation(z7, mutableInteractionSource5, composer3, i15 & 910);
                        composer3.endReplaceGroup();
                    }
                    if (stateElevation != null) {
                        fM9687constructorimpl = stateElevation.getValue().m9701unboximpl();
                    } else {
                        fM9687constructorimpl = Dp.m9687constructorimpl(0);
                    }
                    Composer composer16 = composer3;
                    SurfaceKt.m2585SurfaceLPr_se0(function0, modifierSemantics$default13, z7, shape3, jM6824unboximpl13, jM6813copywmQWz5c$default13, borderStroke4, fM9687constructorimpl, mutableInteractionSource5, ComposableLambdaKt.rememberComposableLambda(-20345758, r6, new Function2() { // from class: androidx.compose.material.ButtonKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ButtonKt.Button$lambda$3(stateContentColor13, contentPadding, function3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer3, 54), composer16, (i14 & 14) | 805306368 | (i14 & 896) | (i15 & 7168) | (i14 & 3670016), 0);
                    composer2 = composer16;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    buttonColors2 = buttonColorsM2301buttonColorsro_MJ88;
                    buttonElevation2 = buttonElevationM2302elevationR_JCAzs;
                    shape2 = shape3;
                    borderStroke2 = borderStroke4;
                    mutableInteractionSource3 = mutableInteractionSource4;
                    paddingValues2 = contentPadding;
                    modifier3 = modifier2;
                    z4 = z7;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    shape2 = shape;
                    borderStroke2 = borderStroke;
                    modifier3 = modifier2;
                    z4 = z2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    buttonElevation2 = buttonElevationM2302elevationR_JCAzs;
                    buttonColors2 = buttonColors;
                    paddingValues2 = paddingValues;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ButtonKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ButtonKt.Button$lambda$4(function0, modifier3, z4, mutableInteractionSource3, buttonElevation2, shape2, borderStroke2, buttonColors2, paddingValues2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 100663296;
            if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i16 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i16 = 268435456;
                }
                i3 |= i16;
            }
            i12 = i3;
            if ((i12 & 306783379) != 306783378) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i12 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "99@4736L11,100@4782L6,102@4872L14");
                if ((i & 1) != 0) {
                    if (i17 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    if ((i2 & 16) != 0) {
                        i12 &= -57345;
                        buttonElevationM2302elevationR_JCAzs = ButtonDefaults.INSTANCE.m2302elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    }
                    if ((i2 & 32) != 0) {
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i12 &= -458753;
                    } else {
                        small = shape;
                    }
                    i13 = i12;
                    if (i8 != 0) {
                        borderStroke3 = null;
                    } else {
                        borderStroke3 = borderStroke;
                    }
                    if ((i2 & 128) != 0) {
                        z6 = true;
                        buttonColorsM2301buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m2301buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        composer3 = composerStartRestartGroup;
                        i13 &= -29360129;
                    } else {
                        composer3 = composerStartRestartGroup;
                        z6 = true;
                        buttonColorsM2301buttonColorsro_MJ88 = buttonColors;
                    }
                    int i11114 = i13;
                    if (i10 != 0) {
                        contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                    } else {
                        contentPadding = paddingValues;
                    }
                    shape3 = small;
                    borderStroke4 = borderStroke3;
                    z7 = z5;
                    modifier2 = companion;
                    i14 = i11114;
                    r6 = z6;
                } else {
                    if (i17 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    if ((i2 & 16) != 0) {
                        i12 &= -57345;
                        buttonElevationM2302elevationR_JCAzs = ButtonDefaults.INSTANCE.m2302elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    }
                    if ((i2 & 32) != 0) {
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i12 &= -458753;
                    } else {
                        small = shape;
                    }
                    i13 = i12;
                    if (i8 != 0) {
                        borderStroke3 = null;
                    } else {
                        borderStroke3 = borderStroke;
                    }
                    if ((i2 & 128) != 0) {
                        z6 = true;
                        buttonColorsM2301buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m2301buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        composer3 = composerStartRestartGroup;
                        i13 &= -29360129;
                    } else {
                        composer3 = composerStartRestartGroup;
                        z6 = true;
                        buttonColorsM2301buttonColorsro_MJ88 = buttonColors;
                    }
                    int i11115 = i13;
                    if (i10 != 0) {
                        contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                    } else {
                        contentPadding = paddingValues;
                    }
                    shape3 = small;
                    borderStroke4 = borderStroke3;
                    z7 = z5;
                    modifier2 = companion;
                    i14 = i11115;
                    r6 = z6;
                }
                composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1084573925, i14, -1, "androidx.compose.material.Button (Button.kt:105)");
                }
                if (mutableInteractionSource4 == null) {
                    composer3.startReplaceGroup(497721888);
                    ComposerKt.sourceInformation(composer3, "107@5086L39");
                    ComposerKt.sourceInformationMarkerStart(composer3, 1401528866, "CC(remember):Button.kt#9igjgp");
                    objRememberedValue2 = composer3.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                        composer3.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endReplaceGroup();
                    mutableInteractionSource5 = (MutableInteractionSource) objRememberedValue2;
                } else {
                    composer3.startReplaceGroup(1401528215);
                    composer3.endReplaceGroup();
                    mutableInteractionSource5 = mutableInteractionSource4;
                }
                i15 = i14 >> 6;
                int i213 = (i15 & 14) | ((i14 >> 18) & 112);
                final State stateContentColor14 = buttonColorsM2301buttonColorsro_MJ88.contentColor(z7, composer3, i213);
                ComposerKt.sourceInformationMarkerStart(composer3, 1401534321, "CC(remember):Button.kt#9igjgp");
                objRememberedValue = composer3.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material.ButtonKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ButtonKt.Button$lambda$2$0((SemanticsPropertyReceiver) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                Modifier modifierSemantics$default14 = SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, r6, null);
                long jM6824unboximpl14 = buttonColorsM2301buttonColorsro_MJ88.backgroundColor(z7, composer3, i213).getValue().m6824unboximpl();
                long jM6813copywmQWz5c$default14 = Color.m6813copywmQWz5c$default(Button$lambda$1(stateContentColor14), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                if (buttonElevationM2302elevationR_JCAzs == null) {
                    composer3.startReplaceGroup(498128545);
                    composer3.endReplaceGroup();
                    stateElevation = null;
                } else {
                    composer3.startReplaceGroup(1401541984);
                    ComposerKt.sourceInformation(composer3, "117@5496L37");
                    stateElevation = buttonElevationM2302elevationR_JCAzs.elevation(z7, mutableInteractionSource5, composer3, i15 & 910);
                    composer3.endReplaceGroup();
                }
                if (stateElevation != null) {
                    fM9687constructorimpl = stateElevation.getValue().m9701unboximpl();
                } else {
                    fM9687constructorimpl = Dp.m9687constructorimpl(0);
                }
                Composer composer17 = composer3;
                SurfaceKt.m2585SurfaceLPr_se0(function0, modifierSemantics$default14, z7, shape3, jM6824unboximpl14, jM6813copywmQWz5c$default14, borderStroke4, fM9687constructorimpl, mutableInteractionSource5, ComposableLambdaKt.rememberComposableLambda(-20345758, r6, new Function2() { // from class: androidx.compose.material.ButtonKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ButtonKt.Button$lambda$3(stateContentColor14, contentPadding, function3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer3, 54), composer17, (i14 & 14) | 805306368 | (i14 & 896) | (i15 & 7168) | (i14 & 3670016), 0);
                composer2 = composer17;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                buttonColors2 = buttonColorsM2301buttonColorsro_MJ88;
                buttonElevation2 = buttonElevationM2302elevationR_JCAzs;
                shape2 = shape3;
                borderStroke2 = borderStroke4;
                mutableInteractionSource3 = mutableInteractionSource4;
                paddingValues2 = contentPadding;
                modifier3 = modifier2;
                z4 = z7;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                shape2 = shape;
                borderStroke2 = borderStroke;
                modifier3 = modifier2;
                z4 = z2;
                mutableInteractionSource3 = mutableInteractionSource2;
                buttonElevation2 = buttonElevationM2302elevationR_JCAzs;
                buttonColors2 = buttonColors;
                paddingValues2 = paddingValues;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ButtonKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ButtonKt.Button$lambda$4(function0, modifier3, z4, mutableInteractionSource3, buttonElevation2, shape2, borderStroke2, buttonColors2, paddingValues2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i & 24576) == 0) {
            if ((i2 & 16) == 0) {
                buttonElevationM2302elevationR_JCAzs = buttonElevation;
                if (composerStartRestartGroup.changed(buttonElevationM2302elevationR_JCAzs)) {
                }
                i3 |= i18;
            } else {
                buttonElevationM2302elevationR_JCAzs = buttonElevation;
            }
            i3 |= i18;
        } else {
            buttonElevationM2302elevationR_JCAzs = buttonElevation;
        }
        if ((196608 & i) != 0) {
            i3 |= ((i2 & 32) == 0 || !composerStartRestartGroup.changed(shape)) ? 65536 : 131072;
        }
        i8 = i2 & 64;
        if (i8 != 0) {
            i3 |= 1572864;
        } else if ((i & 1572864) == 0) {
            if (composerStartRestartGroup.changed(borderStroke)) {
                i9 = 1048576;
            } else {
                i9 = 524288;
            }
            i3 |= i9;
        }
        if ((i & 12582912) != 0) {
            i3 |= ((i2 & 128) == 0 || !composerStartRestartGroup.changed(buttonColors)) ? 4194304 : 8388608;
        }
        i10 = i2 & 256;
        if (i10 != 0) {
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changed(paddingValues)) {
                    i11 = 67108864;
                } else {
                    i11 = 33554432;
                }
                i3 |= i11;
            }
            if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i16 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i16 = 268435456;
                }
                i3 |= i16;
            }
            i12 = i3;
            if ((i12 & 306783379) != 306783378) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i12 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "99@4736L11,100@4782L6,102@4872L14");
                if ((i & 1) != 0) {
                    if (i17 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    if ((i2 & 16) != 0) {
                        i12 &= -57345;
                        buttonElevationM2302elevationR_JCAzs = ButtonDefaults.INSTANCE.m2302elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    }
                    if ((i2 & 32) != 0) {
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i12 &= -458753;
                    } else {
                        small = shape;
                    }
                    i13 = i12;
                    if (i8 != 0) {
                        borderStroke3 = null;
                    } else {
                        borderStroke3 = borderStroke;
                    }
                    if ((i2 & 128) != 0) {
                        z6 = true;
                        buttonColorsM2301buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m2301buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        composer3 = composerStartRestartGroup;
                        i13 &= -29360129;
                    } else {
                        composer3 = composerStartRestartGroup;
                        z6 = true;
                        buttonColorsM2301buttonColorsro_MJ88 = buttonColors;
                    }
                    int i11116 = i13;
                    if (i10 != 0) {
                        contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                    } else {
                        contentPadding = paddingValues;
                    }
                    shape3 = small;
                    borderStroke4 = borderStroke3;
                    z7 = z5;
                    modifier2 = companion;
                    i14 = i11116;
                    r6 = z6;
                } else {
                    if (i17 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        z5 = true;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    if ((i2 & 16) != 0) {
                        i12 &= -57345;
                        buttonElevationM2302elevationR_JCAzs = ButtonDefaults.INSTANCE.m2302elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                    }
                    if ((i2 & 32) != 0) {
                        small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                        i12 &= -458753;
                    } else {
                        small = shape;
                    }
                    i13 = i12;
                    if (i8 != 0) {
                        borderStroke3 = null;
                    } else {
                        borderStroke3 = borderStroke;
                    }
                    if ((i2 & 128) != 0) {
                        z6 = true;
                        buttonColorsM2301buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m2301buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                        composer3 = composerStartRestartGroup;
                        i13 &= -29360129;
                    } else {
                        composer3 = composerStartRestartGroup;
                        z6 = true;
                        buttonColorsM2301buttonColorsro_MJ88 = buttonColors;
                    }
                    int i11117 = i13;
                    if (i10 != 0) {
                        contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                    } else {
                        contentPadding = paddingValues;
                    }
                    shape3 = small;
                    borderStroke4 = borderStroke3;
                    z7 = z5;
                    modifier2 = companion;
                    i14 = i11117;
                    r6 = z6;
                }
                composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1084573925, i14, -1, "androidx.compose.material.Button (Button.kt:105)");
                }
                if (mutableInteractionSource4 == null) {
                    composer3.startReplaceGroup(497721888);
                    ComposerKt.sourceInformation(composer3, "107@5086L39");
                    ComposerKt.sourceInformationMarkerStart(composer3, 1401528866, "CC(remember):Button.kt#9igjgp");
                    objRememberedValue2 = composer3.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                        composer3.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endReplaceGroup();
                    mutableInteractionSource5 = (MutableInteractionSource) objRememberedValue2;
                } else {
                    composer3.startReplaceGroup(1401528215);
                    composer3.endReplaceGroup();
                    mutableInteractionSource5 = mutableInteractionSource4;
                }
                i15 = i14 >> 6;
                int i214 = (i15 & 14) | ((i14 >> 18) & 112);
                final State stateContentColor15 = buttonColorsM2301buttonColorsro_MJ88.contentColor(z7, composer3, i214);
                ComposerKt.sourceInformationMarkerStart(composer3, 1401534321, "CC(remember):Button.kt#9igjgp");
                objRememberedValue = composer3.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material.ButtonKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ButtonKt.Button$lambda$2$0((SemanticsPropertyReceiver) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                Modifier modifierSemantics$default15 = SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, r6, null);
                long jM6824unboximpl15 = buttonColorsM2301buttonColorsro_MJ88.backgroundColor(z7, composer3, i214).getValue().m6824unboximpl();
                long jM6813copywmQWz5c$default15 = Color.m6813copywmQWz5c$default(Button$lambda$1(stateContentColor15), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
                if (buttonElevationM2302elevationR_JCAzs == null) {
                    composer3.startReplaceGroup(498128545);
                    composer3.endReplaceGroup();
                    stateElevation = null;
                } else {
                    composer3.startReplaceGroup(1401541984);
                    ComposerKt.sourceInformation(composer3, "117@5496L37");
                    stateElevation = buttonElevationM2302elevationR_JCAzs.elevation(z7, mutableInteractionSource5, composer3, i15 & 910);
                    composer3.endReplaceGroup();
                }
                if (stateElevation != null) {
                    fM9687constructorimpl = stateElevation.getValue().m9701unboximpl();
                } else {
                    fM9687constructorimpl = Dp.m9687constructorimpl(0);
                }
                Composer composer18 = composer3;
                SurfaceKt.m2585SurfaceLPr_se0(function0, modifierSemantics$default15, z7, shape3, jM6824unboximpl15, jM6813copywmQWz5c$default15, borderStroke4, fM9687constructorimpl, mutableInteractionSource5, ComposableLambdaKt.rememberComposableLambda(-20345758, r6, new Function2() { // from class: androidx.compose.material.ButtonKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ButtonKt.Button$lambda$3(stateContentColor15, contentPadding, function3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer3, 54), composer18, (i14 & 14) | 805306368 | (i14 & 896) | (i15 & 7168) | (i14 & 3670016), 0);
                composer2 = composer18;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                buttonColors2 = buttonColorsM2301buttonColorsro_MJ88;
                buttonElevation2 = buttonElevationM2302elevationR_JCAzs;
                shape2 = shape3;
                borderStroke2 = borderStroke4;
                mutableInteractionSource3 = mutableInteractionSource4;
                paddingValues2 = contentPadding;
                modifier3 = modifier2;
                z4 = z7;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                shape2 = shape;
                borderStroke2 = borderStroke;
                modifier3 = modifier2;
                z4 = z2;
                mutableInteractionSource3 = mutableInteractionSource2;
                buttonElevation2 = buttonElevationM2302elevationR_JCAzs;
                buttonColors2 = buttonColors;
                paddingValues2 = paddingValues;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ButtonKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ButtonKt.Button$lambda$4(function0, modifier3, z4, mutableInteractionSource3, buttonElevation2, shape2, borderStroke2, buttonColors2, paddingValues2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 100663296;
        if ((i & 805306368) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i16 = C.BUFFER_FLAG_LAST_SAMPLE;
            } else {
                i16 = 268435456;
            }
            i3 |= i16;
        }
        i12 = i3;
        if ((i12 & 306783379) != 306783378) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i12 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "99@4736L11,100@4782L6,102@4872L14");
            if ((i & 1) != 0) {
                if (i17 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                if (i6 != 0) {
                    mutableInteractionSource4 = null;
                } else {
                    mutableInteractionSource4 = mutableInteractionSource2;
                }
                if ((i2 & 16) != 0) {
                    i12 &= -57345;
                    buttonElevationM2302elevationR_JCAzs = ButtonDefaults.INSTANCE.m2302elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                }
                if ((i2 & 32) != 0) {
                    small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                    i12 &= -458753;
                } else {
                    small = shape;
                }
                i13 = i12;
                if (i8 != 0) {
                    borderStroke3 = null;
                } else {
                    borderStroke3 = borderStroke;
                }
                if ((i2 & 128) != 0) {
                    z6 = true;
                    buttonColorsM2301buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m2301buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    composer3 = composerStartRestartGroup;
                    i13 &= -29360129;
                } else {
                    composer3 = composerStartRestartGroup;
                    z6 = true;
                    buttonColorsM2301buttonColorsro_MJ88 = buttonColors;
                }
                int i11118 = i13;
                if (i10 != 0) {
                    contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                } else {
                    contentPadding = paddingValues;
                }
                shape3 = small;
                borderStroke4 = borderStroke3;
                z7 = z5;
                modifier2 = companion;
                i14 = i11118;
                r6 = z6;
            } else {
                if (i17 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    z5 = true;
                } else {
                    z5 = z2;
                }
                if (i6 != 0) {
                    mutableInteractionSource4 = null;
                } else {
                    mutableInteractionSource4 = mutableInteractionSource2;
                }
                if ((i2 & 16) != 0) {
                    i12 &= -57345;
                    buttonElevationM2302elevationR_JCAzs = ButtonDefaults.INSTANCE.m2302elevationR_JCAzs(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 31);
                }
                if ((i2 & 32) != 0) {
                    small = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall();
                    i12 &= -458753;
                } else {
                    small = shape;
                }
                i13 = i12;
                if (i8 != 0) {
                    borderStroke3 = null;
                } else {
                    borderStroke3 = borderStroke;
                }
                if ((i2 & 128) != 0) {
                    z6 = true;
                    buttonColorsM2301buttonColorsro_MJ88 = ButtonDefaults.INSTANCE.m2301buttonColorsro_MJ88(0L, 0L, 0L, 0L, composerStartRestartGroup, 24576, 15);
                    composer3 = composerStartRestartGroup;
                    i13 &= -29360129;
                } else {
                    composer3 = composerStartRestartGroup;
                    z6 = true;
                    buttonColorsM2301buttonColorsro_MJ88 = buttonColors;
                }
                int i11119 = i13;
                if (i10 != 0) {
                    contentPadding = ButtonDefaults.INSTANCE.getContentPadding();
                } else {
                    contentPadding = paddingValues;
                }
                shape3 = small;
                borderStroke4 = borderStroke3;
                z7 = z5;
                modifier2 = companion;
                i14 = i11119;
                r6 = z6;
            }
            composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1084573925, i14, -1, "androidx.compose.material.Button (Button.kt:105)");
            }
            if (mutableInteractionSource4 == null) {
                composer3.startReplaceGroup(497721888);
                ComposerKt.sourceInformation(composer3, "107@5086L39");
                ComposerKt.sourceInformationMarkerStart(composer3, 1401528866, "CC(remember):Button.kt#9igjgp");
                objRememberedValue2 = composer3.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = InteractionSourceKt.MutableInteractionSource();
                    composer3.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                composer3.endReplaceGroup();
                mutableInteractionSource5 = (MutableInteractionSource) objRememberedValue2;
            } else {
                composer3.startReplaceGroup(1401528215);
                composer3.endReplaceGroup();
                mutableInteractionSource5 = mutableInteractionSource4;
            }
            i15 = i14 >> 6;
            int i215 = (i15 & 14) | ((i14 >> 18) & 112);
            final State stateContentColor16 = buttonColorsM2301buttonColorsro_MJ88.contentColor(z7, composer3, i215);
            ComposerKt.sourceInformationMarkerStart(composer3, 1401534321, "CC(remember):Button.kt#9igjgp");
            objRememberedValue = composer3.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material.ButtonKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ButtonKt.Button$lambda$2$0((SemanticsPropertyReceiver) obj);
                    }
                };
                composer3.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer3);
            Modifier modifierSemantics$default16 = SemanticsModifierKt.semantics$default(modifier2, false, (Function1) objRememberedValue, r6, null);
            long jM6824unboximpl16 = buttonColorsM2301buttonColorsro_MJ88.backgroundColor(z7, composer3, i215).getValue().m6824unboximpl();
            long jM6813copywmQWz5c$default16 = Color.m6813copywmQWz5c$default(Button$lambda$1(stateContentColor16), 1.0f, 0.0f, 0.0f, 0.0f, 14, null);
            if (buttonElevationM2302elevationR_JCAzs == null) {
                composer3.startReplaceGroup(498128545);
                composer3.endReplaceGroup();
                stateElevation = null;
            } else {
                composer3.startReplaceGroup(1401541984);
                ComposerKt.sourceInformation(composer3, "117@5496L37");
                stateElevation = buttonElevationM2302elevationR_JCAzs.elevation(z7, mutableInteractionSource5, composer3, i15 & 910);
                composer3.endReplaceGroup();
            }
            if (stateElevation != null) {
                fM9687constructorimpl = stateElevation.getValue().m9701unboximpl();
            } else {
                fM9687constructorimpl = Dp.m9687constructorimpl(0);
            }
            Composer composer19 = composer3;
            SurfaceKt.m2585SurfaceLPr_se0(function0, modifierSemantics$default16, z7, shape3, jM6824unboximpl16, jM6813copywmQWz5c$default16, borderStroke4, fM9687constructorimpl, mutableInteractionSource5, ComposableLambdaKt.rememberComposableLambda(-20345758, r6, new Function2() { // from class: androidx.compose.material.ButtonKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ButtonKt.Button$lambda$3(stateContentColor16, contentPadding, function3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer3, 54), composer19, (i14 & 14) | 805306368 | (i14 & 896) | (i15 & 7168) | (i14 & 3670016), 0);
            composer2 = composer19;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            buttonColors2 = buttonColorsM2301buttonColorsro_MJ88;
            buttonElevation2 = buttonElevationM2302elevationR_JCAzs;
            shape2 = shape3;
            borderStroke2 = borderStroke4;
            mutableInteractionSource3 = mutableInteractionSource4;
            paddingValues2 = contentPadding;
            modifier3 = modifier2;
            z4 = z7;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            shape2 = shape;
            borderStroke2 = borderStroke;
            modifier3 = modifier2;
            z4 = z2;
            mutableInteractionSource3 = mutableInteractionSource2;
            buttonElevation2 = buttonElevationM2302elevationR_JCAzs;
            buttonColors2 = buttonColors;
            paddingValues2 = paddingValues;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ButtonKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ButtonKt.Button$lambda$4(function0, modifier3, z4, mutableInteractionSource3, buttonElevation2, shape2, borderStroke2, buttonColors2, paddingValues2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Button$lambda$2$0(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.m8851setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m8832getButtono7Vup1c());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Button$lambda$3(State state, final PaddingValues paddingValues, final Function3 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C120@5685L558,120@5613L630:Button.kt#jmzs0o");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-20345758, i, -1, "androidx.compose.material.Button.<anonymous> (Button.kt:120)");
            }
            CompositionLocalKt.CompositionLocalProvider(ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m6816getAlphaimpl(Button$lambda$1(state)))), ComposableLambdaKt.rememberComposableLambda(-869936862, true, new Function2() { // from class: androidx.compose.material.ButtonKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ButtonKt.Button$lambda$3$0(paddingValues, function3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Button$lambda$3$0(final PaddingValues paddingValues, final Function3 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C121@5738L10,121@5757L476,121@5699L534:Button.kt#jmzs0o");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-869936862, i, -1, "androidx.compose.material.Button.<anonymous>.<anonymous> (Button.kt:121)");
            }
            TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer, 6).getButton(), ComposableLambdaKt.rememberComposableLambda(165539859, true, new Function2() { // from class: androidx.compose.material.ButtonKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ButtonKt.Button$lambda$3$0$0(paddingValues, function3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Button$lambda$3$0$0(PaddingValues paddingValues, Function3 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C122@5775L444:Button.kt#jmzs0o");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(165539859, i, -1, "androidx.compose.material.Button.<anonymous>.<anonymous>.<anonymous> (Button.kt:122)");
            }
            Modifier modifierPadding = PaddingKt.padding(SizeKt.m1250defaultMinSizeVpY3zN4(Modifier.INSTANCE, ButtonDefaults.INSTANCE.m2307getMinWidthD9Ej5fM(), ButtonDefaults.INSTANCE.m2306getMinHeightD9Ej5fM()), paddingValues);
            Arrangement.HorizontalOrVertical center = Arrangement.INSTANCE.getCenter();
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(center, centerVertically, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierPadding);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            function3.invoke(RowScopeInstance.INSTANCE, composer, 6);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public static final void OutlinedButton(Function0<Unit> function0, Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, ButtonElevation buttonElevation, Shape shape, BorderStroke borderStroke, ButtonColors buttonColors, PaddingValues paddingValues, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, -1445054947, "C(OutlinedButton)N(onClick,modifier,enabled,interactionSource,elevation,shape,border,colors,contentPadding,content)175@8304L6,176@8361L14,177@8419L22,181@8564L315:Button.kt#jmzs0o");
        Modifier modifier2 = (i2 & 2) != 0 ? Modifier.INSTANCE : modifier;
        boolean z2 = (i2 & 4) != 0 ? true : z;
        MutableInteractionSource mutableInteractionSource2 = (i2 & 8) != 0 ? null : mutableInteractionSource;
        ButtonElevation buttonElevation2 = (i2 & 16) != 0 ? null : buttonElevation;
        Shape small = (i2 & 32) != 0 ? MaterialTheme.INSTANCE.getShapes(composer, 6).getSmall() : shape;
        BorderStroke outlinedBorder = (i2 & 64) != 0 ? ButtonDefaults.INSTANCE.getOutlinedBorder(composer, 6) : borderStroke;
        ButtonColors buttonColorsM2309outlinedButtonColorsRGew2ao = (i2 & 128) != 0 ? ButtonDefaults.INSTANCE.m2309outlinedButtonColorsRGew2ao(0L, 0L, 0L, composer, 3072, 7) : buttonColors;
        PaddingValues contentPadding = (i2 & 256) != 0 ? ButtonDefaults.INSTANCE.getContentPadding() : paddingValues;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1445054947, i, -1, "androidx.compose.material.OutlinedButton (Button.kt:181)");
        }
        Button(function0, modifier2, z2, mutableInteractionSource2, buttonElevation2, small, outlinedBorder, buttonColorsM2309outlinedButtonColorsRGew2ao, contentPadding, function3, composer, i & 2147483646, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    public static final void TextButton(Function0<Unit> function0, Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, ButtonElevation buttonElevation, Shape shape, BorderStroke borderStroke, ButtonColors buttonColors, PaddingValues paddingValues, Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, int i, int i2) {
        ComposerKt.sourceInformationMarkerStart(composer, 724562088, "C(TextButton)N(onClick,modifier,enabled,interactionSource,elevation,shape,border,colors,contentPadding,content)232@10929L6,234@11019L18,238@11170L315:Button.kt#jmzs0o");
        Modifier modifier2 = (i2 & 2) != 0 ? Modifier.INSTANCE : modifier;
        boolean z2 = (i2 & 4) != 0 ? true : z;
        MutableInteractionSource mutableInteractionSource2 = (i2 & 8) != 0 ? null : mutableInteractionSource;
        ButtonElevation buttonElevation2 = (i2 & 16) != 0 ? null : buttonElevation;
        Shape small = (i2 & 32) != 0 ? MaterialTheme.INSTANCE.getShapes(composer, 6).getSmall() : shape;
        BorderStroke borderStroke2 = (i2 & 64) != 0 ? null : borderStroke;
        ButtonColors buttonColorsM2310textButtonColorsRGew2ao = (i2 & 128) != 0 ? ButtonDefaults.INSTANCE.m2310textButtonColorsRGew2ao(0L, 0L, 0L, composer, 3072, 7) : buttonColors;
        PaddingValues textButtonContentPadding = (i2 & 256) != 0 ? ButtonDefaults.INSTANCE.getTextButtonContentPadding() : paddingValues;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(724562088, i, -1, "androidx.compose.material.TextButton (Button.kt:238)");
        }
        Button(function0, modifier2, z2, mutableInteractionSource2, buttonElevation2, small, borderStroke2, buttonColorsM2310textButtonColorsRGew2ao, textButtonContentPadding, function3, composer, i & 2147483646, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
    }

    private static final long Button$lambda$1(State<Color> state) {
        return state.getValue().m6824unboximpl();
    }
}

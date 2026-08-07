package androidx.compose.material;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.IntrinsicKt;
import androidx.compose.foundation.layout.IntrinsicSize;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.shape.CornerBasedShape;
import androidx.compose.foundation.shape.CornerSizeKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
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
import androidx.compose.ui.draw.ClipKt;
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

/* JADX INFO: compiled from: Chip.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0007\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u001a\u0090\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u0015\b\u0002\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00112\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0015H\u0007¢\u0006\u0002\u0010\u0016\u001aÆ\u0001\u0010\u0017\u001a\u00020\u00012\u0006\u0010\u0018\u001a\u00020\u00072\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\f\u001a\u0004\u0018\u00010\r2\b\b\u0002\u0010\u000e\u001a\u00020\u00192\u0015\b\u0002\u0010\u0010\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00112\u0015\b\u0002\u0010\u001a\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00112\u0015\b\u0002\u0010\u001b\u001a\u000f\u0012\u0004\u0012\u00020\u0001\u0018\u00010\u0003¢\u0006\u0002\b\u00112\u001c\u0010\u0012\u001a\u0018\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\u00010\u0013¢\u0006\u0002\b\u0011¢\u0006\u0002\b\u0015H\u0007¢\u0006\u0002\u0010\u001c\"\u0010\u0010\u001d\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001f\"\u0010\u0010 \u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001f\"\u0010\u0010!\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001f\"\u0010\u0010\"\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001f\"\u000e\u0010#\u001a\u00020$X\u0082T¢\u0006\u0002\n\u0000\"\u000e\u0010%\u001a\u00020$X\u0082T¢\u0006\u0002\n\u0000\"\u0010\u0010&\u001a\u00020\u001eX\u0082\u0004¢\u0006\u0004\n\u0002\u0010\u001f¨\u0006'²\u0006\n\u0010(\u001a\u00020)X\u008a\u0084\u0002²\u0006\n\u0010*\u001a\u00020)X\u008a\u0084\u0002"}, d2 = {"Chip", "", ViewProps.ON_CLICK, "Lkotlin/Function0;", "modifier", "Landroidx/compose/ui/Modifier;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "shape", "Landroidx/compose/ui/graphics/Shape;", OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "colors", "Landroidx/compose/material/ChipColors;", "leadingIcon", "Landroidx/compose/runtime/Composable;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/RowScope;", "Lkotlin/ExtensionFunctionType;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/material/ChipColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "FilterChip", "selected", "Landroidx/compose/material/SelectableChipColors;", "selectedIcon", "trailingIcon", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/foundation/interaction/MutableInteractionSource;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/material/SelectableChipColors;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function2;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;III)V", "HorizontalPadding", "Landroidx/compose/ui/unit/Dp;", "F", "LeadingIconStartSpacing", "LeadingIconEndSpacing", "TrailingIconSpacing", "SurfaceOverlayOpacity", "", "SelectedOverlayOpacity", "SelectedIconContainerSize", "material", "contentColor", "Landroidx/compose/ui/graphics/Color;", "leadingIconContentColor"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class ChipKt {
    private static final float LeadingIconEndSpacing;
    private static final float SelectedOverlayOpacity = 0.16f;
    private static final float SurfaceOverlayOpacity = 0.12f;
    private static final float TrailingIconSpacing;
    private static final float HorizontalPadding = Dp.m9687constructorimpl(12);
    private static final float LeadingIconStartSpacing = Dp.m9687constructorimpl(4);
    private static final float SelectedIconContainerSize = Dp.m9687constructorimpl(24);

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Chip$lambda$3(Function0 function0, Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, Shape shape, BorderStroke borderStroke, ChipColors chipColors, Function2 function2, Function3 function3, int i, int i2, Composer composer, int i3) {
        Chip(function0, modifier, z, mutableInteractionSource, shape, borderStroke, chipColors, function2, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FilterChip$lambda$2(boolean z, Function0 function0, Modifier modifier, boolean z2, MutableInteractionSource mutableInteractionSource, Shape shape, BorderStroke borderStroke, SelectableChipColors selectableChipColors, Function2 function2, Function2 function3, Function2 function4, Function3 function5, int i, int i2, int i3, Composer composer, int i4) {
        FilterChip(z, function0, modifier, z2, mutableInteractionSource, shape, borderStroke, selectableChipColors, function2, function3, function4, function5, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), RecomposeScopeImplKt.updateChangedFlags(i2), i3);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:101:0x0130  */
    /* JADX WARN: Code duplicated, block: B:111:0x0154 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:112:0x0156  */
    /* JADX WARN: Code duplicated, block: B:114:0x015d  */
    /* JADX WARN: Code duplicated, block: B:116:0x0160  */
    /* JADX WARN: Code duplicated, block: B:119:0x0165  */
    /* JADX WARN: Code duplicated, block: B:120:0x017f  */
    /* JADX WARN: Code duplicated, block: B:122:0x0182  */
    /* JADX WARN: Code duplicated, block: B:123:0x0184  */
    /* JADX WARN: Code duplicated, block: B:126:0x0189  */
    /* JADX WARN: Code duplicated, block: B:127:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:130:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:131:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:135:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:138:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:141:0x026d  */
    /* JADX WARN: Code duplicated, block: B:143:0x027a  */
    /* JADX WARN: Code duplicated, block: B:146:0x028d  */
    /* JADX WARN: Code duplicated, block: B:148:? A[RETURN, SYNTHETIC] */
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
    /* JADX WARN: Code duplicated, block: B:56:0x009b  */
    /* JADX WARN: Code duplicated, block: B:57:0x009d  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:69:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:71:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:75:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:78:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:79:0x00db  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:83:0x00e9  */
    /* JADX WARN: Code duplicated, block: B:84:0x00ec  */
    /* JADX WARN: Code duplicated, block: B:88:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:90:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:91:0x0101  */
    /* JADX WARN: Code duplicated, block: B:95:0x0112  */
    /* JADX WARN: Code duplicated, block: B:96:0x0114  */
    /* JADX WARN: Code duplicated, block: B:99:0x011d  */
    /* JADX WARN: Type inference failed for: r13v3 */
    /* JADX WARN: Type inference failed for: r6v11, types: [boolean, int] */
    /* JADX WARN: Type inference failed for: r6v14 */
    public static final void Chip(final Function0<Unit> function0, Modifier modifier, boolean z, MutableInteractionSource mutableInteractionSource, Shape shape, BorderStroke borderStroke, ChipColors chipColors, Function2<? super Composer, ? super Integer, Unit> function2, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        int i5;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        int i7;
        Shape shape2;
        int i8;
        BorderStroke borderStroke2;
        int i9;
        ChipColors chipColorsM2319chipColors5tl4gsc;
        int i10;
        int i11;
        int i12;
        ?? r13;
        boolean z3;
        Composer composer2;
        final Function2<? super Composer, ? super Integer, Unit> function4;
        final Modifier modifier3;
        final boolean z4;
        final MutableInteractionSource mutableInteractionSource3;
        final Shape shape3;
        final BorderStroke borderStroke3;
        final ChipColors chipColors2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        CornerBasedShape cornerBasedShapeCopy;
        BorderStroke borderStroke4;
        Composer composer3;
        boolean z5;
        Shape shape4;
        ChipColors chipColors3;
        Function2<? super Composer, ? super Integer, Unit> function5;
        BorderStroke borderStroke5;
        boolean z6;
        MutableInteractionSource mutableInteractionSource4;
        Object objRememberedValue;
        int i13;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1232125330);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Chip)N(onClick,modifier,enabled,interactionSource,shape,border,colors,leadingIcon,content)100@4561L21,103@4661L22,106@4758L24,110@4916L1391,101@4587L1720:Chip.kt#jmzs0o");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i14 = i2 & 2;
        if (i14 == 0) {
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
                            shape2 = shape;
                            int i15 = composerStartRestartGroup.changed(shape2) ? 16384 : 8192;
                            i3 |= i15;
                        } else {
                            shape2 = shape;
                        }
                        i3 |= i15;
                    } else {
                        shape2 = shape;
                    }
                    i8 = i2 & 32;
                    if (i8 != 0) {
                        if ((196608 & i) == 0) {
                            borderStroke2 = borderStroke;
                            if (composerStartRestartGroup.changed(borderStroke2)) {
                                i9 = 131072;
                            } else {
                                i9 = 65536;
                            }
                            i3 |= i9;
                        }
                        if ((1572864 & i) == 0) {
                            if ((i2 & 64) == 0) {
                                chipColorsM2319chipColors5tl4gsc = chipColors;
                                int i16 = composerStartRestartGroup.changed(chipColorsM2319chipColors5tl4gsc) ? 1048576 : 524288;
                                i3 |= i16;
                            } else {
                                chipColorsM2319chipColors5tl4gsc = chipColors;
                            }
                            i3 |= i16;
                        } else {
                            chipColorsM2319chipColors5tl4gsc = chipColors;
                        }
                        i10 = i2 & 128;
                        if (i10 != 0) {
                            i3 |= 12582912;
                            i11 = i8;
                        } else {
                            i11 = i8;
                            if ((i & 12582912) == 0) {
                                if (composerStartRestartGroup.changedInstance(function2)) {
                                    i12 = 8388608;
                                } else {
                                    i12 = 4194304;
                                }
                                i3 |= i12;
                            }
                        }
                        if ((i & 100663296) == 0) {
                            if (composerStartRestartGroup.changedInstance(function3)) {
                                i13 = 67108864;
                            } else {
                                i13 = 33554432;
                            }
                            i3 |= i13;
                        }
                        r13 = 1;
                        if ((i3 & 38347923) != 38347922) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "94@4298L6,96@4415L12");
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i14 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    z2 = true;
                                }
                                if (i6 != 0) {
                                    mutableInteractionSource2 = null;
                                }
                                if ((i2 & 16) != 0) {
                                    cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                    i3 &= -57345;
                                } else {
                                    cornerBasedShapeCopy = shape2;
                                }
                                if (i11 != 0) {
                                    borderStroke4 = null;
                                } else {
                                    borderStroke4 = borderStroke2;
                                }
                                if ((i2 & 64) != 0) {
                                    z5 = false;
                                    composer3 = composerStartRestartGroup;
                                    i3 &= -3670017;
                                    chipColorsM2319chipColors5tl4gsc = ChipDefaults.INSTANCE.m2319chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                                } else {
                                    composer3 = composerStartRestartGroup;
                                    z5 = false;
                                }
                                ChipColors chipColors4 = chipColorsM2319chipColors5tl4gsc;
                                shape4 = cornerBasedShapeCopy;
                                chipColors3 = chipColors4;
                                if (i10 != 0) {
                                    function5 = null;
                                } else {
                                    function5 = function2;
                                }
                                borderStroke5 = borderStroke4;
                                z6 = z2;
                                mutableInteractionSource4 = mutableInteractionSource2;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i2 & 16) != 0) {
                                    i3 &= -57345;
                                }
                                if ((i2 & 64) != 0) {
                                    i3 &= -3670017;
                                }
                                mutableInteractionSource4 = mutableInteractionSource2;
                                r13 = 1;
                                borderStroke5 = borderStroke2;
                                chipColors3 = chipColorsM2319chipColors5tl4gsc;
                                z5 = false;
                                z6 = z2;
                                shape4 = shape2;
                                composer3 = composerStartRestartGroup;
                                function5 = function2;
                            }
                            composer3.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1232125330, i3, -1, "androidx.compose.material.Chip (Chip.kt:99)");
                            }
                            int i17 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                            final State<Color> stateContentColor = chipColors3.contentColor(z6, composer3, i17);
                            ComposerKt.sourceInformationMarkerStart(composer3, 1338549252, "CC(remember):Chip.kt#9igjgp");
                            objRememberedValue = composer3.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function1() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda7
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return ChipKt.Chip$lambda$1$0((SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composer3.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            final ChipColors chipColors5 = chipColors3;
                            final Function2<? super Composer, ? super Integer, Unit> function6 = function5;
                            final boolean z7 = z6;
                            composer2 = composer3;
                            SurfaceKt.m2585SurfaceLPr_se0(function0, SemanticsModifierKt.semantics$default(modifier2, z5, (Function1) objRememberedValue, r13, null), z6, shape4, chipColors3.backgroundColor(z6, composer3, i17).getValue().m6824unboximpl(), Color.m6813copywmQWz5c$default(Chip$lambda$0(stateContentColor), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke5, 0.0f, mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(-1849195083, r13, new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda8
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ChipKt.Chip$lambda$2(stateContentColor, function6, chipColors5, z7, function3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | (3670016 & (i3 << 3)) | ((i3 << 15) & 234881024), 128);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            chipColors2 = chipColors3;
                            function4 = function6;
                            modifier3 = modifier2;
                            z4 = z6;
                            shape3 = shape4;
                            borderStroke3 = borderStroke5;
                            mutableInteractionSource3 = mutableInteractionSource4;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            function4 = function2;
                            modifier3 = modifier2;
                            z4 = z2;
                            mutableInteractionSource3 = mutableInteractionSource2;
                            shape3 = shape2;
                            borderStroke3 = borderStroke2;
                            chipColors2 = chipColorsM2319chipColors5tl4gsc;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ChipKt.Chip$lambda$3(function0, modifier3, z4, mutableInteractionSource3, shape3, borderStroke3, chipColors2, function4, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                    borderStroke2 = borderStroke;
                    if ((1572864 & i) == 0) {
                        if ((i2 & 64) == 0) {
                            chipColorsM2319chipColors5tl4gsc = chipColors;
                            if (composerStartRestartGroup.changed(chipColorsM2319chipColors5tl4gsc)) {
                            }
                            i3 |= i16;
                        } else {
                            chipColorsM2319chipColors5tl4gsc = chipColors;
                        }
                        i3 |= i16;
                    } else {
                        chipColorsM2319chipColors5tl4gsc = chipColors;
                    }
                    i10 = i2 & 128;
                    if (i10 != 0) {
                        i3 |= 12582912;
                        i11 = i8;
                    } else {
                        i11 = i8;
                        if ((i & 12582912) == 0) {
                            if (composerStartRestartGroup.changedInstance(function2)) {
                                i12 = 8388608;
                            } else {
                                i12 = 4194304;
                            }
                            i3 |= i12;
                        }
                    }
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i13 = 67108864;
                        } else {
                            i13 = 33554432;
                        }
                        i3 |= i13;
                    }
                    r13 = 1;
                    if ((i3 & 38347923) != 38347922) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "94@4298L6,96@4415L12");
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if (i6 != 0) {
                                mutableInteractionSource2 = null;
                            }
                            if ((i2 & 16) != 0) {
                                cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                i3 &= -57345;
                            } else {
                                cornerBasedShapeCopy = shape2;
                            }
                            if (i11 != 0) {
                                borderStroke4 = null;
                            } else {
                                borderStroke4 = borderStroke2;
                            }
                            if ((i2 & 64) != 0) {
                                z5 = false;
                                composer3 = composerStartRestartGroup;
                                i3 &= -3670017;
                                chipColorsM2319chipColors5tl4gsc = ChipDefaults.INSTANCE.m2319chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            } else {
                                composer3 = composerStartRestartGroup;
                                z5 = false;
                            }
                            ChipColors chipColors6 = chipColorsM2319chipColors5tl4gsc;
                            shape4 = cornerBasedShapeCopy;
                            chipColors3 = chipColors6;
                            if (i10 != 0) {
                                function5 = null;
                            } else {
                                function5 = function2;
                            }
                            borderStroke5 = borderStroke4;
                            z6 = z2;
                            mutableInteractionSource4 = mutableInteractionSource2;
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if (i6 != 0) {
                                mutableInteractionSource2 = null;
                            }
                            if ((i2 & 16) != 0) {
                                cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                i3 &= -57345;
                            } else {
                                cornerBasedShapeCopy = shape2;
                            }
                            if (i11 != 0) {
                                borderStroke4 = null;
                            } else {
                                borderStroke4 = borderStroke2;
                            }
                            if ((i2 & 64) != 0) {
                                z5 = false;
                                composer3 = composerStartRestartGroup;
                                i3 &= -3670017;
                                chipColorsM2319chipColors5tl4gsc = ChipDefaults.INSTANCE.m2319chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            } else {
                                composer3 = composerStartRestartGroup;
                                z5 = false;
                            }
                            ChipColors chipColors7 = chipColorsM2319chipColors5tl4gsc;
                            shape4 = cornerBasedShapeCopy;
                            chipColors3 = chipColors7;
                            if (i10 != 0) {
                                function5 = null;
                            } else {
                                function5 = function2;
                            }
                            borderStroke5 = borderStroke4;
                            z6 = z2;
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        composer3.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1232125330, i3, -1, "androidx.compose.material.Chip (Chip.kt:99)");
                        }
                        int i18 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                        final State stateContentColor2 = chipColors3.contentColor(z6, composer3, i18);
                        ComposerKt.sourceInformationMarkerStart(composer3, 1338549252, "CC(remember):Chip.kt#9igjgp");
                        objRememberedValue = composer3.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ChipKt.Chip$lambda$1$0((SemanticsPropertyReceiver) obj);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        final ChipColors chipColors8 = chipColors3;
                        final Function2 function7 = function5;
                        final boolean z8 = z6;
                        composer2 = composer3;
                        SurfaceKt.m2585SurfaceLPr_se0(function0, SemanticsModifierKt.semantics$default(modifier2, z5, (Function1) objRememberedValue, r13, null), z6, shape4, chipColors3.backgroundColor(z6, composer3, i18).getValue().m6824unboximpl(), Color.m6813copywmQWz5c$default(Chip$lambda$0(stateContentColor2), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke5, 0.0f, mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(-1849195083, r13, new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ChipKt.Chip$lambda$2(stateContentColor2, function7, chipColors8, z8, function3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | (3670016 & (i3 << 3)) | ((i3 << 15) & 234881024), 128);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        chipColors2 = chipColors3;
                        function4 = function7;
                        modifier3 = modifier2;
                        z4 = z6;
                        shape3 = shape4;
                        borderStroke3 = borderStroke5;
                        mutableInteractionSource3 = mutableInteractionSource4;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        function4 = function2;
                        modifier3 = modifier2;
                        z4 = z2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        shape3 = shape2;
                        borderStroke3 = borderStroke2;
                        chipColors2 = chipColorsM2319chipColors5tl4gsc;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ChipKt.Chip$lambda$3(function0, modifier3, z4, mutableInteractionSource3, shape3, borderStroke3, chipColors2, function4, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 3072;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        shape2 = shape;
                        if (composerStartRestartGroup.changed(shape2)) {
                        }
                        i3 |= i15;
                    } else {
                        shape2 = shape;
                    }
                    i3 |= i15;
                } else {
                    shape2 = shape;
                }
                i8 = i2 & 32;
                if (i8 != 0) {
                    if ((196608 & i) == 0) {
                        borderStroke2 = borderStroke;
                        if (composerStartRestartGroup.changed(borderStroke2)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i3 |= i9;
                    }
                    if ((1572864 & i) == 0) {
                        if ((i2 & 64) == 0) {
                            chipColorsM2319chipColors5tl4gsc = chipColors;
                            if (composerStartRestartGroup.changed(chipColorsM2319chipColors5tl4gsc)) {
                            }
                            i3 |= i16;
                        } else {
                            chipColorsM2319chipColors5tl4gsc = chipColors;
                        }
                        i3 |= i16;
                    } else {
                        chipColorsM2319chipColors5tl4gsc = chipColors;
                    }
                    i10 = i2 & 128;
                    if (i10 != 0) {
                        i3 |= 12582912;
                        i11 = i8;
                    } else {
                        i11 = i8;
                        if ((i & 12582912) == 0) {
                            if (composerStartRestartGroup.changedInstance(function2)) {
                                i12 = 8388608;
                            } else {
                                i12 = 4194304;
                            }
                            i3 |= i12;
                        }
                    }
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i13 = 67108864;
                        } else {
                            i13 = 33554432;
                        }
                        i3 |= i13;
                    }
                    r13 = 1;
                    if ((i3 & 38347923) != 38347922) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "94@4298L6,96@4415L12");
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if (i6 != 0) {
                                mutableInteractionSource2 = null;
                            }
                            if ((i2 & 16) != 0) {
                                cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                i3 &= -57345;
                            } else {
                                cornerBasedShapeCopy = shape2;
                            }
                            if (i11 != 0) {
                                borderStroke4 = null;
                            } else {
                                borderStroke4 = borderStroke2;
                            }
                            if ((i2 & 64) != 0) {
                                z5 = false;
                                composer3 = composerStartRestartGroup;
                                i3 &= -3670017;
                                chipColorsM2319chipColors5tl4gsc = ChipDefaults.INSTANCE.m2319chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            } else {
                                composer3 = composerStartRestartGroup;
                                z5 = false;
                            }
                            ChipColors chipColors9 = chipColorsM2319chipColors5tl4gsc;
                            shape4 = cornerBasedShapeCopy;
                            chipColors3 = chipColors9;
                            if (i10 != 0) {
                                function5 = null;
                            } else {
                                function5 = function2;
                            }
                            borderStroke5 = borderStroke4;
                            z6 = z2;
                            mutableInteractionSource4 = mutableInteractionSource2;
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if (i6 != 0) {
                                mutableInteractionSource2 = null;
                            }
                            if ((i2 & 16) != 0) {
                                cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                i3 &= -57345;
                            } else {
                                cornerBasedShapeCopy = shape2;
                            }
                            if (i11 != 0) {
                                borderStroke4 = null;
                            } else {
                                borderStroke4 = borderStroke2;
                            }
                            if ((i2 & 64) != 0) {
                                z5 = false;
                                composer3 = composerStartRestartGroup;
                                i3 &= -3670017;
                                chipColorsM2319chipColors5tl4gsc = ChipDefaults.INSTANCE.m2319chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            } else {
                                composer3 = composerStartRestartGroup;
                                z5 = false;
                            }
                            ChipColors chipColors10 = chipColorsM2319chipColors5tl4gsc;
                            shape4 = cornerBasedShapeCopy;
                            chipColors3 = chipColors10;
                            if (i10 != 0) {
                                function5 = null;
                            } else {
                                function5 = function2;
                            }
                            borderStroke5 = borderStroke4;
                            z6 = z2;
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        composer3.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1232125330, i3, -1, "androidx.compose.material.Chip (Chip.kt:99)");
                        }
                        int i19 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                        final State stateContentColor3 = chipColors3.contentColor(z6, composer3, i19);
                        ComposerKt.sourceInformationMarkerStart(composer3, 1338549252, "CC(remember):Chip.kt#9igjgp");
                        objRememberedValue = composer3.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ChipKt.Chip$lambda$1$0((SemanticsPropertyReceiver) obj);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        final ChipColors chipColors11 = chipColors3;
                        final Function2 function8 = function5;
                        final boolean z9 = z6;
                        composer2 = composer3;
                        SurfaceKt.m2585SurfaceLPr_se0(function0, SemanticsModifierKt.semantics$default(modifier2, z5, (Function1) objRememberedValue, r13, null), z6, shape4, chipColors3.backgroundColor(z6, composer3, i19).getValue().m6824unboximpl(), Color.m6813copywmQWz5c$default(Chip$lambda$0(stateContentColor3), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke5, 0.0f, mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(-1849195083, r13, new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ChipKt.Chip$lambda$2(stateContentColor3, function8, chipColors11, z9, function3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | (3670016 & (i3 << 3)) | ((i3 << 15) & 234881024), 128);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        chipColors2 = chipColors3;
                        function4 = function8;
                        modifier3 = modifier2;
                        z4 = z6;
                        shape3 = shape4;
                        borderStroke3 = borderStroke5;
                        mutableInteractionSource3 = mutableInteractionSource4;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        function4 = function2;
                        modifier3 = modifier2;
                        z4 = z2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        shape3 = shape2;
                        borderStroke3 = borderStroke2;
                        chipColors2 = chipColorsM2319chipColors5tl4gsc;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ChipKt.Chip$lambda$3(function0, modifier3, z4, mutableInteractionSource3, shape3, borderStroke3, chipColors2, function4, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                borderStroke2 = borderStroke;
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        chipColorsM2319chipColors5tl4gsc = chipColors;
                        if (composerStartRestartGroup.changed(chipColorsM2319chipColors5tl4gsc)) {
                        }
                        i3 |= i16;
                    } else {
                        chipColorsM2319chipColors5tl4gsc = chipColors;
                    }
                    i3 |= i16;
                } else {
                    chipColorsM2319chipColors5tl4gsc = chipColors;
                }
                i10 = i2 & 128;
                if (i10 != 0) {
                    i3 |= 12582912;
                    i11 = i8;
                } else {
                    i11 = i8;
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i12 = 8388608;
                        } else {
                            i12 = 4194304;
                        }
                        i3 |= i12;
                    }
                }
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i13 = 67108864;
                    } else {
                        i13 = 33554432;
                    }
                    i3 |= i13;
                }
                r13 = 1;
                if ((i3 & 38347923) != 38347922) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "94@4298L6,96@4415L12");
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource2 = null;
                        }
                        if ((i2 & 16) != 0) {
                            cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -57345;
                        } else {
                            cornerBasedShapeCopy = shape2;
                        }
                        if (i11 != 0) {
                            borderStroke4 = null;
                        } else {
                            borderStroke4 = borderStroke2;
                        }
                        if ((i2 & 64) != 0) {
                            z5 = false;
                            composer3 = composerStartRestartGroup;
                            i3 &= -3670017;
                            chipColorsM2319chipColors5tl4gsc = ChipDefaults.INSTANCE.m2319chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                        } else {
                            composer3 = composerStartRestartGroup;
                            z5 = false;
                        }
                        ChipColors chipColors12 = chipColorsM2319chipColors5tl4gsc;
                        shape4 = cornerBasedShapeCopy;
                        chipColors3 = chipColors12;
                        if (i10 != 0) {
                            function5 = null;
                        } else {
                            function5 = function2;
                        }
                        borderStroke5 = borderStroke4;
                        z6 = z2;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource2 = null;
                        }
                        if ((i2 & 16) != 0) {
                            cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -57345;
                        } else {
                            cornerBasedShapeCopy = shape2;
                        }
                        if (i11 != 0) {
                            borderStroke4 = null;
                        } else {
                            borderStroke4 = borderStroke2;
                        }
                        if ((i2 & 64) != 0) {
                            z5 = false;
                            composer3 = composerStartRestartGroup;
                            i3 &= -3670017;
                            chipColorsM2319chipColors5tl4gsc = ChipDefaults.INSTANCE.m2319chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                        } else {
                            composer3 = composerStartRestartGroup;
                            z5 = false;
                        }
                        ChipColors chipColors13 = chipColorsM2319chipColors5tl4gsc;
                        shape4 = cornerBasedShapeCopy;
                        chipColors3 = chipColors13;
                        if (i10 != 0) {
                            function5 = null;
                        } else {
                            function5 = function2;
                        }
                        borderStroke5 = borderStroke4;
                        z6 = z2;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    composer3.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1232125330, i3, -1, "androidx.compose.material.Chip (Chip.kt:99)");
                    }
                    int i110 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                    final State stateContentColor4 = chipColors3.contentColor(z6, composer3, i110);
                    ComposerKt.sourceInformationMarkerStart(composer3, 1338549252, "CC(remember):Chip.kt#9igjgp");
                    objRememberedValue = composer3.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ChipKt.Chip$lambda$1$0((SemanticsPropertyReceiver) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    final ChipColors chipColors14 = chipColors3;
                    final Function2 function9 = function5;
                    final boolean z10 = z6;
                    composer2 = composer3;
                    SurfaceKt.m2585SurfaceLPr_se0(function0, SemanticsModifierKt.semantics$default(modifier2, z5, (Function1) objRememberedValue, r13, null), z6, shape4, chipColors3.backgroundColor(z6, composer3, i110).getValue().m6824unboximpl(), Color.m6813copywmQWz5c$default(Chip$lambda$0(stateContentColor4), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke5, 0.0f, mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(-1849195083, r13, new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ChipKt.Chip$lambda$2(stateContentColor4, function9, chipColors14, z10, function3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer3, 54), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | (3670016 & (i3 << 3)) | ((i3 << 15) & 234881024), 128);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    chipColors2 = chipColors3;
                    function4 = function9;
                    modifier3 = modifier2;
                    z4 = z6;
                    shape3 = shape4;
                    borderStroke3 = borderStroke5;
                    mutableInteractionSource3 = mutableInteractionSource4;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    function4 = function2;
                    modifier3 = modifier2;
                    z4 = z2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    shape3 = shape2;
                    borderStroke3 = borderStroke2;
                    chipColors2 = chipColorsM2319chipColors5tl4gsc;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ChipKt.Chip$lambda$3(function0, modifier3, z4, mutableInteractionSource3, shape3, borderStroke3, chipColors2, function4, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
                        shape2 = shape;
                        if (composerStartRestartGroup.changed(shape2)) {
                        }
                        i3 |= i15;
                    } else {
                        shape2 = shape;
                    }
                    i3 |= i15;
                } else {
                    shape2 = shape;
                }
                i8 = i2 & 32;
                if (i8 != 0) {
                    if ((196608 & i) == 0) {
                        borderStroke2 = borderStroke;
                        if (composerStartRestartGroup.changed(borderStroke2)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i3 |= i9;
                    }
                    if ((1572864 & i) == 0) {
                        if ((i2 & 64) == 0) {
                            chipColorsM2319chipColors5tl4gsc = chipColors;
                            if (composerStartRestartGroup.changed(chipColorsM2319chipColors5tl4gsc)) {
                            }
                            i3 |= i16;
                        } else {
                            chipColorsM2319chipColors5tl4gsc = chipColors;
                        }
                        i3 |= i16;
                    } else {
                        chipColorsM2319chipColors5tl4gsc = chipColors;
                    }
                    i10 = i2 & 128;
                    if (i10 != 0) {
                        i3 |= 12582912;
                        i11 = i8;
                    } else {
                        i11 = i8;
                        if ((i & 12582912) == 0) {
                            if (composerStartRestartGroup.changedInstance(function2)) {
                                i12 = 8388608;
                            } else {
                                i12 = 4194304;
                            }
                            i3 |= i12;
                        }
                    }
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i13 = 67108864;
                        } else {
                            i13 = 33554432;
                        }
                        i3 |= i13;
                    }
                    r13 = 1;
                    if ((i3 & 38347923) != 38347922) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "94@4298L6,96@4415L12");
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if (i6 != 0) {
                                mutableInteractionSource2 = null;
                            }
                            if ((i2 & 16) != 0) {
                                cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                i3 &= -57345;
                            } else {
                                cornerBasedShapeCopy = shape2;
                            }
                            if (i11 != 0) {
                                borderStroke4 = null;
                            } else {
                                borderStroke4 = borderStroke2;
                            }
                            if ((i2 & 64) != 0) {
                                z5 = false;
                                composer3 = composerStartRestartGroup;
                                i3 &= -3670017;
                                chipColorsM2319chipColors5tl4gsc = ChipDefaults.INSTANCE.m2319chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            } else {
                                composer3 = composerStartRestartGroup;
                                z5 = false;
                            }
                            ChipColors chipColors15 = chipColorsM2319chipColors5tl4gsc;
                            shape4 = cornerBasedShapeCopy;
                            chipColors3 = chipColors15;
                            if (i10 != 0) {
                                function5 = null;
                            } else {
                                function5 = function2;
                            }
                            borderStroke5 = borderStroke4;
                            z6 = z2;
                            mutableInteractionSource4 = mutableInteractionSource2;
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if (i6 != 0) {
                                mutableInteractionSource2 = null;
                            }
                            if ((i2 & 16) != 0) {
                                cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                i3 &= -57345;
                            } else {
                                cornerBasedShapeCopy = shape2;
                            }
                            if (i11 != 0) {
                                borderStroke4 = null;
                            } else {
                                borderStroke4 = borderStroke2;
                            }
                            if ((i2 & 64) != 0) {
                                z5 = false;
                                composer3 = composerStartRestartGroup;
                                i3 &= -3670017;
                                chipColorsM2319chipColors5tl4gsc = ChipDefaults.INSTANCE.m2319chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            } else {
                                composer3 = composerStartRestartGroup;
                                z5 = false;
                            }
                            ChipColors chipColors16 = chipColorsM2319chipColors5tl4gsc;
                            shape4 = cornerBasedShapeCopy;
                            chipColors3 = chipColors16;
                            if (i10 != 0) {
                                function5 = null;
                            } else {
                                function5 = function2;
                            }
                            borderStroke5 = borderStroke4;
                            z6 = z2;
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        composer3.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1232125330, i3, -1, "androidx.compose.material.Chip (Chip.kt:99)");
                        }
                        int i111 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                        final State stateContentColor5 = chipColors3.contentColor(z6, composer3, i111);
                        ComposerKt.sourceInformationMarkerStart(composer3, 1338549252, "CC(remember):Chip.kt#9igjgp");
                        objRememberedValue = composer3.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ChipKt.Chip$lambda$1$0((SemanticsPropertyReceiver) obj);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        final ChipColors chipColors17 = chipColors3;
                        final Function2 function10 = function5;
                        final boolean z11 = z6;
                        composer2 = composer3;
                        SurfaceKt.m2585SurfaceLPr_se0(function0, SemanticsModifierKt.semantics$default(modifier2, z5, (Function1) objRememberedValue, r13, null), z6, shape4, chipColors3.backgroundColor(z6, composer3, i111).getValue().m6824unboximpl(), Color.m6813copywmQWz5c$default(Chip$lambda$0(stateContentColor5), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke5, 0.0f, mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(-1849195083, r13, new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ChipKt.Chip$lambda$2(stateContentColor5, function10, chipColors17, z11, function3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | (3670016 & (i3 << 3)) | ((i3 << 15) & 234881024), 128);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        chipColors2 = chipColors3;
                        function4 = function10;
                        modifier3 = modifier2;
                        z4 = z6;
                        shape3 = shape4;
                        borderStroke3 = borderStroke5;
                        mutableInteractionSource3 = mutableInteractionSource4;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        function4 = function2;
                        modifier3 = modifier2;
                        z4 = z2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        shape3 = shape2;
                        borderStroke3 = borderStroke2;
                        chipColors2 = chipColorsM2319chipColors5tl4gsc;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ChipKt.Chip$lambda$3(function0, modifier3, z4, mutableInteractionSource3, shape3, borderStroke3, chipColors2, function4, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                borderStroke2 = borderStroke;
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        chipColorsM2319chipColors5tl4gsc = chipColors;
                        if (composerStartRestartGroup.changed(chipColorsM2319chipColors5tl4gsc)) {
                        }
                        i3 |= i16;
                    } else {
                        chipColorsM2319chipColors5tl4gsc = chipColors;
                    }
                    i3 |= i16;
                } else {
                    chipColorsM2319chipColors5tl4gsc = chipColors;
                }
                i10 = i2 & 128;
                if (i10 != 0) {
                    i3 |= 12582912;
                    i11 = i8;
                } else {
                    i11 = i8;
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i12 = 8388608;
                        } else {
                            i12 = 4194304;
                        }
                        i3 |= i12;
                    }
                }
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i13 = 67108864;
                    } else {
                        i13 = 33554432;
                    }
                    i3 |= i13;
                }
                r13 = 1;
                if ((i3 & 38347923) != 38347922) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "94@4298L6,96@4415L12");
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource2 = null;
                        }
                        if ((i2 & 16) != 0) {
                            cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -57345;
                        } else {
                            cornerBasedShapeCopy = shape2;
                        }
                        if (i11 != 0) {
                            borderStroke4 = null;
                        } else {
                            borderStroke4 = borderStroke2;
                        }
                        if ((i2 & 64) != 0) {
                            z5 = false;
                            composer3 = composerStartRestartGroup;
                            i3 &= -3670017;
                            chipColorsM2319chipColors5tl4gsc = ChipDefaults.INSTANCE.m2319chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                        } else {
                            composer3 = composerStartRestartGroup;
                            z5 = false;
                        }
                        ChipColors chipColors18 = chipColorsM2319chipColors5tl4gsc;
                        shape4 = cornerBasedShapeCopy;
                        chipColors3 = chipColors18;
                        if (i10 != 0) {
                            function5 = null;
                        } else {
                            function5 = function2;
                        }
                        borderStroke5 = borderStroke4;
                        z6 = z2;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource2 = null;
                        }
                        if ((i2 & 16) != 0) {
                            cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -57345;
                        } else {
                            cornerBasedShapeCopy = shape2;
                        }
                        if (i11 != 0) {
                            borderStroke4 = null;
                        } else {
                            borderStroke4 = borderStroke2;
                        }
                        if ((i2 & 64) != 0) {
                            z5 = false;
                            composer3 = composerStartRestartGroup;
                            i3 &= -3670017;
                            chipColorsM2319chipColors5tl4gsc = ChipDefaults.INSTANCE.m2319chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                        } else {
                            composer3 = composerStartRestartGroup;
                            z5 = false;
                        }
                        ChipColors chipColors19 = chipColorsM2319chipColors5tl4gsc;
                        shape4 = cornerBasedShapeCopy;
                        chipColors3 = chipColors19;
                        if (i10 != 0) {
                            function5 = null;
                        } else {
                            function5 = function2;
                        }
                        borderStroke5 = borderStroke4;
                        z6 = z2;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    composer3.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1232125330, i3, -1, "androidx.compose.material.Chip (Chip.kt:99)");
                    }
                    int i112 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                    final State stateContentColor6 = chipColors3.contentColor(z6, composer3, i112);
                    ComposerKt.sourceInformationMarkerStart(composer3, 1338549252, "CC(remember):Chip.kt#9igjgp");
                    objRememberedValue = composer3.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ChipKt.Chip$lambda$1$0((SemanticsPropertyReceiver) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    final ChipColors chipColors110 = chipColors3;
                    final Function2 function11 = function5;
                    final boolean z12 = z6;
                    composer2 = composer3;
                    SurfaceKt.m2585SurfaceLPr_se0(function0, SemanticsModifierKt.semantics$default(modifier2, z5, (Function1) objRememberedValue, r13, null), z6, shape4, chipColors3.backgroundColor(z6, composer3, i112).getValue().m6824unboximpl(), Color.m6813copywmQWz5c$default(Chip$lambda$0(stateContentColor6), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke5, 0.0f, mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(-1849195083, r13, new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ChipKt.Chip$lambda$2(stateContentColor6, function11, chipColors110, z12, function3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer3, 54), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | (3670016 & (i3 << 3)) | ((i3 << 15) & 234881024), 128);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    chipColors2 = chipColors3;
                    function4 = function11;
                    modifier3 = modifier2;
                    z4 = z6;
                    shape3 = shape4;
                    borderStroke3 = borderStroke5;
                    mutableInteractionSource3 = mutableInteractionSource4;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    function4 = function2;
                    modifier3 = modifier2;
                    z4 = z2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    shape3 = shape2;
                    borderStroke3 = borderStroke2;
                    chipColors2 = chipColorsM2319chipColors5tl4gsc;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ChipKt.Chip$lambda$3(function0, modifier3, z4, mutableInteractionSource3, shape3, borderStroke3, chipColors2, function4, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                    }
                    i3 |= i15;
                } else {
                    shape2 = shape;
                }
                i3 |= i15;
            } else {
                shape2 = shape;
            }
            i8 = i2 & 32;
            if (i8 != 0) {
                if ((196608 & i) == 0) {
                    borderStroke2 = borderStroke;
                    if (composerStartRestartGroup.changed(borderStroke2)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        chipColorsM2319chipColors5tl4gsc = chipColors;
                        if (composerStartRestartGroup.changed(chipColorsM2319chipColors5tl4gsc)) {
                        }
                        i3 |= i16;
                    } else {
                        chipColorsM2319chipColors5tl4gsc = chipColors;
                    }
                    i3 |= i16;
                } else {
                    chipColorsM2319chipColors5tl4gsc = chipColors;
                }
                i10 = i2 & 128;
                if (i10 != 0) {
                    i3 |= 12582912;
                    i11 = i8;
                } else {
                    i11 = i8;
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i12 = 8388608;
                        } else {
                            i12 = 4194304;
                        }
                        i3 |= i12;
                    }
                }
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i13 = 67108864;
                    } else {
                        i13 = 33554432;
                    }
                    i3 |= i13;
                }
                r13 = 1;
                if ((i3 & 38347923) != 38347922) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "94@4298L6,96@4415L12");
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource2 = null;
                        }
                        if ((i2 & 16) != 0) {
                            cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -57345;
                        } else {
                            cornerBasedShapeCopy = shape2;
                        }
                        if (i11 != 0) {
                            borderStroke4 = null;
                        } else {
                            borderStroke4 = borderStroke2;
                        }
                        if ((i2 & 64) != 0) {
                            z5 = false;
                            composer3 = composerStartRestartGroup;
                            i3 &= -3670017;
                            chipColorsM2319chipColors5tl4gsc = ChipDefaults.INSTANCE.m2319chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                        } else {
                            composer3 = composerStartRestartGroup;
                            z5 = false;
                        }
                        ChipColors chipColors111 = chipColorsM2319chipColors5tl4gsc;
                        shape4 = cornerBasedShapeCopy;
                        chipColors3 = chipColors111;
                        if (i10 != 0) {
                            function5 = null;
                        } else {
                            function5 = function2;
                        }
                        borderStroke5 = borderStroke4;
                        z6 = z2;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource2 = null;
                        }
                        if ((i2 & 16) != 0) {
                            cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -57345;
                        } else {
                            cornerBasedShapeCopy = shape2;
                        }
                        if (i11 != 0) {
                            borderStroke4 = null;
                        } else {
                            borderStroke4 = borderStroke2;
                        }
                        if ((i2 & 64) != 0) {
                            z5 = false;
                            composer3 = composerStartRestartGroup;
                            i3 &= -3670017;
                            chipColorsM2319chipColors5tl4gsc = ChipDefaults.INSTANCE.m2319chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                        } else {
                            composer3 = composerStartRestartGroup;
                            z5 = false;
                        }
                        ChipColors chipColors112 = chipColorsM2319chipColors5tl4gsc;
                        shape4 = cornerBasedShapeCopy;
                        chipColors3 = chipColors112;
                        if (i10 != 0) {
                            function5 = null;
                        } else {
                            function5 = function2;
                        }
                        borderStroke5 = borderStroke4;
                        z6 = z2;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    composer3.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1232125330, i3, -1, "androidx.compose.material.Chip (Chip.kt:99)");
                    }
                    int i113 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                    final State stateContentColor7 = chipColors3.contentColor(z6, composer3, i113);
                    ComposerKt.sourceInformationMarkerStart(composer3, 1338549252, "CC(remember):Chip.kt#9igjgp");
                    objRememberedValue = composer3.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ChipKt.Chip$lambda$1$0((SemanticsPropertyReceiver) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    final ChipColors chipColors113 = chipColors3;
                    final Function2 function12 = function5;
                    final boolean z13 = z6;
                    composer2 = composer3;
                    SurfaceKt.m2585SurfaceLPr_se0(function0, SemanticsModifierKt.semantics$default(modifier2, z5, (Function1) objRememberedValue, r13, null), z6, shape4, chipColors3.backgroundColor(z6, composer3, i113).getValue().m6824unboximpl(), Color.m6813copywmQWz5c$default(Chip$lambda$0(stateContentColor7), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke5, 0.0f, mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(-1849195083, r13, new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ChipKt.Chip$lambda$2(stateContentColor7, function12, chipColors113, z13, function3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer3, 54), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | (3670016 & (i3 << 3)) | ((i3 << 15) & 234881024), 128);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    chipColors2 = chipColors3;
                    function4 = function12;
                    modifier3 = modifier2;
                    z4 = z6;
                    shape3 = shape4;
                    borderStroke3 = borderStroke5;
                    mutableInteractionSource3 = mutableInteractionSource4;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    function4 = function2;
                    modifier3 = modifier2;
                    z4 = z2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    shape3 = shape2;
                    borderStroke3 = borderStroke2;
                    chipColors2 = chipColorsM2319chipColors5tl4gsc;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ChipKt.Chip$lambda$3(function0, modifier3, z4, mutableInteractionSource3, shape3, borderStroke3, chipColors2, function4, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            borderStroke2 = borderStroke;
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    chipColorsM2319chipColors5tl4gsc = chipColors;
                    if (composerStartRestartGroup.changed(chipColorsM2319chipColors5tl4gsc)) {
                    }
                    i3 |= i16;
                } else {
                    chipColorsM2319chipColors5tl4gsc = chipColors;
                }
                i3 |= i16;
            } else {
                chipColorsM2319chipColors5tl4gsc = chipColors;
            }
            i10 = i2 & 128;
            if (i10 != 0) {
                i3 |= 12582912;
                i11 = i8;
            } else {
                i11 = i8;
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i12 = 8388608;
                    } else {
                        i12 = 4194304;
                    }
                    i3 |= i12;
                }
            }
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i13 = 67108864;
                } else {
                    i13 = 33554432;
                }
                i3 |= i13;
            }
            r13 = 1;
            if ((i3 & 38347923) != 38347922) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "94@4298L6,96@4415L12");
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource2 = null;
                    }
                    if ((i2 & 16) != 0) {
                        cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i3 &= -57345;
                    } else {
                        cornerBasedShapeCopy = shape2;
                    }
                    if (i11 != 0) {
                        borderStroke4 = null;
                    } else {
                        borderStroke4 = borderStroke2;
                    }
                    if ((i2 & 64) != 0) {
                        z5 = false;
                        composer3 = composerStartRestartGroup;
                        i3 &= -3670017;
                        chipColorsM2319chipColors5tl4gsc = ChipDefaults.INSTANCE.m2319chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                    } else {
                        composer3 = composerStartRestartGroup;
                        z5 = false;
                    }
                    ChipColors chipColors114 = chipColorsM2319chipColors5tl4gsc;
                    shape4 = cornerBasedShapeCopy;
                    chipColors3 = chipColors114;
                    if (i10 != 0) {
                        function5 = null;
                    } else {
                        function5 = function2;
                    }
                    borderStroke5 = borderStroke4;
                    z6 = z2;
                    mutableInteractionSource4 = mutableInteractionSource2;
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource2 = null;
                    }
                    if ((i2 & 16) != 0) {
                        cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i3 &= -57345;
                    } else {
                        cornerBasedShapeCopy = shape2;
                    }
                    if (i11 != 0) {
                        borderStroke4 = null;
                    } else {
                        borderStroke4 = borderStroke2;
                    }
                    if ((i2 & 64) != 0) {
                        z5 = false;
                        composer3 = composerStartRestartGroup;
                        i3 &= -3670017;
                        chipColorsM2319chipColors5tl4gsc = ChipDefaults.INSTANCE.m2319chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                    } else {
                        composer3 = composerStartRestartGroup;
                        z5 = false;
                    }
                    ChipColors chipColors115 = chipColorsM2319chipColors5tl4gsc;
                    shape4 = cornerBasedShapeCopy;
                    chipColors3 = chipColors115;
                    if (i10 != 0) {
                        function5 = null;
                    } else {
                        function5 = function2;
                    }
                    borderStroke5 = borderStroke4;
                    z6 = z2;
                    mutableInteractionSource4 = mutableInteractionSource2;
                }
                composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1232125330, i3, -1, "androidx.compose.material.Chip (Chip.kt:99)");
                }
                int i114 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                final State stateContentColor8 = chipColors3.contentColor(z6, composer3, i114);
                ComposerKt.sourceInformationMarkerStart(composer3, 1338549252, "CC(remember):Chip.kt#9igjgp");
                objRememberedValue = composer3.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ChipKt.Chip$lambda$1$0((SemanticsPropertyReceiver) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                final ChipColors chipColors116 = chipColors3;
                final Function2 function13 = function5;
                final boolean z14 = z6;
                composer2 = composer3;
                SurfaceKt.m2585SurfaceLPr_se0(function0, SemanticsModifierKt.semantics$default(modifier2, z5, (Function1) objRememberedValue, r13, null), z6, shape4, chipColors3.backgroundColor(z6, composer3, i114).getValue().m6824unboximpl(), Color.m6813copywmQWz5c$default(Chip$lambda$0(stateContentColor8), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke5, 0.0f, mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(-1849195083, r13, new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ChipKt.Chip$lambda$2(stateContentColor8, function13, chipColors116, z14, function3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer3, 54), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | (3670016 & (i3 << 3)) | ((i3 << 15) & 234881024), 128);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                chipColors2 = chipColors3;
                function4 = function13;
                modifier3 = modifier2;
                z4 = z6;
                shape3 = shape4;
                borderStroke3 = borderStroke5;
                mutableInteractionSource3 = mutableInteractionSource4;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                function4 = function2;
                modifier3 = modifier2;
                z4 = z2;
                mutableInteractionSource3 = mutableInteractionSource2;
                shape3 = shape2;
                borderStroke3 = borderStroke2;
                chipColors2 = chipColorsM2319chipColors5tl4gsc;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ChipKt.Chip$lambda$3(function0, modifier3, z4, mutableInteractionSource3, shape3, borderStroke3, chipColors2, function4, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
                        shape2 = shape;
                        if (composerStartRestartGroup.changed(shape2)) {
                        }
                        i3 |= i15;
                    } else {
                        shape2 = shape;
                    }
                    i3 |= i15;
                } else {
                    shape2 = shape;
                }
                i8 = i2 & 32;
                if (i8 != 0) {
                    if ((196608 & i) == 0) {
                        borderStroke2 = borderStroke;
                        if (composerStartRestartGroup.changed(borderStroke2)) {
                            i9 = 131072;
                        } else {
                            i9 = 65536;
                        }
                        i3 |= i9;
                    }
                    if ((1572864 & i) == 0) {
                        if ((i2 & 64) == 0) {
                            chipColorsM2319chipColors5tl4gsc = chipColors;
                            if (composerStartRestartGroup.changed(chipColorsM2319chipColors5tl4gsc)) {
                            }
                            i3 |= i16;
                        } else {
                            chipColorsM2319chipColors5tl4gsc = chipColors;
                        }
                        i3 |= i16;
                    } else {
                        chipColorsM2319chipColors5tl4gsc = chipColors;
                    }
                    i10 = i2 & 128;
                    if (i10 != 0) {
                        i3 |= 12582912;
                        i11 = i8;
                    } else {
                        i11 = i8;
                        if ((i & 12582912) == 0) {
                            if (composerStartRestartGroup.changedInstance(function2)) {
                                i12 = 8388608;
                            } else {
                                i12 = 4194304;
                            }
                            i3 |= i12;
                        }
                    }
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i13 = 67108864;
                        } else {
                            i13 = 33554432;
                        }
                        i3 |= i13;
                    }
                    r13 = 1;
                    if ((i3 & 38347923) != 38347922) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "94@4298L6,96@4415L12");
                        if ((i & 1) != 0) {
                            if (i14 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if (i6 != 0) {
                                mutableInteractionSource2 = null;
                            }
                            if ((i2 & 16) != 0) {
                                cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                i3 &= -57345;
                            } else {
                                cornerBasedShapeCopy = shape2;
                            }
                            if (i11 != 0) {
                                borderStroke4 = null;
                            } else {
                                borderStroke4 = borderStroke2;
                            }
                            if ((i2 & 64) != 0) {
                                z5 = false;
                                composer3 = composerStartRestartGroup;
                                i3 &= -3670017;
                                chipColorsM2319chipColors5tl4gsc = ChipDefaults.INSTANCE.m2319chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            } else {
                                composer3 = composerStartRestartGroup;
                                z5 = false;
                            }
                            ChipColors chipColors117 = chipColorsM2319chipColors5tl4gsc;
                            shape4 = cornerBasedShapeCopy;
                            chipColors3 = chipColors117;
                            if (i10 != 0) {
                                function5 = null;
                            } else {
                                function5 = function2;
                            }
                            borderStroke5 = borderStroke4;
                            z6 = z2;
                            mutableInteractionSource4 = mutableInteractionSource2;
                        } else {
                            if (i14 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if (i6 != 0) {
                                mutableInteractionSource2 = null;
                            }
                            if ((i2 & 16) != 0) {
                                cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                i3 &= -57345;
                            } else {
                                cornerBasedShapeCopy = shape2;
                            }
                            if (i11 != 0) {
                                borderStroke4 = null;
                            } else {
                                borderStroke4 = borderStroke2;
                            }
                            if ((i2 & 64) != 0) {
                                z5 = false;
                                composer3 = composerStartRestartGroup;
                                i3 &= -3670017;
                                chipColorsM2319chipColors5tl4gsc = ChipDefaults.INSTANCE.m2319chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                            } else {
                                composer3 = composerStartRestartGroup;
                                z5 = false;
                            }
                            ChipColors chipColors118 = chipColorsM2319chipColors5tl4gsc;
                            shape4 = cornerBasedShapeCopy;
                            chipColors3 = chipColors118;
                            if (i10 != 0) {
                                function5 = null;
                            } else {
                                function5 = function2;
                            }
                            borderStroke5 = borderStroke4;
                            z6 = z2;
                            mutableInteractionSource4 = mutableInteractionSource2;
                        }
                        composer3.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1232125330, i3, -1, "androidx.compose.material.Chip (Chip.kt:99)");
                        }
                        int i115 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                        final State stateContentColor9 = chipColors3.contentColor(z6, composer3, i115);
                        ComposerKt.sourceInformationMarkerStart(composer3, 1338549252, "CC(remember):Chip.kt#9igjgp");
                        objRememberedValue = composer3.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda7
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ChipKt.Chip$lambda$1$0((SemanticsPropertyReceiver) obj);
                                }
                            };
                            composer3.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        final ChipColors chipColors119 = chipColors3;
                        final Function2 function14 = function5;
                        final boolean z15 = z6;
                        composer2 = composer3;
                        SurfaceKt.m2585SurfaceLPr_se0(function0, SemanticsModifierKt.semantics$default(modifier2, z5, (Function1) objRememberedValue, r13, null), z6, shape4, chipColors3.backgroundColor(z6, composer3, i115).getValue().m6824unboximpl(), Color.m6813copywmQWz5c$default(Chip$lambda$0(stateContentColor9), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke5, 0.0f, mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(-1849195083, r13, new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ChipKt.Chip$lambda$2(stateContentColor9, function14, chipColors119, z15, function3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | (3670016 & (i3 << 3)) | ((i3 << 15) & 234881024), 128);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        chipColors2 = chipColors3;
                        function4 = function14;
                        modifier3 = modifier2;
                        z4 = z6;
                        shape3 = shape4;
                        borderStroke3 = borderStroke5;
                        mutableInteractionSource3 = mutableInteractionSource4;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        function4 = function2;
                        modifier3 = modifier2;
                        z4 = z2;
                        mutableInteractionSource3 = mutableInteractionSource2;
                        shape3 = shape2;
                        borderStroke3 = borderStroke2;
                        chipColors2 = chipColorsM2319chipColors5tl4gsc;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ChipKt.Chip$lambda$3(function0, modifier3, z4, mutableInteractionSource3, shape3, borderStroke3, chipColors2, function4, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                borderStroke2 = borderStroke;
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        chipColorsM2319chipColors5tl4gsc = chipColors;
                        if (composerStartRestartGroup.changed(chipColorsM2319chipColors5tl4gsc)) {
                        }
                        i3 |= i16;
                    } else {
                        chipColorsM2319chipColors5tl4gsc = chipColors;
                    }
                    i3 |= i16;
                } else {
                    chipColorsM2319chipColors5tl4gsc = chipColors;
                }
                i10 = i2 & 128;
                if (i10 != 0) {
                    i3 |= 12582912;
                    i11 = i8;
                } else {
                    i11 = i8;
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i12 = 8388608;
                        } else {
                            i12 = 4194304;
                        }
                        i3 |= i12;
                    }
                }
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i13 = 67108864;
                    } else {
                        i13 = 33554432;
                    }
                    i3 |= i13;
                }
                r13 = 1;
                if ((i3 & 38347923) != 38347922) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "94@4298L6,96@4415L12");
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource2 = null;
                        }
                        if ((i2 & 16) != 0) {
                            cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -57345;
                        } else {
                            cornerBasedShapeCopy = shape2;
                        }
                        if (i11 != 0) {
                            borderStroke4 = null;
                        } else {
                            borderStroke4 = borderStroke2;
                        }
                        if ((i2 & 64) != 0) {
                            z5 = false;
                            composer3 = composerStartRestartGroup;
                            i3 &= -3670017;
                            chipColorsM2319chipColors5tl4gsc = ChipDefaults.INSTANCE.m2319chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                        } else {
                            composer3 = composerStartRestartGroup;
                            z5 = false;
                        }
                        ChipColors chipColors1110 = chipColorsM2319chipColors5tl4gsc;
                        shape4 = cornerBasedShapeCopy;
                        chipColors3 = chipColors1110;
                        if (i10 != 0) {
                            function5 = null;
                        } else {
                            function5 = function2;
                        }
                        borderStroke5 = borderStroke4;
                        z6 = z2;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource2 = null;
                        }
                        if ((i2 & 16) != 0) {
                            cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -57345;
                        } else {
                            cornerBasedShapeCopy = shape2;
                        }
                        if (i11 != 0) {
                            borderStroke4 = null;
                        } else {
                            borderStroke4 = borderStroke2;
                        }
                        if ((i2 & 64) != 0) {
                            z5 = false;
                            composer3 = composerStartRestartGroup;
                            i3 &= -3670017;
                            chipColorsM2319chipColors5tl4gsc = ChipDefaults.INSTANCE.m2319chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                        } else {
                            composer3 = composerStartRestartGroup;
                            z5 = false;
                        }
                        ChipColors chipColors1111 = chipColorsM2319chipColors5tl4gsc;
                        shape4 = cornerBasedShapeCopy;
                        chipColors3 = chipColors1111;
                        if (i10 != 0) {
                            function5 = null;
                        } else {
                            function5 = function2;
                        }
                        borderStroke5 = borderStroke4;
                        z6 = z2;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    composer3.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1232125330, i3, -1, "androidx.compose.material.Chip (Chip.kt:99)");
                    }
                    int i116 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                    final State stateContentColor10 = chipColors3.contentColor(z6, composer3, i116);
                    ComposerKt.sourceInformationMarkerStart(composer3, 1338549252, "CC(remember):Chip.kt#9igjgp");
                    objRememberedValue = composer3.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ChipKt.Chip$lambda$1$0((SemanticsPropertyReceiver) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    final ChipColors chipColors1112 = chipColors3;
                    final Function2 function15 = function5;
                    final boolean z16 = z6;
                    composer2 = composer3;
                    SurfaceKt.m2585SurfaceLPr_se0(function0, SemanticsModifierKt.semantics$default(modifier2, z5, (Function1) objRememberedValue, r13, null), z6, shape4, chipColors3.backgroundColor(z6, composer3, i116).getValue().m6824unboximpl(), Color.m6813copywmQWz5c$default(Chip$lambda$0(stateContentColor10), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke5, 0.0f, mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(-1849195083, r13, new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ChipKt.Chip$lambda$2(stateContentColor10, function15, chipColors1112, z16, function3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer3, 54), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | (3670016 & (i3 << 3)) | ((i3 << 15) & 234881024), 128);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    chipColors2 = chipColors3;
                    function4 = function15;
                    modifier3 = modifier2;
                    z4 = z6;
                    shape3 = shape4;
                    borderStroke3 = borderStroke5;
                    mutableInteractionSource3 = mutableInteractionSource4;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    function4 = function2;
                    modifier3 = modifier2;
                    z4 = z2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    shape3 = shape2;
                    borderStroke3 = borderStroke2;
                    chipColors2 = chipColorsM2319chipColors5tl4gsc;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ChipKt.Chip$lambda$3(function0, modifier3, z4, mutableInteractionSource3, shape3, borderStroke3, chipColors2, function4, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                    }
                    i3 |= i15;
                } else {
                    shape2 = shape;
                }
                i3 |= i15;
            } else {
                shape2 = shape;
            }
            i8 = i2 & 32;
            if (i8 != 0) {
                if ((196608 & i) == 0) {
                    borderStroke2 = borderStroke;
                    if (composerStartRestartGroup.changed(borderStroke2)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        chipColorsM2319chipColors5tl4gsc = chipColors;
                        if (composerStartRestartGroup.changed(chipColorsM2319chipColors5tl4gsc)) {
                        }
                        i3 |= i16;
                    } else {
                        chipColorsM2319chipColors5tl4gsc = chipColors;
                    }
                    i3 |= i16;
                } else {
                    chipColorsM2319chipColors5tl4gsc = chipColors;
                }
                i10 = i2 & 128;
                if (i10 != 0) {
                    i3 |= 12582912;
                    i11 = i8;
                } else {
                    i11 = i8;
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i12 = 8388608;
                        } else {
                            i12 = 4194304;
                        }
                        i3 |= i12;
                    }
                }
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i13 = 67108864;
                    } else {
                        i13 = 33554432;
                    }
                    i3 |= i13;
                }
                r13 = 1;
                if ((i3 & 38347923) != 38347922) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "94@4298L6,96@4415L12");
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource2 = null;
                        }
                        if ((i2 & 16) != 0) {
                            cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -57345;
                        } else {
                            cornerBasedShapeCopy = shape2;
                        }
                        if (i11 != 0) {
                            borderStroke4 = null;
                        } else {
                            borderStroke4 = borderStroke2;
                        }
                        if ((i2 & 64) != 0) {
                            z5 = false;
                            composer3 = composerStartRestartGroup;
                            i3 &= -3670017;
                            chipColorsM2319chipColors5tl4gsc = ChipDefaults.INSTANCE.m2319chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                        } else {
                            composer3 = composerStartRestartGroup;
                            z5 = false;
                        }
                        ChipColors chipColors1113 = chipColorsM2319chipColors5tl4gsc;
                        shape4 = cornerBasedShapeCopy;
                        chipColors3 = chipColors1113;
                        if (i10 != 0) {
                            function5 = null;
                        } else {
                            function5 = function2;
                        }
                        borderStroke5 = borderStroke4;
                        z6 = z2;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource2 = null;
                        }
                        if ((i2 & 16) != 0) {
                            cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -57345;
                        } else {
                            cornerBasedShapeCopy = shape2;
                        }
                        if (i11 != 0) {
                            borderStroke4 = null;
                        } else {
                            borderStroke4 = borderStroke2;
                        }
                        if ((i2 & 64) != 0) {
                            z5 = false;
                            composer3 = composerStartRestartGroup;
                            i3 &= -3670017;
                            chipColorsM2319chipColors5tl4gsc = ChipDefaults.INSTANCE.m2319chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                        } else {
                            composer3 = composerStartRestartGroup;
                            z5 = false;
                        }
                        ChipColors chipColors1114 = chipColorsM2319chipColors5tl4gsc;
                        shape4 = cornerBasedShapeCopy;
                        chipColors3 = chipColors1114;
                        if (i10 != 0) {
                            function5 = null;
                        } else {
                            function5 = function2;
                        }
                        borderStroke5 = borderStroke4;
                        z6 = z2;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    composer3.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1232125330, i3, -1, "androidx.compose.material.Chip (Chip.kt:99)");
                    }
                    int i117 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                    final State stateContentColor11 = chipColors3.contentColor(z6, composer3, i117);
                    ComposerKt.sourceInformationMarkerStart(composer3, 1338549252, "CC(remember):Chip.kt#9igjgp");
                    objRememberedValue = composer3.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ChipKt.Chip$lambda$1$0((SemanticsPropertyReceiver) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    final ChipColors chipColors1115 = chipColors3;
                    final Function2 function16 = function5;
                    final boolean z17 = z6;
                    composer2 = composer3;
                    SurfaceKt.m2585SurfaceLPr_se0(function0, SemanticsModifierKt.semantics$default(modifier2, z5, (Function1) objRememberedValue, r13, null), z6, shape4, chipColors3.backgroundColor(z6, composer3, i117).getValue().m6824unboximpl(), Color.m6813copywmQWz5c$default(Chip$lambda$0(stateContentColor11), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke5, 0.0f, mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(-1849195083, r13, new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ChipKt.Chip$lambda$2(stateContentColor11, function16, chipColors1115, z17, function3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer3, 54), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | (3670016 & (i3 << 3)) | ((i3 << 15) & 234881024), 128);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    chipColors2 = chipColors3;
                    function4 = function16;
                    modifier3 = modifier2;
                    z4 = z6;
                    shape3 = shape4;
                    borderStroke3 = borderStroke5;
                    mutableInteractionSource3 = mutableInteractionSource4;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    function4 = function2;
                    modifier3 = modifier2;
                    z4 = z2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    shape3 = shape2;
                    borderStroke3 = borderStroke2;
                    chipColors2 = chipColorsM2319chipColors5tl4gsc;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ChipKt.Chip$lambda$3(function0, modifier3, z4, mutableInteractionSource3, shape3, borderStroke3, chipColors2, function4, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            borderStroke2 = borderStroke;
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    chipColorsM2319chipColors5tl4gsc = chipColors;
                    if (composerStartRestartGroup.changed(chipColorsM2319chipColors5tl4gsc)) {
                    }
                    i3 |= i16;
                } else {
                    chipColorsM2319chipColors5tl4gsc = chipColors;
                }
                i3 |= i16;
            } else {
                chipColorsM2319chipColors5tl4gsc = chipColors;
            }
            i10 = i2 & 128;
            if (i10 != 0) {
                i3 |= 12582912;
                i11 = i8;
            } else {
                i11 = i8;
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i12 = 8388608;
                    } else {
                        i12 = 4194304;
                    }
                    i3 |= i12;
                }
            }
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i13 = 67108864;
                } else {
                    i13 = 33554432;
                }
                i3 |= i13;
            }
            r13 = 1;
            if ((i3 & 38347923) != 38347922) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "94@4298L6,96@4415L12");
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource2 = null;
                    }
                    if ((i2 & 16) != 0) {
                        cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i3 &= -57345;
                    } else {
                        cornerBasedShapeCopy = shape2;
                    }
                    if (i11 != 0) {
                        borderStroke4 = null;
                    } else {
                        borderStroke4 = borderStroke2;
                    }
                    if ((i2 & 64) != 0) {
                        z5 = false;
                        composer3 = composerStartRestartGroup;
                        i3 &= -3670017;
                        chipColorsM2319chipColors5tl4gsc = ChipDefaults.INSTANCE.m2319chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                    } else {
                        composer3 = composerStartRestartGroup;
                        z5 = false;
                    }
                    ChipColors chipColors1116 = chipColorsM2319chipColors5tl4gsc;
                    shape4 = cornerBasedShapeCopy;
                    chipColors3 = chipColors1116;
                    if (i10 != 0) {
                        function5 = null;
                    } else {
                        function5 = function2;
                    }
                    borderStroke5 = borderStroke4;
                    z6 = z2;
                    mutableInteractionSource4 = mutableInteractionSource2;
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource2 = null;
                    }
                    if ((i2 & 16) != 0) {
                        cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i3 &= -57345;
                    } else {
                        cornerBasedShapeCopy = shape2;
                    }
                    if (i11 != 0) {
                        borderStroke4 = null;
                    } else {
                        borderStroke4 = borderStroke2;
                    }
                    if ((i2 & 64) != 0) {
                        z5 = false;
                        composer3 = composerStartRestartGroup;
                        i3 &= -3670017;
                        chipColorsM2319chipColors5tl4gsc = ChipDefaults.INSTANCE.m2319chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                    } else {
                        composer3 = composerStartRestartGroup;
                        z5 = false;
                    }
                    ChipColors chipColors1117 = chipColorsM2319chipColors5tl4gsc;
                    shape4 = cornerBasedShapeCopy;
                    chipColors3 = chipColors1117;
                    if (i10 != 0) {
                        function5 = null;
                    } else {
                        function5 = function2;
                    }
                    borderStroke5 = borderStroke4;
                    z6 = z2;
                    mutableInteractionSource4 = mutableInteractionSource2;
                }
                composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1232125330, i3, -1, "androidx.compose.material.Chip (Chip.kt:99)");
                }
                int i118 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                final State stateContentColor12 = chipColors3.contentColor(z6, composer3, i118);
                ComposerKt.sourceInformationMarkerStart(composer3, 1338549252, "CC(remember):Chip.kt#9igjgp");
                objRememberedValue = composer3.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ChipKt.Chip$lambda$1$0((SemanticsPropertyReceiver) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                final ChipColors chipColors1118 = chipColors3;
                final Function2 function17 = function5;
                final boolean z18 = z6;
                composer2 = composer3;
                SurfaceKt.m2585SurfaceLPr_se0(function0, SemanticsModifierKt.semantics$default(modifier2, z5, (Function1) objRememberedValue, r13, null), z6, shape4, chipColors3.backgroundColor(z6, composer3, i118).getValue().m6824unboximpl(), Color.m6813copywmQWz5c$default(Chip$lambda$0(stateContentColor12), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke5, 0.0f, mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(-1849195083, r13, new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ChipKt.Chip$lambda$2(stateContentColor12, function17, chipColors1118, z18, function3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer3, 54), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | (3670016 & (i3 << 3)) | ((i3 << 15) & 234881024), 128);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                chipColors2 = chipColors3;
                function4 = function17;
                modifier3 = modifier2;
                z4 = z6;
                shape3 = shape4;
                borderStroke3 = borderStroke5;
                mutableInteractionSource3 = mutableInteractionSource4;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                function4 = function2;
                modifier3 = modifier2;
                z4 = z2;
                mutableInteractionSource3 = mutableInteractionSource2;
                shape3 = shape2;
                borderStroke3 = borderStroke2;
                chipColors2 = chipColorsM2319chipColors5tl4gsc;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ChipKt.Chip$lambda$3(function0, modifier3, z4, mutableInteractionSource3, shape3, borderStroke3, chipColors2, function4, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                    }
                    i3 |= i15;
                } else {
                    shape2 = shape;
                }
                i3 |= i15;
            } else {
                shape2 = shape;
            }
            i8 = i2 & 32;
            if (i8 != 0) {
                if ((196608 & i) == 0) {
                    borderStroke2 = borderStroke;
                    if (composerStartRestartGroup.changed(borderStroke2)) {
                        i9 = 131072;
                    } else {
                        i9 = 65536;
                    }
                    i3 |= i9;
                }
                if ((1572864 & i) == 0) {
                    if ((i2 & 64) == 0) {
                        chipColorsM2319chipColors5tl4gsc = chipColors;
                        if (composerStartRestartGroup.changed(chipColorsM2319chipColors5tl4gsc)) {
                        }
                        i3 |= i16;
                    } else {
                        chipColorsM2319chipColors5tl4gsc = chipColors;
                    }
                    i3 |= i16;
                } else {
                    chipColorsM2319chipColors5tl4gsc = chipColors;
                }
                i10 = i2 & 128;
                if (i10 != 0) {
                    i3 |= 12582912;
                    i11 = i8;
                } else {
                    i11 = i8;
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i12 = 8388608;
                        } else {
                            i12 = 4194304;
                        }
                        i3 |= i12;
                    }
                }
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i13 = 67108864;
                    } else {
                        i13 = 33554432;
                    }
                    i3 |= i13;
                }
                r13 = 1;
                if ((i3 & 38347923) != 38347922) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "94@4298L6,96@4415L12");
                    if ((i & 1) != 0) {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource2 = null;
                        }
                        if ((i2 & 16) != 0) {
                            cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -57345;
                        } else {
                            cornerBasedShapeCopy = shape2;
                        }
                        if (i11 != 0) {
                            borderStroke4 = null;
                        } else {
                            borderStroke4 = borderStroke2;
                        }
                        if ((i2 & 64) != 0) {
                            z5 = false;
                            composer3 = composerStartRestartGroup;
                            i3 &= -3670017;
                            chipColorsM2319chipColors5tl4gsc = ChipDefaults.INSTANCE.m2319chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                        } else {
                            composer3 = composerStartRestartGroup;
                            z5 = false;
                        }
                        ChipColors chipColors1119 = chipColorsM2319chipColors5tl4gsc;
                        shape4 = cornerBasedShapeCopy;
                        chipColors3 = chipColors1119;
                        if (i10 != 0) {
                            function5 = null;
                        } else {
                            function5 = function2;
                        }
                        borderStroke5 = borderStroke4;
                        z6 = z2;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    } else {
                        if (i14 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource2 = null;
                        }
                        if ((i2 & 16) != 0) {
                            cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i3 &= -57345;
                        } else {
                            cornerBasedShapeCopy = shape2;
                        }
                        if (i11 != 0) {
                            borderStroke4 = null;
                        } else {
                            borderStroke4 = borderStroke2;
                        }
                        if ((i2 & 64) != 0) {
                            z5 = false;
                            composer3 = composerStartRestartGroup;
                            i3 &= -3670017;
                            chipColorsM2319chipColors5tl4gsc = ChipDefaults.INSTANCE.m2319chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                        } else {
                            composer3 = composerStartRestartGroup;
                            z5 = false;
                        }
                        ChipColors chipColors11110 = chipColorsM2319chipColors5tl4gsc;
                        shape4 = cornerBasedShapeCopy;
                        chipColors3 = chipColors11110;
                        if (i10 != 0) {
                            function5 = null;
                        } else {
                            function5 = function2;
                        }
                        borderStroke5 = borderStroke4;
                        z6 = z2;
                        mutableInteractionSource4 = mutableInteractionSource2;
                    }
                    composer3.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1232125330, i3, -1, "androidx.compose.material.Chip (Chip.kt:99)");
                    }
                    int i119 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                    final State stateContentColor13 = chipColors3.contentColor(z6, composer3, i119);
                    ComposerKt.sourceInformationMarkerStart(composer3, 1338549252, "CC(remember):Chip.kt#9igjgp");
                    objRememberedValue = composer3.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ChipKt.Chip$lambda$1$0((SemanticsPropertyReceiver) obj);
                            }
                        };
                        composer3.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    final ChipColors chipColors11111 = chipColors3;
                    final Function2 function18 = function5;
                    final boolean z19 = z6;
                    composer2 = composer3;
                    SurfaceKt.m2585SurfaceLPr_se0(function0, SemanticsModifierKt.semantics$default(modifier2, z5, (Function1) objRememberedValue, r13, null), z6, shape4, chipColors3.backgroundColor(z6, composer3, i119).getValue().m6824unboximpl(), Color.m6813copywmQWz5c$default(Chip$lambda$0(stateContentColor13), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke5, 0.0f, mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(-1849195083, r13, new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ChipKt.Chip$lambda$2(stateContentColor13, function18, chipColors11111, z19, function3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer3, 54), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | (3670016 & (i3 << 3)) | ((i3 << 15) & 234881024), 128);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    chipColors2 = chipColors3;
                    function4 = function18;
                    modifier3 = modifier2;
                    z4 = z6;
                    shape3 = shape4;
                    borderStroke3 = borderStroke5;
                    mutableInteractionSource3 = mutableInteractionSource4;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    function4 = function2;
                    modifier3 = modifier2;
                    z4 = z2;
                    mutableInteractionSource3 = mutableInteractionSource2;
                    shape3 = shape2;
                    borderStroke3 = borderStroke2;
                    chipColors2 = chipColorsM2319chipColors5tl4gsc;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ChipKt.Chip$lambda$3(function0, modifier3, z4, mutableInteractionSource3, shape3, borderStroke3, chipColors2, function4, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            borderStroke2 = borderStroke;
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    chipColorsM2319chipColors5tl4gsc = chipColors;
                    if (composerStartRestartGroup.changed(chipColorsM2319chipColors5tl4gsc)) {
                    }
                    i3 |= i16;
                } else {
                    chipColorsM2319chipColors5tl4gsc = chipColors;
                }
                i3 |= i16;
            } else {
                chipColorsM2319chipColors5tl4gsc = chipColors;
            }
            i10 = i2 & 128;
            if (i10 != 0) {
                i3 |= 12582912;
                i11 = i8;
            } else {
                i11 = i8;
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i12 = 8388608;
                    } else {
                        i12 = 4194304;
                    }
                    i3 |= i12;
                }
            }
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i13 = 67108864;
                } else {
                    i13 = 33554432;
                }
                i3 |= i13;
            }
            r13 = 1;
            if ((i3 & 38347923) != 38347922) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "94@4298L6,96@4415L12");
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource2 = null;
                    }
                    if ((i2 & 16) != 0) {
                        cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i3 &= -57345;
                    } else {
                        cornerBasedShapeCopy = shape2;
                    }
                    if (i11 != 0) {
                        borderStroke4 = null;
                    } else {
                        borderStroke4 = borderStroke2;
                    }
                    if ((i2 & 64) != 0) {
                        z5 = false;
                        composer3 = composerStartRestartGroup;
                        i3 &= -3670017;
                        chipColorsM2319chipColors5tl4gsc = ChipDefaults.INSTANCE.m2319chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                    } else {
                        composer3 = composerStartRestartGroup;
                        z5 = false;
                    }
                    ChipColors chipColors11112 = chipColorsM2319chipColors5tl4gsc;
                    shape4 = cornerBasedShapeCopy;
                    chipColors3 = chipColors11112;
                    if (i10 != 0) {
                        function5 = null;
                    } else {
                        function5 = function2;
                    }
                    borderStroke5 = borderStroke4;
                    z6 = z2;
                    mutableInteractionSource4 = mutableInteractionSource2;
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource2 = null;
                    }
                    if ((i2 & 16) != 0) {
                        cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i3 &= -57345;
                    } else {
                        cornerBasedShapeCopy = shape2;
                    }
                    if (i11 != 0) {
                        borderStroke4 = null;
                    } else {
                        borderStroke4 = borderStroke2;
                    }
                    if ((i2 & 64) != 0) {
                        z5 = false;
                        composer3 = composerStartRestartGroup;
                        i3 &= -3670017;
                        chipColorsM2319chipColors5tl4gsc = ChipDefaults.INSTANCE.m2319chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                    } else {
                        composer3 = composerStartRestartGroup;
                        z5 = false;
                    }
                    ChipColors chipColors11113 = chipColorsM2319chipColors5tl4gsc;
                    shape4 = cornerBasedShapeCopy;
                    chipColors3 = chipColors11113;
                    if (i10 != 0) {
                        function5 = null;
                    } else {
                        function5 = function2;
                    }
                    borderStroke5 = borderStroke4;
                    z6 = z2;
                    mutableInteractionSource4 = mutableInteractionSource2;
                }
                composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1232125330, i3, -1, "androidx.compose.material.Chip (Chip.kt:99)");
                }
                int i1110 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                final State stateContentColor14 = chipColors3.contentColor(z6, composer3, i1110);
                ComposerKt.sourceInformationMarkerStart(composer3, 1338549252, "CC(remember):Chip.kt#9igjgp");
                objRememberedValue = composer3.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ChipKt.Chip$lambda$1$0((SemanticsPropertyReceiver) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                final ChipColors chipColors11114 = chipColors3;
                final Function2 function19 = function5;
                final boolean z110 = z6;
                composer2 = composer3;
                SurfaceKt.m2585SurfaceLPr_se0(function0, SemanticsModifierKt.semantics$default(modifier2, z5, (Function1) objRememberedValue, r13, null), z6, shape4, chipColors3.backgroundColor(z6, composer3, i1110).getValue().m6824unboximpl(), Color.m6813copywmQWz5c$default(Chip$lambda$0(stateContentColor14), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke5, 0.0f, mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(-1849195083, r13, new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ChipKt.Chip$lambda$2(stateContentColor14, function19, chipColors11114, z110, function3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer3, 54), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | (3670016 & (i3 << 3)) | ((i3 << 15) & 234881024), 128);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                chipColors2 = chipColors3;
                function4 = function19;
                modifier3 = modifier2;
                z4 = z6;
                shape3 = shape4;
                borderStroke3 = borderStroke5;
                mutableInteractionSource3 = mutableInteractionSource4;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                function4 = function2;
                modifier3 = modifier2;
                z4 = z2;
                mutableInteractionSource3 = mutableInteractionSource2;
                shape3 = shape2;
                borderStroke3 = borderStroke2;
                chipColors2 = chipColorsM2319chipColors5tl4gsc;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ChipKt.Chip$lambda$3(function0, modifier3, z4, mutableInteractionSource3, shape3, borderStroke3, chipColors2, function4, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i & 24576) == 0) {
            if ((i2 & 16) == 0) {
                shape2 = shape;
                if (composerStartRestartGroup.changed(shape2)) {
                }
                i3 |= i15;
            } else {
                shape2 = shape;
            }
            i3 |= i15;
        } else {
            shape2 = shape;
        }
        i8 = i2 & 32;
        if (i8 != 0) {
            if ((196608 & i) == 0) {
                borderStroke2 = borderStroke;
                if (composerStartRestartGroup.changed(borderStroke2)) {
                    i9 = 131072;
                } else {
                    i9 = 65536;
                }
                i3 |= i9;
            }
            if ((1572864 & i) == 0) {
                if ((i2 & 64) == 0) {
                    chipColorsM2319chipColors5tl4gsc = chipColors;
                    if (composerStartRestartGroup.changed(chipColorsM2319chipColors5tl4gsc)) {
                    }
                    i3 |= i16;
                } else {
                    chipColorsM2319chipColors5tl4gsc = chipColors;
                }
                i3 |= i16;
            } else {
                chipColorsM2319chipColors5tl4gsc = chipColors;
            }
            i10 = i2 & 128;
            if (i10 != 0) {
                i3 |= 12582912;
                i11 = i8;
            } else {
                i11 = i8;
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i12 = 8388608;
                    } else {
                        i12 = 4194304;
                    }
                    i3 |= i12;
                }
            }
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i13 = 67108864;
                } else {
                    i13 = 33554432;
                }
                i3 |= i13;
            }
            r13 = 1;
            if ((i3 & 38347923) != 38347922) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "94@4298L6,96@4415L12");
                if ((i & 1) != 0) {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource2 = null;
                    }
                    if ((i2 & 16) != 0) {
                        cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i3 &= -57345;
                    } else {
                        cornerBasedShapeCopy = shape2;
                    }
                    if (i11 != 0) {
                        borderStroke4 = null;
                    } else {
                        borderStroke4 = borderStroke2;
                    }
                    if ((i2 & 64) != 0) {
                        z5 = false;
                        composer3 = composerStartRestartGroup;
                        i3 &= -3670017;
                        chipColorsM2319chipColors5tl4gsc = ChipDefaults.INSTANCE.m2319chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                    } else {
                        composer3 = composerStartRestartGroup;
                        z5 = false;
                    }
                    ChipColors chipColors11115 = chipColorsM2319chipColors5tl4gsc;
                    shape4 = cornerBasedShapeCopy;
                    chipColors3 = chipColors11115;
                    if (i10 != 0) {
                        function5 = null;
                    } else {
                        function5 = function2;
                    }
                    borderStroke5 = borderStroke4;
                    z6 = z2;
                    mutableInteractionSource4 = mutableInteractionSource2;
                } else {
                    if (i14 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource2 = null;
                    }
                    if ((i2 & 16) != 0) {
                        cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i3 &= -57345;
                    } else {
                        cornerBasedShapeCopy = shape2;
                    }
                    if (i11 != 0) {
                        borderStroke4 = null;
                    } else {
                        borderStroke4 = borderStroke2;
                    }
                    if ((i2 & 64) != 0) {
                        z5 = false;
                        composer3 = composerStartRestartGroup;
                        i3 &= -3670017;
                        chipColorsM2319chipColors5tl4gsc = ChipDefaults.INSTANCE.m2319chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                    } else {
                        composer3 = composerStartRestartGroup;
                        z5 = false;
                    }
                    ChipColors chipColors11116 = chipColorsM2319chipColors5tl4gsc;
                    shape4 = cornerBasedShapeCopy;
                    chipColors3 = chipColors11116;
                    if (i10 != 0) {
                        function5 = null;
                    } else {
                        function5 = function2;
                    }
                    borderStroke5 = borderStroke4;
                    z6 = z2;
                    mutableInteractionSource4 = mutableInteractionSource2;
                }
                composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1232125330, i3, -1, "androidx.compose.material.Chip (Chip.kt:99)");
                }
                int i1111 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
                final State stateContentColor15 = chipColors3.contentColor(z6, composer3, i1111);
                ComposerKt.sourceInformationMarkerStart(composer3, 1338549252, "CC(remember):Chip.kt#9igjgp");
                objRememberedValue = composer3.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ChipKt.Chip$lambda$1$0((SemanticsPropertyReceiver) obj);
                        }
                    };
                    composer3.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                final ChipColors chipColors11117 = chipColors3;
                final Function2 function110 = function5;
                final boolean z111 = z6;
                composer2 = composer3;
                SurfaceKt.m2585SurfaceLPr_se0(function0, SemanticsModifierKt.semantics$default(modifier2, z5, (Function1) objRememberedValue, r13, null), z6, shape4, chipColors3.backgroundColor(z6, composer3, i1111).getValue().m6824unboximpl(), Color.m6813copywmQWz5c$default(Chip$lambda$0(stateContentColor15), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke5, 0.0f, mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(-1849195083, r13, new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ChipKt.Chip$lambda$2(stateContentColor15, function110, chipColors11117, z111, function3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer3, 54), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | (3670016 & (i3 << 3)) | ((i3 << 15) & 234881024), 128);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                chipColors2 = chipColors3;
                function4 = function110;
                modifier3 = modifier2;
                z4 = z6;
                shape3 = shape4;
                borderStroke3 = borderStroke5;
                mutableInteractionSource3 = mutableInteractionSource4;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                function4 = function2;
                modifier3 = modifier2;
                z4 = z2;
                mutableInteractionSource3 = mutableInteractionSource2;
                shape3 = shape2;
                borderStroke3 = borderStroke2;
                chipColors2 = chipColorsM2319chipColors5tl4gsc;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ChipKt.Chip$lambda$3(function0, modifier3, z4, mutableInteractionSource3, shape3, borderStroke3, chipColors2, function4, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        borderStroke2 = borderStroke;
        if ((1572864 & i) == 0) {
            if ((i2 & 64) == 0) {
                chipColorsM2319chipColors5tl4gsc = chipColors;
                if (composerStartRestartGroup.changed(chipColorsM2319chipColors5tl4gsc)) {
                }
                i3 |= i16;
            } else {
                chipColorsM2319chipColors5tl4gsc = chipColors;
            }
            i3 |= i16;
        } else {
            chipColorsM2319chipColors5tl4gsc = chipColors;
        }
        i10 = i2 & 128;
        if (i10 != 0) {
            i3 |= 12582912;
            i11 = i8;
        } else {
            i11 = i8;
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i12 = 8388608;
                } else {
                    i12 = 4194304;
                }
                i3 |= i12;
            }
        }
        if ((i & 100663296) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i13 = 67108864;
            } else {
                i13 = 33554432;
            }
            i3 |= i13;
        }
        r13 = 1;
        if ((i3 & 38347923) != 38347922) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "94@4298L6,96@4415L12");
            if ((i & 1) != 0) {
                if (i14 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    z2 = true;
                }
                if (i6 != 0) {
                    mutableInteractionSource2 = null;
                }
                if ((i2 & 16) != 0) {
                    cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                    i3 &= -57345;
                } else {
                    cornerBasedShapeCopy = shape2;
                }
                if (i11 != 0) {
                    borderStroke4 = null;
                } else {
                    borderStroke4 = borderStroke2;
                }
                if ((i2 & 64) != 0) {
                    z5 = false;
                    composer3 = composerStartRestartGroup;
                    i3 &= -3670017;
                    chipColorsM2319chipColors5tl4gsc = ChipDefaults.INSTANCE.m2319chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                } else {
                    composer3 = composerStartRestartGroup;
                    z5 = false;
                }
                ChipColors chipColors11118 = chipColorsM2319chipColors5tl4gsc;
                shape4 = cornerBasedShapeCopy;
                chipColors3 = chipColors11118;
                if (i10 != 0) {
                    function5 = null;
                } else {
                    function5 = function2;
                }
                borderStroke5 = borderStroke4;
                z6 = z2;
                mutableInteractionSource4 = mutableInteractionSource2;
            } else {
                if (i14 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    z2 = true;
                }
                if (i6 != 0) {
                    mutableInteractionSource2 = null;
                }
                if ((i2 & 16) != 0) {
                    cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                    i3 &= -57345;
                } else {
                    cornerBasedShapeCopy = shape2;
                }
                if (i11 != 0) {
                    borderStroke4 = null;
                } else {
                    borderStroke4 = borderStroke2;
                }
                if ((i2 & 64) != 0) {
                    z5 = false;
                    composer3 = composerStartRestartGroup;
                    i3 &= -3670017;
                    chipColorsM2319chipColors5tl4gsc = ChipDefaults.INSTANCE.m2319chipColors5tl4gsc(0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 1572864, 63);
                } else {
                    composer3 = composerStartRestartGroup;
                    z5 = false;
                }
                ChipColors chipColors11119 = chipColorsM2319chipColors5tl4gsc;
                shape4 = cornerBasedShapeCopy;
                chipColors3 = chipColors11119;
                if (i10 != 0) {
                    function5 = null;
                } else {
                    function5 = function2;
                }
                borderStroke5 = borderStroke4;
                z6 = z2;
                mutableInteractionSource4 = mutableInteractionSource2;
            }
            composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1232125330, i3, -1, "androidx.compose.material.Chip (Chip.kt:99)");
            }
            int i1112 = ((i3 >> 6) & 14) | ((i3 >> 15) & 112);
            final State stateContentColor16 = chipColors3.contentColor(z6, composer3, i1112);
            ComposerKt.sourceInformationMarkerStart(composer3, 1338549252, "CC(remember):Chip.kt#9igjgp");
            objRememberedValue = composer3.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ChipKt.Chip$lambda$1$0((SemanticsPropertyReceiver) obj);
                    }
                };
                composer3.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer3);
            final ChipColors chipColors111110 = chipColors3;
            final Function2 function111 = function5;
            final boolean z112 = z6;
            composer2 = composer3;
            SurfaceKt.m2585SurfaceLPr_se0(function0, SemanticsModifierKt.semantics$default(modifier2, z5, (Function1) objRememberedValue, r13, null), z6, shape4, chipColors3.backgroundColor(z6, composer3, i1112).getValue().m6824unboximpl(), Color.m6813copywmQWz5c$default(Chip$lambda$0(stateContentColor16), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke5, 0.0f, mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(-1849195083, r13, new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChipKt.Chip$lambda$2(stateContentColor16, function111, chipColors111110, z112, function3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer3, 54), composer2, (i3 & 14) | 805306368 | (i3 & 896) | ((i3 >> 3) & 7168) | (3670016 & (i3 << 3)) | ((i3 << 15) & 234881024), 128);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            chipColors2 = chipColors3;
            function4 = function111;
            modifier3 = modifier2;
            z4 = z6;
            shape3 = shape4;
            borderStroke3 = borderStroke5;
            mutableInteractionSource3 = mutableInteractionSource4;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            function4 = function2;
            modifier3 = modifier2;
            z4 = z2;
            mutableInteractionSource3 = mutableInteractionSource2;
            shape3 = shape2;
            borderStroke3 = borderStroke2;
            chipColors2 = chipColorsM2319chipColors5tl4gsc;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda9
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChipKt.Chip$lambda$3(function0, modifier3, z4, mutableInteractionSource3, shape3, borderStroke3, chipColors2, function4, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Chip$lambda$1$0(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.m8851setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m8832getButtono7Vup1c());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Chip$lambda$2(State state, final Function2 function2, final ChipColors chipColors, final boolean z, final Function3 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C111@4998L1303,111@4926L1375:Chip.kt#jmzs0o");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1849195083, i, -1, "androidx.compose.material.Chip.<anonymous> (Chip.kt:111)");
            }
            CompositionLocalKt.CompositionLocalProvider(ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m6816getAlphaimpl(Chip$lambda$0(state)))), ComposableLambdaKt.rememberComposableLambda(1808091765, true, new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChipKt.Chip$lambda$2$0(function2, chipColors, z, function3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Chip$lambda$2$0(final Function2 function2, final ChipColors chipColors, final boolean z, final Function3 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C112@5051L10,112@5069L1222,112@5012L1279:Chip.kt#jmzs0o");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1808091765, i, -1, "androidx.compose.material.Chip.<anonymous>.<anonymous> (Chip.kt:112)");
            }
            TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer, 6).getBody2(), ComposableLambdaKt.rememberComposableLambda(1507027814, true, new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChipKt.Chip$lambda$2$0$0(function2, chipColors, z, function3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Chip$lambda$2$0$0(Function2 function2, ChipColors chipColors, boolean z, Function3 function3, Composer composer, int i) {
        float fM9687constructorimpl;
        ComposerKt.sourceInformation(composer, "C113@5087L1190:Chip.kt#jmzs0o");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1507027814, i, -1, "androidx.compose.material.Chip.<anonymous>.<anonymous>.<anonymous> (Chip.kt:113)");
            }
            Modifier modifierM1251defaultMinSizeVpY3zN4$default = SizeKt.m1251defaultMinSizeVpY3zN4$default(Modifier.INSTANCE, 0.0f, ChipDefaults.INSTANCE.m2322getMinHeightD9Ej5fM(), 1, null);
            if (function2 == null) {
                fM9687constructorimpl = HorizontalPadding;
            } else {
                fM9687constructorimpl = Dp.m9687constructorimpl(0);
            }
            Modifier modifierM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(modifierM1251defaultMinSizeVpY3zN4$default, fM9687constructorimpl, 0.0f, HorizontalPadding, 0.0f, 10, null);
            Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1222paddingqDBjuR0$default);
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
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 1856957913, "C135@6250L9:Chip.kt#jmzs0o");
            if (function2 == null) {
                composer.startReplaceGroup(1851332280);
            } else {
                composer.startReplaceGroup(1856981007);
                ComposerKt.sourceInformation(composer, "126@5702L47,127@5812L32,128@5869L268,133@6162L45");
                SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, LeadingIconStartSpacing), composer, 6);
                State<Color> stateLeadingIconContentColor = chipColors.leadingIconContentColor(z, composer, 0);
                CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(Chip$lambda$2$0$0$0$0(stateLeadingIconContentColor))), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m6816getAlphaimpl(Chip$lambda$2$0$0$0$0(stateLeadingIconContentColor))))}, (Function2<? super Composer, ? super Integer, Unit>) function2, composer, ProvidedValue.$stable);
                SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, LeadingIconEndSpacing), composer, 6);
            }
            composer.endReplaceGroup();
            function3.invoke(rowScopeInstance, composer, 6);
            ComposerKt.sourceInformationMarkerEnd(composer);
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

    /* JADX WARN: Code duplicated, block: B:100:0x0120  */
    /* JADX WARN: Code duplicated, block: B:101:0x0123  */
    /* JADX WARN: Code duplicated, block: B:106:0x0130  */
    /* JADX WARN: Code duplicated, block: B:107:0x0137  */
    /* JADX WARN: Code duplicated, block: B:109:0x013b  */
    /* JADX WARN: Code duplicated, block: B:111:0x0145  */
    /* JADX WARN: Code duplicated, block: B:112:0x0148  */
    /* JADX WARN: Code duplicated, block: B:114:0x014d  */
    /* JADX WARN: Code duplicated, block: B:117:0x0159  */
    /* JADX WARN: Code duplicated, block: B:119:0x015f  */
    /* JADX WARN: Code duplicated, block: B:120:0x0162  */
    /* JADX WARN: Code duplicated, block: B:124:0x0175  */
    /* JADX WARN: Code duplicated, block: B:128:0x017e  */
    /* JADX WARN: Code duplicated, block: B:131:0x0187  */
    /* JADX WARN: Code duplicated, block: B:133:0x0199  */
    /* JADX WARN: Code duplicated, block: B:143:0x01c0 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:144:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:145:0x01c7  */
    /* JADX WARN: Code duplicated, block: B:147:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:148:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:150:0x01d1  */
    /* JADX WARN: Code duplicated, block: B:151:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:154:0x01da  */
    /* JADX WARN: Code duplicated, block: B:157:0x01f9  */
    /* JADX WARN: Code duplicated, block: B:158:0x01fc  */
    /* JADX WARN: Code duplicated, block: B:161:0x0202  */
    /* JADX WARN: Code duplicated, block: B:162:0x0248  */
    /* JADX WARN: Code duplicated, block: B:164:0x0258  */
    /* JADX WARN: Code duplicated, block: B:166:0x025b  */
    /* JADX WARN: Code duplicated, block: B:167:0x025d  */
    /* JADX WARN: Code duplicated, block: B:169:0x0261  */
    /* JADX WARN: Code duplicated, block: B:170:0x026e  */
    /* JADX WARN: Code duplicated, block: B:174:0x0287  */
    /* JADX WARN: Code duplicated, block: B:177:0x02b7  */
    /* JADX WARN: Code duplicated, block: B:180:0x0354  */
    /* JADX WARN: Code duplicated, block: B:182:0x0366  */
    /* JADX WARN: Code duplicated, block: B:185:0x037e  */
    /* JADX WARN: Code duplicated, block: B:187:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:31:0x005b  */
    /* JADX WARN: Code duplicated, block: B:32:0x005e  */
    /* JADX WARN: Code duplicated, block: B:34:0x0062  */
    /* JADX WARN: Code duplicated, block: B:36:0x006a  */
    /* JADX WARN: Code duplicated, block: B:37:0x006d  */
    /* JADX WARN: Code duplicated, block: B:42:0x0078  */
    /* JADX WARN: Code duplicated, block: B:43:0x007b  */
    /* JADX WARN: Code duplicated, block: B:45:0x007f  */
    /* JADX WARN: Code duplicated, block: B:47:0x0087  */
    /* JADX WARN: Code duplicated, block: B:48:0x008a  */
    /* JADX WARN: Code duplicated, block: B:53:0x0097  */
    /* JADX WARN: Code duplicated, block: B:55:0x009d  */
    /* JADX WARN: Code duplicated, block: B:58:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:60:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:66:0x00be  */
    /* JADX WARN: Code duplicated, block: B:68:0x00c4  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:75:0x00d5  */
    /* JADX WARN: Code duplicated, block: B:77:0x00da  */
    /* JADX WARN: Code duplicated, block: B:78:0x00df  */
    /* JADX WARN: Code duplicated, block: B:80:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:81:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:86:0x00f6  */
    /* JADX WARN: Code duplicated, block: B:88:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:90:0x0102  */
    /* JADX WARN: Code duplicated, block: B:91:0x0105  */
    /* JADX WARN: Code duplicated, block: B:95:0x010f  */
    /* JADX WARN: Code duplicated, block: B:96:0x0112  */
    /* JADX WARN: Code duplicated, block: B:98:0x0116  */
    public static final void FilterChip(final boolean z, final Function0<Unit> function0, Modifier modifier, boolean z2, MutableInteractionSource mutableInteractionSource, Shape shape, BorderStroke borderStroke, SelectableChipColors selectableChipColors, Function2<? super Composer, ? super Integer, Unit> function2, Function2<? super Composer, ? super Integer, Unit> function3, Function2<? super Composer, ? super Integer, Unit> function4, final Function3<? super RowScope, ? super Composer, ? super Integer, Unit> function5, Composer composer, final int i, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        int i5;
        boolean z3;
        int i6;
        int i7;
        int i8;
        CornerBasedShape cornerBasedShapeCopy;
        int i9;
        BorderStroke borderStroke2;
        int i10;
        int i11;
        Function2<? super Composer, ? super Integer, Unit> function6;
        int i12;
        int i13;
        int i14;
        int i15;
        int i16;
        int i17;
        int i18;
        boolean z4;
        Composer composer2;
        final MutableInteractionSource mutableInteractionSource2;
        final SelectableChipColors selectableChipColors2;
        final Function2<? super Composer, ? super Integer, Unit> function7;
        final Function2<? super Composer, ? super Integer, Unit> function8;
        final Shape shape2;
        final BorderStroke borderStroke3;
        final Modifier modifier3;
        final Function2<? super Composer, ? super Integer, Unit> function9;
        final boolean z5;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        MutableInteractionSource mutableInteractionSource3;
        int i19;
        int i20;
        SelectableChipColors selectableChipColorsM2320filterChipColorsJ08w3E;
        Function2<? super Composer, ? super Integer, Unit> function10;
        Function2<? super Composer, ? super Integer, Unit> function11;
        Function2<? super Composer, ? super Integer, Unit> function12;
        Modifier modifier4;
        Object objRememberedValue;
        int i21;
        int i22;
        boolean zChangedInstance;
        int i23;
        Composer composerStartRestartGroup = composer.startRestartGroup(69602198);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FilterChip)N(selected,onClick,modifier,enabled,interactionSource,shape,border,colors,leadingIcon,selectedIcon,trailingIcon,content)196@9190L31,200@9329L24,203@9428L34,207@9602L3857,197@9226L4233:Chip.kt#jmzs0o");
        if ((i & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i4 = i;
        }
        if ((i & 48) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        int i24 = i3 & 4;
        if (i24 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            i5 = i3 & 8;
            if (i5 != 0) {
                if ((i & 3072) == 0) {
                    z3 = z2;
                    if (composerStartRestartGroup.changed(z3)) {
                        i6 = 2048;
                    } else {
                        i6 = 1024;
                    }
                    i4 |= i6;
                }
                i7 = i3 & 16;
                if (i7 != 0) {
                    if ((i & 24576) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i8 = 16384;
                        } else {
                            i8 = 8192;
                        }
                        i4 |= i8;
                    }
                    if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                        cornerBasedShapeCopy = shape;
                        if ((i3 & 32) == 0 || !composerStartRestartGroup.changed(cornerBasedShapeCopy)) {
                            i23 = 65536;
                        } else {
                            i23 = 131072;
                        }
                        i4 |= i23;
                    } else {
                        cornerBasedShapeCopy = shape;
                    }
                    i9 = i3 & 64;
                    if (i9 != 0) {
                        i4 |= 1572864;
                        borderStroke2 = borderStroke;
                    } else {
                        borderStroke2 = borderStroke;
                        if ((i & 1572864) == 0) {
                            if (composerStartRestartGroup.changed(borderStroke2)) {
                                i10 = 1048576;
                            } else {
                                i10 = 524288;
                            }
                            i4 |= i10;
                        }
                    }
                    if ((i & 12582912) == 0) {
                        if ((i3 & 128) != 0) {
                            i22 = 4194304;
                        } else {
                            if ((16777216 & i) == 0) {
                                zChangedInstance = composerStartRestartGroup.changed(selectableChipColors);
                            } else {
                                zChangedInstance = composerStartRestartGroup.changedInstance(selectableChipColors);
                            }
                            if (zChangedInstance) {
                                i22 = 8388608;
                            } else {
                                i22 = 4194304;
                            }
                        }
                        i4 |= i22;
                    }
                    i11 = i3 & 256;
                    if (i11 != 0) {
                        i4 |= 100663296;
                        function6 = function2;
                    } else {
                        function6 = function2;
                        if ((i & 100663296) == 0) {
                            if (composerStartRestartGroup.changedInstance(function6)) {
                                i12 = 67108864;
                            } else {
                                i12 = 33554432;
                            }
                            i4 |= i12;
                        }
                    }
                    i13 = i3 & 512;
                    if (i13 != 0) {
                        if ((i & 805306368) == 0) {
                            if (composerStartRestartGroup.changedInstance(function3)) {
                                i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                            } else {
                                i14 = 268435456;
                            }
                            i4 |= i14;
                        }
                        i15 = i3 & 1024;
                        if (i15 != 0) {
                            i16 = i2 | 6;
                        } else if ((i2 & 6) == 0) {
                            if (composerStartRestartGroup.changedInstance(function4)) {
                                i17 = 4;
                            } else {
                                i17 = 2;
                            }
                            i16 = i2 | i17;
                        } else {
                            i16 = i2;
                        }
                        if ((i2 & 48) == 0) {
                            if (composerStartRestartGroup.changedInstance(function5)) {
                                i21 = 32;
                            } else {
                                i21 = 16;
                            }
                            i16 |= i21;
                        }
                        i18 = i16;
                        if ((i4 & 306783379) == 306783378 || (i18 & 19) != 18) {
                            z4 = true;
                        } else {
                            z4 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                            composerStartRestartGroup.startDefaults();
                            ComposerKt.sourceInformation(composerStartRestartGroup, "187@8731L6,189@8858L18");
                            if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                                if (i24 != 0) {
                                    companion = Modifier.INSTANCE;
                                } else {
                                    companion = modifier2;
                                }
                                if (i5 != 0) {
                                    z3 = true;
                                } else {
                                    z3 = z3;
                                }
                                if (i7 != 0) {
                                    mutableInteractionSource3 = null;
                                } else {
                                    mutableInteractionSource3 = mutableInteractionSource;
                                }
                                if ((i3 & 32) != 0) {
                                    cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                    i4 &= -458753;
                                }
                                i19 = i4;
                                cornerBasedShapeCopy = cornerBasedShapeCopy;
                                if (i9 != 0) {
                                    borderStroke2 = null;
                                } else {
                                    borderStroke2 = borderStroke2;
                                }
                                if ((i3 & 128) != 0) {
                                    i20 = i11;
                                    selectableChipColorsM2320filterChipColorsJ08w3E = ChipDefaults.INSTANCE.m2320filterChipColorsJ08w3E(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 805306368, 511);
                                    i19 &= -29360129;
                                } else {
                                    i20 = i11;
                                    selectableChipColorsM2320filterChipColorsJ08w3E = selectableChipColors;
                                }
                                if (i20 != 0) {
                                    composerStartRestartGroup = composerStartRestartGroup;
                                    function6 = null;
                                }
                                if (i13 != 0) {
                                    function10 = null;
                                } else {
                                    function10 = function3;
                                }
                                if (i15 != 0) {
                                    function11 = null;
                                } else {
                                    function11 = function4;
                                }
                                function12 = function6;
                                modifier4 = companion;
                            } else {
                                composerStartRestartGroup.skipToGroupEnd();
                                if ((i3 & 32) != 0) {
                                    i4 &= -458753;
                                }
                                if ((i3 & 128) != 0) {
                                    i4 &= -29360129;
                                }
                                mutableInteractionSource3 = mutableInteractionSource;
                                function10 = function3;
                                function11 = function4;
                                i18 = i18;
                                function12 = function6;
                                modifier4 = modifier2;
                                i19 = i4;
                                selectableChipColorsM2320filterChipColorsJ08w3E = selectableChipColors;
                            }
                            composerStartRestartGroup.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(69602198, i19, i18, "androidx.compose.material.FilterChip (Chip.kt:194)");
                            }
                            int i25 = i19 << 3;
                            int i26 = ((i19 >> 9) & 14) | (i25 & 112) | ((i19 >> 15) & 896);
                            final State<Color> stateContentColor = selectableChipColorsM2320filterChipColorsJ08w3E.contentColor(z3, z, composerStartRestartGroup, i26);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1831738322, "CC(remember):Chip.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function1() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda0
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return ChipKt.FilterChip$lambda$0$0((SemanticsPropertyReceiver) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            final Function2<? super Composer, ? super Integer, Unit> function13 = function12;
                            Shape shape3 = cornerBasedShapeCopy;
                            final SelectableChipColors selectableChipColors3 = selectableChipColorsM2320filterChipColorsJ08w3E;
                            final Function2<? super Composer, ? super Integer, Unit> function14 = function10;
                            final Function2<? super Composer, ? super Integer, Unit> function15 = function11;
                            final boolean z6 = z3;
                            Modifier modifier5 = modifier4;
                            SurfaceKt.m2586SurfaceNy5ogXk(z, function0, SemanticsModifierKt.semantics$default(modifier4, false, (Function1) objRememberedValue, 1, null), z6, shape3, selectableChipColorsM2320filterChipColorsJ08w3E.backgroundColor(z3, z, composerStartRestartGroup, i26).getValue().m6824unboximpl(), Color.m6813copywmQWz5c$default(stateContentColor.getValue().m6824unboximpl(), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(-60565717, true, new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ChipKt.FilterChip$lambda$1(stateContentColor, function13, z, function14, function15, function5, selectableChipColors3, z6, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i19 & 7294) | (57344 & (i19 >> 3)) | (i25 & 29360128) | ((i19 << 15) & C.ENCODING_PCM_DOUBLE), 6, 256);
                            composer2 = composerStartRestartGroup;
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            shape2 = shape3;
                            borderStroke3 = borderStroke2;
                            mutableInteractionSource2 = mutableInteractionSource3;
                            selectableChipColors2 = selectableChipColors3;
                            function9 = function13;
                            function7 = function14;
                            function8 = function15;
                            z5 = z6;
                            modifier3 = modifier5;
                        } else {
                            composer2 = composerStartRestartGroup;
                            composer2.skipToGroupEnd();
                            mutableInteractionSource2 = mutableInteractionSource;
                            selectableChipColors2 = selectableChipColors;
                            function7 = function3;
                            function8 = function4;
                            shape2 = cornerBasedShapeCopy;
                            borderStroke3 = borderStroke2;
                            modifier3 = modifier2;
                            function9 = function6;
                            z5 = z3;
                        }
                        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return ChipKt.FilterChip$lambda$2(z, function0, modifier3, z5, mutableInteractionSource2, shape2, borderStroke3, selectableChipColors2, function9, function7, function8, function5, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i4 |= 805306368;
                    i15 = i3 & 1024;
                    if (i15 != 0) {
                        i16 = i2 | 6;
                    } else if ((i2 & 6) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i17 = 4;
                        } else {
                            i17 = 2;
                        }
                        i16 = i2 | i17;
                    } else {
                        i16 = i2;
                    }
                    if ((i2 & 48) == 0) {
                        if (composerStartRestartGroup.changedInstance(function5)) {
                            i21 = 32;
                        } else {
                            i21 = 16;
                        }
                        i16 |= i21;
                    }
                    i18 = i16;
                    if ((i4 & 306783379) == 306783378) {
                        z4 = true;
                    } else {
                        z4 = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "187@8731L6,189@8858L18");
                        if ((i & 1) != 0) {
                            if (i24 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i5 != 0) {
                                z3 = true;
                            } else {
                                z3 = z3;
                            }
                            if (i7 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i3 & 32) != 0) {
                                cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                i4 &= -458753;
                            }
                            i19 = i4;
                            cornerBasedShapeCopy = cornerBasedShapeCopy;
                            if (i9 != 0) {
                                borderStroke2 = null;
                            } else {
                                borderStroke2 = borderStroke2;
                            }
                            if ((i3 & 128) != 0) {
                                i20 = i11;
                                selectableChipColorsM2320filterChipColorsJ08w3E = ChipDefaults.INSTANCE.m2320filterChipColorsJ08w3E(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 805306368, 511);
                                i19 &= -29360129;
                            } else {
                                i20 = i11;
                                selectableChipColorsM2320filterChipColorsJ08w3E = selectableChipColors;
                            }
                            if (i20 != 0) {
                                composerStartRestartGroup = composerStartRestartGroup;
                                function6 = null;
                            }
                            if (i13 != 0) {
                                function10 = null;
                            } else {
                                function10 = function3;
                            }
                            if (i15 != 0) {
                                function11 = null;
                            } else {
                                function11 = function4;
                            }
                            function12 = function6;
                            modifier4 = companion;
                        } else {
                            if (i24 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i5 != 0) {
                                z3 = true;
                            } else {
                                z3 = z3;
                            }
                            if (i7 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i3 & 32) != 0) {
                                cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                i4 &= -458753;
                            }
                            i19 = i4;
                            cornerBasedShapeCopy = cornerBasedShapeCopy;
                            if (i9 != 0) {
                                borderStroke2 = null;
                            } else {
                                borderStroke2 = borderStroke2;
                            }
                            if ((i3 & 128) != 0) {
                                i20 = i11;
                                selectableChipColorsM2320filterChipColorsJ08w3E = ChipDefaults.INSTANCE.m2320filterChipColorsJ08w3E(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 805306368, 511);
                                i19 &= -29360129;
                            } else {
                                i20 = i11;
                                selectableChipColorsM2320filterChipColorsJ08w3E = selectableChipColors;
                            }
                            if (i20 != 0) {
                                composerStartRestartGroup = composerStartRestartGroup;
                                function6 = null;
                            }
                            if (i13 != 0) {
                                function10 = null;
                            } else {
                                function10 = function3;
                            }
                            if (i15 != 0) {
                                function11 = null;
                            } else {
                                function11 = function4;
                            }
                            function12 = function6;
                            modifier4 = companion;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(69602198, i19, i18, "androidx.compose.material.FilterChip (Chip.kt:194)");
                        }
                        int i27 = i19 << 3;
                        int i28 = ((i19 >> 9) & 14) | (i27 & 112) | ((i19 >> 15) & 896);
                        final State stateContentColor2 = selectableChipColorsM2320filterChipColorsJ08w3E.contentColor(z3, z, composerStartRestartGroup, i28);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1831738322, "CC(remember):Chip.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ChipKt.FilterChip$lambda$0$0((SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        final Function2 function16 = function12;
                        Shape shape4 = cornerBasedShapeCopy;
                        final SelectableChipColors selectableChipColors4 = selectableChipColorsM2320filterChipColorsJ08w3E;
                        final Function2 function17 = function10;
                        final Function2 function18 = function11;
                        final boolean z7 = z3;
                        Modifier modifier6 = modifier4;
                        SurfaceKt.m2586SurfaceNy5ogXk(z, function0, SemanticsModifierKt.semantics$default(modifier4, false, (Function1) objRememberedValue, 1, null), z7, shape4, selectableChipColorsM2320filterChipColorsJ08w3E.backgroundColor(z3, z, composerStartRestartGroup, i28).getValue().m6824unboximpl(), Color.m6813copywmQWz5c$default(stateContentColor2.getValue().m6824unboximpl(), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(-60565717, true, new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ChipKt.FilterChip$lambda$1(stateContentColor2, function16, z, function17, function18, function5, selectableChipColors4, z7, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i19 & 7294) | (57344 & (i19 >> 3)) | (i27 & 29360128) | ((i19 << 15) & C.ENCODING_PCM_DOUBLE), 6, 256);
                        composer2 = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        shape2 = shape4;
                        borderStroke3 = borderStroke2;
                        mutableInteractionSource2 = mutableInteractionSource3;
                        selectableChipColors2 = selectableChipColors4;
                        function9 = function16;
                        function7 = function17;
                        function8 = function18;
                        z5 = z7;
                        modifier3 = modifier6;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        mutableInteractionSource2 = mutableInteractionSource;
                        selectableChipColors2 = selectableChipColors;
                        function7 = function3;
                        function8 = function4;
                        shape2 = cornerBasedShapeCopy;
                        borderStroke3 = borderStroke2;
                        modifier3 = modifier2;
                        function9 = function6;
                        z5 = z3;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ChipKt.FilterChip$lambda$2(z, function0, modifier3, z5, mutableInteractionSource2, shape2, borderStroke3, selectableChipColors2, function9, function7, function8, function5, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i4 |= 24576;
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    cornerBasedShapeCopy = shape;
                    if ((i3 & 32) == 0) {
                        i23 = 65536;
                    } else {
                        i23 = 65536;
                    }
                    i4 |= i23;
                } else {
                    cornerBasedShapeCopy = shape;
                }
                i9 = i3 & 64;
                if (i9 != 0) {
                    i4 |= 1572864;
                    borderStroke2 = borderStroke;
                } else {
                    borderStroke2 = borderStroke;
                    if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(borderStroke2)) {
                            i10 = 1048576;
                        } else {
                            i10 = 524288;
                        }
                        i4 |= i10;
                    }
                }
                if ((i & 12582912) == 0) {
                    if ((i3 & 128) != 0) {
                        i22 = 4194304;
                    } else {
                        if ((16777216 & i) == 0) {
                            zChangedInstance = composerStartRestartGroup.changed(selectableChipColors);
                        } else {
                            zChangedInstance = composerStartRestartGroup.changedInstance(selectableChipColors);
                        }
                        if (zChangedInstance) {
                            i22 = 8388608;
                        } else {
                            i22 = 4194304;
                        }
                    }
                    i4 |= i22;
                }
                i11 = i3 & 256;
                if (i11 != 0) {
                    i4 |= 100663296;
                    function6 = function2;
                } else {
                    function6 = function2;
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changedInstance(function6)) {
                            i12 = 67108864;
                        } else {
                            i12 = 33554432;
                        }
                        i4 |= i12;
                    }
                }
                i13 = i3 & 512;
                if (i13 != 0) {
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i14 = 268435456;
                        }
                        i4 |= i14;
                    }
                    i15 = i3 & 1024;
                    if (i15 != 0) {
                        i16 = i2 | 6;
                    } else if ((i2 & 6) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i17 = 4;
                        } else {
                            i17 = 2;
                        }
                        i16 = i2 | i17;
                    } else {
                        i16 = i2;
                    }
                    if ((i2 & 48) == 0) {
                        if (composerStartRestartGroup.changedInstance(function5)) {
                            i21 = 32;
                        } else {
                            i21 = 16;
                        }
                        i16 |= i21;
                    }
                    i18 = i16;
                    if ((i4 & 306783379) == 306783378) {
                        z4 = true;
                    } else {
                        z4 = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "187@8731L6,189@8858L18");
                        if ((i & 1) != 0) {
                            if (i24 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i5 != 0) {
                                z3 = true;
                            } else {
                                z3 = z3;
                            }
                            if (i7 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i3 & 32) != 0) {
                                cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                i4 &= -458753;
                            }
                            i19 = i4;
                            cornerBasedShapeCopy = cornerBasedShapeCopy;
                            if (i9 != 0) {
                                borderStroke2 = null;
                            } else {
                                borderStroke2 = borderStroke2;
                            }
                            if ((i3 & 128) != 0) {
                                i20 = i11;
                                selectableChipColorsM2320filterChipColorsJ08w3E = ChipDefaults.INSTANCE.m2320filterChipColorsJ08w3E(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 805306368, 511);
                                i19 &= -29360129;
                            } else {
                                i20 = i11;
                                selectableChipColorsM2320filterChipColorsJ08w3E = selectableChipColors;
                            }
                            if (i20 != 0) {
                                composerStartRestartGroup = composerStartRestartGroup;
                                function6 = null;
                            }
                            if (i13 != 0) {
                                function10 = null;
                            } else {
                                function10 = function3;
                            }
                            if (i15 != 0) {
                                function11 = null;
                            } else {
                                function11 = function4;
                            }
                            function12 = function6;
                            modifier4 = companion;
                        } else {
                            if (i24 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i5 != 0) {
                                z3 = true;
                            } else {
                                z3 = z3;
                            }
                            if (i7 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i3 & 32) != 0) {
                                cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                i4 &= -458753;
                            }
                            i19 = i4;
                            cornerBasedShapeCopy = cornerBasedShapeCopy;
                            if (i9 != 0) {
                                borderStroke2 = null;
                            } else {
                                borderStroke2 = borderStroke2;
                            }
                            if ((i3 & 128) != 0) {
                                i20 = i11;
                                selectableChipColorsM2320filterChipColorsJ08w3E = ChipDefaults.INSTANCE.m2320filterChipColorsJ08w3E(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 805306368, 511);
                                i19 &= -29360129;
                            } else {
                                i20 = i11;
                                selectableChipColorsM2320filterChipColorsJ08w3E = selectableChipColors;
                            }
                            if (i20 != 0) {
                                composerStartRestartGroup = composerStartRestartGroup;
                                function6 = null;
                            }
                            if (i13 != 0) {
                                function10 = null;
                            } else {
                                function10 = function3;
                            }
                            if (i15 != 0) {
                                function11 = null;
                            } else {
                                function11 = function4;
                            }
                            function12 = function6;
                            modifier4 = companion;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(69602198, i19, i18, "androidx.compose.material.FilterChip (Chip.kt:194)");
                        }
                        int i29 = i19 << 3;
                        int i210 = ((i19 >> 9) & 14) | (i29 & 112) | ((i19 >> 15) & 896);
                        final State stateContentColor3 = selectableChipColorsM2320filterChipColorsJ08w3E.contentColor(z3, z, composerStartRestartGroup, i210);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1831738322, "CC(remember):Chip.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ChipKt.FilterChip$lambda$0$0((SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        final Function2 function19 = function12;
                        Shape shape5 = cornerBasedShapeCopy;
                        final SelectableChipColors selectableChipColors5 = selectableChipColorsM2320filterChipColorsJ08w3E;
                        final Function2 function110 = function10;
                        final Function2 function111 = function11;
                        final boolean z8 = z3;
                        Modifier modifier7 = modifier4;
                        SurfaceKt.m2586SurfaceNy5ogXk(z, function0, SemanticsModifierKt.semantics$default(modifier4, false, (Function1) objRememberedValue, 1, null), z8, shape5, selectableChipColorsM2320filterChipColorsJ08w3E.backgroundColor(z3, z, composerStartRestartGroup, i210).getValue().m6824unboximpl(), Color.m6813copywmQWz5c$default(stateContentColor3.getValue().m6824unboximpl(), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(-60565717, true, new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ChipKt.FilterChip$lambda$1(stateContentColor3, function19, z, function110, function111, function5, selectableChipColors5, z8, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i19 & 7294) | (57344 & (i19 >> 3)) | (i29 & 29360128) | ((i19 << 15) & C.ENCODING_PCM_DOUBLE), 6, 256);
                        composer2 = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        shape2 = shape5;
                        borderStroke3 = borderStroke2;
                        mutableInteractionSource2 = mutableInteractionSource3;
                        selectableChipColors2 = selectableChipColors5;
                        function9 = function19;
                        function7 = function110;
                        function8 = function111;
                        z5 = z8;
                        modifier3 = modifier7;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        mutableInteractionSource2 = mutableInteractionSource;
                        selectableChipColors2 = selectableChipColors;
                        function7 = function3;
                        function8 = function4;
                        shape2 = cornerBasedShapeCopy;
                        borderStroke3 = borderStroke2;
                        modifier3 = modifier2;
                        function9 = function6;
                        z5 = z3;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ChipKt.FilterChip$lambda$2(z, function0, modifier3, z5, mutableInteractionSource2, shape2, borderStroke3, selectableChipColors2, function9, function7, function8, function5, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i4 |= 805306368;
                i15 = i3 & 1024;
                if (i15 != 0) {
                    i16 = i2 | 6;
                } else if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i17 = 4;
                    } else {
                        i17 = 2;
                    }
                    i16 = i2 | i17;
                } else {
                    i16 = i2;
                }
                if ((i2 & 48) == 0) {
                    if (composerStartRestartGroup.changedInstance(function5)) {
                        i21 = 32;
                    } else {
                        i21 = 16;
                    }
                    i16 |= i21;
                }
                i18 = i16;
                if ((i4 & 306783379) == 306783378) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "187@8731L6,189@8858L18");
                    if ((i & 1) != 0) {
                        if (i24 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        } else {
                            z3 = z3;
                        }
                        if (i7 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i3 & 32) != 0) {
                            cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i4 &= -458753;
                        }
                        i19 = i4;
                        cornerBasedShapeCopy = cornerBasedShapeCopy;
                        if (i9 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke2;
                        }
                        if ((i3 & 128) != 0) {
                            i20 = i11;
                            selectableChipColorsM2320filterChipColorsJ08w3E = ChipDefaults.INSTANCE.m2320filterChipColorsJ08w3E(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 805306368, 511);
                            i19 &= -29360129;
                        } else {
                            i20 = i11;
                            selectableChipColorsM2320filterChipColorsJ08w3E = selectableChipColors;
                        }
                        if (i20 != 0) {
                            composerStartRestartGroup = composerStartRestartGroup;
                            function6 = null;
                        }
                        if (i13 != 0) {
                            function10 = null;
                        } else {
                            function10 = function3;
                        }
                        if (i15 != 0) {
                            function11 = null;
                        } else {
                            function11 = function4;
                        }
                        function12 = function6;
                        modifier4 = companion;
                    } else {
                        if (i24 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        } else {
                            z3 = z3;
                        }
                        if (i7 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i3 & 32) != 0) {
                            cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i4 &= -458753;
                        }
                        i19 = i4;
                        cornerBasedShapeCopy = cornerBasedShapeCopy;
                        if (i9 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke2;
                        }
                        if ((i3 & 128) != 0) {
                            i20 = i11;
                            selectableChipColorsM2320filterChipColorsJ08w3E = ChipDefaults.INSTANCE.m2320filterChipColorsJ08w3E(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 805306368, 511);
                            i19 &= -29360129;
                        } else {
                            i20 = i11;
                            selectableChipColorsM2320filterChipColorsJ08w3E = selectableChipColors;
                        }
                        if (i20 != 0) {
                            composerStartRestartGroup = composerStartRestartGroup;
                            function6 = null;
                        }
                        if (i13 != 0) {
                            function10 = null;
                        } else {
                            function10 = function3;
                        }
                        if (i15 != 0) {
                            function11 = null;
                        } else {
                            function11 = function4;
                        }
                        function12 = function6;
                        modifier4 = companion;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(69602198, i19, i18, "androidx.compose.material.FilterChip (Chip.kt:194)");
                    }
                    int i211 = i19 << 3;
                    int i212 = ((i19 >> 9) & 14) | (i211 & 112) | ((i19 >> 15) & 896);
                    final State stateContentColor4 = selectableChipColorsM2320filterChipColorsJ08w3E.contentColor(z3, z, composerStartRestartGroup, i212);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1831738322, "CC(remember):Chip.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ChipKt.FilterChip$lambda$0$0((SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final Function2 function112 = function12;
                    Shape shape6 = cornerBasedShapeCopy;
                    final SelectableChipColors selectableChipColors6 = selectableChipColorsM2320filterChipColorsJ08w3E;
                    final Function2 function113 = function10;
                    final Function2 function114 = function11;
                    final boolean z9 = z3;
                    Modifier modifier8 = modifier4;
                    SurfaceKt.m2586SurfaceNy5ogXk(z, function0, SemanticsModifierKt.semantics$default(modifier4, false, (Function1) objRememberedValue, 1, null), z9, shape6, selectableChipColorsM2320filterChipColorsJ08w3E.backgroundColor(z3, z, composerStartRestartGroup, i212).getValue().m6824unboximpl(), Color.m6813copywmQWz5c$default(stateContentColor4.getValue().m6824unboximpl(), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(-60565717, true, new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ChipKt.FilterChip$lambda$1(stateContentColor4, function112, z, function113, function114, function5, selectableChipColors6, z9, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i19 & 7294) | (57344 & (i19 >> 3)) | (i211 & 29360128) | ((i19 << 15) & C.ENCODING_PCM_DOUBLE), 6, 256);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    shape2 = shape6;
                    borderStroke3 = borderStroke2;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    selectableChipColors2 = selectableChipColors6;
                    function9 = function112;
                    function7 = function113;
                    function8 = function114;
                    z5 = z9;
                    modifier3 = modifier8;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    selectableChipColors2 = selectableChipColors;
                    function7 = function3;
                    function8 = function4;
                    shape2 = cornerBasedShapeCopy;
                    borderStroke3 = borderStroke2;
                    modifier3 = modifier2;
                    function9 = function6;
                    z5 = z3;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ChipKt.FilterChip$lambda$2(z, function0, modifier3, z5, mutableInteractionSource2, shape2, borderStroke3, selectableChipColors2, function9, function7, function8, function5, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 3072;
            z3 = z2;
            i7 = i3 & 16;
            if (i7 != 0) {
                if ((i & 24576) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i8 = 16384;
                    } else {
                        i8 = 8192;
                    }
                    i4 |= i8;
                }
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    cornerBasedShapeCopy = shape;
                    if ((i3 & 32) == 0) {
                        i23 = 65536;
                    } else {
                        i23 = 65536;
                    }
                    i4 |= i23;
                } else {
                    cornerBasedShapeCopy = shape;
                }
                i9 = i3 & 64;
                if (i9 != 0) {
                    i4 |= 1572864;
                    borderStroke2 = borderStroke;
                } else {
                    borderStroke2 = borderStroke;
                    if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(borderStroke2)) {
                            i10 = 1048576;
                        } else {
                            i10 = 524288;
                        }
                        i4 |= i10;
                    }
                }
                if ((i & 12582912) == 0) {
                    if ((i3 & 128) != 0) {
                        i22 = 4194304;
                    } else {
                        if ((16777216 & i) == 0) {
                            zChangedInstance = composerStartRestartGroup.changed(selectableChipColors);
                        } else {
                            zChangedInstance = composerStartRestartGroup.changedInstance(selectableChipColors);
                        }
                        if (zChangedInstance) {
                            i22 = 8388608;
                        } else {
                            i22 = 4194304;
                        }
                    }
                    i4 |= i22;
                }
                i11 = i3 & 256;
                if (i11 != 0) {
                    i4 |= 100663296;
                    function6 = function2;
                } else {
                    function6 = function2;
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changedInstance(function6)) {
                            i12 = 67108864;
                        } else {
                            i12 = 33554432;
                        }
                        i4 |= i12;
                    }
                }
                i13 = i3 & 512;
                if (i13 != 0) {
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i14 = 268435456;
                        }
                        i4 |= i14;
                    }
                    i15 = i3 & 1024;
                    if (i15 != 0) {
                        i16 = i2 | 6;
                    } else if ((i2 & 6) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i17 = 4;
                        } else {
                            i17 = 2;
                        }
                        i16 = i2 | i17;
                    } else {
                        i16 = i2;
                    }
                    if ((i2 & 48) == 0) {
                        if (composerStartRestartGroup.changedInstance(function5)) {
                            i21 = 32;
                        } else {
                            i21 = 16;
                        }
                        i16 |= i21;
                    }
                    i18 = i16;
                    if ((i4 & 306783379) == 306783378) {
                        z4 = true;
                    } else {
                        z4 = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "187@8731L6,189@8858L18");
                        if ((i & 1) != 0) {
                            if (i24 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i5 != 0) {
                                z3 = true;
                            } else {
                                z3 = z3;
                            }
                            if (i7 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i3 & 32) != 0) {
                                cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                i4 &= -458753;
                            }
                            i19 = i4;
                            cornerBasedShapeCopy = cornerBasedShapeCopy;
                            if (i9 != 0) {
                                borderStroke2 = null;
                            } else {
                                borderStroke2 = borderStroke2;
                            }
                            if ((i3 & 128) != 0) {
                                i20 = i11;
                                selectableChipColorsM2320filterChipColorsJ08w3E = ChipDefaults.INSTANCE.m2320filterChipColorsJ08w3E(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 805306368, 511);
                                i19 &= -29360129;
                            } else {
                                i20 = i11;
                                selectableChipColorsM2320filterChipColorsJ08w3E = selectableChipColors;
                            }
                            if (i20 != 0) {
                                composerStartRestartGroup = composerStartRestartGroup;
                                function6 = null;
                            }
                            if (i13 != 0) {
                                function10 = null;
                            } else {
                                function10 = function3;
                            }
                            if (i15 != 0) {
                                function11 = null;
                            } else {
                                function11 = function4;
                            }
                            function12 = function6;
                            modifier4 = companion;
                        } else {
                            if (i24 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i5 != 0) {
                                z3 = true;
                            } else {
                                z3 = z3;
                            }
                            if (i7 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i3 & 32) != 0) {
                                cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                i4 &= -458753;
                            }
                            i19 = i4;
                            cornerBasedShapeCopy = cornerBasedShapeCopy;
                            if (i9 != 0) {
                                borderStroke2 = null;
                            } else {
                                borderStroke2 = borderStroke2;
                            }
                            if ((i3 & 128) != 0) {
                                i20 = i11;
                                selectableChipColorsM2320filterChipColorsJ08w3E = ChipDefaults.INSTANCE.m2320filterChipColorsJ08w3E(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 805306368, 511);
                                i19 &= -29360129;
                            } else {
                                i20 = i11;
                                selectableChipColorsM2320filterChipColorsJ08w3E = selectableChipColors;
                            }
                            if (i20 != 0) {
                                composerStartRestartGroup = composerStartRestartGroup;
                                function6 = null;
                            }
                            if (i13 != 0) {
                                function10 = null;
                            } else {
                                function10 = function3;
                            }
                            if (i15 != 0) {
                                function11 = null;
                            } else {
                                function11 = function4;
                            }
                            function12 = function6;
                            modifier4 = companion;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(69602198, i19, i18, "androidx.compose.material.FilterChip (Chip.kt:194)");
                        }
                        int i213 = i19 << 3;
                        int i214 = ((i19 >> 9) & 14) | (i213 & 112) | ((i19 >> 15) & 896);
                        final State stateContentColor5 = selectableChipColorsM2320filterChipColorsJ08w3E.contentColor(z3, z, composerStartRestartGroup, i214);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1831738322, "CC(remember):Chip.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ChipKt.FilterChip$lambda$0$0((SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        final Function2 function115 = function12;
                        Shape shape7 = cornerBasedShapeCopy;
                        final SelectableChipColors selectableChipColors7 = selectableChipColorsM2320filterChipColorsJ08w3E;
                        final Function2 function116 = function10;
                        final Function2 function117 = function11;
                        final boolean z10 = z3;
                        Modifier modifier9 = modifier4;
                        SurfaceKt.m2586SurfaceNy5ogXk(z, function0, SemanticsModifierKt.semantics$default(modifier4, false, (Function1) objRememberedValue, 1, null), z10, shape7, selectableChipColorsM2320filterChipColorsJ08w3E.backgroundColor(z3, z, composerStartRestartGroup, i214).getValue().m6824unboximpl(), Color.m6813copywmQWz5c$default(stateContentColor5.getValue().m6824unboximpl(), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(-60565717, true, new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ChipKt.FilterChip$lambda$1(stateContentColor5, function115, z, function116, function117, function5, selectableChipColors7, z10, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i19 & 7294) | (57344 & (i19 >> 3)) | (i213 & 29360128) | ((i19 << 15) & C.ENCODING_PCM_DOUBLE), 6, 256);
                        composer2 = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        shape2 = shape7;
                        borderStroke3 = borderStroke2;
                        mutableInteractionSource2 = mutableInteractionSource3;
                        selectableChipColors2 = selectableChipColors7;
                        function9 = function115;
                        function7 = function116;
                        function8 = function117;
                        z5 = z10;
                        modifier3 = modifier9;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        mutableInteractionSource2 = mutableInteractionSource;
                        selectableChipColors2 = selectableChipColors;
                        function7 = function3;
                        function8 = function4;
                        shape2 = cornerBasedShapeCopy;
                        borderStroke3 = borderStroke2;
                        modifier3 = modifier2;
                        function9 = function6;
                        z5 = z3;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ChipKt.FilterChip$lambda$2(z, function0, modifier3, z5, mutableInteractionSource2, shape2, borderStroke3, selectableChipColors2, function9, function7, function8, function5, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i4 |= 805306368;
                i15 = i3 & 1024;
                if (i15 != 0) {
                    i16 = i2 | 6;
                } else if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i17 = 4;
                    } else {
                        i17 = 2;
                    }
                    i16 = i2 | i17;
                } else {
                    i16 = i2;
                }
                if ((i2 & 48) == 0) {
                    if (composerStartRestartGroup.changedInstance(function5)) {
                        i21 = 32;
                    } else {
                        i21 = 16;
                    }
                    i16 |= i21;
                }
                i18 = i16;
                if ((i4 & 306783379) == 306783378) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "187@8731L6,189@8858L18");
                    if ((i & 1) != 0) {
                        if (i24 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        } else {
                            z3 = z3;
                        }
                        if (i7 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i3 & 32) != 0) {
                            cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i4 &= -458753;
                        }
                        i19 = i4;
                        cornerBasedShapeCopy = cornerBasedShapeCopy;
                        if (i9 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke2;
                        }
                        if ((i3 & 128) != 0) {
                            i20 = i11;
                            selectableChipColorsM2320filterChipColorsJ08w3E = ChipDefaults.INSTANCE.m2320filterChipColorsJ08w3E(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 805306368, 511);
                            i19 &= -29360129;
                        } else {
                            i20 = i11;
                            selectableChipColorsM2320filterChipColorsJ08w3E = selectableChipColors;
                        }
                        if (i20 != 0) {
                            composerStartRestartGroup = composerStartRestartGroup;
                            function6 = null;
                        }
                        if (i13 != 0) {
                            function10 = null;
                        } else {
                            function10 = function3;
                        }
                        if (i15 != 0) {
                            function11 = null;
                        } else {
                            function11 = function4;
                        }
                        function12 = function6;
                        modifier4 = companion;
                    } else {
                        if (i24 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        } else {
                            z3 = z3;
                        }
                        if (i7 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i3 & 32) != 0) {
                            cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i4 &= -458753;
                        }
                        i19 = i4;
                        cornerBasedShapeCopy = cornerBasedShapeCopy;
                        if (i9 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke2;
                        }
                        if ((i3 & 128) != 0) {
                            i20 = i11;
                            selectableChipColorsM2320filterChipColorsJ08w3E = ChipDefaults.INSTANCE.m2320filterChipColorsJ08w3E(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 805306368, 511);
                            i19 &= -29360129;
                        } else {
                            i20 = i11;
                            selectableChipColorsM2320filterChipColorsJ08w3E = selectableChipColors;
                        }
                        if (i20 != 0) {
                            composerStartRestartGroup = composerStartRestartGroup;
                            function6 = null;
                        }
                        if (i13 != 0) {
                            function10 = null;
                        } else {
                            function10 = function3;
                        }
                        if (i15 != 0) {
                            function11 = null;
                        } else {
                            function11 = function4;
                        }
                        function12 = function6;
                        modifier4 = companion;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(69602198, i19, i18, "androidx.compose.material.FilterChip (Chip.kt:194)");
                    }
                    int i215 = i19 << 3;
                    int i216 = ((i19 >> 9) & 14) | (i215 & 112) | ((i19 >> 15) & 896);
                    final State stateContentColor6 = selectableChipColorsM2320filterChipColorsJ08w3E.contentColor(z3, z, composerStartRestartGroup, i216);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1831738322, "CC(remember):Chip.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ChipKt.FilterChip$lambda$0$0((SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final Function2 function118 = function12;
                    Shape shape8 = cornerBasedShapeCopy;
                    final SelectableChipColors selectableChipColors8 = selectableChipColorsM2320filterChipColorsJ08w3E;
                    final Function2 function119 = function10;
                    final Function2 function1110 = function11;
                    final boolean z11 = z3;
                    Modifier modifier10 = modifier4;
                    SurfaceKt.m2586SurfaceNy5ogXk(z, function0, SemanticsModifierKt.semantics$default(modifier4, false, (Function1) objRememberedValue, 1, null), z11, shape8, selectableChipColorsM2320filterChipColorsJ08w3E.backgroundColor(z3, z, composerStartRestartGroup, i216).getValue().m6824unboximpl(), Color.m6813copywmQWz5c$default(stateContentColor6.getValue().m6824unboximpl(), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(-60565717, true, new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ChipKt.FilterChip$lambda$1(stateContentColor6, function118, z, function119, function1110, function5, selectableChipColors8, z11, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i19 & 7294) | (57344 & (i19 >> 3)) | (i215 & 29360128) | ((i19 << 15) & C.ENCODING_PCM_DOUBLE), 6, 256);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    shape2 = shape8;
                    borderStroke3 = borderStroke2;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    selectableChipColors2 = selectableChipColors8;
                    function9 = function118;
                    function7 = function119;
                    function8 = function1110;
                    z5 = z11;
                    modifier3 = modifier10;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    selectableChipColors2 = selectableChipColors;
                    function7 = function3;
                    function8 = function4;
                    shape2 = cornerBasedShapeCopy;
                    borderStroke3 = borderStroke2;
                    modifier3 = modifier2;
                    function9 = function6;
                    z5 = z3;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ChipKt.FilterChip$lambda$2(z, function0, modifier3, z5, mutableInteractionSource2, shape2, borderStroke3, selectableChipColors2, function9, function7, function8, function5, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 24576;
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                cornerBasedShapeCopy = shape;
                if ((i3 & 32) == 0) {
                    i23 = 65536;
                } else {
                    i23 = 65536;
                }
                i4 |= i23;
            } else {
                cornerBasedShapeCopy = shape;
            }
            i9 = i3 & 64;
            if (i9 != 0) {
                i4 |= 1572864;
                borderStroke2 = borderStroke;
            } else {
                borderStroke2 = borderStroke;
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(borderStroke2)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i4 |= i10;
                }
            }
            if ((i & 12582912) == 0) {
                if ((i3 & 128) != 0) {
                    i22 = 4194304;
                } else {
                    if ((16777216 & i) == 0) {
                        zChangedInstance = composerStartRestartGroup.changed(selectableChipColors);
                    } else {
                        zChangedInstance = composerStartRestartGroup.changedInstance(selectableChipColors);
                    }
                    if (zChangedInstance) {
                        i22 = 8388608;
                    } else {
                        i22 = 4194304;
                    }
                }
                i4 |= i22;
            }
            i11 = i3 & 256;
            if (i11 != 0) {
                i4 |= 100663296;
                function6 = function2;
            } else {
                function6 = function2;
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i12 = 67108864;
                    } else {
                        i12 = 33554432;
                    }
                    i4 |= i12;
                }
            }
            i13 = i3 & 512;
            if (i13 != 0) {
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i14 = 268435456;
                    }
                    i4 |= i14;
                }
                i15 = i3 & 1024;
                if (i15 != 0) {
                    i16 = i2 | 6;
                } else if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i17 = 4;
                    } else {
                        i17 = 2;
                    }
                    i16 = i2 | i17;
                } else {
                    i16 = i2;
                }
                if ((i2 & 48) == 0) {
                    if (composerStartRestartGroup.changedInstance(function5)) {
                        i21 = 32;
                    } else {
                        i21 = 16;
                    }
                    i16 |= i21;
                }
                i18 = i16;
                if ((i4 & 306783379) == 306783378) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "187@8731L6,189@8858L18");
                    if ((i & 1) != 0) {
                        if (i24 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        } else {
                            z3 = z3;
                        }
                        if (i7 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i3 & 32) != 0) {
                            cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i4 &= -458753;
                        }
                        i19 = i4;
                        cornerBasedShapeCopy = cornerBasedShapeCopy;
                        if (i9 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke2;
                        }
                        if ((i3 & 128) != 0) {
                            i20 = i11;
                            selectableChipColorsM2320filterChipColorsJ08w3E = ChipDefaults.INSTANCE.m2320filterChipColorsJ08w3E(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 805306368, 511);
                            i19 &= -29360129;
                        } else {
                            i20 = i11;
                            selectableChipColorsM2320filterChipColorsJ08w3E = selectableChipColors;
                        }
                        if (i20 != 0) {
                            composerStartRestartGroup = composerStartRestartGroup;
                            function6 = null;
                        }
                        if (i13 != 0) {
                            function10 = null;
                        } else {
                            function10 = function3;
                        }
                        if (i15 != 0) {
                            function11 = null;
                        } else {
                            function11 = function4;
                        }
                        function12 = function6;
                        modifier4 = companion;
                    } else {
                        if (i24 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        } else {
                            z3 = z3;
                        }
                        if (i7 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i3 & 32) != 0) {
                            cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i4 &= -458753;
                        }
                        i19 = i4;
                        cornerBasedShapeCopy = cornerBasedShapeCopy;
                        if (i9 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke2;
                        }
                        if ((i3 & 128) != 0) {
                            i20 = i11;
                            selectableChipColorsM2320filterChipColorsJ08w3E = ChipDefaults.INSTANCE.m2320filterChipColorsJ08w3E(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 805306368, 511);
                            i19 &= -29360129;
                        } else {
                            i20 = i11;
                            selectableChipColorsM2320filterChipColorsJ08w3E = selectableChipColors;
                        }
                        if (i20 != 0) {
                            composerStartRestartGroup = composerStartRestartGroup;
                            function6 = null;
                        }
                        if (i13 != 0) {
                            function10 = null;
                        } else {
                            function10 = function3;
                        }
                        if (i15 != 0) {
                            function11 = null;
                        } else {
                            function11 = function4;
                        }
                        function12 = function6;
                        modifier4 = companion;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(69602198, i19, i18, "androidx.compose.material.FilterChip (Chip.kt:194)");
                    }
                    int i217 = i19 << 3;
                    int i218 = ((i19 >> 9) & 14) | (i217 & 112) | ((i19 >> 15) & 896);
                    final State stateContentColor7 = selectableChipColorsM2320filterChipColorsJ08w3E.contentColor(z3, z, composerStartRestartGroup, i218);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1831738322, "CC(remember):Chip.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ChipKt.FilterChip$lambda$0$0((SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final Function2 function1111 = function12;
                    Shape shape9 = cornerBasedShapeCopy;
                    final SelectableChipColors selectableChipColors9 = selectableChipColorsM2320filterChipColorsJ08w3E;
                    final Function2 function1112 = function10;
                    final Function2 function1113 = function11;
                    final boolean z12 = z3;
                    Modifier modifier11 = modifier4;
                    SurfaceKt.m2586SurfaceNy5ogXk(z, function0, SemanticsModifierKt.semantics$default(modifier4, false, (Function1) objRememberedValue, 1, null), z12, shape9, selectableChipColorsM2320filterChipColorsJ08w3E.backgroundColor(z3, z, composerStartRestartGroup, i218).getValue().m6824unboximpl(), Color.m6813copywmQWz5c$default(stateContentColor7.getValue().m6824unboximpl(), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(-60565717, true, new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ChipKt.FilterChip$lambda$1(stateContentColor7, function1111, z, function1112, function1113, function5, selectableChipColors9, z12, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i19 & 7294) | (57344 & (i19 >> 3)) | (i217 & 29360128) | ((i19 << 15) & C.ENCODING_PCM_DOUBLE), 6, 256);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    shape2 = shape9;
                    borderStroke3 = borderStroke2;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    selectableChipColors2 = selectableChipColors9;
                    function9 = function1111;
                    function7 = function1112;
                    function8 = function1113;
                    z5 = z12;
                    modifier3 = modifier11;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    selectableChipColors2 = selectableChipColors;
                    function7 = function3;
                    function8 = function4;
                    shape2 = cornerBasedShapeCopy;
                    borderStroke3 = borderStroke2;
                    modifier3 = modifier2;
                    function9 = function6;
                    z5 = z3;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ChipKt.FilterChip$lambda$2(z, function0, modifier3, z5, mutableInteractionSource2, shape2, borderStroke3, selectableChipColors2, function9, function7, function8, function5, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 805306368;
            i15 = i3 & 1024;
            if (i15 != 0) {
                i16 = i2 | 6;
            } else if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i17 = 4;
                } else {
                    i17 = 2;
                }
                i16 = i2 | i17;
            } else {
                i16 = i2;
            }
            if ((i2 & 48) == 0) {
                if (composerStartRestartGroup.changedInstance(function5)) {
                    i21 = 32;
                } else {
                    i21 = 16;
                }
                i16 |= i21;
            }
            i18 = i16;
            if ((i4 & 306783379) == 306783378) {
                z4 = true;
            } else {
                z4 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "187@8731L6,189@8858L18");
                if ((i & 1) != 0) {
                    if (i24 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    } else {
                        z3 = z3;
                    }
                    if (i7 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if ((i3 & 32) != 0) {
                        cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i4 &= -458753;
                    }
                    i19 = i4;
                    cornerBasedShapeCopy = cornerBasedShapeCopy;
                    if (i9 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke2;
                    }
                    if ((i3 & 128) != 0) {
                        i20 = i11;
                        selectableChipColorsM2320filterChipColorsJ08w3E = ChipDefaults.INSTANCE.m2320filterChipColorsJ08w3E(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 805306368, 511);
                        i19 &= -29360129;
                    } else {
                        i20 = i11;
                        selectableChipColorsM2320filterChipColorsJ08w3E = selectableChipColors;
                    }
                    if (i20 != 0) {
                        composerStartRestartGroup = composerStartRestartGroup;
                        function6 = null;
                    }
                    if (i13 != 0) {
                        function10 = null;
                    } else {
                        function10 = function3;
                    }
                    if (i15 != 0) {
                        function11 = null;
                    } else {
                        function11 = function4;
                    }
                    function12 = function6;
                    modifier4 = companion;
                } else {
                    if (i24 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    } else {
                        z3 = z3;
                    }
                    if (i7 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if ((i3 & 32) != 0) {
                        cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i4 &= -458753;
                    }
                    i19 = i4;
                    cornerBasedShapeCopy = cornerBasedShapeCopy;
                    if (i9 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke2;
                    }
                    if ((i3 & 128) != 0) {
                        i20 = i11;
                        selectableChipColorsM2320filterChipColorsJ08w3E = ChipDefaults.INSTANCE.m2320filterChipColorsJ08w3E(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 805306368, 511);
                        i19 &= -29360129;
                    } else {
                        i20 = i11;
                        selectableChipColorsM2320filterChipColorsJ08w3E = selectableChipColors;
                    }
                    if (i20 != 0) {
                        composerStartRestartGroup = composerStartRestartGroup;
                        function6 = null;
                    }
                    if (i13 != 0) {
                        function10 = null;
                    } else {
                        function10 = function3;
                    }
                    if (i15 != 0) {
                        function11 = null;
                    } else {
                        function11 = function4;
                    }
                    function12 = function6;
                    modifier4 = companion;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(69602198, i19, i18, "androidx.compose.material.FilterChip (Chip.kt:194)");
                }
                int i219 = i19 << 3;
                int i2110 = ((i19 >> 9) & 14) | (i219 & 112) | ((i19 >> 15) & 896);
                final State stateContentColor8 = selectableChipColorsM2320filterChipColorsJ08w3E.contentColor(z3, z, composerStartRestartGroup, i2110);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1831738322, "CC(remember):Chip.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ChipKt.FilterChip$lambda$0$0((SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final Function2 function1114 = function12;
                Shape shape10 = cornerBasedShapeCopy;
                final SelectableChipColors selectableChipColors10 = selectableChipColorsM2320filterChipColorsJ08w3E;
                final Function2 function1115 = function10;
                final Function2 function1116 = function11;
                final boolean z13 = z3;
                Modifier modifier12 = modifier4;
                SurfaceKt.m2586SurfaceNy5ogXk(z, function0, SemanticsModifierKt.semantics$default(modifier4, false, (Function1) objRememberedValue, 1, null), z13, shape10, selectableChipColorsM2320filterChipColorsJ08w3E.backgroundColor(z3, z, composerStartRestartGroup, i2110).getValue().m6824unboximpl(), Color.m6813copywmQWz5c$default(stateContentColor8.getValue().m6824unboximpl(), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(-60565717, true, new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ChipKt.FilterChip$lambda$1(stateContentColor8, function1114, z, function1115, function1116, function5, selectableChipColors10, z13, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i19 & 7294) | (57344 & (i19 >> 3)) | (i219 & 29360128) | ((i19 << 15) & C.ENCODING_PCM_DOUBLE), 6, 256);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                shape2 = shape10;
                borderStroke3 = borderStroke2;
                mutableInteractionSource2 = mutableInteractionSource3;
                selectableChipColors2 = selectableChipColors10;
                function9 = function1114;
                function7 = function1115;
                function8 = function1116;
                z5 = z13;
                modifier3 = modifier12;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                mutableInteractionSource2 = mutableInteractionSource;
                selectableChipColors2 = selectableChipColors;
                function7 = function3;
                function8 = function4;
                shape2 = cornerBasedShapeCopy;
                borderStroke3 = borderStroke2;
                modifier3 = modifier2;
                function9 = function6;
                z5 = z3;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ChipKt.FilterChip$lambda$2(z, function0, modifier3, z5, mutableInteractionSource2, shape2, borderStroke3, selectableChipColors2, function9, function7, function8, function5, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 384;
        modifier2 = modifier;
        i5 = i3 & 8;
        if (i5 != 0) {
            if ((i & 3072) == 0) {
                z3 = z2;
                if (composerStartRestartGroup.changed(z3)) {
                    i6 = 2048;
                } else {
                    i6 = 1024;
                }
                i4 |= i6;
            }
            i7 = i3 & 16;
            if (i7 != 0) {
                if ((i & 24576) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i8 = 16384;
                    } else {
                        i8 = 8192;
                    }
                    i4 |= i8;
                }
                if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                    cornerBasedShapeCopy = shape;
                    if ((i3 & 32) == 0) {
                        i23 = 65536;
                    } else {
                        i23 = 65536;
                    }
                    i4 |= i23;
                } else {
                    cornerBasedShapeCopy = shape;
                }
                i9 = i3 & 64;
                if (i9 != 0) {
                    i4 |= 1572864;
                    borderStroke2 = borderStroke;
                } else {
                    borderStroke2 = borderStroke;
                    if ((i & 1572864) == 0) {
                        if (composerStartRestartGroup.changed(borderStroke2)) {
                            i10 = 1048576;
                        } else {
                            i10 = 524288;
                        }
                        i4 |= i10;
                    }
                }
                if ((i & 12582912) == 0) {
                    if ((i3 & 128) != 0) {
                        i22 = 4194304;
                    } else {
                        if ((16777216 & i) == 0) {
                            zChangedInstance = composerStartRestartGroup.changed(selectableChipColors);
                        } else {
                            zChangedInstance = composerStartRestartGroup.changedInstance(selectableChipColors);
                        }
                        if (zChangedInstance) {
                            i22 = 8388608;
                        } else {
                            i22 = 4194304;
                        }
                    }
                    i4 |= i22;
                }
                i11 = i3 & 256;
                if (i11 != 0) {
                    i4 |= 100663296;
                    function6 = function2;
                } else {
                    function6 = function2;
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changedInstance(function6)) {
                            i12 = 67108864;
                        } else {
                            i12 = 33554432;
                        }
                        i4 |= i12;
                    }
                }
                i13 = i3 & 512;
                if (i13 != 0) {
                    if ((i & 805306368) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                        } else {
                            i14 = 268435456;
                        }
                        i4 |= i14;
                    }
                    i15 = i3 & 1024;
                    if (i15 != 0) {
                        i16 = i2 | 6;
                    } else if ((i2 & 6) == 0) {
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i17 = 4;
                        } else {
                            i17 = 2;
                        }
                        i16 = i2 | i17;
                    } else {
                        i16 = i2;
                    }
                    if ((i2 & 48) == 0) {
                        if (composerStartRestartGroup.changedInstance(function5)) {
                            i21 = 32;
                        } else {
                            i21 = 16;
                        }
                        i16 |= i21;
                    }
                    i18 = i16;
                    if ((i4 & 306783379) == 306783378) {
                        z4 = true;
                    } else {
                        z4 = true;
                    }
                    if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "187@8731L6,189@8858L18");
                        if ((i & 1) != 0) {
                            if (i24 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i5 != 0) {
                                z3 = true;
                            } else {
                                z3 = z3;
                            }
                            if (i7 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i3 & 32) != 0) {
                                cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                i4 &= -458753;
                            }
                            i19 = i4;
                            cornerBasedShapeCopy = cornerBasedShapeCopy;
                            if (i9 != 0) {
                                borderStroke2 = null;
                            } else {
                                borderStroke2 = borderStroke2;
                            }
                            if ((i3 & 128) != 0) {
                                i20 = i11;
                                selectableChipColorsM2320filterChipColorsJ08w3E = ChipDefaults.INSTANCE.m2320filterChipColorsJ08w3E(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 805306368, 511);
                                i19 &= -29360129;
                            } else {
                                i20 = i11;
                                selectableChipColorsM2320filterChipColorsJ08w3E = selectableChipColors;
                            }
                            if (i20 != 0) {
                                composerStartRestartGroup = composerStartRestartGroup;
                                function6 = null;
                            }
                            if (i13 != 0) {
                                function10 = null;
                            } else {
                                function10 = function3;
                            }
                            if (i15 != 0) {
                                function11 = null;
                            } else {
                                function11 = function4;
                            }
                            function12 = function6;
                            modifier4 = companion;
                        } else {
                            if (i24 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i5 != 0) {
                                z3 = true;
                            } else {
                                z3 = z3;
                            }
                            if (i7 != 0) {
                                mutableInteractionSource3 = null;
                            } else {
                                mutableInteractionSource3 = mutableInteractionSource;
                            }
                            if ((i3 & 32) != 0) {
                                cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                                i4 &= -458753;
                            }
                            i19 = i4;
                            cornerBasedShapeCopy = cornerBasedShapeCopy;
                            if (i9 != 0) {
                                borderStroke2 = null;
                            } else {
                                borderStroke2 = borderStroke2;
                            }
                            if ((i3 & 128) != 0) {
                                i20 = i11;
                                selectableChipColorsM2320filterChipColorsJ08w3E = ChipDefaults.INSTANCE.m2320filterChipColorsJ08w3E(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 805306368, 511);
                                i19 &= -29360129;
                            } else {
                                i20 = i11;
                                selectableChipColorsM2320filterChipColorsJ08w3E = selectableChipColors;
                            }
                            if (i20 != 0) {
                                composerStartRestartGroup = composerStartRestartGroup;
                                function6 = null;
                            }
                            if (i13 != 0) {
                                function10 = null;
                            } else {
                                function10 = function3;
                            }
                            if (i15 != 0) {
                                function11 = null;
                            } else {
                                function11 = function4;
                            }
                            function12 = function6;
                            modifier4 = companion;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(69602198, i19, i18, "androidx.compose.material.FilterChip (Chip.kt:194)");
                        }
                        int i2111 = i19 << 3;
                        int i2112 = ((i19 >> 9) & 14) | (i2111 & 112) | ((i19 >> 15) & 896);
                        final State stateContentColor9 = selectableChipColorsM2320filterChipColorsJ08w3E.contentColor(z3, z, composerStartRestartGroup, i2112);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1831738322, "CC(remember):Chip.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return ChipKt.FilterChip$lambda$0$0((SemanticsPropertyReceiver) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        final Function2 function1117 = function12;
                        Shape shape11 = cornerBasedShapeCopy;
                        final SelectableChipColors selectableChipColors11 = selectableChipColorsM2320filterChipColorsJ08w3E;
                        final Function2 function1118 = function10;
                        final Function2 function1119 = function11;
                        final boolean z14 = z3;
                        Modifier modifier13 = modifier4;
                        SurfaceKt.m2586SurfaceNy5ogXk(z, function0, SemanticsModifierKt.semantics$default(modifier4, false, (Function1) objRememberedValue, 1, null), z14, shape11, selectableChipColorsM2320filterChipColorsJ08w3E.backgroundColor(z3, z, composerStartRestartGroup, i2112).getValue().m6824unboximpl(), Color.m6813copywmQWz5c$default(stateContentColor9.getValue().m6824unboximpl(), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(-60565717, true, new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ChipKt.FilterChip$lambda$1(stateContentColor9, function1117, z, function1118, function1119, function5, selectableChipColors11, z14, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i19 & 7294) | (57344 & (i19 >> 3)) | (i2111 & 29360128) | ((i19 << 15) & C.ENCODING_PCM_DOUBLE), 6, 256);
                        composer2 = composerStartRestartGroup;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        shape2 = shape11;
                        borderStroke3 = borderStroke2;
                        mutableInteractionSource2 = mutableInteractionSource3;
                        selectableChipColors2 = selectableChipColors11;
                        function9 = function1117;
                        function7 = function1118;
                        function8 = function1119;
                        z5 = z14;
                        modifier3 = modifier13;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        mutableInteractionSource2 = mutableInteractionSource;
                        selectableChipColors2 = selectableChipColors;
                        function7 = function3;
                        function8 = function4;
                        shape2 = cornerBasedShapeCopy;
                        borderStroke3 = borderStroke2;
                        modifier3 = modifier2;
                        function9 = function6;
                        z5 = z3;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return ChipKt.FilterChip$lambda$2(z, function0, modifier3, z5, mutableInteractionSource2, shape2, borderStroke3, selectableChipColors2, function9, function7, function8, function5, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i4 |= 805306368;
                i15 = i3 & 1024;
                if (i15 != 0) {
                    i16 = i2 | 6;
                } else if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i17 = 4;
                    } else {
                        i17 = 2;
                    }
                    i16 = i2 | i17;
                } else {
                    i16 = i2;
                }
                if ((i2 & 48) == 0) {
                    if (composerStartRestartGroup.changedInstance(function5)) {
                        i21 = 32;
                    } else {
                        i21 = 16;
                    }
                    i16 |= i21;
                }
                i18 = i16;
                if ((i4 & 306783379) == 306783378) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "187@8731L6,189@8858L18");
                    if ((i & 1) != 0) {
                        if (i24 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        } else {
                            z3 = z3;
                        }
                        if (i7 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i3 & 32) != 0) {
                            cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i4 &= -458753;
                        }
                        i19 = i4;
                        cornerBasedShapeCopy = cornerBasedShapeCopy;
                        if (i9 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke2;
                        }
                        if ((i3 & 128) != 0) {
                            i20 = i11;
                            selectableChipColorsM2320filterChipColorsJ08w3E = ChipDefaults.INSTANCE.m2320filterChipColorsJ08w3E(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 805306368, 511);
                            i19 &= -29360129;
                        } else {
                            i20 = i11;
                            selectableChipColorsM2320filterChipColorsJ08w3E = selectableChipColors;
                        }
                        if (i20 != 0) {
                            composerStartRestartGroup = composerStartRestartGroup;
                            function6 = null;
                        }
                        if (i13 != 0) {
                            function10 = null;
                        } else {
                            function10 = function3;
                        }
                        if (i15 != 0) {
                            function11 = null;
                        } else {
                            function11 = function4;
                        }
                        function12 = function6;
                        modifier4 = companion;
                    } else {
                        if (i24 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        } else {
                            z3 = z3;
                        }
                        if (i7 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i3 & 32) != 0) {
                            cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i4 &= -458753;
                        }
                        i19 = i4;
                        cornerBasedShapeCopy = cornerBasedShapeCopy;
                        if (i9 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke2;
                        }
                        if ((i3 & 128) != 0) {
                            i20 = i11;
                            selectableChipColorsM2320filterChipColorsJ08w3E = ChipDefaults.INSTANCE.m2320filterChipColorsJ08w3E(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 805306368, 511);
                            i19 &= -29360129;
                        } else {
                            i20 = i11;
                            selectableChipColorsM2320filterChipColorsJ08w3E = selectableChipColors;
                        }
                        if (i20 != 0) {
                            composerStartRestartGroup = composerStartRestartGroup;
                            function6 = null;
                        }
                        if (i13 != 0) {
                            function10 = null;
                        } else {
                            function10 = function3;
                        }
                        if (i15 != 0) {
                            function11 = null;
                        } else {
                            function11 = function4;
                        }
                        function12 = function6;
                        modifier4 = companion;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(69602198, i19, i18, "androidx.compose.material.FilterChip (Chip.kt:194)");
                    }
                    int i2113 = i19 << 3;
                    int i2114 = ((i19 >> 9) & 14) | (i2113 & 112) | ((i19 >> 15) & 896);
                    final State stateContentColor10 = selectableChipColorsM2320filterChipColorsJ08w3E.contentColor(z3, z, composerStartRestartGroup, i2114);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1831738322, "CC(remember):Chip.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ChipKt.FilterChip$lambda$0$0((SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final Function2 function11110 = function12;
                    Shape shape12 = cornerBasedShapeCopy;
                    final SelectableChipColors selectableChipColors12 = selectableChipColorsM2320filterChipColorsJ08w3E;
                    final Function2 function11111 = function10;
                    final Function2 function11112 = function11;
                    final boolean z15 = z3;
                    Modifier modifier14 = modifier4;
                    SurfaceKt.m2586SurfaceNy5ogXk(z, function0, SemanticsModifierKt.semantics$default(modifier4, false, (Function1) objRememberedValue, 1, null), z15, shape12, selectableChipColorsM2320filterChipColorsJ08w3E.backgroundColor(z3, z, composerStartRestartGroup, i2114).getValue().m6824unboximpl(), Color.m6813copywmQWz5c$default(stateContentColor10.getValue().m6824unboximpl(), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(-60565717, true, new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ChipKt.FilterChip$lambda$1(stateContentColor10, function11110, z, function11111, function11112, function5, selectableChipColors12, z15, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i19 & 7294) | (57344 & (i19 >> 3)) | (i2113 & 29360128) | ((i19 << 15) & C.ENCODING_PCM_DOUBLE), 6, 256);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    shape2 = shape12;
                    borderStroke3 = borderStroke2;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    selectableChipColors2 = selectableChipColors12;
                    function9 = function11110;
                    function7 = function11111;
                    function8 = function11112;
                    z5 = z15;
                    modifier3 = modifier14;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    selectableChipColors2 = selectableChipColors;
                    function7 = function3;
                    function8 = function4;
                    shape2 = cornerBasedShapeCopy;
                    borderStroke3 = borderStroke2;
                    modifier3 = modifier2;
                    function9 = function6;
                    z5 = z3;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ChipKt.FilterChip$lambda$2(z, function0, modifier3, z5, mutableInteractionSource2, shape2, borderStroke3, selectableChipColors2, function9, function7, function8, function5, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 24576;
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                cornerBasedShapeCopy = shape;
                if ((i3 & 32) == 0) {
                    i23 = 65536;
                } else {
                    i23 = 65536;
                }
                i4 |= i23;
            } else {
                cornerBasedShapeCopy = shape;
            }
            i9 = i3 & 64;
            if (i9 != 0) {
                i4 |= 1572864;
                borderStroke2 = borderStroke;
            } else {
                borderStroke2 = borderStroke;
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(borderStroke2)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i4 |= i10;
                }
            }
            if ((i & 12582912) == 0) {
                if ((i3 & 128) != 0) {
                    i22 = 4194304;
                } else {
                    if ((16777216 & i) == 0) {
                        zChangedInstance = composerStartRestartGroup.changed(selectableChipColors);
                    } else {
                        zChangedInstance = composerStartRestartGroup.changedInstance(selectableChipColors);
                    }
                    if (zChangedInstance) {
                        i22 = 8388608;
                    } else {
                        i22 = 4194304;
                    }
                }
                i4 |= i22;
            }
            i11 = i3 & 256;
            if (i11 != 0) {
                i4 |= 100663296;
                function6 = function2;
            } else {
                function6 = function2;
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i12 = 67108864;
                    } else {
                        i12 = 33554432;
                    }
                    i4 |= i12;
                }
            }
            i13 = i3 & 512;
            if (i13 != 0) {
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i14 = 268435456;
                    }
                    i4 |= i14;
                }
                i15 = i3 & 1024;
                if (i15 != 0) {
                    i16 = i2 | 6;
                } else if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i17 = 4;
                    } else {
                        i17 = 2;
                    }
                    i16 = i2 | i17;
                } else {
                    i16 = i2;
                }
                if ((i2 & 48) == 0) {
                    if (composerStartRestartGroup.changedInstance(function5)) {
                        i21 = 32;
                    } else {
                        i21 = 16;
                    }
                    i16 |= i21;
                }
                i18 = i16;
                if ((i4 & 306783379) == 306783378) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "187@8731L6,189@8858L18");
                    if ((i & 1) != 0) {
                        if (i24 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        } else {
                            z3 = z3;
                        }
                        if (i7 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i3 & 32) != 0) {
                            cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i4 &= -458753;
                        }
                        i19 = i4;
                        cornerBasedShapeCopy = cornerBasedShapeCopy;
                        if (i9 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke2;
                        }
                        if ((i3 & 128) != 0) {
                            i20 = i11;
                            selectableChipColorsM2320filterChipColorsJ08w3E = ChipDefaults.INSTANCE.m2320filterChipColorsJ08w3E(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 805306368, 511);
                            i19 &= -29360129;
                        } else {
                            i20 = i11;
                            selectableChipColorsM2320filterChipColorsJ08w3E = selectableChipColors;
                        }
                        if (i20 != 0) {
                            composerStartRestartGroup = composerStartRestartGroup;
                            function6 = null;
                        }
                        if (i13 != 0) {
                            function10 = null;
                        } else {
                            function10 = function3;
                        }
                        if (i15 != 0) {
                            function11 = null;
                        } else {
                            function11 = function4;
                        }
                        function12 = function6;
                        modifier4 = companion;
                    } else {
                        if (i24 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        } else {
                            z3 = z3;
                        }
                        if (i7 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i3 & 32) != 0) {
                            cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i4 &= -458753;
                        }
                        i19 = i4;
                        cornerBasedShapeCopy = cornerBasedShapeCopy;
                        if (i9 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke2;
                        }
                        if ((i3 & 128) != 0) {
                            i20 = i11;
                            selectableChipColorsM2320filterChipColorsJ08w3E = ChipDefaults.INSTANCE.m2320filterChipColorsJ08w3E(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 805306368, 511);
                            i19 &= -29360129;
                        } else {
                            i20 = i11;
                            selectableChipColorsM2320filterChipColorsJ08w3E = selectableChipColors;
                        }
                        if (i20 != 0) {
                            composerStartRestartGroup = composerStartRestartGroup;
                            function6 = null;
                        }
                        if (i13 != 0) {
                            function10 = null;
                        } else {
                            function10 = function3;
                        }
                        if (i15 != 0) {
                            function11 = null;
                        } else {
                            function11 = function4;
                        }
                        function12 = function6;
                        modifier4 = companion;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(69602198, i19, i18, "androidx.compose.material.FilterChip (Chip.kt:194)");
                    }
                    int i2115 = i19 << 3;
                    int i2116 = ((i19 >> 9) & 14) | (i2115 & 112) | ((i19 >> 15) & 896);
                    final State stateContentColor11 = selectableChipColorsM2320filterChipColorsJ08w3E.contentColor(z3, z, composerStartRestartGroup, i2116);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1831738322, "CC(remember):Chip.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ChipKt.FilterChip$lambda$0$0((SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final Function2 function11113 = function12;
                    Shape shape13 = cornerBasedShapeCopy;
                    final SelectableChipColors selectableChipColors13 = selectableChipColorsM2320filterChipColorsJ08w3E;
                    final Function2 function11114 = function10;
                    final Function2 function11115 = function11;
                    final boolean z16 = z3;
                    Modifier modifier15 = modifier4;
                    SurfaceKt.m2586SurfaceNy5ogXk(z, function0, SemanticsModifierKt.semantics$default(modifier4, false, (Function1) objRememberedValue, 1, null), z16, shape13, selectableChipColorsM2320filterChipColorsJ08w3E.backgroundColor(z3, z, composerStartRestartGroup, i2116).getValue().m6824unboximpl(), Color.m6813copywmQWz5c$default(stateContentColor11.getValue().m6824unboximpl(), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(-60565717, true, new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ChipKt.FilterChip$lambda$1(stateContentColor11, function11113, z, function11114, function11115, function5, selectableChipColors13, z16, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i19 & 7294) | (57344 & (i19 >> 3)) | (i2115 & 29360128) | ((i19 << 15) & C.ENCODING_PCM_DOUBLE), 6, 256);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    shape2 = shape13;
                    borderStroke3 = borderStroke2;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    selectableChipColors2 = selectableChipColors13;
                    function9 = function11113;
                    function7 = function11114;
                    function8 = function11115;
                    z5 = z16;
                    modifier3 = modifier15;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    selectableChipColors2 = selectableChipColors;
                    function7 = function3;
                    function8 = function4;
                    shape2 = cornerBasedShapeCopy;
                    borderStroke3 = borderStroke2;
                    modifier3 = modifier2;
                    function9 = function6;
                    z5 = z3;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ChipKt.FilterChip$lambda$2(z, function0, modifier3, z5, mutableInteractionSource2, shape2, borderStroke3, selectableChipColors2, function9, function7, function8, function5, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 805306368;
            i15 = i3 & 1024;
            if (i15 != 0) {
                i16 = i2 | 6;
            } else if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i17 = 4;
                } else {
                    i17 = 2;
                }
                i16 = i2 | i17;
            } else {
                i16 = i2;
            }
            if ((i2 & 48) == 0) {
                if (composerStartRestartGroup.changedInstance(function5)) {
                    i21 = 32;
                } else {
                    i21 = 16;
                }
                i16 |= i21;
            }
            i18 = i16;
            if ((i4 & 306783379) == 306783378) {
                z4 = true;
            } else {
                z4 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "187@8731L6,189@8858L18");
                if ((i & 1) != 0) {
                    if (i24 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    } else {
                        z3 = z3;
                    }
                    if (i7 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if ((i3 & 32) != 0) {
                        cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i4 &= -458753;
                    }
                    i19 = i4;
                    cornerBasedShapeCopy = cornerBasedShapeCopy;
                    if (i9 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke2;
                    }
                    if ((i3 & 128) != 0) {
                        i20 = i11;
                        selectableChipColorsM2320filterChipColorsJ08w3E = ChipDefaults.INSTANCE.m2320filterChipColorsJ08w3E(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 805306368, 511);
                        i19 &= -29360129;
                    } else {
                        i20 = i11;
                        selectableChipColorsM2320filterChipColorsJ08w3E = selectableChipColors;
                    }
                    if (i20 != 0) {
                        composerStartRestartGroup = composerStartRestartGroup;
                        function6 = null;
                    }
                    if (i13 != 0) {
                        function10 = null;
                    } else {
                        function10 = function3;
                    }
                    if (i15 != 0) {
                        function11 = null;
                    } else {
                        function11 = function4;
                    }
                    function12 = function6;
                    modifier4 = companion;
                } else {
                    if (i24 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    } else {
                        z3 = z3;
                    }
                    if (i7 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if ((i3 & 32) != 0) {
                        cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i4 &= -458753;
                    }
                    i19 = i4;
                    cornerBasedShapeCopy = cornerBasedShapeCopy;
                    if (i9 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke2;
                    }
                    if ((i3 & 128) != 0) {
                        i20 = i11;
                        selectableChipColorsM2320filterChipColorsJ08w3E = ChipDefaults.INSTANCE.m2320filterChipColorsJ08w3E(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 805306368, 511);
                        i19 &= -29360129;
                    } else {
                        i20 = i11;
                        selectableChipColorsM2320filterChipColorsJ08w3E = selectableChipColors;
                    }
                    if (i20 != 0) {
                        composerStartRestartGroup = composerStartRestartGroup;
                        function6 = null;
                    }
                    if (i13 != 0) {
                        function10 = null;
                    } else {
                        function10 = function3;
                    }
                    if (i15 != 0) {
                        function11 = null;
                    } else {
                        function11 = function4;
                    }
                    function12 = function6;
                    modifier4 = companion;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(69602198, i19, i18, "androidx.compose.material.FilterChip (Chip.kt:194)");
                }
                int i2117 = i19 << 3;
                int i2118 = ((i19 >> 9) & 14) | (i2117 & 112) | ((i19 >> 15) & 896);
                final State stateContentColor12 = selectableChipColorsM2320filterChipColorsJ08w3E.contentColor(z3, z, composerStartRestartGroup, i2118);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1831738322, "CC(remember):Chip.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ChipKt.FilterChip$lambda$0$0((SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final Function2 function11116 = function12;
                Shape shape14 = cornerBasedShapeCopy;
                final SelectableChipColors selectableChipColors14 = selectableChipColorsM2320filterChipColorsJ08w3E;
                final Function2 function11117 = function10;
                final Function2 function11118 = function11;
                final boolean z17 = z3;
                Modifier modifier16 = modifier4;
                SurfaceKt.m2586SurfaceNy5ogXk(z, function0, SemanticsModifierKt.semantics$default(modifier4, false, (Function1) objRememberedValue, 1, null), z17, shape14, selectableChipColorsM2320filterChipColorsJ08w3E.backgroundColor(z3, z, composerStartRestartGroup, i2118).getValue().m6824unboximpl(), Color.m6813copywmQWz5c$default(stateContentColor12.getValue().m6824unboximpl(), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(-60565717, true, new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ChipKt.FilterChip$lambda$1(stateContentColor12, function11116, z, function11117, function11118, function5, selectableChipColors14, z17, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i19 & 7294) | (57344 & (i19 >> 3)) | (i2117 & 29360128) | ((i19 << 15) & C.ENCODING_PCM_DOUBLE), 6, 256);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                shape2 = shape14;
                borderStroke3 = borderStroke2;
                mutableInteractionSource2 = mutableInteractionSource3;
                selectableChipColors2 = selectableChipColors14;
                function9 = function11116;
                function7 = function11117;
                function8 = function11118;
                z5 = z17;
                modifier3 = modifier16;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                mutableInteractionSource2 = mutableInteractionSource;
                selectableChipColors2 = selectableChipColors;
                function7 = function3;
                function8 = function4;
                shape2 = cornerBasedShapeCopy;
                borderStroke3 = borderStroke2;
                modifier3 = modifier2;
                function9 = function6;
                z5 = z3;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ChipKt.FilterChip$lambda$2(z, function0, modifier3, z5, mutableInteractionSource2, shape2, borderStroke3, selectableChipColors2, function9, function7, function8, function5, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 3072;
        z3 = z2;
        i7 = i3 & 16;
        if (i7 != 0) {
            if ((i & 24576) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i8 = 16384;
                } else {
                    i8 = 8192;
                }
                i4 |= i8;
            }
            if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
                cornerBasedShapeCopy = shape;
                if ((i3 & 32) == 0) {
                    i23 = 65536;
                } else {
                    i23 = 65536;
                }
                i4 |= i23;
            } else {
                cornerBasedShapeCopy = shape;
            }
            i9 = i3 & 64;
            if (i9 != 0) {
                i4 |= 1572864;
                borderStroke2 = borderStroke;
            } else {
                borderStroke2 = borderStroke;
                if ((i & 1572864) == 0) {
                    if (composerStartRestartGroup.changed(borderStroke2)) {
                        i10 = 1048576;
                    } else {
                        i10 = 524288;
                    }
                    i4 |= i10;
                }
            }
            if ((i & 12582912) == 0) {
                if ((i3 & 128) != 0) {
                    i22 = 4194304;
                } else {
                    if ((16777216 & i) == 0) {
                        zChangedInstance = composerStartRestartGroup.changed(selectableChipColors);
                    } else {
                        zChangedInstance = composerStartRestartGroup.changedInstance(selectableChipColors);
                    }
                    if (zChangedInstance) {
                        i22 = 8388608;
                    } else {
                        i22 = 4194304;
                    }
                }
                i4 |= i22;
            }
            i11 = i3 & 256;
            if (i11 != 0) {
                i4 |= 100663296;
                function6 = function2;
            } else {
                function6 = function2;
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(function6)) {
                        i12 = 67108864;
                    } else {
                        i12 = 33554432;
                    }
                    i4 |= i12;
                }
            }
            i13 = i3 & 512;
            if (i13 != 0) {
                if ((i & 805306368) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                    } else {
                        i14 = 268435456;
                    }
                    i4 |= i14;
                }
                i15 = i3 & 1024;
                if (i15 != 0) {
                    i16 = i2 | 6;
                } else if ((i2 & 6) == 0) {
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i17 = 4;
                    } else {
                        i17 = 2;
                    }
                    i16 = i2 | i17;
                } else {
                    i16 = i2;
                }
                if ((i2 & 48) == 0) {
                    if (composerStartRestartGroup.changedInstance(function5)) {
                        i21 = 32;
                    } else {
                        i21 = 16;
                    }
                    i16 |= i21;
                }
                i18 = i16;
                if ((i4 & 306783379) == 306783378) {
                    z4 = true;
                } else {
                    z4 = true;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "187@8731L6,189@8858L18");
                    if ((i & 1) != 0) {
                        if (i24 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        } else {
                            z3 = z3;
                        }
                        if (i7 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i3 & 32) != 0) {
                            cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i4 &= -458753;
                        }
                        i19 = i4;
                        cornerBasedShapeCopy = cornerBasedShapeCopy;
                        if (i9 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke2;
                        }
                        if ((i3 & 128) != 0) {
                            i20 = i11;
                            selectableChipColorsM2320filterChipColorsJ08w3E = ChipDefaults.INSTANCE.m2320filterChipColorsJ08w3E(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 805306368, 511);
                            i19 &= -29360129;
                        } else {
                            i20 = i11;
                            selectableChipColorsM2320filterChipColorsJ08w3E = selectableChipColors;
                        }
                        if (i20 != 0) {
                            composerStartRestartGroup = composerStartRestartGroup;
                            function6 = null;
                        }
                        if (i13 != 0) {
                            function10 = null;
                        } else {
                            function10 = function3;
                        }
                        if (i15 != 0) {
                            function11 = null;
                        } else {
                            function11 = function4;
                        }
                        function12 = function6;
                        modifier4 = companion;
                    } else {
                        if (i24 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i5 != 0) {
                            z3 = true;
                        } else {
                            z3 = z3;
                        }
                        if (i7 != 0) {
                            mutableInteractionSource3 = null;
                        } else {
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                        if ((i3 & 32) != 0) {
                            cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                            i4 &= -458753;
                        }
                        i19 = i4;
                        cornerBasedShapeCopy = cornerBasedShapeCopy;
                        if (i9 != 0) {
                            borderStroke2 = null;
                        } else {
                            borderStroke2 = borderStroke2;
                        }
                        if ((i3 & 128) != 0) {
                            i20 = i11;
                            selectableChipColorsM2320filterChipColorsJ08w3E = ChipDefaults.INSTANCE.m2320filterChipColorsJ08w3E(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 805306368, 511);
                            i19 &= -29360129;
                        } else {
                            i20 = i11;
                            selectableChipColorsM2320filterChipColorsJ08w3E = selectableChipColors;
                        }
                        if (i20 != 0) {
                            composerStartRestartGroup = composerStartRestartGroup;
                            function6 = null;
                        }
                        if (i13 != 0) {
                            function10 = null;
                        } else {
                            function10 = function3;
                        }
                        if (i15 != 0) {
                            function11 = null;
                        } else {
                            function11 = function4;
                        }
                        function12 = function6;
                        modifier4 = companion;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(69602198, i19, i18, "androidx.compose.material.FilterChip (Chip.kt:194)");
                    }
                    int i2119 = i19 << 3;
                    int i21110 = ((i19 >> 9) & 14) | (i2119 & 112) | ((i19 >> 15) & 896);
                    final State stateContentColor13 = selectableChipColorsM2320filterChipColorsJ08w3E.contentColor(z3, z, composerStartRestartGroup, i21110);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1831738322, "CC(remember):Chip.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return ChipKt.FilterChip$lambda$0$0((SemanticsPropertyReceiver) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    final Function2 function11119 = function12;
                    Shape shape15 = cornerBasedShapeCopy;
                    final SelectableChipColors selectableChipColors15 = selectableChipColorsM2320filterChipColorsJ08w3E;
                    final Function2 function111110 = function10;
                    final Function2 function111111 = function11;
                    final boolean z18 = z3;
                    Modifier modifier17 = modifier4;
                    SurfaceKt.m2586SurfaceNy5ogXk(z, function0, SemanticsModifierKt.semantics$default(modifier4, false, (Function1) objRememberedValue, 1, null), z18, shape15, selectableChipColorsM2320filterChipColorsJ08w3E.backgroundColor(z3, z, composerStartRestartGroup, i21110).getValue().m6824unboximpl(), Color.m6813copywmQWz5c$default(stateContentColor13.getValue().m6824unboximpl(), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(-60565717, true, new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ChipKt.FilterChip$lambda$1(stateContentColor13, function11119, z, function111110, function111111, function5, selectableChipColors15, z18, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i19 & 7294) | (57344 & (i19 >> 3)) | (i2119 & 29360128) | ((i19 << 15) & C.ENCODING_PCM_DOUBLE), 6, 256);
                    composer2 = composerStartRestartGroup;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    shape2 = shape15;
                    borderStroke3 = borderStroke2;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    selectableChipColors2 = selectableChipColors15;
                    function9 = function11119;
                    function7 = function111110;
                    function8 = function111111;
                    z5 = z18;
                    modifier3 = modifier17;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    mutableInteractionSource2 = mutableInteractionSource;
                    selectableChipColors2 = selectableChipColors;
                    function7 = function3;
                    function8 = function4;
                    shape2 = cornerBasedShapeCopy;
                    borderStroke3 = borderStroke2;
                    modifier3 = modifier2;
                    function9 = function6;
                    z5 = z3;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ChipKt.FilterChip$lambda$2(z, function0, modifier3, z5, mutableInteractionSource2, shape2, borderStroke3, selectableChipColors2, function9, function7, function8, function5, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i4 |= 805306368;
            i15 = i3 & 1024;
            if (i15 != 0) {
                i16 = i2 | 6;
            } else if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i17 = 4;
                } else {
                    i17 = 2;
                }
                i16 = i2 | i17;
            } else {
                i16 = i2;
            }
            if ((i2 & 48) == 0) {
                if (composerStartRestartGroup.changedInstance(function5)) {
                    i21 = 32;
                } else {
                    i21 = 16;
                }
                i16 |= i21;
            }
            i18 = i16;
            if ((i4 & 306783379) == 306783378) {
                z4 = true;
            } else {
                z4 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "187@8731L6,189@8858L18");
                if ((i & 1) != 0) {
                    if (i24 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    } else {
                        z3 = z3;
                    }
                    if (i7 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if ((i3 & 32) != 0) {
                        cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i4 &= -458753;
                    }
                    i19 = i4;
                    cornerBasedShapeCopy = cornerBasedShapeCopy;
                    if (i9 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke2;
                    }
                    if ((i3 & 128) != 0) {
                        i20 = i11;
                        selectableChipColorsM2320filterChipColorsJ08w3E = ChipDefaults.INSTANCE.m2320filterChipColorsJ08w3E(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 805306368, 511);
                        i19 &= -29360129;
                    } else {
                        i20 = i11;
                        selectableChipColorsM2320filterChipColorsJ08w3E = selectableChipColors;
                    }
                    if (i20 != 0) {
                        composerStartRestartGroup = composerStartRestartGroup;
                        function6 = null;
                    }
                    if (i13 != 0) {
                        function10 = null;
                    } else {
                        function10 = function3;
                    }
                    if (i15 != 0) {
                        function11 = null;
                    } else {
                        function11 = function4;
                    }
                    function12 = function6;
                    modifier4 = companion;
                } else {
                    if (i24 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    } else {
                        z3 = z3;
                    }
                    if (i7 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if ((i3 & 32) != 0) {
                        cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i4 &= -458753;
                    }
                    i19 = i4;
                    cornerBasedShapeCopy = cornerBasedShapeCopy;
                    if (i9 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke2;
                    }
                    if ((i3 & 128) != 0) {
                        i20 = i11;
                        selectableChipColorsM2320filterChipColorsJ08w3E = ChipDefaults.INSTANCE.m2320filterChipColorsJ08w3E(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 805306368, 511);
                        i19 &= -29360129;
                    } else {
                        i20 = i11;
                        selectableChipColorsM2320filterChipColorsJ08w3E = selectableChipColors;
                    }
                    if (i20 != 0) {
                        composerStartRestartGroup = composerStartRestartGroup;
                        function6 = null;
                    }
                    if (i13 != 0) {
                        function10 = null;
                    } else {
                        function10 = function3;
                    }
                    if (i15 != 0) {
                        function11 = null;
                    } else {
                        function11 = function4;
                    }
                    function12 = function6;
                    modifier4 = companion;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(69602198, i19, i18, "androidx.compose.material.FilterChip (Chip.kt:194)");
                }
                int i21111 = i19 << 3;
                int i21112 = ((i19 >> 9) & 14) | (i21111 & 112) | ((i19 >> 15) & 896);
                final State stateContentColor14 = selectableChipColorsM2320filterChipColorsJ08w3E.contentColor(z3, z, composerStartRestartGroup, i21112);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1831738322, "CC(remember):Chip.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ChipKt.FilterChip$lambda$0$0((SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final Function2 function111112 = function12;
                Shape shape16 = cornerBasedShapeCopy;
                final SelectableChipColors selectableChipColors16 = selectableChipColorsM2320filterChipColorsJ08w3E;
                final Function2 function111113 = function10;
                final Function2 function111114 = function11;
                final boolean z19 = z3;
                Modifier modifier18 = modifier4;
                SurfaceKt.m2586SurfaceNy5ogXk(z, function0, SemanticsModifierKt.semantics$default(modifier4, false, (Function1) objRememberedValue, 1, null), z19, shape16, selectableChipColorsM2320filterChipColorsJ08w3E.backgroundColor(z3, z, composerStartRestartGroup, i21112).getValue().m6824unboximpl(), Color.m6813copywmQWz5c$default(stateContentColor14.getValue().m6824unboximpl(), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(-60565717, true, new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ChipKt.FilterChip$lambda$1(stateContentColor14, function111112, z, function111113, function111114, function5, selectableChipColors16, z19, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i19 & 7294) | (57344 & (i19 >> 3)) | (i21111 & 29360128) | ((i19 << 15) & C.ENCODING_PCM_DOUBLE), 6, 256);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                shape2 = shape16;
                borderStroke3 = borderStroke2;
                mutableInteractionSource2 = mutableInteractionSource3;
                selectableChipColors2 = selectableChipColors16;
                function9 = function111112;
                function7 = function111113;
                function8 = function111114;
                z5 = z19;
                modifier3 = modifier18;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                mutableInteractionSource2 = mutableInteractionSource;
                selectableChipColors2 = selectableChipColors;
                function7 = function3;
                function8 = function4;
                shape2 = cornerBasedShapeCopy;
                borderStroke3 = borderStroke2;
                modifier3 = modifier2;
                function9 = function6;
                z5 = z3;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ChipKt.FilterChip$lambda$2(z, function0, modifier3, z5, mutableInteractionSource2, shape2, borderStroke3, selectableChipColors2, function9, function7, function8, function5, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 24576;
        if ((i & ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE) == 0) {
            cornerBasedShapeCopy = shape;
            if ((i3 & 32) == 0) {
                i23 = 65536;
            } else {
                i23 = 65536;
            }
            i4 |= i23;
        } else {
            cornerBasedShapeCopy = shape;
        }
        i9 = i3 & 64;
        if (i9 != 0) {
            i4 |= 1572864;
            borderStroke2 = borderStroke;
        } else {
            borderStroke2 = borderStroke;
            if ((i & 1572864) == 0) {
                if (composerStartRestartGroup.changed(borderStroke2)) {
                    i10 = 1048576;
                } else {
                    i10 = 524288;
                }
                i4 |= i10;
            }
        }
        if ((i & 12582912) == 0) {
            if ((i3 & 128) != 0) {
                i22 = 4194304;
            } else {
                if ((16777216 & i) == 0) {
                    zChangedInstance = composerStartRestartGroup.changed(selectableChipColors);
                } else {
                    zChangedInstance = composerStartRestartGroup.changedInstance(selectableChipColors);
                }
                if (zChangedInstance) {
                    i22 = 8388608;
                } else {
                    i22 = 4194304;
                }
            }
            i4 |= i22;
        }
        i11 = i3 & 256;
        if (i11 != 0) {
            i4 |= 100663296;
            function6 = function2;
        } else {
            function6 = function2;
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changedInstance(function6)) {
                    i12 = 67108864;
                } else {
                    i12 = 33554432;
                }
                i4 |= i12;
            }
        }
        i13 = i3 & 512;
        if (i13 != 0) {
            if ((i & 805306368) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i14 = C.BUFFER_FLAG_LAST_SAMPLE;
                } else {
                    i14 = 268435456;
                }
                i4 |= i14;
            }
            i15 = i3 & 1024;
            if (i15 != 0) {
                i16 = i2 | 6;
            } else if ((i2 & 6) == 0) {
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i17 = 4;
                } else {
                    i17 = 2;
                }
                i16 = i2 | i17;
            } else {
                i16 = i2;
            }
            if ((i2 & 48) == 0) {
                if (composerStartRestartGroup.changedInstance(function5)) {
                    i21 = 32;
                } else {
                    i21 = 16;
                }
                i16 |= i21;
            }
            i18 = i16;
            if ((i4 & 306783379) == 306783378) {
                z4 = true;
            } else {
                z4 = true;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "187@8731L6,189@8858L18");
                if ((i & 1) != 0) {
                    if (i24 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    } else {
                        z3 = z3;
                    }
                    if (i7 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if ((i3 & 32) != 0) {
                        cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i4 &= -458753;
                    }
                    i19 = i4;
                    cornerBasedShapeCopy = cornerBasedShapeCopy;
                    if (i9 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke2;
                    }
                    if ((i3 & 128) != 0) {
                        i20 = i11;
                        selectableChipColorsM2320filterChipColorsJ08w3E = ChipDefaults.INSTANCE.m2320filterChipColorsJ08w3E(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 805306368, 511);
                        i19 &= -29360129;
                    } else {
                        i20 = i11;
                        selectableChipColorsM2320filterChipColorsJ08w3E = selectableChipColors;
                    }
                    if (i20 != 0) {
                        composerStartRestartGroup = composerStartRestartGroup;
                        function6 = null;
                    }
                    if (i13 != 0) {
                        function10 = null;
                    } else {
                        function10 = function3;
                    }
                    if (i15 != 0) {
                        function11 = null;
                    } else {
                        function11 = function4;
                    }
                    function12 = function6;
                    modifier4 = companion;
                } else {
                    if (i24 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i5 != 0) {
                        z3 = true;
                    } else {
                        z3 = z3;
                    }
                    if (i7 != 0) {
                        mutableInteractionSource3 = null;
                    } else {
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    if ((i3 & 32) != 0) {
                        cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                        i4 &= -458753;
                    }
                    i19 = i4;
                    cornerBasedShapeCopy = cornerBasedShapeCopy;
                    if (i9 != 0) {
                        borderStroke2 = null;
                    } else {
                        borderStroke2 = borderStroke2;
                    }
                    if ((i3 & 128) != 0) {
                        i20 = i11;
                        selectableChipColorsM2320filterChipColorsJ08w3E = ChipDefaults.INSTANCE.m2320filterChipColorsJ08w3E(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 805306368, 511);
                        i19 &= -29360129;
                    } else {
                        i20 = i11;
                        selectableChipColorsM2320filterChipColorsJ08w3E = selectableChipColors;
                    }
                    if (i20 != 0) {
                        composerStartRestartGroup = composerStartRestartGroup;
                        function6 = null;
                    }
                    if (i13 != 0) {
                        function10 = null;
                    } else {
                        function10 = function3;
                    }
                    if (i15 != 0) {
                        function11 = null;
                    } else {
                        function11 = function4;
                    }
                    function12 = function6;
                    modifier4 = companion;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(69602198, i19, i18, "androidx.compose.material.FilterChip (Chip.kt:194)");
                }
                int i21113 = i19 << 3;
                int i21114 = ((i19 >> 9) & 14) | (i21113 & 112) | ((i19 >> 15) & 896);
                final State stateContentColor15 = selectableChipColorsM2320filterChipColorsJ08w3E.contentColor(z3, z, composerStartRestartGroup, i21114);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1831738322, "CC(remember):Chip.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return ChipKt.FilterChip$lambda$0$0((SemanticsPropertyReceiver) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final Function2 function111115 = function12;
                Shape shape17 = cornerBasedShapeCopy;
                final SelectableChipColors selectableChipColors17 = selectableChipColorsM2320filterChipColorsJ08w3E;
                final Function2 function111116 = function10;
                final Function2 function111117 = function11;
                final boolean z110 = z3;
                Modifier modifier19 = modifier4;
                SurfaceKt.m2586SurfaceNy5ogXk(z, function0, SemanticsModifierKt.semantics$default(modifier4, false, (Function1) objRememberedValue, 1, null), z110, shape17, selectableChipColorsM2320filterChipColorsJ08w3E.backgroundColor(z3, z, composerStartRestartGroup, i21114).getValue().m6824unboximpl(), Color.m6813copywmQWz5c$default(stateContentColor15.getValue().m6824unboximpl(), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(-60565717, true, new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ChipKt.FilterChip$lambda$1(stateContentColor15, function111115, z, function111116, function111117, function5, selectableChipColors17, z110, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i19 & 7294) | (57344 & (i19 >> 3)) | (i21113 & 29360128) | ((i19 << 15) & C.ENCODING_PCM_DOUBLE), 6, 256);
                composer2 = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                shape2 = shape17;
                borderStroke3 = borderStroke2;
                mutableInteractionSource2 = mutableInteractionSource3;
                selectableChipColors2 = selectableChipColors17;
                function9 = function111115;
                function7 = function111116;
                function8 = function111117;
                z5 = z110;
                modifier3 = modifier19;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                mutableInteractionSource2 = mutableInteractionSource;
                selectableChipColors2 = selectableChipColors;
                function7 = function3;
                function8 = function4;
                shape2 = cornerBasedShapeCopy;
                borderStroke3 = borderStroke2;
                modifier3 = modifier2;
                function9 = function6;
                z5 = z3;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ChipKt.FilterChip$lambda$2(z, function0, modifier3, z5, mutableInteractionSource2, shape2, borderStroke3, selectableChipColors2, function9, function7, function8, function5, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 805306368;
        i15 = i3 & 1024;
        if (i15 != 0) {
            i16 = i2 | 6;
        } else if ((i2 & 6) == 0) {
            if (composerStartRestartGroup.changedInstance(function4)) {
                i17 = 4;
            } else {
                i17 = 2;
            }
            i16 = i2 | i17;
        } else {
            i16 = i2;
        }
        if ((i2 & 48) == 0) {
            if (composerStartRestartGroup.changedInstance(function5)) {
                i21 = 32;
            } else {
                i21 = 16;
            }
            i16 |= i21;
        }
        i18 = i16;
        if ((i4 & 306783379) == 306783378) {
            z4 = true;
        } else {
            z4 = true;
        }
        if (composerStartRestartGroup.shouldExecute(z4, i4 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "187@8731L6,189@8858L18");
            if ((i & 1) != 0) {
                if (i24 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i5 != 0) {
                    z3 = true;
                } else {
                    z3 = z3;
                }
                if (i7 != 0) {
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                if ((i3 & 32) != 0) {
                    cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                    i4 &= -458753;
                }
                i19 = i4;
                cornerBasedShapeCopy = cornerBasedShapeCopy;
                if (i9 != 0) {
                    borderStroke2 = null;
                } else {
                    borderStroke2 = borderStroke2;
                }
                if ((i3 & 128) != 0) {
                    i20 = i11;
                    selectableChipColorsM2320filterChipColorsJ08w3E = ChipDefaults.INSTANCE.m2320filterChipColorsJ08w3E(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 805306368, 511);
                    i19 &= -29360129;
                } else {
                    i20 = i11;
                    selectableChipColorsM2320filterChipColorsJ08w3E = selectableChipColors;
                }
                if (i20 != 0) {
                    composerStartRestartGroup = composerStartRestartGroup;
                    function6 = null;
                }
                if (i13 != 0) {
                    function10 = null;
                } else {
                    function10 = function3;
                }
                if (i15 != 0) {
                    function11 = null;
                } else {
                    function11 = function4;
                }
                function12 = function6;
                modifier4 = companion;
            } else {
                if (i24 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i5 != 0) {
                    z3 = true;
                } else {
                    z3 = z3;
                }
                if (i7 != 0) {
                    mutableInteractionSource3 = null;
                } else {
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                if ((i3 & 32) != 0) {
                    cornerBasedShapeCopy = MaterialTheme.INSTANCE.getShapes(composerStartRestartGroup, 6).getSmall().copy(CornerSizeKt.CornerSize(50));
                    i4 &= -458753;
                }
                i19 = i4;
                cornerBasedShapeCopy = cornerBasedShapeCopy;
                if (i9 != 0) {
                    borderStroke2 = null;
                } else {
                    borderStroke2 = borderStroke2;
                }
                if ((i3 & 128) != 0) {
                    i20 = i11;
                    selectableChipColorsM2320filterChipColorsJ08w3E = ChipDefaults.INSTANCE.m2320filterChipColorsJ08w3E(0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, 0L, composerStartRestartGroup, 805306368, 511);
                    i19 &= -29360129;
                } else {
                    i20 = i11;
                    selectableChipColorsM2320filterChipColorsJ08w3E = selectableChipColors;
                }
                if (i20 != 0) {
                    composerStartRestartGroup = composerStartRestartGroup;
                    function6 = null;
                }
                if (i13 != 0) {
                    function10 = null;
                } else {
                    function10 = function3;
                }
                if (i15 != 0) {
                    function11 = null;
                } else {
                    function11 = function4;
                }
                function12 = function6;
                modifier4 = companion;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(69602198, i19, i18, "androidx.compose.material.FilterChip (Chip.kt:194)");
            }
            int i21115 = i19 << 3;
            int i21116 = ((i19 >> 9) & 14) | (i21115 & 112) | ((i19 >> 15) & 896);
            final State stateContentColor16 = selectableChipColorsM2320filterChipColorsJ08w3E.contentColor(z3, z, composerStartRestartGroup, i21116);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1831738322, "CC(remember):Chip.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return ChipKt.FilterChip$lambda$0$0((SemanticsPropertyReceiver) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final Function2 function111118 = function12;
            Shape shape18 = cornerBasedShapeCopy;
            final SelectableChipColors selectableChipColors18 = selectableChipColorsM2320filterChipColorsJ08w3E;
            final Function2 function111119 = function10;
            final Function2 function1111110 = function11;
            final boolean z111 = z3;
            Modifier modifier110 = modifier4;
            SurfaceKt.m2586SurfaceNy5ogXk(z, function0, SemanticsModifierKt.semantics$default(modifier4, false, (Function1) objRememberedValue, 1, null), z111, shape18, selectableChipColorsM2320filterChipColorsJ08w3E.backgroundColor(z3, z, composerStartRestartGroup, i21116).getValue().m6824unboximpl(), Color.m6813copywmQWz5c$default(stateContentColor16.getValue().m6824unboximpl(), 1.0f, 0.0f, 0.0f, 0.0f, 14, null), borderStroke2, 0.0f, mutableInteractionSource3, ComposableLambdaKt.rememberComposableLambda(-60565717, true, new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChipKt.FilterChip$lambda$1(stateContentColor16, function111118, z, function111119, function1111110, function5, selectableChipColors18, z111, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i19 & 7294) | (57344 & (i19 >> 3)) | (i21115 & 29360128) | ((i19 << 15) & C.ENCODING_PCM_DOUBLE), 6, 256);
            composer2 = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            shape2 = shape18;
            borderStroke3 = borderStroke2;
            mutableInteractionSource2 = mutableInteractionSource3;
            selectableChipColors2 = selectableChipColors18;
            function9 = function111118;
            function7 = function111119;
            function8 = function1111110;
            z5 = z111;
            modifier3 = modifier110;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            mutableInteractionSource2 = mutableInteractionSource;
            selectableChipColors2 = selectableChipColors;
            function7 = function3;
            function8 = function4;
            shape2 = cornerBasedShapeCopy;
            borderStroke3 = borderStroke2;
            modifier3 = modifier2;
            function9 = function6;
            z5 = z3;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChipKt.FilterChip$lambda$2(z, function0, modifier3, z5, mutableInteractionSource2, shape2, borderStroke3, selectableChipColors2, function9, function7, function8, function5, i, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FilterChip$lambda$0$0(SemanticsPropertyReceiver semanticsPropertyReceiver) {
        SemanticsPropertiesKt.m8851setRolekuIjeqM(semanticsPropertyReceiver, Role.INSTANCE.m8834getCheckboxo7Vup1c());
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FilterChip$lambda$1(final State state, final Function2 function2, final boolean z, final Function2 function3, final Function2 function4, final Function3 function5, final SelectableChipColors selectableChipColors, final boolean z2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C208@9690L3763,208@9612L3841:Chip.kt#jmzs0o");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-60565717, i, -1, "androidx.compose.material.FilterChip.<anonymous> (Chip.kt:208)");
            }
            CompositionLocalKt.CompositionLocalProvider(ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m6816getAlphaimpl(((Color) state.getValue()).m6824unboximpl()))), ComposableLambdaKt.rememberComposableLambda(-773543317, true, new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChipKt.FilterChip$lambda$1$0(function2, z, function3, function4, function5, selectableChipColors, z2, state, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, ProvidedValue.$stable | 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FilterChip$lambda$1$0(final Function2 function2, final boolean z, final Function2 function3, final Function2 function4, final Function3 function5, final SelectableChipColors selectableChipColors, final boolean z2, final State state, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C209@9743L10,209@9761L3682,209@9704L3739:Chip.kt#jmzs0o");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-773543317, i, -1, "androidx.compose.material.FilterChip.<anonymous>.<anonymous> (Chip.kt:209)");
            }
            TextKt.ProvideTextStyle(MaterialTheme.INSTANCE.getTypography(composer, 6).getBody2(), ComposableLambdaKt.rememberComposableLambda(-44453990, true, new Function2() { // from class: androidx.compose.material.ChipKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ChipKt.FilterChip$lambda$1$0$0(function2, z, function3, function4, function5, selectableChipColors, z2, state, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FilterChip$lambda$1$0$0(Function2 function2, boolean z, Function2 function3, Function2 function4, Function3 function5, SelectableChipColors selectableChipColors, boolean z2, State state, Composer composer, int i) {
        float fM9687constructorimpl;
        float fM9687constructorimpl2;
        ComposerKt.sourceInformation(composer, "C210@9779L3650:Chip.kt#jmzs0o");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-44453990, i, -1, "androidx.compose.material.FilterChip.<anonymous>.<anonymous>.<anonymous> (Chip.kt:210)");
            }
            Modifier modifierM1251defaultMinSizeVpY3zN4$default = SizeKt.m1251defaultMinSizeVpY3zN4$default(IntrinsicKt.width(Modifier.INSTANCE, IntrinsicSize.Max), 0.0f, ChipDefaults.INSTANCE.m2322getMinHeightD9Ej5fM(), 1, null);
            if (function2 == null && (!z || function3 == null)) {
                fM9687constructorimpl = HorizontalPadding;
            } else {
                fM9687constructorimpl = Dp.m9687constructorimpl(0);
            }
            float f = fM9687constructorimpl;
            if (function4 == null) {
                fM9687constructorimpl2 = HorizontalPadding;
            } else {
                fM9687constructorimpl2 = Dp.m9687constructorimpl(0);
            }
            Modifier modifierM1222paddingqDBjuR0$default = PaddingKt.m1222paddingqDBjuR0$default(modifierM1251defaultMinSizeVpY3zN4$default, f, 0.0f, fM9687constructorimpl2, 0.0f, 10, null);
            Arrangement.Horizontal start = Arrangement.INSTANCE.getStart();
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(start, centerVertically, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1222paddingqDBjuR0$default);
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
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -1505315515, "C268@12902L264:Chip.kt#jmzs0o");
            if (function2 != null || (z && function3 != null)) {
                composer.startReplaceGroup(-1505271403);
                ComposerKt.sourceInformation(composer, "231@10804L47,232@10876L1913,266@12814L45");
                SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, LeadingIconStartSpacing), composer, 6);
                ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                Modifier.Companion companion = Modifier.INSTANCE;
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                int currentCompositeKeyHash2 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                CompositionLocalMap currentCompositionLocalMap2 = composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composer, companion);
                Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
                ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                if (!(composer.getApplier() instanceof Applier)) {
                    ComposablesKt.invalidApplier();
                }
                composer.startReusableNode();
                if (composer.getInserting()) {
                    composer.createNode(constructor2);
                } else {
                    composer.useNode();
                }
                Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composer);
                Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash2 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                if (composerM6062constructorimpl2.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl2.rememberedValue(), Integer.valueOf(currentCompositeKeyHash2))) {
                    composerM6062constructorimpl2.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash2));
                    composerM6062constructorimpl2.apply(Integer.valueOf(currentCompositeKeyHash2), setCompositeKeyHash2);
                }
                Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer, -2077321583, "C:Chip.kt#jmzs0o");
                if (function2 == null) {
                    composer.startReplaceGroup(-2088202739);
                } else {
                    composer.startReplaceGroup(-2077339967);
                    ComposerKt.sourceInformation(composer, "234@10999L35,235@11067L298");
                    State<Color> stateLeadingIconColor = selectableChipColors.leadingIconColor(z2, z, composer, 0);
                    CompositionLocalKt.CompositionLocalProvider((ProvidedValue<?>[]) new ProvidedValue[]{ContentColorKt.getLocalContentColor().provides(stateLeadingIconColor.getValue()), ContentAlphaKt.getLocalContentAlpha().provides(Float.valueOf(Color.m6816getAlphaimpl(stateLeadingIconColor.getValue().m6824unboximpl())))}, (Function2<? super Composer, ? super Integer, Unit>) function2, composer, ProvidedValue.$stable);
                }
                composer.endReplaceGroup();
                if (!z || function3 == null) {
                    composer.startReplaceGroup(-2088202739);
                } else {
                    composer.startReplaceGroup(-2076791112);
                    ComposerKt.sourceInformation(composer, "255@12280L453");
                    Modifier.Companion companionClip = Modifier.INSTANCE;
                    long jM6824unboximpl = ((Color) state.getValue()).m6824unboximpl();
                    if (function2 != null) {
                        composer.startReplaceGroup(-2076615869);
                        ComposerKt.sourceInformation(composer, "253@12173L34");
                        companionClip = ClipKt.clip(BackgroundKt.m588backgroundbw27NRU(SizeKt.m1258requiredSize3ABfNKs(Modifier.INSTANCE, SelectedIconContainerSize), ((Color) state.getValue()).m6824unboximpl(), RoundedCornerShapeKt.getCircleShape()), RoundedCornerShapeKt.getCircleShape());
                        jM6824unboximpl = selectableChipColors.backgroundColor(z2, z, composer, 0).getValue().m6824unboximpl();
                    } else {
                        composer.startReplaceGroup(-2088202739);
                    }
                    composer.endReplaceGroup();
                    Alignment center = Alignment.INSTANCE.getCenter();
                    ComposerKt.sourceInformationMarkerStart(composer, 733328855, "CC(Box)P(2,1,3)71@3423L130:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
                    ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
                    int currentCompositeKeyHash3 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
                    CompositionLocalMap currentCompositionLocalMap3 = composer.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composer, companionClip);
                    Function0<ComposeUiNode> constructor3 = ComposeUiNode.INSTANCE.getConstructor();
                    ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
                    if (!(composer.getApplier() instanceof Applier)) {
                        ComposablesKt.invalidApplier();
                    }
                    composer.startReusableNode();
                    if (composer.getInserting()) {
                        composer.createNode(constructor3);
                    } else {
                        composer.useNode();
                    }
                    Composer composerM6062constructorimpl3 = Updater.m6062constructorimpl(composer);
                    Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash3 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
                    if (composerM6062constructorimpl3.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl3.rememberedValue(), Integer.valueOf(currentCompositeKeyHash3))) {
                        composerM6062constructorimpl3.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash3));
                        composerM6062constructorimpl3.apply(Integer.valueOf(currentCompositeKeyHash3), setCompositeKeyHash3);
                    }
                    Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composer, -2146730711, "C72@3468L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composer, 1681585881, "C259@12494L205:Chip.kt#jmzs0o");
                    CompositionLocalKt.CompositionLocalProvider(ContentColorKt.getLocalContentColor().provides(Color.m6804boximpl(jM6824unboximpl)), (Function2<? super Composer, ? super Integer, Unit>) function3, composer, ProvidedValue.$stable);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    composer.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                    ComposerKt.sourceInformationMarkerEnd(composer);
                }
                composer.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, LeadingIconEndSpacing), composer, 6);
            } else {
                composer.startReplaceGroup(-1516029364);
            }
            composer.endReplaceGroup();
            Modifier modifierWeight$default = RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null);
            Arrangement.Horizontal start2 = Arrangement.INSTANCE.getStart();
            Alignment.Vertical centerVertically2 = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 693286680, "CC(Row)P(2,1,3)99@5124L58,100@5187L130:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy2 = RowKt.rowMeasurePolicy(start2, centerVertically2, composer, 54);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash4 = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap4 = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composer, modifierWeight$default);
            Function0<ComposeUiNode> constructor4 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -692256719, "CC(ReusableComposeNode)P(1,2)355@14017L9:Composables.kt#9igjgp");
            if (!(composer.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer.startReusableNode();
            if (composer.getInserting()) {
                composer.createNode(constructor4);
            } else {
                composer.useNode();
            }
            Composer composerM6062constructorimpl4 = Updater.m6062constructorimpl(composer);
            Updater.m6070setimpl(composerM6062constructorimpl4, measurePolicyRowMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash4 = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl4.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl4.rememberedValue(), Integer.valueOf(currentCompositeKeyHash4))) {
                composerM6062constructorimpl4.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash4));
                composerM6062constructorimpl4.apply(Integer.valueOf(currentCompositeKeyHash4), setCompositeKeyHash4);
            }
            Updater.m6070setimpl(composerM6062constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -407735110, "C101@5232L9:Row.kt#2w3rfo");
            function5.invoke(RowScopeInstance.INSTANCE, composer, 6);
            ComposerKt.sourceInformationMarkerEnd(composer);
            composer.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            ComposerKt.sourceInformationMarkerEnd(composer);
            if (function4 != null) {
                composer.startReplaceGroup(-1502914938);
                ComposerKt.sourceInformation(composer, "275@13239L43,276@13307L14,277@13346L43");
                Modifier.Companion companion2 = Modifier.INSTANCE;
                float f2 = TrailingIconSpacing;
                SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(companion2, f2), composer, 6);
                function4.invoke(composer, 0);
                SpacerKt.Spacer(SizeKt.m1271width3ABfNKs(Modifier.INSTANCE, f2), composer, 6);
            } else {
                composer.startReplaceGroup(-1516029364);
            }
            composer.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composer);
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

    private static final long Chip$lambda$0(State<Color> state) {
        return state.getValue().m6824unboximpl();
    }

    private static final long Chip$lambda$2$0$0$0$0(State<Color> state) {
        return state.getValue().m6824unboximpl();
    }

    static {
        float f = 8;
        LeadingIconEndSpacing = Dp.m9687constructorimpl(f);
        TrailingIconSpacing = Dp.m9687constructorimpl(f);
    }
}

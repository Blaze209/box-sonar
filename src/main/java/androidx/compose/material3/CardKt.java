package androidx.compose.material3;

import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.InteractionSourceKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Card.kt */
/* JADX INFO: loaded from: classes7.dex */
@Metadata(d1 = {"\u0000N\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u001a_\u0010\u0000\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0011\u001a\u0083\u0001\u0010\u0000\u001a\u00020\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u00132\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u000b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0018\u001aS\u0010\u0019\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u001a\u001aw\u0010\u0019\u001a\u00020\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u00132\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u001b\u001a]\u0010\u001c\u001a\u00020\u00012\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0011\u001a\u0081\u0001\u0010\u001c\u001a\u00020\u00012\f\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00010\u00132\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\n\b\u0002\u0010\u0016\u001a\u0004\u0018\u00010\u00172\u001c\u0010\f\u001a\u0018\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u00010\r¢\u0006\u0002\b\u000f¢\u0006\u0002\b\u0010H\u0007¢\u0006\u0002\u0010\u0018¨\u0006\u001d"}, d2 = {"Card", "", "modifier", "Landroidx/compose/ui/Modifier;", "shape", "Landroidx/compose/ui/graphics/Shape;", "colors", "Landroidx/compose/material3/CardColors;", "elevation", "Landroidx/compose/material3/CardElevation;", androidx.compose.material.OutlinedTextFieldKt.BorderId, "Landroidx/compose/foundation/BorderStroke;", "content", "Lkotlin/Function1;", "Landroidx/compose/foundation/layout/ColumnScope;", "Landroidx/compose/runtime/Composable;", "Lkotlin/ExtensionFunctionType;", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/CardColors;Landroidx/compose/material3/CardElevation;Landroidx/compose/foundation/BorderStroke;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", ViewProps.ON_CLICK, "Lkotlin/Function0;", "enabled", "", "interactionSource", "Landroidx/compose/foundation/interaction/MutableInteractionSource;", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/CardColors;Landroidx/compose/material3/CardElevation;Landroidx/compose/foundation/BorderStroke;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "ElevatedCard", "(Landroidx/compose/ui/Modifier;Landroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/CardColors;Landroidx/compose/material3/CardElevation;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/Shape;Landroidx/compose/material3/CardColors;Landroidx/compose/material3/CardElevation;Landroidx/compose/foundation/interaction/MutableInteractionSource;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "OutlinedCard", "material3"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class CardKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Card$lambda$1(Modifier modifier, Shape shape, CardColors cardColors, CardElevation cardElevation, BorderStroke borderStroke, Function3 function3, int i, int i2, Composer composer, int i3) {
        Card(modifier, shape, cardColors, cardElevation, borderStroke, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Card$lambda$4(Function0 function0, Modifier modifier, boolean z, Shape shape, CardColors cardColors, CardElevation cardElevation, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, Function3 function3, int i, int i2, Composer composer, int i3) {
        Card(function0, modifier, z, shape, cardColors, cardElevation, borderStroke, mutableInteractionSource, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ElevatedCard$lambda$0(Modifier modifier, Shape shape, CardColors cardColors, CardElevation cardElevation, Function3 function3, int i, int i2, Composer composer, int i3) {
        ElevatedCard(modifier, shape, cardColors, cardElevation, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ElevatedCard$lambda$1(Function0 function0, Modifier modifier, boolean z, Shape shape, CardColors cardColors, CardElevation cardElevation, MutableInteractionSource mutableInteractionSource, Function3 function3, int i, int i2, Composer composer, int i3) {
        ElevatedCard(function0, modifier, z, shape, cardColors, cardElevation, mutableInteractionSource, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OutlinedCard$lambda$0(Modifier modifier, Shape shape, CardColors cardColors, CardElevation cardElevation, BorderStroke borderStroke, Function3 function3, int i, int i2, Composer composer, int i3) {
        OutlinedCard(modifier, shape, cardColors, cardElevation, borderStroke, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OutlinedCard$lambda$1(Function0 function0, Modifier modifier, boolean z, Shape shape, CardColors cardColors, CardElevation cardElevation, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, Function3 function3, int i, int i2, Composer composer, int i3) {
        OutlinedCard(function0, modifier, z, shape, cardColors, cardElevation, borderStroke, mutableInteractionSource, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x0142  */
    /* JADX WARN: Code duplicated, block: B:103:0x0146  */
    /* JADX WARN: Code duplicated, block: B:106:0x0152  */
    /* JADX WARN: Code duplicated, block: B:109:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:111:0x01b3  */
    /* JADX WARN: Code duplicated, block: B:114:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:116:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:59:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:67:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:85:0x00f7 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:86:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:87:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:90:0x0103  */
    /* JADX WARN: Code duplicated, block: B:91:0x010c  */
    /* JADX WARN: Code duplicated, block: B:94:0x0111  */
    /* JADX WARN: Code duplicated, block: B:95:0x011a  */
    /* JADX WARN: Code duplicated, block: B:98:0x011f  */
    /* JADX WARN: Code duplicated, block: B:99:0x013a  */
    public static final void Card(Modifier modifier, Shape shape, CardColors cardColors, CardElevation cardElevation, BorderStroke borderStroke, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        Shape shape2;
        CardColors cardColors2;
        CardElevation cardElevationM2904cardElevationaqJV_2Y;
        BorderStroke borderStroke2;
        boolean z;
        final Modifier modifier3;
        final Shape shape3;
        final CardColors cardColors3;
        final CardElevation cardElevation2;
        final BorderStroke borderStroke3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        Shape shape4;
        CardColors cardColors4;
        boolean z2;
        Modifier modifier4;
        CardElevation cardElevation3;
        BorderStroke borderStroke4;
        Shape shape5;
        int i4;
        Composer composerStartRestartGroup = composer.startRestartGroup(1359693790);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Card)N(modifier,shape,colors,elevation,border,content)92@4165L57,94@4261L41,87@3953L349:Card.kt#uh7d8r");
        int i5 = i2 & 1;
        if (i5 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                shape2 = shape;
                int i6 = composerStartRestartGroup.changed(shape2) ? 32 : 16;
                i3 |= i6;
            } else {
                shape2 = shape;
            }
            i3 |= i6;
        } else {
            shape2 = shape;
        }
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                cardColors2 = cardColors;
                int i7 = composerStartRestartGroup.changed(cardColors2) ? 256 : 128;
                i3 |= i7;
            } else {
                cardColors2 = cardColors;
            }
            i3 |= i7;
        } else {
            cardColors2 = cardColors;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                cardElevationM2904cardElevationaqJV_2Y = cardElevation;
                int i8 = composerStartRestartGroup.changed(cardElevationM2904cardElevationaqJV_2Y) ? 2048 : 1024;
                i3 |= i8;
            } else {
                cardElevationM2904cardElevationaqJV_2Y = cardElevation;
            }
            i3 |= i8;
        } else {
            cardElevationM2904cardElevationaqJV_2Y = cardElevation;
        }
        int i9 = i2 & 16;
        if (i9 == 0) {
            if ((i & 24576) == 0) {
                borderStroke2 = borderStroke;
                i3 |= composerStartRestartGroup.changed(borderStroke2) ? 16384 : 8192;
            }
            if ((196608 & i) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i4 = 131072;
                } else {
                    i4 = 65536;
                }
                i3 |= i4;
            }
            if ((74899 & i3) != 74898) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "81@3742L5,82@3787L12,83@3845L15");
                if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                    if (i5 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if ((i2 & 2) != 0) {
                        shape4 = CardDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        i3 &= -113;
                    } else {
                        shape4 = shape2;
                    }
                    if ((i2 & 4) != 0) {
                        cardColors4 = CardDefaults.INSTANCE.cardColors(composerStartRestartGroup, 6);
                        i3 &= -897;
                    } else {
                        cardColors4 = cardColors2;
                    }
                    if ((i2 & 8) != 0) {
                        z2 = true;
                        cardElevationM2904cardElevationaqJV_2Y = CardDefaults.INSTANCE.m2904cardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                        i3 &= -7169;
                    } else {
                        z2 = true;
                    }
                    CardElevation cardElevation4 = cardElevationM2904cardElevationaqJV_2Y;
                    modifier4 = companion;
                    cardElevation3 = cardElevation4;
                    if (i9 != 0) {
                        shape5 = shape4;
                        borderStroke4 = null;
                    } else {
                        borderStroke4 = borderStroke;
                        shape5 = shape4;
                    }
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    if ((i2 & 2) != 0) {
                        i3 &= -113;
                    }
                    if ((i2 & 4) != 0) {
                        i3 &= -897;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                    }
                    cardElevation3 = cardElevationM2904cardElevationaqJV_2Y;
                    borderStroke4 = borderStroke2;
                    modifier4 = modifier2;
                    shape5 = shape2;
                    cardColors4 = cardColors2;
                    z2 = true;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1359693790, i3, -1, "androidx.compose.material3.Card (Card.kt:86)");
                }
                SurfaceKt.m4323SurfaceT9BRK9s(modifier4, shape5, cardColors4.m2896containerColorvNxB06k$material3(z2), cardColors4.m2897contentColorvNxB06k$material3(z2), 0.0f, cardElevation3.shadowElevation$material3(z2, null, composerStartRestartGroup, ((i3 >> 3) & 896) | 54).getValue().m9701unboximpl(), borderStroke4, ComposableLambdaKt.rememberComposableLambda(-97109725, z2, new Function2() { // from class: androidx.compose.material3.CardKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CardKt.Card$lambda$0(function3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (3670016 & (i3 << 6)), 16);
                composerStartRestartGroup = composerStartRestartGroup;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                cardColors3 = cardColors4;
                shape3 = shape5;
                borderStroke3 = borderStroke4;
                cardElevation2 = cardElevation3;
                modifier3 = modifier4;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                shape3 = shape2;
                cardColors3 = cardColors2;
                cardElevation2 = cardElevationM2904cardElevationaqJV_2Y;
                borderStroke3 = borderStroke;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CardKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CardKt.Card$lambda$1(modifier3, shape3, cardColors3, cardElevation2, borderStroke3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        borderStroke2 = borderStroke;
        if ((196608 & i) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i4 = 131072;
            } else {
                i4 = 65536;
            }
            i3 |= i4;
        }
        if ((74899 & i3) != 74898) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "81@3742L5,82@3787L12,83@3845L15");
            if ((i & 1) != 0) {
                if (i5 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 2) != 0) {
                    shape4 = CardDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    i3 &= -113;
                } else {
                    shape4 = shape2;
                }
                if ((i2 & 4) != 0) {
                    cardColors4 = CardDefaults.INSTANCE.cardColors(composerStartRestartGroup, 6);
                    i3 &= -897;
                } else {
                    cardColors4 = cardColors2;
                }
                if ((i2 & 8) != 0) {
                    z2 = true;
                    cardElevationM2904cardElevationaqJV_2Y = CardDefaults.INSTANCE.m2904cardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                    i3 &= -7169;
                } else {
                    z2 = true;
                }
                CardElevation cardElevation5 = cardElevationM2904cardElevationaqJV_2Y;
                modifier4 = companion;
                cardElevation3 = cardElevation5;
                if (i9 != 0) {
                    shape5 = shape4;
                    borderStroke4 = null;
                } else {
                    borderStroke4 = borderStroke;
                    shape5 = shape4;
                }
            } else {
                if (i5 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if ((i2 & 2) != 0) {
                    shape4 = CardDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    i3 &= -113;
                } else {
                    shape4 = shape2;
                }
                if ((i2 & 4) != 0) {
                    cardColors4 = CardDefaults.INSTANCE.cardColors(composerStartRestartGroup, 6);
                    i3 &= -897;
                } else {
                    cardColors4 = cardColors2;
                }
                if ((i2 & 8) != 0) {
                    z2 = true;
                    cardElevationM2904cardElevationaqJV_2Y = CardDefaults.INSTANCE.m2904cardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                    i3 &= -7169;
                } else {
                    z2 = true;
                }
                CardElevation cardElevation6 = cardElevationM2904cardElevationaqJV_2Y;
                modifier4 = companion;
                cardElevation3 = cardElevation6;
                if (i9 != 0) {
                    shape5 = shape4;
                    borderStroke4 = null;
                } else {
                    borderStroke4 = borderStroke;
                    shape5 = shape4;
                }
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1359693790, i3, -1, "androidx.compose.material3.Card (Card.kt:86)");
            }
            SurfaceKt.m4323SurfaceT9BRK9s(modifier4, shape5, cardColors4.m2896containerColorvNxB06k$material3(z2), cardColors4.m2897contentColorvNxB06k$material3(z2), 0.0f, cardElevation3.shadowElevation$material3(z2, null, composerStartRestartGroup, ((i3 >> 3) & 896) | 54).getValue().m9701unboximpl(), borderStroke4, ComposableLambdaKt.rememberComposableLambda(-97109725, z2, new Function2() { // from class: androidx.compose.material3.CardKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CardKt.Card$lambda$0(function3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i3 & 14) | 12582912 | (i3 & 112) | (3670016 & (i3 << 6)), 16);
            composerStartRestartGroup = composerStartRestartGroup;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            cardColors3 = cardColors4;
            shape3 = shape5;
            borderStroke3 = borderStroke4;
            cardElevation2 = cardElevation3;
            modifier3 = modifier4;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            shape3 = shape2;
            cardColors3 = cardColors2;
            cardElevation2 = cardElevationM2904cardElevationaqJV_2Y;
            borderStroke3 = borderStroke;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CardKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CardKt.Card$lambda$1(modifier3, shape3, cardColors3, cardElevation2, borderStroke3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Card$lambda$0(Function3 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C95@4271L25:Card.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-97109725, i, -1, "androidx.compose.material3.Card.<anonymous> (Card.kt:95)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, companion);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            function3.invoke(ColumnScopeInstance.INSTANCE, composer, 6);
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

    /* JADX WARN: Code duplicated, block: B:101:0x0128  */
    /* JADX WARN: Code duplicated, block: B:115:0x0153 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:116:0x0155  */
    /* JADX WARN: Code duplicated, block: B:118:0x015c  */
    /* JADX WARN: Code duplicated, block: B:121:0x0161  */
    /* JADX WARN: Code duplicated, block: B:124:0x016e  */
    /* JADX WARN: Code duplicated, block: B:125:0x0177  */
    /* JADX WARN: Code duplicated, block: B:128:0x017c  */
    /* JADX WARN: Code duplicated, block: B:129:0x0198  */
    /* JADX WARN: Code duplicated, block: B:132:0x01a0  */
    /* JADX WARN: Code duplicated, block: B:133:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:135:0x01a6  */
    /* JADX WARN: Code duplicated, block: B:136:0x01af  */
    /* JADX WARN: Code duplicated, block: B:139:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:141:0x01ca  */
    /* JADX WARN: Code duplicated, block: B:143:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:145:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:148:0x0257  */
    /* JADX WARN: Code duplicated, block: B:150:0x0263  */
    /* JADX WARN: Code duplicated, block: B:153:0x0278  */
    /* JADX WARN: Code duplicated, block: B:155:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0048  */
    /* JADX WARN: Code duplicated, block: B:24:0x004b  */
    /* JADX WARN: Code duplicated, block: B:26:0x004f  */
    /* JADX WARN: Code duplicated, block: B:28:0x0057  */
    /* JADX WARN: Code duplicated, block: B:29:0x005a  */
    /* JADX WARN: Code duplicated, block: B:34:0x0064  */
    /* JADX WARN: Code duplicated, block: B:36:0x0068  */
    /* JADX WARN: Code duplicated, block: B:38:0x0070  */
    /* JADX WARN: Code duplicated, block: B:39:0x0073  */
    /* JADX WARN: Code duplicated, block: B:42:0x0079  */
    /* JADX WARN: Code duplicated, block: B:45:0x007f  */
    /* JADX WARN: Code duplicated, block: B:47:0x0083  */
    /* JADX WARN: Code duplicated, block: B:49:0x008b  */
    /* JADX WARN: Code duplicated, block: B:50:0x008e  */
    /* JADX WARN: Code duplicated, block: B:53:0x0094  */
    /* JADX WARN: Code duplicated, block: B:56:0x009b  */
    /* JADX WARN: Code duplicated, block: B:58:0x009f  */
    /* JADX WARN: Code duplicated, block: B:61:0x00aa A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:64:0x00b0  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b8  */
    /* JADX WARN: Code duplicated, block: B:68:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:70:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:73:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:78:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:79:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:81:0x00df  */
    /* JADX WARN: Code duplicated, block: B:83:0x00e5  */
    /* JADX WARN: Code duplicated, block: B:84:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:88:0x00f2  */
    /* JADX WARN: Code duplicated, block: B:90:0x00f8  */
    /* JADX WARN: Code duplicated, block: B:91:0x00fb  */
    /* JADX WARN: Code duplicated, block: B:95:0x010a  */
    /* JADX WARN: Code duplicated, block: B:96:0x010c  */
    /* JADX WARN: Code duplicated, block: B:99:0x0115  */
    public static final void Card(final Function0<Unit> function0, Modifier modifier, boolean z, Shape shape, CardColors cardColors, CardElevation cardElevation, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        int i5;
        Shape shape2;
        CardColors cardColors2;
        int i6;
        BorderStroke borderStroke2;
        int i7;
        int i8;
        int i9;
        boolean z3;
        boolean z4;
        Composer composer2;
        final CardElevation cardElevation2;
        final Modifier modifier3;
        final boolean z5;
        final Shape shape3;
        final CardColors cardColors3;
        final BorderStroke borderStroke3;
        final MutableInteractionSource mutableInteractionSource2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        CardColors cardColors4;
        Composer composer3;
        CardElevation cardElevationM2904cardElevationaqJV_2Y;
        BorderStroke borderStroke4;
        Modifier modifier4;
        Shape shape4;
        BorderStroke borderStroke5;
        int i10;
        boolean z6;
        MutableInteractionSource mutableInteractionSource3;
        MutableInteractionSource mutableInteractionSource4;
        Object objRememberedValue;
        int i11;
        Composer composerStartRestartGroup = composer.startRestartGroup(2136075085);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Card)N(onClick,modifier,enabled,shape,colors,elevation,border,interactionSource,content)155@7038L43,158@7167L41,148@6786L422:Card.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i12 = i2 & 2;
        if (i12 == 0) {
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
                        shape2 = shape;
                        int i13 = composerStartRestartGroup.changed(shape2) ? 2048 : 1024;
                        i3 |= i13;
                    } else {
                        shape2 = shape;
                    }
                    i3 |= i13;
                } else {
                    shape2 = shape;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        cardColors2 = cardColors;
                        int i14 = composerStartRestartGroup.changed(cardColors2) ? 16384 : 8192;
                        i3 |= i14;
                    } else {
                        cardColors2 = cardColors;
                    }
                    i3 |= i14;
                } else {
                    cardColors2 = cardColors;
                }
                if ((196608 & i) != 0) {
                    i3 |= ((i2 & 32) == 0 || !composerStartRestartGroup.changed(cardElevation)) ? 65536 : 131072;
                }
                i6 = i2 & 64;
                if (i6 != 0) {
                    if ((1572864 & i) == 0) {
                        borderStroke2 = borderStroke;
                        if (composerStartRestartGroup.changed(borderStroke2)) {
                            i7 = 1048576;
                        } else {
                            i7 = 524288;
                        }
                        i3 |= i7;
                    }
                    i8 = i2 & 128;
                    if (i8 != 0) {
                        i3 |= 12582912;
                    } else if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                            i9 = 8388608;
                        } else {
                            i9 = 4194304;
                        }
                        i3 |= i9;
                    }
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i11 = 67108864;
                        } else {
                            i11 = 33554432;
                        }
                        i3 |= i11;
                    }
                    z3 = true;
                    if ((i3 & 38347923) != 38347922) {
                        z4 = true;
                    } else {
                        z4 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "139@6397L5,140@6442L12,141@6500L15");
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i12 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                                shape2 = CardDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                            }
                            if ((i2 & 16) != 0) {
                                cardColors4 = CardDefaults.INSTANCE.cardColors(composerStartRestartGroup, 6);
                                i3 &= -57345;
                            } else {
                                cardColors4 = cardColors2;
                            }
                            if ((i2 & 32) != 0) {
                                cardElevationM2904cardElevationaqJV_2Y = CardDefaults.INSTANCE.m2904cardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                                composer3 = composerStartRestartGroup;
                                i3 &= -458753;
                            } else {
                                composer3 = composerStartRestartGroup;
                                cardElevationM2904cardElevationaqJV_2Y = cardElevation;
                            }
                            if (i6 != 0) {
                                borderStroke4 = null;
                            } else {
                                borderStroke4 = borderStroke;
                            }
                            if (i8 != 0) {
                                Modifier modifier5 = modifier2;
                                i10 = i3;
                                mutableInteractionSource3 = null;
                                modifier4 = modifier5;
                                shape4 = shape2;
                                borderStroke5 = borderStroke4;
                                z6 = z2;
                            } else {
                                modifier4 = modifier2;
                                shape4 = shape2;
                                borderStroke5 = borderStroke4;
                                i10 = i3;
                                z6 = z2;
                            }
                            composer3.endDefaults();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(2136075085, i10, -1, "androidx.compose.material3.Card (Card.kt:145)");
                            }
                            if (mutableInteractionSource3 == null) {
                                composer3.startReplaceGroup(1577873102);
                                ComposerKt.sourceInformation(composer3, "147@6742L39");
                                ComposerKt.sourceInformationMarkerStart(composer3, -226195532, "CC(remember):Card.kt#9igjgp");
                                objRememberedValue = composer3.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                    composer3.updateRememberedValue(objRememberedValue);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composer3);
                                composer3.endReplaceGroup();
                                mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue;
                            } else {
                                composer3.startReplaceGroup(-226196183);
                                composer3.endReplaceGroup();
                                mutableInteractionSource4 = mutableInteractionSource3;
                            }
                            composer2 = composer3;
                            SurfaceKt.m4326Surfaceo_FOJdg(function0, modifier4, z6, shape4, cardColors4.m2896containerColorvNxB06k$material3(z6), cardColors4.m2897contentColorvNxB06k$material3(z6), 0.0f, cardElevationM2904cardElevationaqJV_2Y.shadowElevation$material3(z6, mutableInteractionSource4, composer3, ((i10 >> 6) & 14) | ((i10 >> 9) & 896)).getValue().m9701unboximpl(), borderStroke5, mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(-1347531112, z3, new Function2() { // from class: androidx.compose.material3.CardKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return CardKt.Card$lambda$3(function3, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composer3, 54), composer2, (i10 & 8190) | ((i10 << 6) & 234881024), 6, 64);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            cardColors3 = cardColors4;
                            cardElevation2 = cardElevationM2904cardElevationaqJV_2Y;
                            mutableInteractionSource2 = mutableInteractionSource3;
                            modifier3 = modifier4;
                            z5 = z6;
                            shape3 = shape4;
                            borderStroke3 = borderStroke5;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                            }
                            shape4 = shape2;
                            cardColors4 = cardColors2;
                            z3 = true;
                            borderStroke5 = borderStroke2;
                            composer3 = composerStartRestartGroup;
                            modifier4 = modifier2;
                            z6 = z2;
                            cardElevationM2904cardElevationaqJV_2Y = cardElevation;
                            i10 = i3;
                        }
                        mutableInteractionSource3 = mutableInteractionSource;
                        composer3.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(2136075085, i10, -1, "androidx.compose.material3.Card (Card.kt:145)");
                        }
                        if (mutableInteractionSource3 == null) {
                            composer3.startReplaceGroup(1577873102);
                            ComposerKt.sourceInformation(composer3, "147@6742L39");
                            ComposerKt.sourceInformationMarkerStart(composer3, -226195532, "CC(remember):Card.kt#9igjgp");
                            objRememberedValue = composer3.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                                composer3.updateRememberedValue(objRememberedValue);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer3);
                            composer3.endReplaceGroup();
                            mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue;
                        } else {
                            composer3.startReplaceGroup(-226196183);
                            composer3.endReplaceGroup();
                            mutableInteractionSource4 = mutableInteractionSource3;
                        }
                        composer2 = composer3;
                        SurfaceKt.m4326Surfaceo_FOJdg(function0, modifier4, z6, shape4, cardColors4.m2896containerColorvNxB06k$material3(z6), cardColors4.m2897contentColorvNxB06k$material3(z6), 0.0f, cardElevationM2904cardElevationaqJV_2Y.shadowElevation$material3(z6, mutableInteractionSource4, composer3, ((i10 >> 6) & 14) | ((i10 >> 9) & 896)).getValue().m9701unboximpl(), borderStroke5, mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(-1347531112, z3, new Function2() { // from class: androidx.compose.material3.CardKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CardKt.Card$lambda$3(function3, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composer3, 54), composer2, (i10 & 8190) | ((i10 << 6) & 234881024), 6, 64);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        cardColors3 = cardColors4;
                        cardElevation2 = cardElevationM2904cardElevationaqJV_2Y;
                        mutableInteractionSource2 = mutableInteractionSource3;
                        modifier3 = modifier4;
                        z5 = z6;
                        shape3 = shape4;
                        borderStroke3 = borderStroke5;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        cardElevation2 = cardElevation;
                        modifier3 = modifier2;
                        z5 = z2;
                        shape3 = shape2;
                        cardColors3 = cardColors2;
                        borderStroke3 = borderStroke;
                        mutableInteractionSource2 = mutableInteractionSource;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CardKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CardKt.Card$lambda$4(function0, modifier3, z5, shape3, cardColors3, cardElevation2, borderStroke3, mutableInteractionSource2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 1572864;
                borderStroke2 = borderStroke;
                i8 = i2 & 128;
                if (i8 != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i9 = 8388608;
                    } else {
                        i9 = 4194304;
                    }
                    i3 |= i9;
                }
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i11 = 67108864;
                    } else {
                        i11 = 33554432;
                    }
                    i3 |= i11;
                }
                z3 = true;
                if ((i3 & 38347923) != 38347922) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "139@6397L5,140@6442L12,141@6500L15");
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            shape2 = CardDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 16) != 0) {
                            cardColors4 = CardDefaults.INSTANCE.cardColors(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        } else {
                            cardColors4 = cardColors2;
                        }
                        if ((i2 & 32) != 0) {
                            cardElevationM2904cardElevationaqJV_2Y = CardDefaults.INSTANCE.m2904cardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                            composer3 = composerStartRestartGroup;
                            i3 &= -458753;
                        } else {
                            composer3 = composerStartRestartGroup;
                            cardElevationM2904cardElevationaqJV_2Y = cardElevation;
                        }
                        if (i6 != 0) {
                            borderStroke4 = null;
                        } else {
                            borderStroke4 = borderStroke;
                        }
                        if (i8 != 0) {
                            Modifier modifier6 = modifier2;
                            i10 = i3;
                            mutableInteractionSource3 = null;
                            modifier4 = modifier6;
                            shape4 = shape2;
                            borderStroke5 = borderStroke4;
                            z6 = z2;
                        } else {
                            modifier4 = modifier2;
                            shape4 = shape2;
                            borderStroke5 = borderStroke4;
                            i10 = i3;
                            z6 = z2;
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            shape2 = CardDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 16) != 0) {
                            cardColors4 = CardDefaults.INSTANCE.cardColors(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        } else {
                            cardColors4 = cardColors2;
                        }
                        if ((i2 & 32) != 0) {
                            cardElevationM2904cardElevationaqJV_2Y = CardDefaults.INSTANCE.m2904cardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                            composer3 = composerStartRestartGroup;
                            i3 &= -458753;
                        } else {
                            composer3 = composerStartRestartGroup;
                            cardElevationM2904cardElevationaqJV_2Y = cardElevation;
                        }
                        if (i6 != 0) {
                            borderStroke4 = null;
                        } else {
                            borderStroke4 = borderStroke;
                        }
                        if (i8 != 0) {
                            Modifier modifier7 = modifier2;
                            i10 = i3;
                            mutableInteractionSource3 = null;
                            modifier4 = modifier7;
                            shape4 = shape2;
                            borderStroke5 = borderStroke4;
                            z6 = z2;
                        } else {
                            modifier4 = modifier2;
                            shape4 = shape2;
                            borderStroke5 = borderStroke4;
                            i10 = i3;
                            z6 = z2;
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    }
                    composer3.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2136075085, i10, -1, "androidx.compose.material3.Card (Card.kt:145)");
                    }
                    if (mutableInteractionSource3 == null) {
                        composer3.startReplaceGroup(1577873102);
                        ComposerKt.sourceInformation(composer3, "147@6742L39");
                        ComposerKt.sourceInformationMarkerStart(composer3, -226195532, "CC(remember):Card.kt#9igjgp");
                        objRememberedValue = composer3.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composer3.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endReplaceGroup();
                        mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        composer3.startReplaceGroup(-226196183);
                        composer3.endReplaceGroup();
                        mutableInteractionSource4 = mutableInteractionSource3;
                    }
                    composer2 = composer3;
                    SurfaceKt.m4326Surfaceo_FOJdg(function0, modifier4, z6, shape4, cardColors4.m2896containerColorvNxB06k$material3(z6), cardColors4.m2897contentColorvNxB06k$material3(z6), 0.0f, cardElevationM2904cardElevationaqJV_2Y.shadowElevation$material3(z6, mutableInteractionSource4, composer3, ((i10 >> 6) & 14) | ((i10 >> 9) & 896)).getValue().m9701unboximpl(), borderStroke5, mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(-1347531112, z3, new Function2() { // from class: androidx.compose.material3.CardKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CardKt.Card$lambda$3(function3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer3, 54), composer2, (i10 & 8190) | ((i10 << 6) & 234881024), 6, 64);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    cardColors3 = cardColors4;
                    cardElevation2 = cardElevationM2904cardElevationaqJV_2Y;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    modifier3 = modifier4;
                    z5 = z6;
                    shape3 = shape4;
                    borderStroke3 = borderStroke5;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    cardElevation2 = cardElevation;
                    modifier3 = modifier2;
                    z5 = z2;
                    shape3 = shape2;
                    cardColors3 = cardColors2;
                    borderStroke3 = borderStroke;
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CardKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CardKt.Card$lambda$4(function0, modifier3, z5, shape3, cardColors3, cardElevation2, borderStroke3, mutableInteractionSource2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 384;
            z2 = z;
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                    }
                    i3 |= i13;
                } else {
                    shape2 = shape;
                }
                i3 |= i13;
            } else {
                shape2 = shape;
            }
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    cardColors2 = cardColors;
                    if (composerStartRestartGroup.changed(cardColors2)) {
                    }
                    i3 |= i14;
                } else {
                    cardColors2 = cardColors;
                }
                i3 |= i14;
            } else {
                cardColors2 = cardColors;
            }
            if ((196608 & i) != 0) {
                i3 |= ((i2 & 32) == 0 || !composerStartRestartGroup.changed(cardElevation)) ? 65536 : 131072;
            }
            i6 = i2 & 64;
            if (i6 != 0) {
                if ((1572864 & i) == 0) {
                    borderStroke2 = borderStroke;
                    if (composerStartRestartGroup.changed(borderStroke2)) {
                        i7 = 1048576;
                    } else {
                        i7 = 524288;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 128;
                if (i8 != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i9 = 8388608;
                    } else {
                        i9 = 4194304;
                    }
                    i3 |= i9;
                }
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i11 = 67108864;
                    } else {
                        i11 = 33554432;
                    }
                    i3 |= i11;
                }
                z3 = true;
                if ((i3 & 38347923) != 38347922) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "139@6397L5,140@6442L12,141@6500L15");
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            shape2 = CardDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 16) != 0) {
                            cardColors4 = CardDefaults.INSTANCE.cardColors(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        } else {
                            cardColors4 = cardColors2;
                        }
                        if ((i2 & 32) != 0) {
                            cardElevationM2904cardElevationaqJV_2Y = CardDefaults.INSTANCE.m2904cardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                            composer3 = composerStartRestartGroup;
                            i3 &= -458753;
                        } else {
                            composer3 = composerStartRestartGroup;
                            cardElevationM2904cardElevationaqJV_2Y = cardElevation;
                        }
                        if (i6 != 0) {
                            borderStroke4 = null;
                        } else {
                            borderStroke4 = borderStroke;
                        }
                        if (i8 != 0) {
                            Modifier modifier8 = modifier2;
                            i10 = i3;
                            mutableInteractionSource3 = null;
                            modifier4 = modifier8;
                            shape4 = shape2;
                            borderStroke5 = borderStroke4;
                            z6 = z2;
                        } else {
                            modifier4 = modifier2;
                            shape4 = shape2;
                            borderStroke5 = borderStroke4;
                            i10 = i3;
                            z6 = z2;
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            shape2 = CardDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 16) != 0) {
                            cardColors4 = CardDefaults.INSTANCE.cardColors(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        } else {
                            cardColors4 = cardColors2;
                        }
                        if ((i2 & 32) != 0) {
                            cardElevationM2904cardElevationaqJV_2Y = CardDefaults.INSTANCE.m2904cardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                            composer3 = composerStartRestartGroup;
                            i3 &= -458753;
                        } else {
                            composer3 = composerStartRestartGroup;
                            cardElevationM2904cardElevationaqJV_2Y = cardElevation;
                        }
                        if (i6 != 0) {
                            borderStroke4 = null;
                        } else {
                            borderStroke4 = borderStroke;
                        }
                        if (i8 != 0) {
                            Modifier modifier9 = modifier2;
                            i10 = i3;
                            mutableInteractionSource3 = null;
                            modifier4 = modifier9;
                            shape4 = shape2;
                            borderStroke5 = borderStroke4;
                            z6 = z2;
                        } else {
                            modifier4 = modifier2;
                            shape4 = shape2;
                            borderStroke5 = borderStroke4;
                            i10 = i3;
                            z6 = z2;
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    }
                    composer3.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2136075085, i10, -1, "androidx.compose.material3.Card (Card.kt:145)");
                    }
                    if (mutableInteractionSource3 == null) {
                        composer3.startReplaceGroup(1577873102);
                        ComposerKt.sourceInformation(composer3, "147@6742L39");
                        ComposerKt.sourceInformationMarkerStart(composer3, -226195532, "CC(remember):Card.kt#9igjgp");
                        objRememberedValue = composer3.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composer3.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endReplaceGroup();
                        mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        composer3.startReplaceGroup(-226196183);
                        composer3.endReplaceGroup();
                        mutableInteractionSource4 = mutableInteractionSource3;
                    }
                    composer2 = composer3;
                    SurfaceKt.m4326Surfaceo_FOJdg(function0, modifier4, z6, shape4, cardColors4.m2896containerColorvNxB06k$material3(z6), cardColors4.m2897contentColorvNxB06k$material3(z6), 0.0f, cardElevationM2904cardElevationaqJV_2Y.shadowElevation$material3(z6, mutableInteractionSource4, composer3, ((i10 >> 6) & 14) | ((i10 >> 9) & 896)).getValue().m9701unboximpl(), borderStroke5, mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(-1347531112, z3, new Function2() { // from class: androidx.compose.material3.CardKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CardKt.Card$lambda$3(function3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer3, 54), composer2, (i10 & 8190) | ((i10 << 6) & 234881024), 6, 64);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    cardColors3 = cardColors4;
                    cardElevation2 = cardElevationM2904cardElevationaqJV_2Y;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    modifier3 = modifier4;
                    z5 = z6;
                    shape3 = shape4;
                    borderStroke3 = borderStroke5;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    cardElevation2 = cardElevation;
                    modifier3 = modifier2;
                    z5 = z2;
                    shape3 = shape2;
                    cardColors3 = cardColors2;
                    borderStroke3 = borderStroke;
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CardKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CardKt.Card$lambda$4(function0, modifier3, z5, shape3, cardColors3, cardElevation2, borderStroke3, mutableInteractionSource2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 1572864;
            borderStroke2 = borderStroke;
            i8 = i2 & 128;
            if (i8 != 0) {
                i3 |= 12582912;
            } else if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i9 = 8388608;
                } else {
                    i9 = 4194304;
                }
                i3 |= i9;
            }
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i11 = 67108864;
                } else {
                    i11 = 33554432;
                }
                i3 |= i11;
            }
            z3 = true;
            if ((i3 & 38347923) != 38347922) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "139@6397L5,140@6442L12,141@6500L15");
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        shape2 = CardDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 16) != 0) {
                        cardColors4 = CardDefaults.INSTANCE.cardColors(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    } else {
                        cardColors4 = cardColors2;
                    }
                    if ((i2 & 32) != 0) {
                        cardElevationM2904cardElevationaqJV_2Y = CardDefaults.INSTANCE.m2904cardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                        composer3 = composerStartRestartGroup;
                        i3 &= -458753;
                    } else {
                        composer3 = composerStartRestartGroup;
                        cardElevationM2904cardElevationaqJV_2Y = cardElevation;
                    }
                    if (i6 != 0) {
                        borderStroke4 = null;
                    } else {
                        borderStroke4 = borderStroke;
                    }
                    if (i8 != 0) {
                        Modifier modifier10 = modifier2;
                        i10 = i3;
                        mutableInteractionSource3 = null;
                        modifier4 = modifier10;
                        shape4 = shape2;
                        borderStroke5 = borderStroke4;
                        z6 = z2;
                    } else {
                        modifier4 = modifier2;
                        shape4 = shape2;
                        borderStroke5 = borderStroke4;
                        i10 = i3;
                        z6 = z2;
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        shape2 = CardDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 16) != 0) {
                        cardColors4 = CardDefaults.INSTANCE.cardColors(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    } else {
                        cardColors4 = cardColors2;
                    }
                    if ((i2 & 32) != 0) {
                        cardElevationM2904cardElevationaqJV_2Y = CardDefaults.INSTANCE.m2904cardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                        composer3 = composerStartRestartGroup;
                        i3 &= -458753;
                    } else {
                        composer3 = composerStartRestartGroup;
                        cardElevationM2904cardElevationaqJV_2Y = cardElevation;
                    }
                    if (i6 != 0) {
                        borderStroke4 = null;
                    } else {
                        borderStroke4 = borderStroke;
                    }
                    if (i8 != 0) {
                        Modifier modifier11 = modifier2;
                        i10 = i3;
                        mutableInteractionSource3 = null;
                        modifier4 = modifier11;
                        shape4 = shape2;
                        borderStroke5 = borderStroke4;
                        z6 = z2;
                    } else {
                        modifier4 = modifier2;
                        shape4 = shape2;
                        borderStroke5 = borderStroke4;
                        i10 = i3;
                        z6 = z2;
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                }
                composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2136075085, i10, -1, "androidx.compose.material3.Card (Card.kt:145)");
                }
                if (mutableInteractionSource3 == null) {
                    composer3.startReplaceGroup(1577873102);
                    ComposerKt.sourceInformation(composer3, "147@6742L39");
                    ComposerKt.sourceInformationMarkerStart(composer3, -226195532, "CC(remember):Card.kt#9igjgp");
                    objRememberedValue = composer3.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composer3.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endReplaceGroup();
                    mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue;
                } else {
                    composer3.startReplaceGroup(-226196183);
                    composer3.endReplaceGroup();
                    mutableInteractionSource4 = mutableInteractionSource3;
                }
                composer2 = composer3;
                SurfaceKt.m4326Surfaceo_FOJdg(function0, modifier4, z6, shape4, cardColors4.m2896containerColorvNxB06k$material3(z6), cardColors4.m2897contentColorvNxB06k$material3(z6), 0.0f, cardElevationM2904cardElevationaqJV_2Y.shadowElevation$material3(z6, mutableInteractionSource4, composer3, ((i10 >> 6) & 14) | ((i10 >> 9) & 896)).getValue().m9701unboximpl(), borderStroke5, mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(-1347531112, z3, new Function2() { // from class: androidx.compose.material3.CardKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CardKt.Card$lambda$3(function3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer3, 54), composer2, (i10 & 8190) | ((i10 << 6) & 234881024), 6, 64);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                cardColors3 = cardColors4;
                cardElevation2 = cardElevationM2904cardElevationaqJV_2Y;
                mutableInteractionSource2 = mutableInteractionSource3;
                modifier3 = modifier4;
                z5 = z6;
                shape3 = shape4;
                borderStroke3 = borderStroke5;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                cardElevation2 = cardElevation;
                modifier3 = modifier2;
                z5 = z2;
                shape3 = shape2;
                cardColors3 = cardColors2;
                borderStroke3 = borderStroke;
                mutableInteractionSource2 = mutableInteractionSource;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CardKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CardKt.Card$lambda$4(function0, modifier3, z5, shape3, cardColors3, cardElevation2, borderStroke3, mutableInteractionSource2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
                    shape2 = shape;
                    if (composerStartRestartGroup.changed(shape2)) {
                    }
                    i3 |= i13;
                } else {
                    shape2 = shape;
                }
                i3 |= i13;
            } else {
                shape2 = shape;
            }
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    cardColors2 = cardColors;
                    if (composerStartRestartGroup.changed(cardColors2)) {
                    }
                    i3 |= i14;
                } else {
                    cardColors2 = cardColors;
                }
                i3 |= i14;
            } else {
                cardColors2 = cardColors;
            }
            if ((196608 & i) != 0) {
                i3 |= ((i2 & 32) == 0 || !composerStartRestartGroup.changed(cardElevation)) ? 65536 : 131072;
            }
            i6 = i2 & 64;
            if (i6 != 0) {
                if ((1572864 & i) == 0) {
                    borderStroke2 = borderStroke;
                    if (composerStartRestartGroup.changed(borderStroke2)) {
                        i7 = 1048576;
                    } else {
                        i7 = 524288;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 128;
                if (i8 != 0) {
                    i3 |= 12582912;
                } else if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                        i9 = 8388608;
                    } else {
                        i9 = 4194304;
                    }
                    i3 |= i9;
                }
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i11 = 67108864;
                    } else {
                        i11 = 33554432;
                    }
                    i3 |= i11;
                }
                z3 = true;
                if ((i3 & 38347923) != 38347922) {
                    z4 = true;
                } else {
                    z4 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "139@6397L5,140@6442L12,141@6500L15");
                    if ((i & 1) != 0) {
                        if (i12 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            shape2 = CardDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 16) != 0) {
                            cardColors4 = CardDefaults.INSTANCE.cardColors(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        } else {
                            cardColors4 = cardColors2;
                        }
                        if ((i2 & 32) != 0) {
                            cardElevationM2904cardElevationaqJV_2Y = CardDefaults.INSTANCE.m2904cardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                            composer3 = composerStartRestartGroup;
                            i3 &= -458753;
                        } else {
                            composer3 = composerStartRestartGroup;
                            cardElevationM2904cardElevationaqJV_2Y = cardElevation;
                        }
                        if (i6 != 0) {
                            borderStroke4 = null;
                        } else {
                            borderStroke4 = borderStroke;
                        }
                        if (i8 != 0) {
                            Modifier modifier12 = modifier2;
                            i10 = i3;
                            mutableInteractionSource3 = null;
                            modifier4 = modifier12;
                            shape4 = shape2;
                            borderStroke5 = borderStroke4;
                            z6 = z2;
                        } else {
                            modifier4 = modifier2;
                            shape4 = shape2;
                            borderStroke5 = borderStroke4;
                            i10 = i3;
                            z6 = z2;
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            shape2 = CardDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 16) != 0) {
                            cardColors4 = CardDefaults.INSTANCE.cardColors(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        } else {
                            cardColors4 = cardColors2;
                        }
                        if ((i2 & 32) != 0) {
                            cardElevationM2904cardElevationaqJV_2Y = CardDefaults.INSTANCE.m2904cardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                            composer3 = composerStartRestartGroup;
                            i3 &= -458753;
                        } else {
                            composer3 = composerStartRestartGroup;
                            cardElevationM2904cardElevationaqJV_2Y = cardElevation;
                        }
                        if (i6 != 0) {
                            borderStroke4 = null;
                        } else {
                            borderStroke4 = borderStroke;
                        }
                        if (i8 != 0) {
                            Modifier modifier13 = modifier2;
                            i10 = i3;
                            mutableInteractionSource3 = null;
                            modifier4 = modifier13;
                            shape4 = shape2;
                            borderStroke5 = borderStroke4;
                            z6 = z2;
                        } else {
                            modifier4 = modifier2;
                            shape4 = shape2;
                            borderStroke5 = borderStroke4;
                            i10 = i3;
                            z6 = z2;
                            mutableInteractionSource3 = mutableInteractionSource;
                        }
                    }
                    composer3.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(2136075085, i10, -1, "androidx.compose.material3.Card (Card.kt:145)");
                    }
                    if (mutableInteractionSource3 == null) {
                        composer3.startReplaceGroup(1577873102);
                        ComposerKt.sourceInformation(composer3, "147@6742L39");
                        ComposerKt.sourceInformationMarkerStart(composer3, -226195532, "CC(remember):Card.kt#9igjgp");
                        objRememberedValue = composer3.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                            composer3.updateRememberedValue(objRememberedValue);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer3);
                        composer3.endReplaceGroup();
                        mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue;
                    } else {
                        composer3.startReplaceGroup(-226196183);
                        composer3.endReplaceGroup();
                        mutableInteractionSource4 = mutableInteractionSource3;
                    }
                    composer2 = composer3;
                    SurfaceKt.m4326Surfaceo_FOJdg(function0, modifier4, z6, shape4, cardColors4.m2896containerColorvNxB06k$material3(z6), cardColors4.m2897contentColorvNxB06k$material3(z6), 0.0f, cardElevationM2904cardElevationaqJV_2Y.shadowElevation$material3(z6, mutableInteractionSource4, composer3, ((i10 >> 6) & 14) | ((i10 >> 9) & 896)).getValue().m9701unboximpl(), borderStroke5, mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(-1347531112, z3, new Function2() { // from class: androidx.compose.material3.CardKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CardKt.Card$lambda$3(function3, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composer3, 54), composer2, (i10 & 8190) | ((i10 << 6) & 234881024), 6, 64);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    cardColors3 = cardColors4;
                    cardElevation2 = cardElevationM2904cardElevationaqJV_2Y;
                    mutableInteractionSource2 = mutableInteractionSource3;
                    modifier3 = modifier4;
                    z5 = z6;
                    shape3 = shape4;
                    borderStroke3 = borderStroke5;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    cardElevation2 = cardElevation;
                    modifier3 = modifier2;
                    z5 = z2;
                    shape3 = shape2;
                    cardColors3 = cardColors2;
                    borderStroke3 = borderStroke;
                    mutableInteractionSource2 = mutableInteractionSource;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CardKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CardKt.Card$lambda$4(function0, modifier3, z5, shape3, cardColors3, cardElevation2, borderStroke3, mutableInteractionSource2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 1572864;
            borderStroke2 = borderStroke;
            i8 = i2 & 128;
            if (i8 != 0) {
                i3 |= 12582912;
            } else if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i9 = 8388608;
                } else {
                    i9 = 4194304;
                }
                i3 |= i9;
            }
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i11 = 67108864;
                } else {
                    i11 = 33554432;
                }
                i3 |= i11;
            }
            z3 = true;
            if ((i3 & 38347923) != 38347922) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "139@6397L5,140@6442L12,141@6500L15");
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        shape2 = CardDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 16) != 0) {
                        cardColors4 = CardDefaults.INSTANCE.cardColors(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    } else {
                        cardColors4 = cardColors2;
                    }
                    if ((i2 & 32) != 0) {
                        cardElevationM2904cardElevationaqJV_2Y = CardDefaults.INSTANCE.m2904cardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                        composer3 = composerStartRestartGroup;
                        i3 &= -458753;
                    } else {
                        composer3 = composerStartRestartGroup;
                        cardElevationM2904cardElevationaqJV_2Y = cardElevation;
                    }
                    if (i6 != 0) {
                        borderStroke4 = null;
                    } else {
                        borderStroke4 = borderStroke;
                    }
                    if (i8 != 0) {
                        Modifier modifier14 = modifier2;
                        i10 = i3;
                        mutableInteractionSource3 = null;
                        modifier4 = modifier14;
                        shape4 = shape2;
                        borderStroke5 = borderStroke4;
                        z6 = z2;
                    } else {
                        modifier4 = modifier2;
                        shape4 = shape2;
                        borderStroke5 = borderStroke4;
                        i10 = i3;
                        z6 = z2;
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        shape2 = CardDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 16) != 0) {
                        cardColors4 = CardDefaults.INSTANCE.cardColors(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    } else {
                        cardColors4 = cardColors2;
                    }
                    if ((i2 & 32) != 0) {
                        cardElevationM2904cardElevationaqJV_2Y = CardDefaults.INSTANCE.m2904cardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                        composer3 = composerStartRestartGroup;
                        i3 &= -458753;
                    } else {
                        composer3 = composerStartRestartGroup;
                        cardElevationM2904cardElevationaqJV_2Y = cardElevation;
                    }
                    if (i6 != 0) {
                        borderStroke4 = null;
                    } else {
                        borderStroke4 = borderStroke;
                    }
                    if (i8 != 0) {
                        Modifier modifier15 = modifier2;
                        i10 = i3;
                        mutableInteractionSource3 = null;
                        modifier4 = modifier15;
                        shape4 = shape2;
                        borderStroke5 = borderStroke4;
                        z6 = z2;
                    } else {
                        modifier4 = modifier2;
                        shape4 = shape2;
                        borderStroke5 = borderStroke4;
                        i10 = i3;
                        z6 = z2;
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                }
                composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2136075085, i10, -1, "androidx.compose.material3.Card (Card.kt:145)");
                }
                if (mutableInteractionSource3 == null) {
                    composer3.startReplaceGroup(1577873102);
                    ComposerKt.sourceInformation(composer3, "147@6742L39");
                    ComposerKt.sourceInformationMarkerStart(composer3, -226195532, "CC(remember):Card.kt#9igjgp");
                    objRememberedValue = composer3.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composer3.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endReplaceGroup();
                    mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue;
                } else {
                    composer3.startReplaceGroup(-226196183);
                    composer3.endReplaceGroup();
                    mutableInteractionSource4 = mutableInteractionSource3;
                }
                composer2 = composer3;
                SurfaceKt.m4326Surfaceo_FOJdg(function0, modifier4, z6, shape4, cardColors4.m2896containerColorvNxB06k$material3(z6), cardColors4.m2897contentColorvNxB06k$material3(z6), 0.0f, cardElevationM2904cardElevationaqJV_2Y.shadowElevation$material3(z6, mutableInteractionSource4, composer3, ((i10 >> 6) & 14) | ((i10 >> 9) & 896)).getValue().m9701unboximpl(), borderStroke5, mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(-1347531112, z3, new Function2() { // from class: androidx.compose.material3.CardKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CardKt.Card$lambda$3(function3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer3, 54), composer2, (i10 & 8190) | ((i10 << 6) & 234881024), 6, 64);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                cardColors3 = cardColors4;
                cardElevation2 = cardElevationM2904cardElevationaqJV_2Y;
                mutableInteractionSource2 = mutableInteractionSource3;
                modifier3 = modifier4;
                z5 = z6;
                shape3 = shape4;
                borderStroke3 = borderStroke5;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                cardElevation2 = cardElevation;
                modifier3 = modifier2;
                z5 = z2;
                shape3 = shape2;
                cardColors3 = cardColors2;
                borderStroke3 = borderStroke;
                mutableInteractionSource2 = mutableInteractionSource;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CardKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CardKt.Card$lambda$4(function0, modifier3, z5, shape3, cardColors3, cardElevation2, borderStroke3, mutableInteractionSource2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        z2 = z;
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                shape2 = shape;
                if (composerStartRestartGroup.changed(shape2)) {
                }
                i3 |= i13;
            } else {
                shape2 = shape;
            }
            i3 |= i13;
        } else {
            shape2 = shape;
        }
        if ((i & 24576) == 0) {
            if ((i2 & 16) == 0) {
                cardColors2 = cardColors;
                if (composerStartRestartGroup.changed(cardColors2)) {
                }
                i3 |= i14;
            } else {
                cardColors2 = cardColors;
            }
            i3 |= i14;
        } else {
            cardColors2 = cardColors;
        }
        if ((196608 & i) != 0) {
            i3 |= ((i2 & 32) == 0 || !composerStartRestartGroup.changed(cardElevation)) ? 65536 : 131072;
        }
        i6 = i2 & 64;
        if (i6 != 0) {
            if ((1572864 & i) == 0) {
                borderStroke2 = borderStroke;
                if (composerStartRestartGroup.changed(borderStroke2)) {
                    i7 = 1048576;
                } else {
                    i7 = 524288;
                }
                i3 |= i7;
            }
            i8 = i2 & 128;
            if (i8 != 0) {
                i3 |= 12582912;
            } else if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                    i9 = 8388608;
                } else {
                    i9 = 4194304;
                }
                i3 |= i9;
            }
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i11 = 67108864;
                } else {
                    i11 = 33554432;
                }
                i3 |= i11;
            }
            z3 = true;
            if ((i3 & 38347923) != 38347922) {
                z4 = true;
            } else {
                z4 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "139@6397L5,140@6442L12,141@6500L15");
                if ((i & 1) != 0) {
                    if (i12 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        shape2 = CardDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 16) != 0) {
                        cardColors4 = CardDefaults.INSTANCE.cardColors(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    } else {
                        cardColors4 = cardColors2;
                    }
                    if ((i2 & 32) != 0) {
                        cardElevationM2904cardElevationaqJV_2Y = CardDefaults.INSTANCE.m2904cardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                        composer3 = composerStartRestartGroup;
                        i3 &= -458753;
                    } else {
                        composer3 = composerStartRestartGroup;
                        cardElevationM2904cardElevationaqJV_2Y = cardElevation;
                    }
                    if (i6 != 0) {
                        borderStroke4 = null;
                    } else {
                        borderStroke4 = borderStroke;
                    }
                    if (i8 != 0) {
                        Modifier modifier16 = modifier2;
                        i10 = i3;
                        mutableInteractionSource3 = null;
                        modifier4 = modifier16;
                        shape4 = shape2;
                        borderStroke5 = borderStroke4;
                        z6 = z2;
                    } else {
                        modifier4 = modifier2;
                        shape4 = shape2;
                        borderStroke5 = borderStroke4;
                        i10 = i3;
                        z6 = z2;
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        shape2 = CardDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 16) != 0) {
                        cardColors4 = CardDefaults.INSTANCE.cardColors(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    } else {
                        cardColors4 = cardColors2;
                    }
                    if ((i2 & 32) != 0) {
                        cardElevationM2904cardElevationaqJV_2Y = CardDefaults.INSTANCE.m2904cardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                        composer3 = composerStartRestartGroup;
                        i3 &= -458753;
                    } else {
                        composer3 = composerStartRestartGroup;
                        cardElevationM2904cardElevationaqJV_2Y = cardElevation;
                    }
                    if (i6 != 0) {
                        borderStroke4 = null;
                    } else {
                        borderStroke4 = borderStroke;
                    }
                    if (i8 != 0) {
                        Modifier modifier17 = modifier2;
                        i10 = i3;
                        mutableInteractionSource3 = null;
                        modifier4 = modifier17;
                        shape4 = shape2;
                        borderStroke5 = borderStroke4;
                        z6 = z2;
                    } else {
                        modifier4 = modifier2;
                        shape4 = shape2;
                        borderStroke5 = borderStroke4;
                        i10 = i3;
                        z6 = z2;
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                }
                composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2136075085, i10, -1, "androidx.compose.material3.Card (Card.kt:145)");
                }
                if (mutableInteractionSource3 == null) {
                    composer3.startReplaceGroup(1577873102);
                    ComposerKt.sourceInformation(composer3, "147@6742L39");
                    ComposerKt.sourceInformationMarkerStart(composer3, -226195532, "CC(remember):Card.kt#9igjgp");
                    objRememberedValue = composer3.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                        composer3.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    composer3.endReplaceGroup();
                    mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue;
                } else {
                    composer3.startReplaceGroup(-226196183);
                    composer3.endReplaceGroup();
                    mutableInteractionSource4 = mutableInteractionSource3;
                }
                composer2 = composer3;
                SurfaceKt.m4326Surfaceo_FOJdg(function0, modifier4, z6, shape4, cardColors4.m2896containerColorvNxB06k$material3(z6), cardColors4.m2897contentColorvNxB06k$material3(z6), 0.0f, cardElevationM2904cardElevationaqJV_2Y.shadowElevation$material3(z6, mutableInteractionSource4, composer3, ((i10 >> 6) & 14) | ((i10 >> 9) & 896)).getValue().m9701unboximpl(), borderStroke5, mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(-1347531112, z3, new Function2() { // from class: androidx.compose.material3.CardKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CardKt.Card$lambda$3(function3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composer3, 54), composer2, (i10 & 8190) | ((i10 << 6) & 234881024), 6, 64);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                cardColors3 = cardColors4;
                cardElevation2 = cardElevationM2904cardElevationaqJV_2Y;
                mutableInteractionSource2 = mutableInteractionSource3;
                modifier3 = modifier4;
                z5 = z6;
                shape3 = shape4;
                borderStroke3 = borderStroke5;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                cardElevation2 = cardElevation;
                modifier3 = modifier2;
                z5 = z2;
                shape3 = shape2;
                cardColors3 = cardColors2;
                borderStroke3 = borderStroke;
                mutableInteractionSource2 = mutableInteractionSource;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CardKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CardKt.Card$lambda$4(function0, modifier3, z5, shape3, cardColors3, cardElevation2, borderStroke3, mutableInteractionSource2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 1572864;
        borderStroke2 = borderStroke;
        i8 = i2 & 128;
        if (i8 != 0) {
            i3 |= 12582912;
        } else if ((i & 12582912) == 0) {
            if (composerStartRestartGroup.changed(mutableInteractionSource)) {
                i9 = 8388608;
            } else {
                i9 = 4194304;
            }
            i3 |= i9;
        }
        if ((i & 100663296) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i11 = 67108864;
            } else {
                i11 = 33554432;
            }
            i3 |= i11;
        }
        z3 = true;
        if ((i3 & 38347923) != 38347922) {
            z4 = true;
        } else {
            z4 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z4, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "139@6397L5,140@6442L12,141@6500L15");
            if ((i & 1) != 0) {
                if (i12 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    z2 = true;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    shape2 = CardDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                }
                if ((i2 & 16) != 0) {
                    cardColors4 = CardDefaults.INSTANCE.cardColors(composerStartRestartGroup, 6);
                    i3 &= -57345;
                } else {
                    cardColors4 = cardColors2;
                }
                if ((i2 & 32) != 0) {
                    cardElevationM2904cardElevationaqJV_2Y = CardDefaults.INSTANCE.m2904cardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                    composer3 = composerStartRestartGroup;
                    i3 &= -458753;
                } else {
                    composer3 = composerStartRestartGroup;
                    cardElevationM2904cardElevationaqJV_2Y = cardElevation;
                }
                if (i6 != 0) {
                    borderStroke4 = null;
                } else {
                    borderStroke4 = borderStroke;
                }
                if (i8 != 0) {
                    Modifier modifier18 = modifier2;
                    i10 = i3;
                    mutableInteractionSource3 = null;
                    modifier4 = modifier18;
                    shape4 = shape2;
                    borderStroke5 = borderStroke4;
                    z6 = z2;
                } else {
                    modifier4 = modifier2;
                    shape4 = shape2;
                    borderStroke5 = borderStroke4;
                    i10 = i3;
                    z6 = z2;
                    mutableInteractionSource3 = mutableInteractionSource;
                }
            } else {
                if (i12 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    z2 = true;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    shape2 = CardDefaults.INSTANCE.getShape(composerStartRestartGroup, 6);
                }
                if ((i2 & 16) != 0) {
                    cardColors4 = CardDefaults.INSTANCE.cardColors(composerStartRestartGroup, 6);
                    i3 &= -57345;
                } else {
                    cardColors4 = cardColors2;
                }
                if ((i2 & 32) != 0) {
                    cardElevationM2904cardElevationaqJV_2Y = CardDefaults.INSTANCE.m2904cardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                    composer3 = composerStartRestartGroup;
                    i3 &= -458753;
                } else {
                    composer3 = composerStartRestartGroup;
                    cardElevationM2904cardElevationaqJV_2Y = cardElevation;
                }
                if (i6 != 0) {
                    borderStroke4 = null;
                } else {
                    borderStroke4 = borderStroke;
                }
                if (i8 != 0) {
                    Modifier modifier19 = modifier2;
                    i10 = i3;
                    mutableInteractionSource3 = null;
                    modifier4 = modifier19;
                    shape4 = shape2;
                    borderStroke5 = borderStroke4;
                    z6 = z2;
                } else {
                    modifier4 = modifier2;
                    shape4 = shape2;
                    borderStroke5 = borderStroke4;
                    i10 = i3;
                    z6 = z2;
                    mutableInteractionSource3 = mutableInteractionSource;
                }
            }
            composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2136075085, i10, -1, "androidx.compose.material3.Card (Card.kt:145)");
            }
            if (mutableInteractionSource3 == null) {
                composer3.startReplaceGroup(1577873102);
                ComposerKt.sourceInformation(composer3, "147@6742L39");
                ComposerKt.sourceInformationMarkerStart(composer3, -226195532, "CC(remember):Card.kt#9igjgp");
                objRememberedValue = composer3.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = InteractionSourceKt.MutableInteractionSource();
                    composer3.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer3);
                composer3.endReplaceGroup();
                mutableInteractionSource4 = (MutableInteractionSource) objRememberedValue;
            } else {
                composer3.startReplaceGroup(-226196183);
                composer3.endReplaceGroup();
                mutableInteractionSource4 = mutableInteractionSource3;
            }
            composer2 = composer3;
            SurfaceKt.m4326Surfaceo_FOJdg(function0, modifier4, z6, shape4, cardColors4.m2896containerColorvNxB06k$material3(z6), cardColors4.m2897contentColorvNxB06k$material3(z6), 0.0f, cardElevationM2904cardElevationaqJV_2Y.shadowElevation$material3(z6, mutableInteractionSource4, composer3, ((i10 >> 6) & 14) | ((i10 >> 9) & 896)).getValue().m9701unboximpl(), borderStroke5, mutableInteractionSource4, ComposableLambdaKt.rememberComposableLambda(-1347531112, z3, new Function2() { // from class: androidx.compose.material3.CardKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CardKt.Card$lambda$3(function3, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer3, 54), composer2, (i10 & 8190) | ((i10 << 6) & 234881024), 6, 64);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            cardColors3 = cardColors4;
            cardElevation2 = cardElevationM2904cardElevationaqJV_2Y;
            mutableInteractionSource2 = mutableInteractionSource3;
            modifier3 = modifier4;
            z5 = z6;
            shape3 = shape4;
            borderStroke3 = borderStroke5;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            cardElevation2 = cardElevation;
            modifier3 = modifier2;
            z5 = z2;
            shape3 = shape2;
            cardColors3 = cardColors2;
            borderStroke3 = borderStroke;
            mutableInteractionSource2 = mutableInteractionSource;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CardKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CardKt.Card$lambda$4(function0, modifier3, z5, shape3, cardColors3, cardElevation2, borderStroke3, mutableInteractionSource2, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit Card$lambda$3(Function3 function3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C159@7177L25:Card.kt#uh7d8r");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1347531112, i, -1, "androidx.compose.material3.Card.<anonymous> (Card.kt:159)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, -483455358, "CC(Column)P(2,3,1)87@4442L61,88@4508L133:Column.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1323940314, "CC(Layout)P(!1,2)79@3206L23,82@3357L359:Layout.kt#80mrfh");
            int currentCompositeKeyHash = ComposablesKt.getCurrentCompositeKeyHash(composer, 0);
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, companion);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Function2<ComposeUiNode, Integer, Unit> setCompositeKeyHash = ComposeUiNode.INSTANCE.getSetCompositeKeyHash();
            if (composerM6062constructorimpl.getInserting() || !Intrinsics.areEqual(composerM6062constructorimpl.rememberedValue(), Integer.valueOf(currentCompositeKeyHash))) {
                composerM6062constructorimpl.updateRememberedValue(Integer.valueOf(currentCompositeKeyHash));
                composerM6062constructorimpl.apply(Integer.valueOf(currentCompositeKeyHash), setCompositeKeyHash);
            }
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, -384672921, "C89@4556L9:Column.kt#2w3rfo");
            function3.invoke(ColumnScopeInstance.INSTANCE, composer, 6);
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

    public static final void ElevatedCard(Modifier modifier, Shape shape, CardColors cardColors, CardElevation cardElevation, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        Shape shape2;
        CardColors cardColors2;
        CardElevation cardElevation2;
        Composer composer2;
        final Modifier modifier3;
        final Shape shape3;
        final CardColors cardColors3;
        final CardElevation cardElevation3;
        Shape elevatedShape;
        CardColors cardColorsElevatedCardColors;
        Composer composer3;
        Shape shape4;
        CardColors cardColors4;
        CardElevation cardElevationM2906elevatedCardElevationaqJV_2Y;
        Modifier modifier4;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1464672362);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ElevatedCard)N(modifier,shape,colors,elevation,content)197@8874L169:Card.kt#uh7d8r");
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
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                shape2 = shape;
                int i5 = composerStartRestartGroup.changed(shape2) ? 32 : 16;
                i3 |= i5;
            } else {
                shape2 = shape;
            }
            i3 |= i5;
        } else {
            shape2 = shape;
        }
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                cardColors2 = cardColors;
                int i6 = composerStartRestartGroup.changed(cardColors2) ? 256 : 128;
                i3 |= i6;
            } else {
                cardColors2 = cardColors;
            }
            i3 |= i6;
        } else {
            cardColors2 = cardColors;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                cardElevation2 = cardElevation;
                int i7 = composerStartRestartGroup.changed(cardElevation2) ? 2048 : 1024;
                i3 |= i7;
            } else {
                cardElevation2 = cardElevation;
            }
            i3 |= i7;
        } else {
            cardElevation2 = cardElevation;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function3) ? 16384 : 8192;
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "192@8673L13,193@8726L20,194@8792L23");
            if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                }
                shape4 = shape2;
                cardColors4 = cardColors2;
                cardElevationM2906elevatedCardElevationaqJV_2Y = cardElevation2;
                composer3 = composerStartRestartGroup;
                modifier4 = modifier2;
            } else {
                Modifier.Companion companion = i4 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i2 & 2) != 0) {
                    elevatedShape = CardDefaults.INSTANCE.getElevatedShape(composerStartRestartGroup, 6);
                    i3 &= -113;
                } else {
                    elevatedShape = shape2;
                }
                if ((i2 & 4) != 0) {
                    cardColorsElevatedCardColors = CardDefaults.INSTANCE.elevatedCardColors(composerStartRestartGroup, 6);
                    i3 &= -897;
                } else {
                    cardColorsElevatedCardColors = cardColors2;
                }
                if ((i2 & 8) != 0) {
                    composer3 = composerStartRestartGroup;
                    i3 &= -7169;
                    modifier4 = companion;
                    shape4 = elevatedShape;
                    cardColors4 = cardColorsElevatedCardColors;
                    cardElevationM2906elevatedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m2906elevatedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composer3, 1572864, 63);
                } else {
                    composer3 = composerStartRestartGroup;
                    shape4 = elevatedShape;
                    cardColors4 = cardColorsElevatedCardColors;
                    cardElevationM2906elevatedCardElevationaqJV_2Y = cardElevation2;
                    modifier4 = companion;
                }
            }
            composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1464672362, i3, -1, "androidx.compose.material3.ElevatedCard (Card.kt:197)");
            }
            Composer composer4 = composer3;
            Card(modifier4, shape4, cardColors4, cardElevationM2906elevatedCardElevationaqJV_2Y, null, function3, composer4, (i3 & 14) | 24576 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | ((i3 << 3) & 458752), 0);
            composer2 = composer4;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            shape3 = shape4;
            cardColors3 = cardColors4;
            cardElevation3 = cardElevationM2906elevatedCardElevationaqJV_2Y;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
            shape3 = shape2;
            cardColors3 = cardColors2;
            cardElevation3 = cardElevation2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CardKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CardKt.ElevatedCard$lambda$0(modifier3, shape3, cardColors3, cardElevation3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:105:0x0131 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:106:0x0133  */
    /* JADX WARN: Code duplicated, block: B:108:0x013a  */
    /* JADX WARN: Code duplicated, block: B:111:0x0141  */
    /* JADX WARN: Code duplicated, block: B:114:0x014e  */
    /* JADX WARN: Code duplicated, block: B:115:0x0156  */
    /* JADX WARN: Code duplicated, block: B:118:0x015b  */
    /* JADX WARN: Code duplicated, block: B:119:0x0172  */
    /* JADX WARN: Code duplicated, block: B:121:0x0176  */
    /* JADX WARN: Code duplicated, block: B:122:0x0180  */
    /* JADX WARN: Code duplicated, block: B:126:0x0192  */
    /* JADX WARN: Code duplicated, block: B:129:0x01cd  */
    /* JADX WARN: Code duplicated, block: B:131:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:134:0x01e9  */
    /* JADX WARN: Code duplicated, block: B:136:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0044  */
    /* JADX WARN: Code duplicated, block: B:24:0x0047  */
    /* JADX WARN: Code duplicated, block: B:26:0x004b  */
    /* JADX WARN: Code duplicated, block: B:28:0x0053  */
    /* JADX WARN: Code duplicated, block: B:29:0x0056  */
    /* JADX WARN: Code duplicated, block: B:34:0x0060  */
    /* JADX WARN: Code duplicated, block: B:36:0x0064  */
    /* JADX WARN: Code duplicated, block: B:38:0x006c  */
    /* JADX WARN: Code duplicated, block: B:39:0x006f  */
    /* JADX WARN: Code duplicated, block: B:42:0x0075  */
    /* JADX WARN: Code duplicated, block: B:45:0x007b  */
    /* JADX WARN: Code duplicated, block: B:47:0x007f  */
    /* JADX WARN: Code duplicated, block: B:49:0x0087  */
    /* JADX WARN: Code duplicated, block: B:50:0x008a  */
    /* JADX WARN: Code duplicated, block: B:53:0x0090  */
    /* JADX WARN: Code duplicated, block: B:56:0x0097  */
    /* JADX WARN: Code duplicated, block: B:58:0x009b  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a3  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:64:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:68:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:70:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:73:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:78:0x00d1  */
    /* JADX WARN: Code duplicated, block: B:80:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:81:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:83:0x00e0  */
    /* JADX WARN: Code duplicated, block: B:86:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:87:0x00f0  */
    /* JADX WARN: Code duplicated, block: B:90:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:92:0x010b  */
    public static final void ElevatedCard(final Function0<Unit> function0, Modifier modifier, boolean z, Shape shape, CardColors cardColors, CardElevation cardElevation, MutableInteractionSource mutableInteractionSource, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Function0<Unit> function1;
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        int i5;
        Shape elevatedShape;
        CardColors cardColors2;
        CardElevation cardElevationM2906elevatedCardElevationaqJV_2Y;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        int i7;
        boolean z3;
        Composer composer2;
        final Modifier modifier3;
        final boolean z4;
        final Shape shape2;
        final CardColors cardColors3;
        final CardElevation cardElevation2;
        final MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        CardColors cardColorsElevatedCardColors;
        Composer composer3;
        MutableInteractionSource mutableInteractionSource4;
        Modifier modifier4;
        int i8;
        Composer composerStartRestartGroup = composer.startRestartGroup(-129138571);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ElevatedCard)N(onClick,modifier,enabled,shape,colors,elevation,interactionSource,content)250@11337L270:Card.kt#uh7d8r");
        if ((i & 6) == 0) {
            function1 = function0;
            i3 = (composerStartRestartGroup.changedInstance(function1) ? 4 : 2) | i;
        } else {
            function1 = function0;
            i3 = i;
        }
        int i9 = i2 & 2;
        if (i9 == 0) {
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
                        elevatedShape = shape;
                        int i10 = composerStartRestartGroup.changed(elevatedShape) ? 2048 : 1024;
                        i3 |= i10;
                    } else {
                        elevatedShape = shape;
                    }
                    i3 |= i10;
                } else {
                    elevatedShape = shape;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        cardColors2 = cardColors;
                        int i11 = composerStartRestartGroup.changed(cardColors2) ? 16384 : 8192;
                        i3 |= i11;
                    } else {
                        cardColors2 = cardColors;
                    }
                    i3 |= i11;
                } else {
                    cardColors2 = cardColors;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        cardElevationM2906elevatedCardElevationaqJV_2Y = cardElevation;
                        int i12 = composerStartRestartGroup.changed(cardElevationM2906elevatedCardElevationaqJV_2Y) ? 131072 : 65536;
                        i3 |= i12;
                    } else {
                        cardElevationM2906elevatedCardElevationaqJV_2Y = cardElevation;
                    }
                    i3 |= i12;
                } else {
                    cardElevationM2906elevatedCardElevationaqJV_2Y = cardElevation;
                }
                i6 = i2 & 64;
                if (i6 != 0) {
                    if ((i & 1572864) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                            i7 = 1048576;
                        } else {
                            i7 = 524288;
                        }
                        i3 |= i7;
                    }
                    if ((12582912 & i) != 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i8 = 8388608;
                        } else {
                            i8 = 4194304;
                        }
                        i3 |= i8;
                    }
                    if ((4793491 & i3) != 4793490) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "244@11079L13,245@11132L20,246@11198L23");
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i9 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                                elevatedShape = CardDefaults.INSTANCE.getElevatedShape(composerStartRestartGroup, 6);
                            }
                            if ((i2 & 16) != 0) {
                                cardColorsElevatedCardColors = CardDefaults.INSTANCE.elevatedCardColors(composerStartRestartGroup, 6);
                                i3 &= -57345;
                            } else {
                                cardColorsElevatedCardColors = cardColors2;
                            }
                            if ((i2 & 32) != 0) {
                                composer3 = composerStartRestartGroup;
                                i3 &= -458753;
                                cardElevationM2906elevatedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m2906elevatedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composer3, 1572864, 63);
                            } else {
                                composer3 = composerStartRestartGroup;
                            }
                            if (i6 != 0) {
                                mutableInteractionSource4 = null;
                            } else {
                                mutableInteractionSource4 = mutableInteractionSource;
                            }
                            modifier4 = modifier2;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                            }
                            composer3 = composerStartRestartGroup;
                            elevatedShape = elevatedShape;
                            cardColorsElevatedCardColors = cardColors2;
                            cardElevationM2906elevatedCardElevationaqJV_2Y = cardElevationM2906elevatedCardElevationaqJV_2Y;
                            mutableInteractionSource4 = mutableInteractionSource2;
                            modifier4 = modifier2;
                            z2 = z2;
                        }
                        composer3.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-129138571, i3, -1, "androidx.compose.material3.ElevatedCard (Card.kt:250)");
                        }
                        int i13 = i3 << 3;
                        Card(function1, modifier4, z2, elevatedShape, cardColorsElevatedCardColors, cardElevationM2906elevatedCardElevationaqJV_2Y, null, mutableInteractionSource4, function3, composer3, (i3 & 14) | 1572864 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (29360128 & i13) | (i13 & 234881024), 0);
                        MutableInteractionSource mutableInteractionSource5 = mutableInteractionSource4;
                        composer2 = composer3;
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        mutableInteractionSource3 = mutableInteractionSource5;
                        modifier3 = modifier4;
                        z4 = z2;
                        shape2 = elevatedShape;
                        cardColors3 = cardColorsElevatedCardColors;
                        cardElevation2 = cardElevationM2906elevatedCardElevationaqJV_2Y;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier3 = modifier2;
                        z4 = z2;
                        shape2 = elevatedShape;
                        cardColors3 = cardColors2;
                        cardElevation2 = cardElevationM2906elevatedCardElevationaqJV_2Y;
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CardKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CardKt.ElevatedCard$lambda$1(function0, modifier3, z4, shape2, cardColors3, cardElevation2, mutableInteractionSource3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 1572864;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((12582912 & i) != 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i8 = 8388608;
                    } else {
                        i8 = 4194304;
                    }
                    i3 |= i8;
                }
                if ((4793491 & i3) != 4793490) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "244@11079L13,245@11132L20,246@11198L23");
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            elevatedShape = CardDefaults.INSTANCE.getElevatedShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 16) != 0) {
                            cardColorsElevatedCardColors = CardDefaults.INSTANCE.elevatedCardColors(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        } else {
                            cardColorsElevatedCardColors = cardColors2;
                        }
                        if ((i2 & 32) != 0) {
                            composer3 = composerStartRestartGroup;
                            i3 &= -458753;
                            cardElevationM2906elevatedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m2906elevatedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composer3, 1572864, 63);
                        } else {
                            composer3 = composerStartRestartGroup;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource;
                        }
                        modifier4 = modifier2;
                    } else {
                        if (i9 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            elevatedShape = CardDefaults.INSTANCE.getElevatedShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 16) != 0) {
                            cardColorsElevatedCardColors = CardDefaults.INSTANCE.elevatedCardColors(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        } else {
                            cardColorsElevatedCardColors = cardColors2;
                        }
                        if ((i2 & 32) != 0) {
                            composer3 = composerStartRestartGroup;
                            i3 &= -458753;
                            cardElevationM2906elevatedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m2906elevatedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composer3, 1572864, 63);
                        } else {
                            composer3 = composerStartRestartGroup;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource;
                        }
                        modifier4 = modifier2;
                    }
                    composer3.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-129138571, i3, -1, "androidx.compose.material3.ElevatedCard (Card.kt:250)");
                    }
                    int i14 = i3 << 3;
                    Card(function1, modifier4, z2, elevatedShape, cardColorsElevatedCardColors, cardElevationM2906elevatedCardElevationaqJV_2Y, null, mutableInteractionSource4, function3, composer3, (i3 & 14) | 1572864 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (29360128 & i14) | (i14 & 234881024), 0);
                    MutableInteractionSource mutableInteractionSource6 = mutableInteractionSource4;
                    composer2 = composer3;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource3 = mutableInteractionSource6;
                    modifier3 = modifier4;
                    z4 = z2;
                    shape2 = elevatedShape;
                    cardColors3 = cardColorsElevatedCardColors;
                    cardElevation2 = cardElevationM2906elevatedCardElevationaqJV_2Y;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    z4 = z2;
                    shape2 = elevatedShape;
                    cardColors3 = cardColors2;
                    cardElevation2 = cardElevationM2906elevatedCardElevationaqJV_2Y;
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CardKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CardKt.ElevatedCard$lambda$1(function0, modifier3, z4, shape2, cardColors3, cardElevation2, mutableInteractionSource3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 384;
            z2 = z;
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    elevatedShape = shape;
                    if (composerStartRestartGroup.changed(elevatedShape)) {
                    }
                    i3 |= i10;
                } else {
                    elevatedShape = shape;
                }
                i3 |= i10;
            } else {
                elevatedShape = shape;
            }
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    cardColors2 = cardColors;
                    if (composerStartRestartGroup.changed(cardColors2)) {
                    }
                    i3 |= i11;
                } else {
                    cardColors2 = cardColors;
                }
                i3 |= i11;
            } else {
                cardColors2 = cardColors;
            }
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    cardElevationM2906elevatedCardElevationaqJV_2Y = cardElevation;
                    if (composerStartRestartGroup.changed(cardElevationM2906elevatedCardElevationaqJV_2Y)) {
                    }
                    i3 |= i12;
                } else {
                    cardElevationM2906elevatedCardElevationaqJV_2Y = cardElevation;
                }
                i3 |= i12;
            } else {
                cardElevationM2906elevatedCardElevationaqJV_2Y = cardElevation;
            }
            i6 = i2 & 64;
            if (i6 != 0) {
                if ((i & 1572864) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i7 = 1048576;
                    } else {
                        i7 = 524288;
                    }
                    i3 |= i7;
                }
                if ((12582912 & i) != 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i8 = 8388608;
                    } else {
                        i8 = 4194304;
                    }
                    i3 |= i8;
                }
                if ((4793491 & i3) != 4793490) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "244@11079L13,245@11132L20,246@11198L23");
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            elevatedShape = CardDefaults.INSTANCE.getElevatedShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 16) != 0) {
                            cardColorsElevatedCardColors = CardDefaults.INSTANCE.elevatedCardColors(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        } else {
                            cardColorsElevatedCardColors = cardColors2;
                        }
                        if ((i2 & 32) != 0) {
                            composer3 = composerStartRestartGroup;
                            i3 &= -458753;
                            cardElevationM2906elevatedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m2906elevatedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composer3, 1572864, 63);
                        } else {
                            composer3 = composerStartRestartGroup;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource;
                        }
                        modifier4 = modifier2;
                    } else {
                        if (i9 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            elevatedShape = CardDefaults.INSTANCE.getElevatedShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 16) != 0) {
                            cardColorsElevatedCardColors = CardDefaults.INSTANCE.elevatedCardColors(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        } else {
                            cardColorsElevatedCardColors = cardColors2;
                        }
                        if ((i2 & 32) != 0) {
                            composer3 = composerStartRestartGroup;
                            i3 &= -458753;
                            cardElevationM2906elevatedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m2906elevatedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composer3, 1572864, 63);
                        } else {
                            composer3 = composerStartRestartGroup;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource;
                        }
                        modifier4 = modifier2;
                    }
                    composer3.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-129138571, i3, -1, "androidx.compose.material3.ElevatedCard (Card.kt:250)");
                    }
                    int i15 = i3 << 3;
                    Card(function1, modifier4, z2, elevatedShape, cardColorsElevatedCardColors, cardElevationM2906elevatedCardElevationaqJV_2Y, null, mutableInteractionSource4, function3, composer3, (i3 & 14) | 1572864 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (29360128 & i15) | (i15 & 234881024), 0);
                    MutableInteractionSource mutableInteractionSource7 = mutableInteractionSource4;
                    composer2 = composer3;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource3 = mutableInteractionSource7;
                    modifier3 = modifier4;
                    z4 = z2;
                    shape2 = elevatedShape;
                    cardColors3 = cardColorsElevatedCardColors;
                    cardElevation2 = cardElevationM2906elevatedCardElevationaqJV_2Y;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    z4 = z2;
                    shape2 = elevatedShape;
                    cardColors3 = cardColors2;
                    cardElevation2 = cardElevationM2906elevatedCardElevationaqJV_2Y;
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CardKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CardKt.ElevatedCard$lambda$1(function0, modifier3, z4, shape2, cardColors3, cardElevation2, mutableInteractionSource3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 1572864;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((12582912 & i) != 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i8 = 8388608;
                } else {
                    i8 = 4194304;
                }
                i3 |= i8;
            }
            if ((4793491 & i3) != 4793490) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "244@11079L13,245@11132L20,246@11198L23");
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        elevatedShape = CardDefaults.INSTANCE.getElevatedShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 16) != 0) {
                        cardColorsElevatedCardColors = CardDefaults.INSTANCE.elevatedCardColors(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    } else {
                        cardColorsElevatedCardColors = cardColors2;
                    }
                    if ((i2 & 32) != 0) {
                        composer3 = composerStartRestartGroup;
                        i3 &= -458753;
                        cardElevationM2906elevatedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m2906elevatedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composer3, 1572864, 63);
                    } else {
                        composer3 = composerStartRestartGroup;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource;
                    }
                    modifier4 = modifier2;
                } else {
                    if (i9 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        elevatedShape = CardDefaults.INSTANCE.getElevatedShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 16) != 0) {
                        cardColorsElevatedCardColors = CardDefaults.INSTANCE.elevatedCardColors(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    } else {
                        cardColorsElevatedCardColors = cardColors2;
                    }
                    if ((i2 & 32) != 0) {
                        composer3 = composerStartRestartGroup;
                        i3 &= -458753;
                        cardElevationM2906elevatedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m2906elevatedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composer3, 1572864, 63);
                    } else {
                        composer3 = composerStartRestartGroup;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource;
                    }
                    modifier4 = modifier2;
                }
                composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-129138571, i3, -1, "androidx.compose.material3.ElevatedCard (Card.kt:250)");
                }
                int i16 = i3 << 3;
                Card(function1, modifier4, z2, elevatedShape, cardColorsElevatedCardColors, cardElevationM2906elevatedCardElevationaqJV_2Y, null, mutableInteractionSource4, function3, composer3, (i3 & 14) | 1572864 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (29360128 & i16) | (i16 & 234881024), 0);
                MutableInteractionSource mutableInteractionSource8 = mutableInteractionSource4;
                composer2 = composer3;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                mutableInteractionSource3 = mutableInteractionSource8;
                modifier3 = modifier4;
                z4 = z2;
                shape2 = elevatedShape;
                cardColors3 = cardColorsElevatedCardColors;
                cardElevation2 = cardElevationM2906elevatedCardElevationaqJV_2Y;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                z4 = z2;
                shape2 = elevatedShape;
                cardColors3 = cardColors2;
                cardElevation2 = cardElevationM2906elevatedCardElevationaqJV_2Y;
                mutableInteractionSource3 = mutableInteractionSource;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CardKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CardKt.ElevatedCard$lambda$1(function0, modifier3, z4, shape2, cardColors3, cardElevation2, mutableInteractionSource3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
                    elevatedShape = shape;
                    if (composerStartRestartGroup.changed(elevatedShape)) {
                    }
                    i3 |= i10;
                } else {
                    elevatedShape = shape;
                }
                i3 |= i10;
            } else {
                elevatedShape = shape;
            }
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    cardColors2 = cardColors;
                    if (composerStartRestartGroup.changed(cardColors2)) {
                    }
                    i3 |= i11;
                } else {
                    cardColors2 = cardColors;
                }
                i3 |= i11;
            } else {
                cardColors2 = cardColors;
            }
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    cardElevationM2906elevatedCardElevationaqJV_2Y = cardElevation;
                    if (composerStartRestartGroup.changed(cardElevationM2906elevatedCardElevationaqJV_2Y)) {
                    }
                    i3 |= i12;
                } else {
                    cardElevationM2906elevatedCardElevationaqJV_2Y = cardElevation;
                }
                i3 |= i12;
            } else {
                cardElevationM2906elevatedCardElevationaqJV_2Y = cardElevation;
            }
            i6 = i2 & 64;
            if (i6 != 0) {
                if ((i & 1572864) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i7 = 1048576;
                    } else {
                        i7 = 524288;
                    }
                    i3 |= i7;
                }
                if ((12582912 & i) != 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i8 = 8388608;
                    } else {
                        i8 = 4194304;
                    }
                    i3 |= i8;
                }
                if ((4793491 & i3) != 4793490) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "244@11079L13,245@11132L20,246@11198L23");
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            elevatedShape = CardDefaults.INSTANCE.getElevatedShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 16) != 0) {
                            cardColorsElevatedCardColors = CardDefaults.INSTANCE.elevatedCardColors(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        } else {
                            cardColorsElevatedCardColors = cardColors2;
                        }
                        if ((i2 & 32) != 0) {
                            composer3 = composerStartRestartGroup;
                            i3 &= -458753;
                            cardElevationM2906elevatedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m2906elevatedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composer3, 1572864, 63);
                        } else {
                            composer3 = composerStartRestartGroup;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource;
                        }
                        modifier4 = modifier2;
                    } else {
                        if (i9 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            elevatedShape = CardDefaults.INSTANCE.getElevatedShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 16) != 0) {
                            cardColorsElevatedCardColors = CardDefaults.INSTANCE.elevatedCardColors(composerStartRestartGroup, 6);
                            i3 &= -57345;
                        } else {
                            cardColorsElevatedCardColors = cardColors2;
                        }
                        if ((i2 & 32) != 0) {
                            composer3 = composerStartRestartGroup;
                            i3 &= -458753;
                            cardElevationM2906elevatedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m2906elevatedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composer3, 1572864, 63);
                        } else {
                            composer3 = composerStartRestartGroup;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource;
                        }
                        modifier4 = modifier2;
                    }
                    composer3.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-129138571, i3, -1, "androidx.compose.material3.ElevatedCard (Card.kt:250)");
                    }
                    int i17 = i3 << 3;
                    Card(function1, modifier4, z2, elevatedShape, cardColorsElevatedCardColors, cardElevationM2906elevatedCardElevationaqJV_2Y, null, mutableInteractionSource4, function3, composer3, (i3 & 14) | 1572864 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (29360128 & i17) | (i17 & 234881024), 0);
                    MutableInteractionSource mutableInteractionSource9 = mutableInteractionSource4;
                    composer2 = composer3;
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    mutableInteractionSource3 = mutableInteractionSource9;
                    modifier3 = modifier4;
                    z4 = z2;
                    shape2 = elevatedShape;
                    cardColors3 = cardColorsElevatedCardColors;
                    cardElevation2 = cardElevationM2906elevatedCardElevationaqJV_2Y;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    z4 = z2;
                    shape2 = elevatedShape;
                    cardColors3 = cardColors2;
                    cardElevation2 = cardElevationM2906elevatedCardElevationaqJV_2Y;
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CardKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CardKt.ElevatedCard$lambda$1(function0, modifier3, z4, shape2, cardColors3, cardElevation2, mutableInteractionSource3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 1572864;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((12582912 & i) != 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i8 = 8388608;
                } else {
                    i8 = 4194304;
                }
                i3 |= i8;
            }
            if ((4793491 & i3) != 4793490) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "244@11079L13,245@11132L20,246@11198L23");
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        elevatedShape = CardDefaults.INSTANCE.getElevatedShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 16) != 0) {
                        cardColorsElevatedCardColors = CardDefaults.INSTANCE.elevatedCardColors(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    } else {
                        cardColorsElevatedCardColors = cardColors2;
                    }
                    if ((i2 & 32) != 0) {
                        composer3 = composerStartRestartGroup;
                        i3 &= -458753;
                        cardElevationM2906elevatedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m2906elevatedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composer3, 1572864, 63);
                    } else {
                        composer3 = composerStartRestartGroup;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource;
                    }
                    modifier4 = modifier2;
                } else {
                    if (i9 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        elevatedShape = CardDefaults.INSTANCE.getElevatedShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 16) != 0) {
                        cardColorsElevatedCardColors = CardDefaults.INSTANCE.elevatedCardColors(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    } else {
                        cardColorsElevatedCardColors = cardColors2;
                    }
                    if ((i2 & 32) != 0) {
                        composer3 = composerStartRestartGroup;
                        i3 &= -458753;
                        cardElevationM2906elevatedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m2906elevatedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composer3, 1572864, 63);
                    } else {
                        composer3 = composerStartRestartGroup;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource;
                    }
                    modifier4 = modifier2;
                }
                composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-129138571, i3, -1, "androidx.compose.material3.ElevatedCard (Card.kt:250)");
                }
                int i18 = i3 << 3;
                Card(function1, modifier4, z2, elevatedShape, cardColorsElevatedCardColors, cardElevationM2906elevatedCardElevationaqJV_2Y, null, mutableInteractionSource4, function3, composer3, (i3 & 14) | 1572864 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (29360128 & i18) | (i18 & 234881024), 0);
                MutableInteractionSource mutableInteractionSource10 = mutableInteractionSource4;
                composer2 = composer3;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                mutableInteractionSource3 = mutableInteractionSource10;
                modifier3 = modifier4;
                z4 = z2;
                shape2 = elevatedShape;
                cardColors3 = cardColorsElevatedCardColors;
                cardElevation2 = cardElevationM2906elevatedCardElevationaqJV_2Y;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                z4 = z2;
                shape2 = elevatedShape;
                cardColors3 = cardColors2;
                cardElevation2 = cardElevationM2906elevatedCardElevationaqJV_2Y;
                mutableInteractionSource3 = mutableInteractionSource;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CardKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CardKt.ElevatedCard$lambda$1(function0, modifier3, z4, shape2, cardColors3, cardElevation2, mutableInteractionSource3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        z2 = z;
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                elevatedShape = shape;
                if (composerStartRestartGroup.changed(elevatedShape)) {
                }
                i3 |= i10;
            } else {
                elevatedShape = shape;
            }
            i3 |= i10;
        } else {
            elevatedShape = shape;
        }
        if ((i & 24576) == 0) {
            if ((i2 & 16) == 0) {
                cardColors2 = cardColors;
                if (composerStartRestartGroup.changed(cardColors2)) {
                }
                i3 |= i11;
            } else {
                cardColors2 = cardColors;
            }
            i3 |= i11;
        } else {
            cardColors2 = cardColors;
        }
        if ((196608 & i) == 0) {
            if ((i2 & 32) == 0) {
                cardElevationM2906elevatedCardElevationaqJV_2Y = cardElevation;
                if (composerStartRestartGroup.changed(cardElevationM2906elevatedCardElevationaqJV_2Y)) {
                }
                i3 |= i12;
            } else {
                cardElevationM2906elevatedCardElevationaqJV_2Y = cardElevation;
            }
            i3 |= i12;
        } else {
            cardElevationM2906elevatedCardElevationaqJV_2Y = cardElevation;
        }
        i6 = i2 & 64;
        if (i6 != 0) {
            if ((i & 1572864) == 0) {
                mutableInteractionSource2 = mutableInteractionSource;
                if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                    i7 = 1048576;
                } else {
                    i7 = 524288;
                }
                i3 |= i7;
            }
            if ((12582912 & i) != 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i8 = 8388608;
                } else {
                    i8 = 4194304;
                }
                i3 |= i8;
            }
            if ((4793491 & i3) != 4793490) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "244@11079L13,245@11132L20,246@11198L23");
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        elevatedShape = CardDefaults.INSTANCE.getElevatedShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 16) != 0) {
                        cardColorsElevatedCardColors = CardDefaults.INSTANCE.elevatedCardColors(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    } else {
                        cardColorsElevatedCardColors = cardColors2;
                    }
                    if ((i2 & 32) != 0) {
                        composer3 = composerStartRestartGroup;
                        i3 &= -458753;
                        cardElevationM2906elevatedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m2906elevatedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composer3, 1572864, 63);
                    } else {
                        composer3 = composerStartRestartGroup;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource;
                    }
                    modifier4 = modifier2;
                } else {
                    if (i9 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        elevatedShape = CardDefaults.INSTANCE.getElevatedShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 16) != 0) {
                        cardColorsElevatedCardColors = CardDefaults.INSTANCE.elevatedCardColors(composerStartRestartGroup, 6);
                        i3 &= -57345;
                    } else {
                        cardColorsElevatedCardColors = cardColors2;
                    }
                    if ((i2 & 32) != 0) {
                        composer3 = composerStartRestartGroup;
                        i3 &= -458753;
                        cardElevationM2906elevatedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m2906elevatedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composer3, 1572864, 63);
                    } else {
                        composer3 = composerStartRestartGroup;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource;
                    }
                    modifier4 = modifier2;
                }
                composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-129138571, i3, -1, "androidx.compose.material3.ElevatedCard (Card.kt:250)");
                }
                int i19 = i3 << 3;
                Card(function1, modifier4, z2, elevatedShape, cardColorsElevatedCardColors, cardElevationM2906elevatedCardElevationaqJV_2Y, null, mutableInteractionSource4, function3, composer3, (i3 & 14) | 1572864 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (29360128 & i19) | (i19 & 234881024), 0);
                MutableInteractionSource mutableInteractionSource11 = mutableInteractionSource4;
                composer2 = composer3;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                mutableInteractionSource3 = mutableInteractionSource11;
                modifier3 = modifier4;
                z4 = z2;
                shape2 = elevatedShape;
                cardColors3 = cardColorsElevatedCardColors;
                cardElevation2 = cardElevationM2906elevatedCardElevationaqJV_2Y;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                z4 = z2;
                shape2 = elevatedShape;
                cardColors3 = cardColors2;
                cardElevation2 = cardElevationM2906elevatedCardElevationaqJV_2Y;
                mutableInteractionSource3 = mutableInteractionSource;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CardKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CardKt.ElevatedCard$lambda$1(function0, modifier3, z4, shape2, cardColors3, cardElevation2, mutableInteractionSource3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 1572864;
        mutableInteractionSource2 = mutableInteractionSource;
        if ((12582912 & i) != 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i8 = 8388608;
            } else {
                i8 = 4194304;
            }
            i3 |= i8;
        }
        if ((4793491 & i3) != 4793490) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "244@11079L13,245@11132L20,246@11198L23");
            if ((i & 1) != 0) {
                if (i9 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    z2 = true;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    elevatedShape = CardDefaults.INSTANCE.getElevatedShape(composerStartRestartGroup, 6);
                }
                if ((i2 & 16) != 0) {
                    cardColorsElevatedCardColors = CardDefaults.INSTANCE.elevatedCardColors(composerStartRestartGroup, 6);
                    i3 &= -57345;
                } else {
                    cardColorsElevatedCardColors = cardColors2;
                }
                if ((i2 & 32) != 0) {
                    composer3 = composerStartRestartGroup;
                    i3 &= -458753;
                    cardElevationM2906elevatedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m2906elevatedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composer3, 1572864, 63);
                } else {
                    composer3 = composerStartRestartGroup;
                }
                if (i6 != 0) {
                    mutableInteractionSource4 = null;
                } else {
                    mutableInteractionSource4 = mutableInteractionSource;
                }
                modifier4 = modifier2;
            } else {
                if (i9 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    z2 = true;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    elevatedShape = CardDefaults.INSTANCE.getElevatedShape(composerStartRestartGroup, 6);
                }
                if ((i2 & 16) != 0) {
                    cardColorsElevatedCardColors = CardDefaults.INSTANCE.elevatedCardColors(composerStartRestartGroup, 6);
                    i3 &= -57345;
                } else {
                    cardColorsElevatedCardColors = cardColors2;
                }
                if ((i2 & 32) != 0) {
                    composer3 = composerStartRestartGroup;
                    i3 &= -458753;
                    cardElevationM2906elevatedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m2906elevatedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composer3, 1572864, 63);
                } else {
                    composer3 = composerStartRestartGroup;
                }
                if (i6 != 0) {
                    mutableInteractionSource4 = null;
                } else {
                    mutableInteractionSource4 = mutableInteractionSource;
                }
                modifier4 = modifier2;
            }
            composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-129138571, i3, -1, "androidx.compose.material3.ElevatedCard (Card.kt:250)");
            }
            int i110 = i3 << 3;
            Card(function1, modifier4, z2, elevatedShape, cardColorsElevatedCardColors, cardElevationM2906elevatedCardElevationaqJV_2Y, null, mutableInteractionSource4, function3, composer3, (i3 & 14) | 1572864 | (i3 & 112) | (i3 & 896) | (i3 & 7168) | (57344 & i3) | (458752 & i3) | (29360128 & i110) | (i110 & 234881024), 0);
            MutableInteractionSource mutableInteractionSource12 = mutableInteractionSource4;
            composer2 = composer3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            mutableInteractionSource3 = mutableInteractionSource12;
            modifier3 = modifier4;
            z4 = z2;
            shape2 = elevatedShape;
            cardColors3 = cardColorsElevatedCardColors;
            cardElevation2 = cardElevationM2906elevatedCardElevationaqJV_2Y;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
            z4 = z2;
            shape2 = elevatedShape;
            cardColors3 = cardColors2;
            cardElevation2 = cardElevationM2906elevatedCardElevationaqJV_2Y;
            mutableInteractionSource3 = mutableInteractionSource;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CardKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CardKt.ElevatedCard$lambda$1(function0, modifier3, z4, shape2, cardColors3, cardElevation2, mutableInteractionSource3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    public static final void OutlinedCard(Modifier modifier, Shape shape, CardColors cardColors, CardElevation cardElevation, BorderStroke borderStroke, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        Shape shape2;
        CardColors cardColors2;
        CardElevation cardElevationM2908outlinedCardElevationaqJV_2Y;
        BorderStroke borderStroke2;
        Composer composer2;
        final Modifier modifier3;
        final Shape shape3;
        final CardColors cardColors3;
        final CardElevation cardElevation2;
        final BorderStroke borderStroke3;
        Modifier.Companion companion;
        Shape outlinedShape;
        CardColors cardColorsOutlinedCardColors;
        int i4;
        Composer composer3;
        BorderStroke borderStrokeOutlinedCardBorder;
        CardElevation cardElevation3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1945643296);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OutlinedCard)N(modifier,shape,colors,elevation,border,content)298@13425L171:Card.kt#uh7d8r");
        int i5 = i2 & 1;
        if (i5 != 0) {
            i3 = i | 6;
            modifier2 = modifier;
        } else if ((i & 6) == 0) {
            modifier2 = modifier;
            i3 = (composerStartRestartGroup.changed(modifier2) ? 4 : 2) | i;
        } else {
            modifier2 = modifier;
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) == 0) {
                shape2 = shape;
                int i6 = composerStartRestartGroup.changed(shape2) ? 32 : 16;
                i3 |= i6;
            } else {
                shape2 = shape;
            }
            i3 |= i6;
        } else {
            shape2 = shape;
        }
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                cardColors2 = cardColors;
                int i7 = composerStartRestartGroup.changed(cardColors2) ? 256 : 128;
                i3 |= i7;
            } else {
                cardColors2 = cardColors;
            }
            i3 |= i7;
        } else {
            cardColors2 = cardColors;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                cardElevationM2908outlinedCardElevationaqJV_2Y = cardElevation;
                int i8 = composerStartRestartGroup.changed(cardElevationM2908outlinedCardElevationaqJV_2Y) ? 2048 : 1024;
                i3 |= i8;
            } else {
                cardElevationM2908outlinedCardElevationaqJV_2Y = cardElevation;
            }
            i3 |= i8;
        } else {
            cardElevationM2908outlinedCardElevationaqJV_2Y = cardElevation;
        }
        if ((i & 24576) == 0) {
            if ((i2 & 16) == 0) {
                borderStroke2 = borderStroke;
                int i9 = composerStartRestartGroup.changed(borderStroke2) ? 16384 : 8192;
                i3 |= i9;
            } else {
                borderStroke2 = borderStroke;
            }
            i3 |= i9;
        } else {
            borderStroke2 = borderStroke;
        }
        if ((196608 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function3) ? 131072 : 65536;
        }
        if (composerStartRestartGroup.shouldExecute((74899 & i3) != 74898, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "292@13162L13,293@13215L20,294@13281L23,295@13346L20");
            if ((i & 1) != 0 && !composerStartRestartGroup.getDefaultsInvalid()) {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 2) != 0) {
                    i3 &= -113;
                }
                if ((i2 & 4) != 0) {
                    i3 &= -897;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                }
                outlinedShape = shape2;
                cardColorsOutlinedCardColors = cardColors2;
                cardElevation3 = cardElevationM2908outlinedCardElevationaqJV_2Y;
                borderStrokeOutlinedCardBorder = borderStroke2;
                composer3 = composerStartRestartGroup;
                companion = modifier2;
            } else {
                companion = i5 != 0 ? Modifier.INSTANCE : modifier2;
                if ((i2 & 2) != 0) {
                    outlinedShape = CardDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, 6);
                    i3 &= -113;
                } else {
                    outlinedShape = shape2;
                }
                if ((i2 & 4) != 0) {
                    cardColorsOutlinedCardColors = CardDefaults.INSTANCE.outlinedCardColors(composerStartRestartGroup, 6);
                    i3 &= -897;
                } else {
                    cardColorsOutlinedCardColors = cardColors2;
                }
                if ((i2 & 8) != 0) {
                    composer3 = composerStartRestartGroup;
                    i3 &= -7169;
                    i4 = 1;
                    cardElevationM2908outlinedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m2908outlinedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composer3, 1572864, 63);
                } else {
                    i4 = 1;
                    composer3 = composerStartRestartGroup;
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    borderStrokeOutlinedCardBorder = CardDefaults.INSTANCE.outlinedCardBorder(false, composer3, 48, i4);
                } else {
                    borderStrokeOutlinedCardBorder = borderStroke;
                }
                cardElevation3 = cardElevationM2908outlinedCardElevationaqJV_2Y;
            }
            composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1945643296, i3, -1, "androidx.compose.material3.OutlinedCard (Card.kt:298)");
            }
            Composer composer4 = composer3;
            Card(companion, outlinedShape, cardColorsOutlinedCardColors, cardElevation3, borderStrokeOutlinedCardBorder, function3, composer4, 524286 & i3, 0);
            composer2 = composer4;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = companion;
            shape3 = outlinedShape;
            cardColors3 = cardColorsOutlinedCardColors;
            cardElevation2 = cardElevation3;
            borderStroke3 = borderStrokeOutlinedCardBorder;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
            shape3 = shape2;
            cardColors3 = cardColors2;
            cardElevation2 = cardElevationM2908outlinedCardElevationaqJV_2Y;
            borderStroke3 = borderStroke;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CardKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CardKt.OutlinedCard$lambda$0(modifier3, shape3, cardColors3, cardElevation2, borderStroke3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0117  */
    /* JADX WARN: Code duplicated, block: B:102:0x012c  */
    /* JADX WARN: Code duplicated, block: B:118:0x015b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:119:0x015d  */
    /* JADX WARN: Code duplicated, block: B:121:0x0164  */
    /* JADX WARN: Code duplicated, block: B:124:0x016b  */
    /* JADX WARN: Code duplicated, block: B:127:0x0178  */
    /* JADX WARN: Code duplicated, block: B:130:0x0185  */
    /* JADX WARN: Code duplicated, block: B:131:0x01a2  */
    /* JADX WARN: Code duplicated, block: B:134:0x01a9  */
    /* JADX WARN: Code duplicated, block: B:135:0x01b9  */
    /* JADX WARN: Code duplicated, block: B:137:0x01bd  */
    /* JADX WARN: Code duplicated, block: B:138:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:142:0x01d7  */
    /* JADX WARN: Code duplicated, block: B:145:0x01f6  */
    /* JADX WARN: Code duplicated, block: B:147:0x0205  */
    /* JADX WARN: Code duplicated, block: B:150:0x0219  */
    /* JADX WARN: Code duplicated, block: B:152:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0046  */
    /* JADX WARN: Code duplicated, block: B:24:0x0049  */
    /* JADX WARN: Code duplicated, block: B:26:0x004d  */
    /* JADX WARN: Code duplicated, block: B:28:0x0055  */
    /* JADX WARN: Code duplicated, block: B:29:0x0058  */
    /* JADX WARN: Code duplicated, block: B:34:0x0062  */
    /* JADX WARN: Code duplicated, block: B:36:0x0066  */
    /* JADX WARN: Code duplicated, block: B:38:0x006e  */
    /* JADX WARN: Code duplicated, block: B:39:0x0071  */
    /* JADX WARN: Code duplicated, block: B:42:0x0077  */
    /* JADX WARN: Code duplicated, block: B:45:0x007d  */
    /* JADX WARN: Code duplicated, block: B:47:0x0081  */
    /* JADX WARN: Code duplicated, block: B:49:0x0089  */
    /* JADX WARN: Code duplicated, block: B:50:0x008c  */
    /* JADX WARN: Code duplicated, block: B:53:0x0092  */
    /* JADX WARN: Code duplicated, block: B:56:0x0099  */
    /* JADX WARN: Code duplicated, block: B:58:0x009d  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:61:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:64:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:67:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:69:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c4 A[ADDED_TO_REGION] */
    /* JADX WARN: Code duplicated, block: B:75:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:78:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:79:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:81:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:83:0x00df  */
    /* JADX WARN: Code duplicated, block: B:84:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:89:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:91:0x00f7  */
    /* JADX WARN: Code duplicated, block: B:92:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:96:0x010b  */
    /* JADX WARN: Code duplicated, block: B:97:0x010e  */
    public static final void OutlinedCard(final Function0<Unit> function0, Modifier modifier, boolean z, Shape shape, CardColors cardColors, CardElevation cardElevation, BorderStroke borderStroke, MutableInteractionSource mutableInteractionSource, final Function3<? super ColumnScope, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        int i5;
        Shape outlinedShape;
        CardColors cardColorsOutlinedCardColors;
        CardElevation cardElevationM2908outlinedCardElevationaqJV_2Y;
        int i6;
        MutableInteractionSource mutableInteractionSource2;
        int i7;
        boolean z3;
        Composer composer2;
        final Modifier modifier3;
        final boolean z4;
        final Shape shape2;
        final CardColors cardColors2;
        final CardElevation cardElevation2;
        final BorderStroke borderStroke2;
        final MutableInteractionSource mutableInteractionSource3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composer3;
        BorderStroke borderStrokeOutlinedCardBorder;
        MutableInteractionSource mutableInteractionSource4;
        Modifier modifier4;
        boolean z5;
        Shape shape3;
        CardColors cardColors3;
        CardElevation cardElevation3;
        int i8;
        Composer composerStartRestartGroup = composer.startRestartGroup(1401605899);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OutlinedCard)N(onClick,modifier,enabled,shape,colors,elevation,border,interactionSource,content)353@16051L272:Card.kt#uh7d8r");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(function0) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i9 = i2 & 2;
        if (i9 == 0) {
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
                        outlinedShape = shape;
                        int i10 = composerStartRestartGroup.changed(outlinedShape) ? 2048 : 1024;
                        i3 |= i10;
                    } else {
                        outlinedShape = shape;
                    }
                    i3 |= i10;
                } else {
                    outlinedShape = shape;
                }
                if ((i & 24576) == 0) {
                    if ((i2 & 16) == 0) {
                        cardColorsOutlinedCardColors = cardColors;
                        int i11 = composerStartRestartGroup.changed(cardColorsOutlinedCardColors) ? 16384 : 8192;
                        i3 |= i11;
                    } else {
                        cardColorsOutlinedCardColors = cardColors;
                    }
                    i3 |= i11;
                } else {
                    cardColorsOutlinedCardColors = cardColors;
                }
                if ((196608 & i) == 0) {
                    if ((i2 & 32) == 0) {
                        cardElevationM2908outlinedCardElevationaqJV_2Y = cardElevation;
                        int i12 = composerStartRestartGroup.changed(cardElevationM2908outlinedCardElevationaqJV_2Y) ? 131072 : 65536;
                        i3 |= i12;
                    } else {
                        cardElevationM2908outlinedCardElevationaqJV_2Y = cardElevation;
                    }
                    i3 |= i12;
                } else {
                    cardElevationM2908outlinedCardElevationaqJV_2Y = cardElevation;
                }
                if ((1572864 & i) != 0) {
                    i3 |= ((i2 & 64) == 0 || !composerStartRestartGroup.changed(borderStroke)) ? 524288 : 1048576;
                }
                i6 = i2 & 128;
                if (i6 != 0) {
                    if ((12582912 & i) == 0) {
                        mutableInteractionSource2 = mutableInteractionSource;
                        if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                            i7 = 8388608;
                        } else {
                            i7 = 4194304;
                        }
                        i3 |= i7;
                    }
                    if ((i & 100663296) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i8 = 67108864;
                        } else {
                            i8 = 33554432;
                        }
                        i3 |= i8;
                    }
                    if ((i3 & 38347923) != 38347922) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                        composerStartRestartGroup.startDefaults();
                        ComposerKt.sourceInformation(composerStartRestartGroup, "346@15724L13,347@15777L20,348@15843L23,349@15908L27");
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i9 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z2 = true;
                            }
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                                outlinedShape = CardDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, 6);
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                                cardColorsOutlinedCardColors = CardDefaults.INSTANCE.outlinedCardColors(composerStartRestartGroup, 6);
                            }
                            if ((i2 & 32) != 0) {
                                composer3 = composerStartRestartGroup;
                                i3 &= -458753;
                                cardElevationM2908outlinedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m2908outlinedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                            } else {
                                composer3 = composerStartRestartGroup;
                            }
                            if ((i2 & 64) != 0) {
                                borderStrokeOutlinedCardBorder = CardDefaults.INSTANCE.outlinedCardBorder(z2, composer3, ((i3 >> 6) & 14) | 48, 0);
                                i3 &= -3670017;
                            } else {
                                borderStrokeOutlinedCardBorder = borderStroke;
                            }
                            if (i6 != 0) {
                                mutableInteractionSource4 = null;
                            } else {
                                mutableInteractionSource4 = mutableInteractionSource;
                            }
                            modifier4 = modifier2;
                            z5 = z2;
                            shape3 = outlinedShape;
                            cardColors3 = cardColorsOutlinedCardColors;
                            cardElevation3 = cardElevationM2908outlinedCardElevationaqJV_2Y;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                            if ((i2 & 16) != 0) {
                                i3 &= -57345;
                            }
                            if ((i2 & 32) != 0) {
                                i3 &= -458753;
                            }
                            if ((i2 & 64) != 0) {
                                i3 &= -3670017;
                            }
                            borderStrokeOutlinedCardBorder = borderStroke;
                            composer3 = composerStartRestartGroup;
                            modifier4 = modifier2;
                            z5 = z2;
                            cardColors3 = cardColorsOutlinedCardColors;
                            cardElevation3 = cardElevationM2908outlinedCardElevationaqJV_2Y;
                            mutableInteractionSource4 = mutableInteractionSource2;
                            shape3 = outlinedShape;
                        }
                        composer3.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1401605899, i3, -1, "androidx.compose.material3.OutlinedCard (Card.kt:353)");
                        }
                        composer2 = composer3;
                        Card(function0, modifier4, z5, shape3, cardColors3, cardElevation3, borderStrokeOutlinedCardBorder, mutableInteractionSource4, function3, composer2, i3 & 268435454, 0);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier4;
                        z4 = z5;
                        shape2 = shape3;
                        cardColors2 = cardColors3;
                        cardElevation2 = cardElevation3;
                        borderStroke2 = borderStrokeOutlinedCardBorder;
                        mutableInteractionSource3 = mutableInteractionSource4;
                    } else {
                        composer2 = composerStartRestartGroup;
                        composer2.skipToGroupEnd();
                        modifier3 = modifier2;
                        z4 = z2;
                        shape2 = outlinedShape;
                        cardColors2 = cardColorsOutlinedCardColors;
                        cardElevation2 = cardElevationM2908outlinedCardElevationaqJV_2Y;
                        borderStroke2 = borderStroke;
                        mutableInteractionSource3 = mutableInteractionSource;
                    }
                    scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CardKt$$ExternalSyntheticLambda7
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return CardKt.OutlinedCard$lambda$1(function0, modifier3, z4, shape2, cardColors2, cardElevation2, borderStroke2, mutableInteractionSource3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 12582912;
                mutableInteractionSource2 = mutableInteractionSource;
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i8 = 67108864;
                    } else {
                        i8 = 33554432;
                    }
                    i3 |= i8;
                }
                if ((i3 & 38347923) != 38347922) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "346@15724L13,347@15777L20,348@15843L23,349@15908L27");
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            outlinedShape = CardDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            cardColorsOutlinedCardColors = CardDefaults.INSTANCE.outlinedCardColors(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 32) != 0) {
                            composer3 = composerStartRestartGroup;
                            i3 &= -458753;
                            cardElevationM2908outlinedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m2908outlinedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                        } else {
                            composer3 = composerStartRestartGroup;
                        }
                        if ((i2 & 64) != 0) {
                            borderStrokeOutlinedCardBorder = CardDefaults.INSTANCE.outlinedCardBorder(z2, composer3, ((i3 >> 6) & 14) | 48, 0);
                            i3 &= -3670017;
                        } else {
                            borderStrokeOutlinedCardBorder = borderStroke;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource;
                        }
                        modifier4 = modifier2;
                        z5 = z2;
                        shape3 = outlinedShape;
                        cardColors3 = cardColorsOutlinedCardColors;
                        cardElevation3 = cardElevationM2908outlinedCardElevationaqJV_2Y;
                    } else {
                        if (i9 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            outlinedShape = CardDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            cardColorsOutlinedCardColors = CardDefaults.INSTANCE.outlinedCardColors(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 32) != 0) {
                            composer3 = composerStartRestartGroup;
                            i3 &= -458753;
                            cardElevationM2908outlinedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m2908outlinedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                        } else {
                            composer3 = composerStartRestartGroup;
                        }
                        if ((i2 & 64) != 0) {
                            borderStrokeOutlinedCardBorder = CardDefaults.INSTANCE.outlinedCardBorder(z2, composer3, ((i3 >> 6) & 14) | 48, 0);
                            i3 &= -3670017;
                        } else {
                            borderStrokeOutlinedCardBorder = borderStroke;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource;
                        }
                        modifier4 = modifier2;
                        z5 = z2;
                        shape3 = outlinedShape;
                        cardColors3 = cardColorsOutlinedCardColors;
                        cardElevation3 = cardElevationM2908outlinedCardElevationaqJV_2Y;
                    }
                    composer3.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1401605899, i3, -1, "androidx.compose.material3.OutlinedCard (Card.kt:353)");
                    }
                    composer2 = composer3;
                    Card(function0, modifier4, z5, shape3, cardColors3, cardElevation3, borderStrokeOutlinedCardBorder, mutableInteractionSource4, function3, composer2, i3 & 268435454, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    z4 = z5;
                    shape2 = shape3;
                    cardColors2 = cardColors3;
                    cardElevation2 = cardElevation3;
                    borderStroke2 = borderStrokeOutlinedCardBorder;
                    mutableInteractionSource3 = mutableInteractionSource4;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    z4 = z2;
                    shape2 = outlinedShape;
                    cardColors2 = cardColorsOutlinedCardColors;
                    cardElevation2 = cardElevationM2908outlinedCardElevationaqJV_2Y;
                    borderStroke2 = borderStroke;
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CardKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CardKt.OutlinedCard$lambda$1(function0, modifier3, z4, shape2, cardColors2, cardElevation2, borderStroke2, mutableInteractionSource3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 384;
            z2 = z;
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    outlinedShape = shape;
                    if (composerStartRestartGroup.changed(outlinedShape)) {
                    }
                    i3 |= i10;
                } else {
                    outlinedShape = shape;
                }
                i3 |= i10;
            } else {
                outlinedShape = shape;
            }
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    cardColorsOutlinedCardColors = cardColors;
                    if (composerStartRestartGroup.changed(cardColorsOutlinedCardColors)) {
                    }
                    i3 |= i11;
                } else {
                    cardColorsOutlinedCardColors = cardColors;
                }
                i3 |= i11;
            } else {
                cardColorsOutlinedCardColors = cardColors;
            }
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    cardElevationM2908outlinedCardElevationaqJV_2Y = cardElevation;
                    if (composerStartRestartGroup.changed(cardElevationM2908outlinedCardElevationaqJV_2Y)) {
                    }
                    i3 |= i12;
                } else {
                    cardElevationM2908outlinedCardElevationaqJV_2Y = cardElevation;
                }
                i3 |= i12;
            } else {
                cardElevationM2908outlinedCardElevationaqJV_2Y = cardElevation;
            }
            if ((1572864 & i) != 0) {
                i3 |= ((i2 & 64) == 0 || !composerStartRestartGroup.changed(borderStroke)) ? 524288 : 1048576;
            }
            i6 = i2 & 128;
            if (i6 != 0) {
                if ((12582912 & i) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i7 = 8388608;
                    } else {
                        i7 = 4194304;
                    }
                    i3 |= i7;
                }
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i8 = 67108864;
                    } else {
                        i8 = 33554432;
                    }
                    i3 |= i8;
                }
                if ((i3 & 38347923) != 38347922) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "346@15724L13,347@15777L20,348@15843L23,349@15908L27");
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            outlinedShape = CardDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            cardColorsOutlinedCardColors = CardDefaults.INSTANCE.outlinedCardColors(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 32) != 0) {
                            composer3 = composerStartRestartGroup;
                            i3 &= -458753;
                            cardElevationM2908outlinedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m2908outlinedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                        } else {
                            composer3 = composerStartRestartGroup;
                        }
                        if ((i2 & 64) != 0) {
                            borderStrokeOutlinedCardBorder = CardDefaults.INSTANCE.outlinedCardBorder(z2, composer3, ((i3 >> 6) & 14) | 48, 0);
                            i3 &= -3670017;
                        } else {
                            borderStrokeOutlinedCardBorder = borderStroke;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource;
                        }
                        modifier4 = modifier2;
                        z5 = z2;
                        shape3 = outlinedShape;
                        cardColors3 = cardColorsOutlinedCardColors;
                        cardElevation3 = cardElevationM2908outlinedCardElevationaqJV_2Y;
                    } else {
                        if (i9 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            outlinedShape = CardDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            cardColorsOutlinedCardColors = CardDefaults.INSTANCE.outlinedCardColors(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 32) != 0) {
                            composer3 = composerStartRestartGroup;
                            i3 &= -458753;
                            cardElevationM2908outlinedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m2908outlinedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                        } else {
                            composer3 = composerStartRestartGroup;
                        }
                        if ((i2 & 64) != 0) {
                            borderStrokeOutlinedCardBorder = CardDefaults.INSTANCE.outlinedCardBorder(z2, composer3, ((i3 >> 6) & 14) | 48, 0);
                            i3 &= -3670017;
                        } else {
                            borderStrokeOutlinedCardBorder = borderStroke;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource;
                        }
                        modifier4 = modifier2;
                        z5 = z2;
                        shape3 = outlinedShape;
                        cardColors3 = cardColorsOutlinedCardColors;
                        cardElevation3 = cardElevationM2908outlinedCardElevationaqJV_2Y;
                    }
                    composer3.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1401605899, i3, -1, "androidx.compose.material3.OutlinedCard (Card.kt:353)");
                    }
                    composer2 = composer3;
                    Card(function0, modifier4, z5, shape3, cardColors3, cardElevation3, borderStrokeOutlinedCardBorder, mutableInteractionSource4, function3, composer2, i3 & 268435454, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    z4 = z5;
                    shape2 = shape3;
                    cardColors2 = cardColors3;
                    cardElevation2 = cardElevation3;
                    borderStroke2 = borderStrokeOutlinedCardBorder;
                    mutableInteractionSource3 = mutableInteractionSource4;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    z4 = z2;
                    shape2 = outlinedShape;
                    cardColors2 = cardColorsOutlinedCardColors;
                    cardElevation2 = cardElevationM2908outlinedCardElevationaqJV_2Y;
                    borderStroke2 = borderStroke;
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CardKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CardKt.OutlinedCard$lambda$1(function0, modifier3, z4, shape2, cardColors2, cardElevation2, borderStroke2, mutableInteractionSource3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 12582912;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i8 = 67108864;
                } else {
                    i8 = 33554432;
                }
                i3 |= i8;
            }
            if ((i3 & 38347923) != 38347922) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "346@15724L13,347@15777L20,348@15843L23,349@15908L27");
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        outlinedShape = CardDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        cardColorsOutlinedCardColors = CardDefaults.INSTANCE.outlinedCardColors(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 32) != 0) {
                        composer3 = composerStartRestartGroup;
                        i3 &= -458753;
                        cardElevationM2908outlinedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m2908outlinedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                    } else {
                        composer3 = composerStartRestartGroup;
                    }
                    if ((i2 & 64) != 0) {
                        borderStrokeOutlinedCardBorder = CardDefaults.INSTANCE.outlinedCardBorder(z2, composer3, ((i3 >> 6) & 14) | 48, 0);
                        i3 &= -3670017;
                    } else {
                        borderStrokeOutlinedCardBorder = borderStroke;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource;
                    }
                    modifier4 = modifier2;
                    z5 = z2;
                    shape3 = outlinedShape;
                    cardColors3 = cardColorsOutlinedCardColors;
                    cardElevation3 = cardElevationM2908outlinedCardElevationaqJV_2Y;
                } else {
                    if (i9 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        outlinedShape = CardDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        cardColorsOutlinedCardColors = CardDefaults.INSTANCE.outlinedCardColors(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 32) != 0) {
                        composer3 = composerStartRestartGroup;
                        i3 &= -458753;
                        cardElevationM2908outlinedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m2908outlinedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                    } else {
                        composer3 = composerStartRestartGroup;
                    }
                    if ((i2 & 64) != 0) {
                        borderStrokeOutlinedCardBorder = CardDefaults.INSTANCE.outlinedCardBorder(z2, composer3, ((i3 >> 6) & 14) | 48, 0);
                        i3 &= -3670017;
                    } else {
                        borderStrokeOutlinedCardBorder = borderStroke;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource;
                    }
                    modifier4 = modifier2;
                    z5 = z2;
                    shape3 = outlinedShape;
                    cardColors3 = cardColorsOutlinedCardColors;
                    cardElevation3 = cardElevationM2908outlinedCardElevationaqJV_2Y;
                }
                composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1401605899, i3, -1, "androidx.compose.material3.OutlinedCard (Card.kt:353)");
                }
                composer2 = composer3;
                Card(function0, modifier4, z5, shape3, cardColors3, cardElevation3, borderStrokeOutlinedCardBorder, mutableInteractionSource4, function3, composer2, i3 & 268435454, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                z4 = z5;
                shape2 = shape3;
                cardColors2 = cardColors3;
                cardElevation2 = cardElevation3;
                borderStroke2 = borderStrokeOutlinedCardBorder;
                mutableInteractionSource3 = mutableInteractionSource4;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                z4 = z2;
                shape2 = outlinedShape;
                cardColors2 = cardColorsOutlinedCardColors;
                cardElevation2 = cardElevationM2908outlinedCardElevationaqJV_2Y;
                borderStroke2 = borderStroke;
                mutableInteractionSource3 = mutableInteractionSource;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CardKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CardKt.OutlinedCard$lambda$1(function0, modifier3, z4, shape2, cardColors2, cardElevation2, borderStroke2, mutableInteractionSource3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
                    outlinedShape = shape;
                    if (composerStartRestartGroup.changed(outlinedShape)) {
                    }
                    i3 |= i10;
                } else {
                    outlinedShape = shape;
                }
                i3 |= i10;
            } else {
                outlinedShape = shape;
            }
            if ((i & 24576) == 0) {
                if ((i2 & 16) == 0) {
                    cardColorsOutlinedCardColors = cardColors;
                    if (composerStartRestartGroup.changed(cardColorsOutlinedCardColors)) {
                    }
                    i3 |= i11;
                } else {
                    cardColorsOutlinedCardColors = cardColors;
                }
                i3 |= i11;
            } else {
                cardColorsOutlinedCardColors = cardColors;
            }
            if ((196608 & i) == 0) {
                if ((i2 & 32) == 0) {
                    cardElevationM2908outlinedCardElevationaqJV_2Y = cardElevation;
                    if (composerStartRestartGroup.changed(cardElevationM2908outlinedCardElevationaqJV_2Y)) {
                    }
                    i3 |= i12;
                } else {
                    cardElevationM2908outlinedCardElevationaqJV_2Y = cardElevation;
                }
                i3 |= i12;
            } else {
                cardElevationM2908outlinedCardElevationaqJV_2Y = cardElevation;
            }
            if ((1572864 & i) != 0) {
                i3 |= ((i2 & 64) == 0 || !composerStartRestartGroup.changed(borderStroke)) ? 524288 : 1048576;
            }
            i6 = i2 & 128;
            if (i6 != 0) {
                if ((12582912 & i) == 0) {
                    mutableInteractionSource2 = mutableInteractionSource;
                    if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                        i7 = 8388608;
                    } else {
                        i7 = 4194304;
                    }
                    i3 |= i7;
                }
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i8 = 67108864;
                    } else {
                        i8 = 33554432;
                    }
                    i3 |= i8;
                }
                if ((i3 & 38347923) != 38347922) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "346@15724L13,347@15777L20,348@15843L23,349@15908L27");
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            outlinedShape = CardDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            cardColorsOutlinedCardColors = CardDefaults.INSTANCE.outlinedCardColors(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 32) != 0) {
                            composer3 = composerStartRestartGroup;
                            i3 &= -458753;
                            cardElevationM2908outlinedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m2908outlinedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                        } else {
                            composer3 = composerStartRestartGroup;
                        }
                        if ((i2 & 64) != 0) {
                            borderStrokeOutlinedCardBorder = CardDefaults.INSTANCE.outlinedCardBorder(z2, composer3, ((i3 >> 6) & 14) | 48, 0);
                            i3 &= -3670017;
                        } else {
                            borderStrokeOutlinedCardBorder = borderStroke;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource;
                        }
                        modifier4 = modifier2;
                        z5 = z2;
                        shape3 = outlinedShape;
                        cardColors3 = cardColorsOutlinedCardColors;
                        cardElevation3 = cardElevationM2908outlinedCardElevationaqJV_2Y;
                    } else {
                        if (i9 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            outlinedShape = CardDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                            cardColorsOutlinedCardColors = CardDefaults.INSTANCE.outlinedCardColors(composerStartRestartGroup, 6);
                        }
                        if ((i2 & 32) != 0) {
                            composer3 = composerStartRestartGroup;
                            i3 &= -458753;
                            cardElevationM2908outlinedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m2908outlinedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                        } else {
                            composer3 = composerStartRestartGroup;
                        }
                        if ((i2 & 64) != 0) {
                            borderStrokeOutlinedCardBorder = CardDefaults.INSTANCE.outlinedCardBorder(z2, composer3, ((i3 >> 6) & 14) | 48, 0);
                            i3 &= -3670017;
                        } else {
                            borderStrokeOutlinedCardBorder = borderStroke;
                        }
                        if (i6 != 0) {
                            mutableInteractionSource4 = null;
                        } else {
                            mutableInteractionSource4 = mutableInteractionSource;
                        }
                        modifier4 = modifier2;
                        z5 = z2;
                        shape3 = outlinedShape;
                        cardColors3 = cardColorsOutlinedCardColors;
                        cardElevation3 = cardElevationM2908outlinedCardElevationaqJV_2Y;
                    }
                    composer3.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1401605899, i3, -1, "androidx.compose.material3.OutlinedCard (Card.kt:353)");
                    }
                    composer2 = composer3;
                    Card(function0, modifier4, z5, shape3, cardColors3, cardElevation3, borderStrokeOutlinedCardBorder, mutableInteractionSource4, function3, composer2, i3 & 268435454, 0);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                    z4 = z5;
                    shape2 = shape3;
                    cardColors2 = cardColors3;
                    cardElevation2 = cardElevation3;
                    borderStroke2 = borderStrokeOutlinedCardBorder;
                    mutableInteractionSource3 = mutableInteractionSource4;
                } else {
                    composer2 = composerStartRestartGroup;
                    composer2.skipToGroupEnd();
                    modifier3 = modifier2;
                    z4 = z2;
                    shape2 = outlinedShape;
                    cardColors2 = cardColorsOutlinedCardColors;
                    cardElevation2 = cardElevationM2908outlinedCardElevationaqJV_2Y;
                    borderStroke2 = borderStroke;
                    mutableInteractionSource3 = mutableInteractionSource;
                }
                scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CardKt$$ExternalSyntheticLambda7
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return CardKt.OutlinedCard$lambda$1(function0, modifier3, z4, shape2, cardColors2, cardElevation2, borderStroke2, mutableInteractionSource3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 12582912;
            mutableInteractionSource2 = mutableInteractionSource;
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i8 = 67108864;
                } else {
                    i8 = 33554432;
                }
                i3 |= i8;
            }
            if ((i3 & 38347923) != 38347922) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "346@15724L13,347@15777L20,348@15843L23,349@15908L27");
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        outlinedShape = CardDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        cardColorsOutlinedCardColors = CardDefaults.INSTANCE.outlinedCardColors(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 32) != 0) {
                        composer3 = composerStartRestartGroup;
                        i3 &= -458753;
                        cardElevationM2908outlinedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m2908outlinedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                    } else {
                        composer3 = composerStartRestartGroup;
                    }
                    if ((i2 & 64) != 0) {
                        borderStrokeOutlinedCardBorder = CardDefaults.INSTANCE.outlinedCardBorder(z2, composer3, ((i3 >> 6) & 14) | 48, 0);
                        i3 &= -3670017;
                    } else {
                        borderStrokeOutlinedCardBorder = borderStroke;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource;
                    }
                    modifier4 = modifier2;
                    z5 = z2;
                    shape3 = outlinedShape;
                    cardColors3 = cardColorsOutlinedCardColors;
                    cardElevation3 = cardElevationM2908outlinedCardElevationaqJV_2Y;
                } else {
                    if (i9 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        outlinedShape = CardDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        cardColorsOutlinedCardColors = CardDefaults.INSTANCE.outlinedCardColors(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 32) != 0) {
                        composer3 = composerStartRestartGroup;
                        i3 &= -458753;
                        cardElevationM2908outlinedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m2908outlinedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                    } else {
                        composer3 = composerStartRestartGroup;
                    }
                    if ((i2 & 64) != 0) {
                        borderStrokeOutlinedCardBorder = CardDefaults.INSTANCE.outlinedCardBorder(z2, composer3, ((i3 >> 6) & 14) | 48, 0);
                        i3 &= -3670017;
                    } else {
                        borderStrokeOutlinedCardBorder = borderStroke;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource;
                    }
                    modifier4 = modifier2;
                    z5 = z2;
                    shape3 = outlinedShape;
                    cardColors3 = cardColorsOutlinedCardColors;
                    cardElevation3 = cardElevationM2908outlinedCardElevationaqJV_2Y;
                }
                composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1401605899, i3, -1, "androidx.compose.material3.OutlinedCard (Card.kt:353)");
                }
                composer2 = composer3;
                Card(function0, modifier4, z5, shape3, cardColors3, cardElevation3, borderStrokeOutlinedCardBorder, mutableInteractionSource4, function3, composer2, i3 & 268435454, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                z4 = z5;
                shape2 = shape3;
                cardColors2 = cardColors3;
                cardElevation2 = cardElevation3;
                borderStroke2 = borderStrokeOutlinedCardBorder;
                mutableInteractionSource3 = mutableInteractionSource4;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                z4 = z2;
                shape2 = outlinedShape;
                cardColors2 = cardColorsOutlinedCardColors;
                cardElevation2 = cardElevationM2908outlinedCardElevationaqJV_2Y;
                borderStroke2 = borderStroke;
                mutableInteractionSource3 = mutableInteractionSource;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CardKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CardKt.OutlinedCard$lambda$1(function0, modifier3, z4, shape2, cardColors2, cardElevation2, borderStroke2, mutableInteractionSource3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        z2 = z;
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                outlinedShape = shape;
                if (composerStartRestartGroup.changed(outlinedShape)) {
                }
                i3 |= i10;
            } else {
                outlinedShape = shape;
            }
            i3 |= i10;
        } else {
            outlinedShape = shape;
        }
        if ((i & 24576) == 0) {
            if ((i2 & 16) == 0) {
                cardColorsOutlinedCardColors = cardColors;
                if (composerStartRestartGroup.changed(cardColorsOutlinedCardColors)) {
                }
                i3 |= i11;
            } else {
                cardColorsOutlinedCardColors = cardColors;
            }
            i3 |= i11;
        } else {
            cardColorsOutlinedCardColors = cardColors;
        }
        if ((196608 & i) == 0) {
            if ((i2 & 32) == 0) {
                cardElevationM2908outlinedCardElevationaqJV_2Y = cardElevation;
                if (composerStartRestartGroup.changed(cardElevationM2908outlinedCardElevationaqJV_2Y)) {
                }
                i3 |= i12;
            } else {
                cardElevationM2908outlinedCardElevationaqJV_2Y = cardElevation;
            }
            i3 |= i12;
        } else {
            cardElevationM2908outlinedCardElevationaqJV_2Y = cardElevation;
        }
        if ((1572864 & i) != 0) {
            i3 |= ((i2 & 64) == 0 || !composerStartRestartGroup.changed(borderStroke)) ? 524288 : 1048576;
        }
        i6 = i2 & 128;
        if (i6 != 0) {
            if ((12582912 & i) == 0) {
                mutableInteractionSource2 = mutableInteractionSource;
                if (composerStartRestartGroup.changed(mutableInteractionSource2)) {
                    i7 = 8388608;
                } else {
                    i7 = 4194304;
                }
                i3 |= i7;
            }
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i8 = 67108864;
                } else {
                    i8 = 33554432;
                }
                i3 |= i8;
            }
            if ((i3 & 38347923) != 38347922) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "346@15724L13,347@15777L20,348@15843L23,349@15908L27");
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        outlinedShape = CardDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        cardColorsOutlinedCardColors = CardDefaults.INSTANCE.outlinedCardColors(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 32) != 0) {
                        composer3 = composerStartRestartGroup;
                        i3 &= -458753;
                        cardElevationM2908outlinedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m2908outlinedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                    } else {
                        composer3 = composerStartRestartGroup;
                    }
                    if ((i2 & 64) != 0) {
                        borderStrokeOutlinedCardBorder = CardDefaults.INSTANCE.outlinedCardBorder(z2, composer3, ((i3 >> 6) & 14) | 48, 0);
                        i3 &= -3670017;
                    } else {
                        borderStrokeOutlinedCardBorder = borderStroke;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource;
                    }
                    modifier4 = modifier2;
                    z5 = z2;
                    shape3 = outlinedShape;
                    cardColors3 = cardColorsOutlinedCardColors;
                    cardElevation3 = cardElevationM2908outlinedCardElevationaqJV_2Y;
                } else {
                    if (i9 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        outlinedShape = CardDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 16) != 0) {
                        i3 &= -57345;
                        cardColorsOutlinedCardColors = CardDefaults.INSTANCE.outlinedCardColors(composerStartRestartGroup, 6);
                    }
                    if ((i2 & 32) != 0) {
                        composer3 = composerStartRestartGroup;
                        i3 &= -458753;
                        cardElevationM2908outlinedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m2908outlinedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                    } else {
                        composer3 = composerStartRestartGroup;
                    }
                    if ((i2 & 64) != 0) {
                        borderStrokeOutlinedCardBorder = CardDefaults.INSTANCE.outlinedCardBorder(z2, composer3, ((i3 >> 6) & 14) | 48, 0);
                        i3 &= -3670017;
                    } else {
                        borderStrokeOutlinedCardBorder = borderStroke;
                    }
                    if (i6 != 0) {
                        mutableInteractionSource4 = null;
                    } else {
                        mutableInteractionSource4 = mutableInteractionSource;
                    }
                    modifier4 = modifier2;
                    z5 = z2;
                    shape3 = outlinedShape;
                    cardColors3 = cardColorsOutlinedCardColors;
                    cardElevation3 = cardElevationM2908outlinedCardElevationaqJV_2Y;
                }
                composer3.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1401605899, i3, -1, "androidx.compose.material3.OutlinedCard (Card.kt:353)");
                }
                composer2 = composer3;
                Card(function0, modifier4, z5, shape3, cardColors3, cardElevation3, borderStrokeOutlinedCardBorder, mutableInteractionSource4, function3, composer2, i3 & 268435454, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
                z4 = z5;
                shape2 = shape3;
                cardColors2 = cardColors3;
                cardElevation2 = cardElevation3;
                borderStroke2 = borderStrokeOutlinedCardBorder;
                mutableInteractionSource3 = mutableInteractionSource4;
            } else {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
                z4 = z2;
                shape2 = outlinedShape;
                cardColors2 = cardColorsOutlinedCardColors;
                cardElevation2 = cardElevationM2908outlinedCardElevationaqJV_2Y;
                borderStroke2 = borderStroke;
                mutableInteractionSource3 = mutableInteractionSource;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CardKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return CardKt.OutlinedCard$lambda$1(function0, modifier3, z4, shape2, cardColors2, cardElevation2, borderStroke2, mutableInteractionSource3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 12582912;
        mutableInteractionSource2 = mutableInteractionSource;
        if ((i & 100663296) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i8 = 67108864;
            } else {
                i8 = 33554432;
            }
            i3 |= i8;
        }
        if ((i3 & 38347923) != 38347922) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "346@15724L13,347@15777L20,348@15843L23,349@15908L27");
            if ((i & 1) != 0) {
                if (i9 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    z2 = true;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    outlinedShape = CardDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, 6);
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    cardColorsOutlinedCardColors = CardDefaults.INSTANCE.outlinedCardColors(composerStartRestartGroup, 6);
                }
                if ((i2 & 32) != 0) {
                    composer3 = composerStartRestartGroup;
                    i3 &= -458753;
                    cardElevationM2908outlinedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m2908outlinedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                } else {
                    composer3 = composerStartRestartGroup;
                }
                if ((i2 & 64) != 0) {
                    borderStrokeOutlinedCardBorder = CardDefaults.INSTANCE.outlinedCardBorder(z2, composer3, ((i3 >> 6) & 14) | 48, 0);
                    i3 &= -3670017;
                } else {
                    borderStrokeOutlinedCardBorder = borderStroke;
                }
                if (i6 != 0) {
                    mutableInteractionSource4 = null;
                } else {
                    mutableInteractionSource4 = mutableInteractionSource;
                }
                modifier4 = modifier2;
                z5 = z2;
                shape3 = outlinedShape;
                cardColors3 = cardColorsOutlinedCardColors;
                cardElevation3 = cardElevationM2908outlinedCardElevationaqJV_2Y;
            } else {
                if (i9 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    z2 = true;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    outlinedShape = CardDefaults.INSTANCE.getOutlinedShape(composerStartRestartGroup, 6);
                }
                if ((i2 & 16) != 0) {
                    i3 &= -57345;
                    cardColorsOutlinedCardColors = CardDefaults.INSTANCE.outlinedCardColors(composerStartRestartGroup, 6);
                }
                if ((i2 & 32) != 0) {
                    composer3 = composerStartRestartGroup;
                    i3 &= -458753;
                    cardElevationM2908outlinedCardElevationaqJV_2Y = CardDefaults.INSTANCE.m2908outlinedCardElevationaqJV_2Y(0.0f, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, composerStartRestartGroup, 1572864, 63);
                } else {
                    composer3 = composerStartRestartGroup;
                }
                if ((i2 & 64) != 0) {
                    borderStrokeOutlinedCardBorder = CardDefaults.INSTANCE.outlinedCardBorder(z2, composer3, ((i3 >> 6) & 14) | 48, 0);
                    i3 &= -3670017;
                } else {
                    borderStrokeOutlinedCardBorder = borderStroke;
                }
                if (i6 != 0) {
                    mutableInteractionSource4 = null;
                } else {
                    mutableInteractionSource4 = mutableInteractionSource;
                }
                modifier4 = modifier2;
                z5 = z2;
                shape3 = outlinedShape;
                cardColors3 = cardColorsOutlinedCardColors;
                cardElevation3 = cardElevationM2908outlinedCardElevationaqJV_2Y;
            }
            composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1401605899, i3, -1, "androidx.compose.material3.OutlinedCard (Card.kt:353)");
            }
            composer2 = composer3;
            Card(function0, modifier4, z5, shape3, cardColors3, cardElevation3, borderStrokeOutlinedCardBorder, mutableInteractionSource4, function3, composer2, i3 & 268435454, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
            z4 = z5;
            shape2 = shape3;
            cardColors2 = cardColors3;
            cardElevation2 = cardElevation3;
            borderStroke2 = borderStrokeOutlinedCardBorder;
            mutableInteractionSource3 = mutableInteractionSource4;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
            z4 = z2;
            shape2 = outlinedShape;
            cardColors2 = cardColorsOutlinedCardColors;
            cardElevation2 = cardElevationM2908outlinedCardElevationaqJV_2Y;
            borderStroke2 = borderStroke;
            mutableInteractionSource3 = mutableInteractionSource;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: androidx.compose.material3.CardKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return CardKt.OutlinedCard$lambda$1(function0, modifier3, z4, shape2, cardColors2, cardElevation2, borderStroke2, mutableInteractionSource3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}

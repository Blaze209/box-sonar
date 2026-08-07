package com.box.android.base.compose.button;

import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.IconButtonColors;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.IconKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.unit.Dp;
import com.box.android.base.compose.BoxColorsKt;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.base.compose.button.model.ButtonItem;
import com.box.android.base.compose.button.model.ButtonItemIconResource;
import com.box.android.base.compose.progressbar.BoxCircularProgressBarKt;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxIconButton.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u0000$\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0005\u001a?\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0007¢\u0006\u0004\b\u000b\u0010\f\u001a\r\u0010\r\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u000e¨\u0006\u000f"}, d2 = {"BoxIconButton", "", "buttonItem", "Lcom/box/android/base/compose/button/model/ButtonItem$IconButtonItem;", "modifier", "Landroidx/compose/ui/Modifier;", "iconModifier", "tint", "Landroidx/compose/ui/graphics/Color;", "disabledAlpha", "", "BoxIconButton-uDo3WH8", "(Lcom/box/android/base/compose/button/model/ButtonItem$IconButtonItem;Landroidx/compose/ui/Modifier;Landroidx/compose/ui/Modifier;JFLandroidx/compose/runtime/Composer;II)V", "BoxIconButtonPreview", "(Landroidx/compose/runtime/Composer;I)V", "base_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BoxIconButtonKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxIconButtonPreview$lambda$0(int i, Composer composer, int i2) {
        BoxIconButtonPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxIconButton_uDo3WH8$lambda$1(ButtonItem.IconButtonItem iconButtonItem, Modifier modifier, Modifier modifier2, long j, float f, int i, int i2, Composer composer, int i3) {
        m11681BoxIconButtonuDo3WH8(iconButtonItem, modifier, modifier2, j, f, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0047  */
    /* JADX WARN: Code duplicated, block: B:24:0x004a  */
    /* JADX WARN: Code duplicated, block: B:26:0x004e  */
    /* JADX WARN: Code duplicated, block: B:28:0x0056  */
    /* JADX WARN: Code duplicated, block: B:29:0x0059  */
    /* JADX WARN: Code duplicated, block: B:34:0x0063  */
    /* JADX WARN: Code duplicated, block: B:36:0x0067  */
    /* JADX WARN: Code duplicated, block: B:38:0x006f  */
    /* JADX WARN: Code duplicated, block: B:39:0x0072  */
    /* JADX WARN: Code duplicated, block: B:42:0x0078  */
    /* JADX WARN: Code duplicated, block: B:45:0x007e  */
    /* JADX WARN: Code duplicated, block: B:46:0x0081  */
    /* JADX WARN: Code duplicated, block: B:48:0x0085  */
    /* JADX WARN: Code duplicated, block: B:50:0x008d  */
    /* JADX WARN: Code duplicated, block: B:51:0x0090  */
    /* JADX WARN: Code duplicated, block: B:56:0x009d  */
    /* JADX WARN: Code duplicated, block: B:57:0x009f  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a8  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c9 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:70:0x00cb  */
    /* JADX WARN: Code duplicated, block: B:71:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:77:0x00dd  */
    /* JADX WARN: Code duplicated, block: B:79:0x00ed  */
    /* JADX WARN: Code duplicated, block: B:83:0x0100  */
    /* JADX WARN: Code duplicated, block: B:86:0x0141  */
    /* JADX WARN: Code duplicated, block: B:88:0x0149  */
    /* JADX WARN: Code duplicated, block: B:91:0x0156  */
    /* JADX WARN: Code duplicated, block: B:93:? A[RETURN, SYNTHETIC] */
    /* JADX INFO: renamed from: BoxIconButton-uDo3WH8, reason: not valid java name */
    public static final void m11681BoxIconButtonuDo3WH8(final ButtonItem.IconButtonItem buttonItem, Modifier modifier, Modifier modifier2, long j, float f, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier3;
        int i4;
        Modifier modifier4;
        int i5;
        long jM11533getMainActiveControl0d7_KjU;
        int i6;
        float f2;
        int i7;
        boolean z;
        final Modifier modifier5;
        final Modifier modifier6;
        final long j2;
        final float f3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        Modifier.Companion companion2;
        int i8;
        Modifier modifier7;
        long j3;
        Intrinsics.checkNotNullParameter(buttonItem, "buttonItem");
        Composer composerStartRestartGroup = composer.startRestartGroup(1020801719);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxIconButton)N(buttonItem,modifier,iconModifier,tint:c#ui.graphics.Color,disabledAlpha)33@1278L1106,29@1154L1230:BoxIconButton.kt#171s90");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(buttonItem) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i9 = i2 & 2;
        if (i9 == 0) {
            if ((i & 48) == 0) {
                modifier3 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier3) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    modifier4 = modifier2;
                    if (composerStartRestartGroup.changed(modifier4)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                if ((i & 3072) == 0) {
                    if ((i2 & 8) == 0) {
                        jM11533getMainActiveControl0d7_KjU = j;
                        int i10 = composerStartRestartGroup.changed(jM11533getMainActiveControl0d7_KjU) ? 2048 : 1024;
                        i3 |= i10;
                    } else {
                        jM11533getMainActiveControl0d7_KjU = j;
                    }
                    i3 |= i10;
                } else {
                    jM11533getMainActiveControl0d7_KjU = j;
                }
                i6 = i2 & 16;
                if (i6 != 0) {
                    if ((i & 24576) == 0) {
                        f2 = f;
                        if (composerStartRestartGroup.changed(f2)) {
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
                        ComposerKt.sourceInformation(composerStartRestartGroup, "26@1062L6");
                        if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                            if (i9 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier3;
                            }
                            if (i4 != 0) {
                                companion2 = Modifier.INSTANCE;
                            } else {
                                companion2 = modifier4;
                            }
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                                jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                            }
                            if (i6 != 0) {
                                f2 = 0.4f;
                            }
                            i8 = i3;
                            modifier7 = companion;
                            j3 = jM11533getMainActiveControl0d7_KjU;
                        } else {
                            composerStartRestartGroup.skipToGroupEnd();
                            if ((i2 & 8) != 0) {
                                i3 &= -7169;
                            }
                            i8 = i3;
                            j3 = jM11533getMainActiveControl0d7_KjU;
                            modifier7 = modifier3;
                            companion2 = modifier4;
                        }
                        composerStartRestartGroup.endDefaults();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(1020801719, i8, -1, "com.box.android.base.compose.button.BoxIconButton (BoxIconButton.kt:28)");
                        }
                        final long j4 = j3;
                        final Modifier modifier8 = companion2;
                        final float f4 = f2;
                        IconButtonKt.IconButton(buttonItem.getOnClick(), modifier7, buttonItem.getIsEnabled(), (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, ComposableLambdaKt.rememberComposableLambda(426634453, true, new Function2() { // from class: com.box.android.base.compose.button.BoxIconButtonKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxIconButtonKt.BoxIconButton_uDo3WH8$lambda$0(buttonItem, j4, f4, modifier8, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, (i8 & 112) | 1572864, 56);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        f3 = f4;
                        modifier6 = companion2;
                        j2 = j4;
                        modifier5 = modifier7;
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier5 = modifier3;
                        modifier6 = modifier4;
                        j2 = jM11533getMainActiveControl0d7_KjU;
                        f3 = f2;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.button.BoxIconButtonKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BoxIconButtonKt.BoxIconButton_uDo3WH8$lambda$1(buttonItem, modifier5, modifier6, j2, f3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 24576;
                f2 = f;
                if ((i3 & 9363) != 9362) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "26@1062L6");
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier3;
                        }
                        if (i4 != 0) {
                            companion2 = Modifier.INSTANCE;
                        } else {
                            companion2 = modifier4;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                        }
                        if (i6 != 0) {
                            f2 = 0.4f;
                        }
                        i8 = i3;
                        modifier7 = companion;
                        j3 = jM11533getMainActiveControl0d7_KjU;
                    } else {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier3;
                        }
                        if (i4 != 0) {
                            companion2 = Modifier.INSTANCE;
                        } else {
                            companion2 = modifier4;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                        }
                        if (i6 != 0) {
                            f2 = 0.4f;
                        }
                        i8 = i3;
                        modifier7 = companion;
                        j3 = jM11533getMainActiveControl0d7_KjU;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1020801719, i8, -1, "com.box.android.base.compose.button.BoxIconButton (BoxIconButton.kt:28)");
                    }
                    final long j5 = j3;
                    final Modifier modifier9 = companion2;
                    final float f5 = f2;
                    IconButtonKt.IconButton(buttonItem.getOnClick(), modifier7, buttonItem.getIsEnabled(), (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, ComposableLambdaKt.rememberComposableLambda(426634453, true, new Function2() { // from class: com.box.android.base.compose.button.BoxIconButtonKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxIconButtonKt.BoxIconButton_uDo3WH8$lambda$0(buttonItem, j5, f5, modifier9, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i8 & 112) | 1572864, 56);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f3 = f5;
                    modifier6 = companion2;
                    j2 = j5;
                    modifier5 = modifier7;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier5 = modifier3;
                    modifier6 = modifier4;
                    j2 = jM11533getMainActiveControl0d7_KjU;
                    f3 = f2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.button.BoxIconButtonKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxIconButtonKt.BoxIconButton_uDo3WH8$lambda$1(buttonItem, modifier5, modifier6, j2, f3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 384;
            modifier4 = modifier2;
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    jM11533getMainActiveControl0d7_KjU = j;
                    if (composerStartRestartGroup.changed(jM11533getMainActiveControl0d7_KjU)) {
                    }
                    i3 |= i10;
                } else {
                    jM11533getMainActiveControl0d7_KjU = j;
                }
                i3 |= i10;
            } else {
                jM11533getMainActiveControl0d7_KjU = j;
            }
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    f2 = f;
                    if (composerStartRestartGroup.changed(f2)) {
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
                    ComposerKt.sourceInformation(composerStartRestartGroup, "26@1062L6");
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier3;
                        }
                        if (i4 != 0) {
                            companion2 = Modifier.INSTANCE;
                        } else {
                            companion2 = modifier4;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                        }
                        if (i6 != 0) {
                            f2 = 0.4f;
                        }
                        i8 = i3;
                        modifier7 = companion;
                        j3 = jM11533getMainActiveControl0d7_KjU;
                    } else {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier3;
                        }
                        if (i4 != 0) {
                            companion2 = Modifier.INSTANCE;
                        } else {
                            companion2 = modifier4;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                        }
                        if (i6 != 0) {
                            f2 = 0.4f;
                        }
                        i8 = i3;
                        modifier7 = companion;
                        j3 = jM11533getMainActiveControl0d7_KjU;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1020801719, i8, -1, "com.box.android.base.compose.button.BoxIconButton (BoxIconButton.kt:28)");
                    }
                    final long j6 = j3;
                    final Modifier modifier10 = companion2;
                    final float f6 = f2;
                    IconButtonKt.IconButton(buttonItem.getOnClick(), modifier7, buttonItem.getIsEnabled(), (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, ComposableLambdaKt.rememberComposableLambda(426634453, true, new Function2() { // from class: com.box.android.base.compose.button.BoxIconButtonKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxIconButtonKt.BoxIconButton_uDo3WH8$lambda$0(buttonItem, j6, f6, modifier10, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i8 & 112) | 1572864, 56);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f3 = f6;
                    modifier6 = companion2;
                    j2 = j6;
                    modifier5 = modifier7;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier5 = modifier3;
                    modifier6 = modifier4;
                    j2 = jM11533getMainActiveControl0d7_KjU;
                    f3 = f2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.button.BoxIconButtonKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxIconButtonKt.BoxIconButton_uDo3WH8$lambda$1(buttonItem, modifier5, modifier6, j2, f3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            f2 = f;
            if ((i3 & 9363) != 9362) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "26@1062L6");
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier3;
                    }
                    if (i4 != 0) {
                        companion2 = Modifier.INSTANCE;
                    } else {
                        companion2 = modifier4;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                    }
                    if (i6 != 0) {
                        f2 = 0.4f;
                    }
                    i8 = i3;
                    modifier7 = companion;
                    j3 = jM11533getMainActiveControl0d7_KjU;
                } else {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier3;
                    }
                    if (i4 != 0) {
                        companion2 = Modifier.INSTANCE;
                    } else {
                        companion2 = modifier4;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                    }
                    if (i6 != 0) {
                        f2 = 0.4f;
                    }
                    i8 = i3;
                    modifier7 = companion;
                    j3 = jM11533getMainActiveControl0d7_KjU;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1020801719, i8, -1, "com.box.android.base.compose.button.BoxIconButton (BoxIconButton.kt:28)");
                }
                final long j7 = j3;
                final Modifier modifier11 = companion2;
                final float f7 = f2;
                IconButtonKt.IconButton(buttonItem.getOnClick(), modifier7, buttonItem.getIsEnabled(), (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, ComposableLambdaKt.rememberComposableLambda(426634453, true, new Function2() { // from class: com.box.android.base.compose.button.BoxIconButtonKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxIconButtonKt.BoxIconButton_uDo3WH8$lambda$0(buttonItem, j7, f7, modifier11, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i8 & 112) | 1572864, 56);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f3 = f7;
                modifier6 = companion2;
                j2 = j7;
                modifier5 = modifier7;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier5 = modifier3;
                modifier6 = modifier4;
                j2 = jM11533getMainActiveControl0d7_KjU;
                f3 = f2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.button.BoxIconButtonKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxIconButtonKt.BoxIconButton_uDo3WH8$lambda$1(buttonItem, modifier5, modifier6, j2, f3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier3 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 384) == 0) {
                modifier4 = modifier2;
                if (composerStartRestartGroup.changed(modifier4)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            if ((i & 3072) == 0) {
                if ((i2 & 8) == 0) {
                    jM11533getMainActiveControl0d7_KjU = j;
                    if (composerStartRestartGroup.changed(jM11533getMainActiveControl0d7_KjU)) {
                    }
                    i3 |= i10;
                } else {
                    jM11533getMainActiveControl0d7_KjU = j;
                }
                i3 |= i10;
            } else {
                jM11533getMainActiveControl0d7_KjU = j;
            }
            i6 = i2 & 16;
            if (i6 != 0) {
                if ((i & 24576) == 0) {
                    f2 = f;
                    if (composerStartRestartGroup.changed(f2)) {
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
                    ComposerKt.sourceInformation(composerStartRestartGroup, "26@1062L6");
                    if ((i & 1) != 0) {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier3;
                        }
                        if (i4 != 0) {
                            companion2 = Modifier.INSTANCE;
                        } else {
                            companion2 = modifier4;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                        }
                        if (i6 != 0) {
                            f2 = 0.4f;
                        }
                        i8 = i3;
                        modifier7 = companion;
                        j3 = jM11533getMainActiveControl0d7_KjU;
                    } else {
                        if (i9 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier3;
                        }
                        if (i4 != 0) {
                            companion2 = Modifier.INSTANCE;
                        } else {
                            companion2 = modifier4;
                        }
                        if ((i2 & 8) != 0) {
                            i3 &= -7169;
                            jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                        }
                        if (i6 != 0) {
                            f2 = 0.4f;
                        }
                        i8 = i3;
                        modifier7 = companion;
                        j3 = jM11533getMainActiveControl0d7_KjU;
                    }
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1020801719, i8, -1, "com.box.android.base.compose.button.BoxIconButton (BoxIconButton.kt:28)");
                    }
                    final long j8 = j3;
                    final Modifier modifier12 = companion2;
                    final float f8 = f2;
                    IconButtonKt.IconButton(buttonItem.getOnClick(), modifier7, buttonItem.getIsEnabled(), (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, ComposableLambdaKt.rememberComposableLambda(426634453, true, new Function2() { // from class: com.box.android.base.compose.button.BoxIconButtonKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxIconButtonKt.BoxIconButton_uDo3WH8$lambda$0(buttonItem, j8, f8, modifier12, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, (i8 & 112) | 1572864, 56);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    f3 = f8;
                    modifier6 = companion2;
                    j2 = j8;
                    modifier5 = modifier7;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier5 = modifier3;
                    modifier6 = modifier4;
                    j2 = jM11533getMainActiveControl0d7_KjU;
                    f3 = f2;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.button.BoxIconButtonKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxIconButtonKt.BoxIconButton_uDo3WH8$lambda$1(buttonItem, modifier5, modifier6, j2, f3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            f2 = f;
            if ((i3 & 9363) != 9362) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "26@1062L6");
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier3;
                    }
                    if (i4 != 0) {
                        companion2 = Modifier.INSTANCE;
                    } else {
                        companion2 = modifier4;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                    }
                    if (i6 != 0) {
                        f2 = 0.4f;
                    }
                    i8 = i3;
                    modifier7 = companion;
                    j3 = jM11533getMainActiveControl0d7_KjU;
                } else {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier3;
                    }
                    if (i4 != 0) {
                        companion2 = Modifier.INSTANCE;
                    } else {
                        companion2 = modifier4;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                    }
                    if (i6 != 0) {
                        f2 = 0.4f;
                    }
                    i8 = i3;
                    modifier7 = companion;
                    j3 = jM11533getMainActiveControl0d7_KjU;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1020801719, i8, -1, "com.box.android.base.compose.button.BoxIconButton (BoxIconButton.kt:28)");
                }
                final long j9 = j3;
                final Modifier modifier13 = companion2;
                final float f9 = f2;
                IconButtonKt.IconButton(buttonItem.getOnClick(), modifier7, buttonItem.getIsEnabled(), (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, ComposableLambdaKt.rememberComposableLambda(426634453, true, new Function2() { // from class: com.box.android.base.compose.button.BoxIconButtonKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxIconButtonKt.BoxIconButton_uDo3WH8$lambda$0(buttonItem, j9, f9, modifier13, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i8 & 112) | 1572864, 56);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f3 = f9;
                modifier6 = companion2;
                j2 = j9;
                modifier5 = modifier7;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier5 = modifier3;
                modifier6 = modifier4;
                j2 = jM11533getMainActiveControl0d7_KjU;
                f3 = f2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.button.BoxIconButtonKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxIconButtonKt.BoxIconButton_uDo3WH8$lambda$1(buttonItem, modifier5, modifier6, j2, f3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        modifier4 = modifier2;
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                jM11533getMainActiveControl0d7_KjU = j;
                if (composerStartRestartGroup.changed(jM11533getMainActiveControl0d7_KjU)) {
                }
                i3 |= i10;
            } else {
                jM11533getMainActiveControl0d7_KjU = j;
            }
            i3 |= i10;
        } else {
            jM11533getMainActiveControl0d7_KjU = j;
        }
        i6 = i2 & 16;
        if (i6 != 0) {
            if ((i & 24576) == 0) {
                f2 = f;
                if (composerStartRestartGroup.changed(f2)) {
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
                ComposerKt.sourceInformation(composerStartRestartGroup, "26@1062L6");
                if ((i & 1) != 0) {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier3;
                    }
                    if (i4 != 0) {
                        companion2 = Modifier.INSTANCE;
                    } else {
                        companion2 = modifier4;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                    }
                    if (i6 != 0) {
                        f2 = 0.4f;
                    }
                    i8 = i3;
                    modifier7 = companion;
                    j3 = jM11533getMainActiveControl0d7_KjU;
                } else {
                    if (i9 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier3;
                    }
                    if (i4 != 0) {
                        companion2 = Modifier.INSTANCE;
                    } else {
                        companion2 = modifier4;
                    }
                    if ((i2 & 8) != 0) {
                        i3 &= -7169;
                        jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                    }
                    if (i6 != 0) {
                        f2 = 0.4f;
                    }
                    i8 = i3;
                    modifier7 = companion;
                    j3 = jM11533getMainActiveControl0d7_KjU;
                }
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1020801719, i8, -1, "com.box.android.base.compose.button.BoxIconButton (BoxIconButton.kt:28)");
                }
                final long j10 = j3;
                final Modifier modifier14 = companion2;
                final float f10 = f2;
                IconButtonKt.IconButton(buttonItem.getOnClick(), modifier7, buttonItem.getIsEnabled(), (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, ComposableLambdaKt.rememberComposableLambda(426634453, true, new Function2() { // from class: com.box.android.base.compose.button.BoxIconButtonKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxIconButtonKt.BoxIconButton_uDo3WH8$lambda$0(buttonItem, j10, f10, modifier14, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i8 & 112) | 1572864, 56);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                f3 = f10;
                modifier6 = companion2;
                j2 = j10;
                modifier5 = modifier7;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                modifier5 = modifier3;
                modifier6 = modifier4;
                j2 = jM11533getMainActiveControl0d7_KjU;
                f3 = f2;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.button.BoxIconButtonKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxIconButtonKt.BoxIconButton_uDo3WH8$lambda$1(buttonItem, modifier5, modifier6, j2, f3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        f2 = f;
        if ((i3 & 9363) != 9362) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "26@1062L6");
            if ((i & 1) != 0) {
                if (i9 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier3;
                }
                if (i4 != 0) {
                    companion2 = Modifier.INSTANCE;
                } else {
                    companion2 = modifier4;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                }
                if (i6 != 0) {
                    f2 = 0.4f;
                }
                i8 = i3;
                modifier7 = companion;
                j3 = jM11533getMainActiveControl0d7_KjU;
            } else {
                if (i9 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier3;
                }
                if (i4 != 0) {
                    companion2 = Modifier.INSTANCE;
                } else {
                    companion2 = modifier4;
                }
                if ((i2 & 8) != 0) {
                    i3 &= -7169;
                    jM11533getMainActiveControl0d7_KjU = BoxTheme.INSTANCE.getColors(composerStartRestartGroup, 6).m11533getMainActiveControl0d7_KjU();
                }
                if (i6 != 0) {
                    f2 = 0.4f;
                }
                i8 = i3;
                modifier7 = companion;
                j3 = jM11533getMainActiveControl0d7_KjU;
            }
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1020801719, i8, -1, "com.box.android.base.compose.button.BoxIconButton (BoxIconButton.kt:28)");
            }
            final long j11 = j3;
            final Modifier modifier15 = companion2;
            final float f11 = f2;
            IconButtonKt.IconButton(buttonItem.getOnClick(), modifier7, buttonItem.getIsEnabled(), (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, ComposableLambdaKt.rememberComposableLambda(426634453, true, new Function2() { // from class: com.box.android.base.compose.button.BoxIconButtonKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxIconButtonKt.BoxIconButton_uDo3WH8$lambda$0(buttonItem, j11, f11, modifier15, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i8 & 112) | 1572864, 56);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            f3 = f11;
            modifier6 = companion2;
            j2 = j11;
            modifier5 = modifier7;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            modifier5 = modifier3;
            modifier6 = modifier4;
            j2 = jM11533getMainActiveControl0d7_KjU;
            f3 = f2;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.button.BoxIconButtonKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxIconButtonKt.BoxIconButton_uDo3WH8$lambda$1(buttonItem, modifier5, modifier6, j2, f3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxIconButton_uDo3WH8$lambda$0(ButtonItem.IconButtonItem iconButtonItem, long j, float f, Modifier modifier, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:BoxIconButton.kt#171s90");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(426634453, i, -1, "com.box.android.base.compose.button.BoxIconButton.<anonymous> (BoxIconButton.kt:34)");
            }
            if (iconButtonItem.isLoading()) {
                composer.startReplaceGroup(1058802404);
                ComposerKt.sourceInformation(composer, "35@1328L177");
                float f2 = 2;
                BoxCircularProgressBarKt.m11734BoxCircularProgressBarO8KfPlw(PaddingKt.m1218padding3ABfNKs(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(24)), Dp.m9687constructorimpl(f2)), null, 0L, 0L, Dp.m9687constructorimpl(f2), 0, null, composer, 24582, 110);
                composer.endReplaceGroup();
            } else {
                composer.startReplaceGroup(1059041228);
                ComposerKt.sourceInformation(composer, "");
                ButtonItemIconResource iconResource = iconButtonItem.getIconResource();
                if (iconResource instanceof ButtonItemIconResource.DrawableResource) {
                    composer.startReplaceGroup(1059139250);
                    ComposerKt.sourceInformation(composer, "46@1739L46,44@1650L315");
                    IconKt.m3575Iconww6aTOc(PainterResources_androidKt.painterResource(((ButtonItemIconResource.DrawableResource) iconButtonItem.getIconResource()).getValue(), composer, 0), iconButtonItem.getContentDescription(), modifier, BoxColorsKt.m11586enabledek8zF_U(j, iconButtonItem.getIsEnabled(), f), composer, Painter.$stable, 0);
                    composer.endReplaceGroup();
                } else {
                    if (!(iconResource instanceof ButtonItemIconResource.ImageVectorResource)) {
                        composer.startReplaceGroup(1973825270);
                        composer.endReplaceGroup();
                        throw new NoWhenBranchMatchedException();
                    }
                    composer.startReplaceGroup(1059537631);
                    ComposerKt.sourceInformation(composer, "52@2052L302");
                    IconKt.m3576Iconww6aTOc(((ButtonItemIconResource.ImageVectorResource) iconButtonItem.getIconResource()).getValue(), iconButtonItem.getContentDescription(), modifier, BoxColorsKt.m11586enabledek8zF_U(j, iconButtonItem.getIsEnabled(), f), composer, 0, 0);
                    composer.endReplaceGroup();
                }
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final void BoxIconButtonPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(164783508);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxIconButtonPreview)68@2526L283:BoxIconButton.kt#171s90");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(164783508, i, -1, "com.box.android.base.compose.button.BoxIconButtonPreview (BoxIconButton.kt:67)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$BoxIconButtonKt.INSTANCE.m11686getLambda$684532951$base_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.button.BoxIconButtonKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxIconButtonKt.BoxIconButtonPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}

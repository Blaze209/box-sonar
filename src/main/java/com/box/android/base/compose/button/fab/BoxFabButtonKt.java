package com.box.android.base.compose.button.fab;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.EasingKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScope;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.material.icons.Icons;
import androidx.compose.material.icons.filled.AddKt;
import androidx.compose.material3.FloatingActionButtonKt;
import androidx.compose.material3.IconKt;
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
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.graphics.vector.VectorPainter;
import androidx.compose.ui.graphics.vector.VectorPainterKt;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.unit.Dp;
import androidx.profileinstaller.ProfileVerifier;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.CustomRippleConfigurationKt;
import com.facebook.react.uimanager.ViewProps;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: BoxFabButton.kt */
/* JADX INFO: loaded from: classes9.dex */
@Metadata(d1 = {"\u00000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u001aA\u0010\u0000\u001a\u00020\u00012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00010\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\f\u001a\f\u0010\r\u001a\u00020\u0007*\u00020\u000eH\u0007\u001a\r\u0010\u000f\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\u0010¨\u0006\u0011"}, d2 = {"BoxFabButton", "", ViewProps.ON_CLICK, "Lkotlin/Function0;", "contentDescription", "", "modifier", "Landroidx/compose/ui/Modifier;", "isVisible", "", "painter", "Landroidx/compose/ui/graphics/painter/Painter;", "(Lkotlin/jvm/functions/Function0;Ljava/lang/String;Landroidx/compose/ui/Modifier;ZLandroidx/compose/ui/graphics/painter/Painter;Landroidx/compose/runtime/Composer;II)V", "boxFabButtonDefaultModifier", "Landroidx/compose/foundation/layout/BoxScope;", "BoxFabButtonPreview", "(Landroidx/compose/runtime/Composer;I)V", "base_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BoxFabButtonKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxFabButton$lambda$1(Function0 function0, String str, Modifier modifier, boolean z, Painter painter, int i, int i2, Composer composer, int i3) {
        BoxFabButton(function0, str, modifier, z, painter, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxFabButtonPreview$lambda$1(int i, Composer composer, int i2) {
        BoxFabButtonPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0061  */
    /* JADX WARN: Code duplicated, block: B:31:0x0064  */
    /* JADX WARN: Code duplicated, block: B:33:0x0068  */
    /* JADX WARN: Code duplicated, block: B:35:0x0070  */
    /* JADX WARN: Code duplicated, block: B:36:0x0073  */
    /* JADX WARN: Code duplicated, block: B:41:0x007d  */
    /* JADX WARN: Code duplicated, block: B:43:0x0081  */
    /* JADX WARN: Code duplicated, block: B:45:0x0087  */
    /* JADX WARN: Code duplicated, block: B:46:0x008c  */
    /* JADX WARN: Code duplicated, block: B:48:0x0092  */
    /* JADX WARN: Code duplicated, block: B:49:0x0095  */
    /* JADX WARN: Code duplicated, block: B:53:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:54:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:57:0x00ab  */
    /* JADX WARN: Code duplicated, block: B:59:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:66:0x00cb A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:67:0x00cd  */
    /* JADX WARN: Code duplicated, block: B:69:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:72:0x00d9  */
    /* JADX WARN: Code duplicated, block: B:75:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:78:0x014b  */
    /* JADX WARN: Code duplicated, block: B:80:0x0150  */
    /* JADX WARN: Code duplicated, block: B:83:0x015c  */
    /* JADX WARN: Code duplicated, block: B:85:? A[RETURN, SYNTHETIC] */
    public static final void BoxFabButton(final Function0<Unit> onClick, final String contentDescription, Modifier modifier, boolean z, Painter painter, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z2;
        int i5;
        boolean z3;
        final boolean z4;
        final Painter painter2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i6;
        boolean zChangedInstance;
        final VectorPainter vectorPainterRememberVectorPainter = painter;
        Intrinsics.checkNotNullParameter(onClick, "onClick");
        Intrinsics.checkNotNullParameter(contentDescription, "contentDescription");
        Composer composerStartRestartGroup = composer.startRestartGroup(1257928002);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxFabButton)N(onClick,contentDescription,modifier,isVisible,painter)43@1754L495,38@1471L778:BoxFabButton.kt#m9079x");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(onClick) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(contentDescription) ? 32 : 16;
        }
        int i7 = i2 & 4;
        if (i7 == 0) {
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
                if ((i & 24576) == 0) {
                    if ((i2 & 16) != 0) {
                        i6 = 8192;
                    } else {
                        if ((32768 & i) == 0) {
                            zChangedInstance = composerStartRestartGroup.changed(vectorPainterRememberVectorPainter);
                        } else {
                            zChangedInstance = composerStartRestartGroup.changedInstance(vectorPainterRememberVectorPainter);
                        }
                        if (zChangedInstance) {
                            i6 = 16384;
                        } else {
                            i6 = 8192;
                        }
                    }
                    i3 |= i6;
                }
                if ((i3 & 9363) != 9362) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.startDefaults();
                    ComposerKt.sourceInformation(composerStartRestartGroup, "36@1423L39");
                    if ((i & 1) != 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                        if (i7 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z2 = true;
                        }
                        if ((i2 & 16) != 0) {
                            vectorPainterRememberVectorPainter = VectorPainterKt.rememberVectorPainter(AddKt.getAdd(Icons.Filled.INSTANCE), composerStartRestartGroup, 0);
                            i3 &= -57345;
                        }
                    } else {
                        composerStartRestartGroup.skipToGroupEnd();
                        if ((i2 & 16) != 0) {
                            i3 &= -57345;
                        }
                    }
                    boolean z5 = z2;
                    composerStartRestartGroup.endDefaults();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(1257928002, i3, -1, "com.box.android.base.compose.button.fab.BoxFabButton (BoxFabButton.kt:37)");
                    }
                    AnimatedVisibilityKt.AnimatedVisibility(z5, modifier2, EnterExitTransitionKt.m389scaleInL8ZKhE$default(AnimationSpecKt.tween$default(80, 0, EasingKt.getFastOutSlowInEasing(), 2, null), 0.0f, 0L, 6, null), EnterExitTransitionKt.m391scaleOutL8ZKhE$default(AnimationSpecKt.tween$default(80, 0, EasingKt.getFastOutLinearInEasing(), 2, null), 0.0f, 0L, 6, null), (String) null, ComposableLambdaKt.rememberComposableLambda(1784239466, true, new Function3() { // from class: com.box.android.base.compose.button.fab.BoxFabButtonKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function3
                        public final Object invoke(Object obj, Object obj2, Object obj3) {
                            return BoxFabButtonKt.BoxFabButton$lambda$0(onClick, vectorPainterRememberVectorPainter, contentDescription, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 9) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | ((i3 >> 3) & 112), 16);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    z4 = z5;
                } else {
                    composerStartRestartGroup.skipToGroupEnd();
                    z4 = z2;
                }
                painter2 = vectorPainterRememberVectorPainter;
                modifier3 = modifier2;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.button.fab.BoxFabButtonKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BoxFabButtonKt.BoxFabButton$lambda$1(onClick, contentDescription, modifier3, z4, painter2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            z2 = z;
            if ((i & 24576) == 0) {
                if ((i2 & 16) != 0) {
                    i6 = 8192;
                } else {
                    if ((32768 & i) == 0) {
                        zChangedInstance = composerStartRestartGroup.changed(vectorPainterRememberVectorPainter);
                    } else {
                        zChangedInstance = composerStartRestartGroup.changedInstance(vectorPainterRememberVectorPainter);
                    }
                    if (zChangedInstance) {
                        i6 = 16384;
                    } else {
                        i6 = 8192;
                    }
                }
                i3 |= i6;
            }
            if ((i3 & 9363) != 9362) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "36@1423L39");
                if ((i & 1) != 0) {
                    if (i7 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 16) != 0) {
                        vectorPainterRememberVectorPainter = VectorPainterKt.rememberVectorPainter(AddKt.getAdd(Icons.Filled.INSTANCE), composerStartRestartGroup, 0);
                        i3 &= -57345;
                    }
                } else {
                    if (i7 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 16) != 0) {
                        vectorPainterRememberVectorPainter = VectorPainterKt.rememberVectorPainter(AddKt.getAdd(Icons.Filled.INSTANCE), composerStartRestartGroup, 0);
                        i3 &= -57345;
                    }
                }
                boolean z6 = z2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1257928002, i3, -1, "com.box.android.base.compose.button.fab.BoxFabButton (BoxFabButton.kt:37)");
                }
                AnimatedVisibilityKt.AnimatedVisibility(z6, modifier2, EnterExitTransitionKt.m389scaleInL8ZKhE$default(AnimationSpecKt.tween$default(80, 0, EasingKt.getFastOutSlowInEasing(), 2, null), 0.0f, 0L, 6, null), EnterExitTransitionKt.m391scaleOutL8ZKhE$default(AnimationSpecKt.tween$default(80, 0, EasingKt.getFastOutLinearInEasing(), 2, null), 0.0f, 0L, 6, null), (String) null, ComposableLambdaKt.rememberComposableLambda(1784239466, true, new Function3() { // from class: com.box.android.base.compose.button.fab.BoxFabButtonKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return BoxFabButtonKt.BoxFabButton$lambda$0(onClick, vectorPainterRememberVectorPainter, contentDescription, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 9) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | ((i3 >> 3) & 112), 16);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z4 = z6;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                z4 = z2;
            }
            painter2 = vectorPainterRememberVectorPainter;
            modifier3 = modifier2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.button.fab.BoxFabButtonKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxFabButtonKt.BoxFabButton$lambda$1(onClick, contentDescription, modifier3, z4, painter2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
            if ((i & 24576) == 0) {
                if ((i2 & 16) != 0) {
                    i6 = 8192;
                } else {
                    if ((32768 & i) == 0) {
                        zChangedInstance = composerStartRestartGroup.changed(vectorPainterRememberVectorPainter);
                    } else {
                        zChangedInstance = composerStartRestartGroup.changedInstance(vectorPainterRememberVectorPainter);
                    }
                    if (zChangedInstance) {
                        i6 = 16384;
                    } else {
                        i6 = 8192;
                    }
                }
                i3 |= i6;
            }
            if ((i3 & 9363) != 9362) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.startDefaults();
                ComposerKt.sourceInformation(composerStartRestartGroup, "36@1423L39");
                if ((i & 1) != 0) {
                    if (i7 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 16) != 0) {
                        vectorPainterRememberVectorPainter = VectorPainterKt.rememberVectorPainter(AddKt.getAdd(Icons.Filled.INSTANCE), composerStartRestartGroup, 0);
                        i3 &= -57345;
                    }
                } else {
                    if (i7 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z2 = true;
                    }
                    if ((i2 & 16) != 0) {
                        vectorPainterRememberVectorPainter = VectorPainterKt.rememberVectorPainter(AddKt.getAdd(Icons.Filled.INSTANCE), composerStartRestartGroup, 0);
                        i3 &= -57345;
                    }
                }
                boolean z7 = z2;
                composerStartRestartGroup.endDefaults();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1257928002, i3, -1, "com.box.android.base.compose.button.fab.BoxFabButton (BoxFabButton.kt:37)");
                }
                AnimatedVisibilityKt.AnimatedVisibility(z7, modifier2, EnterExitTransitionKt.m389scaleInL8ZKhE$default(AnimationSpecKt.tween$default(80, 0, EasingKt.getFastOutSlowInEasing(), 2, null), 0.0f, 0L, 6, null), EnterExitTransitionKt.m391scaleOutL8ZKhE$default(AnimationSpecKt.tween$default(80, 0, EasingKt.getFastOutLinearInEasing(), 2, null), 0.0f, 0L, 6, null), (String) null, ComposableLambdaKt.rememberComposableLambda(1784239466, true, new Function3() { // from class: com.box.android.base.compose.button.fab.BoxFabButtonKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return BoxFabButtonKt.BoxFabButton$lambda$0(onClick, vectorPainterRememberVectorPainter, contentDescription, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 9) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | ((i3 >> 3) & 112), 16);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                z4 = z7;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                z4 = z2;
            }
            painter2 = vectorPainterRememberVectorPainter;
            modifier3 = modifier2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.button.fab.BoxFabButtonKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BoxFabButtonKt.BoxFabButton$lambda$1(onClick, contentDescription, modifier3, z4, painter2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        z2 = z;
        if ((i & 24576) == 0) {
            if ((i2 & 16) != 0) {
                i6 = 8192;
            } else {
                if ((32768 & i) == 0) {
                    zChangedInstance = composerStartRestartGroup.changed(vectorPainterRememberVectorPainter);
                } else {
                    zChangedInstance = composerStartRestartGroup.changedInstance(vectorPainterRememberVectorPainter);
                }
                if (zChangedInstance) {
                    i6 = 16384;
                } else {
                    i6 = 8192;
                }
            }
            i3 |= i6;
        }
        if ((i3 & 9363) != 9362) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "36@1423L39");
            if ((i & 1) != 0) {
                if (i7 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    z2 = true;
                }
                if ((i2 & 16) != 0) {
                    vectorPainterRememberVectorPainter = VectorPainterKt.rememberVectorPainter(AddKt.getAdd(Icons.Filled.INSTANCE), composerStartRestartGroup, 0);
                    i3 &= -57345;
                }
            } else {
                if (i7 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    z2 = true;
                }
                if ((i2 & 16) != 0) {
                    vectorPainterRememberVectorPainter = VectorPainterKt.rememberVectorPainter(AddKt.getAdd(Icons.Filled.INSTANCE), composerStartRestartGroup, 0);
                    i3 &= -57345;
                }
            }
            boolean z8 = z2;
            composerStartRestartGroup.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1257928002, i3, -1, "com.box.android.base.compose.button.fab.BoxFabButton (BoxFabButton.kt:37)");
            }
            AnimatedVisibilityKt.AnimatedVisibility(z8, modifier2, EnterExitTransitionKt.m389scaleInL8ZKhE$default(AnimationSpecKt.tween$default(80, 0, EasingKt.getFastOutSlowInEasing(), 2, null), 0.0f, 0L, 6, null), EnterExitTransitionKt.m391scaleOutL8ZKhE$default(AnimationSpecKt.tween$default(80, 0, EasingKt.getFastOutLinearInEasing(), 2, null), 0.0f, 0L, 6, null), (String) null, ComposableLambdaKt.rememberComposableLambda(1784239466, true, new Function3() { // from class: com.box.android.base.compose.button.fab.BoxFabButtonKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return BoxFabButtonKt.BoxFabButton$lambda$0(onClick, vectorPainterRememberVectorPainter, contentDescription, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, ((i3 >> 9) & 14) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE | ((i3 >> 3) & 112), 16);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            z4 = z8;
        } else {
            composerStartRestartGroup.skipToGroupEnd();
            z4 = z2;
        }
        painter2 = vectorPainterRememberVectorPainter;
        modifier3 = modifier2;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.button.fab.BoxFabButtonKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxFabButtonKt.BoxFabButton$lambda$1(onClick, contentDescription, modifier3, z4, painter2, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxFabButton$lambda$0(final Function0 function0, final Painter painter, final String str, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation(composer, "C45@1826L6,46@1860L383,44@1764L479:BoxFabButton.kt#m9079x");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1784239466, i, -1, "com.box.android.base.compose.button.fab.BoxFabButton.<anonymous> (BoxFabButton.kt:44)");
        }
        CustomRippleConfigurationKt.m11643CustomRippleConfiguration3JVO9M(BoxTheme.INSTANCE.getColors(composer, 6).m11519getFabButtonContent0d7_KjU(), ComposableLambdaKt.rememberComposableLambda(-701926687, true, new Function2() { // from class: com.box.android.base.compose.button.fab.BoxFabButtonKt$$ExternalSyntheticLambda3
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return BoxFabButtonKt.BoxFabButton$lambda$0$0(function0, painter, str, (Composer) obj, ((Integer) obj2).intValue());
            }
        }, composer, 54), composer, 48, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxFabButton$lambda$0$0(Function0 function0, final Painter painter, final String str, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C49@1973L6,50@2041L6,51@2079L154,47@1874L359:BoxFabButton.kt#m9079x");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-701926687, i, -1, "com.box.android.base.compose.button.fab.BoxFabButton.<anonymous>.<anonymous> (BoxFabButton.kt:47)");
            }
            FloatingActionButtonKt.m3394FloatingActionButtonXz6DiA(function0, null, null, BoxTheme.INSTANCE.getColors(composer, 6).m11518getFabButtonBackground0d7_KjU(), BoxTheme.INSTANCE.getColors(composer, 6).m11519getFabButtonContent0d7_KjU(), null, null, ComposableLambdaKt.rememberComposableLambda(1930628067, true, new Function2() { // from class: com.box.android.base.compose.button.fab.BoxFabButtonKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxFabButtonKt.BoxFabButton$lambda$0$0$0(painter, str, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 12582912, 102);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BoxFabButton$lambda$0$0$0(Painter painter, String str, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C52@2097L122:BoxFabButton.kt#m9079x");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1930628067, i, -1, "com.box.android.base.compose.button.fab.BoxFabButton.<anonymous>.<anonymous>.<anonymous> (BoxFabButton.kt:52)");
            }
            IconKt.m3575Iconww6aTOc(painter, str, (Modifier) null, 0L, composer, Painter.$stable, 12);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    public static final Modifier boxFabButtonDefaultModifier(BoxScope boxScope) {
        Intrinsics.checkNotNullParameter(boxScope, "<this>");
        return PaddingKt.m1218padding3ABfNKs(boxScope.align(Modifier.INSTANCE, Alignment.INSTANCE.getBottomEnd()), Dp.m9687constructorimpl(16));
    }

    private static final void BoxFabButtonPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(332039153);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BoxFabButtonPreview)76@2755L71:BoxFabButton.kt#m9079x");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(332039153, i, -1, "com.box.android.base.compose.button.fab.BoxFabButtonPreview (BoxFabButton.kt:75)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            Modifier.Companion companion = Modifier.INSTANCE;
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, companion);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1810076059, "C77@2792L2,77@2769L51:BoxFabButton.kt#m9079x");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 357253133, "CC(remember):BoxFabButton.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.base.compose.button.fab.BoxFabButtonKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return Unit.INSTANCE;
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            BoxFabButton((Function0) objRememberedValue, "", null, false, null, composerStartRestartGroup, 54, 28);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.base.compose.button.fab.BoxFabButtonKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BoxFabButtonKt.BoxFabButtonPreview$lambda$1(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }
}

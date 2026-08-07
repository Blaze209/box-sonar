package com.box.android.preview.preview.previewbar;

import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.animation.ExitTransition;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.ButtonColors;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
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
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: AnimatedPreviewBar.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000&\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\u001a:\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\u0011\u0010\b\u001a\r\u0012\u0004\u0012\u00020\u00010\t¢\u0006\u0002\b\nH\u0007¢\u0006\u0002\u0010\u000b\u001a\r\u0010\f\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010\r¨\u0006\u000e²\u0006\n\u0010\u000f\u001a\u00020\u0003X\u008a\u008e\u0002"}, d2 = {"AnimatedPreviewBar", "", ViewProps.VISIBLE, "", "type", "Lcom/box/android/preview/preview/previewbar/PreviewBarType;", "modifier", "Landroidx/compose/ui/Modifier;", "content", "Lkotlin/Function0;", "Landroidx/compose/runtime/Composable;", "(ZLcom/box/android/preview/preview/previewbar/PreviewBarType;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;II)V", "AnimatedPreviewBarPreview", "(Landroidx/compose/runtime/Composer;I)V", "preview_generalProdRelease", "isVisible"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class AnimatedPreviewBarKt {

    /* JADX INFO: compiled from: AnimatedPreviewBar.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[PreviewBarType.values().length];
            try {
                iArr[PreviewBarType.TOP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[PreviewBarType.BOTTOM.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int AnimatedPreviewBar$lambda$0$0(int i) {
        return -i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int AnimatedPreviewBar$lambda$1$0(int i) {
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int AnimatedPreviewBar$lambda$2$0(int i) {
        return -i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int AnimatedPreviewBar$lambda$3$0(int i) {
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AnimatedPreviewBar$lambda$5(boolean z, PreviewBarType previewBarType, Modifier modifier, Function2 function2, int i, int i2, Composer composer, int i3) {
        AnimatedPreviewBar(z, previewBarType, modifier, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AnimatedPreviewBarPreview$lambda$4(int i, Composer composer, int i2) {
        AnimatedPreviewBarPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x0066  */
    /* JADX WARN: Code duplicated, block: B:32:0x006c  */
    /* JADX WARN: Code duplicated, block: B:33:0x006f  */
    /* JADX WARN: Code duplicated, block: B:37:0x0079  */
    /* JADX WARN: Code duplicated, block: B:38:0x007b  */
    /* JADX WARN: Code duplicated, block: B:41:0x0084 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:42:0x0086  */
    /* JADX WARN: Code duplicated, block: B:45:0x0091  */
    /* JADX WARN: Code duplicated, block: B:48:0x00a4 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:49:0x00a6  */
    /* JADX WARN: Code duplicated, block: B:51:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:53:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:55:0x00e7  */
    /* JADX WARN: Code duplicated, block: B:57:0x0104  */
    /* JADX WARN: Code duplicated, block: B:61:0x0122 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:62:0x0124  */
    /* JADX WARN: Code duplicated, block: B:64:0x0141  */
    /* JADX WARN: Code duplicated, block: B:66:0x0156  */
    /* JADX WARN: Code duplicated, block: B:68:0x0165  */
    /* JADX WARN: Code duplicated, block: B:70:0x0182  */
    /* JADX WARN: Code duplicated, block: B:74:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:75:0x01c6  */
    /* JADX WARN: Code duplicated, block: B:78:0x01d0  */
    /* JADX WARN: Code duplicated, block: B:80:? A[RETURN, SYNTHETIC] */
    public static final void AnimatedPreviewBar(final boolean z, final PreviewBarType type, Modifier modifier, final Function2<? super Composer, ? super Integer, Unit> content, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        boolean z2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i4;
        Object objRememberedValue;
        EnterTransition enterTransitionSlideInVertically$default;
        int i5;
        Object objRememberedValue2;
        ExitTransition exitTransitionSlideOutVertically$default;
        Object objRememberedValue3;
        Object objRememberedValue4;
        int i6;
        Intrinsics.checkNotNullParameter(type, "type");
        Intrinsics.checkNotNullParameter(content, "content");
        Composer composerStartRestartGroup = composer.startRestartGroup(1461757905);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AnimatedPreviewBar)N(visible,type,modifier,content)53@1821L13,47@1627L213:AnimatedPreviewBar.kt#rtxr0a");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(type.ordinal()) ? 32 : 16;
        }
        int i7 = i2 & 4;
        if (i7 == 0) {
            if ((i & 384) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 256 : 128;
            }
            if ((i & 3072) == 0) {
                if (composerStartRestartGroup.changedInstance(content)) {
                    i6 = 2048;
                } else {
                    i6 = 1024;
                }
                i3 |= i6;
            }
            if ((i3 & 1171) != 1170) {
                z2 = true;
            } else {
                z2 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
            } else {
                if (i7 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1461757905, i3, -1, "com.box.android.preview.preview.previewbar.AnimatedPreviewBar (AnimatedPreviewBar.kt:36)");
                }
                i4 = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
                if (i4 != 1) {
                    composerStartRestartGroup.startReplaceGroup(295047864);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "38@1333L21");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 295048422, "CC(remember):AnimatedPreviewBar.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: com.box.android.preview.preview.previewbar.AnimatedPreviewBarKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Integer.valueOf(AnimatedPreviewBarKt.AnimatedPreviewBar$lambda$0$0(((Integer) obj).intValue()));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    enterTransitionSlideInVertically$default = EnterExitTransitionKt.slideInVertically$default(null, (Function1) objRememberedValue, 1, null);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    if (i4 == 2) {
                        composerStartRestartGroup.startReplaceGroup(295046578);
                        composerStartRestartGroup.endReplaceGroup();
                        throw new NoWhenBranchMatchedException();
                    }
                    composerStartRestartGroup.startReplaceGroup(295050199);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "39@1406L20");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 295050757, "CC(remember):AnimatedPreviewBar.kt#9igjgp");
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new Function1() { // from class: com.box.android.preview.preview.previewbar.AnimatedPreviewBarKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Integer.valueOf(AnimatedPreviewBarKt.AnimatedPreviewBar$lambda$1$0(((Integer) obj).intValue()));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    enterTransitionSlideInVertically$default = EnterExitTransitionKt.slideInVertically$default(null, (Function1) objRememberedValue4, 1, null);
                    composerStartRestartGroup.endReplaceGroup();
                }
                i5 = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
                if (i5 != 1) {
                    composerStartRestartGroup.startReplaceGroup(295053849);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "43@1521L21");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 295054438, "CC(remember):AnimatedPreviewBar.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function1() { // from class: com.box.android.preview.preview.previewbar.AnimatedPreviewBarKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Integer.valueOf(AnimatedPreviewBarKt.AnimatedPreviewBar$lambda$2$0(((Integer) obj).intValue()));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    exitTransitionSlideOutVertically$default = EnterExitTransitionKt.slideOutVertically$default(null, (Function1) objRememberedValue2, 1, null);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    if (i5 == 2) {
                        composerStartRestartGroup.startReplaceGroup(295052564);
                        composerStartRestartGroup.endReplaceGroup();
                        throw new NoWhenBranchMatchedException();
                    }
                    composerStartRestartGroup.startReplaceGroup(295056216);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "44@1595L20");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 295056805, "CC(remember):AnimatedPreviewBar.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function1() { // from class: com.box.android.preview.preview.previewbar.AnimatedPreviewBarKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return Integer.valueOf(AnimatedPreviewBarKt.AnimatedPreviewBar$lambda$3$0(((Integer) obj).intValue()));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    exitTransitionSlideOutVertically$default = EnterExitTransitionKt.slideOutVertically$default(null, (Function1) objRememberedValue3, 1, null);
                    composerStartRestartGroup.endReplaceGroup();
                }
                AnimatedVisibilityKt.AnimatedVisibility(z, modifier2, enterTransitionSlideInVertically$default, exitTransitionSlideOutVertically$default, "AnimatedPreviewBar", ComposableLambdaKt.rememberComposableLambda(271762601, true, new Function3() { // from class: com.box.android.preview.preview.previewbar.AnimatedPreviewBarKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return AnimatedPreviewBarKt.AnimatedPreviewBar$lambda$4(content, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, (i3 & 14) | 221184 | ((i3 >> 3) & 112), 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
            modifier3 = modifier2;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.preview.previewbar.AnimatedPreviewBarKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return AnimatedPreviewBarKt.AnimatedPreviewBar$lambda$5(z, type, modifier3, content, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        modifier2 = modifier;
        if ((i & 3072) == 0) {
            if (composerStartRestartGroup.changedInstance(content)) {
                i6 = 2048;
            } else {
                i6 = 1024;
            }
            i3 |= i6;
        }
        if ((i3 & 1171) != 1170) {
            z2 = true;
        } else {
            z2 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z2, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (i7 != 0) {
                modifier2 = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1461757905, i3, -1, "com.box.android.preview.preview.previewbar.AnimatedPreviewBar (AnimatedPreviewBar.kt:36)");
            }
            i4 = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
            if (i4 != 1) {
                composerStartRestartGroup.startReplaceGroup(295047864);
                ComposerKt.sourceInformation(composerStartRestartGroup, "38@1333L21");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 295048422, "CC(remember):AnimatedPreviewBar.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.box.android.preview.preview.previewbar.AnimatedPreviewBarKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Integer.valueOf(AnimatedPreviewBarKt.AnimatedPreviewBar$lambda$0$0(((Integer) obj).intValue()));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                enterTransitionSlideInVertically$default = EnterExitTransitionKt.slideInVertically$default(null, (Function1) objRememberedValue, 1, null);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                if (i4 == 2) {
                    composerStartRestartGroup.startReplaceGroup(295046578);
                    composerStartRestartGroup.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
                composerStartRestartGroup.startReplaceGroup(295050199);
                ComposerKt.sourceInformation(composerStartRestartGroup, "39@1406L20");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 295050757, "CC(remember):AnimatedPreviewBar.kt#9igjgp");
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new Function1() { // from class: com.box.android.preview.preview.previewbar.AnimatedPreviewBarKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Integer.valueOf(AnimatedPreviewBarKt.AnimatedPreviewBar$lambda$1$0(((Integer) obj).intValue()));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                enterTransitionSlideInVertically$default = EnterExitTransitionKt.slideInVertically$default(null, (Function1) objRememberedValue4, 1, null);
                composerStartRestartGroup.endReplaceGroup();
            }
            i5 = WhenMappings.$EnumSwitchMapping$0[type.ordinal()];
            if (i5 != 1) {
                composerStartRestartGroup.startReplaceGroup(295053849);
                ComposerKt.sourceInformation(composerStartRestartGroup, "43@1521L21");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 295054438, "CC(remember):AnimatedPreviewBar.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: com.box.android.preview.preview.previewbar.AnimatedPreviewBarKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Integer.valueOf(AnimatedPreviewBarKt.AnimatedPreviewBar$lambda$2$0(((Integer) obj).intValue()));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                exitTransitionSlideOutVertically$default = EnterExitTransitionKt.slideOutVertically$default(null, (Function1) objRememberedValue2, 1, null);
                composerStartRestartGroup.endReplaceGroup();
            } else {
                if (i5 == 2) {
                    composerStartRestartGroup.startReplaceGroup(295052564);
                    composerStartRestartGroup.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
                composerStartRestartGroup.startReplaceGroup(295056216);
                ComposerKt.sourceInformation(composerStartRestartGroup, "44@1595L20");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 295056805, "CC(remember):AnimatedPreviewBar.kt#9igjgp");
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function1() { // from class: com.box.android.preview.preview.previewbar.AnimatedPreviewBarKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return Integer.valueOf(AnimatedPreviewBarKt.AnimatedPreviewBar$lambda$3$0(((Integer) obj).intValue()));
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                exitTransitionSlideOutVertically$default = EnterExitTransitionKt.slideOutVertically$default(null, (Function1) objRememberedValue3, 1, null);
                composerStartRestartGroup.endReplaceGroup();
            }
            AnimatedVisibilityKt.AnimatedVisibility(z, modifier2, enterTransitionSlideInVertically$default, exitTransitionSlideOutVertically$default, "AnimatedPreviewBar", ComposableLambdaKt.rememberComposableLambda(271762601, true, new Function3() { // from class: com.box.android.preview.preview.previewbar.AnimatedPreviewBarKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AnimatedPreviewBarKt.AnimatedPreviewBar$lambda$4(content, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, (i3 & 14) | 221184 | ((i3 >> 3) & 112), 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        modifier3 = modifier2;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.preview.previewbar.AnimatedPreviewBarKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AnimatedPreviewBarKt.AnimatedPreviewBar$lambda$5(z, type, modifier3, content, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AnimatedPreviewBar$lambda$4(Function2 function2, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation(composer, "C53@1823L9:AnimatedPreviewBar.kt#rtxr0a");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(271762601, i, -1, "com.box.android.preview.preview.previewbar.AnimatedPreviewBar.<anonymous> (AnimatedPreviewBar.kt:53)");
        }
        function2.invoke(composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    private static final void AnimatedPreviewBarPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-282950334);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(AnimatedPreviewBarPreview)62@1981L33,64@2020L1252:AnimatedPreviewBar.kt#rtxr0a");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-282950334, i, -1, "com.box.android.preview.preview.previewbar.AnimatedPreviewBarPreview (AnimatedPreviewBar.kt:61)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1332329533, "CC(remember):AnimatedPreviewBar.kt#9igjgp");
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(true, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierFillMaxSize$default = SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composerStartRestartGroup, 0);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierFillMaxSize$default);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyColumnMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1630387039, "C65@2072L418,80@2500L332,93@2842L424:AnimatedPreviewBar.kt#rtxr0a");
            AnimatedPreviewBar(AnimatedPreviewBarPreview$lambda$1(mutableState), PreviewBarType.TOP, null, ComposableSingletons$AnimatedPreviewBarKt.INSTANCE.getLambda$48330998$preview_generalProdRelease(), composerStartRestartGroup, 3120, 4);
            Modifier modifierWeight$default = ColumnScope.weight$default(columnScopeInstance, SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), 1.0f, false, 2, null);
            Alignment center = Alignment.INSTANCE.getCenter();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(center, false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierWeight$default);
            Function0<ComposeUiNode> constructor2 = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composerStartRestartGroup.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composerStartRestartGroup.startReusableNode();
            if (composerStartRestartGroup.getInserting()) {
                composerStartRestartGroup.createNode(constructor2);
            } else {
                composerStartRestartGroup.useNode();
            }
            Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 325470540, "C87@2703L26,88@2744L78,86@2669L153:AnimatedPreviewBar.kt#rtxr0a");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1534520664, "CC(remember):AnimatedPreviewBar.kt#9igjgp");
            Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.preview.preview.previewbar.AnimatedPreviewBarKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return AnimatedPreviewBarKt.AnimatedPreviewBarPreview$lambda$3$0$0$0(mutableState);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ButtonKt.Button((Function0<Unit>) objRememberedValue2, (Modifier) null, false, (Shape) null, (ButtonColors) null, (ButtonElevation) null, (BorderStroke) null, (PaddingValues) null, (MutableInteractionSource) null, (Function3<? super RowScope, ? super Composer, ? super Integer, Unit>) ComposableLambdaKt.rememberComposableLambda(513626798, true, new Function3() { // from class: com.box.android.preview.preview.previewbar.AnimatedPreviewBarKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return AnimatedPreviewBarKt.AnimatedPreviewBarPreview$lambda$3$0$1(mutableState, (RowScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 805306374, 510);
            composerStartRestartGroup = composerStartRestartGroup;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            AnimatedPreviewBar(AnimatedPreviewBarPreview$lambda$1(mutableState), PreviewBarType.BOTTOM, null, ComposableSingletons$AnimatedPreviewBarKt.INSTANCE.m12867getLambda$1548954835$preview_generalProdRelease(), composerStartRestartGroup, 3120, 4);
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
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.preview.preview.previewbar.AnimatedPreviewBarKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return AnimatedPreviewBarKt.AnimatedPreviewBarPreview$lambda$4(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final boolean AnimatedPreviewBarPreview$lambda$1(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void AnimatedPreviewBarPreview$lambda$2(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AnimatedPreviewBarPreview$lambda$3$0$0$0(MutableState mutableState) {
        AnimatedPreviewBarPreview$lambda$2(mutableState, !AnimatedPreviewBarPreview$lambda$1(mutableState));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit AnimatedPreviewBarPreview$lambda$3$0$1(MutableState mutableState, RowScope Button, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(Button, "$this$Button");
        ComposerKt.sourceInformation(composer, "C89@2762L46:AnimatedPreviewBar.kt#rtxr0a");
        if (!composer.shouldExecute((i & 17) != 16, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(513626798, i, -1, "com.box.android.preview.preview.previewbar.AnimatedPreviewBarPreview.<anonymous>.<anonymous>.<anonymous> (AnimatedPreviewBar.kt:89)");
            }
            TextKt.m4494TextNvy7gAk(AnimatedPreviewBarPreview$lambda$1(mutableState) ? "Hide" : "Show", null, 0L, null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, null, composer, 0, 0, 262142);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}

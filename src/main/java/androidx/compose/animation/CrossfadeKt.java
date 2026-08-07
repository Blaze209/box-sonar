package androidx.compose.animation;

import androidx.collection.MutableScatterMap;
import androidx.collection.ScatterMapKt;
import androidx.compose.animation.core.AnimationSpecKt;
import androidx.compose.animation.core.FiniteAnimationSpec;
import androidx.compose.animation.core.Transition;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.snapshots.SnapshotStateList;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.exifinterface.media.ExifInterface;
import java.util.Iterator;
import java.util.List;
import kotlin.Deprecated;
import kotlin.DeprecationLevel;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: Crossfade.kt */
/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000@\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0003\u001aX\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010\u000e\u001aN\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u00022\u0006\u0010\u0003\u001a\u0002H\u00022\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072\u0017\u0010\u000b\u001a\u0013\u0012\u0004\u0012\u0002H\u0002\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010\u000f\u001a\u0086\u0001\u0010\u0000\u001a\u00020\u0001\"\u0004\b\u0000\u0010\u0002*\b\u0012\u0004\u0012\u0002H\u00020\u00102\b\b\u0002\u0010\u0004\u001a\u00020\u00052\u000e\b\u0002\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\b0\u00072%\b\u0002\u0010\u0011\u001a\u001f\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0003\u0012\u0006\u0012\u0004\u0018\u00010\u00140\f2&\u0010\u000b\u001a\"\u0012\u0013\u0012\u0011H\u0002¢\u0006\f\b\u0012\u0012\b\b\u0013\u0012\u0004\b\b(\u0003\u0012\u0004\u0012\u00020\u00010\f¢\u0006\u0002\b\rH\u0007¢\u0006\u0002\u0010\u0015¨\u0006\u0016²\u0006\n\u0010\u0017\u001a\u00020\bX\u008a\u0084\u0002"}, d2 = {"Crossfade", "", ExifInterface.GPS_DIRECTION_TRUE, "targetState", "modifier", "Landroidx/compose/ui/Modifier;", "animationSpec", "Landroidx/compose/animation/core/FiniteAnimationSpec;", "", "label", "", "content", "Lkotlin/Function1;", "Landroidx/compose/runtime/Composable;", "(Ljava/lang/Object;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/core/FiniteAnimationSpec;Ljava/lang/String;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "(Ljava/lang/Object;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "Landroidx/compose/animation/core/Transition;", "contentKey", "Lkotlin/ParameterName;", "name", "", "(Landroidx/compose/animation/core/Transition;Landroidx/compose/ui/Modifier;Landroidx/compose/animation/core/FiniteAnimationSpec;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function3;Landroidx/compose/runtime/Composer;II)V", "animation", "alpha"}, k = 2, mv = {2, 0, 0}, xi = 48)
public final class CrossfadeKt {
    /* JADX WARN: Code duplicated, block: B:26:0x004b  */
    /* JADX WARN: Code duplicated, block: B:27:0x004e  */
    /* JADX WARN: Code duplicated, block: B:29:0x0052  */
    /* JADX WARN: Code duplicated, block: B:31:0x005a  */
    /* JADX WARN: Code duplicated, block: B:32:0x005d  */
    /* JADX WARN: Code duplicated, block: B:37:0x0067  */
    /* JADX WARN: Code duplicated, block: B:38:0x006a  */
    /* JADX WARN: Code duplicated, block: B:40:0x006e  */
    /* JADX WARN: Code duplicated, block: B:42:0x0076  */
    /* JADX WARN: Code duplicated, block: B:43:0x0079  */
    /* JADX WARN: Code duplicated, block: B:48:0x0085  */
    /* JADX WARN: Code duplicated, block: B:50:0x008b  */
    /* JADX WARN: Code duplicated, block: B:51:0x008e  */
    /* JADX WARN: Code duplicated, block: B:55:0x0098  */
    /* JADX WARN: Code duplicated, block: B:56:0x009a  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a3 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:60:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:61:0x00ad  */
    /* JADX WARN: Code duplicated, block: B:63:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:64:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:66:0x00be  */
    /* JADX WARN: Code duplicated, block: B:67:0x00c1  */
    /* JADX WARN: Code duplicated, block: B:70:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:73:0x00ea  */
    /* JADX WARN: Code duplicated, block: B:75:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:78:0x00fe  */
    /* JADX WARN: Code duplicated, block: B:80:? A[RETURN, SYNTHETIC] */
    public static final <T> void Crossfade(final T t, Modifier modifier, FiniteAnimationSpec<Float> finiteAnimationSpec, String str, final Function3<? super T, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        FiniteAnimationSpec<Float> finiteAnimationSpec2;
        int i5;
        int i6;
        int i7;
        boolean z;
        final Modifier modifier3;
        final FiniteAnimationSpec<Float> finiteAnimationSpec3;
        final String str2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        int i8;
        Modifier modifier4;
        FiniteAnimationSpec<Float> finiteAnimationSpecTween$default;
        String str3;
        int i9;
        Composer composerStartRestartGroup = composer.startRestartGroup(-513216493);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Crossfade)P(4,3!1,2)56@2427L36,57@2479L53:Crossfade.kt#xbi5r1");
        if ((i & 6) == 0) {
            i3 = ((i & 8) == 0 ? composerStartRestartGroup.changed(t) : composerStartRestartGroup.changedInstance(t) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i10 = i2 & 2;
        if (i10 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i4 = i2 & 4;
            if (i4 != 0) {
                if ((i & 384) == 0) {
                    finiteAnimationSpec2 = finiteAnimationSpec;
                    if (composerStartRestartGroup.changedInstance(finiteAnimationSpec2)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    if ((i & 3072) == 0) {
                        if (composerStartRestartGroup.changed(str)) {
                            i7 = 2048;
                        } else {
                            i7 = 1024;
                        }
                        i3 |= i7;
                    }
                    if ((i & 24576) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    if ((i3 & 9363) != 9362) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        finiteAnimationSpec3 = finiteAnimationSpec2;
                        str2 = str;
                    } else {
                        if (i10 != 0) {
                            modifier4 = Modifier.INSTANCE;
                            i8 = i6;
                        } else {
                            i8 = i6;
                            modifier4 = modifier2;
                        }
                        if (i4 != 0) {
                            finiteAnimationSpecTween$default = AnimationSpecKt.tween$default(0, 0, null, 7, null);
                        } else {
                            finiteAnimationSpecTween$default = finiteAnimationSpec2;
                        }
                        if (i8 != 0) {
                            str3 = "Crossfade";
                        } else {
                            str3 = str;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-513216493, i3, -1, "androidx.compose.animation.Crossfade (Crossfade.kt:55)");
                        }
                        Crossfade(androidx.compose.animation.core.TransitionKt.updateTransition(t, str3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 6) & 112), 0), modifier4, finiteAnimationSpecTween$default, (Function1) null, function3, composerStartRestartGroup, i3 & 58352, 4);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        str2 = str3;
                        modifier3 = modifier4;
                        finiteAnimationSpec3 = finiteAnimationSpecTween$default;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.CrossfadeKt.Crossfade.1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i11) {
                                CrossfadeKt.Crossfade(t, modifier3, finiteAnimationSpec3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i3 |= 3072;
                if ((i & 24576) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                if ((i3 & 9363) != 9362) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    finiteAnimationSpec3 = finiteAnimationSpec2;
                    str2 = str;
                } else {
                    if (i10 != 0) {
                        modifier4 = Modifier.INSTANCE;
                        i8 = i6;
                    } else {
                        i8 = i6;
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        finiteAnimationSpecTween$default = AnimationSpecKt.tween$default(0, 0, null, 7, null);
                    } else {
                        finiteAnimationSpecTween$default = finiteAnimationSpec2;
                    }
                    if (i8 != 0) {
                        str3 = "Crossfade";
                    } else {
                        str3 = str;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-513216493, i3, -1, "androidx.compose.animation.Crossfade (Crossfade.kt:55)");
                    }
                    Crossfade(androidx.compose.animation.core.TransitionKt.updateTransition(t, str3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 6) & 112), 0), modifier4, finiteAnimationSpecTween$default, (Function1) null, function3, composerStartRestartGroup, i3 & 58352, 4);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str2 = str3;
                    modifier3 = modifier4;
                    finiteAnimationSpec3 = finiteAnimationSpecTween$default;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.CrossfadeKt.Crossfade.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i11) {
                            CrossfadeKt.Crossfade(t, modifier3, finiteAnimationSpec3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 384;
            finiteAnimationSpec2 = finiteAnimationSpec;
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    if (composerStartRestartGroup.changed(str)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                if ((i & 24576) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                if ((i3 & 9363) != 9362) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    finiteAnimationSpec3 = finiteAnimationSpec2;
                    str2 = str;
                } else {
                    if (i10 != 0) {
                        modifier4 = Modifier.INSTANCE;
                        i8 = i6;
                    } else {
                        i8 = i6;
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        finiteAnimationSpecTween$default = AnimationSpecKt.tween$default(0, 0, null, 7, null);
                    } else {
                        finiteAnimationSpecTween$default = finiteAnimationSpec2;
                    }
                    if (i8 != 0) {
                        str3 = "Crossfade";
                    } else {
                        str3 = str;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-513216493, i3, -1, "androidx.compose.animation.Crossfade (Crossfade.kt:55)");
                    }
                    Crossfade(androidx.compose.animation.core.TransitionKt.updateTransition(t, str3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 6) & 112), 0), modifier4, finiteAnimationSpecTween$default, (Function1) null, function3, composerStartRestartGroup, i3 & 58352, 4);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str2 = str3;
                    modifier3 = modifier4;
                    finiteAnimationSpec3 = finiteAnimationSpecTween$default;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.CrossfadeKt.Crossfade.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i11) {
                            CrossfadeKt.Crossfade(t, modifier3, finiteAnimationSpec3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 3072;
            if ((i & 24576) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i9 = 16384;
                } else {
                    i9 = 8192;
                }
                i3 |= i9;
            }
            if ((i3 & 9363) != 9362) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                finiteAnimationSpec3 = finiteAnimationSpec2;
                str2 = str;
            } else {
                if (i10 != 0) {
                    modifier4 = Modifier.INSTANCE;
                    i8 = i6;
                } else {
                    i8 = i6;
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    finiteAnimationSpecTween$default = AnimationSpecKt.tween$default(0, 0, null, 7, null);
                } else {
                    finiteAnimationSpecTween$default = finiteAnimationSpec2;
                }
                if (i8 != 0) {
                    str3 = "Crossfade";
                } else {
                    str3 = str;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-513216493, i3, -1, "androidx.compose.animation.Crossfade (Crossfade.kt:55)");
                }
                Crossfade(androidx.compose.animation.core.TransitionKt.updateTransition(t, str3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 6) & 112), 0), modifier4, finiteAnimationSpecTween$default, (Function1) null, function3, composerStartRestartGroup, i3 & 58352, 4);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str2 = str3;
                modifier3 = modifier4;
                finiteAnimationSpec3 = finiteAnimationSpecTween$default;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.CrossfadeKt.Crossfade.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i11) {
                        CrossfadeKt.Crossfade(t, modifier3, finiteAnimationSpec3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 384) == 0) {
                finiteAnimationSpec2 = finiteAnimationSpec;
                if (composerStartRestartGroup.changedInstance(finiteAnimationSpec2)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    if (composerStartRestartGroup.changed(str)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                if ((i & 24576) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                if ((i3 & 9363) != 9362) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    finiteAnimationSpec3 = finiteAnimationSpec2;
                    str2 = str;
                } else {
                    if (i10 != 0) {
                        modifier4 = Modifier.INSTANCE;
                        i8 = i6;
                    } else {
                        i8 = i6;
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        finiteAnimationSpecTween$default = AnimationSpecKt.tween$default(0, 0, null, 7, null);
                    } else {
                        finiteAnimationSpecTween$default = finiteAnimationSpec2;
                    }
                    if (i8 != 0) {
                        str3 = "Crossfade";
                    } else {
                        str3 = str;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-513216493, i3, -1, "androidx.compose.animation.Crossfade (Crossfade.kt:55)");
                    }
                    Crossfade(androidx.compose.animation.core.TransitionKt.updateTransition(t, str3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 6) & 112), 0), modifier4, finiteAnimationSpecTween$default, (Function1) null, function3, composerStartRestartGroup, i3 & 58352, 4);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    str2 = str3;
                    modifier3 = modifier4;
                    finiteAnimationSpec3 = finiteAnimationSpecTween$default;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.CrossfadeKt.Crossfade.1
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i11) {
                            CrossfadeKt.Crossfade(t, modifier3, finiteAnimationSpec3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i3 |= 3072;
            if ((i & 24576) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i9 = 16384;
                } else {
                    i9 = 8192;
                }
                i3 |= i9;
            }
            if ((i3 & 9363) != 9362) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                finiteAnimationSpec3 = finiteAnimationSpec2;
                str2 = str;
            } else {
                if (i10 != 0) {
                    modifier4 = Modifier.INSTANCE;
                    i8 = i6;
                } else {
                    i8 = i6;
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    finiteAnimationSpecTween$default = AnimationSpecKt.tween$default(0, 0, null, 7, null);
                } else {
                    finiteAnimationSpecTween$default = finiteAnimationSpec2;
                }
                if (i8 != 0) {
                    str3 = "Crossfade";
                } else {
                    str3 = str;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-513216493, i3, -1, "androidx.compose.animation.Crossfade (Crossfade.kt:55)");
                }
                Crossfade(androidx.compose.animation.core.TransitionKt.updateTransition(t, str3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 6) & 112), 0), modifier4, finiteAnimationSpecTween$default, (Function1) null, function3, composerStartRestartGroup, i3 & 58352, 4);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str2 = str3;
                modifier3 = modifier4;
                finiteAnimationSpec3 = finiteAnimationSpecTween$default;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.CrossfadeKt.Crossfade.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i11) {
                        CrossfadeKt.Crossfade(t, modifier3, finiteAnimationSpec3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 384;
        finiteAnimationSpec2 = finiteAnimationSpec;
        i6 = i2 & 8;
        if (i6 != 0) {
            if ((i & 3072) == 0) {
                if (composerStartRestartGroup.changed(str)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i3 |= i7;
            }
            if ((i & 24576) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i9 = 16384;
                } else {
                    i9 = 8192;
                }
                i3 |= i9;
            }
            if ((i3 & 9363) != 9362) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                finiteAnimationSpec3 = finiteAnimationSpec2;
                str2 = str;
            } else {
                if (i10 != 0) {
                    modifier4 = Modifier.INSTANCE;
                    i8 = i6;
                } else {
                    i8 = i6;
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    finiteAnimationSpecTween$default = AnimationSpecKt.tween$default(0, 0, null, 7, null);
                } else {
                    finiteAnimationSpecTween$default = finiteAnimationSpec2;
                }
                if (i8 != 0) {
                    str3 = "Crossfade";
                } else {
                    str3 = str;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-513216493, i3, -1, "androidx.compose.animation.Crossfade (Crossfade.kt:55)");
                }
                Crossfade(androidx.compose.animation.core.TransitionKt.updateTransition(t, str3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 6) & 112), 0), modifier4, finiteAnimationSpecTween$default, (Function1) null, function3, composerStartRestartGroup, i3 & 58352, 4);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                str2 = str3;
                modifier3 = modifier4;
                finiteAnimationSpec3 = finiteAnimationSpecTween$default;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.CrossfadeKt.Crossfade.1
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i11) {
                        CrossfadeKt.Crossfade(t, modifier3, finiteAnimationSpec3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i3 |= 3072;
        if ((i & 24576) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i9 = 16384;
            } else {
                i9 = 8192;
            }
            i3 |= i9;
        }
        if ((i3 & 9363) != 9362) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            finiteAnimationSpec3 = finiteAnimationSpec2;
            str2 = str;
        } else {
            if (i10 != 0) {
                modifier4 = Modifier.INSTANCE;
                i8 = i6;
            } else {
                i8 = i6;
                modifier4 = modifier2;
            }
            if (i4 != 0) {
                finiteAnimationSpecTween$default = AnimationSpecKt.tween$default(0, 0, null, 7, null);
            } else {
                finiteAnimationSpecTween$default = finiteAnimationSpec2;
            }
            if (i8 != 0) {
                str3 = "Crossfade";
            } else {
                str3 = str;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-513216493, i3, -1, "androidx.compose.animation.Crossfade (Crossfade.kt:55)");
            }
            Crossfade(androidx.compose.animation.core.TransitionKt.updateTransition(t, str3, composerStartRestartGroup, (i3 & 14) | ((i3 >> 6) & 112), 0), modifier4, finiteAnimationSpecTween$default, (Function1) null, function3, composerStartRestartGroup, i3 & 58352, 4);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            str2 = str3;
            modifier3 = modifier4;
            finiteAnimationSpec3 = finiteAnimationSpecTween$default;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.CrossfadeKt.Crossfade.1
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i11) {
                    CrossfadeKt.Crossfade(t, modifier3, finiteAnimationSpec3, str2, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    @Deprecated(level = DeprecationLevel.HIDDEN, message = "Crossfade API now has a new label parameter added.")
    public static final /* synthetic */ void Crossfade(final Object obj, Modifier modifier, FiniteAnimationSpec finiteAnimationSpec, Function3 function3, Composer composer, final int i, final int i2) {
        int i3;
        final Function3 function4;
        final FiniteAnimationSpec finiteAnimationSpec2;
        final Modifier modifier2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-160948176);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Crossfade)P(3,2)69@2888L29,70@2933L53:Crossfade.kt#xbi5r1");
        if ((i & 6) == 0) {
            i3 = ((i & 8) == 0 ? composerStartRestartGroup.changed(obj) : composerStartRestartGroup.changedInstance(obj) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        int i4 = i2 & 2;
        if (i4 != 0) {
            i3 |= 48;
        } else if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(modifier) ? 32 : 16;
        }
        int i5 = i2 & 4;
        if (i5 != 0) {
            i3 |= 384;
        } else if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(finiteAnimationSpec) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function3) ? 2048 : 1024;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 1171) != 1170, i3 & 1)) {
            function4 = function3;
            composerStartRestartGroup.skipToGroupEnd();
            finiteAnimationSpec2 = finiteAnimationSpec;
            modifier2 = modifier;
        } else {
            if (i4 != 0) {
                modifier = Modifier.INSTANCE;
            }
            Modifier modifier3 = modifier;
            if (i5 != 0) {
                finiteAnimationSpec = AnimationSpecKt.tween$default(0, 0, null, 7, null);
            }
            FiniteAnimationSpec finiteAnimationSpec3 = finiteAnimationSpec;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-160948176, i3, -1, "androidx.compose.animation.Crossfade (Crossfade.kt:68)");
            }
            Crossfade(androidx.compose.animation.core.TransitionKt.updateTransition(obj, (String) null, composerStartRestartGroup, i3 & 14, 2), modifier3, (FiniteAnimationSpec<Float>) finiteAnimationSpec3, (Function1) null, function3, composerStartRestartGroup, (i3 & 1008) | ((i3 << 3) & 57344), 4);
            function4 = function3;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier2 = modifier3;
            finiteAnimationSpec2 = finiteAnimationSpec3;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.CrossfadeKt.Crossfade.2
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i6) {
                    CrossfadeKt.Crossfade(obj, modifier2, finiteAnimationSpec2, function4, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }

    /* JADX WARN: Code duplicated, block: B:101:0x01c2  */
    /* JADX WARN: Code duplicated, block: B:104:0x01d9 A[LOOP:0: B:99:0x01bc->B:104:0x01d9, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:108:0x01e0  */
    /* JADX WARN: Code duplicated, block: B:109:0x01e8  */
    /* JADX WARN: Code duplicated, block: B:112:0x01fc A[LOOP:1: B:111:0x01fa->B:112:0x01fc, LOOP_END] */
    /* JADX WARN: Code duplicated, block: B:114:0x021d  */
    /* JADX WARN: Code duplicated, block: B:117:0x0266  */
    /* JADX WARN: Code duplicated, block: B:120:0x0272  */
    /* JADX WARN: Code duplicated, block: B:121:0x0276  */
    /* JADX WARN: Code duplicated, block: B:124:0x02d9  */
    /* JADX WARN: Code duplicated, block: B:126:0x02f2  */
    /* JADX WARN: Code duplicated, block: B:127:0x02fe  */
    /* JADX WARN: Code duplicated, block: B:131:0x0336  */
    /* JADX WARN: Code duplicated, block: B:133:0x033b  */
    /* JADX WARN: Code duplicated, block: B:136:0x0346  */
    /* JADX WARN: Code duplicated, block: B:138:0x01dc A[SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:139:0x01dd A[EDGE_INSN: B:139:0x01dd->B:106:0x01dd BREAK  A[LOOP:0: B:99:0x01bc->B:104:0x01d9], SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:144:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:23:0x0044  */
    /* JADX WARN: Code duplicated, block: B:24:0x0047  */
    /* JADX WARN: Code duplicated, block: B:26:0x004b  */
    /* JADX WARN: Code duplicated, block: B:28:0x0053  */
    /* JADX WARN: Code duplicated, block: B:29:0x0056  */
    /* JADX WARN: Code duplicated, block: B:34:0x0060  */
    /* JADX WARN: Code duplicated, block: B:35:0x0063  */
    /* JADX WARN: Code duplicated, block: B:37:0x0067  */
    /* JADX WARN: Code duplicated, block: B:39:0x006f  */
    /* JADX WARN: Code duplicated, block: B:40:0x0072  */
    /* JADX WARN: Code duplicated, block: B:45:0x007c  */
    /* JADX WARN: Code duplicated, block: B:47:0x0082  */
    /* JADX WARN: Code duplicated, block: B:48:0x0085  */
    /* JADX WARN: Code duplicated, block: B:52:0x0090  */
    /* JADX WARN: Code duplicated, block: B:53:0x0092  */
    /* JADX WARN: Code duplicated, block: B:56:0x009b A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:57:0x009d  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a4  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:64:0x00c3  */
    /* JADX WARN: Code duplicated, block: B:66:0x00d0  */
    /* JADX WARN: Code duplicated, block: B:69:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:72:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:75:0x0114  */
    /* JADX WARN: Code duplicated, block: B:78:0x0133  */
    /* JADX WARN: Code duplicated, block: B:80:0x0142  */
    /* JADX WARN: Code duplicated, block: B:85:0x0158  */
    /* JADX WARN: Code duplicated, block: B:87:0x0171  */
    /* JADX WARN: Code duplicated, block: B:88:0x0173  */
    /* JADX WARN: Code duplicated, block: B:91:0x017a  */
    /* JADX WARN: Code duplicated, block: B:93:0x0182  */
    /* JADX WARN: Code duplicated, block: B:95:0x0199  */
    /* JADX WARN: Code duplicated, block: B:98:0x01a9  */
    public static final <T> void Crossfade(final Transition<T> transition, Modifier modifier, FiniteAnimationSpec<Float> finiteAnimationSpec, Function1<? super T, ? extends Object> function1, final Function3<? super T, ? super Composer, ? super Integer, Unit> function3, Composer composer, final int i, final int i2) {
        Modifier modifier2;
        int i3;
        FiniteAnimationSpec<Float> finiteAnimationSpecTween$default;
        int i4;
        int i5;
        Function1<? super T, ? extends Object> function2;
        int i6;
        boolean z;
        final Function1<? super T, ? extends Object> function4;
        final FiniteAnimationSpec<Float> finiteAnimationSpec2;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function1<? super T, ? extends Object> function5;
        Object objRememberedValue;
        Object obj;
        SnapshotStateList snapshotStateList;
        Object objRememberedValue2;
        MutableScatterMap mutableScatterMap;
        SnapshotStateList snapshotStateList2;
        Function0<ComposeUiNode> constructor;
        SnapshotStateList snapshotStateList3;
        int size;
        int i7;
        Function2 function6;
        SnapshotStateList snapshotStateList4;
        Iterator<T> it;
        int i8;
        int size2;
        int i9;
        boolean z2;
        Object objRememberedValue3;
        CrossfadeKt$Crossfade$3$1 crossfadeKt$Crossfade$3$1RememberedValue;
        int i10;
        final Transition<T> transition2 = transition;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1877370462);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(Crossfade)P(3!1,2)100@4602L6,103@4692L64,104@4778L61,134@6037L111:Crossfade.kt#xbi5r1");
        int i11 = (i & 6) == 0 ? (composerStartRestartGroup.changed(transition2) ? 4 : 2) | i : i;
        int i12 = i2 & 1;
        if (i12 == 0) {
            if ((i & 48) == 0) {
                modifier2 = modifier;
                i11 |= composerStartRestartGroup.changed(modifier2) ? 32 : 16;
            }
            i3 = i2 & 2;
            if (i3 != 0) {
                if ((i & 384) == 0) {
                    finiteAnimationSpecTween$default = finiteAnimationSpec;
                    if (composerStartRestartGroup.changedInstance(finiteAnimationSpecTween$default)) {
                        i4 = 256;
                    } else {
                        i4 = 128;
                    }
                    i11 |= i4;
                }
                i5 = i2 & 4;
                if (i5 != 0) {
                    if ((i & 3072) == 0) {
                        function2 = function1;
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i6 = 2048;
                        } else {
                            i6 = 1024;
                        }
                        i11 |= i6;
                    }
                    if ((i & 24576) == 0) {
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i10 = 16384;
                        } else {
                            i10 = 8192;
                        }
                        i11 |= i10;
                    }
                    if ((i11 & 9363) != 9362) {
                        z = true;
                    } else {
                        z = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z, i11 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        function4 = function2;
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i3 != 0) {
                            finiteAnimationSpecTween$default = AnimationSpecKt.tween$default(0, 0, null, 7, null);
                        }
                        if (i5 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -266744280, "CC(remember):Crossfade.kt#9igjgp");
                            crossfadeKt$Crossfade$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                            if (crossfadeKt$Crossfade$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                                crossfadeKt$Crossfade$3$1RememberedValue = new Function1<T, T>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$3$1
                                    @Override // kotlin.jvm.functions.Function1
                                    public final T invoke(T t) {
                                        return t;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(crossfadeKt$Crossfade$3$1RememberedValue);
                            }
                            function5 = (Function1) crossfadeKt$Crossfade$3$1RememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function5 = function2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1877370462, i11, -1, "androidx.compose.animation.Crossfade (Crossfade.kt:102)");
                        }
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -266741342, "CC(remember):Crossfade.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        obj = objRememberedValue;
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            SnapshotStateList snapshotStateListMutableStateListOf = SnapshotStateKt.mutableStateListOf();
                            snapshotStateListMutableStateListOf.add(transition2.getCurrentState());
                            composerStartRestartGroup.updateRememberedValue(snapshotStateListMutableStateListOf);
                            obj = snapshotStateListMutableStateListOf;
                        }
                        snapshotStateList = (SnapshotStateList) obj;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -266738593, "CC(remember):Crossfade.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = ScatterMapKt.mutableScatterMapOf();
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        mutableScatterMap = (MutableScatterMap) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (Intrinsics.areEqual(transition2.getCurrentState(), transition2.getTargetState())) {
                            composerStartRestartGroup.startReplaceGroup(316295552);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(321145192);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "");
                            if (snapshotStateList.size() == 1 || !Intrinsics.areEqual(snapshotStateList.get(0), transition2.getTargetState())) {
                                composerStartRestartGroup.startReplaceGroup(321279546);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "109@5153L21");
                                SnapshotStateList snapshotStateList5 = snapshotStateList;
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -266726633, "CC(remember):Crossfade.kt#9igjgp");
                                if ((i11 & 14) == 4) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                if (!z2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue3 = (Function1) new Function1<T, Boolean>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$4$1
                                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                        {
                                            super(1);
                                        }

                                        /* JADX WARN: Can't rename method to resolve collision */
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Boolean invoke(T t) {
                                            return Boolean.valueOf(!Intrinsics.areEqual(t, transition2.getTargetState()));
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                CollectionsKt.removeAll((List) snapshotStateList5, (Function1) objRememberedValue3);
                                mutableScatterMap.clear();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(316295552);
                            }
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        if (!mutableScatterMap.contains(transition2.getTargetState())) {
                            snapshotStateList2 = snapshotStateList;
                            composerStartRestartGroup.startReplaceGroup(316295552);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(321536443);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*124@5720L295");
                            snapshotStateList4 = snapshotStateList;
                            it = snapshotStateList4.iterator();
                            i8 = 0;
                            while (true) {
                                if (it.hasNext()) {
                                    i8 = -1;
                                    break;
                                } else if (Intrinsics.areEqual(function5.invoke(it.next()), function5.invoke(transition2.getTargetState()))) {
                                    break;
                                } else {
                                    i8++;
                                }
                            }
                            if (i8 == -1) {
                                snapshotStateList.add(transition2.getTargetState());
                            } else {
                                snapshotStateList.set(i8, transition2.getTargetState());
                            }
                            mutableScatterMap.clear();
                            size2 = snapshotStateList4.size();
                            i9 = 0;
                            while (i9 < size2) {
                                T t = snapshotStateList4.get(i9);
                                mutableScatterMap.set(t, ComposableLambdaKt.rememberComposableLambda(-934471669, true, new CrossfadeKt$Crossfade$5$1(transition2, finiteAnimationSpecTween$default, t, function3), composerStartRestartGroup, 54));
                                i9++;
                                transition2 = transition;
                                snapshotStateList = snapshotStateList;
                            }
                            snapshotStateList2 = snapshotStateList;
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier2);
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2039243542, "C:Crossfade.kt#xbi5r1");
                        composerStartRestartGroup.startReplaceGroup(-1312707512);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "");
                        snapshotStateList3 = snapshotStateList2;
                        size = snapshotStateList3.size();
                        for (i7 = 0; i7 < size; i7++) {
                            T t2 = snapshotStateList3.get(i7);
                            composerStartRestartGroup.startMovableGroup(1171574969, function5.invoke(t2));
                            ComposerKt.sourceInformation(composerStartRestartGroup, "");
                            function6 = (Function2) mutableScatterMap.get(t2);
                            if (function6 == null) {
                                composerStartRestartGroup.startReplaceGroup(1959122128);
                                composerStartRestartGroup.endReplaceGroup();
                            } else {
                                composerStartRestartGroup.startReplaceGroup(1171576145);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "135@6130L8");
                                function6.invoke(composerStartRestartGroup, 0);
                                composerStartRestartGroup.endReplaceGroup();
                            }
                            composerStartRestartGroup.endMovableGroup();
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function4 = function5;
                    }
                    finiteAnimationSpec2 = finiteAnimationSpecTween$default;
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        final Modifier modifier3 = modifier2;
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.CrossfadeKt.Crossfade.7
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            /* JADX WARN: Multi-variable type inference failed */
                            {
                                super(2);
                            }

                            @Override // kotlin.jvm.functions.Function2
                            public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                                invoke(composer2, num.intValue());
                                return Unit.INSTANCE;
                            }

                            public final void invoke(Composer composer2, int i13) {
                                CrossfadeKt.Crossfade(transition, modifier3, finiteAnimationSpec2, function4, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                            }
                        });
                    }
                }
                i11 |= 3072;
                function2 = function1;
                if ((i & 24576) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i10 = 16384;
                    } else {
                        i10 = 8192;
                    }
                    i11 |= i10;
                }
                if ((i11 & 9363) != 9362) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i11 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    function4 = function2;
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i3 != 0) {
                        finiteAnimationSpecTween$default = AnimationSpecKt.tween$default(0, 0, null, 7, null);
                    }
                    if (i5 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -266744280, "CC(remember):Crossfade.kt#9igjgp");
                        crossfadeKt$Crossfade$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (crossfadeKt$Crossfade$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            crossfadeKt$Crossfade$3$1RememberedValue = new Function1<T, T>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$3$1
                                @Override // kotlin.jvm.functions.Function1
                                public final T invoke(T t3) {
                                    return t3;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(crossfadeKt$Crossfade$3$1RememberedValue);
                        }
                        function5 = (Function1) crossfadeKt$Crossfade$3$1RememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function5 = function2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1877370462, i11, -1, "androidx.compose.animation.Crossfade (Crossfade.kt:102)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -266741342, "CC(remember):Crossfade.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    obj = objRememberedValue;
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        SnapshotStateList snapshotStateListMutableStateListOf2 = SnapshotStateKt.mutableStateListOf();
                        snapshotStateListMutableStateListOf2.add(transition2.getCurrentState());
                        composerStartRestartGroup.updateRememberedValue(snapshotStateListMutableStateListOf2);
                        obj = snapshotStateListMutableStateListOf2;
                    }
                    snapshotStateList = (SnapshotStateList) obj;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -266738593, "CC(remember):Crossfade.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = ScatterMapKt.mutableScatterMapOf();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableScatterMap = (MutableScatterMap) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (Intrinsics.areEqual(transition2.getCurrentState(), transition2.getTargetState())) {
                        composerStartRestartGroup.startReplaceGroup(316295552);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(321145192);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "");
                        if (snapshotStateList.size() == 1) {
                            composerStartRestartGroup.startReplaceGroup(321279546);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "109@5153L21");
                            SnapshotStateList snapshotStateList6 = snapshotStateList;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -266726633, "CC(remember):Crossfade.kt#9igjgp");
                            if ((i11 & 14) == 4) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (!z2) {
                                objRememberedValue3 = (Function1) new Function1<T, Boolean>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$4$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Boolean invoke(T t3) {
                                        return Boolean.valueOf(!Intrinsics.areEqual(t3, transition2.getTargetState()));
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                objRememberedValue3 = (Function1) new Function1<T, Boolean>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$4$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Boolean invoke(T t3) {
                                        return Boolean.valueOf(!Intrinsics.areEqual(t3, transition2.getTargetState()));
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            CollectionsKt.removeAll((List) snapshotStateList6, (Function1) objRememberedValue3);
                            mutableScatterMap.clear();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(321279546);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "109@5153L21");
                            SnapshotStateList snapshotStateList7 = snapshotStateList;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -266726633, "CC(remember):Crossfade.kt#9igjgp");
                            if ((i11 & 14) == 4) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (!z2) {
                                objRememberedValue3 = (Function1) new Function1<T, Boolean>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$4$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Boolean invoke(T t3) {
                                        return Boolean.valueOf(!Intrinsics.areEqual(t3, transition2.getTargetState()));
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                objRememberedValue3 = (Function1) new Function1<T, Boolean>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$4$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Boolean invoke(T t3) {
                                        return Boolean.valueOf(!Intrinsics.areEqual(t3, transition2.getTargetState()));
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            CollectionsKt.removeAll((List) snapshotStateList7, (Function1) objRememberedValue3);
                            mutableScatterMap.clear();
                        }
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    if (!mutableScatterMap.contains(transition2.getTargetState())) {
                        snapshotStateList2 = snapshotStateList;
                        composerStartRestartGroup.startReplaceGroup(316295552);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(321536443);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*124@5720L295");
                        snapshotStateList4 = snapshotStateList;
                        it = snapshotStateList4.iterator();
                        i8 = 0;
                        while (true) {
                            if (it.hasNext()) {
                                i8 = -1;
                                break;
                            } else {
                                if (Intrinsics.areEqual(function5.invoke(it.next()), function5.invoke(transition2.getTargetState()))) {
                                    break;
                                    break;
                                }
                                i8++;
                            }
                        }
                        if (i8 == -1) {
                            snapshotStateList.add(transition2.getTargetState());
                        } else {
                            snapshotStateList.set(i8, transition2.getTargetState());
                        }
                        mutableScatterMap.clear();
                        size2 = snapshotStateList4.size();
                        i9 = 0;
                        while (i9 < size2) {
                            T t3 = snapshotStateList4.get(i9);
                            mutableScatterMap.set(t3, ComposableLambdaKt.rememberComposableLambda(-934471669, true, new CrossfadeKt$Crossfade$5$1(transition2, finiteAnimationSpecTween$default, t3, function3), composerStartRestartGroup, 54));
                            i9++;
                            transition2 = transition;
                            snapshotStateList = snapshotStateList;
                        }
                        snapshotStateList2 = snapshotStateList;
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier2);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                    Composer composerM6062constructorimpl2 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl2, measurePolicyMaybeCachedBoxMeasurePolicy2, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl2, currentCompositionLocalMap2, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl2, Integer.valueOf(iHashCode2), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl2, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl2, modifierMaterializeModifier2, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance2 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2039243542, "C:Crossfade.kt#xbi5r1");
                    composerStartRestartGroup.startReplaceGroup(-1312707512);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "");
                    snapshotStateList3 = snapshotStateList2;
                    size = snapshotStateList3.size();
                    while (i7 < size) {
                        T t4 = snapshotStateList3.get(i7);
                        composerStartRestartGroup.startMovableGroup(1171574969, function5.invoke(t4));
                        ComposerKt.sourceInformation(composerStartRestartGroup, "");
                        function6 = (Function2) mutableScatterMap.get(t4);
                        if (function6 == null) {
                            composerStartRestartGroup.startReplaceGroup(1959122128);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1171576145);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "135@6130L8");
                            function6.invoke(composerStartRestartGroup, 0);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        composerStartRestartGroup.endMovableGroup();
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function4 = function5;
                }
                finiteAnimationSpec2 = finiteAnimationSpecTween$default;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier4 = modifier2;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.CrossfadeKt.Crossfade.7
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i13) {
                            CrossfadeKt.Crossfade(transition, modifier4, finiteAnimationSpec2, function4, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i11 |= 384;
            finiteAnimationSpecTween$default = finiteAnimationSpec;
            i5 = i2 & 4;
            if (i5 != 0) {
                if ((i & 3072) == 0) {
                    function2 = function1;
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i6 = 2048;
                    } else {
                        i6 = 1024;
                    }
                    i11 |= i6;
                }
                if ((i & 24576) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i10 = 16384;
                    } else {
                        i10 = 8192;
                    }
                    i11 |= i10;
                }
                if ((i11 & 9363) != 9362) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i11 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    function4 = function2;
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i3 != 0) {
                        finiteAnimationSpecTween$default = AnimationSpecKt.tween$default(0, 0, null, 7, null);
                    }
                    if (i5 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -266744280, "CC(remember):Crossfade.kt#9igjgp");
                        crossfadeKt$Crossfade$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (crossfadeKt$Crossfade$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            crossfadeKt$Crossfade$3$1RememberedValue = new Function1<T, T>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$3$1
                                @Override // kotlin.jvm.functions.Function1
                                public final T invoke(T t5) {
                                    return t5;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(crossfadeKt$Crossfade$3$1RememberedValue);
                        }
                        function5 = (Function1) crossfadeKt$Crossfade$3$1RememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function5 = function2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1877370462, i11, -1, "androidx.compose.animation.Crossfade (Crossfade.kt:102)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -266741342, "CC(remember):Crossfade.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    obj = objRememberedValue;
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        SnapshotStateList snapshotStateListMutableStateListOf3 = SnapshotStateKt.mutableStateListOf();
                        snapshotStateListMutableStateListOf3.add(transition2.getCurrentState());
                        composerStartRestartGroup.updateRememberedValue(snapshotStateListMutableStateListOf3);
                        obj = snapshotStateListMutableStateListOf3;
                    }
                    snapshotStateList = (SnapshotStateList) obj;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -266738593, "CC(remember):Crossfade.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = ScatterMapKt.mutableScatterMapOf();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableScatterMap = (MutableScatterMap) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (Intrinsics.areEqual(transition2.getCurrentState(), transition2.getTargetState())) {
                        composerStartRestartGroup.startReplaceGroup(316295552);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(321145192);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "");
                        if (snapshotStateList.size() == 1) {
                            composerStartRestartGroup.startReplaceGroup(321279546);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "109@5153L21");
                            SnapshotStateList snapshotStateList8 = snapshotStateList;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -266726633, "CC(remember):Crossfade.kt#9igjgp");
                            if ((i11 & 14) == 4) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (!z2) {
                                objRememberedValue3 = (Function1) new Function1<T, Boolean>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$4$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Boolean invoke(T t5) {
                                        return Boolean.valueOf(!Intrinsics.areEqual(t5, transition2.getTargetState()));
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                objRememberedValue3 = (Function1) new Function1<T, Boolean>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$4$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Boolean invoke(T t5) {
                                        return Boolean.valueOf(!Intrinsics.areEqual(t5, transition2.getTargetState()));
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            CollectionsKt.removeAll((List) snapshotStateList8, (Function1) objRememberedValue3);
                            mutableScatterMap.clear();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(321279546);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "109@5153L21");
                            SnapshotStateList snapshotStateList9 = snapshotStateList;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -266726633, "CC(remember):Crossfade.kt#9igjgp");
                            if ((i11 & 14) == 4) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (!z2) {
                                objRememberedValue3 = (Function1) new Function1<T, Boolean>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$4$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Boolean invoke(T t5) {
                                        return Boolean.valueOf(!Intrinsics.areEqual(t5, transition2.getTargetState()));
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                objRememberedValue3 = (Function1) new Function1<T, Boolean>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$4$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Boolean invoke(T t5) {
                                        return Boolean.valueOf(!Intrinsics.areEqual(t5, transition2.getTargetState()));
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            CollectionsKt.removeAll((List) snapshotStateList9, (Function1) objRememberedValue3);
                            mutableScatterMap.clear();
                        }
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    if (!mutableScatterMap.contains(transition2.getTargetState())) {
                        snapshotStateList2 = snapshotStateList;
                        composerStartRestartGroup.startReplaceGroup(316295552);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(321536443);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*124@5720L295");
                        snapshotStateList4 = snapshotStateList;
                        it = snapshotStateList4.iterator();
                        i8 = 0;
                        while (true) {
                            if (it.hasNext()) {
                                i8 = -1;
                                break;
                            } else {
                                if (Intrinsics.areEqual(function5.invoke(it.next()), function5.invoke(transition2.getTargetState()))) {
                                    break;
                                    break;
                                }
                                i8++;
                            }
                        }
                        if (i8 == -1) {
                            snapshotStateList.add(transition2.getTargetState());
                        } else {
                            snapshotStateList.set(i8, transition2.getTargetState());
                        }
                        mutableScatterMap.clear();
                        size2 = snapshotStateList4.size();
                        i9 = 0;
                        while (i9 < size2) {
                            T t5 = snapshotStateList4.get(i9);
                            mutableScatterMap.set(t5, ComposableLambdaKt.rememberComposableLambda(-934471669, true, new CrossfadeKt$Crossfade$5$1(transition2, finiteAnimationSpecTween$default, t5, function3), composerStartRestartGroup, 54));
                            i9++;
                            transition2 = transition;
                            snapshotStateList = snapshotStateList;
                        }
                        snapshotStateList2 = snapshotStateList;
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier2);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                    Composer composerM6062constructorimpl3 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl3, measurePolicyMaybeCachedBoxMeasurePolicy3, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl3, currentCompositionLocalMap3, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl3, Integer.valueOf(iHashCode3), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl3, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl3, modifierMaterializeModifier3, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance3 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2039243542, "C:Crossfade.kt#xbi5r1");
                    composerStartRestartGroup.startReplaceGroup(-1312707512);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "");
                    snapshotStateList3 = snapshotStateList2;
                    size = snapshotStateList3.size();
                    while (i7 < size) {
                        T t6 = snapshotStateList3.get(i7);
                        composerStartRestartGroup.startMovableGroup(1171574969, function5.invoke(t6));
                        ComposerKt.sourceInformation(composerStartRestartGroup, "");
                        function6 = (Function2) mutableScatterMap.get(t6);
                        if (function6 == null) {
                            composerStartRestartGroup.startReplaceGroup(1959122128);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1171576145);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "135@6130L8");
                            function6.invoke(composerStartRestartGroup, 0);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        composerStartRestartGroup.endMovableGroup();
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function4 = function5;
                }
                finiteAnimationSpec2 = finiteAnimationSpecTween$default;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier5 = modifier2;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.CrossfadeKt.Crossfade.7
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i13) {
                            CrossfadeKt.Crossfade(transition, modifier5, finiteAnimationSpec2, function4, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i11 |= 3072;
            function2 = function1;
            if ((i & 24576) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i10 = 16384;
                } else {
                    i10 = 8192;
                }
                i11 |= i10;
            }
            if ((i11 & 9363) != 9362) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i11 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                function4 = function2;
            } else {
                if (i12 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i3 != 0) {
                    finiteAnimationSpecTween$default = AnimationSpecKt.tween$default(0, 0, null, 7, null);
                }
                if (i5 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -266744280, "CC(remember):Crossfade.kt#9igjgp");
                    crossfadeKt$Crossfade$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (crossfadeKt$Crossfade$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        crossfadeKt$Crossfade$3$1RememberedValue = new Function1<T, T>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$3$1
                            @Override // kotlin.jvm.functions.Function1
                            public final T invoke(T t7) {
                                return t7;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(crossfadeKt$Crossfade$3$1RememberedValue);
                    }
                    function5 = (Function1) crossfadeKt$Crossfade$3$1RememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    function5 = function2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1877370462, i11, -1, "androidx.compose.animation.Crossfade (Crossfade.kt:102)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -266741342, "CC(remember):Crossfade.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                obj = objRememberedValue;
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    SnapshotStateList snapshotStateListMutableStateListOf4 = SnapshotStateKt.mutableStateListOf();
                    snapshotStateListMutableStateListOf4.add(transition2.getCurrentState());
                    composerStartRestartGroup.updateRememberedValue(snapshotStateListMutableStateListOf4);
                    obj = snapshotStateListMutableStateListOf4;
                }
                snapshotStateList = (SnapshotStateList) obj;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -266738593, "CC(remember):Crossfade.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = ScatterMapKt.mutableScatterMapOf();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableScatterMap = (MutableScatterMap) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (Intrinsics.areEqual(transition2.getCurrentState(), transition2.getTargetState())) {
                    composerStartRestartGroup.startReplaceGroup(316295552);
                } else {
                    composerStartRestartGroup.startReplaceGroup(321145192);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "");
                    if (snapshotStateList.size() == 1) {
                        composerStartRestartGroup.startReplaceGroup(321279546);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "109@5153L21");
                        SnapshotStateList snapshotStateList10 = snapshotStateList;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -266726633, "CC(remember):Crossfade.kt#9igjgp");
                        if ((i11 & 14) == 4) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!z2) {
                            objRememberedValue3 = (Function1) new Function1<T, Boolean>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$4$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function1
                                public final Boolean invoke(T t7) {
                                    return Boolean.valueOf(!Intrinsics.areEqual(t7, transition2.getTargetState()));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = (Function1) new Function1<T, Boolean>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$4$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function1
                                public final Boolean invoke(T t7) {
                                    return Boolean.valueOf(!Intrinsics.areEqual(t7, transition2.getTargetState()));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        CollectionsKt.removeAll((List) snapshotStateList10, (Function1) objRememberedValue3);
                        mutableScatterMap.clear();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(321279546);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "109@5153L21");
                        SnapshotStateList snapshotStateList11 = snapshotStateList;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -266726633, "CC(remember):Crossfade.kt#9igjgp");
                        if ((i11 & 14) == 4) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!z2) {
                            objRememberedValue3 = (Function1) new Function1<T, Boolean>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$4$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function1
                                public final Boolean invoke(T t7) {
                                    return Boolean.valueOf(!Intrinsics.areEqual(t7, transition2.getTargetState()));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = (Function1) new Function1<T, Boolean>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$4$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function1
                                public final Boolean invoke(T t7) {
                                    return Boolean.valueOf(!Intrinsics.areEqual(t7, transition2.getTargetState()));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        CollectionsKt.removeAll((List) snapshotStateList11, (Function1) objRememberedValue3);
                        mutableScatterMap.clear();
                    }
                    composerStartRestartGroup.endReplaceGroup();
                }
                composerStartRestartGroup.endReplaceGroup();
                if (!mutableScatterMap.contains(transition2.getTargetState())) {
                    snapshotStateList2 = snapshotStateList;
                    composerStartRestartGroup.startReplaceGroup(316295552);
                } else {
                    composerStartRestartGroup.startReplaceGroup(321536443);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*124@5720L295");
                    snapshotStateList4 = snapshotStateList;
                    it = snapshotStateList4.iterator();
                    i8 = 0;
                    while (true) {
                        if (it.hasNext()) {
                            i8 = -1;
                            break;
                        } else {
                            if (Intrinsics.areEqual(function5.invoke(it.next()), function5.invoke(transition2.getTargetState()))) {
                                break;
                                break;
                            }
                            i8++;
                        }
                    }
                    if (i8 == -1) {
                        snapshotStateList.add(transition2.getTargetState());
                    } else {
                        snapshotStateList.set(i8, transition2.getTargetState());
                    }
                    mutableScatterMap.clear();
                    size2 = snapshotStateList4.size();
                    i9 = 0;
                    while (i9 < size2) {
                        T t7 = snapshotStateList4.get(i9);
                        mutableScatterMap.set(t7, ComposableLambdaKt.rememberComposableLambda(-934471669, true, new CrossfadeKt$Crossfade$5$1(transition2, finiteAnimationSpecTween$default, t7, function3), composerStartRestartGroup, 54));
                        i9++;
                        transition2 = transition;
                        snapshotStateList = snapshotStateList;
                    }
                    snapshotStateList2 = snapshotStateList;
                }
                composerStartRestartGroup.endReplaceGroup();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier2);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                Composer composerM6062constructorimpl4 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl4, measurePolicyMaybeCachedBoxMeasurePolicy4, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl4, currentCompositionLocalMap4, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl4, Integer.valueOf(iHashCode4), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl4, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl4, modifierMaterializeModifier4, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance4 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2039243542, "C:Crossfade.kt#xbi5r1");
                composerStartRestartGroup.startReplaceGroup(-1312707512);
                ComposerKt.sourceInformation(composerStartRestartGroup, "");
                snapshotStateList3 = snapshotStateList2;
                size = snapshotStateList3.size();
                while (i7 < size) {
                    T t8 = snapshotStateList3.get(i7);
                    composerStartRestartGroup.startMovableGroup(1171574969, function5.invoke(t8));
                    ComposerKt.sourceInformation(composerStartRestartGroup, "");
                    function6 = (Function2) mutableScatterMap.get(t8);
                    if (function6 == null) {
                        composerStartRestartGroup.startReplaceGroup(1959122128);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1171576145);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "135@6130L8");
                        function6.invoke(composerStartRestartGroup, 0);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    composerStartRestartGroup.endMovableGroup();
                }
                composerStartRestartGroup.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function4 = function5;
            }
            finiteAnimationSpec2 = finiteAnimationSpecTween$default;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier6 = modifier2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.CrossfadeKt.Crossfade.7
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i13) {
                        CrossfadeKt.Crossfade(transition, modifier6, finiteAnimationSpec2, function4, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i11 |= 48;
        modifier2 = modifier;
        i3 = i2 & 2;
        if (i3 != 0) {
            if ((i & 384) == 0) {
                finiteAnimationSpecTween$default = finiteAnimationSpec;
                if (composerStartRestartGroup.changedInstance(finiteAnimationSpecTween$default)) {
                    i4 = 256;
                } else {
                    i4 = 128;
                }
                i11 |= i4;
            }
            i5 = i2 & 4;
            if (i5 != 0) {
                if ((i & 3072) == 0) {
                    function2 = function1;
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i6 = 2048;
                    } else {
                        i6 = 1024;
                    }
                    i11 |= i6;
                }
                if ((i & 24576) == 0) {
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i10 = 16384;
                    } else {
                        i10 = 8192;
                    }
                    i11 |= i10;
                }
                if ((i11 & 9363) != 9362) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i11 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    function4 = function2;
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i3 != 0) {
                        finiteAnimationSpecTween$default = AnimationSpecKt.tween$default(0, 0, null, 7, null);
                    }
                    if (i5 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -266744280, "CC(remember):Crossfade.kt#9igjgp");
                        crossfadeKt$Crossfade$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                        if (crossfadeKt$Crossfade$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                            crossfadeKt$Crossfade$3$1RememberedValue = new Function1<T, T>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$3$1
                                @Override // kotlin.jvm.functions.Function1
                                public final T invoke(T t9) {
                                    return t9;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(crossfadeKt$Crossfade$3$1RememberedValue);
                        }
                        function5 = (Function1) crossfadeKt$Crossfade$3$1RememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function5 = function2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1877370462, i11, -1, "androidx.compose.animation.Crossfade (Crossfade.kt:102)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -266741342, "CC(remember):Crossfade.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    obj = objRememberedValue;
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        SnapshotStateList snapshotStateListMutableStateListOf5 = SnapshotStateKt.mutableStateListOf();
                        snapshotStateListMutableStateListOf5.add(transition2.getCurrentState());
                        composerStartRestartGroup.updateRememberedValue(snapshotStateListMutableStateListOf5);
                        obj = snapshotStateListMutableStateListOf5;
                    }
                    snapshotStateList = (SnapshotStateList) obj;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -266738593, "CC(remember):Crossfade.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = ScatterMapKt.mutableScatterMapOf();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    mutableScatterMap = (MutableScatterMap) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (Intrinsics.areEqual(transition2.getCurrentState(), transition2.getTargetState())) {
                        composerStartRestartGroup.startReplaceGroup(316295552);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(321145192);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "");
                        if (snapshotStateList.size() == 1) {
                            composerStartRestartGroup.startReplaceGroup(321279546);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "109@5153L21");
                            SnapshotStateList snapshotStateList12 = snapshotStateList;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -266726633, "CC(remember):Crossfade.kt#9igjgp");
                            if ((i11 & 14) == 4) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (!z2) {
                                objRememberedValue3 = (Function1) new Function1<T, Boolean>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$4$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Boolean invoke(T t9) {
                                        return Boolean.valueOf(!Intrinsics.areEqual(t9, transition2.getTargetState()));
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                objRememberedValue3 = (Function1) new Function1<T, Boolean>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$4$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Boolean invoke(T t9) {
                                        return Boolean.valueOf(!Intrinsics.areEqual(t9, transition2.getTargetState()));
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            CollectionsKt.removeAll((List) snapshotStateList12, (Function1) objRememberedValue3);
                            mutableScatterMap.clear();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(321279546);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "109@5153L21");
                            SnapshotStateList snapshotStateList13 = snapshotStateList;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -266726633, "CC(remember):Crossfade.kt#9igjgp");
                            if ((i11 & 14) == 4) {
                                z2 = true;
                            } else {
                                z2 = false;
                            }
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (!z2) {
                                objRememberedValue3 = (Function1) new Function1<T, Boolean>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$4$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Boolean invoke(T t9) {
                                        return Boolean.valueOf(!Intrinsics.areEqual(t9, transition2.getTargetState()));
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            } else {
                                objRememberedValue3 = (Function1) new Function1<T, Boolean>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$4$1
                                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                    {
                                        super(1);
                                    }

                                    /* JADX WARN: Can't rename method to resolve collision */
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Boolean invoke(T t9) {
                                        return Boolean.valueOf(!Intrinsics.areEqual(t9, transition2.getTargetState()));
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            CollectionsKt.removeAll((List) snapshotStateList13, (Function1) objRememberedValue3);
                            mutableScatterMap.clear();
                        }
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    if (!mutableScatterMap.contains(transition2.getTargetState())) {
                        snapshotStateList2 = snapshotStateList;
                        composerStartRestartGroup.startReplaceGroup(316295552);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(321536443);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*124@5720L295");
                        snapshotStateList4 = snapshotStateList;
                        it = snapshotStateList4.iterator();
                        i8 = 0;
                        while (true) {
                            if (it.hasNext()) {
                                i8 = -1;
                                break;
                            } else {
                                if (Intrinsics.areEqual(function5.invoke(it.next()), function5.invoke(transition2.getTargetState()))) {
                                    break;
                                    break;
                                }
                                i8++;
                            }
                        }
                        if (i8 == -1) {
                            snapshotStateList.add(transition2.getTargetState());
                        } else {
                            snapshotStateList.set(i8, transition2.getTargetState());
                        }
                        mutableScatterMap.clear();
                        size2 = snapshotStateList4.size();
                        i9 = 0;
                        while (i9 < size2) {
                            T t9 = snapshotStateList4.get(i9);
                            mutableScatterMap.set(t9, ComposableLambdaKt.rememberComposableLambda(-934471669, true, new CrossfadeKt$Crossfade$5$1(transition2, finiteAnimationSpecTween$default, t9, function3), composerStartRestartGroup, 54));
                            i9++;
                            transition2 = transition;
                            snapshotStateList = snapshotStateList;
                        }
                        snapshotStateList2 = snapshotStateList;
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode5 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier2);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                    Composer composerM6062constructorimpl5 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl5, measurePolicyMaybeCachedBoxMeasurePolicy5, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl5, currentCompositionLocalMap5, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl5, Integer.valueOf(iHashCode5), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl5, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl5, modifierMaterializeModifier5, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance5 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2039243542, "C:Crossfade.kt#xbi5r1");
                    composerStartRestartGroup.startReplaceGroup(-1312707512);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "");
                    snapshotStateList3 = snapshotStateList2;
                    size = snapshotStateList3.size();
                    while (i7 < size) {
                        T t10 = snapshotStateList3.get(i7);
                        composerStartRestartGroup.startMovableGroup(1171574969, function5.invoke(t10));
                        ComposerKt.sourceInformation(composerStartRestartGroup, "");
                        function6 = (Function2) mutableScatterMap.get(t10);
                        if (function6 == null) {
                            composerStartRestartGroup.startReplaceGroup(1959122128);
                            composerStartRestartGroup.endReplaceGroup();
                        } else {
                            composerStartRestartGroup.startReplaceGroup(1171576145);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "135@6130L8");
                            function6.invoke(composerStartRestartGroup, 0);
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        composerStartRestartGroup.endMovableGroup();
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function4 = function5;
                }
                finiteAnimationSpec2 = finiteAnimationSpecTween$default;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    final Modifier modifier7 = modifier2;
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.CrossfadeKt.Crossfade.7
                        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                        /* JADX WARN: Multi-variable type inference failed */
                        {
                            super(2);
                        }

                        @Override // kotlin.jvm.functions.Function2
                        public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                            invoke(composer2, num.intValue());
                            return Unit.INSTANCE;
                        }

                        public final void invoke(Composer composer2, int i13) {
                            CrossfadeKt.Crossfade(transition, modifier7, finiteAnimationSpec2, function4, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                        }
                    });
                }
            }
            i11 |= 3072;
            function2 = function1;
            if ((i & 24576) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i10 = 16384;
                } else {
                    i10 = 8192;
                }
                i11 |= i10;
            }
            if ((i11 & 9363) != 9362) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i11 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                function4 = function2;
            } else {
                if (i12 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i3 != 0) {
                    finiteAnimationSpecTween$default = AnimationSpecKt.tween$default(0, 0, null, 7, null);
                }
                if (i5 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -266744280, "CC(remember):Crossfade.kt#9igjgp");
                    crossfadeKt$Crossfade$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (crossfadeKt$Crossfade$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        crossfadeKt$Crossfade$3$1RememberedValue = new Function1<T, T>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$3$1
                            @Override // kotlin.jvm.functions.Function1
                            public final T invoke(T t11) {
                                return t11;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(crossfadeKt$Crossfade$3$1RememberedValue);
                    }
                    function5 = (Function1) crossfadeKt$Crossfade$3$1RememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    function5 = function2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1877370462, i11, -1, "androidx.compose.animation.Crossfade (Crossfade.kt:102)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -266741342, "CC(remember):Crossfade.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                obj = objRememberedValue;
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    SnapshotStateList snapshotStateListMutableStateListOf6 = SnapshotStateKt.mutableStateListOf();
                    snapshotStateListMutableStateListOf6.add(transition2.getCurrentState());
                    composerStartRestartGroup.updateRememberedValue(snapshotStateListMutableStateListOf6);
                    obj = snapshotStateListMutableStateListOf6;
                }
                snapshotStateList = (SnapshotStateList) obj;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -266738593, "CC(remember):Crossfade.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = ScatterMapKt.mutableScatterMapOf();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableScatterMap = (MutableScatterMap) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (Intrinsics.areEqual(transition2.getCurrentState(), transition2.getTargetState())) {
                    composerStartRestartGroup.startReplaceGroup(316295552);
                } else {
                    composerStartRestartGroup.startReplaceGroup(321145192);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "");
                    if (snapshotStateList.size() == 1) {
                        composerStartRestartGroup.startReplaceGroup(321279546);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "109@5153L21");
                        SnapshotStateList snapshotStateList14 = snapshotStateList;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -266726633, "CC(remember):Crossfade.kt#9igjgp");
                        if ((i11 & 14) == 4) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!z2) {
                            objRememberedValue3 = (Function1) new Function1<T, Boolean>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$4$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function1
                                public final Boolean invoke(T t11) {
                                    return Boolean.valueOf(!Intrinsics.areEqual(t11, transition2.getTargetState()));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = (Function1) new Function1<T, Boolean>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$4$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function1
                                public final Boolean invoke(T t11) {
                                    return Boolean.valueOf(!Intrinsics.areEqual(t11, transition2.getTargetState()));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        CollectionsKt.removeAll((List) snapshotStateList14, (Function1) objRememberedValue3);
                        mutableScatterMap.clear();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(321279546);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "109@5153L21");
                        SnapshotStateList snapshotStateList15 = snapshotStateList;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -266726633, "CC(remember):Crossfade.kt#9igjgp");
                        if ((i11 & 14) == 4) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!z2) {
                            objRememberedValue3 = (Function1) new Function1<T, Boolean>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$4$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function1
                                public final Boolean invoke(T t11) {
                                    return Boolean.valueOf(!Intrinsics.areEqual(t11, transition2.getTargetState()));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = (Function1) new Function1<T, Boolean>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$4$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function1
                                public final Boolean invoke(T t11) {
                                    return Boolean.valueOf(!Intrinsics.areEqual(t11, transition2.getTargetState()));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        CollectionsKt.removeAll((List) snapshotStateList15, (Function1) objRememberedValue3);
                        mutableScatterMap.clear();
                    }
                    composerStartRestartGroup.endReplaceGroup();
                }
                composerStartRestartGroup.endReplaceGroup();
                if (!mutableScatterMap.contains(transition2.getTargetState())) {
                    snapshotStateList2 = snapshotStateList;
                    composerStartRestartGroup.startReplaceGroup(316295552);
                } else {
                    composerStartRestartGroup.startReplaceGroup(321536443);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*124@5720L295");
                    snapshotStateList4 = snapshotStateList;
                    it = snapshotStateList4.iterator();
                    i8 = 0;
                    while (true) {
                        if (it.hasNext()) {
                            i8 = -1;
                            break;
                        } else {
                            if (Intrinsics.areEqual(function5.invoke(it.next()), function5.invoke(transition2.getTargetState()))) {
                                break;
                                break;
                            }
                            i8++;
                        }
                    }
                    if (i8 == -1) {
                        snapshotStateList.add(transition2.getTargetState());
                    } else {
                        snapshotStateList.set(i8, transition2.getTargetState());
                    }
                    mutableScatterMap.clear();
                    size2 = snapshotStateList4.size();
                    i9 = 0;
                    while (i9 < size2) {
                        T t11 = snapshotStateList4.get(i9);
                        mutableScatterMap.set(t11, ComposableLambdaKt.rememberComposableLambda(-934471669, true, new CrossfadeKt$Crossfade$5$1(transition2, finiteAnimationSpecTween$default, t11, function3), composerStartRestartGroup, 54));
                        i9++;
                        transition2 = transition;
                        snapshotStateList = snapshotStateList;
                    }
                    snapshotStateList2 = snapshotStateList;
                }
                composerStartRestartGroup.endReplaceGroup();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy6 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode6 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier2);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                Composer composerM6062constructorimpl6 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl6, measurePolicyMaybeCachedBoxMeasurePolicy6, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl6, currentCompositionLocalMap6, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl6, Integer.valueOf(iHashCode6), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl6, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl6, modifierMaterializeModifier6, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance6 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2039243542, "C:Crossfade.kt#xbi5r1");
                composerStartRestartGroup.startReplaceGroup(-1312707512);
                ComposerKt.sourceInformation(composerStartRestartGroup, "");
                snapshotStateList3 = snapshotStateList2;
                size = snapshotStateList3.size();
                while (i7 < size) {
                    T t12 = snapshotStateList3.get(i7);
                    composerStartRestartGroup.startMovableGroup(1171574969, function5.invoke(t12));
                    ComposerKt.sourceInformation(composerStartRestartGroup, "");
                    function6 = (Function2) mutableScatterMap.get(t12);
                    if (function6 == null) {
                        composerStartRestartGroup.startReplaceGroup(1959122128);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1171576145);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "135@6130L8");
                        function6.invoke(composerStartRestartGroup, 0);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    composerStartRestartGroup.endMovableGroup();
                }
                composerStartRestartGroup.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function4 = function5;
            }
            finiteAnimationSpec2 = finiteAnimationSpecTween$default;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier8 = modifier2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.CrossfadeKt.Crossfade.7
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i13) {
                        CrossfadeKt.Crossfade(transition, modifier8, finiteAnimationSpec2, function4, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i11 |= 384;
        finiteAnimationSpecTween$default = finiteAnimationSpec;
        i5 = i2 & 4;
        if (i5 != 0) {
            if ((i & 3072) == 0) {
                function2 = function1;
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i6 = 2048;
                } else {
                    i6 = 1024;
                }
                i11 |= i6;
            }
            if ((i & 24576) == 0) {
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i10 = 16384;
                } else {
                    i10 = 8192;
                }
                i11 |= i10;
            }
            if ((i11 & 9363) != 9362) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i11 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                function4 = function2;
            } else {
                if (i12 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i3 != 0) {
                    finiteAnimationSpecTween$default = AnimationSpecKt.tween$default(0, 0, null, 7, null);
                }
                if (i5 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -266744280, "CC(remember):Crossfade.kt#9igjgp");
                    crossfadeKt$Crossfade$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (crossfadeKt$Crossfade$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        crossfadeKt$Crossfade$3$1RememberedValue = new Function1<T, T>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$3$1
                            @Override // kotlin.jvm.functions.Function1
                            public final T invoke(T t13) {
                                return t13;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(crossfadeKt$Crossfade$3$1RememberedValue);
                    }
                    function5 = (Function1) crossfadeKt$Crossfade$3$1RememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    function5 = function2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1877370462, i11, -1, "androidx.compose.animation.Crossfade (Crossfade.kt:102)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -266741342, "CC(remember):Crossfade.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                obj = objRememberedValue;
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    SnapshotStateList snapshotStateListMutableStateListOf7 = SnapshotStateKt.mutableStateListOf();
                    snapshotStateListMutableStateListOf7.add(transition2.getCurrentState());
                    composerStartRestartGroup.updateRememberedValue(snapshotStateListMutableStateListOf7);
                    obj = snapshotStateListMutableStateListOf7;
                }
                snapshotStateList = (SnapshotStateList) obj;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -266738593, "CC(remember):Crossfade.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = ScatterMapKt.mutableScatterMapOf();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                mutableScatterMap = (MutableScatterMap) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (Intrinsics.areEqual(transition2.getCurrentState(), transition2.getTargetState())) {
                    composerStartRestartGroup.startReplaceGroup(316295552);
                } else {
                    composerStartRestartGroup.startReplaceGroup(321145192);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "");
                    if (snapshotStateList.size() == 1) {
                        composerStartRestartGroup.startReplaceGroup(321279546);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "109@5153L21");
                        SnapshotStateList snapshotStateList16 = snapshotStateList;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -266726633, "CC(remember):Crossfade.kt#9igjgp");
                        if ((i11 & 14) == 4) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!z2) {
                            objRememberedValue3 = (Function1) new Function1<T, Boolean>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$4$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function1
                                public final Boolean invoke(T t13) {
                                    return Boolean.valueOf(!Intrinsics.areEqual(t13, transition2.getTargetState()));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = (Function1) new Function1<T, Boolean>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$4$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function1
                                public final Boolean invoke(T t13) {
                                    return Boolean.valueOf(!Intrinsics.areEqual(t13, transition2.getTargetState()));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        CollectionsKt.removeAll((List) snapshotStateList16, (Function1) objRememberedValue3);
                        mutableScatterMap.clear();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(321279546);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "109@5153L21");
                        SnapshotStateList snapshotStateList17 = snapshotStateList;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -266726633, "CC(remember):Crossfade.kt#9igjgp");
                        if ((i11 & 14) == 4) {
                            z2 = true;
                        } else {
                            z2 = false;
                        }
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (!z2) {
                            objRememberedValue3 = (Function1) new Function1<T, Boolean>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$4$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function1
                                public final Boolean invoke(T t13) {
                                    return Boolean.valueOf(!Intrinsics.areEqual(t13, transition2.getTargetState()));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        } else {
                            objRememberedValue3 = (Function1) new Function1<T, Boolean>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$4$1
                                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                                {
                                    super(1);
                                }

                                /* JADX WARN: Can't rename method to resolve collision */
                                @Override // kotlin.jvm.functions.Function1
                                public final Boolean invoke(T t13) {
                                    return Boolean.valueOf(!Intrinsics.areEqual(t13, transition2.getTargetState()));
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        CollectionsKt.removeAll((List) snapshotStateList17, (Function1) objRememberedValue3);
                        mutableScatterMap.clear();
                    }
                    composerStartRestartGroup.endReplaceGroup();
                }
                composerStartRestartGroup.endReplaceGroup();
                if (!mutableScatterMap.contains(transition2.getTargetState())) {
                    snapshotStateList2 = snapshotStateList;
                    composerStartRestartGroup.startReplaceGroup(316295552);
                } else {
                    composerStartRestartGroup.startReplaceGroup(321536443);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*124@5720L295");
                    snapshotStateList4 = snapshotStateList;
                    it = snapshotStateList4.iterator();
                    i8 = 0;
                    while (true) {
                        if (it.hasNext()) {
                            i8 = -1;
                            break;
                        } else {
                            if (Intrinsics.areEqual(function5.invoke(it.next()), function5.invoke(transition2.getTargetState()))) {
                                break;
                                break;
                            }
                            i8++;
                        }
                    }
                    if (i8 == -1) {
                        snapshotStateList.add(transition2.getTargetState());
                    } else {
                        snapshotStateList.set(i8, transition2.getTargetState());
                    }
                    mutableScatterMap.clear();
                    size2 = snapshotStateList4.size();
                    i9 = 0;
                    while (i9 < size2) {
                        T t13 = snapshotStateList4.get(i9);
                        mutableScatterMap.set(t13, ComposableLambdaKt.rememberComposableLambda(-934471669, true, new CrossfadeKt$Crossfade$5$1(transition2, finiteAnimationSpecTween$default, t13, function3), composerStartRestartGroup, 54));
                        i9++;
                        transition2 = transition;
                        snapshotStateList = snapshotStateList;
                    }
                    snapshotStateList2 = snapshotStateList;
                }
                composerStartRestartGroup.endReplaceGroup();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy7 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode7 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier2);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
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
                Composer composerM6062constructorimpl7 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl7, measurePolicyMaybeCachedBoxMeasurePolicy7, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl7, currentCompositionLocalMap7, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl7, Integer.valueOf(iHashCode7), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl7, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl7, modifierMaterializeModifier7, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance7 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2039243542, "C:Crossfade.kt#xbi5r1");
                composerStartRestartGroup.startReplaceGroup(-1312707512);
                ComposerKt.sourceInformation(composerStartRestartGroup, "");
                snapshotStateList3 = snapshotStateList2;
                size = snapshotStateList3.size();
                while (i7 < size) {
                    T t14 = snapshotStateList3.get(i7);
                    composerStartRestartGroup.startMovableGroup(1171574969, function5.invoke(t14));
                    ComposerKt.sourceInformation(composerStartRestartGroup, "");
                    function6 = (Function2) mutableScatterMap.get(t14);
                    if (function6 == null) {
                        composerStartRestartGroup.startReplaceGroup(1959122128);
                        composerStartRestartGroup.endReplaceGroup();
                    } else {
                        composerStartRestartGroup.startReplaceGroup(1171576145);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "135@6130L8");
                        function6.invoke(composerStartRestartGroup, 0);
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    composerStartRestartGroup.endMovableGroup();
                }
                composerStartRestartGroup.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function4 = function5;
            }
            finiteAnimationSpec2 = finiteAnimationSpecTween$default;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                final Modifier modifier9 = modifier2;
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.CrossfadeKt.Crossfade.7
                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    /* JADX WARN: Multi-variable type inference failed */
                    {
                        super(2);
                    }

                    @Override // kotlin.jvm.functions.Function2
                    public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                        invoke(composer2, num.intValue());
                        return Unit.INSTANCE;
                    }

                    public final void invoke(Composer composer2, int i13) {
                        CrossfadeKt.Crossfade(transition, modifier9, finiteAnimationSpec2, function4, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                    }
                });
            }
        }
        i11 |= 3072;
        function2 = function1;
        if ((i & 24576) == 0) {
            if (composerStartRestartGroup.changedInstance(function3)) {
                i10 = 16384;
            } else {
                i10 = 8192;
            }
            i11 |= i10;
        }
        if ((i11 & 9363) != 9362) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i11 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            function4 = function2;
        } else {
            if (i12 != 0) {
                modifier2 = Modifier.INSTANCE;
            }
            if (i3 != 0) {
                finiteAnimationSpecTween$default = AnimationSpecKt.tween$default(0, 0, null, 7, null);
            }
            if (i5 != 0) {
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -266744280, "CC(remember):Crossfade.kt#9igjgp");
                crossfadeKt$Crossfade$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (crossfadeKt$Crossfade$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    crossfadeKt$Crossfade$3$1RememberedValue = new Function1<T, T>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$3$1
                        @Override // kotlin.jvm.functions.Function1
                        public final T invoke(T t15) {
                            return t15;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(crossfadeKt$Crossfade$3$1RememberedValue);
                }
                function5 = (Function1) crossfadeKt$Crossfade$3$1RememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            } else {
                function5 = function2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1877370462, i11, -1, "androidx.compose.animation.Crossfade (Crossfade.kt:102)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -266741342, "CC(remember):Crossfade.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            obj = objRememberedValue;
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                SnapshotStateList snapshotStateListMutableStateListOf8 = SnapshotStateKt.mutableStateListOf();
                snapshotStateListMutableStateListOf8.add(transition2.getCurrentState());
                composerStartRestartGroup.updateRememberedValue(snapshotStateListMutableStateListOf8);
                obj = snapshotStateListMutableStateListOf8;
            }
            snapshotStateList = (SnapshotStateList) obj;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -266738593, "CC(remember):Crossfade.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = ScatterMapKt.mutableScatterMapOf();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            mutableScatterMap = (MutableScatterMap) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (Intrinsics.areEqual(transition2.getCurrentState(), transition2.getTargetState())) {
                composerStartRestartGroup.startReplaceGroup(316295552);
            } else {
                composerStartRestartGroup.startReplaceGroup(321145192);
                ComposerKt.sourceInformation(composerStartRestartGroup, "");
                if (snapshotStateList.size() == 1) {
                    composerStartRestartGroup.startReplaceGroup(321279546);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "109@5153L21");
                    SnapshotStateList snapshotStateList18 = snapshotStateList;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -266726633, "CC(remember):Crossfade.kt#9igjgp");
                    if ((i11 & 14) == 4) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        objRememberedValue3 = (Function1) new Function1<T, Boolean>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$4$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function1
                            public final Boolean invoke(T t15) {
                                return Boolean.valueOf(!Intrinsics.areEqual(t15, transition2.getTargetState()));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = (Function1) new Function1<T, Boolean>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$4$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function1
                            public final Boolean invoke(T t15) {
                                return Boolean.valueOf(!Intrinsics.areEqual(t15, transition2.getTargetState()));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    CollectionsKt.removeAll((List) snapshotStateList18, (Function1) objRememberedValue3);
                    mutableScatterMap.clear();
                } else {
                    composerStartRestartGroup.startReplaceGroup(321279546);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "109@5153L21");
                    SnapshotStateList snapshotStateList19 = snapshotStateList;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -266726633, "CC(remember):Crossfade.kt#9igjgp");
                    if ((i11 & 14) == 4) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!z2) {
                        objRememberedValue3 = (Function1) new Function1<T, Boolean>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$4$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function1
                            public final Boolean invoke(T t15) {
                                return Boolean.valueOf(!Intrinsics.areEqual(t15, transition2.getTargetState()));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = (Function1) new Function1<T, Boolean>() { // from class: androidx.compose.animation.CrossfadeKt$Crossfade$4$1
                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(1);
                            }

                            /* JADX WARN: Can't rename method to resolve collision */
                            @Override // kotlin.jvm.functions.Function1
                            public final Boolean invoke(T t15) {
                                return Boolean.valueOf(!Intrinsics.areEqual(t15, transition2.getTargetState()));
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    CollectionsKt.removeAll((List) snapshotStateList19, (Function1) objRememberedValue3);
                    mutableScatterMap.clear();
                }
                composerStartRestartGroup.endReplaceGroup();
            }
            composerStartRestartGroup.endReplaceGroup();
            if (!mutableScatterMap.contains(transition2.getTargetState())) {
                snapshotStateList2 = snapshotStateList;
                composerStartRestartGroup.startReplaceGroup(316295552);
            } else {
                composerStartRestartGroup.startReplaceGroup(321536443);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*124@5720L295");
                snapshotStateList4 = snapshotStateList;
                it = snapshotStateList4.iterator();
                i8 = 0;
                while (true) {
                    if (it.hasNext()) {
                        i8 = -1;
                        break;
                    } else {
                        if (Intrinsics.areEqual(function5.invoke(it.next()), function5.invoke(transition2.getTargetState()))) {
                            break;
                            break;
                        }
                        i8++;
                    }
                }
                if (i8 == -1) {
                    snapshotStateList.add(transition2.getTargetState());
                } else {
                    snapshotStateList.set(i8, transition2.getTargetState());
                }
                mutableScatterMap.clear();
                size2 = snapshotStateList4.size();
                i9 = 0;
                while (i9 < size2) {
                    T t15 = snapshotStateList4.get(i9);
                    mutableScatterMap.set(t15, ComposableLambdaKt.rememberComposableLambda(-934471669, true, new CrossfadeKt$Crossfade$5$1(transition2, finiteAnimationSpecTween$default, t15, function3), composerStartRestartGroup, 54));
                    i9++;
                    transition2 = transition;
                    snapshotStateList = snapshotStateList;
                }
                snapshotStateList2 = snapshotStateList;
            }
            composerStartRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy8 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode8 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifier2);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
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
            Composer composerM6062constructorimpl8 = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl8, measurePolicyMaybeCachedBoxMeasurePolicy8, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl8, currentCompositionLocalMap8, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl8, Integer.valueOf(iHashCode8), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl8, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl8, modifierMaterializeModifier8, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance8 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -2039243542, "C:Crossfade.kt#xbi5r1");
            composerStartRestartGroup.startReplaceGroup(-1312707512);
            ComposerKt.sourceInformation(composerStartRestartGroup, "");
            snapshotStateList3 = snapshotStateList2;
            size = snapshotStateList3.size();
            while (i7 < size) {
                T t16 = snapshotStateList3.get(i7);
                composerStartRestartGroup.startMovableGroup(1171574969, function5.invoke(t16));
                ComposerKt.sourceInformation(composerStartRestartGroup, "");
                function6 = (Function2) mutableScatterMap.get(t16);
                if (function6 == null) {
                    composerStartRestartGroup.startReplaceGroup(1959122128);
                    composerStartRestartGroup.endReplaceGroup();
                } else {
                    composerStartRestartGroup.startReplaceGroup(1171576145);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "135@6130L8");
                    function6.invoke(composerStartRestartGroup, 0);
                    composerStartRestartGroup.endReplaceGroup();
                }
                composerStartRestartGroup.endMovableGroup();
            }
            composerStartRestartGroup.endReplaceGroup();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function4 = function5;
        }
        finiteAnimationSpec2 = finiteAnimationSpecTween$default;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            final Modifier modifier10 = modifier2;
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2<Composer, Integer, Unit>() { // from class: androidx.compose.animation.CrossfadeKt.Crossfade.7
                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                /* JADX WARN: Multi-variable type inference failed */
                {
                    super(2);
                }

                @Override // kotlin.jvm.functions.Function2
                public /* bridge */ /* synthetic */ Unit invoke(Composer composer2, Integer num) {
                    invoke(composer2, num.intValue());
                    return Unit.INSTANCE;
                }

                public final void invoke(Composer composer2, int i13) {
                    CrossfadeKt.Crossfade(transition, modifier10, finiteAnimationSpec2, function4, function3, composer2, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
                }
            });
        }
    }
}

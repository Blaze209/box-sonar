package com.box.android.browse.cpl.offlined;

import androidx.compose.material3.SnackbarDuration;
import androidx.compose.material3.SnackbarResult;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.StringResources_androidKt;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.base.compose.ItemsStateConfig;
import com.box.android.base.models.SecondaryActionType;
import com.box.android.browse.R;
import com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt;
import com.box.android.cpl.Store;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: compiled from: OfflinedContent.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u001a¢\u0001\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072a\b\u0002\u0010\b\u001a[\b\u0001\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\t2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0015H\u0007¢\u0006\u0002\u0010\u0017¨\u0006\u0018"}, d2 = {"OfflinedContent", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/browse/cpl/offlined/OfflinedReducer$State;", "Lcom/box/android/browse/cpl/offlined/OfflinedReducer$Action;", "modifier", "Landroidx/compose/ui/Modifier;", "onShowSnackbar", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "message", "actionLabel", "Landroidx/compose/material3/SnackbarDuration;", "duration", "Lkotlin/coroutines/Continuation;", "Landroidx/compose/material3/SnackbarResult;", "", "isRedesignedVersion", "", "shouldUseAiCenter", "(Lcom/box/android/cpl/Store;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function4;ZZLandroidx/compose/runtime/Composer;II)V", "browse_generalProdRelease"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class OfflinedContentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflinedContent$lambda$1(Store store, Modifier modifier, Function4 function4, boolean z, boolean z2, int i, int i2, Composer composer, int i3) {
        OfflinedContent(store, modifier, function4, z, z2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0047  */
    /* JADX WARN: Code duplicated, block: B:24:0x004a  */
    /* JADX WARN: Code duplicated, block: B:26:0x004e  */
    /* JADX WARN: Code duplicated, block: B:28:0x0056  */
    /* JADX WARN: Code duplicated, block: B:29:0x0059  */
    /* JADX WARN: Code duplicated, block: B:34:0x0063  */
    /* JADX WARN: Code duplicated, block: B:35:0x0066  */
    /* JADX WARN: Code duplicated, block: B:37:0x006a  */
    /* JADX WARN: Code duplicated, block: B:39:0x0072  */
    /* JADX WARN: Code duplicated, block: B:40:0x0075  */
    /* JADX WARN: Code duplicated, block: B:45:0x007f  */
    /* JADX WARN: Code duplicated, block: B:46:0x0082  */
    /* JADX WARN: Code duplicated, block: B:48:0x0086  */
    /* JADX WARN: Code duplicated, block: B:50:0x008e  */
    /* JADX WARN: Code duplicated, block: B:51:0x0091  */
    /* JADX WARN: Code duplicated, block: B:56:0x00a0  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:60:0x00ac A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:61:0x00ae  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b6  */
    /* JADX WARN: Code duplicated, block: B:65:0x00bd  */
    /* JADX WARN: Code duplicated, block: B:68:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c5  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c9  */
    /* JADX WARN: Code duplicated, block: B:73:0x00cc  */
    /* JADX WARN: Code duplicated, block: B:76:0x00d3  */
    /* JADX WARN: Code duplicated, block: B:79:0x00f4  */
    /* JADX WARN: Code duplicated, block: B:81:0x00f9  */
    /* JADX WARN: Code duplicated, block: B:84:0x0106  */
    /* JADX WARN: Code duplicated, block: B:86:? A[RETURN, SYNTHETIC] */
    public static final void OfflinedContent(final Store<OfflinedReducer.State, OfflinedReducer.Action> store, Modifier modifier, Function4<? super String, ? super String, ? super SnackbarDuration, ? super Continuation<? super SnackbarResult>, ? extends Object> function4, boolean z, boolean z2, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        Function4<? super String, ? super String, ? super SnackbarDuration, ? super Continuation<? super SnackbarResult>, ? extends Object> function5;
        int i5;
        int i6;
        boolean z3;
        int i7;
        int i8;
        boolean z4;
        int i9;
        boolean z5;
        final Modifier modifier3;
        final Function4<? super String, ? super String, ? super SnackbarDuration, ? super Continuation<? super SnackbarResult>, ? extends Object> function6;
        final boolean z6;
        final boolean z7;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        Intrinsics.checkNotNullParameter(store, "store");
        Composer composerStartRestartGroup = composer.startRestartGroup(-1864142464);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(OfflinedContent)N(store,modifier,onShowSnackbar,isRedesignedVersion,shouldUseAiCenter)24@991L660,24@982L669:OfflinedContent.kt#t6qdi3");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
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
                    function5 = function4;
                    if (composerStartRestartGroup.changedInstance(function5)) {
                        i5 = 256;
                    } else {
                        i5 = 128;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 8;
                if (i6 != 0) {
                    if ((i & 3072) == 0) {
                        z3 = z;
                        if (composerStartRestartGroup.changed(z3)) {
                            i7 = 2048;
                        } else {
                            i7 = 1024;
                        }
                        i3 |= i7;
                    }
                    i8 = i2 & 16;
                    if (i8 != 0) {
                        if ((i & 24576) == 0) {
                            z4 = z2;
                            if (composerStartRestartGroup.changed(z4)) {
                                i9 = 16384;
                            } else {
                                i9 = 8192;
                            }
                            i3 |= i9;
                        }
                        if ((i3 & 9363) != 9362) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                            composerStartRestartGroup.skipToGroupEnd();
                            modifier3 = modifier2;
                            function6 = function5;
                            z6 = z3;
                            z7 = z4;
                        } else {
                            if (i10 != 0) {
                                companion = Modifier.INSTANCE;
                            } else {
                                companion = modifier2;
                            }
                            if (i4 != 0) {
                                function6 = null;
                            } else {
                                function6 = function5;
                            }
                            final Modifier modifier4 = companion;
                            if (i6 != 0) {
                                z6 = false;
                            } else {
                                z6 = z3;
                            }
                            if (i8 != 0) {
                                z7 = false;
                            } else {
                                z7 = z4;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-1864142464, i3, -1, "com.box.android.browse.cpl.offlined.OfflinedContent (OfflinedContent.kt:23)");
                            }
                            BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(1186569109, true, new Function2() { // from class: com.box.android.browse.cpl.offlined.OfflinedContentKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return OfflinedContentKt.OfflinedContent$lambda$0(store, modifier4, function6, z6, z7, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier4;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.offlined.OfflinedContentKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return OfflinedContentKt.OfflinedContent$lambda$1(store, modifier3, function6, z6, z7, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 24576;
                    z4 = z2;
                    if ((i3 & 9363) != 9362) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        function6 = function5;
                        z6 = z3;
                        z7 = z4;
                    } else {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            function6 = null;
                        } else {
                            function6 = function5;
                        }
                        final Modifier modifier5 = companion;
                        if (i6 != 0) {
                            z6 = false;
                        } else {
                            z6 = z3;
                        }
                        if (i8 != 0) {
                            z7 = false;
                        } else {
                            z7 = z4;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1864142464, i3, -1, "com.box.android.browse.cpl.offlined.OfflinedContent (OfflinedContent.kt:23)");
                        }
                        BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(1186569109, true, new Function2() { // from class: com.box.android.browse.cpl.offlined.OfflinedContentKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return OfflinedContentKt.OfflinedContent$lambda$0(store, modifier5, function6, z6, z7, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier5;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.offlined.OfflinedContentKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return OfflinedContentKt.OfflinedContent$lambda$1(store, modifier3, function6, z6, z7, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 3072;
                z3 = z;
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((i & 24576) == 0) {
                        z4 = z2;
                        if (composerStartRestartGroup.changed(z4)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    if ((i3 & 9363) != 9362) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        function6 = function5;
                        z6 = z3;
                        z7 = z4;
                    } else {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            function6 = null;
                        } else {
                            function6 = function5;
                        }
                        final Modifier modifier6 = companion;
                        if (i6 != 0) {
                            z6 = false;
                        } else {
                            z6 = z3;
                        }
                        if (i8 != 0) {
                            z7 = false;
                        } else {
                            z7 = z4;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1864142464, i3, -1, "com.box.android.browse.cpl.offlined.OfflinedContent (OfflinedContent.kt:23)");
                        }
                        BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(1186569109, true, new Function2() { // from class: com.box.android.browse.cpl.offlined.OfflinedContentKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return OfflinedContentKt.OfflinedContent$lambda$0(store, modifier6, function6, z6, z7, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier6;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.offlined.OfflinedContentKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return OfflinedContentKt.OfflinedContent$lambda$1(store, modifier3, function6, z6, z7, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 24576;
                z4 = z2;
                if ((i3 & 9363) != 9362) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    function6 = function5;
                    z6 = z3;
                    z7 = z4;
                } else {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        function6 = null;
                    } else {
                        function6 = function5;
                    }
                    final Modifier modifier7 = companion;
                    if (i6 != 0) {
                        z6 = false;
                    } else {
                        z6 = z3;
                    }
                    if (i8 != 0) {
                        z7 = false;
                    } else {
                        z7 = z4;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1864142464, i3, -1, "com.box.android.browse.cpl.offlined.OfflinedContent (OfflinedContent.kt:23)");
                    }
                    BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(1186569109, true, new Function2() { // from class: com.box.android.browse.cpl.offlined.OfflinedContentKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return OfflinedContentKt.OfflinedContent$lambda$0(store, modifier7, function6, z6, z7, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier7;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.offlined.OfflinedContentKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return OfflinedContentKt.OfflinedContent$lambda$1(store, modifier3, function6, z6, z7, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 384;
            function5 = function4;
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    z3 = z;
                    if (composerStartRestartGroup.changed(z3)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((i & 24576) == 0) {
                        z4 = z2;
                        if (composerStartRestartGroup.changed(z4)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    if ((i3 & 9363) != 9362) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        function6 = function5;
                        z6 = z3;
                        z7 = z4;
                    } else {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            function6 = null;
                        } else {
                            function6 = function5;
                        }
                        final Modifier modifier8 = companion;
                        if (i6 != 0) {
                            z6 = false;
                        } else {
                            z6 = z3;
                        }
                        if (i8 != 0) {
                            z7 = false;
                        } else {
                            z7 = z4;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1864142464, i3, -1, "com.box.android.browse.cpl.offlined.OfflinedContent (OfflinedContent.kt:23)");
                        }
                        BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(1186569109, true, new Function2() { // from class: com.box.android.browse.cpl.offlined.OfflinedContentKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return OfflinedContentKt.OfflinedContent$lambda$0(store, modifier8, function6, z6, z7, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier8;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.offlined.OfflinedContentKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return OfflinedContentKt.OfflinedContent$lambda$1(store, modifier3, function6, z6, z7, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 24576;
                z4 = z2;
                if ((i3 & 9363) != 9362) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    function6 = function5;
                    z6 = z3;
                    z7 = z4;
                } else {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        function6 = null;
                    } else {
                        function6 = function5;
                    }
                    final Modifier modifier9 = companion;
                    if (i6 != 0) {
                        z6 = false;
                    } else {
                        z6 = z3;
                    }
                    if (i8 != 0) {
                        z7 = false;
                    } else {
                        z7 = z4;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1864142464, i3, -1, "com.box.android.browse.cpl.offlined.OfflinedContent (OfflinedContent.kt:23)");
                    }
                    BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(1186569109, true, new Function2() { // from class: com.box.android.browse.cpl.offlined.OfflinedContentKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return OfflinedContentKt.OfflinedContent$lambda$0(store, modifier9, function6, z6, z7, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier9;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.offlined.OfflinedContentKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return OfflinedContentKt.OfflinedContent$lambda$1(store, modifier3, function6, z6, z7, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            z3 = z;
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((i & 24576) == 0) {
                    z4 = z2;
                    if (composerStartRestartGroup.changed(z4)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                if ((i3 & 9363) != 9362) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    function6 = function5;
                    z6 = z3;
                    z7 = z4;
                } else {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        function6 = null;
                    } else {
                        function6 = function5;
                    }
                    final Modifier modifier10 = companion;
                    if (i6 != 0) {
                        z6 = false;
                    } else {
                        z6 = z3;
                    }
                    if (i8 != 0) {
                        z7 = false;
                    } else {
                        z7 = z4;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1864142464, i3, -1, "com.box.android.browse.cpl.offlined.OfflinedContent (OfflinedContent.kt:23)");
                    }
                    BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(1186569109, true, new Function2() { // from class: com.box.android.browse.cpl.offlined.OfflinedContentKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return OfflinedContentKt.OfflinedContent$lambda$0(store, modifier10, function6, z6, z7, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier10;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.offlined.OfflinedContentKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return OfflinedContentKt.OfflinedContent$lambda$1(store, modifier3, function6, z6, z7, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            z4 = z2;
            if ((i3 & 9363) != 9362) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                function6 = function5;
                z6 = z3;
                z7 = z4;
            } else {
                if (i10 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    function6 = null;
                } else {
                    function6 = function5;
                }
                final Modifier modifier11 = companion;
                if (i6 != 0) {
                    z6 = false;
                } else {
                    z6 = z3;
                }
                if (i8 != 0) {
                    z7 = false;
                } else {
                    z7 = z4;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1864142464, i3, -1, "com.box.android.browse.cpl.offlined.OfflinedContent (OfflinedContent.kt:23)");
                }
                BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(1186569109, true, new Function2() { // from class: com.box.android.browse.cpl.offlined.OfflinedContentKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return OfflinedContentKt.OfflinedContent$lambda$0(store, modifier11, function6, z6, z7, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier11;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.offlined.OfflinedContentKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return OfflinedContentKt.OfflinedContent$lambda$1(store, modifier3, function6, z6, z7, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 48;
        modifier2 = modifier;
        i4 = i2 & 4;
        if (i4 != 0) {
            if ((i & 384) == 0) {
                function5 = function4;
                if (composerStartRestartGroup.changedInstance(function5)) {
                    i5 = 256;
                } else {
                    i5 = 128;
                }
                i3 |= i5;
            }
            i6 = i2 & 8;
            if (i6 != 0) {
                if ((i & 3072) == 0) {
                    z3 = z;
                    if (composerStartRestartGroup.changed(z3)) {
                        i7 = 2048;
                    } else {
                        i7 = 1024;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 16;
                if (i8 != 0) {
                    if ((i & 24576) == 0) {
                        z4 = z2;
                        if (composerStartRestartGroup.changed(z4)) {
                            i9 = 16384;
                        } else {
                            i9 = 8192;
                        }
                        i3 |= i9;
                    }
                    if ((i3 & 9363) != 9362) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        modifier3 = modifier2;
                        function6 = function5;
                        z6 = z3;
                        z7 = z4;
                    } else {
                        if (i10 != 0) {
                            companion = Modifier.INSTANCE;
                        } else {
                            companion = modifier2;
                        }
                        if (i4 != 0) {
                            function6 = null;
                        } else {
                            function6 = function5;
                        }
                        final Modifier modifier12 = companion;
                        if (i6 != 0) {
                            z6 = false;
                        } else {
                            z6 = z3;
                        }
                        if (i8 != 0) {
                            z7 = false;
                        } else {
                            z7 = z4;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-1864142464, i3, -1, "com.box.android.browse.cpl.offlined.OfflinedContent (OfflinedContent.kt:23)");
                        }
                        BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(1186569109, true, new Function2() { // from class: com.box.android.browse.cpl.offlined.OfflinedContentKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return OfflinedContentKt.OfflinedContent$lambda$0(store, modifier12, function6, z6, z7, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier12;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.offlined.OfflinedContentKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return OfflinedContentKt.OfflinedContent$lambda$1(store, modifier3, function6, z6, z7, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 24576;
                z4 = z2;
                if ((i3 & 9363) != 9362) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    function6 = function5;
                    z6 = z3;
                    z7 = z4;
                } else {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        function6 = null;
                    } else {
                        function6 = function5;
                    }
                    final Modifier modifier13 = companion;
                    if (i6 != 0) {
                        z6 = false;
                    } else {
                        z6 = z3;
                    }
                    if (i8 != 0) {
                        z7 = false;
                    } else {
                        z7 = z4;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1864142464, i3, -1, "com.box.android.browse.cpl.offlined.OfflinedContent (OfflinedContent.kt:23)");
                    }
                    BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(1186569109, true, new Function2() { // from class: com.box.android.browse.cpl.offlined.OfflinedContentKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return OfflinedContentKt.OfflinedContent$lambda$0(store, modifier13, function6, z6, z7, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier13;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.offlined.OfflinedContentKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return OfflinedContentKt.OfflinedContent$lambda$1(store, modifier3, function6, z6, z7, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            z3 = z;
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((i & 24576) == 0) {
                    z4 = z2;
                    if (composerStartRestartGroup.changed(z4)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                if ((i3 & 9363) != 9362) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    function6 = function5;
                    z6 = z3;
                    z7 = z4;
                } else {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        function6 = null;
                    } else {
                        function6 = function5;
                    }
                    final Modifier modifier14 = companion;
                    if (i6 != 0) {
                        z6 = false;
                    } else {
                        z6 = z3;
                    }
                    if (i8 != 0) {
                        z7 = false;
                    } else {
                        z7 = z4;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1864142464, i3, -1, "com.box.android.browse.cpl.offlined.OfflinedContent (OfflinedContent.kt:23)");
                    }
                    BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(1186569109, true, new Function2() { // from class: com.box.android.browse.cpl.offlined.OfflinedContentKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return OfflinedContentKt.OfflinedContent$lambda$0(store, modifier14, function6, z6, z7, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier14;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.offlined.OfflinedContentKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return OfflinedContentKt.OfflinedContent$lambda$1(store, modifier3, function6, z6, z7, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            z4 = z2;
            if ((i3 & 9363) != 9362) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                function6 = function5;
                z6 = z3;
                z7 = z4;
            } else {
                if (i10 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    function6 = null;
                } else {
                    function6 = function5;
                }
                final Modifier modifier15 = companion;
                if (i6 != 0) {
                    z6 = false;
                } else {
                    z6 = z3;
                }
                if (i8 != 0) {
                    z7 = false;
                } else {
                    z7 = z4;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1864142464, i3, -1, "com.box.android.browse.cpl.offlined.OfflinedContent (OfflinedContent.kt:23)");
                }
                BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(1186569109, true, new Function2() { // from class: com.box.android.browse.cpl.offlined.OfflinedContentKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return OfflinedContentKt.OfflinedContent$lambda$0(store, modifier15, function6, z6, z7, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier15;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.offlined.OfflinedContentKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return OfflinedContentKt.OfflinedContent$lambda$1(store, modifier3, function6, z6, z7, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        function5 = function4;
        i6 = i2 & 8;
        if (i6 != 0) {
            if ((i & 3072) == 0) {
                z3 = z;
                if (composerStartRestartGroup.changed(z3)) {
                    i7 = 2048;
                } else {
                    i7 = 1024;
                }
                i3 |= i7;
            }
            i8 = i2 & 16;
            if (i8 != 0) {
                if ((i & 24576) == 0) {
                    z4 = z2;
                    if (composerStartRestartGroup.changed(z4)) {
                        i9 = 16384;
                    } else {
                        i9 = 8192;
                    }
                    i3 |= i9;
                }
                if ((i3 & 9363) != 9362) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                    function6 = function5;
                    z6 = z3;
                    z7 = z4;
                } else {
                    if (i10 != 0) {
                        companion = Modifier.INSTANCE;
                    } else {
                        companion = modifier2;
                    }
                    if (i4 != 0) {
                        function6 = null;
                    } else {
                        function6 = function5;
                    }
                    final Modifier modifier16 = companion;
                    if (i6 != 0) {
                        z6 = false;
                    } else {
                        z6 = z3;
                    }
                    if (i8 != 0) {
                        z7 = false;
                    } else {
                        z7 = z4;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-1864142464, i3, -1, "com.box.android.browse.cpl.offlined.OfflinedContent (OfflinedContent.kt:23)");
                    }
                    BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(1186569109, true, new Function2() { // from class: com.box.android.browse.cpl.offlined.OfflinedContentKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return OfflinedContentKt.OfflinedContent$lambda$0(store, modifier16, function6, z6, z7, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier16;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.offlined.OfflinedContentKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return OfflinedContentKt.OfflinedContent$lambda$1(store, modifier3, function6, z6, z7, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            z4 = z2;
            if ((i3 & 9363) != 9362) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                function6 = function5;
                z6 = z3;
                z7 = z4;
            } else {
                if (i10 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    function6 = null;
                } else {
                    function6 = function5;
                }
                final Modifier modifier17 = companion;
                if (i6 != 0) {
                    z6 = false;
                } else {
                    z6 = z3;
                }
                if (i8 != 0) {
                    z7 = false;
                } else {
                    z7 = z4;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1864142464, i3, -1, "com.box.android.browse.cpl.offlined.OfflinedContent (OfflinedContent.kt:23)");
                }
                BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(1186569109, true, new Function2() { // from class: com.box.android.browse.cpl.offlined.OfflinedContentKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return OfflinedContentKt.OfflinedContent$lambda$0(store, modifier17, function6, z6, z7, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier17;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.offlined.OfflinedContentKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return OfflinedContentKt.OfflinedContent$lambda$1(store, modifier3, function6, z6, z7, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        z3 = z;
        i8 = i2 & 16;
        if (i8 != 0) {
            if ((i & 24576) == 0) {
                z4 = z2;
                if (composerStartRestartGroup.changed(z4)) {
                    i9 = 16384;
                } else {
                    i9 = 8192;
                }
                i3 |= i9;
            }
            if ((i3 & 9363) != 9362) {
                z5 = true;
            } else {
                z5 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
                function6 = function5;
                z6 = z3;
                z7 = z4;
            } else {
                if (i10 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    function6 = null;
                } else {
                    function6 = function5;
                }
                final Modifier modifier18 = companion;
                if (i6 != 0) {
                    z6 = false;
                } else {
                    z6 = z3;
                }
                if (i8 != 0) {
                    z7 = false;
                } else {
                    z7 = z4;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-1864142464, i3, -1, "com.box.android.browse.cpl.offlined.OfflinedContent (OfflinedContent.kt:23)");
                }
                BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(1186569109, true, new Function2() { // from class: com.box.android.browse.cpl.offlined.OfflinedContentKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return OfflinedContentKt.OfflinedContent$lambda$0(store, modifier18, function6, z6, z7, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier18;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.offlined.OfflinedContentKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return OfflinedContentKt.OfflinedContent$lambda$1(store, modifier3, function6, z6, z7, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        z4 = z2;
        if ((i3 & 9363) != 9362) {
            z5 = true;
        } else {
            z5 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z5, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
            function6 = function5;
            z6 = z3;
            z7 = z4;
        } else {
            if (i10 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (i4 != 0) {
                function6 = null;
            } else {
                function6 = function5;
            }
            final Modifier modifier19 = companion;
            if (i6 != 0) {
                z6 = false;
            } else {
                z6 = z3;
            }
            if (i8 != 0) {
                z7 = false;
            } else {
                z7 = z4;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1864142464, i3, -1, "com.box.android.browse.cpl.offlined.OfflinedContent (OfflinedContent.kt:23)");
            }
            BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(1186569109, true, new Function2() { // from class: com.box.android.browse.cpl.offlined.OfflinedContentKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OfflinedContentKt.OfflinedContent$lambda$0(store, modifier19, function6, z6, z7, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier19;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.offlined.OfflinedContentKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return OfflinedContentKt.OfflinedContent$lambda$1(store, modifier3, function6, z6, z7, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit OfflinedContent$lambda$0(Store store, Modifier modifier, Function4 function4, boolean z, boolean z2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C29@1216L43,30@1287L46,25@1001L644:OfflinedContent.kt#t6qdi3");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1186569109, i, -1, "com.box.android.browse.cpl.offlined.OfflinedContent.<anonymous> (OfflinedContent.kt:25)");
            }
            ActionableItemsListScreenKt.ActionableItemsListScreen(OfflinedReducerKt.scopeActionableItemsList(store), new ItemsStateConfig(R.drawable.ic_unplugged140, StringResources_androidKt.stringResource(R.string.empty_offline_text, composer, 0), StringResources_androidKt.stringResource(R.string.empty_offline_subtext, composer, 0), null, 8, null), TestTagKt.testTag(modifier, "OfflinedScreen"), SecondaryActionType.BottomSheetMenu.INSTANCE, function4, z, z2, composer, SecondaryActionType.BottomSheetMenu.$stable << 9, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }
}

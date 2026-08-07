package com.box.android.browse.cpl.browse;

import androidx.compose.material3.SnackbarDuration;
import androidx.compose.material3.SnackbarResult;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.base.compose.ItemsStateConfig;
import com.box.android.base.models.SecondaryActionType;
import com.box.android.browse.R;
import com.box.android.browse.cpl.createfolder.CreateFolderDialogKt;
import com.box.android.browse.cpl.itemsList.ActionableItemsListScreenKt;
import com.box.android.cpl.Store;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KFunction;

/* JADX INFO: compiled from: BrowseContent.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000H\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0004\u001a¢\u0001\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072a\b\u0002\u0010\b\u001a[\b\u0001\u0012\u0013\u0012\u00110\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\r\u0012\u0015\u0012\u0013\u0018\u00010\n¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u000e\u0012\u0013\u0012\u00110\u000f¢\u0006\f\b\u000b\u0012\b\b\f\u0012\u0004\b\b(\u0010\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\u0006\u0012\u0004\u0018\u00010\u0013\u0018\u00010\t2\b\b\u0002\u0010\u0014\u001a\u00020\u00152\b\b\u0002\u0010\u0016\u001a\u00020\u0015H\u0007¢\u0006\u0002\u0010\u0017¨\u0006\u0018²\u0006\n\u0010\u0019\u001a\u00020\u0004X\u008a\u0084\u0002"}, d2 = {"BrowseContent", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$State;", "Lcom/box/android/browse/cpl/browse/BrowseReducer$Action;", "modifier", "Landroidx/compose/ui/Modifier;", "onShowSnackbar", "Lkotlin/Function4;", "", "Lkotlin/ParameterName;", "name", "message", "actionLabel", "Landroidx/compose/material3/SnackbarDuration;", "duration", "Lkotlin/coroutines/Continuation;", "Landroidx/compose/material3/SnackbarResult;", "", "isRedesignedVersion", "", "shouldUseAiCenter", "(Lcom/box/android/cpl/Store;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function4;ZZLandroidx/compose/runtime/Composer;II)V", "browse_generalProdRelease", "state"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class BrowseContentKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BrowseContent$lambda$3(Store store, Modifier modifier, Function4 function4, boolean z, boolean z2, int i, int i2, Composer composer, int i3) {
        BrowseContent(store, modifier, function4, z, z2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0048  */
    /* JADX WARN: Code duplicated, block: B:24:0x004b  */
    /* JADX WARN: Code duplicated, block: B:26:0x004f  */
    /* JADX WARN: Code duplicated, block: B:28:0x0057  */
    /* JADX WARN: Code duplicated, block: B:29:0x005a  */
    /* JADX WARN: Code duplicated, block: B:34:0x0064  */
    /* JADX WARN: Code duplicated, block: B:35:0x0067  */
    /* JADX WARN: Code duplicated, block: B:37:0x006b  */
    /* JADX WARN: Code duplicated, block: B:39:0x0073  */
    /* JADX WARN: Code duplicated, block: B:40:0x0076  */
    /* JADX WARN: Code duplicated, block: B:45:0x0080  */
    /* JADX WARN: Code duplicated, block: B:46:0x0083  */
    /* JADX WARN: Code duplicated, block: B:48:0x0087  */
    /* JADX WARN: Code duplicated, block: B:50:0x008f  */
    /* JADX WARN: Code duplicated, block: B:51:0x0092  */
    /* JADX WARN: Code duplicated, block: B:56:0x009f  */
    /* JADX WARN: Code duplicated, block: B:57:0x00a1  */
    /* JADX WARN: Code duplicated, block: B:60:0x00aa A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:61:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:62:0x00b1  */
    /* JADX WARN: Code duplicated, block: B:64:0x00b4  */
    /* JADX WARN: Code duplicated, block: B:65:0x00bb  */
    /* JADX WARN: Code duplicated, block: B:68:0x00c0  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c2  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c6  */
    /* JADX WARN: Code duplicated, block: B:73:0x00c8  */
    /* JADX WARN: Code duplicated, block: B:76:0x00cf  */
    /* JADX WARN: Code duplicated, block: B:79:0x0101  */
    /* JADX WARN: Code duplicated, block: B:80:0x0108  */
    /* JADX WARN: Code duplicated, block: B:83:0x012d  */
    /* JADX WARN: Code duplicated, block: B:85:0x0132  */
    /* JADX WARN: Code duplicated, block: B:88:0x013f  */
    /* JADX WARN: Code duplicated, block: B:90:? A[RETURN, SYNTHETIC] */
    public static final void BrowseContent(final Store<BrowseReducer.State, BrowseReducer.Action> store, Modifier modifier, Function4<? super String, ? super String, ? super SnackbarDuration, ? super Continuation<? super SnackbarResult>, ? extends Object> function4, boolean z, boolean z2, Composer composer, final int i, final int i2) {
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
        State stateCollectAsStateWithLifecycle;
        Intrinsics.checkNotNullParameter(store, "store");
        Composer composerStartRestartGroup = composer.startRestartGroup(1152351419);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BrowseContent)N(store,modifier,onShowSnackbar,isRedesignedVersion,shouldUseAiCenter)27@1168L29,28@1211L665,28@1202L674:BrowseContent.kt#89mwni");
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
                                ComposerKt.traceEventStart(1152351419, i3, -1, "com.box.android.browse.cpl.browse.BrowseContent (BrowseContent.kt:26)");
                            }
                            stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                            BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(2023758480, true, new Function2() { // from class: com.box.android.browse.cpl.browse.BrowseContentKt$$ExternalSyntheticLambda0
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BrowseContentKt.BrowseContent$lambda$1(store, modifier4, function6, z6, z7, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                            if (BrowseContent$lambda$0(stateCollectAsStateWithLifecycle).getCreateFolderState() == null) {
                                composerStartRestartGroup.startReplaceGroup(28619407);
                            } else {
                                composerStartRestartGroup.startReplaceGroup(28619408);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "*45@1930L250,45@1921L259");
                                BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(1692734052, true, new Function2() { // from class: com.box.android.browse.cpl.browse.BrowseContentKt$$ExternalSyntheticLambda1
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return BrowseContentKt.BrowseContent$lambda$2$0(store, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                            }
                            composerStartRestartGroup.endReplaceGroup();
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            modifier3 = modifier4;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.browse.BrowseContentKt$$ExternalSyntheticLambda2
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BrowseContentKt.BrowseContent$lambda$3(store, modifier3, function6, z6, z7, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
                            ComposerKt.traceEventStart(1152351419, i3, -1, "com.box.android.browse.cpl.browse.BrowseContent (BrowseContent.kt:26)");
                        }
                        stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                        BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(2023758480, true, new Function2() { // from class: com.box.android.browse.cpl.browse.BrowseContentKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BrowseContentKt.BrowseContent$lambda$1(store, modifier5, function6, z6, z7, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                        if (BrowseContent$lambda$0(stateCollectAsStateWithLifecycle).getCreateFolderState() == null) {
                            composerStartRestartGroup.startReplaceGroup(28619407);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(28619408);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*45@1930L250,45@1921L259");
                            BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(1692734052, true, new Function2() { // from class: com.box.android.browse.cpl.browse.BrowseContentKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BrowseContentKt.BrowseContent$lambda$2$0(store, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier5;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.browse.BrowseContentKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BrowseContentKt.BrowseContent$lambda$3(store, modifier3, function6, z6, z7, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
                            ComposerKt.traceEventStart(1152351419, i3, -1, "com.box.android.browse.cpl.browse.BrowseContent (BrowseContent.kt:26)");
                        }
                        stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                        BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(2023758480, true, new Function2() { // from class: com.box.android.browse.cpl.browse.BrowseContentKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BrowseContentKt.BrowseContent$lambda$1(store, modifier6, function6, z6, z7, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                        if (BrowseContent$lambda$0(stateCollectAsStateWithLifecycle).getCreateFolderState() == null) {
                            composerStartRestartGroup.startReplaceGroup(28619407);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(28619408);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*45@1930L250,45@1921L259");
                            BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(1692734052, true, new Function2() { // from class: com.box.android.browse.cpl.browse.BrowseContentKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BrowseContentKt.BrowseContent$lambda$2$0(store, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier6;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.browse.BrowseContentKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BrowseContentKt.BrowseContent$lambda$3(store, modifier3, function6, z6, z7, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
                        ComposerKt.traceEventStart(1152351419, i3, -1, "com.box.android.browse.cpl.browse.BrowseContent (BrowseContent.kt:26)");
                    }
                    stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                    BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(2023758480, true, new Function2() { // from class: com.box.android.browse.cpl.browse.BrowseContentKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BrowseContentKt.BrowseContent$lambda$1(store, modifier7, function6, z6, z7, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                    if (BrowseContent$lambda$0(stateCollectAsStateWithLifecycle).getCreateFolderState() == null) {
                        composerStartRestartGroup.startReplaceGroup(28619407);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(28619408);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*45@1930L250,45@1921L259");
                        BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(1692734052, true, new Function2() { // from class: com.box.android.browse.cpl.browse.BrowseContentKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BrowseContentKt.BrowseContent$lambda$2$0(store, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier7;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.browse.BrowseContentKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BrowseContentKt.BrowseContent$lambda$3(store, modifier3, function6, z6, z7, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
                            ComposerKt.traceEventStart(1152351419, i3, -1, "com.box.android.browse.cpl.browse.BrowseContent (BrowseContent.kt:26)");
                        }
                        stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                        BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(2023758480, true, new Function2() { // from class: com.box.android.browse.cpl.browse.BrowseContentKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BrowseContentKt.BrowseContent$lambda$1(store, modifier8, function6, z6, z7, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                        if (BrowseContent$lambda$0(stateCollectAsStateWithLifecycle).getCreateFolderState() == null) {
                            composerStartRestartGroup.startReplaceGroup(28619407);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(28619408);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*45@1930L250,45@1921L259");
                            BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(1692734052, true, new Function2() { // from class: com.box.android.browse.cpl.browse.BrowseContentKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BrowseContentKt.BrowseContent$lambda$2$0(store, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier8;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.browse.BrowseContentKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BrowseContentKt.BrowseContent$lambda$3(store, modifier3, function6, z6, z7, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
                        ComposerKt.traceEventStart(1152351419, i3, -1, "com.box.android.browse.cpl.browse.BrowseContent (BrowseContent.kt:26)");
                    }
                    stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                    BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(2023758480, true, new Function2() { // from class: com.box.android.browse.cpl.browse.BrowseContentKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BrowseContentKt.BrowseContent$lambda$1(store, modifier9, function6, z6, z7, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                    if (BrowseContent$lambda$0(stateCollectAsStateWithLifecycle).getCreateFolderState() == null) {
                        composerStartRestartGroup.startReplaceGroup(28619407);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(28619408);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*45@1930L250,45@1921L259");
                        BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(1692734052, true, new Function2() { // from class: com.box.android.browse.cpl.browse.BrowseContentKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BrowseContentKt.BrowseContent$lambda$2$0(store, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier9;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.browse.BrowseContentKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BrowseContentKt.BrowseContent$lambda$3(store, modifier3, function6, z6, z7, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
                        ComposerKt.traceEventStart(1152351419, i3, -1, "com.box.android.browse.cpl.browse.BrowseContent (BrowseContent.kt:26)");
                    }
                    stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                    BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(2023758480, true, new Function2() { // from class: com.box.android.browse.cpl.browse.BrowseContentKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BrowseContentKt.BrowseContent$lambda$1(store, modifier10, function6, z6, z7, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                    if (BrowseContent$lambda$0(stateCollectAsStateWithLifecycle).getCreateFolderState() == null) {
                        composerStartRestartGroup.startReplaceGroup(28619407);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(28619408);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*45@1930L250,45@1921L259");
                        BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(1692734052, true, new Function2() { // from class: com.box.android.browse.cpl.browse.BrowseContentKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BrowseContentKt.BrowseContent$lambda$2$0(store, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier10;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.browse.BrowseContentKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BrowseContentKt.BrowseContent$lambda$3(store, modifier3, function6, z6, z7, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
                    ComposerKt.traceEventStart(1152351419, i3, -1, "com.box.android.browse.cpl.browse.BrowseContent (BrowseContent.kt:26)");
                }
                stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(2023758480, true, new Function2() { // from class: com.box.android.browse.cpl.browse.BrowseContentKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BrowseContentKt.BrowseContent$lambda$1(store, modifier11, function6, z6, z7, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                if (BrowseContent$lambda$0(stateCollectAsStateWithLifecycle).getCreateFolderState() == null) {
                    composerStartRestartGroup.startReplaceGroup(28619407);
                } else {
                    composerStartRestartGroup.startReplaceGroup(28619408);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*45@1930L250,45@1921L259");
                    BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(1692734052, true, new Function2() { // from class: com.box.android.browse.cpl.browse.BrowseContentKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BrowseContentKt.BrowseContent$lambda$2$0(store, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                }
                composerStartRestartGroup.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier11;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.browse.BrowseContentKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BrowseContentKt.BrowseContent$lambda$3(store, modifier3, function6, z6, z7, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
                            ComposerKt.traceEventStart(1152351419, i3, -1, "com.box.android.browse.cpl.browse.BrowseContent (BrowseContent.kt:26)");
                        }
                        stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                        BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(2023758480, true, new Function2() { // from class: com.box.android.browse.cpl.browse.BrowseContentKt$$ExternalSyntheticLambda0
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BrowseContentKt.BrowseContent$lambda$1(store, modifier12, function6, z6, z7, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                        if (BrowseContent$lambda$0(stateCollectAsStateWithLifecycle).getCreateFolderState() == null) {
                            composerStartRestartGroup.startReplaceGroup(28619407);
                        } else {
                            composerStartRestartGroup.startReplaceGroup(28619408);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "*45@1930L250,45@1921L259");
                            BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(1692734052, true, new Function2() { // from class: com.box.android.browse.cpl.browse.BrowseContentKt$$ExternalSyntheticLambda1
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return BrowseContentKt.BrowseContent$lambda$2$0(store, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                        }
                        composerStartRestartGroup.endReplaceGroup();
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        modifier3 = modifier12;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.browse.BrowseContentKt$$ExternalSyntheticLambda2
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BrowseContentKt.BrowseContent$lambda$3(store, modifier3, function6, z6, z7, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
                        ComposerKt.traceEventStart(1152351419, i3, -1, "com.box.android.browse.cpl.browse.BrowseContent (BrowseContent.kt:26)");
                    }
                    stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                    BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(2023758480, true, new Function2() { // from class: com.box.android.browse.cpl.browse.BrowseContentKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BrowseContentKt.BrowseContent$lambda$1(store, modifier13, function6, z6, z7, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                    if (BrowseContent$lambda$0(stateCollectAsStateWithLifecycle).getCreateFolderState() == null) {
                        composerStartRestartGroup.startReplaceGroup(28619407);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(28619408);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*45@1930L250,45@1921L259");
                        BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(1692734052, true, new Function2() { // from class: com.box.android.browse.cpl.browse.BrowseContentKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BrowseContentKt.BrowseContent$lambda$2$0(store, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier13;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.browse.BrowseContentKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BrowseContentKt.BrowseContent$lambda$3(store, modifier3, function6, z6, z7, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
                        ComposerKt.traceEventStart(1152351419, i3, -1, "com.box.android.browse.cpl.browse.BrowseContent (BrowseContent.kt:26)");
                    }
                    stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                    BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(2023758480, true, new Function2() { // from class: com.box.android.browse.cpl.browse.BrowseContentKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BrowseContentKt.BrowseContent$lambda$1(store, modifier14, function6, z6, z7, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                    if (BrowseContent$lambda$0(stateCollectAsStateWithLifecycle).getCreateFolderState() == null) {
                        composerStartRestartGroup.startReplaceGroup(28619407);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(28619408);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*45@1930L250,45@1921L259");
                        BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(1692734052, true, new Function2() { // from class: com.box.android.browse.cpl.browse.BrowseContentKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BrowseContentKt.BrowseContent$lambda$2$0(store, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier14;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.browse.BrowseContentKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BrowseContentKt.BrowseContent$lambda$3(store, modifier3, function6, z6, z7, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
                    ComposerKt.traceEventStart(1152351419, i3, -1, "com.box.android.browse.cpl.browse.BrowseContent (BrowseContent.kt:26)");
                }
                stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(2023758480, true, new Function2() { // from class: com.box.android.browse.cpl.browse.BrowseContentKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BrowseContentKt.BrowseContent$lambda$1(store, modifier15, function6, z6, z7, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                if (BrowseContent$lambda$0(stateCollectAsStateWithLifecycle).getCreateFolderState() == null) {
                    composerStartRestartGroup.startReplaceGroup(28619407);
                } else {
                    composerStartRestartGroup.startReplaceGroup(28619408);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*45@1930L250,45@1921L259");
                    BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(1692734052, true, new Function2() { // from class: com.box.android.browse.cpl.browse.BrowseContentKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BrowseContentKt.BrowseContent$lambda$2$0(store, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                }
                composerStartRestartGroup.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier15;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.browse.BrowseContentKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BrowseContentKt.BrowseContent$lambda$3(store, modifier3, function6, z6, z7, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
                        ComposerKt.traceEventStart(1152351419, i3, -1, "com.box.android.browse.cpl.browse.BrowseContent (BrowseContent.kt:26)");
                    }
                    stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                    BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(2023758480, true, new Function2() { // from class: com.box.android.browse.cpl.browse.BrowseContentKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BrowseContentKt.BrowseContent$lambda$1(store, modifier16, function6, z6, z7, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                    if (BrowseContent$lambda$0(stateCollectAsStateWithLifecycle).getCreateFolderState() == null) {
                        composerStartRestartGroup.startReplaceGroup(28619407);
                    } else {
                        composerStartRestartGroup.startReplaceGroup(28619408);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "*45@1930L250,45@1921L259");
                        BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(1692734052, true, new Function2() { // from class: com.box.android.browse.cpl.browse.BrowseContentKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return BrowseContentKt.BrowseContent$lambda$2$0(store, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                    }
                    composerStartRestartGroup.endReplaceGroup();
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier16;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.browse.BrowseContentKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BrowseContentKt.BrowseContent$lambda$3(store, modifier3, function6, z6, z7, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
                    ComposerKt.traceEventStart(1152351419, i3, -1, "com.box.android.browse.cpl.browse.BrowseContent (BrowseContent.kt:26)");
                }
                stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(2023758480, true, new Function2() { // from class: com.box.android.browse.cpl.browse.BrowseContentKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BrowseContentKt.BrowseContent$lambda$1(store, modifier17, function6, z6, z7, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                if (BrowseContent$lambda$0(stateCollectAsStateWithLifecycle).getCreateFolderState() == null) {
                    composerStartRestartGroup.startReplaceGroup(28619407);
                } else {
                    composerStartRestartGroup.startReplaceGroup(28619408);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*45@1930L250,45@1921L259");
                    BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(1692734052, true, new Function2() { // from class: com.box.android.browse.cpl.browse.BrowseContentKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BrowseContentKt.BrowseContent$lambda$2$0(store, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                }
                composerStartRestartGroup.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier17;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.browse.BrowseContentKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BrowseContentKt.BrowseContent$lambda$3(store, modifier3, function6, z6, z7, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
                    ComposerKt.traceEventStart(1152351419, i3, -1, "com.box.android.browse.cpl.browse.BrowseContent (BrowseContent.kt:26)");
                }
                stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(2023758480, true, new Function2() { // from class: com.box.android.browse.cpl.browse.BrowseContentKt$$ExternalSyntheticLambda0
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BrowseContentKt.BrowseContent$lambda$1(store, modifier18, function6, z6, z7, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                if (BrowseContent$lambda$0(stateCollectAsStateWithLifecycle).getCreateFolderState() == null) {
                    composerStartRestartGroup.startReplaceGroup(28619407);
                } else {
                    composerStartRestartGroup.startReplaceGroup(28619408);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "*45@1930L250,45@1921L259");
                    BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(1692734052, true, new Function2() { // from class: com.box.android.browse.cpl.browse.BrowseContentKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return BrowseContentKt.BrowseContent$lambda$2$0(store, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                }
                composerStartRestartGroup.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier18;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.browse.BrowseContentKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BrowseContentKt.BrowseContent$lambda$3(store, modifier3, function6, z6, z7, i, i2, (Composer) obj, ((Integer) obj2).intValue());
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
                ComposerKt.traceEventStart(1152351419, i3, -1, "com.box.android.browse.cpl.browse.BrowseContent (BrowseContent.kt:26)");
            }
            stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(2023758480, true, new Function2() { // from class: com.box.android.browse.cpl.browse.BrowseContentKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BrowseContentKt.BrowseContent$lambda$1(store, modifier19, function6, z6, z7, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
            if (BrowseContent$lambda$0(stateCollectAsStateWithLifecycle).getCreateFolderState() == null) {
                composerStartRestartGroup.startReplaceGroup(28619407);
            } else {
                composerStartRestartGroup.startReplaceGroup(28619408);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*45@1930L250,45@1921L259");
                BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(1692734052, true, new Function2() { // from class: com.box.android.browse.cpl.browse.BrowseContentKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return BrowseContentKt.BrowseContent$lambda$2$0(store, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
            }
            composerStartRestartGroup.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier19;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.browse.BrowseContentKt$$ExternalSyntheticLambda2
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return BrowseContentKt.BrowseContent$lambda$3(store, modifier3, function6, z6, z7, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BrowseContent$lambda$1(Store store, Modifier modifier, Function4 function4, boolean z, boolean z2, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C33@1438L42,34@1508L52,29@1221L649:BrowseContent.kt#89mwni");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2023758480, i, -1, "com.box.android.browse.cpl.browse.BrowseContent.<anonymous> (BrowseContent.kt:29)");
            }
            ActionableItemsListScreenKt.ActionableItemsListScreen(BrowseReducerKt.scopeActionableItemsList(store), new ItemsStateConfig(R.drawable.ic_folderfloat140, StringResources_androidKt.stringResource(R.string.empty_folder_text, composer, 0), StringResources_androidKt.stringResource(R.string.add_content_to_empty_folder, composer, 0), null, 8, null), TestTagKt.testTag(modifier, "BrowseScreen"), SecondaryActionType.BottomSheetMenu.INSTANCE, function4, z, z2, composer, SecondaryActionType.BottomSheetMenu.$stable << 9, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BrowseContent$lambda$2$0(Store store, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C49@2093L45,46@1944L226:BrowseContent.kt#89mwni");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1692734052, i, -1, "com.box.android.browse.cpl.browse.BrowseContent.<anonymous>.<anonymous> (BrowseContent.kt:46)");
            }
            BrowseContentKt$BrowseContent$2$1$1 browseContentKt$BrowseContent$2$1$1 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.browse.BrowseContentKt$BrowseContent$2$1$1
                @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                public Object get(Object obj) {
                    return ((BrowseReducer.State) obj).getCreateFolderState();
                }
            };
            ComposerKt.sourceInformationMarkerStart(composer, -1075175951, "CC(remember):BrowseContent.kt#9igjgp");
            BrowseContentKt$BrowseContent$2$1$2$1 browseContentKt$BrowseContent$2$1$2$1RememberedValue = composer.rememberedValue();
            if (browseContentKt$BrowseContent$2$1$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                browseContentKt$BrowseContent$2$1$2$1RememberedValue = BrowseContentKt$BrowseContent$2$1$2$1.INSTANCE;
                composer.updateRememberedValue(browseContentKt$BrowseContent$2$1$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            CreateFolderDialogKt.CreateFolderDialog(store.ifScope(browseContentKt$BrowseContent$2$1$1, (Function1) ((KFunction) browseContentKt$BrowseContent$2$1$2$1RememberedValue)), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    private static final BrowseReducer.State BrowseContent$lambda$0(State<BrowseReducer.State> state) {
        return state.getValue();
    }
}

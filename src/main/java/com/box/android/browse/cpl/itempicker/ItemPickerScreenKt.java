package com.box.android.browse.cpl.itempicker;

import androidx.activity.compose.BackHandlerKt;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.ColumnKt;
import androidx.compose.foundation.layout.ColumnScope;
import androidx.compose.foundation.layout.ColumnScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.base.compose.ButtonBarKt;
import com.box.android.base.compose.ImmutableButtonItems;
import com.box.android.base.compose.SwipeableSnackbarHostKt;
import com.box.android.base.compose.button.model.ButtonItem;
import com.box.android.browse.R;
import com.box.android.browse.compose.BoxBrowseToolbarsKt;
import com.box.android.browse.compose.FolderListingScreenKt;
import com.box.android.browse.cpl.createfolder.CreateFolderDialogKt;
import com.box.android.cpl.Store;
import com.box.android.domain.models.item.FolderModel;
import external.sdk.pendo.io.mozilla.javascript.Token;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.coroutines.EmptyCoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.PropertyReference1Impl;
import kotlin.reflect.KFunction;
import kotlinx.coroutines.BuildersKt__Builders_commonKt;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: ItemPickerScreen.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u00006\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\u001aO\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0012\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\u00010\u00072\u000e\b\u0002\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\fH\u0007¢\u0006\u0002\u0010\r\u001a3\u0010\u000e\u001a\u00020\u00012\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\f2\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0003¢\u0006\u0002\u0010\u0012¨\u0006\u0013²\u0006\n\u0010\u0014\u001a\u00020\u0004X\u008a\u0084\u0002²\u0006\u0012\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0001\u0018\u00010\nX\u008a\u0084\u0002"}, d2 = {"ItemPickerScreen", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/browse/cpl/itempicker/ItemPickerReducer$State;", "Lcom/box/android/browse/cpl/itempicker/ItemPickerReducer$Action;", "onInviteCollaborators", "Lkotlin/Function1;", "Lcom/box/android/domain/models/item/FolderModel;", "onClose", "Lkotlin/Function0;", "isRedesignedVersion", "", "(Lcom/box/android/cpl/Store;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;ZLandroidx/compose/runtime/Composer;II)V", "BottomBar", "buttonName", "", "isEnabled", "(Ljava/lang/Integer;ZLcom/box/android/cpl/Store;Landroidx/compose/runtime/Composer;I)V", "browse_generalProdRelease", "state", "onCreateFolder"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class ItemPickerScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomBar$lambda$1(Integer num, boolean z, Store store, int i, Composer composer, int i2) {
        BottomBar(num, z, store, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemPickerScreen$lambda$5(Store store, Function1 function1, Function0 function0, boolean z, int i, int i2, Composer composer, int i3) {
        ItemPickerScreen(store, function1, function0, z, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:30:0x005f  */
    /* JADX WARN: Code duplicated, block: B:31:0x0062  */
    /* JADX WARN: Code duplicated, block: B:33:0x0066  */
    /* JADX WARN: Code duplicated, block: B:35:0x006e  */
    /* JADX WARN: Code duplicated, block: B:36:0x0071  */
    /* JADX WARN: Code duplicated, block: B:41:0x007e  */
    /* JADX WARN: Code duplicated, block: B:42:0x0080  */
    /* JADX WARN: Code duplicated, block: B:45:0x0089  */
    /* JADX WARN: Code duplicated, block: B:47:0x008d  */
    /* JADX WARN: Code duplicated, block: B:49:0x009f  */
    /* JADX WARN: Code duplicated, block: B:51:0x00af  */
    /* JADX WARN: Code duplicated, block: B:53:0x00b3  */
    /* JADX WARN: Code duplicated, block: B:54:0x00b5  */
    /* JADX WARN: Code duplicated, block: B:57:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:60:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:63:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:66:0x012f  */
    /* JADX WARN: Code duplicated, block: B:69:0x013e  */
    /* JADX WARN: Code duplicated, block: B:70:0x0140  */
    /* JADX WARN: Code duplicated, block: B:73:0x0147  */
    /* JADX WARN: Code duplicated, block: B:75:0x014f  */
    /* JADX WARN: Code duplicated, block: B:78:0x0181  */
    /* JADX WARN: Code duplicated, block: B:80:0x0187  */
    /* JADX WARN: Code duplicated, block: B:83:0x0192  */
    /* JADX WARN: Code duplicated, block: B:85:? A[RETURN, SYNTHETIC] */
    public static final void ItemPickerScreen(final Store<ItemPickerReducer.State, ItemPickerReducer.Action> store, final Function1<? super FolderModel, Unit> onInviteCollaborators, Function0<Unit> function0, boolean z, Composer composer, final int i, final int i2) {
        int i3;
        Function0<Unit> function1;
        int i4;
        boolean z2;
        int i5;
        boolean z3;
        final Function0<Unit> function2;
        final boolean z4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Function0<Unit> function3;
        boolean z5;
        Object objRememberedValue;
        Object objRememberedValue2;
        final State stateCollectAsStateWithLifecycle;
        boolean z6;
        ItemPickerScreenKt$ItemPickerScreen$2$1 itemPickerScreenKt$ItemPickerScreen$2$1RememberedValue;
        Object objRememberedValue3;
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(onInviteCollaborators, "onInviteCollaborators");
        Composer composerStartRestartGroup = composer.startRestartGroup(-117074289);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ItemPickerScreen)N(store,onInviteCollaborators,onClose,isRedesignedVersion)39@1748L2,42@1825L32,43@1874L24,44@1928L29,49@2035L73,49@2014L94,53@2123L3297,53@2114L3306:ItemPickerScreen.kt#oru6qt");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onInviteCollaborators) ? 32 : 16;
        }
        int i6 = i2 & 4;
        if (i6 == 0) {
            if ((i & 384) == 0) {
                function1 = function0;
                i3 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
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
                if ((i3 & 1171) != 1170) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    function2 = function1;
                    z4 = z2;
                } else {
                    if (i6 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -839236623, "CC(remember):ItemPickerScreen.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new Function0() { // from class: com.box.android.browse.cpl.itempicker.ItemPickerScreenKt$$ExternalSyntheticLambda9
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function3 = (Function0) objRememberedValue3;
                    } else {
                        function3 = function1;
                    }
                    if (i4 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-117074289, i3, -1, "com.box.android.browse.cpl.itempicker.ItemPickerScreen (ItemPickerScreen.kt:41)");
                    }
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -839234129, "CC(remember):ItemPickerScreen.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new SnackbarHostState();
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    final SnackbarHostState snackbarHostState = (SnackbarHostState) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    final CoroutineScope coroutineScope = (CoroutineScope) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                    if (ItemPickerScreen$lambda$2(stateCollectAsStateWithLifecycle).isClosing()) {
                        function3.invoke();
                    }
                    Unit unit = Unit.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -839227368, "CC(remember):ItemPickerScreen.kt#9igjgp");
                    if ((i3 & 14) == 4) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    itemPickerScreenKt$ItemPickerScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z6 || itemPickerScreenKt$ItemPickerScreen$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        itemPickerScreenKt$ItemPickerScreen$2$1RememberedValue = new ItemPickerScreenKt$ItemPickerScreen$2$1(store, null);
                        composerStartRestartGroup.updateRememberedValue(itemPickerScreenKt$ItemPickerScreen$2$1RememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) itemPickerScreenKt$ItemPickerScreen$2$1RememberedValue, composerStartRestartGroup, 6);
                    z4 = z5;
                    BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(1513121508, true, new Function2() { // from class: com.box.android.browse.cpl.itempicker.ItemPickerScreenKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ItemPickerScreenKt.ItemPickerScreen$lambda$4(store, stateCollectAsStateWithLifecycle, snackbarHostState, z4, onInviteCollaborators, coroutineScope, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function2 = function3;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.itempicker.ItemPickerScreenKt$$ExternalSyntheticLambda11
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return ItemPickerScreenKt.ItemPickerScreen$lambda$5(store, onInviteCollaborators, function2, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 3072;
            z2 = z;
            if ((i3 & 1171) != 1170) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                function2 = function1;
                z4 = z2;
            } else {
                if (i6 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -839236623, "CC(remember):ItemPickerScreen.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function0() { // from class: com.box.android.browse.cpl.itempicker.ItemPickerScreenKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function3 = (Function0) objRememberedValue3;
                } else {
                    function3 = function1;
                }
                if (i4 != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-117074289, i3, -1, "com.box.android.browse.cpl.itempicker.ItemPickerScreen (ItemPickerScreen.kt:41)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -839234129, "CC(remember):ItemPickerScreen.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new SnackbarHostState();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                final SnackbarHostState snackbarHostState2 = (SnackbarHostState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                final CoroutineScope coroutineScope2 = (CoroutineScope) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                if (ItemPickerScreen$lambda$2(stateCollectAsStateWithLifecycle).isClosing()) {
                    function3.invoke();
                }
                Unit unit2 = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -839227368, "CC(remember):ItemPickerScreen.kt#9igjgp");
                if ((i3 & 14) == 4) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                itemPickerScreenKt$ItemPickerScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z6) {
                    itemPickerScreenKt$ItemPickerScreen$2$1RememberedValue = new ItemPickerScreenKt$ItemPickerScreen$2$1(store, null);
                    composerStartRestartGroup.updateRememberedValue(itemPickerScreenKt$ItemPickerScreen$2$1RememberedValue);
                } else {
                    itemPickerScreenKt$ItemPickerScreen$2$1RememberedValue = new ItemPickerScreenKt$ItemPickerScreen$2$1(store, null);
                    composerStartRestartGroup.updateRememberedValue(itemPickerScreenKt$ItemPickerScreen$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(unit2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) itemPickerScreenKt$ItemPickerScreen$2$1RememberedValue, composerStartRestartGroup, 6);
                z4 = z5;
                BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(1513121508, true, new Function2() { // from class: com.box.android.browse.cpl.itempicker.ItemPickerScreenKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ItemPickerScreenKt.ItemPickerScreen$lambda$4(store, stateCollectAsStateWithLifecycle, snackbarHostState2, z4, onInviteCollaborators, coroutineScope2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function2 = function3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.itempicker.ItemPickerScreenKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ItemPickerScreenKt.ItemPickerScreen$lambda$5(store, onInviteCollaborators, function2, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 384;
        function1 = function0;
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
            if ((i3 & 1171) != 1170) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                function2 = function1;
                z4 = z2;
            } else {
                if (i6 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -839236623, "CC(remember):ItemPickerScreen.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function0() { // from class: com.box.android.browse.cpl.itempicker.ItemPickerScreenKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function3 = (Function0) objRememberedValue3;
                } else {
                    function3 = function1;
                }
                if (i4 != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-117074289, i3, -1, "com.box.android.browse.cpl.itempicker.ItemPickerScreen (ItemPickerScreen.kt:41)");
                }
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -839234129, "CC(remember):ItemPickerScreen.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new SnackbarHostState();
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                final SnackbarHostState snackbarHostState3 = (SnackbarHostState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                final CoroutineScope coroutineScope3 = (CoroutineScope) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                if (ItemPickerScreen$lambda$2(stateCollectAsStateWithLifecycle).isClosing()) {
                    function3.invoke();
                }
                Unit unit3 = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -839227368, "CC(remember):ItemPickerScreen.kt#9igjgp");
                if ((i3 & 14) == 4) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                itemPickerScreenKt$ItemPickerScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z6) {
                    itemPickerScreenKt$ItemPickerScreen$2$1RememberedValue = new ItemPickerScreenKt$ItemPickerScreen$2$1(store, null);
                    composerStartRestartGroup.updateRememberedValue(itemPickerScreenKt$ItemPickerScreen$2$1RememberedValue);
                } else {
                    itemPickerScreenKt$ItemPickerScreen$2$1RememberedValue = new ItemPickerScreenKt$ItemPickerScreen$2$1(store, null);
                    composerStartRestartGroup.updateRememberedValue(itemPickerScreenKt$ItemPickerScreen$2$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(unit3, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) itemPickerScreenKt$ItemPickerScreen$2$1RememberedValue, composerStartRestartGroup, 6);
                z4 = z5;
                BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(1513121508, true, new Function2() { // from class: com.box.android.browse.cpl.itempicker.ItemPickerScreenKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ItemPickerScreenKt.ItemPickerScreen$lambda$4(store, stateCollectAsStateWithLifecycle, snackbarHostState3, z4, onInviteCollaborators, coroutineScope3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function2 = function3;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.itempicker.ItemPickerScreenKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return ItemPickerScreenKt.ItemPickerScreen$lambda$5(store, onInviteCollaborators, function2, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        z2 = z;
        if ((i3 & 1171) != 1170) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            function2 = function1;
            z4 = z2;
        } else {
            if (i6 != 0) {
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -839236623, "CC(remember):ItemPickerScreen.kt#9igjgp");
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function0() { // from class: com.box.android.browse.cpl.itempicker.ItemPickerScreenKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Unit.INSTANCE;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                function3 = (Function0) objRememberedValue3;
            } else {
                function3 = function1;
            }
            if (i4 != 0) {
                z5 = false;
            } else {
                z5 = z2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-117074289, i3, -1, "com.box.android.browse.cpl.itempicker.ItemPickerScreen (ItemPickerScreen.kt:41)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -839234129, "CC(remember):ItemPickerScreen.kt#9igjgp");
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new SnackbarHostState();
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            final SnackbarHostState snackbarHostState4 = (SnackbarHostState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 773894976, "CC(rememberCoroutineScope)N(getContext)600@27430L68:Effects.kt#9igjgp");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 683736516, "CC(remember):Effects.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = EffectsKt.createCompositionCoroutineScope(EmptyCoroutineContext.INSTANCE, composerStartRestartGroup);
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            final CoroutineScope coroutineScope4 = (CoroutineScope) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            if (ItemPickerScreen$lambda$2(stateCollectAsStateWithLifecycle).isClosing()) {
                function3.invoke();
            }
            Unit unit4 = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -839227368, "CC(remember):ItemPickerScreen.kt#9igjgp");
            if ((i3 & 14) == 4) {
                z6 = true;
            } else {
                z6 = false;
            }
            itemPickerScreenKt$ItemPickerScreen$2$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z6) {
                itemPickerScreenKt$ItemPickerScreen$2$1RememberedValue = new ItemPickerScreenKt$ItemPickerScreen$2$1(store, null);
                composerStartRestartGroup.updateRememberedValue(itemPickerScreenKt$ItemPickerScreen$2$1RememberedValue);
            } else {
                itemPickerScreenKt$ItemPickerScreen$2$1RememberedValue = new ItemPickerScreenKt$ItemPickerScreen$2$1(store, null);
                composerStartRestartGroup.updateRememberedValue(itemPickerScreenKt$ItemPickerScreen$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(unit4, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) itemPickerScreenKt$ItemPickerScreen$2$1RememberedValue, composerStartRestartGroup, 6);
            z4 = z5;
            BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(1513121508, true, new Function2() { // from class: com.box.android.browse.cpl.itempicker.ItemPickerScreenKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ItemPickerScreenKt.ItemPickerScreen$lambda$4(store, stateCollectAsStateWithLifecycle, snackbarHostState4, z4, onInviteCollaborators, coroutineScope4, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function2 = function3;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.itempicker.ItemPickerScreenKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ItemPickerScreenKt.ItemPickerScreen$lambda$5(store, onInviteCollaborators, function2, z4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemPickerScreen$lambda$4$2(SnackbarHostState snackbarHostState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C56@2188L60:ItemPickerScreen.kt#oru6qt");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-527514786, i, -1, "com.box.android.browse.cpl.itempicker.ItemPickerScreen.<anonymous>.<anonymous> (ItemPickerScreen.kt:56)");
            }
            SwipeableSnackbarHostKt.SwipeableSnackbarHost(snackbarHostState, null, composer, 6, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemPickerScreen$lambda$4(final Store store, final State state, final SnackbarHostState snackbarHostState, final boolean z, final Function1 function1, final CoroutineScope coroutineScope, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C58@2285L721,76@3032L210,55@2170L92,83@3253L2161,54@2133L3281:ItemPickerScreen.kt#oru6qt");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1513121508, i, -1, "com.box.android.browse.cpl.itempicker.ItemPickerScreen.<anonymous> (ItemPickerScreen.kt:54)");
            }
            ScaffoldKt.m4038ScaffoldTvnljyQ(null, ComposableLambdaKt.rememberComposableLambda(-2051277408, true, new Function2() { // from class: com.box.android.browse.cpl.itempicker.ItemPickerScreenKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ItemPickerScreenKt.ItemPickerScreen$lambda$4$0(store, state, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), ComposableLambdaKt.rememberComposableLambda(-1289396097, true, new Function2() { // from class: com.box.android.browse.cpl.itempicker.ItemPickerScreenKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ItemPickerScreenKt.ItemPickerScreen$lambda$4$1(store, state, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), ComposableLambdaKt.rememberComposableLambda(-527514786, true, new Function2() { // from class: com.box.android.browse.cpl.itempicker.ItemPickerScreenKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ItemPickerScreenKt.ItemPickerScreen$lambda$4$2(snackbarHostState, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), null, 0, 0L, 0L, null, ComposableLambdaKt.rememberComposableLambda(-443457419, true, new Function3() { // from class: com.box.android.browse.cpl.itempicker.ItemPickerScreenKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return ItemPickerScreenKt.ItemPickerScreen$lambda$4$3(z, state, function1, store, coroutineScope, snackbarHostState, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 805309872, 497);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemPickerScreen$lambda$4$0(final Store store, final State state, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C59@2325L318,70@2715L31,72@2875L46,69@2661L331:ItemPickerScreen.kt#oru6qt");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-2051277408, i, -1, "com.box.android.browse.cpl.itempicker.ItemPickerScreen.<anonymous>.<anonymous> (ItemPickerScreen.kt:59)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 112401374, "CC(remember):ItemPickerScreen.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt.derivedStateOf(new Function0() { // from class: com.box.android.browse.cpl.itempicker.ItemPickerScreenKt$$ExternalSyntheticLambda7
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ItemPickerScreenKt.ItemPickerScreen$lambda$4$0$0$0(state, store);
                    }
                });
                composer.updateRememberedValue(objRememberedValue);
            }
            State state2 = (State) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            String strFolderName = BoxBrowseToolbarsKt.folderName(ItemPickerScreen$lambda$2(state).getCurrentFolder(), composer, 0);
            String subtitle = ItemPickerScreen$lambda$2(state).getSubtitle();
            if (subtitle == null) {
                composer.startReplaceGroup(112416423);
                ComposerKt.sourceInformation(composer, "71@2804L39");
                subtitle = StringResources_androidKt.stringResource(R.string.Choose_an_item, composer, 0);
            } else {
                composer.startReplaceGroup(112415865);
            }
            composer.endReplaceGroup();
            String str = subtitle;
            ComposerKt.sourceInformationMarkerStart(composer, 112418702, "CC(remember):ItemPickerScreen.kt#9igjgp");
            boolean zChanged = composer.changed(store);
            Object objRememberedValue2 = composer.rememberedValue();
            if (zChanged || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = new Function0() { // from class: com.box.android.browse.cpl.itempicker.ItemPickerScreenKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ItemPickerScreenKt.ItemPickerScreen$lambda$4$0$2$0(store);
                    }
                };
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BoxBrowseToolbarsKt.ItemPickerToolbar(strFolderName, str, (Function0) objRememberedValue2, ItemPickerScreen$lambda$4$0$1(state2), composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Function0 ItemPickerScreen$lambda$4$0$0$0(State state, final Store store) {
        if (ItemPickerScreen$lambda$2(state).getCreateFolderEnabled()) {
            return new Function0() { // from class: com.box.android.browse.cpl.itempicker.ItemPickerScreenKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return ItemPickerScreenKt.ItemPickerScreen$lambda$4$0$0$0$0(store);
                }
            };
        }
        return null;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemPickerScreen$lambda$4$0$0$0$0(Store store) {
        store.send(ItemPickerReducer.Action.CreateFolder.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemPickerScreen$lambda$4$0$2$0(Store store) {
        store.send(ItemPickerReducer.Action.Close.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemPickerScreen$lambda$4$1(Store store, State state, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C77@3050L178:ItemPickerScreen.kt#oru6qt");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1289396097, i, -1, "com.box.android.browse.cpl.itempicker.ItemPickerScreen.<anonymous>.<anonymous> (ItemPickerScreen.kt:77)");
            }
            BottomBar(ItemPickerScreen$lambda$2(state).getSelectButtonName(), ItemPickerScreen$lambda$2(state).getSelectFolderEnabled(), store, composer, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemPickerScreen$lambda$4$3(boolean z, State state, Function1 function1, final Store store, CoroutineScope coroutineScope, SnackbarHostState snackbarHostState, PaddingValues padding, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(padding, "padding");
        ComposerKt.sourceInformation(composer, "CN(padding)84@3278L2126:ItemPickerScreen.kt#oru6qt");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(padding) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-443457419, i2, -1, "com.box.android.browse.cpl.itempicker.ItemPickerScreen.<anonymous>.<anonymous> (ItemPickerScreen.kt:84)");
            }
            Modifier modifierPadding = PaddingKt.padding(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), padding);
            ComposerKt.sourceInformationMarkerStart(composer, 1341605231, "CC(Column)N(modifier,verticalArrangement,horizontalAlignment,content)87@4443L61,88@4509L134:Column.kt#2w3rfo");
            MeasurePolicy measurePolicyColumnMeasurePolicy = ColumnKt.columnMeasurePolicy(Arrangement.INSTANCE.getTop(), Alignment.INSTANCE.getStart(), composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierPadding);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
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
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 2093002350, "C89@4557L9:Column.kt#2w3rfo");
            ColumnScopeInstance columnScopeInstance = ColumnScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 440586657, "C117@4763L275,117@4725L313,124@5074L83,124@5056L101:ItemPickerScreen.kt#oru6qt");
            composer.startMovableGroup(1399684749, Integer.valueOf(ItemPickerScreen$lambda$2(state).getStack().size()));
            ComposerKt.sourceInformation(composer, "91@3606L299,103@4176L39,98@3926L401");
            ComposerKt.sourceInformationMarkerStart(composer, 1399686262, "CC(remember):ItemPickerScreen.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = store.scope(new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itempicker.ItemPickerScreenKt$ItemPickerScreen$3$4$1$currentStore$1$1
                    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                    public Object get(Object obj) {
                        return ((ItemPickerReducer.State) obj).getStack();
                    }
                }, ItemPickerScreen$lambda$2(state).getStack().size() - 1, ItemPickerScreenKt$ItemPickerScreen$3$4$1$currentStore$1$2.INSTANCE);
                composer.updateRememberedValue(objRememberedValue);
            }
            Store store2 = (Store) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            Modifier modifierTestTag = TestTagKt.testTag(ColumnScope.weight$default(columnScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), "ItemPickerScreen");
            ComposerKt.sourceInformationMarkerStart(composer, 1399704242, "CC(remember):ItemPickerScreen.kt#9igjgp");
            Object objRememberedValue2 = composer.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = (Function4) new ItemPickerScreenKt$ItemPickerScreen$3$4$1$1$1(null);
                composer.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            FolderListingScreenKt.FolderListingScreen(store2, modifierTestTag, null, null, (Function4) objRememberedValue2, z, composer, 6, 12);
            composer.endMovableGroup();
            if (ItemPickerScreen$lambda$2(state).getCreateFolderState() == null) {
                composer.startReplaceGroup(441377527);
            } else {
                composer.startReplaceGroup(441377528);
                ComposerKt.sourceInformation(composer, "*112@4591L50,109@4414L275");
                ItemPickerScreenKt$ItemPickerScreen$3$4$1$2$1 itemPickerScreenKt$ItemPickerScreen$3$4$1$2$1 = new PropertyReference1Impl() { // from class: com.box.android.browse.cpl.itempicker.ItemPickerScreenKt$ItemPickerScreen$3$4$1$2$1
                    @Override // kotlin.jvm.internal.PropertyReference1Impl, kotlin.reflect.KProperty1
                    public Object get(Object obj) {
                        return ((ItemPickerReducer.State) obj).getCreateFolderState();
                    }
                };
                ComposerKt.sourceInformationMarkerStart(composer, 913330921, "CC(remember):ItemPickerScreen.kt#9igjgp");
                Object objRememberedValue3 = composer.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = (KFunction) ItemPickerScreenKt$ItemPickerScreen$3$4$1$2$2$1.INSTANCE;
                    composer.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                CreateFolderDialogKt.CreateFolderDialog(store.ifScope(itemPickerScreenKt$ItemPickerScreen$3$4$1$2$1, (Function1) ((KFunction) objRememberedValue3)), composer, 0);
            }
            composer.endReplaceGroup();
            ItemPickerReducer.Route navigationRoute = ItemPickerScreen$lambda$2(state).getNavigationRoute();
            ComposerKt.sourceInformationMarkerStart(composer, 1399723262, "CC(remember):ItemPickerScreen.kt#9igjgp");
            boolean zChanged = composer.changed(state) | composer.changed(function1) | composer.changed(store);
            Object objRememberedValue4 = composer.rememberedValue();
            if (zChanged || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = (Function2) new ItemPickerScreenKt$ItemPickerScreen$3$4$1$3$1(state, function1, store, null);
                composer.updateRememberedValue(objRememberedValue4);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            EffectsKt.LaunchedEffect(navigationRoute, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) objRememberedValue4, composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, 1399733022, "CC(remember):ItemPickerScreen.kt#9igjgp");
            boolean zChanged2 = composer.changed(store);
            Object objRememberedValue5 = composer.rememberedValue();
            if (zChanged2 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new Function0() { // from class: com.box.android.browse.cpl.itempicker.ItemPickerScreenKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ItemPickerScreenKt.ItemPickerScreen$lambda$4$3$0$4$0(store);
                    }
                };
                composer.updateRememberedValue(objRememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BackHandlerKt.BackHandler(true, (Function0) objRememberedValue5, composer, 6, 0);
            Integer error = ItemPickerScreen$lambda$2(state).getError();
            if (error == null) {
                composer.startReplaceGroup(442167500);
            } else {
                composer.startReplaceGroup(442167501);
                ComposerKt.sourceInformation(composer, "*129@5228L23,130@5285L87");
                String strStringResource = StringResources_androidKt.stringResource(error.intValue(), composer, 0);
                ComposerKt.sourceInformationMarkerStart(composer, 2068348195, "CC(remember):ItemPickerScreen.kt#9igjgp");
                boolean zChanged3 = composer.changed(strStringResource);
                Object objRememberedValue6 = composer.rememberedValue();
                if (zChanged3 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue6 = (Function2) new ItemPickerScreenKt$ItemPickerScreen$3$4$1$5$1$1(snackbarHostState, strStringResource, null);
                    composer.updateRememberedValue(objRememberedValue6);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                BuildersKt__Builders_commonKt.launch$default(coroutineScope, null, null, (Function2) objRememberedValue6, 3, null);
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

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ItemPickerScreen$lambda$4$3$0$4$0(Store store) {
        store.send(ItemPickerReducer.Action.GoBack.INSTANCE);
        return Unit.INSTANCE;
    }

    private static final void BottomBar(final Integer num, final boolean z, final Store<ItemPickerReducer.State, ItemPickerReducer.Action> store, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-710478760);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(BottomBar)N(buttonName,isEnabled,store)141@5581L310,150@5897L31:ItemPickerScreen.kt#oru6qt");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(num) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(z) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(store) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & Token.DOTQUERY) != 146, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-710478760, i2, -1, "com.box.android.browse.cpl.itempicker.BottomBar (ItemPickerScreen.kt:140)");
            }
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 129716398, "CC(remember):ItemPickerScreen.kt#9igjgp");
            boolean z2 = (i2 & 112) == 32;
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (z2 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new ImmutableButtonItems(CollectionsKt.listOf(new ButtonItem.TextButtonItem(z, new Function0() { // from class: com.box.android.browse.cpl.itempicker.ItemPickerScreenKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return ItemPickerScreenKt.BottomBar$lambda$0$0(store);
                    }
                }, num != null ? num.intValue() : R.string.Select_this_folder)));
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ButtonBarKt.ButtonBar((ImmutableButtonItems) objRememberedValue, composerStartRestartGroup, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.browse.cpl.itempicker.ItemPickerScreenKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return ItemPickerScreenKt.BottomBar$lambda$1(num, z, store, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit BottomBar$lambda$0$0(Store store) {
        store.send(ItemPickerReducer.Action.ConfirmSelection.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ItemPickerReducer.State ItemPickerScreen$lambda$2(State<ItemPickerReducer.State> state) {
        return state.getValue();
    }

    private static final Function0<Unit> ItemPickerScreen$lambda$4$0$1(State<? extends Function0<Unit>> state) {
        return state.getValue();
    }
}

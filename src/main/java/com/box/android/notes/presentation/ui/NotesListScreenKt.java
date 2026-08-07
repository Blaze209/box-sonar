package com.box.android.notes.presentation.ui;

import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.lazy.LazyDslKt;
import androidx.compose.foundation.lazy.LazyItemScope;
import androidx.compose.foundation.lazy.LazyListScope;
import androidx.compose.foundation.lazy.LazyListState;
import androidx.compose.foundation.lazy.LazyListStateKt;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.material3.pulltorefresh.PullToRefreshDefaults;
import androidx.compose.material3.pulltorefresh.PullToRefreshKt;
import androidx.compose.material3.pulltorefresh.PullToRefreshState;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.profileinstaller.ProfileVerifier;
import com.box.android.base.EmptyItemsWithPullToRefreshWorkaroundKt;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.base.compose.ComposeUtilsKt;
import com.box.android.base.compose.ItemStateScreensKt;
import com.box.android.base.compose.ItemsStateConfig;
import com.box.android.base.compose.divider.BoxHorizontalDividerKt;
import com.box.android.browse.R;
import com.box.android.browse.cpl.itemsList.ItemReducer;
import com.box.android.browse.cpl.itemsList.ItemsListReducer;
import com.box.android.cpl.Store;
import com.box.android.domain.models.DomainError;
import com.box.android.domain.models.DomainErrorKt;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.ItemType;
import com.box.android.notes.presentation.cpl.NoteReadStatus;
import com.box.android.notes.presentation.cpl.NotesItemViewData;
import com.box.android.notes.presentation.cpl.NotesItemViewDataKt;
import com.box.android.notes.presentation.cpl.NotesListReducer;
import com.swmansion.rnscreens.gamma.stack.screen.event.StackScreenDismissEvent;
import external.sdk.pendo.io.mozilla.javascript.Token;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlin.time.Duration;
import kotlin.time.DurationKt;
import kotlin.time.DurationUnit;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: NotesListScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0010\t\u001a;\u0010\u0000\u001a\u00020\u00012\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u00032\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000bH\u0007¢\u0006\u0002\u0010\f\u001a#\u0010\r\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u0011H\u0003¢\u0006\u0002\u0010\u0012\u001a1\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\t2\u0012\u0010\u0002\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00050\u0003H\u0003¢\u0006\u0002\u0010\u0015\u001aC\u0010\u0016\u001a\u00020\u00012\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0001\u0010\u0017\u001a\u00020\u00182\u0006\u0010\b\u001a\u00020\t2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00010\u00112\f\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u00010\u0011H\u0003¢\u0006\u0002\u0010\u001a\u001a{\u0010\u0000\u001a\u00020\u00012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u0006\u001a\u00020\u00072\u0006\u0010\u001e\u001a\u00020\u001f2\b\b\u0002\u0010\n\u001a\u00020\u000b2\b\b\u0002\u0010 \u001a\u00020\u000f2\u000e\b\u0002\u0010!\u001a\b\u0012\u0004\u0012\u00020\u00010\u00112\u0014\b\u0002\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00010#2\u0014\b\u0002\u0010%\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00010#H\u0003¢\u0006\u0002\u0010&\u001aK\u0010'\u001a\u00020\u00012\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001c2\u0006\u0010\u001e\u001a\u00020\u001f2\u0012\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00010#2\u0012\u0010%\u001a\u000e\u0012\u0004\u0012\u00020$\u0012\u0004\u0012\u00020\u00010#H\u0003¢\u0006\u0002\u0010(\u001a\r\u0010)\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010*\u001a\r\u0010+\u001a\u00020\u0001H\u0003¢\u0006\u0002\u0010*¨\u0006,²\u0006\n\u0010\u0014\u001a\u00020\u0004X\u008a\u0084\u0002²\u0006\n\u0010-\u001a\u00020.X\u008a\u0084\u0002"}, d2 = {"NotesListScreen", "", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/notes/presentation/cpl/NotesListReducer$State;", "Lcom/box/android/notes/presentation/cpl/NotesListReducer$Action;", "emptyScreenConfig", "Lcom/box/android/base/compose/ItemsStateConfig;", "snackbarHostState", "Landroidx/compose/material3/SnackbarHostState;", "modifier", "Landroidx/compose/ui/Modifier;", "(Lcom/box/android/cpl/Store;Lcom/box/android/base/compose/ItemsStateConfig;Landroidx/compose/material3/SnackbarHostState;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "NotesListErrorScreen", "isNetworkConnectionErrorMessage", "", "onRetry", "Lkotlin/Function0;", "(ZLkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "FavoriteUpdateErrorSnackbarEffect", "state", "(Lcom/box/android/notes/presentation/cpl/NotesListReducer$State;Landroidx/compose/material3/SnackbarHostState;Lcom/box/android/cpl/Store;Landroidx/compose/runtime/Composer;I)V", "NotesListRefreshErrorSnackbarEffect", "errorRes", "", StackScreenDismissEvent.EVENT_REGISTRATION_NAME, "(ZILandroidx/compose/material3/SnackbarHostState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "noteItems", "", "Lcom/box/android/notes/presentation/cpl/NotesItemViewData;", "lazyListState", "Landroidx/compose/foundation/lazy/LazyListState;", "isRefreshing", "onRefresh", "onItemClick", "Lkotlin/Function1;", "Lcom/box/android/domain/models/ItemId$Remote;", "onToggleFavorite", "(Ljava/util/List;Lcom/box/android/base/compose/ItemsStateConfig;Landroidx/compose/foundation/lazy/LazyListState;Landroidx/compose/ui/Modifier;ZLkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "NotesList", "(Ljava/util/List;Landroidx/compose/foundation/lazy/LazyListState;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "NotesListScreenPreview", "(Landroidx/compose/runtime/Composer;I)V", "NotesListScreenEmptyPreview", "notes_generalProdRelease", "currentTimeMillis", ""}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class NotesListScreenKt {
    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FavoriteUpdateErrorSnackbarEffect$lambda$1(NotesListReducer.State state, SnackbarHostState snackbarHostState, Store store, int i, Composer composer, int i2) {
        FavoriteUpdateErrorSnackbarEffect(state, snackbarHostState, store, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotesList$lambda$1(List list, LazyListState lazyListState, Function1 function1, Function1 function2, int i, Composer composer, int i2) {
        NotesList(list, lazyListState, function1, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotesListErrorScreen$lambda$0(boolean z, Function0 function0, int i, Composer composer, int i2) {
        NotesListErrorScreen(z, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotesListRefreshErrorSnackbarEffect$lambda$1(boolean z, int i, SnackbarHostState snackbarHostState, Function0 function0, Function0 function1, int i2, Composer composer, int i3) {
        NotesListRefreshErrorSnackbarEffect(z, i, snackbarHostState, function0, function1, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotesListScreen$lambda$13(List list, ItemsStateConfig itemsStateConfig, LazyListState lazyListState, Modifier modifier, boolean z, Function0 function0, Function1 function1, Function1 function2, int i, int i2, Composer composer, int i3) {
        NotesListScreen(list, itemsStateConfig, lazyListState, modifier, z, function0, function1, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotesListScreen$lambda$8(Store store, ItemsStateConfig itemsStateConfig, SnackbarHostState snackbarHostState, Modifier modifier, int i, int i2, Composer composer, int i3) {
        NotesListScreen(store, itemsStateConfig, snackbarHostState, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotesListScreenEmptyPreview$lambda$0(int i, Composer composer, int i2) {
        NotesListScreenEmptyPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotesListScreenPreview$lambda$1(int i, Composer composer, int i2) {
        NotesListScreenPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:100:0x0222  */
    /* JADX WARN: Code duplicated, block: B:105:0x0231  */
    /* JADX WARN: Code duplicated, block: B:108:0x026c  */
    /* JADX WARN: Code duplicated, block: B:109:0x0277  */
    /* JADX WARN: Code duplicated, block: B:111:0x0291  */
    /* JADX WARN: Code duplicated, block: B:112:0x0293  */
    /* JADX WARN: Code duplicated, block: B:117:0x02a3  */
    /* JADX WARN: Code duplicated, block: B:120:0x02ba  */
    /* JADX WARN: Code duplicated, block: B:121:0x02bc  */
    /* JADX WARN: Code duplicated, block: B:126:0x02cc  */
    /* JADX WARN: Code duplicated, block: B:131:0x02f1  */
    /* JADX WARN: Code duplicated, block: B:133:0x02f6  */
    /* JADX WARN: Code duplicated, block: B:136:0x0301  */
    /* JADX WARN: Code duplicated, block: B:138:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:37:0x007d  */
    /* JADX WARN: Code duplicated, block: B:38:0x007f  */
    /* JADX WARN: Code duplicated, block: B:41:0x0088 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:42:0x008a  */
    /* JADX WARN: Code duplicated, block: B:43:0x0091  */
    /* JADX WARN: Code duplicated, block: B:46:0x0099  */
    /* JADX WARN: Code duplicated, block: B:53:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:56:0x0114  */
    /* JADX WARN: Code duplicated, block: B:57:0x0117  */
    /* JADX WARN: Code duplicated, block: B:62:0x012a  */
    /* JADX WARN: Code duplicated, block: B:65:0x0156  */
    /* JADX WARN: Code duplicated, block: B:67:0x016e  */
    /* JADX WARN: Code duplicated, block: B:69:0x0177  */
    /* JADX WARN: Code duplicated, block: B:71:0x018b  */
    /* JADX WARN: Code duplicated, block: B:72:0x018d  */
    /* JADX WARN: Code duplicated, block: B:77:0x019c  */
    /* JADX WARN: Code duplicated, block: B:79:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:81:0x01d2  */
    /* JADX WARN: Code duplicated, block: B:82:0x01d4  */
    /* JADX WARN: Code duplicated, block: B:87:0x01e3  */
    /* JADX WARN: Code duplicated, block: B:90:0x01f9  */
    /* JADX WARN: Code duplicated, block: B:91:0x01fb  */
    /* JADX WARN: Code duplicated, block: B:96:0x020a  */
    /* JADX WARN: Code duplicated, block: B:99:0x0220  */
    public static final void NotesListScreen(final Store<NotesListReducer.State, NotesListReducer.Action> store, final ItemsStateConfig emptyScreenConfig, final SnackbarHostState snackbarHostState, Modifier modifier, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        boolean z;
        Composer composer2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        State stateCollectAsStateWithLifecycle;
        List<NotesItemViewData> notesItemViewDataList;
        ItemsListReducer.LoadingState itemLoadingState;
        LazyListState lazyListStateRememberLazyListState;
        Integer error;
        boolean z2;
        int i5;
        boolean z3;
        boolean z4;
        NotesListScreenKt$NotesListScreen$1$1 notesListScreenKt$NotesListScreen$1$1RememberedValue;
        boolean z5;
        Object objRememberedValue;
        boolean z6;
        Object objRememberedValue2;
        boolean z7;
        Object objRememberedValue3;
        boolean z8;
        Modifier modifier5;
        Integer error2;
        boolean z9;
        Object objRememberedValue4;
        boolean z10;
        Object objRememberedValue5;
        boolean z11;
        Object objRememberedValue6;
        Intrinsics.checkNotNullParameter(store, "store");
        Intrinsics.checkNotNullParameter(emptyScreenConfig, "emptyScreenConfig");
        Intrinsics.checkNotNullParameter(snackbarHostState, "snackbarHostState");
        Composer composerStartRestartGroup = composer.startRestartGroup(577813045);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NotesListScreen)N(store,emptyScreenConfig,snackbarHostState,modifier)60@2897L29,61@2956L51,65@3187L23,69@3380L159,69@3340L199,75@3545L66:NotesListScreen.kt#a1bbf8");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(emptyScreenConfig) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(snackbarHostState) ? 256 : 128;
        }
        int i6 = i2 & 8;
        if (i6 == 0) {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            i4 = i3;
            if ((i4 & 1171) != 1170) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                if (i6 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(577813045, i4, -1, "com.box.android.notes.presentation.ui.NotesListScreen (NotesListScreen.kt:59)");
                }
                stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                composer2 = composerStartRestartGroup;
                Duration.Companion companion = Duration.INSTANCE;
                notesItemViewDataList = NotesItemViewDataKt.toNotesItemViewDataList(NotesListScreen$lambda$0(stateCollectAsStateWithLifecycle), NotesListScreen$lambda$1(ComposeUtilsKt.m11636rememberCurrentTimeMillisKLykuaI(DurationKt.toDuration(1, DurationUnit.MINUTES), composer2, 0)));
                itemLoadingState = NotesListScreen$lambda$0(stateCollectAsStateWithLifecycle).getItemsListViewState().getItemLoadingState();
                lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composer2, 0, 3);
                error = NotesListScreen$lambda$0(stateCollectAsStateWithLifecycle).getItemsListViewState().getError();
                int i7 = R.string.boxsdk_error_network_connection;
                if (error == null && error.intValue() == i7) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                Boolean boolValueOf = Boolean.valueOf(NotesListScreen$lambda$0(stateCollectAsStateWithLifecycle).getShouldScrollToTop());
                ComposerKt.sourceInformationMarkerStart(composer2, 1227577748, "CC(remember):NotesListScreen.kt#9igjgp");
                boolean zChanged = composer2.changed(stateCollectAsStateWithLifecycle) | composer2.changed(lazyListStateRememberLazyListState);
                i5 = i4 & 14;
                if (i5 == 4) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                z4 = zChanged | z3;
                notesListScreenKt$NotesListScreen$1$1RememberedValue = composer2.rememberedValue();
                if (!z4 || notesListScreenKt$NotesListScreen$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    notesListScreenKt$NotesListScreen$1$1RememberedValue = new NotesListScreenKt$NotesListScreen$1$1(lazyListStateRememberLazyListState, store, stateCollectAsStateWithLifecycle, null);
                    composer2.updateRememberedValue(notesListScreenKt$NotesListScreen$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer2);
                EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) notesListScreenKt$NotesListScreen$1$1RememberedValue, composer2, 0);
                FavoriteUpdateErrorSnackbarEffect(NotesListScreen$lambda$0(stateCollectAsStateWithLifecycle), snackbarHostState, store, composer2, ((i4 >> 3) & 112) | ((i4 << 6) & 896));
                if (Intrinsics.areEqual(itemLoadingState, ItemsListReducer.LoadingState.Loading.INSTANCE)) {
                    composer2.startReplaceGroup(-599492697);
                    ComposerKt.sourceInformation(composer2, "79@3702L46");
                    ItemStateScreensKt.LoadingItemsScreen(null, true, composer2, 48, 1);
                    composer2.endReplaceGroup();
                } else {
                    if (Intrinsics.areEqual(itemLoadingState, ItemsListReducer.LoadingState.Error.INSTANCE)) {
                        composer2.startReplaceGroup(-599369286);
                        ComposerKt.sourceInformation(composer2, "85@3952L74,83@3821L219");
                        ComposerKt.sourceInformationMarkerStart(composer2, 1227595967, "CC(remember):NotesListScreen.kt#9igjgp");
                        if (i5 == 4) {
                            z11 = true;
                        } else {
                            z11 = false;
                        }
                        objRememberedValue6 = composer2.rememberedValue();
                        if (!z11 || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue6 = new Function0() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda14
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return NotesListScreenKt.NotesListScreen$lambda$3$0(store);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue6);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        NotesListErrorScreen(z2, (Function0) objRememberedValue6, composer2, 0);
                        composer2.endReplaceGroup();
                    } else {
                        composer2.startReplaceGroup(-599078227);
                        ComposerKt.sourceInformation(composer2, "95@4351L79,96@4462L148,99@4647L83,90@4082L699");
                        boolean pullToRefreshIsRefreshing = NotesListScreen$lambda$0(stateCollectAsStateWithLifecycle).getItemsListViewState().getPullToRefreshIsRefreshing();
                        ComposerKt.sourceInformationMarkerStart(composer2, 1227608740, "CC(remember):NotesListScreen.kt#9igjgp");
                        if (i5 == 4) {
                            z5 = true;
                        } else {
                            z5 = false;
                        }
                        objRememberedValue = composer2.rememberedValue();
                        if (!z5 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function0() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda15
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return NotesListScreenKt.NotesListScreen$lambda$4$0(store);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue);
                        }
                        Function0 function0 = (Function0) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerStart(composer2, 1227612361, "CC(remember):NotesListScreen.kt#9igjgp");
                        if (i5 == 4) {
                            z6 = true;
                        } else {
                            z6 = false;
                        }
                        objRememberedValue2 = composer2.rememberedValue();
                        if (!z6 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda16
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return NotesListScreenKt.NotesListScreen$lambda$5$0(store, (ItemId.Remote) obj);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue2);
                        }
                        Function1 function1 = (Function1) objRememberedValue2;
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerStart(composer2, 1227618216, "CC(remember):NotesListScreen.kt#9igjgp");
                        if (i5 == 4) {
                            z7 = true;
                        } else {
                            z7 = false;
                        }
                        objRememberedValue3 = composer2.rememberedValue();
                        if (!z7 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda17
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return NotesListScreenKt.NotesListScreen$lambda$6$0(store, (ItemId.Remote) obj);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        z8 = z2;
                        Modifier modifier6 = modifier4;
                        NotesListScreen(notesItemViewDataList, emptyScreenConfig, lazyListStateRememberLazyListState, modifier6, pullToRefreshIsRefreshing, function0, function1, (Function1) objRememberedValue3, composer2, i4 & 7280, 0);
                        modifier5 = modifier6;
                        composer2 = composer2;
                        error2 = NotesListScreen$lambda$0(stateCollectAsStateWithLifecycle).getItemsListViewState().getError();
                        if (error2 == null) {
                            composer2.startReplaceGroup(-598349139);
                            composer2.endReplaceGroup();
                        } else {
                            composer2.startReplaceGroup(-598349138);
                            ComposerKt.sourceInformation(composer2, "*110@5115L81,111@5230L76,106@4861L463");
                            int iIntValue = error2.intValue();
                            ComposerKt.sourceInformationMarkerStart(composer2, -2035842725, "CC(remember):NotesListScreen.kt#9igjgp");
                            if (i5 == 4) {
                                z9 = true;
                            } else {
                                z9 = false;
                            }
                            objRememberedValue4 = composer2.rememberedValue();
                            if (!z9 || objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue4 = new Function0() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda18
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return NotesListScreenKt.NotesListScreen$lambda$7$0$0(store);
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue4);
                            }
                            Function0 function2 = (Function0) objRememberedValue4;
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            ComposerKt.sourceInformationMarkerStart(composer2, -2035839050, "CC(remember):NotesListScreen.kt#9igjgp");
                            if (i5 == 4) {
                                z10 = true;
                            } else {
                                z10 = false;
                            }
                            objRememberedValue5 = composer2.rememberedValue();
                            if (!z10 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue5 = new Function0() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda19
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return NotesListScreenKt.NotesListScreen$lambda$7$1$0(store);
                                    }
                                };
                                composer2.updateRememberedValue(objRememberedValue5);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composer2);
                            NotesListRefreshErrorSnackbarEffect(z8, iIntValue, snackbarHostState, function2, (Function0) objRememberedValue5, composer2, i4 & 896);
                            composer2.endReplaceGroup();
                            Unit unit = Unit.INSTANCE;
                        }
                        composer2.endReplaceGroup();
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier5;
                }
                modifier5 = modifier4;
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier5;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda1
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NotesListScreenKt.NotesListScreen$lambda$8(store, emptyScreenConfig, snackbarHostState, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        modifier2 = modifier;
        i4 = i3;
        if ((i4 & 1171) != 1170) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i4 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i6 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(577813045, i4, -1, "com.box.android.notes.presentation.ui.NotesListScreen (NotesListScreen.kt:59)");
            }
            stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            composer2 = composerStartRestartGroup;
            Duration.Companion companion2 = Duration.INSTANCE;
            notesItemViewDataList = NotesItemViewDataKt.toNotesItemViewDataList(NotesListScreen$lambda$0(stateCollectAsStateWithLifecycle), NotesListScreen$lambda$1(ComposeUtilsKt.m11636rememberCurrentTimeMillisKLykuaI(DurationKt.toDuration(1, DurationUnit.MINUTES), composer2, 0)));
            itemLoadingState = NotesListScreen$lambda$0(stateCollectAsStateWithLifecycle).getItemsListViewState().getItemLoadingState();
            lazyListStateRememberLazyListState = LazyListStateKt.rememberLazyListState(0, 0, composer2, 0, 3);
            error = NotesListScreen$lambda$0(stateCollectAsStateWithLifecycle).getItemsListViewState().getError();
            int i8 = R.string.boxsdk_error_network_connection;
            if (error == null) {
                z2 = false;
            } else {
                z2 = true;
            }
            Boolean boolValueOf2 = Boolean.valueOf(NotesListScreen$lambda$0(stateCollectAsStateWithLifecycle).getShouldScrollToTop());
            ComposerKt.sourceInformationMarkerStart(composer2, 1227577748, "CC(remember):NotesListScreen.kt#9igjgp");
            boolean zChanged2 = composer2.changed(stateCollectAsStateWithLifecycle) | composer2.changed(lazyListStateRememberLazyListState);
            i5 = i4 & 14;
            if (i5 == 4) {
                z3 = true;
            } else {
                z3 = false;
            }
            z4 = zChanged2 | z3;
            notesListScreenKt$NotesListScreen$1$1RememberedValue = composer2.rememberedValue();
            if (!z4) {
                notesListScreenKt$NotesListScreen$1$1RememberedValue = new NotesListScreenKt$NotesListScreen$1$1(lazyListStateRememberLazyListState, store, stateCollectAsStateWithLifecycle, null);
                composer2.updateRememberedValue(notesListScreenKt$NotesListScreen$1$1RememberedValue);
            } else {
                notesListScreenKt$NotesListScreen$1$1RememberedValue = new NotesListScreenKt$NotesListScreen$1$1(lazyListStateRememberLazyListState, store, stateCollectAsStateWithLifecycle, null);
                composer2.updateRememberedValue(notesListScreenKt$NotesListScreen$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer2);
            EffectsKt.LaunchedEffect(boolValueOf2, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) notesListScreenKt$NotesListScreen$1$1RememberedValue, composer2, 0);
            FavoriteUpdateErrorSnackbarEffect(NotesListScreen$lambda$0(stateCollectAsStateWithLifecycle), snackbarHostState, store, composer2, ((i4 >> 3) & 112) | ((i4 << 6) & 896));
            if (Intrinsics.areEqual(itemLoadingState, ItemsListReducer.LoadingState.Loading.INSTANCE)) {
                composer2.startReplaceGroup(-599492697);
                ComposerKt.sourceInformation(composer2, "79@3702L46");
                ItemStateScreensKt.LoadingItemsScreen(null, true, composer2, 48, 1);
                composer2.endReplaceGroup();
            } else {
                if (Intrinsics.areEqual(itemLoadingState, ItemsListReducer.LoadingState.Error.INSTANCE)) {
                    composer2.startReplaceGroup(-599369286);
                    ComposerKt.sourceInformation(composer2, "85@3952L74,83@3821L219");
                    ComposerKt.sourceInformationMarkerStart(composer2, 1227595967, "CC(remember):NotesListScreen.kt#9igjgp");
                    if (i5 == 4) {
                        z11 = true;
                    } else {
                        z11 = false;
                    }
                    objRememberedValue6 = composer2.rememberedValue();
                    if (!z11) {
                        objRememberedValue6 = new Function0() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda14
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return NotesListScreenKt.NotesListScreen$lambda$3$0(store);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue6);
                    } else {
                        objRememberedValue6 = new Function0() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda14
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return NotesListScreenKt.NotesListScreen$lambda$3$0(store);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue6);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    NotesListErrorScreen(z2, (Function0) objRememberedValue6, composer2, 0);
                    composer2.endReplaceGroup();
                } else {
                    composer2.startReplaceGroup(-599078227);
                    ComposerKt.sourceInformation(composer2, "95@4351L79,96@4462L148,99@4647L83,90@4082L699");
                    boolean pullToRefreshIsRefreshing2 = NotesListScreen$lambda$0(stateCollectAsStateWithLifecycle).getItemsListViewState().getPullToRefreshIsRefreshing();
                    ComposerKt.sourceInformationMarkerStart(composer2, 1227608740, "CC(remember):NotesListScreen.kt#9igjgp");
                    if (i5 == 4) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    objRememberedValue = composer2.rememberedValue();
                    if (!z5) {
                        objRememberedValue = new Function0() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda15
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return NotesListScreenKt.NotesListScreen$lambda$4$0(store);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue);
                    } else {
                        objRememberedValue = new Function0() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda15
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return NotesListScreenKt.NotesListScreen$lambda$4$0(store);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue);
                    }
                    Function0 function3 = (Function0) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerStart(composer2, 1227612361, "CC(remember):NotesListScreen.kt#9igjgp");
                    if (i5 == 4) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    objRememberedValue2 = composer2.rememberedValue();
                    if (!z6) {
                        objRememberedValue2 = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda16
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return NotesListScreenKt.NotesListScreen$lambda$5$0(store, (ItemId.Remote) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue2);
                    } else {
                        objRememberedValue2 = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda16
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return NotesListScreenKt.NotesListScreen$lambda$5$0(store, (ItemId.Remote) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue2);
                    }
                    Function1 function4 = (Function1) objRememberedValue2;
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    ComposerKt.sourceInformationMarkerStart(composer2, 1227618216, "CC(remember):NotesListScreen.kt#9igjgp");
                    if (i5 == 4) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    objRememberedValue3 = composer2.rememberedValue();
                    if (!z7) {
                        objRememberedValue3 = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda17
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return NotesListScreenKt.NotesListScreen$lambda$6$0(store, (ItemId.Remote) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue3);
                    } else {
                        objRememberedValue3 = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda17
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return NotesListScreenKt.NotesListScreen$lambda$6$0(store, (ItemId.Remote) obj);
                            }
                        };
                        composer2.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composer2);
                    z8 = z2;
                    Modifier modifier7 = modifier4;
                    NotesListScreen(notesItemViewDataList, emptyScreenConfig, lazyListStateRememberLazyListState, modifier7, pullToRefreshIsRefreshing2, function3, function4, (Function1) objRememberedValue3, composer2, i4 & 7280, 0);
                    modifier5 = modifier7;
                    composer2 = composer2;
                    error2 = NotesListScreen$lambda$0(stateCollectAsStateWithLifecycle).getItemsListViewState().getError();
                    if (error2 == null) {
                        composer2.startReplaceGroup(-598349139);
                        composer2.endReplaceGroup();
                    } else {
                        composer2.startReplaceGroup(-598349138);
                        ComposerKt.sourceInformation(composer2, "*110@5115L81,111@5230L76,106@4861L463");
                        int iIntValue2 = error2.intValue();
                        ComposerKt.sourceInformationMarkerStart(composer2, -2035842725, "CC(remember):NotesListScreen.kt#9igjgp");
                        if (i5 == 4) {
                            z9 = true;
                        } else {
                            z9 = false;
                        }
                        objRememberedValue4 = composer2.rememberedValue();
                        if (!z9) {
                            objRememberedValue4 = new Function0() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda18
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return NotesListScreenKt.NotesListScreen$lambda$7$0$0(store);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue4);
                        } else {
                            objRememberedValue4 = new Function0() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda18
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return NotesListScreenKt.NotesListScreen$lambda$7$0$0(store);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue4);
                        }
                        Function0 function5 = (Function0) objRememberedValue4;
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        ComposerKt.sourceInformationMarkerStart(composer2, -2035839050, "CC(remember):NotesListScreen.kt#9igjgp");
                        if (i5 == 4) {
                            z10 = true;
                        } else {
                            z10 = false;
                        }
                        objRememberedValue5 = composer2.rememberedValue();
                        if (!z10) {
                            objRememberedValue5 = new Function0() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda19
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return NotesListScreenKt.NotesListScreen$lambda$7$1$0(store);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue5);
                        } else {
                            objRememberedValue5 = new Function0() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda19
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return NotesListScreenKt.NotesListScreen$lambda$7$1$0(store);
                                }
                            };
                            composer2.updateRememberedValue(objRememberedValue5);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composer2);
                        NotesListRefreshErrorSnackbarEffect(z8, iIntValue2, snackbarHostState, function5, (Function0) objRememberedValue5, composer2, i4 & 896);
                        composer2.endReplaceGroup();
                        Unit unit2 = Unit.INSTANCE;
                    }
                    composer2.endReplaceGroup();
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier5;
            }
            modifier5 = modifier4;
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NotesListScreenKt.NotesListScreen$lambda$8(store, emptyScreenConfig, snackbarHostState, modifier3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotesListScreen$lambda$3$0(Store store) {
        store.send(new NotesListReducer.Action.ItemsListAction(ItemsListReducer.Action.FetchItems.INSTANCE));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotesListScreen$lambda$4$0(Store store) {
        store.send(new NotesListReducer.Action.ItemsListAction(ItemsListReducer.Action.PulledToRefresh.INSTANCE));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotesListScreen$lambda$5$0(Store store, ItemId.Remote id) {
        Intrinsics.checkNotNullParameter(id, "id");
        store.send(new NotesListReducer.Action.ItemsListAction(new ItemsListReducer.Action.ItemAction(id, ItemReducer.Action.Clicked.INSTANCE)));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotesListScreen$lambda$6$0(Store store, ItemId.Remote id) {
        Intrinsics.checkNotNullParameter(id, "id");
        store.send(new NotesListReducer.Action.ToggleFavorite(id));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotesListScreen$lambda$7$0$0(Store store) {
        store.send(new NotesListReducer.Action.ItemsListAction(ItemsListReducer.Action.RefreshFromRemote.INSTANCE));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotesListScreen$lambda$7$1$0(Store store) {
        store.send(new NotesListReducer.Action.ItemsListAction(ItemsListReducer.Action.HandledError.INSTANCE));
        return Unit.INSTANCE;
    }

    private static final void NotesListErrorScreen(final boolean z, Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        final Function0<Unit> function1;
        Composer composerStartRestartGroup = composer.startRestartGroup(512956808);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NotesListErrorScreen)N(isNetworkConnectionErrorMessage,onRetry):NotesListScreen.kt#a1bbf8");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if (composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(512956808, i2, -1, "com.box.android.notes.presentation.ui.NotesListErrorScreen (NotesListScreen.kt:119)");
            }
            if (z) {
                composerStartRestartGroup.startReplaceGroup(2760673);
                ComposerKt.sourceInformation(composerStartRestartGroup, "121@5519L73");
                ItemStateScreensKt.NetworkConnectionError(function0, true, composerStartRestartGroup, ((i2 >> 3) & 14) | 48, 0);
                composerStartRestartGroup.endReplaceGroup();
                function1 = function0;
            } else {
                composerStartRestartGroup.startReplaceGroup(2854789);
                ComposerKt.sourceInformation(composerStartRestartGroup, "123@5614L69");
                function1 = function0;
                ItemStateScreensKt.GenericErrorScreen(function1, true, 0, null, 0, null, composerStartRestartGroup, ((i2 >> 3) & 14) | 48, 60);
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            function1 = function0;
            composerStartRestartGroup.skipToGroupEnd();
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NotesListScreenKt.NotesListErrorScreen$lambda$0(z, function1, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void FavoriteUpdateErrorSnackbarEffect(final NotesListReducer.State state, final SnackbarHostState snackbarHostState, final Store<NotesListReducer.State, NotesListReducer.Action> store, Composer composer, final int i) {
        int i2;
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(34264246);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FavoriteUpdateErrorSnackbarEffect)N(state,snackbarHostState,store):NotesListScreen.kt#a1bbf8");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(state) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(snackbarHostState) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(store) ? 256 : 128;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & Token.DOTQUERY) != 146, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(34264246, i2, -1, "com.box.android.notes.presentation.ui.FavoriteUpdateErrorSnackbarEffect (NotesListScreen.kt:132)");
            }
            DomainError favoriteUpdateError = state.getFavoriteUpdateError();
            if (favoriteUpdateError == null) {
                composerStartRestartGroup.startReplaceGroup(-1435850922);
            } else {
                composerStartRestartGroup.startReplaceGroup(-1435850921);
                ComposerKt.sourceInformation(composerStartRestartGroup, "*139@6151L26,140@6208L168,140@6186L190");
                if (DomainErrorKt.isNetworkConnectionError(favoriteUpdateError)) {
                    i3 = R.string.boxsdk_error_network_connection;
                } else {
                    i3 = com.box.android.notes.R.string.notes_favorite_update_failed;
                }
                String strStringResource = StringResources_androidKt.stringResource(i3, composerStartRestartGroup, 0);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1307485601, "CC(remember):NotesListScreen.kt#9igjgp");
                boolean zChanged = ((i2 & 112) == 32) | composerStartRestartGroup.changed(strStringResource) | ((i2 & 896) == 256);
                NotesListScreenKt$FavoriteUpdateErrorSnackbarEffect$1$1$1 notesListScreenKt$FavoriteUpdateErrorSnackbarEffect$1$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged || notesListScreenKt$FavoriteUpdateErrorSnackbarEffect$1$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    notesListScreenKt$FavoriteUpdateErrorSnackbarEffect$1$1$1RememberedValue = new NotesListScreenKt$FavoriteUpdateErrorSnackbarEffect$1$1$1(snackbarHostState, strStringResource, store, null);
                    composerStartRestartGroup.updateRememberedValue(notesListScreenKt$FavoriteUpdateErrorSnackbarEffect$1$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(favoriteUpdateError, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) notesListScreenKt$FavoriteUpdateErrorSnackbarEffect$1$1$1RememberedValue, composerStartRestartGroup, 0);
            }
            composerStartRestartGroup.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NotesListScreenKt.FavoriteUpdateErrorSnackbarEffect$lambda$1(state, snackbarHostState, store, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void NotesListRefreshErrorSnackbarEffect(final boolean z, final int i, final SnackbarHostState snackbarHostState, final Function0<Unit> function0, final Function0<Unit> function1, Composer composer, final int i2) {
        int i3;
        Composer composerStartRestartGroup = composer.startRestartGroup(1521188464);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NotesListRefreshErrorSnackbarEffect)N(isNetworkConnectionErrorMessage,errorRes,snackbarHostState,onRetry,onDismiss)155@6638L24,156@6696L57,158@6780L616,158@6759L637:NotesListScreen.kt#a1bbf8");
        if ((i2 & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i2;
        } else {
            i3 = i2;
        }
        if ((i2 & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(i) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i3 |= composerStartRestartGroup.changed(snackbarHostState) ? 256 : 128;
        }
        if ((i2 & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function0) ? 2048 : 1024;
        }
        if ((i2 & 24576) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 16384 : 8192;
        }
        if (!composerStartRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1521188464, i3, -1, "com.box.android.notes.presentation.ui.NotesListRefreshErrorSnackbarEffect (NotesListScreen.kt:154)");
            }
            String strStringResource = StringResources_androidKt.stringResource(i, composerStartRestartGroup, (i3 >> 3) & 14);
            String strStringResource2 = StringResources_androidKt.stringResource(R.string.box_browsesdk_tap_to_retry, composerStartRestartGroup, 0);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1573245848, "CC(remember):NotesListScreen.kt#9igjgp");
            boolean zChanged = ((i3 & 14) == 4) | ((i3 & 896) == 256) | composerStartRestartGroup.changed(strStringResource) | composerStartRestartGroup.changed(strStringResource2) | ((i3 & 7168) == 2048) | ((i3 & 57344) == 16384);
            NotesListScreenKt$NotesListRefreshErrorSnackbarEffect$1$1 notesListScreenKt$NotesListRefreshErrorSnackbarEffect$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChanged || notesListScreenKt$NotesListRefreshErrorSnackbarEffect$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                notesListScreenKt$NotesListRefreshErrorSnackbarEffect$1$1RememberedValue = new NotesListScreenKt$NotesListRefreshErrorSnackbarEffect$1$1(snackbarHostState, z, strStringResource, strStringResource2, function0, function1, null);
                composerStartRestartGroup.updateRememberedValue(notesListScreenKt$NotesListRefreshErrorSnackbarEffect$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) notesListScreenKt$NotesListRefreshErrorSnackbarEffect$1$1RememberedValue, composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NotesListScreenKt.NotesListRefreshErrorSnackbarEffect$lambda$1(z, i, snackbarHostState, function0, function1, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotesListScreen$lambda$10$0(ItemId.Remote it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotesListScreen$lambda$11$0(ItemId.Remote it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:100:0x0132  */
    /* JADX WARN: Code duplicated, block: B:102:0x0144  */
    /* JADX WARN: Code duplicated, block: B:105:0x0154  */
    /* JADX WARN: Code duplicated, block: B:107:0x0166  */
    /* JADX WARN: Code duplicated, block: B:109:0x0174  */
    /* JADX WARN: Code duplicated, block: B:112:0x017c  */
    /* JADX WARN: Code duplicated, block: B:115:0x01e2  */
    /* JADX WARN: Code duplicated, block: B:118:0x01ee  */
    /* JADX WARN: Code duplicated, block: B:119:0x01f2  */
    /* JADX WARN: Code duplicated, block: B:122:0x0244  */
    /* JADX WARN: Code duplicated, block: B:123:0x026e  */
    /* JADX WARN: Code duplicated, block: B:126:0x02f1  */
    /* JADX WARN: Code duplicated, block: B:128:0x02fb  */
    /* JADX WARN: Code duplicated, block: B:131:0x030a  */
    /* JADX WARN: Code duplicated, block: B:133:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:39:0x0070  */
    /* JADX WARN: Code duplicated, block: B:40:0x0073  */
    /* JADX WARN: Code duplicated, block: B:42:0x0077  */
    /* JADX WARN: Code duplicated, block: B:44:0x007f  */
    /* JADX WARN: Code duplicated, block: B:45:0x0082  */
    /* JADX WARN: Code duplicated, block: B:50:0x008e  */
    /* JADX WARN: Code duplicated, block: B:51:0x0090  */
    /* JADX WARN: Code duplicated, block: B:53:0x0093  */
    /* JADX WARN: Code duplicated, block: B:55:0x009b  */
    /* JADX WARN: Code duplicated, block: B:56:0x009e  */
    /* JADX WARN: Code duplicated, block: B:61:0x00aa  */
    /* JADX WARN: Code duplicated, block: B:62:0x00ac  */
    /* JADX WARN: Code duplicated, block: B:64:0x00af  */
    /* JADX WARN: Code duplicated, block: B:66:0x00b7  */
    /* JADX WARN: Code duplicated, block: B:67:0x00ba  */
    /* JADX WARN: Code duplicated, block: B:72:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:73:0x00ca  */
    /* JADX WARN: Code duplicated, block: B:75:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:77:0x00d8  */
    /* JADX WARN: Code duplicated, block: B:78:0x00db  */
    /* JADX WARN: Code duplicated, block: B:83:0x00ef  */
    /* JADX WARN: Code duplicated, block: B:84:0x00f1  */
    /* JADX WARN: Code duplicated, block: B:87:0x00fa A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:88:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:90:0x0103  */
    /* JADX WARN: Code duplicated, block: B:91:0x0106  */
    /* JADX WARN: Code duplicated, block: B:94:0x010c  */
    /* JADX WARN: Code duplicated, block: B:96:0x011e  */
    /* JADX WARN: Code duplicated, block: B:98:0x012e  */
    public static final void NotesListScreen(final List<NotesItemViewData> list, final ItemsStateConfig itemsStateConfig, final LazyListState lazyListState, Modifier modifier, boolean z, Function0<Unit> function0, Function1<? super ItemId.Remote, Unit> function1, Function1<? super ItemId.Remote, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        LazyListState lazyListState2;
        Modifier modifier2;
        int i4;
        boolean z2;
        int i5;
        int i6;
        Function0<Unit> function3;
        int i7;
        int i8;
        Function1<? super ItemId.Remote, Unit> function4;
        int i9;
        int i10;
        int i11;
        boolean z3;
        final Function1<? super ItemId.Remote, Unit> function5;
        final Modifier modifier3;
        final boolean z4;
        final Function0<Unit> function6;
        final Function1<? super ItemId.Remote, Unit> function7;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        boolean z5;
        Function0<Unit> function8;
        Function1<? super ItemId.Remote, Unit> function9;
        Function0<ComposeUiNode> constructor;
        Function1<? super ItemId.Remote, Unit> function10;
        Function1<? super ItemId.Remote, Unit> function11;
        Function1<? super ItemId.Remote, Unit> function12;
        Object objRememberedValue;
        Object objRememberedValue2;
        Object objRememberedValue3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-266863461);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NotesListScreen)N(noteItems,emptyScreenConfig,lazyListState,modifier,isRefreshing,onRefresh,onItemClick,onToggleFavorite)186@7654L2,187@7701L2,188@7753L2,190@7789L28,191@7822L940:NotesListScreen.kt#a1bbf8");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(list) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(itemsStateConfig) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            lazyListState2 = lazyListState;
            i3 |= composerStartRestartGroup.changed(lazyListState2) ? 256 : 128;
        } else {
            lazyListState2 = lazyListState;
        }
        int i12 = i2 & 8;
        if (i12 == 0) {
            if ((i & 3072) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
            i4 = i2 & 16;
            if (i4 != 0) {
                if ((i & 24576) == 0) {
                    z2 = z;
                    if (composerStartRestartGroup.changed(z2)) {
                        i5 = 16384;
                    } else {
                        i5 = 8192;
                    }
                    i3 |= i5;
                }
                i6 = i2 & 32;
                if (i6 != 0) {
                    if ((196608 & i) == 0) {
                        function3 = function0;
                        if (composerStartRestartGroup.changedInstance(function3)) {
                            i7 = 131072;
                        } else {
                            i7 = 65536;
                        }
                        i3 |= i7;
                    }
                    i8 = i2 & 64;
                    if (i8 != 0) {
                        if ((1572864 & i) == 0) {
                            function4 = function1;
                            if (composerStartRestartGroup.changedInstance(function4)) {
                                i9 = 1048576;
                            } else {
                                i9 = 524288;
                            }
                            i3 |= i9;
                        }
                        i10 = i2 & 128;
                        if (i10 != 0) {
                            if ((i & 12582912) == 0) {
                                if (composerStartRestartGroup.changedInstance(function2)) {
                                    i11 = 8388608;
                                } else {
                                    i11 = 4194304;
                                }
                                i3 |= i11;
                            }
                            if ((i3 & 4793491) != 4793490) {
                                z3 = true;
                            } else {
                                z3 = false;
                            }
                            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                                composerStartRestartGroup.skipToGroupEnd();
                                function5 = function2;
                                modifier3 = modifier2;
                                z4 = z2;
                                function6 = function3;
                                function7 = function4;
                            } else {
                                if (i12 != 0) {
                                    modifier2 = Modifier.INSTANCE;
                                }
                                if (i4 != 0) {
                                    z5 = false;
                                } else {
                                    z5 = z2;
                                }
                                if (i6 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242259229, "CC(remember):NotesListScreen.kt#9igjgp");
                                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue3 = new Function0() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda3
                                            @Override // kotlin.jvm.functions.Function0
                                            public final Object invoke() {
                                                return Unit.INSTANCE;
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    function8 = (Function0) objRememberedValue3;
                                } else {
                                    function8 = function3;
                                }
                                if (i8 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242260733, "CC(remember):NotesListScreen.kt#9igjgp");
                                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue2 = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda4
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj) {
                                                return NotesListScreenKt.NotesListScreen$lambda$10$0((ItemId.Remote) obj);
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                    }
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                    function4 = (Function1) objRememberedValue2;
                                }
                                if (i10 != 0) {
                                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242262397, "CC(remember):NotesListScreen.kt#9igjgp");
                                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                        objRememberedValue = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda5
                                            @Override // kotlin.jvm.functions.Function1
                                            public final Object invoke(Object obj) {
                                                return NotesListScreenKt.NotesListScreen$lambda$11$0((ItemId.Remote) obj);
                                            }
                                        };
                                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                    }
                                    function9 = (Function1) objRememberedValue;
                                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                } else {
                                    function9 = function2;
                                }
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventStart(-266863461, i3, -1, "com.box.android.notes.presentation.ui.NotesListScreen (NotesListScreen.kt:189)");
                                }
                                PullToRefreshState pullToRefreshStateRememberPullToRefreshState = PullToRefreshKt.rememberPullToRefreshState(composerStartRestartGroup, 0);
                                Modifier modifierM5119pullToRefreshZ4HSEVQ$default = PullToRefreshKt.m5119pullToRefreshZ4HSEVQ$default(SizeKt.fillMaxHeight$default(modifier2, 0.0f, 1, null), z5, pullToRefreshStateRememberPullToRefreshState, false, 0.0f, function8, 12, null);
                                boolean z6 = z5;
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                                CompositionLocalMap currentCompositionLocalMap = composerStartRestartGroup.getCurrentCompositionLocalMap();
                                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM5119pullToRefreshZ4HSEVQ$default);
                                constructor = ComposeUiNode.INSTANCE.getConstructor();
                                function10 = function9;
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
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 327999752, "C218@8669L6,219@8722L6,214@8479L277:NotesListScreen.kt#a1bbf8");
                                if (list.isEmpty()) {
                                    composerStartRestartGroup.startReplaceGroup(328007594);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "201@8097L127");
                                    EmptyItemsWithPullToRefreshWorkaroundKt.EmptyItemsList(itemsStateConfig, null, true, composerStartRestartGroup, ((i3 >> 3) & 14) | 384, 2);
                                    composerStartRestartGroup.endReplaceGroup();
                                    function11 = function4;
                                    function12 = function10;
                                } else {
                                    composerStartRestartGroup.startReplaceGroup(328165756);
                                    ComposerKt.sourceInformation(composerStartRestartGroup, "206@8254L205");
                                    int i13 = i3 >> 12;
                                    Function1<? super ItemId.Remote, Unit> function13 = function4;
                                    NotesList(list, lazyListState2, function13, function10, composerStartRestartGroup, (i3 & 14) | ((i3 >> 3) & 112) | (i13 & 896) | (i13 & 7168));
                                    function11 = function13;
                                    function12 = function10;
                                    composerStartRestartGroup.endReplaceGroup();
                                }
                                PullToRefreshDefaults.INSTANCE.m5106Indicator2poqoh4(pullToRefreshStateRememberPullToRefreshState, z6, boxScopeInstance.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopCenter()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11542getPopupBackground0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), 0.0f, composerStartRestartGroup, ((i3 >> 9) & 112) | (PullToRefreshDefaults.$stable << 18), 32);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                composerStartRestartGroup.endNode();
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                if (ComposerKt.isTraceInProgress()) {
                                    ComposerKt.traceEventEnd();
                                }
                                function5 = function12;
                                modifier3 = modifier2;
                                z4 = z6;
                                function6 = function8;
                                function7 = function11;
                            }
                            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                            if (scopeUpdateScopeEndRestartGroup != null) {
                                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda6
                                    @Override // kotlin.jvm.functions.Function2
                                    public final Object invoke(Object obj, Object obj2) {
                                        return NotesListScreenKt.NotesListScreen$lambda$13(list, itemsStateConfig, lazyListState, modifier3, z4, function6, function7, function5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                    }
                                });
                            }
                        }
                        i3 |= 12582912;
                        if ((i3 & 4793491) != 4793490) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                            composerStartRestartGroup.skipToGroupEnd();
                            function5 = function2;
                            modifier3 = modifier2;
                            z4 = z2;
                            function6 = function3;
                            function7 = function4;
                        } else {
                            if (i12 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z5 = false;
                            } else {
                                z5 = z2;
                            }
                            if (i6 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242259229, "CC(remember):NotesListScreen.kt#9igjgp");
                                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue3 = new Function0() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda3
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                function8 = (Function0) objRememberedValue3;
                            } else {
                                function8 = function3;
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242260733, "CC(remember):NotesListScreen.kt#9igjgp");
                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue2 = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda4
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return NotesListScreenKt.NotesListScreen$lambda$10$0((ItemId.Remote) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                function4 = (Function1) objRememberedValue2;
                            }
                            if (i10 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242262397, "CC(remember):NotesListScreen.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda5
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return NotesListScreenKt.NotesListScreen$lambda$11$0((ItemId.Remote) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                function9 = (Function1) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                function9 = function2;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-266863461, i3, -1, "com.box.android.notes.presentation.ui.NotesListScreen (NotesListScreen.kt:189)");
                            }
                            PullToRefreshState pullToRefreshStateRememberPullToRefreshState2 = PullToRefreshKt.rememberPullToRefreshState(composerStartRestartGroup, 0);
                            Modifier modifierM5119pullToRefreshZ4HSEVQ$default2 = PullToRefreshKt.m5119pullToRefreshZ4HSEVQ$default(SizeKt.fillMaxHeight$default(modifier2, 0.0f, 1, null), z5, pullToRefreshStateRememberPullToRefreshState2, false, 0.0f, function8, 12, null);
                            boolean z7 = z5;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy2 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int iHashCode2 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                            CompositionLocalMap currentCompositionLocalMap2 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier2 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM5119pullToRefreshZ4HSEVQ$default2);
                            constructor = ComposeUiNode.INSTANCE.getConstructor();
                            function10 = function9;
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
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 327999752, "C218@8669L6,219@8722L6,214@8479L277:NotesListScreen.kt#a1bbf8");
                            if (list.isEmpty()) {
                                composerStartRestartGroup.startReplaceGroup(328007594);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "201@8097L127");
                                EmptyItemsWithPullToRefreshWorkaroundKt.EmptyItemsList(itemsStateConfig, null, true, composerStartRestartGroup, ((i3 >> 3) & 14) | 384, 2);
                                composerStartRestartGroup.endReplaceGroup();
                                function11 = function4;
                                function12 = function10;
                            } else {
                                composerStartRestartGroup.startReplaceGroup(328165756);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "206@8254L205");
                                int i14 = i3 >> 12;
                                Function1<? super ItemId.Remote, Unit> function14 = function4;
                                NotesList(list, lazyListState2, function14, function10, composerStartRestartGroup, (i3 & 14) | ((i3 >> 3) & 112) | (i14 & 896) | (i14 & 7168));
                                function11 = function14;
                                function12 = function10;
                                composerStartRestartGroup.endReplaceGroup();
                            }
                            PullToRefreshDefaults.INSTANCE.m5106Indicator2poqoh4(pullToRefreshStateRememberPullToRefreshState2, z7, boxScopeInstance2.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopCenter()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11542getPopupBackground0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), 0.0f, composerStartRestartGroup, ((i3 >> 9) & 112) | (PullToRefreshDefaults.$stable << 18), 32);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            function5 = function12;
                            modifier3 = modifier2;
                            z4 = z7;
                            function6 = function8;
                            function7 = function11;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return NotesListScreenKt.NotesListScreen$lambda$13(list, itemsStateConfig, lazyListState, modifier3, z4, function6, function7, function5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 1572864;
                    function4 = function1;
                    i10 = i2 & 128;
                    if (i10 != 0) {
                        if ((i & 12582912) == 0) {
                            if (composerStartRestartGroup.changedInstance(function2)) {
                                i11 = 8388608;
                            } else {
                                i11 = 4194304;
                            }
                            i3 |= i11;
                        }
                        if ((i3 & 4793491) != 4793490) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                            composerStartRestartGroup.skipToGroupEnd();
                            function5 = function2;
                            modifier3 = modifier2;
                            z4 = z2;
                            function6 = function3;
                            function7 = function4;
                        } else {
                            if (i12 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z5 = false;
                            } else {
                                z5 = z2;
                            }
                            if (i6 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242259229, "CC(remember):NotesListScreen.kt#9igjgp");
                                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue3 = new Function0() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda3
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                function8 = (Function0) objRememberedValue3;
                            } else {
                                function8 = function3;
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242260733, "CC(remember):NotesListScreen.kt#9igjgp");
                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue2 = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda4
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return NotesListScreenKt.NotesListScreen$lambda$10$0((ItemId.Remote) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                function4 = (Function1) objRememberedValue2;
                            }
                            if (i10 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242262397, "CC(remember):NotesListScreen.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda5
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return NotesListScreenKt.NotesListScreen$lambda$11$0((ItemId.Remote) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                function9 = (Function1) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                function9 = function2;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-266863461, i3, -1, "com.box.android.notes.presentation.ui.NotesListScreen (NotesListScreen.kt:189)");
                            }
                            PullToRefreshState pullToRefreshStateRememberPullToRefreshState3 = PullToRefreshKt.rememberPullToRefreshState(composerStartRestartGroup, 0);
                            Modifier modifierM5119pullToRefreshZ4HSEVQ$default3 = PullToRefreshKt.m5119pullToRefreshZ4HSEVQ$default(SizeKt.fillMaxHeight$default(modifier2, 0.0f, 1, null), z5, pullToRefreshStateRememberPullToRefreshState3, false, 0.0f, function8, 12, null);
                            boolean z8 = z5;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy3 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int iHashCode3 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                            CompositionLocalMap currentCompositionLocalMap3 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier3 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM5119pullToRefreshZ4HSEVQ$default3);
                            constructor = ComposeUiNode.INSTANCE.getConstructor();
                            function10 = function9;
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
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 327999752, "C218@8669L6,219@8722L6,214@8479L277:NotesListScreen.kt#a1bbf8");
                            if (list.isEmpty()) {
                                composerStartRestartGroup.startReplaceGroup(328007594);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "201@8097L127");
                                EmptyItemsWithPullToRefreshWorkaroundKt.EmptyItemsList(itemsStateConfig, null, true, composerStartRestartGroup, ((i3 >> 3) & 14) | 384, 2);
                                composerStartRestartGroup.endReplaceGroup();
                                function11 = function4;
                                function12 = function10;
                            } else {
                                composerStartRestartGroup.startReplaceGroup(328165756);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "206@8254L205");
                                int i15 = i3 >> 12;
                                Function1<? super ItemId.Remote, Unit> function15 = function4;
                                NotesList(list, lazyListState2, function15, function10, composerStartRestartGroup, (i3 & 14) | ((i3 >> 3) & 112) | (i15 & 896) | (i15 & 7168));
                                function11 = function15;
                                function12 = function10;
                                composerStartRestartGroup.endReplaceGroup();
                            }
                            PullToRefreshDefaults.INSTANCE.m5106Indicator2poqoh4(pullToRefreshStateRememberPullToRefreshState3, z8, boxScopeInstance3.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopCenter()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11542getPopupBackground0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), 0.0f, composerStartRestartGroup, ((i3 >> 9) & 112) | (PullToRefreshDefaults.$stable << 18), 32);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            function5 = function12;
                            modifier3 = modifier2;
                            z4 = z8;
                            function6 = function8;
                            function7 = function11;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return NotesListScreenKt.NotesListScreen$lambda$13(list, itemsStateConfig, lazyListState, modifier3, z4, function6, function7, function5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 12582912;
                    if ((i3 & 4793491) != 4793490) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        function5 = function2;
                        modifier3 = modifier2;
                        z4 = z2;
                        function6 = function3;
                        function7 = function4;
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z5 = false;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242259229, "CC(remember):NotesListScreen.kt#9igjgp");
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue3 = new Function0() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Unit.INSTANCE;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            function8 = (Function0) objRememberedValue3;
                        } else {
                            function8 = function3;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242260733, "CC(remember):NotesListScreen.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda4
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return NotesListScreenKt.NotesListScreen$lambda$10$0((ItemId.Remote) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            function4 = (Function1) objRememberedValue2;
                        }
                        if (i10 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242262397, "CC(remember):NotesListScreen.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda5
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return NotesListScreenKt.NotesListScreen$lambda$11$0((ItemId.Remote) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            function9 = (Function1) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function9 = function2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-266863461, i3, -1, "com.box.android.notes.presentation.ui.NotesListScreen (NotesListScreen.kt:189)");
                        }
                        PullToRefreshState pullToRefreshStateRememberPullToRefreshState4 = PullToRefreshKt.rememberPullToRefreshState(composerStartRestartGroup, 0);
                        Modifier modifierM5119pullToRefreshZ4HSEVQ$default4 = PullToRefreshKt.m5119pullToRefreshZ4HSEVQ$default(SizeKt.fillMaxHeight$default(modifier2, 0.0f, 1, null), z5, pullToRefreshStateRememberPullToRefreshState4, false, 0.0f, function8, 12, null);
                        boolean z9 = z5;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy4 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode4 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap4 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier4 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM5119pullToRefreshZ4HSEVQ$default4);
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        function10 = function9;
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
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 327999752, "C218@8669L6,219@8722L6,214@8479L277:NotesListScreen.kt#a1bbf8");
                        if (list.isEmpty()) {
                            composerStartRestartGroup.startReplaceGroup(328007594);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "201@8097L127");
                            EmptyItemsWithPullToRefreshWorkaroundKt.EmptyItemsList(itemsStateConfig, null, true, composerStartRestartGroup, ((i3 >> 3) & 14) | 384, 2);
                            composerStartRestartGroup.endReplaceGroup();
                            function11 = function4;
                            function12 = function10;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(328165756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "206@8254L205");
                            int i16 = i3 >> 12;
                            Function1<? super ItemId.Remote, Unit> function16 = function4;
                            NotesList(list, lazyListState2, function16, function10, composerStartRestartGroup, (i3 & 14) | ((i3 >> 3) & 112) | (i16 & 896) | (i16 & 7168));
                            function11 = function16;
                            function12 = function10;
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        PullToRefreshDefaults.INSTANCE.m5106Indicator2poqoh4(pullToRefreshStateRememberPullToRefreshState4, z9, boxScopeInstance4.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopCenter()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11542getPopupBackground0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), 0.0f, composerStartRestartGroup, ((i3 >> 9) & 112) | (PullToRefreshDefaults.$stable << 18), 32);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function5 = function12;
                        modifier3 = modifier2;
                        z4 = z9;
                        function6 = function8;
                        function7 = function11;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NotesListScreenKt.NotesListScreen$lambda$13(list, itemsStateConfig, lazyListState, modifier3, z4, function6, function7, function5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
                function3 = function0;
                i8 = i2 & 64;
                if (i8 != 0) {
                    if ((1572864 & i) == 0) {
                        function4 = function1;
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                    i10 = i2 & 128;
                    if (i10 != 0) {
                        if ((i & 12582912) == 0) {
                            if (composerStartRestartGroup.changedInstance(function2)) {
                                i11 = 8388608;
                            } else {
                                i11 = 4194304;
                            }
                            i3 |= i11;
                        }
                        if ((i3 & 4793491) != 4793490) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                            composerStartRestartGroup.skipToGroupEnd();
                            function5 = function2;
                            modifier3 = modifier2;
                            z4 = z2;
                            function6 = function3;
                            function7 = function4;
                        } else {
                            if (i12 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z5 = false;
                            } else {
                                z5 = z2;
                            }
                            if (i6 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242259229, "CC(remember):NotesListScreen.kt#9igjgp");
                                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue3 = new Function0() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda3
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                function8 = (Function0) objRememberedValue3;
                            } else {
                                function8 = function3;
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242260733, "CC(remember):NotesListScreen.kt#9igjgp");
                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue2 = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda4
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return NotesListScreenKt.NotesListScreen$lambda$10$0((ItemId.Remote) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                function4 = (Function1) objRememberedValue2;
                            }
                            if (i10 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242262397, "CC(remember):NotesListScreen.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda5
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return NotesListScreenKt.NotesListScreen$lambda$11$0((ItemId.Remote) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                function9 = (Function1) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                function9 = function2;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-266863461, i3, -1, "com.box.android.notes.presentation.ui.NotesListScreen (NotesListScreen.kt:189)");
                            }
                            PullToRefreshState pullToRefreshStateRememberPullToRefreshState5 = PullToRefreshKt.rememberPullToRefreshState(composerStartRestartGroup, 0);
                            Modifier modifierM5119pullToRefreshZ4HSEVQ$default5 = PullToRefreshKt.m5119pullToRefreshZ4HSEVQ$default(SizeKt.fillMaxHeight$default(modifier2, 0.0f, 1, null), z5, pullToRefreshStateRememberPullToRefreshState5, false, 0.0f, function8, 12, null);
                            boolean z10 = z5;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy5 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int iHashCode5 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                            CompositionLocalMap currentCompositionLocalMap5 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier5 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM5119pullToRefreshZ4HSEVQ$default5);
                            constructor = ComposeUiNode.INSTANCE.getConstructor();
                            function10 = function9;
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
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 327999752, "C218@8669L6,219@8722L6,214@8479L277:NotesListScreen.kt#a1bbf8");
                            if (list.isEmpty()) {
                                composerStartRestartGroup.startReplaceGroup(328007594);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "201@8097L127");
                                EmptyItemsWithPullToRefreshWorkaroundKt.EmptyItemsList(itemsStateConfig, null, true, composerStartRestartGroup, ((i3 >> 3) & 14) | 384, 2);
                                composerStartRestartGroup.endReplaceGroup();
                                function11 = function4;
                                function12 = function10;
                            } else {
                                composerStartRestartGroup.startReplaceGroup(328165756);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "206@8254L205");
                                int i17 = i3 >> 12;
                                Function1<? super ItemId.Remote, Unit> function17 = function4;
                                NotesList(list, lazyListState2, function17, function10, composerStartRestartGroup, (i3 & 14) | ((i3 >> 3) & 112) | (i17 & 896) | (i17 & 7168));
                                function11 = function17;
                                function12 = function10;
                                composerStartRestartGroup.endReplaceGroup();
                            }
                            PullToRefreshDefaults.INSTANCE.m5106Indicator2poqoh4(pullToRefreshStateRememberPullToRefreshState5, z10, boxScopeInstance5.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopCenter()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11542getPopupBackground0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), 0.0f, composerStartRestartGroup, ((i3 >> 9) & 112) | (PullToRefreshDefaults.$stable << 18), 32);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            function5 = function12;
                            modifier3 = modifier2;
                            z4 = z10;
                            function6 = function8;
                            function7 = function11;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return NotesListScreenKt.NotesListScreen$lambda$13(list, itemsStateConfig, lazyListState, modifier3, z4, function6, function7, function5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 12582912;
                    if ((i3 & 4793491) != 4793490) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        function5 = function2;
                        modifier3 = modifier2;
                        z4 = z2;
                        function6 = function3;
                        function7 = function4;
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z5 = false;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242259229, "CC(remember):NotesListScreen.kt#9igjgp");
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue3 = new Function0() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Unit.INSTANCE;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            function8 = (Function0) objRememberedValue3;
                        } else {
                            function8 = function3;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242260733, "CC(remember):NotesListScreen.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda4
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return NotesListScreenKt.NotesListScreen$lambda$10$0((ItemId.Remote) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            function4 = (Function1) objRememberedValue2;
                        }
                        if (i10 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242262397, "CC(remember):NotesListScreen.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda5
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return NotesListScreenKt.NotesListScreen$lambda$11$0((ItemId.Remote) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            function9 = (Function1) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function9 = function2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-266863461, i3, -1, "com.box.android.notes.presentation.ui.NotesListScreen (NotesListScreen.kt:189)");
                        }
                        PullToRefreshState pullToRefreshStateRememberPullToRefreshState6 = PullToRefreshKt.rememberPullToRefreshState(composerStartRestartGroup, 0);
                        Modifier modifierM5119pullToRefreshZ4HSEVQ$default6 = PullToRefreshKt.m5119pullToRefreshZ4HSEVQ$default(SizeKt.fillMaxHeight$default(modifier2, 0.0f, 1, null), z5, pullToRefreshStateRememberPullToRefreshState6, false, 0.0f, function8, 12, null);
                        boolean z11 = z5;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy6 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode6 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap6 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier6 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM5119pullToRefreshZ4HSEVQ$default6);
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        function10 = function9;
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
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 327999752, "C218@8669L6,219@8722L6,214@8479L277:NotesListScreen.kt#a1bbf8");
                        if (list.isEmpty()) {
                            composerStartRestartGroup.startReplaceGroup(328007594);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "201@8097L127");
                            EmptyItemsWithPullToRefreshWorkaroundKt.EmptyItemsList(itemsStateConfig, null, true, composerStartRestartGroup, ((i3 >> 3) & 14) | 384, 2);
                            composerStartRestartGroup.endReplaceGroup();
                            function11 = function4;
                            function12 = function10;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(328165756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "206@8254L205");
                            int i18 = i3 >> 12;
                            Function1<? super ItemId.Remote, Unit> function18 = function4;
                            NotesList(list, lazyListState2, function18, function10, composerStartRestartGroup, (i3 & 14) | ((i3 >> 3) & 112) | (i18 & 896) | (i18 & 7168));
                            function11 = function18;
                            function12 = function10;
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        PullToRefreshDefaults.INSTANCE.m5106Indicator2poqoh4(pullToRefreshStateRememberPullToRefreshState6, z11, boxScopeInstance6.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopCenter()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11542getPopupBackground0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), 0.0f, composerStartRestartGroup, ((i3 >> 9) & 112) | (PullToRefreshDefaults.$stable << 18), 32);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function5 = function12;
                        modifier3 = modifier2;
                        z4 = z11;
                        function6 = function8;
                        function7 = function11;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NotesListScreenKt.NotesListScreen$lambda$13(list, itemsStateConfig, lazyListState, modifier3, z4, function6, function7, function5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 1572864;
                function4 = function1;
                i10 = i2 & 128;
                if (i10 != 0) {
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i11 = 8388608;
                        } else {
                            i11 = 4194304;
                        }
                        i3 |= i11;
                    }
                    if ((i3 & 4793491) != 4793490) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        function5 = function2;
                        modifier3 = modifier2;
                        z4 = z2;
                        function6 = function3;
                        function7 = function4;
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z5 = false;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242259229, "CC(remember):NotesListScreen.kt#9igjgp");
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue3 = new Function0() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Unit.INSTANCE;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            function8 = (Function0) objRememberedValue3;
                        } else {
                            function8 = function3;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242260733, "CC(remember):NotesListScreen.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda4
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return NotesListScreenKt.NotesListScreen$lambda$10$0((ItemId.Remote) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            function4 = (Function1) objRememberedValue2;
                        }
                        if (i10 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242262397, "CC(remember):NotesListScreen.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda5
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return NotesListScreenKt.NotesListScreen$lambda$11$0((ItemId.Remote) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            function9 = (Function1) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function9 = function2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-266863461, i3, -1, "com.box.android.notes.presentation.ui.NotesListScreen (NotesListScreen.kt:189)");
                        }
                        PullToRefreshState pullToRefreshStateRememberPullToRefreshState7 = PullToRefreshKt.rememberPullToRefreshState(composerStartRestartGroup, 0);
                        Modifier modifierM5119pullToRefreshZ4HSEVQ$default7 = PullToRefreshKt.m5119pullToRefreshZ4HSEVQ$default(SizeKt.fillMaxHeight$default(modifier2, 0.0f, 1, null), z5, pullToRefreshStateRememberPullToRefreshState7, false, 0.0f, function8, 12, null);
                        boolean z12 = z5;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy7 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode7 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap7 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier7 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM5119pullToRefreshZ4HSEVQ$default7);
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        function10 = function9;
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
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 327999752, "C218@8669L6,219@8722L6,214@8479L277:NotesListScreen.kt#a1bbf8");
                        if (list.isEmpty()) {
                            composerStartRestartGroup.startReplaceGroup(328007594);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "201@8097L127");
                            EmptyItemsWithPullToRefreshWorkaroundKt.EmptyItemsList(itemsStateConfig, null, true, composerStartRestartGroup, ((i3 >> 3) & 14) | 384, 2);
                            composerStartRestartGroup.endReplaceGroup();
                            function11 = function4;
                            function12 = function10;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(328165756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "206@8254L205");
                            int i19 = i3 >> 12;
                            Function1<? super ItemId.Remote, Unit> function19 = function4;
                            NotesList(list, lazyListState2, function19, function10, composerStartRestartGroup, (i3 & 14) | ((i3 >> 3) & 112) | (i19 & 896) | (i19 & 7168));
                            function11 = function19;
                            function12 = function10;
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        PullToRefreshDefaults.INSTANCE.m5106Indicator2poqoh4(pullToRefreshStateRememberPullToRefreshState7, z12, boxScopeInstance7.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopCenter()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11542getPopupBackground0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), 0.0f, composerStartRestartGroup, ((i3 >> 9) & 112) | (PullToRefreshDefaults.$stable << 18), 32);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function5 = function12;
                        modifier3 = modifier2;
                        z4 = z12;
                        function6 = function8;
                        function7 = function11;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NotesListScreenKt.NotesListScreen$lambda$13(list, itemsStateConfig, lazyListState, modifier3, z4, function6, function7, function5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 12582912;
                if ((i3 & 4793491) != 4793490) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    function5 = function2;
                    modifier3 = modifier2;
                    z4 = z2;
                    function6 = function3;
                    function7 = function4;
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242259229, "CC(remember):NotesListScreen.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new Function0() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function8 = (Function0) objRememberedValue3;
                    } else {
                        function8 = function3;
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242260733, "CC(remember):NotesListScreen.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return NotesListScreenKt.NotesListScreen$lambda$10$0((ItemId.Remote) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function4 = (Function1) objRememberedValue2;
                    }
                    if (i10 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242262397, "CC(remember):NotesListScreen.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return NotesListScreenKt.NotesListScreen$lambda$11$0((ItemId.Remote) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        function9 = (Function1) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function9 = function2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-266863461, i3, -1, "com.box.android.notes.presentation.ui.NotesListScreen (NotesListScreen.kt:189)");
                    }
                    PullToRefreshState pullToRefreshStateRememberPullToRefreshState8 = PullToRefreshKt.rememberPullToRefreshState(composerStartRestartGroup, 0);
                    Modifier modifierM5119pullToRefreshZ4HSEVQ$default8 = PullToRefreshKt.m5119pullToRefreshZ4HSEVQ$default(SizeKt.fillMaxHeight$default(modifier2, 0.0f, 1, null), z5, pullToRefreshStateRememberPullToRefreshState8, false, 0.0f, function8, 12, null);
                    boolean z13 = z5;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy8 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode8 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap8 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier8 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM5119pullToRefreshZ4HSEVQ$default8);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    function10 = function9;
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
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 327999752, "C218@8669L6,219@8722L6,214@8479L277:NotesListScreen.kt#a1bbf8");
                    if (list.isEmpty()) {
                        composerStartRestartGroup.startReplaceGroup(328007594);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "201@8097L127");
                        EmptyItemsWithPullToRefreshWorkaroundKt.EmptyItemsList(itemsStateConfig, null, true, composerStartRestartGroup, ((i3 >> 3) & 14) | 384, 2);
                        composerStartRestartGroup.endReplaceGroup();
                        function11 = function4;
                        function12 = function10;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(328165756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "206@8254L205");
                        int i110 = i3 >> 12;
                        Function1<? super ItemId.Remote, Unit> function110 = function4;
                        NotesList(list, lazyListState2, function110, function10, composerStartRestartGroup, (i3 & 14) | ((i3 >> 3) & 112) | (i110 & 896) | (i110 & 7168));
                        function11 = function110;
                        function12 = function10;
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    PullToRefreshDefaults.INSTANCE.m5106Indicator2poqoh4(pullToRefreshStateRememberPullToRefreshState8, z13, boxScopeInstance8.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopCenter()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11542getPopupBackground0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), 0.0f, composerStartRestartGroup, ((i3 >> 9) & 112) | (PullToRefreshDefaults.$stable << 18), 32);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function5 = function12;
                    modifier3 = modifier2;
                    z4 = z13;
                    function6 = function8;
                    function7 = function11;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NotesListScreenKt.NotesListScreen$lambda$13(list, itemsStateConfig, lazyListState, modifier3, z4, function6, function7, function5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 24576;
            z2 = z;
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((196608 & i) == 0) {
                    function3 = function0;
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    if ((1572864 & i) == 0) {
                        function4 = function1;
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                    i10 = i2 & 128;
                    if (i10 != 0) {
                        if ((i & 12582912) == 0) {
                            if (composerStartRestartGroup.changedInstance(function2)) {
                                i11 = 8388608;
                            } else {
                                i11 = 4194304;
                            }
                            i3 |= i11;
                        }
                        if ((i3 & 4793491) != 4793490) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                            composerStartRestartGroup.skipToGroupEnd();
                            function5 = function2;
                            modifier3 = modifier2;
                            z4 = z2;
                            function6 = function3;
                            function7 = function4;
                        } else {
                            if (i12 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z5 = false;
                            } else {
                                z5 = z2;
                            }
                            if (i6 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242259229, "CC(remember):NotesListScreen.kt#9igjgp");
                                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue3 = new Function0() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda3
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                function8 = (Function0) objRememberedValue3;
                            } else {
                                function8 = function3;
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242260733, "CC(remember):NotesListScreen.kt#9igjgp");
                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue2 = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda4
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return NotesListScreenKt.NotesListScreen$lambda$10$0((ItemId.Remote) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                function4 = (Function1) objRememberedValue2;
                            }
                            if (i10 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242262397, "CC(remember):NotesListScreen.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda5
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return NotesListScreenKt.NotesListScreen$lambda$11$0((ItemId.Remote) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                function9 = (Function1) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                function9 = function2;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-266863461, i3, -1, "com.box.android.notes.presentation.ui.NotesListScreen (NotesListScreen.kt:189)");
                            }
                            PullToRefreshState pullToRefreshStateRememberPullToRefreshState9 = PullToRefreshKt.rememberPullToRefreshState(composerStartRestartGroup, 0);
                            Modifier modifierM5119pullToRefreshZ4HSEVQ$default9 = PullToRefreshKt.m5119pullToRefreshZ4HSEVQ$default(SizeKt.fillMaxHeight$default(modifier2, 0.0f, 1, null), z5, pullToRefreshStateRememberPullToRefreshState9, false, 0.0f, function8, 12, null);
                            boolean z14 = z5;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy9 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int iHashCode9 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                            CompositionLocalMap currentCompositionLocalMap9 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier9 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM5119pullToRefreshZ4HSEVQ$default9);
                            constructor = ComposeUiNode.INSTANCE.getConstructor();
                            function10 = function9;
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
                            Composer composerM6062constructorimpl9 = Updater.m6062constructorimpl(composerStartRestartGroup);
                            Updater.m6070setimpl(composerM6062constructorimpl9, measurePolicyMaybeCachedBoxMeasurePolicy9, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m6070setimpl(composerM6062constructorimpl9, currentCompositionLocalMap9, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Updater.m6066initimpl(composerM6062constructorimpl9, Integer.valueOf(iHashCode9), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                            Updater.m6068reconcileimpl(composerM6062constructorimpl9, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                            Updater.m6070setimpl(composerM6062constructorimpl9, modifierMaterializeModifier9, ComposeUiNode.INSTANCE.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance9 = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 327999752, "C218@8669L6,219@8722L6,214@8479L277:NotesListScreen.kt#a1bbf8");
                            if (list.isEmpty()) {
                                composerStartRestartGroup.startReplaceGroup(328007594);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "201@8097L127");
                                EmptyItemsWithPullToRefreshWorkaroundKt.EmptyItemsList(itemsStateConfig, null, true, composerStartRestartGroup, ((i3 >> 3) & 14) | 384, 2);
                                composerStartRestartGroup.endReplaceGroup();
                                function11 = function4;
                                function12 = function10;
                            } else {
                                composerStartRestartGroup.startReplaceGroup(328165756);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "206@8254L205");
                                int i111 = i3 >> 12;
                                Function1<? super ItemId.Remote, Unit> function111 = function4;
                                NotesList(list, lazyListState2, function111, function10, composerStartRestartGroup, (i3 & 14) | ((i3 >> 3) & 112) | (i111 & 896) | (i111 & 7168));
                                function11 = function111;
                                function12 = function10;
                                composerStartRestartGroup.endReplaceGroup();
                            }
                            PullToRefreshDefaults.INSTANCE.m5106Indicator2poqoh4(pullToRefreshStateRememberPullToRefreshState9, z14, boxScopeInstance9.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopCenter()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11542getPopupBackground0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), 0.0f, composerStartRestartGroup, ((i3 >> 9) & 112) | (PullToRefreshDefaults.$stable << 18), 32);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            function5 = function12;
                            modifier3 = modifier2;
                            z4 = z14;
                            function6 = function8;
                            function7 = function11;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return NotesListScreenKt.NotesListScreen$lambda$13(list, itemsStateConfig, lazyListState, modifier3, z4, function6, function7, function5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 12582912;
                    if ((i3 & 4793491) != 4793490) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        function5 = function2;
                        modifier3 = modifier2;
                        z4 = z2;
                        function6 = function3;
                        function7 = function4;
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z5 = false;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242259229, "CC(remember):NotesListScreen.kt#9igjgp");
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue3 = new Function0() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Unit.INSTANCE;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            function8 = (Function0) objRememberedValue3;
                        } else {
                            function8 = function3;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242260733, "CC(remember):NotesListScreen.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda4
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return NotesListScreenKt.NotesListScreen$lambda$10$0((ItemId.Remote) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            function4 = (Function1) objRememberedValue2;
                        }
                        if (i10 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242262397, "CC(remember):NotesListScreen.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda5
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return NotesListScreenKt.NotesListScreen$lambda$11$0((ItemId.Remote) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            function9 = (Function1) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function9 = function2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-266863461, i3, -1, "com.box.android.notes.presentation.ui.NotesListScreen (NotesListScreen.kt:189)");
                        }
                        PullToRefreshState pullToRefreshStateRememberPullToRefreshState10 = PullToRefreshKt.rememberPullToRefreshState(composerStartRestartGroup, 0);
                        Modifier modifierM5119pullToRefreshZ4HSEVQ$default10 = PullToRefreshKt.m5119pullToRefreshZ4HSEVQ$default(SizeKt.fillMaxHeight$default(modifier2, 0.0f, 1, null), z5, pullToRefreshStateRememberPullToRefreshState10, false, 0.0f, function8, 12, null);
                        boolean z15 = z5;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy10 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode10 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap10 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier10 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM5119pullToRefreshZ4HSEVQ$default10);
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        function10 = function9;
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
                        Composer composerM6062constructorimpl10 = Updater.m6062constructorimpl(composerStartRestartGroup);
                        Updater.m6070setimpl(composerM6062constructorimpl10, measurePolicyMaybeCachedBoxMeasurePolicy10, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl10, currentCompositionLocalMap10, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl10, Integer.valueOf(iHashCode10), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl10, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl10, modifierMaterializeModifier10, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance10 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 327999752, "C218@8669L6,219@8722L6,214@8479L277:NotesListScreen.kt#a1bbf8");
                        if (list.isEmpty()) {
                            composerStartRestartGroup.startReplaceGroup(328007594);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "201@8097L127");
                            EmptyItemsWithPullToRefreshWorkaroundKt.EmptyItemsList(itemsStateConfig, null, true, composerStartRestartGroup, ((i3 >> 3) & 14) | 384, 2);
                            composerStartRestartGroup.endReplaceGroup();
                            function11 = function4;
                            function12 = function10;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(328165756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "206@8254L205");
                            int i112 = i3 >> 12;
                            Function1<? super ItemId.Remote, Unit> function112 = function4;
                            NotesList(list, lazyListState2, function112, function10, composerStartRestartGroup, (i3 & 14) | ((i3 >> 3) & 112) | (i112 & 896) | (i112 & 7168));
                            function11 = function112;
                            function12 = function10;
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        PullToRefreshDefaults.INSTANCE.m5106Indicator2poqoh4(pullToRefreshStateRememberPullToRefreshState10, z15, boxScopeInstance10.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopCenter()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11542getPopupBackground0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), 0.0f, composerStartRestartGroup, ((i3 >> 9) & 112) | (PullToRefreshDefaults.$stable << 18), 32);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function5 = function12;
                        modifier3 = modifier2;
                        z4 = z15;
                        function6 = function8;
                        function7 = function11;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NotesListScreenKt.NotesListScreen$lambda$13(list, itemsStateConfig, lazyListState, modifier3, z4, function6, function7, function5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 1572864;
                function4 = function1;
                i10 = i2 & 128;
                if (i10 != 0) {
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i11 = 8388608;
                        } else {
                            i11 = 4194304;
                        }
                        i3 |= i11;
                    }
                    if ((i3 & 4793491) != 4793490) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        function5 = function2;
                        modifier3 = modifier2;
                        z4 = z2;
                        function6 = function3;
                        function7 = function4;
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z5 = false;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242259229, "CC(remember):NotesListScreen.kt#9igjgp");
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue3 = new Function0() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Unit.INSTANCE;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            function8 = (Function0) objRememberedValue3;
                        } else {
                            function8 = function3;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242260733, "CC(remember):NotesListScreen.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda4
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return NotesListScreenKt.NotesListScreen$lambda$10$0((ItemId.Remote) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            function4 = (Function1) objRememberedValue2;
                        }
                        if (i10 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242262397, "CC(remember):NotesListScreen.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda5
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return NotesListScreenKt.NotesListScreen$lambda$11$0((ItemId.Remote) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            function9 = (Function1) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function9 = function2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-266863461, i3, -1, "com.box.android.notes.presentation.ui.NotesListScreen (NotesListScreen.kt:189)");
                        }
                        PullToRefreshState pullToRefreshStateRememberPullToRefreshState11 = PullToRefreshKt.rememberPullToRefreshState(composerStartRestartGroup, 0);
                        Modifier modifierM5119pullToRefreshZ4HSEVQ$default11 = PullToRefreshKt.m5119pullToRefreshZ4HSEVQ$default(SizeKt.fillMaxHeight$default(modifier2, 0.0f, 1, null), z5, pullToRefreshStateRememberPullToRefreshState11, false, 0.0f, function8, 12, null);
                        boolean z16 = z5;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy11 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode11 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap11 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier11 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM5119pullToRefreshZ4HSEVQ$default11);
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        function10 = function9;
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
                        Composer composerM6062constructorimpl11 = Updater.m6062constructorimpl(composerStartRestartGroup);
                        Updater.m6070setimpl(composerM6062constructorimpl11, measurePolicyMaybeCachedBoxMeasurePolicy11, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl11, currentCompositionLocalMap11, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl11, Integer.valueOf(iHashCode11), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl11, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl11, modifierMaterializeModifier11, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance11 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 327999752, "C218@8669L6,219@8722L6,214@8479L277:NotesListScreen.kt#a1bbf8");
                        if (list.isEmpty()) {
                            composerStartRestartGroup.startReplaceGroup(328007594);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "201@8097L127");
                            EmptyItemsWithPullToRefreshWorkaroundKt.EmptyItemsList(itemsStateConfig, null, true, composerStartRestartGroup, ((i3 >> 3) & 14) | 384, 2);
                            composerStartRestartGroup.endReplaceGroup();
                            function11 = function4;
                            function12 = function10;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(328165756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "206@8254L205");
                            int i113 = i3 >> 12;
                            Function1<? super ItemId.Remote, Unit> function113 = function4;
                            NotesList(list, lazyListState2, function113, function10, composerStartRestartGroup, (i3 & 14) | ((i3 >> 3) & 112) | (i113 & 896) | (i113 & 7168));
                            function11 = function113;
                            function12 = function10;
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        PullToRefreshDefaults.INSTANCE.m5106Indicator2poqoh4(pullToRefreshStateRememberPullToRefreshState11, z16, boxScopeInstance11.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopCenter()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11542getPopupBackground0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), 0.0f, composerStartRestartGroup, ((i3 >> 9) & 112) | (PullToRefreshDefaults.$stable << 18), 32);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function5 = function12;
                        modifier3 = modifier2;
                        z4 = z16;
                        function6 = function8;
                        function7 = function11;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NotesListScreenKt.NotesListScreen$lambda$13(list, itemsStateConfig, lazyListState, modifier3, z4, function6, function7, function5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 12582912;
                if ((i3 & 4793491) != 4793490) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    function5 = function2;
                    modifier3 = modifier2;
                    z4 = z2;
                    function6 = function3;
                    function7 = function4;
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242259229, "CC(remember):NotesListScreen.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new Function0() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function8 = (Function0) objRememberedValue3;
                    } else {
                        function8 = function3;
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242260733, "CC(remember):NotesListScreen.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return NotesListScreenKt.NotesListScreen$lambda$10$0((ItemId.Remote) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function4 = (Function1) objRememberedValue2;
                    }
                    if (i10 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242262397, "CC(remember):NotesListScreen.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return NotesListScreenKt.NotesListScreen$lambda$11$0((ItemId.Remote) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        function9 = (Function1) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function9 = function2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-266863461, i3, -1, "com.box.android.notes.presentation.ui.NotesListScreen (NotesListScreen.kt:189)");
                    }
                    PullToRefreshState pullToRefreshStateRememberPullToRefreshState12 = PullToRefreshKt.rememberPullToRefreshState(composerStartRestartGroup, 0);
                    Modifier modifierM5119pullToRefreshZ4HSEVQ$default12 = PullToRefreshKt.m5119pullToRefreshZ4HSEVQ$default(SizeKt.fillMaxHeight$default(modifier2, 0.0f, 1, null), z5, pullToRefreshStateRememberPullToRefreshState12, false, 0.0f, function8, 12, null);
                    boolean z17 = z5;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy12 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode12 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap12 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier12 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM5119pullToRefreshZ4HSEVQ$default12);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    function10 = function9;
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
                    Composer composerM6062constructorimpl12 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl12, measurePolicyMaybeCachedBoxMeasurePolicy12, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl12, currentCompositionLocalMap12, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl12, Integer.valueOf(iHashCode12), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl12, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl12, modifierMaterializeModifier12, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance12 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 327999752, "C218@8669L6,219@8722L6,214@8479L277:NotesListScreen.kt#a1bbf8");
                    if (list.isEmpty()) {
                        composerStartRestartGroup.startReplaceGroup(328007594);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "201@8097L127");
                        EmptyItemsWithPullToRefreshWorkaroundKt.EmptyItemsList(itemsStateConfig, null, true, composerStartRestartGroup, ((i3 >> 3) & 14) | 384, 2);
                        composerStartRestartGroup.endReplaceGroup();
                        function11 = function4;
                        function12 = function10;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(328165756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "206@8254L205");
                        int i114 = i3 >> 12;
                        Function1<? super ItemId.Remote, Unit> function114 = function4;
                        NotesList(list, lazyListState2, function114, function10, composerStartRestartGroup, (i3 & 14) | ((i3 >> 3) & 112) | (i114 & 896) | (i114 & 7168));
                        function11 = function114;
                        function12 = function10;
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    PullToRefreshDefaults.INSTANCE.m5106Indicator2poqoh4(pullToRefreshStateRememberPullToRefreshState12, z17, boxScopeInstance12.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopCenter()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11542getPopupBackground0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), 0.0f, composerStartRestartGroup, ((i3 >> 9) & 112) | (PullToRefreshDefaults.$stable << 18), 32);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function5 = function12;
                    modifier3 = modifier2;
                    z4 = z17;
                    function6 = function8;
                    function7 = function11;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NotesListScreenKt.NotesListScreen$lambda$13(list, itemsStateConfig, lazyListState, modifier3, z4, function6, function7, function5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function3 = function0;
            i8 = i2 & 64;
            if (i8 != 0) {
                if ((1572864 & i) == 0) {
                    function4 = function1;
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 128;
                if (i10 != 0) {
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i11 = 8388608;
                        } else {
                            i11 = 4194304;
                        }
                        i3 |= i11;
                    }
                    if ((i3 & 4793491) != 4793490) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        function5 = function2;
                        modifier3 = modifier2;
                        z4 = z2;
                        function6 = function3;
                        function7 = function4;
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z5 = false;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242259229, "CC(remember):NotesListScreen.kt#9igjgp");
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue3 = new Function0() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Unit.INSTANCE;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            function8 = (Function0) objRememberedValue3;
                        } else {
                            function8 = function3;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242260733, "CC(remember):NotesListScreen.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda4
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return NotesListScreenKt.NotesListScreen$lambda$10$0((ItemId.Remote) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            function4 = (Function1) objRememberedValue2;
                        }
                        if (i10 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242262397, "CC(remember):NotesListScreen.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda5
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return NotesListScreenKt.NotesListScreen$lambda$11$0((ItemId.Remote) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            function9 = (Function1) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function9 = function2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-266863461, i3, -1, "com.box.android.notes.presentation.ui.NotesListScreen (NotesListScreen.kt:189)");
                        }
                        PullToRefreshState pullToRefreshStateRememberPullToRefreshState13 = PullToRefreshKt.rememberPullToRefreshState(composerStartRestartGroup, 0);
                        Modifier modifierM5119pullToRefreshZ4HSEVQ$default13 = PullToRefreshKt.m5119pullToRefreshZ4HSEVQ$default(SizeKt.fillMaxHeight$default(modifier2, 0.0f, 1, null), z5, pullToRefreshStateRememberPullToRefreshState13, false, 0.0f, function8, 12, null);
                        boolean z18 = z5;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy13 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode13 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap13 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier13 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM5119pullToRefreshZ4HSEVQ$default13);
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        function10 = function9;
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
                        Composer composerM6062constructorimpl13 = Updater.m6062constructorimpl(composerStartRestartGroup);
                        Updater.m6070setimpl(composerM6062constructorimpl13, measurePolicyMaybeCachedBoxMeasurePolicy13, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl13, currentCompositionLocalMap13, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl13, Integer.valueOf(iHashCode13), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl13, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl13, modifierMaterializeModifier13, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance13 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 327999752, "C218@8669L6,219@8722L6,214@8479L277:NotesListScreen.kt#a1bbf8");
                        if (list.isEmpty()) {
                            composerStartRestartGroup.startReplaceGroup(328007594);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "201@8097L127");
                            EmptyItemsWithPullToRefreshWorkaroundKt.EmptyItemsList(itemsStateConfig, null, true, composerStartRestartGroup, ((i3 >> 3) & 14) | 384, 2);
                            composerStartRestartGroup.endReplaceGroup();
                            function11 = function4;
                            function12 = function10;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(328165756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "206@8254L205");
                            int i115 = i3 >> 12;
                            Function1<? super ItemId.Remote, Unit> function115 = function4;
                            NotesList(list, lazyListState2, function115, function10, composerStartRestartGroup, (i3 & 14) | ((i3 >> 3) & 112) | (i115 & 896) | (i115 & 7168));
                            function11 = function115;
                            function12 = function10;
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        PullToRefreshDefaults.INSTANCE.m5106Indicator2poqoh4(pullToRefreshStateRememberPullToRefreshState13, z18, boxScopeInstance13.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopCenter()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11542getPopupBackground0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), 0.0f, composerStartRestartGroup, ((i3 >> 9) & 112) | (PullToRefreshDefaults.$stable << 18), 32);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function5 = function12;
                        modifier3 = modifier2;
                        z4 = z18;
                        function6 = function8;
                        function7 = function11;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NotesListScreenKt.NotesListScreen$lambda$13(list, itemsStateConfig, lazyListState, modifier3, z4, function6, function7, function5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 12582912;
                if ((i3 & 4793491) != 4793490) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    function5 = function2;
                    modifier3 = modifier2;
                    z4 = z2;
                    function6 = function3;
                    function7 = function4;
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242259229, "CC(remember):NotesListScreen.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new Function0() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function8 = (Function0) objRememberedValue3;
                    } else {
                        function8 = function3;
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242260733, "CC(remember):NotesListScreen.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return NotesListScreenKt.NotesListScreen$lambda$10$0((ItemId.Remote) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function4 = (Function1) objRememberedValue2;
                    }
                    if (i10 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242262397, "CC(remember):NotesListScreen.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return NotesListScreenKt.NotesListScreen$lambda$11$0((ItemId.Remote) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        function9 = (Function1) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function9 = function2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-266863461, i3, -1, "com.box.android.notes.presentation.ui.NotesListScreen (NotesListScreen.kt:189)");
                    }
                    PullToRefreshState pullToRefreshStateRememberPullToRefreshState14 = PullToRefreshKt.rememberPullToRefreshState(composerStartRestartGroup, 0);
                    Modifier modifierM5119pullToRefreshZ4HSEVQ$default14 = PullToRefreshKt.m5119pullToRefreshZ4HSEVQ$default(SizeKt.fillMaxHeight$default(modifier2, 0.0f, 1, null), z5, pullToRefreshStateRememberPullToRefreshState14, false, 0.0f, function8, 12, null);
                    boolean z19 = z5;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy14 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode14 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap14 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier14 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM5119pullToRefreshZ4HSEVQ$default14);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    function10 = function9;
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
                    Composer composerM6062constructorimpl14 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl14, measurePolicyMaybeCachedBoxMeasurePolicy14, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl14, currentCompositionLocalMap14, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl14, Integer.valueOf(iHashCode14), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl14, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl14, modifierMaterializeModifier14, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance14 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 327999752, "C218@8669L6,219@8722L6,214@8479L277:NotesListScreen.kt#a1bbf8");
                    if (list.isEmpty()) {
                        composerStartRestartGroup.startReplaceGroup(328007594);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "201@8097L127");
                        EmptyItemsWithPullToRefreshWorkaroundKt.EmptyItemsList(itemsStateConfig, null, true, composerStartRestartGroup, ((i3 >> 3) & 14) | 384, 2);
                        composerStartRestartGroup.endReplaceGroup();
                        function11 = function4;
                        function12 = function10;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(328165756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "206@8254L205");
                        int i116 = i3 >> 12;
                        Function1<? super ItemId.Remote, Unit> function116 = function4;
                        NotesList(list, lazyListState2, function116, function10, composerStartRestartGroup, (i3 & 14) | ((i3 >> 3) & 112) | (i116 & 896) | (i116 & 7168));
                        function11 = function116;
                        function12 = function10;
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    PullToRefreshDefaults.INSTANCE.m5106Indicator2poqoh4(pullToRefreshStateRememberPullToRefreshState14, z19, boxScopeInstance14.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopCenter()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11542getPopupBackground0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), 0.0f, composerStartRestartGroup, ((i3 >> 9) & 112) | (PullToRefreshDefaults.$stable << 18), 32);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function5 = function12;
                    modifier3 = modifier2;
                    z4 = z19;
                    function6 = function8;
                    function7 = function11;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NotesListScreenKt.NotesListScreen$lambda$13(list, itemsStateConfig, lazyListState, modifier3, z4, function6, function7, function5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 1572864;
            function4 = function1;
            i10 = i2 & 128;
            if (i10 != 0) {
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i3 |= i11;
                }
                if ((i3 & 4793491) != 4793490) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    function5 = function2;
                    modifier3 = modifier2;
                    z4 = z2;
                    function6 = function3;
                    function7 = function4;
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242259229, "CC(remember):NotesListScreen.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new Function0() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function8 = (Function0) objRememberedValue3;
                    } else {
                        function8 = function3;
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242260733, "CC(remember):NotesListScreen.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return NotesListScreenKt.NotesListScreen$lambda$10$0((ItemId.Remote) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function4 = (Function1) objRememberedValue2;
                    }
                    if (i10 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242262397, "CC(remember):NotesListScreen.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return NotesListScreenKt.NotesListScreen$lambda$11$0((ItemId.Remote) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        function9 = (Function1) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function9 = function2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-266863461, i3, -1, "com.box.android.notes.presentation.ui.NotesListScreen (NotesListScreen.kt:189)");
                    }
                    PullToRefreshState pullToRefreshStateRememberPullToRefreshState15 = PullToRefreshKt.rememberPullToRefreshState(composerStartRestartGroup, 0);
                    Modifier modifierM5119pullToRefreshZ4HSEVQ$default15 = PullToRefreshKt.m5119pullToRefreshZ4HSEVQ$default(SizeKt.fillMaxHeight$default(modifier2, 0.0f, 1, null), z5, pullToRefreshStateRememberPullToRefreshState15, false, 0.0f, function8, 12, null);
                    boolean z110 = z5;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy15 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode15 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap15 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier15 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM5119pullToRefreshZ4HSEVQ$default15);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    function10 = function9;
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
                    Composer composerM6062constructorimpl15 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl15, measurePolicyMaybeCachedBoxMeasurePolicy15, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl15, currentCompositionLocalMap15, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl15, Integer.valueOf(iHashCode15), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl15, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl15, modifierMaterializeModifier15, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance15 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 327999752, "C218@8669L6,219@8722L6,214@8479L277:NotesListScreen.kt#a1bbf8");
                    if (list.isEmpty()) {
                        composerStartRestartGroup.startReplaceGroup(328007594);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "201@8097L127");
                        EmptyItemsWithPullToRefreshWorkaroundKt.EmptyItemsList(itemsStateConfig, null, true, composerStartRestartGroup, ((i3 >> 3) & 14) | 384, 2);
                        composerStartRestartGroup.endReplaceGroup();
                        function11 = function4;
                        function12 = function10;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(328165756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "206@8254L205");
                        int i117 = i3 >> 12;
                        Function1<? super ItemId.Remote, Unit> function117 = function4;
                        NotesList(list, lazyListState2, function117, function10, composerStartRestartGroup, (i3 & 14) | ((i3 >> 3) & 112) | (i117 & 896) | (i117 & 7168));
                        function11 = function117;
                        function12 = function10;
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    PullToRefreshDefaults.INSTANCE.m5106Indicator2poqoh4(pullToRefreshStateRememberPullToRefreshState15, z110, boxScopeInstance15.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopCenter()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11542getPopupBackground0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), 0.0f, composerStartRestartGroup, ((i3 >> 9) & 112) | (PullToRefreshDefaults.$stable << 18), 32);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function5 = function12;
                    modifier3 = modifier2;
                    z4 = z110;
                    function6 = function8;
                    function7 = function11;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NotesListScreenKt.NotesListScreen$lambda$13(list, itemsStateConfig, lazyListState, modifier3, z4, function6, function7, function5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 12582912;
            if ((i3 & 4793491) != 4793490) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                function5 = function2;
                modifier3 = modifier2;
                z4 = z2;
                function6 = function3;
                function7 = function4;
            } else {
                if (i12 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
                if (i6 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242259229, "CC(remember):NotesListScreen.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function0() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function8 = (Function0) objRememberedValue3;
                } else {
                    function8 = function3;
                }
                if (i8 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242260733, "CC(remember):NotesListScreen.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return NotesListScreenKt.NotesListScreen$lambda$10$0((ItemId.Remote) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function4 = (Function1) objRememberedValue2;
                }
                if (i10 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242262397, "CC(remember):NotesListScreen.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return NotesListScreenKt.NotesListScreen$lambda$11$0((ItemId.Remote) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    function9 = (Function1) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    function9 = function2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-266863461, i3, -1, "com.box.android.notes.presentation.ui.NotesListScreen (NotesListScreen.kt:189)");
                }
                PullToRefreshState pullToRefreshStateRememberPullToRefreshState16 = PullToRefreshKt.rememberPullToRefreshState(composerStartRestartGroup, 0);
                Modifier modifierM5119pullToRefreshZ4HSEVQ$default16 = PullToRefreshKt.m5119pullToRefreshZ4HSEVQ$default(SizeKt.fillMaxHeight$default(modifier2, 0.0f, 1, null), z5, pullToRefreshStateRememberPullToRefreshState16, false, 0.0f, function8, 12, null);
                boolean z111 = z5;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy16 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode16 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap16 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier16 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM5119pullToRefreshZ4HSEVQ$default16);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                function10 = function9;
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
                Composer composerM6062constructorimpl16 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl16, measurePolicyMaybeCachedBoxMeasurePolicy16, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl16, currentCompositionLocalMap16, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl16, Integer.valueOf(iHashCode16), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl16, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl16, modifierMaterializeModifier16, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance16 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 327999752, "C218@8669L6,219@8722L6,214@8479L277:NotesListScreen.kt#a1bbf8");
                if (list.isEmpty()) {
                    composerStartRestartGroup.startReplaceGroup(328007594);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "201@8097L127");
                    EmptyItemsWithPullToRefreshWorkaroundKt.EmptyItemsList(itemsStateConfig, null, true, composerStartRestartGroup, ((i3 >> 3) & 14) | 384, 2);
                    composerStartRestartGroup.endReplaceGroup();
                    function11 = function4;
                    function12 = function10;
                } else {
                    composerStartRestartGroup.startReplaceGroup(328165756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "206@8254L205");
                    int i118 = i3 >> 12;
                    Function1<? super ItemId.Remote, Unit> function118 = function4;
                    NotesList(list, lazyListState2, function118, function10, composerStartRestartGroup, (i3 & 14) | ((i3 >> 3) & 112) | (i118 & 896) | (i118 & 7168));
                    function11 = function118;
                    function12 = function10;
                    composerStartRestartGroup.endReplaceGroup();
                }
                PullToRefreshDefaults.INSTANCE.m5106Indicator2poqoh4(pullToRefreshStateRememberPullToRefreshState16, z111, boxScopeInstance16.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopCenter()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11542getPopupBackground0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), 0.0f, composerStartRestartGroup, ((i3 >> 9) & 112) | (PullToRefreshDefaults.$stable << 18), 32);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function5 = function12;
                modifier3 = modifier2;
                z4 = z111;
                function6 = function8;
                function7 = function11;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NotesListScreenKt.NotesListScreen$lambda$13(list, itemsStateConfig, lazyListState, modifier3, z4, function6, function7, function5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 3072;
        modifier2 = modifier;
        i4 = i2 & 16;
        if (i4 != 0) {
            if ((i & 24576) == 0) {
                z2 = z;
                if (composerStartRestartGroup.changed(z2)) {
                    i5 = 16384;
                } else {
                    i5 = 8192;
                }
                i3 |= i5;
            }
            i6 = i2 & 32;
            if (i6 != 0) {
                if ((196608 & i) == 0) {
                    function3 = function0;
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i7 = 131072;
                    } else {
                        i7 = 65536;
                    }
                    i3 |= i7;
                }
                i8 = i2 & 64;
                if (i8 != 0) {
                    if ((1572864 & i) == 0) {
                        function4 = function1;
                        if (composerStartRestartGroup.changedInstance(function4)) {
                            i9 = 1048576;
                        } else {
                            i9 = 524288;
                        }
                        i3 |= i9;
                    }
                    i10 = i2 & 128;
                    if (i10 != 0) {
                        if ((i & 12582912) == 0) {
                            if (composerStartRestartGroup.changedInstance(function2)) {
                                i11 = 8388608;
                            } else {
                                i11 = 4194304;
                            }
                            i3 |= i11;
                        }
                        if ((i3 & 4793491) != 4793490) {
                            z3 = true;
                        } else {
                            z3 = false;
                        }
                        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                            composerStartRestartGroup.skipToGroupEnd();
                            function5 = function2;
                            modifier3 = modifier2;
                            z4 = z2;
                            function6 = function3;
                            function7 = function4;
                        } else {
                            if (i12 != 0) {
                                modifier2 = Modifier.INSTANCE;
                            }
                            if (i4 != 0) {
                                z5 = false;
                            } else {
                                z5 = z2;
                            }
                            if (i6 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242259229, "CC(remember):NotesListScreen.kt#9igjgp");
                                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue3 = new Function0() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda3
                                        @Override // kotlin.jvm.functions.Function0
                                        public final Object invoke() {
                                            return Unit.INSTANCE;
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                function8 = (Function0) objRememberedValue3;
                            } else {
                                function8 = function3;
                            }
                            if (i8 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242260733, "CC(remember):NotesListScreen.kt#9igjgp");
                                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue2 = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda4
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return NotesListScreenKt.NotesListScreen$lambda$10$0((ItemId.Remote) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                                }
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                                function4 = (Function1) objRememberedValue2;
                            }
                            if (i10 != 0) {
                                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242262397, "CC(remember):NotesListScreen.kt#9igjgp");
                                objRememberedValue = composerStartRestartGroup.rememberedValue();
                                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                    objRememberedValue = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda5
                                        @Override // kotlin.jvm.functions.Function1
                                        public final Object invoke(Object obj) {
                                            return NotesListScreenKt.NotesListScreen$lambda$11$0((ItemId.Remote) obj);
                                        }
                                    };
                                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                                }
                                function9 = (Function1) objRememberedValue;
                                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            } else {
                                function9 = function2;
                            }
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventStart(-266863461, i3, -1, "com.box.android.notes.presentation.ui.NotesListScreen (NotesListScreen.kt:189)");
                            }
                            PullToRefreshState pullToRefreshStateRememberPullToRefreshState17 = PullToRefreshKt.rememberPullToRefreshState(composerStartRestartGroup, 0);
                            Modifier modifierM5119pullToRefreshZ4HSEVQ$default17 = PullToRefreshKt.m5119pullToRefreshZ4HSEVQ$default(SizeKt.fillMaxHeight$default(modifier2, 0.0f, 1, null), z5, pullToRefreshStateRememberPullToRefreshState17, false, 0.0f, function8, 12, null);
                            boolean z112 = z5;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy17 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                            int iHashCode17 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                            CompositionLocalMap currentCompositionLocalMap17 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                            Modifier modifierMaterializeModifier17 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM5119pullToRefreshZ4HSEVQ$default17);
                            constructor = ComposeUiNode.INSTANCE.getConstructor();
                            function10 = function9;
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
                            Composer composerM6062constructorimpl17 = Updater.m6062constructorimpl(composerStartRestartGroup);
                            Updater.m6070setimpl(composerM6062constructorimpl17, measurePolicyMaybeCachedBoxMeasurePolicy17, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                            Updater.m6070setimpl(composerM6062constructorimpl17, currentCompositionLocalMap17, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                            Updater.m6066initimpl(composerM6062constructorimpl17, Integer.valueOf(iHashCode17), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                            Updater.m6068reconcileimpl(composerM6062constructorimpl17, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                            Updater.m6070setimpl(composerM6062constructorimpl17, modifierMaterializeModifier17, ComposeUiNode.INSTANCE.getSetModifier());
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                            BoxScopeInstance boxScopeInstance17 = BoxScopeInstance.INSTANCE;
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 327999752, "C218@8669L6,219@8722L6,214@8479L277:NotesListScreen.kt#a1bbf8");
                            if (list.isEmpty()) {
                                composerStartRestartGroup.startReplaceGroup(328007594);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "201@8097L127");
                                EmptyItemsWithPullToRefreshWorkaroundKt.EmptyItemsList(itemsStateConfig, null, true, composerStartRestartGroup, ((i3 >> 3) & 14) | 384, 2);
                                composerStartRestartGroup.endReplaceGroup();
                                function11 = function4;
                                function12 = function10;
                            } else {
                                composerStartRestartGroup.startReplaceGroup(328165756);
                                ComposerKt.sourceInformation(composerStartRestartGroup, "206@8254L205");
                                int i119 = i3 >> 12;
                                Function1<? super ItemId.Remote, Unit> function119 = function4;
                                NotesList(list, lazyListState2, function119, function10, composerStartRestartGroup, (i3 & 14) | ((i3 >> 3) & 112) | (i119 & 896) | (i119 & 7168));
                                function11 = function119;
                                function12 = function10;
                                composerStartRestartGroup.endReplaceGroup();
                            }
                            PullToRefreshDefaults.INSTANCE.m5106Indicator2poqoh4(pullToRefreshStateRememberPullToRefreshState17, z112, boxScopeInstance17.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopCenter()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11542getPopupBackground0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), 0.0f, composerStartRestartGroup, ((i3 >> 9) & 112) | (PullToRefreshDefaults.$stable << 18), 32);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            composerStartRestartGroup.endNode();
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            if (ComposerKt.isTraceInProgress()) {
                                ComposerKt.traceEventEnd();
                            }
                            function5 = function12;
                            modifier3 = modifier2;
                            z4 = z112;
                            function6 = function8;
                            function7 = function11;
                        }
                        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                        if (scopeUpdateScopeEndRestartGroup != null) {
                            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda6
                                @Override // kotlin.jvm.functions.Function2
                                public final Object invoke(Object obj, Object obj2) {
                                    return NotesListScreenKt.NotesListScreen$lambda$13(list, itemsStateConfig, lazyListState, modifier3, z4, function6, function7, function5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                                }
                            });
                        }
                    }
                    i3 |= 12582912;
                    if ((i3 & 4793491) != 4793490) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        function5 = function2;
                        modifier3 = modifier2;
                        z4 = z2;
                        function6 = function3;
                        function7 = function4;
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z5 = false;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242259229, "CC(remember):NotesListScreen.kt#9igjgp");
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue3 = new Function0() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Unit.INSTANCE;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            function8 = (Function0) objRememberedValue3;
                        } else {
                            function8 = function3;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242260733, "CC(remember):NotesListScreen.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda4
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return NotesListScreenKt.NotesListScreen$lambda$10$0((ItemId.Remote) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            function4 = (Function1) objRememberedValue2;
                        }
                        if (i10 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242262397, "CC(remember):NotesListScreen.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda5
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return NotesListScreenKt.NotesListScreen$lambda$11$0((ItemId.Remote) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            function9 = (Function1) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function9 = function2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-266863461, i3, -1, "com.box.android.notes.presentation.ui.NotesListScreen (NotesListScreen.kt:189)");
                        }
                        PullToRefreshState pullToRefreshStateRememberPullToRefreshState18 = PullToRefreshKt.rememberPullToRefreshState(composerStartRestartGroup, 0);
                        Modifier modifierM5119pullToRefreshZ4HSEVQ$default18 = PullToRefreshKt.m5119pullToRefreshZ4HSEVQ$default(SizeKt.fillMaxHeight$default(modifier2, 0.0f, 1, null), z5, pullToRefreshStateRememberPullToRefreshState18, false, 0.0f, function8, 12, null);
                        boolean z113 = z5;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy18 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode18 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap18 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier18 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM5119pullToRefreshZ4HSEVQ$default18);
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        function10 = function9;
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
                        Composer composerM6062constructorimpl18 = Updater.m6062constructorimpl(composerStartRestartGroup);
                        Updater.m6070setimpl(composerM6062constructorimpl18, measurePolicyMaybeCachedBoxMeasurePolicy18, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl18, currentCompositionLocalMap18, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl18, Integer.valueOf(iHashCode18), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl18, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl18, modifierMaterializeModifier18, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance18 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 327999752, "C218@8669L6,219@8722L6,214@8479L277:NotesListScreen.kt#a1bbf8");
                        if (list.isEmpty()) {
                            composerStartRestartGroup.startReplaceGroup(328007594);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "201@8097L127");
                            EmptyItemsWithPullToRefreshWorkaroundKt.EmptyItemsList(itemsStateConfig, null, true, composerStartRestartGroup, ((i3 >> 3) & 14) | 384, 2);
                            composerStartRestartGroup.endReplaceGroup();
                            function11 = function4;
                            function12 = function10;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(328165756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "206@8254L205");
                            int i1110 = i3 >> 12;
                            Function1<? super ItemId.Remote, Unit> function1110 = function4;
                            NotesList(list, lazyListState2, function1110, function10, composerStartRestartGroup, (i3 & 14) | ((i3 >> 3) & 112) | (i1110 & 896) | (i1110 & 7168));
                            function11 = function1110;
                            function12 = function10;
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        PullToRefreshDefaults.INSTANCE.m5106Indicator2poqoh4(pullToRefreshStateRememberPullToRefreshState18, z113, boxScopeInstance18.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopCenter()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11542getPopupBackground0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), 0.0f, composerStartRestartGroup, ((i3 >> 9) & 112) | (PullToRefreshDefaults.$stable << 18), 32);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function5 = function12;
                        modifier3 = modifier2;
                        z4 = z113;
                        function6 = function8;
                        function7 = function11;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NotesListScreenKt.NotesListScreen$lambda$13(list, itemsStateConfig, lazyListState, modifier3, z4, function6, function7, function5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 1572864;
                function4 = function1;
                i10 = i2 & 128;
                if (i10 != 0) {
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i11 = 8388608;
                        } else {
                            i11 = 4194304;
                        }
                        i3 |= i11;
                    }
                    if ((i3 & 4793491) != 4793490) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        function5 = function2;
                        modifier3 = modifier2;
                        z4 = z2;
                        function6 = function3;
                        function7 = function4;
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z5 = false;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242259229, "CC(remember):NotesListScreen.kt#9igjgp");
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue3 = new Function0() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Unit.INSTANCE;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            function8 = (Function0) objRememberedValue3;
                        } else {
                            function8 = function3;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242260733, "CC(remember):NotesListScreen.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda4
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return NotesListScreenKt.NotesListScreen$lambda$10$0((ItemId.Remote) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            function4 = (Function1) objRememberedValue2;
                        }
                        if (i10 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242262397, "CC(remember):NotesListScreen.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda5
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return NotesListScreenKt.NotesListScreen$lambda$11$0((ItemId.Remote) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            function9 = (Function1) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function9 = function2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-266863461, i3, -1, "com.box.android.notes.presentation.ui.NotesListScreen (NotesListScreen.kt:189)");
                        }
                        PullToRefreshState pullToRefreshStateRememberPullToRefreshState19 = PullToRefreshKt.rememberPullToRefreshState(composerStartRestartGroup, 0);
                        Modifier modifierM5119pullToRefreshZ4HSEVQ$default19 = PullToRefreshKt.m5119pullToRefreshZ4HSEVQ$default(SizeKt.fillMaxHeight$default(modifier2, 0.0f, 1, null), z5, pullToRefreshStateRememberPullToRefreshState19, false, 0.0f, function8, 12, null);
                        boolean z114 = z5;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy19 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode19 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap19 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier19 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM5119pullToRefreshZ4HSEVQ$default19);
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        function10 = function9;
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
                        Composer composerM6062constructorimpl19 = Updater.m6062constructorimpl(composerStartRestartGroup);
                        Updater.m6070setimpl(composerM6062constructorimpl19, measurePolicyMaybeCachedBoxMeasurePolicy19, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl19, currentCompositionLocalMap19, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl19, Integer.valueOf(iHashCode19), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl19, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl19, modifierMaterializeModifier19, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance19 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 327999752, "C218@8669L6,219@8722L6,214@8479L277:NotesListScreen.kt#a1bbf8");
                        if (list.isEmpty()) {
                            composerStartRestartGroup.startReplaceGroup(328007594);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "201@8097L127");
                            EmptyItemsWithPullToRefreshWorkaroundKt.EmptyItemsList(itemsStateConfig, null, true, composerStartRestartGroup, ((i3 >> 3) & 14) | 384, 2);
                            composerStartRestartGroup.endReplaceGroup();
                            function11 = function4;
                            function12 = function10;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(328165756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "206@8254L205");
                            int i1111 = i3 >> 12;
                            Function1<? super ItemId.Remote, Unit> function1111 = function4;
                            NotesList(list, lazyListState2, function1111, function10, composerStartRestartGroup, (i3 & 14) | ((i3 >> 3) & 112) | (i1111 & 896) | (i1111 & 7168));
                            function11 = function1111;
                            function12 = function10;
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        PullToRefreshDefaults.INSTANCE.m5106Indicator2poqoh4(pullToRefreshStateRememberPullToRefreshState19, z114, boxScopeInstance19.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopCenter()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11542getPopupBackground0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), 0.0f, composerStartRestartGroup, ((i3 >> 9) & 112) | (PullToRefreshDefaults.$stable << 18), 32);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function5 = function12;
                        modifier3 = modifier2;
                        z4 = z114;
                        function6 = function8;
                        function7 = function11;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NotesListScreenKt.NotesListScreen$lambda$13(list, itemsStateConfig, lazyListState, modifier3, z4, function6, function7, function5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 12582912;
                if ((i3 & 4793491) != 4793490) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    function5 = function2;
                    modifier3 = modifier2;
                    z4 = z2;
                    function6 = function3;
                    function7 = function4;
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242259229, "CC(remember):NotesListScreen.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new Function0() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function8 = (Function0) objRememberedValue3;
                    } else {
                        function8 = function3;
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242260733, "CC(remember):NotesListScreen.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return NotesListScreenKt.NotesListScreen$lambda$10$0((ItemId.Remote) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function4 = (Function1) objRememberedValue2;
                    }
                    if (i10 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242262397, "CC(remember):NotesListScreen.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return NotesListScreenKt.NotesListScreen$lambda$11$0((ItemId.Remote) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        function9 = (Function1) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function9 = function2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-266863461, i3, -1, "com.box.android.notes.presentation.ui.NotesListScreen (NotesListScreen.kt:189)");
                    }
                    PullToRefreshState pullToRefreshStateRememberPullToRefreshState110 = PullToRefreshKt.rememberPullToRefreshState(composerStartRestartGroup, 0);
                    Modifier modifierM5119pullToRefreshZ4HSEVQ$default110 = PullToRefreshKt.m5119pullToRefreshZ4HSEVQ$default(SizeKt.fillMaxHeight$default(modifier2, 0.0f, 1, null), z5, pullToRefreshStateRememberPullToRefreshState110, false, 0.0f, function8, 12, null);
                    boolean z115 = z5;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy110 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode110 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap110 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier110 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM5119pullToRefreshZ4HSEVQ$default110);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    function10 = function9;
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
                    Composer composerM6062constructorimpl110 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl110, measurePolicyMaybeCachedBoxMeasurePolicy110, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl110, currentCompositionLocalMap110, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl110, Integer.valueOf(iHashCode110), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl110, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl110, modifierMaterializeModifier110, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance110 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 327999752, "C218@8669L6,219@8722L6,214@8479L277:NotesListScreen.kt#a1bbf8");
                    if (list.isEmpty()) {
                        composerStartRestartGroup.startReplaceGroup(328007594);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "201@8097L127");
                        EmptyItemsWithPullToRefreshWorkaroundKt.EmptyItemsList(itemsStateConfig, null, true, composerStartRestartGroup, ((i3 >> 3) & 14) | 384, 2);
                        composerStartRestartGroup.endReplaceGroup();
                        function11 = function4;
                        function12 = function10;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(328165756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "206@8254L205");
                        int i1112 = i3 >> 12;
                        Function1<? super ItemId.Remote, Unit> function1112 = function4;
                        NotesList(list, lazyListState2, function1112, function10, composerStartRestartGroup, (i3 & 14) | ((i3 >> 3) & 112) | (i1112 & 896) | (i1112 & 7168));
                        function11 = function1112;
                        function12 = function10;
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    PullToRefreshDefaults.INSTANCE.m5106Indicator2poqoh4(pullToRefreshStateRememberPullToRefreshState110, z115, boxScopeInstance110.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopCenter()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11542getPopupBackground0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), 0.0f, composerStartRestartGroup, ((i3 >> 9) & 112) | (PullToRefreshDefaults.$stable << 18), 32);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function5 = function12;
                    modifier3 = modifier2;
                    z4 = z115;
                    function6 = function8;
                    function7 = function11;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NotesListScreenKt.NotesListScreen$lambda$13(list, itemsStateConfig, lazyListState, modifier3, z4, function6, function7, function5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
            function3 = function0;
            i8 = i2 & 64;
            if (i8 != 0) {
                if ((1572864 & i) == 0) {
                    function4 = function1;
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 128;
                if (i10 != 0) {
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i11 = 8388608;
                        } else {
                            i11 = 4194304;
                        }
                        i3 |= i11;
                    }
                    if ((i3 & 4793491) != 4793490) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        function5 = function2;
                        modifier3 = modifier2;
                        z4 = z2;
                        function6 = function3;
                        function7 = function4;
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z5 = false;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242259229, "CC(remember):NotesListScreen.kt#9igjgp");
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue3 = new Function0() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Unit.INSTANCE;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            function8 = (Function0) objRememberedValue3;
                        } else {
                            function8 = function3;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242260733, "CC(remember):NotesListScreen.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda4
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return NotesListScreenKt.NotesListScreen$lambda$10$0((ItemId.Remote) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            function4 = (Function1) objRememberedValue2;
                        }
                        if (i10 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242262397, "CC(remember):NotesListScreen.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda5
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return NotesListScreenKt.NotesListScreen$lambda$11$0((ItemId.Remote) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            function9 = (Function1) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function9 = function2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-266863461, i3, -1, "com.box.android.notes.presentation.ui.NotesListScreen (NotesListScreen.kt:189)");
                        }
                        PullToRefreshState pullToRefreshStateRememberPullToRefreshState111 = PullToRefreshKt.rememberPullToRefreshState(composerStartRestartGroup, 0);
                        Modifier modifierM5119pullToRefreshZ4HSEVQ$default111 = PullToRefreshKt.m5119pullToRefreshZ4HSEVQ$default(SizeKt.fillMaxHeight$default(modifier2, 0.0f, 1, null), z5, pullToRefreshStateRememberPullToRefreshState111, false, 0.0f, function8, 12, null);
                        boolean z116 = z5;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy111 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode111 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap111 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier111 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM5119pullToRefreshZ4HSEVQ$default111);
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        function10 = function9;
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
                        Composer composerM6062constructorimpl111 = Updater.m6062constructorimpl(composerStartRestartGroup);
                        Updater.m6070setimpl(composerM6062constructorimpl111, measurePolicyMaybeCachedBoxMeasurePolicy111, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl111, currentCompositionLocalMap111, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl111, Integer.valueOf(iHashCode111), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl111, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl111, modifierMaterializeModifier111, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance111 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 327999752, "C218@8669L6,219@8722L6,214@8479L277:NotesListScreen.kt#a1bbf8");
                        if (list.isEmpty()) {
                            composerStartRestartGroup.startReplaceGroup(328007594);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "201@8097L127");
                            EmptyItemsWithPullToRefreshWorkaroundKt.EmptyItemsList(itemsStateConfig, null, true, composerStartRestartGroup, ((i3 >> 3) & 14) | 384, 2);
                            composerStartRestartGroup.endReplaceGroup();
                            function11 = function4;
                            function12 = function10;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(328165756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "206@8254L205");
                            int i1113 = i3 >> 12;
                            Function1<? super ItemId.Remote, Unit> function1113 = function4;
                            NotesList(list, lazyListState2, function1113, function10, composerStartRestartGroup, (i3 & 14) | ((i3 >> 3) & 112) | (i1113 & 896) | (i1113 & 7168));
                            function11 = function1113;
                            function12 = function10;
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        PullToRefreshDefaults.INSTANCE.m5106Indicator2poqoh4(pullToRefreshStateRememberPullToRefreshState111, z116, boxScopeInstance111.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopCenter()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11542getPopupBackground0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), 0.0f, composerStartRestartGroup, ((i3 >> 9) & 112) | (PullToRefreshDefaults.$stable << 18), 32);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function5 = function12;
                        modifier3 = modifier2;
                        z4 = z116;
                        function6 = function8;
                        function7 = function11;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NotesListScreenKt.NotesListScreen$lambda$13(list, itemsStateConfig, lazyListState, modifier3, z4, function6, function7, function5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 12582912;
                if ((i3 & 4793491) != 4793490) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    function5 = function2;
                    modifier3 = modifier2;
                    z4 = z2;
                    function6 = function3;
                    function7 = function4;
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242259229, "CC(remember):NotesListScreen.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new Function0() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function8 = (Function0) objRememberedValue3;
                    } else {
                        function8 = function3;
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242260733, "CC(remember):NotesListScreen.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return NotesListScreenKt.NotesListScreen$lambda$10$0((ItemId.Remote) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function4 = (Function1) objRememberedValue2;
                    }
                    if (i10 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242262397, "CC(remember):NotesListScreen.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return NotesListScreenKt.NotesListScreen$lambda$11$0((ItemId.Remote) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        function9 = (Function1) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function9 = function2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-266863461, i3, -1, "com.box.android.notes.presentation.ui.NotesListScreen (NotesListScreen.kt:189)");
                    }
                    PullToRefreshState pullToRefreshStateRememberPullToRefreshState112 = PullToRefreshKt.rememberPullToRefreshState(composerStartRestartGroup, 0);
                    Modifier modifierM5119pullToRefreshZ4HSEVQ$default112 = PullToRefreshKt.m5119pullToRefreshZ4HSEVQ$default(SizeKt.fillMaxHeight$default(modifier2, 0.0f, 1, null), z5, pullToRefreshStateRememberPullToRefreshState112, false, 0.0f, function8, 12, null);
                    boolean z117 = z5;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy112 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode112 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap112 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier112 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM5119pullToRefreshZ4HSEVQ$default112);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    function10 = function9;
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
                    Composer composerM6062constructorimpl112 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl112, measurePolicyMaybeCachedBoxMeasurePolicy112, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl112, currentCompositionLocalMap112, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl112, Integer.valueOf(iHashCode112), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl112, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl112, modifierMaterializeModifier112, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance112 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 327999752, "C218@8669L6,219@8722L6,214@8479L277:NotesListScreen.kt#a1bbf8");
                    if (list.isEmpty()) {
                        composerStartRestartGroup.startReplaceGroup(328007594);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "201@8097L127");
                        EmptyItemsWithPullToRefreshWorkaroundKt.EmptyItemsList(itemsStateConfig, null, true, composerStartRestartGroup, ((i3 >> 3) & 14) | 384, 2);
                        composerStartRestartGroup.endReplaceGroup();
                        function11 = function4;
                        function12 = function10;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(328165756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "206@8254L205");
                        int i1114 = i3 >> 12;
                        Function1<? super ItemId.Remote, Unit> function1114 = function4;
                        NotesList(list, lazyListState2, function1114, function10, composerStartRestartGroup, (i3 & 14) | ((i3 >> 3) & 112) | (i1114 & 896) | (i1114 & 7168));
                        function11 = function1114;
                        function12 = function10;
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    PullToRefreshDefaults.INSTANCE.m5106Indicator2poqoh4(pullToRefreshStateRememberPullToRefreshState112, z117, boxScopeInstance112.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopCenter()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11542getPopupBackground0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), 0.0f, composerStartRestartGroup, ((i3 >> 9) & 112) | (PullToRefreshDefaults.$stable << 18), 32);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function5 = function12;
                    modifier3 = modifier2;
                    z4 = z117;
                    function6 = function8;
                    function7 = function11;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NotesListScreenKt.NotesListScreen$lambda$13(list, itemsStateConfig, lazyListState, modifier3, z4, function6, function7, function5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 1572864;
            function4 = function1;
            i10 = i2 & 128;
            if (i10 != 0) {
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i3 |= i11;
                }
                if ((i3 & 4793491) != 4793490) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    function5 = function2;
                    modifier3 = modifier2;
                    z4 = z2;
                    function6 = function3;
                    function7 = function4;
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242259229, "CC(remember):NotesListScreen.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new Function0() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function8 = (Function0) objRememberedValue3;
                    } else {
                        function8 = function3;
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242260733, "CC(remember):NotesListScreen.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return NotesListScreenKt.NotesListScreen$lambda$10$0((ItemId.Remote) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function4 = (Function1) objRememberedValue2;
                    }
                    if (i10 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242262397, "CC(remember):NotesListScreen.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return NotesListScreenKt.NotesListScreen$lambda$11$0((ItemId.Remote) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        function9 = (Function1) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function9 = function2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-266863461, i3, -1, "com.box.android.notes.presentation.ui.NotesListScreen (NotesListScreen.kt:189)");
                    }
                    PullToRefreshState pullToRefreshStateRememberPullToRefreshState113 = PullToRefreshKt.rememberPullToRefreshState(composerStartRestartGroup, 0);
                    Modifier modifierM5119pullToRefreshZ4HSEVQ$default113 = PullToRefreshKt.m5119pullToRefreshZ4HSEVQ$default(SizeKt.fillMaxHeight$default(modifier2, 0.0f, 1, null), z5, pullToRefreshStateRememberPullToRefreshState113, false, 0.0f, function8, 12, null);
                    boolean z118 = z5;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy113 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode113 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap113 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier113 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM5119pullToRefreshZ4HSEVQ$default113);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    function10 = function9;
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
                    Composer composerM6062constructorimpl113 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl113, measurePolicyMaybeCachedBoxMeasurePolicy113, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl113, currentCompositionLocalMap113, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl113, Integer.valueOf(iHashCode113), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl113, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl113, modifierMaterializeModifier113, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance113 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 327999752, "C218@8669L6,219@8722L6,214@8479L277:NotesListScreen.kt#a1bbf8");
                    if (list.isEmpty()) {
                        composerStartRestartGroup.startReplaceGroup(328007594);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "201@8097L127");
                        EmptyItemsWithPullToRefreshWorkaroundKt.EmptyItemsList(itemsStateConfig, null, true, composerStartRestartGroup, ((i3 >> 3) & 14) | 384, 2);
                        composerStartRestartGroup.endReplaceGroup();
                        function11 = function4;
                        function12 = function10;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(328165756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "206@8254L205");
                        int i1115 = i3 >> 12;
                        Function1<? super ItemId.Remote, Unit> function1115 = function4;
                        NotesList(list, lazyListState2, function1115, function10, composerStartRestartGroup, (i3 & 14) | ((i3 >> 3) & 112) | (i1115 & 896) | (i1115 & 7168));
                        function11 = function1115;
                        function12 = function10;
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    PullToRefreshDefaults.INSTANCE.m5106Indicator2poqoh4(pullToRefreshStateRememberPullToRefreshState113, z118, boxScopeInstance113.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopCenter()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11542getPopupBackground0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), 0.0f, composerStartRestartGroup, ((i3 >> 9) & 112) | (PullToRefreshDefaults.$stable << 18), 32);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function5 = function12;
                    modifier3 = modifier2;
                    z4 = z118;
                    function6 = function8;
                    function7 = function11;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NotesListScreenKt.NotesListScreen$lambda$13(list, itemsStateConfig, lazyListState, modifier3, z4, function6, function7, function5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 12582912;
            if ((i3 & 4793491) != 4793490) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                function5 = function2;
                modifier3 = modifier2;
                z4 = z2;
                function6 = function3;
                function7 = function4;
            } else {
                if (i12 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
                if (i6 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242259229, "CC(remember):NotesListScreen.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function0() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function8 = (Function0) objRememberedValue3;
                } else {
                    function8 = function3;
                }
                if (i8 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242260733, "CC(remember):NotesListScreen.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return NotesListScreenKt.NotesListScreen$lambda$10$0((ItemId.Remote) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function4 = (Function1) objRememberedValue2;
                }
                if (i10 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242262397, "CC(remember):NotesListScreen.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return NotesListScreenKt.NotesListScreen$lambda$11$0((ItemId.Remote) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    function9 = (Function1) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    function9 = function2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-266863461, i3, -1, "com.box.android.notes.presentation.ui.NotesListScreen (NotesListScreen.kt:189)");
                }
                PullToRefreshState pullToRefreshStateRememberPullToRefreshState114 = PullToRefreshKt.rememberPullToRefreshState(composerStartRestartGroup, 0);
                Modifier modifierM5119pullToRefreshZ4HSEVQ$default114 = PullToRefreshKt.m5119pullToRefreshZ4HSEVQ$default(SizeKt.fillMaxHeight$default(modifier2, 0.0f, 1, null), z5, pullToRefreshStateRememberPullToRefreshState114, false, 0.0f, function8, 12, null);
                boolean z119 = z5;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy114 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode114 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap114 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier114 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM5119pullToRefreshZ4HSEVQ$default114);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                function10 = function9;
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
                Composer composerM6062constructorimpl114 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl114, measurePolicyMaybeCachedBoxMeasurePolicy114, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl114, currentCompositionLocalMap114, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl114, Integer.valueOf(iHashCode114), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl114, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl114, modifierMaterializeModifier114, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance114 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 327999752, "C218@8669L6,219@8722L6,214@8479L277:NotesListScreen.kt#a1bbf8");
                if (list.isEmpty()) {
                    composerStartRestartGroup.startReplaceGroup(328007594);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "201@8097L127");
                    EmptyItemsWithPullToRefreshWorkaroundKt.EmptyItemsList(itemsStateConfig, null, true, composerStartRestartGroup, ((i3 >> 3) & 14) | 384, 2);
                    composerStartRestartGroup.endReplaceGroup();
                    function11 = function4;
                    function12 = function10;
                } else {
                    composerStartRestartGroup.startReplaceGroup(328165756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "206@8254L205");
                    int i1116 = i3 >> 12;
                    Function1<? super ItemId.Remote, Unit> function1116 = function4;
                    NotesList(list, lazyListState2, function1116, function10, composerStartRestartGroup, (i3 & 14) | ((i3 >> 3) & 112) | (i1116 & 896) | (i1116 & 7168));
                    function11 = function1116;
                    function12 = function10;
                    composerStartRestartGroup.endReplaceGroup();
                }
                PullToRefreshDefaults.INSTANCE.m5106Indicator2poqoh4(pullToRefreshStateRememberPullToRefreshState114, z119, boxScopeInstance114.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopCenter()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11542getPopupBackground0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), 0.0f, composerStartRestartGroup, ((i3 >> 9) & 112) | (PullToRefreshDefaults.$stable << 18), 32);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function5 = function12;
                modifier3 = modifier2;
                z4 = z119;
                function6 = function8;
                function7 = function11;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NotesListScreenKt.NotesListScreen$lambda$13(list, itemsStateConfig, lazyListState, modifier3, z4, function6, function7, function5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 24576;
        z2 = z;
        i6 = i2 & 32;
        if (i6 != 0) {
            if ((196608 & i) == 0) {
                function3 = function0;
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i7 = 131072;
                } else {
                    i7 = 65536;
                }
                i3 |= i7;
            }
            i8 = i2 & 64;
            if (i8 != 0) {
                if ((1572864 & i) == 0) {
                    function4 = function1;
                    if (composerStartRestartGroup.changedInstance(function4)) {
                        i9 = 1048576;
                    } else {
                        i9 = 524288;
                    }
                    i3 |= i9;
                }
                i10 = i2 & 128;
                if (i10 != 0) {
                    if ((i & 12582912) == 0) {
                        if (composerStartRestartGroup.changedInstance(function2)) {
                            i11 = 8388608;
                        } else {
                            i11 = 4194304;
                        }
                        i3 |= i11;
                    }
                    if ((i3 & 4793491) != 4793490) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                        composerStartRestartGroup.skipToGroupEnd();
                        function5 = function2;
                        modifier3 = modifier2;
                        z4 = z2;
                        function6 = function3;
                        function7 = function4;
                    } else {
                        if (i12 != 0) {
                            modifier2 = Modifier.INSTANCE;
                        }
                        if (i4 != 0) {
                            z5 = false;
                        } else {
                            z5 = z2;
                        }
                        if (i6 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242259229, "CC(remember):NotesListScreen.kt#9igjgp");
                            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue3 = new Function0() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda3
                                    @Override // kotlin.jvm.functions.Function0
                                    public final Object invoke() {
                                        return Unit.INSTANCE;
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            function8 = (Function0) objRememberedValue3;
                        } else {
                            function8 = function3;
                        }
                        if (i8 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242260733, "CC(remember):NotesListScreen.kt#9igjgp");
                            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue2 = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda4
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return NotesListScreenKt.NotesListScreen$lambda$10$0((ItemId.Remote) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                            }
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                            function4 = (Function1) objRememberedValue2;
                        }
                        if (i10 != 0) {
                            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242262397, "CC(remember):NotesListScreen.kt#9igjgp");
                            objRememberedValue = composerStartRestartGroup.rememberedValue();
                            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                                objRememberedValue = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda5
                                    @Override // kotlin.jvm.functions.Function1
                                    public final Object invoke(Object obj) {
                                        return NotesListScreenKt.NotesListScreen$lambda$11$0((ItemId.Remote) obj);
                                    }
                                };
                                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                            }
                            function9 = (Function1) objRememberedValue;
                            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        } else {
                            function9 = function2;
                        }
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventStart(-266863461, i3, -1, "com.box.android.notes.presentation.ui.NotesListScreen (NotesListScreen.kt:189)");
                        }
                        PullToRefreshState pullToRefreshStateRememberPullToRefreshState115 = PullToRefreshKt.rememberPullToRefreshState(composerStartRestartGroup, 0);
                        Modifier modifierM5119pullToRefreshZ4HSEVQ$default115 = PullToRefreshKt.m5119pullToRefreshZ4HSEVQ$default(SizeKt.fillMaxHeight$default(modifier2, 0.0f, 1, null), z5, pullToRefreshStateRememberPullToRefreshState115, false, 0.0f, function8, 12, null);
                        boolean z1110 = z5;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy115 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                        int iHashCode115 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                        CompositionLocalMap currentCompositionLocalMap115 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                        Modifier modifierMaterializeModifier115 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM5119pullToRefreshZ4HSEVQ$default115);
                        constructor = ComposeUiNode.INSTANCE.getConstructor();
                        function10 = function9;
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
                        Composer composerM6062constructorimpl115 = Updater.m6062constructorimpl(composerStartRestartGroup);
                        Updater.m6070setimpl(composerM6062constructorimpl115, measurePolicyMaybeCachedBoxMeasurePolicy115, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                        Updater.m6070setimpl(composerM6062constructorimpl115, currentCompositionLocalMap115, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                        Updater.m6066initimpl(composerM6062constructorimpl115, Integer.valueOf(iHashCode115), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                        Updater.m6068reconcileimpl(composerM6062constructorimpl115, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                        Updater.m6070setimpl(composerM6062constructorimpl115, modifierMaterializeModifier115, ComposeUiNode.INSTANCE.getSetModifier());
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                        BoxScopeInstance boxScopeInstance115 = BoxScopeInstance.INSTANCE;
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 327999752, "C218@8669L6,219@8722L6,214@8479L277:NotesListScreen.kt#a1bbf8");
                        if (list.isEmpty()) {
                            composerStartRestartGroup.startReplaceGroup(328007594);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "201@8097L127");
                            EmptyItemsWithPullToRefreshWorkaroundKt.EmptyItemsList(itemsStateConfig, null, true, composerStartRestartGroup, ((i3 >> 3) & 14) | 384, 2);
                            composerStartRestartGroup.endReplaceGroup();
                            function11 = function4;
                            function12 = function10;
                        } else {
                            composerStartRestartGroup.startReplaceGroup(328165756);
                            ComposerKt.sourceInformation(composerStartRestartGroup, "206@8254L205");
                            int i1117 = i3 >> 12;
                            Function1<? super ItemId.Remote, Unit> function1117 = function4;
                            NotesList(list, lazyListState2, function1117, function10, composerStartRestartGroup, (i3 & 14) | ((i3 >> 3) & 112) | (i1117 & 896) | (i1117 & 7168));
                            function11 = function1117;
                            function12 = function10;
                            composerStartRestartGroup.endReplaceGroup();
                        }
                        PullToRefreshDefaults.INSTANCE.m5106Indicator2poqoh4(pullToRefreshStateRememberPullToRefreshState115, z1110, boxScopeInstance115.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopCenter()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11542getPopupBackground0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), 0.0f, composerStartRestartGroup, ((i3 >> 9) & 112) | (PullToRefreshDefaults.$stable << 18), 32);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        composerStartRestartGroup.endNode();
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        if (ComposerKt.isTraceInProgress()) {
                            ComposerKt.traceEventEnd();
                        }
                        function5 = function12;
                        modifier3 = modifier2;
                        z4 = z1110;
                        function6 = function8;
                        function7 = function11;
                    }
                    scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                    if (scopeUpdateScopeEndRestartGroup != null) {
                        scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda6
                            @Override // kotlin.jvm.functions.Function2
                            public final Object invoke(Object obj, Object obj2) {
                                return NotesListScreenKt.NotesListScreen$lambda$13(list, itemsStateConfig, lazyListState, modifier3, z4, function6, function7, function5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                            }
                        });
                    }
                }
                i3 |= 12582912;
                if ((i3 & 4793491) != 4793490) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    function5 = function2;
                    modifier3 = modifier2;
                    z4 = z2;
                    function6 = function3;
                    function7 = function4;
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242259229, "CC(remember):NotesListScreen.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new Function0() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function8 = (Function0) objRememberedValue3;
                    } else {
                        function8 = function3;
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242260733, "CC(remember):NotesListScreen.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return NotesListScreenKt.NotesListScreen$lambda$10$0((ItemId.Remote) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function4 = (Function1) objRememberedValue2;
                    }
                    if (i10 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242262397, "CC(remember):NotesListScreen.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return NotesListScreenKt.NotesListScreen$lambda$11$0((ItemId.Remote) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        function9 = (Function1) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function9 = function2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-266863461, i3, -1, "com.box.android.notes.presentation.ui.NotesListScreen (NotesListScreen.kt:189)");
                    }
                    PullToRefreshState pullToRefreshStateRememberPullToRefreshState116 = PullToRefreshKt.rememberPullToRefreshState(composerStartRestartGroup, 0);
                    Modifier modifierM5119pullToRefreshZ4HSEVQ$default116 = PullToRefreshKt.m5119pullToRefreshZ4HSEVQ$default(SizeKt.fillMaxHeight$default(modifier2, 0.0f, 1, null), z5, pullToRefreshStateRememberPullToRefreshState116, false, 0.0f, function8, 12, null);
                    boolean z1111 = z5;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy116 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode116 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap116 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier116 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM5119pullToRefreshZ4HSEVQ$default116);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    function10 = function9;
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
                    Composer composerM6062constructorimpl116 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl116, measurePolicyMaybeCachedBoxMeasurePolicy116, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl116, currentCompositionLocalMap116, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl116, Integer.valueOf(iHashCode116), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl116, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl116, modifierMaterializeModifier116, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance116 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 327999752, "C218@8669L6,219@8722L6,214@8479L277:NotesListScreen.kt#a1bbf8");
                    if (list.isEmpty()) {
                        composerStartRestartGroup.startReplaceGroup(328007594);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "201@8097L127");
                        EmptyItemsWithPullToRefreshWorkaroundKt.EmptyItemsList(itemsStateConfig, null, true, composerStartRestartGroup, ((i3 >> 3) & 14) | 384, 2);
                        composerStartRestartGroup.endReplaceGroup();
                        function11 = function4;
                        function12 = function10;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(328165756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "206@8254L205");
                        int i1118 = i3 >> 12;
                        Function1<? super ItemId.Remote, Unit> function1118 = function4;
                        NotesList(list, lazyListState2, function1118, function10, composerStartRestartGroup, (i3 & 14) | ((i3 >> 3) & 112) | (i1118 & 896) | (i1118 & 7168));
                        function11 = function1118;
                        function12 = function10;
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    PullToRefreshDefaults.INSTANCE.m5106Indicator2poqoh4(pullToRefreshStateRememberPullToRefreshState116, z1111, boxScopeInstance116.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopCenter()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11542getPopupBackground0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), 0.0f, composerStartRestartGroup, ((i3 >> 9) & 112) | (PullToRefreshDefaults.$stable << 18), 32);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function5 = function12;
                    modifier3 = modifier2;
                    z4 = z1111;
                    function6 = function8;
                    function7 = function11;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NotesListScreenKt.NotesListScreen$lambda$13(list, itemsStateConfig, lazyListState, modifier3, z4, function6, function7, function5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 1572864;
            function4 = function1;
            i10 = i2 & 128;
            if (i10 != 0) {
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i3 |= i11;
                }
                if ((i3 & 4793491) != 4793490) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    function5 = function2;
                    modifier3 = modifier2;
                    z4 = z2;
                    function6 = function3;
                    function7 = function4;
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242259229, "CC(remember):NotesListScreen.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new Function0() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function8 = (Function0) objRememberedValue3;
                    } else {
                        function8 = function3;
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242260733, "CC(remember):NotesListScreen.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return NotesListScreenKt.NotesListScreen$lambda$10$0((ItemId.Remote) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function4 = (Function1) objRememberedValue2;
                    }
                    if (i10 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242262397, "CC(remember):NotesListScreen.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return NotesListScreenKt.NotesListScreen$lambda$11$0((ItemId.Remote) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        function9 = (Function1) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function9 = function2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-266863461, i3, -1, "com.box.android.notes.presentation.ui.NotesListScreen (NotesListScreen.kt:189)");
                    }
                    PullToRefreshState pullToRefreshStateRememberPullToRefreshState117 = PullToRefreshKt.rememberPullToRefreshState(composerStartRestartGroup, 0);
                    Modifier modifierM5119pullToRefreshZ4HSEVQ$default117 = PullToRefreshKt.m5119pullToRefreshZ4HSEVQ$default(SizeKt.fillMaxHeight$default(modifier2, 0.0f, 1, null), z5, pullToRefreshStateRememberPullToRefreshState117, false, 0.0f, function8, 12, null);
                    boolean z1112 = z5;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy117 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode117 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap117 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier117 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM5119pullToRefreshZ4HSEVQ$default117);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    function10 = function9;
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
                    Composer composerM6062constructorimpl117 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl117, measurePolicyMaybeCachedBoxMeasurePolicy117, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl117, currentCompositionLocalMap117, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl117, Integer.valueOf(iHashCode117), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl117, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl117, modifierMaterializeModifier117, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance117 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 327999752, "C218@8669L6,219@8722L6,214@8479L277:NotesListScreen.kt#a1bbf8");
                    if (list.isEmpty()) {
                        composerStartRestartGroup.startReplaceGroup(328007594);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "201@8097L127");
                        EmptyItemsWithPullToRefreshWorkaroundKt.EmptyItemsList(itemsStateConfig, null, true, composerStartRestartGroup, ((i3 >> 3) & 14) | 384, 2);
                        composerStartRestartGroup.endReplaceGroup();
                        function11 = function4;
                        function12 = function10;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(328165756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "206@8254L205");
                        int i1119 = i3 >> 12;
                        Function1<? super ItemId.Remote, Unit> function1119 = function4;
                        NotesList(list, lazyListState2, function1119, function10, composerStartRestartGroup, (i3 & 14) | ((i3 >> 3) & 112) | (i1119 & 896) | (i1119 & 7168));
                        function11 = function1119;
                        function12 = function10;
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    PullToRefreshDefaults.INSTANCE.m5106Indicator2poqoh4(pullToRefreshStateRememberPullToRefreshState117, z1112, boxScopeInstance117.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopCenter()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11542getPopupBackground0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), 0.0f, composerStartRestartGroup, ((i3 >> 9) & 112) | (PullToRefreshDefaults.$stable << 18), 32);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function5 = function12;
                    modifier3 = modifier2;
                    z4 = z1112;
                    function6 = function8;
                    function7 = function11;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NotesListScreenKt.NotesListScreen$lambda$13(list, itemsStateConfig, lazyListState, modifier3, z4, function6, function7, function5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 12582912;
            if ((i3 & 4793491) != 4793490) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                function5 = function2;
                modifier3 = modifier2;
                z4 = z2;
                function6 = function3;
                function7 = function4;
            } else {
                if (i12 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
                if (i6 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242259229, "CC(remember):NotesListScreen.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function0() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function8 = (Function0) objRememberedValue3;
                } else {
                    function8 = function3;
                }
                if (i8 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242260733, "CC(remember):NotesListScreen.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return NotesListScreenKt.NotesListScreen$lambda$10$0((ItemId.Remote) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function4 = (Function1) objRememberedValue2;
                }
                if (i10 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242262397, "CC(remember):NotesListScreen.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return NotesListScreenKt.NotesListScreen$lambda$11$0((ItemId.Remote) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    function9 = (Function1) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    function9 = function2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-266863461, i3, -1, "com.box.android.notes.presentation.ui.NotesListScreen (NotesListScreen.kt:189)");
                }
                PullToRefreshState pullToRefreshStateRememberPullToRefreshState118 = PullToRefreshKt.rememberPullToRefreshState(composerStartRestartGroup, 0);
                Modifier modifierM5119pullToRefreshZ4HSEVQ$default118 = PullToRefreshKt.m5119pullToRefreshZ4HSEVQ$default(SizeKt.fillMaxHeight$default(modifier2, 0.0f, 1, null), z5, pullToRefreshStateRememberPullToRefreshState118, false, 0.0f, function8, 12, null);
                boolean z1113 = z5;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy118 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode118 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap118 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier118 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM5119pullToRefreshZ4HSEVQ$default118);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                function10 = function9;
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
                Composer composerM6062constructorimpl118 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl118, measurePolicyMaybeCachedBoxMeasurePolicy118, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl118, currentCompositionLocalMap118, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl118, Integer.valueOf(iHashCode118), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl118, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl118, modifierMaterializeModifier118, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance118 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 327999752, "C218@8669L6,219@8722L6,214@8479L277:NotesListScreen.kt#a1bbf8");
                if (list.isEmpty()) {
                    composerStartRestartGroup.startReplaceGroup(328007594);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "201@8097L127");
                    EmptyItemsWithPullToRefreshWorkaroundKt.EmptyItemsList(itemsStateConfig, null, true, composerStartRestartGroup, ((i3 >> 3) & 14) | 384, 2);
                    composerStartRestartGroup.endReplaceGroup();
                    function11 = function4;
                    function12 = function10;
                } else {
                    composerStartRestartGroup.startReplaceGroup(328165756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "206@8254L205");
                    int i11110 = i3 >> 12;
                    Function1<? super ItemId.Remote, Unit> function11110 = function4;
                    NotesList(list, lazyListState2, function11110, function10, composerStartRestartGroup, (i3 & 14) | ((i3 >> 3) & 112) | (i11110 & 896) | (i11110 & 7168));
                    function11 = function11110;
                    function12 = function10;
                    composerStartRestartGroup.endReplaceGroup();
                }
                PullToRefreshDefaults.INSTANCE.m5106Indicator2poqoh4(pullToRefreshStateRememberPullToRefreshState118, z1113, boxScopeInstance118.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopCenter()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11542getPopupBackground0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), 0.0f, composerStartRestartGroup, ((i3 >> 9) & 112) | (PullToRefreshDefaults.$stable << 18), 32);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function5 = function12;
                modifier3 = modifier2;
                z4 = z1113;
                function6 = function8;
                function7 = function11;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NotesListScreenKt.NotesListScreen$lambda$13(list, itemsStateConfig, lazyListState, modifier3, z4, function6, function7, function5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        function3 = function0;
        i8 = i2 & 64;
        if (i8 != 0) {
            if ((1572864 & i) == 0) {
                function4 = function1;
                if (composerStartRestartGroup.changedInstance(function4)) {
                    i9 = 1048576;
                } else {
                    i9 = 524288;
                }
                i3 |= i9;
            }
            i10 = i2 & 128;
            if (i10 != 0) {
                if ((i & 12582912) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i11 = 8388608;
                    } else {
                        i11 = 4194304;
                    }
                    i3 |= i11;
                }
                if ((i3 & 4793491) != 4793490) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    function5 = function2;
                    modifier3 = modifier2;
                    z4 = z2;
                    function6 = function3;
                    function7 = function4;
                } else {
                    if (i12 != 0) {
                        modifier2 = Modifier.INSTANCE;
                    }
                    if (i4 != 0) {
                        z5 = false;
                    } else {
                        z5 = z2;
                    }
                    if (i6 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242259229, "CC(remember):NotesListScreen.kt#9igjgp");
                        objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue3 = new Function0() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda3
                                @Override // kotlin.jvm.functions.Function0
                                public final Object invoke() {
                                    return Unit.INSTANCE;
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function8 = (Function0) objRememberedValue3;
                    } else {
                        function8 = function3;
                    }
                    if (i8 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242260733, "CC(remember):NotesListScreen.kt#9igjgp");
                        objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue2 = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda4
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return NotesListScreenKt.NotesListScreen$lambda$10$0((ItemId.Remote) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                        }
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                        function4 = (Function1) objRememberedValue2;
                    }
                    if (i10 != 0) {
                        ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242262397, "CC(remember):NotesListScreen.kt#9igjgp");
                        objRememberedValue = composerStartRestartGroup.rememberedValue();
                        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                            objRememberedValue = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda5
                                @Override // kotlin.jvm.functions.Function1
                                public final Object invoke(Object obj) {
                                    return NotesListScreenKt.NotesListScreen$lambda$11$0((ItemId.Remote) obj);
                                }
                            };
                            composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                        }
                        function9 = (Function1) objRememberedValue;
                        ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    } else {
                        function9 = function2;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-266863461, i3, -1, "com.box.android.notes.presentation.ui.NotesListScreen (NotesListScreen.kt:189)");
                    }
                    PullToRefreshState pullToRefreshStateRememberPullToRefreshState119 = PullToRefreshKt.rememberPullToRefreshState(composerStartRestartGroup, 0);
                    Modifier modifierM5119pullToRefreshZ4HSEVQ$default119 = PullToRefreshKt.m5119pullToRefreshZ4HSEVQ$default(SizeKt.fillMaxHeight$default(modifier2, 0.0f, 1, null), z5, pullToRefreshStateRememberPullToRefreshState119, false, 0.0f, function8, 12, null);
                    boolean z1114 = z5;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                    MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy119 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                    int iHashCode119 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                    CompositionLocalMap currentCompositionLocalMap119 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                    Modifier modifierMaterializeModifier119 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM5119pullToRefreshZ4HSEVQ$default119);
                    constructor = ComposeUiNode.INSTANCE.getConstructor();
                    function10 = function9;
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
                    Composer composerM6062constructorimpl119 = Updater.m6062constructorimpl(composerStartRestartGroup);
                    Updater.m6070setimpl(composerM6062constructorimpl119, measurePolicyMaybeCachedBoxMeasurePolicy119, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                    Updater.m6070setimpl(composerM6062constructorimpl119, currentCompositionLocalMap119, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                    Updater.m6066initimpl(composerM6062constructorimpl119, Integer.valueOf(iHashCode119), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                    Updater.m6068reconcileimpl(composerM6062constructorimpl119, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                    Updater.m6070setimpl(composerM6062constructorimpl119, modifierMaterializeModifier119, ComposeUiNode.INSTANCE.getSetModifier());
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                    BoxScopeInstance boxScopeInstance119 = BoxScopeInstance.INSTANCE;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 327999752, "C218@8669L6,219@8722L6,214@8479L277:NotesListScreen.kt#a1bbf8");
                    if (list.isEmpty()) {
                        composerStartRestartGroup.startReplaceGroup(328007594);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "201@8097L127");
                        EmptyItemsWithPullToRefreshWorkaroundKt.EmptyItemsList(itemsStateConfig, null, true, composerStartRestartGroup, ((i3 >> 3) & 14) | 384, 2);
                        composerStartRestartGroup.endReplaceGroup();
                        function11 = function4;
                        function12 = function10;
                    } else {
                        composerStartRestartGroup.startReplaceGroup(328165756);
                        ComposerKt.sourceInformation(composerStartRestartGroup, "206@8254L205");
                        int i11111 = i3 >> 12;
                        Function1<? super ItemId.Remote, Unit> function11111 = function4;
                        NotesList(list, lazyListState2, function11111, function10, composerStartRestartGroup, (i3 & 14) | ((i3 >> 3) & 112) | (i11111 & 896) | (i11111 & 7168));
                        function11 = function11111;
                        function12 = function10;
                        composerStartRestartGroup.endReplaceGroup();
                    }
                    PullToRefreshDefaults.INSTANCE.m5106Indicator2poqoh4(pullToRefreshStateRememberPullToRefreshState119, z1114, boxScopeInstance119.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopCenter()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11542getPopupBackground0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), 0.0f, composerStartRestartGroup, ((i3 >> 9) & 112) | (PullToRefreshDefaults.$stable << 18), 32);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup.endNode();
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    function5 = function12;
                    modifier3 = modifier2;
                    z4 = z1114;
                    function6 = function8;
                    function7 = function11;
                }
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda6
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NotesListScreenKt.NotesListScreen$lambda$13(list, itemsStateConfig, lazyListState, modifier3, z4, function6, function7, function5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 12582912;
            if ((i3 & 4793491) != 4793490) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                function5 = function2;
                modifier3 = modifier2;
                z4 = z2;
                function6 = function3;
                function7 = function4;
            } else {
                if (i12 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
                if (i6 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242259229, "CC(remember):NotesListScreen.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function0() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function8 = (Function0) objRememberedValue3;
                } else {
                    function8 = function3;
                }
                if (i8 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242260733, "CC(remember):NotesListScreen.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return NotesListScreenKt.NotesListScreen$lambda$10$0((ItemId.Remote) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function4 = (Function1) objRememberedValue2;
                }
                if (i10 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242262397, "CC(remember):NotesListScreen.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return NotesListScreenKt.NotesListScreen$lambda$11$0((ItemId.Remote) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    function9 = (Function1) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    function9 = function2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-266863461, i3, -1, "com.box.android.notes.presentation.ui.NotesListScreen (NotesListScreen.kt:189)");
                }
                PullToRefreshState pullToRefreshStateRememberPullToRefreshState1110 = PullToRefreshKt.rememberPullToRefreshState(composerStartRestartGroup, 0);
                Modifier modifierM5119pullToRefreshZ4HSEVQ$default1110 = PullToRefreshKt.m5119pullToRefreshZ4HSEVQ$default(SizeKt.fillMaxHeight$default(modifier2, 0.0f, 1, null), z5, pullToRefreshStateRememberPullToRefreshState1110, false, 0.0f, function8, 12, null);
                boolean z1115 = z5;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy1110 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode1110 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap1110 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier1110 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM5119pullToRefreshZ4HSEVQ$default1110);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                function10 = function9;
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
                Composer composerM6062constructorimpl1110 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl1110, measurePolicyMaybeCachedBoxMeasurePolicy1110, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl1110, currentCompositionLocalMap1110, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl1110, Integer.valueOf(iHashCode1110), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl1110, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl1110, modifierMaterializeModifier1110, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance1110 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 327999752, "C218@8669L6,219@8722L6,214@8479L277:NotesListScreen.kt#a1bbf8");
                if (list.isEmpty()) {
                    composerStartRestartGroup.startReplaceGroup(328007594);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "201@8097L127");
                    EmptyItemsWithPullToRefreshWorkaroundKt.EmptyItemsList(itemsStateConfig, null, true, composerStartRestartGroup, ((i3 >> 3) & 14) | 384, 2);
                    composerStartRestartGroup.endReplaceGroup();
                    function11 = function4;
                    function12 = function10;
                } else {
                    composerStartRestartGroup.startReplaceGroup(328165756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "206@8254L205");
                    int i11112 = i3 >> 12;
                    Function1<? super ItemId.Remote, Unit> function11112 = function4;
                    NotesList(list, lazyListState2, function11112, function10, composerStartRestartGroup, (i3 & 14) | ((i3 >> 3) & 112) | (i11112 & 896) | (i11112 & 7168));
                    function11 = function11112;
                    function12 = function10;
                    composerStartRestartGroup.endReplaceGroup();
                }
                PullToRefreshDefaults.INSTANCE.m5106Indicator2poqoh4(pullToRefreshStateRememberPullToRefreshState1110, z1115, boxScopeInstance1110.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopCenter()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11542getPopupBackground0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), 0.0f, composerStartRestartGroup, ((i3 >> 9) & 112) | (PullToRefreshDefaults.$stable << 18), 32);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function5 = function12;
                modifier3 = modifier2;
                z4 = z1115;
                function6 = function8;
                function7 = function11;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NotesListScreenKt.NotesListScreen$lambda$13(list, itemsStateConfig, lazyListState, modifier3, z4, function6, function7, function5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 1572864;
        function4 = function1;
        i10 = i2 & 128;
        if (i10 != 0) {
            if ((i & 12582912) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i11 = 8388608;
                } else {
                    i11 = 4194304;
                }
                i3 |= i11;
            }
            if ((i3 & 4793491) != 4793490) {
                z3 = true;
            } else {
                z3 = false;
            }
            if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                function5 = function2;
                modifier3 = modifier2;
                z4 = z2;
                function6 = function3;
                function7 = function4;
            } else {
                if (i12 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (i4 != 0) {
                    z5 = false;
                } else {
                    z5 = z2;
                }
                if (i6 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242259229, "CC(remember):NotesListScreen.kt#9igjgp");
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function0() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda3
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return Unit.INSTANCE;
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function8 = (Function0) objRememberedValue3;
                } else {
                    function8 = function3;
                }
                if (i8 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242260733, "CC(remember):NotesListScreen.kt#9igjgp");
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda4
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return NotesListScreenKt.NotesListScreen$lambda$10$0((ItemId.Remote) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function4 = (Function1) objRememberedValue2;
                }
                if (i10 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242262397, "CC(remember):NotesListScreen.kt#9igjgp");
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda5
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return NotesListScreenKt.NotesListScreen$lambda$11$0((ItemId.Remote) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    function9 = (Function1) objRememberedValue;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                } else {
                    function9 = function2;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-266863461, i3, -1, "com.box.android.notes.presentation.ui.NotesListScreen (NotesListScreen.kt:189)");
                }
                PullToRefreshState pullToRefreshStateRememberPullToRefreshState1111 = PullToRefreshKt.rememberPullToRefreshState(composerStartRestartGroup, 0);
                Modifier modifierM5119pullToRefreshZ4HSEVQ$default1111 = PullToRefreshKt.m5119pullToRefreshZ4HSEVQ$default(SizeKt.fillMaxHeight$default(modifier2, 0.0f, 1, null), z5, pullToRefreshStateRememberPullToRefreshState1111, false, 0.0f, function8, 12, null);
                boolean z1116 = z5;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy1111 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode1111 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
                CompositionLocalMap currentCompositionLocalMap1111 = composerStartRestartGroup.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier1111 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM5119pullToRefreshZ4HSEVQ$default1111);
                constructor = ComposeUiNode.INSTANCE.getConstructor();
                function10 = function9;
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
                Composer composerM6062constructorimpl1111 = Updater.m6062constructorimpl(composerStartRestartGroup);
                Updater.m6070setimpl(composerM6062constructorimpl1111, measurePolicyMaybeCachedBoxMeasurePolicy1111, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl1111, currentCompositionLocalMap1111, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl1111, Integer.valueOf(iHashCode1111), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl1111, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl1111, modifierMaterializeModifier1111, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance1111 = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 327999752, "C218@8669L6,219@8722L6,214@8479L277:NotesListScreen.kt#a1bbf8");
                if (list.isEmpty()) {
                    composerStartRestartGroup.startReplaceGroup(328007594);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "201@8097L127");
                    EmptyItemsWithPullToRefreshWorkaroundKt.EmptyItemsList(itemsStateConfig, null, true, composerStartRestartGroup, ((i3 >> 3) & 14) | 384, 2);
                    composerStartRestartGroup.endReplaceGroup();
                    function11 = function4;
                    function12 = function10;
                } else {
                    composerStartRestartGroup.startReplaceGroup(328165756);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "206@8254L205");
                    int i11113 = i3 >> 12;
                    Function1<? super ItemId.Remote, Unit> function11113 = function4;
                    NotesList(list, lazyListState2, function11113, function10, composerStartRestartGroup, (i3 & 14) | ((i3 >> 3) & 112) | (i11113 & 896) | (i11113 & 7168));
                    function11 = function11113;
                    function12 = function10;
                    composerStartRestartGroup.endReplaceGroup();
                }
                PullToRefreshDefaults.INSTANCE.m5106Indicator2poqoh4(pullToRefreshStateRememberPullToRefreshState1111, z1116, boxScopeInstance1111.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopCenter()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11542getPopupBackground0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), 0.0f, composerStartRestartGroup, ((i3 >> 9) & 112) | (PullToRefreshDefaults.$stable << 18), 32);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup.endNode();
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                function5 = function12;
                modifier3 = modifier2;
                z4 = z1116;
                function6 = function8;
                function7 = function11;
            }
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NotesListScreenKt.NotesListScreen$lambda$13(list, itemsStateConfig, lazyListState, modifier3, z4, function6, function7, function5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 12582912;
        if ((i3 & 4793491) != 4793490) {
            z3 = true;
        } else {
            z3 = false;
        }
        if (composerStartRestartGroup.shouldExecute(z3, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            function5 = function2;
            modifier3 = modifier2;
            z4 = z2;
            function6 = function3;
            function7 = function4;
        } else {
            if (i12 != 0) {
                modifier2 = Modifier.INSTANCE;
            }
            if (i4 != 0) {
                z5 = false;
            } else {
                z5 = z2;
            }
            if (i6 != 0) {
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242259229, "CC(remember):NotesListScreen.kt#9igjgp");
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function0() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda3
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return Unit.INSTANCE;
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                function8 = (Function0) objRememberedValue3;
            } else {
                function8 = function3;
            }
            if (i8 != 0) {
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242260733, "CC(remember):NotesListScreen.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda4
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return NotesListScreenKt.NotesListScreen$lambda$10$0((ItemId.Remote) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                function4 = (Function1) objRememberedValue2;
            }
            if (i10 != 0) {
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1242262397, "CC(remember):NotesListScreen.kt#9igjgp");
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda5
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return NotesListScreenKt.NotesListScreen$lambda$11$0((ItemId.Remote) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                function9 = (Function1) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            } else {
                function9 = function2;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-266863461, i3, -1, "com.box.android.notes.presentation.ui.NotesListScreen (NotesListScreen.kt:189)");
            }
            PullToRefreshState pullToRefreshStateRememberPullToRefreshState1112 = PullToRefreshKt.rememberPullToRefreshState(composerStartRestartGroup, 0);
            Modifier modifierM5119pullToRefreshZ4HSEVQ$default1112 = PullToRefreshKt.m5119pullToRefreshZ4HSEVQ$default(SizeKt.fillMaxHeight$default(modifier2, 0.0f, 1, null), z5, pullToRefreshStateRememberPullToRefreshState1112, false, 0.0f, function8, 12, null);
            boolean z1117 = z5;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy1112 = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode1112 = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composerStartRestartGroup, 0));
            CompositionLocalMap currentCompositionLocalMap1112 = composerStartRestartGroup.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier1112 = ComposedModifierKt.materializeModifier(composerStartRestartGroup, modifierM5119pullToRefreshZ4HSEVQ$default1112);
            constructor = ComposeUiNode.INSTANCE.getConstructor();
            function10 = function9;
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
            Composer composerM6062constructorimpl1112 = Updater.m6062constructorimpl(composerStartRestartGroup);
            Updater.m6070setimpl(composerM6062constructorimpl1112, measurePolicyMaybeCachedBoxMeasurePolicy1112, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl1112, currentCompositionLocalMap1112, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl1112, Integer.valueOf(iHashCode1112), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl1112, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl1112, modifierMaterializeModifier1112, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance1112 = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 327999752, "C218@8669L6,219@8722L6,214@8479L277:NotesListScreen.kt#a1bbf8");
            if (list.isEmpty()) {
                composerStartRestartGroup.startReplaceGroup(328007594);
                ComposerKt.sourceInformation(composerStartRestartGroup, "201@8097L127");
                EmptyItemsWithPullToRefreshWorkaroundKt.EmptyItemsList(itemsStateConfig, null, true, composerStartRestartGroup, ((i3 >> 3) & 14) | 384, 2);
                composerStartRestartGroup.endReplaceGroup();
                function11 = function4;
                function12 = function10;
            } else {
                composerStartRestartGroup.startReplaceGroup(328165756);
                ComposerKt.sourceInformation(composerStartRestartGroup, "206@8254L205");
                int i11114 = i3 >> 12;
                Function1<? super ItemId.Remote, Unit> function11114 = function4;
                NotesList(list, lazyListState2, function11114, function10, composerStartRestartGroup, (i3 & 14) | ((i3 >> 3) & 112) | (i11114 & 896) | (i11114 & 7168));
                function11 = function11114;
                function12 = function10;
                composerStartRestartGroup.endReplaceGroup();
            }
            PullToRefreshDefaults.INSTANCE.m5106Indicator2poqoh4(pullToRefreshStateRememberPullToRefreshState1112, z1117, boxScopeInstance1112.align(Modifier.INSTANCE, Alignment.INSTANCE.getTopCenter()), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11542getPopupBackground0d7_KjU(), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), 0.0f, composerStartRestartGroup, ((i3 >> 9) & 112) | (PullToRefreshDefaults.$stable << 18), 32);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup.endNode();
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            function5 = function12;
            modifier3 = modifier2;
            z4 = z1117;
            function6 = function8;
            function7 = function11;
        }
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NotesListScreenKt.NotesListScreen$lambda$13(list, itemsStateConfig, lazyListState, modifier3, z4, function6, function7, function5, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void NotesList(final List<NotesItemViewData> list, final LazyListState lazyListState, final Function1<? super ItemId.Remote, Unit> function1, final Function1<? super ItemId.Remote, Unit> function2, Composer composer, final int i) {
        int i2;
        LazyListState lazyListState2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1819752875);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NotesList)N(noteItems,lazyListState,onItemClick,onToggleFavorite)234@9071L6,237@9220L734,231@8971L983:NotesListScreen.kt#a1bbf8");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(list) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            lazyListState2 = lazyListState;
            i2 |= composerStartRestartGroup.changed(lazyListState2) ? 32 : 16;
        } else {
            lazyListState2 = lazyListState;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 2048 : 1024;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 1171) != 1170, i2 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1819752875, i2, -1, "com.box.android.notes.presentation.ui.NotesList (NotesListScreen.kt:230)");
            }
            Modifier modifierM589backgroundbw27NRU$default = BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11498getAppBackground0d7_KjU(), null, 2, null);
            PaddingValues paddingValuesM1215PaddingValuesa9UjIt4$default = PaddingKt.m1215PaddingValuesa9UjIt4$default(0.0f, 0.0f, 0.0f, BoxTheme.INSTANCE.getSizes().m11611getListContentBottomPaddingD9Ej5fM(), 7, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -730808781, "CC(remember):NotesListScreen.kt#9igjgp");
            boolean zChangedInstance = ((i2 & 896) == 256) | composerStartRestartGroup.changedInstance(list) | ((i2 & 7168) == 2048);
            Object objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NotesListScreenKt.NotesList$lambda$0$0(list, function1, function2, (LazyListScope) obj);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composer2 = composerStartRestartGroup;
            LazyDslKt.LazyColumn(modifierM589backgroundbw27NRU$default, lazyListState2, paddingValuesM1215PaddingValuesa9UjIt4$default, false, null, null, null, false, null, (Function1) objRememberedValue, composer2, i2 & 112, 504);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda10
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NotesListScreenKt.NotesList$lambda$1(list, lazyListState, function1, function2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotesList$lambda$0$0(final List list, final Function1 function1, final Function1 function2, LazyListScope LazyColumn) {
        Intrinsics.checkNotNullParameter(LazyColumn, "$this$LazyColumn");
        final Function2 function3 = new Function2() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda2
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return NotesListScreenKt.NotesList$lambda$0$0$0(((Integer) obj).intValue(), (NotesItemViewData) obj2);
            }
        };
        LazyColumn.items(list.size(), new Function1<Integer, Object>() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$NotesList$lambda$0$0$$inlined$itemsIndexed$default$1
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                return function3.invoke(Integer.valueOf(i), list.get(i));
            }
        }, new Function1<Integer, Object>() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$NotesList$lambda$0$0$$inlined$itemsIndexed$default$2
            @Override // kotlin.jvm.functions.Function1
            public /* bridge */ /* synthetic */ Object invoke(Integer num) {
                return invoke(num.intValue());
            }

            public final Object invoke(int i) {
                list.get(i);
                return null;
            }
        }, ComposableLambdaKt.composableLambdaInstance(2039820996, true, new Function4<LazyItemScope, Integer, Composer, Integer, Unit>() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$NotesList$lambda$0$0$$inlined$itemsIndexed$default$3
            @Override // kotlin.jvm.functions.Function4
            public /* bridge */ /* synthetic */ Unit invoke(LazyItemScope lazyItemScope, Integer num, Composer composer, Integer num2) {
                invoke(lazyItemScope, num.intValue(), composer, num2.intValue());
                return Unit.INSTANCE;
            }

            public final void invoke(LazyItemScope lazyItemScope, int i, Composer composer, int i2) {
                int i3;
                ComposerKt.sourceInformation(composer, "CN(it)214@10668L26:LazyDsl.kt#428nma");
                if ((i2 & 6) == 0) {
                    i3 = i2 | (composer.changed(lazyItemScope) ? 4 : 2);
                } else {
                    i3 = i2;
                }
                if ((i2 & 48) == 0) {
                    i3 |= composer.changed(i) ? 32 : 16;
                }
                if (!composer.shouldExecute((i3 & Token.DOTQUERY) != 146, i3 & 1)) {
                    composer.skipToGroupEnd();
                    return;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(2039820996, i3, -1, "androidx.compose.foundation.lazy.itemsIndexed.<anonymous> (LazyDsl.kt:214)");
                }
                final NotesItemViewData notesItemViewData = (NotesItemViewData) list.get(i);
                composer.startReplaceGroup(-1997469859);
                ComposerKt.sourceInformation(composer, "CN(index,item)*239@9319L619:NotesListScreen.kt#a1bbf8");
                Modifier modifierAnimateItem$default = LazyItemScope.animateItem$default(lazyItemScope, Modifier.INSTANCE, null, null, null, 7, null);
                Alignment bottomStart = Alignment.INSTANCE.getBottomStart();
                ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
                MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(bottomStart, false);
                ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
                int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
                CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
                Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierAnimateItem$default);
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
                Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
                Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
                Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
                Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
                Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
                ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
                BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composer, 1889829506, "C245@9538L24,246@9602L29,243@9464L185:NotesListScreen.kt#a1bbf8");
                ComposerKt.sourceInformationMarkerStart(composer, -1047414483, "CC(remember):NotesListScreen.kt#9igjgp");
                boolean zChanged = composer.changed(function1) | composer.changedInstance(notesItemViewData);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    final Function1 function4 = function1;
                    objRememberedValue = (Function0) new Function0<Unit>() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$NotesList$1$1$2$1$1$1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            function4.invoke(notesItemViewData.getId());
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                Function0 function0 = (Function0) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, -1047412430, "CC(remember):NotesListScreen.kt#9igjgp");
                boolean zChanged2 = composer.changed(function2) | composer.changedInstance(notesItemViewData);
                Object objRememberedValue2 = composer.rememberedValue();
                if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    final Function1 function5 = function2;
                    objRememberedValue2 = (Function0) new Function0<Unit>() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$NotesList$1$1$2$1$2$1
                        @Override // kotlin.jvm.functions.Function0
                        public /* bridge */ /* synthetic */ Unit invoke() {
                            invoke2();
                            return Unit.INSTANCE;
                        }

                        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
                        public final void invoke2() {
                            function5.invoke(notesItemViewData.getId());
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                NotesItemKt.NotesItem(notesItemViewData, function0, (Function0) objRememberedValue2, null, composer, 0, 8);
                if (i == CollectionsKt.getLastIndex(list)) {
                    composer.startReplaceGroup(1880425965);
                } else {
                    composer.startReplaceGroup(1890057262);
                    ComposerKt.sourceInformation(composer, "252@9859L6,250@9723L183");
                    BoxHorizontalDividerKt.m11724BoxHorizontalDivider9IZ8Weo(PaddingKt.m1220paddingVpY3zN4$default(Modifier.INSTANCE, Dp.m9687constructorimpl(16), 0.0f, 2, null), 0.0f, BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11532getItemListingDivider0d7_KjU(), composer, 6, 2);
                }
                composer.endReplaceGroup();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endNode();
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerEnd(composer);
                composer.endReplaceGroup();
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
            }
        }));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Object NotesList$lambda$0$0$0(int i, NotesItemViewData item) {
        Intrinsics.checkNotNullParameter(item, "item");
        return item.getId().getBoxId();
    }

    private static final void NotesListScreenPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(696738266);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NotesListScreenPreview)294@11157L479,294@11148L488:NotesListScreen.kt#a1bbf8");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(696738266, i, -1, "com.box.android.notes.presentation.ui.NotesListScreenPreview (NotesListScreen.kt:265)");
            }
            final List listListOf = CollectionsKt.listOf((Object[]) new NotesItemViewData[]{new NotesItemViewData(new ItemId.Remote("preview-1", ItemType.FILE), "Meeting Notes", "Edited 10 min ago by John Appleased", "Product Planning", false, true, null, 64, null), new NotesItemViewData(new ItemId.Remote("preview-2", ItemType.FILE), "Project Ideas", "Edited 1 min ago by Jane Doe", "Files", false, true, NoteReadStatus.UNREAD), new NotesItemViewData(new ItemId.Remote("preview-3", ItemType.FILE), "Weekly Standup", "Sam Smith is editing...", "Marketing", true, true, NoteReadStatus.TYPING)});
            BoxThemeKt.BoxTheme(ComposableLambdaKt.rememberComposableLambda(1912378287, true, new Function2() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NotesListScreenKt.NotesListScreenPreview$lambda$0(listListOf, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NotesListScreenKt.NotesListScreenPreview$lambda$1(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotesListScreenPreview$lambda$0(List list, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C295@11200L6,295@11167L463:NotesListScreen.kt#a1bbf8");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1912378287, i, -1, "com.box.android.notes.presentation.ui.NotesListScreenPreview.<anonymous> (NotesListScreen.kt:295)");
            }
            Modifier modifierM589backgroundbw27NRU$default = BackgroundKt.m589backgroundbw27NRU$default(Modifier.INSTANCE, BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11498getAppBackground0d7_KjU(), null, 2, null);
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM589backgroundbw27NRU$default);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -2061550821, "C298@11325L23,296@11237L383:NotesListScreen.kt#a1bbf8");
            NotesListScreen(list, new ItemsStateConfig(com.box.android.notes.R.drawable.ic_folderfloat140, "No recent notes", "Notes you view or edit will appear here", null, 8, null), LazyListStateKt.rememberLazyListState(0, 0, composer, 0, 3), null, false, null, null, null, composer, 0, 248);
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

    private static final void NotesListScreenEmptyPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-589557273);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NotesListScreenEmptyPreview)313@11745L490:NotesListScreen.kt#a1bbf8");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-589557273, i, -1, "com.box.android.notes.presentation.ui.NotesListScreenEmptyPreview (NotesListScreen.kt:312)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$NotesListScreenKt.INSTANCE.m12781getLambda$1636451022$notes_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.notes.presentation.ui.NotesListScreenKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NotesListScreenKt.NotesListScreenEmptyPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NotesListReducer.State NotesListScreen$lambda$0(State<NotesListReducer.State> state) {
        return state.getValue();
    }

    private static final long NotesListScreen$lambda$1(State<Long> state) {
        return state.getValue().longValue();
    }
}

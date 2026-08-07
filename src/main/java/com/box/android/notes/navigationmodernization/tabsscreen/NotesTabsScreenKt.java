package com.box.android.notes.navigationmodernization.tabsscreen;

import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.material3.SnackbarData;
import androidx.compose.material3.SnackbarHostState;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.internal.ComposableLambda;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.painter.Painter;
import androidx.compose.ui.input.nestedscroll.NestedScrollDispatcher;
import androidx.compose.ui.input.nestedscroll.NestedScrollModifierKt;
import androidx.compose.ui.layout.OnVisibilityChangedModifierKt;
import androidx.compose.ui.platform.TestTagKt;
import androidx.compose.ui.res.PainterResources_androidKt;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.lifecycle.compose.LifecycleEffectKt;
import androidx.profileinstaller.ProfileVerifier;
import com.box.android.base.compose.ItemsStateConfig;
import com.box.android.base.compose.ScaffoldWithCollapsingTopBarKt;
import com.box.android.base.compose.analytics.AnalyticsUtilsKt;
import com.box.android.base.compose.button.fab.BoxFabButtonKt;
import com.box.android.base.compose.button.fab.ScrollAwareFabVisibility;
import com.box.android.base.compose.button.fab.ScrollAwareFabVisibilityKt;
import com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt;
import com.box.android.base.presentation.components.topbar.BoxPrimaryTopBarKt;
import com.box.android.base.presentation.components.topbar.CenterSpaceConfig;
import com.box.android.base.presentation.components.topbar.SearchButtonConfig;
import com.box.android.base.presentation.components.topbar.SettingsButtonConfig;
import com.box.android.base.presentation.components.topbar.component.settings.UserAvatarViewModel;
import com.box.android.cpl.Store;
import com.box.android.domain.models.item.ItemModel;
import com.box.android.notes.R;
import com.box.android.notes.navigationmodernization.NotesDestination;
import com.box.android.notes.navigationmodernization.NotesNavigator;
import com.box.android.notes.presentation.cpl.NotesFavoritesViewModel;
import com.box.android.notes.presentation.cpl.NotesListReducer;
import com.box.android.notes.presentation.cpl.NotesRecentsViewModel;
import com.box.android.notes.presentation.ui.NotesListScreenKt;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import sdk.pendo.io.events.ComposeIdentificationData;

/* JADX INFO: compiled from: NotesTabsScreen.kt */
/* JADX INFO: loaded from: classes12.dex */
@Metadata(d1 = {"\u0000|\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\u001a}\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u00010\f2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0014\b\u0002\u0010\u0012\u001a\u000e\u0012\u0004\u0012\u00020\u0013\u0012\u0004\u0012\u00020\u00010\tH\u0007¢\u0006\u0002\u0010\u0014\u001ak\u0010\u0015\u001a\u00020\u00012\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u00010\f2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u00010\tH\u0003¢\u0006\u0002\u0010\u001e\u001aW\u0010\u001f\u001a\u00020\u00012\u0006\u0010 \u001a\u00020!2\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t2\u0006\u0010\u000e\u001a\u00020\u000f2\f\u0010\"\u001a\b\u0012\u0004\u0012\u00020\u00010\fH\u0003¢\u0006\u0002\u0010#\u001a\u001d\u0010$\u001a\u00020%2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020'H\u0003¢\u0006\u0002\u0010)\u001a3\u0010*\u001a\u00020\u00112\u0006\u0010+\u001a\u00020\u00132\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u00192\f\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00010\fH\u0003¢\u0006\u0002\u0010-\u001ao\u0010.\u001a\u00020\u00012\u0012\u0010/\u001a\u000e\u0012\u0004\u0012\u000201\u0012\u0004\u0012\u000202002\u0006\u00103\u001a\u00020%2\u0006\u0010\u0006\u001a\u00020\u00072\u0012\u0010\b\u001a\u000e\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u00010\t2\u0006\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\u0016\b\u0002\u0010\u001c\u001a\u0010\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u0001\u0018\u00010\tH\u0003¢\u0006\u0002\u00104\u001a\f\u00105\u001a\u00020'*\u00020\u0019H\u0002¨\u00066²\u0006\n\u00107\u001a\u000201X\u008a\u0084\u0002²\u0006\n\u0010\u0018\u001a\u00020\u0019X\u008a\u008e\u0002²\u0006\n\u00108\u001a\u00020\u001dX\u008a\u008e\u0002²\u0006\n\u00109\u001a\u000201X\u008a\u0084\u0002"}, d2 = {"NotesTabsScreen", "", "tabDestination", "Lcom/box/android/notes/navigationmodernization/NotesDestination$InnerDestination$TabsScreen;", "tabsViewModels", "Lcom/box/android/notes/navigationmodernization/tabsscreen/NotesTabsViewModels;", "navigator", "Lcom/box/android/notes/navigationmodernization/NotesNavigator;", "onNavigateToNote", "Lkotlin/Function1;", "Lcom/box/android/domain/models/item/ItemModel;", "onNavigateToSearch", "Lkotlin/Function0;", "onNavigateToSettings", "snackbarHostState", "Landroidx/compose/material3/SnackbarHostState;", "modifier", "Landroidx/compose/ui/Modifier;", "onInnerTabChanged", "", "(Lcom/box/android/notes/navigationmodernization/NotesDestination$InnerDestination$TabsScreen;Lcom/box/android/notes/navigationmodernization/tabsscreen/NotesTabsViewModels;Lcom/box/android/notes/navigationmodernization/NotesNavigator;Lkotlin/jvm/functions/Function1;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/material3/SnackbarHostState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "RecentsTabScreen", "recentsViewModel", "Lcom/box/android/notes/presentation/cpl/NotesRecentsViewModel;", "currentVisibleTab", "Lcom/box/android/notes/navigationmodernization/NotesDestination$InnerDestination$TabsScreen$NotesTab;", "tab", "onRecentsTabViewed", "onFullyVisibleChanged", "", "(Lcom/box/android/notes/presentation/cpl/NotesRecentsViewModel;Lcom/box/android/notes/navigationmodernization/NotesDestination$InnerDestination$TabsScreen$NotesTab;Lcom/box/android/notes/navigationmodernization/NotesDestination$InnerDestination$TabsScreen$NotesTab;Lcom/box/android/notes/navigationmodernization/NotesNavigator;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/SnackbarHostState;Lkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;I)V", "FavoritesTabScreen", "favoritesViewModel", "Lcom/box/android/notes/presentation/cpl/NotesFavoritesViewModel;", "onFavoritesTabViewed", "(Lcom/box/android/notes/presentation/cpl/NotesFavoritesViewModel;Lcom/box/android/notes/navigationmodernization/NotesDestination$InnerDestination$TabsScreen$NotesTab;Lcom/box/android/notes/navigationmodernization/NotesDestination$InnerDestination$TabsScreen$NotesTab;Lcom/box/android/notes/navigationmodernization/NotesNavigator;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/SnackbarHostState;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)V", "notesEmptyScreenConfig", "Lcom/box/android/base/compose/ItemsStateConfig;", "titleRes", "", "subtitleRes", "(IILandroidx/compose/runtime/Composer;I)Lcom/box/android/base/compose/ItemsStateConfig;", "notesTabScreenModifier", ComposeIdentificationData.FIELD_TEST_TAG_HASHED, "onTabViewed", "(Ljava/lang/String;Lcom/box/android/notes/navigationmodernization/NotesDestination$InnerDestination$TabsScreen$NotesTab;Lcom/box/android/notes/navigationmodernization/NotesDestination$InnerDestination$TabsScreen$NotesTab;Lkotlin/jvm/functions/Function0;Landroidx/compose/runtime/Composer;I)Landroidx/compose/ui/Modifier;", "NotesTabContentScreen", "store", "Lcom/box/android/cpl/Store;", "Lcom/box/android/notes/presentation/cpl/NotesListReducer$State;", "Lcom/box/android/notes/presentation/cpl/NotesListReducer$Action;", "emptyScreenConfig", "(Lcom/box/android/cpl/Store;Lcom/box/android/base/compose/ItemsStateConfig;Lcom/box/android/notes/navigationmodernization/NotesNavigator;Lkotlin/jvm/functions/Function1;Landroidx/compose/material3/SnackbarHostState;Landroidx/compose/ui/Modifier;Lkotlin/jvm/functions/Function1;Landroidx/compose/runtime/Composer;II)V", "getTitleRes", "notes_generalProdRelease", "recentsState", "isRecentsTabFullyVisible", "state"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class NotesTabsScreenKt {

    /* JADX INFO: compiled from: NotesTabsScreen.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[NotesDestination.InnerDestination.TabsScreen.NotesTab.values().length];
            try {
                iArr[NotesDestination.InnerDestination.TabsScreen.NotesTab.RecentsTab.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[NotesDestination.InnerDestination.TabsScreen.NotesTab.FavoritesTab.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit FavoritesTabScreen$lambda$0(NotesFavoritesViewModel notesFavoritesViewModel, NotesDestination.InnerDestination.TabsScreen.NotesTab notesTab, NotesDestination.InnerDestination.TabsScreen.NotesTab notesTab2, NotesNavigator notesNavigator, Function1 function1, SnackbarHostState snackbarHostState, Function0 function0, int i, Composer composer, int i2) {
        FavoritesTabScreen(notesFavoritesViewModel, notesTab, notesTab2, notesNavigator, function1, snackbarHostState, function0, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotesTabContentScreen$lambda$5(Store store, ItemsStateConfig itemsStateConfig, NotesNavigator notesNavigator, Function1 function1, SnackbarHostState snackbarHostState, Modifier modifier, Function1 function2, int i, int i2, Composer composer, int i3) {
        NotesTabContentScreen(store, itemsStateConfig, notesNavigator, function1, snackbarHostState, modifier, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotesTabsScreen$lambda$12(NotesDestination.InnerDestination.TabsScreen tabsScreen, NotesTabsViewModels notesTabsViewModels, NotesNavigator notesNavigator, Function1 function1, Function0 function0, Function0 function2, SnackbarHostState snackbarHostState, Modifier modifier, Function1 function3, int i, int i2, Composer composer, int i3) {
        NotesTabsScreen(tabsScreen, notesTabsViewModels, notesNavigator, function1, function0, function2, snackbarHostState, modifier, function3, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit RecentsTabScreen$lambda$0(NotesRecentsViewModel notesRecentsViewModel, NotesDestination.InnerDestination.TabsScreen.NotesTab notesTab, NotesDestination.InnerDestination.TabsScreen.NotesTab notesTab2, NotesNavigator notesNavigator, Function1 function1, SnackbarHostState snackbarHostState, Function0 function0, Function1 function2, int i, Composer composer, int i2) {
        RecentsTabScreen(notesRecentsViewModel, notesTab, notesTab2, notesNavigator, function1, snackbarHostState, function0, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final boolean notesTabScreenModifier$lambda$0$0(NotesDestination.InnerDestination.TabsScreen.NotesTab notesTab, NotesDestination.InnerDestination.TabsScreen.NotesTab notesTab2) {
        return notesTab == notesTab2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotesTabsScreen$lambda$0$0(String it) {
        Intrinsics.checkNotNullParameter(it, "it");
        return Unit.INSTANCE;
    }

    /* JADX WARN: Code duplicated, block: B:104:0x020d  */
    /* JADX WARN: Code duplicated, block: B:107:0x0288  */
    /* JADX WARN: Code duplicated, block: B:109:0x028e  */
    /* JADX WARN: Code duplicated, block: B:112:0x029a  */
    /* JADX WARN: Code duplicated, block: B:114:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:65:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:66:0x00dc  */
    /* JADX WARN: Code duplicated, block: B:68:0x00e2  */
    /* JADX WARN: Code duplicated, block: B:70:0x00e8  */
    /* JADX WARN: Code duplicated, block: B:71:0x00eb  */
    /* JADX WARN: Code duplicated, block: B:75:0x00fa  */
    /* JADX WARN: Code duplicated, block: B:76:0x00fc  */
    /* JADX WARN: Code duplicated, block: B:79:0x0105 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:80:0x0107  */
    /* JADX WARN: Code duplicated, block: B:81:0x010c  */
    /* JADX WARN: Code duplicated, block: B:84:0x0111  */
    /* JADX WARN: Code duplicated, block: B:86:0x0123  */
    /* JADX WARN: Code duplicated, block: B:90:0x0136  */
    /* JADX WARN: Code duplicated, block: B:95:0x019e  */
    /* JADX WARN: Code duplicated, block: B:98:0x01c3  */
    /* JADX WARN: Code duplicated, block: B:99:0x01d8  */
    public static final void NotesTabsScreen(final NotesDestination.InnerDestination.TabsScreen tabDestination, final NotesTabsViewModels tabsViewModels, final NotesNavigator navigator, final Function1<? super ItemModel, Unit> onNavigateToNote, final Function0<Unit> onNavigateToSearch, final Function0<Unit> onNavigateToSettings, final SnackbarHostState snackbarHostState, Modifier modifier, Function1<? super String, Unit> function1, Composer composer, final int i, final int i2) {
        int i3;
        Modifier modifier2;
        int i4;
        Function1<? super String, Unit> function2;
        int i5;
        boolean z;
        Composer composer2;
        final Function1<? super String, Unit> function3;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier.Companion companion;
        final Store<NotesTabsReducer.State, NotesTabsReducer.Action> store;
        boolean zChanged;
        Object objRememberedValue;
        Object objRememberedValue2;
        NestedScrollDispatcher nestedScrollDispatcher;
        boolean zChanged2;
        Object objRememberedValue3;
        Object objRememberedValue4;
        Intrinsics.checkNotNullParameter(tabDestination, "tabDestination");
        Intrinsics.checkNotNullParameter(tabsViewModels, "tabsViewModels");
        Intrinsics.checkNotNullParameter(navigator, "navigator");
        Intrinsics.checkNotNullParameter(onNavigateToNote, "onNavigateToNote");
        Intrinsics.checkNotNullParameter(onNavigateToSearch, "onNavigateToSearch");
        Intrinsics.checkNotNullParameter(onNavigateToSettings, "onNavigateToSettings");
        Intrinsics.checkNotNullParameter(snackbarHostState, "snackbarHostState");
        Composer composerStartRestartGroup = composer.startRestartGroup(1335228156);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NotesTabsScreen)N(tabDestination,tabsViewModels,navigator,onNavigateToNote,onNavigateToSearch,onNavigateToSettings,snackbarHostState,modifier,onInnerTabChanged)54@2846L2,56@2888L11,58@2974L18,59@3046L29,61@3116L89,64@3242L34,65@3301L34,94@4599L80,94@4584L95,68@3388L560,81@3981L479,98@4732L1671,67@3341L3062:NotesTabsScreen.kt#2hc2fx");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changedInstance(tabDestination) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            i3 |= composerStartRestartGroup.changed(tabsViewModels) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(navigator) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onNavigateToNote) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onNavigateToSearch) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(onNavigateToSettings) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i3 |= composerStartRestartGroup.changed(snackbarHostState) ? 1048576 : 524288;
        }
        int i6 = i2 & 128;
        if (i6 == 0) {
            if ((12582912 & i) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 8388608 : 4194304;
            }
            i4 = i2 & 256;
            if (i4 != 0) {
                i3 |= 100663296;
                function2 = function1;
            } else {
                function2 = function1;
                if ((i & 100663296) == 0) {
                    if (composerStartRestartGroup.changedInstance(function2)) {
                        i5 = 67108864;
                    } else {
                        i5 = 33554432;
                    }
                    i3 |= i5;
                }
            }
            if ((i3 & 38347923) != 38347922) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composer2 = composerStartRestartGroup;
                composer2.skipToGroupEnd();
                function3 = function2;
                modifier3 = modifier2;
            } else {
                if (i6 != 0) {
                    companion = Modifier.INSTANCE;
                } else {
                    companion = modifier2;
                }
                if (i4 != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1040950946, "CC(remember):NotesTabsScreen.kt#9igjgp");
                    objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                    if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue4 = new Function1() { // from class: com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsScreenKt$$ExternalSyntheticLambda1
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return NotesTabsScreenKt.NotesTabsScreen$lambda$0$0((String) obj);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                    }
                    function2 = (Function1) objRememberedValue4;
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(1335228156, i3, -1, "com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsScreen (NotesTabsScreen.kt:55)");
                }
                store = tabsViewModels.getViewModel().invoke(composerStartRestartGroup, 0).getStore();
                final NotesRecentsViewModel notesRecentsViewModelInvoke = tabsViewModels.getRecentsViewModel().invoke(composerStartRestartGroup, 0);
                final State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(notesRecentsViewModelInvoke.getStore().getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                NotesDestination.InnerDestination.TabsScreen.NotesTab startTab = tabDestination.getStartTab();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1040942219, "CC(remember):NotesTabsScreen.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(startTab.ordinal());
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    MutableState mutableStateMutableStateOf$default = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(tabDestination.getStartTab(), null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default);
                    objRememberedValue = mutableStateMutableStateOf$default;
                }
                final MutableState mutableState = (MutableState) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1040938242, "CC(remember):NotesTabsScreen.kt#9igjgp");
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    nestedScrollDispatcher = null;
                    MutableState mutableStateMutableStateOf$default2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                    composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default2);
                    objRememberedValue2 = mutableStateMutableStateOf$default2;
                } else {
                    nestedScrollDispatcher = null;
                }
                final MutableState mutableState2 = (MutableState) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                final ScrollAwareFabVisibility scrollAwareFabVisibilityRememberScrollAwareFabVisibility = ScrollAwareFabVisibilityKt.rememberScrollAwareFabVisibility(composerStartRestartGroup, 0);
                Modifier modifierTestTag = TestTagKt.testTag(NestedScrollModifierKt.nestedScroll$default(companion, scrollAwareFabVisibilityRememberScrollAwareFabVisibility, nestedScrollDispatcher, 2, nestedScrollDispatcher), "NotesTabsScreen");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1040894772, "CC(remember):NotesTabsScreen.kt#9igjgp");
                zChanged2 = composerStartRestartGroup.changed(store);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function0() { // from class: com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsScreenKt$$ExternalSyntheticLambda2
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return NotesTabsScreenKt.NotesTabsScreen$lambda$8$0(store);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierTrackOnVisible = AnalyticsUtilsKt.trackOnVisible(modifierTestTag, null, (Function0) objRememberedValue3, composerStartRestartGroup, 0, 1);
                WindowInsets WindowInsets = WindowInsetsKt.WindowInsets();
                ComposableLambda composableLambdaRememberComposableLambda = ComposableLambdaKt.rememberComposableLambda(779564299, true, new Function2() { // from class: com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsScreenKt$$ExternalSyntheticLambda3
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NotesTabsScreenKt.NotesTabsScreen$lambda$9(tabsViewModels, store, onNavigateToSettings, onNavigateToSearch, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                ComposableLambda composableLambdaRememberComposableLambda2 = ComposableLambdaKt.rememberComposableLambda(2096330057, true, new Function2() { // from class: com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsScreenKt$$ExternalSyntheticLambda4
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NotesTabsScreenKt.NotesTabsScreen$lambda$10(scrollAwareFabVisibilityRememberScrollAwareFabVisibility, notesRecentsViewModelInvoke, stateCollectAsStateWithLifecycle, mutableState2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54);
                Modifier modifier4 = companion;
                final Function1<? super String, Unit> function4 = function2;
                function3 = function4;
                composer2 = composerStartRestartGroup;
                ScaffoldWithCollapsingTopBarKt.ScaffoldWithCollapsingTopBar(composableLambdaRememberComposableLambda, modifierTrackOnVisible, composableLambdaRememberComposableLambda2, WindowInsets, ComposableLambdaKt.rememberComposableLambda(1868245284, true, new Function3() { // from class: com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsScreenKt$$ExternalSyntheticLambda5
                    @Override // kotlin.jvm.functions.Function3
                    public final Object invoke(Object obj, Object obj2, Object obj3) {
                        return NotesTabsScreenKt.NotesTabsScreen$lambda$11(tabDestination, mutableState, function4, snackbarHostState, notesRecentsViewModelInvoke, navigator, onNavigateToNote, store, tabsViewModels, mutableState2, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, 24966, 0);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsScreenKt$$ExternalSyntheticLambda6
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NotesTabsScreenKt.NotesTabsScreen$lambda$12(tabDestination, tabsViewModels, navigator, onNavigateToNote, onNavigateToSearch, onNavigateToSettings, snackbarHostState, modifier3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 12582912;
        modifier2 = modifier;
        i4 = i2 & 256;
        if (i4 != 0) {
            i3 |= 100663296;
            function2 = function1;
        } else {
            function2 = function1;
            if ((i & 100663296) == 0) {
                if (composerStartRestartGroup.changedInstance(function2)) {
                    i5 = 67108864;
                } else {
                    i5 = 33554432;
                }
                i3 |= i5;
            }
        }
        if ((i3 & 38347923) != 38347922) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            function3 = function2;
            modifier3 = modifier2;
        } else {
            if (i6 != 0) {
                companion = Modifier.INSTANCE;
            } else {
                companion = modifier2;
            }
            if (i4 != 0) {
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1040950946, "CC(remember):NotesTabsScreen.kt#9igjgp");
                objRememberedValue4 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new Function1() { // from class: com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsScreenKt$$ExternalSyntheticLambda1
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return NotesTabsScreenKt.NotesTabsScreen$lambda$0$0((String) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue4);
                }
                function2 = (Function1) objRememberedValue4;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1335228156, i3, -1, "com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsScreen (NotesTabsScreen.kt:55)");
            }
            store = tabsViewModels.getViewModel().invoke(composerStartRestartGroup, 0).getStore();
            final NotesRecentsViewModel notesRecentsViewModelInvoke2 = tabsViewModels.getRecentsViewModel().invoke(composerStartRestartGroup, 0);
            final State stateCollectAsStateWithLifecycle2 = FlowExtKt.collectAsStateWithLifecycle(notesRecentsViewModelInvoke2.getStore().getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            NotesDestination.InnerDestination.TabsScreen.NotesTab startTab2 = tabDestination.getStartTab();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1040942219, "CC(remember):NotesTabsScreen.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(startTab2.ordinal());
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                MutableState mutableStateMutableStateOf$default3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(tabDestination.getStartTab(), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default3);
                objRememberedValue = mutableStateMutableStateOf$default3;
            } else {
                MutableState mutableStateMutableStateOf$default4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(tabDestination.getStartTab(), null, 2, null);
                composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default4);
                objRememberedValue = mutableStateMutableStateOf$default4;
            }
            final MutableState mutableState3 = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1040938242, "CC(remember):NotesTabsScreen.kt#9igjgp");
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                nestedScrollDispatcher = null;
                MutableState mutableStateMutableStateOf$default5 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(false, null, 2, null);
                composerStartRestartGroup.updateRememberedValue(mutableStateMutableStateOf$default5);
                objRememberedValue2 = mutableStateMutableStateOf$default5;
            } else {
                nestedScrollDispatcher = null;
            }
            final MutableState mutableState4 = (MutableState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            final ScrollAwareFabVisibility scrollAwareFabVisibilityRememberScrollAwareFabVisibility2 = ScrollAwareFabVisibilityKt.rememberScrollAwareFabVisibility(composerStartRestartGroup, 0);
            Modifier modifierTestTag2 = TestTagKt.testTag(NestedScrollModifierKt.nestedScroll$default(companion, scrollAwareFabVisibilityRememberScrollAwareFabVisibility2, nestedScrollDispatcher, 2, nestedScrollDispatcher), "NotesTabsScreen");
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1040894772, "CC(remember):NotesTabsScreen.kt#9igjgp");
            zChanged2 = composerStartRestartGroup.changed(store);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (!zChanged2) {
                objRememberedValue3 = new Function0() { // from class: com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsScreenKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return NotesTabsScreenKt.NotesTabsScreen$lambda$8$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new Function0() { // from class: com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsScreenKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return NotesTabsScreenKt.NotesTabsScreen$lambda$8$0(store);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierTrackOnVisible2 = AnalyticsUtilsKt.trackOnVisible(modifierTestTag2, null, (Function0) objRememberedValue3, composerStartRestartGroup, 0, 1);
            WindowInsets WindowInsets2 = WindowInsetsKt.WindowInsets();
            ComposableLambda composableLambdaRememberComposableLambda3 = ComposableLambdaKt.rememberComposableLambda(779564299, true, new Function2() { // from class: com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsScreenKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NotesTabsScreenKt.NotesTabsScreen$lambda$9(tabsViewModels, store, onNavigateToSettings, onNavigateToSearch, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54);
            ComposableLambda composableLambdaRememberComposableLambda4 = ComposableLambdaKt.rememberComposableLambda(2096330057, true, new Function2() { // from class: com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsScreenKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NotesTabsScreenKt.NotesTabsScreen$lambda$10(scrollAwareFabVisibilityRememberScrollAwareFabVisibility2, notesRecentsViewModelInvoke2, stateCollectAsStateWithLifecycle2, mutableState4, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54);
            Modifier modifier5 = companion;
            final Function1 function5 = function2;
            function3 = function5;
            composer2 = composerStartRestartGroup;
            ScaffoldWithCollapsingTopBarKt.ScaffoldWithCollapsingTopBar(composableLambdaRememberComposableLambda3, modifierTrackOnVisible2, composableLambdaRememberComposableLambda4, WindowInsets2, ComposableLambdaKt.rememberComposableLambda(1868245284, true, new Function3() { // from class: com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsScreenKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return NotesTabsScreenKt.NotesTabsScreen$lambda$11(tabDestination, mutableState3, function5, snackbarHostState, notesRecentsViewModelInvoke2, navigator, onNavigateToNote, store, tabsViewModels, mutableState4, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, 24966, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsScreenKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NotesTabsScreenKt.NotesTabsScreen$lambda$12(tabDestination, tabsViewModels, navigator, onNavigateToNote, onNavigateToSearch, onNavigateToSettings, snackbarHostState, modifier3, function3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final NotesDestination.InnerDestination.TabsScreen.NotesTab NotesTabsScreen$lambda$3(MutableState<NotesDestination.InnerDestination.TabsScreen.NotesTab> mutableState) {
        return mutableState.getValue();
    }

    private static final boolean NotesTabsScreen$lambda$6(MutableState<Boolean> mutableState) {
        return mutableState.getValue().booleanValue();
    }

    private static final void NotesTabsScreen$lambda$7(MutableState<Boolean> mutableState, boolean z) {
        mutableState.setValue(Boolean.valueOf(z));
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotesTabsScreen$lambda$9(NotesTabsViewModels notesTabsViewModels, final Store store, final Function0 function0, Function0 function1, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C71@3528L21,72@3581L146,77@3816L30,69@3402L536:NotesTabsScreen.kt#2hc2fx");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(779564299, i, -1, "com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsScreen.<anonymous> (NotesTabsScreen.kt:69)");
            }
            UserAvatarViewModel userAvatarViewModelInvoke = notesTabsViewModels.getUserAvatarViewModel().invoke(composer, 0);
            ComposerKt.sourceInformationMarkerStart(composer, 1836988157, "CC(remember):NotesTabsScreen.kt#9igjgp");
            boolean zChanged = composer.changed(store) | composer.changed(function0);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsScreenKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return NotesTabsScreenKt.NotesTabsScreen$lambda$9$0$0(store, function0);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            BoxPrimaryTopBarKt.BoxPrimaryTopBar(null, new SettingsButtonConfig(userAvatarViewModelInvoke, (Function0) objRememberedValue), null, new CenterSpaceConfig.TitleBarConfig(StringResources_androidKt.stringResource(R.string.notes, composer, 0)), null, new SearchButtonConfig(function1), composer, (SettingsButtonConfig.$stable << 3) | (CenterSpaceConfig.TitleBarConfig.$stable << 9) | (SearchButtonConfig.$stable << 15), 21);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotesTabsScreen$lambda$9$0$0(Store store, Function0 function0) {
        store.send(NotesTabsReducer.Action.SettingsClicked.INSTANCE);
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotesTabsScreen$lambda$10(ScrollAwareFabVisibility scrollAwareFabVisibility, final NotesRecentsViewModel notesRecentsViewModel, State state, MutableState mutableState, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:NotesTabsScreen.kt#2hc2fx");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(2096330057, i, -1, "com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsScreen.<anonymous> (NotesTabsScreen.kt:82)");
            }
            if (NotesTabsScreen$lambda$1(state).getCanCreateBoxNote()) {
                composer.startReplaceGroup(-1350644555);
                ComposerKt.sourceInformation(composer, "84@4092L42,85@4177L54,86@4263L70,83@4048L388");
                Painter painterPainterResource = PainterResources_androidKt.painterResource(R.drawable.ic_create_note, composer, 0);
                String strStringResource = StringResources_androidKt.stringResource(R.string.notes_fab_content_description, composer, 0);
                boolean z = NotesTabsScreen$lambda$6(mutableState) && scrollAwareFabVisibility.isVisible();
                ComposerKt.sourceInformationMarkerStart(composer, 233532047, "CC(remember):NotesTabsScreen.kt#9igjgp");
                boolean zChangedInstance = composer.changedInstance(notesRecentsViewModel);
                Object objRememberedValue = composer.rememberedValue();
                if (zChangedInstance || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsScreenKt$$ExternalSyntheticLambda0
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return NotesTabsScreenKt.NotesTabsScreen$lambda$10$0$0(notesRecentsViewModel);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                BoxFabButtonKt.BoxFabButton((Function0) objRememberedValue, strStringResource, null, z, painterPainterResource, composer, Painter.$stable << 12, 4);
            } else {
                composer.startReplaceGroup(-1354673191);
            }
            composer.endReplaceGroup();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotesTabsScreen$lambda$10$0$0(NotesRecentsViewModel notesRecentsViewModel) {
        notesRecentsViewModel.getStore().send(NotesListReducer.Action.CreateNewNote.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotesTabsScreen$lambda$8$0(Store store) {
        store.send(NotesTabsReducer.Action.ScreenViewed.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotesTabsScreen$lambda$11(NotesDestination.InnerDestination.TabsScreen tabsScreen, final MutableState mutableState, final Function1 function1, final SnackbarHostState snackbarHostState, final NotesRecentsViewModel notesRecentsViewModel, final NotesNavigator notesNavigator, final Function1 function2, final Store store, final NotesTabsViewModels notesTabsViewModels, final MutableState mutableState2, PaddingValues paddingValues, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        ComposerKt.sourceInformation(composer, "CN(paddingValues)103@4975L171,111@5261L1136,99@4759L1638:NotesTabsScreen.kt#2hc2fx");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(paddingValues) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1868245284, i2, -1, "com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsScreen.<anonymous> (NotesTabsScreen.kt:99)");
            }
            List<NotesDestination.InnerDestination.TabsScreen.NotesTab> tabs = tabsScreen.getTabs();
            NotesDestination.InnerDestination.TabsScreen.NotesTab startTab = tabsScreen.getStartTab();
            Modifier modifierPadding = PaddingKt.padding(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), paddingValues);
            Function3 function3 = new Function3() { // from class: com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsScreenKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return NotesTabsScreenKt.NotesTabsScreen$lambda$11$0((NotesDestination.InnerDestination.TabsScreen.NotesTab) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            ComposerKt.sourceInformationMarkerStart(composer, 87396143, "CC(remember):NotesTabsScreen.kt#9igjgp");
            boolean zChanged = composer.changed(mutableState) | composer.changed(function1) | composer.changed(snackbarHostState);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function1() { // from class: com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsScreenKt$$ExternalSyntheticLambda14
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NotesTabsScreenKt.NotesTabsScreen$lambda$11$1$0(function1, snackbarHostState, mutableState, (NotesDestination.InnerDestination.TabsScreen.NotesTab) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            CommonTabsScreenKt.m11833CommonTabsScreenDuhZ5jU(tabs, startTab, function3, modifierPadding, false, 0, 0L, 0L, 0L, 0L, null, null, (Function1) objRememberedValue, null, ComposableLambdaKt.rememberComposableLambda(-910795627, true, new Function3() { // from class: com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsScreenKt$$ExternalSyntheticLambda15
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return NotesTabsScreenKt.NotesTabsScreen$lambda$11$2(notesRecentsViewModel, notesNavigator, function2, snackbarHostState, store, notesTabsViewModels, mutableState, mutableState2, (NotesDestination.InnerDestination.TabsScreen.NotesTab) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, 0, 24576, 12272);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final String NotesTabsScreen$lambda$11$0(NotesDestination.InnerDestination.TabsScreen.NotesTab tab, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(tab, "tab");
        composer.startReplaceGroup(1572421537);
        ComposerKt.sourceInformation(composer, "CN(tab)102@4904L33:NotesTabsScreen.kt#2hc2fx");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1572421537, i, -1, "com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsScreen.<anonymous>.<anonymous> (NotesTabsScreen.kt:102)");
        }
        String strStringResource = StringResources_androidKt.stringResource(getTitleRes(tab), composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return strStringResource;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotesTabsScreen$lambda$11$1$0(Function1 function1, SnackbarHostState snackbarHostState, MutableState mutableState, NotesDestination.InnerDestination.TabsScreen.NotesTab tab) {
        Intrinsics.checkNotNullParameter(tab, "tab");
        mutableState.setValue(tab);
        function1.invoke(tab.name());
        SnackbarData currentSnackbarData = snackbarHostState.getCurrentSnackbarData();
        if (currentSnackbarData != null) {
            currentSnackbarData.dismiss();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotesTabsScreen$lambda$11$2(NotesRecentsViewModel notesRecentsViewModel, NotesNavigator notesNavigator, Function1 function1, SnackbarHostState snackbarHostState, final Store store, NotesTabsViewModels notesTabsViewModels, MutableState mutableState, final MutableState mutableState2, NotesDestination.InnerDestination.TabsScreen.NotesTab tab, Composer composer, int i) {
        int i2;
        Intrinsics.checkNotNullParameter(tab, "tab");
        ComposerKt.sourceInformation(composer, "CN(tab):NotesTabsScreen.kt#2hc2fx");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(tab.ordinal()) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-910795627, i2, -1, "com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsScreen.<anonymous>.<anonymous> (NotesTabsScreen.kt:112)");
            }
            int i3 = WhenMappings.$EnumSwitchMapping$0[tab.ordinal()];
            if (i3 == 1) {
                composer.startReplaceGroup(898733697);
                ComposerKt.sourceInformation(composer, "120@5699L62,121@5807L33,113@5334L524");
                NotesDestination.InnerDestination.TabsScreen.NotesTab notesTabNotesTabsScreen$lambda$3 = NotesTabsScreen$lambda$3(mutableState);
                ComposerKt.sourceInformationMarkerStart(composer, 898744915, "CC(remember):NotesTabsScreen.kt#9igjgp");
                boolean zChanged = composer.changed(store);
                Object objRememberedValue = composer.rememberedValue();
                if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsScreenKt$$ExternalSyntheticLambda18
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return NotesTabsScreenKt.NotesTabsScreen$lambda$11$2$0$0(store);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                Function0 function0 = (Function0) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, 898748342, "CC(remember):NotesTabsScreen.kt#9igjgp");
                Object objRememberedValue2 = composer.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function1() { // from class: com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsScreenKt$$ExternalSyntheticLambda19
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return NotesTabsScreenKt.NotesTabsScreen$lambda$11$2$1$0(mutableState2, ((Boolean) obj).booleanValue());
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                RecentsTabScreen(notesRecentsViewModel, notesTabNotesTabsScreen$lambda$3, tab, notesNavigator, function1, snackbarHostState, function0, (Function1) objRememberedValue2, composer, ((i2 << 6) & 896) | 12582912);
                composer.endReplaceGroup();
            } else {
                if (i3 != 2) {
                    composer.startReplaceGroup(898732614);
                    composer.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
                composer.startReplaceGroup(898751789);
                ComposerKt.sourceInformation(composer, "125@5977L20,131@6291L64,124@5901L472");
                NotesFavoritesViewModel notesFavoritesViewModelInvoke = notesTabsViewModels.getFavoritesViewModel().invoke(composer, 0);
                NotesDestination.InnerDestination.TabsScreen.NotesTab notesTabNotesTabsScreen$lambda$4 = NotesTabsScreen$lambda$3(mutableState);
                ComposerKt.sourceInformationMarkerStart(composer, 898763861, "CC(remember):NotesTabsScreen.kt#9igjgp");
                boolean zChanged2 = composer.changed(store);
                Object objRememberedValue3 = composer.rememberedValue();
                if (zChanged2 || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function0() { // from class: com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsScreenKt$$ExternalSyntheticLambda20
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return NotesTabsScreenKt.NotesTabsScreen$lambda$11$2$2$0(store);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                FavoritesTabScreen(notesFavoritesViewModelInvoke, notesTabNotesTabsScreen$lambda$4, tab, notesNavigator, function1, snackbarHostState, (Function0) objRememberedValue3, composer, (i2 << 6) & 896);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotesTabsScreen$lambda$11$2$0$0(Store store) {
        store.send(NotesTabsReducer.Action.RecentsTabScreenViewed.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotesTabsScreen$lambda$11$2$1$0(MutableState mutableState, boolean z) {
        NotesTabsScreen$lambda$7(mutableState, z);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotesTabsScreen$lambda$11$2$2$0(Store store) {
        store.send(NotesTabsReducer.Action.FavoritesTabScreenViewed.INSTANCE);
        return Unit.INSTANCE;
    }

    private static final void RecentsTabScreen(final NotesRecentsViewModel notesRecentsViewModel, final NotesDestination.InnerDestination.TabsScreen.NotesTab notesTab, final NotesDestination.InnerDestination.TabsScreen.NotesTab notesTab2, final NotesNavigator notesNavigator, final Function1<? super ItemModel, Unit> function1, final SnackbarHostState snackbarHostState, final Function0<Unit> function0, final Function1<? super Boolean, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1858035480);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(RecentsTabScreen)N(recentsViewModel,currentVisibleTab,tab,navigator,onNavigateToNote,snackbarHostState,onRecentsTabViewed,onFullyVisibleChanged)151@6842L156,158@7142L196,149@6751L648:NotesTabsScreen.kt#2hc2fx");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(notesRecentsViewModel) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(notesTab.ordinal()) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(notesTab2.ordinal()) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(notesNavigator) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(snackbarHostState) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 1048576 : 524288;
        }
        if ((12582912 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 8388608 : 4194304;
        }
        int i3 = i2;
        if (!composerStartRestartGroup.shouldExecute((4793491 & i3) != 4793490, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1858035480, i3, -1, "com.box.android.notes.navigationmodernization.tabsscreen.RecentsTabScreen (NotesTabsScreen.kt:148)");
            }
            composer2 = composerStartRestartGroup;
            NotesTabContentScreen(notesRecentsViewModel.getStore(), notesEmptyScreenConfig(R.string.empty_notes_recents_title, R.string.empty_notes_recents_subtitle, composerStartRestartGroup, 0), notesNavigator, function1, snackbarHostState, notesTabScreenModifier("NotesRecentsScreen", notesTab, notesTab2, function0, composerStartRestartGroup, (i3 & 112) | 6 | (i3 & 896) | ((i3 >> 9) & 7168)), function2, composer2, (i3 >> 3) & 3735424, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsScreenKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NotesTabsScreenKt.RecentsTabScreen$lambda$0(notesRecentsViewModel, notesTab, notesTab2, notesNavigator, function1, snackbarHostState, function0, function2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final void FavoritesTabScreen(final NotesFavoritesViewModel notesFavoritesViewModel, final NotesDestination.InnerDestination.TabsScreen.NotesTab notesTab, final NotesDestination.InnerDestination.TabsScreen.NotesTab notesTab2, final NotesNavigator notesNavigator, final Function1<? super ItemModel, Unit> function1, final SnackbarHostState snackbarHostState, final Function0<Unit> function0, Composer composer, final int i) {
        int i2;
        Composer composer2;
        Composer composerStartRestartGroup = composer.startRestartGroup(-490912695);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(FavoritesTabScreen)N(favoritesViewModel,currentVisibleTab,tab,navigator,onNavigateToNote,snackbarHostState,onFavoritesTabViewed)180@7802L160,187@8106L200,178@7709L603:NotesTabsScreen.kt#2hc2fx");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changedInstance(notesFavoritesViewModel) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changed(notesTab.ordinal()) ? 32 : 16;
        }
        if ((i & 384) == 0) {
            i2 |= composerStartRestartGroup.changed(notesTab2.ordinal()) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(notesNavigator) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function1) ? 16384 : 8192;
        }
        if ((196608 & i) == 0) {
            i2 |= composerStartRestartGroup.changed(snackbarHostState) ? 131072 : 65536;
        }
        if ((1572864 & i) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function0) ? 1048576 : 524288;
        }
        int i3 = i2;
        if (!composerStartRestartGroup.shouldExecute((599187 & i3) != 599186, i3 & 1)) {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-490912695, i3, -1, "com.box.android.notes.navigationmodernization.tabsscreen.FavoritesTabScreen (NotesTabsScreen.kt:177)");
            }
            composer2 = composerStartRestartGroup;
            NotesTabContentScreen(notesFavoritesViewModel.getStore(), notesEmptyScreenConfig(R.string.empty_notes_favorites_title, R.string.empty_notes_favorites_subtitle, composerStartRestartGroup, 0), notesNavigator, function1, snackbarHostState, notesTabScreenModifier("NotesFavoritesScreen", notesTab, notesTab2, function0, composerStartRestartGroup, (i3 & 112) | 6 | (i3 & 896) | ((i3 >> 9) & 7168)), null, composer2, (i3 >> 3) & 65408, 64);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsScreenKt$$ExternalSyntheticLambda16
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NotesTabsScreenKt.FavoritesTabScreen$lambda$0(notesFavoritesViewModel, notesTab, notesTab2, notesNavigator, function1, snackbarHostState, function0, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final ItemsStateConfig notesEmptyScreenConfig(int i, int i2, Composer composer, int i3) {
        ComposerKt.sourceInformationMarkerStart(composer, 1282534135, "C(notesEmptyScreenConfig)N(titleRes,subtitleRes)199@8478L24,200@8518L27:NotesTabsScreen.kt#2hc2fx");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1282534135, i3, -1, "com.box.android.notes.navigationmodernization.tabsscreen.notesEmptyScreenConfig (NotesTabsScreen.kt:197)");
        }
        ItemsStateConfig itemsStateConfig = new ItemsStateConfig(R.drawable.ic_folderfloat140, StringResources_androidKt.stringResource(i, composer, i3 & 14), StringResources_androidKt.stringResource(i2, composer, (i3 >> 3) & 14), null, 8, null);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return itemsStateConfig;
    }

    private static final Modifier notesTabScreenModifier(String str, final NotesDestination.InnerDestination.TabsScreen.NotesTab notesTab, final NotesDestination.InnerDestination.TabsScreen.NotesTab notesTab2, Function0<Unit> function0, Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, 473693889, "C(notesTabScreenModifier)N(testTag,currentVisibleTab,tab,onTabViewed)212@8786L28,211@8748L103:NotesTabsScreen.kt#2hc2fx");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(473693889, i, -1, "com.box.android.notes.navigationmodernization.tabsscreen.notesTabScreenModifier (NotesTabsScreen.kt:209)");
        }
        Modifier modifierTestTag = TestTagKt.testTag(Modifier.INSTANCE, str);
        ComposerKt.sourceInformationMarkerStart(composer, -46699075, "CC(remember):NotesTabsScreen.kt#9igjgp");
        boolean z = ((((i & 112) ^ 48) > 32 && composer.changed(notesTab.ordinal())) || (i & 48) == 32) | ((((i & 896) ^ 384) > 256 && composer.changed(notesTab2.ordinal())) || (i & 384) == 256);
        Object objRememberedValue = composer.rememberedValue();
        if (z || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsScreenKt$$ExternalSyntheticLambda17
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return Boolean.valueOf(NotesTabsScreenKt.notesTabScreenModifier$lambda$0$0(notesTab, notesTab2));
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        Modifier modifierTrackOnVisible = AnalyticsUtilsKt.trackOnVisible(modifierTestTag, (Function0) objRememberedValue, function0, composer, (i >> 3) & 896, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return modifierTrackOnVisible;
    }

    /* JADX WARN: Code duplicated, block: B:102:0x019a  */
    /* JADX WARN: Code duplicated, block: B:103:0x019d  */
    /* JADX WARN: Code duplicated, block: B:106:0x01a1  */
    /* JADX WARN: Code duplicated, block: B:107:0x01a4  */
    /* JADX WARN: Code duplicated, block: B:110:0x01b1  */
    /* JADX WARN: Code duplicated, block: B:114:0x01bf  */
    /* JADX WARN: Code duplicated, block: B:118:0x01ed  */
    /* JADX WARN: Code duplicated, block: B:121:0x01f7  */
    /* JADX WARN: Code duplicated, block: B:123:0x01ff  */
    /* JADX WARN: Code duplicated, block: B:126:0x021b  */
    /* JADX WARN: Code duplicated, block: B:128:0x0221  */
    /* JADX WARN: Code duplicated, block: B:131:0x022c  */
    /* JADX WARN: Code duplicated, block: B:133:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Code duplicated, block: B:54:0x0095  */
    /* JADX WARN: Code duplicated, block: B:55:0x0097  */
    /* JADX WARN: Code duplicated, block: B:57:0x009a  */
    /* JADX WARN: Code duplicated, block: B:59:0x00a2  */
    /* JADX WARN: Code duplicated, block: B:60:0x00a5  */
    /* JADX WARN: Code duplicated, block: B:65:0x00b9  */
    /* JADX WARN: Code duplicated, block: B:66:0x00bc  */
    /* JADX WARN: Code duplicated, block: B:69:0x00c5 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:70:0x00c7  */
    /* JADX WARN: Code duplicated, block: B:71:0x00ce  */
    /* JADX WARN: Code duplicated, block: B:73:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:74:0x00d4  */
    /* JADX WARN: Code duplicated, block: B:77:0x00db  */
    /* JADX WARN: Code duplicated, block: B:80:0x00fd  */
    /* JADX WARN: Code duplicated, block: B:81:0x0100  */
    /* JADX WARN: Code duplicated, block: B:84:0x0106  */
    /* JADX WARN: Code duplicated, block: B:85:0x0109  */
    /* JADX WARN: Code duplicated, block: B:88:0x0111  */
    /* JADX WARN: Code duplicated, block: B:90:0x0119  */
    /* JADX WARN: Code duplicated, block: B:93:0x013f  */
    /* JADX WARN: Code duplicated, block: B:94:0x0142  */
    /* JADX WARN: Code duplicated, block: B:97:0x0149  */
    /* JADX WARN: Code duplicated, block: B:99:0x0151  */
    private static final void NotesTabContentScreen(final Store<NotesListReducer.State, NotesListReducer.Action> store, final ItemsStateConfig itemsStateConfig, final NotesNavigator notesNavigator, final Function1<? super ItemModel, Unit> function1, final SnackbarHostState snackbarHostState, Modifier modifier, Function1<? super Boolean, Unit> function2, Composer composer, final int i, final int i2) {
        int i3;
        ItemsStateConfig itemsStateConfig2;
        Modifier modifier2;
        int i4;
        Function1<? super Boolean, Unit> function3;
        int i5;
        boolean z;
        final Modifier modifier3;
        final Function1<? super Boolean, Unit> function4;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Modifier modifier4;
        final Function1<? super Boolean, Unit> function5;
        State stateCollectAsStateWithLifecycle;
        int i6;
        boolean z2;
        boolean z3;
        boolean z4;
        Object objRememberedValue;
        boolean z5;
        Object objRememberedValue2;
        NotesListReducer.Route navigationRoute;
        boolean z6;
        boolean z7;
        boolean zChangedInstance;
        NotesTabsScreenKt$NotesTabContentScreen$3$1 notesTabsScreenKt$NotesTabContentScreen$3$1RememberedValue;
        final State state;
        NotesListReducer.Route route;
        final Store<NotesListReducer.State, NotesListReducer.Action> store2;
        boolean zChanged;
        Object objRememberedValue3;
        Composer composerStartRestartGroup = composer.startRestartGroup(-505135392);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(NotesTabContentScreen)N(store,emptyScreenConfig,navigator,onNavigateToNote,snackbarHostState,modifier,onFullyVisibleChanged)226@9247L29,233@9502L203,239@9764L146,228@9282L634,246@9960L511,246@9922L549,262@10525L232,262@10477L280:NotesTabsScreen.kt#2hc2fx");
        if ((i & 6) == 0) {
            i3 = (composerStartRestartGroup.changed(store) ? 4 : 2) | i;
        } else {
            i3 = i;
        }
        if ((i & 48) == 0) {
            itemsStateConfig2 = itemsStateConfig;
            i3 |= composerStartRestartGroup.changed(itemsStateConfig2) ? 32 : 16;
        } else {
            itemsStateConfig2 = itemsStateConfig;
        }
        if ((i & 384) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(notesNavigator) ? 256 : 128;
        }
        if ((i & 3072) == 0) {
            i3 |= composerStartRestartGroup.changedInstance(function1) ? 2048 : 1024;
        }
        if ((i & 24576) == 0) {
            i3 |= composerStartRestartGroup.changed(snackbarHostState) ? 16384 : 8192;
        }
        int i7 = i2 & 32;
        if (i7 == 0) {
            if ((196608 & i) == 0) {
                modifier2 = modifier;
                i3 |= composerStartRestartGroup.changed(modifier2) ? 131072 : 65536;
            }
            i4 = i2 & 64;
            if (i4 != 0) {
                if ((1572864 & i) == 0) {
                    function3 = function2;
                    if (composerStartRestartGroup.changedInstance(function3)) {
                        i5 = 1048576;
                    } else {
                        i5 = 524288;
                    }
                    i3 |= i5;
                }
                if ((i3 & 599187) != 599186) {
                    z = true;
                } else {
                    z = false;
                }
                if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                    composerStartRestartGroup.skipToGroupEnd();
                    modifier3 = modifier2;
                } else {
                    if (i7 != 0) {
                        modifier4 = Modifier.INSTANCE;
                    } else {
                        modifier4 = modifier2;
                    }
                    if (i4 != 0) {
                        function5 = null;
                    } else {
                        function5 = function3;
                    }
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventStart(-505135392, i3, -1, "com.box.android.notes.navigationmodernization.tabsscreen.NotesTabContentScreen (NotesTabsScreen.kt:225)");
                    }
                    stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -103786933, "CC(remember):NotesTabsScreen.kt#9igjgp");
                    i6 = i3 & 14;
                    if (i6 == 4) {
                        z2 = true;
                    } else {
                        z2 = false;
                    }
                    if ((3670016 & i3) == 1048576) {
                        z3 = true;
                    } else {
                        z3 = false;
                    }
                    z4 = z3 | z2;
                    objRememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!z4 || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue = new Function1() { // from class: com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsScreenKt$$ExternalSyntheticLambda8
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return NotesTabsScreenKt.NotesTabContentScreen$lambda$1$0(store, function5, ((Boolean) obj).booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Modifier modifierOnVisibilityChanged$default = OnVisibilityChangedModifierKt.onVisibilityChanged$default(modifier4, 0L, 1.0f, null, (Function1) objRememberedValue, 5, null);
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -103778606, "CC(remember):NotesTabsScreen.kt#9igjgp");
                    if (i6 == 4) {
                        z5 = true;
                    } else {
                        z5 = false;
                    }
                    objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                    if (!z5 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue2 = new Function1() { // from class: com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsScreenKt$$ExternalSyntheticLambda9
                            @Override // kotlin.jvm.functions.Function1
                            public final Object invoke(Object obj) {
                                return NotesTabsScreenKt.NotesTabContentScreen$lambda$2$0(store, ((Boolean) obj).booleanValue());
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    function3 = function5;
                    NotesListScreenKt.NotesListScreen(store, itemsStateConfig2, snackbarHostState, OnVisibilityChangedModifierKt.onVisibilityChanged$default(modifierOnVisibilityChanged$default, 0L, 0.0f, null, (Function1) objRememberedValue2, 5, null), composerStartRestartGroup, (i3 & 126) | ((i3 >> 6) & 896), 0);
                    navigationRoute = NotesTabContentScreen$lambda$0(stateCollectAsStateWithLifecycle).getNavigationRoute();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -103771969, "CC(remember):NotesTabsScreen.kt#9igjgp");
                    boolean zChanged2 = composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle);
                    if ((i3 & 7168) == 2048) {
                        z6 = true;
                    } else {
                        z6 = false;
                    }
                    boolean z8 = zChanged2 | z6;
                    if (i6 == 4) {
                        z7 = true;
                    } else {
                        z7 = false;
                    }
                    zChangedInstance = z8 | z7 | composerStartRestartGroup.changedInstance(notesNavigator);
                    notesTabsScreenKt$NotesTabContentScreen$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                    if (!zChangedInstance || notesTabsScreenKt$NotesTabContentScreen$3$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                        state = stateCollectAsStateWithLifecycle;
                        route = navigationRoute;
                        store2 = store;
                        notesTabsScreenKt$NotesTabContentScreen$3$1RememberedValue = new NotesTabsScreenKt$NotesTabContentScreen$3$1(function1, store, notesNavigator, state, null);
                        composerStartRestartGroup.updateRememberedValue(notesTabsScreenKt$NotesTabContentScreen$3$1RememberedValue);
                    } else {
                        route = navigationRoute;
                        state = stateCollectAsStateWithLifecycle;
                        store2 = store;
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    EffectsKt.LaunchedEffect(route, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) notesTabsScreenKt$NotesTabContentScreen$3$1RememberedValue, composerStartRestartGroup, 0);
                    Lifecycle.Event event = Lifecycle.Event.ON_RESUME;
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -103754168, "CC(remember):NotesTabsScreen.kt#9igjgp");
                    zChanged = composerStartRestartGroup.changed(state) | (i6 == 4);
                    objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                    if (!zChanged || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                        objRememberedValue3 = new Function0() { // from class: com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsScreenKt$$ExternalSyntheticLambda10
                            @Override // kotlin.jvm.functions.Function0
                            public final Object invoke() {
                                return NotesTabsScreenKt.NotesTabContentScreen$lambda$4$0(store2, state);
                            }
                        };
                        composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                    }
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    composerStartRestartGroup = composerStartRestartGroup;
                    LifecycleEffectKt.LifecycleEventEffect(event, null, (Function0) objRememberedValue3, composerStartRestartGroup, 6, 2);
                    if (ComposerKt.isTraceInProgress()) {
                        ComposerKt.traceEventEnd();
                    }
                    modifier3 = modifier4;
                }
                function4 = function3;
                scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
                if (scopeUpdateScopeEndRestartGroup != null) {
                    scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsScreenKt$$ExternalSyntheticLambda12
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return NotesTabsScreenKt.NotesTabContentScreen$lambda$5(store, itemsStateConfig, notesNavigator, function1, snackbarHostState, modifier3, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                        }
                    });
                }
            }
            i3 |= 1572864;
            function3 = function2;
            if ((i3 & 599187) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                if (i7 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    function5 = null;
                } else {
                    function5 = function3;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-505135392, i3, -1, "com.box.android.notes.navigationmodernization.tabsscreen.NotesTabContentScreen (NotesTabsScreen.kt:225)");
                }
                stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -103786933, "CC(remember):NotesTabsScreen.kt#9igjgp");
                i6 = i3 & 14;
                if (i6 == 4) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if ((3670016 & i3) == 1048576) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                z4 = z3 | z2;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z4) {
                    objRememberedValue = new Function1() { // from class: com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsScreenKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return NotesTabsScreenKt.NotesTabContentScreen$lambda$1$0(store, function5, ((Boolean) obj).booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function1() { // from class: com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsScreenKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return NotesTabsScreenKt.NotesTabContentScreen$lambda$1$0(store, function5, ((Boolean) obj).booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierOnVisibilityChanged$default2 = OnVisibilityChangedModifierKt.onVisibilityChanged$default(modifier4, 0L, 1.0f, null, (Function1) objRememberedValue, 5, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -103778606, "CC(remember):NotesTabsScreen.kt#9igjgp");
                if (i6 == 4) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z5) {
                    objRememberedValue2 = new Function1() { // from class: com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsScreenKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return NotesTabsScreenKt.NotesTabContentScreen$lambda$2$0(store, ((Boolean) obj).booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function1() { // from class: com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsScreenKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return NotesTabsScreenKt.NotesTabContentScreen$lambda$2$0(store, ((Boolean) obj).booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                function3 = function5;
                NotesListScreenKt.NotesListScreen(store, itemsStateConfig2, snackbarHostState, OnVisibilityChangedModifierKt.onVisibilityChanged$default(modifierOnVisibilityChanged$default2, 0L, 0.0f, null, (Function1) objRememberedValue2, 5, null), composerStartRestartGroup, (i3 & 126) | ((i3 >> 6) & 896), 0);
                navigationRoute = NotesTabContentScreen$lambda$0(stateCollectAsStateWithLifecycle).getNavigationRoute();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -103771969, "CC(remember):NotesTabsScreen.kt#9igjgp");
                boolean zChanged3 = composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle);
                if ((i3 & 7168) == 2048) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                boolean z9 = zChanged3 | z6;
                if (i6 == 4) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                zChangedInstance = z9 | z7 | composerStartRestartGroup.changedInstance(notesNavigator);
                notesTabsScreenKt$NotesTabContentScreen$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance) {
                    state = stateCollectAsStateWithLifecycle;
                    route = navigationRoute;
                    store2 = store;
                    notesTabsScreenKt$NotesTabContentScreen$3$1RememberedValue = new NotesTabsScreenKt$NotesTabContentScreen$3$1(function1, store, notesNavigator, state, null);
                    composerStartRestartGroup.updateRememberedValue(notesTabsScreenKt$NotesTabContentScreen$3$1RememberedValue);
                } else {
                    state = stateCollectAsStateWithLifecycle;
                    route = navigationRoute;
                    store2 = store;
                    notesTabsScreenKt$NotesTabContentScreen$3$1RememberedValue = new NotesTabsScreenKt$NotesTabContentScreen$3$1(function1, store, notesNavigator, state, null);
                    composerStartRestartGroup.updateRememberedValue(notesTabsScreenKt$NotesTabContentScreen$3$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(route, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) notesTabsScreenKt$NotesTabContentScreen$3$1RememberedValue, composerStartRestartGroup, 0);
                Lifecycle.Event event2 = Lifecycle.Event.ON_RESUME;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -103754168, "CC(remember):NotesTabsScreen.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(state) | (i6 == 4);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue3 = new Function0() { // from class: com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsScreenKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return NotesTabsScreenKt.NotesTabContentScreen$lambda$4$0(store2, state);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function0() { // from class: com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsScreenKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return NotesTabsScreenKt.NotesTabContentScreen$lambda$4$0(store2, state);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup = composerStartRestartGroup;
                LifecycleEffectKt.LifecycleEventEffect(event2, null, (Function0) objRememberedValue3, composerStartRestartGroup, 6, 2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
            }
            function4 = function3;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsScreenKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NotesTabsScreenKt.NotesTabContentScreen$lambda$5(store, itemsStateConfig, notesNavigator, function1, snackbarHostState, modifier3, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE;
        modifier2 = modifier;
        i4 = i2 & 64;
        if (i4 != 0) {
            if ((1572864 & i) == 0) {
                function3 = function2;
                if (composerStartRestartGroup.changedInstance(function3)) {
                    i5 = 1048576;
                } else {
                    i5 = 524288;
                }
                i3 |= i5;
            }
            if ((i3 & 599187) != 599186) {
                z = true;
            } else {
                z = false;
            }
            if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
                composerStartRestartGroup.skipToGroupEnd();
                modifier3 = modifier2;
            } else {
                if (i7 != 0) {
                    modifier4 = Modifier.INSTANCE;
                } else {
                    modifier4 = modifier2;
                }
                if (i4 != 0) {
                    function5 = null;
                } else {
                    function5 = function3;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(-505135392, i3, -1, "com.box.android.notes.navigationmodernization.tabsscreen.NotesTabContentScreen (NotesTabsScreen.kt:225)");
                }
                stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -103786933, "CC(remember):NotesTabsScreen.kt#9igjgp");
                i6 = i3 & 14;
                if (i6 == 4) {
                    z2 = true;
                } else {
                    z2 = false;
                }
                if ((3670016 & i3) == 1048576) {
                    z3 = true;
                } else {
                    z3 = false;
                }
                z4 = z3 | z2;
                objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (!z4) {
                    objRememberedValue = new Function1() { // from class: com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsScreenKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return NotesTabsScreenKt.NotesTabContentScreen$lambda$1$0(store, function5, ((Boolean) obj).booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                } else {
                    objRememberedValue = new Function1() { // from class: com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsScreenKt$$ExternalSyntheticLambda8
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return NotesTabsScreenKt.NotesTabContentScreen$lambda$1$0(store, function5, ((Boolean) obj).booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Modifier modifierOnVisibilityChanged$default3 = OnVisibilityChangedModifierKt.onVisibilityChanged$default(modifier4, 0L, 1.0f, null, (Function1) objRememberedValue, 5, null);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -103778606, "CC(remember):NotesTabsScreen.kt#9igjgp");
                if (i6 == 4) {
                    z5 = true;
                } else {
                    z5 = false;
                }
                objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (!z5) {
                    objRememberedValue2 = new Function1() { // from class: com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsScreenKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return NotesTabsScreenKt.NotesTabContentScreen$lambda$2$0(store, ((Boolean) obj).booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                } else {
                    objRememberedValue2 = new Function1() { // from class: com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsScreenKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return NotesTabsScreenKt.NotesTabContentScreen$lambda$2$0(store, ((Boolean) obj).booleanValue());
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                function3 = function5;
                NotesListScreenKt.NotesListScreen(store, itemsStateConfig2, snackbarHostState, OnVisibilityChangedModifierKt.onVisibilityChanged$default(modifierOnVisibilityChanged$default3, 0L, 0.0f, null, (Function1) objRememberedValue2, 5, null), composerStartRestartGroup, (i3 & 126) | ((i3 >> 6) & 896), 0);
                navigationRoute = NotesTabContentScreen$lambda$0(stateCollectAsStateWithLifecycle).getNavigationRoute();
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -103771969, "CC(remember):NotesTabsScreen.kt#9igjgp");
                boolean zChanged4 = composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle);
                if ((i3 & 7168) == 2048) {
                    z6 = true;
                } else {
                    z6 = false;
                }
                boolean z10 = zChanged4 | z6;
                if (i6 == 4) {
                    z7 = true;
                } else {
                    z7 = false;
                }
                zChangedInstance = z10 | z7 | composerStartRestartGroup.changedInstance(notesNavigator);
                notesTabsScreenKt$NotesTabContentScreen$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance) {
                    state = stateCollectAsStateWithLifecycle;
                    route = navigationRoute;
                    store2 = store;
                    notesTabsScreenKt$NotesTabContentScreen$3$1RememberedValue = new NotesTabsScreenKt$NotesTabContentScreen$3$1(function1, store, notesNavigator, state, null);
                    composerStartRestartGroup.updateRememberedValue(notesTabsScreenKt$NotesTabContentScreen$3$1RememberedValue);
                } else {
                    state = stateCollectAsStateWithLifecycle;
                    route = navigationRoute;
                    store2 = store;
                    notesTabsScreenKt$NotesTabContentScreen$3$1RememberedValue = new NotesTabsScreenKt$NotesTabContentScreen$3$1(function1, store, notesNavigator, state, null);
                    composerStartRestartGroup.updateRememberedValue(notesTabsScreenKt$NotesTabContentScreen$3$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(route, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) notesTabsScreenKt$NotesTabContentScreen$3$1RememberedValue, composerStartRestartGroup, 0);
                Lifecycle.Event event3 = Lifecycle.Event.ON_RESUME;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -103754168, "CC(remember):NotesTabsScreen.kt#9igjgp");
                zChanged = composerStartRestartGroup.changed(state) | (i6 == 4);
                objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (!zChanged) {
                    objRememberedValue3 = new Function0() { // from class: com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsScreenKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return NotesTabsScreenKt.NotesTabContentScreen$lambda$4$0(store2, state);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                } else {
                    objRememberedValue3 = new Function0() { // from class: com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsScreenKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return NotesTabsScreenKt.NotesTabContentScreen$lambda$4$0(store2, state);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                composerStartRestartGroup = composerStartRestartGroup;
                LifecycleEffectKt.LifecycleEventEffect(event3, null, (Function0) objRememberedValue3, composerStartRestartGroup, 6, 2);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
            }
            function4 = function3;
            scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsScreenKt$$ExternalSyntheticLambda12
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return NotesTabsScreenKt.NotesTabContentScreen$lambda$5(store, itemsStateConfig, notesNavigator, function1, snackbarHostState, modifier3, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i3 |= 1572864;
        function3 = function2;
        if ((i3 & 599187) != 599186) {
            z = true;
        } else {
            z = false;
        }
        if (composerStartRestartGroup.shouldExecute(z, i3 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
            modifier3 = modifier2;
        } else {
            if (i7 != 0) {
                modifier4 = Modifier.INSTANCE;
            } else {
                modifier4 = modifier2;
            }
            if (i4 != 0) {
                function5 = null;
            } else {
                function5 = function3;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-505135392, i3, -1, "com.box.android.notes.navigationmodernization.tabsscreen.NotesTabContentScreen (NotesTabsScreen.kt:225)");
            }
            stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composerStartRestartGroup, 0, 7);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -103786933, "CC(remember):NotesTabsScreen.kt#9igjgp");
            i6 = i3 & 14;
            if (i6 == 4) {
                z2 = true;
            } else {
                z2 = false;
            }
            if ((3670016 & i3) == 1048576) {
                z3 = true;
            } else {
                z3 = false;
            }
            z4 = z3 | z2;
            objRememberedValue = composerStartRestartGroup.rememberedValue();
            if (!z4) {
                objRememberedValue = new Function1() { // from class: com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsScreenKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NotesTabsScreenKt.NotesTabContentScreen$lambda$1$0(store, function5, ((Boolean) obj).booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            } else {
                objRememberedValue = new Function1() { // from class: com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsScreenKt$$ExternalSyntheticLambda8
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NotesTabsScreenKt.NotesTabContentScreen$lambda$1$0(store, function5, ((Boolean) obj).booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Modifier modifierOnVisibilityChanged$default4 = OnVisibilityChangedModifierKt.onVisibilityChanged$default(modifier4, 0L, 1.0f, null, (Function1) objRememberedValue, 5, null);
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -103778606, "CC(remember):NotesTabsScreen.kt#9igjgp");
            if (i6 == 4) {
                z5 = true;
            } else {
                z5 = false;
            }
            objRememberedValue2 = composerStartRestartGroup.rememberedValue();
            if (!z5) {
                objRememberedValue2 = new Function1() { // from class: com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsScreenKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NotesTabsScreenKt.NotesTabContentScreen$lambda$2$0(store, ((Boolean) obj).booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            } else {
                objRememberedValue2 = new Function1() { // from class: com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsScreenKt$$ExternalSyntheticLambda9
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return NotesTabsScreenKt.NotesTabContentScreen$lambda$2$0(store, ((Boolean) obj).booleanValue());
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            function3 = function5;
            NotesListScreenKt.NotesListScreen(store, itemsStateConfig2, snackbarHostState, OnVisibilityChangedModifierKt.onVisibilityChanged$default(modifierOnVisibilityChanged$default4, 0L, 0.0f, null, (Function1) objRememberedValue2, 5, null), composerStartRestartGroup, (i3 & 126) | ((i3 >> 6) & 896), 0);
            navigationRoute = NotesTabContentScreen$lambda$0(stateCollectAsStateWithLifecycle).getNavigationRoute();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -103771969, "CC(remember):NotesTabsScreen.kt#9igjgp");
            boolean zChanged5 = composerStartRestartGroup.changed(stateCollectAsStateWithLifecycle);
            if ((i3 & 7168) == 2048) {
                z6 = true;
            } else {
                z6 = false;
            }
            boolean z11 = zChanged5 | z6;
            if (i6 == 4) {
                z7 = true;
            } else {
                z7 = false;
            }
            zChangedInstance = z11 | z7 | composerStartRestartGroup.changedInstance(notesNavigator);
            notesTabsScreenKt$NotesTabContentScreen$3$1RememberedValue = composerStartRestartGroup.rememberedValue();
            if (zChangedInstance) {
                state = stateCollectAsStateWithLifecycle;
                route = navigationRoute;
                store2 = store;
                notesTabsScreenKt$NotesTabContentScreen$3$1RememberedValue = new NotesTabsScreenKt$NotesTabContentScreen$3$1(function1, store, notesNavigator, state, null);
                composerStartRestartGroup.updateRememberedValue(notesTabsScreenKt$NotesTabContentScreen$3$1RememberedValue);
            } else {
                state = stateCollectAsStateWithLifecycle;
                route = navigationRoute;
                store2 = store;
                notesTabsScreenKt$NotesTabContentScreen$3$1RememberedValue = new NotesTabsScreenKt$NotesTabContentScreen$3$1(function1, store, notesNavigator, state, null);
                composerStartRestartGroup.updateRememberedValue(notesTabsScreenKt$NotesTabContentScreen$3$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            EffectsKt.LaunchedEffect(route, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) notesTabsScreenKt$NotesTabContentScreen$3$1RememberedValue, composerStartRestartGroup, 0);
            Lifecycle.Event event4 = Lifecycle.Event.ON_RESUME;
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -103754168, "CC(remember):NotesTabsScreen.kt#9igjgp");
            zChanged = composerStartRestartGroup.changed(state) | (i6 == 4);
            objRememberedValue3 = composerStartRestartGroup.rememberedValue();
            if (!zChanged) {
                objRememberedValue3 = new Function0() { // from class: com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsScreenKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return NotesTabsScreenKt.NotesTabContentScreen$lambda$4$0(store2, state);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            } else {
                objRememberedValue3 = new Function0() { // from class: com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsScreenKt$$ExternalSyntheticLambda10
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return NotesTabsScreenKt.NotesTabContentScreen$lambda$4$0(store2, state);
                    }
                };
                composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
            }
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            composerStartRestartGroup = composerStartRestartGroup;
            LifecycleEffectKt.LifecycleEventEffect(event4, null, (Function0) objRememberedValue3, composerStartRestartGroup, 6, 2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier4;
        }
        function4 = function3;
        scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.notes.navigationmodernization.tabsscreen.NotesTabsScreenKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return NotesTabsScreenKt.NotesTabContentScreen$lambda$5(store, itemsStateConfig, notesNavigator, function1, snackbarHostState, modifier3, function4, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotesTabContentScreen$lambda$1$0(Store store, Function1 function1, boolean z) {
        if (z) {
            store.send(NotesListReducer.Action.TabVisible.INSTANCE);
        }
        if (function1 != null) {
            function1.invoke(Boolean.valueOf(z));
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotesTabContentScreen$lambda$2$0(Store store, boolean z) {
        if (!z) {
            store.send(NotesListReducer.Action.TabHidden.INSTANCE);
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit NotesTabContentScreen$lambda$4$0(Store store, State state) {
        if (NotesTabContentScreen$lambda$0(state).getVisible()) {
            store.send(NotesListReducer.Action.TabVisible.INSTANCE);
        }
        return Unit.INSTANCE;
    }

    private static final int getTitleRes(NotesDestination.InnerDestination.TabsScreen.NotesTab notesTab) {
        int i = WhenMappings.$EnumSwitchMapping$0[notesTab.ordinal()];
        if (i == 1) {
            return R.string.subtitle_recents_notes;
        }
        if (i != 2) {
            throw new NoWhenBranchMatchedException();
        }
        return R.string.subtitle_favorites_notes;
    }

    private static final NotesListReducer.State NotesTabsScreen$lambda$1(State<NotesListReducer.State> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final NotesListReducer.State NotesTabContentScreen$lambda$0(State<NotesListReducer.State> state) {
        return state.getValue();
    }
}

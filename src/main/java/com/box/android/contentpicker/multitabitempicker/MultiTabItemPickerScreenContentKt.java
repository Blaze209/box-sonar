package com.box.android.contentpicker.multitabitempicker;

import android.app.Activity;
import android.content.Intent;
import androidx.activity.ComponentActivity;
import androidx.activity.OnBackPressedDispatcher;
import androidx.activity.OnBackPressedDispatcherOwner;
import androidx.activity.compose.LocalActivityKt;
import androidx.activity.compose.LocalOnBackPressedDispatcherOwner;
import androidx.compose.animation.AnimatedContentScope;
import androidx.compose.animation.AnimatedVisibilityKt;
import androidx.compose.animation.AnimatedVisibilityScope;
import androidx.compose.animation.EnterExitTransitionKt;
import androidx.compose.animation.EnterTransition;
import androidx.compose.foundation.BackgroundKt;
import androidx.compose.foundation.BorderStroke;
import androidx.compose.foundation.DarkThemeKt;
import androidx.compose.foundation.interaction.MutableInteractionSource;
import androidx.compose.foundation.layout.Arrangement;
import androidx.compose.foundation.layout.BoxKt;
import androidx.compose.foundation.layout.BoxScopeInstance;
import androidx.compose.foundation.layout.PaddingKt;
import androidx.compose.foundation.layout.PaddingValues;
import androidx.compose.foundation.layout.RowKt;
import androidx.compose.foundation.layout.RowScope;
import androidx.compose.foundation.layout.RowScopeInstance;
import androidx.compose.foundation.layout.SizeKt;
import androidx.compose.foundation.layout.SpacerKt;
import androidx.compose.foundation.layout.WindowInsets;
import androidx.compose.foundation.layout.WindowInsetsKt;
import androidx.compose.foundation.layout.WindowInsetsPaddingKt;
import androidx.compose.foundation.layout.WindowInsetsPadding_androidKt;
import androidx.compose.foundation.layout.WindowInsetsSides;
import androidx.compose.foundation.layout.WindowInsets_androidKt;
import androidx.compose.foundation.shape.RoundedCornerShapeKt;
import androidx.compose.material3.ButtonDefaults;
import androidx.compose.material3.ButtonElevation;
import androidx.compose.material3.ButtonKt;
import androidx.compose.material3.IconButtonColors;
import androidx.compose.material3.IconButtonKt;
import androidx.compose.material3.MaterialTheme;
import androidx.compose.material3.ScaffoldKt;
import androidx.compose.material3.SurfaceKt;
import androidx.compose.material3.TextKt;
import androidx.compose.runtime.Applier;
import androidx.compose.runtime.ComposablesKt;
import androidx.compose.runtime.Composer;
import androidx.compose.runtime.ComposerKt;
import androidx.compose.runtime.CompositionLocalKt;
import androidx.compose.runtime.CompositionLocalMap;
import androidx.compose.runtime.DisposableEffectResult;
import androidx.compose.runtime.DisposableEffectScope;
import androidx.compose.runtime.EffectsKt;
import androidx.compose.runtime.MutableIntState;
import androidx.compose.runtime.MutableState;
import androidx.compose.runtime.ProvidableCompositionLocal;
import androidx.compose.runtime.ProvidedValue;
import androidx.compose.runtime.RecomposeScopeImplKt;
import androidx.compose.runtime.ScopeUpdateScope;
import androidx.compose.runtime.SnapshotIntStateKt;
import androidx.compose.runtime.SnapshotStateKt__SnapshotStateKt;
import androidx.compose.runtime.State;
import androidx.compose.runtime.Updater;
import androidx.compose.runtime.internal.ComposableLambdaKt;
import androidx.compose.runtime.saveable.RememberSaveableKt;
import androidx.compose.ui.Alignment;
import androidx.compose.ui.ComposedModifierKt;
import androidx.compose.ui.Modifier;
import androidx.compose.ui.graphics.Color;
import androidx.compose.ui.graphics.Shape;
import androidx.compose.ui.layout.MeasurePolicy;
import androidx.compose.ui.node.ComposeUiNode;
import androidx.compose.ui.res.StringResources_androidKt;
import androidx.compose.ui.unit.Dp;
import androidx.hilt.navigation.compose.HiltViewModelKt;
import androidx.lifecycle.HasDefaultViewModelProviderFactory;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.lifecycle.compose.FlowExtKt;
import androidx.lifecycle.viewmodel.CreationExtras;
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner;
import androidx.lifecycle.viewmodel.compose.ViewModelKt;
import androidx.media3.extractor.ts.PsExtractor;
import androidx.navigation.NavBackStackEntry;
import androidx.navigation.NavController;
import androidx.navigation.NavGraphBuilder;
import androidx.navigation.NavHostController;
import androidx.navigation.NavOptions;
import androidx.navigation.Navigator;
import androidx.navigation.compose.NavGraphBuilderKt;
import androidx.navigation.compose.NavHostControllerKt;
import androidx.navigation.compose.NavHostKt;
import androidx.profileinstaller.ProfileVerifier;
import com.box.android.base.compose.BoxColorPalette;
import com.box.android.base.compose.BoxTheme;
import com.box.android.base.compose.BoxThemeKt;
import com.box.android.base.compose.ComposeUtilsKt;
import com.box.android.base.presentation.components.tabscreen.CommonTabsScreenKt;
import com.box.android.browse.R;
import com.box.android.browse.cpl.RecentsItemPickerViewModel;
import com.box.android.browse.cpl.browse.FolderItemPickerScreenKt;
import com.box.android.browse.cpl.itempicker.FolderItemPickerViewModel;
import com.box.android.browse.cpl.itempicker.RecentsItemPickerScreenKt;
import com.box.android.collections.itempicker.CollectionItemPickerScreenKt;
import com.box.android.collections.itempicker.CollectionItemPickerViewModels;
import com.box.android.contentpicker.ContentPickerActivityKt;
import com.box.android.contentpicker.ContentPickerReducer;
import com.box.android.contentpicker.ContentPickerViewModel;
import com.box.android.cpl.Store;
import com.box.android.domain.models.ItemId;
import com.box.android.domain.models.item.FolderModel;
import com.box.android.hubs.presentation.HubsItemPickerScreenKt;
import com.box.android.hubs.presentation.HubsItemPickerViewModel;
import com.box.android.search.presentation.ui.SearchItemPickerScreenKt;
import com.box.android.search.presentation.ui.SearchItemPickerViewModels;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.CoroutineContext;
import kotlin.enums.EnumEntries;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;

/* JADX INFO: compiled from: MultiTabItemPickerScreenContent.kt */
/* JADX INFO: loaded from: classes10.dex */
@Metadata(d1 = {"\u0000n\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u001a\r\u0010\u0000\u001a\u00020\u0001H\u0007¢\u0006\u0002\u0010\u0002\u001aE\u0010\b\u001a\u00020\t2\u000e\b\u0002\u0010\n\u001a\b\u0012\u0004\u0012\u00020\u00050\u000b2\b\b\u0002\u0010\f\u001a\u00020\u00052\b\b\u0002\u0010\r\u001a\u00020\u00012\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u0007¢\u0006\u0002\u0010\u0012\u001a;\u0010\u0013\u001a\u00020\t2\u0006\u0010\u0014\u001a\u00020\u00152\f\u0010\u0016\u001a\b\u0012\u0004\u0012\u00020\t0\u00172\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\t0\u00172\b\b\u0002\u0010\u0019\u001a\u00020\u001aH\u0003¢\u0006\u0002\u0010\u001b\u001a(\u0010\u001c\u001a\u00020\t2\u0006\u0010\u001d\u001a\u00020\u001e2\u0011\u0010\u001f\u001a\r\u0012\u0004\u0012\u00020\t0\u0017¢\u0006\u0002\b H\u0003¢\u0006\u0002\u0010!\u001a\r\u0010\"\u001a\u00020\tH\u0007¢\u0006\u0002\u0010#\"\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007¨\u0006$²\u0006\n\u0010%\u001a\u00020\u0005X\u008a\u008e\u0002²\u0006\n\u0010&\u001a\u00020'X\u008a\u0084\u0002²\u0006\f\u0010(\u001a\u0004\u0018\u00010\u0011X\u008a\u008e\u0002²\u0006\u0010\u0010)\u001a\b\u0012\u0004\u0012\u00020*0\u000bX\u008a\u008e\u0002²\u0006\u0016\u0010+\u001a\u000e\u0012\u0004\u0012\u00020-\u0012\u0004\u0012\u00020\t0,X\u008a\u008e\u0002²\u0006\n\u0010.\u001a\u00020\u0015X\u008a\u008e\u0002"}, d2 = {"defaultMultiTabItemPickerViewModels", "Lcom/box/android/contentpicker/multitabitempicker/MultiTabItemPickerViewModels;", "(Landroidx/compose/runtime/Composer;I)Lcom/box/android/contentpicker/multitabitempicker/MultiTabItemPickerViewModels;", "defaultEnabledTabs", "Lkotlin/enums/EnumEntries;", "Lcom/box/android/contentpicker/multitabitempicker/ItemPickerTab;", "getDefaultEnabledTabs", "()Lkotlin/enums/EnumEntries;", "MultiTabItemPickerScreenContent", "", "enabledTabs", "", "defaultTab", "viewModels", "contentPickerViewModel", "Lcom/box/android/contentpicker/ContentPickerViewModel;", "startDestination", "", "(Ljava/util/List;Lcom/box/android/contentpicker/multitabitempicker/ItemPickerTab;Lcom/box/android/contentpicker/multitabitempicker/MultiTabItemPickerViewModels;Lcom/box/android/contentpicker/ContentPickerViewModel;Ljava/lang/String;Landroidx/compose/runtime/Composer;II)V", "SelectionFloatingBar", "selectedCount", "", "onDeselectAllClicked", "Lkotlin/Function0;", "onAddClicked", "modifier", "Landroidx/compose/ui/Modifier;", "(ILkotlin/jvm/functions/Function0;Lkotlin/jvm/functions/Function0;Landroidx/compose/ui/Modifier;Landroidx/compose/runtime/Composer;II)V", "ResettableTabContent", "isCurrentTab", "", "content", "Landroidx/compose/runtime/Composable;", "(ZLkotlin/jvm/functions/Function2;Landroidx/compose/runtime/Composer;I)V", "SelectionFloatingBarPreview", "(Landroidx/compose/runtime/Composer;I)V", "content-picker_generalProdRelease", "currentTab", "contentPickerState", "Lcom/box/android/contentpicker/ContentPickerReducer$State;", "subNavigationTitle", "folderBreadcrumbs", "Lcom/box/android/domain/models/item/FolderModel;", "goBackToFolder", "Lkotlin/Function1;", "Lcom/box/android/domain/models/ItemId$Remote;", "resetKey"}, k = 2, mv = {2, 2, 0}, xi = 48)
public final class MultiTabItemPickerScreenContentKt {
    private static final EnumEntries<ItemPickerTab> defaultEnabledTabs = ItemPickerTab.getEntries();

    /* JADX INFO: compiled from: MultiTabItemPickerScreenContent.kt */
    @Metadata(k = 3, mv = {2, 2, 0}, xi = 48)
    public static final /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0;

        static {
            int[] iArr = new int[ItemPickerTab.values().length];
            try {
                iArr[ItemPickerTab.RECENTS.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                iArr[ItemPickerTab.FILES.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                iArr[ItemPickerTab.COLLECTIONS.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                iArr[ItemPickerTab.HUBS.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            $EnumSwitchMapping$0 = iArr;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int MultiTabItemPickerScreenContent$lambda$17$1$0(int i) {
        return i;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int MultiTabItemPickerScreenContent$lambda$17$2$0(int i) {
        return i * 2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiTabItemPickerScreenContent$lambda$18(List list, ItemPickerTab itemPickerTab, MultiTabItemPickerViewModels multiTabItemPickerViewModels, ContentPickerViewModel contentPickerViewModel, String str, int i, int i2, Composer composer, int i3) {
        MultiTabItemPickerScreenContent(list, itemPickerTab, multiTabItemPickerViewModels, contentPickerViewModel, str, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1), i2);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit ResettableTabContent$lambda$6(boolean z, Function2 function2, int i, Composer composer, int i2) {
        ResettableTabContent(z, function2, composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectionFloatingBar$lambda$1(int i, Function0 function0, Function0 function1, Modifier modifier, int i2, int i3, Composer composer, int i4) {
        SelectionFloatingBar(i, function0, function1, modifier, composer, RecomposeScopeImplKt.updateChangedFlags(i2 | 1), i3);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectionFloatingBarPreview$lambda$0(int i, Composer composer, int i2) {
        SelectionFloatingBarPreview(composer, RecomposeScopeImplKt.updateChangedFlags(i | 1));
        return Unit.INSTANCE;
    }

    public static final MultiTabItemPickerViewModels defaultMultiTabItemPickerViewModels(Composer composer, int i) {
        ComposerKt.sourceInformationMarkerStart(composer, -801391680, "C(defaultMultiTabItemPickerViewModels)100@5227L384:MultiTabItemPickerScreenContent.kt#aug1cj");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-801391680, i, -1, "com.box.android.contentpicker.multitabitempicker.defaultMultiTabItemPickerViewModels (MultiTabItemPickerScreenContent.kt:100)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, -1338255744, "CC(remember):MultiTabItemPickerScreenContent.kt#9igjgp");
        Object objRememberedValue = composer.rememberedValue();
        if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
            MultiTabItemPickerViewModels multiTabItemPickerViewModels = new MultiTabItemPickerViewModels(new Function2() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerScreenContentKt$$ExternalSyntheticLambda4
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MultiTabItemPickerScreenContentKt.defaultMultiTabItemPickerViewModels$lambda$0$0((Composer) obj, ((Integer) obj2).intValue());
                }
            }, new Function2() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerScreenContentKt$$ExternalSyntheticLambda5
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MultiTabItemPickerScreenContentKt.defaultMultiTabItemPickerViewModels$lambda$0$1((Composer) obj, ((Integer) obj2).intValue());
                }
            }, new Function2() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerScreenContentKt$$ExternalSyntheticLambda6
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MultiTabItemPickerScreenContentKt.defaultMultiTabItemPickerViewModels$lambda$0$2((Composer) obj, ((Integer) obj2).intValue());
                }
            }, new Function2() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerScreenContentKt$$ExternalSyntheticLambda7
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MultiTabItemPickerScreenContentKt.defaultMultiTabItemPickerViewModels$lambda$0$3((Composer) obj, ((Integer) obj2).intValue());
                }
            }, new Function2() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerScreenContentKt$$ExternalSyntheticLambda8
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MultiTabItemPickerScreenContentKt.defaultMultiTabItemPickerViewModels$lambda$0$4((Composer) obj, ((Integer) obj2).intValue());
                }
            });
            composer.updateRememberedValue(multiTabItemPickerViewModels);
            objRememberedValue = multiTabItemPickerViewModels;
        }
        MultiTabItemPickerViewModels multiTabItemPickerViewModels2 = (MultiTabItemPickerViewModels) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        return multiTabItemPickerViewModels2;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final FolderItemPickerViewModel defaultMultiTabItemPickerViewModels$lambda$0$0(Composer composer, int i) {
        CreationExtras.Empty defaultViewModelCreationExtras;
        composer.startReplaceGroup(-1997711284);
        ComposerKt.sourceInformation(composer, "C102@5310L15:MultiTabItemPickerScreenContent.kt#aug1cj");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1997711284, i, -1, "com.box.android.contentpicker.multitabitempicker.defaultMultiTabItemPickerViewModels.<anonymous>.<anonymous> (MultiTabItemPickerScreenContent.kt:102)");
        }
        composer.startReplaceableGroup(1890788296);
        ComposerKt.sourceInformation(composer, "CC(hiltViewModel)P(1)*45@1969L7,50@2112L47,51@2171L54:HiltViewModel.kt#9mcars");
        ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
        if (current == null) {
            throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
        }
        ViewModelProvider.Factory factoryCreateHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
        composer.startReplaceableGroup(1729797275);
        ComposerKt.sourceInformation(composer, "CC(viewModel)P(3,2,1)*80@3834L7,90@4209L68:ViewModel.kt#3tja67");
        if (current instanceof HasDefaultViewModelProviderFactory) {
            defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
        } else {
            defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
        }
        ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) FolderItemPickerViewModel.class, current, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composer, 36936, 0);
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        FolderItemPickerViewModel folderItemPickerViewModel = (FolderItemPickerViewModel) viewModel;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return folderItemPickerViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final CollectionItemPickerViewModels defaultMultiTabItemPickerViewModels$lambda$0$1(Composer composer, int i) {
        composer.startReplaceGroup(-41179370);
        ComposerKt.sourceInformation(composer, "C103@5372L39:MultiTabItemPickerScreenContent.kt#aug1cj");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-41179370, i, -1, "com.box.android.contentpicker.multitabitempicker.defaultMultiTabItemPickerViewModels.<anonymous>.<anonymous> (MultiTabItemPickerScreenContent.kt:103)");
        }
        CollectionItemPickerViewModels collectionItemPickerViewModelsDefaultCollectionItemPickerViewModels = CollectionItemPickerScreenKt.defaultCollectionItemPickerViewModels(composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return collectionItemPickerViewModelsDefaultCollectionItemPickerViewModels;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final HubsItemPickerViewModel defaultMultiTabItemPickerViewModels$lambda$0$2(Composer composer, int i) {
        CreationExtras.Empty defaultViewModelCreationExtras;
        composer.startReplaceGroup(-571616838);
        ComposerKt.sourceInformation(composer, "C104@5450L15:MultiTabItemPickerScreenContent.kt#aug1cj");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-571616838, i, -1, "com.box.android.contentpicker.multitabitempicker.defaultMultiTabItemPickerViewModels.<anonymous>.<anonymous> (MultiTabItemPickerScreenContent.kt:104)");
        }
        composer.startReplaceableGroup(1890788296);
        ComposerKt.sourceInformation(composer, "CC(hiltViewModel)P(1)*45@1969L7,50@2112L47,51@2171L54:HiltViewModel.kt#9mcars");
        ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
        if (current == null) {
            throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
        }
        ViewModelProvider.Factory factoryCreateHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
        composer.startReplaceableGroup(1729797275);
        ComposerKt.sourceInformation(composer, "CC(viewModel)P(3,2,1)*80@3834L7,90@4209L68:ViewModel.kt#3tja67");
        if (current instanceof HasDefaultViewModelProviderFactory) {
            defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
        } else {
            defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
        }
        ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) HubsItemPickerViewModel.class, current, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composer, 36936, 0);
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        HubsItemPickerViewModel hubsItemPickerViewModel = (HubsItemPickerViewModel) viewModel;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return hubsItemPickerViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final RecentsItemPickerViewModel defaultMultiTabItemPickerViewModels$lambda$0$3(Composer composer, int i) {
        CreationExtras.Empty defaultViewModelCreationExtras;
        composer.startReplaceGroup(-557874473);
        ComposerKt.sourceInformation(composer, "C105@5508L15:MultiTabItemPickerScreenContent.kt#aug1cj");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-557874473, i, -1, "com.box.android.contentpicker.multitabitempicker.defaultMultiTabItemPickerViewModels.<anonymous>.<anonymous> (MultiTabItemPickerScreenContent.kt:105)");
        }
        composer.startReplaceableGroup(1890788296);
        ComposerKt.sourceInformation(composer, "CC(hiltViewModel)P(1)*45@1969L7,50@2112L47,51@2171L54:HiltViewModel.kt#9mcars");
        ViewModelStoreOwner current = LocalViewModelStoreOwner.INSTANCE.getCurrent(composer, LocalViewModelStoreOwner.$stable);
        if (current == null) {
            throw new IllegalStateException("No ViewModelStoreOwner was provided via LocalViewModelStoreOwner".toString());
        }
        ViewModelProvider.Factory factoryCreateHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(current, composer, 0);
        composer.startReplaceableGroup(1729797275);
        ComposerKt.sourceInformation(composer, "CC(viewModel)P(3,2,1)*80@3834L7,90@4209L68:ViewModel.kt#3tja67");
        if (current instanceof HasDefaultViewModelProviderFactory) {
            defaultViewModelCreationExtras = ((HasDefaultViewModelProviderFactory) current).getDefaultViewModelCreationExtras();
        } else {
            defaultViewModelCreationExtras = CreationExtras.Empty.INSTANCE;
        }
        ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) RecentsItemPickerViewModel.class, current, (String) null, factoryCreateHiltViewModelFactory, defaultViewModelCreationExtras, composer, 36936, 0);
        composer.endReplaceableGroup();
        composer.endReplaceableGroup();
        RecentsItemPickerViewModel recentsItemPickerViewModel = (RecentsItemPickerViewModel) viewModel;
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return recentsItemPickerViewModel;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final SearchItemPickerViewModels defaultMultiTabItemPickerViewModels$lambda$0$4(Composer composer, int i) {
        composer.startReplaceGroup(-960255703);
        ComposerKt.sourceInformation(composer, "C106@5566L35:MultiTabItemPickerScreenContent.kt#aug1cj");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-960255703, i, -1, "com.box.android.contentpicker.multitabitempicker.defaultMultiTabItemPickerViewModels.<anonymous>.<anonymous> (MultiTabItemPickerScreenContent.kt:106)");
        }
        SearchItemPickerViewModels searchItemPickerViewModelsDefaultSearchItemPickerViewModels = SearchItemPickerScreenKt.defaultSearchItemPickerViewModels(composer, 0);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return searchItemPickerViewModelsDefaultSearchItemPickerViewModels;
    }

    public static final EnumEntries<ItemPickerTab> getDefaultEnabledTabs() {
        return defaultEnabledTabs;
    }

    /* JADX WARN: Code duplicated, block: B:23:0x0048  */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public static final void MultiTabItemPickerScreenContent(List<? extends ItemPickerTab> list, ItemPickerTab itemPickerTab, MultiTabItemPickerViewModels multiTabItemPickerViewModels, ContentPickerViewModel contentPickerViewModel, String str, Composer composer, final int i, final int i2) {
        final EnumEntries<ItemPickerTab> enumEntries;
        int i3;
        MultiTabItemPickerViewModels multiTabItemPickerViewModelsDefaultMultiTabItemPickerViewModels;
        ContentPickerViewModel contentPickerViewModel2;
        String str2;
        Composer composer2;
        final ItemPickerTab itemPickerTab2;
        final String str3;
        final MultiTabItemPickerViewModels multiTabItemPickerViewModels2;
        final ContentPickerViewModel contentPickerViewModel3;
        int i4;
        ItemPickerTab itemPickerTab3;
        int i5;
        String str4;
        Composer composer3;
        String route;
        int i6;
        ContentPickerViewModel contentPickerViewModel4;
        final List<? extends ItemPickerTab> list2;
        final MultiTabItemPickerViewModels multiTabItemPickerViewModels3;
        final NavHostController navHostController;
        final Store<ContentPickerReducer.State, ContentPickerReducer.Action> store;
        int i7;
        Composer composerStartRestartGroup = composer.startRestartGroup(-1423506017);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(MultiTabItemPickerScreenContent)N(enabledTabs,defaultTab,viewModels,contentPickerViewModel,startDestination)120@6093L7,121@6125L23,122@6171L39,124@6298L29,126@6359L42,127@6431L59,128@6517L62,130@6606L79,130@6585L100,134@6718L111,134@6691L138,138@6873L246,138@6862L257,145@7180L7,146@7248L60,146@7237L71,154@7396L6,156@7497L11,151@7314L5068:MultiTabItemPickerScreenContent.kt#aug1cj");
        if ((i & 6) == 0) {
            if ((i2 & 1) == 0) {
                enumEntries = list;
                int i8 = composerStartRestartGroup.changedInstance(enumEntries) ? 4 : 2;
                i3 = i8 | i;
            } else {
                enumEntries = list;
            }
            i3 = i8 | i;
        } else {
            enumEntries = list;
            i3 = i;
        }
        if ((i & 48) == 0) {
            if ((i2 & 2) != 0) {
                i7 = 16;
            } else {
                if (composerStartRestartGroup.changed(itemPickerTab == null ? -1 : itemPickerTab.ordinal())) {
                    i7 = 32;
                } else {
                    i7 = 16;
                }
            }
            i3 |= i7;
        }
        if ((i & 384) == 0) {
            if ((i2 & 4) == 0) {
                multiTabItemPickerViewModelsDefaultMultiTabItemPickerViewModels = multiTabItemPickerViewModels;
                int i9 = composerStartRestartGroup.changed(multiTabItemPickerViewModelsDefaultMultiTabItemPickerViewModels) ? 256 : 128;
                i3 |= i9;
            } else {
                multiTabItemPickerViewModelsDefaultMultiTabItemPickerViewModels = multiTabItemPickerViewModels;
            }
            i3 |= i9;
        } else {
            multiTabItemPickerViewModelsDefaultMultiTabItemPickerViewModels = multiTabItemPickerViewModels;
        }
        if ((i & 3072) == 0) {
            if ((i2 & 8) == 0) {
                contentPickerViewModel2 = contentPickerViewModel;
                int i10 = composerStartRestartGroup.changedInstance(contentPickerViewModel2) ? 2048 : 1024;
                i3 |= i10;
            } else {
                contentPickerViewModel2 = contentPickerViewModel;
            }
            i3 |= i10;
        } else {
            contentPickerViewModel2 = contentPickerViewModel;
        }
        if ((i & 24576) == 0) {
            if ((i2 & 16) == 0) {
                str2 = str;
                int i11 = composerStartRestartGroup.changed(str2) ? 16384 : 8192;
                i3 |= i11;
            } else {
                str2 = str;
            }
            i3 |= i11;
        } else {
            str2 = str;
        }
        if (composerStartRestartGroup.shouldExecute((i3 & 9363) != 9362, i3 & 1)) {
            composerStartRestartGroup.startDefaults();
            ComposerKt.sourceInformation(composerStartRestartGroup, "116@5869L37,117@5961L23");
            if ((i & 1) == 0 || composerStartRestartGroup.getDefaultsInvalid()) {
                if ((i2 & 1) != 0) {
                    enumEntries = defaultEnabledTabs;
                    i3 &= -15;
                }
                if ((i2 & 2) != 0) {
                    i4 = i3 & (-113);
                    itemPickerTab3 = (ItemPickerTab) CollectionsKt.first((List) enumEntries);
                } else {
                    i4 = i3;
                    itemPickerTab3 = itemPickerTab;
                }
                if ((i2 & 4) != 0) {
                    multiTabItemPickerViewModelsDefaultMultiTabItemPickerViewModels = defaultMultiTabItemPickerViewModels(composerStartRestartGroup, 0);
                    i4 &= -897;
                }
                if ((i2 & 8) != 0) {
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, -1447482489, "CC(hiltActivityViewModel)N(key)159@5773L7,160@5813L56:ComposeUtils.kt#vejmn0");
                    ProvidableCompositionLocal<Activity> localActivity = LocalActivityKt.getLocalActivity();
                    ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
                    Object objConsume = composerStartRestartGroup.consume(localActivity);
                    ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                    Intrinsics.checkNotNull(objConsume, "null cannot be cast to non-null type androidx.activity.ComponentActivity");
                    ComponentActivity componentActivity = (ComponentActivity) objConsume;
                    composerStartRestartGroup.startReplaceableGroup(1890788296);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(hiltViewModel)P(1)*45@1969L7,50@2112L47,51@2171L54:HiltViewModel.kt#9mcars");
                    ViewModelProvider.Factory factoryCreateHiltViewModelFactory = HiltViewModelKt.createHiltViewModelFactory(componentActivity, composerStartRestartGroup, 0);
                    composerStartRestartGroup.startReplaceableGroup(1729797275);
                    ComposerKt.sourceInformation(composerStartRestartGroup, "CC(viewModel)P(3,2,1)*80@3834L7,90@4209L68:ViewModel.kt#3tja67");
                    int i12 = i4;
                    composer3 = composerStartRestartGroup;
                    str4 = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                    ViewModel viewModel = ViewModelKt.viewModel((Class<ViewModel>) ContentPickerViewModel.class, componentActivity, (String) null, factoryCreateHiltViewModelFactory, componentActivity instanceof HasDefaultViewModelProviderFactory ? componentActivity.getDefaultViewModelCreationExtras() : CreationExtras.Empty.INSTANCE, composer3, 36936, 0);
                    composer3.endReplaceableGroup();
                    composer3.endReplaceableGroup();
                    ComposerKt.sourceInformationMarkerEnd(composer3);
                    i5 = i12 & (-7169);
                    contentPickerViewModel2 = (ContentPickerViewModel) viewModel;
                } else {
                    i5 = i4;
                    str4 = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                    composer3 = composerStartRestartGroup;
                }
                if ((i2 & 16) != 0) {
                    i5 &= -57345;
                    route = MultiItemPickerDestination.Items.INSTANCE.getRoute();
                } else {
                    route = str;
                }
                i6 = i5;
                contentPickerViewModel4 = contentPickerViewModel2;
            } else {
                composerStartRestartGroup.skipToGroupEnd();
                if ((i2 & 1) != 0) {
                    i3 &= -15;
                }
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
                i6 = i3;
                contentPickerViewModel4 = contentPickerViewModel2;
                route = str2;
                composer3 = composerStartRestartGroup;
                str4 = "CC(<get-current>):CompositionLocal.kt#9igjgp";
                itemPickerTab3 = itemPickerTab;
            }
            composer3.endDefaults();
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1423506017, i6, -1, "com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerScreenContent (MultiTabItemPickerScreenContent.kt:119)");
            }
            ProvidableCompositionLocal<Activity> localActivity2 = LocalActivityKt.getLocalActivity();
            ComposerKt.sourceInformationMarkerStart(composer3, 2023513938, str4);
            Object objConsume2 = composer3.consume(localActivity2);
            ComposerKt.sourceInformationMarkerEnd(composer3);
            final Activity activity = (Activity) objConsume2;
            NavHostController navHostControllerRememberNavController = NavHostControllerKt.rememberNavController(new Navigator[0], composer3, 0);
            ComposerKt.sourceInformationMarkerStart(composer3, 2105301062, "CC(remember):MultiTabItemPickerScreenContent.kt#9igjgp");
            Object objRememberedValue = composer3.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(itemPickerTab3, null, 2, null);
                composer3.updateRememberedValue(objRememberedValue);
            }
            final MutableState mutableState = (MutableState) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer3);
            final Store<ContentPickerReducer.State, ContentPickerReducer.Action> store2 = contentPickerViewModel4.getStore();
            int i13 = i6;
            Composer composer4 = composer3;
            String str5 = route;
            final State stateCollectAsStateWithLifecycle = FlowExtKt.collectAsStateWithLifecycle(store2.getState(), (LifecycleOwner) null, (Lifecycle.State) null, (CoroutineContext) null, composer4, 0, 7);
            ComposerKt.sourceInformationMarkerStart(composer4, 2105307081, "CC(remember):MultiTabItemPickerScreenContent.kt#9igjgp");
            Object objRememberedValue2 = composer4.rememberedValue();
            if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue2 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(null, null, 2, null);
                composer4.updateRememberedValue(objRememberedValue2);
            }
            final MutableState mutableState2 = (MutableState) objRememberedValue2;
            ComposerKt.sourceInformationMarkerEnd(composer4);
            ComposerKt.sourceInformationMarkerStart(composer4, 2105309402, "CC(remember):MultiTabItemPickerScreenContent.kt#9igjgp");
            Object objRememberedValue3 = composer4.rememberedValue();
            if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue3 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(CollectionsKt.emptyList(), null, 2, null);
                composer4.updateRememberedValue(objRememberedValue3);
            }
            final MutableState mutableState3 = (MutableState) objRememberedValue3;
            ComposerKt.sourceInformationMarkerEnd(composer4);
            ComposerKt.sourceInformationMarkerStart(composer4, 2105312157, "CC(remember):MultiTabItemPickerScreenContent.kt#9igjgp");
            Object objRememberedValue4 = composer4.rememberedValue();
            if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue4 = SnapshotStateKt__SnapshotStateKt.mutableStateOf$default(new Function1() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerScreenContentKt$$ExternalSyntheticLambda16
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return MultiTabItemPickerScreenContentKt.MultiTabItemPickerScreenContent$lambda$10$0((ItemId.Remote) obj);
                    }
                }, null, 2, null);
                composer4.updateRememberedValue(objRememberedValue4);
            }
            final MutableState mutableState4 = (MutableState) objRememberedValue4;
            ComposerKt.sourceInformationMarkerEnd(composer4);
            Unit unit = Unit.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer4, 2105315022, "CC(remember):MultiTabItemPickerScreenContent.kt#9igjgp");
            boolean zChanged = composer4.changed(store2);
            MultiTabItemPickerScreenContentKt$MultiTabItemPickerScreenContent$1$1 multiTabItemPickerScreenContentKt$MultiTabItemPickerScreenContent$1$1RememberedValue = composer4.rememberedValue();
            if (zChanged || multiTabItemPickerScreenContentKt$MultiTabItemPickerScreenContent$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                multiTabItemPickerScreenContentKt$MultiTabItemPickerScreenContent$1$1RememberedValue = new MultiTabItemPickerScreenContentKt$MultiTabItemPickerScreenContent$1$1(store2, null);
                composer4.updateRememberedValue(multiTabItemPickerScreenContentKt$MultiTabItemPickerScreenContent$1$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer4);
            EffectsKt.LaunchedEffect(unit, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) multiTabItemPickerScreenContentKt$MultiTabItemPickerScreenContent$1$1RememberedValue, composer4, 6);
            ItemPickerTab itemPickerTabMultiTabItemPickerScreenContent$lambda$1 = MultiTabItemPickerScreenContent$lambda$1(mutableState);
            ComposerKt.sourceInformationMarkerStart(composer4, 2105318638, "CC(remember):MultiTabItemPickerScreenContent.kt#9igjgp");
            boolean zChanged2 = composer4.changed(store2);
            MultiTabItemPickerScreenContentKt$MultiTabItemPickerScreenContent$2$1 multiTabItemPickerScreenContentKt$MultiTabItemPickerScreenContent$2$1RememberedValue = composer4.rememberedValue();
            if (zChanged2 || multiTabItemPickerScreenContentKt$MultiTabItemPickerScreenContent$2$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                multiTabItemPickerScreenContentKt$MultiTabItemPickerScreenContent$2$1RememberedValue = new MultiTabItemPickerScreenContentKt$MultiTabItemPickerScreenContent$2$1(store2, mutableState, null);
                composer4.updateRememberedValue(multiTabItemPickerScreenContentKt$MultiTabItemPickerScreenContent$2$1RememberedValue);
            }
            ComposerKt.sourceInformationMarkerEnd(composer4);
            EffectsKt.LaunchedEffect(itemPickerTabMultiTabItemPickerScreenContent$lambda$1, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) multiTabItemPickerScreenContentKt$MultiTabItemPickerScreenContent$2$1RememberedValue, composer4, 0);
            ComposerKt.sourceInformationMarkerStart(composer4, 2105323733, "CC(remember):MultiTabItemPickerScreenContent.kt#9igjgp");
            boolean zChanged3 = composer4.changed(stateCollectAsStateWithLifecycle) | composer4.changedInstance(activity);
            Object objRememberedValue5 = composer4.rememberedValue();
            if (zChanged3 || objRememberedValue5 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue5 = new Function0() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerScreenContentKt$$ExternalSyntheticLambda17
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return MultiTabItemPickerScreenContentKt.MultiTabItemPickerScreenContent$lambda$15$0(activity, stateCollectAsStateWithLifecycle);
                    }
                };
                composer4.updateRememberedValue(objRememberedValue5);
            }
            ComposerKt.sourceInformationMarkerEnd(composer4);
            final Function0 function0Remembered = ComposeUtilsKt.remembered((Function0) objRememberedValue5, composer4, 0);
            OnBackPressedDispatcherOwner current = LocalOnBackPressedDispatcherOwner.INSTANCE.getCurrent(composer4, LocalOnBackPressedDispatcherOwner.$stable);
            final OnBackPressedDispatcher onBackPressedDispatcher = current != null ? current.getOnBackPressedDispatcher() : null;
            ComposerKt.sourceInformationMarkerStart(composer4, 2105335547, "CC(remember):MultiTabItemPickerScreenContent.kt#9igjgp");
            boolean zChangedInstance = composer4.changedInstance(onBackPressedDispatcher);
            Object objRememberedValue6 = composer4.rememberedValue();
            if (zChangedInstance || objRememberedValue6 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue6 = new Function0() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerScreenContentKt$$ExternalSyntheticLambda18
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return MultiTabItemPickerScreenContentKt.MultiTabItemPickerScreenContent$lambda$16$0(onBackPressedDispatcher);
                    }
                };
                composer4.updateRememberedValue(objRememberedValue6);
            }
            ComposerKt.sourceInformationMarkerEnd(composer4);
            final Function0 function0Remembered2 = ComposeUtilsKt.remembered((Function0) objRememberedValue6, composer4, 0);
            ContentPickerViewModel contentPickerViewModel5 = contentPickerViewModel4;
            Modifier modifierWindowInsetsPadding = WindowInsetsPaddingKt.windowInsetsPadding(WindowInsetsPadding_androidKt.statusBarsPadding(BackgroundKt.m589backgroundbw27NRU$default(SizeKt.fillMaxSize$default(Modifier.INSTANCE, 0.0f, 1, null), BoxTheme.INSTANCE.getColors(composer4, BoxTheme.$stable).m11498getAppBackground0d7_KjU(), null, 2, null)), WindowInsetsKt.m1294onlybOOhFvg(WindowInsets_androidKt.getSafeDrawing(WindowInsets.INSTANCE, composer4, 6), WindowInsetsSides.INSTANCE.m1321getHorizontalJoeWqyM()));
            ComposerKt.sourceInformationMarkerStart(composer4, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
            final ItemPickerTab itemPickerTab4 = itemPickerTab3;
            ComposerKt.sourceInformationMarkerStart(composer4, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer4, 0));
            CompositionLocalMap currentCompositionLocalMap = composer4.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer4, modifierWindowInsetsPadding);
            Function0<ComposeUiNode> constructor = ComposeUiNode.INSTANCE.getConstructor();
            ComposerKt.sourceInformationMarkerStart(composer4, -553112988, "CC(ReusableComposeNode)N(factory,update,content)399@15590L9:Composables.kt#9igjgp");
            if (!(composer4.getApplier() instanceof Applier)) {
                ComposablesKt.invalidApplier();
            }
            composer4.startReusableNode();
            if (composer4.getInserting()) {
                composer4.createNode(constructor);
            } else {
                composer4.useNode();
            }
            Composer composerM6062constructorimpl = Updater.m6062constructorimpl(composer4);
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer4, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer4, -1518337905, "C158@7621L3955,158@7561L4015,235@11730L6,236@11793L10,242@12031L345,233@11586L790:MultiTabItemPickerScreenContent.kt#aug1cj");
            ComposerKt.sourceInformationMarkerStart(composer4, -1988640232, "CC(remember):MultiTabItemPickerScreenContent.kt#9igjgp");
            boolean zChanged4 = composer4.changed(function0Remembered2) | composer4.changed(store2) | composer4.changedInstance(navHostControllerRememberNavController) | composer4.changedInstance(enumEntries) | ((((i13 & 112) ^ 48) > 32 && composer4.changed(itemPickerTab4.ordinal())) || (i13 & 48) == 32) | ((((i13 & 896) ^ 384) > 256 && composer4.changed(multiTabItemPickerViewModelsDefaultMultiTabItemPickerViewModels)) || (i13 & 384) == 256);
            Object objRememberedValue7 = composer4.rememberedValue();
            if (zChanged4 || objRememberedValue7 == Composer.INSTANCE.getEmpty()) {
                list2 = enumEntries;
                multiTabItemPickerViewModels3 = multiTabItemPickerViewModelsDefaultMultiTabItemPickerViewModels;
                navHostController = navHostControllerRememberNavController;
                objRememberedValue7 = new Function1() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerScreenContentKt$$ExternalSyntheticLambda19
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return MultiTabItemPickerScreenContentKt.MultiTabItemPickerScreenContent$lambda$17$0$0(function0Remembered2, store2, navHostController, mutableState2, mutableState3, mutableState4, mutableState, list2, itemPickerTab4, multiTabItemPickerViewModels3, (NavGraphBuilder) obj);
                    }
                };
                store = store2;
                composer4.updateRememberedValue(objRememberedValue7);
            } else {
                list2 = enumEntries;
                multiTabItemPickerViewModels3 = multiTabItemPickerViewModelsDefaultMultiTabItemPickerViewModels;
                store = store2;
                navHostController = navHostControllerRememberNavController;
            }
            ComposerKt.sourceInformationMarkerEnd(composer4);
            NavHostKt.NavHost(navHostController, str5, null, null, null, null, null, null, null, null, (Function1) objRememberedValue7, composer4, (i13 >> 9) & 112, 0, 1020);
            boolean z = !MultiTabItemPickerScreenContent$lambda$3(stateCollectAsStateWithLifecycle).getSelectedItems().isEmpty();
            ComposerKt.sourceInformationMarkerStart(composer4, -1988512693, "CC(remember):MultiTabItemPickerScreenContent.kt#9igjgp");
            Object objRememberedValue8 = composer4.rememberedValue();
            if (objRememberedValue8 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue8 = new Function1() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerScreenContentKt$$ExternalSyntheticLambda20
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Integer.valueOf(MultiTabItemPickerScreenContentKt.MultiTabItemPickerScreenContent$lambda$17$1$0(((Integer) obj).intValue()));
                    }
                };
                composer4.updateRememberedValue(objRememberedValue8);
            }
            ComposerKt.sourceInformationMarkerEnd(composer4);
            EnterTransition enterTransitionSlideInVertically$default = EnterExitTransitionKt.slideInVertically$default(null, (Function1) objRememberedValue8, 1, null);
            ComposerKt.sourceInformationMarkerStart(composer4, -1988510673, "CC(remember):MultiTabItemPickerScreenContent.kt#9igjgp");
            Object objRememberedValue9 = composer4.rememberedValue();
            if (objRememberedValue9 == Composer.INSTANCE.getEmpty()) {
                objRememberedValue9 = new Function1() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerScreenContentKt$$ExternalSyntheticLambda21
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return Integer.valueOf(MultiTabItemPickerScreenContentKt.MultiTabItemPickerScreenContent$lambda$17$2$0(((Integer) obj).intValue()));
                    }
                };
                composer4.updateRememberedValue(objRememberedValue9);
            }
            ComposerKt.sourceInformationMarkerEnd(composer4);
            AnimatedVisibilityKt.AnimatedVisibility(z, boxScopeInstance.align(PaddingKt.m1219paddingVpY3zN4(SizeKt.fillMaxWidth$default(WindowInsetsPadding_androidKt.navigationBarsPadding(Modifier.INSTANCE), 0.0f, 1, null), Dp.m9687constructorimpl(16), Dp.m9687constructorimpl(32)), Alignment.INSTANCE.getBottomCenter()), enterTransitionSlideInVertically$default, EnterExitTransitionKt.slideOutVertically$default(null, (Function1) objRememberedValue9, 1, null), (String) null, ComposableLambdaKt.rememberComposableLambda(1779074045, true, new Function3() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerScreenContentKt$$ExternalSyntheticLambda23
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return MultiTabItemPickerScreenContentKt.MultiTabItemPickerScreenContent$lambda$17$3(store, function0Remembered, stateCollectAsStateWithLifecycle, (AnimatedVisibilityScope) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer4, 54), composer4, 200064, 16);
            composer2 = composer4;
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            composer2.endNode();
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            ComposerKt.sourceInformationMarkerEnd(composer2);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            contentPickerViewModel3 = contentPickerViewModel5;
            str3 = str5;
            enumEntries = list2;
            itemPickerTab2 = itemPickerTab4;
            multiTabItemPickerViewModels2 = multiTabItemPickerViewModels3;
        } else {
            composer2 = composerStartRestartGroup;
            composer2.skipToGroupEnd();
            itemPickerTab2 = itemPickerTab;
            str3 = str;
            multiTabItemPickerViewModels2 = multiTabItemPickerViewModelsDefaultMultiTabItemPickerViewModels;
            contentPickerViewModel3 = contentPickerViewModel2;
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerScreenContentKt$$ExternalSyntheticLambda24
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MultiTabItemPickerScreenContentKt.MultiTabItemPickerScreenContent$lambda$18(enumEntries, itemPickerTab2, multiTabItemPickerViewModels2, contentPickerViewModel3, str3, i, i2, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final ItemPickerTab MultiTabItemPickerScreenContent$lambda$1(MutableState<ItemPickerTab> mutableState) {
        return mutableState.getValue();
    }

    private static final String MultiTabItemPickerScreenContent$lambda$5(MutableState<String> mutableState) {
        return mutableState.getValue();
    }

    private static final List<FolderModel> MultiTabItemPickerScreenContent$lambda$8(MutableState<List<FolderModel>> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiTabItemPickerScreenContent$lambda$10$0(ItemId.Remote remote) {
        Intrinsics.checkNotNullParameter(remote, "<unused var>");
        return Unit.INSTANCE;
    }

    private static final Function1<ItemId.Remote, Unit> MultiTabItemPickerScreenContent$lambda$11(MutableState<Function1<ItemId.Remote, Unit>> mutableState) {
        return mutableState.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiTabItemPickerScreenContent$lambda$15$0(Activity activity, State state) {
        Intent intentBuildContentPickerResultIntent$default = activity != null ? ContentPickerActivityKt.buildContentPickerResultIntent$default(activity, MultiTabItemPickerScreenContent$lambda$3(state).getSelectedItems(), null, 2, null) : null;
        if (activity != null) {
            activity.setResult(-1, intentBuildContentPickerResultIntent$default);
        }
        if (activity == null) {
            return null;
        }
        activity.finish();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiTabItemPickerScreenContent$lambda$16$0(OnBackPressedDispatcher onBackPressedDispatcher) {
        if (onBackPressedDispatcher != null) {
            onBackPressedDispatcher.onBackPressed();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiTabItemPickerScreenContent$lambda$17$0$0(final Function0 function0, final Store store, final NavHostController navHostController, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, final List list, final ItemPickerTab itemPickerTab, final MultiTabItemPickerViewModels multiTabItemPickerViewModels, NavGraphBuilder NavHost) {
        Intrinsics.checkNotNullParameter(NavHost, "$this$NavHost");
        NavGraphBuilderKt.composable$default(NavHost, MultiItemPickerDestination.Items.INSTANCE.getRoute(), (List) null, (List) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, ComposableLambdaKt.composableLambdaInstance(-1480498232, true, new Function4() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerScreenContentKt$$ExternalSyntheticLambda28
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return MultiTabItemPickerScreenContentKt.MultiTabItemPickerScreenContent$lambda$17$0$0$0(function0, store, navHostController, mutableState, mutableState2, mutableState3, mutableState4, list, itemPickerTab, multiTabItemPickerViewModels, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, (Object) null);
        NavGraphBuilderKt.composable$default(NavHost, MultiItemPickerDestination.Search.INSTANCE.getRoute(), (List) null, (List) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, (Function1) null, ComposableLambdaKt.composableLambdaInstance(2075205823, true, new Function4() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerScreenContentKt$$ExternalSyntheticLambda29
            @Override // kotlin.jvm.functions.Function4
            public final Object invoke(Object obj, Object obj2, Object obj3, Object obj4) {
                return MultiTabItemPickerScreenContentKt.MultiTabItemPickerScreenContent$lambda$17$0$0$1(multiTabItemPickerViewModels, store, function0, mutableState4, (AnimatedContentScope) obj, (NavBackStackEntry) obj2, (Composer) obj3, ((Integer) obj4).intValue());
            }
        }), 254, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiTabItemPickerScreenContent$lambda$17$0$0$0(final Function0 function0, final Store store, final NavHostController navHostController, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, final List list, final ItemPickerTab itemPickerTab, final MultiTabItemPickerViewModels multiTabItemPickerViewModels, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation(composer, "CN(it)161@7743L743,174@8534L6,176@8631L2342,160@7704L3269:MultiTabItemPickerScreenContent.kt#aug1cj");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-1480498232, i, -1, "com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerScreenContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MultiTabItemPickerScreenContent.kt:160)");
        }
        ScaffoldKt.m4038ScaffoldTvnljyQ(null, ComposableLambdaKt.rememberComposableLambda(-1929497972, true, new Function2() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerScreenContentKt$$ExternalSyntheticLambda26
            @Override // kotlin.jvm.functions.Function2
            public final Object invoke(Object obj, Object obj2) {
                return MultiTabItemPickerScreenContentKt.MultiTabItemPickerScreenContent$lambda$17$0$0$0$0(function0, store, navHostController, mutableState, mutableState2, mutableState3, mutableState4, (Composer) obj, ((Integer) obj2).intValue());
            }
        }, composer, 54), null, null, null, 0, BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11498getAppBackground0d7_KjU(), 0L, WindowInsetsKt.WindowInsets(), ComposableLambdaKt.rememberComposableLambda(1681053911, true, new Function3() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerScreenContentKt$$ExternalSyntheticLambda27
            @Override // kotlin.jvm.functions.Function3
            public final Object invoke(Object obj, Object obj2, Object obj3) {
                return MultiTabItemPickerScreenContentKt.MultiTabItemPickerScreenContent$lambda$17$0$0$0$1(list, itemPickerTab, mutableState4, multiTabItemPickerViewModels, mutableState, mutableState2, mutableState3, (PaddingValues) obj, (Composer) obj2, ((Integer) obj3).intValue());
            }
        }, composer, 54), composer, 805306416, PsExtractor.PRIVATE_STREAM_1);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiTabItemPickerScreenContent$lambda$17$0$0$0$0(Function0 function0, final Store store, final NavHostController navHostController, MutableState mutableState, MutableState mutableState2, MutableState mutableState3, MutableState mutableState4, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C164@7900L238,162@7769L695:MultiTabItemPickerScreenContent.kt#aug1cj");
        if (!composer.shouldExecute((i & 3) != 2, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1929497972, i, -1, "com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerScreenContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MultiTabItemPickerScreenContent.kt:162)");
            }
            ComposerKt.sourceInformationMarkerStart(composer, 1178326042, "CC(remember):MultiTabItemPickerScreenContent.kt#9igjgp");
            boolean zChanged = composer.changed(store) | composer.changedInstance(navHostController);
            Object objRememberedValue = composer.rememberedValue();
            if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
                objRememberedValue = new Function0() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerScreenContentKt$$ExternalSyntheticLambda15
                    @Override // kotlin.jvm.functions.Function0
                    public final Object invoke() {
                        return MultiTabItemPickerScreenContentKt.MultiTabItemPickerScreenContent$lambda$17$0$0$0$0$0$0(store, navHostController);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            }
            Function0 function1 = (Function0) objRememberedValue;
            ComposerKt.sourceInformationMarkerEnd(composer);
            String strMultiTabItemPickerScreenContent$lambda$5 = MultiTabItemPickerScreenContent$lambda$5(mutableState);
            List<FolderModel> listMultiTabItemPickerScreenContent$lambda$8 = MultiTabItemPickerScreenContent$lambda$8(mutableState2);
            ArrayList arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(listMultiTabItemPickerScreenContent$lambda$8, 10));
            Iterator<T> it = listMultiTabItemPickerScreenContent$lambda$8.iterator();
            while (it.hasNext()) {
                arrayList.add((FolderModel) it.next());
            }
            MultiTabItemPickerTopBarKt.MultiTabItemPickerTopBar(function0, function1, strMultiTabItemPickerScreenContent$lambda$5, arrayList, MultiTabItemPickerScreenContent$lambda$11(mutableState3), MultiTabItemPickerScreenContent$lambda$1(mutableState4) != ItemPickerTab.COLLECTIONS, composer, 0, 0);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiTabItemPickerScreenContent$lambda$17$0$0$0$0$0$0(Store store, NavHostController navHostController) {
        store.send(new ContentPickerReducer.Action.ActiveSelectionScreenChanged("search"));
        NavController.navigate$default((NavController) navHostController, MultiItemPickerDestination.Search.INSTANCE.getRoute(), (NavOptions) null, (Navigator.Extras) null, 6, (Object) null);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiTabItemPickerScreenContent$lambda$17$0$0$0$1(List list, ItemPickerTab itemPickerTab, MutableState mutableState, final MultiTabItemPickerViewModels multiTabItemPickerViewModels, final MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, PaddingValues paddingValues, Composer composer, int i) {
        int i2;
        final MutableState mutableState5;
        Intrinsics.checkNotNullParameter(paddingValues, "paddingValues");
        ComposerKt.sourceInformation(composer, "CN(paddingValues)177@8670L2285:MultiTabItemPickerScreenContent.kt#aug1cj");
        if ((i & 6) == 0) {
            i2 = i | (composer.changed(paddingValues) ? 4 : 2);
        } else {
            i2 = i;
        }
        if (!composer.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1681053911, i2, -1, "com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerScreenContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MultiTabItemPickerScreenContent.kt:177)");
            }
            Modifier modifierPadding = PaddingKt.padding(Modifier.INSTANCE, paddingValues);
            ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
            MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyMaybeCachedBoxMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1833054614, "C72@3469L9:Box.kt#2w3rfo");
            BoxScopeInstance boxScopeInstance = BoxScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, 945161594, "C183@8986L19,184@9032L1901,178@8733L2200:MultiTabItemPickerScreenContent.kt#aug1cj");
            Function3 function3 = new Function3() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerScreenContentKt$$ExternalSyntheticLambda1
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return MultiTabItemPickerScreenContentKt.MultiTabItemPickerScreenContent$lambda$17$0$0$0$1$0$0((ItemPickerTab) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            };
            ComposerKt.sourceInformationMarkerStart(composer, 1554515652, "CC(remember):MultiTabItemPickerScreenContent.kt#9igjgp");
            Object objRememberedValue = composer.rememberedValue();
            if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                mutableState5 = mutableState;
                objRememberedValue = new Function1() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerScreenContentKt$$ExternalSyntheticLambda2
                    @Override // kotlin.jvm.functions.Function1
                    public final Object invoke(Object obj) {
                        return MultiTabItemPickerScreenContentKt.MultiTabItemPickerScreenContent$lambda$17$0$0$0$1$0$1$0(mutableState5, (ItemPickerTab) obj);
                    }
                };
                composer.updateRememberedValue(objRememberedValue);
            } else {
                mutableState5 = mutableState;
            }
            ComposerKt.sourceInformationMarkerEnd(composer);
            CommonTabsScreenKt.m11833CommonTabsScreenDuhZ5jU(list, itemPickerTab, function3, null, false, 0, 0L, 0L, 0L, 0L, null, null, (Function1) objRememberedValue, null, ComposableLambdaKt.rememberComposableLambda(221297494, true, new Function3() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerScreenContentKt$$ExternalSyntheticLambda3
                @Override // kotlin.jvm.functions.Function3
                public final Object invoke(Object obj, Object obj2, Object obj3) {
                    return MultiTabItemPickerScreenContentKt.MultiTabItemPickerScreenContent$lambda$17$0$0$0$1$0$2(mutableState5, multiTabItemPickerViewModels, mutableState2, mutableState3, mutableState4, (ItemPickerTab) obj, (Composer) obj2, ((Integer) obj3).intValue());
                }
            }, composer, 54), composer, ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE, 24960, 12248);
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
    public static final String MultiTabItemPickerScreenContent$lambda$17$0$0$0$1$0$0(ItemPickerTab it, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(it, "it");
        composer.startReplaceGroup(-803843746);
        ComposerKt.sourceInformation(composer, "CN(it)181@8865L10:MultiTabItemPickerScreenContent.kt#aug1cj");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(-803843746, i, -1, "com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerScreenContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MultiTabItemPickerScreenContent.kt:181)");
        }
        String title = it.getTitle(composer, i & 14);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        composer.endReplaceGroup();
        return title;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiTabItemPickerScreenContent$lambda$17$0$0$0$1$0$1$0(MutableState mutableState, ItemPickerTab it) {
        Intrinsics.checkNotNullParameter(it, "it");
        mutableState.setValue(it);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiTabItemPickerScreenContent$lambda$17$0$0$0$1$0$2(MutableState mutableState, final MultiTabItemPickerViewModels multiTabItemPickerViewModels, final MutableState mutableState2, final MutableState mutableState3, final MutableState mutableState4, final ItemPickerTab it, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation(composer, "CN(it)185@9116L1791,185@9062L1845:MultiTabItemPickerScreenContent.kt#aug1cj");
        if ((i & 6) == 0) {
            i |= composer.changed(it.ordinal()) ? 4 : 2;
        }
        if (!composer.shouldExecute((i & 19) != 18, i & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(221297494, i, -1, "com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerScreenContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MultiTabItemPickerScreenContent.kt:185)");
            }
            ResettableTabContent(it == MultiTabItemPickerScreenContent$lambda$1(mutableState), ComposableLambdaKt.rememberComposableLambda(-1462746875, true, new Function2() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerScreenContentKt$$ExternalSyntheticLambda34
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MultiTabItemPickerScreenContentKt.MultiTabItemPickerScreenContent$lambda$17$0$0$0$1$0$2$0(it, multiTabItemPickerViewModels, mutableState2, mutableState3, mutableState4, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composer, 54), composer, 48);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiTabItemPickerScreenContent$lambda$17$0$0$0$1$0$2$0(ItemPickerTab itemPickerTab, MultiTabItemPickerViewModels multiTabItemPickerViewModels, final MutableState mutableState, final MutableState mutableState2, final MutableState mutableState3, Composer composer, int i) {
        ComposerKt.sourceInformation(composer, "C:MultiTabItemPickerScreenContent.kt#aug1cj");
        if (composer.shouldExecute((i & 3) != 2, i & 1)) {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1462746875, i, -1, "com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerScreenContent.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MultiTabItemPickerScreenContent.kt:186)");
            }
            int i2 = WhenMappings.$EnumSwitchMapping$0[itemPickerTab.ordinal()];
            if (i2 == 1) {
                composer.startReplaceGroup(-1245437595);
                ComposerKt.sourceInformation(composer, "187@9258L28,187@9223L64");
                RecentsItemPickerScreenKt.RecentsItemPickerScreen(multiTabItemPickerViewModels.getRecentsItemPickerViewModel().invoke(composer, 0), composer, RecentsItemPickerViewModel.$stable, 0);
                composer.endReplaceGroup();
            } else if (i2 == 2) {
                composer.startReplaceGroup(-1245433010);
                ComposerKt.sourceInformation(composer, "190@9423L27,191@9510L162,194@9737L222,189@9348L649");
                FolderItemPickerViewModel folderItemPickerViewModelInvoke = multiTabItemPickerViewModels.getFolderItemPickerViewModel().invoke(composer, 0);
                ComposerKt.sourceInformationMarkerStart(composer, -1245428313, "CC(remember):MultiTabItemPickerScreenContent.kt#9igjgp");
                Object objRememberedValue = composer.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function2() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerScreenContentKt$$ExternalSyntheticLambda30
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return MultiTabItemPickerScreenContentKt.MultiTabItemPickerScreenContent$lambda$17$0$0$0$1$0$2$0$0$0(mutableState, (String) obj, ((Boolean) obj2).booleanValue());
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue);
                }
                Function2 function2 = (Function2) objRememberedValue;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, -1245420989, "CC(remember):MultiTabItemPickerScreenContent.kt#9igjgp");
                Object objRememberedValue2 = composer.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new Function2() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerScreenContentKt$$ExternalSyntheticLambda31
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return MultiTabItemPickerScreenContentKt.MultiTabItemPickerScreenContent$lambda$17$0$0$0$1$0$2$0$1$0(mutableState2, mutableState3, (List) obj, (Function1) obj2);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue2);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                FolderItemPickerScreenKt.FolderItemPickerScreen(folderItemPickerViewModelInvoke, function2, (Function2) objRememberedValue2, composer, FolderItemPickerViewModel.$stable | 432, 0);
                composer.endReplaceGroup();
            } else if (i2 == 3) {
                composer.startReplaceGroup(-1245410085);
                ComposerKt.sourceInformation(composer, "201@10143L32,202@10239L162,205@10466L222,200@10064L662");
                CollectionItemPickerViewModels collectionItemPickerViewModelsInvoke = multiTabItemPickerViewModels.getCollectionItemPickerViewModels().invoke(composer, 0);
                ComposerKt.sourceInformationMarkerStart(composer, -1245404985, "CC(remember):MultiTabItemPickerScreenContent.kt#9igjgp");
                Object objRememberedValue3 = composer.rememberedValue();
                if (objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function2() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerScreenContentKt$$ExternalSyntheticLambda32
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return MultiTabItemPickerScreenContentKt.MultiTabItemPickerScreenContent$lambda$17$0$0$0$1$0$2$0$2$0(mutableState, (String) obj, ((Boolean) obj2).booleanValue());
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue3);
                }
                Function2 function3 = (Function2) objRememberedValue3;
                ComposerKt.sourceInformationMarkerEnd(composer);
                ComposerKt.sourceInformationMarkerStart(composer, -1245397661, "CC(remember):MultiTabItemPickerScreenContent.kt#9igjgp");
                Object objRememberedValue4 = composer.rememberedValue();
                if (objRememberedValue4 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue4 = new Function2() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerScreenContentKt$$ExternalSyntheticLambda33
                        @Override // kotlin.jvm.functions.Function2
                        public final Object invoke(Object obj, Object obj2) {
                            return MultiTabItemPickerScreenContentKt.MultiTabItemPickerScreenContent$lambda$17$0$0$0$1$0$2$0$3$0(mutableState2, mutableState3, (List) obj, (Function1) obj2);
                        }
                    };
                    composer.updateRememberedValue(objRememberedValue4);
                }
                ComposerKt.sourceInformationMarkerEnd(composer);
                CollectionItemPickerScreenKt.CollectionItemPickerScreen(collectionItemPickerViewModelsInvoke, function3, (Function2) objRememberedValue4, composer, CollectionItemPickerViewModels.$stable | 432);
                composer.endReplaceGroup();
            } else {
                if (i2 != 4) {
                    composer.startReplaceGroup(-1245438268);
                    composer.endReplaceGroup();
                    throw new NoWhenBranchMatchedException();
                }
                composer.startReplaceGroup(-1245387586);
                ComposerKt.sourceInformation(composer, "211@10818L24,211@10786L57");
                HubsItemPickerScreenKt.HubsItemPickerScreen(multiTabItemPickerViewModels.getHubItemPickerViewModel().invoke(composer, 0), composer, HubsItemPickerViewModel.$stable, 0);
                composer.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        } else {
            composer.skipToGroupEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiTabItemPickerScreenContent$lambda$17$0$0$0$1$0$2$0$0$0(MutableState mutableState, String title, boolean z) {
        Intrinsics.checkNotNullParameter(title, "title");
        if (z) {
            title = null;
        }
        mutableState.setValue(title);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiTabItemPickerScreenContent$lambda$17$0$0$0$1$0$2$0$1$0(MutableState mutableState, MutableState mutableState2, List folders, Function1 goBackToFolderFn) {
        Intrinsics.checkNotNullParameter(folders, "folders");
        Intrinsics.checkNotNullParameter(goBackToFolderFn, "goBackToFolderFn");
        mutableState.setValue(folders);
        mutableState2.setValue(goBackToFolderFn);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiTabItemPickerScreenContent$lambda$17$0$0$0$1$0$2$0$2$0(MutableState mutableState, String title, boolean z) {
        Intrinsics.checkNotNullParameter(title, "title");
        if (z) {
            title = null;
        }
        mutableState.setValue(title);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiTabItemPickerScreenContent$lambda$17$0$0$0$1$0$2$0$3$0(MutableState mutableState, MutableState mutableState2, List folders, Function1 goBackToFolderFn) {
        Intrinsics.checkNotNullParameter(folders, "folders");
        Intrinsics.checkNotNullParameter(goBackToFolderFn, "goBackToFolderFn");
        mutableState.setValue(folders);
        mutableState2.setValue(goBackToFolderFn);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiTabItemPickerScreenContent$lambda$17$0$0$1(MultiTabItemPickerViewModels multiTabItemPickerViewModels, final Store store, final Function0 function0, final MutableState mutableState, AnimatedContentScope composable, NavBackStackEntry it, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(composable, "$this$composable");
        Intrinsics.checkNotNullParameter(it, "it");
        ComposerKt.sourceInformation(composer, "CN(it)220@11071L481:MultiTabItemPickerScreenContent.kt#aug1cj");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(2075205823, i, -1, "com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerScreenContent.<anonymous>.<anonymous>.<anonymous>.<anonymous> (MultiTabItemPickerScreenContent.kt:220)");
        }
        ComposerKt.sourceInformationMarkerStart(composer, 1042775818, "CC(Box)N(modifier,contentAlignment,propagateMinConstraints,content)71@3424L131:Box.kt#2w3rfo");
        Modifier.Companion companion = Modifier.INSTANCE;
        MeasurePolicy measurePolicyMaybeCachedBoxMeasurePolicy = BoxKt.maybeCachedBoxMeasurePolicy(Alignment.INSTANCE.getTopStart(), false);
        ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
        int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
        CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
        Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, companion);
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
        ComposerKt.sourceInformationMarkerStart(composer, -492721463, "C222@11169L28,224@11317L195,221@11097L437:MultiTabItemPickerScreenContent.kt#aug1cj");
        SearchItemPickerViewModels searchItemPickerViewModelsInvoke = multiTabItemPickerViewModels.getSearchItemPickerViewModels().invoke(composer, 0);
        String name = MultiTabItemPickerScreenContent$lambda$1(mutableState).toSearchMode().getName();
        ComposerKt.sourceInformationMarkerStart(composer, -1262813432, "CC(remember):MultiTabItemPickerScreenContent.kt#9igjgp");
        boolean zChanged = composer.changed(store) | composer.changed(function0);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerScreenContentKt$$ExternalSyntheticLambda25
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return MultiTabItemPickerScreenContentKt.MultiTabItemPickerScreenContent$lambda$17$0$0$1$0$0$0(store, function0, mutableState);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        SearchItemPickerScreenKt.SearchItemPickerScreen(searchItemPickerViewModelsInvoke, name, (Function0) objRememberedValue, composer, SearchItemPickerViewModels.$stable);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        composer.endNode();
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerEnd(composer);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiTabItemPickerScreenContent$lambda$17$0$0$1$0$0$0(Store store, Function0 function0, MutableState mutableState) {
        store.send(new ContentPickerReducer.Action.ActiveSelectionScreenChanged(MultiTabItemPickerScreenContent$lambda$1(mutableState).toScreenName()));
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiTabItemPickerScreenContent$lambda$17$3(final Store store, final Function0 function0, State state, AnimatedVisibilityScope AnimatedVisibility, Composer composer, int i) {
        Intrinsics.checkNotNullParameter(AnimatedVisibility, "$this$AnimatedVisibility");
        ComposerKt.sourceInformation(composer, "C245@12163L94,248@12290L62,243@12045L321:MultiTabItemPickerScreenContent.kt#aug1cj");
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventStart(1779074045, i, -1, "com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerScreenContent.<anonymous>.<anonymous> (MultiTabItemPickerScreenContent.kt:243)");
        }
        int globalSelectionCount = MultiTabItemPickerScreenContent$lambda$3(state).getGlobalSelectionCount();
        ComposerKt.sourceInformationMarkerStart(composer, 293177755, "CC(remember):MultiTabItemPickerScreenContent.kt#9igjgp");
        boolean zChanged = composer.changed(store);
        Object objRememberedValue = composer.rememberedValue();
        if (zChanged || objRememberedValue == Composer.INSTANCE.getEmpty()) {
            objRememberedValue = new Function0() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerScreenContentKt$$ExternalSyntheticLambda13
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return MultiTabItemPickerScreenContentKt.MultiTabItemPickerScreenContent$lambda$17$3$0$0(store);
                }
            };
            composer.updateRememberedValue(objRememberedValue);
        }
        Function0 function1 = (Function0) objRememberedValue;
        ComposerKt.sourceInformationMarkerEnd(composer);
        ComposerKt.sourceInformationMarkerStart(composer, 293181787, "CC(remember):MultiTabItemPickerScreenContent.kt#9igjgp");
        boolean zChanged2 = composer.changed(function0);
        Object objRememberedValue2 = composer.rememberedValue();
        if (zChanged2 || objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
            objRememberedValue2 = new Function0() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerScreenContentKt$$ExternalSyntheticLambda14
                @Override // kotlin.jvm.functions.Function0
                public final Object invoke() {
                    return MultiTabItemPickerScreenContentKt.MultiTabItemPickerScreenContent$lambda$17$3$1$0(function0);
                }
            };
            composer.updateRememberedValue(objRememberedValue2);
        }
        ComposerKt.sourceInformationMarkerEnd(composer);
        SelectionFloatingBar(globalSelectionCount, function1, (Function0) objRememberedValue2, null, composer, 0, 8);
        if (ComposerKt.isTraceInProgress()) {
            ComposerKt.traceEventEnd();
        }
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiTabItemPickerScreenContent$lambda$17$3$0$0(Store store) {
        store.send(ContentPickerReducer.Action.ClearSelection.INSTANCE);
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit MultiTabItemPickerScreenContent$lambda$17$3$1$0(Function0 function0) {
        function0.invoke();
        return Unit.INSTANCE;
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* JADX WARN: Code duplicated, block: B:37:0x006a  */
    /* JADX WARN: Code duplicated, block: B:38:0x006c  */
    /* JADX WARN: Code duplicated, block: B:41:0x0075 A[DONT_INVERT] */
    /* JADX WARN: Code duplicated, block: B:42:0x0077  */
    /* JADX WARN: Code duplicated, block: B:45:0x0082  */
    /* JADX WARN: Code duplicated, block: B:48:0x00d2  */
    /* JADX WARN: Code duplicated, block: B:50:0x00d7  */
    /* JADX WARN: Code duplicated, block: B:53:0x00e3  */
    /* JADX WARN: Code duplicated, block: B:55:? A[RETURN, SYNTHETIC] */
    public static final void SelectionFloatingBar(final int i, final Function0<Unit> function0, final Function0<Unit> function1, Modifier modifier, Composer composer, final int i2, final int i3) {
        int i4;
        Modifier modifier2;
        boolean z;
        Composer composer2;
        final Modifier modifier3;
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup;
        Composer composerStartRestartGroup = composer.startRestartGroup(128895700);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SelectionFloatingBar)N(selectedCount,onDeselectAllClicked,onAddClicked,modifier)267@12704L6,268@12736L1519,263@12566L1689:MultiTabItemPickerScreenContent.kt#aug1cj");
        if ((i2 & 6) == 0) {
            i4 = (composerStartRestartGroup.changed(i) ? 4 : 2) | i2;
        } else {
            i4 = i2;
        }
        if ((i2 & 48) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function0) ? 32 : 16;
        }
        if ((i2 & 384) == 0) {
            i4 |= composerStartRestartGroup.changedInstance(function1) ? 256 : 128;
        }
        int i5 = i3 & 8;
        if (i5 == 0) {
            if ((i2 & 3072) == 0) {
                modifier2 = modifier;
                i4 |= composerStartRestartGroup.changed(modifier2) ? 2048 : 1024;
            }
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
                if (i5 != 0) {
                    modifier2 = Modifier.INSTANCE;
                }
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventStart(128895700, i4, -1, "com.box.android.contentpicker.multitabitempicker.SelectionFloatingBar (MultiTabItemPickerScreenContent.kt:262)");
                }
                int i6 = ((i4 >> 9) & 14) | 12779520;
                composer2 = composerStartRestartGroup;
                Modifier modifier4 = modifier2;
                SurfaceKt.m4323SurfaceT9BRK9s(modifier4, RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(32)), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11581getTopLayerBackground0d7_KjU(), 0L, 0.0f, Dp.m9687constructorimpl(6), null, ComposableLambdaKt.rememberComposableLambda(949510447, true, new Function2() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerScreenContentKt$$ExternalSyntheticLambda11
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return MultiTabItemPickerScreenContentKt.SelectionFloatingBar$lambda$0(function0, i, function1, (Composer) obj, ((Integer) obj2).intValue());
                    }
                }, composerStartRestartGroup, 54), composer2, i6, 88);
                if (ComposerKt.isTraceInProgress()) {
                    ComposerKt.traceEventEnd();
                }
                modifier3 = modifier4;
            }
            scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
            if (scopeUpdateScopeEndRestartGroup != null) {
                scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerScreenContentKt$$ExternalSyntheticLambda22
                    @Override // kotlin.jvm.functions.Function2
                    public final Object invoke(Object obj, Object obj2) {
                        return MultiTabItemPickerScreenContentKt.SelectionFloatingBar$lambda$1(i, function0, function1, modifier3, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                    }
                });
            }
        }
        i4 |= 3072;
        modifier2 = modifier;
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
            if (i5 != 0) {
                modifier2 = Modifier.INSTANCE;
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(128895700, i4, -1, "com.box.android.contentpicker.multitabitempicker.SelectionFloatingBar (MultiTabItemPickerScreenContent.kt:262)");
            }
            int i7 = ((i4 >> 9) & 14) | 12779520;
            composer2 = composerStartRestartGroup;
            Modifier modifier5 = modifier2;
            SurfaceKt.m4323SurfaceT9BRK9s(modifier5, RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(32)), BoxTheme.INSTANCE.getColors(composerStartRestartGroup, BoxTheme.$stable).m11581getTopLayerBackground0d7_KjU(), 0L, 0.0f, Dp.m9687constructorimpl(6), null, ComposableLambdaKt.rememberComposableLambda(949510447, true, new Function2() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerScreenContentKt$$ExternalSyntheticLambda11
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MultiTabItemPickerScreenContentKt.SelectionFloatingBar$lambda$0(function0, i, function1, (Composer) obj, ((Integer) obj2).intValue());
                }
            }, composerStartRestartGroup, 54), composer2, i7, 88);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
            modifier3 = modifier5;
        }
        scopeUpdateScopeEndRestartGroup = composer2.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerScreenContentKt$$ExternalSyntheticLambda22
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MultiTabItemPickerScreenContentKt.SelectionFloatingBar$lambda$1(i, function0, function1, modifier3, i2, i3, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final Unit SelectionFloatingBar$lambda$0(Function0 function0, int i, Function0 function1, Composer composer, int i2) {
        ComposerKt.sourceInformation(composer, "C269@12746L1503:MultiTabItemPickerScreenContent.kt#aug1cj");
        if (!composer.shouldExecute((i2 & 3) != 2, i2 & 1)) {
            composer.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(949510447, i2, -1, "com.box.android.contentpicker.multitabitempicker.SelectionFloatingBar.<anonymous> (MultiTabItemPickerScreenContent.kt:269)");
            }
            float f = 4;
            float f2 = 6;
            Modifier modifierM1221paddingqDBjuR0 = PaddingKt.m1221paddingqDBjuR0(Modifier.INSTANCE, Dp.m9687constructorimpl(f), Dp.m9687constructorimpl(f2), Dp.m9687constructorimpl(8), Dp.m9687constructorimpl(f2));
            Alignment.Vertical centerVertically = Alignment.INSTANCE.getCenterVertically();
            ComposerKt.sourceInformationMarkerStart(composer, 844473419, "CC(Row)N(modifier,horizontalArrangement,verticalAlignment,content)99@5125L58,100@5188L131:Row.kt#2w3rfo");
            MeasurePolicy measurePolicyRowMeasurePolicy = RowKt.rowMeasurePolicy(Arrangement.INSTANCE.getStart(), centerVertically, composer, 48);
            ComposerKt.sourceInformationMarkerStart(composer, -1159599143, "CC(Layout)P(!1,2)81@3355L27,84@3521L416:Layout.kt#80mrfh");
            int iHashCode = Long.hashCode(ComposablesKt.getCurrentCompositeKeyHashCode(composer, 0));
            CompositionLocalMap currentCompositionLocalMap = composer.getCurrentCompositionLocalMap();
            Modifier modifierMaterializeModifier = ComposedModifierKt.materializeModifier(composer, modifierM1221paddingqDBjuR0);
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
            Updater.m6070setimpl(composerM6062constructorimpl, measurePolicyRowMeasurePolicy, ComposeUiNode.INSTANCE.getSetMeasurePolicy());
            Updater.m6070setimpl(composerM6062constructorimpl, currentCompositionLocalMap, ComposeUiNode.INSTANCE.getSetResolvedCompositionLocals());
            Updater.m6066initimpl(composerM6062constructorimpl, Integer.valueOf(iHashCode), ComposeUiNode.INSTANCE.getSetCompositeKeyHash());
            Updater.m6068reconcileimpl(composerM6062constructorimpl, ComposeUiNode.INSTANCE.getApplyOnDeactivatedNodeAssertion());
            Updater.m6070setimpl(composerM6062constructorimpl, modifierMaterializeModifier, ComposeUiNode.INSTANCE.getSetModifier());
            ComposerKt.sourceInformationMarkerStart(composer, 1456264949, "C101@5233L9:Row.kt#2w3rfo");
            RowScopeInstance rowScopeInstance = RowScopeInstance.INSTANCE;
            ComposerKt.sourceInformationMarkerStart(composer, -35910951, "C273@12928L300,280@13241L27,282@13310L99,283@13449L10,284@13505L6,281@13281L255,286@13549L27,292@13897L6,293@13962L21,291@13826L222,287@13589L650:MultiTabItemPickerScreenContent.kt#aug1cj");
            IconButtonKt.IconButton((Function0<Unit>) function0, (Modifier) null, false, (IconButtonColors) null, (MutableInteractionSource) null, (Shape) null, (Function2<? super Composer, ? super Integer, Unit>) ComposableSingletons$MultiTabItemPickerScreenContentKt.INSTANCE.getLambda$829198317$content_picker_generalProdRelease(), composer, 1572864, 62);
            SpacerKt.Spacer(SizeKt.m1266size3ABfNKs(Modifier.INSTANCE, Dp.m9687constructorimpl(f)), composer, 6);
            TextKt.m4494TextNvy7gAk(StringResources_androidKt.pluralStringResource(R.plurals.items_selected, i, new Object[]{Integer.valueOf(i)}, composer, 0), null, BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11500getAppPrimary0d7_KjU(), null, 0L, null, null, null, 0L, null, null, 0L, 0, false, 0, 0, null, MaterialTheme.INSTANCE.getTypography(composer, MaterialTheme.$stable).getBodyMedium(), composer, 0, 0, 131066);
            SpacerKt.Spacer(RowScope.weight$default(rowScopeInstance, Modifier.INSTANCE, 1.0f, false, 2, null), composer, 0);
            ButtonKt.FilledTonalButton((Function0<Unit>) function1, (Modifier) null, false, (Shape) RoundedCornerShapeKt.m1573RoundedCornerShape0680j_4(Dp.m9687constructorimpl(100)), ButtonDefaults.INSTANCE.m2855filledTonalButtonColorsro_MJ88(BoxTheme.INSTANCE.getColors(composer, BoxTheme.$stable).m11533getMainActiveControl0d7_KjU(), DarkThemeKt.isSystemInDarkTheme(composer, 0) ? BoxColorPalette.INSTANCE.m11364getBOX_GRAY_1000d7_KjU() : Color.INSTANCE.m6851getWhite0d7_KjU(), 0L, 0L, composer, ButtonDefaults.$stable << 12, 12), (ButtonElevation) null, (BorderStroke) null, PaddingKt.m1212PaddingValuesYgX7TsA(Dp.m9687constructorimpl(16), Dp.m9687constructorimpl(10)), (MutableInteractionSource) null, (Function3<? super RowScope, ? super Composer, ? super Integer, Unit>) ComposableSingletons$MultiTabItemPickerScreenContentKt.INSTANCE.getLambda$1666604345$content_picker_generalProdRelease(), composer, 817889280, 358);
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

    private static final void ResettableTabContent(final boolean z, final Function2<? super Composer, ? super Integer, Unit> function2, Composer composer, final int i) {
        int i2;
        Composer composerStartRestartGroup = composer.startRestartGroup(1417044111);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(ResettableTabContent)N(isCurrentTab,content)311@14561L7:MultiTabItemPickerScreenContent.kt#aug1cj");
        if ((i & 6) == 0) {
            i2 = (composerStartRestartGroup.changed(z) ? 4 : 2) | i;
        } else {
            i2 = i;
        }
        if ((i & 48) == 0) {
            i2 |= composerStartRestartGroup.changedInstance(function2) ? 32 : 16;
        }
        if (!composerStartRestartGroup.shouldExecute((i2 & 19) != 18, i2 & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(1417044111, i2, -1, "com.box.android.contentpicker.multitabitempicker.ResettableTabContent (MultiTabItemPickerScreenContent.kt:310)");
            }
            ProvidableCompositionLocal<Activity> localActivity = LocalActivityKt.getLocalActivity();
            ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 2023513938, "CC(<get-current>):CompositionLocal.kt#9igjgp");
            Object objConsume = composerStartRestartGroup.consume(localActivity);
            ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
            Activity activity = (Activity) objConsume;
            if (activity instanceof ComponentActivity) {
                composerStartRestartGroup.startReplaceGroup(-72212088);
                ComposerKt.sourceInformation(composerStartRestartGroup, "314@14700L24,314@14683L41,316@14763L85,316@14734L114");
                Object[] objArr = new Object[0];
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 274766023, "CC(remember):MultiTabItemPickerScreenContent.kt#9igjgp");
                Object objRememberedValue = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue = new Function0() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerScreenContentKt$$ExternalSyntheticLambda9
                        @Override // kotlin.jvm.functions.Function0
                        public final Object invoke() {
                            return MultiTabItemPickerScreenContentKt.ResettableTabContent$lambda$0$0();
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                MutableIntState mutableIntState = (MutableIntState) RememberSaveableKt.rememberSaveable(objArr, (Function0) objRememberedValue, composerStartRestartGroup, 48);
                Boolean boolValueOf = Boolean.valueOf(z);
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 274768100, "CC(remember):MultiTabItemPickerScreenContent.kt#9igjgp");
                int i3 = i2 & 14;
                boolean zChanged = composerStartRestartGroup.changed(mutableIntState) | (i3 == 4);
                MultiTabItemPickerScreenContentKt$ResettableTabContent$1$1 multiTabItemPickerScreenContentKt$ResettableTabContent$1$1RememberedValue = composerStartRestartGroup.rememberedValue();
                if (zChanged || multiTabItemPickerScreenContentKt$ResettableTabContent$1$1RememberedValue == Composer.INSTANCE.getEmpty()) {
                    multiTabItemPickerScreenContentKt$ResettableTabContent$1$1RememberedValue = new MultiTabItemPickerScreenContentKt$ResettableTabContent$1$1(z, mutableIntState, null);
                    composerStartRestartGroup.updateRememberedValue(multiTabItemPickerScreenContentKt$ResettableTabContent$1$1RememberedValue);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.LaunchedEffect(boolValueOf, (Function2<? super CoroutineScope, ? super Continuation<? super Unit>, ? extends Object>) multiTabItemPickerScreenContentKt$ResettableTabContent$1$1RememberedValue, composerStartRestartGroup, i3);
                composerStartRestartGroup.startMovableGroup(274771467, Integer.valueOf(ResettableTabContent$lambda$1(mutableIntState)));
                ComposerKt.sourceInformation(composerStartRestartGroup, "323@14915L73,326@15024L76,326@15001L99,329@15113L147");
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 274772952, "CC(remember):MultiTabItemPickerScreenContent.kt#9igjgp");
                Object objRememberedValue2 = composerStartRestartGroup.rememberedValue();
                if (objRememberedValue2 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue2 = new TabViewModelStoreOwner((ComponentActivity) activity);
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue2);
                }
                final TabViewModelStoreOwner tabViewModelStoreOwner = (TabViewModelStoreOwner) objRememberedValue2;
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                Unit unit = Unit.INSTANCE;
                ComposerKt.sourceInformationMarkerStart(composerStartRestartGroup, 274776443, "CC(remember):MultiTabItemPickerScreenContent.kt#9igjgp");
                boolean zChangedInstance = composerStartRestartGroup.changedInstance(tabViewModelStoreOwner);
                Object objRememberedValue3 = composerStartRestartGroup.rememberedValue();
                if (zChangedInstance || objRememberedValue3 == Composer.INSTANCE.getEmpty()) {
                    objRememberedValue3 = new Function1() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerScreenContentKt$$ExternalSyntheticLambda10
                        @Override // kotlin.jvm.functions.Function1
                        public final Object invoke(Object obj) {
                            return MultiTabItemPickerScreenContentKt.ResettableTabContent$lambda$5$0(tabViewModelStoreOwner, (DisposableEffectScope) obj);
                        }
                    };
                    composerStartRestartGroup.updateRememberedValue(objRememberedValue3);
                }
                ComposerKt.sourceInformationMarkerEnd(composerStartRestartGroup);
                EffectsKt.DisposableEffect(unit, (Function1<? super DisposableEffectScope, ? extends DisposableEffectResult>) objRememberedValue3, composerStartRestartGroup, 6);
                CompositionLocalKt.CompositionLocalProvider(LocalViewModelStoreOwner.INSTANCE.provides(tabViewModelStoreOwner), function2, composerStartRestartGroup, (i2 & 112) | ProvidedValue.$stable);
                composerStartRestartGroup.endMovableGroup();
                composerStartRestartGroup.endReplaceGroup();
            } else {
                composerStartRestartGroup.startReplaceGroup(-71610502);
                ComposerKt.sourceInformation(composerStartRestartGroup, "335@15292L9");
                function2.invoke(composerStartRestartGroup, Integer.valueOf((i2 >> 3) & 14));
                composerStartRestartGroup.endReplaceGroup();
            }
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerScreenContentKt$$ExternalSyntheticLambda12
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MultiTabItemPickerScreenContentKt.ResettableTabContent$lambda$6(z, function2, i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final MutableIntState ResettableTabContent$lambda$0$0() {
        return SnapshotIntStateKt.mutableIntStateOf(0);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final int ResettableTabContent$lambda$1(MutableIntState mutableIntState) {
        return mutableIntState.getIntValue();
    }

    public static final void SelectionFloatingBarPreview(Composer composer, final int i) {
        Composer composerStartRestartGroup = composer.startRestartGroup(-1438372978);
        ComposerKt.sourceInformation(composerStartRestartGroup, "C(SelectionFloatingBarPreview)393@16824L94:MultiTabItemPickerScreenContent.kt#aug1cj");
        if (!composerStartRestartGroup.shouldExecute(i != 0, i & 1)) {
            composerStartRestartGroup.skipToGroupEnd();
        } else {
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventStart(-1438372978, i, -1, "com.box.android.contentpicker.multitabitempicker.SelectionFloatingBarPreview (MultiTabItemPickerScreenContent.kt:392)");
            }
            BoxThemeKt.BoxTheme(ComposableSingletons$MultiTabItemPickerScreenContentKt.INSTANCE.m12436getLambda$566965917$content_picker_generalProdRelease(), composerStartRestartGroup, 6);
            if (ComposerKt.isTraceInProgress()) {
                ComposerKt.traceEventEnd();
            }
        }
        ScopeUpdateScope scopeUpdateScopeEndRestartGroup = composerStartRestartGroup.endRestartGroup();
        if (scopeUpdateScopeEndRestartGroup != null) {
            scopeUpdateScopeEndRestartGroup.updateScope(new Function2() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerScreenContentKt$$ExternalSyntheticLambda0
                @Override // kotlin.jvm.functions.Function2
                public final Object invoke(Object obj, Object obj2) {
                    return MultiTabItemPickerScreenContentKt.SelectionFloatingBarPreview$lambda$0(i, (Composer) obj, ((Integer) obj2).intValue());
                }
            });
        }
    }

    private static final ContentPickerReducer.State MultiTabItemPickerScreenContent$lambda$3(State<ContentPickerReducer.State> state) {
        return state.getValue();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static final DisposableEffectResult ResettableTabContent$lambda$5$0(final TabViewModelStoreOwner tabViewModelStoreOwner, DisposableEffectScope DisposableEffect) {
        Intrinsics.checkNotNullParameter(DisposableEffect, "$this$DisposableEffect");
        return new DisposableEffectResult() { // from class: com.box.android.contentpicker.multitabitempicker.MultiTabItemPickerScreenContentKt$ResettableTabContent$lambda$5$0$$inlined$onDispose$1
            @Override // androidx.compose.runtime.DisposableEffectResult
            public void dispose() {
                tabViewModelStoreOwner.clear();
            }
        };
    }
}
